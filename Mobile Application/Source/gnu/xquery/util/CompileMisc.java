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
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ValuesMap;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.ChildAxis;
import gnu.kawa.xml.CoerceNodes;
import gnu.kawa.xml.DescendantAxis;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.kawa.xml.NodeSetType;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.SortNodes;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import gnu.xquery.lang.XQuery;

public class CompileMisc
{
  static final Method castMethod = typeXDataType.getDeclaredMethod("cast", 1);
  static final Method castableMethod = typeXDataType.getDeclaredMethod("castable", 1);
  static final ClassType typeTuples = ClassType.make("gnu.xquery.util.OrderedTuples");
  static final ClassType typeXDataType = ClassType.make("gnu.kawa.xml.XDataType");
  
  public static void compileOrderedMap(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget, Procedure paramProcedure)
  {
    Object localObject = paramApplyExp.getArgs();
    if (localObject.length != 2)
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    paramProcedure = paramCompilation.getCode();
    Variable localVariable = paramProcedure.pushScope().addVariable(paramProcedure, typeTuples, null);
    localObject[1].compile(paramCompilation, Target.pushValue(typeTuples));
    paramProcedure.emitStore(localVariable);
    ConsumerTarget localConsumerTarget = new ConsumerTarget(localVariable);
    localObject[0].compile(paramCompilation, localConsumerTarget);
    localObject = typeTuples.getDeclaredMethod("run$X", 1);
    paramProcedure.emitLoad(localVariable);
    PrimProcedure.compileInvoke(paramCompilation, (Method)localObject, paramTarget, paramApplyExp.isTailCall(), 182, Type.pointer_type);
    paramProcedure.popScope();
  }
  
  public static Expression validateApplyCastAs(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp = CompileReflect.inlineClassName(paramApplyExp, 0, paramInlineCalls);
    paramInlineCalls = paramApplyExp.getArgs();
    if ((paramInlineCalls.length != 2) || (!(paramInlineCalls[0] instanceof QuoteExp))) {}
    while (!(((QuoteExp)paramInlineCalls[0]).getValue() instanceof XDataType)) {
      return paramApplyExp;
    }
    return new ApplyExp(castMethod, paramInlineCalls);
  }
  
  public static Expression validateApplyCastableAs(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp = CompileReflect.inlineClassName(paramApplyExp, 1, paramInlineCalls);
    paramInlineCalls = paramApplyExp.getArgs();
    if ((paramInlineCalls.length != 2) || (!(paramInlineCalls[1] instanceof QuoteExp))) {}
    while (!(((QuoteExp)paramInlineCalls[1]).getValue() instanceof XDataType)) {
      return paramApplyExp;
    }
    return new ApplyExp(castableMethod, new Expression[] { paramInlineCalls[1], paramInlineCalls[0] });
  }
  
  public static Expression validateApplyOrderedMap(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramInlineCalls = paramApplyExp.getArgs();
    if (paramInlineCalls.length > 2)
    {
      paramApplyExp = new Expression[paramInlineCalls.length - 1];
      System.arraycopy(paramInlineCalls, 1, paramApplyExp, 0, paramApplyExp.length);
      paramType = typeTuples.getDeclaredMethod("make$V", 2);
      paramApplyExp = new ApplyExp(paramProcedure, new Expression[] { paramInlineCalls[0], new ApplyExp(paramType, paramApplyExp) });
    }
    return paramApplyExp;
  }
  
  public static Expression validateApplyRelativeStep(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramType = paramApplyExp.getArgs();
    Object localObject3 = paramType[0];
    paramProcedure = paramType[1];
    paramType = paramInlineCalls.getCompilation();
    LambdaExp localLambdaExp;
    if (((paramProcedure instanceof LambdaExp)) && (paramType.mustCompile))
    {
      localLambdaExp = (LambdaExp)paramProcedure;
      if ((localLambdaExp.min_args == 3) && (localLambdaExp.max_args == 3)) {}
    }
    else
    {
      paramProcedure = paramApplyExp;
    }
    Object localObject1;
    Object localObject2;
    label402:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return paramProcedure;
                    localLambdaExp.setInlineOnly(true);
                    localLambdaExp.returnContinuation = paramApplyExp;
                    localLambdaExp.inlineHome = paramInlineCalls.getCurrentLambda();
                    localObject1 = localLambdaExp.body;
                    localObject2 = localLambdaExp.firstDecl().nextDecl();
                    paramProcedure = ((Declaration)localObject2).nextDecl();
                    ((Declaration)localObject2).setNext(paramProcedure.nextDecl());
                    paramProcedure.setNext(null);
                    localLambdaExp.min_args = 2;
                    localLambdaExp.max_args = 2;
                    localObject2 = ((Expression)localObject3).getType();
                    if ((localObject2 != null) && (NodeType.anyNodeTest.compare((Type)localObject2) == -3))
                    {
                      paramApplyExp = paramInlineCalls.getCompilation().getLanguage();
                      paramApplyExp = "step input is " + paramApplyExp.formatType((Type)localObject2) + " - not a node sequence";
                      paramInlineCalls.getMessages().error('e', paramApplyExp);
                      return new ErrorExp(paramApplyExp);
                    }
                    paramInlineCalls = paramApplyExp.getTypeRaw();
                    if ((paramInlineCalls == null) || (paramInlineCalls == Type.pointer_type))
                    {
                      paramInlineCalls = OccurrenceType.itemPrimeType(((Expression)localObject1).getType());
                      if (NodeType.anyNodeTest.compare(paramInlineCalls) < 0) {
                        break label402;
                      }
                    }
                    for (paramInlineCalls = NodeSetType.getInstance(paramInlineCalls);; paramInlineCalls = OccurrenceType.getInstance(paramInlineCalls, 0, -1))
                    {
                      paramApplyExp.setType(paramInlineCalls);
                      if (!paramProcedure.getCanRead()) {
                        break;
                      }
                      paramInlineCalls = CoerceNodes.typeNodes;
                      paramType.letStart();
                      localObject1 = paramType.letVariable(null, paramInlineCalls, new ApplyExp(CoerceNodes.coerceNodes, new Expression[] { localObject3 }));
                      paramType.letEnter();
                      paramInlineCalls = new LetExp(new Expression[] { new ApplyExp(paramInlineCalls.getDeclaredMethod("size", 0), new Expression[] { new ReferenceExp((Declaration)localObject1) }) });
                      paramInlineCalls.addDeclaration(paramProcedure);
                      paramInlineCalls.body = new ApplyExp(paramApplyExp.getFunction(), new Expression[] { new ReferenceExp((Declaration)localObject1), localLambdaExp });
                      return paramType.letDone(paramInlineCalls);
                    }
                    paramProcedure = paramApplyExp;
                    paramType = (Type)localObject1;
                    paramInlineCalls = paramProcedure;
                    if ((localObject1 instanceof ApplyExp))
                    {
                      localObject2 = (ApplyExp)localObject1;
                      paramType = (Type)localObject1;
                      paramInlineCalls = paramProcedure;
                      if ((((ApplyExp)localObject2).getFunction().valueIfConstant() instanceof ValuesFilter))
                      {
                        Object localObject4 = localObject2.getArgs()[1];
                        paramType = (Type)localObject1;
                        paramInlineCalls = paramProcedure;
                        if ((localObject4 instanceof LambdaExp))
                        {
                          localObject4 = (LambdaExp)localObject4;
                          Declaration localDeclaration = ((LambdaExp)localObject4).firstDecl();
                          paramType = (Type)localObject1;
                          paramInlineCalls = paramProcedure;
                          if (localDeclaration != null)
                          {
                            localDeclaration = localDeclaration.nextDecl();
                            paramType = (Type)localObject1;
                            paramInlineCalls = paramProcedure;
                            if (localDeclaration != null)
                            {
                              paramType = (Type)localObject1;
                              paramInlineCalls = paramProcedure;
                              if (localDeclaration.nextDecl() == null)
                              {
                                paramType = (Type)localObject1;
                                paramInlineCalls = paramProcedure;
                                if (!localDeclaration.getCanRead())
                                {
                                  paramType = (Type)localObject1;
                                  paramInlineCalls = paramProcedure;
                                  if (ClassType.make("java.lang.Number").compare(((LambdaExp)localObject4).body.getType()) == -3)
                                  {
                                    paramType = ((ApplyExp)localObject2).getArg(0);
                                    localLambdaExp.body = paramType;
                                    ((ApplyExp)localObject2).setArg(0, paramApplyExp);
                                    paramInlineCalls = (InlineCalls)localObject2;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramProcedure = paramInlineCalls;
                  } while (!(localObject3 instanceof ApplyExp));
                  paramProcedure = paramInlineCalls;
                } while (!(paramType instanceof ApplyExp));
                localObject1 = (ApplyExp)localObject3;
                paramType = (ApplyExp)paramType;
                localObject3 = ((ApplyExp)localObject1).getFunction().valueIfConstant();
                localObject2 = paramType.getFunction().valueIfConstant();
                paramProcedure = paramInlineCalls;
              } while (localObject3 != RelativeStep.relativeStep);
              paramProcedure = paramInlineCalls;
            } while (!(localObject2 instanceof ChildAxis));
            paramProcedure = paramInlineCalls;
          } while (((ApplyExp)localObject1).getArgCount() != 2);
          localObject3 = ((ApplyExp)localObject1).getArg(1);
          paramProcedure = paramInlineCalls;
        } while (!(localObject3 instanceof LambdaExp));
        localObject3 = (LambdaExp)localObject3;
        paramProcedure = paramInlineCalls;
      } while (!(((LambdaExp)localObject3).body instanceof ApplyExp));
      paramProcedure = paramInlineCalls;
    } while (((ApplyExp)((LambdaExp)localObject3).body).getFunction().valueIfConstant() != DescendantOrSelfAxis.anyNode);
    paramApplyExp.setArg(0, ((ApplyExp)localObject1).getArg(0));
    paramType.setFunction(new QuoteExp(DescendantAxis.make(((ChildAxis)localObject2).getNodePredicate())));
    return paramInlineCalls;
  }
  
  public static Expression validateApplyValuesFilter(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Object localObject2 = (ValuesFilter)paramProcedure;
    paramApplyExp.visitArgs(paramInlineCalls);
    paramProcedure = paramApplyExp.getArgs();
    Object localObject1 = paramProcedure[1];
    LambdaExp localLambdaExp;
    if ((localObject1 instanceof LambdaExp))
    {
      localLambdaExp = (LambdaExp)localObject1;
      if ((localLambdaExp.min_args == 3) && (localLambdaExp.max_args == 3)) {
        break label56;
      }
    }
    label56:
    Compilation localCompilation;
    Declaration localDeclaration2;
    Declaration localDeclaration3;
    Declaration localDeclaration1;
    do
    {
      return paramApplyExp;
      paramApplyExp.setType(paramProcedure[0].getType());
      localCompilation = paramInlineCalls.getCompilation();
      localDeclaration2 = localLambdaExp.firstDecl();
      localDeclaration3 = localDeclaration2.nextDecl();
      localDeclaration1 = localDeclaration3.nextDecl();
      localLambdaExp.setInlineOnly(true);
      localLambdaExp.returnContinuation = paramApplyExp;
      localLambdaExp.inlineHome = paramInlineCalls.getCurrentLambda();
      localLambdaExp.remove(localDeclaration3, localDeclaration1);
      localLambdaExp.min_args = 2;
      localLambdaExp.max_args = 2;
    } while ((!localDeclaration1.getCanRead()) && (((ValuesFilter)localObject2).kind != 'R'));
    localCompilation.letStart();
    paramApplyExp = paramProcedure[0];
    if (((ValuesFilter)localObject2).kind == 'P') {
      localObject1 = paramApplyExp.getType();
    }
    for (paramProcedure = Compilation.typeValues.getDeclaredMethod("countValues", 1);; paramProcedure = CoerceNodes.typeNodes.getDeclaredMethod("size", 0))
    {
      Declaration localDeclaration4 = localCompilation.letVariable("sequence", (Type)localObject1, paramApplyExp);
      localCompilation.letEnter();
      localObject1 = localLambdaExp.body;
      paramApplyExp = (ApplyExp)localObject1;
      if (localLambdaExp.body.getType() != XDataType.booleanType) {
        paramApplyExp = new ApplyExp(ValuesFilter.matchesMethod, new Expression[] { localObject1, new ReferenceExp(localDeclaration3) });
      }
      localObject1 = paramApplyExp;
      if (((ValuesFilter)localObject2).kind == 'R')
      {
        localObject2 = new Declaration(null, Type.intType);
        localObject1 = new ApplyExp(AddOp.$Mn, new Expression[] { new ReferenceExp(localDeclaration1), new ReferenceExp((Declaration)localObject2) });
        localObject1 = new LetExp(new Expression[] { new ApplyExp(AddOp.$Pl, new Expression[] { localObject1, new QuoteExp(IntNum.one()) }) });
        localLambdaExp.replaceFollowing(localDeclaration2, (Declaration)localObject2);
        ((LetExp)localObject1).add(localDeclaration3);
        ((LetExp)localObject1).body = paramApplyExp;
      }
      localLambdaExp.body = new IfExp((Expression)localObject1, new ReferenceExp(localDeclaration2), QuoteExp.voidExp);
      paramApplyExp = new ApplyExp(ValuesMap.valuesMapWithPos, new Expression[] { localLambdaExp, new ReferenceExp(localDeclaration4) });
      paramApplyExp.setType(localDeclaration2.getType());
      localLambdaExp.returnContinuation = paramApplyExp;
      paramProcedure = new LetExp(new Expression[] { new ApplyExp(paramProcedure, new Expression[] { new ReferenceExp(localDeclaration4) }) });
      paramProcedure.add(localDeclaration1);
      paramProcedure.body = gnu.kawa.functions.CompileMisc.validateApplyValuesMap(paramApplyExp, paramInlineCalls, paramType, ValuesMap.valuesMapWithPos);
      return localCompilation.letDone(paramProcedure);
      localObject1 = SortNodes.typeSortedNodes;
      paramApplyExp = new ApplyExp(SortNodes.sortNodes, new Expression[] { paramApplyExp });
    }
  }
  
  public static Expression validateArithOp(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }
  
  public static Expression validateBooleanValue(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramType = paramApplyExp.getArgs();
    if (paramType.length == 1)
    {
      paramType = paramType[0];
      paramProcedure = paramType.getType();
      if (paramProcedure == XDataType.booleanType) {
        return paramType;
      }
      if (paramProcedure == null) {
        paramApplyExp.setType(XDataType.booleanType);
      }
      if ((paramType instanceof QuoteExp))
      {
        paramApplyExp = ((QuoteExp)paramType).getValue();
        try
        {
          if (BooleanValue.booleanValue(paramApplyExp)) {
            paramApplyExp = XQuery.trueExp;
          } else {
            paramApplyExp = XQuery.falseExp;
          }
        }
        catch (Throwable paramApplyExp)
        {
          paramInlineCalls.getMessages().error('e', "cannot convert to a boolean");
          return new ErrorExp("cannot convert to a boolean");
        }
      }
    }
    return paramApplyExp;
    return paramApplyExp;
  }
  
  public static Expression validateCompare(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramInlineCalls = paramApplyExp.inlineIfConstant(paramProcedure, paramInlineCalls);
    if (paramInlineCalls != paramApplyExp) {
      return paramInlineCalls;
    }
    paramInlineCalls = (Compare)paramProcedure;
    if ((paramInlineCalls.flags & 0x20) != 0) {}
    for (;;)
    {
      if (paramApplyExp.getTypeRaw() == null) {
        paramApplyExp.setType(XDataType.booleanType);
      }
      return paramApplyExp;
      paramApplyExp = new ApplyExp(ClassType.make("gnu.xquery.util.Compare").getDeclaredMethod("apply", 4), new Expression[] { new QuoteExp(IntNum.make(paramInlineCalls.flags)), paramApplyExp.getArg(0), paramApplyExp.getArg(1), QuoteExp.nullExp });
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\CompileMisc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */