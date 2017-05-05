package com.google.appinventor.components.runtime.multidex;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

class ZipEntryReader
{
  private static final long CENSIG = 33639248L;
  private static final int GPBF_ENCRYPTED_FLAG = 1;
  private static final int GPBF_UNSUPPORTED_MASK = 1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  private static long getTime(int paramInt1, int paramInt2)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(14, 0);
    localGregorianCalendar.set((paramInt2 >> 9 & 0x7F) + 1980, (paramInt2 >> 5 & 0xF) - 1, paramInt2 & 0x1F, paramInt1 >> 11 & 0x1F, paramInt1 >> 5 & 0x3F, (paramInt1 & 0x1F) << 1);
    return localGregorianCalendar.getTime().getTime();
  }
  
  static ZipEntry readEntry(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer.getInt() != 33639248L) {
      throw new ZipException("Central Directory Entry not found");
    }
    paramByteBuffer.position(8);
    int i = paramByteBuffer.getShort() & 0xFFFF;
    if ((i & 0x1) != 0) {
      throw new ZipException("Invalid General Purpose Bit Flag: " + i);
    }
    i = paramByteBuffer.getShort();
    int j = paramByteBuffer.getShort();
    int k = paramByteBuffer.getShort();
    long l1 = paramByteBuffer.getInt();
    long l2 = paramByteBuffer.getInt();
    long l3 = paramByteBuffer.getInt();
    int m = paramByteBuffer.getShort();
    int n = paramByteBuffer.getShort() & 0xFFFF;
    int i1 = paramByteBuffer.getShort() & 0xFFFF;
    paramByteBuffer.position(42);
    long l4 = paramByteBuffer.getInt();
    Object localObject = new byte[m & 0xFFFF];
    paramByteBuffer.get((byte[])localObject, 0, localObject.length);
    localObject = new ZipEntry(new String((byte[])localObject, 0, localObject.length, UTF_8));
    ((ZipEntry)localObject).setMethod(i & 0xFFFF);
    ((ZipEntry)localObject).setTime(getTime(j & 0xFFFF, k & 0xFFFF));
    ((ZipEntry)localObject).setCrc(l1 & 0xFFFFFFFF);
    ((ZipEntry)localObject).setCompressedSize(l2 & 0xFFFFFFFF);
    ((ZipEntry)localObject).setSize(l3 & 0xFFFFFFFF);
    byte[] arrayOfByte;
    if (i1 > 0)
    {
      arrayOfByte = new byte[i1];
      paramByteBuffer.get(arrayOfByte, 0, i1);
      ((ZipEntry)localObject).setComment(new String(arrayOfByte, 0, arrayOfByte.length, UTF_8));
    }
    if (n > 0)
    {
      arrayOfByte = new byte[n];
      paramByteBuffer.get(arrayOfByte, 0, n);
      ((ZipEntry)localObject).setExtra(arrayOfByte);
    }
    return (ZipEntry)localObject;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\multidex\ZipEntryReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */