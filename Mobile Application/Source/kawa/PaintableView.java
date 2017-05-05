package kawa;

import gnu.kawa.models.Paintable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position.Bias;
import javax.swing.text.View;

class PaintableView
  extends View
{
  Rectangle2D bounds;
  Paintable p;
  
  public PaintableView(Element paramElement, Paintable paramPaintable)
  {
    super(paramElement);
    this.p = paramPaintable;
    this.bounds = paramPaintable.getBounds2D();
  }
  
  public float getAlignment(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getAlignment(paramInt);
    }
    return 1.0F;
  }
  
  public float getPreferredSpan(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Invalid axis: " + paramInt);
    case 0: 
      return (float)this.bounds.getWidth();
    }
    return (float)this.bounds.getHeight();
  }
  
  public Shape modelToView(int paramInt, Shape paramShape, Position.Bias paramBias)
    throws BadLocationException
  {
    int i = getStartOffset();
    int j = getEndOffset();
    if ((paramInt >= i) && (paramInt <= j))
    {
      paramShape = paramShape.getBounds();
      if (paramInt == j) {
        paramShape.x += paramShape.width;
      }
      paramShape.width = 0;
      return paramShape;
    }
    throw new BadLocationException(paramInt + " not in range " + i + "," + j, paramInt);
  }
  
  public void paint(Graphics paramGraphics, Shape paramShape)
  {
    paramGraphics = (Graphics2D)paramGraphics;
    Rectangle localRectangle = paramShape.getBounds();
    paramShape = paramGraphics.getTransform();
    Paint localPaint = paramGraphics.getPaint();
    try
    {
      paramGraphics.translate(localRectangle.x, localRectangle.y);
      paramGraphics.setPaint(Color.BLACK);
      this.p.paint(paramGraphics);
      return;
    }
    finally
    {
      paramGraphics.setTransform(paramShape);
      paramGraphics.setPaint(localPaint);
    }
  }
  
  public int viewToModel(float paramFloat1, float paramFloat2, Shape paramShape, Position.Bias[] paramArrayOfBias)
  {
    paramShape = (Rectangle)paramShape;
    if (paramFloat1 < paramShape.x + paramShape.width / 2)
    {
      paramArrayOfBias[0] = Position.Bias.Forward;
      return getStartOffset();
    }
    paramArrayOfBias[0] = Position.Bias.Backward;
    return getEndOffset();
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\PaintableView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */