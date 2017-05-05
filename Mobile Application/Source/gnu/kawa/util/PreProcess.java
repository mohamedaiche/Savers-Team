package gnu.kawa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class PreProcess
{
  static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
  static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
  static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android";
  static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer";
  static String[] version_features = { "java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 +JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer +use:java.dyn -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer" };
  String filename;
  Hashtable keywords = new Hashtable();
  int lineno;
  byte[] resultBuffer;
  int resultLength;
  
  public static void main(String[] paramArrayOfString)
  {
    PreProcess localPreProcess = new PreProcess();
    localPreProcess.keywords.put("true", Boolean.TRUE);
    localPreProcess.keywords.put("false", Boolean.FALSE);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localPreProcess.handleArg(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  void error(String paramString)
  {
    System.err.println(this.filename + ':' + this.lineno + ": " + paramString);
    System.exit(-1);
  }
  
  public void filter(String paramString)
    throws Throwable
  {
    if (filter(paramString, new BufferedInputStream(new FileInputStream(paramString))))
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      localFileOutputStream.write(this.resultBuffer, 0, this.resultLength);
      localFileOutputStream.close();
      System.err.println("Pre-processed " + paramString);
    }
  }
  
  public boolean filter(String paramString, BufferedInputStream paramBufferedInputStream)
    throws Throwable
  {
    this.filename = paramString;
    boolean bool1 = false;
    Object localObject2 = new byte['ߐ'];
    int j = 0;
    int i5 = 0;
    int m = -1;
    int i8 = 0;
    this.lineno = 1;
    int i4 = -1;
    int i = 0;
    int i3 = 0;
    int i2 = 0;
    Object localObject3 = null;
    int n = 0;
    int i6;
    Object localObject1;
    for (;;)
    {
      i6 = paramBufferedInputStream.read();
      if (i6 < 0)
      {
        localObject1 = localObject2;
        label64:
        if (i3 != 0)
        {
          this.lineno = i8;
          error("unterminated " + (String)localObject3);
        }
        this.resultBuffer = ((byte[])localObject1);
        this.resultLength = j;
        return bool1;
      }
      localObject1 = localObject2;
      if (j + 10 >= localObject2.length)
      {
        localObject1 = new byte[j * 2];
        System.arraycopy(localObject2, 0, localObject1, 0, j);
      }
      if ((i6 != 10) || (j <= 0) || (localObject1[(j - 1)] != 13)) {
        break;
      }
      localObject1[j] = ((byte)i6);
      j += 1;
      localObject2 = localObject1;
    }
    int k;
    if ((i4 >= 0) && (m < 0) && (n <= 0) && (i6 != 13) && (i6 != 10) && ((i4 == i) || ((i6 != 32) && (i6 != 9)))) {
      if (i6 == 47)
      {
        paramBufferedInputStream.mark(100);
        k = paramBufferedInputStream.read();
        if (k == 47)
        {
          k = 0;
          label271:
          paramBufferedInputStream.reset();
          label275:
          if (k == 0) {
            break label1732;
          }
          k = j + 1;
          localObject1[j] = 47;
          n = k + 1;
          localObject1[k] = 47;
          j = n + 1;
          localObject1[n] = 32;
          k = 1;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      n = i6;
      boolean bool2 = bool1;
      int i7 = k;
      int i1 = m;
      if (i6 != 32)
      {
        n = i6;
        bool2 = bool1;
        i7 = k;
        i1 = m;
        if (i6 != 9)
        {
          n = i6;
          bool2 = bool1;
          i7 = k;
          i1 = m;
          if (m < 0)
          {
            m = j;
            n = i6;
            bool2 = bool1;
            i7 = k;
            i1 = m;
            if (i3 > 0)
            {
              n = i6;
              bool2 = bool1;
              i7 = k;
              i1 = m;
              if (i4 != i)
              {
                n = i6;
                bool2 = bool1;
                i7 = k;
                i1 = m;
                if (i6 == 47)
                {
                  i6 = paramBufferedInputStream.read();
                  if (i6 < 0)
                  {
                    break label64;
                    if (k == 42)
                    {
                      do
                      {
                        k = paramBufferedInputStream.read();
                      } while ((k == 32) || (k == 9));
                      if (k != 35) {}
                      for (k = 1;; k = 0) {
                        break;
                      }
                    }
                    k = 1;
                    break label271;
                    k = 1;
                    break label275;
                  }
                  if (i6 != 47)
                  {
                    n = j + 1;
                    localObject1[j] = 47;
                    j = n;
                    i1 = m;
                    bool2 = bool1;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        label566:
        localObject1[j] = ((byte)i6);
        i7 = j + 1;
        if ((i6 == 13) || (i6 == 10))
        {
          k = -1;
          n = 0;
          j = i5;
          i5 = k;
          for (;;)
          {
            if (j < i7 - 1)
            {
              m = i5;
              k = n;
              if (localObject1[j] != 32)
              {
                m = i5;
                k = n;
                if (localObject1[j] != 9)
                {
                  n = j;
                  m = i5;
                  k = n;
                  if (i5 < 0)
                  {
                    m = j;
                    k = n;
                  }
                }
              }
              j += 1;
              i5 = m;
              n = k;
              continue;
              i6 = paramBufferedInputStream.read();
              if (i6 < 0) {
                break;
              }
              k = -1;
              boolean bool3 = true;
              bool1 = true;
              n = i6;
              bool2 = bool3;
              i7 = k;
              i1 = m;
              if (i6 != 32) {
                break label1721;
              }
              i6 = paramBufferedInputStream.read();
              if (i6 != 32)
              {
                n = i6;
                bool2 = bool3;
                i7 = k;
                i1 = m;
                if (i6 != 9) {
                  break label1721;
                }
              }
              i1 = -1;
              bool2 = bool1;
              break label566;
            }
          }
          Object localObject4 = localObject3;
          m = i8;
          j = i4;
          i1 = i3;
          k = i2;
          Object localObject5;
          if (n - i5 >= 4)
          {
            localObject4 = localObject3;
            m = i8;
            j = i4;
            i1 = i3;
            k = i2;
            if (localObject1[i5] == 47)
            {
              localObject4 = localObject3;
              m = i8;
              j = i4;
              i1 = i3;
              k = i2;
              if (localObject1[(i5 + 1)] == 42)
              {
                localObject4 = localObject3;
                m = i8;
                j = i4;
                i1 = i3;
                k = i2;
                if (localObject1[(n - 1)] == 42)
                {
                  localObject4 = localObject3;
                  m = i8;
                  j = i4;
                  i1 = i3;
                  k = i2;
                  if (localObject1[n] == 47)
                  {
                    i5 += 2;
                    while ((i5 < n) && (localObject1[i5] == 32)) {
                      i5 += 1;
                    }
                    n -= 2;
                    while ((n > i5) && (localObject1[n] == 32)) {
                      n -= 1;
                    }
                    localObject4 = localObject3;
                    m = i8;
                    j = i4;
                    i1 = i3;
                    k = i2;
                    if (localObject1[i5] == 35)
                    {
                      localObject5 = new String((byte[])localObject1, i5, n - i5 + 1, "ISO-8859-1");
                      j = ((String)localObject5).indexOf(' ');
                      i6 = this.lineno;
                      if (j <= 0) {
                        break label1276;
                      }
                      localObject2 = ((String)localObject5).substring(0, j);
                      localObject4 = ((String)localObject5).substring(j).trim();
                      localObject3 = this.keywords.get(localObject4);
                      label1109:
                      if ((!"#ifdef".equals(localObject2)) && (!"#ifndef".equals(localObject2))) {
                        break label1376;
                      }
                      localObject5 = localObject3;
                      if (localObject3 == null)
                      {
                        System.err.println(paramString + ":" + this.lineno + ": warning - undefined keyword: " + (String)localObject4);
                        localObject5 = Boolean.FALSE;
                      }
                      n = i3 + 1;
                      if (i2 <= 0) {
                        break label1290;
                      }
                      k = i2;
                      i1 = n;
                      j = i;
                      m = i6;
                      localObject4 = localObject2;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            i5 = i7;
            i2 = -1;
            i = 0;
            this.lineno += 1;
            n = 0;
            localObject2 = localObject1;
            bool1 = bool2;
            localObject3 = localObject4;
            i8 = m;
            i4 = j;
            m = i2;
            j = i7;
            i3 = i1;
            i2 = k;
            break;
            label1276:
            localObject2 = localObject5;
            localObject4 = "";
            localObject3 = null;
            break label1109;
            label1290:
            if (((String)localObject2).charAt(3) == 'n')
            {
              i3 = 1;
              label1304:
              if (localObject5 != Boolean.FALSE) {
                break label1370;
              }
            }
            label1370:
            for (i5 = 1;; i5 = 0)
            {
              localObject4 = localObject2;
              m = i6;
              j = i4;
              i1 = n;
              k = i2;
              if (i3 == i5) {
                break;
              }
              k = n;
              localObject4 = localObject2;
              m = i6;
              j = i;
              i1 = n;
              break;
              i3 = 0;
              break label1304;
            }
            label1376:
            if ("#else".equals(localObject2))
            {
              if (i3 == 0)
              {
                error("unexpected " + (String)localObject2);
                localObject4 = localObject2;
                m = i6;
                j = i4;
                i1 = i3;
                k = i2;
              }
              else if (i3 == i2)
              {
                j = -1;
                k = 0;
                localObject4 = localObject2;
                m = i6;
                i1 = i3;
              }
              else
              {
                localObject4 = localObject2;
                m = i6;
                j = i;
                i1 = i3;
                k = i2;
                if (i2 == 0)
                {
                  k = i3;
                  localObject4 = localObject2;
                  m = i6;
                  j = i;
                  i1 = i3;
                }
              }
            }
            else
            {
              if ("#endif".equals(localObject2))
              {
                if (i3 == 0) {
                  error("unexpected " + (String)localObject2);
                }
                if (i3 == i2)
                {
                  k = 0;
                  j = -1;
                }
                for (;;)
                {
                  i1 = i3 - 1;
                  localObject4 = localObject2;
                  m = i6;
                  break;
                  j = i4;
                  k = i2;
                  if (i2 > 0)
                  {
                    j = i;
                    k = i2;
                  }
                }
              }
              error("unknown command: " + (String)localObject5);
              localObject4 = localObject2;
              m = i6;
              j = i4;
              i1 = i3;
              k = i2;
            }
          }
        }
        localObject2 = localObject1;
        bool1 = bool2;
        n = k;
        m = i1;
        j = i7;
        if (i1 >= 0) {
          break;
        }
        if (i6 == 9) {
          i = i + 8 & 0xFFFFFFF8;
        }
        for (;;)
        {
          localObject2 = localObject1;
          bool1 = bool2;
          n = k;
          m = i1;
          j = i7;
          break;
          i += 1;
        }
        label1721:
        i6 = n;
        k = i7;
      }
      label1732:
      k = n;
    }
  }
  
  void handleArg(String paramString)
  {
    int i = 1;
    Object localObject;
    if (paramString.charAt(0) == '%')
    {
      paramString = paramString.substring(1);
      i = 0;
      for (;;)
      {
        if (i >= version_features.length)
        {
          System.err.println("Unknown version: " + paramString);
          System.exit(-1);
        }
        if (paramString.equals(version_features[i]))
        {
          localObject = version_features[(i + 1)];
          System.err.println("(variant " + paramString + " maps to: " + (String)localObject + ")");
          paramString = new StringTokenizer((String)localObject);
          while (paramString.hasMoreTokens()) {
            handleArg(paramString.nextToken());
          }
        }
        i += 2;
      }
    }
    if (paramString.charAt(0) == '+')
    {
      this.keywords.put(paramString.substring(1), Boolean.TRUE);
      return;
    }
    if (paramString.charAt(0) == '-')
    {
      int j = paramString.indexOf('=');
      if (j > 1)
      {
        if (paramString.charAt(1) == '-') {
          i = 2;
        }
        String str1 = paramString.substring(i, j);
        String str2 = paramString.substring(j + 1);
        localObject = Boolean.FALSE;
        if (str2.equalsIgnoreCase("true")) {
          paramString = Boolean.TRUE;
        }
        for (;;)
        {
          this.keywords.put(str1, paramString);
          return;
          paramString = (String)localObject;
          if (!str2.equalsIgnoreCase("false"))
          {
            System.err.println("invalid value " + str2 + " for " + str1);
            System.exit(-1);
            paramString = (String)localObject;
          }
        }
      }
      this.keywords.put(paramString.substring(1), Boolean.FALSE);
      return;
    }
    try
    {
      filter(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      System.err.println("caught " + paramString);
      paramString.printStackTrace();
      System.exit(-1);
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\util\PreProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */