package gnu.xquery.util;

import gnu.kawa.functions.NumberCompare;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.FilterConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;

public class OrderedTuples
  extends FilterConsumer
{
  Procedure body;
  Object[] comps;
  int first;
  int n;
  int[] next;
  Object[] tuples = new Object[10];
  
  OrderedTuples()
  {
    super(null);
  }
  
  public static OrderedTuples make$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    OrderedTuples localOrderedTuples = new OrderedTuples();
    localOrderedTuples.comps = paramArrayOfObject;
    localOrderedTuples.body = paramProcedure;
    return localOrderedTuples;
  }
  
  int cmp(int paramInt1, int paramInt2)
    throws Throwable
  {
    int j = 0;
    if (j < this.comps.length)
    {
      Object localObject3 = (Procedure)this.comps[j];
      String str = (String)this.comps[(j + 1)];
      Object localObject2 = (NamedCollator)this.comps[(j + 2)];
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = NamedCollator.codepointCollation;
      }
      localObject2 = ((Procedure)localObject3).applyN((Object[])this.tuples[paramInt1]);
      Object localObject4 = ((Procedure)localObject3).applyN((Object[])this.tuples[paramInt2]);
      localObject3 = KNode.atomicValue(localObject2);
      localObject4 = KNode.atomicValue(localObject4);
      localObject2 = localObject3;
      if ((localObject3 instanceof UntypedAtomic)) {
        localObject2 = localObject3.toString();
      }
      localObject3 = localObject4;
      if ((localObject4 instanceof UntypedAtomic)) {
        localObject3 = localObject4.toString();
      }
      boolean bool2 = SequenceUtils.isEmptySequence(localObject2);
      boolean bool1 = SequenceUtils.isEmptySequence(localObject3);
      if ((bool2) && (bool1)) {}
      label214:
      int i;
      label223:
      label246:
      label275:
      label300:
      label332:
      label348:
      label352:
      label354:
      label360:
      label365:
      label410:
      for (;;)
      {
        j += 3;
        break;
        if ((bool2) || (bool1)) {
          if (str.charAt(1) == 'L')
          {
            bool1 = true;
            if (bool2 != bool1) {
              break label246;
            }
            i = -1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label410;
          }
          if (str.charAt(0) != 'A') {
            break label412;
          }
          return i;
          bool1 = false;
          break label214;
          i = 1;
          continue;
          int k;
          if (((localObject2 instanceof Number)) && (Double.isNaN(((Number)localObject2).doubleValue())))
          {
            i = 1;
            if ((!(localObject3 instanceof Number)) || (!Double.isNaN(((Number)localObject3).doubleValue()))) {
              break label348;
            }
            k = 1;
            if ((i != 0) && (k != 0)) {
              break label352;
            }
            if ((i == 0) && (k == 0)) {
              break label365;
            }
            if (str.charAt(1) != 'L') {
              break label354;
            }
            k = 1;
            if (i != k) {
              break label360;
            }
          }
          for (i = -1;; i = 1)
          {
            break label223;
            i = 0;
            break label275;
            k = 0;
            break label300;
            break;
            k = 0;
            break label332;
          }
          if (((localObject2 instanceof Number)) && ((localObject3 instanceof Number))) {
            i = NumberCompare.compare(localObject2, localObject3, false);
          } else {
            i = ((NamedCollator)localObject1).compare(localObject2.toString(), localObject3.toString());
          }
        }
      }
      label412:
      return -i;
    }
    return 0;
  }
  
  void emit(int paramInt, CallContext paramCallContext)
    throws Throwable
  {
    Object[] arrayOfObject = (Object[])this.tuples[paramInt];
    this.body.checkN(arrayOfObject, paramCallContext);
    paramCallContext.runUntilDone();
  }
  
  void emit(CallContext paramCallContext)
    throws Throwable
  {
    for (int i = this.first; i >= 0; i = this.next[i]) {
      emit(i, paramCallContext);
    }
  }
  
  int listsort(int paramInt)
    throws Throwable
  {
    if (this.n == 0) {
      return -1;
    }
    this.next = new int[this.n];
    int i = 1;
    int k;
    if (i == this.n)
    {
      this.next[(i - 1)] = -1;
      k = 1;
    }
    for (;;)
    {
      i = -1;
      int i4 = -1;
      int j = 0;
      for (;;)
      {
        if (paramInt < 0) {
          break label296;
        }
        int i5 = j + 1;
        int i1 = paramInt;
        int i2 = 0;
        int i3 = 0;
        label66:
        j = i2;
        int m = i1;
        if (i3 < k)
        {
          j = i2 + 1;
          m = this.next[i1];
          if (m >= 0) {}
        }
        else
        {
          i1 = k;
          i3 = i;
          i2 = i4;
          i = m;
          m = j;
          j = paramInt;
          label118:
          if ((m <= 0) && ((i1 <= 0) || (i < 0))) {
            break label281;
          }
          if (m != 0) {
            break label203;
          }
          paramInt = i;
          i = this.next[i];
          i1 -= 1;
          label152:
          if (i2 < 0) {
            break label275;
          }
          this.next[i2] = paramInt;
        }
        for (;;)
        {
          i2 = paramInt;
          break label118;
          this.next[(i - 1)] = i;
          i += 1;
          break;
          i3 += 1;
          i2 = j;
          i1 = m;
          break label66;
          label203:
          if ((i1 == 0) || (i < 0))
          {
            paramInt = j;
            j = this.next[j];
            m -= 1;
            break label152;
          }
          if (cmp(j, i) <= 0)
          {
            paramInt = j;
            j = this.next[j];
            m -= 1;
            break label152;
          }
          paramInt = i;
          i = this.next[i];
          i1 -= 1;
          break label152;
          label275:
          i3 = paramInt;
        }
        label281:
        paramInt = i;
        j = i5;
        i4 = i2;
        i = i3;
      }
      label296:
      this.next[i4] = -1;
      if (j <= 1) {
        return i;
      }
      k *= 2;
      paramInt = i;
    }
  }
  
  public void run$X(CallContext paramCallContext)
    throws Throwable
  {
    this.first = listsort(0);
    emit(paramCallContext);
  }
  
  public void writeObject(Object paramObject)
  {
    if (this.n >= this.tuples.length)
    {
      arrayOfObject = new Object[this.n * 2];
      System.arraycopy(this.tuples, 0, arrayOfObject, 0, this.n);
      this.tuples = arrayOfObject;
    }
    Object[] arrayOfObject = this.tuples;
    int i = this.n;
    this.n = (i + 1);
    arrayOfObject[i] = paramObject;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\OrderedTuples.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */