package gnu.xquery.util;

import gnu.kawa.util.GeneralHashTable;
import gnu.math.Numeric;
import gnu.math.RealNum;

class DistinctValuesHashTable
  extends GeneralHashTable
{
  NamedCollator collator;
  
  public DistinctValuesHashTable(NamedCollator paramNamedCollator)
  {
    this.collator = paramNamedCollator;
  }
  
  public int hash(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      if ((!(paramObject instanceof Number)) || ((!(paramObject instanceof RealNum)) && ((paramObject instanceof Numeric)))) {
        break;
      }
      j = Float.floatToIntBits(((Number)paramObject).floatValue());
      i = j;
    } while (j != Integer.MIN_VALUE);
    return 0;
    return paramObject.hashCode();
  }
  
  public boolean matches(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    while ((NumberValue.isNaN(paramObject1)) && (NumberValue.isNaN(paramObject2))) {
      return true;
    }
    return Compare.apply(72, paramObject1, paramObject2, this.collator);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\DistinctValuesHashTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */