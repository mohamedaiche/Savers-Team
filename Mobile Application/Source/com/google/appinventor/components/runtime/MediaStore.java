package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@DesignerComponent(category=ComponentCategory.INTERNAL, description="Non-visible component that communicates with a Web service and stores media files.", iconName="images/mediastore.png", nonVisible=true, version=1)
@SimpleObject
@UsesLibraries(libraries="httpcore-4.3.2.jar,httpmime-4.3.4.jar")
@UsesPermissions(permissionNames="android.permission.INTERNET")
public final class MediaStore
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG_COMPONENT = "MediaStore: ";
  private Handler androidUIHandler;
  protected final ComponentContainer componentContainer;
  private String serviceURL;
  
  public MediaStore(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.componentContainer = paramComponentContainer;
    this.androidUIHandler = new Handler();
    this.serviceURL = "http://ai-mediaservice.appspot.com";
  }
  
  private String getUploadUrl()
  {
    StringBuilder localStringBuilder;
    try
    {
      Object localObject = (HttpURLConnection)new URL(this.serviceURL).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setRequestProperty("User-Agent", "AppInventor");
      ((HttpURLConnection)localObject).setRequestProperty("Content-Type", "text/plain; charset=utf-8");
      localObject = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject).getInputStream()));
      localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str2 = ((BufferedReader)localObject).readLine();
        if (str2 == null) {
          break;
        }
        localStringBuilder.append(str2);
      }
      localException.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "";
    }
    String str1 = localStringBuilder.toString();
    return str1;
  }
  
  @SimpleEvent
  public void MediaStored(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "MediaStored", new Object[] { paramString });
  }
  
  @SimpleFunction
  public void PostMedia(String paramString)
    throws FileNotFoundException
  {
    AsyncCallbackPair local1 = new AsyncCallbackPair()
    {
      public void onFailure(final String paramAnonymousString)
      {
        MediaStore.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            MediaStore.this.WebServiceError(paramAnonymousString);
          }
        });
      }
      
      public void onSuccess(final String paramAnonymousString)
      {
        MediaStore.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            MediaStore.this.MediaStored(paramAnonymousString);
          }
        });
      }
    };
    try
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      Object localObject = MultipartEntityBuilder.create();
      ((MultipartEntityBuilder)localObject).setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
      if (paramString.split("/")[0].equals("file:")) {
        paramString = new File(new URL(paramString).toURI()).getAbsolutePath();
      }
      for (;;)
      {
        ((MultipartEntityBuilder)localObject).addPart("file", new FileBody(new File(paramString)));
        paramString = ((MultipartEntityBuilder)localObject).build();
        localObject = new HttpPost(getUploadUrl());
        ((HttpPost)localObject).setEntity(paramString);
        local1.onSuccess(EntityUtils.toString(localDefaultHttpClient.execute((HttpUriRequest)localObject).getEntity()));
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      local1.onFailure(paramString.getMessage());
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ServiceURL()
  {
    return this.serviceURL;
  }
  
  @DesignerProperty(defaultValue="http://ai-mediaservice.appspot.com", editorType="string")
  @SimpleProperty
  public void ServiceURL(String paramString)
  {
    this.serviceURL = paramString;
  }
  
  @SimpleEvent
  public void WebServiceError(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "WebServiceError", new Object[] { paramString });
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\MediaStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */