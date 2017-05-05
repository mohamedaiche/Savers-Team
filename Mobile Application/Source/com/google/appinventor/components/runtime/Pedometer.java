package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import java.util.List;

@DesignerComponent(category=ComponentCategory.SENSORS, description="A Component that acts like a Pedometer. It senses motion via the Accerleromter and attempts to determine if a step has been taken. Using a configurable stride length, it can estimate the distance traveled as well. ", iconName="images/pedometer.png", nonVisible=true, version=2)
@SimpleObject
public class Pedometer
  extends AndroidNonvisibleComponent
  implements Component, SensorEventListener, Deleteable
{
  private static final int INTERVAL_VARIATION = 250;
  private static final int NUM_INTERVALS = 2;
  private static final float PEAK_VALLEY_RANGE = 40.0F;
  private static final String PREFS_NAME = "PedometerPrefs";
  private static final float STRIDE_LENGTH = 0.73F;
  private static final String TAG = "Pedometer";
  private static final int WIN_SIZE = 100;
  private int avgPos = 0;
  private float[] avgWindow = new float[10];
  private final Context context;
  private boolean foundNonStep = true;
  private boolean foundValley = false;
  private int intervalPos = 0;
  private float lastValley = 0.0F;
  private float[] lastValues = new float[100];
  private int numStepsRaw = 0;
  private int numStepsWithFilter = 0;
  private boolean pedometerPaused = true;
  private long prevStopClockTime = 0L;
  private final SensorManager sensorManager;
  private boolean startPeaking = false;
  private long startTime = 0L;
  private long[] stepInterval = new long[2];
  private long stepTimestamp = 0L;
  private int stopDetectionTimeout = 2000;
  private float strideLength = 0.73F;
  private float totalDistance = 0.0F;
  private int winPos = 0;
  
  public Pedometer(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.context = paramComponentContainer.$context();
    this.winPos = 0;
    this.startPeaking = false;
    this.numStepsWithFilter = 0;
    this.numStepsRaw = 0;
    this.foundValley = true;
    this.lastValley = 0.0F;
    this.sensorManager = ((SensorManager)this.context.getSystemService("sensor"));
    paramComponentContainer = this.context.getSharedPreferences("PedometerPrefs", 0);
    this.strideLength = paramComponentContainer.getFloat("Pedometer.stridelength", 0.73F);
    this.totalDistance = paramComponentContainer.getFloat("Pedometer.distance", 0.0F);
    this.numStepsRaw = paramComponentContainer.getInt("Pedometer.prevStepCount", 0);
    this.prevStopClockTime = paramComponentContainer.getLong("Pedometer.clockTime", 0L);
    this.numStepsWithFilter = this.numStepsRaw;
    this.startTime = System.currentTimeMillis();
    Log.d("Pedometer", "Pedometer Created");
  }
  
  private boolean areStepsEquallySpaced()
  {
    float f1 = 0.0F;
    int j = 0;
    long[] arrayOfLong = this.stepInterval;
    int m = arrayOfLong.length;
    int i = 0;
    while (i < m)
    {
      long l = arrayOfLong[i];
      float f2 = f1;
      int k = j;
      if (l > 0L)
      {
        k = j + 1;
        f2 = f1 + (float)l;
      }
      i += 1;
      f1 = f2;
      j = k;
    }
    f1 /= j;
    arrayOfLong = this.stepInterval;
    j = arrayOfLong.length;
    i = 0;
    while (i < j)
    {
      if (Math.abs((float)arrayOfLong[i] - f1) > 250.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isPeak()
  {
    int j = (this.winPos + 50) % 100;
    int i = 0;
    while (i < 100)
    {
      if ((i != j) && (this.lastValues[i] > this.lastValues[j])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isValley()
  {
    int j = (this.winPos + 50) % 100;
    int i = 0;
    while (i < 100)
    {
      if ((i != j) && (this.lastValues[i] < this.lastValues[j])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  @Deprecated
  public void CalibrateStrideLength(boolean paramBoolean) {}
  
  @SimpleProperty
  @Deprecated
  public boolean CalibrateStrideLength()
  {
    return false;
  }
  
  @SimpleEvent
  @Deprecated
  public void CalibrationFailed() {}
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The approximate distance traveled in meters.")
  public float Distance()
  {
    return this.totalDistance;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Time elapsed in milliseconds since the pedometer was started.")
  public long ElapsedTime()
  {
    if (this.pedometerPaused) {
      return this.prevStopClockTime;
    }
    return this.prevStopClockTime + (System.currentTimeMillis() - this.startTime);
  }
  
  @SimpleEvent
  @Deprecated
  public void GPSAvailable() {}
  
  @SimpleEvent
  @Deprecated
  public void GPSLost() {}
  
  @SimpleProperty
  @Deprecated
  public boolean Moving()
  {
    return false;
  }
  
  @SimpleFunction(description="Pause counting of steps and distance.")
  public void Pause()
  {
    if (!this.pedometerPaused)
    {
      this.pedometerPaused = true;
      this.sensorManager.unregisterListener(this);
      Log.d("Pedometer", "Unregistered listener on pause");
      this.prevStopClockTime += System.currentTimeMillis() - this.startTime;
    }
  }
  
  @SimpleFunction(description="Resets the step counter, distance measure and time running.")
  public void Reset()
  {
    this.numStepsWithFilter = 0;
    this.numStepsRaw = 0;
    this.totalDistance = 0.0F;
    this.prevStopClockTime = 0L;
    this.startTime = System.currentTimeMillis();
  }
  
  @SimpleFunction(description="Resumes counting, synonym of Start.")
  public void Resume()
  {
    Start();
  }
  
  @SimpleFunction(description="Saves the pedometer state to the phone. Permits permits accumulation of steps and distance between invocations of an App that uses the pedometer. Different Apps will have their own saved state.")
  public void Save()
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("PedometerPrefs", 0).edit();
    localEditor.putFloat("Pedometer.stridelength", this.strideLength);
    localEditor.putFloat("Pedometer.distance", this.totalDistance);
    localEditor.putInt("Pedometer.prevStepCount", this.numStepsRaw);
    if (this.pedometerPaused) {
      localEditor.putLong("Pedometer.clockTime", this.prevStopClockTime);
    }
    for (;;)
    {
      localEditor.putLong("Pedometer.closeTime", System.currentTimeMillis());
      localEditor.commit();
      Log.d("Pedometer", "Pedometer state saved.");
      return;
      localEditor.putLong("Pedometer.clockTime", this.prevStopClockTime + (System.currentTimeMillis() - this.startTime));
    }
  }
  
  @SimpleEvent(description="This event is run when a raw step is detected")
  public void SimpleStep(int paramInt, float paramFloat)
  {
    EventDispatcher.dispatchEvent(this, "SimpleStep", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat) });
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The number of simple steps taken since the pedometer has started.")
  public int SimpleSteps()
  {
    return this.numStepsRaw;
  }
  
  @SimpleFunction(description="Start counting steps")
  public void Start()
  {
    if (this.pedometerPaused)
    {
      this.pedometerPaused = false;
      this.sensorManager.registerListener(this, (Sensor)this.sensorManager.getSensorList(1).get(0), 0);
      this.startTime = System.currentTimeMillis();
    }
  }
  
  @SimpleEvent
  @Deprecated
  public void StartedMoving() {}
  
  @SimpleFunction(description="Stop counting steps")
  public void Stop()
  {
    Pause();
  }
  
  @SimpleProperty
  public int StopDetectionTimeout()
  {
    return this.stopDetectionTimeout;
  }
  
  @DesignerProperty(defaultValue="2000", editorType="non_negative_integer")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The duration in milliseconds of idleness (no steps detected) after which to go into a \"stopped\" state")
  public void StopDetectionTimeout(int paramInt)
  {
    this.stopDetectionTimeout = paramInt;
  }
  
  @SimpleEvent
  @Deprecated
  public void StoppedMoving() {}
  
  @SimpleProperty
  public float StrideLength()
  {
    return this.strideLength;
  }
  
  @DesignerProperty(defaultValue="0.73", editorType="non_negative_float")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Set the average stride length in meters.")
  public void StrideLength(float paramFloat)
  {
    this.strideLength = paramFloat;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  @Deprecated
  public void UseGPS(boolean paramBoolean) {}
  
  @SimpleEvent(description="This event is run when a walking step is detected. A walking step is a step that appears to be involved in forward motion.")
  public void WalkStep(int paramInt, float paramFloat)
  {
    EventDispatcher.dispatchEvent(this, "WalkStep", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat) });
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="the number of walk steps taken since the pedometer has started.")
  public int WalkSteps()
  {
    return this.numStepsWithFilter;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    Log.d("Pedometer", "Accelerometer accuracy changed.");
  }
  
  public void onDelete()
  {
    this.sensorManager.unregisterListener(this);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    float f1 = 0.0F;
    int j = paramSensorEvent.length;
    int i = 0;
    while (i < j)
    {
      float f2 = paramSensorEvent[i];
      f1 += f2 * f2;
      i += 1;
    }
    i = (this.winPos + 50) % 100;
    long l;
    if ((this.startPeaking) && (isPeak()) && (this.foundValley) && (this.lastValues[i] - this.lastValley > 40.0F))
    {
      l = System.currentTimeMillis();
      this.stepInterval[this.intervalPos] = (l - this.stepTimestamp);
      this.intervalPos = ((this.intervalPos + 1) % 2);
      this.stepTimestamp = l;
      if (!areStepsEquallySpaced()) {
        break label372;
      }
      if (this.foundNonStep)
      {
        this.numStepsWithFilter += 2;
        this.totalDistance += this.strideLength * 2.0F;
        this.foundNonStep = false;
      }
      this.numStepsWithFilter += 1;
      WalkStep(this.numStepsWithFilter, this.totalDistance);
      this.totalDistance += this.strideLength;
    }
    for (;;)
    {
      this.numStepsRaw += 1;
      SimpleStep(this.numStepsRaw, this.totalDistance);
      this.foundValley = false;
      if ((this.startPeaking) && (isValley()))
      {
        this.foundValley = true;
        this.lastValley = this.lastValues[i];
      }
      this.avgWindow[this.avgPos] = f1;
      this.avgPos = ((this.avgPos + 1) % this.avgWindow.length);
      this.lastValues[this.winPos] = 0.0F;
      paramSensorEvent = this.avgWindow;
      j = paramSensorEvent.length;
      i = 0;
      while (i < j)
      {
        f1 = paramSensorEvent[i];
        float[] arrayOfFloat = this.lastValues;
        int k = this.winPos;
        arrayOfFloat[k] += f1;
        i += 1;
      }
      label372:
      this.foundNonStep = true;
    }
    paramSensorEvent = this.lastValues;
    i = this.winPos;
    paramSensorEvent[i] /= this.avgWindow.length;
    if ((this.startPeaking) || (this.winPos > 1))
    {
      j = this.winPos - 1;
      i = j;
      if (j < 0) {
        i = j + 100;
      }
      paramSensorEvent = this.lastValues;
      j = this.winPos;
      paramSensorEvent[j] += 2.0F * this.lastValues[i];
      j = i - 1;
      i = j;
      if (j < 0) {
        i = j + 100;
      }
      paramSensorEvent = this.lastValues;
      j = this.winPos;
      paramSensorEvent[j] += this.lastValues[i];
      paramSensorEvent = this.lastValues;
      i = this.winPos;
      paramSensorEvent[i] /= 4.0F;
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      if (l - this.stepTimestamp > this.stopDetectionTimeout) {
        this.stepTimestamp = l;
      }
      if ((this.winPos == 99) && (!this.startPeaking)) {
        this.startPeaking = true;
      }
      this.winPos = ((this.winPos + 1) % 100);
      return;
      if ((!this.startPeaking) && (this.winPos == 1)) {
        this.lastValues[1] = ((this.lastValues[1] + this.lastValues[0]) / 2.0F);
      }
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\Pedometer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */