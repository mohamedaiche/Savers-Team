package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import kawa.lang.PatternScope;
import kawa.lang.Quote;
import kawa.lang.SyntaxTemplate;
import kawa.lang.Translator;

public class syntax
  extends Quote
{
  static final Method makeTemplateScopeMethod = typeTemplateScope.getDeclaredMethod("make", 0);
  public static final syntax quasiSyntax;
  public static final syntax syntax = new syntax("syntax", false);
  static final ClassType typeTemplateScope;
  
  static
  {
    quasiSyntax = new syntax("quasisyntax", true);
    typeTemplateScope = ClassType.make("kawa.lang.TemplateScope");
  }
  
  public syntax(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  static Expression makeSyntax(Object paramObject, Translator paramTranslator)
  {
    SyntaxTemplate localSyntaxTemplate = new SyntaxTemplate(paramObject, null, paramTranslator);
    QuoteExp localQuoteExp = QuoteExp.nullExp;
    PatternScope localPatternScope = paramTranslator.patternScope;
    paramObject = localQuoteExp;
    if (localPatternScope != null)
    {
      paramObject = localQuoteExp;
      if (localPatternScope.matchArray != null) {
        paramObject = new ReferenceExp(localPatternScope.matchArray);
      }
    }
    localQuoteExp = new QuoteExp(localSyntaxTemplate);
    paramTranslator = new ReferenceExp(paramTranslator.templateScopeDecl);
    return new ApplyExp(ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", 2), new Expression[] { localQuoteExp, paramObject, paramTranslator });
  }
  
  protected boolean expandColonForms()
  {
    return false;
  }
  
  protected Expression leaf(Object paramObject, Translator paramTranslator)
  {
    return makeSyntax(paramObject, paramTranslator);
  }
  
  /* Error */
  public Expression rewriteForm(gnu.lists.Pair paramPair, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 103	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   4: instanceof 99
    //   7: ifeq +24 -> 31
    //   10: aload_1
    //   11: invokevirtual 103	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   14: checkcast 99	gnu/lists/Pair
    //   17: checkcast 99	gnu/lists/Pair
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 103	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   25: getstatic 109	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   28: if_acmpeq +10 -> 38
    //   31: aload_2
    //   32: ldc 111
    //   34: invokevirtual 115	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   37: areturn
    //   38: aload_2
    //   39: getfield 79	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnonnull +49 -> 95
    //   49: aload_2
    //   50: invokevirtual 118	kawa/lang/Translator:letStart	()V
    //   53: new 81	gnu/expr/ApplyExp
    //   56: dup
    //   57: getstatic 41	kawa/standard/syntax:makeTemplateScopeMethod	Lgnu/bytecode/Method;
    //   60: getstatic 122	gnu/expr/Expression:noExpressions	[Lgnu/expr/Expression;
    //   63: invokespecial 90	gnu/expr/ApplyExp:<init>	(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V
    //   66: astore 4
    //   68: aload_2
    //   69: aconst_null
    //   70: getstatic 34	kawa/standard/syntax:typeTemplateScope	Lgnu/bytecode/ClassType;
    //   73: aload 4
    //   75: invokevirtual 126	kawa/lang/Translator:letVariable	(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;
    //   78: astore 4
    //   80: aload 4
    //   82: invokevirtual 131	gnu/expr/Declaration:setCanRead	()V
    //   85: aload_2
    //   86: aload 4
    //   88: putfield 79	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   91: aload_2
    //   92: invokevirtual 134	kawa/lang/Translator:letEnter	()V
    //   95: aload_1
    //   96: invokevirtual 137	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   99: astore_1
    //   100: aload_0
    //   101: getfield 141	kawa/standard/syntax:isQuasi	Z
    //   104: ifeq +42 -> 146
    //   107: iconst_1
    //   108: istore_3
    //   109: aload_0
    //   110: aload_0
    //   111: aload_1
    //   112: iload_3
    //   113: aload_2
    //   114: invokevirtual 145	kawa/standard/syntax:expand	(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;
    //   117: aload_2
    //   118: invokevirtual 148	kawa/standard/syntax:coerceExpression	(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    //   121: astore 4
    //   123: aload 4
    //   125: astore_1
    //   126: aload 5
    //   128: ifnonnull +10 -> 138
    //   131: aload_2
    //   132: aload 4
    //   134: invokevirtual 152	kawa/lang/Translator:letDone	(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    //   137: astore_1
    //   138: aload_2
    //   139: aload 5
    //   141: putfield 79	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   144: aload_1
    //   145: areturn
    //   146: iconst_m1
    //   147: istore_3
    //   148: goto -39 -> 109
    //   151: astore_1
    //   152: aload_2
    //   153: aload 5
    //   155: putfield 79	kawa/lang/Translator:templateScopeDecl	Lgnu/expr/Declaration;
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	syntax
    //   0	160	1	paramPair	gnu.lists.Pair
    //   0	160	2	paramTranslator	Translator
    //   108	40	3	i	int
    //   66	67	4	localObject	Object
    //   42	112	5	localDeclaration	gnu.expr.Declaration
    // Exception table:
    //   from	to	target	type
    //   95	107	151	finally
    //   109	123	151	finally
    //   131	138	151	finally
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\standard\syntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */