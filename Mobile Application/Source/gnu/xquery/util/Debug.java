package gnu.xquery.util;

import gnu.mapping.OutPort;
import gnu.mapping.WrappedException;
import gnu.xml.XMLPrinter;
import java.io.FileOutputStream;

public class Debug
{
  public static String traceFilename;
  public static OutPort tracePort;
  public static String tracePrefix = "XQuery-trace: ";
  public static boolean traceShouldAppend = false;
  public static boolean traceShouldFlush;
  
  static
  {
    tracePort = null;
    traceFilename = "XQuery-trace.log";
    traceShouldFlush = true;
  }
  
  public static Object trace(Object paramObject1, Object paramObject2)
  {
    try
    {
      Object localObject1 = tracePort;
      Object localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = new OutPort(new FileOutputStream(traceFilename, traceShouldAppend));
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          new WrappedException("Could not open '" + traceFilename + "' for fn:trace output", localThrowable);
        }
      }
      tracePort = (OutPort)localObject1;
      localObject2 = localObject1;
      ((OutPort)localObject2).print(tracePrefix);
      ((OutPort)localObject2).print(paramObject2);
      ((OutPort)localObject2).print(' ');
      new XMLPrinter((OutPort)localObject2, false).writeObject(paramObject1);
      ((OutPort)localObject2).println();
      if (traceShouldFlush) {
        ((OutPort)localObject2).flush();
      }
      return paramObject1;
    }
    finally {}
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\Debug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */