package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ResolveNames;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.GetModuleClass;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.NodeType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.WrongArguments;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.xml.NamespaceBinding;
import gnu.xml.XMLFilter;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.QNameUtils;
import kawa.standard.Scheme;

public class XQResolveNames
  extends ResolveNames
{
  public static final int BASE_URI_BUILTIN = -11;
  public static final int CASTABLE_AS_BUILTIN = -34;
  public static final int CAST_AS_BUILTIN = -33;
  public static final int COLLECTION_BUILTIN = -8;
  public static final int COMPARE_BUILTIN = -4;
  public static final int DEEP_EQUAL_BUILTIN = -25;
  public static final int DEFAULT_COLLATION_BUILTIN = -29;
  public static final int DISTINCT_VALUES_BUILTIN = -5;
  public static final int DOC_AVAILABLE_BUILTIN = -10;
  public static final int DOC_BUILTIN = -9;
  public static final int HANDLE_EXTENSION_BUILTIN = -3;
  public static final int IDREF_BUILTIN = -31;
  public static final int ID_BUILTIN = -30;
  public static final int INDEX_OF_BUILTIN = -15;
  public static final int LANG_BUILTIN = -23;
  public static final int LAST_BUILTIN = -1;
  public static final int LOCAL_NAME_BUILTIN = -6;
  public static final int MAX_BUILTIN = -27;
  public static final int MIN_BUILTIN = -26;
  public static final int NAMESPACE_URI_BUILTIN = -7;
  public static final int NAME_BUILTIN = -24;
  public static final int NORMALIZE_SPACE_BUILTIN = -17;
  public static final int NUMBER_BUILTIN = -28;
  public static final int POSITION_BUILTIN = -2;
  public static final int RESOLVE_PREFIX_BUILTIN = -13;
  public static final int RESOLVE_URI_BUILTIN = -12;
  public static final int ROOT_BUILTIN = -32;
  public static final int STATIC_BASE_URI_BUILTIN = -14;
  public static final int STRING_BUILTIN = -16;
  public static final int UNORDERED_BUILTIN = -18;
  public static final int XS_QNAME_BUILTIN = -35;
  public static final int XS_QNAME_IGNORE_DEFAULT_BUILTIN = -36;
  public static final Declaration castAsDecl;
  public static final Declaration castableAsDecl;
  public static final Declaration handleExtensionDecl = makeBuiltin("(extension)", -3);
  public static final Declaration lastDecl;
  public static final Declaration resolvePrefixDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(resolve-prefix)"), -13);
  public static final Declaration staticBaseUriDecl;
  public static final Declaration xsQNameDecl;
  public static final Declaration xsQNameIgnoreDefaultDecl;
  public Namespace[] functionNamespacePath = XQuery.defaultFunctionNamespacePath;
  private Declaration moduleDecl;
  public XQParser parser;
  
  static
  {
    castAsDecl = makeBuiltin("(cast as)", -33);
    castableAsDecl = makeBuiltin("(castable as)", -34);
    lastDecl = makeBuiltin("last", -1);
    xsQNameDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "QName"), -35);
    xsQNameIgnoreDefaultDecl = makeBuiltin(Symbol.make("http://www.w3.org/2001/XMLSchema", "(QName-ignore-default)"), -36);
    staticBaseUriDecl = makeBuiltin("static-base-uri", -14);
  }
  
  public XQResolveNames()
  {
    this(null);
  }
  
  public XQResolveNames(Compilation paramCompilation)
  {
    super(paramCompilation);
    this.lookup.push(lastDecl);
    this.lookup.push(xsQNameDecl);
    this.lookup.push(staticBaseUriDecl);
    pushBuiltin("position", -2);
    pushBuiltin("compare", -4);
    pushBuiltin("distinct-values", -5);
    pushBuiltin("local-name", -6);
    pushBuiltin("name", -24);
    pushBuiltin("namespace-uri", -7);
    pushBuiltin("root", -32);
    pushBuiltin("base-uri", -11);
    pushBuiltin("lang", -23);
    pushBuiltin("resolve-uri", -12);
    pushBuiltin("collection", -8);
    pushBuiltin("doc", -9);
    pushBuiltin("document", -9);
    pushBuiltin("doc-available", -10);
    pushBuiltin("index-of", -15);
    pushBuiltin("string", -16);
    pushBuiltin("normalize-space", -17);
    pushBuiltin("unordered", -18);
    pushBuiltin("deep-equal", -25);
    pushBuiltin("min", -26);
    pushBuiltin("max", -27);
    pushBuiltin("number", -28);
    pushBuiltin("default-collation", -29);
    pushBuiltin("id", -30);
    pushBuiltin("idref", -31);
  }
  
  private Expression checkArgCount(Expression[] paramArrayOfExpression, Declaration paramDeclaration, int paramInt1, int paramInt2)
  {
    paramArrayOfExpression = WrongArguments.checkArgCount("fn:" + paramDeclaration.getName(), paramInt1, paramInt2, paramArrayOfExpression.length);
    if (paramArrayOfExpression == null) {
      return null;
    }
    return getCompilation().syntaxError(paramArrayOfExpression);
  }
  
  public static Declaration makeBuiltin(Symbol paramSymbol, int paramInt)
  {
    paramSymbol = new Declaration(paramSymbol);
    paramSymbol.setProcedureDecl(true);
    paramSymbol.setCode(paramInt);
    return paramSymbol;
  }
  
  public static Declaration makeBuiltin(String paramString, int paramInt)
  {
    return makeBuiltin(Symbol.make("http://www.w3.org/2005/xpath-functions", paramString, "fn"), paramInt);
  }
  
  static NamespaceBinding maybeAddNamespace(Symbol paramSymbol, boolean paramBoolean, NamespaceBinding paramNamespaceBinding)
  {
    if (paramSymbol == null) {}
    Object localObject;
    do
    {
      return paramNamespaceBinding;
      localObject = paramSymbol.getPrefix();
      String str = paramSymbol.getNamespaceURI();
      paramSymbol = (Symbol)localObject;
      if (localObject == "") {
        paramSymbol = null;
      }
      localObject = str;
      if (str == "") {
        localObject = null;
      }
    } while ((paramBoolean) && (paramSymbol == null) && (localObject == null));
    return NamespaceBinding.maybeAdd(paramSymbol, (String)localObject, paramNamespaceBinding);
  }
  
  static Declaration procToDecl(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new Declaration(paramObject1);
    ((Declaration)paramObject1).setProcedureDecl(true);
    ((Declaration)paramObject1).noteValue(new QuoteExp(paramObject2));
    ((Declaration)paramObject1).setFlag(16384L);
    return (Declaration)paramObject1;
  }
  
  private Expression visitStatements(Expression paramExpression)
  {
    Object localObject1;
    Object localObject2;
    if ((paramExpression instanceof BeginExp))
    {
      localObject1 = (BeginExp)paramExpression;
      localObject2 = ((BeginExp)localObject1).getExpressions();
      int j = ((BeginExp)localObject1).getExpressionCount();
      int i = 0;
      for (;;)
      {
        localObject1 = paramExpression;
        if (i >= j) {
          break;
        }
        localObject2[i] = visitStatements(localObject2[i]);
        i += 1;
      }
    }
    if ((paramExpression instanceof SetExp))
    {
      localObject1 = this.moduleDecl;
      SetExp localSetExp = (SetExp)paramExpression;
      localObject2 = visitSetExp(localSetExp, null);
      paramExpression = (Expression)localObject1;
      if (localSetExp.isDefining())
      {
        paramExpression = (Expression)localObject1;
        if (localSetExp.getBinding() == localObject1)
        {
          if (!((Declaration)localObject1).isProcedureDecl()) {
            push((Declaration)localObject1);
          }
          paramExpression = ((Declaration)localObject1).nextDecl();
        }
      }
      this.moduleDecl = paramExpression;
      localObject1 = localObject2;
      return (Expression)localObject1;
    }
    return (Expression)visit(paramExpression, null);
  }
  
  public Expression checkPragma(Symbol paramSymbol, Expression paramExpression)
  {
    return null;
  }
  
  Declaration flookup(Symbol paramSymbol)
  {
    Object localObject = XQuery.xqEnvironment.lookup(paramSymbol, EnvironmentKey.FUNCTION);
    if (localObject == null) {
      localObject = null;
    }
    Location localLocation;
    Declaration localDeclaration;
    do
    {
      return (Declaration)localObject;
      localLocation = ((Location)localObject).getBase();
      if (!(localLocation instanceof StaticFieldLocation)) {
        break;
      }
      localDeclaration = ((StaticFieldLocation)localLocation).getDeclaration();
      localObject = localDeclaration;
    } while (localDeclaration != null);
    localObject = localLocation.get(null);
    if (localObject != null) {
      return procToDecl(paramSymbol, localObject);
    }
    return null;
  }
  
  Expression getBaseUriExpr()
  {
    Compilation localCompilation = getCompilation();
    String str = this.parser.getStaticBaseUri();
    if (str != null) {
      return QuoteExp.getInstance(str);
    }
    return GetModuleClass.getModuleClassURI(localCompilation);
  }
  
  Expression getCollator(Expression[] paramArrayOfExpression, int paramInt)
  {
    if ((paramArrayOfExpression != null) && (paramArrayOfExpression.length > paramInt)) {
      return new ApplyExp(ClassType.make("gnu.xquery.util.NamedCollator").getDeclaredMethod("find", 1), new Expression[] { paramArrayOfExpression[paramInt] });
    }
    paramArrayOfExpression = this.parser.defaultCollator;
    if (paramArrayOfExpression == null) {
      return QuoteExp.nullExp;
    }
    return new QuoteExp(paramArrayOfExpression);
  }
  
  void push(Declaration paramDeclaration)
  {
    Compilation localCompilation = getCompilation();
    Object localObject2 = paramDeclaration.getSymbol();
    boolean bool = paramDeclaration.isProcedureDecl();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof String))
    {
      if ((paramDeclaration.getLineNumber() > 0) && (localCompilation != null))
      {
        String str = localCompilation.getFileName();
        int i = localCompilation.getLineNumber();
        int j = localCompilation.getColumnNumber();
        localCompilation.setLocation(paramDeclaration);
        localObject1 = this.parser.namespaceResolve((String)localObject2, bool);
        localCompilation.setLine(str, i, j);
      }
      while (localObject1 == null)
      {
        return;
        localObject1 = this.parser.namespaceResolve((String)localObject2, bool);
      }
      paramDeclaration.setName(localObject1);
    }
    localObject2 = this.lookup.lookup(localObject1, XQuery.instance.getNamespaceOf(paramDeclaration));
    if (localObject2 != null)
    {
      if (paramDeclaration.context != ((Declaration)localObject2).context) {
        break label175;
      }
      ScopeExp.duplicateDeclarationError((Declaration)localObject2, paramDeclaration, localCompilation);
    }
    for (;;)
    {
      this.lookup.push(paramDeclaration);
      return;
      label175:
      if ((XQParser.warnHidePreviousDeclaration) && ((!(localObject1 instanceof Symbol)) || (((Symbol)localObject1).getNamespace() != null))) {
        localCompilation.error('w', paramDeclaration, "declaration ", " hides previous declaration");
      }
    }
  }
  
  protected void push(ScopeExp paramScopeExp)
  {
    for (paramScopeExp = paramScopeExp.firstDecl(); paramScopeExp != null; paramScopeExp = paramScopeExp.nextDecl()) {
      push(paramScopeExp);
    }
  }
  
  void pushBuiltin(String paramString, int paramInt)
  {
    this.lookup.push(makeBuiltin(paramString, paramInt));
  }
  
  public void resolveModule(ModuleExp paramModuleExp)
  {
    this.currentLambda = paramModuleExp;
    for (Declaration localDeclaration = paramModuleExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl()) {
      if (localDeclaration.isProcedureDecl()) {
        push(localDeclaration);
      }
    }
    this.moduleDecl = paramModuleExp.firstDecl();
    paramModuleExp.body = visitStatements(paramModuleExp.body);
    for (paramModuleExp = paramModuleExp.firstDecl(); paramModuleExp != null; paramModuleExp = paramModuleExp.nextDecl()) {
      if (paramModuleExp.getSymbol() != null) {
        this.lookup.removeSubsumed(paramModuleExp);
      }
    }
  }
  
  protected Expression visitApplyExp(ApplyExp paramApplyExp, Void paramVoid)
  {
    Object localObject1 = paramApplyExp.getFunction();
    Object localObject2 = this.parser.constructorNamespaces;
    Object localObject3 = paramApplyExp.getFunctionValue();
    Object localObject4;
    if ((localObject3 instanceof MakeElement))
    {
      localObject3 = (MakeElement)localObject3;
      localObject4 = NamespaceBinding.nconc(((MakeElement)localObject3).getNamespaceNodes(), (NamespaceBinding)localObject2);
      ((MakeElement)localObject3).setNamespaceNodes((NamespaceBinding)localObject4);
      this.parser.constructorNamespaces = ((NamespaceBinding)localObject4);
    }
    int j;
    if ((localObject1 instanceof ReferenceExp))
    {
      localObject1 = visitReferenceExp((ReferenceExp)localObject1, paramApplyExp);
      paramApplyExp.setFunction((Expression)localObject1);
      visitExps(paramApplyExp.getArgs(), paramVoid);
      this.parser.constructorNamespaces = ((NamespaceBinding)localObject2);
      localObject1 = paramApplyExp.getFunction();
      if ((localObject1 instanceof ReferenceExp))
      {
        localObject1 = ((ReferenceExp)localObject1).getBinding();
        if (localObject1 != null)
        {
          j = ((Declaration)localObject1).getCode();
          if (j >= 0) {}
        }
      }
    }
    label434:
    int i;
    ApplyExp localApplyExp;
    switch (j)
    {
    case -22: 
    case -21: 
    case -20: 
    case -19: 
    default: 
      paramVoid = paramApplyExp.getFunctionValue();
      if (!(paramVoid instanceof Type)) {
        break label2193;
      }
      paramVoid = paramApplyExp.getArgs();
      if (paramVoid.length != 1) {
        this.messages.error('e', "type constructor requires a single argument");
      }
      break;
    case -2: 
    case -1: 
    case -34: 
    case -33: 
    case -36: 
    case -35: 
    case -13: 
    case -6: 
    case -24: 
    case -28: 
    case -32: 
    case -11: 
    case -23: 
    case -30: 
    case -31: 
    case -14: 
    case -7: 
    case -17: 
    case -18: 
    case -4: 
    case -16: 
    case -15: 
    case -8: 
    case -10: 
    case -9: 
    case -12: 
    case -5: 
    case -25: 
    case -26: 
    case -27: 
    case -29: 
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
                      return paramApplyExp;
                      localObject1 = (Expression)visit((Expression)localObject1, paramVoid);
                      break;
                      if (j == -1)
                      {
                        paramApplyExp = XQParser.LAST_VARNAME;
                        paramVoid = this.lookup.lookup(paramApplyExp, false);
                        if (paramVoid != null) {
                          break label434;
                        }
                        error('e', "undefined context for " + paramApplyExp.getName());
                      }
                      for (;;)
                      {
                        return new ReferenceExp(paramApplyExp, paramVoid);
                        paramApplyExp = XQParser.POSITION_VARNAME;
                        break;
                        paramVoid.setCanRead(true);
                      }
                      localObject4 = paramApplyExp.getArgs();
                      if (j == -33)
                      {
                        i = 0;
                        localObject3 = localObject4[i];
                        localObject1 = localObject3;
                        localObject2 = localObject1;
                        if ((localObject3 instanceof ApplyExp))
                        {
                          localApplyExp = (ApplyExp)localObject3;
                          localObject2 = localObject1;
                          if (localApplyExp.getFunction().valueIfConstant() == XQParser.proc_OccurrenceType_getInstance) {
                            localObject2 = localApplyExp.getArg(0);
                          }
                        }
                        localObject2 = ((Expression)localObject2).valueIfConstant();
                        localObject1 = null;
                        if (localObject2 != SingletonType.getInstance()) {
                          break label604;
                        }
                        localObject1 = "type to 'cast as' or 'castable as' must be atomic";
                        if (localObject1 != null) {
                          this.messages.error('e', (SourceLocator)localObject3, (String)localObject1, "XPST0080");
                        }
                        if ((localObject2 != Compilation.typeSymbol) || ((localObject3 instanceof ApplyExp))) {
                          break label668;
                        }
                      }
                      for (i = 1;; i = 0)
                      {
                        if (j != -33) {
                          break label698;
                        }
                        if (i == 0) {
                          break label673;
                        }
                        return visitApplyExp(XQParser.castQName(localObject4[1], true), paramVoid);
                        i = 1;
                        break;
                        if (localObject2 == XDataType.anyAtomicType)
                        {
                          localObject1 = "type to 'cast as' or 'castable as' cannot be anyAtomicType";
                          break label535;
                        }
                        if (localObject2 == XDataType.anySimpleType)
                        {
                          localObject1 = "type to 'cast as' or 'castable as' cannot be anySimpleType";
                          break label535;
                        }
                        if (localObject2 == XDataType.untypedType)
                        {
                          localObject1 = "type to 'cast as' or 'castable as' cannot be untyped";
                          break label535;
                        }
                        if (localObject2 != XDataType.NotationType) {
                          break label535;
                        }
                        localObject1 = "type to 'cast as' or 'castable as' cannot be NOTATION";
                        break label535;
                      }
                      for (paramVoid = XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs");; paramVoid = XQParser.makeFunctionExp("gnu.xquery.lang.XQParser", "castableAs"))
                      {
                        return new ApplyExp(paramVoid, (Expression[])localObject4).setLine(paramApplyExp);
                        if ((i != 0) && ((localObject4[0] instanceof QuoteExp)))
                        {
                          paramApplyExp = ((QuoteExp)localObject4[0]).getValue();
                          try
                          {
                            QNameUtils.resolveQName(paramApplyExp, this.parser.constructorNamespaces, this.parser.prologNamespaces);
                            paramApplyExp = XQuery.trueExp;
                            return paramApplyExp;
                          }
                          catch (RuntimeException paramApplyExp)
                          {
                            return XQuery.falseExp;
                          }
                        }
                      }
                      localObject2 = paramApplyExp.getArgs();
                      paramVoid = checkArgCount((Expression[])localObject2, (Declaration)localObject1, 1, 1);
                      paramApplyExp = paramVoid;
                    } while (paramVoid != null);
                    paramVoid = this.parser.constructorNamespaces;
                    paramApplyExp = paramVoid;
                    if (j == -36) {
                      paramApplyExp = new NamespaceBinding(null, "", paramVoid);
                    }
                    if ((localObject2[0] instanceof QuoteExp)) {
                      try
                      {
                        paramApplyExp = new QuoteExp(QNameUtils.resolveQName(((QuoteExp)localObject2[0]).getValue(), paramApplyExp, this.parser.prologNamespaces));
                        return paramApplyExp;
                      }
                      catch (RuntimeException paramApplyExp)
                      {
                        return getCompilation().syntaxError(paramApplyExp.getMessage());
                      }
                    }
                    paramVoid = localObject2[0];
                    paramApplyExp = new QuoteExp(paramApplyExp);
                    localObject1 = new QuoteExp(this.parser.prologNamespaces);
                    paramApplyExp = new ApplyExp(ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveQName", 3), new Expression[] { paramVoid, paramApplyExp, localObject1 });
                    paramApplyExp.setFlag(4);
                    return paramApplyExp;
                    localObject2 = paramApplyExp.getArgs();
                    paramVoid = checkArgCount((Expression[])localObject2, (Declaration)localObject1, 1, 1);
                    paramApplyExp = paramVoid;
                  } while (paramVoid != null);
                  if ((localObject2[0] instanceof QuoteExp))
                  {
                    paramApplyExp = ((QuoteExp)localObject2[0]).getValue();
                    if (paramApplyExp == null) {}
                    for (paramApplyExp = null;; paramApplyExp = paramApplyExp.toString())
                    {
                      paramVoid = QNameUtils.lookupPrefix(paramApplyExp, this.parser.constructorNamespaces, this.parser.prologNamespaces);
                      if (paramVoid != null) {
                        break;
                      }
                      return getCompilation().syntaxError("unknown namespace prefix '" + paramApplyExp + "'");
                    }
                    return new QuoteExp(paramVoid);
                  }
                  paramApplyExp = localObject2[0];
                  paramVoid = new QuoteExp(this.parser.constructorNamespaces);
                  localObject1 = new QuoteExp(this.parser.prologNamespaces);
                  paramApplyExp = new ApplyExp(new PrimProcedure(ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolvePrefix", 3)), new Expression[] { paramApplyExp, paramVoid, localObject1 });
                  paramApplyExp.setFlag(4);
                  return paramApplyExp;
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("localName", 1), paramApplyExp.getArgs(), "fn:local-name", 0);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("name", 1), paramApplyExp.getArgs(), "fn:name", 0);
                  return withContext(ClassType.make("gnu.xquery.util.NumberValue").getDeclaredMethod("numberValue", 1), paramApplyExp.getArgs(), "fn:number", 0);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("root", 1), paramApplyExp.getArgs(), "fn:root", 0);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("baseUri", 1), paramApplyExp.getArgs(), "fn:base-uri", 0);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("lang", 2), paramApplyExp.getArgs(), "fn:lang", 1);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("id$X", 3), paramApplyExp.getArgs(), "fn:id", 1);
                  return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("idref", 2), paramApplyExp.getArgs(), "fn:idref", 1);
                  paramVoid = checkArgCount(paramApplyExp.getArgs(), (Declaration)localObject1, 0, 0);
                  paramApplyExp = paramVoid;
                } while (paramVoid != null);
                return getBaseUriExpr();
                return withContext(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("namespaceURI", 1), paramApplyExp.getArgs(), "fn:namespace-uri", 0);
                return withContext(ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("normalizeSpace", 1), paramApplyExp.getArgs(), "fn:normalize-space", 0);
                localObject2 = paramApplyExp.getArgs();
                paramVoid = checkArgCount((Expression[])localObject2, (Declaration)localObject1, 1, 1);
                paramApplyExp = paramVoid;
              } while (paramVoid != null);
              return localObject2[0];
              return withCollator(ClassType.make("gnu.xquery.util.StringUtils").getDeclaredMethod("compare", 3), paramApplyExp.getArgs(), "fn:compare", 2);
              return withContext(ClassType.make("gnu.xml.TextUtils").getDeclaredMethod("asString", 1), paramApplyExp.getArgs(), "fn:string", 0);
              return withCollator(ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("indexOf$X", 4), paramApplyExp.getArgs(), "fn:index-of", 2);
              localObject3 = paramApplyExp.getArgs();
              localObject2 = ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("collection", 2);
              paramVoid = checkArgCount((Expression[])localObject3, (Declaration)localObject1, 0, 1);
              paramApplyExp = paramVoid;
            } while (paramVoid != null);
            paramVoid = getBaseUriExpr();
            if (localObject3.length > 0) {}
            for (paramApplyExp = localObject3[0];; paramApplyExp = QuoteExp.voidExp)
            {
              paramApplyExp = new ApplyExp((Method)localObject2, new Expression[] { paramApplyExp, paramVoid });
              paramApplyExp.setType(NodeType.documentNodeTest);
              return paramApplyExp;
            }
            localObject2 = paramApplyExp.getArgs();
            localObject3 = ClassType.make("gnu.xquery.util.NodeUtils");
            if (j != -9) {
              break label1770;
            }
            paramVoid = "docCached";
            paramApplyExp = paramVoid;
            if (XQParser.warnOldVersion)
            {
              paramApplyExp = paramVoid;
              if ("document".equals(((Declaration)localObject1).getName()))
              {
                getCompilation().error('w', "replace 'document' by 'doc'");
                paramApplyExp = paramVoid;
              }
            }
            localObject3 = ((ClassType)localObject3).getDeclaredMethod(paramApplyExp, 2);
            paramVoid = checkArgCount((Expression[])localObject2, (Declaration)localObject1, 1, 1);
            paramApplyExp = paramVoid;
          } while (paramVoid != null);
          paramApplyExp = getBaseUriExpr();
          paramApplyExp = new ApplyExp((Method)localObject3, new Expression[] { localObject2[0], paramApplyExp });
          if (j == -9) {
            paramApplyExp.setType(NodeType.documentNodeTest);
          }
          for (;;)
          {
            return paramApplyExp;
            paramApplyExp = "availableCached";
            break;
            paramApplyExp.setType(XDataType.booleanType);
          }
          localObject2 = paramApplyExp.getArgs();
          paramVoid = checkArgCount((Expression[])localObject2, (Declaration)localObject1, 1, 2);
          paramApplyExp = paramVoid;
        } while (paramVoid != null);
        paramApplyExp = new Expression[2];
        paramApplyExp[0] = localObject2[0];
        if (localObject2.length == 1) {
          paramApplyExp[1] = getBaseUriExpr();
        }
        for (;;)
        {
          return new ApplyExp(ClassType.make("gnu.xquery.util.QNameUtils").getDeclaredMethod("resolveURI", 2), paramApplyExp);
          paramApplyExp[1] = localObject2[1];
        }
        return withCollator(ClassType.make("gnu.xquery.util.DistinctValues").getDeclaredMethod("distinctValues$X", 3), paramApplyExp.getArgs(), "fn:distinct-values", 1);
        return withCollator(ClassType.make("gnu.xquery.util.SequenceUtils").getDeclaredMethod("deepEqual", 3), paramApplyExp.getArgs(), "fn:deep-equal", 2);
        return withCollator(ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("min", 2), paramApplyExp.getArgs(), "fn:min", 1);
        return withCollator(ClassType.make("gnu.xquery.util.MinMax").getDeclaredMethod("max", 2), paramApplyExp.getArgs(), "fn:max", 1);
        paramVoid = checkArgCount(paramApplyExp.getArgs(), (Declaration)localObject1, 0, 0);
        paramApplyExp = paramVoid;
      } while (paramVoid != null);
      paramApplyExp = this.parser.defaultCollator;
      if (paramApplyExp != null) {}
      for (paramApplyExp = paramApplyExp.getName();; paramApplyExp = "http://www.w3.org/2005/xpath-functions/collation/codepoint") {
        return QuoteExp.getInstance(paramApplyExp);
      }
    case -3: 
      label535:
      label604:
      label668:
      label673:
      label698:
      label1770:
      paramVoid = getCompilation();
      paramApplyExp = paramApplyExp.getArgs();
      i = 0;
      if (i < paramApplyExp.length - 1)
      {
        localObject1 = (String)((QuoteExp)paramApplyExp[i]).getValue();
        localObject1 = this.parser.namespaceResolve((String)localObject1, false);
        if (localObject1 == null) {}
        label2099:
        do
        {
          for (;;)
          {
            i += 2;
            break;
            if (((Symbol)localObject1).getNamespaceURI().length() != 0) {
              break label2099;
            }
            paramVoid.error('e', "pragma name cannot be in the empty namespace");
          }
          localObject1 = checkPragma((Symbol)localObject1, paramApplyExp[(i + 1)]);
        } while (localObject1 == null);
        return (Expression)localObject1;
      }
      if (i < paramApplyExp.length) {
        return paramApplyExp[(paramApplyExp.length - 1)];
      }
      getMessages().error('e', "no recognized pragma or default in extension expression", "XQST0079");
      return new ErrorExp("no recognized pragma or default in extension expression");
    }
    return new ApplyExp(XQParser.makeFunctionExp("gnu.xquery.util.CastAs", "castAs"), new Expression[] { paramApplyExp.getFunction(), paramVoid[0] });
    label2193:
    if ((paramVoid instanceof MakeElement))
    {
      localObject2 = (MakeElement)paramVoid;
      localObject3 = ((MakeElement)localObject2).getNamespaceNodes();
      localObject1 = ((MakeElement)localObject2).tag;
      paramVoid = (Void)localObject1;
      if (localObject1 == null) {
        paramVoid = MakeElement.getTagName(paramApplyExp);
      }
      paramVoid = maybeAddNamespace(paramVoid, false, (NamespaceBinding)localObject3);
      localObject3 = paramApplyExp.getArgs();
      localObject4 = new Symbol[localObject3.length];
      j = 0;
      i = 0;
      while (i < localObject3.length)
      {
        localApplyExp = localObject3[i];
        int k = j;
        localObject1 = paramVoid;
        Symbol localSymbol;
        if ((localApplyExp instanceof ApplyExp))
        {
          localApplyExp = (ApplyExp)localApplyExp;
          k = j;
          localObject1 = paramVoid;
          if (localApplyExp.getFunction() == MakeAttribute.makeAttributeExp)
          {
            localSymbol = MakeElement.getTagName(localApplyExp);
            k = j;
            localObject1 = paramVoid;
            if (localSymbol != null)
            {
              k = 0;
              if (k != j) {
                break label2378;
              }
              localObject4[j] = localSymbol;
              localObject1 = maybeAddNamespace(localSymbol, true, paramVoid);
              k = j + 1;
            }
          }
        }
        i += 1;
        j = k;
        paramVoid = (Void)localObject1;
        continue;
        label2378:
        if (localSymbol.equals(localObject4[k]))
        {
          getCompilation().setLine(localApplyExp);
          localObject1 = MakeElement.getTagName(paramApplyExp);
          if (localObject1 != null) {
            break label2442;
          }
        }
        label2442:
        for (localObject1 = null;; localObject1 = ((Symbol)localObject1).toString())
        {
          this.messages.error('e', XMLFilter.duplicateAttributeMessage(localSymbol, localObject1), "XQST0040");
          k += 1;
          break;
        }
      }
      if (paramVoid != null) {
        ((MakeElement)localObject2).setNamespaceNodes(paramVoid);
      }
    }
    return paramApplyExp;
  }
  
  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, ApplyExp paramApplyExp)
  {
    Object localObject3;
    boolean bool1;
    boolean bool2;
    int i;
    Object localObject1;
    if (paramReferenceExp.getBinding() == null)
    {
      localObject3 = paramReferenceExp.getSymbol();
      bool1 = paramReferenceExp.isProcedureName();
      bool2 = paramReferenceExp.getFlag(16);
      if (paramApplyExp != null) {
        break label63;
      }
      i = 1;
      localObject1 = this.lookup.lookup(localObject3, i);
      if (localObject1 == null) {
        break label74;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label523;
      }
      paramReferenceExp.setBinding((Declaration)localObject1);
      return paramReferenceExp;
      label63:
      i = XQuery.namespaceForFunctions(paramApplyExp.getArgCount());
      break;
      label74:
      if ((localObject3 instanceof Symbol))
      {
        paramApplyExp = (Symbol)localObject3;
        if ("".equals(paramApplyExp.getNamespaceURI()))
        {
          paramApplyExp = paramApplyExp.getLocalName();
          if ("request".equals(paramApplyExp)) {
            paramApplyExp = "getCurrentRequest";
          }
          while (paramApplyExp != null)
          {
            return new ApplyExp(ClassType.make("gnu.kawa.servlet.ServletRequestContext").getDeclaredMethod(paramApplyExp, 0), Expression.noExpressions);
            if ("response".equals(paramApplyExp)) {
              paramApplyExp = "getCurrentResponse";
            } else {
              paramApplyExp = null;
            }
          }
          continue;
        }
      }
      if ((localObject3 instanceof Symbol))
      {
        localObject1 = flookup((Symbol)localObject3);
      }
      else
      {
        String str = (String)localObject3;
        paramApplyExp = (ApplyExp)localObject1;
        Object localObject2 = str;
        int j;
        if (str.indexOf(':') < 0)
        {
          str = str.intern();
          paramApplyExp = (ApplyExp)localObject1;
          localObject2 = str;
          if (bool1)
          {
            j = 0;
            paramApplyExp = (ApplyExp)localObject1;
            localObject2 = str;
            if (j < this.functionNamespacePath.length)
            {
              localObject1 = this.functionNamespacePath[j].getSymbol(str);
              paramApplyExp = this.lookup.lookup(localObject1, i);
              if (paramApplyExp == null) {
                break label391;
              }
              localObject2 = str;
            }
          }
        }
        label286:
        localObject1 = paramApplyExp;
        if (paramApplyExp == null)
        {
          localObject2 = this.parser.namespaceResolve((String)localObject2, bool1);
          localObject1 = paramApplyExp;
          if (localObject2 != null)
          {
            paramApplyExp = this.lookup.lookup(localObject2, i);
            localObject1 = paramApplyExp;
            if (paramApplyExp == null) {
              if (!bool1)
              {
                localObject1 = paramApplyExp;
                if (!bool2) {}
              }
              else
              {
                str = ((Symbol)localObject2).getNamespaceURI();
                localObject1 = null;
                if ("http://www.w3.org/2001/XMLSchema".equals(str)) {
                  paramApplyExp = XQuery.getStandardType(((Symbol)localObject2).getName());
                }
                for (;;)
                {
                  if (paramApplyExp == null) {
                    break label467;
                  }
                  return new QuoteExp(paramApplyExp).setLine(paramReferenceExp);
                  label391:
                  localObject1 = flookup((Symbol)localObject1);
                  paramApplyExp = (ApplyExp)localObject1;
                  localObject2 = str;
                  if (localObject1 != null) {
                    break label286;
                  }
                  j += 1;
                  paramApplyExp = (ApplyExp)localObject1;
                  break;
                  paramApplyExp = (ApplyExp)localObject1;
                  if (bool2)
                  {
                    paramApplyExp = (ApplyExp)localObject1;
                    if (str == "")
                    {
                      paramApplyExp = (ApplyExp)localObject1;
                      if (!getCompilation().isPedantic()) {
                        paramApplyExp = Scheme.string2Type(((Symbol)localObject2).getName());
                      }
                    }
                  }
                }
                label467:
                if ((str != null) && (str.length() > 6) && (str.startsWith("class:"))) {
                  return CompileNamedPart.makeExp(ClassType.make(str.substring(6)), ((Symbol)localObject2).getName());
                }
                localObject1 = flookup((Symbol)localObject2);
              }
            }
          }
        }
      }
    }
    label523:
    if (bool1)
    {
      error('e', "unknown function " + localObject3);
      return paramReferenceExp;
    }
    if (bool2)
    {
      this.messages.error('e', paramReferenceExp, "unknown type " + localObject3, "XPST0051");
      return paramReferenceExp;
    }
    this.messages.error('e', paramReferenceExp, "unknown variable $" + localObject3, "XPST0008");
    return paramReferenceExp;
  }
  
  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Void paramVoid)
  {
    return visitReferenceExp(paramReferenceExp, (ApplyExp)null);
  }
  
  protected Expression visitSetExp(SetExp paramSetExp, Void paramVoid)
  {
    paramVoid = super.visitSetExp(paramSetExp, paramVoid);
    Declaration localDeclaration = paramSetExp.getBinding();
    if ((localDeclaration != null) && (!getCompilation().immediate))
    {
      Object localObject = localDeclaration.getSymbol();
      if (((localObject instanceof Symbol)) && ("http://www.w3.org/2005/xquery-local-functions".equals(((Symbol)localObject).getNamespaceURI())))
      {
        paramSetExp = paramSetExp.getNewValue();
        if ((!(paramSetExp instanceof ApplyExp)) || (((ApplyExp)paramSetExp).getFunction() != XQParser.getExternalFunction))
        {
          localDeclaration.setFlag(16777216L);
          localDeclaration.setPrivate(true);
        }
      }
    }
    return paramVoid;
  }
  
  Expression withCollator(Method paramMethod, Expression[] paramArrayOfExpression, String paramString, int paramInt)
  {
    return withCollator(new QuoteExp(new PrimProcedure(paramMethod)), paramArrayOfExpression, paramString, paramInt);
  }
  
  Expression withCollator(Expression paramExpression, Expression[] paramArrayOfExpression, String paramString, int paramInt)
  {
    paramString = WrongArguments.checkArgCount(paramString, paramInt, paramInt + 1, paramArrayOfExpression.length);
    if (paramString != null) {
      return getCompilation().syntaxError(paramString);
    }
    paramString = new Expression[paramInt + 1];
    System.arraycopy(paramArrayOfExpression, 0, paramString, 0, paramInt);
    paramString[paramInt] = getCollator(paramArrayOfExpression, paramInt);
    return new ApplyExp(paramExpression, paramString);
  }
  
  Expression withContext(Method paramMethod, Expression[] paramArrayOfExpression, String paramString, int paramInt)
  {
    Object localObject = WrongArguments.checkArgCount(paramString, paramInt, paramInt + 1, paramArrayOfExpression.length);
    if (localObject != null) {
      return getCompilation().syntaxError((String)localObject);
    }
    localObject = paramArrayOfExpression;
    if (paramArrayOfExpression.length == paramInt)
    {
      localObject = new Expression[paramInt + 1];
      System.arraycopy(paramArrayOfExpression, 0, localObject, 0, paramInt);
      paramArrayOfExpression = this.lookup.lookup(XQParser.DOT_VARNAME, false);
      if (paramArrayOfExpression == null)
      {
        paramMethod = "undefined context for " + paramString;
        this.messages.error('e', paramMethod, "XPDY0002");
        return new ErrorExp(paramMethod);
      }
      localObject[paramInt] = new ReferenceExp(paramArrayOfExpression);
    }
    return new ApplyExp(paramMethod, (Expression[])localObject);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\lang\XQResolveNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */