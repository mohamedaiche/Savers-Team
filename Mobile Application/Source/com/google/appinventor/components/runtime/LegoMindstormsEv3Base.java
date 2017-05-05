package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.Ev3BinaryParser;
import java.util.Collections;

@SimpleObject
public class LegoMindstormsEv3Base
  extends AndroidNonvisibleComponent
  implements BluetoothConnectionListener, Component, Deleteable
{
  private static final int TOY_ROBOT = 2052;
  protected BluetoothClient bluetooth;
  protected int commandCount;
  protected final String logTag;
  
  protected LegoMindstormsEv3Base()
  {
    super(null);
    this.logTag = null;
  }
  
  protected LegoMindstormsEv3Base(ComponentContainer paramComponentContainer, String paramString)
  {
    super(paramComponentContainer.$form());
    this.logTag = paramString;
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The BluetoothClient component that should be used for communication.")
  public BluetoothClient BluetoothClient()
  {
    return this.bluetooth;
  }
  
  @DesignerProperty(defaultValue="", editorType="BluetoothClient")
  @SimpleProperty
  public void BluetoothClient(BluetoothClient paramBluetoothClient)
  {
    if (this.bluetooth != null)
    {
      this.bluetooth.removeBluetoothConnectionListener(this);
      this.bluetooth.detachComponent(this);
      this.bluetooth = null;
    }
    if (paramBluetoothClient != null)
    {
      this.bluetooth = paramBluetoothClient;
      this.bluetooth.attachComponent(this, Collections.singleton(Integer.valueOf(2052)));
      this.bluetooth.addBluetoothConnectionListener(this);
      if (this.bluetooth.IsConnected()) {
        afterConnect(this.bluetooth);
      }
    }
  }
  
  public void afterConnect(BluetoothConnectionBase paramBluetoothConnectionBase) {}
  
  public void beforeDisconnect(BluetoothConnectionBase paramBluetoothConnectionBase) {}
  
  protected final String bitFieldToMotorPortLetters(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 15)) {
      throw new IllegalArgumentException("Invalid bit field number " + paramInt);
    }
    Object localObject2 = "";
    if ((paramInt & 0x1) != 0) {
      localObject2 = "" + "A";
    }
    Object localObject1 = localObject2;
    if ((paramInt & 0x2) != 0) {
      localObject1 = (String)localObject2 + "B";
    }
    localObject2 = localObject1;
    if ((paramInt & 0x4) != 0) {
      localObject2 = (String)localObject1 + "C";
    }
    localObject1 = localObject2;
    if ((paramInt & 0x8) != 0) {
      localObject1 = (String)localObject2 + "D";
    }
    return (String)localObject1;
  }
  
  protected final boolean isBluetoothConnected(String paramString)
  {
    if (this.bluetooth == null)
    {
      this.form.dispatchErrorOccurredEvent(this, paramString, 3100, new Object[0]);
      return false;
    }
    if (!this.bluetooth.IsConnected())
    {
      this.form.dispatchErrorOccurredEvent(this, paramString, 3101, new Object[0]);
      return false;
    }
    return true;
  }
  
  protected final int motorPortLettersToBitField(String paramString)
  {
    if (paramString.length() > 4) {
      throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
    }
    int n = 0;
    int m = 0;
    int j = 0;
    int i = 0;
    int k = 0;
    if (k < paramString.length())
    {
      switch (paramString.charAt(k))
      {
      default: 
        throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
      case 'A': 
        if (n != 0) {
          throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
        }
        n = 1;
      }
      for (;;)
      {
        k += 1;
        break;
        if (m != 0) {
          throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
        }
        m = 2;
        continue;
        if (j != 0) {
          throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
        }
        j = 4;
        continue;
        if (i != 0) {
          throw new IllegalArgumentException("Malformed motor port letters \"" + paramString + "\"");
        }
        i = 8;
      }
    }
    return n | m | j | i;
  }
  
  public void onDelete()
  {
    if (this.bluetooth != null)
    {
      this.bluetooth.removeBluetoothConnectionListener(this);
      this.bluetooth.detachComponent(this);
      this.bluetooth = null;
    }
  }
  
  protected final String portNumberToSensorPortLetter(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 3)) {
      throw new IllegalArgumentException(paramInt + " is not a valid port number");
    }
    return "" + (paramInt + 49);
  }
  
  protected final byte[] sendCommand(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!isBluetoothConnected(paramString)) {
      paramArrayOfByte = null;
    }
    byte[] arrayOfByte;
    int i;
    do
    {
      return paramArrayOfByte;
      arrayOfByte = Ev3BinaryParser.pack("hh", new Object[] { Short.valueOf((short)(paramArrayOfByte.length + 2)), Short.valueOf((short)this.commandCount) });
      this.commandCount += 1;
      this.bluetooth.write(paramString, arrayOfByte);
      this.bluetooth.write(paramString, paramArrayOfByte);
      if (!paramBoolean) {
        break label183;
      }
      paramArrayOfByte = this.bluetooth.read(paramString, 4);
      if (paramArrayOfByte.length != 4) {
        break;
      }
      paramArrayOfByte = Ev3BinaryParser.unpack("hh", paramArrayOfByte);
      i = ((Short)paramArrayOfByte[0]).shortValue() - 2;
      ((Short)paramArrayOfByte[1]).shortValue();
      arrayOfByte = this.bluetooth.read(paramString, i);
      paramArrayOfByte = arrayOfByte;
    } while (arrayOfByte.length == i);
    this.form.dispatchErrorOccurredEvent(this, paramString, 3102, new Object[0]);
    return null;
    this.form.dispatchErrorOccurredEvent(this, paramString, 3102, new Object[0]);
    return null;
    label183:
    return null;
  }
  
  protected final int sensorPortLetterToPortNumber(String paramString)
  {
    if (paramString.length() != 1) {
      throw new IllegalArgumentException("String \"" + paramString + "\" is not a valid sensor port letter");
    }
    int i = paramString.charAt(0) - '1';
    if ((i < 0) || (i > 3)) {
      throw new IllegalArgumentException("String \"" + paramString + "\" is not a valid sensor port letter");
    }
    return i;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\LegoMindstormsEv3Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */