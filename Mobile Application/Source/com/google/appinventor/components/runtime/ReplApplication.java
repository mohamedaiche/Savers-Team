package com.google.appinventor.components.runtime;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.appinventor.common.version.GitBuildId;
import com.google.appinventor.components.runtime.multidex.MultiDex;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ErrorReporter;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(formKey="")
public class ReplApplication
  extends Application
{
  public static boolean installed = true;
  private static ReplApplication thisInstance;
  private boolean active = false;
  
  public static boolean isAcraActive()
  {
    return (thisInstance != null) && (thisInstance.active);
  }
  
  public static void reportError(Throwable paramThrowable)
  {
    if ((thisInstance != null) && (thisInstance.active)) {
      ACRA.getErrorReporter().handleException(paramThrowable);
    }
  }
  
  public static void reportError(Throwable paramThrowable, String paramString)
  {
    ACRA.getErrorReporter().putCustomData("reportid", paramString);
    reportError(paramThrowable);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    installed = MultiDex.install(this, false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    thisInstance = this;
    String str = GitBuildId.getAcraUri();
    if (str.equals(""))
    {
      Log.i("ReplApplication", "ACRA Not Active");
      return;
    }
    Log.i("ReplApplication", "ACRA Active, URI = " + str);
    ACRAConfiguration localACRAConfiguration = ACRA.getNewDefaultConfig(this);
    localACRAConfiguration.setFormUri(str);
    localACRAConfiguration.setDisableSSLCertValidation(true);
    ACRA.setConfig(localACRAConfiguration);
    ACRA.init(this);
    this.active = true;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\ReplApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */