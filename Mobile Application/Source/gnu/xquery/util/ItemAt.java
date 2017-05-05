package gnu.xquery.util;

import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class ItemAt
  extends Procedure2
{
  public static final ItemAt itemAt = new ItemAt();
  
  public static Object itemAt(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Values))
    {
      paramObject = (Values)paramObject;
      if (((Values)paramObject).isEmpty()) {
        paramObject = Values.empty;
      }
    }
    while (paramInt == 1)
    {
      return paramObject;
      return ((Values)paramObject).get(paramInt - 1);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return itemAt(paramObject1, ((Number)paramObject2).intValue());
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\ItemAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */