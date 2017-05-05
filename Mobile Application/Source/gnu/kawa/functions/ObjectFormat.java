package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.ParsePosition;

public class ObjectFormat
  extends ReportFormat
{
  private static ObjectFormat plainFormat;
  private static ObjectFormat readableFormat;
  int maxChars;
  boolean readable;
  
  public ObjectFormat(boolean paramBoolean)
  {
    this.readable = paramBoolean;
    this.maxChars = -1073741824;
  }
  
  public ObjectFormat(boolean paramBoolean, int paramInt)
  {
    this.readable = paramBoolean;
    this.maxChars = paramInt;
  }
  
  public static int format(Object[] paramArrayOfObject, int paramInt1, Writer paramWriter, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    if (paramInt1 >= paramArrayOfObject.length)
    {
      paramArrayOfObject = "#<missing format argument>";
      paramInt1 -= 1;
      paramBoolean = false;
      paramInt2 = -1;
    }
    for (;;)
    {
      format(paramArrayOfObject, paramWriter, paramInt2, paramBoolean);
      return paramInt1 + 1;
      paramArrayOfObject = paramArrayOfObject[paramInt1];
    }
  }
  
  public static boolean format(Object paramObject, Writer paramWriter, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if ((paramInt < 0) && ((paramWriter instanceof OutPort)))
    {
      print(paramObject, (OutPort)paramWriter, paramBoolean);
      return true;
    }
    if ((paramInt < 0) && ((paramWriter instanceof CharArrayWriter)))
    {
      paramWriter = new OutPort(paramWriter);
      print(paramObject, paramWriter, paramBoolean);
      paramWriter.close();
      return true;
    }
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    OutPort localOutPort = new OutPort(localCharArrayWriter);
    print(paramObject, localOutPort, paramBoolean);
    localOutPort.close();
    int i = localCharArrayWriter.size();
    if ((paramInt < 0) || (i <= paramInt))
    {
      localCharArrayWriter.writeTo(paramWriter);
      return true;
    }
    paramWriter.write(localCharArrayWriter.toCharArray(), 0, paramInt);
    return false;
  }
  
  public static ObjectFormat getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (readableFormat == null) {
        readableFormat = new ObjectFormat(true);
      }
      return readableFormat;
    }
    if (plainFormat == null) {
      plainFormat = new ObjectFormat(false);
    }
    return plainFormat;
  }
  
  /* Error */
  private static void print(Object paramObject, OutPort paramOutPort, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 76	gnu/mapping/OutPort:printReadable	Z
    //   4: istore_3
    //   5: aload_1
    //   6: getfield 80	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   9: astore 5
    //   11: aload_1
    //   12: iload_2
    //   13: putfield 76	gnu/mapping/OutPort:printReadable	Z
    //   16: iload_2
    //   17: ifeq +33 -> 50
    //   20: getstatic 85	kawa/standard/Scheme:writeFormat	Lgnu/lists/AbstractFormat;
    //   23: astore 4
    //   25: aload_1
    //   26: aload 4
    //   28: putfield 80	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   31: aload 4
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 91	gnu/lists/AbstractFormat:writeObject	(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    //   38: aload_1
    //   39: iload_3
    //   40: putfield 76	gnu/mapping/OutPort:printReadable	Z
    //   43: aload_1
    //   44: aload 5
    //   46: putfield 80	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   49: return
    //   50: getstatic 94	kawa/standard/Scheme:displayFormat	Lgnu/lists/AbstractFormat;
    //   53: astore 4
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: aload_1
    //   60: iload_3
    //   61: putfield 76	gnu/mapping/OutPort:printReadable	Z
    //   64: aload_1
    //   65: aload 5
    //   67: putfield 80	gnu/mapping/OutPort:objectFormat	Lgnu/lists/AbstractFormat;
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramObject	Object
    //   0	72	1	paramOutPort	OutPort
    //   0	72	2	paramBoolean	boolean
    //   4	57	3	bool	boolean
    //   23	31	4	localAbstractFormat1	gnu.lists.AbstractFormat
    //   9	57	5	localAbstractFormat2	gnu.lists.AbstractFormat
    // Exception table:
    //   from	to	target	type
    //   11	16	58	finally
    //   20	25	58	finally
    //   25	38	58	finally
    //   50	55	58	finally
  }
  
  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int j = getParam(this.maxChars, -1, paramArrayOfObject, paramInt);
    int i = paramInt;
    if (this.maxChars == -1610612736) {
      i = paramInt + 1;
    }
    return format(paramArrayOfObject, i, paramWriter, j, this.readable);
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new RuntimeException("ObjectFormat.parseObject - not implemented");
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\functions\ObjectFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */