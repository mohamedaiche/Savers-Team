package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import gnu.kawa.models.ModelListener;
import gnu.kawa.models.Viewable;

class SwingBox
  extends javax.swing.Box
  implements ModelListener
{
  gnu.kawa.models.Box model;
  
  public SwingBox(gnu.kawa.models.Box paramBox, Display paramDisplay)
  {
    super(paramBox.getAxis());
    paramBox.addListener(this);
    Viewable localViewable = paramBox.getCellSpacing();
    int j = paramBox.getComponentCount();
    int i = 0;
    while (i < j)
    {
      if ((i > 0) && (localViewable != null)) {
        localViewable.makeView(paramDisplay, this);
      }
      paramBox.getComponent(i).makeView(paramDisplay, this);
      i += 1;
    }
  }
  
  public void modelUpdated(Model paramModel, Object paramObject) {}
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\SwingBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */