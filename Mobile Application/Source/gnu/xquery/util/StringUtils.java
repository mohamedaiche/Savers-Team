package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XIntegerType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import gnu.text.URIPath;
import gnu.xml.TextUtils;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  private static String ERROR_VALUE = "<error>";
  
  private static void appendCodepoint(Object paramObject, StringBuffer paramStringBuffer)
  {
    int j = ((IntNum)XIntegerType.integerType.cast(paramObject)).intValue();
    if ((j <= 0) || ((j > 55295) && ((j < 57344) || ((j > 65533) && (j < 65536)) || (j > 1114111)))) {
      throw new IllegalArgumentException("codepoints-to-string: " + j + " is not a valid XML character [FOCH0001]");
    }
    int i = j;
    if (j >= 65536)
    {
      paramStringBuffer.append((char)((j - 65536 >> 10) + 55296));
      i = (j & 0x3FF) + 56320;
    }
    paramStringBuffer.append((char)i);
  }
  
  static double asDouble(Object paramObject)
  {
    Object localObject = paramObject;
    if (!(paramObject instanceof Number)) {
      localObject = NumberValue.numberValue(paramObject);
    }
    return ((Number)localObject).doubleValue();
  }
  
  public static Object codepointEqual(Object paramObject1, Object paramObject2)
  {
    paramObject1 = coerceToString(paramObject1, "codepoint-equal", 1, null);
    paramObject2 = coerceToString(paramObject2, "codepoint-equal", 2, null);
    if ((paramObject1 == null) || (paramObject2 == null)) {
      return Values.empty;
    }
    if (((String)paramObject1).equals(paramObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static String codepointsToString(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramObject instanceof Values))
    {
      paramObject = (Values)paramObject;
      int i = ((Values)paramObject).startPos();
      for (;;)
      {
        i = ((Values)paramObject).nextPos(i);
        if (i == 0) {
          break;
        }
        appendCodepoint(((Values)paramObject).getPosPrevious(i), localStringBuffer);
      }
    }
    appendCodepoint(paramObject, localStringBuffer);
    return localStringBuffer.toString();
  }
  
  static String coerceToString(Object paramObject, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof KNode)) {
      localObject = KNode.atomicValue(paramObject);
    }
    if (((localObject == Values.empty) || (localObject == null)) && (paramString2 != ERROR_VALUE)) {
      return paramString2;
    }
    if (((localObject instanceof UntypedAtomic)) || ((localObject instanceof CharSequence)) || ((localObject instanceof URI)) || ((localObject instanceof Path))) {
      return localObject.toString();
    }
    if (paramString2 == ERROR_VALUE) {}
    for (paramObject = "xs:string";; paramObject = "xs:string?") {
      throw new WrongType(paramString1, paramInt, localObject, (String)paramObject);
    }
  }
  
  public static Object compare(Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator)
  {
    if ((paramObject1 == Values.empty) || (paramObject1 == null) || (paramObject2 == Values.empty) || (paramObject2 == null)) {
      return Values.empty;
    }
    NamedCollator localNamedCollator = paramNamedCollator;
    if (paramNamedCollator == null) {
      localNamedCollator = NamedCollator.codepointCollation;
    }
    int i = localNamedCollator.compare(paramObject1.toString(), paramObject2.toString());
    if (i < 0) {
      return IntNum.minusOne();
    }
    if (i > 0) {
      return IntNum.one();
    }
    return IntNum.zero();
  }
  
  public static String concat$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = TextUtils.stringValue(SequenceUtils.coerceToZeroOrOne(paramObject1, "concat", 1));
    paramObject2 = TextUtils.stringValue(SequenceUtils.coerceToZeroOrOne(paramObject2, "concat", 2));
    paramObject1 = new StringBuilder((String)paramObject1);
    ((StringBuilder)paramObject1).append((String)paramObject2);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)paramObject1).append(TextUtils.stringValue(SequenceUtils.coerceToZeroOrOne(paramArrayOfObject[i], "concat", i + 2)));
      i += 1;
    }
    return ((StringBuilder)paramObject1).toString();
  }
  
  public static Object contains(Object paramObject1, Object paramObject2)
  {
    if (coerceToString(paramObject1, "contains", 1, "").indexOf(coerceToString(paramObject2, "contains", 2, "")) < 0) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static String encodeForUri(Object paramObject)
  {
    return URIPath.encodeForUri(coerceToString(paramObject, "encode-for-uri", 1, ""), 'U');
  }
  
  public static Object endsWith(Object paramObject1, Object paramObject2)
  {
    if (coerceToString(paramObject1, "ends-with", 1, "").endsWith(coerceToString(paramObject2, "ends-with", 2, ""))) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static String escapeHtmlUri(Object paramObject)
  {
    return URIPath.encodeForUri(coerceToString(paramObject, "escape-html-uri", 1, ""), 'H');
  }
  
  public static String iriToUri(Object paramObject)
  {
    return URIPath.encodeForUri(coerceToString(paramObject, "iri-to-uru", 1, ""), 'I');
  }
  
  public static Object lowerCase(Object paramObject)
  {
    return coerceToString(paramObject, "lower-case", 1, "").toLowerCase();
  }
  
  public static Pattern makePattern(String paramString1, String paramString2)
  {
    int i = 0;
    int j = paramString2.length();
    int m;
    char c1;
    int k;
    for (;;)
    {
      int i1 = j - 1;
      if (i1 < 0) {
        break;
      }
      switch (paramString2.charAt(i1))
      {
      default: 
        throw new IllegalArgumentException("unknown 'replace' flag");
      case 'i': 
        i |= 0x42;
        j = i1;
        break;
      case 's': 
        i |= 0x20;
        j = i1;
        break;
      case 'x': 
        StringBuffer localStringBuffer = new StringBuffer();
        int i2 = paramString1.length();
        m = 0;
        j = 0;
        while (j < i2)
        {
          int n = j + 1;
          char c2 = paramString1.charAt(j);
          if ((c2 == '\\') && (n < i2))
          {
            localStringBuffer.append(c2);
            c1 = paramString1.charAt(n);
            k = n + 1;
            j = m;
          }
          do
          {
            do
            {
              for (;;)
              {
                localStringBuffer.append(c1);
                m = j;
                j = k;
                break;
                if (c2 == '[')
                {
                  j = m + 1;
                  k = n;
                  c1 = c2;
                }
                else
                {
                  if (c2 != ']') {
                    break label244;
                  }
                  j = m - 1;
                  k = n;
                  c1 = c2;
                }
              }
              j = m;
              k = n;
              c1 = c2;
            } while (m != 0);
            j = m;
            k = n;
            c1 = c2;
          } while (!Character.isWhitespace(c2));
          j = n;
        }
        paramString1 = localStringBuffer.toString();
        j = i1;
        break;
      case 'm': 
        label244:
        i |= 0x8;
        j = i1;
      }
    }
    paramString2 = paramString1;
    if (paramString1.indexOf("{Is") >= 0)
    {
      paramString2 = new StringBuffer();
      m = paramString1.length();
      j = 0;
      if (j < m)
      {
        k = j + 1;
        c1 = paramString1.charAt(j);
        if ((c1 == '\\') && (k + 4 < m))
        {
          paramString2.append(c1);
          j = k + 1;
          c1 = paramString1.charAt(k);
          paramString2.append(c1);
          if (((c1 != 'p') && (c1 != 'P')) || (paramString1.charAt(j) != '{') || (paramString1.charAt(j + 1) != 'I') || (paramString1.charAt(j + 2) != 's')) {
            break label502;
          }
          paramString2.append('{');
          paramString2.append('I');
          paramString2.append('n');
          j += 3;
        }
      }
    }
    label502:
    for (;;)
    {
      break;
      paramString2.append(c1);
      j = k;
      continue;
      paramString2 = paramString2.toString();
      return Pattern.compile(paramString2, i);
    }
  }
  
  public static boolean matches(Object paramObject, String paramString)
  {
    return matches(paramObject, paramString, "");
  }
  
  public static boolean matches(Object paramObject, String paramString1, String paramString2)
  {
    paramObject = coerceToString(paramObject, "matches", 1, "");
    return makePattern(paramString1, paramString2).matcher((CharSequence)paramObject).find();
  }
  
  public static String normalizeSpace(Object paramObject)
  {
    String str = coerceToString(paramObject, "normalize-space", 1, "");
    int m = str.length();
    paramObject = null;
    int i = 0;
    int k = 0;
    while (k < m)
    {
      char c = str.charAt(k);
      Object localObject;
      if (Character.isWhitespace(c))
      {
        localObject = paramObject;
        if (paramObject == null)
        {
          localObject = paramObject;
          if (i == 0)
          {
            localObject = paramObject;
            if (k > 0) {
              localObject = new StringBuffer(str.substring(0, k));
            }
          }
        }
        i += 1;
        paramObject = localObject;
        k += 1;
      }
      else
      {
        localObject = paramObject;
        int j = i;
        if (i > 0)
        {
          if (paramObject == null) {
            break label153;
          }
          ((StringBuffer)paramObject).append(' ');
        }
        for (;;)
        {
          j = 0;
          localObject = paramObject;
          paramObject = localObject;
          i = j;
          if (localObject == null) {
            break;
          }
          ((StringBuffer)localObject).append(c);
          paramObject = localObject;
          i = j;
          break;
          label153:
          if ((i > 1) || (k == 1) || (str.charAt(k - 1) != ' ')) {
            paramObject = new StringBuffer();
          }
        }
      }
    }
    if (paramObject != null) {
      paramObject = ((StringBuffer)paramObject).toString();
    }
    do
    {
      return (String)paramObject;
      paramObject = str;
    } while (i <= 0);
    return "";
  }
  
  public static Object normalizeUnicode(Object paramObject)
  {
    return normalizeUnicode(paramObject, "NFC");
  }
  
  public static Object normalizeUnicode(Object paramObject, String paramString)
  {
    paramObject = coerceToString(paramObject, "normalize-unicode", 1, "");
    if ("".equals(paramString.trim().toUpperCase())) {
      return paramObject;
    }
    throw new UnsupportedOperationException("normalize-unicode: unicode string normalization not available");
  }
  
  public static String replace(Object paramObject, String paramString1, String paramString2)
  {
    return replace(paramObject, paramString1, paramString2, "");
  }
  
  public static String replace(Object paramObject, String paramString1, String paramString2, String paramString3)
  {
    paramObject = coerceToString(paramObject, "replace", 1, "");
    int k = paramString2.length();
    int i = 0;
    while (i < k)
    {
      int j = i + 1;
      int m = paramString2.charAt(i);
      i = j;
      if (m == 92)
      {
        if (j < m)
        {
          i = paramString2.charAt(j);
          if ((i == 92) || (i == 36)) {}
        }
        else
        {
          throw new IllegalArgumentException("invalid replacement string [FORX0004]");
        }
        i = j + 1;
      }
    }
    return makePattern(paramString1, paramString3).matcher((CharSequence)paramObject).replaceAll(paramString2);
  }
  
  public static Object startsWith(Object paramObject1, Object paramObject2)
  {
    if (coerceToString(paramObject1, "starts-with", 1, "").startsWith(coerceToString(paramObject2, "starts-with", 2, ""))) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object stringJoin(Object paramObject1, Object paramObject2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramObject2 = coerceToString(paramObject2, "string-join", 2, ERROR_VALUE);
    int m = ((String)paramObject2).length();
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k = Values.nextIndex(paramObject1, i);
      if (k < 0) {
        break;
      }
      Object localObject = Values.nextValue(paramObject1, i);
      if (localObject != Values.empty)
      {
        if ((j != 0) && (m > 0)) {
          localStringBuffer.append((String)paramObject2);
        }
        localStringBuffer.append(TextUtils.stringValue(localObject));
        j = 1;
        i = k;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static Object stringLength(Object paramObject)
  {
    paramObject = coerceToString(paramObject, "string-length", 1, "");
    int m = ((String)paramObject).length();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      int k = i + 1;
      int n = ((String)paramObject).charAt(i);
      i = k;
      if (n >= 55296)
      {
        i = k;
        if (n < 56320)
        {
          i = k;
          if (k < m) {
            i = k + 1;
          }
        }
      }
      j += 1;
    }
    return IntNum.make(j);
  }
  
  public static Object stringPad(Object paramObject1, Object paramObject2)
  {
    int j = ((Number)NumberValue.numberValue(paramObject2)).intValue();
    if (j <= 0)
    {
      if (j == 0) {
        return "";
      }
      throw new IndexOutOfBoundsException("Invalid string-pad count");
    }
    paramObject1 = coerceToString(paramObject1, "string-pad", 1, "");
    paramObject2 = new StringBuffer(j * ((String)paramObject1).length());
    int i = 0;
    while (i < j)
    {
      ((StringBuffer)paramObject2).append((String)paramObject1);
      i += 1;
    }
    return ((StringBuffer)paramObject2).toString();
  }
  
  public static void stringToCodepoints$X(Object paramObject, CallContext paramCallContext)
  {
    paramObject = coerceToString(paramObject, "string-to-codepoints", 1, "");
    int n = ((String)paramObject).length();
    paramCallContext = paramCallContext.consumer;
    int i = 0;
    while (i < n)
    {
      int k = i + 1;
      int m = ((String)paramObject).charAt(i);
      int j = m;
      i = k;
      if (m >= 55296)
      {
        j = m;
        i = k;
        if (m < 56320)
        {
          j = m;
          i = k;
          if (k < n)
          {
            j = (m - 55296) * 1024 + (((String)paramObject).charAt(k) - 56320) + 65536;
            i = k + 1;
          }
        }
      }
      paramCallContext.writeInt(j);
    }
  }
  
  public static Object substring(Object paramObject1, Object paramObject2)
  {
    double d = asDouble(paramObject2);
    if (Double.isNaN(d)) {
      return "";
    }
    int j = (int)(d - 0.5D);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramObject1 = coerceToString(paramObject1, "substring", 1, "");
    int n = ((String)paramObject1).length();
    j = 0;
    for (;;)
    {
      int k = i - 1;
      if (k < 0) {
        break;
      }
      if (j >= n) {
        return "";
      }
      int m = j + 1;
      j = ((String)paramObject1).charAt(j);
      i = m;
      if (j >= 55296)
      {
        i = m;
        if (j < 56320)
        {
          i = m;
          if (m < n) {
            i = m + 1;
          }
        }
      }
      j = i;
      i = k;
    }
    return ((String)paramObject1).substring(j);
  }
  
  public static Object substring(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = coerceToString(paramObject1, "substring", 1, "");
    int n = ((String)paramObject1).length();
    double d2 = Math.floor(asDouble(paramObject2) - 0.5D);
    double d3 = d2 + Math.floor(asDouble(paramObject3) + 0.5D);
    double d1 = d2;
    if (d2 <= 0.0D) {
      d1 = 0.0D;
    }
    d2 = d3;
    if (d3 > n) {
      d2 = n;
    }
    if (d2 <= d1) {
      return "";
    }
    int j = (int)d1;
    int k = (int)d2 - j;
    int i = 0;
    int m;
    int i1;
    for (;;)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      if (i >= n) {
        return "";
      }
      m = i + 1;
      i1 = ((String)paramObject1).charAt(i);
      i = m;
      if (i1 >= 55296)
      {
        i = m;
        if (i1 < 56320)
        {
          i = m;
          if (m < n) {
            i = m + 1;
          }
        }
      }
    }
    j = i;
    for (;;)
    {
      k -= 1;
      if (k < 0) {
        break;
      }
      if (j >= n) {
        return "";
      }
      m = j + 1;
      i1 = ((String)paramObject1).charAt(j);
      j = m;
      if (i1 >= 55296)
      {
        j = m;
        if (i1 < 56320)
        {
          j = m;
          if (m < n) {
            j = m + 1;
          }
        }
      }
    }
    return ((String)paramObject1).substring(i, j);
  }
  
  public static Object substringAfter(Object paramObject1, Object paramObject2)
  {
    paramObject1 = coerceToString(paramObject1, "substring-after", 1, "");
    paramObject2 = coerceToString(paramObject2, "substring-after", 2, "");
    int i = ((String)paramObject2).length();
    if (i == 0) {
      return paramObject1;
    }
    int j = ((String)paramObject1).indexOf((String)paramObject2);
    if (j >= 0) {}
    for (paramObject1 = ((String)paramObject1).substring(j + i);; paramObject1 = "") {
      return paramObject1;
    }
  }
  
  public static Object substringBefore(Object paramObject1, Object paramObject2)
  {
    paramObject1 = coerceToString(paramObject1, "substring-before", 1, "");
    paramObject2 = coerceToString(paramObject2, "substring-before", 2, "");
    if (((String)paramObject2).length() == 0) {
      return "";
    }
    int i = ((String)paramObject1).indexOf((String)paramObject2);
    if (i >= 0) {
      return ((String)paramObject1).substring(0, i);
    }
    return "";
  }
  
  public static void tokenize$X(Object paramObject, String paramString, CallContext paramCallContext)
  {
    tokenize$X(paramObject, paramString, "", paramCallContext);
  }
  
  public static void tokenize$X(Object paramObject, String paramString1, String paramString2, CallContext paramCallContext)
  {
    paramObject = coerceToString(paramObject, "tokenize", 1, "");
    paramCallContext = paramCallContext.consumer;
    paramString1 = makePattern(paramString1, paramString2).matcher((CharSequence)paramObject);
    if (((String)paramObject).length() == 0) {
      return;
    }
    int i = 0;
    int k;
    int j;
    do
    {
      if (!paramString1.find())
      {
        paramCallContext.writeObject(((String)paramObject).substring(i));
        return;
      }
      k = paramString1.start();
      paramCallContext.writeObject(((String)paramObject).substring(i, k));
      j = paramString1.end();
      i = j;
    } while (j != k);
    throw new IllegalArgumentException("pattern matches empty string");
  }
  
  public static Object translate(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str = coerceToString(paramObject1, "translate", 1, "");
    paramObject2 = KNode.atomicValue(paramObject2);
    if ((!(paramObject2 instanceof UntypedAtomic)) && (!(paramObject2 instanceof String))) {
      throw new WrongType("translate", 2, paramObject1, "xs:string");
    }
    paramObject2 = paramObject2.toString();
    int i3 = ((String)paramObject2).length();
    paramObject3 = KNode.atomicValue(paramObject3);
    if ((!(paramObject3 instanceof UntypedAtomic)) && (!(paramObject3 instanceof String))) {
      throw new WrongType("translate", 3, paramObject1, "xs:string");
    }
    paramObject1 = paramObject3.toString();
    if (i3 == 0) {
      return str;
    }
    int i4 = str.length();
    paramObject3 = new StringBuffer(i4);
    int i5 = ((String)paramObject1).length();
    int j = 0;
    int k;
    int i;
    char c1;
    int m;
    label217:
    int n;
    if (j < i4)
    {
      k = j + 1;
      i = str.charAt(j);
      char c2 = '\000';
      c1 = c2;
      j = k;
      if (i >= 55296)
      {
        c1 = c2;
        j = k;
        if (i < 56320)
        {
          c1 = c2;
          j = k;
          if (k < i4)
          {
            c1 = str.charAt(k);
            j = k + 1;
          }
        }
      }
      k = 0;
      m = 0;
      if (m >= i3) {
        break label454;
      }
      int i1 = m + 1;
      int i6 = ((String)paramObject2).charAt(m);
      int i2 = 0;
      n = i2;
      m = i1;
      if (i6 >= 55296)
      {
        n = i2;
        m = i1;
        if (i6 < 56320)
        {
          n = i2;
          m = i1;
          if (i1 < i3)
          {
            n = ((String)paramObject2).charAt(i1);
            m = i1 + 1;
          }
        }
      }
      if ((i6 == i) && (n == c1))
      {
        n = 0;
        m = k;
        label320:
        if (n < i5)
        {
          i1 = n + 1;
          i = ((String)paramObject1).charAt(n);
          c2 = '\000';
          c1 = c2;
          k = i1;
          if (i >= 55296)
          {
            c1 = c2;
            k = i1;
            if (i < 56320)
            {
              c1 = c2;
              k = i1;
              if (i1 < i5)
              {
                c1 = ((String)paramObject1).charAt(i1);
                k = i1 + 1;
              }
            }
          }
          if (m != 0) {}
        }
      }
    }
    label454:
    for (;;)
    {
      ((StringBuffer)paramObject3).append(i);
      if (c1 != 0) {
        ((StringBuffer)paramObject3).append(c1);
      }
      break;
      m -= 1;
      n = k;
      break label320;
      break;
      k += 1;
      break label217;
      return ((StringBuffer)paramObject3).toString();
    }
  }
  
  public static Object upperCase(Object paramObject)
  {
    return coerceToString(paramObject, "upper-case", 1, "").toUpperCase();
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */