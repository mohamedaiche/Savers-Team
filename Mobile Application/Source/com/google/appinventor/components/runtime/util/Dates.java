package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SimpleObject
public final class Dates
{
  public static final int DATE_APRIL = 3;
  public static final int DATE_AUGUST = 7;
  public static final int DATE_DAY = 5;
  public static final int DATE_DECEMBER = 11;
  public static final int DATE_FEBRUARY = 1;
  public static final int DATE_FRIDAY = 6;
  public static final int DATE_HOUR = 11;
  public static final int DATE_JANUARY = 0;
  public static final int DATE_JULY = 6;
  public static final int DATE_JUNE = 5;
  public static final int DATE_MARCH = 2;
  public static final int DATE_MAY = 4;
  public static final int DATE_MILLISECOND = 14;
  public static final int DATE_MINUTE = 12;
  public static final int DATE_MONDAY = 2;
  public static final int DATE_MONTH = 2;
  public static final int DATE_NOVEMBER = 10;
  public static final int DATE_OCTOBER = 9;
  public static final int DATE_SATURDAY = 7;
  public static final int DATE_SECOND = 13;
  public static final int DATE_SEPTEMBER = 8;
  public static final int DATE_SUNDAY = 1;
  public static final int DATE_THURSDAY = 5;
  public static final int DATE_TUESDAY = 3;
  public static final int DATE_WEDNESDAY = 4;
  public static final int DATE_WEEK = 3;
  public static final int DATE_YEAR = 1;
  
  @SimpleFunction
  public static long ConvertDuration(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      throw new IllegalArgumentException("illegal date/time interval kind in function Duration()");
    case 3: 
      return paramLong / 1000L / 60L / 60L / 24L / 7L;
    case 5: 
      return paramLong / 1000L / 60L / 60L / 24L;
    case 11: 
      return paramLong / 1000L / 60L / 60L;
    case 12: 
      return paramLong / 1000L / 60L;
    }
    return paramLong / 1000L;
  }
  
  @SimpleFunction
  public static void DateAdd(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      throw new IllegalArgumentException("illegal date/time interval kind in function DateAdd()");
    }
    paramCalendar.add(paramInt1, paramInt2);
  }
  
  @SimpleFunction
  public static void DateAddInMillis(Calendar paramCalendar, long paramLong)
  {
    paramCalendar.setTimeInMillis(paramCalendar.getTimeInMillis() + paramLong);
  }
  
  @SimpleFunction
  public static Calendar DateInstant(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = String.valueOf(paramInt2);
    String str = String.valueOf(paramInt3);
    Object localObject1 = localObject2;
    if (paramInt2 < 10) {
      localObject1 = "0" + (String)localObject2;
    }
    localObject2 = str;
    if (paramInt3 < 10) {
      localObject2 = "0" + str;
    }
    return DateValue((String)localObject1 + "/" + (String)localObject2 + "/" + String.valueOf(paramInt1));
  }
  
  @SimpleFunction
  public static Calendar DateValue(String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    try
    {
      SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      localSimpleDateFormat1.setLenient(true);
      localGregorianCalendar.setTime(localSimpleDateFormat1.parse(paramString));
      return localGregorianCalendar;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        localSimpleDateFormat2.setLenient(true);
        localGregorianCalendar.setTime(localSimpleDateFormat2.parse(paramString));
        return localGregorianCalendar;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          SimpleDateFormat localSimpleDateFormat3 = new SimpleDateFormat("HH:mm");
          localSimpleDateFormat3.setLenient(true);
          localGregorianCalendar.setTime(localSimpleDateFormat3.parse(paramString));
          return localGregorianCalendar;
        }
        catch (ParseException paramString)
        {
          throw new IllegalArgumentException("illegal date/time format in function DateValue()");
        }
      }
    }
  }
  
  @SimpleFunction
  public static int Day(Calendar paramCalendar)
  {
    return paramCalendar.get(5);
  }
  
  @SimpleFunction
  public static String FormatDate(Calendar paramCalendar, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (paramString.length() == 0) {
      localSimpleDateFormat.applyPattern("MMM d, yyyy");
    }
    for (;;)
    {
      return localSimpleDateFormat.format(paramCalendar.getTime());
      localSimpleDateFormat.applyPattern(paramString);
    }
  }
  
  @SimpleFunction
  public static String FormatDateTime(Calendar paramCalendar, String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (paramString.length() == 0) {
      localSimpleDateFormat.applyPattern("MMM d, yyyy HH:mm:ss a");
    }
    for (;;)
    {
      return localSimpleDateFormat.format(paramCalendar.getTime());
      localSimpleDateFormat.applyPattern(paramString);
    }
  }
  
  @SimpleFunction
  public static String FormatTime(Calendar paramCalendar)
  {
    return DateFormat.getTimeInstance(2).format(paramCalendar.getTime());
  }
  
  @SimpleFunction
  public static int Hour(Calendar paramCalendar)
  {
    return paramCalendar.get(11);
  }
  
  @SimpleFunction
  public static int Minute(Calendar paramCalendar)
  {
    return paramCalendar.get(12);
  }
  
  @SimpleFunction
  public static int Month(Calendar paramCalendar)
  {
    return paramCalendar.get(2);
  }
  
  @SimpleFunction
  public static String MonthName(Calendar paramCalendar)
  {
    return String.format("%1$tB", new Object[] { paramCalendar });
  }
  
  @SimpleFunction
  public static Calendar Now()
  {
    return new GregorianCalendar();
  }
  
  @SimpleFunction
  public static int Second(Calendar paramCalendar)
  {
    return paramCalendar.get(13);
  }
  
  @SimpleFunction
  public static Calendar TimeInstant(int paramInt1, int paramInt2)
  {
    Object localObject2 = String.valueOf(paramInt1);
    String str = String.valueOf(paramInt2);
    Object localObject1 = localObject2;
    if (paramInt1 < 10) {
      localObject1 = "0" + (String)localObject2;
    }
    localObject2 = str;
    if (paramInt2 < 10) {
      localObject2 = "0" + str;
    }
    return DateValue((String)localObject1 + ":" + (String)localObject2);
  }
  
  @SimpleFunction
  public static long Timer()
  {
    return System.currentTimeMillis();
  }
  
  @SimpleFunction
  public static int Weekday(Calendar paramCalendar)
  {
    return paramCalendar.get(7);
  }
  
  @SimpleFunction
  public static String WeekdayName(Calendar paramCalendar)
  {
    return String.format("%1$tA", new Object[] { paramCalendar });
  }
  
  @SimpleFunction
  public static int Year(Calendar paramCalendar)
  {
    return paramCalendar.get(1);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\util\Dates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */