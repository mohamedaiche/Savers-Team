package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;

public class SubList
  extends MethodProc
{
  public static final SubList subList = new SubList();
  
  public static void subList(Object paramObject, double paramDouble1, double paramDouble2, Consumer paramConsumer)
  {
    if ((paramObject instanceof Values))
    {
      paramObject = (Values)paramObject;
      j = 0;
      i = 0;
      do
      {
        j += 1;
        if (j >= paramDouble1) {
          break;
        }
        k = ((Values)paramObject).nextDataIndex(i);
        i = k;
      } while (k >= 0);
    }
    while ((paramDouble1 > 1.0D) || (paramDouble2 < 2.0D))
    {
      int i;
      return;
      int m = i;
      int k = j;
      int j = i;
      for (;;)
      {
        if (k < paramDouble2)
        {
          j = ((Values)paramObject).nextDataIndex(j);
          if (j >= 0) {}
        }
        else
        {
          ((Values)paramObject).consumeIRange(i, m, paramConsumer);
          return;
        }
        m = j;
        k += 1;
      }
    }
    paramConsumer.writeObject(paramObject);
  }
  
  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    Object localObject1 = paramCallContext.getNextArg();
    double d2 = Math.round(StringUtils.asDouble(paramCallContext.getNextArg()));
    Object localObject2 = Sequence.eofValue;
    Object localObject3 = paramCallContext.getNextArg(localObject2);
    paramCallContext.lastArg();
    if (localObject3 != localObject2) {}
    for (double d1 = Math.round(StringUtils.asDouble(localObject3));; d1 = Double.POSITIVE_INFINITY)
    {
      subList(localObject1, d2, d2 + d1, localConsumer);
      return;
    }
  }
  
  public int numArgs()
  {
    return 12290;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\SubList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */