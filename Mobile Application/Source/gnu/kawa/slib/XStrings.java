package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class XStrings
  extends ModuleBody
{
  public static final XStrings $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2 = (SimpleSymbol)new SimpleSymbol("string-length").readResolve();
  public static final ModuleMethod string$Mnlength;
  public static final ModuleMethod substring;
  
  static
  {
    Lit1 = (SimpleSymbol)new SimpleSymbol("substring").readResolve();
    Lit0 = IntNum.make(Integer.MAX_VALUE);
    $instance = new XStrings();
    XStrings localXStrings = $instance;
    substring = new ModuleMethod(localXStrings, 1, Lit1, 12290);
    string$Mnlength = new ModuleMethod(localXStrings, 3, Lit2, 4097);
    $instance.run();
  }
  
  public XStrings()
  {
    ModuleInfo.register(this);
  }
  
  public static Object stringLength(Object paramObject)
  {
    if (paramObject == Values.empty) {
      return Values.empty;
    }
    return Integer.valueOf(((String)paramObject).length());
  }
  
  public static Object substring(Object paramObject1, Object paramObject2)
  {
    return substring(paramObject1, paramObject2, Lit0);
  }
  
  /* Error */
  public static Object substring(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 74	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   4: if_acmpne +17 -> 21
    //   7: iconst_1
    //   8: istore_3
    //   9: iload_3
    //   10: ifeq +16 -> 26
    //   13: iload_3
    //   14: ifeq +29 -> 43
    //   17: getstatic 74	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   20: areturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -14 -> 9
    //   26: aload_1
    //   27: getstatic 74	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   30: if_acmpne +75 -> 105
    //   33: iconst_1
    //   34: istore_3
    //   35: iload_3
    //   36: ifeq +74 -> 110
    //   39: iload_3
    //   40: ifne -23 -> 17
    //   43: aload_0
    //   44: checkcast 76	java/lang/String
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 80	java/lang/String:length	()I
    //   54: istore 4
    //   56: aload_1
    //   57: checkcast 94	java/lang/Number
    //   60: invokevirtual 97	java/lang/Number:intValue	()I
    //   63: istore_3
    //   64: iload_3
    //   65: iconst_1
    //   66: isub
    //   67: istore 5
    //   69: aload_2
    //   70: checkcast 94	java/lang/Number
    //   73: invokevirtual 97	java/lang/Number:intValue	()I
    //   76: istore_3
    //   77: iload 4
    //   79: iload 5
    //   81: isub
    //   82: istore 4
    //   84: iload_3
    //   85: iload 4
    //   87: if_icmple +33 -> 120
    //   90: iload 4
    //   92: istore_3
    //   93: aload 6
    //   95: iload 5
    //   97: iload 5
    //   99: iload_3
    //   100: iadd
    //   101: invokevirtual 100	java/lang/String:substring	(II)Ljava/lang/String;
    //   104: areturn
    //   105: iconst_0
    //   106: istore_3
    //   107: goto -72 -> 35
    //   110: aload_2
    //   111: getstatic 74	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   114: if_acmpne -71 -> 43
    //   117: goto -100 -> 17
    //   120: goto -27 -> 93
    //   123: astore_1
    //   124: new 102	gnu/mapping/WrongType
    //   127: dup
    //   128: aload_1
    //   129: ldc 104
    //   131: bipush -2
    //   133: aload_0
    //   134: invokespecial 107	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   137: athrow
    //   138: astore_0
    //   139: new 102	gnu/mapping/WrongType
    //   142: dup
    //   143: aload_0
    //   144: ldc 109
    //   146: bipush -2
    //   148: aload_1
    //   149: invokespecial 107	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    //   153: astore_0
    //   154: new 102	gnu/mapping/WrongType
    //   157: dup
    //   158: aload_0
    //   159: ldc 111
    //   161: bipush -2
    //   163: aload_2
    //   164: invokespecial 107	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramObject1	Object
    //   0	168	1	paramObject2	Object
    //   0	168	2	paramObject3	Object
    //   8	99	3	i	int
    //   54	37	4	j	int
    //   67	34	5	k	int
    //   47	47	6	str	String
    // Exception table:
    //   from	to	target	type
    //   43	49	123	java/lang/ClassCastException
    //   56	64	138	java/lang/ClassCastException
    //   69	77	153	java/lang/ClassCastException
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 3) {
      return stringLength(paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 1) {
      return substring(paramObject1, paramObject2);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 1) {
      return substring(paramObject1, paramObject2, paramObject3);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  
  public final void run(CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\XStrings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */