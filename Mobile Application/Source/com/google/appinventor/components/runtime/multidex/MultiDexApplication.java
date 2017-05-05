package com.google.appinventor.components.runtime.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication
  extends Application
{
  public static boolean installed = false;
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    MultiDex.install(this, true);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\multidex\MultiDexApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */