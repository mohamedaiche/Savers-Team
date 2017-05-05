package gnu.xquery.util;

import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.NodeType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.xml.NodeTree;

public class SequenceUtils
{
  public static final NodeType textOrElement = new NodeType("element-or-text", 3);
  
  static Object coerceToZeroOrOne(Object paramObject, String paramString, int paramInt)
  {
    if (isZeroOrOne(paramObject)) {
      return paramObject;
    }
    throw new WrongType(paramString, paramInt, paramObject, "xs:item()?");
  }
  
  public static boolean deepEqual(NodeTree paramNodeTree1, int paramInt1, NodeTree paramNodeTree2, int paramInt2, NamedCollator paramNamedCollator)
  {
    int i = paramNodeTree1.getNextKind(paramInt1);
    int j = paramNodeTree2.getNextKind(paramInt2);
    switch (i)
    {
    case 36: 
    default: 
      if (i != j) {
        return false;
      }
      break;
    case 33: 
      if (i != j) {
        return false;
      }
      if (paramNodeTree1.posLocalName(paramInt1) != paramNodeTree2.posLocalName(paramInt2)) {
        return false;
      }
      if (paramNodeTree1.posNamespaceURI(paramInt1) != paramNodeTree2.posNamespaceURI(paramInt2)) {
        return false;
      }
      i = paramNodeTree1.firstAttributePos(paramInt1);
      j = 0;
      for (;;)
      {
        if ((i == 0) || (paramNodeTree1.getNextKind(i) != 35))
        {
          if (j == paramNodeTree2.getAttributeCount(paramInt2)) {
            break;
          }
          return false;
        }
        j += 1;
        String str = paramNodeTree1.posLocalName(i);
        int k = paramNodeTree2.getAttributeI(paramInt2, paramNodeTree1.posNamespaceURI(i), str);
        if (k == 0) {
          return false;
        }
        if (!deepEqualItems(KNode.getNodeValue(paramNodeTree1, i), KNode.getNodeValue(paramNodeTree2, k), paramNamedCollator)) {
          return false;
        }
        i = paramNodeTree1.nextPos(i);
      }
    case 34: 
      return deepEqualChildren(paramNodeTree1, paramInt1, paramNodeTree2, paramInt2, paramNamedCollator);
    case 35: 
      if ((paramNodeTree1.posLocalName(paramInt1) != paramNodeTree2.posLocalName(paramInt2)) || (paramNodeTree1.posNamespaceURI(paramInt1) != paramNodeTree2.posNamespaceURI(paramInt2))) {
        return false;
      }
      return deepEqualItems(KAttr.getObjectValue(paramNodeTree1, paramInt1), KAttr.getObjectValue(paramNodeTree2, paramInt2), paramNamedCollator);
    case 37: 
      if (!paramNodeTree1.posTarget(paramInt1).equals(paramNodeTree2.posTarget(paramInt2))) {
        return false;
      }
      return KNode.getNodeValue(paramNodeTree1, paramInt1).equals(KNode.getNodeValue(paramNodeTree2, paramInt2));
    }
    return KNode.getNodeValue(paramNodeTree1, paramInt1).equals(KNode.getNodeValue(paramNodeTree2, paramInt2));
  }
  
  public static boolean deepEqual(Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 == null) || (paramObject1 == Values.empty)) {
      return (paramObject2 == null) || (paramObject2 == Values.empty);
    }
    if ((paramObject2 == null) || (paramObject2 == Values.empty)) {
      return false;
    }
    int j = 1;
    int i = 1;
    boolean bool1 = paramObject1 instanceof Values;
    boolean bool2 = paramObject2 instanceof Values;
    Values localValues1;
    Values localValues2;
    label85:
    int m;
    if (bool1)
    {
      localValues1 = (Values)paramObject1;
      if (!bool2) {
        break label170;
      }
      localValues2 = (Values)paramObject2;
      m = 1;
    }
    for (;;)
    {
      int k = j;
      if (bool1)
      {
        if (m != 0) {
          j = localValues1.startPos();
        }
        k = localValues1.nextPos(j);
      }
      int n = i;
      if (bool2)
      {
        if (m != 0) {
          i = localValues2.startPos();
        }
        n = localValues2.nextPos(i);
      }
      if ((k == 0) || (n == 0))
      {
        if (k == n)
        {
          return true;
          localValues1 = null;
          break;
          label170:
          localValues2 = null;
          break label85;
        }
        return false;
      }
      Object localObject1;
      if (bool1)
      {
        localObject1 = localValues1.getPosPrevious(k);
        if (!bool2) {
          break label243;
        }
      }
      label243:
      for (Object localObject2 = localValues2.getPosPrevious(n);; localObject2 = paramObject2)
      {
        if (((localObject1 instanceof KNode)) || ((localObject2 instanceof KNode))) {
          break label252;
        }
        try
        {
          boolean bool3 = deepEqualItems(paramObject1, paramObject2, paramNamedCollator);
          if (bool3) {
            break label319;
          }
          return false;
        }
        catch (Throwable paramObject1)
        {
          return false;
        }
        localObject1 = paramObject1;
        break;
      }
      label252:
      if (((localObject1 instanceof KNode)) && ((localObject2 instanceof KNode)))
      {
        localObject1 = (KNode)localObject1;
        localObject2 = (KNode)localObject2;
        if (!deepEqual((NodeTree)((KNode)localObject1).sequence, ((KNode)localObject1).ipos, (NodeTree)((KNode)localObject2).sequence, ((KNode)localObject2).ipos, paramNamedCollator)) {
          return false;
        }
      }
      else
      {
        return false;
      }
      label319:
      j = k;
      i = n;
      if (m != 0)
      {
        int i1 = 0;
        if (!bool1) {
          k = 0;
        }
        m = i1;
        j = k;
        i = n;
        if (!bool2)
        {
          i = 0;
          m = i1;
          j = k;
        }
      }
    }
  }
  
  public static boolean deepEqualChildren(NodeTree paramNodeTree1, int paramInt1, NodeTree paramNodeTree2, int paramInt2, NamedCollator paramNamedCollator)
  {
    boolean bool2 = false;
    NodeType localNodeType = textOrElement;
    int i = paramNodeTree1.firstChildPos(paramInt1, localNodeType);
    paramInt1 = paramNodeTree2.firstChildPos(paramInt2, localNodeType);
    paramInt2 = i;
    for (;;)
    {
      boolean bool1;
      if ((paramInt2 == 0) || (paramInt1 == 0))
      {
        bool1 = bool2;
        if (paramInt2 == paramInt1) {
          bool1 = true;
        }
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!deepEqual(paramNodeTree1, paramInt2, paramNodeTree2, paramInt1, paramNamedCollator));
      paramInt2 = paramNodeTree1.nextMatching(paramInt2, localNodeType, -1, false);
      paramInt1 = paramNodeTree2.nextMatching(paramInt1, localNodeType, -1, false);
    }
  }
  
  public static boolean deepEqualItems(Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator)
  {
    if ((NumberValue.isNaN(paramObject1)) && (NumberValue.isNaN(paramObject2))) {
      return true;
    }
    return Compare.atomicCompare(8, paramObject1, paramObject2, paramNamedCollator);
  }
  
  public static Object exactlyOne(Object paramObject)
  {
    if ((paramObject instanceof Values)) {
      throw new IllegalArgumentException();
    }
    return paramObject;
  }
  
  public static boolean exists(Object paramObject)
  {
    return (!(paramObject instanceof Values)) || (!((Values)paramObject).isEmpty());
  }
  
  public static void indexOf$X(Object paramObject1, Object paramObject2, NamedCollator paramNamedCollator, CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
    if ((paramObject1 instanceof Values))
    {
      paramObject1 = (Values)paramObject1;
      int j = ((Values)paramObject1).startPos();
      int i = 1;
      for (;;)
      {
        j = ((Values)paramObject1).nextPos(j);
        if (j == 0) {
          break;
        }
        if (Compare.apply(72, ((Values)paramObject1).getPosPrevious(j), paramObject2, paramNamedCollator)) {
          paramCallContext.writeInt(i);
        }
        i += 1;
      }
    }
    if (Compare.apply(72, paramObject1, paramObject2, paramNamedCollator)) {
      paramCallContext.writeInt(1);
    }
  }
  
  public static void insertBefore$X(Object paramObject1, long paramLong, Object paramObject2, CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
    int j = 0;
    long l2 = paramLong;
    if (paramLong <= 0L) {
      l2 = 1L;
    }
    int i;
    int k;
    if ((paramObject1 instanceof Values))
    {
      paramObject1 = (Values)paramObject1;
      i = 0;
      paramLong = 0L;
      k = ((Values)paramObject1).nextPos(i);
      long l1;
      if (k == 0)
      {
        l1 = paramLong;
        if (j == 0) {}
      }
      else
      {
        l1 = paramLong + 1L;
        paramLong = l1;
        if (l1 != l2) {
          break label88;
        }
      }
      Values.writeValues(paramObject2, paramCallContext);
      j = 1;
      paramLong = l1;
      label88:
      if (k != 0) {}
    }
    do
    {
      return;
      ((Values)paramObject1).consumePosRange(i, k, paramCallContext);
      i = k;
      break;
      if (l2 <= 1L) {
        Values.writeValues(paramObject2, paramCallContext);
      }
      paramCallContext.writeObject(paramObject1);
    } while (l2 <= 1L);
    Values.writeValues(paramObject2, paramCallContext);
  }
  
  public static boolean isEmptySequence(Object paramObject)
  {
    return ((paramObject instanceof Values)) && (((Values)paramObject).isEmpty());
  }
  
  public static boolean isZeroOrOne(Object paramObject)
  {
    return (!(paramObject instanceof Values)) || (((Values)paramObject).isEmpty());
  }
  
  public static Object oneOrMore(Object paramObject)
  {
    if (((paramObject instanceof Values)) && (((Values)paramObject).isEmpty())) {
      throw new IllegalArgumentException();
    }
    return paramObject;
  }
  
  public static void remove$X(Object paramObject, long paramLong, CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
    if ((paramObject instanceof Values))
    {
      paramObject = (Values)paramObject;
      i = 0;
      l = 0L;
      j = ((Values)paramObject).nextPos(i);
      if (j != 0) {}
    }
    while (paramLong == 1L) {
      for (;;)
      {
        long l;
        int j;
        return;
        l += 1L;
        if (l != paramLong) {
          ((Values)paramObject).consumePosRange(i, j, paramCallContext);
        }
        int i = j;
      }
    }
    paramCallContext.writeObject(paramObject);
  }
  
  public static void reverse$X(Object paramObject, CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    if (!(paramObject instanceof Values))
    {
      localConsumer.writeObject(paramObject);
      return;
    }
    Values localValues = (Values)paramObject;
    int i = 0;
    paramObject = new int[100];
    int j = 0;
    for (;;)
    {
      paramCallContext = (CallContext)paramObject;
      if (j >= paramObject.length)
      {
        paramCallContext = new int[j * 2];
        System.arraycopy(paramObject, 0, paramCallContext, 0, j);
      }
      int k = j + 1;
      paramCallContext[j] = i;
      i = localValues.nextPos(i);
      if (i == 0)
      {
        i = k - 1;
        for (;;)
        {
          i -= 1;
          if (i < 0) {
            break;
          }
          localValues.consumePosRange(paramCallContext[i], paramCallContext[(i + 1)], localConsumer);
        }
      }
      j = k;
      paramObject = paramCallContext;
    }
  }
  
  public static Object zeroOrOne(Object paramObject)
  {
    return coerceToZeroOrOne(paramObject, "zero-or-one", 1);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\SequenceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */