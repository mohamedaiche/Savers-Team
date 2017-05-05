package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Macro
  extends Syntax
  implements Printable, Externalizable
{
  private ScopeExp capturedScope;
  public Object expander;
  private boolean hygienic = true;
  Object instance;
  
  public Macro() {}
  
  public Macro(Object paramObject)
  {
    super(paramObject);
  }
  
  public Macro(Object paramObject, Procedure paramProcedure)
  {
    super(paramObject);
    this.expander = new QuoteExp(paramProcedure);
  }
  
  public Macro(Macro paramMacro)
  {
    this.name = paramMacro.name;
    this.expander = paramMacro.expander;
    this.hygienic = paramMacro.hygienic;
  }
  
  public static Macro make(Declaration paramDeclaration)
  {
    Macro localMacro = new Macro(paramDeclaration.getSymbol());
    paramDeclaration.setSyntax();
    localMacro.capturedScope = paramDeclaration.context;
    return localMacro;
  }
  
  public static Macro make(Object paramObject, Procedure paramProcedure)
  {
    return new Macro(paramObject, paramProcedure);
  }
  
  public static Macro make(Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    paramObject1 = new Macro(paramObject1, paramProcedure);
    ((Macro)paramObject1).instance = paramObject2;
    return (Macro)paramObject1;
  }
  
  public static Macro makeNonHygienic(Object paramObject, Procedure paramProcedure)
  {
    paramObject = new Macro(paramObject, paramProcedure);
    ((Macro)paramObject).hygienic = false;
    return (Macro)paramObject;
  }
  
  public static Macro makeNonHygienic(Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    paramObject1 = new Macro(paramObject1, paramProcedure);
    ((Macro)paramObject1).hygienic = false;
    ((Macro)paramObject1).instance = paramObject2;
    return (Macro)paramObject1;
  }
  
  /* Error */
  public Object expand(Object paramObject, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	kawa/lang/Macro:expander	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: instanceof 65
    //   11: ifeq +66 -> 77
    //   14: aload 6
    //   16: instanceof 67
    //   19: ifne +58 -> 77
    //   22: aload 6
    //   24: checkcast 65	gnu/mapping/Procedure
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 21	kawa/lang/Macro:hygienic	Z
    //   33: ifne +262 -> 295
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 72	kawa/lang/Quote:quote	(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: invokestatic 78	kawa/lang/Translator:listLength	(Ljava/lang/Object;)I
    //   46: istore 4
    //   48: iload 4
    //   50: ifgt +136 -> 186
    //   53: aload_2
    //   54: new 80	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   61: ldc 83
    //   63: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 98	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   76: areturn
    //   77: aload 6
    //   79: astore 5
    //   81: aload 6
    //   83: instanceof 67
    //   86: ifne +34 -> 120
    //   89: aload_2
    //   90: getfield 102	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   93: astore 7
    //   95: aload_2
    //   96: aload_0
    //   97: putfield 102	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   100: aload_2
    //   101: aload 6
    //   103: invokevirtual 106	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   106: astore 5
    //   108: aload_0
    //   109: aload 5
    //   111: putfield 31	kawa/lang/Macro:expander	Ljava/lang/Object;
    //   114: aload_2
    //   115: aload 7
    //   117: putfield 102	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   120: aload 5
    //   122: checkcast 67	gnu/expr/Expression
    //   125: aload_2
    //   126: invokevirtual 110	kawa/lang/Translator:getGlobalEnvironment	()Lgnu/mapping/Environment;
    //   129: invokevirtual 114	gnu/expr/Expression:eval	(Lgnu/mapping/Environment;)Ljava/lang/Object;
    //   132: checkcast 65	gnu/mapping/Procedure
    //   135: astore 5
    //   137: goto -108 -> 29
    //   140: astore_1
    //   141: aload_2
    //   142: aload 7
    //   144: putfield 102	kawa/lang/Translator:currentMacroDefinition	Lkawa/lang/Macro;
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: aload_2
    //   151: new 80	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   158: ldc 116
    //   160: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 119	kawa/lang/Macro:getName	()Ljava/lang/String;
    //   167: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 121
    //   172: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 98	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   185: areturn
    //   186: iload 4
    //   188: iconst_1
    //   189: isub
    //   190: anewarray 123	java/lang/Object
    //   193: astore 6
    //   195: iconst_0
    //   196: istore_3
    //   197: iload_3
    //   198: iload 4
    //   200: if_icmpge +34 -> 234
    //   203: aload_1
    //   204: checkcast 125	gnu/lists/Pair
    //   207: astore_1
    //   208: iload_3
    //   209: ifle +13 -> 222
    //   212: aload 6
    //   214: iload_3
    //   215: iconst_1
    //   216: isub
    //   217: aload_1
    //   218: invokevirtual 128	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   221: aastore
    //   222: aload_1
    //   223: invokevirtual 131	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   226: astore_1
    //   227: iload_3
    //   228: iconst_1
    //   229: iadd
    //   230: istore_3
    //   231: goto -34 -> 197
    //   234: aload 5
    //   236: aload 6
    //   238: invokevirtual 135	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
    //   241: astore 5
    //   243: aload_1
    //   244: instanceof 137
    //   247: ifeq +59 -> 306
    //   250: aload 5
    //   252: instanceof 125
    //   255: ifeq +51 -> 306
    //   258: aload 5
    //   260: instanceof 137
    //   263: ifne +43 -> 306
    //   266: aload 5
    //   268: checkcast 125	gnu/lists/Pair
    //   271: astore 5
    //   273: new 137	gnu/lists/PairWithPosition
    //   276: dup
    //   277: aload_1
    //   278: checkcast 137	gnu/lists/PairWithPosition
    //   281: aload 5
    //   283: invokevirtual 128	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   286: aload 5
    //   288: invokevirtual 131	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   291: invokespecial 140	gnu/lists/PairWithPosition:<init>	(Lgnu/text/SourceLocator;Ljava/lang/Object;Ljava/lang/Object;)V
    //   294: areturn
    //   295: aload 5
    //   297: aload_1
    //   298: invokevirtual 144	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   301: astore 5
    //   303: goto -60 -> 243
    //   306: aload 5
    //   308: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	Macro
    //   0	309	1	paramObject	Object
    //   0	309	2	paramTranslator	Translator
    //   196	35	3	i	int
    //   46	155	4	j	int
    //   27	280	5	localObject1	Object
    //   4	233	6	localObject2	Object
    //   93	50	7	localMacro	Macro
    // Exception table:
    //   from	to	target	type
    //   100	114	140	finally
    //   0	29	149	java/lang/Throwable
    //   29	48	149	java/lang/Throwable
    //   53	77	149	java/lang/Throwable
    //   81	100	149	java/lang/Throwable
    //   114	120	149	java/lang/Throwable
    //   120	137	149	java/lang/Throwable
    //   141	149	149	java/lang/Throwable
    //   186	195	149	java/lang/Throwable
    //   203	208	149	java/lang/Throwable
    //   212	222	149	java/lang/Throwable
    //   222	227	149	java/lang/Throwable
    //   234	243	149	java/lang/Throwable
    //   243	295	149	java/lang/Throwable
    //   295	303	149	java/lang/Throwable
  }
  
  public ScopeExp getCapturedScope()
  {
    if (this.capturedScope == null)
    {
      if (!(this.instance instanceof ModuleExp)) {
        break label33;
      }
      this.capturedScope = ((ModuleExp)this.instance);
    }
    for (;;)
    {
      return this.capturedScope;
      label33:
      if (this.instance != null) {
        this.capturedScope = ModuleInfo.findFromInstance(this.instance).getModuleExp();
      }
    }
  }
  
  public final boolean isHygienic()
  {
    return this.hygienic;
  }
  
  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<macro ");
    paramConsumer.write(getName());
    paramConsumer.write(62);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName((String)paramObjectInput.readObject());
    this.expander = new QuoteExp(paramObjectInput.readObject());
  }
  
  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return paramTranslator.rewrite(expand(paramPair, paramTranslator));
  }
  
  public Expression rewriteForm(Object paramObject, Translator paramTranslator)
  {
    return paramTranslator.rewrite(expand(paramObject, paramTranslator));
  }
  
  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    String str = paramTranslator.getFileName();
    int i = paramTranslator.getLineNumber();
    int j = paramTranslator.getColumnNumber();
    Syntax localSyntax = paramTranslator.currentSyntax;
    try
    {
      paramTranslator.setLine(paramPair);
      paramTranslator.currentSyntax = this;
      paramTranslator.scanForm(expand(paramPair, paramTranslator), paramScopeExp);
      return;
    }
    finally
    {
      paramTranslator.setLine(str, i, j);
      paramTranslator.currentSyntax = localSyntax;
    }
  }
  
  public void setCapturedScope(ScopeExp paramScopeExp)
  {
    this.capturedScope = paramScopeExp;
  }
  
  public final void setHygienic(boolean paramBoolean)
  {
    this.hygienic = paramBoolean;
  }
  
  public String toString()
  {
    return "#<macro " + getName() + '>';
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
    paramObjectOutput.writeObject(((QuoteExp)this.expander).getValue());
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\lang\Macro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */