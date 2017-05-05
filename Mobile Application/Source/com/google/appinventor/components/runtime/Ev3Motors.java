package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.Ev3BinaryParser;

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides both high- and low-level interfaces to a LEGO MINDSTORMS EV3 robot, with functions that can control the motors.", iconName="images/legoMindstormsEv3.png", nonVisible=true, version=1)
@SimpleObject
public class Ev3Motors
  extends LegoMindstormsEv3Base
{
  private static final String DEFAULT_MOTOR_PORTS = "ABC";
  private static final double DEFAULT_WHEEL_DIAMETER = 4.32D;
  private static final int DELAY_MILLISECONDS = 50;
  private boolean directionReversed = false;
  private Handler eventHandler = new Handler();
  private boolean ifReset = false;
  private int motorPortBitField = 1;
  private int previousValue = 0;
  private boolean regulationEnabled = true;
  private final Runnable sensorValueChecker = new Runnable()
  {
    public void run()
    {
      int i;
      if ((Ev3Motors.this.bluetooth != null) && (Ev3Motors.this.bluetooth.IsConnected()))
      {
        i = Ev3Motors.this.getOutputCount("", 0, Ev3Motors.this.motorPortBitField);
        if (Ev3Motors.this.ifReset) {
          break label105;
        }
        if ((i != Ev3Motors.this.previousValue) && (Ev3Motors.this.tachoCountChangedEventEnabled)) {
          Ev3Motors.this.TachoCountChanged(i);
        }
      }
      for (;;)
      {
        Ev3Motors.access$302(Ev3Motors.this, i);
        Ev3Motors.this.eventHandler.postDelayed(this, 50L);
        return;
        label105:
        Ev3Motors.access$202(Ev3Motors.this, false);
      }
    }
  };
  private boolean stopBeforeDisconnect = true;
  private boolean tachoCountChangedEventEnabled = false;
  private double wheelDiameter = 4.32D;
  
  public Ev3Motors(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "Ev3Motors");
    this.eventHandler.post(this.sensorValueChecker);
    MotorPorts("ABC");
    StopBeforeDisconnect(true);
    EnableSpeedRegulation(true);
    ReverseDirection(false);
    WheelDiameter(4.32D);
    TachoCountChangedEventEnabled(false);
  }
  
  private void clearOutputCount(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-78, false, 0, 0, "cc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2) }), false);
  }
  
  private int getOutputCount(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    switch ((paramInt2 - 1 ^ paramInt2) + 1 >>> 1)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException();
    case 1: 
      paramInt2 = 0;
    }
    for (;;)
    {
      paramString = sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-77, true, 4, 0, "ccg", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2), Byte.valueOf(0) }), true);
      paramInt1 = i;
      if (paramString != null)
      {
        paramInt1 = i;
        if (paramString.length == 5)
        {
          paramInt1 = i;
          if (paramString[0] == 2) {
            paramInt1 = ((Integer)Ev3BinaryParser.unpack("xi", paramString)[0]).intValue();
          }
        }
      }
      return paramInt1;
      paramInt2 = 1;
      continue;
      paramInt2 = 2;
      continue;
      paramInt2 = 3;
    }
  }
  
  private boolean isOneShotInteger(int paramInt)
  {
    return (paramInt != 0) && (((paramInt - 1 ^ paramInt ^ 0xFFFFFFFF) & paramInt) == 0);
  }
  
  private void outputStepPower(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt6 < 0)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-84, false, 0, 0, "ccccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void outputStepSpeed(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt6 < 0)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-82, false, 0, 0, "ccccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void outputStepSync(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt4 < 65336) || (paramInt4 > 200)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    short s = (short)paramInt4;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-80, false, 0, 0, "cccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Short.valueOf(s), Integer.valueOf(paramInt5), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void outputTimePower(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt6 < 0)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-83, false, 0, 0, "ccccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void outputTimeSpeed(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt4 < 0) || (paramInt5 < 0) || (paramInt6 < 0)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-81, false, 0, 0, "ccccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void outputTimeSync(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt5 < 0)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    byte b1 = (byte)paramInt1;
    byte b2 = (byte)paramInt2;
    byte b3 = (byte)paramInt3;
    short s = (short)paramInt4;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-79, false, 0, 0, "cccccc", new Object[] { Byte.valueOf(b1), Byte.valueOf(b2), Byte.valueOf(b3), Short.valueOf(s), Integer.valueOf(paramInt5), Byte.valueOf((byte)paramInt1) }), false);
      return;
    }
  }
  
  private void resetOutput(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    this.ifReset = true;
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-94, false, 0, 0, "cc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2) }), false);
  }
  
  private int roundValue(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private void setOutputDirection(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15) || (paramInt3 < -1) || (paramInt3 > 1)) {
      throw new IllegalArgumentException();
    }
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-89, false, 0, 0, "ccc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2), Byte.valueOf((byte)paramInt3) }), false);
  }
  
  private void setOutputPower(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-92, false, 0, 0, "ccc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2), Byte.valueOf((byte)paramInt3) }), false);
  }
  
  private void setOutputSpeed(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    paramInt3 = roundValue(paramInt3, -100, 100);
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-91, false, 0, 0, "ccc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2), Byte.valueOf((byte)paramInt3) }), false);
  }
  
  private void startOutput(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-90, false, 0, 0, "cc", new Object[] { Byte.valueOf((byte)paramInt1), Byte.valueOf((byte)paramInt2) }), false);
  }
  
  private void stopOutput(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte b1 = 1;
    if ((paramInt1 < 0) || (paramInt1 > 3) || (paramInt2 < 0) || (paramInt2 > 15)) {
      throw new IllegalArgumentException();
    }
    byte b2 = (byte)paramInt1;
    byte b3 = (byte)paramInt2;
    if (paramBoolean) {}
    for (;;)
    {
      sendCommand(paramString, Ev3BinaryParser.encodeDirectCommand((byte)-93, false, 0, 0, "ccc", new Object[] { Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b1) }), false);
      return;
      b1 = 0;
    }
  }
  
  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void EnableSpeedRegulation(boolean paramBoolean)
  {
    this.regulationEnabled = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The robot adjusts the power to maintain the speed if speed regulation is enabled.")
  public boolean EnableSpeedRegulation()
  {
    return this.regulationEnabled;
  }
  
  @SimpleFunction(description="Get the current tacho count.")
  public int GetTachoCount()
  {
    try
    {
      int i = getOutputCount("GetTachoCount", 0, this.motorPortBitField);
      return i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetTachoCount", 3103, new Object[] { "GetTachoCount" });
    }
    return 0;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The motor ports that the motors are connected to. The ports are specified by a sequence of port letters.", userVisible=false)
  public String MotorPorts()
  {
    return bitFieldToMotorPortLetters(this.motorPortBitField);
  }
  
  @DesignerProperty(defaultValue="ABC", editorType="string")
  @SimpleProperty
  public void MotorPorts(String paramString)
  {
    try
    {
      this.motorPortBitField = motorPortLettersToBitField(paramString);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "MotorPorts", 3104, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Set the current tacho count to zero.")
  public void ResetTachoCount()
  {
    try
    {
      clearOutputCount("ResetTachoCount", 0, this.motorPortBitField);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ResetTachoCount", 3103, new Object[] { "ResetTachoCount" });
    }
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void ReverseDirection(boolean paramBoolean)
  {
    try
    {
      int j = this.motorPortBitField;
      if (paramBoolean) {}
      for (int i = -1;; i = 1)
      {
        setOutputDirection("ReverseDirection", 0, j, i);
        this.directionReversed = paramBoolean;
        return;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ReverseDirection", 3103, new Object[] { "ReverseDirection" });
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="It specifies if the direction of the motors is reversed.")
  public boolean ReverseDirection()
  {
    return this.directionReversed;
  }
  
  @SimpleFunction(description="Rotate the motors in a distance.")
  public void RotateInDistance(int paramInt, double paramDouble, boolean paramBoolean)
  {
    int i = (int)(360.0D * paramDouble / this.wheelDiameter / 3.141592653589793D);
    try
    {
      if (this.regulationEnabled)
      {
        outputStepSpeed("RotateInDistance", 0, this.motorPortBitField, paramInt, 0, i, 0, paramBoolean);
        return;
      }
      outputStepPower("RotateInDistance", 0, this.motorPortBitField, paramInt, 0, i, 0, paramBoolean);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateInDistance", 3103, new Object[] { "RotateInDistance" });
    }
  }
  
  @SimpleFunction(description="Rotate the motors in a period of time.")
  public void RotateInDuration(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.regulationEnabled)
      {
        outputTimeSpeed("RotateInDuration", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
        return;
      }
      outputTimePower("RotateInDuration", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateInDuration", 3103, new Object[] { "RotateInDuration" });
    }
  }
  
  @SimpleFunction(description="Rotate the motors in a number of tacho counts.")
  public void RotateInTachoCounts(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.regulationEnabled)
      {
        outputStepSpeed("RotateInTachoCounts", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
        return;
      }
      outputStepPower("RotateInTachoCounts", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateInTachoCounts", 3103, new Object[] { "RotateInTachoCounts" });
    }
  }
  
  @SimpleFunction(description="Start to rotate the motors.")
  public void RotateIndefinitely(int paramInt)
  {
    try
    {
      if (this.regulationEnabled) {
        setOutputPower("RotateIndefinitely", 0, this.motorPortBitField, paramInt);
      }
      for (;;)
      {
        startOutput("RotateIndefinitely", 0, this.motorPortBitField);
        return;
        setOutputSpeed("RotateIndefinitely", 0, this.motorPortBitField, paramInt);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateIndefinitely", 3103, new Object[] { "RotateIndefinitely" });
    }
  }
  
  @SimpleFunction(description="Rotate the motors at the same speed for a distance in cm.")
  public void RotateSyncInDistance(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt2 = (int)(paramInt2 * 360.0D / this.wheelDiameter / 3.141592653589793D);
    try
    {
      if (this.motorPortBitField != 0)
      {
        if (isOneShotInteger(this.motorPortBitField))
        {
          outputStepSpeed("RotateSyncInDuration", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
          return;
        }
        outputStepSync("RotateSyncInDuration", 0, this.motorPortBitField, paramInt1, paramInt3, paramInt2, paramBoolean);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateSyncInDuration", 3103, new Object[] { "RotateSyncInDuration" });
    }
  }
  
  @SimpleFunction(description="Rotate the motors at the same speed in a period of time.")
  public void RotateSyncInDuration(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      if (this.motorPortBitField != 0)
      {
        if (isOneShotInteger(this.motorPortBitField))
        {
          outputTimeSpeed("RotateSyncInDuration", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
          return;
        }
        outputTimeSync("RotateSyncInDuration", 0, this.motorPortBitField, paramInt1, paramInt3, paramInt2, paramBoolean);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateSyncInDuration", 3103, new Object[] { "RotateSyncInDuration" });
    }
  }
  
  @SimpleFunction(description="Rotate the motors at the same speed in a number of tacho counts.")
  public void RotateSyncInTachoCounts(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      if (this.motorPortBitField != 0)
      {
        if (isOneShotInteger(this.motorPortBitField))
        {
          outputStepSpeed("RotateSyncInTachoCounts", 0, this.motorPortBitField, paramInt1, 0, paramInt2, 0, paramBoolean);
          return;
        }
        outputStepSync("RotateSyncInTachoCounts", 0, this.motorPortBitField, paramInt1, paramInt3, paramInt2, paramBoolean);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateSyncInTachoCounts", 3103, new Object[] { "RotateSyncInTachoCounts" });
    }
  }
  
  @SimpleFunction(description="Start to rotate the motors at the same speed.")
  public void RotateSyncIndefinitely(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.motorPortBitField != 0)
      {
        if (isOneShotInteger(this.motorPortBitField))
        {
          setOutputSpeed("RotateSyncIndefinitely", 0, this.motorPortBitField, paramInt1);
          return;
        }
        outputStepSync("RotateSyncIndefinitely", 0, this.motorPortBitField, paramInt1, paramInt2, 0, true);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "RotateSyncIndefinitely", 3103, new Object[] { "RotateSyncIndefinitely" });
    }
  }
  
  @SimpleFunction(description="Stop the motors of the robot.")
  public void Stop(boolean paramBoolean)
  {
    try
    {
      stopOutput("Stop", 0, this.motorPortBitField, paramBoolean);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "Stop", 3103, new Object[] { "Stop" });
    }
  }
  
  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void StopBeforeDisconnect(boolean paramBoolean)
  {
    this.stopBeforeDisconnect = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether to stop the motor before disconnecting.")
  public boolean StopBeforeDisconnect()
  {
    return this.stopBeforeDisconnect;
  }
  
  @SimpleEvent(description="Called when the tacho count has changed.")
  public void TachoCountChanged(int paramInt)
  {
    EventDispatcher.dispatchEvent(this, "TachoCountChanged", new Object[] { Integer.valueOf(paramInt) });
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void TachoCountChangedEventEnabled(boolean paramBoolean)
  {
    this.tachoCountChangedEventEnabled = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the TachoCountChanged event should fire when the angle is changed.")
  public boolean TachoCountChangedEventEnabled()
  {
    return this.tachoCountChangedEventEnabled;
  }
  
  @SimpleFunction(description="Toggle the direction of motors.")
  public void ToggleDirection()
  {
    try
    {
      setOutputDirection("ToggleDirection", 0, this.motorPortBitField, 0);
      if (!this.directionReversed) {}
      for (boolean bool = true;; bool = false)
      {
        this.directionReversed = bool;
        return;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ToggleDirection", 3103, new Object[] { "ToggleDirection" });
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The diameter of the wheels attached on the motors in centimeters.", userVisible=false)
  public double WheelDiameter()
  {
    return this.wheelDiameter;
  }
  
  @DesignerProperty(defaultValue="4.32", editorType="float")
  @SimpleProperty
  public void WheelDiameter(double paramDouble)
  {
    this.wheelDiameter = paramDouble;
  }
  
  public void beforeDisconnect(BluetoothConnectionBase paramBluetoothConnectionBase)
  {
    if (this.stopBeforeDisconnect) {}
    try
    {
      stopOutput("beforeDisconnect", 0, this.motorPortBitField, true);
      return;
    }
    catch (IllegalArgumentException paramBluetoothConnectionBase)
    {
      this.form.dispatchErrorOccurredEvent(this, "beforeDisconnect", 3103, new Object[] { "beforeDisconnect" });
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\Ev3Motors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */