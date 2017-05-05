package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

@SimpleObject
public class HVArrangement
  extends AndroidViewComponent
  implements Component, ComponentContainer
{
  private static final String LOG_TAG = "HVArrangement";
  private AlignmentUtil alignmentSetter;
  private final Handler androidUIHandler = new Handler();
  private int backgroundColor;
  private Drawable backgroundImageDrawable;
  private final Activity context;
  private Drawable defaultButtonDrawable;
  private ViewGroup frameContainer;
  private int horizontalAlignment;
  private String imagePath = "";
  private final int orientation;
  private boolean scrollable = false;
  private int verticalAlignment;
  private final LinearLayout viewLayout;
  
  public HVArrangement(ComponentContainer paramComponentContainer, int paramInt, boolean paramBoolean)
  {
    super(paramComponentContainer);
    this.context = paramComponentContainer.$context();
    this.orientation = paramInt;
    this.scrollable = paramBoolean;
    this.viewLayout = new LinearLayout(this.context, paramInt, Integer.valueOf(100), Integer.valueOf(100));
    this.viewLayout.setBaselineAligned(false);
    this.alignmentSetter = new AlignmentUtil(this.viewLayout);
    this.horizontalAlignment = 1;
    this.verticalAlignment = 1;
    this.alignmentSetter.setHorizontalAlignment(this.horizontalAlignment);
    this.alignmentSetter.setVerticalAlignment(this.verticalAlignment);
    if (paramBoolean) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.frameContainer.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
      this.frameContainer.addView(this.viewLayout.getLayoutManager(), new ViewGroup.LayoutParams(-1, -1));
      this.defaultButtonDrawable = getView().getBackground();
      paramComponentContainer.$add(this);
      BackgroundColor(0);
      return;
      Log.d("HVArrangement", "Setting up frameContainer = ScrollView()");
      this.frameContainer = new ScrollView(this.context);
      continue;
      Log.d("HVArrangement", "Setting up frameContainer = HorizontalScrollView()");
      this.frameContainer = new HorizontalScrollView(this.context);
      continue;
      Log.d("HVArrangement", "Setting up frameContainer = FrameLayout()");
      this.frameContainer = new FrameLayout(this.context);
    }
  }
  
  private void updateAppearance()
  {
    if (this.backgroundImageDrawable == null)
    {
      if (this.backgroundColor == 0)
      {
        ViewUtil.setBackgroundDrawable(this.viewLayout.getLayoutManager(), this.defaultButtonDrawable);
        return;
      }
      ViewUtil.setBackgroundDrawable(this.viewLayout.getLayoutManager(), null);
      this.viewLayout.getLayoutManager().setBackgroundColor(this.backgroundColor);
      return;
    }
    ViewUtil.setBackgroundImage(this.viewLayout.getLayoutManager(), this.backgroundImageDrawable);
  }
  
  public void $add(AndroidViewComponent paramAndroidViewComponent)
  {
    this.viewLayout.add(paramAndroidViewComponent);
  }
  
  public Activity $context()
  {
    return this.context;
  }
  
  public Form $form()
  {
    return this.container.$form();
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how contents of the arrangement are aligned  horizontally. The choices are: 1 = left aligned, 2 = right aligned,  3 = horizontally centered.  Alignment has no effect if the arrangement's width is automatic.")
  public int AlignHorizontal()
  {
    return this.horizontalAlignment;
  }
  
  @DesignerProperty(defaultValue="1", editorType="horizontal_alignment")
  @SimpleProperty
  public void AlignHorizontal(int paramInt)
  {
    try
    {
      this.alignmentSetter.setHorizontalAlignment(paramInt);
      this.horizontalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how the contents of the arrangement are aligned  vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom.  Alignment has no effect if the arrangement's height is automatic.")
  public int AlignVertical()
  {
    return this.verticalAlignment;
  }
  
  @DesignerProperty(defaultValue="1", editorType="vertical_alignment")
  @SimpleProperty
  public void AlignVertical(int paramInt)
  {
    try
    {
      this.alignmentSetter.setVerticalAlignment(paramInt);
      this.verticalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Returns the component's background color")
  public int BackgroundColor()
  {
    return this.backgroundColor;
  }
  
  @DesignerProperty(defaultValue="&H00000000", editorType="color")
  @SimpleProperty(description="Specifies the component's background color. The background color will not be visible if an Image is being displayed.")
  public void BackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    updateAppearance();
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public String Image()
  {
    return this.imagePath;
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(description="Specifies the path of the component's image.  If there is both an Image and a BackgroundColor, only the Image will be visible.")
  public void Image(String paramString)
  {
    if ((paramString.equals(this.imagePath)) && (this.backgroundImageDrawable != null)) {
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.imagePath = str;
    this.backgroundImageDrawable = null;
    if (this.imagePath.length() > 0) {}
    try
    {
      this.backgroundImageDrawable = MediaUtil.getBitmapDrawable(this.container.$form(), this.imagePath);
      updateAppearance();
      return;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  public View getView()
  {
    return this.frameContainer;
  }
  
  public void setChildHeight(final AndroidViewComponent paramAndroidViewComponent, final int paramInt)
  {
    int j = this.container.$form().Height();
    if (j == 0) {
      this.androidUIHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          Log.d("HVArrangement", "(HVArrangement)Height not stable yet... trying again");
          HVArrangement.this.setChildHeight(paramAndroidViewComponent, paramInt);
        }
      }, 100L);
    }
    int i = paramInt;
    if (paramInt <= 64536) {
      i = -(paramInt + 1000) * j / 100;
    }
    paramAndroidViewComponent.setLastHeight(i);
    if (this.orientation == 0)
    {
      ViewUtil.setChildHeightForHorizontalLayout(paramAndroidViewComponent.getView(), i);
      return;
    }
    ViewUtil.setChildHeightForVerticalLayout(paramAndroidViewComponent.getView(), i);
  }
  
  public void setChildWidth(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    setChildWidth(paramAndroidViewComponent, paramInt, 0);
  }
  
  public void setChildWidth(final AndroidViewComponent paramAndroidViewComponent, final int paramInt1, final int paramInt2)
  {
    int i = this.container.$form().Width();
    if ((i == 0) && (paramInt2 < 2)) {
      this.androidUIHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          Log.d("HVArrangement", "(HVArrangement)Width not stable yet... trying again");
          HVArrangement.this.setChildWidth(paramAndroidViewComponent, paramInt1, paramInt2 + 1);
        }
      }, 100L);
    }
    paramInt2 = paramInt1;
    if (paramInt1 <= 64536)
    {
      Log.d("HVArrangement", "HVArrangement.setChildWidth(): width = " + paramInt1 + " parent Width = " + i + " child = " + paramAndroidViewComponent);
      paramInt2 = -(paramInt1 + 1000) * i / 100;
    }
    paramAndroidViewComponent.setLastWidth(paramInt2);
    if (this.orientation == 0)
    {
      ViewUtil.setChildWidthForHorizontalLayout(paramAndroidViewComponent.getView(), paramInt2);
      return;
    }
    ViewUtil.setChildWidthForVerticalLayout(paramAndroidViewComponent.getView(), paramInt2);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\HVArrangement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */