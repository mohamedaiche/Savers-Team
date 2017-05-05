package gnu.xquery.util;

import gnu.bytecode.ClassType;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.xml.Document;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.Nodes;
import gnu.kawa.xml.SortedNodes;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Path;
import gnu.xml.NamespaceBinding;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XName;
import gnu.xquery.lang.XQuery;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Stack;

public class NodeUtils
{
  static String collectionNamespace = "http://gnu.org/kawa/cached-collections";
  public static final Symbol collectionResolverSymbol = Symbol.make("http://www.w3.org/2005/xquery-local-functions", "collection-resolver", "qexo");
  
  public static boolean availableCached(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    paramObject1 = resolve(paramObject1, paramObject2, "doc-available");
    if (paramObject1 == null) {
      return false;
    }
    try
    {
      Document.parseCached(paramObject1);
      return true;
    }
    catch (Throwable paramObject1) {}
    return false;
  }
  
  public static Object baseUri(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {}
    Path localPath;
    do
    {
      return paramObject;
      if (!(paramObject instanceof KNode)) {
        throw new WrongType("base-uri", 1, paramObject, "node()?");
      }
      localPath = ((KNode)paramObject).baseURI();
      paramObject = localPath;
    } while (localPath != null);
    return Values.empty;
  }
  
  public static Object collection(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Object localObject1 = resolve(paramObject1, paramObject2, "collection");
    Object localObject2 = Environment.getCurrent();
    Object localObject3 = collectionResolverSymbol;
    paramObject2 = ((Environment)localObject2).get((Symbol)localObject3, null, null);
    paramObject1 = paramObject2;
    if (paramObject2 == null) {
      paramObject1 = ((Environment)localObject2).get(Symbol.makeWithUnknownNamespace(((Symbol)localObject3).getLocalName(), ((Symbol)localObject3).getPrefix()), null, null);
    }
    if (paramObject1 == null) {
      return getSavedCollection(localObject1);
    }
    if (!(paramObject1 instanceof String))
    {
      paramObject2 = paramObject1;
      if (!(paramObject1 instanceof UntypedAtomic)) {}
    }
    else
    {
      localObject3 = paramObject1.toString();
      int i = ((String)localObject3).indexOf(':');
      paramObject2 = paramObject1;
      if (i > 0)
      {
        localObject2 = ((String)localObject3).substring(0, i);
        localObject3 = ((String)localObject3).substring(i + 1);
        try
        {
          paramObject1 = Class.forName((String)localObject2);
          paramObject1 = ClassMethods.apply((ClassType)ClassType.make((Class)paramObject1), (String)localObject3, '\000', XQuery.instance);
          paramObject2 = paramObject1;
          if (paramObject1 == null) {
            throw new RuntimeException("invalid collection-resolver: no method " + (String)localObject3 + " in " + (String)localObject2);
          }
        }
        catch (ClassNotFoundException paramObject1)
        {
          throw new RuntimeException("invalid collection-resolver: class " + (String)localObject2 + " not found");
        }
        catch (Throwable paramObject1)
        {
          throw new RuntimeException("invalid collection-resolver: " + paramObject1);
        }
      }
    }
    if (!(paramObject2 instanceof Procedure)) {
      throw new RuntimeException("invalid collection-resolver: " + paramObject2);
    }
    return ((Procedure)paramObject2).apply1(localObject1);
  }
  
  public static void data$X(Object paramObject, CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
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
        paramCallContext.writeObject(KNode.atomicValue(((Values)paramObject).getPosPrevious(i)));
      }
    }
    paramCallContext.writeObject(KNode.atomicValue(paramObject));
  }
  
  public static Object docCached(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    paramObject1 = resolve(paramObject1, paramObject2, "doc");
    if (paramObject1 == null) {
      return Values.empty;
    }
    return Document.parseCached(paramObject1);
  }
  
  public static Object documentUri(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {}
    Object localObject;
    do
    {
      return paramObject;
      if (!(paramObject instanceof KNode)) {
        throw new WrongType("xs:document-uri", 1, paramObject, "node()?");
      }
      paramObject = (KNode)paramObject;
      localObject = ((NodeTree)((KNode)paramObject).sequence).documentUriOfPos(((KNode)paramObject).ipos);
      paramObject = localObject;
    } while (localObject != null);
    return Values.empty;
  }
  
  static Object getIDs(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject1;
    if ((paramObject1 instanceof KNode)) {
      localObject = KNode.atomicValue(paramObject1);
    }
    if ((localObject instanceof Values))
    {
      localObject = ((Values)localObject).getValues();
      i = localObject.length;
      for (;;)
      {
        i -= 1;
        paramObject1 = paramObject2;
        if (i < 0) {
          break;
        }
        paramObject2 = getIDs(localObject[i], paramObject2);
      }
    }
    String str = StringUtils.coerceToString(localObject, "fn:id", 1, "");
    int j = str.length();
    int i = 0;
    paramObject1 = paramObject2;
    while (i < j)
    {
      int k = i + 1;
      char c = str.charAt(i);
      if (Character.isWhitespace(c))
      {
        i = k;
      }
      else
      {
        if (XName.isNameStart(c)) {
          i = k - 1;
        }
        for (;;)
        {
          if (k < j)
          {
            c = str.charAt(k);
            if (!Character.isWhitespace(c)) {}
          }
          else
          {
            paramObject2 = paramObject1;
            if (i < j)
            {
              localObject = str.substring(i, k);
              if (paramObject1 != null) {
                break label226;
              }
              paramObject2 = localObject;
            }
            i = k + 1;
            paramObject1 = paramObject2;
            break;
            i = j;
            continue;
          }
          int m = k + 1;
          k = m;
          if (i < j)
          {
            k = m;
            if (!XName.isNamePart(c))
            {
              i = j;
              k = m;
            }
          }
        }
        label226:
        if ((paramObject1 instanceof Stack)) {
          paramObject2 = (Stack)paramObject1;
        }
        for (;;)
        {
          ((Stack)paramObject2).push(localObject);
          paramObject2 = paramObject1;
          break;
          paramObject2 = new Stack();
          ((Stack)paramObject2).push(paramObject1);
          paramObject1 = paramObject2;
        }
      }
    }
    return paramObject1;
  }
  
  public static String getLang(KNode paramKNode)
  {
    NodeTree localNodeTree = (NodeTree)paramKNode.sequence;
    int i = localNodeTree.ancestorAttribute(paramKNode.ipos, "http://www.w3.org/XML/1998/namespace", "lang");
    if (i == 0) {
      return null;
    }
    return KNode.getNodeValue(localNodeTree, i);
  }
  
  public static Object getSavedCollection(Object paramObject)
  {
    return getSavedCollection(paramObject, Environment.getCurrent());
  }
  
  public static Object getSavedCollection(Object paramObject, Environment paramEnvironment)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "#default";
    }
    paramObject = paramEnvironment.get(Symbol.make(collectionNamespace, localObject.toString()), null, null);
    if (paramObject == null) {
      throw new RuntimeException("collection '" + localObject + "' not found");
    }
    return paramObject;
  }
  
  public static void id$X(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    Object localObject = (KNode)paramObject2;
    paramObject2 = (NodeTree)((KNode)localObject).sequence;
    localObject = (KDocument)Nodes.root((NodeTree)paramObject2, ((KNode)localObject).ipos);
    paramCallContext = paramCallContext.consumer;
    paramObject1 = getIDs(paramObject1, null);
    if (paramObject1 == null) {}
    int i;
    do
    {
      return;
      ((NodeTree)paramObject2).makeIDtableIfNeeded();
      if (((paramCallContext instanceof PositionConsumer)) && (((paramObject1 instanceof String)) || ((paramCallContext instanceof SortedNodes))))
      {
        idScan(paramObject1, (NodeTree)paramObject2, (PositionConsumer)paramCallContext);
        return;
      }
      if (!(paramObject1 instanceof String)) {
        break;
      }
      i = ((NodeTree)paramObject2).lookupID((String)paramObject1);
    } while (i == -1);
    paramCallContext.writeObject(KNode.make((NodeTree)paramObject2, i));
    return;
    localObject = new SortedNodes();
    idScan(paramObject1, (NodeTree)paramObject2, (PositionConsumer)localObject);
    Values.writeValues(localObject, paramCallContext);
  }
  
  private static void idScan(Object paramObject, NodeTree paramNodeTree, PositionConsumer paramPositionConsumer)
  {
    int i;
    if ((paramObject instanceof String))
    {
      i = paramNodeTree.lookupID((String)paramObject);
      if (i != -1) {
        paramPositionConsumer.writePosition(paramNodeTree, i);
      }
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Stack))
      {
        paramObject = (Stack)paramObject;
        int j = ((Stack)paramObject).size();
        i = 0;
        while (i < j)
        {
          idScan(((Stack)paramObject).elementAt(i), paramNodeTree, paramPositionConsumer);
          i += 1;
        }
      }
    }
  }
  
  public static Object idref(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (KNode)paramObject2;
    paramObject1 = (KDocument)Nodes.root((NodeTree)((KNode)paramObject1).sequence, ((KNode)paramObject1).getPos());
    return Values.empty;
  }
  
  public static void inScopePrefixes$X(Object paramObject, CallContext paramCallContext)
  {
    paramObject = ((KElement)paramObject).getNodeNameObject();
    if ((paramObject instanceof XName))
    {
      prefixesFromNodetype((XName)paramObject, paramCallContext.consumer);
      return;
    }
    paramCallContext.consumer.writeObject("xml");
  }
  
  public static boolean lang(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject1 == Values.empty)) {}
    String str;
    for (paramObject1 = "";; paramObject1 = TextUtils.stringValue(paramObject1))
    {
      str = getLang((KNode)paramObject2);
      if (str != null) {
        break;
      }
      return false;
    }
    int i = str.length();
    int j = ((String)paramObject1).length();
    paramObject2 = str;
    if (i > j)
    {
      paramObject2 = str;
      if (str.charAt(j) == '-') {
        paramObject2 = str.substring(0, j);
      }
    }
    return ((String)paramObject2).equalsIgnoreCase((String)paramObject1);
  }
  
  public static String localName(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return "";
    }
    if (!(paramObject instanceof KNode)) {
      throw new WrongType("local-name", 1, paramObject, "node()?");
    }
    paramObject = ((KNode)paramObject).getNodeNameObject();
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return "";
    }
    if ((paramObject instanceof Symbol)) {
      return ((Symbol)paramObject).getName();
    }
    return paramObject.toString();
  }
  
  public static String name(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {
      return "";
    }
    paramObject = ((KNode)paramObject).getNodeNameObject();
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static Object namespaceURI(Object paramObject)
  {
    if ((paramObject != Values.empty) && (paramObject != null))
    {
      if (!(paramObject instanceof KNode)) {
        throw new WrongType("namespace-uri", 1, paramObject, "node()?");
      }
      paramObject = ((KNode)paramObject).getNodeNameObject();
      if ((paramObject instanceof Symbol)) {
        return QNameUtils.namespaceURIFromQName(paramObject);
      }
    }
    return "";
  }
  
  public static Object nilled(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    if (!(paramObject instanceof KNode)) {
      throw new WrongType("nilled", 1, paramObject, "node()?");
    }
    if (!(paramObject instanceof KElement)) {
      return Values.empty;
    }
    return Boolean.FALSE;
  }
  
  public static Object nodeName(Object paramObject)
  {
    if ((paramObject == Values.empty) || (paramObject == null)) {}
    Symbol localSymbol;
    do
    {
      return paramObject;
      if (!(paramObject instanceof KNode)) {
        throw new WrongType("node-name", 1, paramObject, "node()?");
      }
      localSymbol = ((KNode)paramObject).getNodeSymbol();
      paramObject = localSymbol;
    } while (localSymbol != null);
    return Values.empty;
  }
  
  public static void prefixesFromNodetype(XName paramXName, Consumer paramConsumer)
  {
    paramXName = paramXName.getNamespaceNodes();
    Object localObject1 = paramXName;
    while (localObject1 != null) {
      if (((NamespaceBinding)localObject1).getUri() == null)
      {
        localObject1 = ((NamespaceBinding)localObject1).getNext();
      }
      else
      {
        String str = ((NamespaceBinding)localObject1).getPrefix();
        for (Object localObject2 = paramXName;; localObject2 = ((NamespaceBinding)localObject2).getNext())
        {
          if (localObject2 == localObject1)
          {
            localObject2 = str;
            if (str == null) {
              localObject2 = "";
            }
            paramConsumer.writeObject(localObject2);
            break;
          }
          if (((NamespaceBinding)localObject2).getPrefix() == str) {
            break;
          }
        }
      }
    }
  }
  
  static Object resolve(Object paramObject1, Object paramObject2, String paramString)
    throws Throwable
  {
    paramObject2 = paramObject1;
    if (!(paramObject1 instanceof File))
    {
      paramObject2 = paramObject1;
      if (!(paramObject1 instanceof Path))
      {
        paramObject2 = paramObject1;
        if (!(paramObject1 instanceof URI))
        {
          paramObject2 = paramObject1;
          if (!(paramObject1 instanceof URL)) {
            paramObject2 = StringUtils.coerceToString(paramObject1, paramString, 1, null);
          }
        }
      }
    }
    if ((paramObject2 == Values.empty) || (paramObject2 == null)) {
      return null;
    }
    return Path.currentPath().resolve(Path.valueOf(paramObject2));
  }
  
  public static Object root(Object paramObject)
  {
    if ((paramObject == null) || (paramObject == Values.empty)) {
      return paramObject;
    }
    if (!(paramObject instanceof KNode)) {
      throw new WrongType("root", 1, paramObject, "node()?");
    }
    paramObject = (KNode)paramObject;
    return Nodes.root((NodeTree)((KNode)paramObject).sequence, ((KNode)paramObject).getPos());
  }
  
  public static KDocument rootDocument(Object paramObject)
  {
    if (!(paramObject instanceof KNode)) {
      throw new WrongType("root-document", 1, paramObject, "node()?");
    }
    KNode localKNode = (KNode)paramObject;
    localKNode = Nodes.root((NodeTree)localKNode.sequence, localKNode.getPos());
    if (!(localKNode instanceof KDocument)) {
      throw new WrongType("root-document", 1, paramObject, "document()");
    }
    return (KDocument)localKNode;
  }
  
  public static void setSavedCollection(Object paramObject1, Object paramObject2)
  {
    setSavedCollection(paramObject1, paramObject2, Environment.getCurrent());
  }
  
  public static void setSavedCollection(Object paramObject1, Object paramObject2, Environment paramEnvironment)
  {
    Object localObject = paramObject1;
    if (paramObject1 == null) {
      localObject = "#default";
    }
    paramEnvironment.put(Symbol.make(collectionNamespace, localObject.toString()), null, paramObject2);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\NodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */