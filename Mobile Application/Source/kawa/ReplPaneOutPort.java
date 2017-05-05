package kawa;

import gnu.kawa.models.Paintable;
import gnu.kawa.models.Viewable;
import gnu.mapping.OutPort;
import gnu.text.Path;
import java.awt.Component;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ReplPaneOutPort
  extends OutPort
{
  ReplDocument document;
  String str = "";
  AttributeSet style;
  TextPaneWriter tout;
  
  public ReplPaneOutPort(ReplDocument paramReplDocument, String paramString, AttributeSet paramAttributeSet)
  {
    this(new TextPaneWriter(paramReplDocument, paramAttributeSet), paramReplDocument, paramString, paramAttributeSet);
  }
  
  ReplPaneOutPort(TextPaneWriter paramTextPaneWriter, ReplDocument paramReplDocument, String paramString, AttributeSet paramAttributeSet)
  {
    super(paramTextPaneWriter, true, true, Path.valueOf(paramString));
    this.tout = paramTextPaneWriter;
    this.document = paramReplDocument;
    this.style = paramAttributeSet;
  }
  
  public void print(Object paramObject)
  {
    if ((paramObject instanceof Component))
    {
      write((Component)paramObject);
      return;
    }
    SimpleAttributeSet localSimpleAttributeSet;
    if ((paramObject instanceof Paintable))
    {
      localSimpleAttributeSet = new SimpleAttributeSet();
      localSimpleAttributeSet.addAttribute("$ename", "Paintable");
      localSimpleAttributeSet.addAttribute(ReplPane.PaintableAttribute, paramObject);
      write(" ", localSimpleAttributeSet);
      return;
    }
    if ((paramObject instanceof Viewable))
    {
      localSimpleAttributeSet = new SimpleAttributeSet();
      localSimpleAttributeSet.addAttribute("$ename", "Viewable");
      localSimpleAttributeSet.addAttribute(ReplPane.ViewableAttribute, paramObject);
      write(" ", localSimpleAttributeSet);
      return;
    }
    super.print(paramObject);
  }
  
  public void write(Component paramComponent)
  {
    try
    {
      SimpleAttributeSet localSimpleAttributeSet = new SimpleAttributeSet();
      StyleConstants.setComponent(localSimpleAttributeSet, paramComponent);
      write(" ", localSimpleAttributeSet);
      return;
    }
    finally
    {
      paramComponent = finally;
      throw paramComponent;
    }
  }
  
  public void write(String paramString, MutableAttributeSet paramMutableAttributeSet)
  {
    flush();
    this.document.write(paramString, paramMutableAttributeSet);
    setColumnNumber(1);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\ReplPaneOutPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */