package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class ValuesEvery
  extends MethodProc
{
  public static final ValuesEvery every = new ValuesEvery(true);
  public static final ValuesEvery some = new ValuesEvery(false);
  boolean matchAll;
  
  public ValuesEvery(boolean paramBoolean)
  {
    this.matchAll = paramBoolean;
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Procedure localProcedure = (Procedure)paramCallContext.getNextArg();
    Object localObject = paramCallContext.getNextArg();
    boolean bool1 = this.matchAll;
    Procedure.checkArgCount(localProcedure, 1);
    boolean bool2;
    if ((localObject instanceof Values))
    {
      int i = 0;
      localObject = (Values)localObject;
      do
      {
        i = ((Values)localObject).nextPos(i);
        if (i == 0) {
          break;
        }
        localProcedure.check1(((Values)localObject).getPosPrevious(i), paramCallContext);
        bool2 = BooleanValue.booleanValue(paramCallContext.runUntilValue());
        bool1 = bool2;
      } while (bool2 == this.matchAll);
    }
    for (bool1 = bool2;; bool1 = BooleanValue.booleanValue(paramCallContext.runUntilValue()))
    {
      paramCallContext.consumer.writeBoolean(bool1);
      return;
      localProcedure.check1(localObject, paramCallContext);
    }
  }
  
  public int numArgs()
  {
    return 8194;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\ValuesEvery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */