package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.Target;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;

public class ValuesFilter
  extends MethodProc
  implements Inlineable
{
  public static final ValuesFilter exprFilter;
  public static final ValuesFilter forwardFilter = new ValuesFilter('F');
  public static final Method matchesMethod = typeValuesFilter.getDeclaredMethod("matches", 2);
  public static final ValuesFilter reverseFilter = new ValuesFilter('R');
  public static final ClassType typeValuesFilter;
  char kind;
  int last_or_position_needed = 2;
  
  static
  {
    exprFilter = new ValuesFilter('P');
    typeValuesFilter = ClassType.make("gnu.xquery.util.ValuesFilter");
  }
  
  public ValuesFilter(char paramChar)
  {
    this.kind = paramChar;
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyValuesFilter");
  }
  
  public static ValuesFilter get(char paramChar)
  {
    if (paramChar == 'F') {
      return forwardFilter;
    }
    if (paramChar == 'R') {
      return reverseFilter;
    }
    return exprFilter;
  }
  
  public static boolean matches(Object paramObject, long paramLong)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof Values)) {
      localObject = ((Values)paramObject).canonicalize();
    }
    if ((localObject instanceof Number))
    {
      if ((localObject instanceof IntNum)) {
        if (IntNum.compare((IntNum)localObject, paramLong) != 0) {}
      }
      do
      {
        do
        {
          return true;
          return false;
          if ((!(localObject instanceof Double)) && (!(localObject instanceof Float)) && (!(localObject instanceof DFloNum))) {
            break;
          }
        } while (((Number)localObject).doubleValue() == paramLong);
        return false;
        if ((!(localObject instanceof Long)) && (!(localObject instanceof Integer)) && (!(localObject instanceof Short)) && (!(localObject instanceof Byte))) {
          break;
        }
      } while (paramLong == ((Number)localObject).longValue());
      return false;
      return NumberCompare.applyWithPromotion(8, IntNum.make(paramLong), localObject);
    }
    return BooleanValue.booleanValue(localObject);
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject1 = paramCallContext.getNextArg();
    Procedure localProcedure = (Procedure)paramCallContext.getNextArg();
    Consumer localConsumer = paramCallContext.consumer;
    int j;
    IntNum localIntNum;
    int i;
    label68:
    int k;
    Object localObject2;
    if (this.kind != 'P')
    {
      paramCallContext = new SortedNodes();
      Values.writeValues(localObject1, paramCallContext);
      int m = paramCallContext.size();
      j = 0;
      localIntNum = IntNum.make(m);
      int n = localProcedure.maxArgs();
      i = 0;
      if (i >= m) {
        break label201;
      }
      k = paramCallContext.nextPos(j);
      localObject2 = paramCallContext.getPosPrevious(k);
      if (this.kind != 'R') {
        break label202;
      }
      j = m - i;
      label103:
      localObject1 = IntNum.make(j);
      if (n != 2) {
        break label209;
      }
    }
    label201:
    label202:
    label209:
    for (localObject1 = localProcedure.apply2(localObject2, localObject1);; localObject1 = localProcedure.apply3(localObject2, localObject1, localIntNum))
    {
      if (matches(localObject1, j)) {
        localConsumer.writeObject(localObject2);
      }
      i += 1;
      j = k;
      break label68;
      if ((localObject1 instanceof Values))
      {
        paramCallContext = (Values)localObject1;
        break;
      }
      paramCallContext = IntNum.one();
      if (matches(localProcedure.apply3(localObject1, paramCallContext, paramCallContext), 1L)) {
        localConsumer.writeObject(localObject1);
      }
      return;
      j = i + 1;
      break label103;
    }
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Object localObject = paramApplyExp.getArgs();
    Expression localExpression = localObject[0];
    localObject = localObject[1];
    if ((paramTarget instanceof IgnoreTarget))
    {
      localExpression.compile(paramCompilation, paramTarget);
      ((Expression)localObject).compile(paramCompilation, paramTarget);
      return;
    }
    if (!(localObject instanceof LambdaExp))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    if (!(paramTarget instanceof ConsumerTarget))
    {
      ConsumerTarget.compileUsingConsumer(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    ValuesMap.compileInlined((LambdaExp)localObject, localExpression, 1, matchesMethod, paramCompilation, paramTarget);
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }
  
  public int numArgs()
  {
    return 8194;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\ValuesFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */