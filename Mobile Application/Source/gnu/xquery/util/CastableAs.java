package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.xquery.lang.XQuery;

public class CastableAs
  extends InstanceOf
{
  public static CastableAs castableAs = new CastableAs();
  
  CastableAs()
  {
    super(XQuery.getInstance(), "castable as");
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastableAs");
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    paramObject2 = this.language.asType(paramObject2);
    if ((paramObject2 instanceof XDataType)) {}
    for (boolean bool = ((XDataType)paramObject2).castable(paramObject1);; bool = ((Type)paramObject2).isInstance(paramObject1)) {
      return this.language.booleanObject(bool);
    }
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\CastableAs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */