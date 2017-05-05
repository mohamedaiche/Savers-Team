package kawa;

import gnu.kawa.swingviews.SwingContent;
import gnu.lists.CharBuffer;
import gnu.mapping.OutPort;
import gnu.text.QueueReader;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.EditorKit;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;

public class ReplPane
  extends JTextPane
  implements KeyListener
{
  public static final Object PaintableAttribute = new String("Paintable");
  public static final String PaintableElementName = "Paintable";
  public static final Object ViewableAttribute = new String("Viewable");
  public static final String ViewableElementName = "Viewable";
  ReplDocument document;
  
  public ReplPane(ReplDocument paramReplDocument)
  {
    super(paramReplDocument);
    this.document = paramReplDocument;
    paramReplDocument.pane = this;
    paramReplDocument.paneCount += 1;
    addKeyListener(this);
    addFocusListener(paramReplDocument);
    getEditorKit();
    setCaretPosition(paramReplDocument.outputMark);
  }
  
  protected EditorKit createDefaultEditorKit()
  {
    return new ReplEditorKit(this);
  }
  
  void enter()
  {
    int m = getCaretPosition();
    ??? = this.document.content.buffer;
    int k = ((CharBuffer)???).length() - 1;
    this.document.endMark = -1;
    int j;
    int i;
    if (m >= this.document.outputMark)
    {
      j = ((CharBuffer)???).indexOf(10, m);
      i = j;
      if (j == k)
      {
        if ((k <= this.document.outputMark) || (((CharBuffer)???).charAt(k - 1) != '\n')) {
          break label138;
        }
        i = j - 1;
      }
      for (;;)
      {
        this.document.endMark = i;
        synchronized (this.document.in_r)
        {
          this.document.in_r.notifyAll();
          if (m <= i) {
            setCaretPosition(i + 1);
          }
          return;
          label138:
          this.document.insertString(k, "\n", null);
          i = j;
        }
      }
    }
    if (m == 0)
    {
      i = 0;
      label169:
      Element localElement = this.document.getCharacterElement(i);
      j = ((CharBuffer)???).indexOf(10, m);
      if (localElement.getAttributes().isEqual(ReplDocument.promptStyle)) {
        i = localElement.getEndOffset();
      }
      if (j >= 0) {
        break label316;
      }
    }
    label316:
    for (??? = ((CharBuffer)???).substring(i, k) + '\n';; ??? = ((CharBuffer)???).substring(i, j + 1))
    {
      setCaretPosition(this.document.outputMark);
      this.document.write((String)???, ReplDocument.inputStyle);
      if (this.document.in_r == null) {
        break;
      }
      this.document.in_r.append((CharSequence)???, 0, ((String)???).length());
      return;
      i = ((CharBuffer)???).lastIndexOf(10, m - 1) + 1;
      break label169;
    }
  }
  
  public MutableAttributeSet getInputAttributes()
  {
    return ReplDocument.inputStyle;
  }
  
  public OutPort getStderr()
  {
    return this.document.err_stream;
  }
  
  public OutPort getStdout()
  {
    return this.document.out_stream;
  }
  
  public void keyPressed(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 10)
    {
      enter();
      paramKeyEvent.consume();
    }
  }
  
  public void keyReleased(KeyEvent paramKeyEvent) {}
  
  public void keyTyped(KeyEvent paramKeyEvent) {}
  
  public void removeNotify()
  {
    super.removeNotify();
    ReplDocument localReplDocument = this.document;
    int i = localReplDocument.paneCount - 1;
    localReplDocument.paneCount = i;
    if (i == 0) {
      this.document.close();
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\ReplPane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */