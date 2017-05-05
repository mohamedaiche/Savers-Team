package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.Config;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.Firebase.AuthResultHandler;
import com.firebase.client.Firebase.AuthStateListener;
import com.firebase.client.FirebaseError;
import com.firebase.client.MutableData;
import com.firebase.client.Transaction;
import com.firebase.client.Transaction.Handler;
import com.firebase.client.Transaction.Result;
import com.firebase.client.ValueEventListener;
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
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.EXPERIMENTAL, description="Non-visible component that communicates with Firebase to store and retrieve information.", designerHelpDescription="Non-visible component that communicates with a Firebase to store and retrieve information.", iconName="images/firebaseDB.png", nonVisible=true, version=3)
@SimpleObject
@UsesLibraries(libraries="firebase.jar")
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class FirebaseDB
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "Firebase";
  private static boolean isInitialized = false;
  private static boolean persist = false;
  private final Activity activity;
  private Handler androidUIHandler = new Handler();
  private Firebase.AuthStateListener authListener;
  private ChildEventListener childListener;
  private String defaultURL = null;
  private String developerBucket;
  private String firebaseToken;
  private String firebaseURL = null;
  private Firebase myFirebase;
  private String projectBucket;
  private boolean useDefault = true;
  
  public FirebaseDB(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.activity = paramComponentContainer.$context();
    Firebase.setAndroidContext(this.activity);
    this.developerBucket = "";
    this.projectBucket = "";
    this.firebaseToken = "";
    this.childListener = new ChildEventListener()
    {
      public void onCancelled(final FirebaseError paramAnonymousFirebaseError)
      {
        FirebaseDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            FirebaseDB.this.FirebaseError(paramAnonymousFirebaseError.getMessage());
          }
        });
      }
      
      public void onChildAdded(final DataSnapshot paramAnonymousDataSnapshot, String paramAnonymousString)
      {
        FirebaseDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            FirebaseDB.this.DataChanged(paramAnonymousDataSnapshot.getKey(), paramAnonymousDataSnapshot.getValue());
          }
        });
      }
      
      public void onChildChanged(final DataSnapshot paramAnonymousDataSnapshot, String paramAnonymousString)
      {
        FirebaseDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            FirebaseDB.this.DataChanged(paramAnonymousDataSnapshot.getKey(), paramAnonymousDataSnapshot.getValue());
          }
        });
      }
      
      public void onChildMoved(DataSnapshot paramAnonymousDataSnapshot, String paramAnonymousString) {}
      
      public void onChildRemoved(DataSnapshot paramAnonymousDataSnapshot)
      {
        Log.i("Firebase", "onChildRemoved: " + paramAnonymousDataSnapshot.getKey() + " removed.");
      }
    };
    this.authListener = new Firebase.AuthStateListener()
    {
      public void onAuthStateChanged(AuthData paramAnonymousAuthData)
      {
        Log.i("Firebase", "onAuthStateChanged: data = " + paramAnonymousAuthData);
        if (paramAnonymousAuthData == null) {
          FirebaseDB.this.myFirebase.authWithCustomToken(FirebaseDB.this.firebaseToken, new Firebase.AuthResultHandler()
          {
            public void onAuthenticated(AuthData paramAnonymous2AuthData)
            {
              Log.i("Firebase", "Auth Successful.");
            }
            
            public void onAuthenticationError(FirebaseError paramAnonymous2FirebaseError)
            {
              Log.e("Firebase", "Auth Failed: " + paramAnonymous2FirebaseError.getMessage());
            }
          });
        }
      }
    };
  }
  
  private void connectFirebase()
  {
    if (SdkLevel.getLevel() < 10)
    {
      Notifier.oneButtonAlert(this.activity, "The version of Android on this device is too old to use Firebase.", "Android Too Old", "OK");
      return;
    }
    if (this.useDefault) {}
    for (this.myFirebase = new Firebase(this.firebaseURL + "developers/" + this.developerBucket + this.projectBucket);; this.myFirebase = new Firebase(this.firebaseURL + this.projectBucket))
    {
      this.myFirebase.addChildEventListener(this.childListener);
      this.myFirebase.addAuthStateListener(this.authListener);
      return;
    }
  }
  
  private void firebaseTransaction(final Transactional paramTransactional, Firebase paramFirebase, final Runnable paramRunnable)
  {
    paramFirebase.runTransaction(new Transaction.Handler()
    {
      public Transaction.Result doTransaction(MutableData paramAnonymousMutableData)
      {
        return paramTransactional.run(paramAnonymousMutableData);
      }
      
      public void onComplete(final FirebaseError paramAnonymousFirebaseError, boolean paramAnonymousBoolean, DataSnapshot paramAnonymousDataSnapshot)
      {
        if (paramAnonymousFirebaseError != null) {
          FirebaseDB.this.androidUIHandler.post(new Runnable()
          {
            public void run()
            {
              Log.i("Firebase", "AppendValue(onComplete): firebase: " + paramAnonymousFirebaseError.getMessage());
              Log.i("Firebase", "AppendValue(onComplete): result.err: " + FirebaseDB.8.this.val$result.err);
              FirebaseDB.this.FirebaseError(paramAnonymousFirebaseError.getMessage());
            }
          });
        }
        do
        {
          return;
          if (!paramAnonymousBoolean)
          {
            FirebaseDB.this.androidUIHandler.post(new Runnable()
            {
              public void run()
              {
                Log.i("Firebase", "AppendValue(!committed): result.err: " + FirebaseDB.8.this.val$result.err);
                FirebaseDB.this.FirebaseError(FirebaseDB.8.this.val$result.err);
              }
            });
            return;
          }
        } while (paramRunnable == null);
        FirebaseDB.this.androidUIHandler.post(paramRunnable);
      }
    });
  }
  
  private void resetListener()
  {
    if (!isInitialized) {
      return;
    }
    if (this.myFirebase != null)
    {
      this.myFirebase.removeEventListener(this.childListener);
      this.myFirebase.removeAuthStateListener(this.authListener);
    }
    this.myFirebase = null;
    connectFirebase();
  }
  
  @SimpleFunction(description="Append a value to the end of a list atomically. If two devices use this function simultaneously, both will be appended and no data lost.")
  public void AppendValue(String paramString, final Object paramObject)
  {
    final ReturnVal localReturnVal = new ReturnVal(null);
    paramString = this.myFirebase.child(paramString);
    firebaseTransaction(new Transactional(null, null, localReturnVal)
    {
      /* Error */
      Transaction.Result run(MutableData paramAnonymousMutableData)
      {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 37	com/firebase/client/MutableData:getValue	()Ljava/lang/Object;
        //   4: astore_2
        //   5: aload_2
        //   6: ifnonnull +16 -> 22
        //   9: aload_0
        //   10: getfield 21	com/google/appinventor/components/runtime/FirebaseDB$7:val$result	Lcom/google/appinventor/components/runtime/FirebaseDB$ReturnVal;
        //   13: ldc 39
        //   15: putfield 45	com/google/appinventor/components/runtime/FirebaseDB$ReturnVal:err	Ljava/lang/String;
        //   18: invokestatic 51	com/firebase/client/Transaction:abort	()Lcom/firebase/client/Transaction$Result;
        //   21: areturn
        //   22: aload_2
        //   23: instanceof 53
        //   26: ifeq +53 -> 79
        //   29: aload_2
        //   30: checkcast 53	java/lang/String
        //   33: invokestatic 59	com/google/appinventor/components/runtime/util/JsonUtil:getObjectFromJson	(Ljava/lang/String;)Ljava/lang/Object;
        //   36: astore_2
        //   37: aload_2
        //   38: instanceof 61
        //   41: ifeq +81 -> 122
        //   44: aload_2
        //   45: checkcast 61	java/util/List
        //   48: aload_0
        //   49: getfield 23	com/google/appinventor/components/runtime/FirebaseDB$7:val$valueToAdd	Ljava/lang/Object;
        //   52: invokeinterface 65 2 0
        //   57: pop
        //   58: aload_2
        //   59: checkcast 61	java/util/List
        //   62: invokestatic 71	com/google/appinventor/components/runtime/util/YailList:makeList	(Ljava/util/List;)Lcom/google/appinventor/components/runtime/util/YailList;
        //   65: invokestatic 75	com/google/appinventor/components/runtime/util/JsonUtil:getJsonRepresentation	(Ljava/lang/Object;)Ljava/lang/String;
        //   68: astore_2
        //   69: aload_1
        //   70: aload_2
        //   71: invokevirtual 79	com/firebase/client/MutableData:setValue	(Ljava/lang/Object;)V
        //   74: aload_1
        //   75: invokestatic 82	com/firebase/client/Transaction:success	(Lcom/firebase/client/MutableData;)Lcom/firebase/client/Transaction$Result;
        //   78: areturn
        //   79: aload_0
        //   80: getfield 21	com/google/appinventor/components/runtime/FirebaseDB$7:val$result	Lcom/google/appinventor/components/runtime/FirebaseDB$ReturnVal;
        //   83: ldc 84
        //   85: putfield 45	com/google/appinventor/components/runtime/FirebaseDB$ReturnVal:err	Ljava/lang/String;
        //   88: invokestatic 51	com/firebase/client/Transaction:abort	()Lcom/firebase/client/Transaction$Result;
        //   91: astore_1
        //   92: aload_1
        //   93: areturn
        //   94: astore_1
        //   95: aload_0
        //   96: getfield 21	com/google/appinventor/components/runtime/FirebaseDB$7:val$result	Lcom/google/appinventor/components/runtime/FirebaseDB$ReturnVal;
        //   99: ldc 84
        //   101: putfield 45	com/google/appinventor/components/runtime/FirebaseDB$ReturnVal:err	Ljava/lang/String;
        //   104: invokestatic 51	com/firebase/client/Transaction:abort	()Lcom/firebase/client/Transaction$Result;
        //   107: areturn
        //   108: astore_1
        //   109: aload_0
        //   110: getfield 21	com/google/appinventor/components/runtime/FirebaseDB$7:val$result	Lcom/google/appinventor/components/runtime/FirebaseDB$ReturnVal;
        //   113: ldc 86
        //   115: putfield 45	com/google/appinventor/components/runtime/FirebaseDB$ReturnVal:err	Ljava/lang/String;
        //   118: invokestatic 51	com/firebase/client/Transaction:abort	()Lcom/firebase/client/Transaction$Result;
        //   121: areturn
        //   122: aload_0
        //   123: getfield 21	com/google/appinventor/components/runtime/FirebaseDB$7:val$result	Lcom/google/appinventor/components/runtime/FirebaseDB$ReturnVal;
        //   126: ldc 88
        //   128: putfield 45	com/google/appinventor/components/runtime/FirebaseDB$ReturnVal:err	Ljava/lang/String;
        //   131: invokestatic 51	com/firebase/client/Transaction:abort	()Lcom/firebase/client/Transaction$Result;
        //   134: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	135	0	this	7
        //   0	135	1	paramAnonymousMutableData	MutableData
        //   4	67	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   22	37	94	org/json/JSONException
        //   79	92	94	org/json/JSONException
        //   58	69	108	org/json/JSONException
      }
    }, paramString, null);
  }
  
  @SimpleFunction(description="Remove the tag from Firebase")
  public void ClearTag(String paramString)
  {
    this.myFirebase.child(paramString).removeValue();
  }
  
  @SimpleEvent
  public void DataChanged(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = paramObject;
    }
    try
    {
      if ((paramObject instanceof String)) {
        localObject = JsonUtil.getObjectFromJson((String)paramObject);
      }
      EventDispatcher.dispatchEvent(this, "DataChanged", new Object[] { paramString, localObject });
      return;
    }
    catch (JSONException paramString)
    {
      throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Retrieval Error.");
    }
  }
  
  @DesignerProperty(editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, userVisible=false)
  public void DefaultURL(String paramString)
  {
    this.defaultURL = paramString;
    if (this.useDefault)
    {
      this.firebaseURL = this.defaultURL;
      resetListener();
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, userVisible=false)
  public String DeveloperBucket()
  {
    return this.developerBucket;
  }
  
  @DesignerProperty(editorType="string")
  @SimpleProperty
  public void DeveloperBucket(String paramString)
  {
    this.developerBucket = paramString;
    resetListener();
  }
  
  @SimpleEvent
  public void FirebaseError(String paramString)
  {
    Log.e("Firebase", paramString);
    if (!EventDispatcher.dispatchEvent(this, "FirebaseError", new Object[] { paramString })) {
      Notifier.oneButtonAlert(this.form, paramString, "FirebaseError", "Continue");
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, userVisible=false)
  public String FirebaseToken()
  {
    return this.firebaseToken;
  }
  
  @DesignerProperty(editorType="string")
  @SimpleProperty
  public void FirebaseToken(String paramString)
  {
    this.firebaseToken = paramString;
    resetListener();
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Gets the URL for this FirebaseDB.", userVisible=false)
  public String FirebaseURL()
  {
    if (this.useDefault) {
      return "DEFAULT";
    }
    return this.firebaseURL;
  }
  
  @DesignerProperty(defaultValue="DEFAULT", editorType="FirbaseURL")
  @SimpleProperty(description="Sets the URL for this FirebaseDB.")
  public void FirebaseURL(String paramString)
  {
    if (paramString.equals("DEFAULT"))
    {
      if (!this.useDefault)
      {
        this.useDefault = true;
        if (this.defaultURL == null)
        {
          Log.d("Firebase", "FirebaseURL called before DefaultURL (should not happen!)");
          return;
        }
        this.firebaseURL = this.defaultURL;
        resetListener();
        return;
      }
      this.firebaseURL = this.defaultURL;
      return;
    }
    this.useDefault = false;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.endsWith("/")) {}
    for (paramString = "";; paramString = "/")
    {
      paramString = paramString;
      if (this.firebaseURL.equals(paramString)) {
        break;
      }
      this.firebaseURL = paramString;
      this.useDefault = false;
      resetListener();
      return;
    }
  }
  
  @SimpleEvent(description="Event triggered by the \"RemoveFirst\" function. The argument \"value\" is the object that was the first in the list, and which is now removed.")
  public void FirstRemoved(Object paramObject)
  {
    EventDispatcher.dispatchEvent(this, "FirstRemoved", new Object[] { paramObject });
  }
  
  @SimpleFunction(description="Get the list of tags for this application. When complete a \"TagList\" event will be triggered with the list of known tags.")
  public void GetTagList()
  {
    this.myFirebase.child("").addListenerForSingleValueEvent(new ValueEventListener()
    {
      public void onCancelled(FirebaseError paramAnonymousFirebaseError) {}
      
      public void onDataChange(final DataSnapshot paramAnonymousDataSnapshot)
      {
        paramAnonymousDataSnapshot = paramAnonymousDataSnapshot.getValue();
        if ((paramAnonymousDataSnapshot instanceof HashMap))
        {
          paramAnonymousDataSnapshot = (List)new ArrayList(((HashMap)paramAnonymousDataSnapshot).keySet());
          FirebaseDB.this.androidUIHandler.post(new Runnable()
          {
            public void run()
            {
              FirebaseDB.this.TagList(paramAnonymousDataSnapshot);
            }
          });
        }
      }
    });
  }
  
  @SimpleFunction
  public void GetValue(final String paramString, final Object paramObject)
  {
    this.myFirebase.child(paramString).addListenerForSingleValueEvent(new ValueEventListener()
    {
      public void onCancelled(final FirebaseError paramAnonymousFirebaseError)
      {
        FirebaseDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            FirebaseDB.this.FirebaseError(paramAnonymousFirebaseError.getMessage());
          }
        });
      }
      
      /* Error */
      public void onDataChange(DataSnapshot paramAnonymousDataSnapshot)
      {
        // Byte code:
        //   0: new 54	java/util/concurrent/atomic/AtomicReference
        //   3: dup
        //   4: invokespecial 55	java/util/concurrent/atomic/AtomicReference:<init>	()V
        //   7: astore_2
        //   8: aload_1
        //   9: invokevirtual 61	com/firebase/client/DataSnapshot:exists	()Z
        //   12: ifeq +32 -> 44
        //   15: aload_2
        //   16: aload_1
        //   17: invokevirtual 65	com/firebase/client/DataSnapshot:getValue	()Ljava/lang/Object;
        //   20: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   23: aload_0
        //   24: getfield 25	com/google/appinventor/components/runtime/FirebaseDB$3:this$0	Lcom/google/appinventor/components/runtime/FirebaseDB;
        //   27: invokestatic 39	com/google/appinventor/components/runtime/FirebaseDB:access$000	(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;
        //   30: new 13	com/google/appinventor/components/runtime/FirebaseDB$3$1
        //   33: dup
        //   34: aload_0
        //   35: aload_2
        //   36: invokespecial 72	com/google/appinventor/components/runtime/FirebaseDB$3$1:<init>	(Lcom/google/appinventor/components/runtime/FirebaseDB$3;Ljava/util/concurrent/atomic/AtomicReference;)V
        //   39: invokevirtual 48	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   42: pop
        //   43: return
        //   44: aload_2
        //   45: aload_0
        //   46: getfield 27	com/google/appinventor/components/runtime/FirebaseDB$3:val$valueIfTagNotThere	Ljava/lang/Object;
        //   49: invokestatic 78	com/google/appinventor/components/runtime/util/JsonUtil:getJsonRepresentation	(Ljava/lang/Object;)Ljava/lang/String;
        //   52: invokevirtual 69	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
        //   55: goto -32 -> 23
        //   58: astore_1
        //   59: new 80	com/google/appinventor/components/runtime/errors/YailRuntimeError
        //   62: dup
        //   63: ldc 82
        //   65: ldc 84
        //   67: invokespecial 87	com/google/appinventor/components/runtime/errors/YailRuntimeError:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   70: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	71	0	this	3
        //   0	71	1	paramAnonymousDataSnapshot	DataSnapshot
        //   7	38	2	localAtomicReference	AtomicReference
        // Exception table:
        //   from	to	target	type
        //   8	23	58	org/json/JSONException
        //   44	55	58	org/json/JSONException
      }
    });
  }
  
  @SimpleEvent
  public void GotValue(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = paramObject;
    }
    try
    {
      if ((paramObject instanceof String)) {
        localObject = JsonUtil.getObjectFromJson((String)paramObject);
      }
      EventDispatcher.dispatchEvent(this, "GotValue", new Object[] { paramString, localObject });
      return;
    }
    catch (JSONException paramString)
    {
      throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Retrieval Error.");
    }
  }
  
  public void Initialize()
  {
    Log.i("Firebase", "Initalize called!");
    isInitialized = true;
    resetListener();
  }
  
  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty(description="If true, variables will retain their values when off-line and the App exits. Values will be uploaded to Firebase the next time the App is run while connected to the network. This is useful for applications which will gather data while not connected to the network. Note: AppendValue and RemoveFirst will not work correctly when off-line, they require a network connection.<br/><br/> <i>Note</i>: If you set Persist on any Firebase component, on any screen, it makes all Firebase components on all screens persistent. This is a limitation of the low level Firebase library. Also be aware that if you want to set persist to true, you should do so before connecting the Companion for incremental development.", userVisible=false)
  public void Persist(boolean paramBoolean)
  {
    Log.i("Firebase", "Persist Called: Value = " + paramBoolean);
    if (persist != paramBoolean)
    {
      if (isInitialized) {
        throw new RuntimeException("You cannot change the Persist value of Firebase after Application Initialization, this includes the Companion");
      }
      Config localConfig = Firebase.getDefaultConfig();
      localConfig.setPersistenceEnabled(paramBoolean);
      Firebase.setDefaultConfig(localConfig);
      persist = paramBoolean;
      resetListener();
    }
  }
  
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Gets the ProjectBucket for this FirebaseDB.")
  public String ProjectBucket()
  {
    return this.projectBucket;
  }
  
  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(description="Sets the ProjectBucket for this FirebaseDB.")
  public void ProjectBucket(String paramString)
  {
    if (!this.projectBucket.equals(paramString))
    {
      this.projectBucket = paramString;
      resetListener();
    }
  }
  
  @SimpleFunction(description="Return the first element of a list and atomically remove it. If two devices use this function simultaneously, one will get the first element and the the other will get the second element, or an error if there is no available element. When the element is available, the \"FirstRemoved\" event will be triggered.")
  public void RemoveFirst(String paramString)
  {
    final ReturnVal localReturnVal = new ReturnVal(null);
    paramString = this.myFirebase.child(paramString);
    firebaseTransaction(new Transactional(null, null, localReturnVal)
    {
      Transaction.Result run(MutableData paramAnonymousMutableData)
      {
        Object localObject = paramAnonymousMutableData.getValue();
        if (localObject == null)
        {
          localReturnVal.err = "Previous value was empty.";
          return Transaction.abort();
        }
        try
        {
          if ((localObject instanceof String))
          {
            localObject = JsonUtil.getObjectFromJson((String)localObject);
            if (!(localObject instanceof List)) {
              break label150;
            }
            if (((List)localObject).isEmpty())
            {
              localReturnVal.err = "The list was empty";
              return Transaction.abort();
            }
          }
          else
          {
            localReturnVal.err = "Invalid JSON object in database (shouldn't happen!)";
            paramAnonymousMutableData = Transaction.abort();
            return paramAnonymousMutableData;
          }
        }
        catch (JSONException paramAnonymousMutableData)
        {
          localReturnVal.err = "Invalid JSON object in database (shouldn't happen!)";
          return Transaction.abort();
        }
        localReturnVal.retval = ((List)localObject).remove(0);
        try
        {
          localObject = JsonUtil.getJsonRepresentation(YailList.makeList((List)localObject));
          paramAnonymousMutableData.setValue(localObject);
          return Transaction.success(paramAnonymousMutableData);
        }
        catch (JSONException paramAnonymousMutableData)
        {
          localReturnVal.err = "Could not convert value to JSON.";
          return Transaction.abort();
        }
        label150:
        localReturnVal.err = "You can only remove elements from a list.";
        return Transaction.abort();
      }
    }, paramString, new Runnable()
    {
      public void run()
      {
        FirebaseDB.this.FirstRemoved(localReturnVal.getRetval());
      }
    });
  }
  
  @SimpleFunction
  public void StoreValue(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {}
    try
    {
      localObject = JsonUtil.getJsonRepresentation(paramObject);
      this.myFirebase.child(paramString).setValue(localObject);
      return;
    }
    catch (JSONException paramString)
    {
      throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
    }
  }
  
  @SimpleEvent(description="Event triggered when we have received the list of known tags. Used with the \"GetTagList\" Function.")
  public void TagList(List paramList)
  {
    EventDispatcher.dispatchEvent(this, "TagList", new Object[] { paramList });
  }
  
  @SimpleFunction(description="If you are having difficulty with the Companion and you are switching between different Firebase accounts, you may need to use this function to clear internal Firebase caches. You can just use the \"Do It\" function on this block in the blocks editor. Note: You should not normally need to use this block as part of an application.")
  public void Unauthenticate()
  {
    if (this.myFirebase == null) {
      connectFirebase();
    }
    this.myFirebase.unauth();
  }
  
  private static class ReturnVal
  {
    String err;
    Object retval;
    
    Object getRetval()
    {
      return this.retval;
    }
  }
  
  private static abstract class Transactional
  {
    final Object arg1;
    final Object arg2;
    final FirebaseDB.ReturnVal retv;
    
    Transactional(Object paramObject1, Object paramObject2, FirebaseDB.ReturnVal paramReturnVal)
    {
      this.arg1 = paramObject1;
      this.arg2 = paramObject2;
      this.retv = paramReturnVal;
    }
    
    FirebaseDB.ReturnVal getResult()
    {
      return this.retv;
    }
    
    abstract Transaction.Result run(MutableData paramMutableData);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\FirebaseDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */