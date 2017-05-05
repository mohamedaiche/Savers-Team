package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class IntegerRange
  extends MethodProc
{
  public static final IntNum MAX_INT = IntNum.make(Integer.MAX_VALUE);
  public static final IntNum MIN_INT;
  public static final IntegerRange integerRange = new IntegerRange("to");
  
  static
  {
    MIN_INT = IntNum.make(Integer.MIN_VALUE);
  }
  
  public IntegerRange(String paramString)
  {
    setName(paramString);
  }
  
  public static void integerRange(IntNum paramIntNum1, IntNum paramIntNum2, Consumer paramConsumer)
  {
    IntNum localIntNum = paramIntNum1;
    int i;
    if (IntNum.compare(paramIntNum1, MIN_INT) >= 0)
    {
      localIntNum = paramIntNum1;
      if (IntNum.compare(paramIntNum2, MAX_INT) <= 0)
      {
        i = paramIntNum1.intValue();
        int j = paramIntNum2.intValue();
        if (i <= j)
        {
          paramConsumer.writeInt(i);
          if (i != j) {
            break label57;
          }
        }
      }
    }
    for (;;)
    {
      return;
      label57:
      i += 1;
      break;
      while (IntNum.compare(localIntNum, paramIntNum2) <= 0)
      {
        paramConsumer.writeObject(localIntNum);
        localIntNum = IntNum.add(localIntNum, 1);
      }
    }
  }
  
  public void apply(CallContext paramCallContext)
  {
    Object localObject2 = paramCallContext.getNextArg();
    Object localObject1 = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    localObject2 = KNode.atomicValue(localObject2);
    Object localObject3 = KNode.atomicValue(localObject1);
    if ((localObject2 == Values.empty) || (localObject2 == null) || (localObject3 == Values.empty) || (localObject3 == null)) {
      return;
    }
    localObject1 = localObject2;
    if ((localObject2 instanceof UntypedAtomic)) {
      localObject1 = IntNum.valueOf(localObject2.toString().trim(), 10);
    }
    localObject2 = localObject3;
    if ((localObject3 instanceof UntypedAtomic)) {
      localObject2 = IntNum.valueOf(localObject3.toString().trim(), 10);
    }
    integerRange((IntNum)localObject1, (IntNum)localObject2, paramCallContext.consumer);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\IntegerRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */