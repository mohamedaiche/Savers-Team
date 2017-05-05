package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.kawa.functions.ConstantFunction0;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.kawa.xml.XStringType;
import gnu.kawa.xml.XTimeType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.InPort;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.XMLPrinter;
import gnu.xquery.util.BooleanValue;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;
import kawa.standard.Scheme;

public class XQuery
  extends Language
{
  public static final String DEFAULT_ELEMENT_PREFIX;
  public static final String DEFAULT_FUNCTION_PREFIX = "(functions)";
  public static final String KAWA_FUNCTION_NAMESPACE = "http://kawa.gnu.org/";
  public static final String LOCAL_NAMESPACE = "http://www.w3.org/2005/xquery-local-functions";
  public static final int PARSE_WITH_FOCUS = 65536;
  public static final String QEXO_FUNCTION_NAMESPACE = "http://qexo.gnu.org/";
  public static final String SCHEMA_INSTANCE_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
  public static final String SCHEMA_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
  public static final int VARIADIC_FUNCTION_NAMESPACE = -2;
  public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";
  public static final String XQUERY_FUNCTION_NAMESPACE = "http://www.w3.org/2005/xpath-functions";
  static boolean charIsInt;
  public static final Namespace[] defaultFunctionNamespacePath;
  static int envCounter;
  public static Environment extensionsEnvEnv;
  public static QuoteExp falseExp;
  public static final ConstantFunction0 falseFunction = new ConstantFunction0("false", falseExp);
  public static final XQuery instance;
  public static final Namespace kawaFunctionNamespace;
  public static final Namespace qexoFunctionNamespace;
  public static QuoteExp trueExp;
  public static final ConstantFunction0 trueFunction = new ConstantFunction0("true", trueExp);
  static Object[] typeMap = { "string", XDataType.stringType, "untypedAtomic", XDataType.untypedAtomicType, "boolean", XDataType.booleanType, "integer", XIntegerType.integerType, "long", XIntegerType.longType, "int", XIntegerType.intType, "short", XIntegerType.shortType, "byte", XIntegerType.byteType, "unsignedLong", XIntegerType.unsignedLongType, "unsignedInt", XIntegerType.unsignedIntType, "unsignedShort", XIntegerType.unsignedShortType, "unsignedByte", XIntegerType.unsignedByteType, "positiveInteger", XIntegerType.positiveIntegerType, "nonPositiveInteger", XIntegerType.nonPositiveIntegerType, "negativeInteger", XIntegerType.negativeIntegerType, "nonNegativeInteger", XIntegerType.nonNegativeIntegerType, "date", XTimeType.dateType, "dateTime", XTimeType.dateTimeType, "time", XTimeType.timeType, "duration", XTimeType.durationType, "yearMonthDuration", XTimeType.yearMonthDurationType, "dayTimeDuration", XTimeType.dayTimeDurationType, "gYearMonth", XTimeType.gYearMonthType, "gYear", XTimeType.gYearType, "gMonthDay", XTimeType.gMonthDayType, "gDay", XTimeType.gDayType, "gMonth", XTimeType.gMonthType, "decimal", XDataType.decimalType, "float", XDataType.floatType, "double", XDataType.doubleType, "anyURI", XDataType.anyURIType, "hexBinary", XDataType.hexBinaryType, "base64Binary", XDataType.base64BinaryType, "NOTATION", XDataType.NotationType, "QName", "gnu.mapping.Symbol", "normalizedString", XStringType.normalizedStringType, "token", XStringType.tokenType, "language", XStringType.languageType, "NMTOKEN", XStringType.NMTOKENType, "Name", XStringType.NameType, "NCName", XStringType.NCNameType, "ID", XStringType.IDType, "IDREF", XStringType.IDREFType, "ENTITY", XStringType.ENTITYType, "anyAtomicType", XDataType.anyAtomicType, "anySimpleType", XDataType.anySimpleType, "untyped", XDataType.untypedType, "anyType", Type.objectType };
  public static final Environment xqEnvironment;
  public static final Namespace xqueryFunctionNamespace = Namespace.valueOf("http://www.w3.org/2005/xpath-functions");
  Namespace defaultNamespace = xqueryFunctionNamespace;
  
  static
  {
    kawaFunctionNamespace = Namespace.valueOf("http://kawa.gnu.org/");
    qexoFunctionNamespace = Namespace.valueOf("http://qexo.gnu.org/");
    defaultFunctionNamespacePath = new Namespace[] { qexoFunctionNamespace, xqueryFunctionNamespace, Namespace.EmptyNamespace, kawaFunctionNamespace };
    charIsInt = false;
    DEFAULT_ELEMENT_PREFIX = null;
    envCounter = 0;
    extensionsEnvEnv = Environment.getInstance("http://kawa.gnu.org/");
    xqEnvironment = Environment.make("http://www.w3.org/2005/xpath-functions");
    instance = new XQuery();
    instance.initXQuery();
    falseExp = new QuoteExp(Boolean.FALSE, XDataType.booleanType);
    trueExp = new QuoteExp(Boolean.TRUE, XDataType.booleanType);
  }
  
  public XQuery()
  {
    this.environ = xqEnvironment;
  }
  
  public static char asChar(Object paramObject)
  {
    if ((paramObject instanceof Char)) {
      return ((Char)paramObject).charValue();
    }
    if ((paramObject instanceof Numeric)) {}
    for (int i = ((Numeric)paramObject).intValue(); (i < 0) || (i > 65535); i = -1) {
      throw new ClassCastException("not a character value");
    }
    return (char)i;
  }
  
  public static Numeric asNumber(Object paramObject)
  {
    if ((paramObject instanceof Char)) {
      return IntNum.make(((Char)paramObject).intValue());
    }
    return (Numeric)paramObject;
  }
  
  public static Object getExternal(Symbol paramSymbol, Object paramObject)
  {
    Environment localEnvironment = Environment.getCurrent();
    Object localObject2 = localEnvironment.get(paramSymbol, null, null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localEnvironment.get(Symbol.makeWithUnknownNamespace(paramSymbol.getLocalName(), paramSymbol.getPrefix()), null, null);
    }
    if (localObject1 == null) {
      throw new RuntimeException("unbound external " + paramSymbol);
    }
    if (paramObject == null) {
      return localObject1;
    }
    if ((paramObject instanceof XDataType)) {
      return ((XDataType)paramObject).cast(localObject1);
    }
    if ((paramObject instanceof ClassType))
    {
      localObject2 = ((ClassType)paramObject).getName();
      if ("gnu.math.IntNum".equals(localObject2)) {
        return IntNum.valueOf(localObject1.toString());
      }
      if ("gnu.math.RealNum".equals(localObject2)) {
        return DFloNum.make(Double.parseDouble(localObject1.toString()));
      }
    }
    try
    {
      localObject2 = ((Type)paramObject).coerceFromObject(localObject1);
      return localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(paramSymbol.toString(), -2, localObject1, paramObject.toString());
    }
  }
  
  public static XQuery getInstance()
  {
    return instance;
  }
  
  public static Type getStandardType(String paramString)
  {
    int i = typeMap.length;
    int j;
    do
    {
      j = i - 2;
      if (j < 0) {
        break;
      }
      i = j;
    } while (!typeMap[j].equals(paramString));
    paramString = typeMap[(j + 1)];
    if ((paramString instanceof String)) {
      return Scheme.string2Type((String)paramString);
    }
    return (Type)paramString;
    return null;
  }
  
  private void initXQuery()
  {
    ModuleBody.setMainPrintValues(true);
    defProcStFld("unescaped-data", "gnu.kawa.xml.MakeUnescapedData", "unescapedData");
    defProcStFld("item-at", "gnu.xquery.util.ItemAt", "itemAt");
    defProcStFld("count", "gnu.kawa.functions.CountValues", "countValues");
    define_method("sum", "gnu.xquery.util.Reduce", "sum");
    defProcStFld("avg", "gnu.xquery.util.Average", "avg");
    defProcStFld("sublist", "gnu.xquery.util.SubList", "subList");
    defProcStFld("subsequence", "gnu.xquery.util.SubList", "subList");
    define_method("empty", "gnu.xquery.util.SequenceUtils", "isEmptySequence");
    define_method("exists", "gnu.xquery.util.SequenceUtils", "exists");
    define_method("insert-before", "gnu.xquery.util.SequenceUtils", "insertBefore$X");
    define_method("remove", "gnu.xquery.util.SequenceUtils", "remove$X");
    define_method("reverse", "gnu.xquery.util.SequenceUtils", "reverse$X");
    defProcStFld("false", "gnu.xquery.lang.XQuery", "falseFunction");
    defProcStFld("true", "gnu.xquery.lang.XQuery", "trueFunction");
    defProcStFld("boolean", "gnu.xquery.util.BooleanValue", "booleanValue");
    define_method("trace", "gnu.xquery.util.Debug", "trace");
    define_method("error", "gnu.xquery.util.XQException", "error");
    defProcStFld("write-to", "gnu.kawa.xml.WriteTo", "writeTo");
    defProcStFld("write-to-if-changed", "gnu.kawa.xml.WriteTo", "writeToIfChanged");
    defProcStFld("iterator-items", "gnu.kawa.xml.IteratorItems", "iteratorItems");
    defProcStFld("list-items", "gnu.kawa.xml.ListItems", "listItems");
    define_method("node-name", "gnu.xquery.util.NodeUtils", "nodeName");
    define_method("nilled", "gnu.xquery.util.NodeUtils", "nilled");
    define_method("data", "gnu.xquery.util.NodeUtils", "data$X");
    define_method("lower-case", "gnu.xquery.util.StringUtils", "lowerCase");
    define_method("upper-case", "gnu.xquery.util.StringUtils", "upperCase");
    define_method("substring", "gnu.xquery.util.StringUtils", "substring");
    define_method("string-length", "gnu.xquery.util.StringUtils", "stringLength");
    define_method("substring-before", "gnu.xquery.util.StringUtils", "substringBefore");
    define_method("substring-after", "gnu.xquery.util.StringUtils", "substringAfter");
    define_method("translate", "gnu.xquery.util.StringUtils", "translate");
    define_method("encode-for-uri", "gnu.xquery.util.StringUtils", "encodeForUri");
    define_method("iri-to-uri", "gnu.xquery.util.StringUtils", "iriToUri");
    define_method("escape-html-uri", "gnu.xquery.util.StringUtils", "escapeHtmlUri");
    define_method("contains", "gnu.xquery.util.StringUtils", "contains");
    define_method("starts-with", "gnu.xquery.util.StringUtils", "startsWith");
    define_method("ends-with", "gnu.xquery.util.StringUtils", "endsWith");
    define_method("codepoint-equal", "gnu.xquery.util.StringUtils", "codepointEqual");
    define_method("normalize-unicode", "gnu.xquery.util.StringUtils", "normalizeUnicode");
    define_method("string-join", "gnu.xquery.util.StringUtils", "stringJoin");
    define_method("concat", "gnu.xquery.util.StringUtils", "concat$V");
    define_method("matches", "gnu.xquery.util.StringUtils", "matches");
    define_method("replace", "gnu.xquery.util.StringUtils", "replace");
    define_method("tokenize", "gnu.xquery.util.StringUtils", "tokenize$X");
    define_method("string-to-codepoints", "gnu.xquery.util.StringUtils", "stringToCodepoints$X");
    define_method("codepoints-to-string", "gnu.xquery.util.StringUtils", "codepointsToString");
    define_method("abs", "gnu.xquery.util.NumberValue", "abs");
    define_method("floor", "gnu.xquery.util.NumberValue", "floor");
    define_method("ceiling", "gnu.xquery.util.NumberValue", "ceiling");
    define_method("round", "gnu.xquery.util.NumberValue", "round");
    define_method("round-half-to-even", "gnu.xquery.util.NumberValue", "roundHalfToEven");
    define_method("QName", "gnu.xquery.util.QNameUtils", "makeQName");
    define_method("resolve-QName", "gnu.xquery.util.QNameUtils", "resolveQNameUsingElement");
    define_method("prefix-from-QName", "gnu.xquery.util.QNameUtils", "prefixFromQName");
    define_method("local-name-from-QName", "gnu.xquery.util.QNameUtils", "localNameFromQName");
    define_method("namespace-uri-from-QName", "gnu.xquery.util.QNameUtils", "namespaceURIFromQName");
    define_method("namespace-uri-for-prefix", "gnu.xquery.util.QNameUtils", "namespaceURIForPrefix");
    define_method("in-scope-prefixes", "gnu.xquery.util.NodeUtils", "inScopePrefixes$X");
    define_method("document-uri", "gnu.xquery.util.NodeUtils", "documentUri");
    define_method("years-from-duration", "gnu.xquery.util.TimeUtils", "yearsFromDuration");
    define_method("months-from-duration", "gnu.xquery.util.TimeUtils", "monthsFromDuration");
    define_method("days-from-duration", "gnu.xquery.util.TimeUtils", "daysFromDuration");
    define_method("hours-from-duration", "gnu.xquery.util.TimeUtils", "hoursFromDuration");
    define_method("minutes-from-duration", "gnu.xquery.util.TimeUtils", "minutesFromDuration");
    define_method("seconds-from-duration", "gnu.xquery.util.TimeUtils", "secondsFromDuration");
    define_method("year-from-dateTime", "gnu.xquery.util.TimeUtils", "yearFromDateTime");
    define_method("month-from-dateTime", "gnu.xquery.util.TimeUtils", "monthFromDateTime");
    define_method("day-from-dateTime", "gnu.xquery.util.TimeUtils", "dayFromDateTime");
    define_method("hours-from-dateTime", "gnu.xquery.util.TimeUtils", "hoursFromDateTime");
    define_method("minutes-from-dateTime", "gnu.xquery.util.TimeUtils", "minutesFromDateTime");
    define_method("seconds-from-dateTime", "gnu.xquery.util.TimeUtils", "secondsFromDateTime");
    define_method("timezone-from-dateTime", "gnu.xquery.util.TimeUtils", "timezoneFromDateTime");
    define_method("year-from-date", "gnu.xquery.util.TimeUtils", "yearFromDate");
    define_method("month-from-date", "gnu.xquery.util.TimeUtils", "monthFromDate");
    define_method("day-from-date", "gnu.xquery.util.TimeUtils", "dayFromDate");
    define_method("timezone-from-date", "gnu.xquery.util.TimeUtils", "timezoneFromDate");
    define_method("hours-from-time", "gnu.xquery.util.TimeUtils", "hoursFromTime");
    define_method("minutes-from-time", "gnu.xquery.util.TimeUtils", "minutesFromTime");
    define_method("seconds-from-time", "gnu.xquery.util.TimeUtils", "secondsFromTime");
    define_method("timezone-from-time", "gnu.xquery.util.TimeUtils", "timezoneFromTime");
    define_method("adjust-dateTime-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateTimeToTimezone");
    define_method("adjust-date-to-timezone", "gnu.xquery.util.TimeUtils", "adjustDateToTimezone");
    define_method("adjust-time-to-timezone", "gnu.xquery.util.TimeUtils", "adjustTimeToTimezone");
    define_method("dateTime", "gnu.xquery.util.TimeUtils", "dateTime");
    define_method("current-dateTime", "gnu.xquery.util.TimeUtils", "currentDateTime");
    define_method("current-date", "gnu.xquery.util.TimeUtils", "currentDate");
    define_method("current-time", "gnu.xquery.util.TimeUtils", "currentTime");
    define_method("implicit-timezone", "gnu.xquery.util.TimeUtils", "implicitTimezone");
    define_method("zero-or-one", "gnu.xquery.util.SequenceUtils", "zeroOrOne");
    define_method("one-or-more", "gnu.xquery.util.SequenceUtils", "oneOrMore");
    define_method("exactly-one", "gnu.xquery.util.SequenceUtils", "exactlyOne");
    defProcStFld("distinct-nodes", "gnu.kawa.xml.SortNodes", "sortNodes");
    defProcStFld("children", "gnu.kawa.xml.Children", "children");
    define_method("not", "gnu.xquery.util.BooleanValue", "not");
    this.defaultNamespace = qexoFunctionNamespace;
    defProcStFld("response-header", "gnu.kawa.servlet.HTTP");
    defProcStFld("response-content-type", "gnu.kawa.servlet.HTTP");
    defProcStFld("response-status", "gnu.kawa.servlet.HTTP");
    defProcStFld("error-response", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet-context", "gnu.kawa.servlet.HTTP");
    defProcStFld("current-servlet-config", "gnu.kawa.servlet.HTTP");
    defProcStFld("servlet-context-realpath", "gnu.kawa.servlet.HTTP");
    defProcStFld("get-response", "gnu.kawa.servlet.HTTP");
    defProcStFld("get-request", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-method", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-uri", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-url", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-path-info", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-path-translated", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-servlet-path", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-query-string", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-parameter", "gnu.kawa.servlet.HTTP");
    defProcStFld("request-parameters", "gnu.kawa.servlet.HTTP");
    this.defaultNamespace = xqueryFunctionNamespace;
  }
  
  public static String makeClassName(String paramString)
  {
    String str = paramString.replace(File.separatorChar, '/');
    int i = str.lastIndexOf('/');
    paramString = str;
    if (i >= 0) {
      paramString = str.substring(i + 1);
    }
    i = paramString.lastIndexOf('.');
    str = paramString;
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    return Compilation.mangleNameIfNeeded(str);
  }
  
  public static String mangle(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    mangle(paramString, 0, paramString.length(), localStringBuffer, 'U');
    return localStringBuffer.toString();
  }
  
  static void mangle(String paramString, int paramInt1, int paramInt2, StringBuffer paramStringBuffer, char paramChar)
  {
    int i = 80;
    int m = paramStringBuffer.length();
    int j = 0;
    while (j < paramInt2)
    {
      char c2 = paramString.charAt(paramInt1 + j);
      int k = j + 1;
      if (Character.isUpperCase(c2))
      {
        if ((i != 85) || ((k < paramInt2) && (Character.isLowerCase(paramString.charAt(paramInt1 + k))))) {}
        for (j = 1;; j = 0)
        {
          i = 85;
          char c1;
          if (j == 0)
          {
            c1 = c2;
            if (paramChar != '_') {}
          }
          else
          {
            if ((j != 0) && (paramChar == '_') && (paramStringBuffer.length() > m)) {
              paramStringBuffer.append('_');
            }
            c1 = Character.toUpperCase(c2);
          }
          paramStringBuffer.append(c1);
          j = k;
          break;
        }
      }
      if (Character.isLowerCase(c2))
      {
        if ((i != 76) || (i != 85)) {}
        for (j = 1;; j = 0)
        {
          i = 76;
          break;
        }
      }
      if (Character.isLetter(c2))
      {
        if (i != 79) {}
        for (j = 1;; j = 0)
        {
          i = 79;
          break;
        }
      }
      if (Character.isDigit(c2))
      {
        if (i != 68) {}
        for (j = 1;; j = 0)
        {
          i = 68;
          break;
        }
      }
      if (Character.isJavaIdentifierPart(c2))
      {
        if ((i != 68) && (i != 77)) {}
        for (j = 1;; j = 0)
        {
          i = 77;
          break;
        }
      }
      i = 80;
      j = k;
    }
  }
  
  public static int namespaceForFunctions(int paramInt)
  {
    return paramInt << 2 | 0x2;
  }
  
  public static void registerEnvironment()
  {
    gnu.expr.ApplicationMainSupport.processCommandLinePropertyAssignments = true;
    Language.setDefaults(instance);
  }
  
  public Object applyWithFocus(Procedure paramProcedure, Object paramObject)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      applyWithFocus$X(paramProcedure, paramObject, localCallContext);
      paramProcedure = localCallContext.getFromContext(i);
      return paramProcedure;
    }
    catch (Throwable paramProcedure)
    {
      localCallContext.cleanupFromContext(i);
      throw paramProcedure;
    }
  }
  
  public Object applyWithFocus(Procedure paramProcedure, Object paramObject, int paramInt1, int paramInt2)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      paramProcedure.check3(paramObject, IntNum.make(paramInt1), IntNum.make(paramInt2), localCallContext);
      paramProcedure = localCallContext.getFromContext(i);
      return paramProcedure;
    }
    catch (Throwable paramProcedure)
    {
      localCallContext.cleanupFromContext(i);
      throw paramProcedure;
    }
  }
  
  public void applyWithFocus(Procedure paramProcedure, Object paramObject, int paramInt1, int paramInt2, Consumer paramConsumer)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    paramProcedure.check3(paramObject, IntNum.make(paramInt1), IntNum.make(paramInt2), localCallContext);
    paramProcedure = localCallContext.consumer;
    try
    {
      localCallContext.consumer = paramConsumer;
      localCallContext.runUntilDone();
      return;
    }
    finally
    {
      localCallContext.consumer = paramProcedure;
    }
  }
  
  public void applyWithFocus(Procedure paramProcedure, Object paramObject, Consumer paramConsumer)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    Consumer localConsumer = localCallContext.consumer;
    try
    {
      localCallContext.consumer = paramConsumer;
      applyWithFocus$X(paramProcedure, paramObject, localCallContext);
      return;
    }
    finally
    {
      localCallContext.consumer = localConsumer;
    }
  }
  
  public void applyWithFocus$X(Procedure paramProcedure, Object paramObject, CallContext paramCallContext)
    throws Throwable
  {
    if ((paramObject instanceof Values))
    {
      paramObject = (Values)paramObject;
      int k = ((Values)paramObject).size();
      if (k == 0) {
        return;
      }
      int j = 0;
      localIntNum = IntNum.make(k);
      int i = 1;
      for (;;)
      {
        paramProcedure.check3(((Values)paramObject).getPosNext(j), IntNum.make(i), localIntNum, paramCallContext);
        paramCallContext.runUntilDone();
        if (i == k) {
          break;
        }
        j = ((Values)paramObject).nextPos(j);
        i += 1;
      }
    }
    IntNum localIntNum = IntNum.one();
    paramProcedure.check3(paramObject, localIntNum, localIntNum, paramCallContext);
    paramCallContext.runUntilDone();
  }
  
  public void define(String paramString, Object paramObject)
  {
    Symbol localSymbol = Symbol.make(this.defaultNamespace, paramString);
    if ((paramObject instanceof Procedure)) {}
    for (paramString = EnvironmentKey.FUNCTION;; paramString = null)
    {
      this.environ.define(localSymbol, paramString, paramObject);
      return;
    }
  }
  
  protected void define_method(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = Symbol.make(this.defaultNamespace, paramString1);
    paramString2 = ClassMethods.apply(ClassType.make(paramString2), paramString3, '\000', this);
    paramString2.setSymbol(paramString1);
    this.environ.define(paramString1, EnvironmentKey.FUNCTION, paramString2);
  }
  
  public Procedure evalToFocusProc(Reader paramReader, SourceMessages paramSourceMessages)
    throws Throwable
  {
    if ((paramReader instanceof InPort)) {}
    for (paramReader = (InPort)paramReader;; paramReader = new InPort(paramReader))
    {
      paramSourceMessages = parse(paramReader, paramSourceMessages, 65537);
      paramReader = CallContext.getInstance();
      int i = paramReader.startFromContext();
      try
      {
        ModuleExp.evalModule(Environment.getCurrent(), paramReader, paramSourceMessages, null, null);
        paramSourceMessages = (Procedure)paramReader.getFromContext(i);
        return paramSourceMessages;
      }
      catch (Throwable paramSourceMessages)
      {
        paramReader.cleanupFromContext(i);
        throw paramSourceMessages;
      }
    }
  }
  
  public Procedure evalToFocusProc(String paramString)
    throws Throwable
  {
    SourceMessages localSourceMessages = new SourceMessages();
    paramString = evalToFocusProc(new CharArrayInPort(paramString), localSourceMessages);
    if (localSourceMessages.seenErrors()) {
      throw new RuntimeException("invalid syntax in eval form:\n" + localSourceMessages.toString(20));
    }
    return paramString;
  }
  
  public Object evalWithFocus(String paramString, Object paramObject)
    throws Throwable
  {
    return applyWithFocus(evalToFocusProc(paramString), paramObject);
  }
  
  public Object evalWithFocus(String paramString, Object paramObject, int paramInt1, int paramInt2)
    throws Throwable
  {
    return applyWithFocus(evalToFocusProc(paramString), paramObject, paramInt1, paramInt2);
  }
  
  public void evalWithFocus(Reader paramReader, SourceMessages paramSourceMessages, Object paramObject, int paramInt1, int paramInt2, Consumer paramConsumer)
    throws Throwable
  {
    applyWithFocus(evalToFocusProc(paramReader, paramSourceMessages), paramObject, paramInt1, paramInt2, paramConsumer);
  }
  
  public void evalWithFocus(Reader paramReader, SourceMessages paramSourceMessages, Object paramObject, Consumer paramConsumer)
    throws Throwable
  {
    applyWithFocus(evalToFocusProc(paramReader, paramSourceMessages), paramObject, paramConsumer);
  }
  
  public void eval_with_focus$X(String paramString, Object paramObject, int paramInt1, int paramInt2, CallContext paramCallContext)
    throws Throwable
  {
    evalToFocusProc(paramString).check3(paramObject, IntNum.make(paramInt1), IntNum.make(paramInt2), paramCallContext);
  }
  
  public void eval_with_focus$X(String paramString, Object paramObject, CallContext paramCallContext)
    throws Throwable
  {
    applyWithFocus$X(evalToFocusProc(paramString), paramObject, paramCallContext);
  }
  
  public String formatType(Type paramType)
  {
    String str = paramType.getName();
    if ("gnu.math.IntNum".equals(str)) {
      return "xs:integer";
    }
    if (("java.lang.String".equals(str)) || ("java.lang.CharSequence".equals(str))) {
      return "xs:string";
    }
    return paramType.toString();
  }
  
  public Compilation getCompilation(Lexer paramLexer, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    return new Compilation(this, paramSourceMessages, paramNameLookup);
  }
  
  public Lexer getLexer(InPort paramInPort, SourceMessages paramSourceMessages)
  {
    return new XQParser(paramInPort, paramSourceMessages, this);
  }
  
  public String getName()
  {
    return "XQuery";
  }
  
  public int getNamespaceOf(Declaration paramDeclaration)
  {
    if (paramDeclaration.isProcedureDecl())
    {
      if (paramDeclaration.getCode() < 0) {}
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return -2;
              paramDeclaration = paramDeclaration.getValue();
              if (!(paramDeclaration instanceof LambdaExp)) {
                break;
              }
              paramDeclaration = (LambdaExp)paramDeclaration;
            } while (paramDeclaration.min_args != paramDeclaration.max_args);
            return namespaceForFunctions(paramDeclaration.min_args);
            if (!(paramDeclaration instanceof QuoteExp)) {
              break;
            }
            paramDeclaration = ((QuoteExp)paramDeclaration).getValue();
          } while (!(paramDeclaration instanceof Procedure));
          paramDeclaration = (Procedure)paramDeclaration;
          i = paramDeclaration.minArgs();
        } while (i != paramDeclaration.maxArgs());
        return namespaceForFunctions(i);
      } while (!(paramDeclaration instanceof ReferenceExp));
      return getNamespaceOf(((ReferenceExp)paramDeclaration).getBinding());
    }
    return 1;
  }
  
  public Consumer getOutputConsumer(Writer paramWriter)
  {
    return new XMLPrinter(paramWriter, false);
  }
  
  public Procedure getPrompter()
  {
    return new Prompter();
  }
  
  public Symbol getSymbol(String paramString)
  {
    return Symbol.make(this.defaultNamespace, paramString);
  }
  
  public Type getTypeFor(Class paramClass)
  {
    if (paramClass.isPrimitive())
    {
      paramClass = paramClass.getName();
      if (paramClass.equals("boolean")) {
        return XDataType.booleanType;
      }
      return Scheme.getNamedType(paramClass);
    }
    if (!paramClass.isArray())
    {
      String str = paramClass.getName();
      if (str.equals("java.lang.String")) {
        return XDataType.stringStringType;
      }
      if (str.equals("gnu.kawa.xml.UntypedAtomic")) {
        return XDataType.untypedAtomicType;
      }
      if (str.equals("java.lang.Boolean")) {
        return XDataType.booleanType;
      }
      if (str.equals("java.lang.Float")) {
        return XDataType.floatType;
      }
      if (str.equals("java.lang.Double")) {
        return XDataType.doubleType;
      }
      if (str.equals("java.math.BigDecimal")) {
        return XDataType.decimalType;
      }
      if (str.equals("gnu.math.Duration")) {
        return XDataType.durationType;
      }
      if (str.equals("gnu.text.Path")) {
        return XDataType.anyURIType;
      }
    }
    return Type.make(paramClass);
  }
  
  public Type getTypeFor(String paramString)
  {
    Object localObject;
    if (paramString.startsWith("xs:")) {
      localObject = paramString.substring(3);
    }
    for (;;)
    {
      localObject = getStandardType((String)localObject);
      if (localObject == null) {
        break;
      }
      return (Type)localObject;
      if (paramString.startsWith("xdt:")) {
        localObject = paramString.substring(4);
      } else {
        localObject = paramString;
      }
    }
    return Scheme.string2Type(paramString);
  }
  
  public boolean hasNamespace(Declaration paramDeclaration, int paramInt)
  {
    int i = getNamespaceOf(paramDeclaration);
    return (i == paramInt) || ((i == -2) && ((paramInt & 0x2) != 0)) || ((paramInt == -2) && ((i & 0x2) != 0));
  }
  
  public boolean hasSeparateFunctionNamespace()
  {
    return true;
  }
  
  public boolean isTrue(Object paramObject)
  {
    return BooleanValue.booleanValue(paramObject);
  }
  
  public boolean parse(Compilation paramCompilation, int paramInt)
    throws IOException, SyntaxException
  {
    ModuleExp localModuleExp = paramCompilation.mainLambda;
    Compilation.defaultCallConvention = 2;
    paramCompilation.mustCompileHere();
    XQParser localXQParser = (XQParser)paramCompilation.lexer;
    Object localObject1;
    if (localXQParser.isInteractive())
    {
      localObject1 = localXQParser.parse(paramCompilation);
      if (localObject1 == null) {
        return false;
      }
      localModuleExp.body = ((Expression)localObject1);
    }
    for (;;)
    {
      paramCompilation.pop(localModuleExp);
      localObject1 = new XQResolveNames(paramCompilation);
      ((XQResolveNames)localObject1).functionNamespacePath = localXQParser.functionNamespacePath;
      ((XQResolveNames)localObject1).parser = localXQParser;
      ((XQResolveNames)localObject1).resolveModule(localModuleExp);
      paramCompilation.setState(4);
      return true;
      Object localObject2;
      if ((0x10000 & paramInt) != 0)
      {
        localObject1 = new LambdaExp(3);
        localObject2 = ((LambdaExp)localObject1).addDeclaration(XQParser.DOT_VARNAME);
        ((Declaration)localObject2).setFlag(262144L);
        ((Declaration)localObject2).noteValue(null);
        ((LambdaExp)localObject1).addDeclaration(XQParser.POSITION_VARNAME, Type.intType);
        ((LambdaExp)localObject1).addDeclaration(XQParser.LAST_VARNAME, Type.intType);
        paramCompilation.push((ScopeExp)localObject1);
        ((LambdaExp)localObject1).body = localXQParser.parse(paramCompilation);
        paramCompilation.pop((ScopeExp)localObject1);
        localModuleExp.body = ((Expression)localObject1);
      }
      else
      {
        localObject1 = new Vector(10);
        localObject2 = localModuleExp.body;
        if ((localObject2 instanceof BeginExp))
        {
          localObject2 = (BeginExp)localObject2;
          int i = ((BeginExp)localObject2).getExpressionCount();
          localObject2 = ((BeginExp)localObject2).getExpressions();
          paramInt = 0;
          while (paramInt < i)
          {
            ((Vector)localObject1).addElement(localObject2[paramInt]);
            paramInt += 1;
          }
        }
        if ((localObject2 != null) && (localObject2 != QuoteExp.voidExp)) {
          ((Vector)localObject1).addElement(localObject2);
        }
        for (;;)
        {
          localObject2 = localXQParser.parse(paramCompilation);
          if (localObject2 == null)
          {
            if ((localXQParser.parseCount != 0) || (localXQParser.isInteractive())) {
              break;
            }
            localXQParser.error('e', "empty module", "XPST0003");
            return false;
          }
          ((Vector)localObject1).addElement(localObject2);
        }
        paramInt = ((Vector)localObject1).size();
        if (paramInt == 0)
        {
          localModuleExp.body = QuoteExp.voidExp;
        }
        else if (paramInt == 1)
        {
          localModuleExp.body = ((Expression)((Vector)localObject1).elementAt(0));
        }
        else
        {
          localObject2 = new Expression[paramInt];
          ((Vector)localObject1).copyInto((Object[])localObject2);
          localModuleExp.body = new BeginExp((Expression[])localObject2);
        }
      }
    }
  }
  
  public void resolve(Compilation paramCompilation) {}
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\lang\XQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */