package gnu.xquery.util;

import gnu.kawa.functions.AddOp;
import gnu.lists.Sequence;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Reduce
{
  public static Object sum(Object paramObject)
    throws Throwable
  {
    return sum(paramObject, IntNum.zero());
  }
  
  public static Object sum(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if ((paramObject1 instanceof Values))
    {
      TreeList localTreeList = (TreeList)paramObject1;
      int i = 0;
      paramObject1 = localTreeList.getPosNext(0);
      if (paramObject1 == Sequence.eofValue) {
        return paramObject2;
      }
      for (paramObject1 = MinMax.convert(paramObject1);; paramObject1 = AddOp.apply2(1, paramObject1, MinMax.convert(paramObject2)))
      {
        i = localTreeList.nextPos(i);
        paramObject2 = localTreeList.getPosNext(i);
        if (paramObject2 == Sequence.eofValue) {
          return paramObject1;
        }
      }
    }
    return (Number)MinMax.convert(paramObject1);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\Reduce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */