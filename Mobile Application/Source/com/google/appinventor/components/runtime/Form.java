package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.collect.Sets;
import com.google.appinventor.components.runtime.multidex.MultiDex;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import com.google.appinventor.components.runtime.util.ScreenDensityUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.LAYOUT, description="Top-level component containing all other components in the program", showOnPalette=false, version=20)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.ACCESS_WIFI_STATE,android.permission.ACCESS_NETWORK_STATE")
public class Form
  extends Activity
  implements Component, ComponentContainer, HandlesEventDispatching, ViewTreeObserver.OnGlobalLayoutListener
{
  public static final String APPINVENTOR_URL_SCHEME = "appinventor";
  private static final String ARGUMENT_NAME = "APP_INVENTOR_START";
  private static final String LOG_TAG = "Form";
  private static final String RESULT_NAME = "APP_INVENTOR_RESULT";
  private static final int SWITCH_FORM_REQUEST_CODE = 1;
  private static boolean _initialized = false;
  protected static Form activeForm;
  private static boolean applicationIsBeingClosed;
  private static long minimumToastWait;
  private static int nextRequestCode = 2;
  private static boolean sCompatibilityMode;
  private static boolean showListsAsJson = false;
  private String aboutScreen;
  private final HashMap<Integer, ActivityResultListener> activityResultMap = Maps.newHashMap();
  private AlignmentUtil alignmentSetter;
  private final Handler androidUIHandler = new Handler();
  private int backgroundColor;
  private Drawable backgroundDrawable;
  private String backgroundImagePath = "";
  private String closeAnimType;
  private float compatScalingFactor;
  private float deviceDensity;
  private ArrayList<PercentStorageRecord> dimChanges = new ArrayList();
  private int formHeight;
  protected String formName;
  private int formWidth;
  private FrameLayout frameLayout;
  private FullScreenVideoUtil fullScreenVideoUtil;
  private int horizontalAlignment;
  private boolean keyboardShown = false;
  private long lastToastTime = System.nanoTime() - minimumToastWait;
  private String nextFormName;
  private final Set<OnCreateOptionsMenuListener> onCreateOptionsMenuListeners = Sets.newHashSet();
  private final Set<OnDestroyListener> onDestroyListeners = Sets.newHashSet();
  private final Set<OnInitializeListener> onInitializeListeners = Sets.newHashSet();
  private final Set<OnNewIntentListener> onNewIntentListeners = Sets.newHashSet();
  private final Set<OnOptionsItemSelectedListener> onOptionsItemSelectedListeners = Sets.newHashSet();
  private final Set<OnPauseListener> onPauseListeners = Sets.newHashSet();
  private final Set<OnResumeListener> onResumeListeners = Sets.newHashSet();
  private final Set<OnStopListener> onStopListeners = Sets.newHashSet();
  private String openAnimType;
  private ProgressDialog progress;
  private ScaledFrameLayout scaleLayout;
  private boolean screenInitialized;
  private boolean scrollable;
  private boolean showStatusBar = true;
  private boolean showTitle = true;
  protected String startupValue = "";
  private int verticalAlignment;
  private LinearLayout viewLayout;
  private String yandexTranslateTagline = "";
  
  static
  {
    minimumToastWait = 10000000000L;
  }
  
  private void closeApplication()
  {
    applicationIsBeingClosed = true;
    finish();
    if (this.formName.equals("Screen1")) {
      System.exit(0);
    }
  }
  
  private void closeApplicationFromMenu()
  {
    closeApplication();
  }
  
  private static Object decodeJSONStringForForm(String paramString1, String paramString2)
  {
    Log.i("Form", "decodeJSONStringForForm -- decoding JSON representation:" + paramString1);
    Object localObject1 = "";
    try
    {
      Object localObject2 = JsonUtil.getObjectFromJson(paramString1);
      localObject1 = localObject2;
      Log.i("Form", "decodeJSONStringForForm -- got decoded JSON:" + localObject2.toString());
      return localObject2;
    }
    catch (JSONException localJSONException)
    {
      activeForm.dispatchErrorOccurredEvent(activeForm, paramString2, 903, new Object[] { paramString1 });
    }
    return localObject1;
  }
  
  private void defaultPropertyValues()
  {
    Scrollable(false);
    Sizing("Fixed");
    BackgroundImage("");
    AboutScreen("");
    BackgroundImage("");
    BackgroundColor(-1);
    AlignHorizontal(1);
    AlignVertical(1);
    Title("");
    ShowStatusBar(true);
    TitleVisible(true);
    ShowListsAsJson(false);
  }
  
  public static void finishActivity()
  {
    if (activeForm != null)
    {
      activeForm.closeForm(null);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishActivityWithResult(Object paramObject)
  {
    if (activeForm != null)
    {
      if ((activeForm instanceof ReplForm))
      {
        ((ReplForm)activeForm).setResult(paramObject);
        activeForm.closeForm(null);
        return;
      }
      paramObject = jsonEncodeForForm(paramObject, "close screen with value");
      Intent localIntent = new Intent();
      localIntent.putExtra("APP_INVENTOR_RESULT", (String)paramObject);
      activeForm.closeForm(localIntent);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishActivityWithTextResult(String paramString)
  {
    if (activeForm != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("APP_INVENTOR_RESULT", paramString);
      activeForm.closeForm(localIntent);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void finishApplication()
  {
    if (activeForm != null)
    {
      activeForm.closeApplicationFromBlocks();
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  private static int generateNewRequestCode()
  {
    int i = nextRequestCode;
    nextRequestCode = i + 1;
    return i;
  }
  
  public static Form getActiveForm()
  {
    return activeForm;
  }
  
  public static boolean getCompatibilityMode()
  {
    return sCompatibilityMode;
  }
  
  public static String getStartText()
  {
    if (activeForm != null) {
      return activeForm.startupValue;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static Object getStartValue()
  {
    if (activeForm != null) {
      return decodeJSONStringForForm(activeForm.startupValue, "get start value");
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  protected static String jsonEncodeForForm(Object paramObject, String paramString)
  {
    Object localObject = "";
    Log.i("Form", "jsonEncodeForForm -- creating JSON representation:" + paramObject.toString());
    try
    {
      String str = JsonUtil.getJsonRepresentation(paramObject);
      localObject = str;
      Log.i("Form", "jsonEncodeForForm -- got JSON representation:" + str);
      return str;
    }
    catch (JSONException localJSONException)
    {
      activeForm.dispatchErrorOccurredEvent(activeForm, paramString, 904, new Object[] { paramObject.toString() });
    }
    return (String)localObject;
  }
  
  private void recomputeLayout()
  {
    Log.d("Form", "recomputeLayout called");
    if (this.frameLayout != null) {
      this.frameLayout.removeAllViews();
    }
    if (this.scrollable) {}
    for (Object localObject = new ScrollView(this);; localObject = new FrameLayout(this))
    {
      this.frameLayout = ((FrameLayout)localObject);
      this.frameLayout.addView(this.viewLayout.getLayoutManager(), new ViewGroup.LayoutParams(-1, -1));
      setBackground(this.frameLayout);
      Log.d("Form", "About to create a new ScaledFrameLayout");
      this.scaleLayout = new ScaledFrameLayout(this);
      this.scaleLayout.addView(this.frameLayout, new ViewGroup.LayoutParams(-1, -1));
      setContentView(this.scaleLayout);
      this.frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
      this.scaleLayout.requestLayout();
      this.androidUIHandler.post(new Runnable()
      {
        public void run()
        {
          if ((Form.this.frameLayout != null) && (Form.this.frameLayout.getWidth() != 0) && (Form.this.frameLayout.getHeight() != 0))
          {
            if (Form.sCompatibilityMode) {
              Form.this.Sizing("Fixed");
            }
            for (;;)
            {
              Form.this.ReplayFormOrientation();
              Form.this.frameLayout.requestLayout();
              return;
              Form.this.Sizing("Responsive");
            }
          }
          Form.this.androidUIHandler.post(this);
        }
      });
      return;
    }
  }
  
  private void setBackground(View paramView)
  {
    int i = -1;
    Object localObject = this.backgroundDrawable;
    if ((this.backgroundImagePath != "") && (localObject != null))
    {
      localObject = this.backgroundDrawable.getConstantState().newDrawable();
      if (this.backgroundColor != 0) {
        i = this.backgroundColor;
      }
      ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.DST_OVER);
    }
    for (;;)
    {
      ViewUtil.setBackgroundImage(paramView, (Drawable)localObject);
      paramView.invalidate();
      return;
      if (this.backgroundColor != 0) {
        i = this.backgroundColor;
      }
      localObject = new ColorDrawable(i);
    }
  }
  
  private void showAboutApplicationNotification()
  {
    Notifier.oneButtonAlert(this, (this.aboutScreen + "<p><small><em>Invented with MIT App Inventor<br>appinventor.mit.edu</em></small></p>" + this.yandexTranslateTagline).replaceAll("\\n", "<br>"), "About this app", "Got it");
  }
  
  private void showExitApplicationNotification()
  {
    Runnable local10 = new Runnable()
    {
      public void run()
      {
        Form.this.closeApplicationFromMenu();
      }
    };
    Runnable local11 = new Runnable()
    {
      public void run() {}
    };
    Notifier.twoButtonDialog(this, "Stop this application and exit? You'll need to relaunch the application to use it again.", "Stop application?", "Stop and exit", "Don't stop", false, local10, local11, local11);
  }
  
  public static void switchForm(String paramString)
  {
    if (activeForm != null)
    {
      activeForm.startNewForm(paramString, null);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public static void switchFormWithStartValue(String paramString, Object paramObject)
  {
    Log.i("Form", "Open another screen with start value:" + paramString);
    if (activeForm != null)
    {
      activeForm.startNewForm(paramString, paramObject);
      return;
    }
    throw new IllegalStateException("activeForm is null");
  }
  
  public void $add(AndroidViewComponent paramAndroidViewComponent)
  {
    this.viewLayout.add(paramAndroidViewComponent);
  }
  
  public Activity $context()
  {
    return this;
  }
  
  protected void $define()
  {
    throw new UnsupportedOperationException();
  }
  
  public Form $form()
  {
    return this;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Information about the screen.  It appears when \"About this Application\" is selected from the system menu. Use it to inform people about your app.  In multiple screen apps, each screen has its own AboutScreen info.")
  public String AboutScreen()
  {
    return this.aboutScreen;
  }
  
  @DesignerProperty(defaultValue="", editorType="textArea")
  @SimpleProperty
  public void AboutScreen(String paramString)
  {
    this.aboutScreen = paramString;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how contents of the screen are aligned  horizontally. The choices are: 1 = left aligned, 2 = horizontally centered,  3 = right aligned.")
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
      dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how the contents of the arrangement are aligned vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom. Vertical alignment has no effect if the screen is scrollable.")
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
      dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(description="This is the display name of the installed application in the phone.If the AppName is blank, it will be set to the name of the project when the project is built.", userVisible=false)
  public void AppName(String paramString) {}
  
  @SimpleEvent(description="Device back button pressed.")
  public boolean BackPressed()
  {
    return EventDispatcher.dispatchEvent(this, "BackPressed", new Object[0]);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public int BackgroundColor()
  {
    return this.backgroundColor;
  }
  
  @DesignerProperty(defaultValue="&HFFFFFFFF", editorType="color")
  @SimpleProperty
  public void BackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    setBackground(this.frameLayout);
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The screen background image.")
  public String BackgroundImage()
  {
    return this.backgroundImagePath;
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The screen background image.")
  public void BackgroundImage(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.backgroundImagePath = str;
    try
    {
      this.backgroundDrawable = MediaUtil.getBitmapDrawable(this, this.backgroundImagePath);
      setBackground(this.frameLayout);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("Form", "Unable to load " + this.backgroundImagePath);
        this.backgroundDrawable = null;
      }
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The animation for closing current screen and returning  to the previous screen. Valid options are default, fade, zoom, slidehorizontal, slidevertical, and none")
  public String CloseScreenAnimation()
  {
    return this.closeAnimType;
  }
  
  @DesignerProperty(defaultValue="default", editorType="screen_animation")
  @SimpleProperty
  public void CloseScreenAnimation(String paramString)
  {
    if ((paramString != "default") && (paramString != "fade") && (paramString != "zoom") && (paramString != "slidehorizontal") && (paramString != "slidevertical") && (paramString != "none"))
    {
      dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] { paramString });
      return;
    }
    this.closeAnimType = paramString;
  }
  
  @SimpleEvent(description="Event raised when an error occurs. Only some errors will raise this condition.  For those errors, the system will show a notification by default.  You can use this event handler to prescribe an error behavior different than the default.")
  public void ErrorOccurred(Component paramComponent, String paramString1, int paramInt, String paramString2)
  {
    String str = paramComponent.getClass().getName();
    str = str.substring(str.lastIndexOf(".") + 1);
    Log.e("Form", "Form " + this.formName + " ErrorOccurred, errorNumber = " + paramInt + ", componentType = " + str + ", functionName = " + paramString1 + ", messages = " + paramString2);
    if ((!EventDispatcher.dispatchEvent(this, "ErrorOccurred", new Object[] { paramComponent, paramString1, Integer.valueOf(paramInt), paramString2 })) && (this.screenInitialized)) {
      new Notifier(this).ShowAlert("Error " + paramInt + ": " + paramString2);
    }
  }
  
  public void ErrorOccurredDialog(Component paramComponent, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    String str = paramComponent.getClass().getName();
    str = str.substring(str.lastIndexOf(".") + 1);
    Log.e("Form", "Form " + this.formName + " ErrorOccurred, errorNumber = " + paramInt + ", componentType = " + str + ", functionName = " + paramString1 + ", messages = " + paramString2);
    if ((!EventDispatcher.dispatchEvent(this, "ErrorOccurred", new Object[] { paramComponent, paramString1, Integer.valueOf(paramInt), paramString2 })) && (this.screenInitialized)) {
      new Notifier(this).ShowMessageDialog("Error " + paramInt + ": " + paramString2, paramString3, paramString4);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Screen height (y-size).")
  public int Height()
  {
    Log.d("Form", "Form.Height = " + this.formHeight);
    return this.formHeight;
  }
  
  @SimpleFunction(description="Hide the onscreen soft keyboard.")
  public void HideKeyboard()
  {
    View localView = getCurrentFocus();
    if (localView != null)
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      return;
    }
    dispatchErrorOccurredEvent(this, "HideKeyboard", 906, new Object[0]);
  }
  
  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(userVisible=false)
  public void Icon(String paramString) {}
  
  @SimpleEvent(description="Screen starting")
  public void Initialize()
  {
    this.androidUIHandler.post(new Runnable()
    {
      public void run()
      {
        if ((Form.this.frameLayout != null) && (Form.this.frameLayout.getWidth() != 0) && (Form.this.frameLayout.getHeight() != 0))
        {
          EventDispatcher.dispatchEvent(Form.this, "Initialize", new Object[0]);
          if (Form.sCompatibilityMode) {
            Form.this.Sizing("Fixed");
          }
          for (;;)
          {
            Form.access$502(Form.this, true);
            Iterator localIterator = Form.this.onInitializeListeners.iterator();
            while (localIterator.hasNext()) {
              ((OnInitializeListener)localIterator.next()).onInitialize();
            }
            Form.this.Sizing("Responsive");
          }
          if ((Form.activeForm instanceof ReplForm)) {
            ((ReplForm)Form.activeForm).HandleReturnValues();
          }
          return;
        }
        Form.this.androidUIHandler.post(this);
      }
    });
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The animation for switching to another screen. Valid options are default, fade, zoom, slidehorizontal, slidevertical, and none")
  public String OpenScreenAnimation()
  {
    return this.openAnimType;
  }
  
  @DesignerProperty(defaultValue="default", editorType="screen_animation")
  @SimpleProperty
  public void OpenScreenAnimation(String paramString)
  {
    if ((paramString != "default") && (paramString != "fade") && (paramString != "zoom") && (paramString != "slidehorizontal") && (paramString != "slidevertical") && (paramString != "none"))
    {
      dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] { paramString });
      return;
    }
    this.openAnimType = paramString;
  }
  
  @SimpleEvent(description="Event raised when another screen has closed and control has returned to this screen.")
  public void OtherScreenClosed(String paramString, Object paramObject)
  {
    Log.i("Form", "Form " + this.formName + " OtherScreenClosed, otherScreenName = " + paramString + ", result = " + paramObject.toString());
    EventDispatcher.dispatchEvent(this, "OtherScreenClosed", new Object[] { paramString, paramObject });
  }
  
  void ReplayFormOrientation()
  {
    Log.d("Form", "ReplayFormOrientation()");
    ArrayList localArrayList = (ArrayList)this.dimChanges.clone();
    this.dimChanges.clear();
    int i = 0;
    if (i < localArrayList.size())
    {
      PercentStorageRecord localPercentStorageRecord = (PercentStorageRecord)localArrayList.get(i);
      if (localPercentStorageRecord.dim == Form.PercentStorageRecord.Dim.HEIGHT) {
        localPercentStorageRecord.component.Height(localPercentStorageRecord.length);
      }
      for (;;)
      {
        i += 1;
        break;
        localPercentStorageRecord.component.Width(localPercentStorageRecord.length);
      }
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The requested screen orientation, specified as a text value.  Commonly used values are landscape, portrait, sensor, user and unspecified.  See the Android developer documentation for ActivityInfo.Screen_Orientation for the complete list of possible settings.")
  public String ScreenOrientation()
  {
    switch (getRequestedOrientation())
    {
    default: 
      return "unspecified";
    case 3: 
      return "behind";
    case 0: 
      return "landscape";
    case 5: 
      return "nosensor";
    case 1: 
      return "portrait";
    case 4: 
      return "sensor";
    case -1: 
      return "unspecified";
    case 2: 
      return "user";
    case 10: 
      return "fullSensor";
    case 8: 
      return "reverseLandscape";
    case 9: 
      return "reversePortrait";
    case 6: 
      return "sensorLandscape";
    }
    return "sensorPortrait";
  }
  
  @DesignerProperty(defaultValue="unspecified", editorType="screen_orientation")
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public void ScreenOrientation(String paramString)
  {
    if (paramString.equalsIgnoreCase("behind"))
    {
      setRequestedOrientation(3);
      return;
    }
    if (paramString.equalsIgnoreCase("landscape"))
    {
      setRequestedOrientation(0);
      return;
    }
    if (paramString.equalsIgnoreCase("nosensor"))
    {
      setRequestedOrientation(5);
      return;
    }
    if (paramString.equalsIgnoreCase("portrait"))
    {
      setRequestedOrientation(1);
      return;
    }
    if (paramString.equalsIgnoreCase("sensor"))
    {
      setRequestedOrientation(4);
      return;
    }
    if (paramString.equalsIgnoreCase("unspecified"))
    {
      setRequestedOrientation(-1);
      return;
    }
    if (paramString.equalsIgnoreCase("user"))
    {
      setRequestedOrientation(2);
      return;
    }
    if (SdkLevel.getLevel() >= 9)
    {
      if (paramString.equalsIgnoreCase("fullSensor"))
      {
        setRequestedOrientation(10);
        return;
      }
      if (paramString.equalsIgnoreCase("reverseLandscape"))
      {
        setRequestedOrientation(8);
        return;
      }
      if (paramString.equalsIgnoreCase("reversePortrait"))
      {
        setRequestedOrientation(9);
        return;
      }
      if (paramString.equalsIgnoreCase("sensorLandscape"))
      {
        setRequestedOrientation(6);
        return;
      }
      if (paramString.equalsIgnoreCase("sensorPortrait"))
      {
        setRequestedOrientation(7);
        return;
      }
      dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] { paramString });
      return;
    }
    dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] { paramString });
  }
  
  @SimpleEvent(description="Screen orientation changed")
  public void ScreenOrientationChanged()
  {
    EventDispatcher.dispatchEvent(this, "ScreenOrientationChanged", new Object[0]);
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void Scrollable(boolean paramBoolean)
  {
    if ((this.scrollable == paramBoolean) && (this.frameLayout != null)) {
      return;
    }
    this.scrollable = paramBoolean;
    recomputeLayout();
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="When checked, there will be a vertical scrollbar on the screen, and the height of the application can exceed the physical height of the device. When unchecked, the application height is constrained to the height of the device.")
  public boolean Scrollable()
  {
    return this.scrollable;
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="If false, lists will be converted to strings using Lisp notation, i.e., as symbols separated by spaces, e.g., (a 1 b2 (c d). If true, lists will appear as in Json or Python, e.g.  [\"a\", 1, \"b\", 2, [\"c\", \"d\"]].  This property appears only in Screen 1, and the value for Screen 1 determines the behavior for all screens. The property defaults to \"false\" meaning that the App Inventor programmer must explicitly set it to \"true\" if JSON/Python syntax is desired. At some point in the future we will alter the system so that new projects are created with this property set to \"true\" by default. Existing projects will not be impacted. The App Inventor programmer can also set it back to \"false\" in newer projects if desired. ", userVisible=false)
  public void ShowListsAsJson(boolean paramBoolean)
  {
    showListsAsJson = paramBoolean;
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public boolean ShowListsAsJson()
  {
    return showListsAsJson;
  }
  
  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public void ShowStatusBar(boolean paramBoolean)
  {
    if (paramBoolean != this.showStatusBar)
    {
      if (!paramBoolean) {
        break label38;
      }
      getWindow().addFlags(2048);
      getWindow().clearFlags(1024);
    }
    for (;;)
    {
      this.showStatusBar = paramBoolean;
      return;
      label38:
      getWindow().addFlags(1024);
      getWindow().clearFlags(2048);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The status bar is the topmost bar on the screen. This property reports whether the status bar is visible.")
  public boolean ShowStatusBar()
  {
    return this.showStatusBar;
  }
  
  @DesignerProperty(defaultValue="Fixed", editorType="sizing")
  @SimpleProperty(description="If set to fixed,  screen layouts will be created for a single fixed-size screen and autoscaled. If set to responsive, screen layouts will use the actual resolution of the device.  See the documentation on responsive design in App Inventor for more information. This property appears on Screen1 only and controls the sizing for all screens in the app.", userVisible=false)
  public void Sizing(String paramString)
  {
    Log.d("Form", "Sizing(" + paramString + ")");
    this.formWidth = ((int)(getResources().getDisplayMetrics().widthPixels / this.deviceDensity));
    this.formHeight = ((int)(getResources().getDisplayMetrics().heightPixels / this.deviceDensity));
    if (paramString.equals("Fixed"))
    {
      sCompatibilityMode = true;
      this.formWidth = ((int)(this.formWidth / this.compatScalingFactor));
      this.formHeight = ((int)(this.formHeight / this.compatScalingFactor));
      paramString = this.scaleLayout;
      if (!sCompatibilityMode) {
        break label203;
      }
    }
    label203:
    for (float f = this.compatScalingFactor;; f = 1.0F)
    {
      paramString.setScale(f);
      if (this.frameLayout != null) {
        this.frameLayout.invalidate();
      }
      Log.d("Form", "formWidth = " + this.formWidth + " formHeight = " + this.formHeight);
      return;
      sCompatibilityMode = false;
      break;
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The caption for the form, which apears in the title bar")
  public String Title()
  {
    return getTitle().toString();
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Title(String paramString)
  {
    setTitle(paramString);
  }
  
  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public void TitleVisible(boolean paramBoolean)
  {
    View localView;
    if (paramBoolean != this.showTitle)
    {
      localView = (View)findViewById(16908310).getParent();
      if (localView != null)
      {
        if (!paramBoolean) {
          break label41;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.showTitle = paramBoolean;
      return;
      label41:
      localView.setVisibility(8);
    }
  }
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The title bar is the top gray bar on the screen. This property reports whether the title bar is visible.")
  public boolean TitleVisible()
  {
    return this.showTitle;
  }
  
  @DesignerProperty(defaultValue="1", editorType="non_negative_integer")
  @SimpleProperty(description="An integer value which must be incremented each time a new Android Application Package File (APK) is created for the Google Play Store.", userVisible=false)
  public void VersionCode(int paramInt) {}
  
  @DesignerProperty(defaultValue="1.0", editorType="string")
  @SimpleProperty(description="A string which can be changed to allow Google Play Store users to distinguish between different versions of the App.", userVisible=false)
  public void VersionName(String paramString) {}
  
  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Screen width (x-size).")
  public int Width()
  {
    Log.d("Form", "Form.Width = " + this.formWidth);
    return this.formWidth;
  }
  
  public void addAboutInfoToMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 2, "About this application").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Form.this.showAboutApplicationNotification();
        return true;
      }
    }).setIcon(17301651);
  }
  
  public void addExitButtonToMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 1, "Stop this application").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Form.this.showExitApplicationNotification();
        return true;
      }
    }).setIcon(17301594);
  }
  
  /* Error */
  public void callInitialize(Object paramObject)
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 676	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: ldc_w 975
    //   7: aconst_null
    //   8: checkcast 977	[Ljava/lang/Class;
    //   11: invokevirtual 981	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   14: astore_2
    //   15: ldc 69
    //   17: new 285	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 983
    //   27: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 313	java/lang/Object:toString	()Ljava/lang/String;
    //   34: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 302	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   43: pop
    //   44: aload_2
    //   45: aload_1
    //   46: aconst_null
    //   47: checkcast 985	[Ljava/lang/Object;
    //   50: invokevirtual 991	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: return
    //   55: astore_1
    //   56: ldc 69
    //   58: new 285	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 993
    //   68: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 996	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 302	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: return
    //   86: astore_1
    //   87: return
    //   88: astore_1
    //   89: ldc 69
    //   91: new 285	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 998
    //   101: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 999	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 302	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: aload_1
    //   119: invokevirtual 1003	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	Form
    //   0	123	1	paramObject	Object
    //   14	31	2	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   0	15	55	java/lang/SecurityException
    //   0	15	86	java/lang/NoSuchMethodException
    //   15	54	88	java/lang/reflect/InvocationTargetException
  }
  
  public boolean canDispatchEvent(Component paramComponent, String paramString)
  {
    if ((this.screenInitialized) || ((paramComponent == this) && (paramString.equals("Initialize")))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        activeForm = this;
      }
      return bool;
    }
  }
  
  public void clear()
  {
    this.viewLayout.getLayoutManager().removeAllViews();
    this.frameLayout.removeAllViews();
    this.frameLayout = null;
    defaultPropertyValues();
    this.onStopListeners.clear();
    this.onNewIntentListeners.clear();
    this.onResumeListeners.clear();
    this.onPauseListeners.clear();
    this.onDestroyListeners.clear();
    this.onInitializeListeners.clear();
    this.onCreateOptionsMenuListeners.clear();
    this.onOptionsItemSelectedListeners.clear();
    this.screenInitialized = false;
    System.err.println("Form.clear() About to do moby GC!");
    System.gc();
    this.dimChanges.clear();
  }
  
  protected void closeApplicationFromBlocks()
  {
    closeApplication();
  }
  
  protected void closeForm(Intent paramIntent)
  {
    if (paramIntent != null) {
      setResult(-1, paramIntent);
    }
    finish();
    AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnimType);
  }
  
  public float compatScalingFactor()
  {
    return this.compatScalingFactor;
  }
  
  public void deleteComponent(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof OnStopListener))
    {
      localObject = (OnStopListener)paramObject;
      if (this.onStopListeners.contains(localObject)) {
        this.onStopListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnNewIntentListener))
    {
      localObject = (OnNewIntentListener)paramObject;
      if (this.onNewIntentListeners.contains(localObject)) {
        this.onNewIntentListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnResumeListener))
    {
      localObject = (OnResumeListener)paramObject;
      if (this.onResumeListeners.contains(localObject)) {
        this.onResumeListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnPauseListener))
    {
      localObject = (OnPauseListener)paramObject;
      if (this.onPauseListeners.contains(localObject)) {
        this.onPauseListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnDestroyListener))
    {
      localObject = (OnDestroyListener)paramObject;
      if (this.onDestroyListeners.contains(localObject)) {
        this.onDestroyListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnInitializeListener))
    {
      localObject = (OnInitializeListener)paramObject;
      if (this.onInitializeListeners.contains(localObject)) {
        this.onInitializeListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnCreateOptionsMenuListener))
    {
      localObject = (OnCreateOptionsMenuListener)paramObject;
      if (this.onCreateOptionsMenuListeners.contains(localObject)) {
        this.onCreateOptionsMenuListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof OnOptionsItemSelectedListener))
    {
      localObject = (OnOptionsItemSelectedListener)paramObject;
      if (this.onOptionsItemSelectedListeners.contains(localObject)) {
        this.onOptionsItemSelectedListeners.remove(localObject);
      }
    }
    if ((paramObject instanceof Deleteable)) {
      ((Deleteable)paramObject).onDelete();
    }
  }
  
  public float deviceDensity()
  {
    return this.deviceDensity;
  }
  
  public void dispatchErrorOccurredEvent(final Component paramComponent, final String paramString, final int paramInt, final Object... paramVarArgs)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        String str = ErrorMessages.formatMessage(paramInt, paramVarArgs);
        Form.this.ErrorOccurred(paramComponent, paramString, paramInt, str);
      }
    });
  }
  
  public void dispatchErrorOccurredEventDialog(final Component paramComponent, final String paramString, final int paramInt, final Object... paramVarArgs)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        String str = ErrorMessages.formatMessage(paramInt, paramVarArgs);
        Form.this.ErrorOccurredDialog(paramComponent, paramString, paramInt, str, "Error in " + paramString, "Dismiss");
      }
    });
  }
  
  public boolean dispatchEvent(Component paramComponent, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void dontGrabTouchEventsForComponent()
  {
    this.frameLayout.requestDisallowInterceptTouchEvent(true);
  }
  
  public Bundle fullScreenVideoAction(int paramInt, VideoPlayer paramVideoPlayer, Object paramObject)
  {
    try
    {
      paramVideoPlayer = this.fullScreenVideoUtil.performAction(paramInt, paramVideoPlayer, paramObject);
      return paramVideoPlayer;
    }
    finally
    {
      paramVideoPlayer = finally;
      throw paramVideoPlayer;
    }
  }
  
  public HandlesEventDispatching getDispatchDelegate()
  {
    return this;
  }
  
  public String getOpenAnimType()
  {
    return this.openAnimType;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("Form", "Form " + this.formName + " got onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    if (paramInt1 == 1) {
      if ((paramIntent != null) && (paramIntent.hasExtra("APP_INVENTOR_RESULT")))
      {
        paramIntent = paramIntent.getStringExtra("APP_INVENTOR_RESULT");
        paramIntent = decodeJSONStringForForm(paramIntent, "other screen closed");
        OtherScreenClosed(this.nextFormName, paramIntent);
      }
    }
    ActivityResultListener localActivityResultListener;
    do
    {
      return;
      paramIntent = "";
      break;
      localActivityResultListener = (ActivityResultListener)this.activityResultMap.get(Integer.valueOf(paramInt1));
    } while (localActivityResultListener == null);
    localActivityResultListener.resultReturned(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.d("Form", "onConfigurationChanged() called");
    final int i = paramConfiguration.orientation;
    if ((i == 2) || (i == 1)) {
      this.androidUIHandler.post(new Runnable()
      {
        public void run()
        {
          int j = 0;
          int i = j;
          if (Form.this.frameLayout != null)
          {
            if (i != 2) {
              break label98;
            }
            i = j;
            if (Form.this.frameLayout.getWidth() >= Form.this.frameLayout.getHeight()) {
              i = 1;
            }
          }
          while (i != 0)
          {
            Form.this.recomputeLayout();
            Form.this.androidUIHandler.postDelayed(new Runnable()
            {
              public void run()
              {
                if (Form.this.frameLayout != null) {
                  Form.this.frameLayout.invalidate();
                }
              }
            }, 100L);
            Form.this.ScreenOrientationChanged();
            return;
            label98:
            i = j;
            if (Form.this.frameLayout.getHeight() >= Form.this.frameLayout.getWidth()) {
              i = 1;
            }
          }
          Form.this.androidUIHandler.post(this);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getClass().getName();
    this.formName = paramBundle.substring(paramBundle.lastIndexOf('.') + 1);
    Log.d("Form", "Form " + this.formName + " got onCreate");
    activeForm = this;
    Log.i("Form", "activeForm is now " + activeForm.formName);
    this.deviceDensity = getResources().getDisplayMetrics().density;
    Log.d("Form", "deviceDensity = " + this.deviceDensity);
    this.compatScalingFactor = ScreenDensityUtil.computeCompatibleScaling(this);
    Log.i("Form", "compatScalingFactor = " + this.compatScalingFactor);
    this.viewLayout = new LinearLayout(this, 1);
    this.alignmentSetter = new AlignmentUtil(this.viewLayout);
    this.progress = null;
    if ((!_initialized) && (this.formName.equals("Screen1")))
    {
      Log.d("Form", "MULTI: _initialized = " + _initialized + " formName = " + this.formName);
      _initialized = true;
      if (ReplApplication.installed)
      {
        Log.d("Form", "MultiDex already installed.");
        onCreateFinish();
        return;
      }
      this.progress = ProgressDialog.show(this, "Please Wait...", "Installation Finishing");
      this.progress.show();
      new MultiDexInstaller(null).execute(new Form[] { this });
      return;
    }
    Log.d("Form", "NO MULTI: _initialized = " + _initialized + " formName = " + this.formName);
    _initialized = true;
    onCreateFinish();
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    return this.fullScreenVideoUtil.createFullScreenVideoDialog();
  }
  
  void onCreateFinish()
  {
    Log.d("Form", "onCreateFinish called " + System.currentTimeMillis());
    if (this.progress != null) {
      this.progress.dismiss();
    }
    defaultPropertyValues();
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("APP_INVENTOR_START"))) {
      this.startupValue = localIntent.getStringExtra("APP_INVENTOR_START");
    }
    this.fullScreenVideoUtil = new FullScreenVideoUtil(this, this.androidUIHandler);
    int i = getWindow().getAttributes().softInputMode;
    getWindow().setSoftInputMode(i | 0x10);
    $define();
    Initialize();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    addExitButtonToMenu(paramMenu);
    addAboutInfoToMenu(paramMenu);
    Iterator localIterator = this.onCreateOptionsMenuListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnCreateOptionsMenuListener)localIterator.next()).onCreateOptionsMenu(paramMenu);
    }
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i("Form", "Form " + this.formName + " got onDestroy");
    EventDispatcher.removeDispatchDelegate(this);
    Iterator localIterator = this.onDestroyListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnDestroyListener)localIterator.next()).onDestroy();
    }
  }
  
  public void onGlobalLayout()
  {
    int i = this.scaleLayout.getRootView().getHeight() - this.scaleLayout.getHeight();
    int j = getWindow().findViewById(16908290).getTop();
    Log.d("Form", "onGlobalLayout(): heightdiff = " + i + " contentViewTop = " + j);
    if (i <= j)
    {
      Log.d("Form", "keyboard hidden!");
      if (this.keyboardShown)
      {
        this.keyboardShown = false;
        if (sCompatibilityMode)
        {
          this.scaleLayout.setScale(this.compatScalingFactor);
          this.scaleLayout.invalidate();
        }
      }
    }
    do
    {
      return;
      Log.d("Form", "keyboard shown!");
      this.keyboardShown = true;
    } while (this.scaleLayout == null);
    this.scaleLayout.setScale(1.0F);
    this.scaleLayout.invalidate();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!BackPressed())
      {
        boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
        AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnimType);
        return bool;
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Log.d("Form", "Form " + this.formName + " got onNewIntent " + paramIntent);
    Iterator localIterator = this.onNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnNewIntentListener)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Iterator localIterator = this.onOptionsItemSelectedListeners.iterator();
    while (localIterator.hasNext()) {
      if (((OnOptionsItemSelectedListener)localIterator.next()).onOptionsItemSelected(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.i("Form", "Form " + this.formName + " got onPause");
    Iterator localIterator = this.onPauseListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnPauseListener)localIterator.next()).onPause();
    }
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      super.onPrepareDialog(paramInt, paramDialog);
      return;
    }
    this.fullScreenVideoUtil.prepareFullScreenVideoDialog(paramDialog);
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i("Form", "Form " + this.formName + " got onResume");
    activeForm = this;
    if (applicationIsBeingClosed) {
      closeApplication();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.onResumeListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnResumeListener)localIterator.next()).onResume();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Log.i("Form", "Form " + this.formName + " got onStop");
    Iterator localIterator = this.onStopListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnStopListener)localIterator.next()).onStop();
    }
  }
  
  public int registerForActivityResult(ActivityResultListener paramActivityResultListener)
  {
    int i = generateNewRequestCode();
    this.activityResultMap.put(Integer.valueOf(i), paramActivityResultListener);
    return i;
  }
  
  public void registerForOnCreateOptionsMenu(OnCreateOptionsMenuListener paramOnCreateOptionsMenuListener)
  {
    this.onCreateOptionsMenuListeners.add(paramOnCreateOptionsMenuListener);
  }
  
  public void registerForOnDestroy(OnDestroyListener paramOnDestroyListener)
  {
    this.onDestroyListeners.add(paramOnDestroyListener);
  }
  
  public void registerForOnInitialize(OnInitializeListener paramOnInitializeListener)
  {
    this.onInitializeListeners.add(paramOnInitializeListener);
  }
  
  public void registerForOnNewIntent(OnNewIntentListener paramOnNewIntentListener)
  {
    this.onNewIntentListeners.add(paramOnNewIntentListener);
  }
  
  public void registerForOnOptionsItemSelected(OnOptionsItemSelectedListener paramOnOptionsItemSelectedListener)
  {
    this.onOptionsItemSelectedListeners.add(paramOnOptionsItemSelectedListener);
  }
  
  public void registerForOnPause(OnPauseListener paramOnPauseListener)
  {
    this.onPauseListeners.add(paramOnPauseListener);
  }
  
  public void registerForOnResume(OnResumeListener paramOnResumeListener)
  {
    this.onResumeListeners.add(paramOnResumeListener);
  }
  
  public void registerForOnStop(OnStopListener paramOnStopListener)
  {
    this.onStopListeners.add(paramOnStopListener);
  }
  
  public void registerPercentLength(AndroidViewComponent paramAndroidViewComponent, int paramInt, Form.PercentStorageRecord.Dim paramDim)
  {
    this.dimChanges.add(new PercentStorageRecord(paramAndroidViewComponent, paramInt, paramDim));
  }
  
  public void runtimeFormErrorOccurredEvent(String paramString1, int paramInt, String paramString2)
  {
    Log.d("FORM_RUNTIME_ERROR", "functionName is " + paramString1);
    Log.d("FORM_RUNTIME_ERROR", "errorNumber is " + paramInt);
    Log.d("FORM_RUNTIME_ERROR", "message is " + paramString2);
    dispatchErrorOccurredEvent(activeForm, paramString1, paramInt, new Object[] { paramString2 });
  }
  
  public void setChildHeight(final AndroidViewComponent paramAndroidViewComponent, final int paramInt)
  {
    if (Height() == 0) {
      this.androidUIHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          System.err.println("(Form)Height not stable yet... trying again");
          Form.this.setChildHeight(paramAndroidViewComponent, paramInt);
        }
      }, 100L);
    }
    int i = paramInt;
    if (paramInt <= 64536) {
      i = Height() * -(paramInt + 1000) / 100;
    }
    paramAndroidViewComponent.setLastHeight(i);
    ViewUtil.setChildHeightForVerticalLayout(paramAndroidViewComponent.getView(), i);
  }
  
  public void setChildWidth(final AndroidViewComponent paramAndroidViewComponent, final int paramInt)
  {
    int j = Width();
    if (j == 0) {
      this.androidUIHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          System.err.println("(Form)Width not stable yet... trying again");
          Form.this.setChildWidth(paramAndroidViewComponent, paramInt);
        }
      }, 100L);
    }
    System.err.println("Form.setChildWidth(): width = " + paramInt + " parent Width = " + j + " child = " + paramAndroidViewComponent);
    int i = paramInt;
    if (paramInt <= 64536) {
      i = -(paramInt + 1000) * j / 100;
    }
    paramAndroidViewComponent.setLastWidth(i);
    ViewUtil.setChildWidthForVerticalLayout(paramAndroidViewComponent.getView(), i);
  }
  
  void setYandexTranslateTagline()
  {
    this.yandexTranslateTagline = "<p><small>Language translation powered by Yandex.Translate</small></p>";
  }
  
  protected void startNewForm(String paramString, Object paramObject)
  {
    Log.i("Form", "startNewForm:" + paramString);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, getPackageName() + "." + paramString);
    String str;
    if (paramObject == null)
    {
      str = "open another screen";
      if (paramObject == null) {
        break label229;
      }
      Log.i("Form", "StartNewForm about to JSON encode:" + paramObject);
      paramObject = jsonEncodeForForm(paramObject, str);
      Log.i("Form", "StartNewForm got JSON encoding:" + (String)paramObject);
    }
    for (;;)
    {
      localIntent.putExtra("APP_INVENTOR_START", (String)paramObject);
      this.nextFormName = paramString;
      Log.i("Form", "about to start new form" + paramString);
      try
      {
        Log.i("Form", "startNewForm starting activity:" + localIntent);
        startActivityForResult(localIntent, 1);
        AnimationUtil.ApplyOpenScreenAnimation(this, this.openAnimType);
        return;
      }
      catch (ActivityNotFoundException paramObject)
      {
        label229:
        dispatchErrorOccurredEvent(this, str, 902, new Object[] { paramString });
      }
      str = "open another screen with start value";
      break;
      paramObject = "";
    }
  }
  
  protected boolean toastAllowed()
  {
    long l = System.nanoTime();
    if (l > this.lastToastTime + minimumToastWait)
    {
      this.lastToastTime = l;
      return true;
    }
    return false;
  }
  
  public void unregisterForActivityResult(ActivityResultListener paramActivityResultListener)
  {
    Object localObject = Lists.newArrayList();
    Iterator localIterator = this.activityResultMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramActivityResultListener.equals(localEntry.getValue())) {
        ((List)localObject).add(localEntry.getKey());
      }
    }
    paramActivityResultListener = ((List)localObject).iterator();
    while (paramActivityResultListener.hasNext())
    {
      localObject = (Integer)paramActivityResultListener.next();
      this.activityResultMap.remove(localObject);
    }
  }
  
  private static class MultiDexInstaller
    extends AsyncTask<Form, Void, Boolean>
  {
    Form ourForm;
    
    protected Boolean doInBackground(Form... paramVarArgs)
    {
      this.ourForm = paramVarArgs[0];
      Log.d("Form", "Doing Full MultiDex Install");
      MultiDex.install(this.ourForm, true);
      return Boolean.valueOf(true);
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      this.ourForm.onCreateFinish();
    }
  }
  
  public static class PercentStorageRecord
  {
    AndroidViewComponent component;
    Dim dim;
    int length;
    
    public PercentStorageRecord(AndroidViewComponent paramAndroidViewComponent, int paramInt, Dim paramDim)
    {
      this.component = paramAndroidViewComponent;
      this.length = paramInt;
      this.dim = paramDim;
    }
    
    public static enum Dim
    {
      HEIGHT,  WIDTH;
      
      private Dim() {}
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\Form.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */