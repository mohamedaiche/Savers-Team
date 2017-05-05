package gnu.kawa.xslt;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.Focus;
import gnu.kawa.xml.KDocument;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xquery.lang.XQParser;
import gnu.xquery.lang.XQResolveNames;
import gnu.xquery.lang.XQuery;
import java.io.IOException;

public class XSLT
  extends XQuery
{
  public static XSLT instance;
  public static Symbol nullMode = Symbol.make(null, "");
  
  public XSLT()
  {
    instance = this;
    ModuleBody.setMainPrintValues(true);
  }
  
  public static void applyTemplates(String paramString, Symbol paramSymbol)
    throws Throwable
  {
    paramString = paramSymbol;
    if (paramSymbol == null) {
      paramString = nullMode;
    }
    TemplateTable.getTemplateTable(paramString);
    paramString = CallContext.getInstance();
    paramSymbol = Focus.getCurrent();
    TreeList localTreeList = (TreeList)paramSymbol.sequence;
    paramSymbol.push(localTreeList, localTreeList.firstChildPos(paramSymbol.ipos));
    process(localTreeList, paramSymbol, paramString);
    paramSymbol.pop();
  }
  
  public static void defineApplyTemplate(String paramString, double paramDouble, Symbol paramSymbol, Procedure paramProcedure)
  {
    Symbol localSymbol = paramSymbol;
    if (paramSymbol == null) {
      localSymbol = nullMode;
    }
    TemplateTable.getTemplateTable(localSymbol).enter(paramString, paramDouble, paramProcedure);
  }
  
  public static void defineCallTemplate(Symbol paramSymbol, double paramDouble, Procedure paramProcedure) {}
  
  public static void defineTemplate(Symbol paramSymbol1, String paramString, double paramDouble, Symbol paramSymbol2, Procedure paramProcedure)
  {
    if (paramSymbol1 != null) {
      defineCallTemplate(paramSymbol1, paramDouble, paramProcedure);
    }
    if (paramString != null) {
      defineApplyTemplate(paramString, paramDouble, paramSymbol2, paramProcedure);
    }
  }
  
  public static XSLT getXsltInstance()
  {
    if (instance == null) {
      new XSLT();
    }
    return instance;
  }
  
  public static void process(TreeList paramTreeList, Focus paramFocus, CallContext paramCallContext)
    throws Throwable
  {
    Consumer localConsumer = paramCallContext.consumer;
    int j = paramFocus.ipos;
    int i;
    switch (paramTreeList.getNextKind(j))
    {
    case 30: 
    case 31: 
    case 32: 
    default: 
      return;
    case 34: 
      i = paramTreeList.firstChildPos(j);
    }
    for (;;)
    {
      paramFocus.ipos = i;
      break;
      Object localObject1 = paramFocus.getNextTypeObject();
      Object localObject2 = paramFocus.getNextTypeName();
      localObject2 = TemplateTable.nullModeTable.find((String)localObject2);
      if (localObject2 != null)
      {
        ((Procedure)localObject2).check0(paramCallContext);
        paramCallContext.runUntilDone();
      }
      int k;
      for (;;)
      {
        i = paramTreeList.nextDataIndex(j >>> 1) << 1;
        paramFocus.gotoNext();
        break;
        localConsumer.startElement(localObject1);
        k = paramTreeList.firstAttributePos(j);
        i = k;
        if (k == 0) {
          i = paramTreeList.firstChildPos(j);
        }
        paramFocus.push(paramTreeList, i);
        process(paramTreeList, paramFocus, paramCallContext);
        paramFocus.pop();
        localConsumer.endElement();
      }
      paramFocus.getNextTypeObject();
      localObject1 = paramFocus.getNextTypeName();
      localObject1 = TemplateTable.nullModeTable.find("@" + (String)localObject1);
      if (localObject1 != null)
      {
        ((Procedure)localObject1).check0(paramCallContext);
        paramCallContext.runUntilDone();
        i = j;
      }
      else
      {
        k = j >>> 1;
        j = paramTreeList.nextNodeIndex(k, Integer.MAX_VALUE);
        i = j;
        if (k == j) {
          i = paramTreeList.nextDataIndex(k);
        }
        paramTreeList.consumeIRange(k, i, localConsumer);
        i <<= 1;
        continue;
        i = paramTreeList.nextDataIndex(j >>> 1) << 1;
      }
    }
  }
  
  public static void registerEnvironment()
  {
    Language.setDefaults(new XSLT());
  }
  
  public static void runStylesheet()
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    ApplicationMainSupport.processSetProperties();
    String[] arrayOfString = ApplicationMainSupport.commandLineArgArray;
    int i = 0;
    while (i < arrayOfString.length)
    {
      KDocument localKDocument = Document.parse(arrayOfString[i]);
      Focus localFocus = Focus.getCurrent();
      localFocus.push(localKDocument.sequence, localKDocument.ipos);
      process((TreeList)localKDocument.sequence, localFocus, localCallContext);
      i += 1;
    }
  }
  
  public Lexer getLexer(InPort paramInPort, SourceMessages paramSourceMessages)
  {
    return new XslTranslator(paramInPort, paramSourceMessages, this);
  }
  
  public String getName()
  {
    return "XSLT";
  }
  
  public boolean parse(Compilation paramCompilation, int paramInt)
    throws IOException, SyntaxException
  {
    Compilation.defaultCallConvention = 2;
    ((XslTranslator)paramCompilation.lexer).parse(paramCompilation);
    paramCompilation.setState(4);
    XQParser localXQParser = new XQParser(null, paramCompilation.getMessages(), this);
    XQResolveNames localXQResolveNames = new XQResolveNames(paramCompilation);
    localXQResolveNames.functionNamespacePath = localXQParser.functionNamespacePath;
    localXQResolveNames.parser = localXQParser;
    localXQResolveNames.resolveModule(paramCompilation.mainLambda);
    return true;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\xslt\XSLT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */