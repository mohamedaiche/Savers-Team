package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.lists.Sequence;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.xml.TextUtils;

public class MinMax
{
  static Object convert(Object paramObject)
  {
    Object localObject = KNode.atomicValue(paramObject);
    paramObject = localObject;
    if ((localObject instanceof UntypedAtomic)) {
      paramObject = (Double)XDataType.doubleType.valueOf(TextUtils.stringValue(localObject));
    }
    return paramObject;
  }
  
  public static Object max(Object paramObject, NamedCollator paramNamedCollator)
  {
    return minMax(paramObject, true, paramNamedCollator);
  }
  
  public static Object min(Object paramObject, NamedCollator paramNamedCollator)
  {
    return minMax(paramObject, false, paramNamedCollator);
  }
  
  public static Object minMax(Object paramObject, boolean paramBoolean, NamedCollator paramNamedCollator)
  {
    int j = 16;
    if ((paramObject instanceof Values))
    {
      TreeList localTreeList = (TreeList)paramObject;
      int m = 0;
      if (paramBoolean) {}
      Object localObject1;
      for (;;)
      {
        paramObject = localTreeList.getPosNext(0);
        if (paramObject != Sequence.eofValue) {
          break;
        }
        localObject1 = Values.empty;
        return localObject1;
        j = 4;
      }
      paramObject = convert(paramObject);
      for (;;)
      {
        int n = localTreeList.nextPos(m);
        Object localObject2 = localTreeList.getPosNext(n);
        localObject1 = paramObject;
        if (localObject2 == Sequence.eofValue) {
          break;
        }
        localObject1 = convert(localObject2);
        if (((paramObject instanceof Number)) || ((localObject1 instanceof Number)))
        {
          int i = Arithmetic.classifyValue(paramObject);
          m = Arithmetic.classifyValue(localObject1);
          int i1 = NumberCompare.compare(paramObject, i, localObject1, m, false);
          if (i1 == -3) {
            throw new IllegalArgumentException("values cannot be compared");
          }
          if (i < m) {}
          for (int k = m;; k = i)
          {
            if (i1 != -2) {
              break label205;
            }
            localObject1 = NumberValue.NaN;
            i = 1;
            m = n;
            paramObject = localObject1;
            if (i == 0) {
              break;
            }
            paramObject = Arithmetic.convert(localObject1, k);
            m = n;
            break;
          }
          label205:
          if (!NumberCompare.checkCompareCode(i1, j))
          {
            if (k != m) {}
            for (i = 1;; i = 0) {
              break;
            }
          }
          if (k != i) {}
          for (i = 1;; i = 0)
          {
            localObject1 = paramObject;
            break;
          }
        }
        m = n;
        if (!Compare.atomicCompare(j, paramObject, localObject1, paramNamedCollator))
        {
          paramObject = localObject1;
          m = n;
        }
      }
    }
    paramObject = convert(paramObject);
    Compare.atomicCompare(16, paramObject, paramObject, paramNamedCollator);
    return paramObject;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\MinMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */