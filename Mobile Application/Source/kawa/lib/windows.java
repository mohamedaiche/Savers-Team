package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;

public class windows
  extends ModuleBody
{
  public static final windows $instance;
  static final SimpleSymbol Lit0 = (SimpleSymbol)new SimpleSymbol("scheme-window").readResolve();
  public static final ModuleMethod scheme$Mnwindow;
  
  static
  {
    $instance = new windows();
    scheme$Mnwindow = new ModuleMethod($instance, 1, Lit0, 4096);
    $instance.run();
  }
  
  public windows()
  {
    ModuleInfo.register(this);
  }
  
  public static void schemeWindow()
  {
    schemeWindow(Boolean.FALSE);
  }
  
  /* Error */
  public static void schemeWindow(Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 65	kawa/standard/Scheme:getInstance	()Lkawa/standard/Scheme;
    //   3: astore_3
    //   4: aload_0
    //   5: getstatic 55	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   8: if_acmpeq +32 -> 40
    //   11: invokestatic 71	kawa/lib/misc:interactionEnvironment	()Lgnu/mapping/Environment;
    //   14: astore_2
    //   15: getstatic 55	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   18: astore 4
    //   20: aload_0
    //   21: aload 4
    //   23: if_acmpeq +25 -> 48
    //   26: iconst_1
    //   27: istore_1
    //   28: new 73	kawa/GuiConsole
    //   31: dup
    //   32: aload_3
    //   33: aload_2
    //   34: iload_1
    //   35: invokespecial 76	kawa/GuiConsole:<init>	(Lgnu/expr/Language;Lgnu/mapping/Environment;Z)V
    //   38: pop
    //   39: return
    //   40: aload_3
    //   41: invokevirtual 81	gnu/expr/Language:getNewEnvironment	()Lgnu/mapping/Environment;
    //   44: astore_2
    //   45: goto -30 -> 15
    //   48: iconst_0
    //   49: istore_1
    //   50: goto -22 -> 28
    //   53: astore_2
    //   54: new 83	gnu/mapping/WrongType
    //   57: dup
    //   58: aload_2
    //   59: ldc 85
    //   61: iconst_3
    //   62: aload_0
    //   63: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramObject	Object
    //   27	23	1	bool	boolean
    //   14	31	2	localEnvironment	gnu.mapping.Environment
    //   53	6	2	localClassCastException	ClassCastException
    //   3	38	3	localScheme	kawa.standard.Scheme
    //   18	4	4	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   15	20	53	java/lang/ClassCastException
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 1)
    {
      schemeWindow();
      return Values.empty;
    }
    return super.apply0(paramModuleMethod);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 1)
    {
      schemeWindow(paramObject);
      return Values.empty;
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public final void run(CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\lib\windows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */