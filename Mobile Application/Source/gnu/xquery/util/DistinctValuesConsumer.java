package gnu.xquery.util;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Values;
import gnu.xml.NodeTree;

class DistinctValuesConsumer
  extends FilterConsumer
  implements PositionConsumer
{
  DistinctValuesHashTable table;
  
  public DistinctValuesConsumer(NamedCollator paramNamedCollator, Consumer paramConsumer)
  {
    super(paramConsumer);
    this.table = new DistinctValuesHashTable(paramNamedCollator);
  }
  
  public void consume(SeqPosition paramSeqPosition)
  {
    writeObject(paramSeqPosition);
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      writeObject(localBoolean);
      return;
    }
  }
  
  public void writeObject(Object paramObject)
  {
    if ((paramObject instanceof Values)) {
      Values.writeValues(paramObject, this);
    }
    do
    {
      return;
      if ((paramObject instanceof KNode))
      {
        paramObject = (KNode)paramObject;
        writeObject(((NodeTree)((KNode)paramObject).sequence).typedValue(((KNode)paramObject).ipos));
        return;
      }
    } while (this.table.get(paramObject, null) != null);
    this.table.put(paramObject, paramObject);
    this.base.writeObject(paramObject);
  }
  
  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    writeObject(((NodeTree)paramAbstractSequence).typedValue(paramInt));
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\util\DistinctValuesConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */