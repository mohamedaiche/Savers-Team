package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

@DesignerComponent(category=ComponentCategory.STORAGE, description="Non-visible component for storing and retrieving files. Use this component to write or read files on your device. The default behaviour is to write files to the private data directory associated with your App. The Companion is special cased to write files to /sdcard/AppInventor/data to facilitate debugging. If the file path starts with a slash (/), then the file is created relative to /sdcard. For example writing a file to /myFile.txt will write the file in /sdcard/myFile.txt.", iconName="images/file.png", nonVisible=true, version=2)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.WRITE_EXTERNAL_STORAGE, android.permission.READ_EXTERNAL_STORAGE")
public class File
  extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "FileComponent";
  public static final String NO_ASSETS = "No_Assets";
  private final int BUFFER_LENGTH = 4096;
  private final Activity activity;
  private boolean isRepl = false;
  
  public File(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    if ((this.form instanceof ReplForm)) {
      this.isRepl = true;
    }
    this.activity = paramComponentContainer.$context();
  }
  
  private String AbsoluteFileName(String paramString)
  {
    if (paramString.startsWith("/")) {
      return Environment.getExternalStorageDirectory().getPath() + paramString;
    }
    Object localObject = this.activity.getFilesDir();
    if (this.isRepl)
    {
      java.io.File localFile = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/AppInventor/data/");
      localObject = localFile;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject = localFile;
      }
    }
    return ((java.io.File)localObject).getPath() + "/" + paramString;
  }
  
  /* Error */
  private void AsyncRead(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 130	java/io/InputStreamReader
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: new 135	java/io/StringWriter
    //   21: dup
    //   22: invokespecial 136	java/io/StringWriter:<init>	()V
    //   25: astore 4
    //   27: sipush 4096
    //   30: newarray <illegal type>
    //   32: astore 5
    //   34: aload_1
    //   35: aload 5
    //   37: iconst_0
    //   38: sipush 4096
    //   41: invokevirtual 140	java/io/InputStreamReader:read	([CII)I
    //   44: istore_3
    //   45: iload_3
    //   46: ifle +63 -> 109
    //   49: aload 4
    //   51: aload 5
    //   53: iconst_0
    //   54: iload_3
    //   55: invokevirtual 144	java/io/StringWriter:write	([CII)V
    //   58: goto -24 -> 34
    //   61: astore 5
    //   63: aload_1
    //   64: astore 4
    //   66: ldc 34
    //   68: ldc -110
    //   70: aload 5
    //   72: invokestatic 152	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   75: pop
    //   76: aload_1
    //   77: astore 4
    //   79: aload_0
    //   80: getfield 62	com/google/appinventor/components/runtime/File:form	Lcom/google/appinventor/components/runtime/Form;
    //   83: aload_0
    //   84: ldc -102
    //   86: sipush 2101
    //   89: iconst_1
    //   90: anewarray 156	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_2
    //   96: aastore
    //   97: invokevirtual 162	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 165	java/io/InputStreamReader:close	()V
    //   108: return
    //   109: aload_0
    //   110: aload 4
    //   112: invokevirtual 166	java/io/StringWriter:toString	()Ljava/lang/String;
    //   115: invokespecial 169	com/google/appinventor/components/runtime/File:normalizeNewLines	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 4
    //   120: aload_0
    //   121: getfield 70	com/google/appinventor/components/runtime/File:activity	Landroid/app/Activity;
    //   124: new 14	com/google/appinventor/components/runtime/File$3
    //   127: dup
    //   128: aload_0
    //   129: aload 4
    //   131: invokespecial 172	com/google/appinventor/components/runtime/File$3:<init>	(Lcom/google/appinventor/components/runtime/File;Ljava/lang/String;)V
    //   134: invokevirtual 176	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   137: aload_1
    //   138: ifnull +108 -> 246
    //   141: aload_1
    //   142: invokevirtual 165	java/io/InputStreamReader:close	()V
    //   145: return
    //   146: astore_1
    //   147: return
    //   148: astore 4
    //   150: aload 5
    //   152: astore_1
    //   153: aload 4
    //   155: astore 5
    //   157: aload_1
    //   158: astore 4
    //   160: ldc 34
    //   162: ldc -78
    //   164: aload 5
    //   166: invokestatic 152	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   169: pop
    //   170: aload_1
    //   171: astore 4
    //   173: aload_0
    //   174: getfield 62	com/google/appinventor/components/runtime/File:form	Lcom/google/appinventor/components/runtime/Form;
    //   177: aload_0
    //   178: ldc -102
    //   180: sipush 2102
    //   183: iconst_1
    //   184: anewarray 156	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: aastore
    //   191: invokevirtual 162	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   194: aload_1
    //   195: ifnull -87 -> 108
    //   198: aload_1
    //   199: invokevirtual 165	java/io/InputStreamReader:close	()V
    //   202: return
    //   203: astore_1
    //   204: return
    //   205: astore_1
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 165	java/io/InputStreamReader:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: return
    //   220: astore_2
    //   221: goto -5 -> 216
    //   224: astore_2
    //   225: aload_1
    //   226: astore 4
    //   228: aload_2
    //   229: astore_1
    //   230: goto -24 -> 206
    //   233: astore 5
    //   235: goto -78 -> 157
    //   238: astore 5
    //   240: aload 6
    //   242: astore_1
    //   243: goto -180 -> 63
    //   246: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	File
    //   0	247	1	paramInputStream	InputStream
    //   0	247	2	paramString	String
    //   44	11	3	i	int
    //   4	126	4	localObject1	Object
    //   148	6	4	localIOException1	IOException
    //   158	69	4	localInputStream	InputStream
    //   1	51	5	arrayOfChar	char[]
    //   61	90	5	localFileNotFoundException1	FileNotFoundException
    //   155	10	5	localObject2	Object
    //   233	1	5	localIOException2	IOException
    //   238	1	5	localFileNotFoundException2	FileNotFoundException
    //   7	234	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	34	61	java/io/FileNotFoundException
    //   34	45	61	java/io/FileNotFoundException
    //   49	58	61	java/io/FileNotFoundException
    //   109	137	61	java/io/FileNotFoundException
    //   141	145	146	java/io/IOException
    //   9	18	148	java/io/IOException
    //   198	202	203	java/io/IOException
    //   9	18	205	finally
    //   66	76	205	finally
    //   79	100	205	finally
    //   160	170	205	finally
    //   173	194	205	finally
    //   104	108	218	java/io/IOException
    //   211	216	220	java/io/IOException
    //   18	34	224	finally
    //   34	45	224	finally
    //   49	58	224	finally
    //   109	137	224	finally
    //   18	34	233	java/io/IOException
    //   34	45	233	java/io/IOException
    //   49	58	233	java/io/IOException
    //   109	137	233	java/io/IOException
    //   9	18	238	java/io/FileNotFoundException
  }
  
  private void Write(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if (paramString1.startsWith("//"))
    {
      if (paramBoolean)
      {
        this.form.dispatchErrorOccurredEvent(this, "AppendTo", 2106, new Object[] { paramString1 });
        return;
      }
      this.form.dispatchErrorOccurredEvent(this, "SaveFile", 2106, new Object[] { paramString1 });
      return;
    }
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        str = File.this.AbsoluteFileName(paramString1);
        Object localObject = new java.io.File(str);
        if (!((java.io.File)localObject).exists()) {}
        try
        {
          ((java.io.File)localObject).createNewFile();
          OutputStreamWriter localOutputStreamWriter;
          return;
        }
        catch (IOException localIOException1)
        {
          try
          {
            localObject = new FileOutputStream((java.io.File)localObject, paramBoolean);
            localOutputStreamWriter = new OutputStreamWriter((OutputStream)localObject);
            localOutputStreamWriter.write(paramString2);
            localOutputStreamWriter.flush();
            localOutputStreamWriter.close();
            ((FileOutputStream)localObject).close();
            File.this.activity.runOnUiThread(new Runnable()
            {
              public void run()
              {
                File.this.AfterFileSaved(File.2.this.val$filename);
              }
            });
            return;
          }
          catch (IOException localIOException2)
          {
            if (!paramBoolean) {
              break label194;
            }
            File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2104, new Object[] { str });
            return;
            File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2104, new Object[] { str });
          }
          localIOException1 = localIOException1;
          if (paramBoolean)
          {
            File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", 2103, new Object[] { str });
            return;
          }
          File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", 2103, new Object[] { str });
          return;
        }
      }
    });
  }
  
  private String normalizeNewLines(String paramString)
  {
    return paramString.replaceAll("\r\n", "\n");
  }
  
  @SimpleEvent(description="Event indicating that the contents of the file have been written.")
  public void AfterFileSaved(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterFileSaved", new Object[] { paramString });
  }
  
  @SimpleFunction(description="Appends text to the end of a file storage, creating the file if it does not exist. See the help text under SaveFile for information about where files are written.")
  public void AppendToFile(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("/")) {
      FileUtil.checkExternalStorageWriteable();
    }
    Write(paramString2, paramString1, true);
  }
  
  @SimpleFunction(description="Deletes a file from storage. Prefix the filename with / to delete a specific file in the SD card, for instance /myFile.txt. will delete the file /sdcard/myFile.txt. If the file does not begin with a /, then the file located in the programs private storage will be deleted. Starting the file with // is an error because assets files cannot be deleted.")
  public void Delete(String paramString)
  {
    if (paramString.startsWith("//"))
    {
      this.form.dispatchErrorOccurredEvent(this, "DeleteFile", 2105, new Object[] { paramString });
      return;
    }
    new java.io.File(AbsoluteFileName(paramString)).delete();
  }
  
  @SimpleEvent(description="Event indicating that the contents from the file have been read.")
  public void GotText(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "GotText", new Object[] { paramString });
  }
  
  @SimpleFunction(description="Reads text from a file in storage. Prefix the filename with / to read from a specific file on the SD card. for instance /myFile.txt will read the file /sdcard/myFile.txt. To read assets packaged with an application (also works for the Companion) start the filename with // (two slashes). If a filename does not start with a slash, it will be read from the applications private storage (for packaged apps) and from /sdcard/AppInventor/data for the Companion.")
  public void ReadFrom(final String paramString)
  {
    try
    {
      final Object localObject;
      if (paramString.startsWith("//")) {
        if (this.isRepl) {
          localObject = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/AppInventor/assets/" + paramString);
        }
      }
      for (;;)
      {
        AsynchUtil.runAsynchronously(new Runnable()
        {
          public void run()
          {
            File.this.AsyncRead(localObject, paramString);
          }
        });
        return;
        localObject = this.form.getAssets().open(paramString.substring(2));
        continue;
        localObject = AbsoluteFileName(paramString);
        Log.d("FileComponent", "filepath = " + (String)localObject);
        localObject = new FileInputStream((String)localObject);
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("FileComponent", "FileNotFoundException", localFileNotFoundException);
      this.form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] { paramString });
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("FileComponent", "IOException", localIOException);
      this.form.dispatchErrorOccurredEvent(this, "ReadFrom", 2101, new Object[] { paramString });
    }
  }
  
  @SimpleFunction(description="Saves text to a file. If the filename begins with a slash (/) the file is written to the sdcard. For example writing to /myFile.txt will write the file to /sdcard/myFile.txt. If the filename does not start with a slash, it will be written in the programs private data directory where it will not be accessible to other programs on the phone. There is a special exception for the AI Companion where these files are written to /sdcard/AppInventor/data to facilitate debugging. Note that this block will overwrite a file if it already exists.\n\nIf you want to add content to a file use the append block.")
  public void SaveFile(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("/")) {
      FileUtil.checkExternalStorageWriteable();
    }
    Write(paramString2, paramString1, false);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\com\google\appinventor\components\runtime\File.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */