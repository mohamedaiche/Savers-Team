package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.AttributeAxis;
import gnu.kawa.xml.ChildAxis;
import gnu.kawa.xml.NodeSetType;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.Nodes;
import gnu.kawa.xml.SelfAxis;
import gnu.kawa.xml.TreeScanner;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class RelativeStep
  extends MethodProc
  implements Inlineable
{
  public static final RelativeStep relativeStep = new RelativeStep();
  
  RelativeStep()
  {
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyRelativeStep");
  }
  
  public static TreeScanner extractStep(Expression paramExpression)
  {
    for (;;)
    {
      if (!(paramExpression instanceof ApplyExp)) {
        return null;
      }
      paramExpression = (ApplyExp)paramExpression;
      Object localObject = paramExpression.getFunction();
      if (!(localObject instanceof QuoteExp)) {
        break;
      }
      localObject = ((QuoteExp)localObject).getValue();
      if ((localObject instanceof TreeScanner)) {
        return (TreeScanner)localObject;
      }
      if (!(localObject instanceof ValuesFilter)) {
        break;
      }
      paramExpression = paramExpression.getArgs()[0];
    }
    return null;
  }
  
  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject2 = paramCallContext.getNextArg();
    Procedure localProcedure = (Procedure)paramCallContext.getNextArg();
    Object localObject1 = paramCallContext.consumer;
    Nodes localNodes;
    if ((localObject2 instanceof Nodes)) {
      localNodes = (Nodes)localObject2;
    }
    for (;;)
    {
      int k = localNodes.size();
      int j = 0;
      localObject2 = IntNum.make(k);
      localObject1 = new RelativeStepFilter((Consumer)localObject1);
      int i = 1;
      while (i <= k)
      {
        j = localNodes.nextPos(j);
        localProcedure.check3(localNodes.getPosPrevious(j), IntNum.make(i), localObject2, paramCallContext);
        Values.writeValues(paramCallContext.runUntilValue(), (Consumer)localObject1);
        i += 1;
      }
      localNodes = new Nodes();
      Values.writeValues(localObject2, localNodes);
    }
    ((RelativeStepFilter)localObject1).finish();
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Object localObject1 = paramApplyExp.getArgs();
    Expression localExpression1 = localObject1[0];
    Expression localExpression2 = localObject1[1];
    if ((paramTarget instanceof IgnoreTarget))
    {
      localExpression1.compile(paramCompilation, paramTarget);
      localExpression2.compile(paramCompilation, paramTarget);
      return;
    }
    Object localObject2 = paramApplyExp.getTypeRaw();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Type.pointer_type;
    }
    localObject1 = OccurrenceType.itemPrimeType((Type)localObject1);
    int i = NodeType.anyNodeTest.compare((Type)localObject1);
    if (i >= 0) {
      i = 78;
    }
    int j;
    for (;;)
    {
      localObject1 = extractStep(localExpression2);
      j = i;
      if (localObject1 != null)
      {
        localObject2 = localExpression1.getType();
        if ((!(localObject1 instanceof ChildAxis)) && (!(localObject1 instanceof AttributeAxis)))
        {
          j = i;
          if (!(localObject1 instanceof SelfAxis)) {}
        }
        else if (!(localObject2 instanceof NodeSetType))
        {
          j = i;
          if (i == 78)
          {
            j = i;
            if (!OccurrenceType.itemCountIsZeroOrOne(localExpression1.getType())) {}
          }
        }
        else
        {
          j = 83;
        }
      }
      if ((paramTarget instanceof ConsumerTarget)) {
        break;
      }
      ConsumerTarget.compileUsingConsumer(paramApplyExp, paramCompilation, paramTarget);
      return;
      if (i == -3) {
        i = 65;
      } else {
        i = 32;
      }
    }
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localObject2 = localCodeAttr.pushScope();
    if ((j == 65) || (j == 83))
    {
      paramApplyExp = null;
      localObject1 = null;
      localObject2 = null;
      ValuesMap.compileInlined((LambdaExp)localExpression2, localExpression1, 1, null, paramCompilation, paramTarget);
      if (j != 78) {
        break label426;
      }
      localCodeAttr.emitLoad((Variable)localObject1);
      localCodeAttr.emitLoad((Variable)localObject2);
      localCodeAttr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("writeValues", 2));
    }
    for (;;)
    {
      localCodeAttr.popScope();
      return;
      if (j == 78) {
        paramApplyExp = ClassType.make("gnu.kawa.xml.SortedNodes");
      }
      for (localObject1 = paramApplyExp.getDeclaredMethod("<init>", 0);; localObject1 = paramApplyExp.getDeclaredMethod("<init>", 1))
      {
        localObject2 = ((Scope)localObject2).addVariable(localCodeAttr, paramApplyExp, null);
        ConsumerTarget localConsumerTarget = new ConsumerTarget((Variable)localObject2);
        localCodeAttr.emitNew(paramApplyExp);
        localCodeAttr.emitDup(paramApplyExp);
        Variable localVariable = ((ConsumerTarget)paramTarget).getConsumerVariable();
        if (j != 78) {
          localCodeAttr.emitLoad(localVariable);
        }
        localCodeAttr.emitInvoke((Method)localObject1);
        localCodeAttr.emitStore((Variable)localObject2);
        paramTarget = localConsumerTarget;
        localObject1 = localObject2;
        localObject2 = localVariable;
        break;
        paramApplyExp = ClassType.make("gnu.xquery.util.RelativeStepFilter");
      }
      label426:
      if (j == 32)
      {
        localCodeAttr.emitLoad((Variable)localObject1);
        localCodeAttr.emitInvoke(paramApplyExp.getDeclaredMethod("finish", 0));
      }
    }
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


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\RelativeStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */