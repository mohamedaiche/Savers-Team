package gnu.xquery.util;

import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XStringType;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Path;
import gnu.text.URIPath;
import gnu.xml.NamespaceBinding;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import java.net.URISyntaxException;

public class QNameUtils
{
  public static Object localNameFromQName(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramObject;
    }
    if (!(paramObject instanceof Symbol)) {
      throw new WrongType("local-name-from-QName", 1, paramObject, "xs:QName");
    }
    return XStringType.makeNCName(((Symbol)paramObject).getName());
  }
  
  public static String lookupPrefix(String paramString, NamespaceBinding paramNamespaceBinding1, NamespaceBinding paramNamespaceBinding2)
  {
    for (;;)
    {
      if (paramNamespaceBinding1 == null) {}
      for (paramNamespaceBinding1 = paramNamespaceBinding2.resolve(paramString);; paramNamespaceBinding1 = paramNamespaceBinding1.getUri())
      {
        paramNamespaceBinding2 = paramNamespaceBinding1;
        if (paramNamespaceBinding1 == null)
        {
          paramNamespaceBinding2 = paramNamespaceBinding1;
          if (paramString == null) {
            paramNamespaceBinding2 = "";
          }
        }
        return paramNamespaceBinding2;
        if (paramNamespaceBinding1.getPrefix() != paramString) {
          break;
        }
      }
      paramNamespaceBinding1 = paramNamespaceBinding1.getNext();
    }
  }
  
  public static Symbol makeQName(Object paramObject, String paramString)
  {
    if (paramObject != null)
    {
      localObject = paramObject;
      if (paramObject != Values.empty) {}
    }
    else
    {
      localObject = "";
    }
    int i = paramString.indexOf(':');
    String str = (String)localObject;
    if (i < 0) {
      paramObject = paramString;
    }
    for (Object localObject = ""; (!validNCName((String)paramObject)) || ((i >= 0) && (!validNCName((String)localObject))); localObject = paramString.substring(0, i).intern())
    {
      throw new IllegalArgumentException("invalid QName syntax '" + paramString + "'");
      paramObject = paramString.substring(i + 1);
    }
    if ((i >= 0) && (str.length() == 0)) {
      throw new IllegalArgumentException("empty uri for '" + paramString + "'");
    }
    return Symbol.make(str, (String)paramObject, (String)localObject);
  }
  
  public static Object namespaceURIForPrefix(Object paramObject1, Object paramObject2)
  {
    KNode localKNode = KNode.coerce(paramObject2);
    if (localKNode == null) {
      throw new WrongType("namespace-uri-for-prefix", 2, paramObject2, "node()");
    }
    if ((paramObject1 == null) || (paramObject1 == Values.empty)) {
      paramObject1 = null;
    }
    for (;;)
    {
      paramObject2 = localKNode.lookupNamespaceURI((String)paramObject1);
      paramObject1 = paramObject2;
      if (paramObject2 == null) {
        paramObject1 = Values.empty;
      }
      return paramObject1;
      if ((!(paramObject1 instanceof String)) && (!(paramObject1 instanceof UntypedAtomic))) {
        throw new WrongType("namespace-uri-for-prefix", 1, paramObject2, "xs:string");
      }
      paramObject2 = paramObject1.toString().intern();
      paramObject1 = paramObject2;
      if (paramObject2 == "") {
        paramObject1 = null;
      }
    }
  }
  
  public static Object namespaceURIFromQName(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramObject;
    }
    try
    {
      URIPath localURIPath = URIPath.makeURI(((Symbol)paramObject).getNamespaceURI());
      return localURIPath;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType("namespace-uri", 1, paramObject, "xs:QName");
    }
  }
  
  public static Object prefixFromQName(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramObject;
    }
    if ((paramObject instanceof Symbol))
    {
      paramObject = ((Symbol)paramObject).getPrefix();
      if ((paramObject == null) || (((String)paramObject).length() == 0)) {
        return Values.empty;
      }
      return XStringType.makeNCName((String)paramObject);
    }
    throw new WrongType("prefix-from-QName", 1, paramObject, "xs:QName");
  }
  
  public static String resolvePrefix(String paramString, NamespaceBinding paramNamespaceBinding1, NamespaceBinding paramNamespaceBinding2)
  {
    paramNamespaceBinding1 = lookupPrefix(paramString, paramNamespaceBinding1, paramNamespaceBinding2);
    if (paramNamespaceBinding1 == null) {
      throw new RuntimeException("unknown namespace prefix '" + paramString + "'");
    }
    return paramNamespaceBinding1;
  }
  
  public static Object resolveQName(Object paramObject, NamespaceBinding paramNamespaceBinding1, NamespaceBinding paramNamespaceBinding2)
  {
    paramObject = KNode.atomicValue(paramObject);
    if ((paramObject instanceof Symbol)) {
      return paramObject;
    }
    if (((paramObject instanceof Values)) || ((!(paramObject instanceof String)) && (!(paramObject instanceof UntypedAtomic)))) {
      throw new RuntimeException("bad argument to QName");
    }
    String str2 = TextUtils.replaceWhitespace(paramObject.toString(), true);
    int i = str2.indexOf(':');
    String str1;
    if (i < 0)
    {
      str1 = str2;
      paramObject = null;
    }
    while ((!validNCName(str1)) || ((paramObject != null) && (!validNCName((String)paramObject))))
    {
      throw new RuntimeException("invalid QName syntax '" + str2 + "'");
      paramObject = str2.substring(0, i).intern();
      str1 = str2.substring(i + 1);
    }
    paramNamespaceBinding2 = resolvePrefix((String)paramObject, paramNamespaceBinding1, paramNamespaceBinding2);
    paramNamespaceBinding1 = (NamespaceBinding)paramObject;
    if (paramObject == null) {
      paramNamespaceBinding1 = "";
    }
    return Symbol.make(paramNamespaceBinding2, str1, paramNamespaceBinding1);
  }
  
  public static Object resolveQNameUsingElement(Object paramObject, KElement paramKElement)
  {
    paramObject = KNode.atomicValue(paramObject);
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return paramObject;
    }
    if (((paramObject instanceof Values)) || ((!(paramObject instanceof String)) && (!(paramObject instanceof UntypedAtomic)))) {
      throw new RuntimeException("bad argument to QName");
    }
    Object localObject2 = TextUtils.replaceWhitespace(paramObject.toString(), true);
    int i = ((String)localObject2).indexOf(':');
    if (i < 0) {
      paramObject = null;
    }
    for (Object localObject1 = localObject2;; localObject1 = ((String)localObject2).substring(i + 1))
    {
      String str = paramKElement.lookupNamespaceURI((String)paramObject);
      paramKElement = str;
      if (str == null)
      {
        if (paramObject != null) {
          break;
        }
        paramKElement = "";
      }
      if ((validNCName((String)localObject1)) && ((paramObject == null) || (validNCName((String)paramObject)))) {
        break label205;
      }
      throw new RuntimeException("invalid QName syntax '" + (String)localObject2 + "'");
      paramObject = ((String)localObject2).substring(0, i).intern();
    }
    throw new RuntimeException("unknown namespace for '" + (String)localObject2 + "'");
    label205:
    localObject2 = paramObject;
    if (paramObject == null) {
      localObject2 = "";
    }
    return Symbol.make(paramKElement, (String)localObject1, (String)localObject2);
  }
  
  public static Object resolveURI(Object paramObject1, Object paramObject2)
    throws URISyntaxException
  {
    Object localObject = paramObject1;
    if ((paramObject1 instanceof KNode)) {
      localObject = KNode.atomicValue(paramObject1);
    }
    paramObject1 = paramObject2;
    if ((paramObject2 instanceof KNode)) {
      paramObject1 = KNode.atomicValue(paramObject2);
    }
    if ((localObject == Values.empty) || (localObject == null)) {
      return localObject;
    }
    paramObject2 = localObject;
    if ((localObject instanceof UntypedAtomic)) {
      paramObject2 = localObject.toString();
    }
    localObject = paramObject1;
    if ((paramObject1 instanceof UntypedAtomic)) {
      localObject = paramObject1.toString();
    }
    if ((localObject instanceof Path)) {}
    for (paramObject1 = (Path)localObject; (paramObject2 instanceof Path); paramObject1 = URIPath.makeURI(localObject)) {
      return ((Path)paramObject1).resolve((Path)paramObject2);
    }
    return ((Path)paramObject1).resolve(paramObject2.toString());
  }
  
  public static boolean validNCName(String paramString)
  {
    return XName.isName(paramString);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\QNameUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */