package com.google.appinventor.components.runtime.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class Ev3BinaryParser
{
  private static byte PRIMPAR_1_BYTE = 1;
  private static byte PRIMPAR_2_BYTES = 2;
  private static byte PRIMPAR_4_BYTES = 3;
  private static byte PRIMPAR_ADDR;
  private static byte PRIMPAR_BYTES;
  private static byte PRIMPAR_CONST;
  private static byte PRIMPAR_CONST_SIGN;
  private static byte PRIMPAR_GLOBAL;
  private static byte PRIMPAR_HANDLE;
  private static byte PRIMPAR_INDEX;
  private static byte PRIMPAR_LOCAL;
  private static byte PRIMPAR_LONG;
  private static byte PRIMPAR_SHORT = 0;
  private static byte PRIMPAR_STRING = 4;
  private static byte PRIMPAR_STRING_OLD;
  private static byte PRIMPAR_VALUE;
  private static byte PRIMPAR_VARIABEL;
  
  static
  {
    PRIMPAR_LONG = Byte.MIN_VALUE;
    PRIMPAR_CONST = 0;
    PRIMPAR_VARIABEL = 64;
    PRIMPAR_LOCAL = 0;
    PRIMPAR_GLOBAL = 32;
    PRIMPAR_HANDLE = 16;
    PRIMPAR_ADDR = 8;
    PRIMPAR_INDEX = 31;
    PRIMPAR_CONST_SIGN = 32;
    PRIMPAR_VALUE = 63;
    PRIMPAR_BYTES = 7;
    PRIMPAR_STRING_OLD = 0;
  }
  
  public static byte[] encodeDirectCommand(byte paramByte, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if ((paramInt1 < 0) || (paramInt1 > 1023) || (paramInt2 < 0) || (paramInt2 > 63) || (paramString.length() != paramVarArgs.length)) {
      throw new IllegalArgumentException();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramString.length())
    {
      int j = paramString.charAt(i);
      Object localObject = paramVarArgs[i];
      switch (j)
      {
      default: 
        throw new IllegalArgumentException("Illegal format string");
      case 99: 
        if ((localObject instanceof Byte)) {
          if ((((Byte)localObject).byteValue() <= 31) && (((Byte)localObject).byteValue() >= -31)) {
            localArrayList.add(encodeLC0(((Byte)localObject).byteValue()));
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(encodeLC1(((Byte)localObject).byteValue()));
        continue;
        if ((localObject instanceof Short))
        {
          localArrayList.add(encodeLC2(((Short)localObject).shortValue()));
        }
        else if ((localObject instanceof Integer))
        {
          localArrayList.add(encodeLC4(((Integer)localObject).intValue()));
        }
        else
        {
          throw new IllegalArgumentException();
          if ((localObject instanceof Byte))
          {
            if ((((Byte)localObject).byteValue() <= 31) && (((Byte)localObject).byteValue() >= -31)) {
              localArrayList.add(encodeLV0(((Byte)localObject).byteValue()));
            } else {
              localArrayList.add(encodeLV1(((Byte)localObject).byteValue()));
            }
          }
          else if ((localObject instanceof Short))
          {
            localArrayList.add(encodeLV2(((Short)localObject).shortValue()));
          }
          else if ((localObject instanceof Integer))
          {
            localArrayList.add(encodeLV4(((Integer)localObject).intValue()));
          }
          else
          {
            throw new IllegalArgumentException();
            if ((localObject instanceof Byte))
            {
              if ((((Byte)localObject).byteValue() <= 31) && (((Byte)localObject).byteValue() >= -31)) {
                localArrayList.add(encodeGV0(((Byte)localObject).byteValue()));
              } else {
                localArrayList.add(encodeGV1(((Byte)localObject).byteValue()));
              }
            }
            else if ((localObject instanceof Short))
            {
              localArrayList.add(encodeGV2(((Short)localObject).shortValue()));
            }
            else if ((localObject instanceof Integer))
            {
              localArrayList.add(encodeGV4(((Integer)localObject).intValue()));
            }
            else
            {
              throw new IllegalArgumentException();
              if (!(localObject instanceof String)) {
                throw new IllegalArgumentException();
              }
              try
              {
                localArrayList.add(((String)localObject + '\000').getBytes("US-ASCII"));
              }
              catch (UnsupportedEncodingException paramString)
              {
                throw new IllegalArgumentException();
              }
            }
          }
        }
      }
    }
    i = 4;
    paramString = localArrayList.iterator();
    while (paramString.hasNext()) {
      i += ((byte[])paramString.next()).length;
    }
    paramString = ByteBuffer.allocate(i);
    paramString.order(ByteOrder.LITTLE_ENDIAN);
    if (paramBoolean) {}
    for (byte b = 0;; b = Byte.MIN_VALUE)
    {
      paramString.put(b);
      paramString.put(new byte[] { (byte)(paramInt1 & 0xFF), (byte)(paramInt1 >>> 8 & 0x3 | paramInt2 << 2) });
      paramString.put(paramByte);
      paramVarArgs = localArrayList.iterator();
      while (paramVarArgs.hasNext()) {
        paramString.put((byte[])paramVarArgs.next());
      }
    }
    return paramString.array();
  }
  
  public static byte[] encodeGV0(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_INDEX & paramInt | PRIMPAR_SHORT | PRIMPAR_VARIABEL | PRIMPAR_GLOBAL) };
  }
  
  public static byte[] encodeGV1(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_GLOBAL | PRIMPAR_1_BYTE), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] encodeGV2(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_GLOBAL | PRIMPAR_2_BYTES), (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF) };
  }
  
  public static byte[] encodeGV4(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_GLOBAL | PRIMPAR_4_BYTES), (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 24 & 0xFF) };
  }
  
  public static byte[] encodeLC0(byte paramByte)
  {
    if ((paramByte < -31) || (paramByte > 31)) {
      throw new IllegalArgumentException("Encoded value must be in range [0, 127]");
    }
    return new byte[] { (byte)(PRIMPAR_VALUE & paramByte) };
  }
  
  public static byte[] encodeLC1(byte paramByte)
  {
    return new byte[] { (byte)((byte)(PRIMPAR_LONG | PRIMPAR_CONST) | PRIMPAR_1_BYTE), (byte)(paramByte & 0xFF) };
  }
  
  public static byte[] encodeLC2(short paramShort)
  {
    return new byte[] { (byte)((byte)(PRIMPAR_LONG | PRIMPAR_CONST) | PRIMPAR_2_BYTES), (byte)(paramShort & 0xFF), (byte)(paramShort >>> 8 & 0xFF) };
  }
  
  public static byte[] encodeLC4(int paramInt)
  {
    return new byte[] { (byte)((byte)(PRIMPAR_LONG | PRIMPAR_CONST) | PRIMPAR_4_BYTES), (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 24 & 0xFF) };
  }
  
  public static byte[] encodeLV0(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_INDEX & paramInt | PRIMPAR_SHORT | PRIMPAR_VARIABEL | PRIMPAR_LOCAL) };
  }
  
  public static byte[] encodeLV1(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_LOCAL | PRIMPAR_1_BYTE), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] encodeLV2(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_LOCAL | PRIMPAR_2_BYTES), (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF) };
  }
  
  public static byte[] encodeLV4(int paramInt)
  {
    return new byte[] { (byte)(PRIMPAR_LONG | PRIMPAR_VARIABEL | PRIMPAR_LOCAL | PRIMPAR_4_BYTES), (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 24 & 0xFF) };
  }
  
  public static byte[] encodeSystemCommand(byte paramByte, boolean paramBoolean, Object... paramVarArgs)
  {
    int i = 2;
    int k = paramVarArgs.length;
    int j = 0;
    if (j < k)
    {
      localObject1 = paramVarArgs[j];
      if ((localObject1 instanceof Byte)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if ((localObject1 instanceof Short))
        {
          i += 2;
        }
        else if ((localObject1 instanceof Integer))
        {
          i += 4;
        }
        else
        {
          if (!(localObject1 instanceof String)) {
            break label106;
          }
          i += ((String)localObject1).length() + 1;
        }
      }
      label106:
      throw new IllegalArgumentException("Parameters should be one of the class types: Byte, Short, Integer, String");
    }
    Object localObject1 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
    byte b;
    label159:
    Object localObject2;
    if (paramBoolean)
    {
      b = 1;
      ((ByteBuffer)localObject1).put(b);
      ((ByteBuffer)localObject1).put(paramByte);
      j = paramVarArgs.length;
      i = 0;
      if (i >= j) {
        break label314;
      }
      localObject2 = paramVarArgs[i];
      if (!(localObject2 instanceof Byte)) {
        break label209;
      }
      ((ByteBuffer)localObject1).put(((Byte)localObject2).byteValue());
    }
    for (;;)
    {
      i += 1;
      break label159;
      b = -127;
      break;
      label209:
      if ((localObject2 instanceof Short)) {
        ((ByteBuffer)localObject1).putShort(((Short)localObject2).shortValue());
      } else if ((localObject2 instanceof Integer)) {
        ((ByteBuffer)localObject1).putInt(((Integer)localObject2).intValue());
      } else if ((localObject2 instanceof String)) {
        try
        {
          ((ByteBuffer)localObject1).put(((String)localObject2).getBytes("US-ASCII"));
          ((ByteBuffer)localObject1).put((byte)0);
        }
        catch (UnsupportedEncodingException paramVarArgs)
        {
          throw new IllegalArgumentException("Non-ASCII string encoding is not supported");
        }
      }
    }
    throw new IllegalArgumentException("Parameters should be one of the class types: Byte, Short, Integer, String");
    label314:
    return ((ByteBuffer)localObject1).array();
  }
  
  public static byte[] pack(String paramString, Object... paramVarArgs)
    throws IllegalArgumentException
  {
    Object localObject1 = paramString.split("(?<=\\D)");
    paramString = new FormatLiteral[localObject1.length];
    int j = 0;
    int i = 0;
    int k = 0;
    Object localObject2;
    int m;
    if (k < localObject1.length)
    {
      localObject2 = localObject1[k];
      char c = ((String)localObject2).charAt(((String)localObject2).length() - 1);
      m = 1;
      n = 0;
      if (((String)localObject2).length() != 1)
      {
        int i1 = Integer.parseInt(((String)localObject2).substring(0, ((String)localObject2).length() - 1));
        n = 1;
        m = i1;
        if (i1 < 1) {
          throw new IllegalArgumentException("Illegal format string");
        }
      }
      switch (c)
      {
      default: 
        throw new IllegalArgumentException("Illegal format string");
      case 'x': 
        i += m;
      }
      for (;;)
      {
        paramString[k] = new FormatLiteral(c, m);
        k += 1;
        break;
        i += m;
        j += m;
        continue;
        i += m;
        j += 1;
        continue;
        i += m * 2;
        j += m;
        continue;
        i += m * 2;
        j += 1;
        continue;
        i += m * 4;
        j += m;
        continue;
        i += m * 4;
        j += 1;
        continue;
        i += m * 8;
        j += m;
        continue;
        i += m * 8;
        j += 1;
        continue;
        i += m * 4;
        j += m;
        continue;
        i += m * 4;
        j += 1;
        continue;
        if (m != ((String)paramVarArgs[j]).length()) {
          throw new IllegalArgumentException("Illegal format string");
        }
        i += m;
        j += 1;
        continue;
        if (n != 0) {
          throw new IllegalArgumentException("Illegal format string");
        }
        i += ((String)paramVarArgs[j]).length() + 1;
        j += 1;
      }
    }
    if (j != paramVarArgs.length) {
      throw new IllegalArgumentException("Illegal format string");
    }
    j = 0;
    localObject1 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject1).order(ByteOrder.LITTLE_ENDIAN);
    int n = paramString.length;
    k = 0;
    if (k < n)
    {
      localObject2 = paramString[k];
      switch (((FormatLiteral)localObject2).symbol)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        k += 1;
        j = i;
        break;
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).put((byte)0);
          m += 1;
        }
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).put(((Byte)paramVarArgs[j]).byteValue());
          j += 1;
          m += 1;
        }
        ((ByteBuffer)localObject1).put((byte[])paramVarArgs[j]);
        i = j + 1;
        continue;
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).putShort(((Short)paramVarArgs[j]).shortValue());
          j += 1;
          m += 1;
        }
        i = 0;
        while (i < ((FormatLiteral)localObject2).size)
        {
          ((ByteBuffer)localObject1).putShort(((short[])(short[])paramVarArgs[j])[i]);
          i += 1;
        }
        i = j + 1;
        continue;
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).putInt(((Integer)paramVarArgs[j]).intValue());
          j += 1;
          m += 1;
        }
        i = 0;
        while (i < ((FormatLiteral)localObject2).size)
        {
          ((ByteBuffer)localObject1).putInt(((int[])(int[])paramVarArgs[j])[i]);
          i += 1;
        }
        i = j + 1;
        continue;
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).putLong(((Long)paramVarArgs[j]).longValue());
          j += 1;
          m += 1;
        }
        i = 0;
        while (i < ((FormatLiteral)localObject2).size)
        {
          ((ByteBuffer)localObject1).putLong(((long[])(long[])paramVarArgs[j])[i]);
          i += 1;
        }
        i = j + 1;
        continue;
        m = 0;
        for (;;)
        {
          i = j;
          if (m >= ((FormatLiteral)localObject2).size) {
            break;
          }
          ((ByteBuffer)localObject1).putFloat(((Float)paramVarArgs[j]).floatValue());
          j += 1;
          m += 1;
        }
        i = 0;
        while (i < ((FormatLiteral)localObject2).size)
        {
          ((ByteBuffer)localObject1).putFloat(((float[])(float[])paramVarArgs[j])[i]);
          i += 1;
        }
        i = j + 1;
        continue;
        try
        {
          ((ByteBuffer)localObject1).put(((String)paramVarArgs[j]).getBytes("US-ASCII"));
          i = j + 1;
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new IllegalArgumentException();
        }
        try
        {
          ((ByteBuffer)localObject1).put(((String)paramVarArgs[j]).getBytes("US-ASCII"));
          ((ByteBuffer)localObject1).put((byte)0);
          i = j + 1;
        }
        catch (UnsupportedEncodingException paramString)
        {
          throw new IllegalArgumentException();
        }
      }
    }
    return ((ByteBuffer)localObject1).array();
  }
  
  public static Object[] unpack(String paramString, byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    paramString = paramString.split("(?<=\\D)");
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.LITTLE_ENDIAN);
    int n = paramString.length;
    int i = 0;
    if (i < n)
    {
      Object localObject = paramString[i];
      int k = 0;
      int j = 1;
      int i1 = ((String)localObject).charAt(((String)localObject).length() - 1);
      if (((String)localObject).length() > 1)
      {
        k = 1;
        int m = Integer.parseInt(((String)localObject).substring(0, ((String)localObject).length() - 1));
        j = m;
        if (m < 1) {
          throw new IllegalArgumentException("Illegal format string");
        }
      }
      switch (i1)
      {
      }
      do
      {
        throw new IllegalArgumentException("Illegal format string");
        k = 0;
        while (k < j)
        {
          paramArrayOfByte.get();
          k += 1;
          continue;
          k = 0;
          while (k < j)
          {
            localArrayList.add(Byte.valueOf(paramArrayOfByte.get()));
            k += 1;
            continue;
            localObject = new byte[j];
            paramArrayOfByte.get((byte[])localObject, 0, j);
            localArrayList.add(localObject);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          k = 0;
          while (k < j)
          {
            localArrayList.add(Short.valueOf(paramArrayOfByte.getShort()));
            k += 1;
          }
          continue;
          localObject = new short[j];
          for (k = 0; k < j; k = (short)(k + 1)) {
            localObject[k] = paramArrayOfByte.getShort();
          }
          localArrayList.add(localObject);
          continue;
          k = 0;
          while (k < j)
          {
            localArrayList.add(Integer.valueOf(paramArrayOfByte.getInt()));
            k += 1;
          }
          continue;
          localObject = new int[j];
          k = 0;
          while (k < j)
          {
            localObject[k] = paramArrayOfByte.getInt();
            k += 1;
          }
          localArrayList.add(localObject);
          continue;
          k = 0;
          while (k < j)
          {
            localArrayList.add(Long.valueOf(paramArrayOfByte.getLong()));
            k += 1;
          }
          continue;
          localObject = new long[j];
          k = 0;
          while (k < j)
          {
            localObject[k] = paramArrayOfByte.getLong();
            k += 1;
          }
          localArrayList.add(localObject);
          continue;
          k = 0;
          while (k < j)
          {
            localArrayList.add(Float.valueOf(paramArrayOfByte.getFloat()));
            k += 1;
          }
          continue;
          localObject = new float[j];
          k = 0;
          while (k < j)
          {
            localObject[k] = paramArrayOfByte.getFloat();
            k += 1;
          }
          localArrayList.add(localObject);
          continue;
          localObject = new byte[j];
          paramArrayOfByte.get((byte[])localObject, 0, j);
          try
          {
            localArrayList.add(new String((byte[])localObject, "US-ASCII"));
          }
          catch (UnsupportedEncodingException paramString)
          {
            throw new IllegalArgumentException();
          }
          if (k != 0) {
            throw new IllegalArgumentException("Illegal format string");
          }
          localObject = new StringBuffer();
          for (;;)
          {
            j = paramArrayOfByte.get();
            if (j == 0) {
              break;
            }
            ((StringBuffer)localObject).append((char)j);
          }
          localArrayList.add(((StringBuffer)localObject).toString());
        }
        if (k != 0) {
          throw new IllegalArgumentException("Illegal format string");
        }
      } while (!paramArrayOfByte.hasRemaining());
      throw new IllegalArgumentException("Illegal format string");
    }
    return localArrayList.toArray();
  }
  
  private static class FormatLiteral
  {
    public int size;
    public char symbol;
    
    public FormatLiteral(char paramChar, int paramInt)
    {
      this.symbol = paramChar;
      this.size = paramInt;
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\util\Ev3BinaryParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */