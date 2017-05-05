package appinventor.ai_infoxreda.Savers;

import com.google.appinventor.components.runtime.Component;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

public class Screen1$frame
  extends ModuleBody
{
  Screen1 $main;
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply0(paramModuleMethod);
    case 15: 
      return Screen1.lambda2();
    case 16: 
      this.$main.$define();
      return Values.empty;
    case 17: 
      return Screen1.lambda3();
    case 18: 
      return Screen1.lambda4();
    case 19: 
      return Screen1.lambda5();
    case 20: 
      return Screen1.lambda6();
    case 21: 
      return Screen1.lambda7();
    case 22: 
      return Screen1.lambda8();
    case 23: 
      return Screen1.lambda9();
    case 24: 
      return this.$main.ListPicker1$BeforePicking();
    case 25: 
      return this.$main.ListPicker1$AfterPicking();
    case 26: 
      return Screen1.lambda10();
    case 27: 
      return Screen1.lambda11();
    case 28: 
      return Screen1.lambda12();
    case 29: 
      return Screen1.lambda13();
    case 30: 
      return this.$main.Button1$Click();
    }
    return this.$main.Clock1$Timer();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      this.$main.androidLogForm(paramObject);
      return Values.empty;
    case 3: 
      paramModuleMethod = this.$main;
    }
    try
    {
      localSymbol = (Symbol)paramObject;
      return paramModuleMethod.lookupInFormEnvironment(localSymbol);
    }
    catch (ClassCastException paramModuleMethod)
    {
      Symbol localSymbol;
      throw new WrongType(paramModuleMethod, "lookup-in-form-environment", 1, paramObject);
    }
    paramModuleMethod = this.$main;
    try
    {
      localSymbol = (Symbol)paramObject;
      if (paramModuleMethod.isBoundInFormEnvironment(localSymbol)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "is-bound-in-form-environment", 1, paramObject);
    }
    this.$main.addToFormDoAfterCreation(paramObject);
    return Values.empty;
    this.$main.sendError(paramObject);
    return Values.empty;
    this.$main.processException(paramObject);
    return Values.empty;
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 2: 
      paramModuleMethod = this.$main;
    }
    try
    {
      localSymbol = (Symbol)paramObject1;
      paramModuleMethod.addToFormEnvironment(localSymbol, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException paramModuleMethod)
    {
      Symbol localSymbol;
      throw new WrongType(paramModuleMethod, "add-to-form-environment", 1, paramObject1);
    }
    paramModuleMethod = this.$main;
    try
    {
      localSymbol = (Symbol)paramObject1;
      return paramModuleMethod.lookupInFormEnvironment(localSymbol, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "lookup-in-form-environment", 1, paramObject1);
    }
    paramModuleMethod = this.$main;
    try
    {
      localSymbol = (Symbol)paramObject1;
      paramModuleMethod.addToGlobalVarEnvironment(localSymbol, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "add-to-global-var-environment", 1, paramObject1);
    }
    this.$main.addToEvents(paramObject1, paramObject2);
    return Values.empty;
    this.$main.addToGlobalVars(paramObject1, paramObject2);
    return Values.empty;
    return this.$main.lookupHandler(paramObject1, paramObject2);
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 19	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 8:+40->44, 13:+57->61
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 163	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: getfield 29	appinventor/ai_infoxreda/Savers/Screen1$frame:$main	Lappinventor/ai_infoxreda/Savers/Screen1;
    //   48: aload_2
    //   49: aload_3
    //   50: aload 4
    //   52: aload 5
    //   54: invokevirtual 167	appinventor/ai_infoxreda/Savers/Screen1:addToComponents	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   57: getstatic 38	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   60: areturn
    //   61: aload_0
    //   62: getfield 29	appinventor/ai_infoxreda/Savers/Screen1$frame:$main	Lappinventor/ai_infoxreda/Savers/Screen1;
    //   65: astore_1
    //   66: aload_2
    //   67: checkcast 169	com/google/appinventor/components/runtime/Component
    //   70: astore 6
    //   72: aload_3
    //   73: checkcast 171	java/lang/String
    //   76: astore_2
    //   77: aload 4
    //   79: checkcast 171	java/lang/String
    //   82: astore_3
    //   83: aload 5
    //   85: checkcast 173	[Ljava/lang/Object;
    //   88: astore 4
    //   90: aload_1
    //   91: aload 6
    //   93: aload_2
    //   94: aload_3
    //   95: aload 4
    //   97: invokevirtual 177	appinventor/ai_infoxreda/Savers/Screen1:dispatchEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: ifeq +7 -> 107
    //   103: getstatic 109	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   106: areturn
    //   107: getstatic 112	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   110: areturn
    //   111: astore_1
    //   112: new 123	gnu/mapping/WrongType
    //   115: dup
    //   116: aload_1
    //   117: ldc -78
    //   119: iconst_1
    //   120: aload_2
    //   121: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: astore_1
    //   126: new 123	gnu/mapping/WrongType
    //   129: dup
    //   130: aload_1
    //   131: ldc -78
    //   133: iconst_2
    //   134: aload_3
    //   135: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   138: athrow
    //   139: astore_1
    //   140: new 123	gnu/mapping/WrongType
    //   143: dup
    //   144: aload_1
    //   145: ldc -78
    //   147: iconst_3
    //   148: aload 4
    //   150: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    //   154: astore_1
    //   155: new 123	gnu/mapping/WrongType
    //   158: dup
    //   159: aload_1
    //   160: ldc -78
    //   162: iconst_4
    //   163: aload 5
    //   165: invokespecial 128	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	frame
    //   0	169	1	paramModuleMethod	ModuleMethod
    //   0	169	2	paramObject1	Object
    //   0	169	3	paramObject2	Object
    //   0	169	4	paramObject3	Object
    //   0	169	5	paramObject4	Object
    //   70	22	6	localComponent	Component
    // Exception table:
    //   from	to	target	type
    //   66	72	111	java/lang/ClassCastException
    //   72	77	125	java/lang/ClassCastException
    //   77	83	139	java/lang/ClassCastException
    //   83	90	154	java/lang/ClassCastException
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 31: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 30: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 29: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 28: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 27: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 26: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 25: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 24: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 23: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 22: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 20: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 19: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 18: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 17: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 16: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 12: 
    case 11: 
    case 10: 
    case 5: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return i;
          } while (!(paramObject instanceof Screen1));
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
        } while (!(paramObject instanceof Symbol));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (!(paramObject instanceof Symbol));
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 14: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6: 
      if (!(paramObject1 instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3: 
      if (!(paramObject1 instanceof Symbol)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    if (!(paramObject1 instanceof Symbol)) {
      return -786431;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 13: 
      if (!(paramObject1 instanceof Screen1)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Component)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof String)) {
        return -786429;
      }
      paramCallContext.value3 = paramObject3;
      if (!(paramObject4 instanceof String)) {
        return -786428;
      }
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\appinventor\ai_infoxreda\Savers\Screen1$frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */