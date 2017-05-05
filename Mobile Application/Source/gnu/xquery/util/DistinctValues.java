package gnu.xquery.util;

import gnu.mapping.CallContext;
import gnu.mapping.Values;

public class DistinctValues
{
  public static void distinctValues$X(Object paramObject, NamedCollator paramNamedCollator, CallContext paramCallContext)
  {
    Values.writeValues(paramObject, new DistinctValuesConsumer(paramNamedCollator, paramCallContext.consumer));
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\DistinctValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */