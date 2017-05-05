package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.Convert;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.xml.DescendantOrSelfAxis;
import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.MakeWithBaseUri;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.ParentAxis;
import gnu.kawa.xml.ProcessingInstructionType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.TtyInPort;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.FilePath;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.Path;
import gnu.text.SourceError;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.text.URIPath;
import gnu.xml.NamespaceBinding;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import gnu.xquery.util.CastableAs;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.QNameUtils;
import gnu.xquery.util.RelativeStep;
import gnu.xquery.util.ValuesFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.Vector;
import kawa.standard.require;

public class XQParser
  extends Lexer
{
  static final int ARROW_TOKEN = 82;
  static final int ATTRIBUTE_TOKEN = 252;
  static final int AXIS_ANCESTOR = 0;
  static final int AXIS_ANCESTOR_OR_SELF = 1;
  static final int AXIS_ATTRIBUTE = 2;
  static final int AXIS_CHILD = 3;
  static final int AXIS_DESCENDANT = 4;
  static final int AXIS_DESCENDANT_OR_SELF = 5;
  static final int AXIS_FOLLOWING = 6;
  static final int AXIS_FOLLOWING_SIBLING = 7;
  static final int AXIS_NAMESPACE = 8;
  static final int AXIS_PARENT = 9;
  static final int AXIS_PRECEDING = 10;
  static final int AXIS_PRECEDING_SIBLING = 11;
  static final int AXIS_SELF = 12;
  static final int CASE_DOLLAR_TOKEN = 247;
  static final int COLON_COLON_TOKEN = 88;
  static final int COLON_EQUAL_TOKEN = 76;
  static final int COMMENT_TOKEN = 254;
  static final int COUNT_OP_AXIS = 13;
  static final char DECIMAL_TOKEN = '1';
  static final int DECLARE_BASE_URI_TOKEN = 66;
  static final int DECLARE_BOUNDARY_SPACE_TOKEN = 83;
  static final int DECLARE_CONSTRUCTION_TOKEN = 75;
  static final int DECLARE_COPY_NAMESPACES_TOKEN = 76;
  static final int DECLARE_FUNCTION_TOKEN = 80;
  static final int DECLARE_NAMESPACE_TOKEN = 78;
  static final int DECLARE_OPTION_TOKEN = 111;
  static final int DECLARE_ORDERING_TOKEN = 85;
  static final int DECLARE_VARIABLE_TOKEN = 86;
  static final int DEFAULT_COLLATION_TOKEN = 71;
  static final int DEFAULT_ELEMENT_TOKEN = 69;
  static final int DEFAULT_FUNCTION_TOKEN = 79;
  static final int DEFAULT_ORDER_TOKEN = 72;
  static final int DEFINE_QNAME_TOKEN = 87;
  static final int DOCUMENT_TOKEN = 256;
  static final int DOTDOT_TOKEN = 51;
  static final Symbol DOT_VARNAME;
  static final char DOUBLE_TOKEN = '2';
  static final int ELEMENT_TOKEN = 251;
  static final int EOF_TOKEN = -1;
  static final int EOL_TOKEN = 10;
  static final int EVERY_DOLLAR_TOKEN = 246;
  static final int FNAME_TOKEN = 70;
  static final int FOR_DOLLAR_TOKEN = 243;
  static final int IF_LPAREN_TOKEN = 241;
  static final int IMPORT_MODULE_TOKEN = 73;
  static final int IMPORT_SCHEMA_TOKEN = 84;
  static final char INTEGER_TOKEN = '0';
  static final Symbol LAST_VARNAME;
  static final int LET_DOLLAR_TOKEN = 244;
  static final int MODULE_NAMESPACE_TOKEN = 77;
  static final int NCNAME_COLON_TOKEN = 67;
  static final int NCNAME_TOKEN = 65;
  static final int OP_ADD = 413;
  static final int OP_AND = 401;
  static final int OP_ATTRIBUTE = 236;
  static final int OP_AXIS_FIRST = 100;
  static final int OP_BASE = 400;
  static final int OP_CASTABLE_AS = 424;
  static final int OP_CAST_AS = 425;
  static final int OP_COMMENT = 232;
  static final int OP_DIV = 416;
  static final int OP_DOCUMENT = 234;
  static final int OP_ELEMENT = 235;
  static final int OP_EMPTY_SEQUENCE = 238;
  static final int OP_EQ = 426;
  static final int OP_EQU = 402;
  static final int OP_EXCEPT = 421;
  static final int OP_GE = 431;
  static final int OP_GEQ = 407;
  static final int OP_GRT = 405;
  static final int OP_GRTGRT = 410;
  static final int OP_GT = 430;
  static final int OP_IDIV = 417;
  static final int OP_INSTANCEOF = 422;
  static final int OP_INTERSECT = 420;
  static final int OP_IS = 408;
  static final int OP_ISNOT = 409;
  static final int OP_ITEM = 237;
  static final int OP_LE = 429;
  static final int OP_LEQ = 406;
  static final int OP_LSS = 404;
  static final int OP_LSSLSS = 411;
  static final int OP_LT = 428;
  static final int OP_MOD = 418;
  static final int OP_MUL = 415;
  static final int OP_NE = 427;
  static final int OP_NEQ = 403;
  static final int OP_NODE = 230;
  static final int OP_OR = 400;
  static final int OP_PI = 233;
  static final int OP_RANGE_TO = 412;
  static final int OP_SCHEMA_ATTRIBUTE = 239;
  static final int OP_SCHEMA_ELEMENT = 240;
  static final int OP_SUB = 414;
  static final int OP_TEXT = 231;
  static final int OP_TREAT_AS = 423;
  static final int OP_UNION = 419;
  static final int OP_WHERE = 196;
  static final int ORDERED_LBRACE_TOKEN = 249;
  static final int PI_TOKEN = 255;
  static final Symbol POSITION_VARNAME;
  static final int PRAGMA_START_TOKEN = 197;
  static final int QNAME_TOKEN = 81;
  static final int SLASHSLASH_TOKEN = 68;
  static final int SOME_DOLLAR_TOKEN = 245;
  static final int STRING_TOKEN = 34;
  static final int TEXT_TOKEN = 253;
  static final int TYPESWITCH_LPAREN_TOKEN = 242;
  static final int UNORDERED_LBRACE_TOKEN = 250;
  static final int VALIDATE_LBRACE_TOKEN = 248;
  static final int XQUERY_VERSION_TOKEN = 89;
  public static final String[] axisNames;
  static NamespaceBinding builtinNamespaces;
  public static final CastableAs castableAs;
  public static final QuoteExp getExternalFunction;
  public static final InstanceOf instanceOf;
  static final Expression makeCDATA;
  public static QuoteExp makeChildAxisStep;
  public static QuoteExp makeDescendantAxisStep;
  public static Expression makeText;
  static PrimProcedure proc_OccurrenceType_getInstance;
  public static final Convert treatAs;
  public static boolean warnHidePreviousDeclaration;
  public static boolean warnOldVersion = true;
  Path baseURI = null;
  boolean baseURIDeclarationSeen;
  boolean boundarySpaceDeclarationSeen;
  boolean boundarySpacePreserve;
  int commentCount;
  Compilation comp;
  boolean constructionModeDeclarationSeen;
  boolean constructionModeStrip;
  NamespaceBinding constructorNamespaces = NamespaceBinding.predefinedXML;
  boolean copyNamespacesDeclarationSeen;
  int copyNamespacesMode = 3;
  int curColumn;
  int curLine;
  int curToken;
  Object curValue;
  NamedCollator defaultCollator = null;
  String defaultElementNamespace = "";
  char defaultEmptyOrder = 'L';
  boolean emptyOrderDeclarationSeen;
  int enclosedExpressionsSeen;
  String errorIfComment;
  Declaration[] flworDecls;
  int flworDeclsCount;
  int flworDeclsFirst;
  public Namespace[] functionNamespacePath = XQuery.defaultFunctionNamespacePath;
  XQuery interpreter;
  String libraryModuleNamespace;
  boolean orderingModeSeen;
  boolean orderingModeUnordered;
  int parseContext;
  int parseCount;
  NamespaceBinding prologNamespaces;
  private int saveToken;
  private Object saveValue;
  boolean seenDeclaration;
  int seenLast;
  int seenPosition;
  private boolean warnedOldStyleKindTest;
  
  static
  {
    warnHidePreviousDeclaration = false;
    DOT_VARNAME = Symbol.makeUninterned("$dot$");
    POSITION_VARNAME = Symbol.makeUninterned("$position$");
    LAST_VARNAME = Symbol.makeUninterned("$last$");
    instanceOf = new InstanceOf(XQuery.getInstance(), "instance");
    castableAs = CastableAs.castableAs;
    treatAs = Convert.as;
    proc_OccurrenceType_getInstance = new PrimProcedure(ClassType.make("gnu.kawa.reflect.OccurrenceType").getDeclaredMethod("getInstance", 3));
    makeChildAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.ChildAxis", "make", 1));
    makeDescendantAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.DescendantAxis", "make", 1));
    makeText = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
    makeCDATA = makeFunctionExp("gnu.kawa.xml.MakeCDATA", "makeCDATA");
    builtinNamespaces = new NamespaceBinding("local", "http://www.w3.org/2005/xquery-local-functions", new NamespaceBinding("qexo", "http://qexo.gnu.org/", new NamespaceBinding("kawa", "http://kawa.gnu.org/", new NamespaceBinding("html", "http://www.w3.org/1999/xhtml", new NamespaceBinding("fn", "http://www.w3.org/2005/xpath-functions", new NamespaceBinding("xsi", "http://www.w3.org/2001/XMLSchema-instance", new NamespaceBinding("xs", "http://www.w3.org/2001/XMLSchema", new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", NamespaceBinding.predefinedXML))))))));
    getExternalFunction = QuoteExp.getInstance(new PrimProcedure("gnu.xquery.lang.XQuery", "getExternal", 2));
    axisNames = new String[13];
    axisNames[0] = "ancestor";
    axisNames[1] = "ancestor-or-self";
    axisNames[2] = "attribute";
    axisNames[3] = "child";
    axisNames[4] = "descendant";
    axisNames[5] = "descendant-or-self";
    axisNames[6] = "following";
    axisNames[7] = "following-sibling";
    axisNames[8] = "namespace";
    axisNames[9] = "parent";
    axisNames[10] = "preceding";
    axisNames[11] = "preceding-sibling";
    axisNames[12] = "self";
  }
  
  public XQParser(InPort paramInPort, SourceMessages paramSourceMessages, XQuery paramXQuery)
  {
    super(paramInPort, paramSourceMessages);
    this.interpreter = paramXQuery;
    this.nesting = 1;
    this.prologNamespaces = builtinNamespaces;
  }
  
  public static Expression booleanValue(Expression paramExpression)
  {
    return new ApplyExp(makeFunctionExp("gnu.xquery.util.BooleanValue", "booleanValue"), new Expression[] { paramExpression });
  }
  
  static ApplyExp castQName(Expression paramExpression, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Declaration localDeclaration = XQResolveNames.xsQNameDecl;; localDeclaration = XQResolveNames.xsQNameIgnoreDefaultDecl) {
      return new ApplyExp(new ReferenceExp(localDeclaration), new Expression[] { paramExpression });
    }
  }
  
  static Path fixupStaticBaseUri(Path paramPath)
  {
    Path localPath = paramPath.getAbsolute();
    paramPath = localPath;
    if ((localPath instanceof FilePath)) {
      paramPath = URIPath.valueOf(localPath.toURI());
    }
    return paramPath;
  }
  
  private boolean lookingAt(String paramString1, String paramString2)
    throws IOException, SyntaxException
  {
    if (!paramString1.equals(this.curValue)) {
      return false;
    }
    int i = 0;
    int k = paramString2.length();
    for (;;)
    {
      int m = read();
      int j;
      if (i == k)
      {
        if (m < 0) {
          return true;
        }
        if (!XName.isNamePart((char)m))
        {
          unread();
          return true;
        }
        j = i + 1;
      }
      do
      {
        do
        {
          this.port.skip(-j);
          return false;
          j = i;
        } while (m < 0);
        j = i + 1;
      } while (m != paramString2.charAt(i));
      i = j;
    }
  }
  
  static Expression makeBinary(Expression paramExpression1, Expression paramExpression2, Expression paramExpression3)
  {
    return new ApplyExp(paramExpression1, new Expression[] { paramExpression2, paramExpression3 });
  }
  
  static Expression makeExprSequence(Expression paramExpression1, Expression paramExpression2)
  {
    return makeBinary(makeFunctionExp("gnu.kawa.functions.AppendValues", "appendValues"), paramExpression1, paramExpression2);
  }
  
  public static Expression makeFunctionExp(String paramString1, String paramString2)
  {
    return makeFunctionExp(paramString1, Compilation.mangleNameIfNeeded(paramString2), paramString2);
  }
  
  public static Expression makeFunctionExp(String paramString1, String paramString2, String paramString3)
  {
    return new ReferenceExp(paramString3, Declaration.getDeclarationValueFromStatic(paramString1, paramString2, paramString3));
  }
  
  static Expression makeNamedNodeType(boolean paramBoolean, Expression paramExpression1, Expression paramExpression2)
  {
    Object localObject = new Expression[2];
    if (paramBoolean) {}
    for (localObject = "gnu.kawa.xml.AttributeType";; localObject = "gnu.kawa.xml.ElementType")
    {
      paramExpression1 = new ApplyExp(ClassType.make((String)localObject).getDeclaredMethod("make", 1), new Expression[] { paramExpression1 });
      paramExpression1.setFlag(4);
      if (paramExpression2 != null) {
        break;
      }
      return paramExpression1;
    }
    return new BeginExp(paramExpression2, paramExpression1);
  }
  
  private void parseSimpleKindType()
    throws IOException, SyntaxException
  {
    getRawToken();
    if (this.curToken == 41)
    {
      getRawToken();
      return;
    }
    error("expected ')'");
  }
  
  private static final int priority(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 400: 
      return 1;
    case 401: 
      return 2;
    case 402: 
    case 403: 
    case 404: 
    case 405: 
    case 406: 
    case 407: 
    case 408: 
    case 409: 
    case 410: 
    case 411: 
    case 426: 
    case 427: 
    case 428: 
    case 429: 
    case 430: 
    case 431: 
      return 3;
    case 412: 
      return 4;
    case 413: 
    case 414: 
      return 5;
    case 415: 
    case 416: 
    case 417: 
    case 418: 
      return 6;
    case 419: 
      return 7;
    case 420: 
    case 421: 
      return 8;
    case 422: 
      return 9;
    case 423: 
      return 10;
    case 424: 
      return 11;
    }
    return 12;
  }
  
  private int setToken(int paramInt1, int paramInt2)
  {
    this.curToken = paramInt1;
    this.curLine = (this.port.getLineNumber() + 1);
    this.curColumn = (this.port.getColumnNumber() + 1 - paramInt2);
    return paramInt1;
  }
  
  private void warnOldStyleKindTest()
  {
    if (this.warnedOldStyleKindTest) {
      return;
    }
    error('w', "old-style KindTest - first one here");
    this.warnedOldStyleKindTest = true;
  }
  
  public void appendNamedEntity(String paramString)
  {
    paramString = paramString.intern();
    int i = 63;
    if (paramString == "lt") {
      i = 60;
    }
    for (;;)
    {
      tokenBufferAppend(i);
      return;
      if (paramString == "gt") {
        i = 62;
      } else if (paramString == "amp") {
        i = 38;
      } else if (paramString == "quot") {
        i = 34;
      } else if (paramString == "apos") {
        i = 39;
      } else {
        error("unknown enity reference: '" + paramString + "'");
      }
    }
  }
  
  void checkAllowedNamespaceDeclaration(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = "xml".equals(paramString1);
    if ("http://www.w3.org/XML/1998/namespace".equals(paramString2)) {
      if ((!bool) || (!paramBoolean)) {
        error('e', "namespace uri cannot be the same as the prefined xml namespace", "XQST0070");
      }
    }
    while ((!bool) && (!"xmlns".equals(paramString1))) {
      return;
    }
    error('e', "namespace prefix cannot be 'xml' or 'xmlns'", "XQST0070");
  }
  
  void checkSeparator(char paramChar)
  {
    if (XName.isNameStart(paramChar)) {
      error('e', "missing separator", "XPST0003");
    }
  }
  
  public Expression declError(String paramString)
    throws IOException, SyntaxException
  {
    if (this.interactive) {
      return syntaxError(paramString);
    }
    error(paramString);
    for (;;)
    {
      if ((this.curToken == 59) || (this.curToken == -1)) {
        return new ErrorExp(paramString);
      }
      getRawToken();
    }
  }
  
  public void eofError(String paramString)
    throws SyntaxException
  {
    fatal(paramString, "XPST0003");
  }
  
  public void error(char paramChar, String paramString)
  {
    error(paramChar, paramString, null);
  }
  
  public void error(char paramChar, String paramString1, String paramString2)
  {
    SourceMessages localSourceMessages = getMessages();
    paramString1 = new SourceError(paramChar, this.port.getName(), this.curLine, this.curColumn, paramString1);
    paramString1.code = paramString2;
    localSourceMessages.error(paramString1);
  }
  
  public void fatal(String paramString1, String paramString2)
    throws SyntaxException
  {
    SourceMessages localSourceMessages = getMessages();
    paramString1 = new SourceError('f', this.port.getName(), this.curLine, this.curColumn, paramString1);
    paramString1.code = paramString2;
    localSourceMessages.error(paramString1);
    throw new SyntaxException(localSourceMessages);
  }
  
  int getAxis()
  {
    String str = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
    int j = 13;
    int i;
    do
    {
      i = j - 1;
      if (i < 0) {
        break;
      }
      j = i;
    } while (axisNames[i] != str);
    if (i >= 0)
    {
      j = i;
      if (i != 8) {}
    }
    else
    {
      error('e', "unknown axis name '" + str + '\'', "XPST0003");
      j = 3;
    }
    return (char)(j + 100);
  }
  
  public void getDelimited(String paramString)
    throws IOException, SyntaxException
  {
    if (!readDelimited(paramString)) {
      eofError("unexpected end-of-file looking for '" + paramString + '\'');
    }
  }
  
  int getRawToken()
    throws IOException, SyntaxException
  {
    int n = 1;
    int i1;
    do
    {
      for (;;)
      {
        i1 = readUnicodeChar();
        if (i1 < 0) {
          return setToken(-1, 0);
        }
        if ((i1 == 10) || (i1 == 13))
        {
          if (this.nesting <= 0) {
            return setToken(10, 0);
          }
        }
        else if (i1 == 40)
        {
          if (checkNext(':'))
          {
            skipComment();
          }
          else
          {
            if (checkNext('#')) {
              return setToken(197, 2);
            }
            return setToken(40, 1);
          }
        }
        else
        {
          if (i1 != 123) {
            break;
          }
          if (!checkNext('-')) {
            return setToken(123, 1);
          }
          if (read() != 45)
          {
            unread();
            unread();
            return setToken(123, 1);
          }
          skipOldComment();
        }
      }
    } while ((i1 == 32) || (i1 == 9));
    this.tokenBufferLength = 0;
    this.curLine = (this.port.getLineNumber() + 1);
    this.curColumn = this.port.getColumnNumber();
    int i = (char)i1;
    int k = i;
    label437:
    int m;
    switch (i)
    {
    default: 
      if ((Character.isDigit(i)) || ((i == 46) && (Character.isDigit((char)peek())))) {
        if (i == 46)
        {
          k = n;
          n = i;
          tokenBufferAppend(n);
          i1 = read();
          if (i1 >= 0) {
            break label810;
          }
          if ((i1 != 101) && (i1 != 69)) {
            break label886;
          }
          tokenBufferAppend((char)i1);
          n = read();
          if (n != 43)
          {
            k = n;
            if (n != 45) {}
          }
          else
          {
            tokenBufferAppend(n);
            m = read();
          }
          i1 = 0;
          n = m;
          m = i1;
          label501:
          if (n >= 0) {
            break label845;
          }
          label506:
          if (m == 0) {
            error('e', "no digits following exponent", "XPST0003");
          }
          m = 50;
        }
      }
      break;
    }
    for (;;)
    {
      this.curToken = m;
      return m;
      if (checkNext('='))
      {
        m = 76;
      }
      else
      {
        m = i;
        if (checkNext(':'))
        {
          m = 88;
          continue;
          m = 419;
          continue;
          m = 415;
          continue;
          m = 413;
          continue;
          m = 414;
          continue;
          m = i;
          if (checkNext('='))
          {
            m = 403;
            continue;
            m = i;
            if (checkNext('/'))
            {
              m = 68;
              continue;
              if (checkNext('>')) {}
              m = 402;
              continue;
              if (checkNext('=')) {
                m = 407;
              }
              for (;;)
              {
                break;
                if (checkNext('>')) {
                  m = 410;
                } else {
                  m = 405;
                }
              }
              if (checkNext('=')) {
                m = 406;
              }
              for (;;)
              {
                break;
                if (checkNext('<')) {
                  m = 411;
                } else {
                  m = 404;
                }
              }
              char c = pushNesting((char)i1);
              for (;;)
              {
                n = readUnicodeChar();
                if (n < 0) {
                  eofError("unexpected end-of-file in string starting here");
                }
                if (n == 38)
                {
                  parseEntityOrCharRef();
                }
                else
                {
                  m = n;
                  if (i == n)
                  {
                    if (i != peek())
                    {
                      popNesting(c);
                      m = 34;
                      break;
                    }
                    m = read();
                  }
                  tokenBufferAppend(m);
                }
              }
              m = 0;
              n = i;
              break;
              label810:
              int j = (char)i1;
              if (j == 46)
              {
                if (m != 0) {
                  break label437;
                }
                m = 1;
                n = j;
                break;
              }
              n = j;
              if (Character.isDigit(j)) {
                break;
              }
              break label437;
              label845:
              j = (char)n;
              if (!Character.isDigit(j))
              {
                checkSeparator(j);
                unread();
                break label506;
              }
              tokenBufferAppend(j);
              n = read();
              m += 1;
              break label501;
              label886:
              if (m != 0) {}
              for (n = 49;; n = 48)
              {
                m = n;
                if (i1 < 0) {
                  break;
                }
                checkSeparator((char)i1);
                unread(i1);
                m = n;
                break;
              }
              if (j == 46)
              {
                m = j;
                if (checkNext('.')) {
                  m = 51;
                }
              }
              else if (XName.isNameStart(j))
              {
                m = j;
                do
                {
                  tokenBufferAppend(m);
                  n = read();
                  i1 = (char)n;
                  m = i1;
                } while (XName.isNamePart(i1));
                if (n < 0)
                {
                  m = 65;
                }
                else
                {
                  if (n != 58) {
                    m = 65;
                  }
                  for (;;)
                  {
                    unread(n);
                    break;
                    n = read();
                    if (n < 0) {
                      eofError("unexpected end-of-file after NAME ':'");
                    }
                    m = (char)n;
                    if (XName.isNameStart(m))
                    {
                      tokenBufferAppend(58);
                      do
                      {
                        tokenBufferAppend(m);
                        n = read();
                        i1 = (char)n;
                        m = i1;
                      } while (XName.isNamePart(i1));
                      m = 81;
                    }
                    else if (m == 61)
                    {
                      unread(m);
                      m = 65;
                    }
                    else
                    {
                      m = 67;
                    }
                  }
                }
              }
              else if ((j >= 32) && (j < 127))
              {
                syntaxError("invalid character '" + j + '\'');
                m = j;
              }
              else
              {
                syntaxError("invalid character '\\u" + Integer.toHexString(j) + '\'');
                m = j;
              }
            }
          }
        }
      }
    }
  }
  
  public String getStaticBaseUri()
  {
    Object localObject1 = this.baseURI;
    Object localObject2 = localObject1;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = Environment.getCurrent().get(Symbol.make("", "base-uri"), null, null);
      localObject2 = localObject1;
      if (localObject3 != null) {
        if (!(localObject3 instanceof Path)) {
          break label125;
        }
      }
    }
    label125:
    for (localObject2 = localObject1;; localObject2 = URIPath.valueOf(localObject3.toString()))
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = getPort();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject2 = ((LineBufferedReader)localObject3).getPath();
          localObject1 = localObject2;
          if ((localObject2 instanceof FilePath)) {
            if ((((Path)localObject2).exists()) && (!(localObject3 instanceof TtyInPort)))
            {
              localObject1 = localObject2;
              if (!(localObject3 instanceof CharArrayInPort)) {}
            }
            else
            {
              localObject1 = null;
            }
          }
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = Path.currentPath();
      }
      localObject2 = fixupStaticBaseUri((Path)localObject2);
      this.baseURI = ((Path)localObject2);
      return localObject2.toString();
    }
  }
  
  public void handleOption(Symbol paramSymbol, String paramString) {}
  
  Expression makeBinary(int paramInt, Expression paramExpression1, Expression paramExpression2)
    throws IOException, SyntaxException
  {
    Expression localExpression;
    switch (paramInt)
    {
    case 422: 
    case 423: 
    case 424: 
    case 425: 
    default: 
      return syntaxError("unimplemented binary op: " + paramInt);
    case 413: 
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "add", "+");
    }
    for (;;)
    {
      return makeBinary(localExpression, paramExpression1, paramExpression2);
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "sub", "-");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "mul", "*");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "div", "div");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "idiv", "idiv");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.ArithOp", "mod", "mod");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valEq", "eq");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valNe", "ne");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valLt", "lt");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valLe", "le");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valGt", "gt");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "valGe", "ge");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "=");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "!=");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "<");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", "<=");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", ">");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.Compare", ">=");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Eq", "is");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ne", "isnot");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Gr", ">>");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ls", "<<");
      continue;
      localExpression = makeFunctionExp("gnu.xquery.util.IntegerRange", "integerRange");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.UnionNodes", "unionNodes");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "intersectNodes");
      continue;
      localExpression = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "exceptNodes");
    }
  }
  
  public void mark()
    throws IOException
  {
    super.mark();
    this.saveToken = this.curToken;
    this.saveValue = this.curValue;
  }
  
  public boolean match(String paramString)
  {
    if (this.curToken != 65) {}
    int i;
    do
    {
      return false;
      i = paramString.length();
    } while (this.tokenBufferLength != i);
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (paramString.charAt(j) == this.tokenBuffer[j]);
    return false;
    return true;
  }
  
  boolean match(String paramString1, String paramString2, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    if (match(paramString1))
    {
      mark();
      getRawToken();
      if (match(paramString2))
      {
        reset();
        getRawToken();
        return true;
      }
      reset();
      if (paramBoolean)
      {
        error('e', "'" + paramString1 + "' must be followed by '" + paramString2 + "'", "XPST0003");
        return true;
      }
    }
    return false;
  }
  
  public void maybeSetLine(Declaration paramDeclaration, int paramInt1, int paramInt2)
  {
    String str = getName();
    if (str != null)
    {
      paramDeclaration.setFile(str);
      paramDeclaration.setLine(paramInt1, paramInt2);
    }
  }
  
  public void maybeSetLine(Expression paramExpression, int paramInt1, int paramInt2)
  {
    String str = getName();
    if ((str != null) && (paramExpression.getFileName() == null) && (!(paramExpression instanceof QuoteExp)))
    {
      paramExpression.setFile(str);
      paramExpression.setLine(paramInt1, paramInt2);
    }
  }
  
  protected Symbol namespaceResolve(String paramString, boolean paramBoolean)
  {
    int i = paramString.indexOf(':');
    String str2;
    String str1;
    String str3;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i).intern();
      str1 = QNameUtils.lookupPrefix(str2, this.constructorNamespaces, this.prologNamespaces);
      str3 = str1;
      if (str1 == null)
      {
        if (i >= 0) {
          break label141;
        }
        str1 = "";
        label55:
        str3 = str1;
        if (str1 == null)
        {
          getMessages().error('e', "unknown namespace prefix '" + str2 + "'", "XPST0081");
          str3 = "(unknown namespace)";
        }
      }
      if (i >= 0) {
        break label191;
      }
    }
    for (;;)
    {
      return Symbol.make(str3, paramString, str2);
      if (paramBoolean)
      {
        str2 = "(functions)";
        break;
      }
      str2 = XQuery.DEFAULT_ELEMENT_PREFIX;
      break;
      label141:
      if (this.comp.isPedantic()) {
        break label55;
      }
      try
      {
        Class.forName(str2);
        str1 = "class:" + str2;
      }
      catch (Exception localException)
      {
        Object localObject = null;
      }
      break label55;
      label191:
      paramString = paramString.substring(i + 1);
    }
  }
  
  public Expression parse(Compilation paramCompilation)
    throws IOException, SyntaxException
  {
    this.comp = paramCompilation;
    int i = skipSpace();
    if (i < 0) {
      paramCompilation = null;
    }
    int k;
    int m;
    do
    {
      return paramCompilation;
      this.parseCount += 1;
      unread(i);
      k = getLineNumber() + 1;
      m = getColumnNumber() + 1;
      if ((i == 35) && (k == 1) && (m == 1))
      {
        read();
        j = read();
        i = j;
        if (j == 33)
        {
          j = read();
          i = j;
          if (j != 47) {
            i = j;
          }
        }
        else
        {
          error("'#' is only allowed in initial '#!/PROGRAM'");
        }
        while ((i != 13) && (i != 10) && (i >= 0)) {
          i = read();
        }
      }
      if (getRawToken() == -1) {
        return null;
      }
      peekOperand();
      if ((this.curToken == 65) && ("namespace".equals((String)this.curValue)))
      {
        if (warnOldVersion) {
          error('w', "use 'declare namespace' instead of 'namespace'");
        }
        this.curToken = 78;
      }
      switch (this.curToken)
      {
      default: 
        localObject1 = parseExprSequence(-1, true);
        if (this.curToken == 10) {
          unread(10);
        }
        maybeSetLine((Expression)localObject1, k, m);
        paramCompilation = (Compilation)localObject1;
      }
    } while (this.libraryModuleNamespace == null);
    error('e', "query body in a library module", "XPST0003");
    return (Expression)localObject1;
    i = getLineNumber();
    int j = getColumnNumber();
    if (peekNonSpace("unexpected end-of-file after 'define QName'") == 40)
    {
      syntaxError("'missing 'function' after 'define'");
      this.curToken = 65;
      return parseFunctionDefinition(i + 1, j + 1);
    }
    return syntaxError("missing keyword after 'define'");
    i = getLineNumber();
    j = getColumnNumber();
    getRawToken();
    peekNonSpace("unexpected end-of-file after 'define function'");
    char c = pushNesting('d');
    paramCompilation = parseFunctionDefinition(i + 1, j + 1);
    popNesting(c);
    parseSeparator();
    maybeSetLine(paramCompilation, k, m);
    this.seenDeclaration = true;
    return paramCompilation;
    getRawToken();
    Object localObject5 = parseVariableDeclaration();
    if (localObject5 == null) {
      return syntaxError("missing Variable");
    }
    Object localObject1 = ((Declaration)localObject5).getSymbol();
    if ((localObject1 instanceof String))
    {
      getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
      ((Declaration)localObject5).setSymbol(namespaceResolve((String)localObject1, false));
    }
    if (this.libraryModuleNamespace != null)
    {
      localObject1 = ((Symbol)((Declaration)localObject5).getSymbol()).getNamespaceURI();
      if ((localObject1 != this.libraryModuleNamespace) && ((!"http://www.w3.org/2005/xquery-local-functions".equals(localObject1)) || (paramCompilation.isPedantic()))) {
        error('e', "variable not in namespace of library module", "XQST0048");
      }
    }
    paramCompilation.currentScope().addDeclaration((Declaration)localObject5);
    getRawToken();
    Object localObject3 = parseOptionalTypeDeclaration();
    ((Declaration)localObject5).setCanRead(true);
    ((Declaration)localObject5).setFlag(16384L);
    i = 0;
    if ((this.curToken == 402) || (this.curToken == 76))
    {
      if (this.curToken == 402) {
        error("declare variable contains '=' instead of ':='");
      }
      getRawToken();
      i = 1;
    }
    if (this.curToken == 123)
    {
      warnOldVersion("obsolete '{' in variable declaration");
      paramCompilation = parseEnclosedExpr();
      parseSeparator();
    }
    for (;;)
    {
      localObject1 = paramCompilation;
      if (localObject3 != null) {
        localObject1 = Compilation.makeCoercion(paramCompilation, (Expression)localObject3);
      }
      ((Declaration)localObject5).noteValue((Expression)localObject1);
      paramCompilation = SetExp.makeDefinition((Declaration)localObject5, (Expression)localObject1);
      maybeSetLine(paramCompilation, k, m);
      this.seenDeclaration = true;
      return paramCompilation;
      if (match("external"))
      {
        localObject1 = castQName(new QuoteExp(((Declaration)localObject5).getSymbol()), false);
        if (localObject3 == null) {}
        for (paramCompilation = QuoteExp.nullExp;; paramCompilation = (Compilation)localObject3)
        {
          paramCompilation = new ApplyExp(getExternalFunction, new Expression[] { localObject1, paramCompilation });
          maybeSetLine(paramCompilation, this.curLine, this.curColumn);
          getRawToken();
          break;
        }
      }
      localObject4 = parseExpr();
      localObject1 = null;
      if ((i == 0) || (localObject4 == null)) {
        localObject1 = syntaxError("expected ':= init' or 'external'");
      }
      paramCompilation = (Compilation)localObject4;
      if (localObject4 == null) {
        paramCompilation = (Compilation)localObject1;
      }
    }
    i = this.curToken;
    if ((i == 77) && (this.libraryModuleNamespace != null))
    {
      error('e', "duplicate module declaration");
      if (this.nesting == 0) {
        break label1065;
      }
    }
    label1065:
    for (boolean bool = true;; bool = false)
    {
      j = skipSpace(bool);
      if (j < 0) {
        break label1380;
      }
      unread();
      if (!XName.isNameStart((char)j)) {
        break label1380;
      }
      getRawToken();
      if (this.curToken == 65) {
        break label1071;
      }
      return syntaxError("missing namespace prefix");
      if ((!this.seenDeclaration) || (this.interactive)) {
        break;
      }
      error('e', "namespace declared after function/variable/option");
      break;
    }
    label1071:
    localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
    getRawToken();
    if (this.curToken != 402) {
      return syntaxError("missing '=' in namespace declaration");
    }
    getRawToken();
    if (this.curToken != 34) {
      return syntaxError("missing uri in namespace declaration");
    }
    localObject3 = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
    Object localObject4 = ((String)localObject1).intern();
    for (localObject1 = this.prologNamespaces;; localObject1 = ((NamespaceBinding)localObject1).getNext()) {
      if (localObject1 != builtinNamespaces)
      {
        if (((NamespaceBinding)localObject1).getPrefix() == localObject4) {
          error('e', "duplicate declarations for the same namespace prefix '" + (String)localObject4 + "'", "XQST0033");
        }
      }
      else
      {
        pushNamespace((String)localObject4, (String)localObject3);
        checkAllowedNamespaceDeclaration((String)localObject4, (String)localObject3, false);
        parseSeparator();
        if (i != 77) {
          break label1376;
        }
        localObject1 = paramCompilation.getModule();
        localObject4 = Compilation.mangleURI((String)localObject3) + '.' + XQuery.makeClassName(((ModuleExp)localObject1).getFileName());
        ((ModuleExp)localObject1).setName((String)localObject4);
        paramCompilation.mainClass = new ClassType((String)localObject4);
        ((ModuleExp)localObject1).setType(paramCompilation.mainClass);
        ModuleManager.getInstance().find(paramCompilation).setNamespaceUri((String)localObject3);
        ((ModuleExp)localObject1).setType(paramCompilation.mainClass);
        if (((String)localObject3).length() != 0) {
          break;
        }
        return syntaxError("zero-length module namespace", "XQST0088");
      }
    }
    this.libraryModuleNamespace = ((String)localObject3);
    label1376:
    return QuoteExp.voidExp;
    label1380:
    fatal("'import schema' not implemented", "XQST0009");
    getRawToken();
    localObject1 = null;
    if (match("namespace"))
    {
      getRawToken();
      if (this.curToken != 65) {
        return syntaxError("missing namespace prefix");
      }
      localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      getRawToken();
      if (this.curToken != 402) {
        return syntaxError("missing '=' in namespace declaration");
      }
      getRawToken();
    }
    if (this.curToken != 34) {
      return syntaxError("missing uri in namespace declaration");
    }
    if (this.tokenBufferLength == 0) {
      return syntaxError("zero-length target namespace", "XQST0088");
    }
    localObject3 = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
    if (localObject1 != null)
    {
      checkAllowedNamespaceDeclaration((String)localObject1, (String)localObject3, false);
      pushNamespace(((String)localObject1).intern(), (String)localObject3);
    }
    getRawToken();
    ModuleManager.getInstance().find(paramCompilation);
    localObject4 = paramCompilation.getModule();
    localObject1 = new Vector();
    Object localObject6 = Compilation.mangleURI((String)localObject3);
    paramCompilation.setLine(this.port.getName(), k, m);
    if (match("at"))
    {
      do
      {
        getRawToken();
        if (this.curToken != 34) {
          return syntaxError("missing module location");
        }
        localObject5 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        localObject6 = Compilation.mangleURI((String)localObject3) + '.' + XQuery.makeClassName((String)localObject5);
        ModuleInfo localModuleInfo = require.lookupModuleFromSourcePath((String)localObject5, (ScopeExp)localObject4);
        if (localModuleInfo == null) {
          paramCompilation.error('e', "malformed URL: " + (String)localObject5);
        }
        require.importDefinitions((String)localObject6, localModuleInfo, null, (Vector)localObject1, (ScopeExp)localObject4, paramCompilation);
        if (this.nesting == 0) {
          break;
        }
        bool = true;
        i = skipSpace(bool);
      } while (i == 44);
      unread(i);
      parseSeparator();
    }
    for (;;)
    {
      if ((paramCompilation.pendingImports != null) && (paramCompilation.pendingImports.size() > 0)) {
        error('e', "module import forms a cycle", "XQST0073");
      }
      paramCompilation = new Expression[((Vector)localObject1).size()];
      ((Vector)localObject1).toArray(paramCompilation);
      return BeginExp.canonicalize(paramCompilation);
      bool = false;
      break;
      localObject5 = ModuleManager.getInstance();
      j = 0;
      try
      {
        ((ModuleManager)localObject5).loadPackageInfo((String)localObject6);
        i = 0;
        localObject6 = ((ModuleManager)localObject5).getModule(i);
        if (localObject6 == null)
        {
          if (j == 0) {
            error('e', "no module found for " + (String)localObject3);
          }
          if (this.curToken == 59) {
            continue;
          }
          parseSeparator();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          error('e', "error loading map for " + (String)localObject3 + " - " + localThrowable);
        }
        if (!((String)localObject3).equals(localThrowable.getNamespaceUri())) {}
        for (;;)
        {
          i += 1;
          break;
          j += 1;
          require.importDefinitions(localThrowable.getClassName(), localThrowable, null, (Vector)localObject1, (ScopeExp)localObject4, paramCompilation);
        }
        if ((this.defaultCollator != null) && (!this.interactive)) {
          error('e', "duplicate default collation declaration", "XQST0038");
        }
        paramCompilation = parseURILiteral();
        if ((paramCompilation instanceof Expression)) {
          return (Expression)paramCompilation;
        }
        localObject1 = (String)paramCompilation;
        paramCompilation = (Compilation)localObject1;
        try
        {
          localObject1 = resolveAgainstBaseUri((String)localObject1);
          paramCompilation = (Compilation)localObject1;
          this.defaultCollator = NamedCollator.make((String)localObject1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.defaultCollator = NamedCollator.codepointCollation;
            error('e', "unknown collation '" + paramCompilation + "'", "XQST0038");
          }
        }
        parseSeparator();
        return QuoteExp.voidExp;
        if (this.curToken == 79)
        {
          i = 1;
          if (i == 0) {
            break label2245;
          }
          paramCompilation = "(functions)";
          if (this.prologNamespaces.resolve(paramCompilation, builtinNamespaces) == null) {
            break label2252;
          }
          error('e', "duplicate default namespace declaration", "XQST0066");
          getRawToken();
          if (!match("namespace")) {
            break label2278;
          }
          getRawToken();
        }
        for (;;)
        {
          if ((this.curToken == 402) || (this.curToken == 76))
          {
            warnOldVersion("extra '=' in default namespace declaration");
            getRawToken();
          }
          if (this.curToken == 34) {
            break label2315;
          }
          return declError("missing namespace uri");
          i = 0;
          break;
          paramCompilation = XQuery.DEFAULT_ELEMENT_PREFIX;
          break label2146;
          if ((!this.seenDeclaration) || (this.interactive)) {
            break label2172;
          }
          error('e', "default namespace declared after function/variable/option");
          break label2172;
          if ((this.curToken != 34) && (this.curToken != 402)) {
            return declError("expected 'namespace' keyword");
          }
          warnOldVersion("expected 'namespace' keyword");
        }
        Object localObject2 = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
        if (i != 0)
        {
          this.functionNamespacePath = new Namespace[1];
          this.functionNamespacePath[0] = Namespace.valueOf((String)localObject2);
        }
        for (;;)
        {
          pushNamespace(paramCompilation, (String)localObject2);
          checkAllowedNamespaceDeclaration(paramCompilation, (String)localObject2, false);
          parseSeparator();
          return QuoteExp.voidExp;
          this.defaultElementNamespace = ((String)localObject2);
        }
        getRawToken();
        if (this.curToken == 402)
        {
          warnOldVersion("obsolate '=' in boundary-space declaration");
          getRawToken();
        }
        if ((this.boundarySpaceDeclarationSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare boundary-space' seen", "XQST0068");
        }
        this.boundarySpaceDeclarationSeen = true;
        if (match("preserve")) {
          this.boundarySpacePreserve = true;
        }
        for (;;)
        {
          parseSeparator();
          return QuoteExp.voidExp;
          if (match("strip"))
          {
            this.boundarySpacePreserve = false;
          }
          else
          {
            if (!match("skip")) {
              break;
            }
            warnOldVersion("update: declare boundary-space skip -> strip");
            this.boundarySpacePreserve = false;
          }
        }
        return syntaxError("boundary-space declaration must be preserve or strip");
        getRawToken();
        if ((this.constructionModeDeclarationSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare construction' seen", "XQST0067");
        }
        this.constructionModeDeclarationSeen = true;
        if (match("strip")) {}
        for (this.constructionModeStrip = true;; this.constructionModeStrip = false)
        {
          parseSeparator();
          return QuoteExp.voidExp;
          if (!match("preserve")) {
            break;
          }
        }
        return syntaxError("construction declaration must be strip or preserve");
        getRawToken();
        if ((this.copyNamespacesDeclarationSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare copy-namespaces' seen", "XQST0055");
        }
        this.copyNamespacesDeclarationSeen = true;
        if (match("preserve")) {}
        for (this.copyNamespacesMode |= 0x1;; this.copyNamespacesMode &= 0xFFFFFFFE)
        {
          getRawToken();
          if (this.curToken == 44) {
            break label2715;
          }
          return syntaxError("missing ',' in copy-namespaces declaration");
          if (!match("no-preserve")) {
            break;
          }
        }
        return syntaxError("expected 'preserve' or 'no-preserve' after 'declare copy-namespaces'");
        getRawToken();
        if (match("inherit")) {}
        for (this.copyNamespacesMode |= 0x2;; this.copyNamespacesMode &= 0xFFFFFFFD)
        {
          parseSeparator();
          return QuoteExp.voidExp;
          if (!match("no-inherit")) {
            break;
          }
        }
        return syntaxError("expected 'inherit' or 'no-inherit' in copy-namespaces declaration");
        getRawToken();
        bool = match("empty");
        if ((this.emptyOrderDeclarationSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare default empty order' seen", "XQST0069");
        }
        this.emptyOrderDeclarationSeen = true;
        if (bool)
        {
          getRawToken();
          if (!match("greatest")) {
            break label2869;
          }
        }
        for (this.defaultEmptyOrder = 'G';; this.defaultEmptyOrder = 'L')
        {
          parseSeparator();
          return QuoteExp.voidExp;
          syntaxError("expected 'empty greatest' or 'empty least'");
          break;
          if (!match("least")) {
            break label2888;
          }
        }
        return syntaxError("expected 'empty greatest' or 'empty least'");
        getRawToken();
        if (this.curToken != 81) {
          syntaxError("expected QName after 'declare option'");
        }
        for (;;)
        {
          parseSeparator();
          this.seenDeclaration = true;
          return QuoteExp.voidExp;
          paramCompilation = new String(this.tokenBuffer, 0, this.tokenBufferLength);
          getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
          localObject2 = namespaceResolve(paramCompilation, false);
          getRawToken();
          if (this.curToken != 34) {
            syntaxError("expected string literal after 'declare option " + paramCompilation + '\'');
          } else {
            handleOption((Symbol)localObject2, new String(this.tokenBuffer, 0, this.tokenBufferLength));
          }
        }
        if ((this.orderingModeSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare ordering' seen", "XQST0065");
        }
        this.orderingModeSeen = true;
        getRawToken();
        if (match("ordered")) {}
        for (this.orderingModeUnordered = false;; this.orderingModeUnordered = true)
        {
          parseSeparator();
          return QuoteExp.voidExp;
          if (!match("unordered")) {
            break;
          }
        }
        return syntaxError("ordering declaration must be ordered or unordered");
        if (this.parseCount != 1) {
          error('e', "'xquery version' does not start module");
        }
        for (;;)
        {
          getRawToken();
          if (this.curToken != 34) {
            break;
          }
          paramCompilation = new String(this.tokenBuffer, 0, this.tokenBufferLength);
          if (!paramCompilation.equals("1.0")) {
            error('e', "unrecognized xquery version " + paramCompilation, "XQST0031");
          }
          getRawToken();
          if (!match("encoding")) {
            break label3466;
          }
          getRawToken();
          if (this.curToken == 34) {
            break label3285;
          }
          return syntaxError("invalid encoding specification");
          if (this.commentCount > 0) {
            error('w', "comments should not precede 'xquery version'");
          }
        }
        return syntaxError("missing version string after 'xquery version'");
        new String(this.tokenBuffer, 0, this.tokenBufferLength);
        j = this.tokenBufferLength;
        if (j == 0) {
          i = 1;
        }
        for (;;)
        {
          k = j - 1;
          if ((k < 0) || (i != 0)) {
            break;
          }
          m = this.tokenBuffer[k];
          if (m >= 65)
          {
            j = k;
            if (m <= 90) {}
          }
          else if (m >= 97)
          {
            j = k;
            if (m <= 122) {}
          }
          else if (k != 0)
          {
            if (m >= 48)
            {
              j = k;
              if (m <= 57) {}
            }
            else
            {
              j = k;
              if (m != 46)
              {
                j = k;
                if (m != 95)
                {
                  j = k;
                  if (m == 45) {}
                }
              }
            }
          }
          else
          {
            i = 1;
            j = k;
            continue;
            i = 0;
          }
        }
        if (i != 0) {
          error('e', "invalid encoding name syntax", "XQST0087");
        }
        getRawToken();
        if (this.curToken != 59) {
          syntaxError("missing ';'");
        }
        return QuoteExp.voidExp;
        if ((this.baseURIDeclarationSeen) && (!this.interactive)) {
          syntaxError("duplicate 'declare base-uri' seen", "XQST0032");
        }
        this.baseURIDeclarationSeen = true;
        paramCompilation = parseURILiteral();
        if ((paramCompilation instanceof Expression)) {
          return (Expression)paramCompilation;
        }
        parseSeparator();
        setStaticBaseUri((String)paramCompilation);
        return QuoteExp.voidExp;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label2146:
        label2172:
        label2245:
        label2252:
        label2278:
        label2315:
        label2715:
        label2869:
        label2888:
        label3285:
        label3466:
        for (;;) {}
      }
    }
  }
  
  Expression parseBinaryExpr(int paramInt)
    throws IOException, SyntaxException
  {
    Object localObject1 = parseUnaryExpr();
    for (;;)
    {
      int i = peekOperator();
      if ((i == 10) || ((i == 404) && (peek() == 47))) {}
      int j;
      do
      {
        return (Expression)localObject1;
        j = priority(i);
      } while (j < paramInt);
      char c = pushNesting('%');
      getRawToken();
      popNesting(c);
      Object localObject2;
      if ((i >= 422) && (i <= 425))
      {
        if ((i == 425) || (i == 424)) {
          this.parseContext = 67;
        }
        Expression localExpression = parseDataType();
        this.parseContext = 0;
        localObject2 = new Expression[2];
        switch (i)
        {
        default: 
          localObject2[0] = localExpression;
          localObject2[1] = localObject1;
          localObject1 = new ReferenceExp(XQResolveNames.castAsDecl);
        }
        for (;;)
        {
          localObject1 = new ApplyExp((Expression)localObject1, (Expression[])localObject2);
          break;
          localObject2[0] = localObject1;
          localObject2[1] = localExpression;
          localObject1 = makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf");
          continue;
          localObject2[0] = localObject1;
          localObject2[1] = localExpression;
          localObject1 = new ReferenceExp(XQResolveNames.castableAsDecl);
          continue;
          localObject2[0] = localExpression;
          localObject2[1] = localObject1;
          localObject1 = makeFunctionExp("gnu.xquery.lang.XQParser", "treatAs");
        }
      }
      if (i == 422)
      {
        localObject2 = parseDataType();
        localObject1 = new ApplyExp(makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf"), new Expression[] { localObject1, localObject2 });
      }
      else
      {
        localObject2 = parseBinaryExpr(j + 1);
        if (i == 401) {
          localObject1 = new IfExp(booleanValue((Expression)localObject1), booleanValue((Expression)localObject2), XQuery.falseExp);
        } else if (i == 400) {
          localObject1 = new IfExp(booleanValue((Expression)localObject1), XQuery.trueExp, booleanValue((Expression)localObject2));
        } else {
          localObject1 = makeBinary(i, (Expression)localObject1, (Expression)localObject2);
        }
      }
    }
  }
  
  void parseContent(char paramChar, Vector paramVector)
    throws IOException, SyntaxException
  {
    this.tokenBufferLength = 0;
    int j = paramVector.size() - 1;
    boolean bool2;
    boolean bool1;
    if ((!this.boundarySpacePreserve) && (paramChar == '<'))
    {
      bool2 = true;
      bool1 = bool2;
    }
    for (;;)
    {
      char c1 = read();
      int i;
      Object localObject1;
      if (c1 == paramChar)
      {
        if (paramChar == '<')
        {
          i = read();
          localObject1 = null;
          if (this.tokenBufferLength > 0)
          {
            localObject1 = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength));
            localObject1 = new ApplyExp(makeText, new Expression[] { localObject1 });
          }
          this.tokenBufferLength = 0;
          if (i == 47)
          {
            if ((localObject1 != null) && (!bool1)) {
              paramVector.addElement(localObject1);
            }
            label139:
            return;
            bool2 = false;
            break;
          }
          Expression localExpression = parseXMLConstructor(i, true);
          char c2 = '\000';
          int k = 0;
          i = k;
          c1 = c2;
          if ((localExpression instanceof ApplyExp))
          {
            Object localObject2 = (ApplyExp)localExpression;
            i = k;
            c1 = c2;
            if (((ApplyExp)localObject2).getFunction() == makeCDATA)
            {
              c1 = '\001';
              localObject2 = (String)((ApplyExp)localObject2).getArg(0).valueIfConstant();
              if ((localObject2 == null) || (((String)localObject2).length() != 0)) {
                break label279;
              }
              i = 1;
            }
          }
          label232:
          if ((localObject1 != null) && ((!bool1) || (c1 != 0))) {
            paramVector.addElement(localObject1);
          }
          if (c1 != 0) {}
          for (bool1 = false;; bool1 = bool2)
          {
            if (i == 0) {
              paramVector.addElement(localExpression);
            }
            this.tokenBufferLength = 0;
            break;
            label279:
            i = 0;
            break label232;
          }
        }
        if (checkNext(paramChar))
        {
          tokenBufferAppend(paramChar);
          continue;
        }
      }
      if ((c1 == paramChar) || (c1 < 0) || (c1 == '{'))
      {
        if (c1 == '{') {}
        for (i = read();; i = -1)
        {
          if (i != 123) {
            break label360;
          }
          tokenBufferAppend(123);
          bool1 = false;
          break;
        }
        label360:
        if ((this.tokenBufferLength > 0) && (!bool1)) {}
        for (localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);; localObject1 = "")
        {
          localObject1 = new QuoteExp(localObject1);
          paramVector.addElement(new ApplyExp(makeText, new Expression[] { localObject1 }));
          do
          {
            this.tokenBufferLength = 0;
            if (c1 == paramChar) {
              break label139;
            }
            if (c1 >= 0) {
              break label474;
            }
            eofError("unexpected end-of-file");
            break;
          } while ((c1 != '{') || (j != paramVector.size()));
        }
        label474:
        unread(i);
        this.enclosedExpressionsSeen += 1;
        paramVector.addElement(parseEnclosedExpr());
        this.tokenBufferLength = 0;
        j = paramVector.size();
        bool1 = bool2;
      }
      else if (c1 == '}')
      {
        i = read();
        if (i == 125)
        {
          tokenBufferAppend(125);
          bool1 = false;
        }
        else
        {
          error("unexpected '}' in element content");
          unread(i);
        }
      }
      else if (c1 == '&')
      {
        parseEntityOrCharRef();
        bool1 = false;
      }
      else
      {
        i = c1;
        if (paramChar != '<') {
          if ((c1 != '\t') && (c1 != '\n'))
          {
            i = c1;
            if (c1 != '\r') {}
          }
          else
          {
            i = 32;
          }
        }
        if (i == 60) {
          error('e', "'<' must be quoted in a direct attribute value");
        }
        boolean bool3 = bool1;
        if (bool1) {
          bool3 = Character.isWhitespace((char)i);
        }
        tokenBufferAppend((char)i);
        bool1 = bool3;
      }
    }
  }
  
  public Expression parseDataType()
    throws IOException, SyntaxException
  {
    Object localObject = parseItemType();
    int j;
    int i;
    if (localObject == null)
    {
      if (this.curToken != 238) {
        return syntaxError("bad syntax - expected DataType");
      }
      parseSimpleKindType();
      if ((this.curToken == 63) || (this.curToken == 413) || (this.curToken == 415))
      {
        getRawToken();
        return syntaxError("occurrence-indicator meaningless after empty-sequence()");
      }
      localObject = QuoteExp.getInstance(OccurrenceType.emptySequenceType);
      j = 0;
      i = 0;
    }
    while ((this.parseContext == 67) && (i != 1))
    {
      return syntaxError("type to 'cast as' or 'castable as' must be a 'SingleType'");
      if (this.curToken == 63)
      {
        j = 0;
        i = 1;
      }
      else if (this.curToken == 413)
      {
        j = 1;
        i = -1;
      }
      else if (this.curToken == 415)
      {
        j = 0;
        i = -1;
      }
      else
      {
        j = 1;
        i = 1;
      }
    }
    if (j != i)
    {
      getRawToken();
      QuoteExp localQuoteExp1 = QuoteExp.getInstance(IntNum.make(j));
      QuoteExp localQuoteExp2 = QuoteExp.getInstance(IntNum.make(i));
      localObject = new ApplyExp(proc_OccurrenceType_getInstance, new Expression[] { localObject, localQuoteExp1, localQuoteExp2 });
      ((ApplyExp)localObject).setFlag(4);
      return (Expression)localObject;
    }
    return (Expression)localObject;
  }
  
  Expression parseElementConstructor()
    throws IOException, SyntaxException
  {
    String str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
    Vector localVector = new Vector();
    localVector.addElement(castQName(new QuoteExp(str), true));
    this.errorIfComment = "comment not allowed in element start tag";
    NamespaceBinding localNamespaceBinding = null;
    int j = 0;
    int i = read();
    while ((i >= 0) && (Character.isWhitespace((char)i)))
    {
      i = read();
      j = 1;
    }
    label100:
    int m;
    int k;
    if ((i < 0) || (i == 62) || (i == 47))
    {
      this.errorIfComment = null;
      m = 0;
      k = i;
      j = m;
      if (i == 47)
      {
        k = read();
        if (k != 62) {
          break label725;
        }
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        if (k != 62)
        {
          return syntaxError("missing '>' after start element");
          if (j == 0) {
            syntaxError("missing space before attribute");
          }
          unread(i);
          getRawToken();
          j = localVector.size();
          if ((this.curToken != 65) && (this.curToken != 81)) {
            break label100;
          }
          Object localObject3 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
          k = getLineNumber();
          m = getColumnNumber();
          int n = this.tokenBufferLength;
          localObject1 = null;
          if (this.curToken == 65)
          {
            if (((String)localObject3).equals("xmlns")) {
              localObject1 = "";
            }
            if (localObject1 == null) {
              break label333;
            }
          }
          label333:
          for (localObject2 = null;; localObject2 = MakeAttribute.makeAttributeExp)
          {
            localVector.addElement(castQName(new QuoteExp(localObject3), false));
            if (skipSpace() == 61) {
              break label341;
            }
            this.errorIfComment = null;
            return syntaxError("missing '=' after attribute");
            if (!((String)localObject3).startsWith("xmlns:")) {
              break;
            }
            localObject1 = ((String)localObject3).substring(6).intern();
            break;
          }
          label341:
          i = skipSpace();
          int i1 = this.enclosedExpressionsSeen;
          if (i == 123)
          {
            warnOldVersion("enclosed attribute value expression should be quoted");
            localVector.addElement(parseEnclosedExpr());
            label374:
            i = localVector.size() - j;
            if (localObject1 == null) {
              break label648;
            }
            localObject2 = "";
            if (i != 1) {
              break label516;
            }
            localObject2 = "";
            label402:
            localVector.setSize(j);
            checkAllowedNamespaceDeclaration((String)localObject1, (String)localObject2, true);
            localObject3 = localObject1;
            if (localObject1 == "") {
              localObject3 = null;
            }
          }
          for (localObject1 = localNamespaceBinding;; localObject1 = ((NamespaceBinding)localObject1).getNext())
          {
            if (localObject1 != null)
            {
              if (((NamespaceBinding)localObject1).getPrefix() != localObject3) {
                continue;
              }
              if (localObject3 != null) {
                break label607;
              }
            }
            label516:
            label607:
            for (localObject1 = "duplicate default namespace declaration";; localObject1 = "duplicate namespace prefix '" + (String)localObject3 + '\'')
            {
              error('e', (String)localObject1, "XQST0071");
              localObject1 = localObject2;
              if (localObject2 == "") {
                localObject1 = null;
              }
              localNamespaceBinding = new NamespaceBinding((String)localObject3, (String)localObject1, localNamespaceBinding);
              break;
              parseContent((char)i, localVector);
              break label374;
              if (this.enclosedExpressionsSeen > i1)
              {
                syntaxError("enclosed expression not allowed in namespace declaration");
                break label402;
              }
              localObject3 = localVector.elementAt(j + 1);
              localObject2 = localObject3;
              if ((localObject3 instanceof ApplyExp))
              {
                ApplyExp localApplyExp = (ApplyExp)localObject3;
                localObject2 = localObject3;
                if (localApplyExp.getFunction() == makeText) {
                  localObject2 = localApplyExp.getArg(0);
                }
              }
              localObject2 = ((QuoteExp)localObject2).getValue().toString().intern();
              break label402;
            }
          }
          label648:
          localObject1 = new Expression[i];
          for (;;)
          {
            i -= 1;
            if (i < 0) {
              break;
            }
            localObject1[i] = ((Expression)localVector.elementAt(j + i));
          }
          localVector.setSize(j);
          localObject1 = new ApplyExp((Expression)localObject2, (Expression[])localObject1);
          maybeSetLine((Expression)localObject1, k + 1, m + 1 - n);
          localVector.addElement(localObject1);
          break;
          label725:
          unread(k);
          j = m;
          continue;
        }
        parseContent('<', localVector);
        j = peek();
        i = j;
        if (j >= 0)
        {
          if (!XName.isNameStart((char)j)) {
            return syntaxError("invalid tag syntax after '</'");
          }
          getRawToken();
          localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
          if (!((String)localObject1).equals(str)) {
            return syntaxError("'<" + str + ">' closed by '</" + (String)localObject1 + ">'");
          }
          this.errorIfComment = "comment not allowed in element end tag";
          i = skipSpace();
          this.errorIfComment = null;
        }
        if (i != 62) {
          return syntaxError("missing '>' after end element");
        }
      }
    }
    Object localObject1 = new Expression[localVector.size()];
    localVector.copyInto((Object[])localObject1);
    Object localObject2 = new MakeElement();
    ((MakeElement)localObject2).copyNamespacesMode = this.copyNamespacesMode;
    ((MakeElement)localObject2).setNamespaceNodes(localNamespaceBinding);
    return new ApplyExp(new QuoteExp(localObject2), (Expression[])localObject1);
  }
  
  Expression parseEnclosedExpr()
    throws IOException, SyntaxException
  {
    String str = this.errorIfComment;
    this.errorIfComment = null;
    char c = pushNesting('{');
    peekNonSpace("unexpected end-of-file after '{'");
    int i = getLineNumber();
    int j = getColumnNumber();
    getRawToken();
    Expression localExpression = parseExpr();
    if (this.curToken == 125) {}
    for (;;)
    {
      maybeSetLine(localExpression, i + 1, j + 1);
      popNesting(c);
      this.errorIfComment = str;
      return localExpression;
      if ((this.curToken != -1) && (this.curToken != 41) && (this.curToken != 93)) {
        break;
      }
      localExpression = syntaxError("missing '}'");
    }
    if (this.curToken != 44) {
      localExpression = syntaxError("missing '}' or ','");
    }
    for (;;)
    {
      localExpression = makeExprSequence(localExpression, parseExpr());
      break;
      getRawToken();
    }
  }
  
  void parseEntityOrCharRef()
    throws IOException, SyntaxException
  {
    int i = read();
    int k;
    if (i == 35)
    {
      i = read();
      if (i == 120)
      {
        j = 16;
        i = read();
        k = 0;
      }
      for (;;)
      {
        int m;
        if (i >= 0)
        {
          m = Character.digit((char)i, j);
          if (m >= 0) {
            break label73;
          }
        }
        label73:
        while (k >= 134217728)
        {
          if (i == 59) {
            break label95;
          }
          unread();
          error("invalid character reference");
          return;
          j = 10;
          break;
        }
        k = k * j + m;
        i = read();
      }
      label95:
      if (((k > 0) && (k <= 55295)) || ((k >= 57344) && (k <= 65533)) || ((k >= 65536) && (k <= 1114111)))
      {
        tokenBufferAppend(k);
        return;
      }
      error('e', "invalid character value " + k, "XQST0090");
      return;
    }
    int j = this.tokenBufferLength;
    for (;;)
    {
      if (i >= 0)
      {
        k = (char)i;
        if (XName.isNamePart(k)) {}
      }
      else
      {
        if (i == 59) {
          break;
        }
        unread();
        error("invalid entity reference");
        return;
      }
      tokenBufferAppend(k);
      i = read();
    }
    String str = new String(this.tokenBuffer, j, this.tokenBufferLength - j);
    this.tokenBufferLength = j;
    appendNamedEntity(str);
  }
  
  Expression parseExpr()
    throws IOException, SyntaxException
  {
    return parseExprSingle();
  }
  
  Expression parseExprSequence(int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    Object localObject2;
    if ((this.curToken == paramInt) || (this.curToken == -1))
    {
      if (!paramBoolean) {
        syntaxError("missing expression");
      }
      localObject2 = QuoteExp.voidExp;
      return (Expression)localObject2;
    }
    Object localObject1 = null;
    for (;;)
    {
      localObject2 = parseExprSingle();
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (this.curToken == paramInt) {
          break;
        }
        localObject2 = localObject1;
        if (this.curToken == -1) {
          break;
        }
        if (this.nesting == 0)
        {
          localObject2 = localObject1;
          if (this.curToken == 10) {
            break;
          }
        }
        if (this.curToken == 44) {
          break label134;
        }
        if (paramInt != 41) {
          break label127;
        }
      }
      label127:
      for (localObject1 = "expected ')'";; localObject1 = "confused by syntax error")
      {
        return syntaxError((String)localObject1);
        localObject1 = makeExprSequence((Expression)localObject1, (Expression)localObject2);
        break;
      }
      label134:
      getRawToken();
    }
  }
  
  final Expression parseExprSingle()
    throws IOException, SyntaxException
  {
    int i = this.curLine;
    i = this.curColumn;
    peekOperand();
    switch (this.curToken)
    {
    default: 
      return parseBinaryExpr(priority(400));
    case 241: 
      return parseIfExpr();
    case 242: 
      return parseTypeSwitch();
    case 243: 
      return parseFLWRExpression(true);
    case 244: 
      return parseFLWRExpression(false);
    case 245: 
      return parseQuantifiedExpr(false);
    }
    return parseQuantifiedExpr(true);
  }
  
  public Expression parseFLWRExpression(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    int i = this.flworDeclsFirst;
    this.flworDeclsFirst = this.flworDeclsCount;
    Expression localExpression = parseFLWRInner(paramBoolean);
    if (match("order"))
    {
      char c1;
      char c3;
      label65:
      Stack localStack;
      if (paramBoolean)
      {
        c1 = 'f';
        c3 = pushNesting(c1);
        getRawToken();
        if (!match("by")) {
          break label146;
        }
        getRawToken();
        localStack = new Stack();
      }
      for (;;)
      {
        j = 0;
        char c2 = this.defaultEmptyOrder;
        Object localObject1 = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
        i = this.flworDeclsFirst;
        for (;;)
        {
          if (i < this.flworDeclsCount)
          {
            ((LambdaExp)localObject1).addDeclaration(this.flworDecls[i].getSymbol());
            i += 1;
            continue;
            c1 = 'l';
            break;
            label146:
            error("missing 'by' following 'order'");
            break label65;
          }
        }
        this.comp.push((ScopeExp)localObject1);
        ((LambdaExp)localObject1).body = parseExprSingle();
        this.comp.pop((ScopeExp)localObject1);
        localStack.push(localObject1);
        if (match("ascending"))
        {
          getRawToken();
          i = j;
        }
        for (;;)
        {
          c1 = c2;
          label245:
          Object localObject4;
          if (match("empty"))
          {
            getRawToken();
            if (match("greatest"))
            {
              getRawToken();
              c1 = 'G';
            }
          }
          else
          {
            localObject3 = new StringBuilder();
            if (i == 0) {
              break label448;
            }
            localObject1 = "D";
            localStack.push(new QuoteExp((String)localObject1 + c1));
            localObject3 = this.defaultCollator;
            localObject1 = localObject3;
            if (match("collation"))
            {
              localObject4 = parseURILiteral();
              localObject1 = localObject3;
              if (!(localObject4 instanceof String)) {}
            }
          }
          try
          {
            localObject1 = NamedCollator.make(resolveAgainstBaseUri((String)localObject4));
            getRawToken();
            localStack.push(new QuoteExp(localObject1));
            if (this.curToken != 44)
            {
              if (match("return")) {
                break label509;
              }
              return syntaxError("expected 'return' clause");
              i = j;
              if (!match("descending")) {
                continue;
              }
              getRawToken();
              i = 1;
              continue;
              if (match("least"))
              {
                getRawToken();
                c1 = 'L';
                break label245;
              }
              error("'empty' sequence order must be 'greatest' or 'least'");
              c1 = c2;
              break label245;
              label448:
              localObject1 = "A";
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              error('e', "unknown collation '" + localObject4 + "'", "XQST0076");
              localObject2 = localObject3;
            }
            getRawToken();
          }
        }
      }
      label509:
      getRawToken();
      Object localObject2 = new LambdaExp(this.flworDeclsCount - this.flworDeclsFirst);
      i = this.flworDeclsFirst;
      while (i < this.flworDeclsCount)
      {
        ((LambdaExp)localObject2).addDeclaration(this.flworDecls[i].getSymbol());
        i += 1;
      }
      popNesting(c3);
      this.comp.push((ScopeExp)localObject2);
      ((LambdaExp)localObject2).body = parseExprSingle();
      this.comp.pop((ScopeExp)localObject2);
      int j = localStack.size();
      Object localObject3 = new Expression[j + 2];
      localObject3[0] = localExpression;
      localObject3[1] = localObject2;
      i = 0;
      while (i < j)
      {
        localObject3[(i + 2)] = ((Expression)localStack.elementAt(i));
        i += 1;
      }
      return new ApplyExp(makeFunctionExp("gnu.xquery.util.OrderedMap", "orderedMap"), (Expression[])localObject3);
    }
    this.flworDeclsCount = this.flworDeclsFirst;
    this.flworDeclsFirst = i;
    return localExpression;
  }
  
  public Expression parseFLWRInner(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    if (paramBoolean) {}
    Object localObject4;
    for (char c = 'f';; c = 'l')
    {
      c = pushNesting(c);
      this.curToken = 36;
      localObject4 = parseVariableDeclaration();
      if (localObject4 != null) {
        break;
      }
      return syntaxError("missing Variable - saw " + tokenString());
    }
    int i;
    Expression localExpression;
    Expression[] arrayOfExpression;
    Object localObject3;
    Object localObject2;
    boolean bool1;
    if (this.flworDecls == null)
    {
      this.flworDecls = new Declaration[8];
      localObject1 = this.flworDecls;
      i = this.flworDeclsCount;
      this.flworDeclsCount = (i + 1);
      localObject1[i] = localObject4;
      getRawToken();
      localExpression = parseOptionalTypeDeclaration();
      arrayOfExpression = new Expression[1];
      localObject1 = null;
      localObject3 = null;
      localObject2 = null;
      if (!paramBoolean) {
        break label449;
      }
      bool1 = match("at");
      if (!bool1) {
        break label419;
      }
      i = 2;
      label150:
      localObject3 = new LambdaExp(i);
      if (bool1)
      {
        getRawToken();
        if (this.curToken == 36)
        {
          localObject2 = parseVariableDeclaration();
          getRawToken();
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          syntaxError("missing Variable after 'at'");
          localObject1 = localObject2;
        }
      }
      if (!match("in")) {
        break label424;
      }
      getRawToken();
    }
    for (;;)
    {
      arrayOfExpression[0] = parseExprSingle();
      if ((localExpression != null) && (!paramBoolean)) {
        arrayOfExpression[0] = Compilation.makeCoercion(arrayOfExpression[0], localExpression);
      }
      popNesting(c);
      this.comp.push((ScopeExp)localObject3);
      ((ScopeExp)localObject3).addDeclaration((Declaration)localObject4);
      if (localExpression != null) {
        ((Declaration)localObject4).setTypeExp(localExpression);
      }
      if (paramBoolean)
      {
        ((Declaration)localObject4).noteValue(null);
        ((Declaration)localObject4).setFlag(262144L);
      }
      if (localObject1 != null)
      {
        ((ScopeExp)localObject3).addDeclaration((Declaration)localObject1);
        ((Declaration)localObject1).setType(LangPrimType.intType);
        ((Declaration)localObject1).noteValue(null);
        ((Declaration)localObject1).setFlag(262144L);
      }
      if (this.curToken != 44) {
        break label595;
      }
      getRawToken();
      if (this.curToken == 36) {
        break label511;
      }
      return syntaxError("missing $NAME after ','");
      if (this.flworDeclsCount < this.flworDecls.length) {
        break;
      }
      localObject1 = new Declaration[this.flworDeclsCount * 2];
      System.arraycopy(this.flworDecls, 0, localObject1, 0, this.flworDeclsCount);
      this.flworDecls = ((Declaration[])localObject1);
      break;
      label419:
      i = 1;
      break label150;
      label424:
      if (this.curToken == 76) {
        getRawToken();
      }
      syntaxError("missing 'in' in 'for' clause");
    }
    label449:
    if (this.curToken == 76) {
      getRawToken();
    }
    for (;;)
    {
      localObject2 = new LetExp(arrayOfExpression);
      localObject1 = localObject3;
      localObject3 = localObject2;
      break;
      if (match("in")) {
        getRawToken();
      }
      syntaxError("missing ':=' in 'let' clause");
    }
    label511:
    Object localObject1 = parseFLWRInner(paramBoolean);
    for (;;)
    {
      this.comp.pop((ScopeExp)localObject3);
      if (!paramBoolean) {
        break label986;
      }
      localObject4 = (LambdaExp)localObject3;
      ((LambdaExp)localObject4).body = ((Expression)localObject1);
      localObject2 = arrayOfExpression[0];
      if (((LambdaExp)localObject4).min_args != 1) {
        break label978;
      }
      localObject1 = "valuesMap";
      label565:
      return new ApplyExp(makeFunctionExp("gnu.kawa.functions.ValuesMap", (String)localObject1), new Expression[] { localObject3, localObject2 });
      label595:
      if (match("for"))
      {
        getRawToken();
        if (this.curToken != 36) {
          return syntaxError("missing $NAME after 'for'");
        }
        localObject1 = parseFLWRInner(true);
      }
      else
      {
        if (!match("let")) {
          break;
        }
        getRawToken();
        if (this.curToken != 36) {
          return syntaxError("missing $NAME after 'let'");
        }
        localObject1 = parseFLWRInner(false);
      }
    }
    c = pushNesting('w');
    if (this.curToken == 196)
    {
      getRawToken();
      localObject1 = parseExprSingle();
    }
    boolean bool2;
    for (;;)
    {
      popNesting(c);
      if (match("stable")) {
        getRawToken();
      }
      bool1 = match("return");
      bool2 = match("order");
      if ((bool1) || (bool2) || (match("let")) || (match("for"))) {
        break;
      }
      return syntaxError("missing 'return' clause");
      if (match("where")) {
        localObject1 = parseExprSingle();
      } else {
        localObject1 = null;
      }
    }
    if (!bool2) {
      peekNonSpace("unexpected eof-of-file after 'return'");
    }
    int j = getLineNumber();
    int k = getColumnNumber();
    if (bool1) {
      getRawToken();
    }
    if (bool2)
    {
      int m = this.flworDeclsCount - this.flworDeclsFirst;
      localObject2 = new Expression[m];
      i = 0;
      while (i < m)
      {
        localObject2[i] = new ReferenceExp(this.flworDecls[(this.flworDeclsFirst + i)]);
        i += 1;
      }
      localObject2 = new ApplyExp(new PrimProcedure("gnu.xquery.util.OrderedMap", "makeTuple$V", 1), (Expression[])localObject2);
      label928:
      if (localObject1 == null) {
        break label999;
      }
    }
    label978:
    label986:
    label999:
    for (localObject1 = new IfExp(booleanValue((Expression)localObject1), (Expression)localObject2, QuoteExp.voidExp);; localObject1 = localObject2)
    {
      maybeSetLine((Expression)localObject1, j + 1, k + 1);
      break;
      localObject2 = parseExprSingle();
      break label928;
      localObject1 = "valuesMapWithPos";
      break label565;
      ((LetExp)localObject3).setBody((Expression)localObject1);
      return (Expression)localObject3;
    }
  }
  
  public Expression parseFunctionDefinition(int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    if ((this.curToken != 81) && (this.curToken != 65)) {
      return syntaxError("missing function name");
    }
    Object localObject2 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
    getMessages().setLine(this.port.getName(), this.curLine, this.curColumn);
    Object localObject3 = namespaceResolve((String)localObject2, true);
    Object localObject1 = ((Symbol)localObject3).getNamespaceURI();
    if ((localObject1 == "http://www.w3.org/XML/1998/namespace") || (localObject1 == "http://www.w3.org/2001/XMLSchema") || (localObject1 == "http://www.w3.org/2001/XMLSchema-instance") || (localObject1 == "http://www.w3.org/2005/xpath-functions")) {
      error('e', "cannot declare function in standard namespace '" + (String)localObject1 + '\'', "XQST0045");
    }
    for (;;)
    {
      getRawToken();
      if (this.curToken == 40) {
        break;
      }
      return syntaxError("missing parameter list:" + this.curToken);
      if (localObject1 == "")
      {
        if (this.comp.isPedantic()) {}
        for (char c = 'e';; c = 'w')
        {
          error(c, "cannot declare function in empty namespace", "XQST0060");
          break;
        }
      }
      if ((this.libraryModuleNamespace != null) && (localObject1 != this.libraryModuleNamespace) && ((!"http://www.w3.org/2005/xquery-local-functions".equals(localObject1)) || (this.comp.isPedantic()))) {
        error('e', "function not in namespace of library module", "XQST0048");
      }
    }
    getRawToken();
    localObject1 = new LambdaExp();
    maybeSetLine((Expression)localObject1, paramInt1, paramInt2);
    ((LambdaExp)localObject1).setName((String)localObject2);
    localObject2 = this.comp.currentScope().addDeclaration(localObject3);
    if (this.comp.isStatic()) {
      ((Declaration)localObject2).setFlag(2048L);
    }
    ((LambdaExp)localObject1).setFlag(2048);
    ((Declaration)localObject2).setCanRead(true);
    ((Declaration)localObject2).setProcedureDecl(true);
    maybeSetLine((Declaration)localObject2, paramInt1, paramInt2);
    this.comp.push((ScopeExp)localObject1);
    if (this.curToken != 41) {}
    for (;;)
    {
      localObject3 = parseVariableDeclaration();
      if (localObject3 == null) {
        error("missing parameter name");
      }
      while (this.curToken == 41)
      {
        getRawToken();
        localObject3 = parseOptionalTypeDeclaration();
        ((LambdaExp)localObject1).body = parseEnclosedExpr();
        this.comp.pop((ScopeExp)localObject1);
        if (localObject3 != null) {
          ((LambdaExp)localObject1).setCoercedReturnValue((Expression)localObject3, this.interpreter);
        }
        localObject3 = new SetExp((Declaration)localObject2, (Expression)localObject1);
        ((SetExp)localObject3).setDefining(true);
        ((Declaration)localObject2).noteValue((Expression)localObject1);
        return (Expression)localObject3;
        ((LambdaExp)localObject1).addDeclaration((Declaration)localObject3);
        getRawToken();
        ((LambdaExp)localObject1).min_args += 1;
        ((LambdaExp)localObject1).max_args += 1;
        ((Declaration)localObject3).setTypeExp(parseOptionalTypeDeclaration());
      }
      if (this.curToken != 44)
      {
        localObject3 = syntaxError("missing ',' in parameter list");
        do
        {
          getRawToken();
          if ((this.curToken < 0) || (this.curToken == 59) || (this.curToken == 59)) {
            return (Expression)localObject3;
          }
          if (this.curToken == 41) {
            break;
          }
        } while (this.curToken != 44);
      }
      else
      {
        getRawToken();
      }
    }
  }
  
  public Expression parseIfExpr()
    throws IOException, SyntaxException
  {
    char c1 = pushNesting('i');
    getRawToken();
    char c2 = pushNesting('(');
    Expression localExpression1 = parseExprSequence(41, false);
    popNesting(c2);
    if (this.curToken == -1) {
      eofError("missing ')' - unexpected end-of-file");
    }
    getRawToken();
    Expression localExpression2;
    if (!match("then"))
    {
      syntaxError("missing 'then'");
      localExpression2 = parseExpr();
      if (match("else")) {
        break label129;
      }
      syntaxError("missing 'else'");
    }
    for (;;)
    {
      popNesting(c1);
      Expression localExpression3 = parseExpr();
      return new IfExp(booleanValue(localExpression1), localExpression2, localExpression3);
      getRawToken();
      break;
      label129:
      getRawToken();
    }
  }
  
  Expression parseIntersectExceptExpr()
    throws IOException, SyntaxException
  {
    int i;
    for (Expression localExpression = parsePathExpr();; localExpression = makeBinary(i, localExpression, parsePathExpr()))
    {
      i = peekOperator();
      if ((i != 420) && (i != 421)) {
        return localExpression;
      }
      getRawToken();
    }
  }
  
  public Expression parseItemType()
    throws IOException, SyntaxException
  {
    peekOperand();
    Object localObject = parseMaybeKindTest();
    if (localObject != null) {
      if (this.parseContext != 67) {}
    }
    for (localObject = XDataType.anyAtomicType;; localObject = SingletonType.getInstance())
    {
      localObject = QuoteExp.getInstance(localObject);
      return (Expression)localObject;
      if (this.curToken != 237) {
        break;
      }
      parseSimpleKindType();
    }
    if ((this.curToken == 65) || (this.curToken == 81))
    {
      localObject = new ReferenceExp(new String(this.tokenBuffer, 0, this.tokenBufferLength));
      ((ReferenceExp)localObject).setFlag(16);
      maybeSetLine((Expression)localObject, this.curLine, this.curColumn);
      getRawToken();
      return (Expression)localObject;
    }
    return null;
  }
  
  public Expression parseMaybeKindTest()
    throws IOException, SyntaxException
  {
    boolean bool = false;
    switch (this.curToken)
    {
    default: 
      return null;
    case 235: 
    case 236: 
      if (this.curToken == 236) {
        bool = true;
      }
      return parseNamedNodeType(bool);
    case 231: 
      parseSimpleKindType();
      localObject = NodeType.textNodeTest;
    case 232: 
    case 234: 
    case 230: 
      for (;;)
      {
        return QuoteExp.getInstance(localObject);
        parseSimpleKindType();
        localObject = NodeType.commentNodeTest;
        continue;
        parseSimpleKindType();
        localObject = NodeType.documentNodeTest;
        continue;
        parseSimpleKindType();
        localObject = NodeType.anyNodeTest;
      }
    }
    getRawToken();
    Object localObject = null;
    if ((this.curToken == 65) || (this.curToken == 34))
    {
      localObject = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      getRawToken();
    }
    if (this.curToken == 41) {
      getRawToken();
    }
    for (;;)
    {
      localObject = ProcessingInstructionType.getInstance((String)localObject);
      break;
      error("expected ')'");
    }
  }
  
  Expression parseMaybePrimaryExpr()
    throws IOException, SyntaxException
  {
    int i = this.curLine;
    int j = this.curColumn;
    int k = peekOperand();
    Object localObject1;
    switch (k)
    {
    default: 
      localObject1 = null;
      return (Expression)localObject1;
    case 40: 
      localObject1 = parseParenExpr();
    }
    for (;;)
    {
      getRawToken();
      return (Expression)localObject1;
      Object localObject3 = new Stack();
      do
      {
        getRawToken();
        if ((this.curToken != 81) && (this.curToken != 65)) {}
        for (localObject1 = syntaxError("missing pragma name");; localObject1 = QuoteExp.getInstance(new String(this.tokenBuffer, 0, this.tokenBufferLength)))
        {
          ((Stack)localObject3).push(localObject1);
          localObject1 = new StringBuffer();
          j = -1;
          int m;
          do
          {
            m = read();
            i = j + 1;
            j = m;
            k = i;
            if (m < 0) {
              break;
            }
            j = i;
          } while (Character.isWhitespace((char)m));
          k = i;
          for (j = m; (j != 35) || (peek() != 41); j = read())
          {
            if (j < 0) {
              eofError("pragma ended by end-of-file");
            }
            if (k == 0) {
              error("missing space between pragma and extension content");
            }
            k = 1;
            ((StringBuffer)localObject1).append((char)j);
          }
        }
        read();
        ((Stack)localObject3).push(QuoteExp.getInstance(((StringBuffer)localObject1).toString()));
        getRawToken();
      } while (this.curToken == 197);
      char c;
      if (this.curToken == 123)
      {
        getRawToken();
        if (this.curToken != 125)
        {
          c = pushNesting('{');
          ((Stack)localObject3).push(parseExprSequence(125, false));
          popNesting(c);
          if (this.curToken == -1) {
            eofError("missing '}' - unexpected end-of-file");
          }
        }
        localObject1 = new Expression[((Stack)localObject3).size()];
        ((Stack)localObject3).copyInto((Object[])localObject1);
        localObject1 = new ApplyExp(new ReferenceExp(XQResolveNames.handleExtensionDecl), (Expression[])localObject1);
      }
      else
      {
        localObject1 = syntaxError("missing '{' after pragma");
        continue;
        localObject1 = syntaxError("saw unexpected '{' - assume you meant '('");
        parseEnclosedExpr();
        continue;
        k = read();
        if (k == 47)
        {
          getRawToken();
          if ((this.curToken == 65) || (this.curToken == 81) || (this.curToken == 67)) {}
          for (localObject1 = "saw end tag '</" + new String(this.tokenBuffer, 0, this.tokenBufferLength) + ">' not in an element constructor";; localObject1 = "saw end tag '</' not in an element constructor")
          {
            this.curLine = i;
            this.curColumn = j;
            localObject3 = syntaxError((String)localObject1);
            for (;;)
            {
              localObject1 = localObject3;
              if (this.curToken == 405) {
                break;
              }
              localObject1 = localObject3;
              if (this.curToken == -1) {
                break;
              }
              localObject1 = localObject3;
              if (this.curToken == 10) {
                break;
              }
              getRawToken();
            }
          }
        }
        localObject1 = parseXMLConstructor(k, false);
        maybeSetLine((Expression)localObject1, i, j);
        continue;
        localObject1 = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
        continue;
        localObject1 = new QuoteExp(IntNum.valueOf(this.tokenBuffer, 0, this.tokenBufferLength, 10, false));
        continue;
        localObject3 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        if (k == 49) {}
        for (;;)
        {
          try
          {
            localObject1 = new BigDecimal((String)localObject3);
            localObject1 = new QuoteExp(localObject1);
          }
          catch (Throwable localThrowable)
          {
            localObject2 = syntaxError("invalid decimal literal: '" + (String)localObject3 + "'");
          }
          localObject1 = new Double((String)localObject3);
        }
        continue;
        Object localObject2 = parseVariable();
        if (localObject2 == null) {
          return syntaxError("missing Variable");
        }
        localObject2 = new ReferenceExp(localObject2);
        maybeSetLine((Expression)localObject2, this.curLine, this.curColumn);
        continue;
        localObject3 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        c = pushNesting('(');
        getRawToken();
        Vector localVector = new Vector(10);
        if (this.curToken != 41) {}
        for (;;)
        {
          localVector.addElement(parseExpr());
          if (this.curToken == 41)
          {
            localObject2 = new Expression[localVector.size()];
            localVector.copyInto((Object[])localObject2);
            localObject3 = new ReferenceExp(localObject3, null);
            ((ReferenceExp)localObject3).setProcedureName(true);
            localObject2 = new ApplyExp((Expression)localObject3, (Expression[])localObject2);
            maybeSetLine((Expression)localObject2, i, j);
            popNesting(c);
            break;
          }
          if (this.curToken != 44) {
            return syntaxError("missing ')' after function call");
          }
          getRawToken();
        }
        getRawToken();
        localVector = new Vector();
        boolean bool;
        if ((k == 251) || (k == 252)) {
          if ((this.curToken == 65) || (this.curToken == 81)) {
            if (k != 251)
            {
              bool = true;
              localObject2 = parseNameTest(bool);
              label1150:
              if (k != 251) {
                break label1279;
              }
              bool = true;
              label1161:
              localVector.addElement(castQName((Expression)localObject2, bool));
              if (k != 251) {
                break label1285;
              }
              localObject2 = new MakeElement();
              ((MakeElement)localObject2).copyNamespacesMode = this.copyNamespacesMode;
              localObject2 = new QuoteExp(localObject2);
              label1210:
              getRawToken();
            }
          }
        }
        for (;;)
        {
          c = pushNesting('{');
          peekNonSpace("unexpected end-of-file after '{'");
          if (this.curToken == 123) {
            break label1465;
          }
          return syntaxError("missing '{'");
          bool = false;
          break;
          if (this.curToken == 123)
          {
            localObject2 = parseEnclosedExpr();
            break label1150;
          }
          return syntaxError("missing element/attribute name");
          label1279:
          bool = false;
          break label1161;
          label1285:
          localObject2 = MakeAttribute.makeAttributeExp;
          break label1210;
          if (k == 256)
          {
            localObject2 = makeFunctionExp("gnu.kawa.xml.DocumentConstructor", "documentConstructor");
          }
          else if (k == 254)
          {
            localObject2 = makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor");
          }
          else
          {
            if (k == 255)
            {
              if (this.curToken == 65) {
                localObject2 = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength).intern());
              }
              label1426:
              do
              {
                for (;;)
                {
                  localVector.addElement(localObject2);
                  localObject2 = makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst");
                  getRawToken();
                  break;
                  if (this.curToken != 123) {
                    break label1426;
                  }
                  localObject2 = parseEnclosedExpr();
                }
                localObject3 = syntaxError("expected NCName or '{' after 'processing-instruction'");
                localObject2 = localObject3;
              } while (this.curToken == 81);
              return (Expression)localObject3;
            }
            localObject2 = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
          }
        }
        label1465:
        getRawToken();
        if ((k == 253) || (k == 254) || (k == 255)) {
          if (k == 255)
          {
            bool = true;
            localVector.addElement(parseExprSequence(125, bool));
          }
        }
        for (;;)
        {
          popNesting(c);
          if (this.curToken == 125) {
            break label1590;
          }
          return syntaxError("missing '}'");
          bool = false;
          break;
          if (this.curToken != 125)
          {
            localVector.addElement(parseExpr());
            while (this.curToken == 44)
            {
              getRawToken();
              localVector.addElement(parseExpr());
            }
          }
        }
        label1590:
        localObject3 = new Expression[localVector.size()];
        localVector.copyInto((Object[])localObject3);
        localObject3 = new ApplyExp((Expression)localObject2, (Expression[])localObject3);
        maybeSetLine((Expression)localObject3, i, j);
        if (k != 256)
        {
          localObject2 = localObject3;
          if (k != 251) {}
        }
        else
        {
          localObject2 = wrapWithBaseUri((Expression)localObject3);
          continue;
          getRawToken();
          localObject2 = parseExprSequence(125, false);
        }
      }
    }
  }
  
  Expression parseNameTest(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    Object localObject3;
    if (this.curToken == 81)
    {
      i = this.tokenBufferLength;
      int j;
      do
      {
        localObject1 = this.tokenBuffer;
        j = i - 1;
        i = j;
      } while (localObject1[j] != ':');
      localObject2 = new String(this.tokenBuffer, 0, j);
      i = j + 1;
      localObject1 = new String(this.tokenBuffer, i, this.tokenBufferLength - i);
      localObject3 = localObject2;
      if (localObject2 != null) {
        localObject3 = ((String)localObject2).intern();
      }
      localObject2 = new ApplyExp(new ReferenceExp(XQResolveNames.resolvePrefixDecl), new Expression[] { QuoteExp.getInstance(localObject3) });
      if (localObject1 != null) {
        break label469;
      }
      localObject1 = "";
    }
    label469:
    for (;;)
    {
      localObject1 = new QuoteExp(localObject1);
      localObject3 = new QuoteExp(localObject3);
      localObject1 = new ApplyExp(Compilation.typeSymbol.getDeclaredMethod("make", 3), new Expression[] { localObject2, localObject1, localObject3 });
      ((ApplyExp)localObject1).setFlag(4);
      return (Expression)localObject1;
      if (this.curToken == 415)
      {
        i = read();
        localObject2 = "";
        if (i != 58)
        {
          unread(i);
          localObject1 = localObject2;
        }
        for (;;)
        {
          return QuoteExp.getInstance(new Symbol(null, (String)localObject1));
          i = read();
          if (i < 0) {
            eofError("unexpected end-of-file after '*:'");
          }
          if (XName.isNameStart((char)i))
          {
            unread();
            getRawToken();
            if (this.curToken != 65)
            {
              syntaxError("invalid name test");
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength).intern();
            }
          }
          else
          {
            localObject1 = localObject2;
            if (i != 42)
            {
              syntaxError("missing local-name after '*:'");
              localObject1 = localObject2;
            }
          }
        }
      }
      if (this.curToken == 65)
      {
        localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
        if (paramBoolean) {
          return new QuoteExp(Namespace.EmptyNamespace.getSymbol(((String)localObject1).intern()));
        }
        localObject2 = null;
        break;
      }
      if (this.curToken != 67) {
        break;
      }
      localObject2 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      if (read() != 42) {
        syntaxError("invalid characters after 'NCName:'");
      }
      localObject1 = "";
      break;
    }
  }
  
  public Expression parseNamedNodeType(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    getRawToken();
    Object localObject1;
    if (this.curToken == 41)
    {
      localObject1 = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
      getRawToken();
    }
    for (;;)
    {
      return makeNamedNodeType(paramBoolean, (Expression)localObject1, (Expression)localObject2);
      if ((this.curToken == 81) || (this.curToken == 65))
      {
        localObject1 = parseNameTest(paramBoolean);
        label62:
        getRawToken();
        localObject2 = localObject3;
        if (this.curToken == 44)
        {
          getRawToken();
          if ((this.curToken != 81) && (this.curToken != 65)) {
            break label152;
          }
        }
      }
      for (localObject2 = parseDataType();; localObject2 = localObject3)
      {
        if (this.curToken != 41) {
          break label166;
        }
        getRawToken();
        break;
        if (this.curToken != 415) {
          syntaxError("expected QName or *");
        }
        localObject1 = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
        break label62;
        label152:
        syntaxError("expected QName");
      }
      label166:
      error("expected ')' after element");
    }
  }
  
  Expression parseNodeTest(int paramInt)
    throws IOException, SyntaxException
  {
    peekOperand();
    Expression[] arrayOfExpression = new Expression[1];
    Object localObject1 = parseMaybeKindTest();
    Object localObject2;
    if (localObject1 != null)
    {
      arrayOfExpression[0] = localObject1;
      localObject2 = this.comp.lexical.lookup(DOT_VARNAME, false);
      if (localObject2 != null) {
        break label243;
      }
      localObject2 = syntaxError("node test when context item is undefined", "XPDY0002");
      label61:
      if (localObject1 == null) {
        getRawToken();
      }
      if ((paramInt != 3) && (paramInt != -1)) {
        break label260;
      }
    }
    for (localObject1 = makeChildAxisStep;; localObject1 = makeDescendantAxisStep)
    {
      localObject1 = new ApplyExp((Expression)localObject1, arrayOfExpression);
      ((ApplyExp)localObject1).setFlag(4);
      return new ApplyExp((Expression)localObject1, new Expression[] { localObject2 });
      if ((this.curToken == 65) || (this.curToken == 81) || (this.curToken == 67) || (this.curToken == 415))
      {
        boolean bool1;
        if (paramInt == 2)
        {
          bool1 = true;
          label168:
          if (paramInt != 2) {
            break label197;
          }
        }
        label197:
        for (boolean bool2 = true;; bool2 = false)
        {
          arrayOfExpression[0] = makeNamedNodeType(bool1, parseNameTest(bool2), null);
          break;
          bool1 = false;
          break label168;
        }
      }
      if (paramInt >= 0) {
        return syntaxError("unsupported axis '" + axisNames[paramInt] + "::'");
      }
      return null;
      label243:
      localObject2 = new ReferenceExp(DOT_VARNAME, (Declaration)localObject2);
      break label61;
      label260:
      if (paramInt != 4) {
        break label273;
      }
    }
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 8: 
    default: 
      throw new Error();
    case 5: 
      label273:
      localObject1 = "DescendantOrSelf";
    }
    for (;;)
    {
      localObject1 = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml." + (String)localObject1 + "Axis", "make", 1));
      break;
      localObject1 = "Self";
      continue;
      localObject1 = "Parent";
      continue;
      localObject1 = "Ancestor";
      continue;
      localObject1 = "AncestorOrSelf";
      continue;
      localObject1 = "Following";
      continue;
      localObject1 = "FollowingSibling";
      continue;
      localObject1 = "Preceding";
      continue;
      localObject1 = "PrecedingSibling";
      continue;
      localObject1 = "Attribute";
    }
  }
  
  public Expression parseOptionalTypeDeclaration()
    throws IOException, SyntaxException
  {
    if (!match("as")) {
      return null;
    }
    getRawToken();
    return parseDataType();
  }
  
  Expression parseParenExpr()
    throws IOException, SyntaxException
  {
    getRawToken();
    char c = pushNesting('(');
    Expression localExpression = parseExprSequence(41, true);
    popNesting(c);
    if (this.curToken == -1) {
      eofError("missing ')' - unexpected end-of-file");
    }
    return localExpression;
  }
  
  Expression parsePathExpr()
    throws IOException, SyntaxException
  {
    boolean bool = true;
    if ((this.curToken == 47) || (this.curToken == 68))
    {
      localObject = this.comp.lexical.lookup(DOT_VARNAME, false);
      ApplyExp localApplyExp;
      if (localObject == null)
      {
        localObject = syntaxError("context item is undefined", "XPDY0002");
        localApplyExp = new ApplyExp(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("rootDocument", 1), new Expression[] { localObject });
        if (this.nesting == 0) {
          break label140;
        }
      }
      for (;;)
      {
        int i = skipSpace(bool);
        unread(i);
        if ((i >= 0) && (i != 41))
        {
          localObject = localApplyExp;
          if (i != 125) {
            break label150;
          }
        }
        getRawToken();
        return localApplyExp;
        localObject = new ReferenceExp(DOT_VARNAME, (Declaration)localObject);
        break;
        label140:
        bool = false;
      }
    }
    Object localObject = parseStepExpr();
    label150:
    return parseRelativePathExpr((Expression)localObject);
  }
  
  Expression parsePrimaryExpr()
    throws IOException, SyntaxException
  {
    Expression localExpression = parseMaybePrimaryExpr();
    if (localExpression == null)
    {
      localExpression = syntaxError("missing expression");
      if (this.curToken != -1) {
        getRawToken();
      }
      return localExpression;
    }
    return localExpression;
  }
  
  public Expression parseQuantifiedExpr(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    if (paramBoolean) {}
    for (char c = 'e';; c = 's')
    {
      c = pushNesting(c);
      this.curToken = 36;
      localObject = parseVariableDeclaration();
      if (localObject != null) {
        break;
      }
      return syntaxError("missing Variable token:" + this.curToken);
    }
    getRawToken();
    LambdaExp localLambdaExp = new LambdaExp(1);
    localLambdaExp.addDeclaration((Declaration)localObject);
    ((Declaration)localObject).noteValue(null);
    ((Declaration)localObject).setFlag(262144L);
    ((Declaration)localObject).setTypeExp(parseOptionalTypeDeclaration());
    if (match("in")) {
      getRawToken();
    }
    for (;;)
    {
      localExpression = parseExprSingle();
      popNesting(c);
      this.comp.push(localLambdaExp);
      if (this.curToken != 44) {
        break label275;
      }
      getRawToken();
      if (this.curToken == 36) {
        break;
      }
      return syntaxError("missing $NAME after ','");
      if (this.curToken == 76) {
        getRawToken();
      }
      syntaxError("missing 'in' in QuantifiedExpr");
    }
    Object localObject = parseQuantifiedExpr(paramBoolean);
    this.comp.pop(localLambdaExp);
    localLambdaExp.body = ((Expression)localObject);
    Expression localExpression = new Expression[] { localExpression }[0];
    if (paramBoolean) {}
    for (localObject = "every";; localObject = "some")
    {
      return new ApplyExp(makeFunctionExp("gnu.xquery.util.ValuesEvery", (String)localObject), new Expression[] { localLambdaExp, localExpression });
      label275:
      boolean bool = match("satisfies");
      if ((!bool) && (!match("every")) && (!match("some"))) {
        return syntaxError("missing 'satisfies' clause");
      }
      peekNonSpace("unexpected eof-of-file after 'satisfies'");
      int i = getLineNumber();
      int j = getColumnNumber();
      if (bool) {
        getRawToken();
      }
      localObject = parseExprSingle();
      maybeSetLine((Expression)localObject, i + 1, j + 1);
      break;
    }
  }
  
  Expression parseRelativePathExpr(Expression paramExpression)
    throws IOException, SyntaxException
  {
    Object localObject1 = null;
    if ((this.curToken == 47) || (this.curToken == 68))
    {
      int i;
      label31:
      LambdaExp localLambdaExp;
      Object localObject2;
      if (this.curToken == 68)
      {
        i = 1;
        localLambdaExp = new LambdaExp(3);
        localObject2 = localLambdaExp.addDeclaration(DOT_VARNAME);
        ((Declaration)localObject2).setFlag(262144L);
        ((Declaration)localObject2).setType(NodeType.anyNodeTest);
        ((Declaration)localObject2).noteValue(null);
        localLambdaExp.addDeclaration(POSITION_VARNAME, LangPrimType.intType);
        localLambdaExp.addDeclaration(LAST_VARNAME, LangPrimType.intType);
        this.comp.push(localLambdaExp);
        if (i == 0) {
          break label195;
        }
        this.curToken = 47;
        localObject1 = new ReferenceExp(DOT_VARNAME, (Declaration)localObject2);
        localLambdaExp.body = new ApplyExp(DescendantOrSelfAxis.anyNode, new Expression[] { localObject1 });
        localObject1 = paramExpression;
      }
      for (;;)
      {
        this.comp.pop(localLambdaExp);
        paramExpression = new ApplyExp(RelativeStep.relativeStep, new Expression[] { paramExpression, localLambdaExp });
        break;
        i = 0;
        break label31;
        label195:
        getRawToken();
        Expression localExpression = parseStepExpr();
        localObject2 = paramExpression;
        if (localObject1 != null)
        {
          localObject2 = paramExpression;
          if ((localExpression instanceof ApplyExp))
          {
            Object localObject3 = ((ApplyExp)localExpression).getFunction();
            localObject2 = paramExpression;
            if ((localObject3 instanceof ApplyExp))
            {
              localObject3 = (ApplyExp)localObject3;
              localObject2 = paramExpression;
              if (((ApplyExp)localObject3).getFunction() == makeChildAxisStep)
              {
                ((ApplyExp)localObject3).setFunction(makeDescendantAxisStep);
                localObject2 = localObject1;
              }
            }
          }
        }
        localLambdaExp.body = localExpression;
        localObject1 = null;
        paramExpression = (Expression)localObject2;
      }
    }
    return paramExpression;
  }
  
  void parseSeparator()
    throws IOException, SyntaxException
  {
    int i = this.port.getLineNumber();
    int j = this.port.getColumnNumber();
    boolean bool;
    int k;
    if (this.nesting != 0)
    {
      bool = true;
      k = skipSpace(bool);
      if (k != 59) {
        break label46;
      }
    }
    label46:
    do
    {
      return;
      bool = false;
      break;
      if ((warnOldVersion) && (k != 10))
      {
        this.curLine = (i + 1);
        this.curColumn = (j + 1);
        error('w', "missing ';' after declaration");
      }
    } while (k < 0);
    unread(k);
  }
  
  Expression parseStepExpr()
    throws IOException, SyntaxException
  {
    Object localObject1;
    if ((this.curToken == 46) || (this.curToken == 51))
    {
      label65:
      Object localObject2;
      if (this.curToken == 46)
      {
        i = 12;
        getRawToken();
        localObject1 = this.comp.lexical.lookup(DOT_VARNAME, false);
        if (localObject1 != null) {
          break label116;
        }
        localObject1 = syntaxError("context item is undefined", "XPDY0002");
        localObject2 = localObject1;
        if (i == 9) {
          localObject2 = new ApplyExp(ParentAxis.make(NodeType.anyNodeTest), new Expression[] { localObject1 });
        }
        if (i != 12) {
          break label131;
        }
        i = -1;
      }
      label116:
      label131:
      for (;;)
      {
        return parseStepQualifiers((Expression)localObject2, i);
        i = 9;
        break;
        localObject1 = new ReferenceExp(DOT_VARNAME, (Declaration)localObject1);
        break label65;
      }
    }
    int i = peekOperand() - 100;
    if ((i >= 0) && (i < 13))
    {
      getRawToken();
      localObject1 = parseNodeTest(i);
    }
    for (;;)
    {
      return parseStepQualifiers((Expression)localObject1, i);
      if (this.curToken == 64)
      {
        getRawToken();
        i = 2;
        localObject1 = parseNodeTest(2);
      }
      else if (this.curToken == 236)
      {
        i = 2;
        localObject1 = parseNodeTest(2);
      }
      else
      {
        localObject1 = parseNodeTest(-1);
        if (localObject1 != null)
        {
          i = 3;
        }
        else
        {
          i = -1;
          localObject1 = parsePrimaryExpr();
        }
      }
    }
  }
  
  Expression parseStepQualifiers(Expression paramExpression, int paramInt)
    throws IOException, SyntaxException
  {
    Object localObject = paramExpression;
    if (this.curToken == 91)
    {
      int i = getLineNumber() + 1;
      int j = getColumnNumber() + 1;
      int k = this.seenPosition;
      k = this.seenLast;
      getRawToken();
      LambdaExp localLambdaExp = new LambdaExp(3);
      maybeSetLine(localLambdaExp, i, j);
      paramExpression = localLambdaExp.addDeclaration(DOT_VARNAME);
      label83:
      Expression localExpression;
      if (paramInt >= 0)
      {
        paramExpression.setType(NodeType.anyNodeTest);
        localLambdaExp.addDeclaration(POSITION_VARNAME, Type.intType);
        localLambdaExp.addDeclaration(LAST_VARNAME, Type.intType);
        this.comp.push(localLambdaExp);
        paramExpression.noteValue(null);
        localExpression = parseExprSequence(93, false);
        if (this.curToken == -1) {
          eofError("missing ']' - unexpected end-of-file");
        }
        if (paramInt >= 0) {
          break label220;
        }
        paramExpression = ValuesFilter.exprFilter;
      }
      for (;;)
      {
        maybeSetLine(localExpression, i, j);
        this.comp.pop(localLambdaExp);
        localLambdaExp.body = localExpression;
        getRawToken();
        localObject = new ApplyExp(paramExpression, new Expression[] { localObject, localLambdaExp });
        break;
        paramExpression.setType(SingletonType.getInstance());
        break label83;
        label220:
        if ((paramInt == 0) || (paramInt == 1) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
          paramExpression = ValuesFilter.reverseFilter;
        } else {
          paramExpression = ValuesFilter.forwardFilter;
        }
      }
    }
    return (Expression)localObject;
  }
  
  Expression parseTypeSwitch()
    throws IOException, SyntaxException
  {
    char c1 = 'e';
    char c2 = pushNesting('t');
    Object localObject = parseParenExpr();
    getRawToken();
    Vector localVector = new Vector();
    localVector.addElement(localObject);
    label103:
    LambdaExp localLambdaExp;
    if (match("case"))
    {
      pushNesting('c');
      getRawToken();
      if (this.curToken == 36)
      {
        localObject = parseVariableDeclaration();
        if (localObject == null) {
          return syntaxError("missing Variable after '$'");
        }
        getRawToken();
        if (match("as"))
        {
          getRawToken();
          ((Declaration)localObject).setTypeExp(parseDataType());
          popNesting('t');
          localLambdaExp = new LambdaExp(1);
          localLambdaExp.addDeclaration((Declaration)localObject);
          if (!match("return")) {
            break label224;
          }
          getRawToken();
        }
      }
      for (;;)
      {
        this.comp.push(localLambdaExp);
        pushNesting('r');
        localLambdaExp.body = parseExpr();
        popNesting('t');
        this.comp.pop(localLambdaExp);
        localVector.addElement(localLambdaExp);
        break;
        error('e', "missing 'as'");
        break label103;
        localObject = new Declaration("(arg)");
        break label103;
        label224:
        error("missing 'return' after 'case'");
      }
    }
    if (match("default"))
    {
      localLambdaExp = new LambdaExp(1);
      getRawToken();
      if (this.curToken == 36)
      {
        localObject = parseVariableDeclaration();
        if (localObject == null) {
          return syntaxError("missing Variable after '$'");
        }
        getRawToken();
        localLambdaExp.addDeclaration((Declaration)localObject);
        if (!match("return")) {
          break label397;
        }
        getRawToken();
      }
      for (;;)
      {
        this.comp.push(localLambdaExp);
        localLambdaExp.body = parseExpr();
        this.comp.pop(localLambdaExp);
        localVector.addElement(localLambdaExp);
        popNesting(c2);
        localObject = new Expression[localVector.size()];
        localVector.copyInto((Object[])localObject);
        return new ApplyExp(makeFunctionExp("gnu.kawa.reflect.TypeSwitch", "typeSwitch"), (Expression[])localObject);
        localObject = new Declaration("(arg)");
        break;
        label397:
        error("missing 'return' after 'default'");
      }
    }
    if (this.comp.isPedantic()) {}
    for (;;)
    {
      error(c1, "no 'default' clause in 'typeswitch'", "XPST0003");
      break;
      c1 = 'w';
    }
  }
  
  Object parseURILiteral()
    throws IOException, SyntaxException
  {
    getRawToken();
    if (this.curToken != 34) {
      return declError("expected a URILiteral");
    }
    return TextUtils.replaceWhitespace(new String(this.tokenBuffer, 0, this.tokenBufferLength), true);
  }
  
  Expression parseUnaryExpr()
    throws IOException, SyntaxException
  {
    if ((this.curToken == 414) || (this.curToken == 413))
    {
      int i = this.curToken;
      getRawToken();
      Expression localExpression = parseUnaryExpr();
      String str1;
      if (i == 413)
      {
        str1 = "plus";
        if (i != 413) {
          break label90;
        }
      }
      label90:
      for (String str2 = "+";; str2 = "-")
      {
        return new ApplyExp(makeFunctionExp("gnu.xquery.util.ArithOp", str1, str2), new Expression[] { localExpression });
        str1 = "minus";
        break;
      }
    }
    return parseUnionExpr();
  }
  
  Expression parseUnionExpr()
    throws IOException, SyntaxException
  {
    int i;
    for (Expression localExpression = parseIntersectExceptExpr();; localExpression = makeBinary(i, localExpression, parseIntersectExceptExpr()))
    {
      i = peekOperator();
      if (i != 419) {
        return localExpression;
      }
      getRawToken();
    }
  }
  
  public Object parseVariable()
    throws IOException, SyntaxException
  {
    if (this.curToken == 36) {
      getRawToken();
    }
    String str;
    for (;;)
    {
      str = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      if (this.curToken != 81) {
        break;
      }
      return str;
      syntaxError("missing '$' before variable name");
    }
    if (this.curToken == 65) {
      return Namespace.EmptyNamespace.getSymbol(str.intern());
    }
    return null;
  }
  
  public Declaration parseVariableDeclaration()
    throws IOException, SyntaxException
  {
    Object localObject = parseVariable();
    if (localObject == null) {
      return null;
    }
    localObject = new Declaration(localObject);
    maybeSetLine((Declaration)localObject, getLineNumber() + 1, getColumnNumber() + 1 - this.tokenBufferLength);
    return (Declaration)localObject;
  }
  
  Expression parseXMLConstructor(int paramInt, boolean paramBoolean)
    throws IOException, SyntaxException
  {
    int i;
    if (paramInt == 33)
    {
      paramInt = read();
      if ((paramInt == 45) && (peek() == 45))
      {
        skip();
        getDelimited("-->");
        int j = 0;
        paramInt = this.tokenBufferLength;
        i = 1;
        for (;;)
        {
          int k = paramInt - 1;
          paramInt = j;
          if (k >= 0) {
            if (this.tokenBuffer[k] != '-') {
              break label98;
            }
          }
          label98:
          for (paramInt = 1; (i != 0) && (paramInt != 0); paramInt = 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label112;
            }
            return syntaxError("consecutive or final hyphen in XML comment");
          }
          i = paramInt;
          paramInt = k;
        }
        label112:
        localObject1 = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength));
        return new ApplyExp(makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor"), new Expression[] { localObject1 });
      }
      if ((paramInt == 91) && (read() == 67) && (read() == 68) && (read() == 65) && (read() == 84) && (read() == 65) && (read() == 91))
      {
        if (!paramBoolean) {
          error('e', "CDATA section must be in element content");
        }
        getDelimited("]]>");
        localObject1 = new QuoteExp(new String(this.tokenBuffer, 0, this.tokenBufferLength));
        return new ApplyExp(makeCDATA, new Expression[] { localObject1 });
      }
      return syntaxError("'<!' must be followed by '--' or '[CDATA['");
    }
    if (paramInt == 63)
    {
      paramInt = peek();
      if ((paramInt < 0) || (!XName.isNameStart((char)paramInt)) || (getRawToken() != 65)) {
        syntaxError("missing target after '<?'");
      }
      localObject2 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      paramInt = 0;
      for (;;)
      {
        i = read();
        if (i < 0) {}
        for (;;)
        {
          getDelimited("?>");
          if ((paramInt == 0) && (this.tokenBufferLength > 0)) {
            syntaxError("target must be followed by space or '?>'");
          }
          localObject1 = new String(this.tokenBuffer, 0, this.tokenBufferLength);
          localObject2 = new QuoteExp(localObject2);
          localObject1 = new QuoteExp(localObject1);
          return new ApplyExp(makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst"), new Expression[] { localObject2, localObject1 });
          if (Character.isWhitespace((char)i)) {
            break;
          }
          unread();
        }
        paramInt += 1;
      }
    }
    if ((paramInt < 0) || (!XName.isNameStart((char)paramInt))) {
      return syntaxError("expected QName after '<'");
    }
    unread(paramInt);
    getRawToken();
    char c = pushNesting('<');
    Object localObject2 = parseElementConstructor();
    Object localObject1 = localObject2;
    if (!paramBoolean) {
      localObject1 = wrapWithBaseUri((Expression)localObject2);
    }
    popNesting(c);
    return (Expression)localObject1;
  }
  
  final int peekNonSpace(String paramString)
    throws IOException, SyntaxException
  {
    int i = skipSpace();
    if (i < 0) {
      eofError(paramString);
    }
    unread(i);
    return i;
  }
  
  int peekOperand()
    throws IOException, SyntaxException
  {
    while (this.curToken == 10) {
      getRawToken();
    }
    int i;
    if ((this.curToken == 65) || (this.curToken == 81))
    {
      boolean bool;
      if (this.nesting != 0)
      {
        bool = true;
        i = skipSpace(bool);
        switch (this.tokenBuffer[0])
        {
        }
      }
      for (;;)
      {
        if ((i == 40) && (peek() != 58))
        {
          this.curToken = 70;
          return 70;
          bool = false;
          break;
          if (match("attribute"))
          {
            if (i == 40)
            {
              this.curToken = 236;
              return 236;
            }
            if ((i == 123) || (XName.isNameStart((char)i)))
            {
              unread();
              this.curToken = 252;
              return 252;
              if (match("comment"))
              {
                if (i == 40)
                {
                  this.curToken = 232;
                  return 232;
                }
                if (i == 123)
                {
                  unread();
                  this.curToken = 254;
                  return 254;
                  if ((i == 123) && (match("document")))
                  {
                    unread();
                    this.curToken = 256;
                    return 256;
                  }
                  if ((i == 40) && (match("document-node")))
                  {
                    this.curToken = 234;
                    return 234;
                    if (match("element"))
                    {
                      if (i == 40)
                      {
                        this.curToken = 235;
                        return 235;
                      }
                      if ((i == 123) || (XName.isNameStart((char)i)))
                      {
                        unread();
                        this.curToken = 251;
                        return 251;
                      }
                    }
                    else
                    {
                      if ((i == 40) && (match("empty-sequence")))
                      {
                        this.curToken = 238;
                        return 238;
                      }
                      if ((i == 36) && (match("every")))
                      {
                        this.curToken = 246;
                        return 246;
                        if ((i == 36) && (match("for")))
                        {
                          this.curToken = 243;
                          return 243;
                          if ((i == 40) && (match("if")))
                          {
                            this.curToken = 241;
                            return 241;
                          }
                          if ((i == 40) && (match("item")))
                          {
                            this.curToken = 237;
                            return 237;
                            if ((i == 36) && (match("let")))
                            {
                              this.curToken = 244;
                              return 244;
                              if ((i == 40) && (match("node")))
                              {
                                this.curToken = 230;
                                return 230;
                                if ((i == 123) && (match("ordered")))
                                {
                                  this.curToken = 249;
                                  return 249;
                                  if (match("processing-instruction"))
                                  {
                                    if (i == 40)
                                    {
                                      this.curToken = 233;
                                      return 233;
                                    }
                                    if ((i == 123) || (XName.isNameStart((char)i)))
                                    {
                                      unread();
                                      this.curToken = 255;
                                      return 255;
                                      if ((i == 36) && (match("some")))
                                      {
                                        this.curToken = 245;
                                        return 245;
                                      }
                                      if ((i == 40) && (match("schema-attribute")))
                                      {
                                        this.curToken = 239;
                                        return 239;
                                      }
                                      if ((i == 40) && (match("schema-element")))
                                      {
                                        this.curToken = 240;
                                        return 240;
                                        if (match("text"))
                                        {
                                          if (i == 40)
                                          {
                                            this.curToken = 231;
                                            return 231;
                                          }
                                          if (i == 123)
                                          {
                                            unread();
                                            this.curToken = 253;
                                            return 253;
                                          }
                                        }
                                        if ((i == 40) && (match("typeswitch")))
                                        {
                                          this.curToken = 242;
                                          return 242;
                                          if ((i == 123) && (match("unordered")))
                                          {
                                            this.curToken = 250;
                                            return 250;
                                            if ((i == 123) && (match("validate")))
                                            {
                                              this.curToken = 248;
                                              return 248;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((i == 58) && (peek() == 58))
      {
        i = getAxis();
        this.curToken = i;
        return i;
      }
      this.curValue = new String(this.tokenBuffer, 0, this.tokenBufferLength);
      switch (i)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          if (i >= 0)
                          {
                            unread();
                            if ((XName.isNameStart((char)i)) && (this.curValue.equals("define")))
                            {
                              getRawToken();
                              this.curToken = 87;
                            }
                          }
                          return this.curToken;
                          if (lookingAt("declare", "ase-uri"))
                          {
                            this.curToken = 66;
                            return 66;
                          }
                        } while (!lookingAt("declare", "oundary-space"));
                        this.curToken = 83;
                        return 83;
                        if (lookingAt("declare", "onstruction"))
                        {
                          this.curToken = 75;
                          return 75;
                        }
                      } while (!lookingAt("declare", "opy-namespaces"));
                      this.curToken = 76;
                      return 76;
                      if (lookingAt("declare", "efault"))
                      {
                        getRawToken();
                        if (match("function"))
                        {
                          this.curToken = 79;
                          return 79;
                        }
                        if (match("element"))
                        {
                          this.curToken = 69;
                          return 69;
                        }
                        if (match("collation"))
                        {
                          this.curToken = 71;
                          return 71;
                        }
                        if (match("order"))
                        {
                          this.curToken = 72;
                          return 72;
                        }
                        error("unrecognized/unimplemented 'declare default'");
                        skipToSemicolon();
                        return peekOperand();
                      }
                    } while (!lookingAt("default", "lement"));
                    warnOldVersion("replace 'default element' by 'declare default element namespace'");
                    this.curToken = 69;
                    return 69;
                    if (lookingAt("declare", "unction"))
                    {
                      this.curToken = 80;
                      return 80;
                    }
                    if (lookingAt("define", "unction"))
                    {
                      warnOldVersion("replace 'define function' by 'declare function'");
                      this.curToken = 80;
                      return 80;
                    }
                  } while (!lookingAt("default", "unction"));
                  warnOldVersion("replace 'default function' by 'declare default function namespace'");
                  this.curToken = 79;
                  return 79;
                } while (!lookingAt("import", "odule"));
                this.curToken = 73;
                return 73;
                if (lookingAt("declare", "amespace"))
                {
                  this.curToken = 78;
                  return 78;
                }
                if (lookingAt("default", "amespace"))
                {
                  warnOldVersion("replace 'default namespace' by 'declare default element namespace'");
                  this.curToken = 69;
                  return 69;
                }
              } while (!lookingAt("module", "amespace"));
              this.curToken = 77;
              return 77;
              if (lookingAt("declare", "rdering"))
              {
                this.curToken = 85;
                return 85;
              }
            } while (!lookingAt("declare", "ption"));
            this.curToken = 111;
            return 111;
          } while (!lookingAt("import", "chema"));
          this.curToken = 84;
          return 84;
          if (lookingAt("declare", "ariable"))
          {
            this.curToken = 86;
            return 86;
          }
          if (lookingAt("define", "ariable"))
          {
            warnOldVersion("replace 'define variable' by 'declare variable'");
            this.curToken = 86;
            return 86;
          }
        } while (!lookingAt("xquery", "ersion"));
        this.curToken = 89;
        return 89;
      } while (!lookingAt("declare", "mlspace"));
      warnOldVersion("replace 'define xmlspace' by 'declare boundary-space'");
      this.curToken = 83;
      return 83;
    }
    if (this.curToken == 67)
    {
      i = read();
      if (i != 58) {
        break label1692;
      }
      this.curToken = getAxis();
    }
    for (;;)
    {
      return this.curToken;
      label1692:
      unread(i);
    }
  }
  
  int peekOperator()
    throws IOException, SyntaxException
  {
    while (this.curToken == 10)
    {
      if (this.nesting == 0) {
        return 10;
      }
      getRawToken();
    }
    if (this.curToken == 65) {
      switch (this.tokenBufferLength)
      {
      }
    }
    for (;;)
    {
      return this.curToken;
      int i = this.tokenBuffer[0];
      int j = this.tokenBuffer[1];
      if ((i == 111) && (j == 114)) {
        this.curToken = 400;
      } else if ((i == 116) && (j == 111)) {
        this.curToken = 412;
      } else if ((i == 105) && (j == 115)) {
        this.curToken = 408;
      } else if ((i == 101) && (j == 113)) {
        this.curToken = 426;
      } else if ((i == 110) && (j == 101)) {
        this.curToken = 427;
      } else if (i == 103)
      {
        if (j == 101) {
          this.curToken = 431;
        } else if (j == 116) {
          this.curToken = 430;
        }
      }
      else if (i == 108) {
        if (j == 101)
        {
          this.curToken = 429;
        }
        else if (j == 116)
        {
          this.curToken = 428;
          continue;
          i = this.tokenBuffer[0];
          j = this.tokenBuffer[1];
          int k = this.tokenBuffer[2];
          if (i == 97)
          {
            if ((j == 110) && (k == 100)) {
              this.curToken = 401;
            }
          }
          else if (i == 109)
          {
            if ((j == 117) && (k == 108)) {
              this.curToken = 415;
            }
            if ((j == 111) && (k == 100)) {
              this.curToken = 418;
            }
          }
          else if ((i == 100) && (j == 105) && (k == 118))
          {
            this.curToken = 416;
            continue;
            if (match("idiv"))
            {
              this.curToken = 417;
            }
            else if (match("cast", "as", true))
            {
              this.curToken = 425;
              continue;
              if (match("where"))
              {
                this.curToken = 196;
              }
              else if (match("isnot"))
              {
                this.curToken = 409;
              }
              else if (match("union"))
              {
                this.curToken = 419;
              }
              else if (match("treat", "as", true))
              {
                this.curToken = 423;
                continue;
                if (match("except"))
                {
                  this.curToken = 421;
                  continue;
                  if (match("instance", "of", true))
                  {
                    this.curToken = 422;
                  }
                  else if (match("castable", "as", true))
                  {
                    this.curToken = 424;
                    continue;
                    if (match("intersect"))
                    {
                      this.curToken = 420;
                      continue;
                      if (match("instanceof"))
                      {
                        warnOldVersion("use 'instanceof of' (two words) instead of 'instanceof'");
                        this.curToken = 422;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  void pushNamespace(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2.length() == 0) {
      str = null;
    }
    this.prologNamespaces = new NamespaceBinding(paramString1, str, this.prologNamespaces);
  }
  
  public Object readObject()
    throws IOException, SyntaxException
  {
    return parse(null);
  }
  
  public void reset()
    throws IOException
  {
    this.curToken = this.saveToken;
    this.curValue = this.saveValue;
    super.reset();
  }
  
  public String resolveAgainstBaseUri(String paramString)
  {
    if (Path.uriSchemeSpecified(paramString)) {
      return paramString;
    }
    return Path.valueOf(getStaticBaseUri()).resolve(paramString).toString();
  }
  
  public void setInteractive(boolean paramBoolean)
  {
    if (this.interactive != paramBoolean) {
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (this.nesting -= 1;; this.nesting += 1)
    {
      this.interactive = paramBoolean;
      return;
    }
  }
  
  public void setStaticBaseUri(String paramString)
  {
    try
    {
      this.baseURI = fixupStaticBaseUri(URIPath.valueOf(paramString));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramString = localThrowable;
      if ((localThrowable instanceof WrappedException)) {
        paramString = ((WrappedException)localThrowable).getCause();
      }
      error('e', "invalid URI: " + paramString.getMessage());
    }
  }
  
  final void skipComment()
    throws IOException, SyntaxException
  {
    this.commentCount += 1;
    int i1 = getLineNumber() + 1;
    int i2 = getColumnNumber() - 1;
    if (this.errorIfComment != null)
    {
      this.curLine = i1;
      this.curColumn = i2;
      error('e', this.errorIfComment);
    }
    int m = 0;
    int k = 0;
    char c = pushNesting(':');
    int n = read();
    int j;
    int i;
    if (n == 58)
    {
      j = n;
      i = k;
      if (m == 40)
      {
        i = k + 1;
        j = 0;
      }
    }
    for (;;)
    {
      k = i;
      m = j;
      break;
      if ((n == 41) && (m == 58))
      {
        if (k == 0)
        {
          popNesting(c);
          return;
        }
        i = k - 1;
        j = n;
      }
      else
      {
        j = n;
        i = k;
        if (n < 0)
        {
          this.curLine = i1;
          this.curColumn = i2;
          eofError("non-terminated comment starting here");
          j = n;
          i = k;
        }
      }
    }
  }
  
  final void skipOldComment()
    throws IOException, SyntaxException
  {
    int i = 0;
    int j = getLineNumber();
    int k = getColumnNumber();
    warnOldVersion("use (: :) instead of old-style comment {-- --}");
    for (;;)
    {
      int m = read();
      if (m == 45)
      {
        i += 1;
      }
      else
      {
        if ((m == 125) && (i >= 2)) {
          return;
        }
        if (m < 0)
        {
          this.curLine = (j + 1);
          this.curColumn = (k - 2);
          eofError("non-terminated comment starting here");
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  final int skipSpace()
    throws IOException, SyntaxException
  {
    return skipSpace(true);
  }
  
  final int skipSpace(boolean paramBoolean)
    throws IOException, SyntaxException
  {
    int i;
    do
    {
      for (;;)
      {
        i = read();
        if (i == 40)
        {
          if (!checkNext(':')) {
            return 40;
          }
          skipComment();
        }
        else
        {
          if (i != 123) {
            break;
          }
          i = read();
          if (i != 45)
          {
            unread(i);
            return 123;
          }
          i = read();
          if (i != 45)
          {
            unread(i);
            unread(45);
            return 123;
          }
          skipOldComment();
        }
      }
      if (!paramBoolean) {
        break;
      }
    } while ((i >= 0) && (Character.isWhitespace((char)i)));
    for (;;)
    {
      return i;
      if ((i == 32) || (i == 9)) {
        break;
      }
    }
  }
  
  final void skipToSemicolon()
    throws IOException
  {
    int i;
    do
    {
      i = read();
    } while ((i >= 0) && (i != 59));
  }
  
  public Expression syntaxError(String paramString)
    throws IOException, SyntaxException
  {
    return syntaxError(paramString, "XPST0003");
  }
  
  public Expression syntaxError(String paramString1, String paramString2)
    throws IOException, SyntaxException
  {
    error('e', paramString1, paramString2);
    if (this.interactive)
    {
      this.curToken = 0;
      this.curValue = null;
      this.nesting = 0;
      ((InPort)getPort()).readState = '\n';
      int i = read();
      if (i < 0) {}
      for (;;)
      {
        throw new SyntaxException(getMessages());
        if ((i != 13) && (i != 10)) {
          break;
        }
        unread(i);
      }
    }
    return new ErrorExp(paramString1);
  }
  
  String tokenString()
  {
    switch (this.curToken)
    {
    default: 
      if ((this.curToken >= 100) && (this.curToken - 100 < 13)) {
        return axisNames[(this.curToken - 100)] + "::-axis(" + this.curToken + ")";
      }
      break;
    case 34: 
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('"');
      int i = 0;
      while (i < this.tokenBufferLength)
      {
        char c = this.tokenBuffer[i];
        if (c == '"') {
          localStringBuffer.append('"');
        }
        localStringBuffer.append(c);
        i += 1;
      }
      localStringBuffer.append('"');
      return localStringBuffer.toString();
    case 70: 
      return new String(this.tokenBuffer, 0, this.tokenBufferLength) + " + '('";
    case 65: 
    case 81: 
      return new String(this.tokenBuffer, 0, this.tokenBufferLength);
    case -1: 
      return "<EOF>";
    }
    if ((this.curToken >= 32) && (this.curToken < 127)) {
      return Integer.toString(this.curToken) + "='" + (char)this.curToken + "'";
    }
    return Integer.toString(this.curToken);
  }
  
  void warnOldVersion(String paramString)
  {
    if ((warnOldVersion) || (this.comp.isPedantic())) {
      if (!this.comp.isPedantic()) {
        break label36;
      }
    }
    label36:
    for (char c = 'e';; c = 'w')
    {
      error(c, paramString);
      return;
    }
  }
  
  Expression wrapWithBaseUri(Expression paramExpression)
  {
    if (getStaticBaseUri() == null) {
      return paramExpression;
    }
    return new ApplyExp(MakeWithBaseUri.makeWithBaseUri, new Expression[] { new ApplyExp(new ReferenceExp(XQResolveNames.staticBaseUriDecl), Expression.noExpressions), paramExpression }).setLine(paramExpression);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\lang\XQParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */