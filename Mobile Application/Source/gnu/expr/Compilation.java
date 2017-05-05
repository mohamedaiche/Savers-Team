package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.Convert;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.Options.OptionInfo;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compilation
  implements SourceLocator
{
  public static final int BODY_PARSED = 4;
  public static final int CALL_WITH_CONSUMER = 2;
  public static final int CALL_WITH_CONTINUATIONS = 4;
  public static final int CALL_WITH_RETURN = 1;
  public static final int CALL_WITH_TAILCALLS = 3;
  public static final int CALL_WITH_UNSPECIFIED = 0;
  public static final int CLASS_WRITTEN = 14;
  public static final int COMPILED = 12;
  public static final int COMPILE_SETUP = 10;
  public static final int ERROR_SEEN = 100;
  public static final int MODULE_NONSTATIC = -1;
  public static final int MODULE_STATIC = 1;
  public static final int MODULE_STATIC_DEFAULT = 0;
  public static final int MODULE_STATIC_RUN = 2;
  public static final int PROLOG_PARSED = 2;
  public static final int PROLOG_PARSING = 1;
  public static final int RESOLVED = 6;
  public static final int WALKED = 8;
  public static Type[] apply0args;
  public static Method apply0method;
  public static Type[] apply1args;
  public static Method apply1method;
  public static Type[] apply2args;
  public static Method apply2method;
  public static Method apply3method;
  public static Method apply4method;
  private static Type[] applyCpsArgs;
  public static Method applyCpsMethod;
  public static Type[] applyNargs;
  public static Method applyNmethod;
  public static Method[] applymethods;
  public static gnu.bytecode.Field argsCallContextField;
  private static Compilation chainUninitialized;
  static Method checkArgCountMethod;
  public static String classPrefixDefault;
  private static final ThreadLocal<Compilation> current = new InheritableThreadLocal();
  public static boolean debugPrintExpr = false;
  public static boolean debugPrintFinalExpr;
  public static int defaultCallConvention;
  public static int defaultClassFileVersion;
  public static boolean emitSourceDebugExtAttr;
  public static final gnu.bytecode.Field falseConstant;
  public static boolean generateMainDefault;
  public static Method getCallContextInstanceMethod;
  public static Method getCurrentEnvironmentMethod;
  public static final Method getLocation1EnvironmentMethod;
  public static final Method getLocation2EnvironmentMethod;
  public static final Method getLocationMethod;
  public static final Method getProcedureBindingMethod;
  public static final Method getSymbolProcedureMethod;
  public static final Method getSymbolValueMethod;
  public static boolean inlineOk;
  public static final Type[] int1Args;
  public static ClassType javaStringType;
  static Method makeListMethod;
  public static int moduleStatic;
  public static gnu.bytecode.Field noArgsField;
  public static final ArrayType objArrayType;
  public static Options options = new Options();
  public static gnu.bytecode.Field pcCallContextField;
  public static gnu.bytecode.Field procCallContextField;
  public static ClassType scmBooleanType;
  public static ClassType scmKeywordType;
  public static ClassType scmListType;
  public static ClassType scmSequenceType;
  static final Method setNameMethod;
  public static final Type[] string1Arg;
  public static final Type[] sym1Arg;
  public static final gnu.bytecode.Field trueConstant;
  public static ClassType typeApplet;
  public static ClassType typeCallContext;
  public static ClassType typeClass;
  public static ClassType typeClassType;
  public static final ClassType typeConsumer;
  public static ClassType typeEnvironment;
  public static ClassType typeLanguage;
  public static ClassType typeLocation;
  public static ClassType typeMethodProc;
  public static ClassType typeModuleBody;
  public static ClassType typeModuleMethod;
  public static ClassType typeModuleWithContext;
  public static ClassType typeObject;
  public static ClassType typeObjectType;
  public static ClassType typePair;
  public static ClassType typeProcedure;
  public static ClassType typeProcedure0;
  public static ClassType typeProcedure1;
  public static ClassType typeProcedure2;
  public static ClassType typeProcedure3;
  public static ClassType typeProcedure4;
  public static ClassType[] typeProcedureArray;
  public static ClassType typeProcedureN;
  public static ClassType typeRunnable;
  public static ClassType typeServlet;
  public static ClassType typeString;
  public static ClassType typeSymbol;
  public static ClassType typeType;
  public static ClassType typeValues;
  public static Options.OptionInfo warnAsError;
  public static Options.OptionInfo warnInvokeUnknownMethod;
  public static Options.OptionInfo warnUndefinedVariable = options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
  public static Options.OptionInfo warnUnknownMember = options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
  Variable callContextVar;
  Variable callContextVarForInit;
  public String classPrefix = classPrefixDefault;
  ClassType[] classes;
  Initializer clinitChain;
  Method clinitMethod;
  public ClassType curClass;
  public LambdaExp curLambda;
  public Options currentOptions = new Options(options);
  protected ScopeExp current_scope;
  public boolean explicit;
  public Stack<Expression> exprStack;
  Method forNameHelper;
  SwitchState fswitch;
  gnu.bytecode.Field fswitchIndex;
  public boolean generateMain = generateMainDefault;
  public boolean immediate;
  private int keyUninitialized;
  int langOptions;
  protected Language language;
  public Lexer lexer;
  public NameLookup lexical;
  LitTable litTable;
  ArrayClassLoader loader;
  int localFieldIndex;
  public ClassType mainClass;
  public ModuleExp mainLambda;
  int maxSelectorValue;
  protected SourceMessages messages;
  public Method method;
  int method_counter;
  public ModuleInfo minfo;
  public ClassType moduleClass;
  gnu.bytecode.Field moduleInstanceMainField;
  Variable moduleInstanceVar;
  public boolean mustCompile = ModuleExp.alwaysCompile;
  private Compilation nextUninitialized;
  int numClasses;
  boolean pedantic;
  public Stack<Object> pendingImports;
  private int state;
  public Variable thisDecl;
  
  static
  {
    warnInvokeUnknownMethod = options.add("warn-invoke-unknown-method", 1, warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
    warnAsError = options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
    defaultClassFileVersion = 3211264;
    moduleStatic = 0;
    typeObject = Type.objectType;
    scmBooleanType = ClassType.make("java.lang.Boolean");
    typeString = ClassType.make("java.lang.String");
    javaStringType = typeString;
    scmKeywordType = ClassType.make("gnu.expr.Keyword");
    scmSequenceType = ClassType.make("gnu.lists.Sequence");
    scmListType = ClassType.make("gnu.lists.LList");
    typePair = ClassType.make("gnu.lists.Pair");
    objArrayType = ArrayType.make(typeObject);
    typeRunnable = ClassType.make("java.lang.Runnable");
    typeType = ClassType.make("gnu.bytecode.Type");
    typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
    typeClass = Type.javalangClassType;
    typeClassType = ClassType.make("gnu.bytecode.ClassType");
    typeProcedure = ClassType.make("gnu.mapping.Procedure");
    typeLanguage = ClassType.make("gnu.expr.Language");
    typeEnvironment = ClassType.make("gnu.mapping.Environment");
    typeLocation = ClassType.make("gnu.mapping.Location");
    typeSymbol = ClassType.make("gnu.mapping.Symbol");
    getSymbolValueMethod = typeLanguage.getDeclaredMethod("getSymbolValue", 1);
    getSymbolProcedureMethod = typeLanguage.getDeclaredMethod("getSymbolProcedure", 1);
    getLocationMethod = typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
    getProcedureBindingMethod = typeSymbol.addMethod("getProcedure", Type.typeArray0, typeProcedure, 1);
    trueConstant = scmBooleanType.getDeclaredField("TRUE");
    falseConstant = scmBooleanType.getDeclaredField("FALSE");
    setNameMethod = typeProcedure.getDeclaredMethod("setName", 1);
    int1Args = new Type[] { Type.intType };
    string1Arg = new Type[] { javaStringType };
    sym1Arg = string1Arg;
    getLocation1EnvironmentMethod = typeEnvironment.getDeclaredMethod("getLocation", 1);
    Object localObject1 = typeSymbol;
    Object localObject2 = Type.objectType;
    ClassType localClassType1 = typeEnvironment;
    Object localObject3 = typeLocation;
    getLocation2EnvironmentMethod = localClassType1.addMethod("getLocation", new Type[] { localObject1, localObject2 }, (Type)localObject3, 17);
    localObject1 = objArrayType;
    localObject2 = Type.intType;
    localClassType1 = scmListType;
    localObject3 = scmListType;
    makeListMethod = localClassType1.addMethod("makeList", new Type[] { localObject1, localObject2 }, (Type)localObject3, 9);
    getCurrentEnvironmentMethod = typeEnvironment.addMethod("getCurrent", Type.typeArray0, typeEnvironment, 9);
    apply0args = Type.typeArray0;
    apply1args = new Type[] { typeObject };
    apply2args = new Type[] { typeObject, typeObject };
    applyNargs = new Type[] { objArrayType };
    apply0method = typeProcedure.addMethod("apply0", apply0args, typeObject, 17);
    apply1method = typeProcedure.addMethod("apply1", apply1args, typeObject, 1);
    apply2method = typeProcedure.addMethod("apply2", apply2args, typeObject, 1);
    localObject1 = typeObject;
    localObject2 = typeObject;
    localClassType1 = typeObject;
    localObject3 = typeProcedure;
    ClassType localClassType2 = typeObject;
    apply3method = ((ClassType)localObject3).addMethod("apply3", new Type[] { localObject1, localObject2, localClassType1 }, localClassType2, 1);
    localObject1 = typeObject;
    localObject2 = typeObject;
    localClassType1 = typeObject;
    localObject3 = typeObject;
    localClassType2 = typeProcedure;
    ClassType localClassType3 = typeObject;
    apply4method = localClassType2.addMethod("apply4", new Type[] { localObject1, localObject2, localClassType1, localObject3 }, localClassType3, 1);
    applyNmethod = typeProcedure.addMethod("applyN", applyNargs, typeObject, 1);
    localObject1 = typeProcedure;
    localObject2 = Type.intType;
    localClassType1 = typeProcedure;
    localObject3 = Type.voidType;
    checkArgCountMethod = localClassType1.addMethod("checkArgCount", new Type[] { localObject1, localObject2 }, (Type)localObject3, 9);
    applymethods = new Method[] { apply0method, apply1method, apply2method, apply3method, apply4method, applyNmethod };
    typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
    typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
    typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
    typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
    typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
    typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
    typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
    typeModuleWithContext = ClassType.make("gnu.expr.ModuleWithContext");
    typeApplet = ClassType.make("java.applet.Applet");
    typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
    typeCallContext = ClassType.make("gnu.mapping.CallContext");
    typeConsumer = ClassType.make("gnu.lists.Consumer");
    getCallContextInstanceMethod = typeCallContext.getDeclaredMethod("getInstance", 0);
    typeValues = ClassType.make("gnu.mapping.Values");
    noArgsField = typeValues.getDeclaredField("noArgs");
    pcCallContextField = typeCallContext.getDeclaredField("pc");
    typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
    typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
    argsCallContextField = typeCallContext.getDeclaredField("values");
    procCallContextField = typeCallContext.getDeclaredField("proc");
    applyCpsArgs = new Type[] { typeCallContext };
    applyCpsMethod = typeProcedure.addMethod("apply", applyCpsArgs, Type.voidType, 1);
    typeProcedureArray = new ClassType[] { typeProcedure0, typeProcedure1, typeProcedure2, typeProcedure3, typeProcedure4 };
    generateMainDefault = false;
    inlineOk = true;
    classPrefixDefault = "";
    emitSourceDebugExtAttr = true;
  }
  
  public Compilation(Language paramLanguage, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    this.language = paramLanguage;
    this.messages = paramSourceMessages;
    this.lexical = paramNameLookup;
  }
  
  private void checkLoop()
  {
    if (((LambdaExp)this.current_scope).getName() != "%do%loop") {
      throw new Error("internal error - bad loop state");
    }
  }
  
  public static char demangle2(char paramChar1, char paramChar2)
  {
    int i = 37;
    switch (paramChar1 << '\020' | paramChar2)
    {
    default: 
      i = 65535;
    case 5046371: 
    case 5242979: 
      return i;
    case 4259949: 
      return '&';
    case 4259956: 
      return '@';
    case 4391020: 
      return ':';
    case 4391021: 
      return ',';
    case 4456561: 
      return '"';
    case 4456564: 
      return '.';
    case 4522097: 
      return '=';
    case 4522104: 
      return '!';
    case 4653170: 
      return '>';
    case 4980802: 
      return '[';
    case 4980803: 
      return '{';
    case 4980816: 
      return '(';
    case 4980851: 
      return '<';
    case 5046382: 
      return '-';
    case 5111917: 
      return '#';
    case 5242988: 
      return '+';
    case 5308533: 
      return '?';
    case 5374018: 
      return ']';
    case 5374019: 
      return '}';
    case 5374032: 
      return ')';
    case 5439555: 
      return ';';
    case 5439596: 
      return '/';
    case 5439601: 
      return '\\';
    case 5439604: 
      return '*';
    case 5505132: 
      return '~';
    case 5570672: 
      return '^';
    }
    return '|';
  }
  
  public static String demangleName(String paramString)
  {
    return demangleName(paramString, false);
  }
  
  public static String demangleName(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i7 = paramString.length();
    int m = 0;
    int i4 = 0;
    int i1 = 0;
    int n = 0;
    if (n < i7)
    {
      int k = paramString.charAt(n);
      int i = k;
      int i2 = i1;
      int j;
      if (i1 != 0)
      {
        i = k;
        i2 = i1;
        if (!paramBoolean)
        {
          j = Character.toLowerCase(k);
          i2 = 0;
        }
      }
      int i3;
      if ((!paramBoolean) && (j == 105) && (n == 0) && (i7 > 2) && (paramString.charAt(n + 1) == 's'))
      {
        k = paramString.charAt(n + 2);
        if (!Character.isLowerCase(k))
        {
          i3 = 1;
          int i5 = 1;
          int i6 = n + 1;
          if (!Character.isUpperCase(k))
          {
            i1 = i2;
            n = i6;
            m = i3;
            i4 = i5;
            if (!Character.isTitleCase(k)) {}
          }
          else
          {
            localStringBuffer.append(Character.toLowerCase(k));
            n = i6 + 1;
            i4 = i5;
            m = i3;
            i1 = i2;
          }
        }
      }
      for (;;)
      {
        n += 1;
        break;
        char c1;
        if ((j == 36) && (n + 2 < i7))
        {
          char c2 = paramString.charAt(n + 1);
          char c3 = paramString.charAt(n + 2);
          k = demangle2(c2, c3);
          if (k != 65535)
          {
            localStringBuffer.append(k);
            n += 2;
            m = 1;
            i1 = 1;
            continue;
          }
          k = j;
          i3 = m;
          if (c2 == 'T')
          {
            k = j;
            i3 = m;
            if (c3 == 'o')
            {
              k = j;
              i3 = m;
              if (n + 3 < i7)
              {
                k = j;
                i3 = m;
                if (paramString.charAt(n + 3) == '$')
                {
                  localStringBuffer.append("->");
                  n += 3;
                  m = 1;
                  i1 = 1;
                }
              }
            }
          }
        }
        else
        {
          k = j;
          i3 = m;
          if (!paramBoolean)
          {
            k = j;
            i3 = m;
            if (n > 1) {
              if (!Character.isUpperCase(j))
              {
                k = j;
                i3 = m;
                if (!Character.isTitleCase(j)) {}
              }
              else
              {
                k = j;
                i3 = m;
                if (Character.isLowerCase(paramString.charAt(n - 1)))
                {
                  localStringBuffer.append('-');
                  i3 = 1;
                  c1 = Character.toLowerCase(j);
                }
              }
            }
          }
        }
        localStringBuffer.append(c1);
        i1 = i2;
        m = i3;
      }
    }
    if (i4 != 0) {
      localStringBuffer.append('?');
    }
    if (m != 0) {
      paramString = localStringBuffer.toString();
    }
    return paramString;
  }
  
  private void dumpInitializers(Initializer paramInitializer)
  {
    for (paramInitializer = Initializer.reverse(paramInitializer); paramInitializer != null; paramInitializer = paramInitializer.next) {
      paramInitializer.emit(this);
    }
  }
  
  public static Compilation findForImmediateLiterals(int paramInt)
  {
    Object localObject3 = null;
    for (;;)
    {
      Compilation localCompilation2;
      try
      {
        Compilation localCompilation1 = chainUninitialized;
        localCompilation2 = localCompilation1.nextUninitialized;
        if (localCompilation1.keyUninitialized == paramInt)
        {
          if (localObject3 == null)
          {
            chainUninitialized = localCompilation2;
            localCompilation1.nextUninitialized = null;
            return localCompilation1;
          }
          ((Compilation)localObject3).nextUninitialized = localCompilation2;
          continue;
        }
        localObject3 = localObject1;
      }
      finally {}
      Object localObject2 = localCompilation2;
    }
  }
  
  public static final Method getConstructor(ClassType paramClassType, LambdaExp paramLambdaExp)
  {
    Object localObject = paramClassType.getDeclaredMethod("<init>", 0);
    if (localObject != null) {
      return (Method)localObject;
    }
    if (((paramLambdaExp instanceof ClassExp)) && (paramLambdaExp.staticLinkField != null))
    {
      localObject = new Type[1];
      localObject[0] = paramLambdaExp.staticLinkField.getType();
    }
    for (paramLambdaExp = (LambdaExp)localObject;; paramLambdaExp = apply0args) {
      return paramClassType.addMethod("<init>", 1, paramLambdaExp, Type.voidType);
    }
  }
  
  public static Compilation getCurrent()
  {
    return (Compilation)current.get();
  }
  
  public static boolean isValidJavaName(String paramString)
  {
    int i = paramString.length();
    if ((i == 0) || (!Character.isJavaIdentifierStart(paramString.charAt(0)))) {
      return false;
    }
    int j;
    do
    {
      j = i - 1;
      if (j <= 0) {
        break;
      }
      i = j;
    } while (Character.isJavaIdentifierPart(paramString.charAt(j)));
    return false;
    return true;
  }
  
  public static ApplyExp makeCoercion(Expression paramExpression1, Expression paramExpression2)
  {
    return new ApplyExp(new QuoteExp(Convert.getInstance()), new Expression[] { paramExpression2, paramExpression1 });
  }
  
  public static Expression makeCoercion(Expression paramExpression, Type paramType)
  {
    return makeCoercion(paramExpression, new QuoteExp(paramType));
  }
  
  public static String mangleName(String paramString)
  {
    return mangleName(paramString, -1);
  }
  
  public static String mangleName(String paramString, int paramInt)
  {
    int m;
    int n;
    String str;
    if (paramInt >= 0)
    {
      m = 1;
      n = paramString.length();
      if ((n != 6) || (!paramString.equals("*init*"))) {
        break label44;
      }
      str = "<init>";
    }
    label44:
    Object localObject;
    label158:
    label611:
    label1026:
    do
    {
      return str;
      m = 0;
      break;
      localObject = new StringBuffer(n);
      int k = 0;
      int i = 0;
      if (i < n)
      {
        char c2 = paramString.charAt(i);
        char c1 = c2;
        int j = k;
        if (k != 0)
        {
          c1 = Character.toTitleCase(c2);
          j = 0;
        }
        if (Character.isDigit(c1))
        {
          if (i == 0) {
            ((StringBuffer)localObject).append("$N");
          }
          ((StringBuffer)localObject).append(c1);
        }
        for (;;)
        {
          i += 1;
          k = j;
          break;
          if ((!Character.isLetter(c1)) && (c1 != '_')) {
            break label158;
          }
          ((StringBuffer)localObject).append(c1);
        }
        if (c1 == '$')
        {
          if (paramInt > 1) {}
          for (str = "$$";; str = "$")
          {
            ((StringBuffer)localObject).append(str);
            break;
          }
        }
        switch (c1)
        {
        default: 
          ((StringBuffer)localObject).append('$');
          ((StringBuffer)localObject).append(Character.forDigit(c1 >> '\f' & 0xF, 16));
          ((StringBuffer)localObject).append(Character.forDigit(c1 >> '\b' & 0xF, 16));
          ((StringBuffer)localObject).append(Character.forDigit(c1 >> '\004' & 0xF, 16));
          ((StringBuffer)localObject).append(Character.forDigit(c1 & 0xF, 16));
          k = i;
        }
        for (;;)
        {
          i = k;
          if (m != 0) {
            break;
          }
          j = 1;
          i = k;
          break;
          ((StringBuffer)localObject).append("$Pl");
          k = i;
          continue;
          if (m != 0)
          {
            ((StringBuffer)localObject).append("$Mn");
            k = i;
          }
          else
          {
            if (i + 1 < n) {}
            for (c1 = paramString.charAt(i + 1);; c1 = '\000')
            {
              if (c1 != '>') {
                break label611;
              }
              ((StringBuffer)localObject).append("$To$");
              k = i + 1;
              break;
            }
            k = i;
            if (!Character.isLowerCase(c1))
            {
              ((StringBuffer)localObject).append("$Mn");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$St");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Sl");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Eq");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Ls");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Gr");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$At");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Tl");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Pc");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Dt");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Cm");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$LP");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$RP");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$LB");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$RB");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$LC");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$RC");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Sq");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Dq");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Am");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Nm");
              k = i;
              continue;
              if (((StringBuffer)localObject).length() > 0) {}
              for (c1 = ((StringBuffer)localObject).charAt(0);; c1 = '\000')
              {
                if ((m != 0) || (i + 1 != n) || (!Character.isLowerCase(c1))) {
                  break label1026;
                }
                ((StringBuffer)localObject).setCharAt(0, Character.toTitleCase(c1));
                ((StringBuffer)localObject).insert(0, "is");
                k = i;
                break;
              }
              ((StringBuffer)localObject).append("$Qu");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Ex");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Cl");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$SC");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$Up");
              k = i;
              continue;
              ((StringBuffer)localObject).append("$VB");
              k = i;
            }
          }
        }
      }
      localObject = ((StringBuffer)localObject).toString();
      str = paramString;
    } while (((String)localObject).equals(paramString));
    return (String)localObject;
  }
  
  public static String mangleName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1) {
      return mangleName(paramString, i);
    }
  }
  
  public static String mangleNameIfNeeded(String paramString)
  {
    if ((paramString == null) || (isValidJavaName(paramString))) {
      return paramString;
    }
    return mangleName(paramString, 0);
  }
  
  public static String mangleURI(String paramString)
  {
    if (paramString.indexOf('/') >= 0) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = paramString.length();
      if ((k <= 6) || (!paramString.startsWith("class:"))) {
        break;
      }
      return paramString.substring(6);
    }
    String str1;
    int i;
    int m;
    int n;
    StringBuffer localStringBuffer;
    if ((k > 5) && (paramString.charAt(4) == ':') && (paramString.substring(0, 4).equalsIgnoreCase("http")))
    {
      str1 = paramString.substring(5);
      i = k - 5;
      m = 1;
      n = 0;
      localStringBuffer = new StringBuffer();
    }
    for (;;)
    {
      int i3 = str1.indexOf('/', n);
      label118:
      int i1;
      if (i3 < 0)
      {
        j = i;
        if (localStringBuffer.length() != 0) {
          break label280;
        }
        i1 = 1;
        label129:
        if ((i1 == 0) || (m == 0)) {
          break label286;
        }
        String str2 = str1.substring(n, j);
        paramString = str2;
        if (j - n > 4)
        {
          paramString = str2;
          if (str2.startsWith("www.")) {
            paramString = str2.substring(4);
          }
        }
        putURLWords(paramString, localStringBuffer);
        paramString = str1;
        k = i;
      }
      for (;;)
      {
        if (i3 >= 0) {
          break label441;
        }
        return localStringBuffer.toString();
        m = j;
        i = k;
        str1 = paramString;
        if (k <= 4) {
          break;
        }
        m = j;
        i = k;
        str1 = paramString;
        if (paramString.charAt(3) != ':') {
          break;
        }
        m = j;
        i = k;
        str1 = paramString;
        if (!paramString.substring(0, 3).equalsIgnoreCase("uri")) {
          break;
        }
        str1 = paramString.substring(4);
        i = k - 4;
        m = j;
        break;
        j = i3;
        break label118;
        label280:
        i1 = 0;
        break label129;
        label286:
        k = i;
        paramString = str1;
        if (n != j)
        {
          if (i1 == 0) {
            localStringBuffer.append('.');
          }
          int i2 = j;
          k = i;
          paramString = str1;
          if (j == i)
          {
            int i4 = str1.lastIndexOf('.', i);
            i2 = j;
            k = i;
            paramString = str1;
            if (i4 > n + 1)
            {
              i2 = j;
              k = i;
              paramString = str1;
              if (i1 == 0)
              {
                i1 = i - i4;
                if (i1 > 4)
                {
                  i2 = j;
                  k = i;
                  paramString = str1;
                  if (i1 == 5)
                  {
                    i2 = j;
                    k = i;
                    paramString = str1;
                    if (!str1.endsWith("html")) {}
                  }
                }
                else
                {
                  k = i - i1;
                  i2 = k;
                  paramString = str1.substring(0, k);
                }
              }
            }
          }
          localStringBuffer.append(paramString.substring(n, i2));
        }
      }
      label441:
      n = i3 + 1;
      i = k;
      str1 = paramString;
    }
  }
  
  private static void putURLWords(String paramString, StringBuffer paramStringBuffer)
  {
    int i = paramString.indexOf('.');
    String str = paramString;
    if (i > 0)
    {
      putURLWords(paramString.substring(i + 1), paramStringBuffer);
      paramStringBuffer.append('.');
      str = paramString.substring(0, i);
    }
    paramStringBuffer.append(str);
  }
  
  private void registerClass(ClassType paramClassType)
  {
    if (this.classes == null)
    {
      this.classes = new ClassType[20];
      if (!paramClassType.isInterface()) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 33)
    {
      paramClassType.addModifiers(i);
      Object localObject = paramClassType;
      if (paramClassType == this.mainClass)
      {
        localObject = paramClassType;
        if (this.numClasses > 0)
        {
          localObject = this.classes[0];
          this.classes[0] = this.mainClass;
        }
      }
      paramClassType = this.classes;
      i = this.numClasses;
      this.numClasses = (i + 1);
      paramClassType[i] = localObject;
      return;
      if (this.numClasses < this.classes.length) {
        break;
      }
      localObject = new ClassType[this.classes.length * 2];
      System.arraycopy(this.classes, 0, localObject, 0, this.numClasses);
      this.classes = ((ClassType[])localObject);
      break;
    }
  }
  
  public static int registerForImmediateLiterals(Compilation paramCompilation)
  {
    int i = 0;
    try
    {
      Compilation localCompilation = chainUninitialized;
      while (localCompilation != null)
      {
        int j = i;
        if (i <= localCompilation.keyUninitialized) {
          j = localCompilation.keyUninitialized + 1;
        }
        localCompilation = localCompilation.nextUninitialized;
        i = j;
      }
      paramCompilation.keyUninitialized = i;
      paramCompilation.nextUninitialized = chainUninitialized;
      chainUninitialized = paramCompilation;
      return i;
    }
    finally {}
  }
  
  public static void restoreCurrent(Compilation paramCompilation)
  {
    current.set(paramCompilation);
  }
  
  public static void setCurrent(Compilation paramCompilation)
  {
    current.set(paramCompilation);
  }
  
  public static Compilation setSaveCurrent(Compilation paramCompilation)
  {
    Compilation localCompilation = (Compilation)current.get();
    current.set(paramCompilation);
    return localCompilation;
  }
  
  public static void setupLiterals(int paramInt)
  {
    Compilation localCompilation = findForImmediateLiterals(paramInt);
    try
    {
      Class localClass = localCompilation.loader.loadClass(localCompilation.mainClass.getName());
      for (Literal localLiteral = localCompilation.litTable.literalsChain; localLiteral != null; localLiteral = localLiteral.next) {
        localClass.getDeclaredField(localLiteral.field.getName()).set(null, localLiteral.value);
      }
      localCompilation.litTable = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new WrappedException("internal error", localThrowable);
    }
  }
  
  private Method startClassInit()
  {
    this.method = this.curClass.addMethod("<clinit>", apply0args, Type.voidType, 9);
    CodeAttr localCodeAttr = this.method.startCode();
    if ((this.generateMain) || (generatingApplet()) || (generatingServlet()))
    {
      Method localMethod = ((ClassType)Type.make(getLanguage().getClass())).getDeclaredMethod("registerEnvironment", 0);
      if (localMethod != null) {
        localCodeAttr.emitInvokeStatic(localMethod);
      }
    }
    return this.method;
  }
  
  private void varArgsToArray(LambdaExp paramLambdaExp, int paramInt, Variable paramVariable1, Type paramType, Variable paramVariable2)
  {
    CodeAttr localCodeAttr = getCode();
    Type localType = ((ArrayType)paramType).getComponentType();
    if (!"java.lang.Object".equals(localType.getName())) {}
    for (int i = 1; (paramVariable2 != null) && (i == 0); i = 0)
    {
      localCodeAttr.emitLoad(paramVariable2);
      localCodeAttr.emitPushInt(paramInt);
      localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
      return;
    }
    if ((paramInt == 0) && (i == 0))
    {
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      return;
    }
    localCodeAttr.pushScope();
    paramType = paramVariable1;
    Label localLabel;
    if (paramVariable1 == null)
    {
      paramType = localCodeAttr.addLocal(Type.intType);
      if (paramVariable2 != null)
      {
        localCodeAttr.emitLoad(paramVariable2);
        localCodeAttr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
        if (paramInt != 0)
        {
          localCodeAttr.emitPushInt(paramInt);
          localCodeAttr.emitSub(Type.intType);
        }
        localCodeAttr.emitStore(paramType);
      }
    }
    else
    {
      localCodeAttr.emitLoad(paramType);
      localCodeAttr.emitNewArray(localType.getImplementationType());
      paramVariable1 = new Label(localCodeAttr);
      localLabel = new Label(localCodeAttr);
      localLabel.setTypes(localCodeAttr);
      localCodeAttr.emitGoto(paramVariable1);
      localLabel.define(localCodeAttr);
      localCodeAttr.emitDup(1);
      localCodeAttr.emitLoad(paramType);
      if (paramVariable2 == null) {
        break label381;
      }
      localCodeAttr.emitLoad(paramVariable2);
      label257:
      localCodeAttr.emitLoad(paramType);
      if (paramInt != 0)
      {
        localCodeAttr.emitPushInt(paramInt);
        localCodeAttr.emitAdd(Type.intType);
      }
      if (paramVariable2 == null) {
        break label395;
      }
      localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getArgAsObject", 1));
    }
    for (;;)
    {
      if (i != 0) {
        CheckedTarget.emitCheckedCoerce(this, paramLambdaExp, paramLambdaExp.getName(), 0, localType, null);
      }
      localCodeAttr.emitArrayStore(localType);
      paramVariable1.define(localCodeAttr);
      localCodeAttr.emitInc(paramType, (short)-1);
      localCodeAttr.emitLoad(paramType);
      localCodeAttr.emitGotoIfIntGeZero(localLabel);
      localCodeAttr.popScope();
      return;
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      localCodeAttr.emitArrayLength();
      break;
      label381:
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      break label257;
      label395:
      localCodeAttr.emitArrayLoad(Type.objectType);
    }
  }
  
  public void addClass(ClassType paramClassType)
  {
    if (this.mainLambda.filename != null)
    {
      if (emitSourceDebugExtAttr) {
        paramClassType.setStratum(getLanguage().getName());
      }
      paramClassType.setSourceFile(this.mainLambda.filename);
    }
    registerClass(paramClassType);
    paramClassType.setClassfileVersion(defaultClassFileVersion);
  }
  
  public void addMainClass(ModuleExp paramModuleExp)
  {
    this.mainClass = paramModuleExp.classFor(this);
    ClassType localClassType2 = this.mainClass;
    Object localObject = paramModuleExp.getInterfaces();
    if (localObject != null) {
      localClassType2.setInterfaces((ClassType[])localObject);
    }
    ClassType localClassType1 = paramModuleExp.getSuperType();
    localObject = localClassType1;
    if (localClassType1 == null)
    {
      if (!generatingApplet()) {
        break label95;
      }
      localObject = typeApplet;
    }
    for (;;)
    {
      if (makeRunnable()) {
        localClassType2.addInterface(typeRunnable);
      }
      localClassType2.setSuper((ClassType)localObject);
      paramModuleExp.type = localClassType2;
      addClass(localClassType2);
      getConstructor(this.mainClass, paramModuleExp);
      return;
      label95:
      if (generatingServlet()) {
        localObject = typeServlet;
      } else {
        localObject = getModuleType();
      }
    }
  }
  
  public gnu.bytecode.Field allocLocalField(Type paramType, String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = new StringBuilder().append("tmp_");
      int i = this.localFieldIndex + 1;
      this.localFieldIndex = i;
      str = i;
    }
    return this.curClass.addField(str, paramType, 0);
  }
  
  void callInitMethods(ClassType paramClassType, Vector<ClassType> paramVector)
  {
    if (paramClassType == null) {}
    do
    {
      return;
      localObject = paramClassType.getName();
    } while ("java.lang.Object".equals(localObject));
    int i = paramVector.size();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (((ClassType)paramVector.elementAt(j)).getName() != localObject);
    return;
    paramVector.addElement(paramClassType);
    Object localObject = paramClassType.getInterfaces();
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        callInitMethods(localObject[i], paramVector);
        i += 1;
      }
    }
    i = 1;
    if (paramClassType.isInterface()) {
      if ((paramClassType instanceof PairClassType)) {
        paramClassType = ((PairClassType)paramClassType).instanceType;
      }
    }
    for (;;)
    {
      paramClassType = paramClassType.getDeclaredMethod("$finit$", i);
      if (paramClassType == null) {
        break;
      }
      paramVector = getCode();
      paramVector.emitPushThis();
      paramVector.emitInvoke(paramClassType);
      return;
      try
      {
        paramClassType = (ClassType)Type.make(Class.forName(paramClassType.getName() + "$class"));
      }
      catch (Throwable paramClassType)
      {
        return;
      }
      i = 0;
    }
  }
  
  public void cleanupAfterCompilation()
  {
    int i = 0;
    while (i < this.numClasses)
    {
      this.classes[i].cleanupAfterCompilation();
      i += 1;
    }
    this.classes = null;
    this.minfo.comp = null;
    if (this.minfo.exp != null) {
      this.minfo.exp.body = null;
    }
    this.mainLambda.body = null;
    this.mainLambda = null;
    if (!this.immediate) {
      this.litTable = null;
    }
  }
  
  public void compileConstant(Object paramObject)
  {
    CodeAttr localCodeAttr = getCode();
    if (paramObject == null)
    {
      localCodeAttr.emitPushNull();
      return;
    }
    if (((paramObject instanceof String)) && (!this.immediate))
    {
      localCodeAttr.emitPushString((String)paramObject);
      return;
    }
    localCodeAttr.emitGetStatic(compileConstantToField(paramObject));
  }
  
  public void compileConstant(Object paramObject, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget)) {}
    int i;
    for (;;)
    {
      return;
      if (!(paramObject instanceof Values)) {
        break;
      }
      localObject1 = ((Values)paramObject).getValues();
      int j = localObject1.length;
      if (!(paramTarget instanceof ConsumerTarget)) {
        break;
      }
      i = 0;
      while (i < j)
      {
        compileConstant(localObject1[i], paramTarget);
        i += 1;
      }
    }
    if ((paramTarget instanceof ConditionalTarget))
    {
      localObject1 = (ConditionalTarget)paramTarget;
      paramTarget = getCode();
      if (getLanguage().isTrue(paramObject)) {}
      for (paramObject = ((ConditionalTarget)localObject1).ifTrue;; paramObject = ((ConditionalTarget)localObject1).ifFalse)
      {
        paramTarget.emitGoto((Label)paramObject);
        return;
      }
    }
    Object localObject1 = paramObject;
    Type localType;
    Object localObject4;
    if ((paramTarget instanceof StackTarget))
    {
      localType = ((StackTarget)paramTarget).getType();
      if ((localType instanceof PrimType))
      {
        try
        {
          localObject4 = localType.getSignature();
          localObject1 = getCode();
          if (localObject4 == null) {
            break label538;
          }
          if (((String)localObject4).length() == 1) {
            break label287;
          }
        }
        catch (ClassCastException localClassCastException) {}
        if ((paramObject instanceof Number))
        {
          localObject4 = (Number)paramObject;
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      if (i == 67)
      {
        ((CodeAttr)localObject1).emitPushInt(((PrimType)localType).charValue(paramObject));
        return;
      }
      for (;;)
      {
        if ((localType == typeClass) && ((paramObject instanceof ClassType)))
        {
          loadClassRef((ClassType)paramObject);
          return;
          label287:
          i = ((String)localObject4).charAt(0);
          break;
          localClassCastException.emitPushInt(((Number)localObject4).intValue());
          return;
          localClassCastException.emitPushInt(((Number)localObject4).shortValue());
          return;
          localClassCastException.emitPushInt(((Number)localObject4).byteValue());
          return;
          localClassCastException.emitPushLong(((Number)localObject4).longValue());
          return;
          localClassCastException.emitPushFloat(((Number)localObject4).floatValue());
          return;
          localClassCastException.emitPushDouble(((Number)localObject4).doubleValue());
          return;
          if (i == 90)
          {
            if (PrimType.booleanValue(paramObject)) {}
            for (i = 1;; i = 0)
            {
              localClassCastException.emitPushInt(i);
              return;
            }
          }
        }
      }
      try
      {
        Object localObject2 = localType.coerceFromObject(paramObject);
        compileConstant(localObject2);
        if (localObject2 == null)
        {
          paramObject = paramTarget.getType();
          paramTarget.compileFromStack(this, (Type)paramObject);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3 = new StringBuffer();
          if (paramObject == Values.empty)
          {
            ((StringBuffer)localObject3).append("cannot convert void to ");
            ((StringBuffer)localObject3).append(localType.getName());
            error('w', ((StringBuffer)localObject3).toString());
            localObject3 = paramObject;
          }
          else
          {
            ((StringBuffer)localObject3).append("cannot convert literal (of type ");
            if (paramObject == null) {
              ((StringBuffer)localObject3).append("<null>");
            }
            for (;;)
            {
              ((StringBuffer)localObject3).append(") to ");
              break;
              ((StringBuffer)localObject3).append(paramObject.getClass().getName());
            }
            paramObject = Type.make(localObject3.getClass());
          }
        }
      }
      label538:
      i = 32;
      break;
    }
  }
  
  public gnu.bytecode.Field compileConstantToField(Object paramObject)
  {
    paramObject = this.litTable.findLiteral(paramObject);
    if (((Literal)paramObject).field == null) {
      ((Literal)paramObject).assign(this.litTable);
    }
    return ((Literal)paramObject).field;
  }
  
  public void compileToArchive(ModuleExp paramModuleExp, String paramString)
    throws IOException
  {
    int i;
    if (paramString.endsWith(".zip"))
    {
      i = 0;
      process(12);
      paramModuleExp = new File(paramString);
      if (paramModuleExp.exists()) {
        paramModuleExp.delete();
      }
      if (i == 0) {
        break label241;
      }
    }
    label241:
    for (paramModuleExp = new JarOutputStream(new FileOutputStream(paramModuleExp));; paramModuleExp = new ZipOutputStream(new FileOutputStream(paramModuleExp)))
    {
      paramString = new byte[this.numClasses][];
      CRC32 localCRC32 = new CRC32();
      i = 0;
      while (i < this.numClasses)
      {
        Object localObject = this.classes[i];
        paramString[i] = ((ClassType)localObject).writeToArray();
        localObject = new ZipEntry(((ClassType)localObject).getName().replace('.', '/') + ".class");
        ((ZipEntry)localObject).setSize(paramString[i].length);
        localCRC32.reset();
        localCRC32.update(paramString[i], 0, paramString[i].length);
        ((ZipEntry)localObject).setCrc(localCRC32.getValue());
        paramModuleExp.putNextEntry((ZipEntry)localObject);
        paramModuleExp.write(paramString[i]);
        i += 1;
      }
      if (paramString.endsWith(".jar"))
      {
        i = 1;
        break;
      }
      paramString = paramString + ".zip";
      i = 0;
      break;
    }
    paramModuleExp.close();
  }
  
  public LambdaExp currentLambda()
  {
    return this.current_scope.currentLambda();
  }
  
  public ModuleExp currentModule()
  {
    return this.current_scope.currentModule();
  }
  
  public ScopeExp currentScope()
  {
    return this.current_scope;
  }
  
  public void error(char paramChar, Declaration paramDeclaration, String paramString1, String paramString2)
  {
    error(paramChar, paramString1 + paramDeclaration.getName() + paramString2, null, paramDeclaration);
  }
  
  public void error(char paramChar, String paramString)
  {
    char c = paramChar;
    if (paramChar == 'w')
    {
      c = paramChar;
      if (warnAsError()) {
        c = 'e';
      }
    }
    this.messages.error(c, this, paramString);
  }
  
  public void error(char paramChar, String paramString, SourceLocator paramSourceLocator)
  {
    String str = paramSourceLocator.getFileName();
    int k = paramSourceLocator.getLineNumber();
    int j = paramSourceLocator.getColumnNumber();
    int i;
    if (str != null)
    {
      paramSourceLocator = str;
      i = k;
      if (k > 0) {}
    }
    else
    {
      paramSourceLocator = getFileName();
      i = getLineNumber();
      j = getColumnNumber();
    }
    char c = paramChar;
    if (paramChar == 'w')
    {
      c = paramChar;
      if (warnAsError()) {
        c = 'e';
      }
    }
    this.messages.error(c, paramSourceLocator, i, j, paramString);
  }
  
  public void error(char paramChar, String paramString1, String paramString2, Declaration paramDeclaration)
  {
    char c = paramChar;
    if (paramChar == 'w')
    {
      c = paramChar;
      if (warnAsError()) {
        c = 'e';
      }
    }
    String str = getFileName();
    int i = getLineNumber();
    int j = getColumnNumber();
    int k = paramDeclaration.getLineNumber();
    if (k > 0)
    {
      str = paramDeclaration.getFileName();
      i = k;
      j = paramDeclaration.getColumnNumber();
    }
    this.messages.error(c, str, i, j, paramString1, paramString2);
  }
  
  public ClassType findNamedClass(String paramString)
  {
    int i = 0;
    while (i < this.numClasses)
    {
      if (paramString.equals(this.classes[i].getName())) {
        return this.classes[i];
      }
      i += 1;
    }
    return null;
  }
  
  public void freeLocalField(gnu.bytecode.Field paramField) {}
  
  public void generateApplyMethodsWithContext(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int j = 0; j == 0; j = paramLambdaExp.applyMethods.size()) {
      return;
    }
    ClassType localClassType = this.curClass;
    this.curClass = paramLambdaExp.getHeapFrameType();
    if (!this.curClass.getSuperclass().isSubtype(typeModuleWithContext)) {
      this.curClass = this.moduleClass;
    }
    Object localObject1 = typeModuleMethod;
    Method localMethod1 = this.method;
    localObject1 = typeCallContext;
    Object localObject2 = this.curClass;
    Object localObject3 = Type.voidType;
    this.method = ((ClassType)localObject2).addMethod("apply", new Type[] { localObject1 }, (Type)localObject3, 1);
    CodeAttr localCodeAttr = this.method.startCode();
    Variable localVariable = localCodeAttr.getArg(1);
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitGetField(pcCallContextField);
    SwitchState localSwitchState = localCodeAttr.startSwitch();
    int k = 0;
    while (k < j)
    {
      LambdaExp localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(k);
      Method[] arrayOfMethod = localLambdaExp.primMethods;
      int i4 = arrayOfMethod.length;
      int m = 0;
      while (m < i4)
      {
        int n;
        SourceLocator localSourceLocator1;
        int i;
        Method localMethod2;
        Type[] arrayOfType;
        int i5;
        int i2;
        label408:
        int i1;
        label416:
        label430:
        int i3;
        if ((m == i4 - 1) && ((localLambdaExp.max_args < 0) || (localLambdaExp.max_args >= localLambdaExp.min_args + i4)))
        {
          n = 1;
          localSwitchState.addCase(localLambdaExp.getSelectorValue(this) + m, localCodeAttr);
          localSourceLocator1 = this.messages.swapSourceLocator(localLambdaExp);
          i = localLambdaExp.getLineNumber();
          if (i > 0) {
            localCodeAttr.putLineNumber(localLambdaExp.getFileName(), i);
          }
          localMethod2 = arrayOfMethod[m];
          arrayOfType = localMethod2.getParameterTypes();
          i5 = localLambdaExp.min_args + m;
          localObject1 = null;
          i2 = 0;
          localObject2 = localObject1;
          if (m > 4)
          {
            localObject2 = localObject1;
            if (i4 > 1)
            {
              localObject2 = localCodeAttr.addLocal(Type.intType);
              localCodeAttr.emitLoad(localVariable);
              localCodeAttr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
              if (localLambdaExp.min_args != 0)
              {
                localCodeAttr.emitPushInt(localLambdaExp.min_args);
                localCodeAttr.emitSub(Type.intType);
              }
              localCodeAttr.emitStore((Variable)localObject2);
            }
          }
          if (!localMethod2.getStaticFlag()) {
            break label733;
          }
          i = 0;
          if (n == 0) {
            break label738;
          }
          i1 = 2;
          if (i1 + i5 >= arrayOfType.length) {
            break label744;
          }
          i1 = 1;
          if (i + i1 > 0)
          {
            localCodeAttr.emitPushThis();
            if ((this.curClass == this.moduleClass) && (this.mainClass != this.moduleClass)) {
              localCodeAttr.emitGetField(this.moduleInstanceMainField);
            }
          }
          localObject3 = localLambdaExp.firstDecl();
          localObject1 = localObject3;
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (((Declaration)localObject3).isThisParameter()) {
              localObject1 = ((Declaration)localObject3).nextDecl();
            }
          }
          i3 = 0;
          i = i2;
          i2 = i3;
          label518:
          if (i2 >= i5) {
            break label782;
          }
          i3 = i;
          if (localObject2 != null)
          {
            i3 = i;
            if (i2 >= localLambdaExp.min_args)
            {
              localCodeAttr.emitLoad((Variable)localObject2);
              localCodeAttr.emitIfIntLEqZero();
              localCodeAttr.emitLoad(localVariable);
              localCodeAttr.emitInvoke(arrayOfMethod[(i2 - localLambdaExp.min_args)]);
              localCodeAttr.emitElse();
              i3 = i + 1;
              localCodeAttr.emitInc((Variable)localObject2, (short)-1);
            }
          }
          localCodeAttr.emitLoad(localVariable);
          if ((i2 > 4) || (n != 0) || (localLambdaExp.max_args > 4)) {
            break label750;
          }
          localCodeAttr.emitGetField(typeCallContext.getDeclaredField("value" + (i2 + 1)));
        }
        for (;;)
        {
          localObject3 = ((Declaration)localObject1).getType();
          if (localObject3 != Type.objectType)
          {
            SourceLocator localSourceLocator2 = this.messages.swapSourceLocator((SourceLocator)localObject1);
            CheckedTarget.emitCheckedCoerce(this, localLambdaExp, i2 + 1, (Type)localObject3);
            this.messages.swapSourceLocator(localSourceLocator2);
          }
          localObject1 = ((Declaration)localObject1).nextDecl();
          i2 += 1;
          i = i3;
          break label518;
          n = 0;
          break;
          label733:
          i = 1;
          break label408;
          label738:
          i1 = 1;
          break label416;
          label744:
          i1 = 0;
          break label430;
          label750:
          localCodeAttr.emitGetField(typeCallContext.getDeclaredField("values"));
          localCodeAttr.emitPushInt(i2);
          localCodeAttr.emitArrayLoad(Type.objectType);
        }
        label782:
        if (n != 0)
        {
          localObject1 = arrayOfType[(i1 + i5)];
          if (!(localObject1 instanceof ArrayType)) {
            break label849;
          }
          varArgsToArray(localLambdaExp, i5, (Variable)localObject2, (Type)localObject1, localVariable);
        }
        for (;;)
        {
          localCodeAttr.emitLoad(localVariable);
          localCodeAttr.emitInvoke(localMethod2);
          for (;;)
          {
            i -= 1;
            if (i < 0) {
              break;
            }
            localCodeAttr.emitFi();
          }
          label849:
          if ("gnu.lists.LList".equals(((Type)localObject1).getName()))
          {
            localCodeAttr.emitLoad(localVariable);
            localCodeAttr.emitPushInt(i5);
            localCodeAttr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsList", 1));
          }
          else
          {
            if (localObject1 != typeCallContext) {
              break;
            }
            localCodeAttr.emitLoad(localVariable);
          }
        }
        throw new RuntimeException("unsupported #!rest type:" + localObject1);
        if (defaultCallConvention < 2) {
          Target.pushObject.compileFromStack(this, localLambdaExp.getReturnType());
        }
        this.messages.swapSourceLocator(localSourceLocator1);
        localCodeAttr.emitReturn();
        m += 1;
      }
      k += 1;
    }
    localSwitchState.addDefault(localCodeAttr);
    localCodeAttr.emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
    localCodeAttr.emitReturn();
    localSwitchState.finish(localCodeAttr);
    this.method = localMethod1;
    this.curClass = localClassType;
  }
  
  public void generateApplyMethodsWithoutContext(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int n = 0; n == 0; n = paramLambdaExp.applyMethods.size()) {
      return;
    }
    ClassType localClassType1 = this.curClass;
    this.curClass = paramLambdaExp.getHeapFrameType();
    ClassType localClassType2 = typeModuleMethod;
    if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
      this.curClass = this.moduleClass;
    }
    Method localMethod1 = this.method;
    Object localObject2 = null;
    int i;
    int k;
    Object localObject3;
    Object localObject1;
    Object localObject4;
    int i1;
    label110:
    LambdaExp localLambdaExp;
    Method[] arrayOfMethod;
    int i3;
    int j;
    label169:
    int i4;
    int i2;
    int m;
    if (defaultCallConvention >= 2)
    {
      i = 5;
      if (i >= 6) {
        break label1298;
      }
      k = 0;
      localObject3 = null;
      localObject1 = null;
      localObject4 = null;
      i1 = 0;
      if (i1 >= n) {
        break label1181;
      }
      localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(i1);
      arrayOfMethod = localLambdaExp.primMethods;
      i3 = arrayOfMethod.length;
      if ((localLambdaExp.max_args >= 0) && (localLambdaExp.max_args < localLambdaExp.min_args + i3)) {
        break label256;
      }
      j = 1;
      i4 = 0;
      i2 = 0;
      if (i >= 5) {
        break label261;
      }
      i4 = i - localLambdaExp.min_args;
      if ((i4 >= 0) && (i4 < i3))
      {
        m = i2;
        if (i4 == i3 - 1)
        {
          m = i2;
          if (j == 0) {}
        }
      }
      else
      {
        m = 1;
      }
      i3 = 1;
      i2 = 0;
      label231:
      if (m == 0) {
        break label313;
      }
      j = k;
    }
    for (;;)
    {
      i1 += 1;
      k = j;
      break label110;
      i = 0;
      break;
      label256:
      j = 0;
      break label169;
      label261:
      i2 = 5 - localLambdaExp.min_args;
      m = i4;
      if (i2 > 0)
      {
        m = i4;
        if (i3 <= i2)
        {
          m = i4;
          if (j == 0) {
            m = 1;
          }
        }
      }
      i4 = i3 - 1;
      i2 = j;
      break label231;
      label313:
      j = k;
      SourceLocator localSourceLocator1;
      Method localMethod2;
      Type[] arrayOfType;
      int i5;
      Object localObject5;
      Object localObject6;
      label652:
      label660:
      label674:
      Object localObject7;
      if (k == 0)
      {
        if (i < 5)
        {
          localObject2 = "apply" + i;
          localObject3 = new Type[i + 1];
          j = i;
          for (;;)
          {
            localObject4 = localObject3;
            localObject1 = localObject2;
            if (j <= 0) {
              break;
            }
            localObject3[j] = typeObject;
            j -= 1;
          }
        }
        localObject1 = "applyN";
        localObject4 = new Type[2];
        localObject4[1] = objArrayType;
        localObject4[0] = localClassType2;
        localObject3 = this.curClass;
        if (defaultCallConvention >= 2)
        {
          localObject2 = Type.voidType;
          this.method = ((ClassType)localObject3).addMethod((String)localObject1, (Type[])localObject4, (Type)localObject2, 1);
          localObject2 = this.method.startCode();
          ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(1));
          ((CodeAttr)localObject2).emitGetField(localClassType2.getField("selector"));
          localObject3 = ((CodeAttr)localObject2).startSwitch();
          j = 1;
        }
      }
      else
      {
        ((SwitchState)localObject3).addCase(localLambdaExp.getSelectorValue(this), (CodeAttr)localObject2);
        localSourceLocator1 = this.messages.swapSourceLocator(localLambdaExp);
        k = localLambdaExp.getLineNumber();
        if (k > 0) {
          ((CodeAttr)localObject2).putLineNumber(localLambdaExp.getFileName(), k);
        }
        localMethod2 = arrayOfMethod[i4];
        arrayOfType = localMethod2.getParameterTypes();
        i5 = localLambdaExp.min_args + i4;
        localObject5 = null;
        i4 = 0;
        localObject6 = localObject5;
        if (i > 4)
        {
          localObject6 = localObject5;
          if (i3 > 1)
          {
            localObject6 = ((CodeAttr)localObject2).addLocal(Type.intType);
            ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(2));
            ((CodeAttr)localObject2).emitArrayLength();
            if (localLambdaExp.min_args != 0)
            {
              ((CodeAttr)localObject2).emitPushInt(localLambdaExp.min_args);
              ((CodeAttr)localObject2).emitSub(Type.intType);
            }
            ((CodeAttr)localObject2).emitStore((Variable)localObject6);
          }
        }
        if (!localMethod2.getStaticFlag()) {
          break label941;
        }
        k = 0;
        if (i2 == 0) {
          break label947;
        }
        m = 1;
        if (m + i5 >= arrayOfType.length) {
          break label953;
        }
        m = 1;
        if (k + m > 0)
        {
          ((CodeAttr)localObject2).emitPushThis();
          if ((this.curClass == this.moduleClass) && (this.mainClass != this.moduleClass)) {
            ((CodeAttr)localObject2).emitGetField(this.moduleInstanceMainField);
          }
        }
        localObject7 = localLambdaExp.firstDecl();
        localObject5 = localObject7;
        if (localObject7 != null)
        {
          localObject5 = localObject7;
          if (((Declaration)localObject7).isThisParameter()) {
            localObject5 = ((Declaration)localObject7).nextDecl();
          }
        }
        i3 = 0;
        k = i4;
        label760:
        if (i3 >= i5) {
          break label988;
        }
        i4 = k;
        if (localObject6 != null)
        {
          i4 = k;
          if (i3 >= localLambdaExp.min_args)
          {
            ((CodeAttr)localObject2).emitLoad((Variable)localObject6);
            ((CodeAttr)localObject2).emitIfIntLEqZero();
            ((CodeAttr)localObject2).emitInvoke(arrayOfMethod[(i3 - localLambdaExp.min_args)]);
            ((CodeAttr)localObject2).emitElse();
            i4 = k + 1;
            ((CodeAttr)localObject2).emitInc((Variable)localObject6, (short)-1);
          }
        }
        localObject7 = null;
        if (i > 4) {
          break label959;
        }
        localObject7 = ((CodeAttr)localObject2).getArg(i3 + 2);
        ((CodeAttr)localObject2).emitLoad((Variable)localObject7);
      }
      for (;;)
      {
        Type localType = ((Declaration)localObject5).getType();
        if (localType != Type.objectType)
        {
          SourceLocator localSourceLocator2 = this.messages.swapSourceLocator((SourceLocator)localObject5);
          CheckedTarget.emitCheckedCoerce(this, localLambdaExp, i3 + 1, localType, (Variable)localObject7);
          this.messages.swapSourceLocator(localSourceLocator2);
        }
        localObject5 = ((Declaration)localObject5).nextDecl();
        i3 += 1;
        k = i4;
        break label760;
        localObject2 = Type.objectType;
        break;
        label941:
        k = 1;
        break label652;
        label947:
        m = 0;
        break label660;
        label953:
        m = 0;
        break label674;
        label959:
        ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(2));
        ((CodeAttr)localObject2).emitPushInt(i3);
        ((CodeAttr)localObject2).emitArrayLoad(Type.objectType);
      }
      label988:
      if (i2 != 0)
      {
        localObject5 = arrayOfType[(m + i5)];
        if (!(localObject5 instanceof ArrayType)) {
          break label1050;
        }
        varArgsToArray(localLambdaExp, i5, (Variable)localObject6, (Type)localObject5, null);
      }
      for (;;)
      {
        ((CodeAttr)localObject2).emitInvoke(localMethod2);
        for (;;)
        {
          k -= 1;
          if (k < 0) {
            break;
          }
          ((CodeAttr)localObject2).emitFi();
        }
        label1050:
        if ("gnu.lists.LList".equals(((Type)localObject5).getName()))
        {
          ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(2));
          ((CodeAttr)localObject2).emitPushInt(i5);
          ((CodeAttr)localObject2).emitInvokeStatic(makeListMethod);
        }
        else
        {
          if (localObject5 != typeCallContext) {
            break;
          }
          ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(2));
        }
      }
      throw new RuntimeException("unsupported #!rest type:" + localObject5);
      if (defaultCallConvention < 2) {
        Target.pushObject.compileFromStack(this, localLambdaExp.getReturnType());
      }
      this.messages.swapSourceLocator(localSourceLocator1);
      ((CodeAttr)localObject2).emitReturn();
    }
    label1181:
    if (k != 0)
    {
      ((SwitchState)localObject3).addDefault((CodeAttr)localObject2);
      if (defaultCallConvention < 2) {
        break label1234;
      }
      ((CodeAttr)localObject2).emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
    }
    for (;;)
    {
      ((CodeAttr)localObject2).emitReturn();
      ((SwitchState)localObject3).finish((CodeAttr)localObject2);
      i += 1;
      break;
      label1234:
      if (i > 4) {}
      for (j = 2;; j = i + 1)
      {
        k = 0;
        while (k < j + 1)
        {
          ((CodeAttr)localObject2).emitLoad(((CodeAttr)localObject2).getArg(k));
          k += 1;
        }
      }
      ((CodeAttr)localObject2).emitInvokeSpecial(typeModuleBody.getDeclaredMethod((String)localObject1, (Type[])localObject4));
    }
    label1298:
    this.method = localMethod1;
    this.curClass = localClassType1;
  }
  
  /* Error */
  void generateBytecode()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1615	gnu/expr/Compilation:getModule	()Lgnu/expr/ModuleExp;
    //   4: astore 8
    //   6: getstatic 1617	gnu/expr/Compilation:debugPrintFinalExpr	Z
    //   9: ifeq +78 -> 87
    //   12: invokestatic 1623	gnu/mapping/OutPort:errDefault	()Lgnu/mapping/OutPort;
    //   15: astore 5
    //   17: aload 5
    //   19: new 1140	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 1625
    //   29: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 8
    //   34: invokevirtual 1626	gnu/expr/ModuleExp:getName	()Ljava/lang/String;
    //   37: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 1628
    //   43: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   50: invokevirtual 898	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   53: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 1630
    //   59: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 1633	gnu/mapping/OutPort:println	(Ljava/lang/String;)V
    //   68: aload 8
    //   70: aload 5
    //   72: invokevirtual 1637	gnu/expr/ModuleExp:print	(Lgnu/mapping/OutPort;)V
    //   75: aload 5
    //   77: bipush 93
    //   79: invokevirtual 1640	gnu/mapping/OutPort:println	(C)V
    //   82: aload 5
    //   84: invokevirtual 1643	gnu/mapping/OutPort:flush	()V
    //   87: aload_0
    //   88: invokevirtual 1136	gnu/expr/Compilation:getModuleType	()Lgnu/bytecode/ClassType;
    //   91: astore 5
    //   93: aload_0
    //   94: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   97: invokevirtual 1488	gnu/bytecode/ClassType:getSuperclass	()Lgnu/bytecode/ClassType;
    //   100: aload 5
    //   102: invokevirtual 1492	gnu/bytecode/ClassType:isSubtype	(Lgnu/bytecode/Type;)Z
    //   105: ifeq +475 -> 580
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   113: putfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   116: aload_0
    //   117: aload 8
    //   119: getfield 1129	gnu/expr/ModuleExp:type	Lgnu/bytecode/ClassType;
    //   122: putfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   125: aload_0
    //   126: getfield 1645	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   129: astore 9
    //   131: aload_0
    //   132: aload 8
    //   134: putfield 1645	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   137: aload 8
    //   139: invokevirtual 1648	gnu/expr/ModuleExp:isHandlingTailCalls	()Z
    //   142: ifeq +485 -> 627
    //   145: iconst_1
    //   146: anewarray 248	gnu/bytecode/Type
    //   149: astore 5
    //   151: aload 5
    //   153: iconst_0
    //   154: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   157: aastore
    //   158: aload 8
    //   160: getfield 1651	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   163: astore 10
    //   165: aload 8
    //   167: invokevirtual 1654	gnu/expr/ModuleExp:isStatic	()Z
    //   170: istore 4
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   177: ldc_w 1656
    //   180: aload 5
    //   182: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   185: bipush 17
    //   187: invokevirtual 354	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;
    //   190: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   193: aload_0
    //   194: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   197: invokevirtual 1659	gnu/bytecode/Method:initCode	()V
    //   200: aload_0
    //   201: invokevirtual 982	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   204: astore 6
    //   206: aload_0
    //   207: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   210: invokevirtual 1536	gnu/bytecode/Method:getStaticFlag	()Z
    //   213: ifeq +493 -> 706
    //   216: aconst_null
    //   217: astore 5
    //   219: aload_0
    //   220: aload 5
    //   222: putfield 1661	gnu/expr/Compilation:thisDecl	Lgnu/bytecode/Variable;
    //   225: aload 8
    //   227: aload 8
    //   229: getfield 1664	gnu/expr/ModuleExp:thisVariable	Lgnu/bytecode/Variable;
    //   232: putfield 1667	gnu/expr/ModuleExp:closureEnv	Lgnu/bytecode/Variable;
    //   235: aload 8
    //   237: invokevirtual 1654	gnu/expr/ModuleExp:isStatic	()Z
    //   240: ifeq +481 -> 721
    //   243: aconst_null
    //   244: astore 5
    //   246: aload 8
    //   248: aload 5
    //   250: putfield 1651	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   253: aload 8
    //   255: aload_0
    //   256: invokevirtual 1670	gnu/expr/ModuleExp:allocChildClasses	(Lgnu/expr/Compilation;)V
    //   259: aload 8
    //   261: invokevirtual 1648	gnu/expr/ModuleExp:isHandlingTailCalls	()Z
    //   264: ifne +10 -> 274
    //   267: aload_0
    //   268: invokevirtual 1673	gnu/expr/Compilation:usingCPStyle	()Z
    //   271: ifeq +44 -> 315
    //   274: aload_0
    //   275: new 1675	gnu/bytecode/Variable
    //   278: dup
    //   279: ldc_w 1677
    //   282: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   285: invokespecial 1680	gnu/bytecode/Variable:<init>	(Ljava/lang/String;Lgnu/bytecode/Type;)V
    //   288: putfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   291: aload 8
    //   293: invokevirtual 1685	gnu/expr/ModuleExp:getVarScope	()Lgnu/bytecode/Scope;
    //   296: aload_0
    //   297: getfield 1661	gnu/expr/Compilation:thisDecl	Lgnu/bytecode/Variable;
    //   300: aload_0
    //   301: getfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   304: invokevirtual 1691	gnu/bytecode/Scope:addVariableAfter	(Lgnu/bytecode/Variable;Lgnu/bytecode/Variable;)V
    //   307: aload_0
    //   308: getfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   311: iconst_1
    //   312: invokevirtual 1695	gnu/bytecode/Variable:setParameter	(Z)V
    //   315: aload 8
    //   317: invokevirtual 1696	gnu/expr/ModuleExp:getLineNumber	()I
    //   320: istore_2
    //   321: iload_2
    //   322: ifle +14 -> 336
    //   325: aload 6
    //   327: aload 8
    //   329: invokevirtual 1697	gnu/expr/ModuleExp:getFileName	()Ljava/lang/String;
    //   332: iload_2
    //   333: invokevirtual 1529	gnu/bytecode/CodeAttr:putLineNumber	(Ljava/lang/String;I)V
    //   336: aload 8
    //   338: aload_0
    //   339: invokevirtual 1700	gnu/expr/ModuleExp:allocParameters	(Lgnu/expr/Compilation;)V
    //   342: aload 8
    //   344: aload_0
    //   345: invokevirtual 1703	gnu/expr/ModuleExp:enterFunction	(Lgnu/expr/Compilation;)V
    //   348: aload_0
    //   349: invokevirtual 1673	gnu/expr/Compilation:usingCPStyle	()Z
    //   352: ifeq +35 -> 387
    //   355: aload_0
    //   356: invokevirtual 1706	gnu/expr/Compilation:loadCallContext	()V
    //   359: aload 6
    //   361: getstatic 505	gnu/expr/Compilation:pcCallContextField	Lgnu/bytecode/Field;
    //   364: invokevirtual 1497	gnu/bytecode/CodeAttr:emitGetField	(Lgnu/bytecode/Field;)V
    //   367: aload_0
    //   368: aload 6
    //   370: invokevirtual 1501	gnu/bytecode/CodeAttr:startSwitch	()Lgnu/bytecode/SwitchState;
    //   373: putfield 1708	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   376: aload_0
    //   377: getfield 1708	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   380: iconst_0
    //   381: aload 6
    //   383: invokevirtual 1519	gnu/bytecode/SwitchState:addCase	(ILgnu/bytecode/CodeAttr;)Z
    //   386: pop
    //   387: aload 8
    //   389: aload_0
    //   390: invokevirtual 1711	gnu/expr/ModuleExp:compileBody	(Lgnu/expr/Compilation;)V
    //   393: aload 8
    //   395: aload_0
    //   396: invokevirtual 1714	gnu/expr/ModuleExp:compileEnd	(Lgnu/expr/Compilation;)V
    //   399: aconst_null
    //   400: astore 6
    //   402: aconst_null
    //   403: astore 5
    //   405: aconst_null
    //   406: astore 7
    //   408: aload_0
    //   409: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   412: aload_0
    //   413: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   416: if_acmpne +635 -> 1051
    //   419: aload_0
    //   420: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   423: astore 11
    //   425: aload_0
    //   426: getfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   429: astore 12
    //   431: aload_0
    //   432: aconst_null
    //   433: putfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   436: aload_0
    //   437: invokespecial 1716	gnu/expr/Compilation:startClassInit	()Lgnu/bytecode/Method;
    //   440: astore 7
    //   442: aload_0
    //   443: aload 7
    //   445: putfield 1718	gnu/expr/Compilation:clinitMethod	Lgnu/bytecode/Method;
    //   448: aload_0
    //   449: invokevirtual 982	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   452: astore 13
    //   454: new 1033	gnu/bytecode/Label
    //   457: dup
    //   458: aload 13
    //   460: invokespecial 1036	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   463: astore 6
    //   465: new 1033	gnu/bytecode/Label
    //   468: dup
    //   469: aload 13
    //   471: invokespecial 1036	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   474: astore 5
    //   476: aload 13
    //   478: aload 5
    //   480: aload 6
    //   482: invokevirtual 1722	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   485: iload 4
    //   487: ifeq +68 -> 555
    //   490: aload_0
    //   491: aload 8
    //   493: invokevirtual 1725	gnu/expr/Compilation:generateConstructor	(Lgnu/expr/LambdaExp;)V
    //   496: aload 13
    //   498: aload_0
    //   499: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   502: invokevirtual 1728	gnu/bytecode/CodeAttr:emitNew	(Lgnu/bytecode/ClassType;)V
    //   505: aload 13
    //   507: aload_0
    //   508: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   511: invokevirtual 1730	gnu/bytecode/CodeAttr:emitDup	(Lgnu/bytecode/Type;)V
    //   514: aload 13
    //   516: aload_0
    //   517: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   520: getfield 1733	gnu/bytecode/ClassType:constructor	Lgnu/bytecode/Method;
    //   523: invokevirtual 1609	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   526: aload_0
    //   527: aload_0
    //   528: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   531: ldc_w 1735
    //   534: aload_0
    //   535: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   538: bipush 25
    //   540: invokevirtual 1156	gnu/bytecode/ClassType:addField	(Ljava/lang/String;Lgnu/bytecode/Type;I)Lgnu/bytecode/Field;
    //   543: putfield 1538	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   546: aload 13
    //   548: aload_0
    //   549: getfield 1538	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   552: invokevirtual 1738	gnu/bytecode/CodeAttr:emitPutStatic	(Lgnu/bytecode/Field;)V
    //   555: aload_0
    //   556: getfield 1740	gnu/expr/Compilation:clinitChain	Lgnu/expr/Initializer;
    //   559: astore 14
    //   561: aload 14
    //   563: ifnull +168 -> 731
    //   566: aload_0
    //   567: aconst_null
    //   568: putfield 1740	gnu/expr/Compilation:clinitChain	Lgnu/expr/Initializer;
    //   571: aload_0
    //   572: aload 14
    //   574: invokespecial 1742	gnu/expr/Compilation:dumpInitializers	(Lgnu/expr/Initializer;)V
    //   577: goto -22 -> 555
    //   580: aload_0
    //   581: new 257	gnu/bytecode/ClassType
    //   584: dup
    //   585: aload_0
    //   586: ldc_w 1744
    //   589: invokevirtual 1747	gnu/expr/Compilation:generateClassName	(Ljava/lang/String;)Ljava/lang/String;
    //   592: invokespecial 1748	gnu/bytecode/ClassType:<init>	(Ljava/lang/String;)V
    //   595: putfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   598: aload_0
    //   599: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   602: aload 5
    //   604: invokevirtual 1126	gnu/bytecode/ClassType:setSuper	(Lgnu/bytecode/ClassType;)V
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   612: invokevirtual 1131	gnu/expr/Compilation:addClass	(Lgnu/bytecode/ClassType;)V
    //   615: aload_0
    //   616: aload_0
    //   617: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   620: aconst_null
    //   621: invokevirtual 1751	gnu/expr/Compilation:generateConstructor	(Lgnu/bytecode/ClassType;Lgnu/expr/LambdaExp;)V
    //   624: goto -508 -> 116
    //   627: aload 8
    //   629: getfield 1752	gnu/expr/ModuleExp:min_args	I
    //   632: aload 8
    //   634: getfield 1753	gnu/expr/ModuleExp:max_args	I
    //   637: if_icmpne +12 -> 649
    //   640: aload 8
    //   642: getfield 1752	gnu/expr/ModuleExp:min_args	I
    //   645: iconst_4
    //   646: if_icmple +26 -> 672
    //   649: iconst_1
    //   650: anewarray 248	gnu/bytecode/Type
    //   653: astore 5
    //   655: aload 5
    //   657: iconst_0
    //   658: new 287	gnu/bytecode/ArrayType
    //   661: dup
    //   662: getstatic 253	gnu/expr/Compilation:typeObject	Lgnu/bytecode/ClassType;
    //   665: invokespecial 1755	gnu/bytecode/ArrayType:<init>	(Lgnu/bytecode/Type;)V
    //   668: aastore
    //   669: goto -511 -> 158
    //   672: aload 8
    //   674: getfield 1752	gnu/expr/ModuleExp:min_args	I
    //   677: istore_2
    //   678: iload_2
    //   679: anewarray 248	gnu/bytecode/Type
    //   682: astore 6
    //   684: iload_2
    //   685: iconst_1
    //   686: isub
    //   687: istore_2
    //   688: aload 6
    //   690: astore 5
    //   692: iload_2
    //   693: iflt -535 -> 158
    //   696: aload 6
    //   698: iload_2
    //   699: getstatic 253	gnu/expr/Compilation:typeObject	Lgnu/bytecode/ClassType;
    //   702: aastore
    //   703: goto -19 -> 684
    //   706: aload 8
    //   708: aload 8
    //   710: getfield 1129	gnu/expr/ModuleExp:type	Lgnu/bytecode/ClassType;
    //   713: invokevirtual 1759	gnu/expr/ModuleExp:declareThis	(Lgnu/bytecode/ClassType;)Lgnu/bytecode/Variable;
    //   716: astore 5
    //   718: goto -499 -> 219
    //   721: aload 8
    //   723: getfield 1664	gnu/expr/ModuleExp:thisVariable	Lgnu/bytecode/Variable;
    //   726: astore 5
    //   728: goto -482 -> 246
    //   731: aload 8
    //   733: invokevirtual 1762	gnu/expr/ModuleExp:staticInitRun	()Z
    //   736: ifeq +27 -> 763
    //   739: aload 13
    //   741: aload_0
    //   742: getfield 1538	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   745: invokevirtual 1224	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   748: aload 13
    //   750: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   753: ldc_w 1656
    //   756: iconst_0
    //   757: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   760: invokevirtual 1017	gnu/bytecode/CodeAttr:emitInvoke	(Lgnu/bytecode/Method;)V
    //   763: aload 13
    //   765: invokevirtual 1586	gnu/bytecode/CodeAttr:emitReturn	()V
    //   768: aload_0
    //   769: getfield 1494	gnu/expr/Compilation:moduleClass	Lgnu/bytecode/ClassType;
    //   772: aload_0
    //   773: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   776: if_acmpeq +263 -> 1039
    //   779: iload 4
    //   781: ifne +258 -> 1039
    //   784: aload_0
    //   785: getfield 561	gnu/expr/Compilation:generateMain	Z
    //   788: ifne +251 -> 1039
    //   791: aload_0
    //   792: getfield 1209	gnu/expr/Compilation:immediate	Z
    //   795: ifne +244 -> 1039
    //   798: aload_0
    //   799: aload_0
    //   800: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   803: ldc_w 1656
    //   806: iconst_1
    //   807: getstatic 350	gnu/bytecode/Type:typeArray0	[Lgnu/bytecode/Type;
    //   810: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   813: invokevirtual 678	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   816: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   819: aload_0
    //   820: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   823: invokevirtual 952	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   826: astore 13
    //   828: aload 13
    //   830: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   833: invokevirtual 1012	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   836: astore 14
    //   838: aload 13
    //   840: getstatic 489	gnu/expr/Compilation:typeConsumer	Lgnu/bytecode/ClassType;
    //   843: invokevirtual 1012	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   846: astore 15
    //   848: aload 13
    //   850: getstatic 1765	gnu/bytecode/Type:javalangThrowableType	Lgnu/bytecode/ClassType;
    //   853: invokevirtual 1012	gnu/bytecode/CodeAttr:addLocal	(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;
    //   856: astore 16
    //   858: aload 13
    //   860: getstatic 493	gnu/expr/Compilation:getCallContextInstanceMethod	Lgnu/bytecode/Method;
    //   863: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   866: aload 13
    //   868: aload 14
    //   870: invokevirtual 1024	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   873: getstatic 485	gnu/expr/Compilation:typeCallContext	Lgnu/bytecode/ClassType;
    //   876: ldc_w 1767
    //   879: invokevirtual 365	gnu/bytecode/ClassType:getDeclaredField	(Ljava/lang/String;)Lgnu/bytecode/Field;
    //   882: astore 17
    //   884: aload 13
    //   886: aload 14
    //   888: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   891: aload 13
    //   893: aload 17
    //   895: invokevirtual 1497	gnu/bytecode/CodeAttr:emitGetField	(Lgnu/bytecode/Field;)V
    //   898: aload 13
    //   900: aload 15
    //   902: invokevirtual 1024	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   905: aload 13
    //   907: aload 14
    //   909: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   912: aload 13
    //   914: ldc_w 1769
    //   917: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   920: ldc_w 1771
    //   923: invokevirtual 365	gnu/bytecode/ClassType:getDeclaredField	(Ljava/lang/String;)Lgnu/bytecode/Field;
    //   926: invokevirtual 1224	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   929: aload 13
    //   931: aload 17
    //   933: invokevirtual 1774	gnu/bytecode/CodeAttr:emitPutField	(Lgnu/bytecode/Field;)V
    //   936: aload 13
    //   938: iconst_0
    //   939: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   942: invokevirtual 1778	gnu/bytecode/CodeAttr:emitTryStart	(ZLgnu/bytecode/Type;)V
    //   945: aload 13
    //   947: invokevirtual 1183	gnu/bytecode/CodeAttr:emitPushThis	()V
    //   950: aload 13
    //   952: aload 14
    //   954: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   957: aload 13
    //   959: aload 11
    //   961: invokevirtual 1000	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   964: aload 13
    //   966: invokevirtual 1213	gnu/bytecode/CodeAttr:emitPushNull	()V
    //   969: aload 13
    //   971: aload 16
    //   973: invokevirtual 1024	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   976: aload 13
    //   978: invokevirtual 1781	gnu/bytecode/CodeAttr:emitTryEnd	()V
    //   981: aload 13
    //   983: aload 16
    //   985: invokevirtual 1784	gnu/bytecode/CodeAttr:emitCatchStart	(Lgnu/bytecode/Variable;)V
    //   988: aload 13
    //   990: invokevirtual 1787	gnu/bytecode/CodeAttr:emitCatchEnd	()V
    //   993: aload 13
    //   995: invokevirtual 1790	gnu/bytecode/CodeAttr:emitTryCatchEnd	()V
    //   998: aload 13
    //   1000: aload 14
    //   1002: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1005: aload 13
    //   1007: aload 16
    //   1009: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1012: aload 13
    //   1014: aload 15
    //   1016: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1019: aload 13
    //   1021: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   1024: ldc_w 1792
    //   1027: iconst_3
    //   1028: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1031: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1034: aload 13
    //   1036: invokevirtual 1586	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1039: aload_0
    //   1040: aload 11
    //   1042: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1045: aload_0
    //   1046: aload 12
    //   1048: putfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   1051: aload 8
    //   1053: aload_0
    //   1054: invokevirtual 1795	gnu/expr/ModuleExp:generateApplyMethods	(Lgnu/expr/Compilation;)V
    //   1057: aload_0
    //   1058: aload 9
    //   1060: putfield 1645	gnu/expr/Compilation:curLambda	Lgnu/expr/LambdaExp;
    //   1063: aload 8
    //   1065: aload 10
    //   1067: putfield 1651	gnu/expr/ModuleExp:heapFrame	Lgnu/bytecode/Variable;
    //   1070: aload_0
    //   1071: invokevirtual 1673	gnu/expr/Compilation:usingCPStyle	()Z
    //   1074: ifeq +18 -> 1092
    //   1077: aload_0
    //   1078: invokevirtual 982	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   1081: astore 8
    //   1083: aload_0
    //   1084: getfield 1708	gnu/expr/Compilation:fswitch	Lgnu/bytecode/SwitchState;
    //   1087: aload 8
    //   1089: invokevirtual 1594	gnu/bytecode/SwitchState:finish	(Lgnu/bytecode/CodeAttr;)V
    //   1092: aload 6
    //   1094: ifnonnull +10 -> 1104
    //   1097: aload_0
    //   1098: getfield 1682	gnu/expr/Compilation:callContextVar	Lgnu/bytecode/Variable;
    //   1101: ifnull +102 -> 1203
    //   1104: aload_0
    //   1105: aload 7
    //   1107: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1110: aload_0
    //   1111: invokevirtual 982	gnu/expr/Compilation:getCode	()Lgnu/bytecode/CodeAttr;
    //   1114: astore 7
    //   1116: new 1033	gnu/bytecode/Label
    //   1119: dup
    //   1120: aload 7
    //   1122: invokespecial 1036	gnu/bytecode/Label:<init>	(Lgnu/bytecode/CodeAttr;)V
    //   1125: astore 8
    //   1127: aload 7
    //   1129: aload 6
    //   1131: aload 8
    //   1133: invokevirtual 1722	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   1136: aload_0
    //   1137: getfield 1797	gnu/expr/Compilation:callContextVarForInit	Lgnu/bytecode/Variable;
    //   1140: ifnull +20 -> 1160
    //   1143: aload 7
    //   1145: getstatic 493	gnu/expr/Compilation:getCallContextInstanceMethod	Lgnu/bytecode/Method;
    //   1148: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1151: aload 7
    //   1153: aload_0
    //   1154: getfield 1797	gnu/expr/Compilation:callContextVarForInit	Lgnu/bytecode/Variable;
    //   1157: invokevirtual 1024	gnu/bytecode/CodeAttr:emitStore	(Lgnu/bytecode/Variable;)V
    //   1160: aload_0
    //   1161: getfield 1209	gnu/expr/Compilation:immediate	Z
    //   1164: ifeq +656 -> 1820
    //   1167: aload 7
    //   1169: aload_0
    //   1170: invokestatic 1799	gnu/expr/Compilation:registerForImmediateLiterals	(Lgnu/expr/Compilation;)I
    //   1173: invokevirtual 995	gnu/bytecode/CodeAttr:emitPushInt	(I)V
    //   1176: aload 7
    //   1178: ldc_w 1801
    //   1181: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1184: ldc_w 1802
    //   1187: iconst_1
    //   1188: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1191: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1194: aload 7
    //   1196: aload 8
    //   1198: aload 5
    //   1200: invokevirtual 1722	gnu/bytecode/CodeAttr:fixupChain	(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V
    //   1203: aload_0
    //   1204: getfield 561	gnu/expr/Compilation:generateMain	Z
    //   1207: ifeq +168 -> 1375
    //   1210: aload_0
    //   1211: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1214: aload_0
    //   1215: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   1218: if_acmpne +157 -> 1375
    //   1221: new 287	gnu/bytecode/ArrayType
    //   1224: dup
    //   1225: getstatic 269	gnu/expr/Compilation:javaStringType	Lgnu/bytecode/ClassType;
    //   1228: invokespecial 1755	gnu/bytecode/ArrayType:<init>	(Lgnu/bytecode/Type;)V
    //   1231: astore 5
    //   1233: aload_0
    //   1234: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1237: astore 6
    //   1239: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1242: astore 7
    //   1244: aload_0
    //   1245: aload 6
    //   1247: ldc_w 1804
    //   1250: bipush 9
    //   1252: iconst_1
    //   1253: anewarray 248	gnu/bytecode/Type
    //   1256: dup
    //   1257: iconst_0
    //   1258: aload 5
    //   1260: aastore
    //   1261: aload 7
    //   1263: invokevirtual 678	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1266: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1269: aload_0
    //   1270: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1273: invokevirtual 952	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1276: astore 5
    //   1278: getstatic 1809	kawa/Shell:defaultFormatName	Ljava/lang/String;
    //   1281: ifnull +29 -> 1310
    //   1284: aload 5
    //   1286: getstatic 1809	kawa/Shell:defaultFormatName	Ljava/lang/String;
    //   1289: invokevirtual 1216	gnu/bytecode/CodeAttr:emitPushString	(Ljava/lang/String;)V
    //   1292: aload 5
    //   1294: ldc_w 1811
    //   1297: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1300: ldc_w 1813
    //   1303: iconst_1
    //   1304: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1307: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1310: aload 5
    //   1312: aload 5
    //   1314: iconst_0
    //   1315: invokevirtual 1004	gnu/bytecode/CodeAttr:getArg	(I)Lgnu/bytecode/Variable;
    //   1318: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1321: aload 5
    //   1323: ldc_w 1815
    //   1326: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1329: ldc_w 1817
    //   1332: iconst_1
    //   1333: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1336: invokevirtual 977	gnu/bytecode/CodeAttr:emitInvokeStatic	(Lgnu/bytecode/Method;)V
    //   1339: aload_0
    //   1340: getfield 1538	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   1343: ifnull +519 -> 1862
    //   1346: aload 5
    //   1348: aload_0
    //   1349: getfield 1538	gnu/expr/Compilation:moduleInstanceMainField	Lgnu/bytecode/Field;
    //   1352: invokevirtual 1224	gnu/bytecode/CodeAttr:emitGetStatic	(Lgnu/bytecode/Field;)V
    //   1355: aload 5
    //   1357: getstatic 469	gnu/expr/Compilation:typeModuleBody	Lgnu/bytecode/ClassType;
    //   1360: ldc_w 1819
    //   1363: iconst_0
    //   1364: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1367: invokevirtual 1000	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   1370: aload 5
    //   1372: invokevirtual 1586	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1375: aload_0
    //   1376: getfield 1195	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   1379: ifnull +632 -> 2011
    //   1382: aload_0
    //   1383: getfield 1195	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   1386: invokevirtual 1822	gnu/expr/ModuleInfo:getNamespaceUri	()Ljava/lang/String;
    //   1389: ifnull +622 -> 2011
    //   1392: invokestatic 1827	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   1395: astore 9
    //   1397: aload_0
    //   1398: getfield 873	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   1401: invokevirtual 898	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   1404: astore 5
    //   1406: aload 5
    //   1408: bipush 46
    //   1410: invokevirtual 1829	java/lang/String:lastIndexOf	(I)I
    //   1413: istore_2
    //   1414: iload_2
    //   1415: ifge +480 -> 1895
    //   1418: ldc_w 535
    //   1421: astore 5
    //   1423: new 257	gnu/bytecode/ClassType
    //   1426: dup
    //   1427: new 1140	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1434: aload 5
    //   1436: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: ldc_w 1831
    //   1442: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1448: invokespecial 1748	gnu/bytecode/ClassType:<init>	(Ljava/lang/String;)V
    //   1451: astore 6
    //   1453: ldc_w 1833
    //   1456: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1459: astore 7
    //   1461: aload 6
    //   1463: aload 7
    //   1465: invokevirtual 1126	gnu/bytecode/ClassType:setSuper	(Lgnu/bytecode/ClassType;)V
    //   1468: aload_0
    //   1469: aload 6
    //   1471: invokespecial 1096	gnu/expr/Compilation:registerClass	(Lgnu/bytecode/ClassType;)V
    //   1474: aload_0
    //   1475: aload 6
    //   1477: ldc_w 664
    //   1480: iconst_1
    //   1481: getstatic 400	gnu/expr/Compilation:apply0args	[Lgnu/bytecode/Type;
    //   1484: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1487: invokevirtual 678	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1490: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1493: aload 7
    //   1495: ldc_w 664
    //   1498: iconst_1
    //   1499: getstatic 400	gnu/expr/Compilation:apply0args	[Lgnu/bytecode/Type;
    //   1502: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1505: invokevirtual 678	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;
    //   1508: astore 7
    //   1510: aload_0
    //   1511: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1514: invokevirtual 952	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1517: astore 8
    //   1519: aload 8
    //   1521: invokevirtual 1183	gnu/bytecode/CodeAttr:emitPushThis	()V
    //   1524: aload 8
    //   1526: aload 7
    //   1528: invokevirtual 1609	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   1531: aload 8
    //   1533: invokevirtual 1586	gnu/bytecode/CodeAttr:emitReturn	()V
    //   1536: ldc_w 1835
    //   1539: invokestatic 261	gnu/bytecode/ClassType:make	(Ljava/lang/String;)Lgnu/bytecode/ClassType;
    //   1542: astore 7
    //   1544: getstatic 433	gnu/bytecode/Type:voidType	Lgnu/bytecode/PrimType;
    //   1547: astore 8
    //   1549: aload_0
    //   1550: aload 6
    //   1552: ldc_w 1837
    //   1555: iconst_1
    //   1556: anewarray 248	gnu/bytecode/Type
    //   1559: dup
    //   1560: iconst_0
    //   1561: aload 7
    //   1563: aastore
    //   1564: aload 8
    //   1566: iconst_1
    //   1567: invokevirtual 354	gnu/bytecode/ClassType:addMethod	(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;
    //   1570: putfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1573: aload_0
    //   1574: getfield 948	gnu/expr/Compilation:method	Lgnu/bytecode/Method;
    //   1577: invokevirtual 952	gnu/bytecode/Method:startCode	()Lgnu/bytecode/CodeAttr;
    //   1580: astore 10
    //   1582: aload 7
    //   1584: ldc_w 1837
    //   1587: iconst_3
    //   1588: invokevirtual 339	gnu/bytecode/ClassType:getDeclaredMethod	(Ljava/lang/String;I)Lgnu/bytecode/Method;
    //   1591: astore 11
    //   1593: aload 9
    //   1595: getfield 1840	gnu/expr/ModuleManager:numModules	I
    //   1598: istore_2
    //   1599: iload_2
    //   1600: iconst_1
    //   1601: isub
    //   1602: istore_3
    //   1603: iload_3
    //   1604: iflt +402 -> 2006
    //   1607: aload 9
    //   1609: getfield 1844	gnu/expr/ModuleManager:modules	[Lgnu/expr/ModuleInfo;
    //   1612: iload_3
    //   1613: aaload
    //   1614: astore 13
    //   1616: aload 13
    //   1618: invokevirtual 1847	gnu/expr/ModuleInfo:getClassName	()Ljava/lang/String;
    //   1621: astore 6
    //   1623: iload_3
    //   1624: istore_2
    //   1625: aload 6
    //   1627: ifnull -28 -> 1599
    //   1630: iload_3
    //   1631: istore_2
    //   1632: aload 6
    //   1634: aload 5
    //   1636: invokevirtual 829	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1639: ifeq -40 -> 1599
    //   1642: aload 13
    //   1644: getfield 1850	gnu/expr/ModuleInfo:sourcePath	Ljava/lang/String;
    //   1647: astore 7
    //   1649: aload 13
    //   1651: invokevirtual 1822	gnu/expr/ModuleInfo:getNamespaceUri	()Ljava/lang/String;
    //   1654: astore 12
    //   1656: aload 10
    //   1658: aload 10
    //   1660: iconst_1
    //   1661: invokevirtual 1004	gnu/bytecode/CodeAttr:getArg	(I)Lgnu/bytecode/Variable;
    //   1664: invokevirtual 992	gnu/bytecode/CodeAttr:emitLoad	(Lgnu/bytecode/Variable;)V
    //   1667: aload_0
    //   1668: aload 6
    //   1670: invokevirtual 1315	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1673: aload 7
    //   1675: astore 6
    //   1677: aload 7
    //   1679: invokestatic 1856	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   1682: invokevirtual 1859	gnu/text/Path:isAbsolute	()Z
    //   1685: ifne +111 -> 1796
    //   1688: getstatic 1863	java/io/File:separatorChar	C
    //   1691: istore_1
    //   1692: aload 9
    //   1694: invokevirtual 1866	gnu/expr/ModuleManager:getCompilationDirectory	()Ljava/lang/String;
    //   1697: astore 6
    //   1699: new 1140	java/lang/StringBuilder
    //   1702: dup
    //   1703: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1706: aload 6
    //   1708: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: aload 5
    //   1713: bipush 46
    //   1715: iload_1
    //   1716: invokevirtual 1390	java/lang/String:replace	(CC)Ljava/lang/String;
    //   1719: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1725: invokestatic 1870	gnu/text/Path:toURL	(Ljava/lang/String;)Ljava/net/URL;
    //   1728: invokevirtual 1873	java/net/URL:toString	()Ljava/lang/String;
    //   1731: astore 8
    //   1733: aload 8
    //   1735: invokevirtual 604	java/lang/String:length	()I
    //   1738: istore_2
    //   1739: aload 8
    //   1741: astore 6
    //   1743: iload_2
    //   1744: ifle +40 -> 1784
    //   1747: aload 8
    //   1749: astore 6
    //   1751: aload 8
    //   1753: iload_2
    //   1754: iconst_1
    //   1755: isub
    //   1756: invokevirtual 608	java/lang/String:charAt	(I)C
    //   1759: iload_1
    //   1760: if_icmpeq +24 -> 1784
    //   1763: new 1140	java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1770: aload 8
    //   1772: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: iload_1
    //   1776: invokevirtual 1876	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1779: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: astore 6
    //   1784: aload 13
    //   1786: invokevirtual 1879	gnu/expr/ModuleInfo:getSourceAbsPathname	()Ljava/lang/String;
    //   1789: aload 6
    //   1791: invokestatic 1883	gnu/text/Path:relativize	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1794: astore 6
    //   1796: aload_0
    //   1797: aload 6
    //   1799: invokevirtual 1315	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1802: aload_0
    //   1803: aload 12
    //   1805: invokevirtual 1315	gnu/expr/Compilation:compileConstant	(Ljava/lang/Object;)V
    //   1808: aload 10
    //   1810: aload 11
    //   1812: invokevirtual 1000	gnu/bytecode/CodeAttr:emitInvokeVirtual	(Lgnu/bytecode/Method;)V
    //   1815: iload_3
    //   1816: istore_2
    //   1817: goto -218 -> 1599
    //   1820: aload_0
    //   1821: getfield 906	gnu/expr/Compilation:litTable	Lgnu/expr/LitTable;
    //   1824: invokevirtual 1885	gnu/expr/LitTable:emit	()V
    //   1827: goto -633 -> 1194
    //   1830: astore 6
    //   1832: aload_0
    //   1833: bipush 101
    //   1835: new 1140	java/lang/StringBuilder
    //   1838: dup
    //   1839: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1842: ldc_w 1887
    //   1845: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: aload 6
    //   1850: invokevirtual 1573	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1853: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokevirtual 1332	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   1859: goto -665 -> 1194
    //   1862: aload 5
    //   1864: aload_0
    //   1865: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1868: invokevirtual 1728	gnu/bytecode/CodeAttr:emitNew	(Lgnu/bytecode/ClassType;)V
    //   1871: aload 5
    //   1873: aload_0
    //   1874: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1877: invokevirtual 1730	gnu/bytecode/CodeAttr:emitDup	(Lgnu/bytecode/Type;)V
    //   1880: aload 5
    //   1882: aload_0
    //   1883: getfield 945	gnu/expr/Compilation:curClass	Lgnu/bytecode/ClassType;
    //   1886: getfield 1733	gnu/bytecode/ClassType:constructor	Lgnu/bytecode/Method;
    //   1889: invokevirtual 1609	gnu/bytecode/CodeAttr:emitInvokeSpecial	(Lgnu/bytecode/Method;)V
    //   1892: goto -537 -> 1355
    //   1895: aload 5
    //   1897: iconst_0
    //   1898: iload_2
    //   1899: invokevirtual 836	java/lang/String:substring	(II)Ljava/lang/String;
    //   1902: astore 6
    //   1904: aload 9
    //   1906: aload 6
    //   1908: invokevirtual 1890	gnu/expr/ModuleManager:loadPackageInfo	(Ljava/lang/String;)V
    //   1911: aload 5
    //   1913: iconst_0
    //   1914: iload_2
    //   1915: iconst_1
    //   1916: iadd
    //   1917: invokevirtual 836	java/lang/String:substring	(II)Ljava/lang/String;
    //   1920: astore 5
    //   1922: goto -499 -> 1423
    //   1925: astore 7
    //   1927: aload_0
    //   1928: bipush 101
    //   1930: new 1140	java/lang/StringBuilder
    //   1933: dup
    //   1934: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1937: ldc_w 1892
    //   1940: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: aload 6
    //   1945: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: ldc_w 1894
    //   1951: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1954: aload 7
    //   1956: invokevirtual 1573	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1959: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1962: invokevirtual 1332	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   1965: goto -54 -> 1911
    //   1968: astore 5
    //   1970: new 936	gnu/mapping/WrappedException
    //   1973: dup
    //   1974: new 1140	java/lang/StringBuilder
    //   1977: dup
    //   1978: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   1981: ldc_w 1896
    //   1984: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: aload 7
    //   1989: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: bipush 39
    //   1994: invokevirtual 1876	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1997: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2000: aload 5
    //   2002: invokespecial 941	gnu/mapping/WrappedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2005: athrow
    //   2006: aload 10
    //   2008: invokevirtual 1586	gnu/bytecode/CodeAttr:emitReturn	()V
    //   2011: return
    //   2012: astore 6
    //   2014: goto -103 -> 1911
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2017	0	this	Compilation
    //   1691	85	1	c	char
    //   320	1597	2	i	int
    //   1602	214	3	j	int
    //   170	610	4	bool	boolean
    //   15	1906	5	localObject1	Object
    //   1968	33	5	localThrowable1	Throwable
    //   204	1594	6	localObject2	Object
    //   1830	19	6	localThrowable2	Throwable
    //   1902	42	6	str	String
    //   2012	1	6	localClassNotFoundException	ClassNotFoundException
    //   406	1272	7	localObject3	Object
    //   1925	63	7	localThrowable3	Throwable
    //   4	1767	8	localObject4	Object
    //   129	1776	9	localObject5	Object
    //   163	1844	10	localObject6	Object
    //   423	1388	11	localMethod	Method
    //   429	1375	12	localObject7	Object
    //   452	1333	13	localObject8	Object
    //   559	442	14	localObject9	Object
    //   846	169	15	localVariable1	Variable
    //   856	152	16	localVariable2	Variable
    //   882	50	17	localField	gnu.bytecode.Field
    // Exception table:
    //   from	to	target	type
    //   1160	1194	1830	java/lang/Throwable
    //   1820	1827	1830	java/lang/Throwable
    //   1904	1911	1925	java/lang/Throwable
    //   1688	1739	1968	java/lang/Throwable
    //   1751	1784	1968	java/lang/Throwable
    //   1784	1796	1968	java/lang/Throwable
    //   1904	1911	2012	java/lang/ClassNotFoundException
  }
  
  public String generateClassName(String paramString)
  {
    String str = mangleName(paramString, true);
    if (this.mainClass != null) {
      paramString = this.mainClass.getName() + '$' + str;
    }
    while (findNamedClass(paramString) == null)
    {
      return paramString;
      paramString = str;
      if (this.classPrefix != null) {
        paramString = this.classPrefix + str;
      }
    }
    int i = 0;
    for (;;)
    {
      str = paramString + i;
      if (findNamedClass(str) == null) {
        return str;
      }
      i += 1;
    }
  }
  
  public final void generateConstructor(ClassType paramClassType, LambdaExp paramLambdaExp)
  {
    Method localMethod = this.method;
    Variable localVariable = this.callContextVar;
    this.callContextVar = null;
    ClassType localClassType = this.curClass;
    this.curClass = paramClassType;
    Object localObject = getConstructor(paramClassType, paramLambdaExp);
    paramClassType.constructor = ((Method)localObject);
    this.method = ((Method)localObject);
    localObject = ((Method)localObject).startCode();
    if (((paramLambdaExp instanceof ClassExp)) && (paramLambdaExp.staticLinkField != null))
    {
      ((CodeAttr)localObject).emitPushThis();
      ((CodeAttr)localObject).emitLoad(((CodeAttr)localObject).getCurrentScope().getVariable(1));
      ((CodeAttr)localObject).emitPutField(paramLambdaExp.staticLinkField);
    }
    ClassExp.invokeDefaultSuperConstructor(paramClassType.getSuperclass(), this, paramLambdaExp);
    if ((this.curClass == this.mainClass) && (this.minfo != null) && (this.minfo.sourcePath != null))
    {
      ((CodeAttr)localObject).emitPushThis();
      ((CodeAttr)localObject).emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
    }
    if ((paramLambdaExp != null) && (paramLambdaExp.initChain != null))
    {
      paramClassType = this.curLambda;
      this.curLambda = new LambdaExp();
      this.curLambda.closureEnv = ((CodeAttr)localObject).getArg(0);
      this.curLambda.outer = paramClassType;
      for (;;)
      {
        Initializer localInitializer = paramLambdaExp.initChain;
        if (localInitializer == null) {
          break;
        }
        paramLambdaExp.initChain = null;
        dumpInitializers(localInitializer);
      }
      this.curLambda = paramClassType;
    }
    if ((paramLambdaExp instanceof ClassExp)) {
      callInitMethods(((ClassExp)paramLambdaExp).getCompiledClassType(this), new Vector(10));
    }
    ((CodeAttr)localObject).emitReturn();
    this.method = localMethod;
    this.curClass = localClassType;
    this.callContextVar = localVariable;
  }
  
  public final void generateConstructor(LambdaExp paramLambdaExp)
  {
    generateConstructor(paramLambdaExp.getHeapFrameType(), paramLambdaExp);
  }
  
  public void generateMatchMethods(LambdaExp paramLambdaExp)
  {
    if (paramLambdaExp.applyMethods == null) {}
    for (int i = 0; i == 0; i = paramLambdaExp.applyMethods.size()) {
      return;
    }
    Method localMethod = this.method;
    ClassType localClassType1 = this.curClass;
    ClassType localClassType2 = typeModuleMethod;
    this.curClass = paramLambdaExp.getHeapFrameType();
    if (!this.curClass.getSuperclass().isSubtype(typeModuleBody)) {
      this.curClass = this.moduleClass;
    }
    CodeAttr localCodeAttr = null;
    int j = 0;
    while (j <= 5)
    {
      int m = 0;
      SwitchState localSwitchState = null;
      String str = null;
      Type[] arrayOfType = null;
      int k = i;
      int i1;
      LambdaExp localLambdaExp;
      int i3;
      label159:
      int i2;
      do
      {
        do
        {
          do
          {
            i1 = k - 1;
            if (i1 < 0) {
              break label911;
            }
            localLambdaExp = (LambdaExp)paramLambdaExp.applyMethods.elementAt(i1);
            i3 = localLambdaExp.primMethods.length;
            if ((localLambdaExp.max_args >= 0) && (localLambdaExp.max_args < localLambdaExp.min_args + i3)) {
              break;
            }
            n = 1;
            if (j >= 5) {
              break label292;
            }
            i2 = j - localLambdaExp.min_args;
            k = i1;
          } while (i2 < 0);
          k = i1;
        } while (i2 >= i3);
        if (i2 != i3 - 1) {
          break;
        }
        k = i1;
      } while (n != 0);
      for (k = i2;; k = i3 - 1)
      {
        n = m;
        if (m != 0) {
          break label408;
        }
        if (j >= 5) {
          break label664;
        }
        str = "match" + j;
        arrayOfType = new Type[j + 2];
        m = j;
        while (m >= 0)
        {
          arrayOfType[(m + 1)] = typeObject;
          m -= 1;
        }
        n = 0;
        break label159;
        label292:
        k = 5 - localLambdaExp.min_args;
        if ((k > 0) && (i3 <= k))
        {
          k = i1;
          if (n == 0) {
            break;
          }
        }
      }
      arrayOfType[(j + 1)] = typeCallContext;
      arrayOfType[0] = localClassType2;
      this.method = this.curClass.addMethod(str, arrayOfType, Type.intType, 1);
      localCodeAttr = this.method.startCode();
      localCodeAttr.emitLoad(localCodeAttr.getArg(1));
      localCodeAttr.emitGetField(localClassType2.getField("selector"));
      localSwitchState = localCodeAttr.startSwitch();
      int n = 1;
      label408:
      localSwitchState.addCase(localLambdaExp.getSelectorValue(this), localCodeAttr);
      m = localLambdaExp.getLineNumber();
      if (m > 0) {
        localCodeAttr.putLineNumber(localLambdaExp.getFileName(), m);
      }
      label454:
      Variable localVariable;
      Declaration localDeclaration;
      label478:
      Type localType;
      if (j == 5)
      {
        m = 3;
        localVariable = localCodeAttr.getArg(m);
        if (j >= 5) {
          break label765;
        }
        localDeclaration = localLambdaExp.firstDecl();
        m = 1;
        if (m > j) {
          break label797;
        }
        localCodeAttr.emitLoad(localVariable);
        localCodeAttr.emitLoad(localCodeAttr.getArg(m + 1));
        localType = localDeclaration.getType();
        if (localType != Type.objectType)
        {
          if (!(localType instanceof TypeValue)) {
            break label700;
          }
          Label localLabel1 = new Label(localCodeAttr);
          Label localLabel2 = new Label(localCodeAttr);
          ConditionalTarget localConditionalTarget = new ConditionalTarget(localLabel1, localLabel2, getLanguage());
          localCodeAttr.emitDup();
          ((TypeValue)localType).emitIsInstance(null, this, localConditionalTarget);
          localLabel2.define(localCodeAttr);
          localCodeAttr.emitPushInt(0xFFF40000 | m);
          localCodeAttr.emitReturn();
          localLabel1.define(localCodeAttr);
        }
      }
      for (;;)
      {
        localCodeAttr.emitPutField(typeCallContext.getField("value" + m));
        localDeclaration = localDeclaration.nextDecl();
        m += 1;
        break label478;
        label664:
        str = "matchN";
        arrayOfType = new Type[3];
        arrayOfType[1] = objArrayType;
        arrayOfType[2] = typeCallContext;
        break;
        m = j + 2;
        break label454;
        label700:
        if (((localType instanceof ClassType)) && (localType != Type.objectType) && (localType != Type.toStringType))
        {
          localCodeAttr.emitDup();
          localType.emitIsInstance(localCodeAttr);
          localCodeAttr.emitIfIntEqZero();
          localCodeAttr.emitPushInt(0xFFF40000 | m);
          localCodeAttr.emitReturn();
          localCodeAttr.emitFi();
        }
      }
      label765:
      localCodeAttr.emitLoad(localVariable);
      localCodeAttr.emitLoad(localCodeAttr.getArg(2));
      localCodeAttr.emitPutField(typeCallContext.getField("values"));
      label797:
      localCodeAttr.emitLoad(localVariable);
      if (defaultCallConvention < 2)
      {
        localCodeAttr.emitLoad(localCodeAttr.getArg(1));
        label822:
        localCodeAttr.emitPutField(procCallContextField);
        localCodeAttr.emitLoad(localVariable);
        if (defaultCallConvention < 2) {
          break label902;
        }
        localCodeAttr.emitPushInt(localLambdaExp.getSelectorValue(this) + k);
      }
      for (;;)
      {
        localCodeAttr.emitPutField(pcCallContextField);
        localCodeAttr.emitPushInt(0);
        localCodeAttr.emitReturn();
        k = i1;
        m = n;
        break;
        localCodeAttr.emitLoad(localCodeAttr.getArg(0));
        break label822;
        label902:
        localCodeAttr.emitPushInt(j);
      }
      label911:
      if (m != 0)
      {
        localSwitchState.addDefault(localCodeAttr);
        if (j > 4) {}
        for (k = 2;; k = j + 1)
        {
          m = 0;
          while (m <= k + 1)
          {
            localCodeAttr.emitLoad(localCodeAttr.getArg(m));
            m += 1;
          }
        }
        localCodeAttr.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(str, arrayOfType.length));
        localCodeAttr.emitReturn();
        localSwitchState.finish(localCodeAttr);
      }
      j += 1;
    }
    this.method = localMethod;
    this.curClass = localClassType1;
  }
  
  public boolean generatingApplet()
  {
    return (this.langOptions & 0x10) != 0;
  }
  
  public boolean generatingServlet()
  {
    return (this.langOptions & 0x20) != 0;
  }
  
  public final boolean getBooleanOption(String paramString)
  {
    return this.currentOptions.getBoolean(paramString);
  }
  
  public final boolean getBooleanOption(String paramString, boolean paramBoolean)
  {
    return this.currentOptions.getBoolean(paramString, paramBoolean);
  }
  
  public final CodeAttr getCode()
  {
    return this.method.getCode();
  }
  
  public final int getColumnNumber()
  {
    return this.messages.getColumnNumber();
  }
  
  public final Method getConstructor(LambdaExp paramLambdaExp)
  {
    return getConstructor(paramLambdaExp.getHeapFrameType(), paramLambdaExp);
  }
  
  public final String getFileName()
  {
    return this.messages.getFileName();
  }
  
  public Method getForNameHelper()
  {
    if (this.forNameHelper == null)
    {
      Method localMethod = this.method;
      this.method = this.curClass.addMethod("class$", 9, string1Arg, typeClass);
      this.forNameHelper = this.method;
      CodeAttr localCodeAttr = this.method.startCode();
      localCodeAttr.emitLoad(localCodeAttr.getArg(0));
      localCodeAttr.emitPushInt(0);
      localCodeAttr.emitPushString(this.mainClass.getName());
      localCodeAttr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 1));
      localCodeAttr.emitInvokeVirtual(typeClass.getDeclaredMethod("getClassLoader", 0));
      localCodeAttr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 3));
      localCodeAttr.emitReturn();
      this.method = localMethod;
    }
    return this.forNameHelper;
  }
  
  public Language getLanguage()
  {
    return this.language;
  }
  
  public final int getLineNumber()
  {
    return this.messages.getLineNumber();
  }
  
  public SourceMessages getMessages()
  {
    return this.messages;
  }
  
  public final ModuleExp getModule()
  {
    return this.mainLambda;
  }
  
  public final ClassType getModuleType()
  {
    if (defaultCallConvention >= 2) {
      return typeModuleWithContext;
    }
    return typeModuleBody;
  }
  
  public String getPublicId()
  {
    return this.messages.getPublicId();
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getSystemId()
  {
    return this.messages.getSystemId();
  }
  
  public boolean inlineOk(Expression paramExpression)
  {
    if ((paramExpression instanceof LambdaExp))
    {
      paramExpression = (LambdaExp)paramExpression;
      Declaration localDeclaration = paramExpression.nameDecl;
      if ((localDeclaration == null) || (localDeclaration.getSymbol() == null) || (!(localDeclaration.context instanceof ModuleExp))) {
        return true;
      }
      if ((this.immediate) && (localDeclaration.isPublic()) && (!paramExpression.getFlag(2048)) && ((this.curLambda == null) || (paramExpression.topLevel() != this.curLambda.topLevel()))) {
        return false;
      }
    }
    return inlineOk;
  }
  
  public boolean inlineOk(Procedure paramProcedure)
  {
    if ((this.immediate) && ((paramProcedure instanceof ModuleMethod)) && ((((ModuleMethod)paramProcedure).module.getClass().getClassLoader() instanceof ArrayClassLoader))) {
      return false;
    }
    return inlineOk;
  }
  
  public boolean isPedantic()
  {
    return this.pedantic;
  }
  
  public boolean isStableSourceLocation()
  {
    return false;
  }
  
  public boolean isStatic()
  {
    return this.mainLambda.isStatic();
  }
  
  public LetExp letDone(Expression paramExpression)
  {
    LetExp localLetExp = (LetExp)this.current_scope;
    localLetExp.body = paramExpression;
    pop(localLetExp);
    return localLetExp;
  }
  
  public void letEnter()
  {
    LetExp localLetExp = (LetExp)this.current_scope;
    Expression[] arrayOfExpression = new Expression[localLetExp.countDecls()];
    Declaration localDeclaration = localLetExp.firstDecl();
    int i = 0;
    while (localDeclaration != null)
    {
      arrayOfExpression[i] = localDeclaration.getValue();
      localDeclaration = localDeclaration.nextDecl();
      i += 1;
    }
    localLetExp.inits = arrayOfExpression;
    this.lexical.push(localLetExp);
  }
  
  public void letStart()
  {
    pushScope(new LetExp(null));
  }
  
  public Declaration letVariable(Object paramObject, Type paramType, Expression paramExpression)
  {
    paramObject = ((LetExp)this.current_scope).addDeclaration(paramObject, paramType);
    ((Declaration)paramObject).noteValue(paramExpression);
    return (Declaration)paramObject;
  }
  
  public final void loadCallContext()
  {
    CodeAttr localCodeAttr = getCode();
    if ((this.callContextVar != null) && (!this.callContextVar.dead()))
    {
      localCodeAttr.emitLoad(this.callContextVar);
      return;
    }
    if (this.method == this.clinitMethod)
    {
      this.callContextVar = new Variable("$ctx", typeCallContext);
      this.callContextVar.reserveLocal(localCodeAttr.getMaxLocals(), localCodeAttr);
      localCodeAttr.emitLoad(this.callContextVar);
      this.callContextVarForInit = this.callContextVar;
      return;
    }
    localCodeAttr.emitInvokeStatic(getCallContextInstanceMethod);
    localCodeAttr.emitDup();
    this.callContextVar = new Variable("$ctx", typeCallContext);
    localCodeAttr.getCurrentScope().addVariable(localCodeAttr, this.callContextVar);
    localCodeAttr.emitStore(this.callContextVar);
  }
  
  public void loadClassRef(ObjectType paramObjectType)
  {
    CodeAttr localCodeAttr = getCode();
    if (this.curClass.getClassfileVersion() >= 3211264)
    {
      localCodeAttr.emitPushClass(paramObjectType);
      return;
    }
    if ((paramObjectType == this.mainClass) && (this.mainLambda.isStatic()) && (this.moduleInstanceMainField != null))
    {
      localCodeAttr.emitGetStatic(this.moduleInstanceMainField);
      localCodeAttr.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
      return;
    }
    if ((paramObjectType instanceof ClassType)) {}
    for (paramObjectType = paramObjectType.getName();; paramObjectType = paramObjectType.getInternalName().replace('/', '.'))
    {
      localCodeAttr.emitPushString(paramObjectType);
      localCodeAttr.emitInvokeStatic(getForNameHelper());
      return;
    }
  }
  
  public Declaration lookup(Object paramObject, int paramInt)
  {
    return this.lexical.lookup(paramObject, paramInt);
  }
  
  public void loopBody(Expression paramExpression)
  {
    ((LambdaExp)this.current_scope).body = paramExpression;
  }
  
  public void loopCond(Expression paramExpression)
  {
    checkLoop();
    this.exprStack.push(paramExpression);
  }
  
  public void loopEnter()
  {
    checkLoop();
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    int i = localLambdaExp.min_args;
    localLambdaExp.max_args = i;
    Expression[] arrayOfExpression = new Expression[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      arrayOfExpression[i] = ((Expression)this.exprStack.pop());
    }
    LetExp localLetExp = (LetExp)localLambdaExp.outer;
    localLetExp.setBody(new ApplyExp(new ReferenceExp(localLetExp.firstDecl()), arrayOfExpression));
    this.lexical.push(localLambdaExp);
  }
  
  public Expression loopRepeat()
  {
    return loopRepeat(Expression.noExpressions);
  }
  
  public Expression loopRepeat(Expression paramExpression)
  {
    return loopRepeat(new Expression[] { paramExpression });
  }
  
  public Expression loopRepeat(Expression[] paramArrayOfExpression)
  {
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    ScopeExp localScopeExp = localLambdaExp.outer;
    Declaration localDeclaration = localScopeExp.firstDecl();
    Expression localExpression = (Expression)this.exprStack.pop();
    paramArrayOfExpression = new ApplyExp(new ReferenceExp(localDeclaration), paramArrayOfExpression);
    localLambdaExp.body = new IfExp(localExpression, new BeginExp(localLambdaExp.body, paramArrayOfExpression), QuoteExp.voidExp);
    this.lexical.pop(localLambdaExp);
    this.current_scope = localScopeExp.outer;
    return localScopeExp;
  }
  
  public void loopStart()
  {
    LambdaExp localLambdaExp = new LambdaExp();
    LetExp localLetExp = new LetExp(new Expression[] { localLambdaExp });
    localLetExp.addDeclaration("%do%loop").noteValue(localLambdaExp);
    localLambdaExp.setName("%do%loop");
    localLetExp.outer = this.current_scope;
    localLambdaExp.outer = localLetExp;
    this.current_scope = localLambdaExp;
  }
  
  public Declaration loopVariable(Object paramObject, Type paramType, Expression paramExpression)
  {
    checkLoop();
    LambdaExp localLambdaExp = (LambdaExp)this.current_scope;
    paramObject = localLambdaExp.addDeclaration(paramObject, paramType);
    if (this.exprStack == null) {
      this.exprStack = new Stack();
    }
    this.exprStack.push(paramExpression);
    localLambdaExp.min_args += 1;
    return (Declaration)paramObject;
  }
  
  public boolean makeRunnable()
  {
    return (!generatingServlet()) && (!generatingApplet()) && (!getModule().staticInitRun());
  }
  
  public void mustCompileHere()
  {
    if ((!this.mustCompile) && (!ModuleExp.compilerAvailable))
    {
      error('w', "this expression claimed that it must be compiled, but compiler is unavailable");
      return;
    }
    this.mustCompile = true;
  }
  
  public void outputClass(String paramString)
    throws IOException
  {
    char c = File.separatorChar;
    int i = 0;
    while (i < this.numClasses)
    {
      ClassType localClassType = this.classes[i];
      String str1 = paramString + localClassType.getName().replace('.', c) + ".class";
      String str2 = new File(str1).getParent();
      if (str2 != null) {
        new File(str2).mkdirs();
      }
      localClassType.writeToFile(str1);
      i += 1;
    }
    this.minfo.cleanupAfterCompilation();
  }
  
  public Expression parse(Object paramObject)
  {
    throw new Error("unimeplemented parse");
  }
  
  public final void pop()
  {
    pop(this.current_scope);
  }
  
  public void pop(ScopeExp paramScopeExp)
  {
    this.lexical.pop(paramScopeExp);
    this.current_scope = paramScopeExp.outer;
  }
  
  /* Error */
  public void process(int paramInt)
  {
    // Byte code:
    //   0: bipush 10
    //   2: istore 4
    //   4: bipush 8
    //   6: istore 5
    //   8: bipush 6
    //   10: istore 6
    //   12: bipush 100
    //   14: istore_3
    //   15: aload_0
    //   16: invokestatic 2173	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 1615	gnu/expr/Compilation:getModule	()Lgnu/expr/ModuleExp;
    //   25: astore 8
    //   27: iload_1
    //   28: iconst_4
    //   29: if_icmplt +78 -> 107
    //   32: aload_0
    //   33: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   36: iconst_3
    //   37: if_icmpge +70 -> 107
    //   40: aload_0
    //   41: iconst_3
    //   42: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   45: aload_0
    //   46: getfield 565	gnu/expr/Compilation:language	Lgnu/expr/Language;
    //   49: aload_0
    //   50: iconst_0
    //   51: invokevirtual 2181	gnu/expr/Language:parse	(Lgnu/expr/Compilation;I)Z
    //   54: pop
    //   55: aload_0
    //   56: getfield 2183	gnu/expr/Compilation:lexer	Lgnu/text/Lexer;
    //   59: invokevirtual 2186	gnu/text/Lexer:close	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 2183	gnu/expr/Compilation:lexer	Lgnu/text/Lexer;
    //   67: aload_0
    //   68: getfield 567	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   71: invokevirtual 2189	gnu/text/SourceMessages:seenErrors	()Z
    //   74: ifeq +28 -> 102
    //   77: bipush 100
    //   79: istore_2
    //   80: aload_0
    //   81: iload_2
    //   82: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   85: aload_0
    //   86: getfield 2191	gnu/expr/Compilation:pendingImports	Ljava/util/Stack;
    //   89: astore 9
    //   91: aload 9
    //   93: ifnull +14 -> 107
    //   96: aload 7
    //   98: invokestatic 2193	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   101: return
    //   102: iconst_4
    //   103: istore_2
    //   104: goto -24 -> 80
    //   107: iload_1
    //   108: bipush 6
    //   110: if_icmplt +47 -> 157
    //   113: aload_0
    //   114: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   117: bipush 6
    //   119: if_icmpge +38 -> 157
    //   122: aload_0
    //   123: aload 8
    //   125: invokevirtual 2195	gnu/expr/Compilation:addMainClass	(Lgnu/expr/ModuleExp;)V
    //   128: aload_0
    //   129: getfield 565	gnu/expr/Compilation:language	Lgnu/expr/Language;
    //   132: aload_0
    //   133: invokevirtual 2198	gnu/expr/Language:resolve	(Lgnu/expr/Compilation;)V
    //   136: iload 6
    //   138: istore_2
    //   139: aload_0
    //   140: getfield 567	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   143: invokevirtual 2189	gnu/text/SourceMessages:seenErrors	()Z
    //   146: ifeq +6 -> 152
    //   149: bipush 100
    //   151: istore_2
    //   152: aload_0
    //   153: iload_2
    //   154: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   157: aload_0
    //   158: getfield 2200	gnu/expr/Compilation:explicit	Z
    //   161: ifne +39 -> 200
    //   164: aload_0
    //   165: getfield 1209	gnu/expr/Compilation:immediate	Z
    //   168: ifne +32 -> 200
    //   171: aload_0
    //   172: getfield 1195	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   175: invokestatic 1827	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   178: invokestatic 2203	java/lang/System:currentTimeMillis	()J
    //   181: invokevirtual 2207	gnu/expr/ModuleInfo:checkCurrent	(Lgnu/expr/ModuleManager;J)Z
    //   184: ifeq +16 -> 200
    //   187: aload_0
    //   188: getfield 1195	gnu/expr/Compilation:minfo	Lgnu/expr/ModuleInfo;
    //   191: invokevirtual 2165	gnu/expr/ModuleInfo:cleanupAfterCompilation	()V
    //   194: aload_0
    //   195: bipush 14
    //   197: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   200: iload_1
    //   201: bipush 8
    //   203: if_icmplt +39 -> 242
    //   206: aload_0
    //   207: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   210: bipush 8
    //   212: if_icmpge +30 -> 242
    //   215: aload_0
    //   216: aload 8
    //   218: invokevirtual 2210	gnu/expr/Compilation:walkModule	(Lgnu/expr/ModuleExp;)V
    //   221: iload 5
    //   223: istore_2
    //   224: aload_0
    //   225: getfield 567	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   228: invokevirtual 2189	gnu/text/SourceMessages:seenErrors	()Z
    //   231: ifeq +6 -> 237
    //   234: bipush 100
    //   236: istore_2
    //   237: aload_0
    //   238: iload_2
    //   239: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   242: iload_1
    //   243: bipush 10
    //   245: if_icmplt +69 -> 314
    //   248: aload_0
    //   249: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   252: bipush 10
    //   254: if_icmpge +60 -> 314
    //   257: aload_0
    //   258: new 908	gnu/expr/LitTable
    //   261: dup
    //   262: aload_0
    //   263: invokespecial 2212	gnu/expr/LitTable:<init>	(Lgnu/expr/Compilation;)V
    //   266: putfield 906	gnu/expr/Compilation:litTable	Lgnu/expr/LitTable;
    //   269: aload 8
    //   271: iconst_1
    //   272: invokevirtual 2215	gnu/expr/ModuleExp:setCanRead	(Z)V
    //   275: aload 8
    //   277: aload_0
    //   278: invokestatic 2221	gnu/expr/FindCapturedVars:findCapturedVars	(Lgnu/expr/Expression;Lgnu/expr/Compilation;)V
    //   281: aload 8
    //   283: aload_0
    //   284: invokevirtual 2224	gnu/expr/ModuleExp:allocFields	(Lgnu/expr/Compilation;)V
    //   287: aload 8
    //   289: aload_0
    //   290: invokevirtual 2227	gnu/expr/ModuleExp:allocChildMethods	(Lgnu/expr/Compilation;)V
    //   293: iload 4
    //   295: istore_2
    //   296: aload_0
    //   297: getfield 567	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   300: invokevirtual 2189	gnu/text/SourceMessages:seenErrors	()Z
    //   303: ifeq +6 -> 309
    //   306: bipush 100
    //   308: istore_2
    //   309: aload_0
    //   310: iload_2
    //   311: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   314: iload_1
    //   315: bipush 12
    //   317: if_icmplt +54 -> 371
    //   320: aload_0
    //   321: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   324: bipush 12
    //   326: if_icmpge +45 -> 371
    //   329: aload_0
    //   330: getfield 1209	gnu/expr/Compilation:immediate	Z
    //   333: ifeq +17 -> 350
    //   336: aload_0
    //   337: new 900	gnu/bytecode/ArrayClassLoader
    //   340: dup
    //   341: invokestatic 2230	gnu/bytecode/ObjectType:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   344: invokespecial 2233	gnu/bytecode/ArrayClassLoader:<init>	(Ljava/lang/ClassLoader;)V
    //   347: putfield 897	gnu/expr/Compilation:loader	Lgnu/bytecode/ArrayClassLoader;
    //   350: aload_0
    //   351: invokevirtual 2235	gnu/expr/Compilation:generateBytecode	()V
    //   354: aload_0
    //   355: getfield 567	gnu/expr/Compilation:messages	Lgnu/text/SourceMessages;
    //   358: invokevirtual 2189	gnu/text/SourceMessages:seenErrors	()Z
    //   361: ifeq +47 -> 408
    //   364: iload_3
    //   365: istore_2
    //   366: aload_0
    //   367: iload_2
    //   368: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   371: iload_1
    //   372: bipush 14
    //   374: if_icmplt +28 -> 402
    //   377: aload_0
    //   378: invokevirtual 2175	gnu/expr/Compilation:getState	()I
    //   381: bipush 14
    //   383: if_icmpge +19 -> 402
    //   386: aload_0
    //   387: invokestatic 1827	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   390: invokevirtual 1866	gnu/expr/ModuleManager:getCompilationDirectory	()Ljava/lang/String;
    //   393: invokevirtual 2237	gnu/expr/Compilation:outputClass	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: bipush 14
    //   399: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   402: aload 7
    //   404: invokestatic 2193	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   407: return
    //   408: bipush 12
    //   410: istore_2
    //   411: goto -45 -> 366
    //   414: astore 8
    //   416: aload_0
    //   417: bipush 100
    //   419: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   422: aload 8
    //   424: invokevirtual 2239	gnu/text/SyntaxException:getMessages	()Lgnu/text/SourceMessages;
    //   427: aload_0
    //   428: invokevirtual 2240	gnu/expr/Compilation:getMessages	()Lgnu/text/SourceMessages;
    //   431: if_acmpeq +42 -> 473
    //   434: new 1568	java/lang/RuntimeException
    //   437: dup
    //   438: new 1140	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 2242
    //   448: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 8
    //   453: invokevirtual 1573	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokespecial 1574	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   462: athrow
    //   463: astore 8
    //   465: aload 7
    //   467: invokestatic 2193	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   470: aload 8
    //   472: athrow
    //   473: aload 7
    //   475: invokestatic 2193	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   478: return
    //   479: astore 8
    //   481: aload 8
    //   483: invokevirtual 2245	java/io/IOException:printStackTrace	()V
    //   486: aload_0
    //   487: bipush 102
    //   489: new 1140	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 1141	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 2247
    //   499: invokevirtual 1146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 8
    //   504: invokevirtual 1573	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 1152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokevirtual 1332	gnu/expr/Compilation:error	(CLjava/lang/String;)V
    //   513: aload_0
    //   514: bipush 100
    //   516: invokevirtual 2178	gnu/expr/Compilation:setState	(I)V
    //   519: aload 7
    //   521: invokestatic 2193	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   524: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	Compilation
    //   0	525	1	paramInt	int
    //   79	332	2	i	int
    //   14	351	3	j	int
    //   2	292	4	k	int
    //   6	216	5	m	int
    //   10	127	6	n	int
    //   19	501	7	localCompilation	Compilation
    //   25	263	8	localModuleExp	ModuleExp
    //   414	38	8	localSyntaxException	gnu.text.SyntaxException
    //   463	8	8	localObject	Object
    //   479	24	8	localIOException	IOException
    //   89	3	9	localStack	Stack
    // Exception table:
    //   from	to	target	type
    //   21	27	414	gnu/text/SyntaxException
    //   32	77	414	gnu/text/SyntaxException
    //   80	91	414	gnu/text/SyntaxException
    //   113	136	414	gnu/text/SyntaxException
    //   139	149	414	gnu/text/SyntaxException
    //   152	157	414	gnu/text/SyntaxException
    //   157	200	414	gnu/text/SyntaxException
    //   206	221	414	gnu/text/SyntaxException
    //   224	234	414	gnu/text/SyntaxException
    //   237	242	414	gnu/text/SyntaxException
    //   248	293	414	gnu/text/SyntaxException
    //   296	306	414	gnu/text/SyntaxException
    //   309	314	414	gnu/text/SyntaxException
    //   320	350	414	gnu/text/SyntaxException
    //   350	364	414	gnu/text/SyntaxException
    //   366	371	414	gnu/text/SyntaxException
    //   377	402	414	gnu/text/SyntaxException
    //   21	27	463	finally
    //   32	77	463	finally
    //   80	91	463	finally
    //   113	136	463	finally
    //   139	149	463	finally
    //   152	157	463	finally
    //   157	200	463	finally
    //   206	221	463	finally
    //   224	234	463	finally
    //   237	242	463	finally
    //   248	293	463	finally
    //   296	306	463	finally
    //   309	314	463	finally
    //   320	350	463	finally
    //   350	364	463	finally
    //   366	371	463	finally
    //   377	402	463	finally
    //   416	463	463	finally
    //   481	519	463	finally
    //   21	27	479	java/io/IOException
    //   32	77	479	java/io/IOException
    //   80	91	479	java/io/IOException
    //   113	136	479	java/io/IOException
    //   139	149	479	java/io/IOException
    //   152	157	479	java/io/IOException
    //   157	200	479	java/io/IOException
    //   206	221	479	java/io/IOException
    //   224	234	479	java/io/IOException
    //   237	242	479	java/io/IOException
    //   248	293	479	java/io/IOException
    //   296	306	479	java/io/IOException
    //   309	314	479	java/io/IOException
    //   320	350	479	java/io/IOException
    //   350	364	479	java/io/IOException
    //   366	371	479	java/io/IOException
    //   377	402	479	java/io/IOException
  }
  
  public void push(Declaration paramDeclaration)
  {
    this.lexical.push(paramDeclaration);
  }
  
  public void push(ScopeExp paramScopeExp)
  {
    pushScope(paramScopeExp);
    this.lexical.push(paramScopeExp);
  }
  
  void pushChain(ScopeExp paramScopeExp1, ScopeExp paramScopeExp2)
  {
    if (paramScopeExp1 != paramScopeExp2)
    {
      pushChain(paramScopeExp1.outer, paramScopeExp2);
      pushScope(paramScopeExp1);
      this.lexical.push(paramScopeExp1);
    }
  }
  
  public ModuleExp pushNewModule(Lexer paramLexer)
  {
    this.lexer = paramLexer;
    return pushNewModule(paramLexer.getName());
  }
  
  public ModuleExp pushNewModule(String paramString)
  {
    ModuleExp localModuleExp = new ModuleExp();
    if (paramString != null) {
      localModuleExp.setFile(paramString);
    }
    if ((generatingApplet()) || (generatingServlet())) {
      localModuleExp.setFlag(131072);
    }
    if (this.immediate)
    {
      localModuleExp.setFlag(1048576);
      new ModuleInfo().setCompilation(this);
    }
    this.mainLambda = localModuleExp;
    push(localModuleExp);
    return localModuleExp;
  }
  
  public void pushPendingImport(ModuleInfo paramModuleInfo, ScopeExp paramScopeExp, int paramInt)
  {
    if (this.pendingImports == null) {
      this.pendingImports = new Stack();
    }
    this.pendingImports.push(paramModuleInfo);
    this.pendingImports.push(paramScopeExp);
    paramModuleInfo = new ReferenceExp((Object)null);
    paramModuleInfo.setLine(this);
    this.pendingImports.push(paramModuleInfo);
    this.pendingImports.push(Integer.valueOf(paramInt));
  }
  
  public final void pushScope(ScopeExp paramScopeExp)
  {
    if ((!this.mustCompile) && ((paramScopeExp.mustCompile()) || ((ModuleExp.compilerAvailable) && ((paramScopeExp instanceof LambdaExp)) && (!(paramScopeExp instanceof ModuleExp))))) {
      mustCompileHere();
    }
    paramScopeExp.outer = this.current_scope;
    this.current_scope = paramScopeExp;
  }
  
  public Object resolve(Object paramObject, boolean paramBoolean)
  {
    Environment localEnvironment = Environment.getCurrent();
    if ((paramObject instanceof String)) {}
    for (paramObject = localEnvironment.defaultNamespace().lookup((String)paramObject); paramObject == null; paramObject = (Symbol)paramObject) {
      return null;
    }
    if ((paramBoolean) && (getLanguage().hasSeparateFunctionNamespace())) {
      return localEnvironment.getFunction((Symbol)paramObject, null);
    }
    return localEnvironment.get((EnvironmentKey)paramObject, null);
  }
  
  public void setColumn(int paramInt)
  {
    this.messages.setColumn(paramInt);
  }
  
  public void setCurrentScope(ScopeExp paramScopeExp)
  {
    int j = ScopeExp.nesting(paramScopeExp);
    int i = ScopeExp.nesting(this.current_scope);
    while (i > j)
    {
      pop(this.current_scope);
      i -= 1;
    }
    ScopeExp localScopeExp1 = paramScopeExp;
    ScopeExp localScopeExp2;
    for (;;)
    {
      localScopeExp2 = localScopeExp1;
      if (j <= i) {
        break;
      }
      localScopeExp1 = localScopeExp1.outer;
      j -= 1;
    }
    while (localScopeExp2 != this.current_scope)
    {
      pop(this.current_scope);
      localScopeExp2 = localScopeExp2.outer;
    }
    pushChain(paramScopeExp, localScopeExp2);
  }
  
  public void setFile(String paramString)
  {
    this.messages.setFile(paramString);
  }
  
  public void setLine(int paramInt)
  {
    this.messages.setLine(paramInt);
  }
  
  public final void setLine(Expression paramExpression)
  {
    this.messages.setLocation(paramExpression);
  }
  
  public void setLine(Object paramObject)
  {
    if ((paramObject instanceof SourceLocator)) {
      this.messages.setLocation((SourceLocator)paramObject);
    }
  }
  
  public void setLine(String paramString, int paramInt1, int paramInt2)
  {
    this.messages.setLine(paramString, paramInt1, paramInt2);
  }
  
  public final void setLocation(SourceLocator paramSourceLocator)
  {
    this.messages.setLocation(paramSourceLocator);
  }
  
  public void setMessages(SourceMessages paramSourceMessages)
  {
    this.messages = paramSourceMessages;
  }
  
  public void setModule(ModuleExp paramModuleExp)
  {
    this.mainLambda = paramModuleExp;
  }
  
  public void setSharedModuleDefs(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.langOptions |= 0x2;
      return;
    }
    this.langOptions &= 0xFFFFFFFD;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public boolean sharedModuleDefs()
  {
    return (this.langOptions & 0x2) != 0;
  }
  
  public Expression syntaxError(String paramString)
  {
    error('e', paramString);
    return new ErrorExp(paramString);
  }
  
  public String toString()
  {
    return "<compilation " + this.mainLambda + ">";
  }
  
  public void usedClass(Type paramType)
  {
    while ((paramType instanceof ArrayType)) {
      paramType = ((ArrayType)paramType).getComponentType();
    }
    if ((this.immediate) && ((paramType instanceof ClassType))) {
      this.loader.addClass((ClassType)paramType);
    }
  }
  
  public boolean usingCPStyle()
  {
    return defaultCallConvention == 4;
  }
  
  public boolean usingTailCalls()
  {
    return defaultCallConvention >= 3;
  }
  
  public void walkModule(ModuleExp paramModuleExp)
  {
    if (debugPrintExpr)
    {
      OutPort localOutPort = OutPort.errDefault();
      localOutPort.println("[Module:" + paramModuleExp.getName());
      paramModuleExp.print(localOutPort);
      localOutPort.println(']');
      localOutPort.flush();
    }
    InlineCalls.inlineCalls(paramModuleExp, this);
    PushApply.pushApply(paramModuleExp);
    ChainLambdas.chainLambdas(paramModuleExp, this);
    FindTailCalls.findTailCalls(paramModuleExp, this);
  }
  
  public boolean warnAsError()
  {
    return this.currentOptions.getBoolean(warnAsError);
  }
  
  public boolean warnInvokeUnknownMethod()
  {
    return this.currentOptions.getBoolean(warnInvokeUnknownMethod);
  }
  
  public boolean warnUndefinedVariable()
  {
    return this.currentOptions.getBoolean(warnUndefinedVariable);
  }
  
  public boolean warnUnknownMember()
  {
    return this.currentOptions.getBoolean(warnUnknownMember);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\expr\Compilation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */