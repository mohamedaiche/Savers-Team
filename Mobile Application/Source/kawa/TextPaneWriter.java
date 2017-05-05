package kawa;

import java.io.Writer;
import javax.swing.text.AttributeSet;

class TextPaneWriter
  extends Writer
{
  ReplDocument document;
  String str = "";
  AttributeSet style;
  
  public TextPaneWriter(ReplDocument paramReplDocument, AttributeSet paramAttributeSet)
  {
    this.document = paramReplDocument;
    this.style = paramAttributeSet;
  }
  
  public void close()
  {
    flush();
  }
  
  public void flush()
  {
    try
    {
      String str1 = this.str;
      if (!str1.equals(""))
      {
        this.str = "";
        write(str1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      this.str += (char)paramInt;
      if (paramInt == 10) {
        flush();
      }
      return;
    }
    finally {}
  }
  
  public void write(String paramString)
  {
    this.document.write(paramString, this.style);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    try
    {
      flush();
      if (paramInt2 != 0) {
        write(new String(paramArrayOfChar, paramInt1, paramInt2));
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\TextPaneWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */