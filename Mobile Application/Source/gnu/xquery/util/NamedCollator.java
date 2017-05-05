package gnu.xquery.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.CollationKey;
import java.text.Collator;

public class NamedCollator
  extends Collator
  implements Externalizable
{
  public static final String UNICODE_CODEPOINT_COLLATION = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
  public static final NamedCollator codepointCollation = new NamedCollator();
  Collator collator;
  String name;
  
  static
  {
    codepointCollation.name = "http://www.w3.org/2005/xpath-functions/collation/codepoint";
  }
  
  public static int codepointCompare(String paramString1, String paramString2)
  {
    int i2 = paramString1.length();
    int i3 = paramString2.length();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i == i2)
      {
        if (j == i3) {}
        for (i = 0;; i = -1) {
          return i;
        }
      }
      if (j == i3) {
        return 1;
      }
      int m = i + 1;
      int n = paramString1.charAt(i);
      int k = n;
      i = m;
      if (n >= 55296)
      {
        k = n;
        i = m;
        if (n < 56320)
        {
          k = n;
          i = m;
          if (m < i2)
          {
            k = (n - 55296) * 1024 + (paramString1.charAt(m) - 56320) + 65536;
            i = m + 1;
          }
        }
      }
      n = j + 1;
      int i1 = paramString2.charAt(j);
      m = i1;
      j = n;
      if (i1 >= 55296)
      {
        m = i1;
        j = n;
        if (i1 < 56320)
        {
          m = i1;
          j = n;
          if (n < i3)
          {
            m = (i1 - 55296) * 1024 + (paramString2.charAt(n) - 56320) + 65536;
            j = n + 1;
          }
        }
      }
      if (k != m)
      {
        if (k < m) {
          return -1;
        }
        return 1;
      }
    }
  }
  
  public static NamedCollator find(String paramString)
  {
    return make(paramString);
  }
  
  public static NamedCollator make(String paramString)
  {
    NamedCollator localNamedCollator = new NamedCollator();
    localNamedCollator.name = paramString;
    localNamedCollator.resolve();
    return localNamedCollator;
  }
  
  public int compare(String paramString1, String paramString2)
  {
    if (this.collator != null) {
      return this.collator.compare(paramString1, paramString2);
    }
    return codepointCompare(paramString1, paramString2);
  }
  
  public CollationKey getCollationKey(String paramString)
  {
    return this.collator.getCollationKey(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    if (this.collator != null) {
      return this.collator.hashCode();
    }
    return 0;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = paramObjectInput.readUTF();
    resolve();
  }
  
  public void resolve()
  {
    if ((this.name != null) && (!this.name.equals("http://www.w3.org/2005/xpath-functions/collation/codepoint"))) {
      throw new RuntimeException("unknown collation: " + this.name);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.name);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\NamedCollator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */