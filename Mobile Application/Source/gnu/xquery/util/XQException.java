package gnu.xquery.util;

import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class XQException
  extends RuntimeException
{
  public static Symbol FOER0000_QNAME = Symbol.make("http://www.w3.org/2005/xqt-errors", "FOER0000", "err");
  public Symbol code;
  public String description;
  public Object errorValue;
  
  public XQException(Symbol paramSymbol, String paramString, Object paramObject)
  {
    super(paramString);
    this.code = paramSymbol;
    this.description = paramString;
    this.errorValue = paramObject;
  }
  
  public static void error()
  {
    throw new XQException(FOER0000_QNAME, null, null);
  }
  
  public static void error(Symbol paramSymbol)
  {
    throw new XQException(paramSymbol, null, null);
  }
  
  public static void error(Object paramObject, String paramString)
  {
    Object localObject;
    if (paramObject != null)
    {
      localObject = paramObject;
      if (paramObject != Values.empty) {}
    }
    else
    {
      localObject = FOER0000_QNAME;
    }
    throw new XQException((Symbol)localObject, paramString, null);
  }
  
  public static void error(Object paramObject1, String paramString, Object paramObject2)
  {
    Object localObject;
    if (paramObject1 != null)
    {
      localObject = paramObject1;
      if (paramObject1 != Values.empty) {}
    }
    else
    {
      localObject = FOER0000_QNAME;
    }
    throw new XQException((Symbol)localObject, paramString, paramObject2);
  }
  
  public String getMessage()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    if (this.description == null) {
      localStringBuffer.append("XQuery-error");
    }
    for (;;)
    {
      if (this.code != null)
      {
        localStringBuffer.append(" [");
        String str = this.code.getPrefix();
        if ((str != null) && (str.length() > 0))
        {
          localStringBuffer.append(str);
          localStringBuffer.append(':');
        }
        localStringBuffer.append(this.code.getLocalName());
        localStringBuffer.append(']');
      }
      if ((this.errorValue != null) && (this.errorValue != Values.empty))
      {
        localStringBuffer.append(" value: ");
        localStringBuffer.append(this.errorValue);
      }
      return localStringBuffer.toString();
      localStringBuffer.append(this.description);
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\XQException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */