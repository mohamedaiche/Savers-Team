package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DesignerComponent(category=ComponentCategory.LEGOMINDSTORMS, description="A component that provides a low-level interface to a LEGO MINDSTORMS NXT robot, with functions to send NXT Direct Commands.", iconName="images/legoMindstormsNxt.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.WRITE_EXTERNAL_STORAGE,android.permission.READ_EXTERNAL_STORAGE")
public class NxtDirectCommands
  extends LegoMindstormsNxtBase
{
  public NxtDirectCommands(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, "NxtDirectCommands");
  }
  
  private void closeHandle(String paramString, int paramInt)
  {
    byte[] arrayOfByte = new byte[3];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -124;
    copyUBYTEValueToBytes(paramInt, arrayOfByte, 2);
    evaluateStatus(paramString, sendCommandAndReceiveReturnPackage(paramString, arrayOfByte), arrayOfByte[1]);
  }
  
  private byte[] getOutputState(String paramString, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[3];
    arrayOfByte1[0] = 0;
    arrayOfByte1[1] = 6;
    copyUBYTEValueToBytes(paramInt, arrayOfByte1, 2);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage(paramString, arrayOfByte1);
    if (evaluateStatus(paramString, arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 25) {
        return arrayOfByte2;
      }
      Log.w(this.logTag, paramString + ": unexpected return package length " + arrayOfByte2.length + " (expected 25)");
    }
    return null;
  }
  
  private Integer openWrite(String paramString1, String paramString2, long paramLong)
  {
    byte[] arrayOfByte = new byte[26];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -127;
    copyStringValueToBytes(paramString2, arrayOfByte, 2, 19);
    copyULONGValueToBytes(paramLong, arrayOfByte, 22);
    paramString2 = sendCommandAndReceiveReturnPackage(paramString1, arrayOfByte);
    if (evaluateStatus(paramString1, paramString2, arrayOfByte[1]))
    {
      if (paramString2.length == 4) {
        return Integer.valueOf(getUBYTEValueFromBytes(paramString2, 3));
      }
      Log.w(this.logTag, paramString1 + ": unexpected return package length " + paramString2.length + " (expected 4)");
    }
    return null;
  }
  
  private Integer openWriteLinear(String paramString1, String paramString2, long paramLong)
  {
    byte[] arrayOfByte = new byte[26];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -119;
    copyStringValueToBytes(paramString2, arrayOfByte, 2, 19);
    copyULONGValueToBytes(paramLong, arrayOfByte, 22);
    paramString2 = sendCommandAndReceiveReturnPackage(paramString1, arrayOfByte);
    if (evaluateStatus(paramString1, paramString2, arrayOfByte[1]))
    {
      if (paramString2.length == 4) {
        return Integer.valueOf(getUBYTEValueFromBytes(paramString2, 3));
      }
      Log.w(this.logTag, paramString1 + ": unexpected return package length " + paramString2.length + " (expected 4)");
    }
    return null;
  }
  
  private int writeChunk(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws IOException
  {
    int i = 0;
    if (paramInt2 > 32) {
      throw new IllegalArgumentException("length must be <= 32");
    }
    byte[] arrayOfByte = new byte[paramInt2 + 3];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -125;
    copyUBYTEValueToBytes(paramInt1, arrayOfByte, 2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 3, paramInt2);
    paramArrayOfByte = sendCommandAndReceiveReturnPackage(paramString, arrayOfByte);
    paramInt1 = i;
    if (evaluateStatus(paramString, paramArrayOfByte, arrayOfByte[1])) {
      if (paramArrayOfByte.length == 6)
      {
        i = getUWORDValueFromBytes(paramArrayOfByte, 4);
        paramInt1 = i;
        if (i != paramInt2)
        {
          Log.e(this.logTag, paramString + ": only " + i + " bytes were written " + "(expected " + paramInt2 + ")");
          throw new IOException("Unable to write file on robot");
        }
      }
      else
      {
        Log.w(this.logTag, paramString + ": unexpected return package length " + paramArrayOfByte.length + " (expected 6)");
        paramInt1 = i;
      }
    }
    return paramInt1;
  }
  
  @SimpleFunction(description="Delete a file on the robot.")
  public void DeleteFile(String paramString)
  {
    if (!checkBluetooth("DeleteFile")) {
      return;
    }
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "DeleteFile", 406, new Object[0]);
      return;
    }
    byte[] arrayOfByte = new byte[22];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -123;
    copyStringValueToBytes(paramString, arrayOfByte, 2, 19);
    evaluateStatus("DeleteFile", sendCommandAndReceiveReturnPackage("DeleteFile", arrayOfByte), arrayOfByte[1]);
  }
  
  /* Error */
  @SimpleFunction(description="Download a file to the robot.")
  public void DownloadFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -92
    //   3: invokevirtual 141	com/google/appinventor/components/runtime/NxtDirectCommands:checkBluetooth	(Ljava/lang/String;)Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: invokevirtual 147	java/lang/String:length	()I
    //   14: ifne +21 -> 35
    //   17: aload_0
    //   18: getfield 151	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   21: aload_0
    //   22: ldc -92
    //   24: sipush 414
    //   27: iconst_0
    //   28: anewarray 153	java/lang/Object
    //   31: invokevirtual 159	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   34: return
    //   35: aload_2
    //   36: invokevirtual 147	java/lang/String:length	()I
    //   39: ifne +21 -> 60
    //   42: aload_0
    //   43: getfield 151	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   46: aload_0
    //   47: ldc -92
    //   49: sipush 415
    //   52: iconst_0
    //   53: anewarray 153	java/lang/Object
    //   56: invokevirtual 159	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   59: return
    //   60: aload_0
    //   61: getfield 151	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   64: aload_1
    //   65: invokestatic 170	com/google/appinventor/components/runtime/util/MediaUtil:copyMediaToTempFile	(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)Ljava/io/File;
    //   68: astore 8
    //   70: new 172	java/io/BufferedInputStream
    //   73: dup
    //   74: new 174	java/io/FileInputStream
    //   77: dup
    //   78: aload 8
    //   80: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: sipush 1024
    //   86: invokespecial 180	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   89: astore 9
    //   91: aload 8
    //   93: invokevirtual 185	java/io/File:length	()J
    //   96: lstore 6
    //   98: aload_2
    //   99: ldc -69
    //   101: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   104: ifne +12 -> 116
    //   107: aload_2
    //   108: ldc -64
    //   110: invokevirtual 190	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   113: ifeq +55 -> 168
    //   116: aload_0
    //   117: ldc -92
    //   119: aload_2
    //   120: lload 6
    //   122: invokespecial 194	com/google/appinventor/components/runtime/NxtDirectCommands:openWriteLinear	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/Integer;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnonnull +54 -> 181
    //   130: aload 9
    //   132: invokevirtual 199	java/io/InputStream:close	()V
    //   135: aload 8
    //   137: invokevirtual 203	java/io/File:delete	()Z
    //   140: pop
    //   141: return
    //   142: astore_1
    //   143: aload_0
    //   144: getfield 151	com/google/appinventor/components/runtime/NxtDirectCommands:form	Lcom/google/appinventor/components/runtime/Form;
    //   147: aload_0
    //   148: ldc -92
    //   150: sipush 416
    //   153: iconst_1
    //   154: anewarray 153	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 206	java/io/IOException:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 159	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   167: return
    //   168: aload_0
    //   169: ldc -92
    //   171: aload_2
    //   172: lload 6
    //   174: invokespecial 208	com/google/appinventor/components/runtime/NxtDirectCommands:openWrite	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/Integer;
    //   177: astore_1
    //   178: goto -52 -> 126
    //   181: bipush 32
    //   183: newarray <illegal type>
    //   185: astore_2
    //   186: lconst_0
    //   187: lstore 4
    //   189: lload 4
    //   191: lload 6
    //   193: lcmp
    //   194: ifge +48 -> 242
    //   197: ldc2_w 209
    //   200: lload 6
    //   202: lload 4
    //   204: lsub
    //   205: invokestatic 216	java/lang/Math:min	(JJ)J
    //   208: l2i
    //   209: istore_3
    //   210: aload 9
    //   212: aload_2
    //   213: iconst_0
    //   214: iload_3
    //   215: invokevirtual 220	java/io/InputStream:read	([BII)I
    //   218: pop
    //   219: aload_0
    //   220: ldc -92
    //   222: aload_1
    //   223: invokevirtual 223	java/lang/Integer:intValue	()I
    //   226: aload_2
    //   227: iload_3
    //   228: invokespecial 225	com/google/appinventor/components/runtime/NxtDirectCommands:writeChunk	(Ljava/lang/String;I[BI)I
    //   231: istore_3
    //   232: lload 4
    //   234: iload_3
    //   235: i2l
    //   236: ladd
    //   237: lstore 4
    //   239: goto -50 -> 189
    //   242: aload_0
    //   243: ldc -92
    //   245: aload_1
    //   246: invokevirtual 223	java/lang/Integer:intValue	()I
    //   249: invokespecial 227	com/google/appinventor/components/runtime/NxtDirectCommands:closeHandle	(Ljava/lang/String;I)V
    //   252: aload 9
    //   254: invokevirtual 199	java/io/InputStream:close	()V
    //   257: aload 8
    //   259: invokevirtual 203	java/io/File:delete	()Z
    //   262: pop
    //   263: return
    //   264: astore_2
    //   265: aload_0
    //   266: ldc -92
    //   268: aload_1
    //   269: invokevirtual 223	java/lang/Integer:intValue	()I
    //   272: invokespecial 227	com/google/appinventor/components/runtime/NxtDirectCommands:closeHandle	(Ljava/lang/String;I)V
    //   275: aload_2
    //   276: athrow
    //   277: astore_1
    //   278: aload 9
    //   280: invokevirtual 199	java/io/InputStream:close	()V
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload 8
    //   288: invokevirtual 203	java/io/File:delete	()Z
    //   291: pop
    //   292: aload_1
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	NxtDirectCommands
    //   0	294	1	paramString1	String
    //   0	294	2	paramString2	String
    //   209	26	3	i	int
    //   187	51	4	l1	long
    //   96	105	6	l2	long
    //   68	219	8	localFile	java.io.File
    //   89	190	9	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   60	70	142	java/io/IOException
    //   135	141	142	java/io/IOException
    //   257	263	142	java/io/IOException
    //   286	294	142	java/io/IOException
    //   181	186	264	finally
    //   197	232	264	finally
    //   91	116	277	finally
    //   116	126	277	finally
    //   168	178	277	finally
    //   242	252	277	finally
    //   265	277	277	finally
    //   70	91	285	finally
    //   130	135	285	finally
    //   252	257	285	finally
    //   278	285	285	finally
  }
  
  @SimpleFunction(description="Get the battery level for the robot. Returns the voltage in millivolts.")
  public int GetBatteryLevel()
  {
    if (!checkBluetooth("GetBatteryLevel")) {}
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    do
    {
      return 0;
      arrayOfByte1 = new byte[2];
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = 11;
      arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetBatteryLevel", arrayOfByte1);
    } while (!evaluateStatus("GetBatteryLevel", arrayOfByte2, arrayOfByte1[1]));
    if (arrayOfByte2.length == 5) {
      return getUWORDValueFromBytes(arrayOfByte2, 3);
    }
    Log.w(this.logTag, "GetBatteryLevel: unexpected return package length " + arrayOfByte2.length + " (expected 5)");
    return 0;
  }
  
  @SimpleFunction(description="Get the brick name of the robot.")
  public String GetBrickName()
  {
    if (!checkBluetooth("GetBrickName")) {
      return "";
    }
    byte[] arrayOfByte1 = new byte[2];
    arrayOfByte1[0] = 1;
    arrayOfByte1[1] = -101;
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetBrickName", arrayOfByte1);
    if (evaluateStatus("GetBrickName", arrayOfByte2, arrayOfByte1[1])) {
      return getStringValueFromBytes(arrayOfByte2, 3);
    }
    return "";
  }
  
  @SimpleFunction(description="Get the name of currently running program on the robot.")
  public String GetCurrentProgramName()
  {
    if (!checkBluetooth("GetCurrentProgramName")) {
      return "";
    }
    byte[] arrayOfByte1 = new byte[2];
    arrayOfByte1[0] = 0;
    arrayOfByte1[1] = 17;
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("GetCurrentProgramName", arrayOfByte1);
    int i = getStatus("GetCurrentProgramName", arrayOfByte2, arrayOfByte1[1]);
    if (i == 0) {
      return getStringValueFromBytes(arrayOfByte2, 3);
    }
    if (i == 236) {
      return "";
    }
    evaluateStatus("GetCurrentProgramName", arrayOfByte2, arrayOfByte1[1]);
    return "";
  }
  
  @SimpleFunction(description="Get the firmware and protocol version numbers for the robot as a list where the first element is the firmware version number and the second element is the protocol version number.")
  public List<String> GetFirmwareVersion()
  {
    if (!checkBluetooth("GetFirmwareVersion")) {
      return new ArrayList();
    }
    Object localObject = new byte[2];
    localObject[0] = 1;
    localObject[1] = -120;
    byte[] arrayOfByte = sendCommandAndReceiveReturnPackage("GetFirmwareVersion", (byte[])localObject);
    if (evaluateStatus("GetFirmwareVersion", arrayOfByte, localObject[1]))
    {
      localObject = new ArrayList();
      ((List)localObject).add(arrayOfByte[6] + "." + arrayOfByte[5]);
      ((List)localObject).add(arrayOfByte[4] + "." + arrayOfByte[3]);
      return (List<String>)localObject;
    }
    return new ArrayList();
  }
  
  @SimpleFunction(description="Reads the values of an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public List<Object> GetInputValues(String paramString)
  {
    if (!checkBluetooth("GetInputValues")) {
      return new ArrayList();
    }
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      paramString = getInputValues("GetInputValues", i);
      if (paramString != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Boolean.valueOf(getBooleanValueFromBytes(paramString, 4)));
        localArrayList.add(Boolean.valueOf(getBooleanValueFromBytes(paramString, 5)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(paramString, 6)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(paramString, 7)));
        localArrayList.add(Integer.valueOf(getUWORDValueFromBytes(paramString, 8)));
        localArrayList.add(Integer.valueOf(getUWORDValueFromBytes(paramString, 10)));
        localArrayList.add(Integer.valueOf(getSWORDValueFromBytes(paramString, 12)));
        localArrayList.add(Integer.valueOf(getSWORDValueFromBytes(paramString, 14)));
        return localArrayList;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetInputValues", 408, new Object[] { paramString });
      return new ArrayList();
    }
    return new ArrayList();
  }
  
  @SimpleFunction(description="Reads the output state of a motor on the robot.")
  public List<Number> GetOutputState(String paramString)
  {
    if (!checkBluetooth("GetOutputState")) {
      return new ArrayList();
    }
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      paramString = getOutputState("GetOutputState", i);
      if (paramString != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(getSBYTEValueFromBytes(paramString, 4)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(paramString, 5)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(paramString, 6)));
        localArrayList.add(Integer.valueOf(getSBYTEValueFromBytes(paramString, 7)));
        localArrayList.add(Integer.valueOf(getUBYTEValueFromBytes(paramString, 8)));
        localArrayList.add(Long.valueOf(getULONGValueFromBytes(paramString, 9)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(paramString, 13)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(paramString, 17)));
        localArrayList.add(Integer.valueOf(getSLONGValueFromBytes(paramString, 21)));
        return localArrayList;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "GetOutputState", 407, new Object[] { paramString });
      return new ArrayList();
    }
    return new ArrayList();
  }
  
  @SimpleFunction(description="Keep Alive. Returns the current sleep time limit in milliseconds.")
  public long KeepAlive()
  {
    if (!checkBluetooth("KeepAlive")) {}
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    do
    {
      return 0L;
      arrayOfByte1 = new byte[2];
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = 13;
      arrayOfByte2 = sendCommandAndReceiveReturnPackage("KeepAlive", arrayOfByte1);
    } while (!evaluateStatus("KeepAlive", arrayOfByte2, arrayOfByte1[1]));
    if (arrayOfByte2.length == 7) {
      return getULONGValueFromBytes(arrayOfByte2, 3);
    }
    Log.w(this.logTag, "KeepAlive: unexpected return package length " + arrayOfByte2.length + " (expected 7)");
    return 0L;
  }
  
  @SimpleFunction(description="Returns a list containing the names of matching files found on the robot.")
  public List<String> ListFiles(String paramString)
  {
    if (!checkBluetooth("ListFiles"))
    {
      paramString = new ArrayList();
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramString;
    if (paramString.length() == 0) {
      localObject = "*.*";
    }
    paramString = new byte[22];
    paramString[0] = 1;
    paramString[1] = -122;
    copyStringValueToBytes((String)localObject, paramString, 2, 19);
    localObject = sendCommandAndReceiveReturnPackage("ListFiles", paramString);
    for (int i = getStatus("ListFiles", (byte[])localObject, paramString[1]);; i = getStatus("ListFiles", (byte[])localObject, paramString[1]))
    {
      paramString = localArrayList;
      if (i != 0) {
        break;
      }
      i = getUBYTEValueFromBytes((byte[])localObject, 3);
      localArrayList.add(getStringValueFromBytes((byte[])localObject, 4));
      paramString = new byte[3];
      paramString[0] = 1;
      paramString[1] = -121;
      copyUBYTEValueToBytes(i, paramString, 2);
      localObject = sendCommandAndReceiveReturnPackage("ListFiles", paramString);
    }
  }
  
  @SimpleFunction(description="Returns the count of available bytes to read.")
  public int LsGetStatus(String paramString)
  {
    if (!checkBluetooth("LsGetStatus")) {
      return 0;
    }
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      return lsGetStatus("LsGetStatus", i);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "LsGetStatus", 408, new Object[] { paramString });
    }
    return 0;
  }
  
  @SimpleFunction(description="Reads unsigned low speed data from an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public List<Integer> LsRead(String paramString)
  {
    if (!checkBluetooth("LsRead")) {
      paramString = new ArrayList();
    }
    for (;;)
    {
      return paramString;
      try
      {
        int i = convertSensorPortLetterToNumber(paramString);
        byte[] arrayOfByte = lsRead("LsRead", i);
        if (arrayOfByte != null)
        {
          ArrayList localArrayList = new ArrayList();
          int j = getUBYTEValueFromBytes(arrayOfByte, 3);
          i = 0;
          for (;;)
          {
            paramString = localArrayList;
            if (i >= j) {
              break;
            }
            localArrayList.add(Integer.valueOf(arrayOfByte[(i + 4)] & 0xFF));
            i += 1;
          }
        }
        return new ArrayList();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.form.dispatchErrorOccurredEvent(this, "LsRead", 408, new Object[] { paramString });
        return new ArrayList();
      }
    }
  }
  
  @SimpleFunction(description="Writes low speed data to an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.")
  public void LsWrite(String paramString, YailList paramYailList, int paramInt)
  {
    if (!checkBluetooth("LsWrite")) {
      return;
    }
    int j;
    try
    {
      j = convertSensorPortLetterToNumber(paramString);
      if (paramYailList.size() > 16)
      {
        this.form.dispatchErrorOccurredEvent(this, "LsWrite", 411, new Object[0]);
        return;
      }
    }
    catch (IllegalArgumentException paramYailList)
    {
      this.form.dispatchErrorOccurredEvent(this, "LsWrite", 408, new Object[] { paramString });
      return;
    }
    paramString = paramYailList.toArray();
    paramYailList = new byte[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].toString();
      try
      {
        int k = Integer.decode(str).intValue();
        paramYailList[i] = ((byte)(k & 0xFF));
        k >>= 8;
        if ((k != 0) && (k != -1))
        {
          this.form.dispatchErrorOccurredEvent(this, "LsWrite", 413, new Object[] { Integer.valueOf(i + 1) });
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        this.form.dispatchErrorOccurredEvent(this, "LsWrite", 412, new Object[] { Integer.valueOf(i + 1) });
        return;
      }
      i += 1;
    }
    lsWrite("LsWrite", j, paramYailList, paramInt);
  }
  
  @SimpleFunction(description="Read a message from a mailbox (1-10) on the robot.")
  public String MessageRead(int paramInt)
  {
    if (!checkBluetooth("MessageRead")) {
      return "";
    }
    if ((paramInt < 1) || (paramInt > 10))
    {
      this.form.dispatchErrorOccurredEvent(this, "MessageRead", 409, new Object[] { Integer.valueOf(paramInt) });
      return "";
    }
    paramInt -= 1;
    byte[] arrayOfByte1 = new byte[5];
    arrayOfByte1[0] = 0;
    arrayOfByte1[1] = 19;
    copyUBYTEValueToBytes(0, arrayOfByte1, 2);
    copyUBYTEValueToBytes(paramInt, arrayOfByte1, 3);
    copyBooleanValueToBytes(true, arrayOfByte1, 4);
    byte[] arrayOfByte2 = sendCommandAndReceiveReturnPackage("MessageRead", arrayOfByte1);
    if (evaluateStatus("MessageRead", arrayOfByte2, arrayOfByte1[1]))
    {
      if (arrayOfByte2.length == 64)
      {
        int i = getUBYTEValueFromBytes(arrayOfByte2, 3);
        if (i != paramInt) {
          Log.w(this.logTag, "MessageRead: unexpected return mailbox: " + i + " (expected " + paramInt + ")");
        }
        return getStringValueFromBytes(arrayOfByte2, 5, getUBYTEValueFromBytes(arrayOfByte2, 4) - 1);
      }
      Log.w(this.logTag, "MessageRead: unexpected return package length " + arrayOfByte2.length + " (expected 64)");
    }
    return "";
  }
  
  @SimpleFunction(description="Write a message to a mailbox (1-10) on the robot.")
  public void MessageWrite(int paramInt, String paramString)
  {
    if (!checkBluetooth("MessageWrite")) {
      return;
    }
    if ((paramInt < 1) || (paramInt > 10))
    {
      this.form.dispatchErrorOccurredEvent(this, "MessageWrite", 409, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    int i = paramString.length();
    if (i > 58)
    {
      this.form.dispatchErrorOccurredEvent(this, "MessageWrite", 410, new Object[0]);
      return;
    }
    byte[] arrayOfByte = new byte[i + 4 + 1];
    arrayOfByte[0] = Byte.MIN_VALUE;
    arrayOfByte[1] = 9;
    copyUBYTEValueToBytes(paramInt - 1, arrayOfByte, 2);
    copyUBYTEValueToBytes(i + 1, arrayOfByte, 3);
    copyStringValueToBytes(paramString, arrayOfByte, 4, i);
    sendCommand("MessageWrite", arrayOfByte);
  }
  
  @SimpleFunction(description="Play a sound file on the robot.")
  public void PlaySoundFile(String paramString)
  {
    if (!checkBluetooth("PlaySoundFile")) {
      return;
    }
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "PlaySoundFile", 406, new Object[0]);
      return;
    }
    String str = paramString;
    if (paramString.indexOf(".") == -1) {
      str = paramString + ".rso";
    }
    paramString = new byte[23];
    paramString[0] = -128;
    paramString[1] = 2;
    copyBooleanValueToBytes(false, paramString, 2);
    copyStringValueToBytes(str, paramString, 3, 19);
    sendCommand("PlaySoundFile", paramString);
  }
  
  @SimpleFunction(description="Make the robot play a tone.")
  public void PlayTone(int paramInt1, int paramInt2)
  {
    if (!checkBluetooth("PlayTone")) {
      return;
    }
    int i = paramInt1;
    if (paramInt1 < 200)
    {
      Log.w(this.logTag, "frequencyHz " + paramInt1 + " is invalid, using 200.");
      i = 200;
    }
    paramInt1 = i;
    if (i > 14000)
    {
      Log.w(this.logTag, "frequencyHz " + i + " is invalid, using 14000.");
      paramInt1 = 14000;
    }
    byte[] arrayOfByte = new byte[6];
    arrayOfByte[0] = Byte.MIN_VALUE;
    arrayOfByte[1] = 3;
    copyUWORDValueToBytes(paramInt1, arrayOfByte, 2);
    copyUWORDValueToBytes(paramInt2, arrayOfByte, 4);
    sendCommand("PlayTone", arrayOfByte);
  }
  
  @SimpleFunction(description="Reset the scaled value of an input sensor on the robot.")
  public void ResetInputScaledValue(String paramString)
  {
    if (!checkBluetooth("ResetInputScaledValue")) {
      return;
    }
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      resetInputScaledValue("ResetInputScaledValue", i);
      paramString = new byte[3];
      paramString[0] = -128;
      paramString[1] = 8;
      copyUBYTEValueToBytes(i, paramString, 2);
      sendCommand("ResetInputScaledValue", paramString);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ResetInputScaledValue", 408, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Reset motor position.")
  public void ResetMotorPosition(String paramString, boolean paramBoolean)
  {
    if (!checkBluetooth("ResetMotorPosition")) {
      return;
    }
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      paramString = new byte[4];
      paramString[0] = -128;
      paramString[1] = 10;
      copyUBYTEValueToBytes(i, paramString, 2);
      copyBooleanValueToBytes(paramBoolean, paramString, 3);
      sendCommand("ResetMotorPosition", paramString);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "ResetMotorPosition", 407, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Set the brick name of the robot.")
  public void SetBrickName(String paramString)
  {
    if (!checkBluetooth("SetBrickName")) {
      return;
    }
    byte[] arrayOfByte = new byte[18];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = -104;
    copyStringValueToBytes(paramString, arrayOfByte, 2, 15);
    evaluateStatus("SetBrickName", sendCommandAndReceiveReturnPackage("SetBrickName", arrayOfByte), arrayOfByte[1]);
  }
  
  @SimpleFunction(description="Configure an input sensor on the robot.")
  public void SetInputMode(String paramString, int paramInt1, int paramInt2)
  {
    if (!checkBluetooth("SetInputMode")) {
      return;
    }
    try
    {
      int i = convertSensorPortLetterToNumber(paramString);
      setInputMode("SetInputMode", i, paramInt1, paramInt2);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "SetInputMode", 408, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Sets the output state of a motor on the robot.")
  public void SetOutputState(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    if (!checkBluetooth("SetOutputState")) {
      return;
    }
    try
    {
      int i = convertMotorPortLetterToNumber(paramString);
      setOutputState("SetOutputState", i, paramInt1, paramInt2, paramInt3, sanitizeTurnRatio(paramInt4), paramInt5, paramLong);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "SetOutputState", 407, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Start execution of a previously downloaded program on the robot.")
  public void StartProgram(String paramString)
  {
    if (!checkBluetooth("StartProgram")) {
      return;
    }
    if (paramString.length() == 0)
    {
      this.form.dispatchErrorOccurredEvent(this, "StartProgram", 405, new Object[0]);
      return;
    }
    String str = paramString;
    if (paramString.indexOf(".") == -1) {
      str = paramString + ".rxe";
    }
    paramString = new byte[22];
    paramString[0] = -128;
    paramString[1] = 0;
    copyStringValueToBytes(str, paramString, 2, 19);
    sendCommand("StartProgram", paramString);
  }
  
  @SimpleFunction(description="Stop execution of the currently running program on the robot.")
  public void StopProgram()
  {
    if (!checkBluetooth("StopProgram")) {
      return;
    }
    sendCommand("StopProgram", new byte[] { Byte.MIN_VALUE, 1 });
  }
  
  @SimpleFunction(description="Stop sound playback.")
  public void StopSoundPlayback()
  {
    if (!checkBluetooth("StopSoundPlayback")) {
      return;
    }
    sendCommand("StopSoundPlayback", new byte[] { Byte.MIN_VALUE, 12 });
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\NxtDirectCommands.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */