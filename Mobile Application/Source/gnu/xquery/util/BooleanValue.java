package gnu.xquery.util;

import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.text.Path;

public class BooleanValue
  extends Procedure1
{
  public static final BooleanValue booleanValue = new BooleanValue("boolean-value");
  
  public BooleanValue(String paramString)
  {
    super(paramString);
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateBooleanValue");
  }
  
  public static boolean booleanValue(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject instanceof Boolean)) {
      bool1 = ((Boolean)paramObject).booleanValue();
    }
    label67:
    Object localObject;
    do
    {
      do
      {
        do
        {
          double d;
          do
          {
            return bool1;
            if ((!(paramObject instanceof Number)) || ((!(paramObject instanceof RealNum)) && ((paramObject instanceof Numeric)))) {
              break label67;
            }
            d = ((Number)paramObject).doubleValue();
            if (d == 0.0D) {
              break;
            }
            bool1 = bool2;
          } while (!Double.isNaN(d));
          return false;
          bool1 = bool2;
        } while ((paramObject instanceof SeqPosition));
        if ((!(paramObject instanceof String)) && (!(paramObject instanceof Path)) && (!(paramObject instanceof UntypedAtomic))) {
          break;
        }
        bool1 = bool2;
      } while (paramObject.toString().length() > 0);
      return false;
      if (!(paramObject instanceof Values)) {
        break;
      }
      Values localValues = (Values)paramObject;
      localObject = localValues.getPosNext(0);
      if (localObject == Sequence.eofValue) {
        return false;
      }
      if (localValues.nextDataIndex(0) < 0) {
        return booleanValue(localObject);
      }
      bool1 = bool2;
    } while ((localObject instanceof SeqPosition));
    throw new WrongType("fn:boolean", 1, paramObject, "boolean-convertible-value");
  }
  
  public static boolean not(Object paramObject)
  {
    return !booleanValue(paramObject);
  }
  
  public Object apply1(Object paramObject)
  {
    if (booleanValue(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\BooleanValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */