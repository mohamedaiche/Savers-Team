package gnu.xquery.util;

import gnu.lists.Sequence;
import gnu.lists.TreeList;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Average
  extends Procedure1
{
  public static final Average avg = new Average("avg");
  
  public Average(String paramString)
  {
    super(paramString);
  }
  
  public Object apply1(Object paramObject)
    throws Throwable
  {
    Object localObject = Values.empty;
    int i = 0;
    TreeList localTreeList;
    int j;
    if ((paramObject instanceof Values))
    {
      localTreeList = (TreeList)paramObject;
      j = 0;
      paramObject = localObject;
      localObject = localTreeList.getPosNext(j);
      if (localObject != Sequence.eofValue) {}
    }
    for (;;)
    {
      if (paramObject != Values.empty) {
        break label92;
      }
      return paramObject;
      i += 1;
      if (paramObject == Values.empty) {}
      for (paramObject = localObject;; paramObject = ArithOp.add.apply2(paramObject, localObject))
      {
        j = localTreeList.nextPos(j);
        break;
      }
      i = 1;
    }
    label92:
    return ArithOp.div.apply2(paramObject, IntNum.make(i));
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\Average.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */