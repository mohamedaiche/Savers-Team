package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class OrderedMap
  extends MethodProc
  implements Inlineable
{
  public static final OrderedMap orderedMap = new OrderedMap();
  
  static
  {
    orderedMap.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyOrderedMap");
  }
  
  public static Object[] makeTuple$V(Object[] paramArrayOfObject)
  {
    return paramArrayOfObject;
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject1 = paramCallContext.getArgs();
    Object localObject2 = localObject1[0];
    if (localObject1.length == 2) {}
    Object[] arrayOfObject;
    for (localObject1 = (OrderedTuples)localObject1[1];; localObject1 = OrderedTuples.make$V((Procedure)localObject1[1], arrayOfObject))
    {
      Values.writeValues(localObject2, (Consumer)localObject1);
      ((OrderedTuples)localObject1).run$X(paramCallContext);
      return;
      arrayOfObject = new Object[localObject1.length - 2];
      System.arraycopy(localObject1, 2, arrayOfObject, 0, arrayOfObject.length);
    }
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    CompileMisc.compileOrderedMap(paramApplyExp, paramCompilation, paramTarget, this);
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\OrderedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */