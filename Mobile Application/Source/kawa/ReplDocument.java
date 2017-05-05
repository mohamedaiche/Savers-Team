package kawa;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.swingviews.SwingContent;
import gnu.lists.CharBuffer;
import gnu.mapping.Environment;
import gnu.mapping.Future;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.text.QueueReader;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ReplDocument
  extends DefaultStyledDocument
  implements DocumentListener, FocusListener
{
  static Style blueStyle;
  public static Style defaultStyle;
  public static Style inputStyle;
  static Style promptStyle;
  public static Style redStyle;
  public static StyleContext styles = new StyleContext();
  Object closeListeners;
  SwingContent content;
  public int endMark = -1;
  Environment environment;
  final ReplPaneOutPort err_stream;
  final GuiInPort in_p;
  final QueueReader in_r;
  Language language;
  int length = 0;
  final ReplPaneOutPort out_stream;
  public int outputMark = 0;
  JTextPane pane;
  int paneCount;
  Future thread;
  
  static
  {
    defaultStyle = styles.addStyle("default", null);
    inputStyle = styles.addStyle("input", null);
    redStyle = styles.addStyle("red", null);
    blueStyle = styles.addStyle("blue", null);
    promptStyle = styles.addStyle("prompt", null);
    StyleConstants.setForeground(redStyle, Color.red);
    StyleConstants.setForeground(blueStyle, Color.blue);
    StyleConstants.setForeground(promptStyle, Color.green);
    StyleConstants.setBold(inputStyle, true);
  }
  
  public ReplDocument(Language paramLanguage, Environment paramEnvironment, boolean paramBoolean)
  {
    this(new SwingContent(), paramLanguage, paramEnvironment, paramBoolean);
  }
  
  private ReplDocument(SwingContent paramSwingContent, Language paramLanguage, Environment paramEnvironment, final boolean paramBoolean)
  {
    super(paramSwingContent, styles);
    this.content = paramSwingContent;
    ModuleBody.exitIncrement();
    addDocumentListener(this);
    this.language = paramLanguage;
    this.in_r = new QueueReader()
    {
      public void checkAvailable()
      {
        ReplDocument.this.checkingPendingInput();
      }
    };
    this.out_stream = new ReplPaneOutPort(this, "/dev/stdout", defaultStyle);
    this.err_stream = new ReplPaneOutPort(this, "/dev/stderr", redStyle);
    this.in_p = new GuiInPort(this.in_r, Path.valueOf("/dev/stdin"), this.out_stream, this);
    this.thread = Future.make(new repl(paramLanguage)
    {
      public Object apply0()
      {
        Environment localEnvironment = Environment.getCurrent();
        if (paramBoolean) {
          localEnvironment.setIndirectDefines();
        }
        ReplDocument.this.environment = localEnvironment;
        Shell.run(this.language, localEnvironment);
        SwingUtilities.invokeLater(new Runnable()
        {
          public void run()
          {
            ReplDocument.this.fireDocumentClosed();
          }
        });
        return Values.empty;
      }
    }, paramEnvironment, this.in_p, this.out_stream, this.err_stream);
    this.thread.start();
  }
  
  public void addDocumentCloseListener(DocumentCloseListener paramDocumentCloseListener)
  {
    if (this.closeListeners == null)
    {
      this.closeListeners = paramDocumentCloseListener;
      return;
    }
    ArrayList localArrayList;
    if ((this.closeListeners instanceof ArrayList)) {
      localArrayList = (ArrayList)this.closeListeners;
    }
    for (;;)
    {
      localArrayList.add(paramDocumentCloseListener);
      return;
      localArrayList = new ArrayList(10);
      localArrayList.add(this.closeListeners);
      this.closeListeners = localArrayList;
    }
  }
  
  public void changedUpdate(DocumentEvent paramDocumentEvent)
  {
    textValueChanged(paramDocumentEvent);
  }
  
  public void checkingPendingInput()
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        int i = ReplDocument.this.outputMark;
        if (i <= ReplDocument.this.endMark)
        {
          CharBuffer localCharBuffer = ReplDocument.this.content.buffer;
          int j = localCharBuffer.indexOf(10, i);
          if (j == ReplDocument.this.endMark) {
            ReplDocument.this.endMark = -1;
          }
          if (i == ReplDocument.this.outputMark) {
            ReplDocument.this.outputMark = (j + 1);
          }
          if (ReplDocument.this.in_r != null) {
            synchronized (ReplDocument.this.in_r)
            {
              ReplDocument.this.in_r.append(localCharBuffer, i, j + 1);
              ReplDocument.this.in_r.notifyAll();
              return;
            }
          }
        }
      }
    });
  }
  
  void close()
  {
    this.in_r.appendEOF();
    try
    {
      Thread.sleep(100L);
      this.thread.stop();
      fireDocumentClosed();
      ModuleBody.exitDecrement();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void deleteOldText()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iconst_0
    //   6: aload_0
    //   7: getfield 119	kawa/ReplDocument:outputMark	I
    //   10: invokevirtual 241	kawa/ReplDocument:getText	(II)Ljava/lang/String;
    //   13: astore_2
    //   14: aload_0
    //   15: getfield 119	kawa/ReplDocument:outputMark	I
    //   18: ifgt +12 -> 30
    //   21: aload_0
    //   22: iconst_0
    //   23: iload_1
    //   24: invokevirtual 245	kawa/ReplDocument:remove	(II)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_2
    //   31: bipush 10
    //   33: aload_0
    //   34: getfield 119	kawa/ReplDocument:outputMark	I
    //   37: iconst_1
    //   38: isub
    //   39: invokevirtual 251	java/lang/String:lastIndexOf	(II)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: goto -26 -> 21
    //   50: astore_2
    //   51: new 253	java/lang/Error
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 256	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	ReplDocument
    //   1	46	1	i	int
    //   13	18	2	str	String
    //   50	6	2	localBadLocationException	BadLocationException
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	21	50	javax/swing/text/BadLocationException
    //   21	27	50	javax/swing/text/BadLocationException
    //   30	43	50	javax/swing/text/BadLocationException
    //   4	21	60	finally
    //   21	27	60	finally
    //   30	43	60	finally
    //   51	60	60	finally
  }
  
  void fireDocumentClosed()
  {
    if ((this.closeListeners instanceof DocumentCloseListener)) {
      ((DocumentCloseListener)this.closeListeners).closed(this);
    }
    while (this.closeListeners == null) {
      return;
    }
    ArrayList localArrayList = (ArrayList)this.closeListeners;
    int i = localArrayList.size();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      ((DocumentCloseListener)localArrayList.get(i)).closed(this);
    }
  }
  
  public void focusGained(FocusEvent paramFocusEvent)
  {
    paramFocusEvent = paramFocusEvent.getSource();
    if ((paramFocusEvent instanceof ReplPane))
    {
      this.pane = ((ReplPane)paramFocusEvent);
      if (!(paramFocusEvent instanceof ReplPane)) {
        break label46;
      }
    }
    label46:
    for (paramFocusEvent = (ReplPane)paramFocusEvent;; paramFocusEvent = null)
    {
      this.pane = paramFocusEvent;
      return;
      this.pane = null;
      break;
    }
  }
  
  public void focusLost(FocusEvent paramFocusEvent)
  {
    this.pane = null;
  }
  
  public void insertString(int paramInt, String paramString, AttributeSet paramAttributeSet)
  {
    try
    {
      super.insertString(paramInt, paramString, paramAttributeSet);
      return;
    }
    catch (BadLocationException paramString)
    {
      throw new Error(paramString);
    }
  }
  
  public void insertUpdate(DocumentEvent paramDocumentEvent)
  {
    textValueChanged(paramDocumentEvent);
  }
  
  public void removeDocumentCloseListener(DocumentCloseListener paramDocumentCloseListener)
  {
    if ((this.closeListeners instanceof DocumentCloseListener)) {
      if (this.closeListeners == paramDocumentCloseListener) {
        this.closeListeners = null;
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (this.closeListeners == null);
      localArrayList = (ArrayList)this.closeListeners;
      int i = localArrayList.size();
      for (;;)
      {
        int j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
        if (localArrayList.get(j) == paramDocumentCloseListener)
        {
          localArrayList.remove(j);
          i = j;
        }
      }
    } while (localArrayList.size() != 0);
    this.closeListeners = null;
  }
  
  public void removeUpdate(DocumentEvent paramDocumentEvent)
  {
    textValueChanged(paramDocumentEvent);
  }
  
  public void textValueChanged(DocumentEvent paramDocumentEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        i = paramDocumentEvent.getOffset();
        int j = getLength() - this.length;
        this.length += j;
        if (i < this.outputMark)
        {
          this.outputMark += j;
          if (this.endMark >= 0)
          {
            if (i >= this.endMark) {
              break label98;
            }
            this.endMark += j;
          }
        }
        else
        {
          if (i - j >= this.outputMark) {
            continue;
          }
          this.outputMark = i;
          continue;
        }
        if (i - j >= this.endMark) {
          continue;
        }
      }
      finally {}
      label98:
      this.endMark = i;
    }
  }
  
  public void write(final String paramString, final AttributeSet paramAttributeSet)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        if ((ReplDocument.this.pane != null) && (ReplDocument.this.pane.getCaretPosition() == ReplDocument.this.outputMark)) {}
        for (int i = 1;; i = 0)
        {
          ReplDocument.this.insertString(ReplDocument.this.outputMark, paramString, paramAttributeSet);
          int j = paramString.length();
          ReplDocument localReplDocument = ReplDocument.this;
          localReplDocument.outputMark += j;
          if (i != 0) {
            ReplDocument.this.pane.setCaretPosition(ReplDocument.this.outputMark);
          }
          return;
        }
      }
    });
  }
  
  public static abstract interface DocumentCloseListener
  {
    public abstract void closed(ReplDocument paramReplDocument);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\ReplDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */