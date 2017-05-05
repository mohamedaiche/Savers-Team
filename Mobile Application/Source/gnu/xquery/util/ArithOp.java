package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1or2;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import gnu.math.Unit;
import gnu.xml.TextUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class ArithOp
  extends Procedure1or2
  implements Inlineable
{
  static final BigInteger TEN = BigInteger.valueOf(10L);
  public static final ArithOp add = new ArithOp("+", '+', 2);
  public static final ArithOp div;
  public static final ArithOp idiv;
  public static final ArithOp minus = new ArithOp("-", 'M', 1);
  public static final ArithOp mod;
  public static final ArithOp mul;
  public static final ArithOp plus;
  public static final ArithOp sub = new ArithOp("-", '-', 2);
  char op;
  
  static
  {
    mul = new ArithOp("*", '*', 2);
    div = new ArithOp("div", 'd', 2);
    idiv = new ArithOp("idiv", 'i', 2);
    mod = new ArithOp("mod", 'm', 2);
    plus = new ArithOp("+", 'P', 1);
  }
  
  ArithOp(String paramString, char paramChar, int paramInt)
  {
    super(paramString);
    setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateArithOp");
    this.op = paramChar;
  }
  
  public static BigDecimal div(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    return paramBigDecimal1.divide(paramBigDecimal2, MathContext.DECIMAL128);
  }
  
  public Object apply1(Object paramObject)
    throws Throwable
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramObject;
    }
    Object localObject;
    if (!(paramObject instanceof KNode))
    {
      localObject = paramObject;
      if (!(paramObject instanceof UntypedAtomic)) {}
    }
    else
    {
      localObject = XDataType.doubleType.valueOf(TextUtils.stringValue(paramObject));
    }
    switch (this.op)
    {
    case 'N': 
    case 'O': 
    default: 
      throw new UnsupportedOperationException(getName());
    case 'P': 
      return AddOp.apply2(1, IntNum.zero(), localObject);
    }
    switch (Arithmetic.classifyValue(localObject))
    {
    default: 
      if ((localObject instanceof Numeric)) {
        return ((Numeric)localObject).neg();
      }
      break;
    case 7: 
      return XDataType.makeFloat(-Arithmetic.asFloat(localObject));
    case 8: 
      return XDataType.makeDouble(-Arithmetic.asDouble(localObject));
    }
    return AddOp.apply2(-1, IntNum.zero(), localObject);
  }
  
  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if ((paramObject1 == Values.empty) || (paramObject1 == null)) {
      return paramObject1;
    }
    if ((paramObject2 == Values.empty) || (paramObject2 == null)) {
      return paramObject2;
    }
    Object localObject;
    if (!(paramObject1 instanceof KNode))
    {
      localObject = paramObject1;
      if (!(paramObject1 instanceof UntypedAtomic)) {}
    }
    else
    {
      localObject = XDataType.doubleType.valueOf(TextUtils.stringValue(paramObject1));
    }
    if (!(paramObject2 instanceof KNode))
    {
      paramObject1 = paramObject2;
      if (!(paramObject2 instanceof UntypedAtomic)) {}
    }
    else
    {
      paramObject1 = XDataType.doubleType.valueOf(TextUtils.stringValue(paramObject2));
    }
    int j;
    int k;
    int i;
    switch (this.op)
    {
    case ',': 
    default: 
      j = Arithmetic.classifyValue(localObject);
      k = Arithmetic.classifyValue(paramObject1);
      if (j < k)
      {
        i = k;
        switch (this.op)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            throw new UnsupportedOperationException(getName());
            return AddOp.apply2(1, localObject, paramObject1);
            return AddOp.apply2(-1, localObject, paramObject1);
            return MultiplyOp.$St.apply2(localObject, paramObject1);
            i = j;
            break;
          } while ((j < 0) || (k < 0));
          if (i <= 6) {
            return div((BigDecimal)XDataType.decimalType.cast(localObject), (BigDecimal)XDataType.decimalType.cast(paramObject1));
          }
          if (i == 7) {
            return new Float(((Number)localObject).floatValue() / ((Number)paramObject1).floatValue());
          }
          if (i == 8) {
            return new Double(((Number)localObject).doubleValue() / ((Number)paramObject1).doubleValue());
          }
          if (((localObject instanceof Duration)) && ((paramObject1 instanceof Duration)))
          {
            paramObject2 = (Duration)localObject;
            paramObject1 = (Duration)paramObject1;
            if ((((Duration)paramObject2).unit() == Unit.second) && (((Duration)paramObject1).unit() == Unit.second))
            {
              long l1 = ((Duration)paramObject2).getTotalSeconds();
              long l2 = ((Duration)paramObject1).getTotalSeconds();
              i = ((Duration)paramObject2).getNanoSecondsOnly();
              j = ((Duration)paramObject1).getNanoSecondsOnly();
              return div(TimeUtils.secondsBigDecimalFromDuration(l1, i), TimeUtils.secondsBigDecimalFromDuration(l2, j));
            }
            if ((((Duration)paramObject2).unit() == Unit.month) && (((Duration)paramObject1).unit() == Unit.month)) {
              return div(BigDecimal.valueOf(((Duration)paramObject2).getTotalMonths()), BigDecimal.valueOf(((Duration)paramObject1).getTotalMonths()));
            }
            throw new ArithmeticException("divide of incompatible durations");
          }
          if (i >= 0) {
            return Arithmetic.asNumeric(localObject).div(Arithmetic.asNumeric(paramObject1));
          }
        } while ((j < 0) || (k < 0));
        if (i <= 4) {
          return IntNum.quotient(Arithmetic.asIntNum(localObject), Arithmetic.asIntNum(paramObject1));
        }
        if (i <= 6) {
          return Arithmetic.asIntNum(((BigDecimal)XDataType.decimalType.cast(localObject)).divide((BigDecimal)XDataType.decimalType.cast(paramObject1), 0, 1));
        }
        if (i <= 7) {
          return RealNum.toExactInt(((Number)localObject).floatValue() / ((Number)paramObject1).floatValue(), 3);
        }
        return RealNum.toExactInt(((Number)localObject).doubleValue() / ((Number)paramObject1).doubleValue(), 3);
      } while ((j < 0) || (k < 0));
      if (i <= 4) {
        return IntNum.remainder(Arithmetic.asIntNum(localObject), Arithmetic.asIntNum(paramObject1));
      }
      if (i <= 6) {
        return sub.apply2(localObject, mul.apply2(idiv.apply2(localObject, paramObject1), paramObject1));
      }
      if (i <= 7) {
        return XDataType.makeFloat(Arithmetic.asFloat(localObject) % Arithmetic.asFloat(paramObject1));
      }
    } while (i > 9);
    double d = Arithmetic.asDouble(localObject) % Arithmetic.asDouble(paramObject1);
    if (i == 9) {
      return DFloNum.make(d);
    }
    return XDataType.makeDouble(d);
  }
  
  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
  
  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\ArithOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */