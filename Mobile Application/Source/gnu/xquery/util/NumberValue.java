package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.xml.TextUtils;
import java.math.BigDecimal;

public class NumberValue
  extends Procedure1
{
  public static final Double NaN = new Double(NaN.0D);
  public static final NumberValue numberValue = new NumberValue();
  
  public static Object abs(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {}
    int i;
    do
    {
      long l;
      do
      {
        return paramObject;
        paramObject = numberCast(paramObject);
        if (!(paramObject instanceof Double)) {
          break;
        }
        paramObject = (Double)paramObject;
        l = Double.doubleToRawLongBits(((Double)paramObject).doubleValue());
      } while (l >= 0L);
      return Double.valueOf(Double.longBitsToDouble(l & 0x7FFFFFFFFFFFFFFF));
      if (!(paramObject instanceof Float)) {
        break;
      }
      paramObject = (Float)paramObject;
      i = Float.floatToRawIntBits(((Float)paramObject).floatValue());
    } while (i >= 0);
    return Float.valueOf(Float.intBitsToFloat(i & 0x7FFFFFFF));
    if ((paramObject instanceof BigDecimal))
    {
      BigDecimal localBigDecimal = (BigDecimal)paramObject;
      paramObject = localBigDecimal;
      if (localBigDecimal.signum() < 0) {
        paramObject = localBigDecimal.negate();
      }
      return paramObject;
    }
    return ((Numeric)paramObject).abs();
  }
  
  public static Object ceiling(Object paramObject)
  {
    Number localNumber = numberCast(paramObject);
    if (localNumber == null) {
      return paramObject;
    }
    if ((localNumber instanceof Double)) {
      return XDataType.makeDouble(Math.ceil(((Double)localNumber).doubleValue()));
    }
    if ((localNumber instanceof Float)) {
      return XDataType.makeFloat((float)Math.ceil(((Float)localNumber).floatValue()));
    }
    if ((localNumber instanceof BigDecimal)) {
      return Arithmetic.asIntNum(((BigDecimal)localNumber).divide(XDataType.DECIMAL_ONE, 0, 2).toBigInteger());
    }
    return ((RealNum)localNumber).toInt(2);
  }
  
  public static Object floor(Object paramObject)
  {
    Number localNumber = numberCast(paramObject);
    if (localNumber == null) {
      return paramObject;
    }
    if ((localNumber instanceof Double)) {
      return XDataType.makeDouble(Math.floor(((Double)localNumber).doubleValue()));
    }
    if ((localNumber instanceof Float)) {
      return XDataType.makeFloat((float)Math.floor(((Float)localNumber).floatValue()));
    }
    if ((localNumber instanceof BigDecimal)) {
      return Arithmetic.asIntNum(((BigDecimal)localNumber).divide(XDataType.DECIMAL_ONE, 0, 3).toBigInteger());
    }
    return ((RealNum)localNumber).toInt(1);
  }
  
  public static boolean isNaN(Object paramObject)
  {
    return (((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof DFloNum))) && (Double.isNaN(((Number)paramObject).doubleValue()));
  }
  
  public static Number numberCast(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return null;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof Values))
    {
      Values localValues = (Values)paramObject;
      int j = localValues.startPos();
      int i = 0;
      for (;;)
      {
        j = localValues.nextPos(j);
        localObject = paramObject;
        if (j == 0) {
          break;
        }
        if (i > 0) {
          throw new ClassCastException("non-singleton sequence cast to number");
        }
        paramObject = localValues.getPosPrevious(j);
        i += 1;
      }
    }
    if (((localObject instanceof KNode)) || ((localObject instanceof UntypedAtomic))) {
      return (Double)XDataType.doubleType.valueOf(TextUtils.stringValue(localObject));
    }
    return (Number)localObject;
  }
  
  public static Object numberValue(Object paramObject)
  {
    paramObject = KNode.atomicValue(paramObject);
    double d;
    if (((paramObject instanceof UntypedAtomic)) || ((paramObject instanceof String))) {
      try
      {
        paramObject = XDataType.doubleType.valueOf(TextUtils.stringValue(paramObject));
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        d = NaN.0D;
      }
    }
    for (;;)
    {
      return XDataType.makeDouble(d);
      if (((paramObject instanceof Number)) && (((paramObject instanceof RealNum)) || (!(paramObject instanceof Numeric)))) {
        d = ((Number)paramObject).doubleValue();
      } else {
        d = NaN.0D;
      }
    }
  }
  
  public static Object round(Object paramObject)
  {
    int i = 4;
    Number localNumber = numberCast(paramObject);
    if (localNumber == null) {
      return paramObject;
    }
    if ((localNumber instanceof Double))
    {
      double d = ((Double)localNumber).doubleValue();
      if ((d >= -0.5D) && (d <= 0.0D) && ((d < 0.0D) || (Double.doubleToLongBits(d) < 0L))) {}
      for (d = 0.0D;; d = Math.floor(d + 0.5D)) {
        return XDataType.makeDouble(d);
      }
    }
    if ((localNumber instanceof Float))
    {
      float f = ((Float)localNumber).floatValue();
      if ((f >= -0.5D) && (f <= 0.0D) && ((f < 0.0D) || (Float.floatToIntBits(f) < 0))) {}
      for (f = 0.0F;; f = (float)Math.floor(f + 0.5D)) {
        return XDataType.makeFloat(f);
      }
    }
    if ((localNumber instanceof BigDecimal))
    {
      paramObject = (BigDecimal)localNumber;
      if (((BigDecimal)paramObject).signum() >= 0) {}
      for (;;)
      {
        return Arithmetic.asIntNum(((BigDecimal)paramObject).divide(XDataType.DECIMAL_ONE, 0, i).toBigInteger());
        i = 5;
      }
    }
    return ((RealNum)localNumber).toInt(4);
  }
  
  public static Object roundHalfToEven(Object paramObject)
  {
    return roundHalfToEven(paramObject, IntNum.zero());
  }
  
  public static Object roundHalfToEven(Object paramObject, IntNum paramIntNum)
  {
    Number localNumber = numberCast(paramObject);
    if (localNumber == null) {}
    double d;
    do
    {
      return paramObject;
      if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float))) {
        break;
      }
      d = ((Number)paramObject).doubleValue();
    } while ((d == 0.0D) || (Double.isInfinite(d)) || (Double.isNaN(d)));
    paramObject = ((BigDecimal)XDataType.decimalType.cast(localNumber)).setScale(paramIntNum.intValue(), 6);
    if ((localNumber instanceof Double)) {
      return XDataType.makeDouble(((BigDecimal)paramObject).doubleValue());
    }
    if ((localNumber instanceof Float)) {
      return XDataType.makeFloat(((BigDecimal)paramObject).floatValue());
    }
    if ((localNumber instanceof IntNum)) {
      return XIntegerType.integerType.cast(paramObject);
    }
    return paramObject;
  }
  
  public Object apply1(Object paramObject)
  {
    if ((paramObject != Values.empty) && (paramObject != null)) {
      try
      {
        paramObject = numberValue(paramObject);
        return paramObject;
      }
      catch (Throwable paramObject) {}
    }
    return NaN;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\NumberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */