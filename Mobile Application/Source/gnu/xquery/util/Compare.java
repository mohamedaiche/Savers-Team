package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XTimeType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.DateTime;
import gnu.math.Duration;
import gnu.math.Unit;

public class Compare
  extends Procedure2
{
  public static final Compare $Eq = make("=", 8);
  public static final Compare $Ex$Eq = make("!=", 23);
  public static final Compare $Gr = make(">", 16);
  public static final Compare $Gr$Eq = make(">=", 24);
  public static final Compare $Ls = make("<", 4);
  public static final Compare $Ls$Eq = make("<=", 12);
  static final int LENIENT_COMPARISON = 64;
  static final int LENIENT_EQ = 72;
  static final int RESULT_EQU = 0;
  static final int RESULT_GRT = 1;
  static final int RESULT_LSS = -1;
  static final int RESULT_NAN = -2;
  static final int RESULT_NEQ = -3;
  static final int TRUE_IF_EQU = 8;
  static final int TRUE_IF_GRT = 16;
  static final int TRUE_IF_LSS = 4;
  static final int TRUE_IF_NAN = 2;
  static final int TRUE_IF_NEQ = 1;
  static final int VALUE_COMPARISON = 32;
  public static final Compare valEq = make("eq", 40);
  public static final Compare valGe;
  public static final Compare valGt;
  public static final Compare valLe = make("le", 44);
  public static final Compare valLt;
  public static final Compare valNe = make("ne", 55);
  int flags;
  
  static
  {
    valGt = make("gt", 48);
    valGe = make("ge", 56);
    valLt = make("lt", 36);
  }
  
  public static boolean apply(int paramInt, Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator)
  {
    int i;
    int j;
    if ((paramObject1 instanceof Values))
    {
      paramObject1 = (Values)paramObject1;
      for (i = 0;; i = j)
      {
        j = ((Values)paramObject1).nextDataIndex(i);
        if (j < 0) {
          return false;
        }
        if (apply(paramInt, ((Values)paramObject1).getPosNext(i << 1), paramObject2, paramNamedCollator)) {
          return true;
        }
      }
    }
    if ((paramObject2 instanceof Values))
    {
      paramObject2 = (Values)paramObject2;
      for (i = 0;; i = j)
      {
        j = ((Values)paramObject2).nextDataIndex(i);
        if (j < 0) {
          break;
        }
        if (apply(paramInt, paramObject1, ((Values)paramObject2).getPosNext(i << 1), paramNamedCollator)) {
          return true;
        }
      }
    }
    return atomicCompare(paramInt, KNode.atomicValue(paramObject1), KNode.atomicValue(paramObject2), paramNamedCollator);
  }
  
  public static boolean atomicCompare(int paramInt, Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator)
  {
    Object localObject = paramObject1;
    label46:
    int i;
    if ((paramObject1 instanceof UntypedAtomic))
    {
      paramObject1 = paramObject1.toString();
      if ((paramInt & 0x20) != 0) {
        localObject = paramObject1;
      }
    }
    else
    {
      paramObject1 = paramObject2;
      if ((paramObject2 instanceof UntypedAtomic))
      {
        paramObject1 = paramObject2.toString();
        if ((paramInt & 0x20) == 0) {
          break label195;
        }
      }
      if ((!(localObject instanceof Number)) && (!(paramObject1 instanceof Number))) {
        break label481;
      }
      if (!(localObject instanceof Duration)) {
        break label341;
      }
      if ((paramObject1 instanceof Duration)) {
        break label285;
      }
      i = -3;
    }
    for (;;)
    {
      if ((i != -3) || ((paramInt & 0x40) != 0)) {
        break label474;
      }
      throw new IllegalArgumentException("values cannot be compared");
      if ((paramObject2 instanceof DateTime))
      {
        localObject = XTimeType.parseDateTime((String)paramObject1, ((DateTime)paramObject2).components());
        break;
      }
      if ((paramObject2 instanceof Duration))
      {
        localObject = Duration.parse((String)paramObject1, ((Duration)paramObject2).unit());
        break;
      }
      if ((paramObject2 instanceof Number))
      {
        localObject = new DFloNum((String)paramObject1);
        break;
      }
      if ((paramObject2 instanceof Boolean))
      {
        localObject = XDataType.booleanType.valueOf((String)paramObject1);
        break;
      }
      localObject = paramObject1;
      break;
      label195:
      if ((localObject instanceof DateTime))
      {
        paramObject1 = XTimeType.parseDateTime((String)paramObject1, ((DateTime)localObject).components());
        break label46;
      }
      if ((localObject instanceof Duration))
      {
        paramObject1 = Duration.parse((String)paramObject1, ((Duration)localObject).unit());
        break label46;
      }
      if ((localObject instanceof Number))
      {
        paramObject1 = new DFloNum((String)paramObject1);
        break label46;
      }
      if ((localObject instanceof Boolean))
      {
        paramObject1 = XDataType.booleanType.valueOf((String)paramObject1);
        break label46;
      }
      break label46;
      label285:
      paramObject2 = (Duration)localObject;
      paramObject1 = (Duration)paramObject1;
      if (((((Duration)paramObject2).unit != ((Duration)paramObject1).unit) || (((Duration)paramObject2).unit == Unit.duration)) && (!equalityComparison(paramInt)))
      {
        i = -3;
      }
      else
      {
        i = Duration.compare((Duration)paramObject2, (Duration)paramObject1);
        continue;
        label341:
        if ((localObject instanceof DateTime))
        {
          if (!(paramObject1 instanceof DateTime))
          {
            i = -3;
          }
          else
          {
            paramObject2 = (DateTime)localObject;
            paramObject1 = (DateTime)paramObject1;
            i = ((DateTime)paramObject2).components();
            if (i != ((DateTime)paramObject1).components()) {
              i = -3;
            } else if ((!equalityComparison(paramInt)) && (i != 112) && (i != 14) && (i != 126)) {
              i = -3;
            } else {
              i = DateTime.compare((DateTime)paramObject2, (DateTime)paramObject1);
            }
          }
        }
        else if (((paramObject1 instanceof Duration)) || ((paramObject1 instanceof DateTime))) {
          i = -3;
        } else {
          i = NumberCompare.compare(localObject, paramObject1, false);
        }
      }
    }
    label474:
    return NumberCompare.checkCompareCode(i, paramInt);
    label481:
    if ((localObject instanceof Symbol)) {
      if (((paramObject1 instanceof Symbol)) && (equalityComparison(paramInt))) {
        if (localObject.equals(paramObject1)) {
          i = 0;
        }
      }
    }
    while ((i == -3) && ((paramInt & 0x40) == 0))
    {
      throw new IllegalArgumentException("values cannot be compared");
      i = -2;
      continue;
      i = -3;
      continue;
      if ((localObject instanceof Boolean))
      {
        if ((paramObject1 instanceof Boolean))
        {
          boolean bool1 = ((Boolean)localObject).booleanValue();
          boolean bool2 = ((Boolean)paramObject1).booleanValue();
          if (bool1 == bool2) {
            i = 0;
          }
          for (;;)
          {
            break;
            if (bool2) {
              i = -1;
            } else {
              i = 1;
            }
          }
        }
        i = -3;
      }
      else if (((paramObject1 instanceof Boolean)) || ((paramObject1 instanceof Symbol)))
      {
        i = -3;
      }
      else
      {
        paramObject2 = localObject.toString();
        paramObject1 = paramObject1.toString();
        if (paramNamedCollator != null)
        {
          i = paramNamedCollator.compare((String)paramObject2, (String)paramObject1);
          label668:
          if (i >= 0) {
            break label689;
          }
          i = -1;
        }
        for (;;)
        {
          break;
          i = NamedCollator.codepointCompare((String)paramObject2, (String)paramObject1);
          break label668;
          label689:
          if (i > 0) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
    return NumberCompare.checkCompareCode(i, paramInt);
  }
  
  public static boolean equalityComparison(int paramInt)
  {
    int i;
    if ((paramInt & 0x10) != 0)
    {
      i = 1;
      if ((paramInt & 0x4) == 0) {
        break label29;
      }
    }
    label29:
    for (paramInt = 1;; paramInt = 0)
    {
      if (i != paramInt) {
        break label34;
      }
      return true;
      i = 0;
      break;
    }
    label34:
    return false;
  }
  
  public static Compare make(String paramString, int paramInt)
  {
    Compare localCompare = new Compare();
    localCompare.setName(paramString);
    localCompare.setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateCompare");
    localCompare.flags = paramInt;
    return localCompare;
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    if ((this.flags & 0x20) != 0)
    {
      if ((paramObject1 == null) || (paramObject1 == Values.empty)) {
        return paramObject1;
      }
      if ((paramObject2 == null) || (paramObject2 == Values.empty)) {
        return paramObject2;
      }
      if (atomicCompare(this.flags, KNode.atomicValue(paramObject1), KNode.atomicValue(paramObject2), null)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    if (apply(this.flags, paramObject1, paramObject2, null)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\Compare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */