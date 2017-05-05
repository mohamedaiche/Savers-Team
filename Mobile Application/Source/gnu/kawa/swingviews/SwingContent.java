package gnu.kawa.swingviews;

import gnu.lists.CharBuffer;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.undo.UndoableEdit;

public class SwingContent
  implements AbstractDocument.Content
{
  public final CharBuffer buffer;
  
  public SwingContent()
  {
    this(100);
  }
  
  public SwingContent(int paramInt)
  {
    CharBuffer localCharBuffer = new CharBuffer(paramInt);
    localCharBuffer.gapEnd = (paramInt - 1);
    localCharBuffer.getArray()[localCharBuffer.gapEnd] = 10;
    this.buffer = localCharBuffer;
  }
  
  public SwingContent(CharBuffer paramCharBuffer)
  {
    this.buffer = paramCharBuffer;
  }
  
  public Position createPosition(int paramInt)
    throws BadLocationException
  {
    CharBuffer localCharBuffer = this.buffer;
    if ((paramInt < 0) || (paramInt > localCharBuffer.length())) {
      throw new BadLocationException("bad offset to createPosition", paramInt);
    }
    return new GapPosition(localCharBuffer, paramInt);
  }
  
  public void getChars(int paramInt1, int paramInt2, Segment paramSegment)
    throws BadLocationException
  {
    CharBuffer localCharBuffer = this.buffer;
    int i = localCharBuffer.getSegment(paramInt1, paramInt2);
    if (i < 0) {
      throw new BadLocationException("invalid offset", paramInt1);
    }
    paramSegment.offset = i;
    paramSegment.array = localCharBuffer.getArray();
    paramSegment.count = paramInt2;
  }
  
  public String getString(int paramInt1, int paramInt2)
    throws BadLocationException
  {
    CharBuffer localCharBuffer = this.buffer;
    int i = localCharBuffer.getSegment(paramInt1, paramInt2);
    if (i < 0) {
      throw new BadLocationException("invalid offset", paramInt1);
    }
    return new String(localCharBuffer.getArray(), i, paramInt2);
  }
  
  public UndoableEdit insertString(int paramInt, String paramString)
    throws BadLocationException
  {
    return insertString(paramInt, paramString, false);
  }
  
  public UndoableEdit insertString(int paramInt, String paramString, boolean paramBoolean)
    throws BadLocationException
  {
    Object localObject = this.buffer;
    if ((paramInt < 0) || (paramInt > ((CharBuffer)localObject).length())) {
      throw new BadLocationException("bad insert", paramInt);
    }
    ((CharBuffer)localObject).insert(paramInt, paramString, paramBoolean);
    localObject = new GapUndoableEdit(paramInt);
    ((GapUndoableEdit)localObject).content = this;
    ((GapUndoableEdit)localObject).data = paramString;
    ((GapUndoableEdit)localObject).nitems = paramString.length();
    ((GapUndoableEdit)localObject).isInsertion = true;
    return (UndoableEdit)localObject;
  }
  
  public int length()
  {
    return this.buffer.length();
  }
  
  public UndoableEdit remove(int paramInt1, int paramInt2)
    throws BadLocationException
  {
    CharBuffer localCharBuffer = this.buffer;
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 + paramInt2 > localCharBuffer.length())) {
      throw new BadLocationException("invalid remove", paramInt1);
    }
    localCharBuffer.delete(paramInt1, paramInt2);
    GapUndoableEdit localGapUndoableEdit = new GapUndoableEdit(paramInt1);
    localGapUndoableEdit.content = this;
    localGapUndoableEdit.data = new String(localCharBuffer.getArray(), localCharBuffer.gapEnd - paramInt2, paramInt2);
    localGapUndoableEdit.nitems = paramInt2;
    localGapUndoableEdit.isInsertion = false;
    return localGapUndoableEdit;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\SwingContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */