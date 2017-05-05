package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class dump
  extends ClassFileInput
{
  ClassTypeWriter writer;
  
  dump(InputStream paramInputStream, ClassTypeWriter paramClassTypeWriter)
    throws IOException, ClassFormatError
  {
    super(paramInputStream);
    this.ctype = new ClassType();
    readFormatVersion();
    readConstants();
    readClassInfo();
    readFields();
    readMethods();
    readAttributes(this.ctype);
    paramClassTypeWriter.print(this.ctype);
    paramClassTypeWriter.flush();
  }
  
  /* Error */
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_2
    //   3: new 46	gnu/bytecode/ClassTypeWriter
    //   6: dup
    //   7: aconst_null
    //   8: getstatic 71	java/lang/System:out	Ljava/io/PrintStream;
    //   11: iconst_0
    //   12: invokespecial 74	gnu/bytecode/ClassTypeWriter:<init>	(Lgnu/bytecode/ClassType;Ljava/io/OutputStream;I)V
    //   15: astore 9
    //   17: iload_2
    //   18: ifne +9 -> 27
    //   21: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   24: invokestatic 81	gnu/bytecode/dump:usage	(Ljava/io/PrintStream;)V
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: iload_2
    //   31: if_icmpge +724 -> 755
    //   34: aload_0
    //   35: iload_1
    //   36: aaload
    //   37: astore 6
    //   39: aload 6
    //   41: ldc 83
    //   43: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifne +13 -> 59
    //   49: aload 6
    //   51: ldc 91
    //   53: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +17 -> 73
    //   59: aload 9
    //   61: bipush 15
    //   63: invokevirtual 95	gnu/bytecode/ClassTypeWriter:setFlags	(I)V
    //   66: iload_1
    //   67: iconst_1
    //   68: iadd
    //   69: istore_1
    //   70: goto -41 -> 29
    //   73: aload 6
    //   75: invokestatic 99	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   78: ifeq +483 -> 561
    //   81: aload 6
    //   83: ldc 101
    //   85: invokevirtual 104	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   88: istore 5
    //   90: aload 6
    //   92: astore 7
    //   94: iload 5
    //   96: istore 4
    //   98: iload 5
    //   100: ifeq +132 -> 232
    //   103: aload 6
    //   105: iconst_4
    //   106: invokevirtual 108	java/lang/String:substring	(I)Ljava/lang/String;
    //   109: astore 10
    //   111: aload 6
    //   113: astore 8
    //   115: aload 10
    //   117: invokestatic 99	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   120: ifne +75 -> 195
    //   123: aload 10
    //   125: bipush 33
    //   127: invokevirtual 112	java/lang/String:indexOf	(I)I
    //   130: istore_3
    //   131: aload 6
    //   133: astore 8
    //   135: iload_3
    //   136: iflt +59 -> 195
    //   139: new 114	java/io/File
    //   142: dup
    //   143: aload 10
    //   145: iconst_0
    //   146: iload_3
    //   147: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   150: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 124	java/io/File:toURI	()Ljava/net/URI;
    //   156: invokevirtual 130	java/net/URI:toURL	()Ljava/net/URL;
    //   159: invokevirtual 136	java/net/URL:toString	()Ljava/lang/String;
    //   162: astore 6
    //   164: new 138	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   171: ldc 101
    //   173: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 6
    //   178: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 10
    //   183: iload_3
    //   184: invokevirtual 108	java/lang/String:substring	(I)Ljava/lang/String;
    //   187: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore 8
    //   195: aload 8
    //   197: astore 7
    //   199: iload 5
    //   201: istore 4
    //   203: aload 10
    //   205: ldc -110
    //   207: invokevirtual 149	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   210: ifge +22 -> 232
    //   213: aload 8
    //   215: bipush 33
    //   217: invokevirtual 152	java/lang/String:lastIndexOf	(I)I
    //   220: istore_3
    //   221: iload_3
    //   222: ifgt +73 -> 295
    //   225: iconst_0
    //   226: istore 4
    //   228: aload 8
    //   230: astore 7
    //   232: new 132	java/net/URL
    //   235: dup
    //   236: aload 7
    //   238: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
    //   241: astore 8
    //   243: aload 8
    //   245: invokevirtual 157	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   248: invokevirtual 163	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   251: astore 6
    //   253: aload 6
    //   255: aload 7
    //   257: aload 9
    //   259: invokestatic 167	gnu/bytecode/dump:process	(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V
    //   262: goto -196 -> 66
    //   265: astore 6
    //   267: aload 6
    //   269: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   272: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   275: ldc -84
    //   277: invokevirtual 177	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   280: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   283: aload 6
    //   285: invokevirtual 180	java/io/PrintStream:print	(Ljava/lang/Object;)V
    //   288: iconst_m1
    //   289: invokestatic 183	java/lang/System:exit	(I)V
    //   292: goto -226 -> 66
    //   295: aload 8
    //   297: astore 7
    //   299: iload 5
    //   301: istore 4
    //   303: aload 8
    //   305: bipush 47
    //   307: iload_3
    //   308: invokevirtual 186	java/lang/String:indexOf	(II)I
    //   311: ifge -79 -> 232
    //   314: aload 8
    //   316: iload_3
    //   317: iconst_1
    //   318: iadd
    //   319: invokevirtual 108	java/lang/String:substring	(I)Ljava/lang/String;
    //   322: bipush 46
    //   324: bipush 47
    //   326: invokevirtual 190	java/lang/String:replace	(CC)Ljava/lang/String;
    //   329: astore 6
    //   331: new 138	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   338: aload 8
    //   340: iconst_0
    //   341: iload_3
    //   342: iconst_1
    //   343: iadd
    //   344: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   347: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: bipush 47
    //   352: invokevirtual 193	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   355: aload 6
    //   357: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc -61
    //   362: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: astore 7
    //   370: iload 5
    //   372: istore 4
    //   374: goto -142 -> 232
    //   377: astore 10
    //   379: iload 4
    //   381: ifeq +51 -> 432
    //   384: aload 8
    //   386: invokevirtual 198	java/net/URL:getFile	()Ljava/lang/String;
    //   389: astore 8
    //   391: aload 8
    //   393: bipush 33
    //   395: invokevirtual 152	java/lang/String:lastIndexOf	(I)I
    //   398: istore_3
    //   399: aload 8
    //   401: astore 6
    //   403: iload_3
    //   404: ifle +12 -> 416
    //   407: aload 8
    //   409: iconst_0
    //   410: iload_3
    //   411: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   414: astore 6
    //   416: new 132	java/net/URL
    //   419: dup
    //   420: aload 6
    //   422: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
    //   425: invokevirtual 157	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   428: invokevirtual 163	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   431: pop
    //   432: aload 10
    //   434: athrow
    //   435: astore 6
    //   437: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   440: ldc -56
    //   442: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   445: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   448: aload 7
    //   450: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   453: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   456: ldc -52
    //   458: invokevirtual 177	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   461: iconst_m1
    //   462: invokestatic 183	java/lang/System:exit	(I)V
    //   465: aconst_null
    //   466: astore 6
    //   468: goto -215 -> 253
    //   471: astore 8
    //   473: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   476: ldc -50
    //   478: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   481: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   484: aload 6
    //   486: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   489: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   492: ldc -52
    //   494: invokevirtual 177	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   497: iconst_m1
    //   498: invokestatic 183	java/lang/System:exit	(I)V
    //   501: goto -69 -> 432
    //   504: astore 6
    //   506: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   509: ldc -48
    //   511: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   514: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   517: aload 7
    //   519: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   522: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   525: ldc -52
    //   527: invokevirtual 177	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   530: aload 6
    //   532: invokevirtual 209	java/util/zip/ZipException:printStackTrace	()V
    //   535: aload 6
    //   537: invokevirtual 213	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   540: ifnull +11 -> 551
    //   543: aload 6
    //   545: invokevirtual 213	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   548: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   551: iconst_m1
    //   552: invokestatic 183	java/lang/System:exit	(I)V
    //   555: aconst_null
    //   556: astore 6
    //   558: goto -305 -> 253
    //   561: new 216	java/io/FileInputStream
    //   564: dup
    //   565: aload 6
    //   567: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   570: astore 8
    //   572: aload 6
    //   574: astore 7
    //   576: aload 8
    //   578: astore 6
    //   580: goto -327 -> 253
    //   583: astore 7
    //   585: aload 6
    //   587: invokestatic 223	gnu/bytecode/ObjectType:getContextClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   590: invokevirtual 229	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   593: astore 7
    //   595: new 138	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   602: aload 6
    //   604: bipush 46
    //   606: bipush 47
    //   608: invokevirtual 190	java/lang/String:replace	(CC)Ljava/lang/String;
    //   611: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc -61
    //   616: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: astore 8
    //   624: aload 7
    //   626: aload 8
    //   628: invokevirtual 235	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   631: astore 7
    //   633: aload 7
    //   635: invokevirtual 157	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   638: invokevirtual 163	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   641: astore 8
    //   643: aload 7
    //   645: invokevirtual 136	java/net/URL:toString	()Ljava/lang/String;
    //   648: astore 7
    //   650: aload 8
    //   652: astore 6
    //   654: goto -401 -> 253
    //   657: astore 7
    //   659: invokestatic 238	gnu/bytecode/ObjectType:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   662: astore 7
    //   664: goto -69 -> 595
    //   667: astore 7
    //   669: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   672: ldc -16
    //   674: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   677: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   680: aload 6
    //   682: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   685: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   688: ldc -52
    //   690: invokevirtual 177	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   693: iconst_m1
    //   694: invokestatic 183	java/lang/System:exit	(I)V
    //   697: aconst_null
    //   698: astore 7
    //   700: goto -105 -> 595
    //   703: astore 7
    //   705: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   708: ldc -14
    //   710: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   713: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   716: aload 6
    //   718: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   721: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   724: ldc -12
    //   726: invokevirtual 202	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   729: getstatic 77	java/lang/System:err	Ljava/io/PrintStream;
    //   732: aload 7
    //   734: invokevirtual 246	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   737: iconst_m1
    //   738: invokestatic 183	java/lang/System:exit	(I)V
    //   741: aconst_null
    //   742: astore 8
    //   744: aload 6
    //   746: astore 7
    //   748: aload 8
    //   750: astore 6
    //   752: goto -499 -> 253
    //   755: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	paramArrayOfString	String[]
    //   28	42	1	i	int
    //   2	30	2	j	int
    //   130	281	3	k	int
    //   96	284	4	bool1	boolean
    //   88	283	5	bool2	boolean
    //   37	217	6	localObject1	Object
    //   265	19	6	localIOException	IOException
    //   329	92	6	localObject2	Object
    //   435	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   466	19	6	str1	String
    //   504	40	6	localZipException1	java.util.zip.ZipException
    //   556	195	6	localObject3	Object
    //   92	483	7	localObject4	Object
    //   583	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   593	56	7	localObject5	Object
    //   657	1	7	localNoClassDefFoundError	NoClassDefFoundError
    //   662	1	7	localClassLoader	ClassLoader
    //   667	1	7	localThrowable1	Throwable
    //   698	1	7	localObject6	Object
    //   703	30	7	localThrowable2	Throwable
    //   746	1	7	localObject7	Object
    //   113	295	8	localObject8	Object
    //   471	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   570	179	8	localObject9	Object
    //   15	243	9	localClassTypeWriter	ClassTypeWriter
    //   109	95	10	str2	String
    //   377	56	10	localZipException2	java.util.zip.ZipException
    // Exception table:
    //   from	to	target	type
    //   81	90	265	java/io/IOException
    //   103	111	265	java/io/IOException
    //   115	131	265	java/io/IOException
    //   139	195	265	java/io/IOException
    //   203	221	265	java/io/IOException
    //   232	243	265	java/io/IOException
    //   243	253	265	java/io/IOException
    //   253	262	265	java/io/IOException
    //   303	370	265	java/io/IOException
    //   384	399	265	java/io/IOException
    //   407	416	265	java/io/IOException
    //   416	432	265	java/io/IOException
    //   432	435	265	java/io/IOException
    //   437	465	265	java/io/IOException
    //   473	501	265	java/io/IOException
    //   506	551	265	java/io/IOException
    //   551	555	265	java/io/IOException
    //   561	572	265	java/io/IOException
    //   585	595	265	java/io/IOException
    //   595	624	265	java/io/IOException
    //   624	650	265	java/io/IOException
    //   659	664	265	java/io/IOException
    //   669	697	265	java/io/IOException
    //   705	741	265	java/io/IOException
    //   243	253	377	java/util/zip/ZipException
    //   232	243	435	java/io/FileNotFoundException
    //   243	253	435	java/io/FileNotFoundException
    //   384	399	435	java/io/FileNotFoundException
    //   407	416	435	java/io/FileNotFoundException
    //   432	435	435	java/io/FileNotFoundException
    //   473	501	435	java/io/FileNotFoundException
    //   416	432	471	java/io/FileNotFoundException
    //   232	243	504	java/util/zip/ZipException
    //   384	399	504	java/util/zip/ZipException
    //   407	416	504	java/util/zip/ZipException
    //   416	432	504	java/util/zip/ZipException
    //   432	435	504	java/util/zip/ZipException
    //   473	501	504	java/util/zip/ZipException
    //   561	572	583	java/io/FileNotFoundException
    //   585	595	657	java/lang/NoClassDefFoundError
    //   585	595	667	java/lang/Throwable
    //   624	650	703	java/lang/Throwable
  }
  
  public static void process(InputStream paramInputStream, String paramString, ClassTypeWriter paramClassTypeWriter)
    throws IOException
  {
    paramInputStream = new BufferedInputStream(paramInputStream);
    paramInputStream.mark(5);
    int i = readMagic(paramInputStream);
    if (i == -889275714)
    {
      paramClassTypeWriter.print("Reading .class from ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      new dump(paramInputStream, paramClassTypeWriter);
      return;
    }
    if (i == 1347093252)
    {
      paramInputStream.reset();
      paramClassTypeWriter.print("Reading classes from archive ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      paramInputStream = new ZipInputStream(paramInputStream);
      for (;;)
      {
        paramString = paramInputStream.getNextEntry();
        if (paramString == null) {
          break;
        }
        String str = paramString.getName();
        if (paramString.isDirectory())
        {
          paramClassTypeWriter.print("Archive directory: ");
          paramClassTypeWriter.print(str);
          paramClassTypeWriter.println('.');
        }
        else
        {
          paramClassTypeWriter.println();
          if (readMagic(paramInputStream) == -889275714)
          {
            paramClassTypeWriter.print("Reading class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
            new dump(paramInputStream, paramClassTypeWriter);
          }
          else
          {
            paramClassTypeWriter.print("Skipping non-class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
          }
        }
      }
      System.exit(-1);
      return;
    }
    System.err.println("File " + paramString + " is not a valid .class file");
    System.exit(-1);
  }
  
  public static void process(InputStream paramInputStream, String paramString, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramOutputStream, paramInt));
  }
  
  public static void process(InputStream paramInputStream, String paramString, Writer paramWriter, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramWriter, paramInt));
  }
  
  static int readMagic(InputStream paramInputStream)
    throws IOException
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k;
      if (i < 4)
      {
        k = paramInputStream.read();
        if (k >= 0) {}
      }
      else
      {
        return j;
      }
      j = j << 8 | k & 0xFF;
      i += 1;
    }
  }
  
  static int uriSchemeLength(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c == ':') {
        return i;
      }
      if (i == 0)
      {
        if (Character.isLetter(c)) {}
      }
      else {
        while ((!Character.isLetterOrDigit(c)) && (c != '+') && (c != '-') && (c != '.')) {
          return -1;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  static boolean uriSchemeSpecified(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = uriSchemeLength(paramString);
    if ((i == 1) && (File.separatorChar == '\\'))
    {
      i = paramString.charAt(0);
      if (i >= 97)
      {
        bool1 = bool2;
        if (i <= 122) {}
      }
      else if (i >= 65)
      {
        bool1 = bool2;
        if (i <= 90) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (i > 0) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public static void usage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Prints and dis-assembles the contents of JVM .class files.");
    paramPrintStream.println("Usage: [--verbose] class-or-jar ...");
    paramPrintStream.println("where a class-or-jar can be one of:");
    paramPrintStream.println("- a fully-qualified class name; or");
    paramPrintStream.println("- the name of a .class file, or a URL reference to one; or");
    paramPrintStream.println("- the name of a .jar or .zip archive file, or a URL reference to one.");
    paramPrintStream.println("If a .jar/.zip archive is named, all its.class file members are printed.");
    paramPrintStream.println();
    paramPrintStream.println("You can name a single .class member of an archive with a jar: URL,");
    paramPrintStream.println("which looks like: jar:jar-spec!/p1/p2/cl.class");
    paramPrintStream.println("The jar-spec can be a URL or the name of the .jar file.");
    paramPrintStream.println("You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl");
    System.exit(-1);
  }
  
  public Attribute readAttribute(String paramString, int paramInt, AttrContainer paramAttrContainer)
    throws IOException
  {
    return super.readAttribute(paramString, paramInt, paramAttrContainer);
  }
  
  public ConstantPool readConstants()
    throws IOException
  {
    this.ctype.constants = super.readConstants();
    return this.ctype.constants;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\bytecode\dump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */