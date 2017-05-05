package gnu.kawa.swingviews;

import gnu.kawa.models.Button;
import gnu.kawa.models.Model;
import gnu.kawa.models.ModelListener;
import java.awt.Color;
import javax.swing.JButton;

public class SwingButton
  extends JButton
  implements ModelListener
{
  Button model;
  
  public SwingButton(Button paramButton)
  {
    super(paramButton.getText());
    setModel(new SwModel(paramButton));
    this.model = paramButton;
    Object localObject = paramButton.getAction();
    if (localObject != null) {
      addActionListener(SwingDisplay.makeActionListener(localObject));
    }
    paramButton.addListener(this);
    localObject = paramButton.getForeground();
    if (localObject != null) {
      super.setBackground((Color)localObject);
    }
    paramButton = paramButton.getBackground();
    if (paramButton != null) {
      super.setBackground(paramButton);
    }
  }
  
  public void modelUpdated(Model paramModel, Object paramObject)
  {
    if ((paramObject == "text") && (paramModel == this.model)) {
      super.setText(this.model.getText());
    }
    do
    {
      return;
      if ((paramObject == "foreground") && (paramModel == this.model))
      {
        super.setForeground(this.model.getForeground());
        return;
      }
    } while ((paramObject != "background") || (paramModel != this.model));
    super.setBackground(this.model.getBackground());
  }
  
  public void setBackground(Color paramColor)
  {
    if (this.model == null)
    {
      super.setBackground(paramColor);
      return;
    }
    this.model.setBackground(paramColor);
  }
  
  public void setForeground(Color paramColor)
  {
    if (this.model == null)
    {
      super.setForeground(paramColor);
      return;
    }
    this.model.setForeground(paramColor);
  }
  
  public void setText(String paramString)
  {
    if (this.model == null)
    {
      super.setText(paramString);
      return;
    }
    this.model.setText(paramString);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\SwingButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */