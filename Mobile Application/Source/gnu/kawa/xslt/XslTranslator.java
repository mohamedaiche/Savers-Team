package gnu.kawa.xslt;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.lists.Consumer;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.InPort;
import gnu.mapping.Symbol;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.xml.XMLParser;
import gnu.xml.XName;
import gnu.xquery.lang.XQParser;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;

public class XslTranslator
  extends Lexer
  implements Consumer
{
  static final String XSL_TRANSFORM_URI = "http://www.w3.org/1999/XSL/Transform";
  static final Method applyTemplatesMethod = typeXSLT.getDeclaredMethod("applyTemplates", 2);
  static final PrimProcedure applyTemplatesProc = new PrimProcedure(applyTemplatesMethod);
  static final Method defineTemplateMethod;
  static final PrimProcedure defineTemplateProc;
  static final Method runStylesheetMethod;
  static final PrimProcedure runStylesheetProc;
  static final ClassType typeTemplateTable;
  static final ClassType typeXSLT = ClassType.make("gnu.kawa.xslt.XSLT");
  Object attributeType;
  StringBuffer attributeValue = new StringBuffer(100);
  Compilation comp;
  Declaration consumerDecl;
  InPort in;
  boolean inAttribute;
  boolean inTemplate;
  XSLT interpreter;
  ModuleExp mexp;
  StringBuffer nesting = new StringBuffer(100);
  boolean preserveSpace;
  LambdaExp templateLambda;
  
  static
  {
    typeTemplateTable = ClassType.make("gnu.kawa.xslt.TemplateTable");
    defineTemplateMethod = typeXSLT.getDeclaredMethod("defineTemplate", 5);
    runStylesheetMethod = typeXSLT.getDeclaredMethod("runStylesheet", 0);
    defineTemplateProc = new PrimProcedure(defineTemplateMethod);
    runStylesheetProc = new PrimProcedure(runStylesheetMethod);
  }
  
  XslTranslator(InPort paramInPort, SourceMessages paramSourceMessages, XSLT paramXSLT)
  {
    super(paramInPort, paramSourceMessages);
    this.interpreter = paramXSLT;
    this.in = paramInPort;
  }
  
  public static String isXslTag(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof QuoteExp)) {
      localObject = ((QuoteExp)paramObject).getValue();
    }
    if (!(localObject instanceof Symbol)) {}
    do
    {
      return null;
      paramObject = (Symbol)localObject;
    } while (((Symbol)paramObject).getNamespaceURI() != "http://www.w3.org/1999/XSL/Transform");
    return ((Symbol)paramObject).getLocalName();
  }
  
  public Consumer append(char paramChar)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramChar);
      return this;
    }
    push(String.valueOf(paramChar));
    return this;
  }
  
  public Consumer append(CharSequence paramCharSequence)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramCharSequence);
      return this;
    }
    push(paramCharSequence.toString());
    return this;
  }
  
  public Consumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return append(paramCharSequence.subSequence(paramInt1, paramInt2));
  }
  
  void append(Expression paramExpression) {}
  
  public void endAttribute()
  {
    QuoteExp localQuoteExp1 = new QuoteExp(this.attributeType);
    QuoteExp localQuoteExp2 = new QuoteExp(this.attributeValue.toString());
    push(new ApplyExp(MakeAttribute.makeAttributeExp, new Expression[] { localQuoteExp1, localQuoteExp2 }));
    this.nesting.setLength(this.nesting.length() - 1);
    this.inAttribute = false;
  }
  
  public void endDocument() {}
  
  public void endElement()
  {
    maybeSkipWhitespace();
    int i = this.nesting.length() - 1;
    int j = this.nesting.charAt(i);
    this.nesting.setLength(i);
    Object localObject1 = isXslTag((Expression)this.comp.exprStack.elementAt(j));
    if (localObject1 == "value-of")
    {
      localObject1 = popMatchingAttribute("", "select", j + 1);
      if (localObject1 != null)
      {
        localObject1 = parseXPath((String)localObject1);
        localObject1 = new ApplyExp(XQParser.makeText, new Expression[] { localObject1 });
        this.comp.exprStack.pop();
        push((Expression)localObject1);
      }
    }
    do
    {
      return;
      if (localObject1 != "copy-of") {
        break;
      }
      localObject1 = popMatchingAttribute("", "select", j + 1);
    } while (localObject1 == null);
    localObject1 = parseXPath((String)localObject1);
    this.comp.exprStack.pop();
    push((Expression)localObject1);
    return;
    Object localObject2;
    if (localObject1 == "apply-templates")
    {
      localObject2 = popMatchingAttribute("", "select", j + 1);
      localObject1 = popMatchingAttribute("", "mode", j + 1);
      localObject2 = new QuoteExp(localObject2);
      localObject1 = resolveQNameExpression((String)localObject1);
      this.comp.exprStack.pop();
      push(new ApplyExp(new QuoteExp(applyTemplatesProc), new Expression[] { localObject2, localObject1 }));
      return;
    }
    if (localObject1 == "if")
    {
      localObject1 = XQParser.booleanValue(parseXPath(popMatchingAttribute("", "test", j + 1)));
      localObject2 = popTemplateBody(j + 1);
      this.comp.exprStack.pop();
      push(new IfExp((Expression)localObject1, (Expression)localObject2, QuoteExp.voidExp));
      return;
    }
    if ((localObject1 == "stylesheet") || (localObject1 == "transform"))
    {
      popMatchingAttribute("", "version", j + 1);
      push(new ApplyExp(new QuoteExp(runStylesheetProc), Expression.noExpressions));
      localObject1 = popTemplateBody(j + 1);
      push((Expression)localObject1);
      this.mexp.body = ((Expression)localObject1);
      return;
    }
    if (localObject1 == "template")
    {
      Object localObject3 = popMatchingAttribute("", "match", j + 1);
      localObject1 = popMatchingAttribute("", "name", j + 1);
      popMatchingAttribute("", "priority", j + 1);
      localObject2 = popMatchingAttribute("", "mode", j + 1);
      this.templateLambda.body = popTemplateBody(j + 1);
      this.comp.exprStack.pop();
      localObject1 = resolveQNameExpression((String)localObject1);
      localObject3 = new QuoteExp(localObject3);
      QuoteExp localQuoteExp = new QuoteExp(DFloNum.make(0.0D));
      localObject2 = resolveQNameExpression((String)localObject2);
      LambdaExp localLambdaExp = this.templateLambda;
      push(new ApplyExp(new QuoteExp(defineTemplateProc), new Expression[] { localObject1, localObject3, localQuoteExp, localObject2, localLambdaExp }));
      this.templateLambda = null;
      return;
    }
    if (localObject1 == "text")
    {
      this.preserveSpace = false;
      localObject1 = new Expression[this.comp.exprStack.size() - j - 1];
      i = localObject1.length;
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          break;
        }
        localObject1[i] = ((Expression)this.comp.exprStack.pop());
      }
      this.comp.exprStack.pop();
      localObject1 = new ApplyExp(XQParser.makeText, (Expression[])localObject1);
      push((Expression)localObject1);
      this.mexp.body = ((Expression)localObject1);
      return;
    }
    localObject1 = new Expression[this.comp.exprStack.size() - j];
    i = localObject1.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject1[i] = ((Expression)this.comp.exprStack.pop());
    }
    localObject1 = new ApplyExp(new QuoteExp(new MakeElement()), (Expression[])localObject1);
    push((Expression)localObject1);
    this.mexp.body = ((Expression)localObject1);
  }
  
  public void error(char paramChar, String paramString)
  {
    getMessages().error(paramChar, paramString);
  }
  
  public Expression getExpression()
  {
    return (Expression)this.comp.exprStack.pop();
  }
  
  public boolean ignoring()
  {
    return false;
  }
  
  void maybeSkipWhitespace()
  {
    if (this.preserveSpace) {
      return;
    }
    int i = this.comp.exprStack.size();
    int j = i - 1;
    if (j >= 0)
    {
      Object localObject = (Expression)this.comp.exprStack.elementAt(j);
      if ((localObject instanceof QuoteExp))
      {
        localObject = ((QuoteExp)localObject).getValue();
        if (localObject == null) {}
        for (localObject = "";; localObject = localObject.toString())
        {
          i = ((String)localObject).length();
          int m;
          do
          {
            int k;
            do
            {
              do
              {
                do
                {
                  k = i - 1;
                  i = j;
                  if (k < 0) {
                    break;
                  }
                  m = ((String)localObject).charAt(k);
                  i = k;
                } while (m == 32);
                i = k;
              } while (m == 9);
              i = k;
            } while (m == 13);
            i = k;
          } while (m == 10);
          return;
        }
      }
    }
    this.comp.exprStack.setSize(j + 1);
  }
  
  public void parse(Compilation paramCompilation)
    throws IOException
  {
    this.comp = paramCompilation;
    if (paramCompilation.exprStack == null) {
      paramCompilation.exprStack = new Stack();
    }
    ModuleExp localModuleExp = paramCompilation.pushNewModule(this);
    paramCompilation.mustCompileHere();
    startDocument(localModuleExp);
    XMLParser.parse(this.in, getMessages(), this);
    endDocument();
    paramCompilation.pop(localModuleExp);
  }
  
  Expression parseXPath(String paramString)
  {
    Object localObject = this.comp.getMessages();
    try
    {
      paramString = new XQParser(new CharArrayInPort(paramString), (SourceMessages)localObject, this.interpreter);
      localObject = new Vector(20);
      int i;
      for (;;)
      {
        Expression localExpression = paramString.parse(this.comp);
        if (localExpression == null)
        {
          i = ((Vector)localObject).size();
          if (i != 0) {
            break;
          }
          return QuoteExp.voidExp;
        }
        ((Vector)localObject).addElement(localExpression);
      }
      if (i != 1) {
        break label123;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      throw new InternalError("caught " + paramString);
    }
    return (Expression)((Vector)localObject).elementAt(0);
    label123:
    throw new InternalError("too many xpath expressions");
  }
  
  public String popMatchingAttribute(String paramString1, String paramString2, int paramInt)
  {
    int j = this.comp.exprStack.size();
    int i = paramInt;
    for (;;)
    {
      Object localObject1;
      if (i < j)
      {
        localObject1 = this.comp.exprStack.elementAt(paramInt);
        if ((localObject1 instanceof ApplyExp)) {
          break label45;
        }
      }
      label45:
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              localObject1 = (ApplyExp)localObject1;
              ((ApplyExp)localObject1).getFunction();
            } while (((ApplyExp)localObject1).getFunction() != MakeAttribute.makeAttributeExp);
            localObject1 = ((ApplyExp)localObject1).getArgs();
          } while (localObject1.length != 2);
          localObject2 = localObject1[0];
        } while (!(localObject2 instanceof QuoteExp));
        localObject2 = ((QuoteExp)localObject2).getValue();
      } while (!(localObject2 instanceof Symbol));
      Object localObject2 = (Symbol)localObject2;
      if ((((Symbol)localObject2).getLocalPart() == paramString2) && (((Symbol)localObject2).getNamespaceURI() == paramString1))
      {
        this.comp.exprStack.removeElementAt(i);
        return (String)((QuoteExp)localObject1[1]).getValue();
      }
      i += 1;
    }
  }
  
  Expression popTemplateBody(int paramInt)
  {
    paramInt = this.comp.exprStack.size() - paramInt;
    Expression[] arrayOfExpression = new Expression[paramInt];
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      arrayOfExpression[paramInt] = ((Expression)this.comp.exprStack.pop());
    }
    return new ApplyExp(AppendValues.appendValues, arrayOfExpression);
  }
  
  void push(Expression paramExpression)
  {
    this.comp.exprStack.push(paramExpression);
  }
  
  void push(Object paramObject)
  {
    push(new QuoteExp(paramObject));
  }
  
  Expression resolveQNameExpression(String paramString)
  {
    if (paramString == null) {
      return QuoteExp.nullExp;
    }
    return new QuoteExp(Symbol.make(null, paramString));
  }
  
  public void startAttribute(Object paramObject)
  {
    if (this.inAttribute) {
      error('f', "internal error - attribute inside attribute");
    }
    this.attributeType = paramObject;
    this.attributeValue.setLength(0);
    this.nesting.append((char)this.comp.exprStack.size());
    this.inAttribute = true;
  }
  
  public void startDocument() {}
  
  public void startDocument(ModuleExp paramModuleExp)
  {
    this.mexp = paramModuleExp;
    startDocument();
  }
  
  public void startElement(Object paramObject)
  {
    maybeSkipWhitespace();
    Object localObject = isXslTag(paramObject);
    if (localObject == "template")
    {
      if (this.templateLambda != null) {
        error("nested xsl:template");
      }
      this.templateLambda = new LambdaExp();
    }
    for (;;)
    {
      localObject = paramObject;
      if ((paramObject instanceof XName))
      {
        paramObject = (XName)paramObject;
        localObject = Symbol.make(((XName)paramObject).getNamespaceURI(), ((XName)paramObject).getLocalPart(), ((XName)paramObject).getPrefix());
      }
      this.nesting.append((char)this.comp.exprStack.size());
      push(localObject);
      return;
      if (localObject == "text") {
        this.preserveSpace = false;
      }
    }
  }
  
  public void write(int paramInt)
  {
    if (this.inAttribute)
    {
      this.attributeValue.appendCodePoint(paramInt);
      return;
    }
    if (paramInt < 65536) {}
    for (String str = String.valueOf(paramInt);; str = new String(new char[] { (char)((paramInt - 65536 >> 10) + 55296), (char)((paramInt & 0x3FF) + 56320) }))
    {
      push(str);
      return;
    }
  }
  
  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    write(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
  }
  
  public void write(String paramString)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramString);
      return;
    }
    push(paramString);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    push(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    for (QuoteExp localQuoteExp = QuoteExp.trueExp;; localQuoteExp = QuoteExp.falseExp)
    {
      push(localQuoteExp);
      return;
    }
  }
  
  public void writeDouble(double paramDouble)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramDouble);
      return;
    }
    push(DFloNum.make(paramDouble));
  }
  
  public void writeFloat(float paramFloat)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramFloat);
      return;
    }
    push(DFloNum.make(paramFloat));
  }
  
  public void writeInt(int paramInt)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramInt);
      return;
    }
    push(IntNum.make(paramInt));
  }
  
  public void writeLong(long paramLong)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramLong);
      return;
    }
    push(IntNum.make(paramLong));
  }
  
  public void writeObject(Object paramObject)
  {
    if (this.inAttribute)
    {
      this.attributeValue.append(paramObject);
      return;
    }
    push(paramObject);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\xslt\XslTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */