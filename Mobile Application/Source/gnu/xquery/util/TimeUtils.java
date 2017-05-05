package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XTimeType;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DateTime;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.xml.TextUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TimeZone;

public class TimeUtils
{
  static final ThreadLocal<DateTime> currentDateTimeLocal = new ThreadLocal();
  
  public static Object adjustDateTimeToTimezone(Object paramObject)
  {
    return adjustDateTimeToTimezone(paramObject, getImplicitTimezone());
  }
  
  public static Object adjustDateTimeToTimezone(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == Values.empty) || (paramObject1 == null)) {
      return paramObject1;
    }
    return adjustDateTimeToTimezoneRaw(coerceToDateTime("adjust-dateTime-to-timezone", paramObject1), paramObject2);
  }
  
  static Object adjustDateTimeToTimezoneRaw(DateTime paramDateTime, Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramDateTime.withZoneUnspecified();
    }
    paramObject = (Duration)paramObject;
    if ((((Duration)paramObject).getNanoSecondsOnly() != 0) || (((Duration)paramObject).getSecondsOnly() != 0)) {
      throw new IllegalArgumentException("timezone offset with fractional minute");
    }
    int i = (int)((Duration)paramObject).getTotalMinutes();
    if ((i < 64696) || (i > 840)) {
      throw new IllegalArgumentException("timezone offset out of range");
    }
    return paramDateTime.adjustTimezone(i);
  }
  
  public static Object adjustDateToTimezone(Object paramObject)
  {
    return adjustDateToTimezone(paramObject, getImplicitTimezone());
  }
  
  public static Object adjustDateToTimezone(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == Values.empty) || (paramObject1 == null)) {
      return paramObject1;
    }
    return adjustDateTimeToTimezoneRaw(coerceToDate("adjust-date-to-timezone", paramObject1), paramObject2);
  }
  
  public static Object adjustTimeToTimezone(Object paramObject)
  {
    return adjustTimeToTimezone(paramObject, getImplicitTimezone());
  }
  
  public static Object adjustTimeToTimezone(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == Values.empty) || (paramObject1 == null)) {
      return paramObject1;
    }
    return adjustDateTimeToTimezoneRaw(coerceToTime("adjust-time-to-timezone", paramObject1), paramObject2);
  }
  
  static IntNum asInteger(int paramInt)
  {
    return IntNum.make(paramInt);
  }
  
  static DateTime coerceToDate(String paramString, Object paramObject)
  {
    if (XTimeType.dateType.isInstance(paramObject)) {
      return (DateTime)paramObject;
    }
    if (((paramObject instanceof KNode)) || ((paramObject instanceof UntypedAtomic))) {
      return XTimeType.parseDateTime(TextUtils.stringValue(paramObject), 14);
    }
    throw new WrongType(paramString, 1, paramObject, "xs:date");
  }
  
  static DateTime coerceToDateTime(String paramString, Object paramObject)
  {
    if (XTimeType.dateTimeType.isInstance(paramObject)) {
      return (DateTime)paramObject;
    }
    if (((paramObject instanceof KNode)) || ((paramObject instanceof UntypedAtomic))) {
      return XTimeType.parseDateTime(TextUtils.stringValue(paramObject), 126);
    }
    throw new WrongType(paramString, 1, paramObject, "xs:dateTime");
  }
  
  static Duration coerceToDuration(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Duration)) {
      return (Duration)paramObject;
    }
    throw new WrongType(paramString, 1, paramObject, "xs:duration");
  }
  
  static DateTime coerceToTime(String paramString, Object paramObject)
  {
    if (XTimeType.timeType.isInstance(paramObject)) {
      return (DateTime)paramObject;
    }
    if (((paramObject instanceof KNode)) || ((paramObject instanceof UntypedAtomic))) {
      return XTimeType.parseDateTime(TextUtils.stringValue(paramObject), 112);
    }
    throw new WrongType(paramString, 1, paramObject, "xs:time");
  }
  
  public static DateTime currentDate()
  {
    return currentDateTime().cast(14);
  }
  
  public static DateTime currentDateTime()
  {
    DateTime localDateTime2 = (DateTime)currentDateTimeLocal.get();
    DateTime localDateTime1 = localDateTime2;
    if (localDateTime2 == null)
    {
      localDateTime1 = now();
      currentDateTimeLocal.set(localDateTime1);
    }
    return localDateTime1;
  }
  
  public static DateTime currentTime()
  {
    return currentDateTime().cast(112);
  }
  
  public static Object dateTime(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject1 == Values.empty)) {
      return paramObject1;
    }
    if ((paramObject2 == null) || (paramObject2 == Values.empty)) {
      return paramObject2;
    }
    paramObject1 = coerceToDate("dateTime", paramObject1);
    paramObject2 = coerceToTime("dateTime", paramObject2);
    StringBuffer localStringBuffer = new StringBuffer();
    ((DateTime)paramObject1).toStringDate(localStringBuffer);
    localStringBuffer.append('T');
    ((DateTime)paramObject2).toStringTime(localStringBuffer);
    int j;
    if (!((DateTime)paramObject1).isZoneUnspecified())
    {
      i = 1;
      if (((DateTime)paramObject2).isZoneUnspecified()) {
        break label137;
      }
      j = 1;
    }
    int k;
    int m;
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        k = ((DateTime)paramObject1).getZoneMinutes();
        m = ((DateTime)paramObject2).getZoneMinutes();
        if ((i != 0) && (j != 0) && (k != m))
        {
          throw new Error("dateTime: incompatible timezone in arguments");
          i = 0;
          break;
          label137:
          j = 0;
          continue;
        }
        if (i == 0) {
          break label170;
        }
      }
    }
    label170:
    for (int i = k;; i = m)
    {
      DateTime.toStringZone(i, localStringBuffer);
      return (DateTime)XTimeType.dateTimeType.valueOf(localStringBuffer.toString());
    }
  }
  
  public static Object dayFromDate(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDate("day-from-date", paramObject).getDay());
  }
  
  public static Object dayFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDateTime("day-from-dateTime", paramObject).getDay());
  }
  
  public static Object daysFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDuration("days-from-duration", paramObject).getDays());
  }
  
  public static Duration getImplicitTimezone()
  {
    return Duration.makeMinutes(TimeZone.getDefault().getRawOffset() / 60000);
  }
  
  static Number getSeconds(DateTime paramDateTime)
  {
    int i = paramDateTime.getSecondsOnly();
    long l = paramDateTime.getNanoSecondsOnly();
    if (l == 0L) {
      return IntNum.make(i);
    }
    return new BigDecimal(BigInteger.valueOf(l + i * 1000000000L), 9);
  }
  
  public static Object hoursFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDateTime("hours-from-dateTime", paramObject).getHours());
  }
  
  public static Object hoursFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDuration("hours-from-duration", paramObject).getHours());
  }
  
  public static Object hoursFromTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToTime("hours-from-time", paramObject).getHours());
  }
  
  public static Object implicitTimezone()
  {
    return timeZoneFromXTime(currentDateTime());
  }
  
  public static Object minutesFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDateTime("minutes-from-dateTime", paramObject).getMinutes());
  }
  
  public static Object minutesFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDuration("minutes-from-duration", paramObject).getMinutes());
  }
  
  public static Object minutesFromTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToTime("minutes-from-time", paramObject).getMinutes());
  }
  
  public static Object monthFromDate(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDate("month-from-date", paramObject).getMonth());
  }
  
  public static Object monthFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDateTime("month-from-dateTime", paramObject).getMonth());
  }
  
  public static Object monthsFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDuration("months-from-duration", paramObject).getMonths());
  }
  
  public static DateTime now()
  {
    return XTimeType.dateTimeType.now();
  }
  
  public static BigDecimal secondsBigDecimalFromDuration(long paramLong, int paramInt)
  {
    Object localObject;
    if (paramInt == 0) {
      localObject = BigDecimal.valueOf(paramLong);
    }
    int i;
    label69:
    label85:
    BigDecimal localBigDecimal;
    do
    {
      return (BigDecimal)localObject;
      int j = 9;
      long l;
      if ((int)paramLong != paramLong)
      {
        i = 1;
        if (i == 0) {
          break label69;
        }
        l = paramInt;
        paramInt = j;
      }
      for (;;)
      {
        if (l % 10L != 0L) {
          break label85;
        }
        l /= 10L;
        paramInt -= 1;
        continue;
        i = 0;
        break;
        l = 1000000000L * paramLong + paramInt;
        paramInt = j;
      }
      localBigDecimal = new BigDecimal(BigInteger.valueOf(l), paramInt);
      localObject = localBigDecimal;
    } while (i == 0);
    return BigDecimal.valueOf(paramLong).add(localBigDecimal);
  }
  
  public static Object secondsFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return getSeconds(coerceToDateTime("seconds-from-dateTime", paramObject));
  }
  
  public static Object secondsFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    paramObject = coerceToDuration("seconds-from-duration", paramObject);
    int i = ((Duration)paramObject).getSecondsOnly();
    int j = ((Duration)paramObject).getNanoSecondsOnly();
    if (j == 0) {
      return asInteger(i);
    }
    return secondsBigDecimalFromDuration(i, j);
  }
  
  public static Object secondsFromTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return getSeconds(coerceToTime("seconds-from-time", paramObject));
  }
  
  static Object timeZoneFromXTime(DateTime paramDateTime)
  {
    if (paramDateTime.isZoneUnspecified()) {
      return Values.empty;
    }
    return Duration.makeMinutes(paramDateTime.getZoneMinutes());
  }
  
  public static Object timezoneFromDate(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return timeZoneFromXTime(coerceToDate("timezone-from-date", paramObject));
  }
  
  public static Object timezoneFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return timeZoneFromXTime(coerceToDateTime("timezone-from-datetime", paramObject));
  }
  
  public static Object timezoneFromTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return timeZoneFromXTime(coerceToTime("timezone-from-time", paramObject));
  }
  
  public static Object yearFromDate(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDate("year-from-date", paramObject).getYear());
  }
  
  public static Object yearFromDateTime(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDateTime("year-from-dateTime", paramObject).getYear());
  }
  
  public static Object yearsFromDuration(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    return asInteger(coerceToDuration("years-from-duration", paramObject).getYears());
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */