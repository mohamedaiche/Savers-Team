package com.google.appinventor.components.runtime;

import android.view.View;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimplePropertyCopier;

@SimpleObject
public abstract class AndroidViewComponent
  extends VisibleComponent
{
  private int column = -1;
  protected final ComponentContainer container;
  private int lastSetHeight = -3;
  private int lastSetWidth = -3;
  private int percentHeightHolder = -3;
  private int percentWidthHolder = -3;
  private int row = -1;
  
  protected AndroidViewComponent(ComponentContainer paramComponentContainer)
  {
    this.container = paramComponentContainer;
  }
  
  @SimpleProperty(userVisible=false)
  public int Column()
  {
    return this.column;
  }
  
  @SimpleProperty(userVisible=false)
  public void Column(int paramInt)
  {
    this.column = paramInt;
  }
  
  @SimplePropertyCopier
  public void CopyHeight(AndroidViewComponent paramAndroidViewComponent)
  {
    Height(paramAndroidViewComponent.lastSetHeight);
  }
  
  @SimplePropertyCopier
  public void CopyWidth(AndroidViewComponent paramAndroidViewComponent)
  {
    Width(paramAndroidViewComponent.lastSetWidth);
  }
  
  @SimpleProperty
  public int Height()
  {
    return (int)(getView().getHeight() / this.container.$form().deviceDensity());
  }
  
  @SimpleProperty
  public void Height(int paramInt)
  {
    this.container.setChildHeight(this, paramInt);
    this.lastSetHeight = paramInt;
    if (paramInt <= 64536) {
      this.container.$form().registerPercentLength(this, paramInt, Form.PercentStorageRecord.Dim.HEIGHT);
    }
  }
  
  @SimpleProperty
  public void HeightPercent(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 100))
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "HeightPercent", 2801, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    Height(-paramInt - 1000);
  }
  
  @SimpleProperty(userVisible=false)
  public int Row()
  {
    return this.row;
  }
  
  @SimpleProperty(userVisible=false)
  public void Row(int paramInt)
  {
    this.row = paramInt;
  }
  
  @DesignerProperty(defaultValue="True", editorType="visibility")
  @SimpleProperty(description="Specifies whether the component should be visible on the screen. Value is true if the component is showing and false if hidden.")
  public void Visible(Boolean paramBoolean)
  {
    View localView = getView();
    if (paramBoolean.booleanValue()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public boolean Visible()
  {
    return getView().getVisibility() == 0;
  }
  
  @SimpleProperty
  public int Width()
  {
    return (int)(getView().getWidth() / this.container.$form().deviceDensity());
  }
  
  @SimpleProperty
  public void Width(int paramInt)
  {
    this.container.setChildWidth(this, paramInt);
    this.lastSetWidth = paramInt;
    if (paramInt <= 64536) {
      this.container.$form().registerPercentLength(this, paramInt, Form.PercentStorageRecord.Dim.WIDTH);
    }
  }
  
  @SimpleProperty
  public void WidthPercent(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 100))
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "WidthPercent", 2801, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    Width(-paramInt - 1000);
  }
  
  public HandlesEventDispatching getDispatchDelegate()
  {
    return this.container.$form();
  }
  
  public int getSetHeight()
  {
    if (this.percentHeightHolder == -3) {
      return Height();
    }
    return this.percentHeightHolder;
  }
  
  public int getSetWidth()
  {
    if (this.percentWidthHolder == -3) {
      return Width();
    }
    return this.percentWidthHolder;
  }
  
  public abstract View getView();
  
  public void setLastHeight(int paramInt)
  {
    this.percentHeightHolder = paramInt;
  }
  
  public void setLastWidth(int paramInt)
  {
    this.percentWidthHolder = paramInt;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\AndroidViewComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */