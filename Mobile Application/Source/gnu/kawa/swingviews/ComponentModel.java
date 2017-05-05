package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import gnu.kawa.models.Model;
import java.awt.Component;

class ComponentModel
  extends Model
{
  Component component;
  
  public ComponentModel(Component paramComponent)
  {
    this.component = paramComponent;
  }
  
  public void makeView(Display paramDisplay, Object paramObject)
  {
    paramDisplay.addView(this.component, paramObject);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\ComponentModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */