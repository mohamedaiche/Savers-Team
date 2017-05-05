package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.USERINTERFACE, description="Component for displaying images.  The picture to display, and other aspects of the Image's appearance, can be specified in the Designer or in the Blocks Editor.", version=3)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public final class Image
  extends AndroidViewComponent
{
  private String picturePath = "";
  private double rotationAngle = 0.0D;
  private int scalingMode = 0;
  private final ImageView view;
  
  public Image(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.view = new ImageView(paramComponentContainer.$context())
    {
      public boolean verifyDrawable(Drawable paramAnonymousDrawable)
      {
        super.verifyDrawable(paramAnonymousDrawable);
        return true;
      }
    };
    this.view.setFocusable(true);
    paramComponentContainer.$add(this);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="This is a limited form of animation that can attach a small number of motion types to images.  The allowable motions are ScrollRightSlow, ScrollRight, ScrollRightFast, ScrollLeftSlow, ScrollLeft, ScrollLeftFast, and Stop")
  public void Animation(String paramString)
  {
    AnimationUtil.ApplyAnimation(this.view, paramString);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public String Picture()
  {
    return this.picturePath;
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void Picture(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.picturePath = str;
    try
    {
      paramString = MediaUtil.getBitmapDrawable(this.container.$form(), this.picturePath);
      ViewUtil.setImage(this.view, paramString);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("Image", "Unable to load " + this.picturePath);
        paramString = null;
      }
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The angle at which the image picture appears rotated. This rotation does not appear on the designer screen, only on the device.")
  public double RotationAngle()
  {
    return this.rotationAngle;
  }
  
  @DesignerProperty(defaultValue="0.0", editorType="float")
  @SimpleProperty
  public void RotationAngle(double paramDouble)
  {
    if (this.rotationAngle == paramDouble) {
      return;
    }
    if (SdkLevel.getLevel() < 11)
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "RotationAngle", 3001, new Object[0]);
      return;
    }
    HoneycombUtil.viewSetRotate(this.view, paramDouble);
    this.rotationAngle = paramDouble;
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty(description="Specifies whether the image should be resized to match the size of the ImageView.")
  public void ScalePictureToFit(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.view.setScaleType(ImageView.ScaleType.FIT_XY);
      return;
    }
    this.view.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  @SimpleProperty
  public int Scaling()
  {
    return this.scalingMode;
  }
  
  @SimpleProperty(description="This property determines how the picture scales according to the Height or Width of the Image. Scale proportionally (0) preserves the picture aspect ratio. Scale to fit (1) matches the Image area, even if the aspect ratio changes.")
  @Deprecated
  public void Scaling(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentError("Illegal scaling mode: " + paramInt);
    case 0: 
      this.view.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      this.scalingMode = paramInt;
      return;
      this.view.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public View getView()
  {
    return this.view;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\Image.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */