package kawa;

import gnu.kawa.models.Paintable;
import gnu.kawa.models.Viewable;
import gnu.kawa.swingviews.SwingDisplay;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

class ReplEditorKit
  extends StyledEditorKit
{
  ViewFactory factory;
  final ReplPane pane;
  ViewFactory styledFactory;
  
  public ReplEditorKit(final ReplPane paramReplPane)
  {
    this.pane = paramReplPane;
    this.styledFactory = super.getViewFactory();
    this.factory = new ViewFactory()
    {
      public View create(Element paramAnonymousElement)
      {
        String str = paramAnonymousElement.getName();
        if (str == "Viewable") {
          new ComponentView(paramAnonymousElement)
          {
            protected Component createComponent()
            {
              Object localObject = getElement().getAttributes();
              JPanel localJPanel = new JPanel();
              ((Viewable)((AttributeSet)localObject).getAttribute(ReplPane.ViewableAttribute)).makeView(SwingDisplay.getInstance(), localJPanel);
              if (localJPanel.getComponentCount() == 1)
              {
                localObject = localJPanel.getComponent(0);
                localJPanel.removeAll();
                return (Component)localObject;
              }
              localJPanel.setBackground(ReplEditorKit.1.this.val$pane.getBackground());
              return localJPanel;
            }
          };
        }
        if (str == "Paintable") {
          return new PaintableView(paramAnonymousElement, (Paintable)paramAnonymousElement.getAttributes().getAttribute(ReplPane.PaintableAttribute));
        }
        return ReplEditorKit.this.styledFactory.create(paramAnonymousElement);
      }
    };
  }
  
  public ViewFactory getViewFactory()
  {
    return this.factory;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\ReplEditorKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */