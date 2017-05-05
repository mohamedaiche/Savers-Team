package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Target;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class CastAs
  extends Convert
{
  public static final CastAs castAs = new CastAs();
  
  public CastAs()
  {
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastAs");
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = (Type)paramObject1;
    if ((localObject1 instanceof XDataType)) {
      localObject1 = ((XDataType)localObject1).cast(paramObject2);
    }
    Type localType;
    int k;
    int m;
    do
    {
      return localObject1;
      if (!(localObject1 instanceof OccurrenceType)) {
        break label243;
      }
      localObject1 = (OccurrenceType)localObject1;
      localType = ((OccurrenceType)localObject1).getBase();
      if (!(localType instanceof XDataType)) {
        break label243;
      }
      k = ((OccurrenceType)localObject1).minOccurs();
      m = ((OccurrenceType)localObject1).maxOccurs();
      if (!(paramObject2 instanceof Values)) {
        break label186;
      }
      if (paramObject2 != Values.empty) {
        break;
      }
      localObject1 = paramObject2;
    } while (k == 0);
    localObject1 = (Values)paramObject2;
    int j = ((Values)localObject1).startPos();
    int i = 0;
    Values localValues = new Values();
    for (;;)
    {
      j = ((Values)localObject1).nextPos(j);
      if (j == 0)
      {
        if ((i < k) || ((m >= 0) && (i > m))) {
          break;
        }
        return localValues.canonicalize();
      }
      Object localObject2 = ((Values)localObject1).getPosPrevious(j);
      localValues.writeObject(((XDataType)localType).cast(localObject2));
      i += 1;
    }
    label186:
    if ((k <= 1) && (m != 0)) {
      return ((XDataType)localType).cast(paramObject2);
    }
    throw new ClassCastException("cannot cast " + paramObject2 + " to " + paramObject1);
    label243:
    return super.apply2(paramObject1, paramObject2);
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\CastAs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */