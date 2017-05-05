package gnu.kawa.swingviews;

import javax.swing.text.BadLocationException;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

class GapUndoableEdit
  extends AbstractUndoableEdit
{
  SwingContent content;
  String data;
  boolean isInsertion;
  int nitems;
  int startOffset;
  
  GapUndoableEdit(int paramInt)
  {
    this.startOffset = paramInt;
  }
  
  private void doit(boolean paramBoolean)
    throws BadLocationException
  {
    if (paramBoolean)
    {
      this.content.insertString(this.startOffset, this.data);
      return;
    }
    this.content.remove(this.startOffset, this.nitems);
  }
  
  public void redo()
    throws CannotUndoException
  {
    super.redo();
    try
    {
      doit(this.isInsertion);
      return;
    }
    catch (BadLocationException localBadLocationException)
    {
      throw new CannotRedoException();
    }
  }
  
  /* Error */
  public void undo()
    throws CannotUndoException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	javax/swing/undo/AbstractUndoableEdit:undo	()V
    //   4: aload_0
    //   5: getfield 49	gnu/kawa/swingviews/GapUndoableEdit:isInsertion	Z
    //   8: ifne +11 -> 19
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: iload_1
    //   15: invokespecial 51	gnu/kawa/swingviews/GapUndoableEdit:doit	(Z)V
    //   18: return
    //   19: iconst_0
    //   20: istore_1
    //   21: goto -8 -> 13
    //   24: astore_2
    //   25: new 45	javax/swing/undo/CannotUndoException
    //   28: dup
    //   29: invokespecial 58	javax/swing/undo/CannotUndoException:<init>	()V
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	GapUndoableEdit
    //   12	9	1	bool	boolean
    //   24	1	2	localBadLocationException	BadLocationException
    // Exception table:
    //   from	to	target	type
    //   4	11	24	javax/swing/text/BadLocationException
    //   13	18	24	javax/swing/text/BadLocationException
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\GapUndoableEdit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */