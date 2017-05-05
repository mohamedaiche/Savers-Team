package gnu.kawa.swingviews;

import gnu.kawa.models.Button;
import javax.swing.DefaultButtonModel;

class SwModel
  extends DefaultButtonModel
{
  Button model;
  
  public SwModel(Button paramButton)
  {
    this.model = paramButton;
    setActionCommand(paramButton.getText());
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\SwModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */