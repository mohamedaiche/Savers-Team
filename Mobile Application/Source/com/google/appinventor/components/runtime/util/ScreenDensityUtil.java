package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;

public final class ScreenDensityUtil
{
  public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
  private static final String LOG_TAG = "ScreenDensityUtil";
  public static final float MAXIMUM_ASPECT_RATIO = 1.7791667F;
  
  public static float computeCompatibleScaling(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Point localPoint = new Point();
    getRawScreenDim(paramContext, localPoint);
    int i = localPoint.x;
    int j = localPoint.y;
    int n;
    int m;
    float f2;
    float f1;
    if (i < j)
    {
      n = i;
      m = j;
      int k = (int)(320.0F * localDisplayMetrics.density + 0.5F);
      f2 = m / n;
      f1 = f2;
      if (f2 > 1.7791667F) {
        f1 = 1.7791667F;
      }
      m = (int)(k * f1 + 0.5F);
      if (i >= j) {
        break label152;
      }
      n = k;
      k = m;
      label109:
      f1 = i / n;
      f2 = j / k;
      if (f1 >= f2) {
        break label159;
      }
    }
    for (;;)
    {
      f2 = f1;
      if (f1 < 1.0F) {
        f2 = 1.0F;
      }
      return f2;
      n = j;
      m = i;
      break;
      label152:
      n = m;
      break label109;
      label159:
      f1 = f2;
    }
  }
  
  /* Error */
  public static void getRawScreenDim(Context paramContext, Point paramPoint)
  {
    // Byte code:
    //   0: new 49	android/util/DisplayMetrics
    //   3: dup
    //   4: invokespecial 62	android/util/DisplayMetrics:<init>	()V
    //   7: pop
    //   8: aload_0
    //   9: ldc 64
    //   11: invokevirtual 68	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 70	android/view/WindowManager
    //   17: invokeinterface 74 1 0
    //   22: astore_0
    //   23: invokestatic 80	com/google/appinventor/components/runtime/util/SdkLevel:getLevel	()I
    //   26: istore_2
    //   27: iload_2
    //   28: bipush 17
    //   30: if_icmplt +9 -> 39
    //   33: aload_0
    //   34: aload_1
    //   35: invokestatic 86	com/google/appinventor/components/runtime/util/JellybeanUtil:getRealSize	(Landroid/view/Display;Landroid/graphics/Point;)V
    //   38: return
    //   39: iload_2
    //   40: bipush 10
    //   42: if_icmple +112 -> 154
    //   45: ldc 88
    //   47: ldc 90
    //   49: iconst_0
    //   50: anewarray 92	java/lang/Class
    //   53: invokevirtual 96	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   56: astore_3
    //   57: ldc 88
    //   59: ldc 98
    //   61: iconst_0
    //   62: anewarray 92	java/lang/Class
    //   65: invokevirtual 96	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   68: astore 4
    //   70: aload_1
    //   71: aload 4
    //   73: aload_0
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 106	java/lang/Integer
    //   84: invokevirtual 109	java/lang/Integer:intValue	()I
    //   87: putfield 43	android/graphics/Point:x	I
    //   90: aload_1
    //   91: aload_3
    //   92: aload_0
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 106	java/lang/Integer
    //   103: invokevirtual 109	java/lang/Integer:intValue	()I
    //   106: putfield 46	android/graphics/Point:y	I
    //   109: return
    //   110: astore_0
    //   111: ldc 11
    //   113: ldc 111
    //   115: aload_0
    //   116: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   119: pop
    //   120: return
    //   121: astore_0
    //   122: ldc 11
    //   124: ldc 111
    //   126: aload_0
    //   127: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: return
    //   132: astore_0
    //   133: ldc 11
    //   135: ldc 111
    //   137: aload_0
    //   138: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: return
    //   143: astore_0
    //   144: ldc 11
    //   146: ldc 111
    //   148: aload_0
    //   149: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   152: pop
    //   153: return
    //   154: aload_1
    //   155: aload_0
    //   156: invokevirtual 120	android/view/Display:getWidth	()I
    //   159: putfield 43	android/graphics/Point:x	I
    //   162: aload_1
    //   163: aload_0
    //   164: invokevirtual 123	android/view/Display:getHeight	()I
    //   167: putfield 46	android/graphics/Point:y	I
    //   170: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	Context
    //   0	171	1	paramPoint	Point
    //   26	17	2	i	int
    //   56	36	3	localMethod1	java.lang.reflect.Method
    //   68	4	4	localMethod2	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   70	109	110	java/lang/IllegalArgumentException
    //   45	70	121	java/lang/NoSuchMethodException
    //   70	109	121	java/lang/NoSuchMethodException
    //   111	120	121	java/lang/NoSuchMethodException
    //   133	142	121	java/lang/NoSuchMethodException
    //   144	153	121	java/lang/NoSuchMethodException
    //   70	109	132	java/lang/IllegalAccessException
    //   70	109	143	java/lang/reflect/InvocationTargetException
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\util\ScreenDensityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */