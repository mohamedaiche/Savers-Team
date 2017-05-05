package gnu.kawa.swingviews;

import gnu.kawa.models.Display;
import gnu.kawa.models.Paintable;
import gnu.kawa.models.Viewable;
import gnu.kawa.models.Window;
import gnu.lists.AbstractSequence;
import gnu.lists.FString;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SwingFrame
  extends JFrame
  implements Window
{
  SwingDisplay display;
  
  public SwingFrame(String paramString, JMenuBar paramJMenuBar, Object paramObject)
  {
    if (paramString != null) {
      setTitle(paramString);
    }
    if (paramJMenuBar != null) {
      setJMenuBar(paramJMenuBar);
    }
    paramString = getContentPane();
    paramString.setLayout(new BoxLayout(paramString, 0));
    addComponent(paramObject);
  }
  
  public void addComponent(Object paramObject)
  {
    if (((paramObject instanceof FString)) || ((paramObject instanceof String))) {
      getContentPane().add(new JLabel(paramObject.toString()));
    }
    do
    {
      return;
      if ((paramObject instanceof AbstractSequence))
      {
        paramObject = (AbstractSequence)paramObject;
        int i = ((AbstractSequence)paramObject).startPos();
        for (;;)
        {
          i = ((AbstractSequence)paramObject).nextPos(i);
          if (i == 0) {
            break;
          }
          addComponent(((AbstractSequence)paramObject).getPosPrevious(i));
        }
      }
      if ((paramObject instanceof Viewable))
      {
        ((Viewable)paramObject).makeView(getDisplay(), getContentPane());
        return;
      }
      if ((paramObject instanceof Paintable))
      {
        getContentPane().add(new SwingPaintable((Paintable)paramObject));
        return;
      }
    } while (paramObject == null);
    getContentPane().add((Component)paramObject);
  }
  
  public Display getDisplay()
  {
    return this.display;
  }
  
  public void open()
  {
    pack();
    setVisible(true);
  }
  
  public void setContent(Object paramObject)
  {
    setContentPane(new JPanel());
    addComponent(paramObject);
    pack();
  }
  
  public void setMenuBar(Object paramObject)
  {
    setJMenuBar((JMenuBar)paramObject);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\swingviews\SwingFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */