package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.BitwiseOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.Invoke;
import gnu.lists.CharSeq;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.Char;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

public class srfi13
  extends ModuleBody
{
  public static final ModuleMethod $Pccheck$Mnbounds;
  public static final ModuleMethod $Pcfinish$Mnstring$Mnconcatenate$Mnreverse;
  public static final ModuleMethod $Pckmp$Mnsearch;
  public static final ModuleMethod $Pcmultispan$Mnrepcopy$Ex;
  public static final ModuleMethod $Pcstring$Mncompare;
  public static final ModuleMethod $Pcstring$Mncompare$Mnci;
  public static final ModuleMethod $Pcstring$Mncopy$Ex;
  public static final ModuleMethod $Pcstring$Mnhash;
  public static final ModuleMethod $Pcstring$Mnmap;
  public static final ModuleMethod $Pcstring$Mnmap$Ex;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod $Pcstring$Mnprefix$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength;
  public static final ModuleMethod $Pcstring$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod $Pcstring$Mnsuffix$Qu;
  public static final ModuleMethod $Pcstring$Mntitlecase$Ex;
  public static final ModuleMethod $Pcsubstring$Slshared;
  public static final srfi13 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final IntNum Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final SimpleSymbol Lit106;
  static final SimpleSymbol Lit107;
  static final SimpleSymbol Lit108;
  static final SimpleSymbol Lit109;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final SimpleSymbol Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final SimpleSymbol Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final Char Lit12;
  static final SimpleSymbol Lit120;
  static final SimpleSymbol Lit121;
  static final SimpleSymbol Lit122;
  static final SimpleSymbol Lit123;
  static final SimpleSymbol Lit124;
  static final SimpleSymbol Lit125;
  static final SimpleSymbol Lit126;
  static final SimpleSymbol Lit127;
  static final SimpleSymbol Lit128;
  static final SimpleSymbol Lit129;
  static final IntNum Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SimpleSymbol Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SimpleSymbol Lit135;
  static final SimpleSymbol Lit136;
  static final SimpleSymbol Lit137;
  static final SimpleSymbol Lit138;
  static final SimpleSymbol Lit139;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit140;
  static final SimpleSymbol Lit141;
  static final SimpleSymbol Lit142;
  static final SimpleSymbol Lit143;
  static final SimpleSymbol Lit144;
  static final SimpleSymbol Lit145;
  static final SimpleSymbol Lit146;
  static final SimpleSymbol Lit147;
  static final SimpleSymbol Lit148;
  static final SimpleSymbol Lit149;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit150 = (SimpleSymbol)new SimpleSymbol("receive").readResolve();
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final IntNum Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final IntNum Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final IntNum Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SyntaxRules Lit42;
  static final SimpleSymbol Lit43;
  static final SyntaxRules Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final IntNum Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final IntNum Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final IntNum Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final IntNum Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final SimpleSymbol Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final IntNum Lit9;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final SimpleSymbol Lit96;
  static final SimpleSymbol Lit97;
  static final SimpleSymbol Lit98;
  static final SimpleSymbol Lit99;
  public static final ModuleMethod check$Mnsubstring$Mnspec;
  public static final ModuleMethod kmp$Mnstep;
  static final ModuleMethod lambda$Fn100;
  static final ModuleMethod lambda$Fn105;
  static final ModuleMethod lambda$Fn106;
  static final ModuleMethod lambda$Fn111;
  static final ModuleMethod lambda$Fn116;
  static final ModuleMethod lambda$Fn117;
  static final ModuleMethod lambda$Fn122;
  static final ModuleMethod lambda$Fn123;
  static final ModuleMethod lambda$Fn128;
  static final ModuleMethod lambda$Fn133;
  static final ModuleMethod lambda$Fn138;
  static final ModuleMethod lambda$Fn163;
  static final ModuleMethod lambda$Fn166;
  static final ModuleMethod lambda$Fn17;
  static final ModuleMethod lambda$Fn18;
  static final ModuleMethod lambda$Fn210;
  static final ModuleMethod lambda$Fn216;
  static final ModuleMethod lambda$Fn220;
  static final ModuleMethod lambda$Fn27;
  static final ModuleMethod lambda$Fn5;
  static final ModuleMethod lambda$Fn72;
  static final ModuleMethod lambda$Fn73;
  static final ModuleMethod lambda$Fn78;
  static final ModuleMethod lambda$Fn83;
  static final ModuleMethod lambda$Fn84;
  static final ModuleMethod lambda$Fn89;
  static final ModuleMethod lambda$Fn90;
  static final ModuleMethod lambda$Fn95;
  public static final Macro let$Mnstring$Mnstart$Plend;
  public static final Macro let$Mnstring$Mnstart$Plend2;
  static final Location loc$$Cloptional;
  static final Location loc$base;
  static final Location loc$bound;
  static final Location loc$c$Eq;
  static final Location loc$char$Mncased$Qu;
  static final Location loc$char$Mnset;
  static final Location loc$char$Mnset$Mncontains$Qu;
  static final Location loc$char$Mnset$Qu;
  static final Location loc$check$Mnarg;
  static final Location loc$criterion;
  static final Location loc$delim;
  static final Location loc$end;
  static final Location loc$final;
  static final Location loc$grammar;
  static final Location loc$let$Mnoptionals$St;
  static final Location loc$make$Mnfinal;
  static final Location loc$p$Mnstart;
  static final Location loc$rest;
  static final Location loc$s$Mnend;
  static final Location loc$s$Mnstart;
  static final Location loc$start;
  static final Location loc$token$Mnchars;
  public static final ModuleMethod make$Mnkmp$Mnrestart$Mnvector;
  public static final ModuleMethod reverse$Mnlist$Mn$Grstring;
  public static final ModuleMethod string$Eq;
  public static final ModuleMethod string$Gr;
  public static final ModuleMethod string$Gr$Eq;
  public static final ModuleMethod string$Ls;
  public static final ModuleMethod string$Ls$Eq;
  public static final ModuleMethod string$Ls$Gr;
  public static final ModuleMethod string$Mn$Grlist;
  public static final ModuleMethod string$Mnany;
  public static final ModuleMethod string$Mnappend$Slshared;
  public static final ModuleMethod string$Mnci$Eq;
  public static final ModuleMethod string$Mnci$Gr;
  public static final ModuleMethod string$Mnci$Gr$Eq;
  public static final ModuleMethod string$Mnci$Ls;
  public static final ModuleMethod string$Mnci$Ls$Eq;
  public static final ModuleMethod string$Mnci$Ls$Gr;
  public static final ModuleMethod string$Mncompare;
  public static final ModuleMethod string$Mncompare$Mnci;
  public static final ModuleMethod string$Mnconcatenate;
  public static final ModuleMethod string$Mnconcatenate$Mnreverse;
  public static final ModuleMethod string$Mnconcatenate$Mnreverse$Slshared;
  public static final ModuleMethod string$Mnconcatenate$Slshared;
  public static final ModuleMethod string$Mncontains;
  public static final ModuleMethod string$Mncontains$Mnci;
  public static final ModuleMethod string$Mncopy;
  public static final ModuleMethod string$Mncopy$Ex;
  public static final ModuleMethod string$Mncount;
  public static final ModuleMethod string$Mndelete;
  public static final ModuleMethod string$Mndowncase;
  public static final ModuleMethod string$Mndowncase$Ex;
  public static final ModuleMethod string$Mndrop;
  public static final ModuleMethod string$Mndrop$Mnright;
  public static final ModuleMethod string$Mnevery;
  public static final ModuleMethod string$Mnfill$Ex;
  public static final ModuleMethod string$Mnfilter;
  public static final ModuleMethod string$Mnfold;
  public static final ModuleMethod string$Mnfold$Mnright;
  public static final ModuleMethod string$Mnfor$Mneach;
  public static final ModuleMethod string$Mnfor$Mneach$Mnindex;
  public static final ModuleMethod string$Mnhash;
  public static final ModuleMethod string$Mnhash$Mnci;
  public static final ModuleMethod string$Mnindex;
  public static final ModuleMethod string$Mnindex$Mnright;
  public static final ModuleMethod string$Mnjoin;
  public static final ModuleMethod string$Mnkmp$Mnpartial$Mnsearch;
  public static final ModuleMethod string$Mnmap;
  public static final ModuleMethod string$Mnmap$Ex;
  public static final ModuleMethod string$Mnnull$Qu;
  public static final ModuleMethod string$Mnpad;
  public static final ModuleMethod string$Mnpad$Mnright;
  public static final ModuleMethod string$Mnparse$Mnfinal$Mnstart$Plend;
  public static final ModuleMethod string$Mnparse$Mnstart$Plend;
  public static final ModuleMethod string$Mnprefix$Mnci$Qu;
  public static final ModuleMethod string$Mnprefix$Mnlength;
  public static final ModuleMethod string$Mnprefix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnprefix$Qu;
  public static final ModuleMethod string$Mnreplace;
  public static final ModuleMethod string$Mnreverse;
  public static final ModuleMethod string$Mnreverse$Ex;
  public static final ModuleMethod string$Mnskip;
  public static final ModuleMethod string$Mnskip$Mnright;
  public static final ModuleMethod string$Mnsuffix$Mnci$Qu;
  public static final ModuleMethod string$Mnsuffix$Mnlength;
  public static final ModuleMethod string$Mnsuffix$Mnlength$Mnci;
  public static final ModuleMethod string$Mnsuffix$Qu;
  public static final ModuleMethod string$Mntabulate;
  public static final ModuleMethod string$Mntake;
  public static final ModuleMethod string$Mntake$Mnright;
  public static final ModuleMethod string$Mntitlecase;
  public static final ModuleMethod string$Mntitlecase$Ex;
  public static final ModuleMethod string$Mntokenize;
  public static final ModuleMethod string$Mntrim;
  public static final ModuleMethod string$Mntrim$Mnboth;
  public static final ModuleMethod string$Mntrim$Mnright;
  public static final ModuleMethod string$Mnunfold;
  public static final ModuleMethod string$Mnunfold$Mnright;
  public static final ModuleMethod string$Mnupcase;
  public static final ModuleMethod string$Mnupcase$Ex;
  public static final ModuleMethod string$Mnxcopy$Ex;
  public static final ModuleMethod substring$Mnspec$Mnok$Qu;
  public static final ModuleMethod substring$Slshared;
  public static final ModuleMethod xsubstring;
  
  public static Object $PcCheckBounds(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return misc.error$V("Illegal substring START spec", new Object[] { paramObject, Integer.valueOf(paramInt1), paramCharSequence });
    }
    if (paramInt1 > paramInt2) {
      return misc.error$V("Illegal substring START/END spec", new Object[0]);
    }
    if (paramInt2 > strings.stringLength(paramCharSequence)) {
      return misc.error$V("Illegal substring END spec", new Object[] { paramObject, Integer.valueOf(paramInt2), paramCharSequence });
    }
    return Values.empty;
  }
  
  static Object $PcCheckSubstringSpec(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0)
    {
      i = 1;
      if (i == 0) {
        break label56;
      }
      if (i == 0) {
        break label74;
      }
    }
    for (;;)
    {
      return misc.error$V("Illegal substring spec.", new Object[] { paramObject, paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      i = 0;
      break;
      label56:
      if (paramInt1 > paramInt2)
      {
        i = 1;
        if (i == 0) {
          break label84;
        }
        if (i != 0) {
          continue;
        }
      }
      label74:
      label84:
      while (paramInt2 <= strings.stringLength(paramCharSequence))
      {
        return Values.empty;
        i = 0;
        break;
      }
    }
  }
  
  /* Error */
  public static Object $PcFinishStringConcatenateReverse(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   3: aload_3
    //   4: aload_0
    //   5: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: checkcast 671	java/lang/Number
    //   15: invokevirtual 675	java/lang/Number:intValue	()I
    //   18: istore 4
    //   20: iload 4
    //   22: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   25: astore 6
    //   27: aload_0
    //   28: checkcast 671	java/lang/Number
    //   31: invokevirtual 675	java/lang/Number:intValue	()I
    //   34: istore 4
    //   36: aload_2
    //   37: checkcast 681	java/lang/CharSequence
    //   40: astore 7
    //   42: aload_3
    //   43: checkcast 671	java/lang/Number
    //   46: invokevirtual 675	java/lang/Number:intValue	()I
    //   49: istore 5
    //   51: aload 6
    //   53: iload 4
    //   55: aload 7
    //   57: iconst_0
    //   58: iload 5
    //   60: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   63: pop
    //   64: aload_1
    //   65: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   68: ifeq +178 -> 246
    //   71: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   74: aload_1
    //   75: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore_2
    //   79: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   82: aload_1
    //   83: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: astore_1
    //   87: aload_2
    //   88: checkcast 681	java/lang/CharSequence
    //   91: astore_3
    //   92: aload_3
    //   93: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   96: istore 4
    //   98: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   101: aload_0
    //   102: iload 4
    //   104: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: astore_0
    //   111: aload_0
    //   112: checkcast 671	java/lang/Number
    //   115: invokevirtual 675	java/lang/Number:intValue	()I
    //   118: istore 5
    //   120: aload_2
    //   121: checkcast 681	java/lang/CharSequence
    //   124: astore_3
    //   125: aload 6
    //   127: iload 5
    //   129: aload_3
    //   130: iconst_0
    //   131: iload 4
    //   133: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   136: pop
    //   137: goto -73 -> 64
    //   140: astore_0
    //   141: new 707	gnu/mapping/WrongType
    //   144: dup
    //   145: aload_0
    //   146: ldc_w 709
    //   149: iconst_1
    //   150: aload 6
    //   152: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    //   156: astore_1
    //   157: new 707	gnu/mapping/WrongType
    //   160: dup
    //   161: aload_1
    //   162: ldc_w 715
    //   165: iconst_1
    //   166: aload_0
    //   167: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   170: athrow
    //   171: astore_0
    //   172: new 707	gnu/mapping/WrongType
    //   175: dup
    //   176: aload_0
    //   177: ldc_w 715
    //   180: iconst_2
    //   181: aload_2
    //   182: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    //   186: astore_0
    //   187: new 707	gnu/mapping/WrongType
    //   190: dup
    //   191: aload_0
    //   192: ldc_w 715
    //   195: iconst_4
    //   196: aload_3
    //   197: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore_0
    //   202: new 707	gnu/mapping/WrongType
    //   205: dup
    //   206: aload_0
    //   207: ldc_w 717
    //   210: iconst_1
    //   211: aload_2
    //   212: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   215: athrow
    //   216: astore_1
    //   217: new 707	gnu/mapping/WrongType
    //   220: dup
    //   221: aload_1
    //   222: ldc_w 715
    //   225: iconst_1
    //   226: aload_0
    //   227: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: astore_0
    //   232: new 707	gnu/mapping/WrongType
    //   235: dup
    //   236: aload_0
    //   237: ldc_w 715
    //   240: iconst_2
    //   241: aload_2
    //   242: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: aload 6
    //   248: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramObject1	Object
    //   0	249	1	paramObject2	Object
    //   0	249	2	paramObject3	Object
    //   0	249	3	paramObject4	Object
    //   18	114	4	i	int
    //   49	79	5	j	int
    //   8	239	6	localObject	Object
    //   40	16	7	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   10	20	140	java/lang/ClassCastException
    //   27	36	156	java/lang/ClassCastException
    //   36	42	171	java/lang/ClassCastException
    //   42	51	186	java/lang/ClassCastException
    //   87	92	201	java/lang/ClassCastException
    //   111	120	216	java/lang/ClassCastException
    //   120	125	231	java/lang/ClassCastException
  }
  
  public static Object $PcKmpSearch(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    Object localObject2 = AddOp.$Mn.apply2(paramObject5, paramObject4);
    localObject4 = makeKmpRestartVector$V(paramObject1, new Object[] { paramObject3, paramObject4, paramObject5 });
    localObject3 = Lit0;
    paramObject7 = AddOp.$Mn.apply2(paramObject7, paramObject6);
    localObject1 = paramObject6;
    paramObject5 = localObject2;
    paramObject6 = localObject3;
    for (;;)
    {
      if (Scheme.numEqu.apply2(paramObject6, localObject2) != Boolean.FALSE) {
        return AddOp.$Mn.apply2(localObject1, localObject2);
      }
      localObject3 = Scheme.numLEq.apply2(paramObject5, paramObject7);
      Object localObject5;
      try
      {
        bool = ((Boolean)localObject3).booleanValue();
        if (bool) {
          localObject3 = Scheme.applyToArgs;
        }
      }
      catch (ClassCastException paramObject1)
      {
        boolean bool;
        int i;
        Char localChar;
        CharSequence localCharSequence;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject3);
      }
      try
      {
        localObject5 = (CharSequence)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
      }
      try
      {
        i = ((Number)localObject1).intValue();
        localChar = Char.make(strings.stringRef((CharSequence)localObject5, i));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject1;
        localObject5 = AddOp.$Pl.apply2(paramObject4, paramObject6);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)localObject5).intValue();
        if (((Procedure)localObject3).apply3(paramObject3, localChar, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE)
        {
          localObject1 = AddOp.$Pl.apply2(Lit1, localObject1);
          paramObject6 = AddOp.$Pl.apply2(Lit1, paramObject6);
          paramObject7 = AddOp.$Mn.apply2(paramObject7, Lit1);
          paramObject5 = AddOp.$Mn.apply2(paramObject5, Lit1);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject5);
      }
      try
      {
        paramObject5 = (FVector)localObject4;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "vector-ref", 1, localObject4);
      }
      try
      {
        i = ((Number)paramObject6).intValue();
        paramObject6 = vectors.vectorRef((FVector)paramObject5, i);
        if (Scheme.numEqu.apply2(paramObject6, Lit13) != Boolean.FALSE)
        {
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit1);
          paramObject6 = Lit0;
          paramObject7 = AddOp.$Mn.apply2(paramObject7, Lit1);
          paramObject5 = localObject2;
        }
        else
        {
          paramObject5 = AddOp.$Mn.apply2(localObject2, paramObject6);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "vector-ref", 2, paramObject6);
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  /* Error */
  public static Object $PcMultispanRepcopy$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    // Byte code:
    //   0: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload 6
    //   5: aload 5
    //   7: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 10
    //   12: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   15: aload 5
    //   17: getstatic 789	gnu/kawa/functions/DivideOp:modulo	Lgnu/kawa/functions/DivideOp;
    //   20: aload_3
    //   21: aload 10
    //   23: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore 12
    //   31: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 11
    //   42: aload_0
    //   43: checkcast 681	java/lang/CharSequence
    //   46: astore_3
    //   47: aload_1
    //   48: checkcast 671	java/lang/Number
    //   51: invokevirtual 675	java/lang/Number:intValue	()I
    //   54: istore 7
    //   56: aload_2
    //   57: checkcast 681	java/lang/CharSequence
    //   60: astore 4
    //   62: aload 12
    //   64: checkcast 671	java/lang/Number
    //   67: invokevirtual 675	java/lang/Number:intValue	()I
    //   70: istore 8
    //   72: aload 6
    //   74: checkcast 671	java/lang/Number
    //   77: invokevirtual 675	java/lang/Number:intValue	()I
    //   80: istore 9
    //   82: aload_3
    //   83: iload 7
    //   85: aload 4
    //   87: iload 8
    //   89: iload 9
    //   91: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   94: pop
    //   95: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   98: aload 6
    //   100: aload 12
    //   102: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: astore_3
    //   106: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   109: aload 11
    //   111: aload_3
    //   112: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: astore 4
    //   117: getstatic 792	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
    //   120: aload 4
    //   122: aload 10
    //   124: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: astore 4
    //   129: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: astore_3
    //   138: aload 4
    //   140: checkcast 671	java/lang/Number
    //   143: astore 12
    //   145: aload 12
    //   147: invokestatic 798	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   150: ifne +84 -> 234
    //   153: aload_0
    //   154: checkcast 681	java/lang/CharSequence
    //   157: astore 12
    //   159: aload_3
    //   160: checkcast 671	java/lang/Number
    //   163: invokevirtual 675	java/lang/Number:intValue	()I
    //   166: istore 7
    //   168: aload_2
    //   169: checkcast 681	java/lang/CharSequence
    //   172: astore 13
    //   174: aload 5
    //   176: checkcast 671	java/lang/Number
    //   179: invokevirtual 675	java/lang/Number:intValue	()I
    //   182: istore 8
    //   184: aload 6
    //   186: checkcast 671	java/lang/Number
    //   189: invokevirtual 675	java/lang/Number:intValue	()I
    //   192: istore 9
    //   194: aload 12
    //   196: iload 7
    //   198: aload 13
    //   200: iload 8
    //   202: iload 9
    //   204: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   207: pop
    //   208: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   211: aload_3
    //   212: aload 10
    //   214: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: astore_3
    //   218: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   221: aload 4
    //   223: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   226: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: astore 4
    //   231: goto -93 -> 138
    //   234: aload_0
    //   235: checkcast 681	java/lang/CharSequence
    //   238: astore 4
    //   240: aload_3
    //   241: checkcast 671	java/lang/Number
    //   244: invokevirtual 675	java/lang/Number:intValue	()I
    //   247: istore 7
    //   249: aload_2
    //   250: checkcast 681	java/lang/CharSequence
    //   253: astore_0
    //   254: aload 5
    //   256: checkcast 671	java/lang/Number
    //   259: invokevirtual 675	java/lang/Number:intValue	()I
    //   262: istore 8
    //   264: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   267: aload 5
    //   269: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   272: aload 11
    //   274: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   277: aload_3
    //   278: aload_1
    //   279: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: astore_1
    //   289: aload_1
    //   290: checkcast 671	java/lang/Number
    //   293: invokevirtual 675	java/lang/Number:intValue	()I
    //   296: istore 9
    //   298: aload 4
    //   300: iload 7
    //   302: aload_0
    //   303: iload 8
    //   305: iload 9
    //   307: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   310: areturn
    //   311: astore_1
    //   312: new 707	gnu/mapping/WrongType
    //   315: dup
    //   316: aload_1
    //   317: ldc_w 715
    //   320: iconst_0
    //   321: aload_0
    //   322: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   325: athrow
    //   326: astore_0
    //   327: new 707	gnu/mapping/WrongType
    //   330: dup
    //   331: aload_0
    //   332: ldc_w 715
    //   335: iconst_1
    //   336: aload_1
    //   337: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   340: athrow
    //   341: astore_0
    //   342: new 707	gnu/mapping/WrongType
    //   345: dup
    //   346: aload_0
    //   347: ldc_w 715
    //   350: iconst_2
    //   351: aload_2
    //   352: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: astore_0
    //   357: new 707	gnu/mapping/WrongType
    //   360: dup
    //   361: aload_0
    //   362: ldc_w 715
    //   365: iconst_3
    //   366: aload 12
    //   368: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   371: athrow
    //   372: astore_0
    //   373: new 707	gnu/mapping/WrongType
    //   376: dup
    //   377: aload_0
    //   378: ldc_w 715
    //   381: iconst_4
    //   382: aload 6
    //   384: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: astore_0
    //   389: new 707	gnu/mapping/WrongType
    //   392: dup
    //   393: aload_0
    //   394: ldc_w 800
    //   397: iconst_1
    //   398: aload 4
    //   400: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   403: athrow
    //   404: astore_1
    //   405: new 707	gnu/mapping/WrongType
    //   408: dup
    //   409: aload_1
    //   410: ldc_w 715
    //   413: iconst_0
    //   414: aload_0
    //   415: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   418: athrow
    //   419: astore_0
    //   420: new 707	gnu/mapping/WrongType
    //   423: dup
    //   424: aload_0
    //   425: ldc_w 715
    //   428: iconst_1
    //   429: aload_3
    //   430: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   433: athrow
    //   434: astore_0
    //   435: new 707	gnu/mapping/WrongType
    //   438: dup
    //   439: aload_0
    //   440: ldc_w 715
    //   443: iconst_2
    //   444: aload_2
    //   445: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   448: athrow
    //   449: astore_0
    //   450: new 707	gnu/mapping/WrongType
    //   453: dup
    //   454: aload_0
    //   455: ldc_w 715
    //   458: iconst_3
    //   459: aload 5
    //   461: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   464: athrow
    //   465: astore_0
    //   466: new 707	gnu/mapping/WrongType
    //   469: dup
    //   470: aload_0
    //   471: ldc_w 715
    //   474: iconst_4
    //   475: aload 6
    //   477: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   480: athrow
    //   481: astore_1
    //   482: new 707	gnu/mapping/WrongType
    //   485: dup
    //   486: aload_1
    //   487: ldc_w 715
    //   490: iconst_0
    //   491: aload_0
    //   492: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   495: athrow
    //   496: astore_0
    //   497: new 707	gnu/mapping/WrongType
    //   500: dup
    //   501: aload_0
    //   502: ldc_w 715
    //   505: iconst_1
    //   506: aload_3
    //   507: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   510: athrow
    //   511: astore_0
    //   512: new 707	gnu/mapping/WrongType
    //   515: dup
    //   516: aload_0
    //   517: ldc_w 715
    //   520: iconst_2
    //   521: aload_2
    //   522: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   525: athrow
    //   526: astore_0
    //   527: new 707	gnu/mapping/WrongType
    //   530: dup
    //   531: aload_0
    //   532: ldc_w 715
    //   535: iconst_3
    //   536: aload 5
    //   538: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   541: athrow
    //   542: astore_0
    //   543: new 707	gnu/mapping/WrongType
    //   546: dup
    //   547: aload_0
    //   548: ldc_w 715
    //   551: iconst_4
    //   552: aload_1
    //   553: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   556: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	paramObject1	Object
    //   0	557	1	paramObject2	Object
    //   0	557	2	paramObject3	Object
    //   0	557	3	paramObject4	Object
    //   0	557	4	paramObject5	Object
    //   0	557	5	paramObject6	Object
    //   0	557	6	paramObject7	Object
    //   54	247	7	i	int
    //   70	234	8	j	int
    //   80	226	9	k	int
    //   10	203	10	localObject1	Object
    //   40	233	11	localObject2	Object
    //   29	338	12	localObject3	Object
    //   172	27	13	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   42	47	311	java/lang/ClassCastException
    //   47	56	326	java/lang/ClassCastException
    //   56	62	341	java/lang/ClassCastException
    //   62	72	356	java/lang/ClassCastException
    //   72	82	372	java/lang/ClassCastException
    //   138	145	388	java/lang/ClassCastException
    //   153	159	404	java/lang/ClassCastException
    //   159	168	419	java/lang/ClassCastException
    //   168	174	434	java/lang/ClassCastException
    //   174	184	449	java/lang/ClassCastException
    //   184	194	465	java/lang/ClassCastException
    //   234	240	481	java/lang/ClassCastException
    //   240	249	496	java/lang/ClassCastException
    //   249	254	511	java/lang/ClassCastException
    //   254	264	526	java/lang/ClassCastException
    //   289	298	542	java/lang/ClassCastException
  }
  
  public static Object $PcStringCompare(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    Object localObject2 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject1 = AddOp.$Mn.apply2(paramObject6, paramObject5);
    paramObject6 = $PcStringPrefixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
    if (Scheme.numEqu.apply2(paramObject6, localObject2) != Boolean.FALSE)
    {
      paramObject1 = Scheme.applyToArgs;
      if (Scheme.numEqu.apply2(paramObject6, localObject1) != Boolean.FALSE) {}
      for (;;)
      {
        return ((Procedure)paramObject1).apply2(paramObject8, paramObject3);
        paramObject8 = paramObject7;
      }
    }
    paramObject3 = Scheme.applyToArgs;
    if (Scheme.numEqu.apply2(paramObject6, localObject1) != Boolean.FALSE) {}
    for (;;)
    {
      return ((Procedure)paramObject3).apply2(paramObject9, AddOp.$Pl.apply2(paramObject6, paramObject2));
      try
      {
        paramObject8 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Pl.apply2(paramObject2, paramObject6);
      }
      catch (ClassCastException paramObject2)
      {
        try
        {
          i = ((Number)paramObject1).intValue();
          paramObject1 = Char.make(strings.stringRef((CharSequence)paramObject8, i));
        }
        catch (ClassCastException paramObject2)
        {
          int i;
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        try
        {
          paramObject8 = (CharSequence)paramObject4;
          paramObject4 = AddOp.$Pl.apply2(paramObject5, paramObject6);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject4);
        }
        try
        {
          i = ((Number)paramObject4).intValue();
          if (!characters.isChar$Ls((Char)paramObject1, Char.make(strings.stringRef((CharSequence)paramObject8, i)))) {
            continue;
          }
          paramObject9 = paramObject7;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject4);
        }
        paramObject2 = paramObject2;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
    }
  }
  
  /* Error */
  public static Object $PcStringCompareCi(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    // Byte code:
    //   0: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload_2
    //   4: aload_1
    //   5: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore 14
    //   10: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   13: aload 5
    //   15: aload 4
    //   17: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 13
    //   22: aload_1
    //   23: checkcast 671	java/lang/Number
    //   26: invokevirtual 675	java/lang/Number:intValue	()I
    //   29: istore 9
    //   31: aload_2
    //   32: checkcast 671	java/lang/Number
    //   35: invokevirtual 675	java/lang/Number:intValue	()I
    //   38: istore 10
    //   40: aload 4
    //   42: checkcast 671	java/lang/Number
    //   45: invokevirtual 675	java/lang/Number:intValue	()I
    //   48: istore 11
    //   50: aload 5
    //   52: checkcast 671	java/lang/Number
    //   55: invokevirtual 675	java/lang/Number:intValue	()I
    //   58: istore 12
    //   60: aload_0
    //   61: iload 9
    //   63: iload 10
    //   65: aload_3
    //   66: iload 11
    //   68: iload 12
    //   70: invokestatic 817	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
    //   73: istore 9
    //   75: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   78: iload 9
    //   80: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aload 14
    //   85: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: if_acmpeq +41 -> 132
    //   94: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   97: astore_0
    //   98: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   101: iload 9
    //   103: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aload 13
    //   108: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   114: if_acmpeq +11 -> 125
    //   117: aload_0
    //   118: aload 7
    //   120: aload_2
    //   121: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: areturn
    //   125: aload 6
    //   127: astore 7
    //   129: goto -12 -> 117
    //   132: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   135: astore_2
    //   136: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   139: iload 9
    //   141: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aload 13
    //   146: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   152: if_acmpeq +22 -> 174
    //   155: aload_2
    //   156: aload 8
    //   158: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   161: aload_1
    //   162: iload 9
    //   164: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: areturn
    //   174: aload_0
    //   175: checkcast 681	java/lang/CharSequence
    //   178: astore 5
    //   180: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   183: aload_1
    //   184: iload 9
    //   186: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: astore_0
    //   193: aload_0
    //   194: checkcast 671	java/lang/Number
    //   197: invokevirtual 675	java/lang/Number:intValue	()I
    //   200: istore 10
    //   202: aload 5
    //   204: iload 10
    //   206: invokestatic 751	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   209: invokestatic 757	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   212: astore_0
    //   213: aload_3
    //   214: checkcast 681	java/lang/CharSequence
    //   217: astore 5
    //   219: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   222: aload 4
    //   224: iload 9
    //   226: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: astore_3
    //   233: aload_3
    //   234: checkcast 671	java/lang/Number
    //   237: invokevirtual 675	java/lang/Number:intValue	()I
    //   240: istore 10
    //   242: aload_0
    //   243: aload 5
    //   245: iload 10
    //   247: invokestatic 751	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   250: invokestatic 757	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   253: invokestatic 822	kawa/lib/rnrs/unicode:isCharCi$Ls	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   256: ifeq -101 -> 155
    //   259: aload 6
    //   261: astore 8
    //   263: goto -108 -> 155
    //   266: astore_0
    //   267: new 707	gnu/mapping/WrongType
    //   270: dup
    //   271: aload_0
    //   272: ldc_w 824
    //   275: iconst_1
    //   276: aload_1
    //   277: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore_0
    //   282: new 707	gnu/mapping/WrongType
    //   285: dup
    //   286: aload_0
    //   287: ldc_w 824
    //   290: iconst_2
    //   291: aload_2
    //   292: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore_0
    //   297: new 707	gnu/mapping/WrongType
    //   300: dup
    //   301: aload_0
    //   302: ldc_w 824
    //   305: iconst_4
    //   306: aload 4
    //   308: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore_0
    //   313: new 707	gnu/mapping/WrongType
    //   316: dup
    //   317: aload_0
    //   318: ldc_w 824
    //   321: iconst_5
    //   322: aload 5
    //   324: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: astore_1
    //   329: new 707	gnu/mapping/WrongType
    //   332: dup
    //   333: aload_1
    //   334: ldc_w 780
    //   337: iconst_1
    //   338: aload_0
    //   339: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   342: athrow
    //   343: astore_1
    //   344: new 707	gnu/mapping/WrongType
    //   347: dup
    //   348: aload_1
    //   349: ldc_w 780
    //   352: iconst_2
    //   353: aload_0
    //   354: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: astore_0
    //   359: new 707	gnu/mapping/WrongType
    //   362: dup
    //   363: aload_0
    //   364: ldc_w 780
    //   367: iconst_1
    //   368: aload_3
    //   369: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: astore_0
    //   374: new 707	gnu/mapping/WrongType
    //   377: dup
    //   378: aload_0
    //   379: ldc_w 780
    //   382: iconst_2
    //   383: aload_3
    //   384: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramObject1	Object
    //   0	388	1	paramObject2	Object
    //   0	388	2	paramObject3	Object
    //   0	388	3	paramObject4	Object
    //   0	388	4	paramObject5	Object
    //   0	388	5	paramObject6	Object
    //   0	388	6	paramObject7	Object
    //   0	388	7	paramObject8	Object
    //   0	388	8	paramObject9	Object
    //   29	196	9	i	int
    //   38	208	10	j	int
    //   48	19	11	k	int
    //   58	11	12	m	int
    //   20	125	13	localObject1	Object
    //   8	76	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	31	266	java/lang/ClassCastException
    //   31	40	281	java/lang/ClassCastException
    //   40	50	296	java/lang/ClassCastException
    //   50	60	312	java/lang/ClassCastException
    //   174	180	328	java/lang/ClassCastException
    //   193	202	343	java/lang/ClassCastException
    //   213	219	358	java/lang/ClassCastException
    //   233	242	373	java/lang/ClassCastException
  }
  
  public static Object $PcStringCopy$Ex(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      if ((paramInt2 <= paramInt1) || (paramInt2 < paramInt3)) {}
      try
      {
        localCharSeq = (CharSeq)paramCharSequence1;
        strings.stringSet$Ex(localCharSeq, paramInt1, strings.stringRef(paramCharSequence2, paramInt2));
        paramInt1 += 1;
        paramInt2 += 1;
      }
      catch (ClassCastException paramCharSequence2)
      {
        CharSeq localCharSeq;
        int i;
        throw new WrongType(paramCharSequence2, "string-set!", 1, paramCharSequence1);
      }
    }
    return Values.empty;
    paramInt1 = paramInt1 - 1 + (paramInt3 - paramInt2);
    i = paramInt3 - 1;
    paramInt3 = paramInt1;
    paramInt1 = i;
    for (;;)
    {
      if (paramInt1 >= paramInt2) {}
      try
      {
        localCharSeq = (CharSeq)paramCharSequence1;
        strings.stringSet$Ex(localCharSeq, paramInt3, strings.stringRef(paramCharSequence2, paramInt1));
        paramInt3 -= 1;
        paramInt1 -= 1;
      }
      catch (ClassCastException paramCharSequence2)
      {
        throw new WrongType(paramCharSequence2, "string-set!", 1, paramCharSequence1);
      }
    }
    return Values.empty;
  }
  
  public static Object $PcStringHash(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    frame55 localframe55 = new frame55();
    localframe55.char$Mn$Grint = paramObject2;
    paramObject2 = Lit5;
    Object localObject2;
    Object localObject1;
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE)
    {
      localObject2 = AddOp.$Mn.apply2(paramObject2, Lit1);
      localObject1 = Lit0;
      paramObject2 = paramObject4;
      paramObject4 = localObject1;
    }
    for (;;)
    {
      if (Scheme.numGEq.apply2(paramObject2, paramObject5) != Boolean.FALSE)
      {
        return DivideOp.modulo.apply2(paramObject4, paramObject3);
        paramObject2 = AddOp.$Pl.apply2(paramObject2, paramObject2);
        break;
      }
      localObject1 = AddOp.$Pl.apply2(paramObject2, Lit1);
      BitwiseOp localBitwiseOp = BitwiseOp.and;
      AddOp localAddOp = AddOp.$Pl;
      paramObject4 = MultiplyOp.$St.apply2(Lit6, paramObject4);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject3 = localframe55.char$Mn$Grint;
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        try
        {
          CharSequence localCharSequence;
          int i = ((Number)paramObject2).intValue();
          paramObject4 = localBitwiseOp.apply2(localObject2, localAddOp.apply2(paramObject4, localApplyToArgs.apply2(localObject3, Char.make(strings.stringRef(localCharSequence, i)))));
          paramObject2 = localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
        }
        paramObject2 = paramObject2;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
    }
  }
  
  /* Error */
  public static Object $PcStringMap(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   3: aload_3
    //   4: aload_2
    //   5: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: checkcast 671	java/lang/Number
    //   13: invokevirtual 675	java/lang/Number:intValue	()I
    //   16: istore 5
    //   18: iload 5
    //   20: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   23: astore 7
    //   25: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   28: aload_3
    //   29: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   32: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore_3
    //   36: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   39: aload_2
    //   40: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   43: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore_2
    //   47: getstatic 864	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   50: aload_2
    //   51: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   54: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   60: if_acmpne +193 -> 253
    //   63: aload 7
    //   65: checkcast 826	gnu/lists/CharSeq
    //   68: astore 8
    //   70: aload_2
    //   71: checkcast 671	java/lang/Number
    //   74: invokevirtual 675	java/lang/Number:intValue	()I
    //   77: istore 5
    //   79: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   82: astore 9
    //   84: aload_1
    //   85: checkcast 681	java/lang/CharSequence
    //   88: astore 10
    //   90: aload_3
    //   91: checkcast 671	java/lang/Number
    //   94: invokevirtual 675	java/lang/Number:intValue	()I
    //   97: istore 6
    //   99: aload 9
    //   101: aload_0
    //   102: aload 10
    //   104: iload 6
    //   106: invokestatic 751	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   109: invokestatic 757	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   112: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: astore 9
    //   117: aload 9
    //   119: checkcast 753	gnu/text/Char
    //   122: invokevirtual 868	gnu/text/Char:charValue	()C
    //   125: istore 4
    //   127: aload 8
    //   129: iload 5
    //   131: iload 4
    //   133: invokestatic 830	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   136: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   139: aload_3
    //   140: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   143: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: astore_3
    //   147: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   150: aload_2
    //   151: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   154: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: astore_2
    //   158: goto -111 -> 47
    //   161: astore_0
    //   162: new 707	gnu/mapping/WrongType
    //   165: dup
    //   166: aload_0
    //   167: ldc_w 709
    //   170: iconst_1
    //   171: aload_2
    //   172: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   175: athrow
    //   176: astore_0
    //   177: new 707	gnu/mapping/WrongType
    //   180: dup
    //   181: aload_0
    //   182: ldc_w 832
    //   185: iconst_1
    //   186: aload 7
    //   188: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   191: athrow
    //   192: astore_0
    //   193: new 707	gnu/mapping/WrongType
    //   196: dup
    //   197: aload_0
    //   198: ldc_w 832
    //   201: iconst_2
    //   202: aload_2
    //   203: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: astore_0
    //   208: new 707	gnu/mapping/WrongType
    //   211: dup
    //   212: aload_0
    //   213: ldc_w 780
    //   216: iconst_1
    //   217: aload_1
    //   218: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: astore_0
    //   223: new 707	gnu/mapping/WrongType
    //   226: dup
    //   227: aload_0
    //   228: ldc_w 780
    //   231: iconst_2
    //   232: aload_3
    //   233: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: astore_0
    //   238: new 707	gnu/mapping/WrongType
    //   241: dup
    //   242: aload_0
    //   243: ldc_w 832
    //   246: iconst_3
    //   247: aload 9
    //   249: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: aload 7
    //   255: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramObject1	Object
    //   0	256	1	paramObject2	Object
    //   0	256	2	paramObject3	Object
    //   0	256	3	paramObject4	Object
    //   125	7	4	c	char
    //   16	114	5	i	int
    //   97	8	6	j	int
    //   23	231	7	localCharSequence1	CharSequence
    //   68	60	8	localCharSeq	CharSeq
    //   82	166	9	localObject	Object
    //   88	15	10	localCharSequence2	CharSequence
    // Exception table:
    //   from	to	target	type
    //   9	18	161	java/lang/ClassCastException
    //   63	70	176	java/lang/ClassCastException
    //   70	79	192	java/lang/ClassCastException
    //   84	90	207	java/lang/ClassCastException
    //   90	99	222	java/lang/ClassCastException
    //   117	127	237	java/lang/ClassCastException
  }
  
  public static Object $PcStringMap$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    paramObject4 = AddOp.$Mn.apply2(paramObject4, Lit1);
    for (;;)
    {
      if (Scheme.numLss.apply2(paramObject4, paramObject3) == Boolean.FALSE) {}
      Object localObject;
      try
      {
        localCharSeq = (CharSeq)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        CharSeq localCharSeq;
        int i;
        CharSequence localCharSequence;
        int j;
        char c;
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, paramObject2);
      }
      try
      {
        i = ((Number)paramObject4).intValue();
        localObject = Scheme.applyToArgs;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramObject4);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
      }
      try
      {
        j = ((Number)paramObject4).intValue();
        localObject = ((Procedure)localObject).apply2(paramObject1, Char.make(strings.stringRef(localCharSequence, j)));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject4);
      }
      try
      {
        c = ((Char)localObject).charValue();
        strings.stringSet$Ex(localCharSeq, i, c);
        paramObject4 = AddOp.$Mn.apply2(paramObject4, Lit1);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject);
      }
    }
    return Values.empty;
  }
  
  public static Object $PcStringPrefix$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject2 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject1 = Scheme.numLEq.apply2(localObject2, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      boolean bool = ((Boolean)localObject1).booleanValue();
      if (bool) {
        return Scheme.numEqu.apply2($PcStringPrefixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6), localObject2);
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
    }
  }
  
  public static Object $PcStringPrefixCi$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        localObject2 = Scheme.numEqu;
      }
    }
    catch (ClassCastException paramObject1)
    {
      boolean bool;
      int i;
      int j;
      int k;
      int m;
      throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject2);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-prefix-length-ci", 1, paramObject2);
    }
    try
    {
      j = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-prefix-length-ci", 2, paramObject3);
    }
    try
    {
      k = ((Number)paramObject5).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-prefix-length-ci", 4, paramObject5);
    }
    try
    {
      m = ((Number)paramObject6).intValue();
      return ((Procedure)localObject2).apply2(localObject1, Integer.valueOf($PcStringPrefixLengthCi(paramObject1, i, j, paramObject4, k, m)));
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-prefix-length-ci", 5, paramObject6);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object $PcStringPrefixLength(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    int i = 0;
    paramObject3 = numbers.min(new Object[] { AddOp.$Mn.apply2(paramObject3, paramObject2), AddOp.$Mn.apply2(paramObject6, paramObject5) });
    Object localObject = AddOp.$Pl.apply2(paramObject2, paramObject3);
    if (paramObject1 == paramObject4) {
      i = 1;
    }
    if (i != 0)
    {
      if (Scheme.numEqu.apply2(paramObject2, paramObject5) == Boolean.FALSE) {}
    }
    else {
      while (i != 0) {
        return paramObject3;
      }
    }
    paramObject6 = paramObject2;
    paramObject3 = paramObject5;
    paramObject5 = paramObject6;
    for (;;)
    {
      paramObject6 = Scheme.numGEq.apply2(paramObject5, localObject);
      try
      {
        boolean bool = ((Boolean)paramObject6).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label193;
          }
          label122:
          return AddOp.$Mn.apply2(paramObject5, paramObject2);
        }
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          paramObject6 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          CharSequence localCharSequence;
          label193:
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject5).intValue();
          paramObject6 = Char.make(strings.stringRef((CharSequence)paramObject6, i));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject5);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject4;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject4);
        }
        try
        {
          i = ((Number)paramObject3).intValue();
          if (!characters.isChar$Eq((Char)paramObject6, Char.make(strings.stringRef(localCharSequence, i)))) {
            break label122;
          }
          paramObject5 = AddOp.$Pl.apply2(paramObject5, Lit1);
          paramObject3 = AddOp.$Pl.apply2(paramObject3, Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject3);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject6);
      }
    }
  }
  
  public static int $PcStringPrefixLengthCi(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4)
  {
    localObject = numbers.min(new Object[] { Integer.valueOf(paramInt2 - paramInt1), Integer.valueOf(paramInt4 - paramInt3) });
    try
    {
      i = ((Number)localObject).intValue();
      if (paramObject1 == paramObject2)
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label64;
        }
        if (paramInt1 != paramInt3) {
          break label68;
        }
      }
      label64:
      while (paramInt2 != 0)
      {
        return i;
        paramInt2 = 0;
        break;
      }
      label68:
      paramInt2 = paramInt1;
    }
    catch (ClassCastException paramObject1)
    {
      for (;;)
      {
        try
        {
          int i;
          localObject = (CharSequence)paramObject1;
          localObject = Char.make(strings.stringRef((CharSequence)localObject, paramInt2));
        }
        catch (ClassCastException paramObject2)
        {
          CharSequence localCharSequence;
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject2;
          if (unicode.isCharCi$Eq((Char)localObject, Char.make(strings.stringRef(localCharSequence, paramInt3))))
          {
            paramInt2 += 1;
            paramInt3 += 1;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
      }
      paramObject1 = paramObject1;
      throw new WrongType((ClassCastException)paramObject1, "delta", -2, localObject);
    }
    if (paramInt2 >= paramInt1 + i) {}
    for (paramInt4 = 1; paramInt4 != 0; paramInt4 = 0)
    {
      if (paramInt4 == 0) {
        break label142;
      }
      return paramInt2 - paramInt1;
    }
  }
  
  public static Object $PcStringSuffix$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject2 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    Object localObject1 = Scheme.numLEq.apply2(localObject2, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      boolean bool = ((Boolean)localObject1).booleanValue();
      if (bool) {
        return Scheme.numEqu.apply2(localObject2, $PcStringSuffixLength(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6));
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
    }
  }
  
  public static Object $PcStringSuffixCi$Qu(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    Object localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
    localObject2 = Scheme.numLEq.apply2(localObject1, AddOp.$Mn.apply2(paramObject6, paramObject5));
    try
    {
      bool = ((Boolean)localObject2).booleanValue();
      if (bool) {
        localObject2 = Scheme.numEqu;
      }
    }
    catch (ClassCastException paramObject1)
    {
      boolean bool;
      int i;
      int j;
      int k;
      int m;
      throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject2);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-suffix-length-ci", 1, paramObject2);
    }
    try
    {
      j = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-suffix-length-ci", 2, paramObject3);
    }
    try
    {
      k = ((Number)paramObject5).intValue();
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-suffix-length-ci", 4, paramObject5);
    }
    try
    {
      m = ((Number)paramObject6).intValue();
      return ((Procedure)localObject2).apply2(localObject1, Integer.valueOf($PcStringSuffixLengthCi(paramObject1, i, j, paramObject4, k, m)));
    }
    catch (ClassCastException paramObject1)
    {
      throw new WrongType((ClassCastException)paramObject1, "%string-suffix-length-ci", 5, paramObject6);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object $PcStringSuffixLength(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    int i = 0;
    paramObject2 = numbers.min(new Object[] { AddOp.$Mn.apply2(paramObject3, paramObject2), AddOp.$Mn.apply2(paramObject6, paramObject5) });
    Object localObject = AddOp.$Mn.apply2(paramObject3, paramObject2);
    if (paramObject1 == paramObject4) {
      i = 1;
    }
    if (i != 0)
    {
      if (Scheme.numEqu.apply2(paramObject3, paramObject6) == Boolean.FALSE) {}
    }
    else {
      while (i != 0) {
        return paramObject2;
      }
    }
    paramObject5 = AddOp.$Mn.apply2(paramObject3, Lit1);
    paramObject2 = AddOp.$Mn.apply2(paramObject6, Lit1);
    for (;;)
    {
      paramObject6 = Scheme.numLss.apply2(paramObject5, localObject);
      try
      {
        boolean bool = ((Boolean)paramObject6).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label216;
          }
          label136:
          return AddOp.$Mn.apply2(AddOp.$Mn.apply2(paramObject3, paramObject5), Lit1);
        }
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          paramObject6 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          CharSequence localCharSequence;
          label216:
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject5).intValue();
          paramObject6 = Char.make(strings.stringRef((CharSequence)paramObject6, i));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject5);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject4;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject4);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          if (!characters.isChar$Eq((Char)paramObject6, Char.make(strings.stringRef(localCharSequence, i)))) {
            break label136;
          }
          paramObject5 = AddOp.$Mn.apply2(paramObject5, Lit1);
          paramObject2 = AddOp.$Mn.apply2(paramObject2, Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject6);
      }
    }
  }
  
  public static int $PcStringSuffixLengthCi(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4)
  {
    localObject = numbers.min(new Object[] { Integer.valueOf(paramInt2 - paramInt1), Integer.valueOf(paramInt4 - paramInt3) });
    try
    {
      i = ((Number)localObject).intValue();
      if (paramObject1 == paramObject2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label64;
        }
        if (paramInt2 != paramInt4) {
          break label68;
        }
      }
      label64:
      while (paramInt1 != 0)
      {
        return i;
        paramInt1 = 0;
        break;
      }
      label68:
      paramInt1 = paramInt2 - 1;
      paramInt3 = paramInt4 - 1;
    }
    catch (ClassCastException paramObject1)
    {
      for (;;)
      {
        try
        {
          int i;
          localObject = (CharSequence)paramObject1;
          localObject = Char.make(strings.stringRef((CharSequence)localObject, paramInt1));
        }
        catch (ClassCastException paramObject2)
        {
          CharSequence localCharSequence;
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject2;
          if (unicode.isCharCi$Eq((Char)localObject, Char.make(strings.stringRef(localCharSequence, paramInt3))))
          {
            paramInt3 -= 1;
            paramInt1 -= 1;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
      }
      paramObject1 = paramObject1;
      throw new WrongType((ClassCastException)paramObject1, "delta", -2, localObject);
    }
    if (paramInt1 < paramInt2 - i) {}
    for (paramInt4 = 1; paramInt4 != 0; paramInt4 = 0)
    {
      if (paramInt4 == 0) {
        break label152;
      }
      return paramInt2 - paramInt1 - 1;
    }
  }
  
  public static Object $PcStringTitlecase$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    for (;;)
    {
      Object localObject1 = loc$char$Mncased$Qu;
      Object localObject2;
      try
      {
        localObject1 = ((Location)localObject1).get();
        paramObject2 = stringIndex$V(paramObject1, localObject1, new Object[] { paramObject2, paramObject3 });
        if (paramObject2 == Boolean.FALSE) {}
      }
      catch (UnboundLocationException paramObject1)
      {
        int i;
        int j;
        char c;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 955, 28);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = (CharSeq)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-set!", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramObject2);
      }
      try
      {
        localObject2 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        localObject2 = unicode.charTitlecase(Char.make(strings.stringRef((CharSequence)localObject2, j)));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      try
      {
        c = ((Char)localObject2).charValue();
        strings.stringSet$Ex((CharSeq)localObject1, i, c);
        paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit1);
        localObject1 = loc$char$Mncased$Qu;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject2);
      }
      try
      {
        localObject1 = ((Location)localObject1).get();
        localObject1 = stringSkip$V(paramObject1, localObject1, new Object[] { paramObject2, paramObject3 });
        if (localObject1 != Boolean.FALSE)
        {
          stringDowncase$Ex$V(paramObject1, new Object[] { paramObject2, localObject1 });
          paramObject2 = AddOp.$Pl.apply2(localObject1, Lit1);
        }
        else
        {
          return stringDowncase$Ex$V(paramObject1, new Object[] { paramObject2, paramObject3 });
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 959, 31);
        throw ((Throwable)paramObject1);
      }
    }
    return Values.empty;
  }
  
  public static Object $PcSubstring$SlShared(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool = numbers.isZero(Integer.valueOf(paramInt1));
    if (bool)
    {
      if (paramInt2 != strings.stringLength(paramCharSequence)) {}
    }
    else {
      while (bool) {
        return paramCharSequence;
      }
    }
    return strings.substring(paramCharSequence, paramInt1, paramInt2);
  }
  
  static
  {
    Lit149 = (SimpleSymbol)new SimpleSymbol("string-join").readResolve();
    Lit148 = (SimpleSymbol)new SimpleSymbol("%multispan-repcopy!").readResolve();
    Lit147 = (SimpleSymbol)new SimpleSymbol("string-xcopy!").readResolve();
    Lit146 = (SimpleSymbol)new SimpleSymbol("xsubstring").readResolve();
    Lit145 = (SimpleSymbol)new SimpleSymbol("string-tokenize").readResolve();
    Lit144 = (SimpleSymbol)new SimpleSymbol("string-replace").readResolve();
    Lit143 = (SimpleSymbol)new SimpleSymbol("%finish-string-concatenate-reverse").readResolve();
    Lit142 = (SimpleSymbol)new SimpleSymbol("string-concatenate-reverse/shared").readResolve();
    Lit141 = (SimpleSymbol)new SimpleSymbol("string-concatenate-reverse").readResolve();
    Lit140 = (SimpleSymbol)new SimpleSymbol("string-concatenate").readResolve();
    Lit139 = (SimpleSymbol)new SimpleSymbol("string-concatenate/shared").readResolve();
    Lit138 = (SimpleSymbol)new SimpleSymbol("string-append/shared").readResolve();
    Lit137 = (SimpleSymbol)new SimpleSymbol("string->list").readResolve();
    Lit136 = (SimpleSymbol)new SimpleSymbol("reverse-list->string").readResolve();
    Lit135 = (SimpleSymbol)new SimpleSymbol("string-reverse!").readResolve();
    Lit134 = (SimpleSymbol)new SimpleSymbol("string-reverse").readResolve();
    Lit133 = (SimpleSymbol)new SimpleSymbol("string-null?").readResolve();
    Lit132 = (SimpleSymbol)new SimpleSymbol("string-kmp-partial-search").readResolve();
    Lit131 = (SimpleSymbol)new SimpleSymbol("kmp-step").readResolve();
    Lit130 = (SimpleSymbol)new SimpleSymbol("make-kmp-restart-vector").readResolve();
    Lit129 = (SimpleSymbol)new SimpleSymbol("%kmp-search").readResolve();
    Lit128 = (SimpleSymbol)new SimpleSymbol("string-contains-ci").readResolve();
    Lit127 = (SimpleSymbol)new SimpleSymbol("string-contains").readResolve();
    Lit126 = (SimpleSymbol)new SimpleSymbol("%string-copy!").readResolve();
    Lit125 = (SimpleSymbol)new SimpleSymbol("string-copy!").readResolve();
    Lit124 = (SimpleSymbol)new SimpleSymbol("string-fill!").readResolve();
    Lit123 = (SimpleSymbol)new SimpleSymbol("string-count").readResolve();
    Lit122 = (SimpleSymbol)new SimpleSymbol("string-skip-right").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("string-skip").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("string-index-right").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("string-index").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("string-filter").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("string-delete").readResolve();
    Lit116 = (SimpleSymbol)new SimpleSymbol("string-pad").readResolve();
    Lit115 = (SimpleSymbol)new SimpleSymbol("string-pad-right").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("string-trim-both").readResolve();
    Lit113 = (SimpleSymbol)new SimpleSymbol("string-trim-right").readResolve();
    Lit112 = (SimpleSymbol)new SimpleSymbol("string-trim").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("string-drop-right").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("string-drop").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol("string-take-right").readResolve();
    Lit108 = (SimpleSymbol)new SimpleSymbol("string-take").readResolve();
    Lit107 = (SimpleSymbol)new SimpleSymbol("string-titlecase").readResolve();
    Lit106 = (SimpleSymbol)new SimpleSymbol("string-titlecase!").readResolve();
    Lit105 = (SimpleSymbol)new SimpleSymbol("%string-titlecase!").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol("string-downcase!").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol("string-downcase").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("string-upcase!").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("string-upcase").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol("string-hash-ci").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit98 = (SimpleSymbol)new SimpleSymbol("%string-hash").readResolve();
    Lit97 = (SimpleSymbol)new SimpleSymbol("string-ci>=").readResolve();
    Lit96 = (SimpleSymbol)new SimpleSymbol("string-ci<=").readResolve();
    Lit95 = (SimpleSymbol)new SimpleSymbol("string-ci>").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol("string-ci<").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol("string-ci<>").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol("string-ci=").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol("string>=").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol("string<=").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol("string>").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol("string<").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol("string<>").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol("string=").readResolve();
    Lit85 = (SimpleSymbol)new SimpleSymbol("string-compare-ci").readResolve();
    Lit84 = (SimpleSymbol)new SimpleSymbol("string-compare").readResolve();
    Lit83 = (SimpleSymbol)new SimpleSymbol("%string-compare-ci").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol("%string-compare").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("%string-suffix-ci?").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("%string-prefix-ci?").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("%string-suffix?").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("%string-prefix?").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("string-suffix-ci?").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("string-prefix-ci?").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("string-suffix?").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("string-prefix?").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("string-suffix-length-ci").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("string-prefix-length-ci").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("string-suffix-length").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("string-prefix-length").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("%string-suffix-length-ci").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("%string-prefix-length-ci").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("%string-suffix-length").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("%string-prefix-length").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("string-tabulate").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("string-any").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("string-every").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("string-for-each-index").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("string-for-each").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("string-unfold-right").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("string-unfold").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("string-fold-right").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("string-fold").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("%string-map!").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("string-map!").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("%string-map").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("string-map").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("string-copy").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("%substring/shared").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("substring/shared").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("check-substring-spec").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("substring-spec-ok?").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("string-parse-final-start+end").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("%check-bounds").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("string-parse-start+end").readResolve();
    Object localObject1 = (SimpleSymbol)new SimpleSymbol("l-s-s+e2").readResolve();
    Object localObject2 = new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\f'\f/\f7\f?\rG@\b\b", new Object[0], 9);
    Object localObject3 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("procv").readResolve();
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("let-string-start+end").readResolve();
    Lit41 = localSimpleSymbol2;
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("rest").readResolve();
    Lit27 = localSimpleSymbol3;
    localObject2 = new SyntaxRule((SyntaxPattern)localObject2, "\001\001\001\001\001\001\001\001\003", "\021\030\0041\b\021\030\f\b#\b\021\030\0241\t\003\t\013\030\034\021\030\f\t+\t;\b\021\030\024!\t\023\b\033\021\030\f\t3\021\030$\bEC", new Object[] { localObject3, localSimpleSymbol1, localSimpleSymbol2, PairWithPosition.make(localSimpleSymbol3, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 553003), Lit27 }, 1);
    Lit44 = new SyntaxRules(new Object[] { localObject1 }, new SyntaxRule[] { localObject2 }, 9);
    Lit43 = (SimpleSymbol)new SimpleSymbol("let-string-start+end2").readResolve();
    localObject1 = Lit41;
    localObject2 = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\f\027\f\037\f'\r/(\b\b", new Object[0], 6), "\001\001\001\001\001\003", "\021\030\004!\t\003\b\013I\021\030\f\t\023\t\033\b#\b-+", new Object[] { Lit150, Lit47 }, 1);
    localObject3 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\f\037\f'\f/\r70\b\b", new Object[0], 7), "\001\001\001\001\001\001\003", "\021\030\0041\t\023\t\003\b\013I\021\030\f\t\033\t#\b+\b53", new Object[] { Lit150, Lit45 }, 1);
    Lit42 = new SyntaxRules(new Object[] { localObject1 }, new SyntaxRule[] { localObject2, localObject3 }, 7);
    Lit40 = (SimpleSymbol)new SimpleSymbol("grammar").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("delim").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("token-chars").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("final").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("s-end").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("s-start").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("p-start").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("end").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("start").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("c=").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("char-set").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("criterion").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("char-cased?").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("bound").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("char-set-contains?").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("char-set?").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("make-final").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("base").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("let-optionals*").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol(":optional").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("check-arg").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("suffix").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("prefix").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("strict-infix").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("infix").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("graphic").readResolve();
    Lit13 = IntNum.make(-1);
    Lit12 = Char.make(32);
    Lit11 = (SimpleSymbol)new SimpleSymbol("whitespace").readResolve();
    Lit10 = IntNum.make(4194304);
    Lit9 = IntNum.make(4194304);
    Lit8 = IntNum.make(4194304);
    Lit7 = IntNum.make(4194304);
    Lit6 = IntNum.make(37);
    Lit5 = IntNum.make(65536);
    Lit4 = IntNum.make(4096);
    Lit3 = IntNum.make(40);
    Lit2 = IntNum.make(4096);
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new srfi13();
    loc$check$Mnarg = ThreadLocation.getInstance(Lit19, null);
    loc$$Cloptional = ThreadLocation.getInstance(Lit20, null);
    loc$let$Mnoptionals$St = ThreadLocation.getInstance(Lit21, null);
    loc$base = ThreadLocation.getInstance(Lit22, null);
    loc$make$Mnfinal = ThreadLocation.getInstance(Lit23, null);
    loc$char$Mnset$Qu = ThreadLocation.getInstance(Lit24, null);
    loc$char$Mnset$Mncontains$Qu = ThreadLocation.getInstance(Lit25, null);
    loc$bound = ThreadLocation.getInstance(Lit26, null);
    loc$rest = ThreadLocation.getInstance(Lit27, null);
    loc$char$Mncased$Qu = ThreadLocation.getInstance(Lit28, null);
    loc$criterion = ThreadLocation.getInstance(Lit29, null);
    loc$char$Mnset = ThreadLocation.getInstance(Lit30, null);
    loc$c$Eq = ThreadLocation.getInstance(Lit31, null);
    loc$start = ThreadLocation.getInstance(Lit32, null);
    loc$end = ThreadLocation.getInstance(Lit33, null);
    loc$p$Mnstart = ThreadLocation.getInstance(Lit34, null);
    loc$s$Mnstart = ThreadLocation.getInstance(Lit35, null);
    loc$s$Mnend = ThreadLocation.getInstance(Lit36, null);
    loc$final = ThreadLocation.getInstance(Lit37, null);
    loc$token$Mnchars = ThreadLocation.getInstance(Lit38, null);
    loc$delim = ThreadLocation.getInstance(Lit39, null);
    loc$grammar = ThreadLocation.getInstance(Lit40, null);
    let$Mnstring$Mnstart$Plend = Macro.make(Lit41, Lit42, $instance);
    let$Mnstring$Mnstart$Plend2 = Macro.make(Lit43, Lit44, $instance);
    localObject1 = $instance;
    string$Mnparse$Mnstart$Plend = new ModuleMethod((ModuleBody)localObject1, 194, Lit45, 12291);
    $Pccheck$Mnbounds = new ModuleMethod((ModuleBody)localObject1, 195, Lit46, 16388);
    string$Mnparse$Mnfinal$Mnstart$Plend = new ModuleMethod((ModuleBody)localObject1, 196, Lit47, 12291);
    substring$Mnspec$Mnok$Qu = new ModuleMethod((ModuleBody)localObject1, 197, Lit48, 12291);
    check$Mnsubstring$Mnspec = new ModuleMethod((ModuleBody)localObject1, 198, Lit49, 16388);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 199, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:223");
    lambda$Fn5 = (ModuleMethod)localObject2;
    substring$Slshared = new ModuleMethod((ModuleBody)localObject1, 200, Lit50, 61442);
    $Pcsubstring$Slshared = new ModuleMethod((ModuleBody)localObject1, 201, Lit51, 12291);
    string$Mncopy = new ModuleMethod((ModuleBody)localObject1, 202, Lit52, 61441);
    string$Mnmap = new ModuleMethod((ModuleBody)localObject1, 203, Lit53, 61442);
    $Pcstring$Mnmap = new ModuleMethod((ModuleBody)localObject1, 204, Lit54, 16388);
    string$Mnmap$Ex = new ModuleMethod((ModuleBody)localObject1, 205, Lit55, 61442);
    $Pcstring$Mnmap$Ex = new ModuleMethod((ModuleBody)localObject1, 206, Lit56, 16388);
    string$Mnfold = new ModuleMethod((ModuleBody)localObject1, 207, Lit57, 61443);
    string$Mnfold$Mnright = new ModuleMethod((ModuleBody)localObject1, 208, Lit58, 61443);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 209, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:377");
    lambda$Fn17 = (ModuleMethod)localObject2;
    string$Mnunfold = new ModuleMethod((ModuleBody)localObject1, 210, Lit59, 61444);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 211, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:422");
    lambda$Fn18 = (ModuleMethod)localObject2;
    string$Mnunfold$Mnright = new ModuleMethod((ModuleBody)localObject1, 212, Lit60, 61444);
    string$Mnfor$Mneach = new ModuleMethod((ModuleBody)localObject1, 213, Lit61, 61442);
    string$Mnfor$Mneach$Mnindex = new ModuleMethod((ModuleBody)localObject1, 214, Lit62, 61442);
    string$Mnevery = new ModuleMethod((ModuleBody)localObject1, 215, Lit63, 61442);
    string$Mnany = new ModuleMethod((ModuleBody)localObject1, 216, Lit64, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 217, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:535");
    lambda$Fn27 = (ModuleMethod)localObject2;
    string$Mntabulate = new ModuleMethod((ModuleBody)localObject1, 218, Lit65, 8194);
    $Pcstring$Mnprefix$Mnlength = new ModuleMethod((ModuleBody)localObject1, 219, Lit66, 24582);
    $Pcstring$Mnsuffix$Mnlength = new ModuleMethod((ModuleBody)localObject1, 220, Lit67, 24582);
    $Pcstring$Mnprefix$Mnlength$Mnci = new ModuleMethod((ModuleBody)localObject1, 221, Lit68, 24582);
    $Pcstring$Mnsuffix$Mnlength$Mnci = new ModuleMethod((ModuleBody)localObject1, 222, Lit69, 24582);
    string$Mnprefix$Mnlength = new ModuleMethod((ModuleBody)localObject1, 223, Lit70, 61442);
    string$Mnsuffix$Mnlength = new ModuleMethod((ModuleBody)localObject1, 224, Lit71, 61442);
    string$Mnprefix$Mnlength$Mnci = new ModuleMethod((ModuleBody)localObject1, 225, Lit72, 61442);
    string$Mnsuffix$Mnlength$Mnci = new ModuleMethod((ModuleBody)localObject1, 226, Lit73, 61442);
    string$Mnprefix$Qu = new ModuleMethod((ModuleBody)localObject1, 227, Lit74, 61442);
    string$Mnsuffix$Qu = new ModuleMethod((ModuleBody)localObject1, 228, Lit75, 61442);
    string$Mnprefix$Mnci$Qu = new ModuleMethod((ModuleBody)localObject1, 229, Lit76, 61442);
    string$Mnsuffix$Mnci$Qu = new ModuleMethod((ModuleBody)localObject1, 230, Lit77, 61442);
    $Pcstring$Mnprefix$Qu = new ModuleMethod((ModuleBody)localObject1, 231, Lit78, 24582);
    $Pcstring$Mnsuffix$Qu = new ModuleMethod((ModuleBody)localObject1, 232, Lit79, 24582);
    $Pcstring$Mnprefix$Mnci$Qu = new ModuleMethod((ModuleBody)localObject1, 233, Lit80, 24582);
    $Pcstring$Mnsuffix$Mnci$Qu = new ModuleMethod((ModuleBody)localObject1, 234, Lit81, 24582);
    $Pcstring$Mncompare = new ModuleMethod((ModuleBody)localObject1, 235, Lit82, 36873);
    $Pcstring$Mncompare$Mnci = new ModuleMethod((ModuleBody)localObject1, 236, Lit83, 36873);
    string$Mncompare = new ModuleMethod((ModuleBody)localObject1, 237, Lit84, 61445);
    string$Mncompare$Mnci = new ModuleMethod((ModuleBody)localObject1, 238, Lit85, 61445);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 239, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:756");
    lambda$Fn72 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 240, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:758");
    lambda$Fn73 = (ModuleMethod)localObject2;
    string$Eq = new ModuleMethod((ModuleBody)localObject1, 241, Lit86, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 242, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:767");
    lambda$Fn78 = (ModuleMethod)localObject2;
    string$Ls$Gr = new ModuleMethod((ModuleBody)localObject1, 243, Lit87, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 244, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:778");
    lambda$Fn83 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 245, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:779");
    lambda$Fn84 = (ModuleMethod)localObject2;
    string$Ls = new ModuleMethod((ModuleBody)localObject1, 246, Lit88, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 247, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:788");
    lambda$Fn89 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 248, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:789");
    lambda$Fn90 = (ModuleMethod)localObject2;
    string$Gr = new ModuleMethod((ModuleBody)localObject1, 249, Lit89, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 250, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:801");
    lambda$Fn95 = (ModuleMethod)localObject2;
    string$Ls$Eq = new ModuleMethod((ModuleBody)localObject1, 251, Lit90, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 252, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:810");
    lambda$Fn100 = (ModuleMethod)localObject2;
    string$Gr$Eq = new ModuleMethod((ModuleBody)localObject1, 253, Lit91, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 254, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:820");
    lambda$Fn105 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 255, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:822");
    lambda$Fn106 = (ModuleMethod)localObject2;
    string$Mnci$Eq = new ModuleMethod((ModuleBody)localObject1, 256, Lit92, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 257, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:831");
    lambda$Fn111 = (ModuleMethod)localObject2;
    string$Mnci$Ls$Gr = new ModuleMethod((ModuleBody)localObject1, 258, Lit93, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 259, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:842");
    lambda$Fn116 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 260, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:843");
    lambda$Fn117 = (ModuleMethod)localObject2;
    string$Mnci$Ls = new ModuleMethod((ModuleBody)localObject1, 261, Lit94, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 262, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:852");
    lambda$Fn122 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 263, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:853");
    lambda$Fn123 = (ModuleMethod)localObject2;
    string$Mnci$Gr = new ModuleMethod((ModuleBody)localObject1, 264, Lit95, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 265, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:865");
    lambda$Fn128 = (ModuleMethod)localObject2;
    string$Mnci$Ls$Eq = new ModuleMethod((ModuleBody)localObject1, 266, Lit96, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 267, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:874");
    lambda$Fn133 = (ModuleMethod)localObject2;
    string$Mnci$Gr$Eq = new ModuleMethod((ModuleBody)localObject1, 268, Lit97, 61442);
    $Pcstring$Mnhash = new ModuleMethod((ModuleBody)localObject1, 269, Lit98, 20485);
    string$Mnhash = new ModuleMethod((ModuleBody)localObject1, 270, Lit99, 61441);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 271, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:922");
    lambda$Fn138 = (ModuleMethod)localObject2;
    string$Mnhash$Mnci = new ModuleMethod((ModuleBody)localObject1, 272, Lit100, 61441);
    string$Mnupcase = new ModuleMethod((ModuleBody)localObject1, 273, Lit101, 61441);
    string$Mnupcase$Ex = new ModuleMethod((ModuleBody)localObject1, 274, Lit102, 61441);
    string$Mndowncase = new ModuleMethod((ModuleBody)localObject1, 275, Lit103, 61441);
    string$Mndowncase$Ex = new ModuleMethod((ModuleBody)localObject1, 276, Lit104, 61441);
    $Pcstring$Mntitlecase$Ex = new ModuleMethod((ModuleBody)localObject1, 277, Lit105, 12291);
    string$Mntitlecase$Ex = new ModuleMethod((ModuleBody)localObject1, 278, Lit106, 61441);
    string$Mntitlecase = new ModuleMethod((ModuleBody)localObject1, 279, Lit107, 61441);
    string$Mntake = new ModuleMethod((ModuleBody)localObject1, 280, Lit108, 8194);
    string$Mntake$Mnright = new ModuleMethod((ModuleBody)localObject1, 281, Lit109, 8194);
    string$Mndrop = new ModuleMethod((ModuleBody)localObject1, 282, Lit110, 8194);
    string$Mndrop$Mnright = new ModuleMethod((ModuleBody)localObject1, 283, Lit111, 8194);
    string$Mntrim = new ModuleMethod((ModuleBody)localObject1, 284, Lit112, 61441);
    string$Mntrim$Mnright = new ModuleMethod((ModuleBody)localObject1, 285, Lit113, 61441);
    string$Mntrim$Mnboth = new ModuleMethod((ModuleBody)localObject1, 286, Lit114, 61441);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 287, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1047");
    lambda$Fn163 = (ModuleMethod)localObject2;
    string$Mnpad$Mnright = new ModuleMethod((ModuleBody)localObject1, 288, Lit115, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 289, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1059");
    lambda$Fn166 = (ModuleMethod)localObject2;
    string$Mnpad = new ModuleMethod((ModuleBody)localObject1, 290, Lit116, 61442);
    string$Mndelete = new ModuleMethod((ModuleBody)localObject1, 291, Lit117, 61442);
    string$Mnfilter = new ModuleMethod((ModuleBody)localObject1, 292, Lit118, 61442);
    string$Mnindex = new ModuleMethod((ModuleBody)localObject1, 293, Lit119, 61442);
    string$Mnindex$Mnright = new ModuleMethod((ModuleBody)localObject1, 294, Lit120, 61442);
    string$Mnskip = new ModuleMethod((ModuleBody)localObject1, 295, Lit121, 61442);
    string$Mnskip$Mnright = new ModuleMethod((ModuleBody)localObject1, 296, Lit122, 61442);
    string$Mncount = new ModuleMethod((ModuleBody)localObject1, 297, Lit123, 61442);
    string$Mnfill$Ex = new ModuleMethod((ModuleBody)localObject1, 298, Lit124, 61442);
    string$Mncopy$Ex = new ModuleMethod((ModuleBody)localObject1, 299, Lit125, 20483);
    $Pcstring$Mncopy$Ex = new ModuleMethod((ModuleBody)localObject1, 302, Lit126, 20485);
    string$Mncontains = new ModuleMethod((ModuleBody)localObject1, 303, Lit127, 61442);
    string$Mncontains$Mnci = new ModuleMethod((ModuleBody)localObject1, 304, Lit128, 61442);
    $Pckmp$Mnsearch = new ModuleMethod((ModuleBody)localObject1, 305, Lit129, 28679);
    make$Mnkmp$Mnrestart$Mnvector = new ModuleMethod((ModuleBody)localObject1, 306, Lit130, 61441);
    kmp$Mnstep = new ModuleMethod((ModuleBody)localObject1, 307, Lit131, 24582);
    string$Mnkmp$Mnpartial$Mnsearch = new ModuleMethod((ModuleBody)localObject1, 308, Lit132, 61444);
    string$Mnnull$Qu = new ModuleMethod((ModuleBody)localObject1, 309, Lit133, 4097);
    string$Mnreverse = new ModuleMethod((ModuleBody)localObject1, 310, Lit134, 61441);
    string$Mnreverse$Ex = new ModuleMethod((ModuleBody)localObject1, 311, Lit135, 61441);
    reverse$Mnlist$Mn$Grstring = new ModuleMethod((ModuleBody)localObject1, 312, Lit136, 4097);
    string$Mn$Grlist = new ModuleMethod((ModuleBody)localObject1, 313, Lit137, 61441);
    string$Mnappend$Slshared = new ModuleMethod((ModuleBody)localObject1, 314, Lit138, 61440);
    string$Mnconcatenate$Slshared = new ModuleMethod((ModuleBody)localObject1, 315, Lit139, 4097);
    string$Mnconcatenate = new ModuleMethod((ModuleBody)localObject1, 316, Lit140, 4097);
    string$Mnconcatenate$Mnreverse = new ModuleMethod((ModuleBody)localObject1, 317, Lit141, 61441);
    string$Mnconcatenate$Mnreverse$Slshared = new ModuleMethod((ModuleBody)localObject1, 318, Lit142, 61441);
    $Pcfinish$Mnstring$Mnconcatenate$Mnreverse = new ModuleMethod((ModuleBody)localObject1, 319, Lit143, 16388);
    string$Mnreplace = new ModuleMethod((ModuleBody)localObject1, 320, Lit144, 61444);
    string$Mntokenize = new ModuleMethod((ModuleBody)localObject1, 321, Lit145, 61441);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 322, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1738");
    lambda$Fn210 = (ModuleMethod)localObject2;
    xsubstring = new ModuleMethod((ModuleBody)localObject1, 323, Lit146, 61442);
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 324, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1779");
    lambda$Fn216 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 325, null, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1785");
    lambda$Fn220 = (ModuleMethod)localObject2;
    string$Mnxcopy$Ex = new ModuleMethod((ModuleBody)localObject1, 326, Lit147, 61444);
    $Pcmultispan$Mnrepcopy$Ex = new ModuleMethod((ModuleBody)localObject1, 327, Lit148, 28679);
    string$Mnjoin = new ModuleMethod((ModuleBody)localObject1, 328, Lit149, 61441);
    $instance.run();
  }
  
  public srfi13()
  {
    ModuleInfo.register(this);
  }
  
  public static Object checkSubstringSpec(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (!isSubstringSpecOk(paramObject2, paramObject3, paramObject4)) {
      return misc.error$V("Illegal substring spec.", new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    }
    return Values.empty;
  }
  
  public static boolean isStringNull(Object paramObject)
  {
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return numbers.isZero(Integer.valueOf(strings.stringLength(localCharSequence)));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, paramObject);
    }
  }
  
  public static Object isStringPrefix$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame19 localframe19 = new frame19();
    localframe19.s1 = paramObject1;
    localframe19.s2 = paramObject2;
    localframe19.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe19.lambda$Fn44, localframe19.lambda$Fn45);
  }
  
  public static Object isStringPrefixCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame23 localframe23 = new frame23();
    localframe23.s1 = paramObject1;
    localframe23.s2 = paramObject2;
    localframe23.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe23.lambda$Fn52, localframe23.lambda$Fn53);
  }
  
  public static Object isStringSuffix$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame21 localframe21 = new frame21();
    localframe21.s1 = paramObject1;
    localframe21.s2 = paramObject2;
    localframe21.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe21.lambda$Fn48, localframe21.lambda$Fn49);
  }
  
  public static Object isStringSuffixCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame25 localframe25 = new frame25();
    localframe25.s1 = paramObject1;
    localframe25.s2 = paramObject2;
    localframe25.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe25.lambda$Fn56, localframe25.lambda$Fn57);
  }
  
  /* Error */
  public static boolean isSubstringSpecOk(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 2029	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   4: istore 4
    //   6: iload 4
    //   8: istore_3
    //   9: iload 4
    //   11: ifeq +145 -> 156
    //   14: aload_1
    //   15: invokestatic 2032	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   18: istore 4
    //   20: iload 4
    //   22: istore_3
    //   23: iload 4
    //   25: ifeq +131 -> 156
    //   28: aload_1
    //   29: invokestatic 2035	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   32: istore 4
    //   34: iload 4
    //   36: istore_3
    //   37: iload 4
    //   39: ifeq +117 -> 156
    //   42: aload_2
    //   43: invokestatic 2032	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   46: istore 4
    //   48: iload 4
    //   50: istore_3
    //   51: iload 4
    //   53: ifeq +103 -> 156
    //   56: aload_2
    //   57: invokestatic 2035	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   60: istore 4
    //   62: iload 4
    //   64: istore_3
    //   65: iload 4
    //   67: ifeq +89 -> 156
    //   70: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   73: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   76: aload_1
    //   77: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 5
    //   82: aload 5
    //   84: checkcast 732	java/lang/Boolean
    //   87: invokevirtual 743	java/lang/Boolean:booleanValue	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: istore_3
    //   95: iload 4
    //   97: ifeq +59 -> 156
    //   100: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   103: aload_1
    //   104: aload_2
    //   105: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: astore_1
    //   109: aload_1
    //   110: checkcast 732	java/lang/Boolean
    //   113: invokevirtual 743	java/lang/Boolean:booleanValue	()Z
    //   116: istore 4
    //   118: iload 4
    //   120: istore_3
    //   121: iload 4
    //   123: ifeq +33 -> 156
    //   126: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   129: astore_1
    //   130: aload_0
    //   131: checkcast 681	java/lang/CharSequence
    //   134: astore 5
    //   136: aload_1
    //   137: aload_2
    //   138: aload 5
    //   140: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   143: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 732	java/lang/Boolean
    //   152: invokevirtual 743	java/lang/Boolean:booleanValue	()Z
    //   155: istore_3
    //   156: iload_3
    //   157: ireturn
    //   158: astore_0
    //   159: new 707	gnu/mapping/WrongType
    //   162: dup
    //   163: aload_0
    //   164: ldc_w 778
    //   167: bipush -2
    //   169: aload 5
    //   171: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: astore_0
    //   176: new 707	gnu/mapping/WrongType
    //   179: dup
    //   180: aload_0
    //   181: ldc_w 778
    //   184: bipush -2
    //   186: aload_1
    //   187: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   190: athrow
    //   191: astore_1
    //   192: new 707	gnu/mapping/WrongType
    //   195: dup
    //   196: aload_1
    //   197: ldc_w 717
    //   200: iconst_1
    //   201: aload_0
    //   202: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramObject1	Object
    //   0	206	1	paramObject2	Object
    //   0	206	2	paramObject3	Object
    //   8	149	3	bool1	boolean
    //   4	118	4	bool2	boolean
    //   80	90	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	92	158	java/lang/ClassCastException
    //   109	118	175	java/lang/ClassCastException
    //   130	136	191	java/lang/ClassCastException
  }
  
  public static Object kmpStep(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    for (;;)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      try
      {
        localCharSequence = (CharSequence)paramObject1;
        localObject = AddOp.$Pl.apply2(paramObject4, paramObject6);
      }
      catch (ClassCastException paramObject2)
      {
        try
        {
          CharSequence localCharSequence;
          i = ((Number)localObject).intValue();
          if (localApplyToArgs.apply3(paramObject5, paramObject3, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE) {
            return AddOp.$Pl.apply2(paramObject4, Lit1);
          }
        }
        catch (ClassCastException paramObject1)
        {
          Object localObject;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject);
        }
        try
        {
          localObject = (FVector)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "vector-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)paramObject4).intValue();
          localObject = vectors.vectorRef((FVector)localObject, i);
          paramObject4 = localObject;
          if (Scheme.numEqu.apply2(localObject, Lit13) == Boolean.FALSE) {
            continue;
          }
          return Lit0;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "vector-ref", 2, paramObject4);
        }
        paramObject2 = paramObject2;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
    }
  }
  
  static String lambda17(Object paramObject)
  {
    return "";
  }
  
  static String lambda18(Object paramObject)
  {
    return "";
  }
  
  public static Object lambda222buildit(Object paramObject1, Object paramObject2)
  {
    frame96 localframe96 = new frame96();
    localframe96.jdField_final = paramObject2;
    return localframe96.lambda223recur(paramObject1);
  }
  
  static boolean lambda27(Object paramObject)
  {
    boolean bool2 = numbers.isInteger(paramObject);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool2 = numbers.isExact(paramObject);
      bool1 = bool2;
      if (bool2) {
        bool1 = ((Boolean)Scheme.numLEq.apply2(Lit0, paramObject)).booleanValue();
      }
    }
    return bool1;
  }
  
  public static Object makeKmpRestartVector$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame87 localframe87 = new frame87();
    localframe87.pattern = paramObject;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    paramObject = loc$let$Mnoptionals$St;
    for (;;)
    {
      Object localObject1;
      Object localObject8;
      Object localObject9;
      try
      {
        localObject2 = ((Location)paramObject).get();
        paramArrayOfObject = Scheme.applyToArgs;
        localObject1 = Scheme.applyToArgs;
        paramObject = loc$c$Eq;
      }
      catch (UnboundLocationException paramObject)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        int i;
        Object localObject6;
        int j;
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1397, 3);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject3 = ((Location)paramObject).get();
        localObject4 = characters.char$Eq$Qu;
        paramObject = loc$c$Eq;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1398, 20);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramObject = ((Location)paramObject).get();
        if (misc.isProcedure(paramObject))
        {
          paramObject = Boolean.TRUE;
          paramObject = ((Procedure)localObject1).apply3(localObject3, localObject4, paramObject);
          localObject1 = Scheme.applyToArgs;
          localObject3 = Scheme.applyToArgs;
          localObject4 = loc$start;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1398, 43);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject4 = ((Location)localObject4).get();
        localObject5 = loc$end;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1399, 7);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject5 = ((Location)localObject5).get();
        localObject3 = paramArrayOfObject.apply2(paramObject, ((Procedure)localObject1).apply2(((Procedure)localObject3).apply2(localObject4, localObject5), localframe87.lambda$Fn197));
        paramObject = AddOp.$Mn;
        paramArrayOfObject = loc$end;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1399, 14);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        localObject1 = loc$start;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1402, 22);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject1 = ((Location)localObject1).get();
        paramObject = ((Procedure)paramObject).apply2(paramArrayOfObject, localObject1);
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1402, 26);
        throw ((Throwable)paramObject);
      }
      try
      {
        i = ((Number)paramObject).intValue();
        localObject4 = vectors.makeVector(i, Lit13);
        if (Scheme.numGrt.apply2(paramObject, Lit0) != Boolean.FALSE)
        {
          localObject5 = AddOp.$Mn.apply2(paramObject, Lit1);
          paramArrayOfObject = localframe87.pattern;
        }
      }
      catch (ClassCastException paramArrayOfObject)
      {
        throw new WrongType(paramArrayOfObject, "make-vector", 1, paramObject);
      }
      try
      {
        paramObject = (CharSequence)paramArrayOfObject;
        paramArrayOfObject = loc$start;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 1, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1406, 27);
        throw ((Throwable)paramObject);
      }
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
        i = strings.stringRef((CharSequence)paramObject, i);
        localObject1 = Lit0;
        paramObject = Lit13;
        paramArrayOfObject = loc$start;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 2, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (Scheme.numLss.apply2(localObject1, localObject5) != Boolean.FALSE) {
          if (Scheme.numEqu.apply2(paramObject, Lit13) != Boolean.FALSE)
          {
            localObject1 = AddOp.$Pl.apply2(Lit1, localObject1);
            paramObject = Scheme.applyToArgs;
            localObject6 = loc$c$Eq;
          }
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1410, 6);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject6 = ((Location)localObject6).get();
        localObject7 = localframe87.pattern;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1418, 18);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject8 = (CharSequence)localObject7;
        localObject7 = AddOp.$Pl.apply2(paramArrayOfObject, Lit1);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 1, localObject7);
      }
      try
      {
        j = ((Number)localObject7).intValue();
        if (((Procedure)paramObject).apply3(localObject6, Char.make(strings.stringRef((CharSequence)localObject8, j)), Char.make(i)) != Boolean.FALSE) {}
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 2, localObject7);
      }
      try
      {
        j = ((Number)localObject1).intValue();
        vectors.vectorSet$Ex((FVector)localObject4, j, Lit0);
        paramObject = Lit0;
        paramArrayOfObject = AddOp.$Pl.apply2(paramArrayOfObject, Lit1);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "vector-set!", 2, localObject1);
      }
      paramObject = Boolean.FALSE;
      continue;
      localObject6 = Scheme.applyToArgs;
      Object localObject7 = loc$c$Eq;
      try
      {
        localObject7 = ((Location)localObject7).get();
        localObject8 = localframe87.pattern;
      }
      catch (UnboundLocationException paramObject)
      {
        CharSequence localCharSequence;
        Object localObject10;
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1422, 7);
        throw ((Throwable)paramObject);
      }
      try
      {
        localCharSequence = (CharSequence)localObject8;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 1, localObject8);
      }
      try
      {
        j = ((Number)paramArrayOfObject).intValue();
        localObject8 = Char.make(strings.stringRef(localCharSequence, j));
        localObject9 = localframe87.pattern;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 2, paramArrayOfObject);
      }
      try
      {
        localCharSequence = (CharSequence)localObject9;
        localObject9 = AddOp.$Pl;
        localObject10 = loc$start;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 1, localObject9);
      }
      try
      {
        localObject10 = ((Location)localObject10).get();
        localObject9 = ((Procedure)localObject9).apply2(paramObject, localObject10);
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1422, 59);
        throw ((Throwable)paramObject);
      }
      try
      {
        j = ((Number)localObject9).intValue();
        if (((Procedure)localObject6).apply3(localObject7, localObject8, Char.make(strings.stringRef(localCharSequence, j))) != Boolean.FALSE)
        {
          localObject1 = AddOp.$Pl.apply2(Lit1, localObject1);
          paramObject = AddOp.$Pl.apply2(Lit1, paramObject);
        }
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-ref", 2, localObject9);
      }
      try
      {
        j = ((Number)localObject1).intValue();
        vectors.vectorSet$Ex((FVector)localObject4, j, paramObject);
        paramArrayOfObject = AddOp.$Pl.apply2(paramArrayOfObject, Lit1);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "vector-set!", 2, localObject1);
      }
      try
      {
        j = ((Number)paramObject).intValue();
        paramObject = vectors.vectorRef((FVector)localObject4, j);
      }
      catch (ClassCastException paramArrayOfObject)
      {
        throw new WrongType(paramArrayOfObject, "vector-ref", 2, paramObject);
      }
    }
    return localApplyToArgs.apply4(localObject2, localLList, localObject3, localObject4);
  }
  
  /* Error */
  public static CharSequence reverseList$To$String(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 1385	gnu/lists/LList
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 2086	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   9: istore_2
    //   10: iload_2
    //   11: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   14: astore 5
    //   16: iload_2
    //   17: iconst_1
    //   18: isub
    //   19: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: astore 4
    //   24: aload_0
    //   25: astore_3
    //   26: aload 4
    //   28: astore_0
    //   29: aload_3
    //   30: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   33: ifeq +127 -> 160
    //   36: aload 5
    //   38: checkcast 826	gnu/lists/CharSeq
    //   41: astore 6
    //   43: aload_0
    //   44: checkcast 671	java/lang/Number
    //   47: invokevirtual 675	java/lang/Number:intValue	()I
    //   50: istore_2
    //   51: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   54: aload_3
    //   55: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: astore 4
    //   60: aload 4
    //   62: checkcast 753	gnu/text/Char
    //   65: invokevirtual 868	gnu/text/Char:charValue	()C
    //   68: istore_1
    //   69: aload 6
    //   71: iload_2
    //   72: iload_1
    //   73: invokestatic 830	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   76: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   79: aload_0
    //   80: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   83: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: astore_0
    //   87: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   90: aload_3
    //   91: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: astore_3
    //   95: goto -66 -> 29
    //   98: astore_3
    //   99: new 707	gnu/mapping/WrongType
    //   102: dup
    //   103: aload_3
    //   104: ldc_w 2087
    //   107: iconst_1
    //   108: aload_0
    //   109: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   112: athrow
    //   113: astore_0
    //   114: new 707	gnu/mapping/WrongType
    //   117: dup
    //   118: aload_0
    //   119: ldc_w 832
    //   122: iconst_1
    //   123: aload 5
    //   125: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   128: athrow
    //   129: astore_3
    //   130: new 707	gnu/mapping/WrongType
    //   133: dup
    //   134: aload_3
    //   135: ldc_w 832
    //   138: iconst_2
    //   139: aload_0
    //   140: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: astore_0
    //   145: new 707	gnu/mapping/WrongType
    //   148: dup
    //   149: aload_0
    //   150: ldc_w 832
    //   153: iconst_3
    //   154: aload 4
    //   156: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: aload 5
    //   162: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramObject	Object
    //   68	5	1	c	char
    //   9	63	2	i	int
    //   4	91	3	localObject1	Object
    //   98	6	3	localClassCastException1	ClassCastException
    //   129	6	3	localClassCastException2	ClassCastException
    //   22	133	4	localObject2	Object
    //   14	147	5	localCharSequence	CharSequence
    //   41	29	6	localCharSeq	CharSeq
    // Exception table:
    //   from	to	target	type
    //   0	5	98	java/lang/ClassCastException
    //   36	43	113	java/lang/ClassCastException
    //   43	51	129	java/lang/ClassCastException
    //   60	69	144	java/lang/ClassCastException
  }
  
  public static Object string$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame31 localframe31 = new frame31();
    localframe31.s1 = paramObject1;
    localframe31.s2 = paramObject2;
    localframe31.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe31.lambda$Fn68, localframe31.lambda$Fn69);
  }
  
  public static Object string$Gr$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame41 localframe41 = new frame41();
    localframe41.s1 = paramObject1;
    localframe41.s2 = paramObject2;
    localframe41.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe41.lambda$Fn96, localframe41.lambda$Fn97);
  }
  
  public static Object string$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame37 localframe37 = new frame37();
    localframe37.s1 = paramObject1;
    localframe37.s2 = paramObject2;
    localframe37.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe37.lambda$Fn85, localframe37.lambda$Fn86);
  }
  
  public static Object string$Ls$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame39 localframe39 = new frame39();
    localframe39.s1 = paramObject1;
    localframe39.s2 = paramObject2;
    localframe39.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe39.lambda$Fn91, localframe39.lambda$Fn92);
  }
  
  public static Object string$Ls$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame33 localframe33 = new frame33();
    localframe33.s1 = paramObject1;
    localframe33.s2 = paramObject2;
    localframe33.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe33.lambda$Fn74, localframe33.lambda$Fn75);
  }
  
  public static Object string$Ls$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame35 localframe35 = new frame35();
    localframe35.s1 = paramObject1;
    localframe35.s2 = paramObject2;
    localframe35.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe35.lambda$Fn79, localframe35.lambda$Fn80);
  }
  
  public static Object string$To$List$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame91 localframe91 = new frame91();
    localframe91.s = paramObject;
    localframe91.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe91.lambda$Fn204, localframe91.lambda$Fn205);
  }
  
  public static Object stringAny$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame10 localframe10 = new frame10();
    localframe10.criterion = paramObject1;
    localframe10.s = paramObject2;
    localframe10.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe10.lambda$Fn25, localframe10.lambda$Fn26);
  }
  
  public static Object stringAppend$SlShared$V(Object[] paramArrayOfObject)
  {
    return stringConcatenate$SlShared(LList.makeList(paramArrayOfObject, 0));
  }
  
  public static Object stringCi$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame43 localframe43 = new frame43();
    localframe43.s1 = paramObject1;
    localframe43.s2 = paramObject2;
    localframe43.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe43.lambda$Fn101, localframe43.lambda$Fn102);
  }
  
  public static Object stringCi$Gr$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame53 localframe53 = new frame53();
    localframe53.s1 = paramObject1;
    localframe53.s2 = paramObject2;
    localframe53.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe53.lambda$Fn129, localframe53.lambda$Fn130);
  }
  
  public static Object stringCi$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame49 localframe49 = new frame49();
    localframe49.s1 = paramObject1;
    localframe49.s2 = paramObject2;
    localframe49.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe49.lambda$Fn118, localframe49.lambda$Fn119);
  }
  
  public static Object stringCi$Ls$Eq$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame51 localframe51 = new frame51();
    localframe51.s1 = paramObject1;
    localframe51.s2 = paramObject2;
    localframe51.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe51.lambda$Fn124, localframe51.lambda$Fn125);
  }
  
  public static Object stringCi$Ls$Gr$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame45 localframe45 = new frame45();
    localframe45.s1 = paramObject1;
    localframe45.s2 = paramObject2;
    localframe45.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe45.lambda$Fn107, localframe45.lambda$Fn108);
  }
  
  public static Object stringCi$Ls$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame47 localframe47 = new frame47();
    localframe47.s1 = paramObject1;
    localframe47.s2 = paramObject2;
    localframe47.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe47.lambda$Fn112, localframe47.lambda$Fn113);
  }
  
  /* Error */
  public static Object stringCompare$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 69	gnu/kawa/slib/srfi13$frame27
    //   3: dup
    //   4: invokespecial 2252	gnu/kawa/slib/srfi13$frame27:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: putfield 2253	gnu/kawa/slib/srfi13$frame27:s1	Ljava/lang/Object;
    //   15: aload 6
    //   17: aload_1
    //   18: putfield 2254	gnu/kawa/slib/srfi13$frame27:s2	Ljava/lang/Object;
    //   21: aload 6
    //   23: aload_2
    //   24: putfield 2257	gnu/kawa/slib/srfi13$frame27:proc$Ls	Ljava/lang/Object;
    //   27: aload 6
    //   29: aload_3
    //   30: putfield 2260	gnu/kawa/slib/srfi13$frame27:proc$Eq	Ljava/lang/Object;
    //   33: aload 6
    //   35: aload 4
    //   37: putfield 2263	gnu/kawa/slib/srfi13$frame27:proc$Gr	Ljava/lang/Object;
    //   40: aload 6
    //   42: aload 5
    //   44: iconst_0
    //   45: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   48: putfield 2264	gnu/kawa/slib/srfi13$frame27:maybe$Mnstarts$Plends	Lgnu/lists/LList;
    //   51: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   54: astore_0
    //   55: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   63: astore_1
    //   64: aload_0
    //   65: aload_1
    //   66: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   69: aload 6
    //   71: getfield 2257	gnu/kawa/slib/srfi13$frame27:proc$Ls	Ljava/lang/Object;
    //   74: getstatic 1724	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   77: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   84: astore_0
    //   85: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_0
    //   95: aload_1
    //   96: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   99: aload 6
    //   101: getfield 2260	gnu/kawa/slib/srfi13$frame27:proc$Eq	Ljava/lang/Object;
    //   104: getstatic 1724	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   107: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   114: astore_0
    //   115: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   123: astore_1
    //   124: aload_0
    //   125: aload_1
    //   126: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   129: aload 6
    //   131: getfield 2263	gnu/kawa/slib/srfi13$frame27:proc$Gr	Ljava/lang/Object;
    //   134: getstatic 1724	gnu/kawa/slib/srfi13:string$Mncompare	Lgnu/expr/ModuleMethod;
    //   137: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 6
    //   143: getfield 2270	gnu/kawa/slib/srfi13$frame27:lambda$Fn60	Lgnu/expr/ModuleMethod;
    //   146: aload 6
    //   148: getfield 2273	gnu/kawa/slib/srfi13$frame27:lambda$Fn61	Lgnu/expr/ModuleMethod;
    //   151: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: ldc_w 920
    //   160: sipush 726
    //   163: iconst_3
    //   164: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: aload_0
    //   171: ldc_w 920
    //   174: sipush 727
    //   177: iconst_3
    //   178: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: aload_0
    //   185: ldc_w 920
    //   188: sipush 728
    //   191: iconst_3
    //   192: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   195: aload_0
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramObject1	Object
    //   0	197	1	paramObject2	Object
    //   0	197	2	paramObject3	Object
    //   0	197	3	paramObject4	Object
    //   0	197	4	paramObject5	Object
    //   0	197	5	paramArrayOfObject	Object[]
    //   7	140	6	localframe27	frame27
    // Exception table:
    //   from	to	target	type
    //   59	64	155	gnu/mapping/UnboundLocationException
    //   89	94	169	gnu/mapping/UnboundLocationException
    //   119	124	183	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringCompareCi$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 75	gnu/kawa/slib/srfi13$frame29
    //   3: dup
    //   4: invokespecial 2275	gnu/kawa/slib/srfi13$frame29:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: putfield 2276	gnu/kawa/slib/srfi13$frame29:s1	Ljava/lang/Object;
    //   15: aload 6
    //   17: aload_1
    //   18: putfield 2277	gnu/kawa/slib/srfi13$frame29:s2	Ljava/lang/Object;
    //   21: aload 6
    //   23: aload_2
    //   24: putfield 2278	gnu/kawa/slib/srfi13$frame29:proc$Ls	Ljava/lang/Object;
    //   27: aload 6
    //   29: aload_3
    //   30: putfield 2279	gnu/kawa/slib/srfi13$frame29:proc$Eq	Ljava/lang/Object;
    //   33: aload 6
    //   35: aload 4
    //   37: putfield 2280	gnu/kawa/slib/srfi13$frame29:proc$Gr	Ljava/lang/Object;
    //   40: aload 6
    //   42: aload 5
    //   44: iconst_0
    //   45: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   48: putfield 2281	gnu/kawa/slib/srfi13$frame29:maybe$Mnstarts$Plends	Lgnu/lists/LList;
    //   51: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   54: astore_0
    //   55: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   63: astore_1
    //   64: aload_0
    //   65: aload_1
    //   66: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   69: aload 6
    //   71: getfield 2278	gnu/kawa/slib/srfi13$frame29:proc$Ls	Ljava/lang/Object;
    //   74: getstatic 1726	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   77: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   84: astore_0
    //   85: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_0
    //   95: aload_1
    //   96: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   99: aload 6
    //   101: getfield 2279	gnu/kawa/slib/srfi13$frame29:proc$Eq	Ljava/lang/Object;
    //   104: getstatic 1726	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   107: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   114: astore_0
    //   115: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   123: astore_1
    //   124: aload_0
    //   125: aload_1
    //   126: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   129: aload 6
    //   131: getfield 2280	gnu/kawa/slib/srfi13$frame29:proc$Gr	Ljava/lang/Object;
    //   134: getstatic 1726	gnu/kawa/slib/srfi13:string$Mncompare$Mnci	Lgnu/expr/ModuleMethod;
    //   137: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 6
    //   143: getfield 2284	gnu/kawa/slib/srfi13$frame29:lambda$Fn64	Lgnu/expr/ModuleMethod;
    //   146: aload 6
    //   148: getfield 2287	gnu/kawa/slib/srfi13$frame29:lambda$Fn65	Lgnu/expr/ModuleMethod;
    //   151: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: ldc_w 920
    //   160: sipush 734
    //   163: iconst_3
    //   164: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: aload_0
    //   171: ldc_w 920
    //   174: sipush 735
    //   177: iconst_3
    //   178: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: aload_0
    //   185: ldc_w 920
    //   188: sipush 736
    //   191: iconst_3
    //   192: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   195: aload_0
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramObject1	Object
    //   0	197	1	paramObject2	Object
    //   0	197	2	paramObject3	Object
    //   0	197	3	paramObject4	Object
    //   0	197	4	paramObject5	Object
    //   0	197	5	paramArrayOfObject	Object[]
    //   7	140	6	localframe29	frame29
    // Exception table:
    //   from	to	target	type
    //   59	64	155	gnu/mapping/UnboundLocationException
    //   89	94	169	gnu/mapping/UnboundLocationException
    //   119	124	183	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static CharSequence stringConcatenate(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   3: astore_3
    //   4: aload_0
    //   5: astore 4
    //   7: aload 4
    //   9: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   12: ifeq +57 -> 69
    //   15: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   18: aload 4
    //   20: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore 5
    //   25: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   28: astore 6
    //   30: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   33: aload 4
    //   35: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore 4
    //   40: aload 4
    //   42: checkcast 681	java/lang/CharSequence
    //   45: astore 7
    //   47: aload 6
    //   49: aload_3
    //   50: aload 7
    //   52: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   55: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: goto -59 -> 7
    //   69: aload_3
    //   70: checkcast 671	java/lang/Number
    //   73: invokevirtual 675	java/lang/Number:intValue	()I
    //   76: istore_1
    //   77: iload_1
    //   78: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   81: astore 5
    //   83: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   86: astore 4
    //   88: aload_0
    //   89: astore_3
    //   90: aload 4
    //   92: astore_0
    //   93: aload_3
    //   94: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   97: ifeq +152 -> 249
    //   100: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   103: aload_3
    //   104: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore 4
    //   109: aload 4
    //   111: checkcast 681	java/lang/CharSequence
    //   114: astore 6
    //   116: aload 6
    //   118: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   121: istore_1
    //   122: aload_0
    //   123: checkcast 671	java/lang/Number
    //   126: invokevirtual 675	java/lang/Number:intValue	()I
    //   129: istore_2
    //   130: aload 4
    //   132: checkcast 681	java/lang/CharSequence
    //   135: astore 6
    //   137: aload 5
    //   139: iload_2
    //   140: aload 6
    //   142: iconst_0
    //   143: iload_1
    //   144: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   147: pop
    //   148: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   151: aload_0
    //   152: iload_1
    //   153: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: astore_0
    //   160: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   163: aload_3
    //   164: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: astore_3
    //   168: goto -75 -> 93
    //   171: astore_0
    //   172: new 707	gnu/mapping/WrongType
    //   175: dup
    //   176: aload_0
    //   177: ldc_w 717
    //   180: iconst_1
    //   181: aload 4
    //   183: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: astore_0
    //   188: new 707	gnu/mapping/WrongType
    //   191: dup
    //   192: aload_0
    //   193: ldc_w 709
    //   196: iconst_1
    //   197: aload_3
    //   198: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    //   202: astore_0
    //   203: new 707	gnu/mapping/WrongType
    //   206: dup
    //   207: aload_0
    //   208: ldc_w 717
    //   211: iconst_1
    //   212: aload 4
    //   214: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: astore_3
    //   219: new 707	gnu/mapping/WrongType
    //   222: dup
    //   223: aload_3
    //   224: ldc_w 715
    //   227: iconst_1
    //   228: aload_0
    //   229: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: astore_0
    //   234: new 707	gnu/mapping/WrongType
    //   237: dup
    //   238: aload_0
    //   239: ldc_w 715
    //   242: iconst_2
    //   243: aload 4
    //   245: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   248: athrow
    //   249: aload 5
    //   251: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramObject	Object
    //   76	77	1	i	int
    //   129	11	2	j	int
    //   3	195	3	localObject1	Object
    //   218	6	3	localClassCastException	ClassCastException
    //   5	239	4	localObject2	Object
    //   23	227	5	localObject3	Object
    //   28	113	6	localObject4	Object
    //   45	6	7	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   40	47	171	java/lang/ClassCastException
    //   69	77	187	java/lang/ClassCastException
    //   109	116	202	java/lang/ClassCastException
    //   122	130	218	java/lang/ClassCastException
    //   130	137	233	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringConcatenate$SlShared(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   3: astore 4
    //   5: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +82 -> 95
    //   16: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   19: aload_0
    //   20: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: astore 6
    //   25: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   28: aload_0
    //   29: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   32: astore 5
    //   34: aload 6
    //   36: checkcast 681	java/lang/CharSequence
    //   39: astore 7
    //   41: aload 7
    //   43: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   46: istore_1
    //   47: iload_1
    //   48: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokestatic 798	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   54: ifeq +9 -> 63
    //   57: aload 5
    //   59: astore_0
    //   60: goto -51 -> 9
    //   63: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   66: aload 4
    //   68: iload_1
    //   69: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 4
    //   77: aload_3
    //   78: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   81: if_acmpeq +9 -> 90
    //   84: aload 5
    //   86: astore_0
    //   87: goto -78 -> 9
    //   90: aload_0
    //   91: astore_3
    //   92: goto -8 -> 84
    //   95: aload 4
    //   97: checkcast 671	java/lang/Number
    //   100: astore_0
    //   101: aload_0
    //   102: invokestatic 798	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   105: ifeq +11 -> 116
    //   108: ldc_w 2040
    //   111: astore 4
    //   113: aload 4
    //   115: areturn
    //   116: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   119: astore 5
    //   121: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   124: aload_3
    //   125: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: astore_0
    //   129: aload_0
    //   130: checkcast 681	java/lang/CharSequence
    //   133: astore 6
    //   135: aload 5
    //   137: aload 4
    //   139: aload 6
    //   141: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   144: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   153: if_acmpeq +11 -> 164
    //   156: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   159: aload_3
    //   160: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: areturn
    //   164: aload 4
    //   166: checkcast 671	java/lang/Number
    //   169: invokevirtual 675	java/lang/Number:intValue	()I
    //   172: istore_1
    //   173: iload_1
    //   174: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   177: astore 5
    //   179: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   182: astore_0
    //   183: aload 5
    //   185: astore 4
    //   187: aload_3
    //   188: invokestatic 691	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   191: ifeq -78 -> 113
    //   194: getstatic 695	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   197: aload_3
    //   198: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: astore 4
    //   203: aload 4
    //   205: checkcast 681	java/lang/CharSequence
    //   208: astore 6
    //   210: aload 6
    //   212: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   215: istore_1
    //   216: aload_0
    //   217: checkcast 671	java/lang/Number
    //   220: invokevirtual 675	java/lang/Number:intValue	()I
    //   223: istore_2
    //   224: aload 4
    //   226: checkcast 681	java/lang/CharSequence
    //   229: astore 6
    //   231: aload 5
    //   233: iload_2
    //   234: aload 6
    //   236: iconst_0
    //   237: iload_1
    //   238: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   241: pop
    //   242: getstatic 702	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   245: aload_3
    //   246: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   249: astore_3
    //   250: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   253: aload_0
    //   254: iload_1
    //   255: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: astore_0
    //   262: goto -79 -> 183
    //   265: astore_0
    //   266: new 707	gnu/mapping/WrongType
    //   269: dup
    //   270: aload_0
    //   271: ldc_w 717
    //   274: iconst_1
    //   275: aload 6
    //   277: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore_0
    //   282: new 707	gnu/mapping/WrongType
    //   285: dup
    //   286: aload_0
    //   287: ldc_w 800
    //   290: iconst_1
    //   291: aload 4
    //   293: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore_3
    //   298: new 707	gnu/mapping/WrongType
    //   301: dup
    //   302: aload_3
    //   303: ldc_w 717
    //   306: iconst_1
    //   307: aload_0
    //   308: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore_0
    //   313: new 707	gnu/mapping/WrongType
    //   316: dup
    //   317: aload_0
    //   318: ldc_w 709
    //   321: iconst_1
    //   322: aload 4
    //   324: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: astore_0
    //   329: new 707	gnu/mapping/WrongType
    //   332: dup
    //   333: aload_0
    //   334: ldc_w 717
    //   337: iconst_1
    //   338: aload 4
    //   340: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: astore_3
    //   345: new 707	gnu/mapping/WrongType
    //   348: dup
    //   349: aload_3
    //   350: ldc_w 715
    //   353: iconst_1
    //   354: aload_0
    //   355: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   358: athrow
    //   359: astore_0
    //   360: new 707	gnu/mapping/WrongType
    //   363: dup
    //   364: aload_0
    //   365: ldc_w 715
    //   368: iconst_2
    //   369: aload 4
    //   371: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   374: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramObject	Object
    //   46	209	1	i	int
    //   223	11	2	j	int
    //   8	242	3	localObject1	Object
    //   297	6	3	localClassCastException1	ClassCastException
    //   344	6	3	localClassCastException2	ClassCastException
    //   3	367	4	localObject2	Object
    //   32	200	5	localObject3	Object
    //   23	253	6	localObject4	Object
    //   39	3	7	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   34	41	265	java/lang/ClassCastException
    //   95	101	281	java/lang/ClassCastException
    //   129	135	297	java/lang/ClassCastException
    //   164	173	312	java/lang/ClassCastException
    //   203	210	328	java/lang/ClassCastException
    //   216	224	344	java/lang/ClassCastException
    //   224	231	359	java/lang/ClassCastException
  }
  
  public static Object stringConcatenateReverse$SlShared$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    paramArrayOfObject = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject3 = paramArrayOfObject.get();
        localObject1 = Scheme.applyToArgs;
        localObject2 = Scheme.applyToArgs;
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        try
        {
          Object localObject3;
          Object localObject4;
          Object localObject6;
          int i;
          Object localObject7;
          CharSequence localCharSequence;
          paramObject = ((Location)paramObject).get();
        }
        catch (UnboundLocationException paramObject)
        {
          Object localObject1;
          Object localObject2;
          Object localObject5;
          boolean bool;
          Object localObject8;
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1649, 16);
          throw ((Throwable)paramObject);
        }
        try
        {
          localObject2 = (Number)paramObject;
          bool = numbers.isZero((Number)localObject2);
          if (bool)
          {
            localObject2 = Scheme.numEqu;
            paramObject = lists.car.apply1(paramArrayOfObject);
          }
        }
        catch (ClassCastException paramArrayOfObject)
        {
          throw new WrongType(paramArrayOfObject, "zero?", 1, paramObject);
        }
        try
        {
          localObject5 = (CharSequence)paramObject;
          if (((Procedure)localObject2).apply2(localObject1, Integer.valueOf(strings.stringLength((CharSequence)localObject5))) != Boolean.FALSE)
          {
            paramObject = lists.car.apply1(paramArrayOfObject);
            continue;
            if (bool) {
              continue;
            }
          }
          paramObject = loc$final;
        }
        catch (ClassCastException paramArrayOfObject)
        {
          throw new WrongType(paramArrayOfObject, "string-length", 1, paramObject);
        }
        try
        {
          paramObject = ((Location)paramObject).get();
          localObject2 = loc$end;
        }
        catch (UnboundLocationException paramObject)
        {
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1652, 56);
          throw ((Throwable)paramObject);
        }
        try
        {
          localObject2 = ((Location)localObject2).get();
          paramObject = $PcFinishStringConcatenateReverse(localObject1, paramArrayOfObject, paramObject, localObject2);
        }
        catch (UnboundLocationException paramObject)
        {
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1652, 62);
          throw ((Throwable)paramObject);
        }
        paramObject = paramObject;
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1630, 3);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject4 = paramArrayOfObject.get();
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1630, 36);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (strings.isString(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject2 = ((Procedure)localObject2).apply3(localObject4, "", paramArrayOfObject);
          localObject4 = Scheme.applyToArgs;
          paramArrayOfObject = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1630, 55);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject5 = paramArrayOfObject.get();
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1631, 8);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1631, 28);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject6 = (CharSequence)paramArrayOfObject;
        i = strings.stringLength((CharSequence)localObject6);
        paramArrayOfObject = loc$end;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        bool = numbers.isInteger(paramArrayOfObject);
        if (bool) {
          paramArrayOfObject = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1632, 21);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        bool = numbers.isExact(paramArrayOfObject);
        if (bool)
        {
          paramArrayOfObject = Scheme.numLEq;
          localObject6 = Lit0;
          localObject7 = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1633, 19);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject7 = ((Location)localObject7).get();
        localObject8 = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1634, 17);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject8 = ((Location)localObject8).get();
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1634, 36);
        throw ((Throwable)paramObject);
      }
      try
      {
        localCharSequence = (CharSequence)localObject8;
        paramArrayOfObject = paramArrayOfObject.apply3(localObject6, localObject7, Integer.valueOf(strings.stringLength(localCharSequence)));
        localObject4 = ((Procedure)localObject1).apply2(localObject2, ((Procedure)localObject4).apply3(localObject5, Integer.valueOf(i), paramArrayOfObject));
        localObject1 = Lit0;
        paramArrayOfObject = Boolean.FALSE;
        if (lists.isPair(paramObject)) {
          localObject2 = lists.car.apply1(paramObject);
        }
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, localObject8);
      }
      try
      {
        localObject5 = (CharSequence)localObject2;
        i = strings.stringLength((CharSequence)localObject5);
        localObject1 = AddOp.$Pl.apply2(localObject1, Integer.valueOf(i));
        localObject2 = paramArrayOfObject;
        if (paramArrayOfObject == Boolean.FALSE)
        {
          if (numbers.isZero(Integer.valueOf(i))) {
            localObject2 = paramArrayOfObject;
          }
        }
        else
        {
          paramObject = lists.cdr.apply1(paramObject);
          paramArrayOfObject = (Object[])localObject2;
          continue;
          paramArrayOfObject = Boolean.FALSE;
          continue;
          if (bool)
          {
            paramArrayOfObject = Boolean.TRUE;
            continue;
          }
          paramArrayOfObject = Boolean.FALSE;
          continue;
          if (bool)
          {
            paramArrayOfObject = Boolean.TRUE;
            continue;
          }
          paramArrayOfObject = Boolean.FALSE;
          continue;
        }
        localObject2 = paramObject;
        continue;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, localObject2);
      }
      try
      {
        paramObject = (Number)localObject1;
        if (numbers.isZero((Number)paramObject)) {
          paramObject = loc$final;
        }
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "zero?", 1, localObject1);
      }
    }
    try
    {
      paramObject = ((Location)paramObject).get();
      paramArrayOfObject = Lit0;
      localObject1 = loc$end;
    }
    catch (UnboundLocationException paramObject)
    {
      ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1645, 41);
      throw ((Throwable)paramObject);
    }
    try
    {
      localObject1 = ((Location)localObject1).get();
      paramObject = substring$SlShared$V(paramObject, paramArrayOfObject, new Object[] { localObject1 });
      return localApplyToArgs.apply4(localObject3, localLList, localObject4, paramObject);
    }
    catch (UnboundLocationException paramObject)
    {
      ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1645, 49);
      throw ((Throwable)paramObject);
    }
    paramObject = loc$end;
  }
  
  public static Object stringConcatenateReverse$V(Object paramObject, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    localApplyToArgs = Scheme.applyToArgs;
    paramArrayOfObject = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject2 = paramArrayOfObject.get();
        localObject1 = Scheme.applyToArgs;
        localObject3 = Scheme.applyToArgs;
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        try
        {
          Object localObject5;
          Object localObject6;
          int i;
          boolean bool;
          Object localObject7;
          CharSequence localCharSequence;
          localObject1 = ((Location)localObject1).get();
          localObject4 = loc$end;
        }
        catch (UnboundLocationException paramObject)
        {
          Object localObject2;
          Object localObject1;
          Object localObject3;
          Object localObject4;
          Object localObject8;
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1627, 59);
          throw ((Throwable)paramObject);
        }
        try
        {
          localObject4 = ((Location)localObject4).get();
          return localApplyToArgs.apply4(localObject2, localLList, localObject3, $PcFinishStringConcatenateReverse(paramArrayOfObject, paramObject, localObject1, localObject4));
        }
        catch (UnboundLocationException paramObject)
        {
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1627, 65);
          throw ((Throwable)paramObject);
        }
        paramObject = paramObject;
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1617, 3);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject4 = paramArrayOfObject.get();
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1617, 36);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (strings.isString(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject3 = ((Procedure)localObject3).apply3(localObject4, "", paramArrayOfObject);
          localObject4 = Scheme.applyToArgs;
          paramArrayOfObject = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1617, 55);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject5 = paramArrayOfObject.get();
        paramArrayOfObject = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1618, 8);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1618, 28);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject6 = (CharSequence)paramArrayOfObject;
        i = strings.stringLength((CharSequence)localObject6);
        paramArrayOfObject = loc$end;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        bool = numbers.isInteger(paramArrayOfObject);
        if (bool) {
          paramArrayOfObject = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1619, 21);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        bool = numbers.isExact(paramArrayOfObject);
        if (bool)
        {
          paramArrayOfObject = Scheme.numLEq;
          localObject6 = Lit0;
          localObject7 = loc$end;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1620, 19);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject7 = ((Location)localObject7).get();
        localObject8 = loc$final;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1621, 17);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject8 = ((Location)localObject8).get();
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1621, 36);
        throw ((Throwable)paramObject);
      }
      try
      {
        localCharSequence = (CharSequence)localObject8;
        paramArrayOfObject = paramArrayOfObject.apply3(localObject6, localObject7, Integer.valueOf(strings.stringLength(localCharSequence)));
        localObject3 = ((Procedure)localObject1).apply2(localObject3, ((Procedure)localObject4).apply3(localObject5, Integer.valueOf(i), paramArrayOfObject));
        paramArrayOfObject = Lit0;
        localObject1 = paramObject;
        if (lists.isPair(localObject1))
        {
          localObject5 = AddOp.$Pl;
          localObject4 = lists.car.apply1(localObject1);
        }
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, localObject8);
      }
      try
      {
        localObject6 = (CharSequence)localObject4;
        paramArrayOfObject = ((Procedure)localObject5).apply2(paramArrayOfObject, Integer.valueOf(strings.stringLength((CharSequence)localObject6)));
        localObject1 = lists.cdr.apply1(localObject1);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "string-length", 1, localObject4);
      }
      paramArrayOfObject = Boolean.FALSE;
      continue;
      if (bool)
      {
        paramArrayOfObject = Boolean.TRUE;
      }
      else
      {
        paramArrayOfObject = Boolean.FALSE;
        continue;
        if (bool) {
          paramArrayOfObject = Boolean.TRUE;
        } else {
          paramArrayOfObject = Boolean.FALSE;
        }
      }
    }
    localObject1 = loc$final;
  }
  
  public static Object stringContains$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame83 localframe83 = new frame83();
    localframe83.text = paramObject1;
    localframe83.pattern = paramObject2;
    localframe83.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe83.lambda$Fn189, localframe83.lambda$Fn190);
  }
  
  public static Object stringContainsCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame85 localframe85 = new frame85();
    localframe85.text = paramObject1;
    localframe85.pattern = paramObject2;
    localframe85.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe85.lambda$Fn193, localframe85.lambda$Fn194);
  }
  
  public static Object stringCopy$Ex(Object paramObject, int paramInt, CharSequence paramCharSequence)
  {
    return stringCopy$Ex(paramObject, paramInt, paramCharSequence, 0);
  }
  
  public static Object stringCopy$Ex(Object paramObject, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    return stringCopy$Ex(paramObject, paramInt1, paramCharSequence, paramInt2, paramCharSequence.length());
  }
  
  /* Error */
  public static Object stringCopy$Ex(Object paramObject, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: getstatic 1890	gnu/kawa/slib/srfi13:string$Mncopy$Ex	Lgnu/expr/ModuleMethod;
    //   3: aload_2
    //   4: iload_3
    //   5: iload 4
    //   7: invokestatic 2331	gnu/kawa/slib/srfi13:$PcCheckBounds	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   10: pop
    //   11: getstatic 1890	gnu/kawa/slib/srfi13:string$Mncopy$Ex	Lgnu/expr/ModuleMethod;
    //   14: astore 5
    //   16: aload_0
    //   17: checkcast 681	java/lang/CharSequence
    //   20: astore 6
    //   22: aload 5
    //   24: aload 6
    //   26: iload_1
    //   27: iload 4
    //   29: iload_3
    //   30: isub
    //   31: iload_1
    //   32: iadd
    //   33: invokestatic 2333	gnu/kawa/slib/srfi13:$PcCheckSubstringSpec	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: checkcast 681	java/lang/CharSequence
    //   41: astore 5
    //   43: aload 5
    //   45: iload_1
    //   46: aload_2
    //   47: iload_3
    //   48: iload 4
    //   50: invokestatic 685	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
    //   53: areturn
    //   54: astore_2
    //   55: new 707	gnu/mapping/WrongType
    //   58: dup
    //   59: aload_2
    //   60: ldc_w 2335
    //   63: iconst_1
    //   64: aload_0
    //   65: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   68: athrow
    //   69: astore_2
    //   70: new 707	gnu/mapping/WrongType
    //   73: dup
    //   74: aload_2
    //   75: ldc_w 715
    //   78: iconst_0
    //   79: aload_0
    //   80: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramObject	Object
    //   0	84	1	paramInt1	int
    //   0	84	2	paramCharSequence	CharSequence
    //   0	84	3	paramInt2	int
    //   0	84	4	paramInt3	int
    //   14	30	5	localObject	Object
    //   20	5	6	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   16	22	54	java/lang/ClassCastException
    //   37	43	69	java/lang/ClassCastException
  }
  
  public static Object stringCopy$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame2 localframe2 = new frame2();
    localframe2.s = paramObject;
    localframe2.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe2.lambda$Fn7, localframe2.lambda$Fn8);
  }
  
  public static Object stringCount$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame81 localframe81 = new frame81();
    localframe81.s = paramObject1;
    localframe81.criterion = paramObject2;
    localframe81.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe81.lambda$Fn185, localframe81.lambda$Fn186);
  }
  
  public static Object stringDelete$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame73 localframe73 = new frame73();
    localframe73.criterion = paramObject1;
    localframe73.s = paramObject2;
    localframe73.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe73.lambda$Fn167, localframe73.lambda$Fn168);
  }
  
  public static Object stringDowncase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame61 localframe61 = new frame61();
    localframe61.s = paramObject;
    localframe61.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe61.lambda$Fn145, localframe61.lambda$Fn146);
  }
  
  public static Object stringDowncase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame60 localframe60 = new frame60();
    localframe60.s = paramObject;
    localframe60.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe60.lambda$Fn143, localframe60.lambda$Fn144);
  }
  
  /* Error */
  public static Object stringDrop(CharSequence paramCharSequence, Object paramObject)
  {
    // Byte code:
    //   0: new 198	gnu/kawa/slib/srfi13$frame66
    //   3: dup
    //   4: invokespecial 2389	gnu/kawa/slib/srfi13$frame66:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: putfield 2392	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_0
    //   15: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   18: putfield 2396	gnu/kawa/slib/srfi13$frame66:len	I
    //   21: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   24: astore_1
    //   25: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 4
    //   37: aload_1
    //   38: aload 4
    //   40: aload_3
    //   41: getfield 2399	gnu/kawa/slib/srfi13$frame66:lambda$Fn153	Lgnu/expr/ModuleMethod;
    //   44: aload_3
    //   45: getfield 2392	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   48: getstatic 1852	gnu/kawa/slib/srfi13:string$Mndrop	Lgnu/expr/ModuleMethod;
    //   51: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_3
    //   56: getfield 2392	gnu/kawa/slib/srfi13$frame66:n	Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_1
    //   61: checkcast 671	java/lang/Number
    //   64: invokevirtual 675	java/lang/Number:intValue	()I
    //   67: istore_2
    //   68: aload_0
    //   69: iload_2
    //   70: aload_3
    //   71: getfield 2396	gnu/kawa/slib/srfi13$frame66:len	I
    //   74: invokestatic 2401	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: ldc_w 920
    //   83: sipush 1010
    //   86: iconst_5
    //   87: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: new 707	gnu/mapping/WrongType
    //   96: dup
    //   97: aload_0
    //   98: ldc_w 1330
    //   101: iconst_1
    //   102: aload_1
    //   103: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramCharSequence	CharSequence
    //   0	107	1	paramObject	Object
    //   67	3	2	i	int
    //   7	64	3	localframe66	frame66
    //   28	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	78	gnu/mapping/UnboundLocationException
    //   60	68	92	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringDropRight(CharSequence paramCharSequence, Object paramObject)
  {
    // Byte code:
    //   0: new 201	gnu/kawa/slib/srfi13$frame67
    //   3: dup
    //   4: invokespecial 2403	gnu/kawa/slib/srfi13$frame67:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: putfield 2404	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_0
    //   15: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   18: putfield 2405	gnu/kawa/slib/srfi13$frame67:len	I
    //   21: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   24: astore_1
    //   25: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 4
    //   37: aload_1
    //   38: aload 4
    //   40: aload_3
    //   41: getfield 2408	gnu/kawa/slib/srfi13$frame67:lambda$Fn154	Lgnu/expr/ModuleMethod;
    //   44: aload_3
    //   45: getfield 2404	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   48: getstatic 1854	gnu/kawa/slib/srfi13:string$Mndrop$Mnright	Lgnu/expr/ModuleMethod;
    //   51: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   58: aload_3
    //   59: getfield 2405	gnu/kawa/slib/srfi13$frame67:len	I
    //   62: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aload_3
    //   66: getfield 2404	gnu/kawa/slib/srfi13$frame67:n	Ljava/lang/Object;
    //   69: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: checkcast 671	java/lang/Number
    //   77: invokevirtual 675	java/lang/Number:intValue	()I
    //   80: istore_2
    //   81: aload_0
    //   82: iconst_0
    //   83: iload_2
    //   84: invokestatic 2401	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: ldc_w 920
    //   93: sipush 1016
    //   96: iconst_5
    //   97: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: new 707	gnu/mapping/WrongType
    //   106: dup
    //   107: aload_0
    //   108: ldc_w 1330
    //   111: iconst_2
    //   112: aload_1
    //   113: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramCharSequence	CharSequence
    //   0	117	1	paramObject	Object
    //   80	4	2	i	int
    //   7	59	3	localframe67	frame67
    //   28	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	88	gnu/mapping/UnboundLocationException
    //   73	81	102	java/lang/ClassCastException
  }
  
  public static Object stringEvery$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.criterion = paramObject1;
    localframe9.s = paramObject2;
    localframe9.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe9.lambda$Fn23, localframe9.lambda$Fn24);
  }
  
  public static Object stringFill$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame82 localframe82 = new frame82();
    localframe82.s = paramObject1;
    localframe82.jdField_char = paramObject2;
    localframe82.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, characters.char$Qu, localframe82.jdField_char, string$Mnfill$Ex);
      return call_with_values.callWithValues(localframe82.lambda$Fn187, localframe82.lambda$Fn188);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1270, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringFilter$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame75 localframe75 = new frame75();
    localframe75.criterion = paramObject1;
    localframe75.s = paramObject2;
    localframe75.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe75.lambda$Fn172, localframe75.lambda$Fn173);
  }
  
  public static Object stringFold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    frame5 localframe5 = new frame5();
    localframe5.kons = paramObject1;
    localframe5.knil = paramObject2;
    localframe5.s = paramObject3;
    localframe5.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe5.kons, string$Mnfold);
      return call_with_values.callWithValues(localframe5.lambda$Fn13, localframe5.lambda$Fn14);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 295, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringFoldRight$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    frame6 localframe6 = new frame6();
    localframe6.kons = paramObject1;
    localframe6.knil = paramObject2;
    localframe6.s = paramObject3;
    localframe6.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe6.kons, string$Mnfold$Mnright);
      return call_with_values.callWithValues(localframe6.lambda$Fn15, localframe6.lambda$Fn16);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 302, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringForEach$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame7 localframe7 = new frame7();
    localframe7.proc = paramObject1;
    localframe7.s = paramObject2;
    localframe7.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe7.proc, string$Mnfor$Mneach);
      return call_with_values.callWithValues(localframe7.lambda$Fn19, localframe7.lambda$Fn20);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 468, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringForEachIndex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame8 localframe8 = new frame8();
    localframe8.proc = paramObject1;
    localframe8.s = paramObject2;
    localframe8.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe8.proc, string$Mnfor$Mneach$Mnindex);
      return call_with_values.callWithValues(localframe8.lambda$Fn21, localframe8.lambda$Fn22);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 476, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  /* Error */
  public static Object stringHash$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 165	gnu/kawa/slib/srfi13$frame56
    //   3: dup
    //   4: invokespecial 2501	gnu/kawa/slib/srfi13$frame56:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 2502	gnu/kawa/slib/srfi13$frame56:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_1
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   32: astore 5
    //   34: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   37: astore 6
    //   39: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   42: astore 7
    //   44: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 8
    //   54: getstatic 1547	gnu/kawa/slib/srfi13:Lit7	Lgnu/math/IntNum;
    //   57: astore 9
    //   59: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   67: astore_0
    //   68: aload_0
    //   69: invokestatic 2032	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   72: istore_2
    //   73: iload_2
    //   74: ifeq +156 -> 230
    //   77: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   85: astore_0
    //   86: aload_0
    //   87: invokestatic 2035	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   90: istore_2
    //   91: iload_2
    //   92: ifeq +120 -> 212
    //   95: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   98: astore_0
    //   99: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   102: astore 10
    //   104: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   107: astore 11
    //   109: aload 11
    //   111: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   114: astore 11
    //   116: aload_0
    //   117: aload 10
    //   119: aload 11
    //   121: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_0
    //   125: aload 7
    //   127: aload 8
    //   129: aload 9
    //   131: aload_0
    //   132: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore_0
    //   136: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   139: astore 7
    //   141: aload 7
    //   143: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   146: astore 7
    //   148: aload 6
    //   150: aload_0
    //   151: aload 7
    //   153: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: astore 6
    //   158: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   166: astore_0
    //   167: aload_0
    //   168: checkcast 671	java/lang/Number
    //   171: astore 7
    //   173: aload 7
    //   175: invokestatic 798	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   178: ifeq +70 -> 248
    //   181: getstatic 1545	gnu/kawa/slib/srfi13:Lit8	Lgnu/math/IntNum;
    //   184: astore_0
    //   185: aload_3
    //   186: aload_0
    //   187: putfield 2504	gnu/kawa/slib/srfi13$frame56:bound	Ljava/lang/Object;
    //   190: aload 4
    //   192: aload 5
    //   194: aload_1
    //   195: aload 6
    //   197: aload_3
    //   198: getfield 2507	gnu/kawa/slib/srfi13$frame56:lambda$Fn134	Lgnu/expr/ModuleMethod;
    //   201: aload_3
    //   202: getfield 2510	gnu/kawa/slib/srfi13$frame56:lambda$Fn135	Lgnu/expr/ModuleMethod;
    //   205: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   208: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: areturn
    //   212: iload_2
    //   213: ifeq +10 -> 223
    //   216: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   219: astore_0
    //   220: goto -95 -> 125
    //   223: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   226: astore_0
    //   227: goto -102 -> 125
    //   230: iload_2
    //   231: ifeq +10 -> 241
    //   234: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   237: astore_0
    //   238: goto -113 -> 125
    //   241: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   244: astore_0
    //   245: goto -120 -> 125
    //   248: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   256: astore_0
    //   257: goto -72 -> 185
    //   260: astore_0
    //   261: aload_0
    //   262: ldc_w 920
    //   265: sipush 907
    //   268: iconst_3
    //   269: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   272: aload_0
    //   273: athrow
    //   274: astore_0
    //   275: aload_0
    //   276: ldc_w 920
    //   279: sipush 907
    //   282: bipush 42
    //   284: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   287: aload_0
    //   288: athrow
    //   289: astore_0
    //   290: aload_0
    //   291: ldc_w 920
    //   294: sipush 907
    //   297: bipush 72
    //   299: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: aload_0
    //   306: ldc_w 920
    //   309: sipush 908
    //   312: bipush 21
    //   314: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   317: aload_0
    //   318: athrow
    //   319: astore_0
    //   320: aload_0
    //   321: ldc_w 920
    //   324: sipush 909
    //   327: bipush 19
    //   329: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   332: aload_0
    //   333: athrow
    //   334: astore_0
    //   335: aload_0
    //   336: ldc_w 920
    //   339: sipush 910
    //   342: bipush 7
    //   344: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   347: aload_0
    //   348: athrow
    //   349: astore_0
    //   350: aload_0
    //   351: ldc_w 920
    //   354: sipush 911
    //   357: bipush 29
    //   359: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   362: aload_0
    //   363: athrow
    //   364: astore_1
    //   365: new 707	gnu/mapping/WrongType
    //   368: dup
    //   369: aload_1
    //   370: ldc_w 800
    //   373: iconst_1
    //   374: aload_0
    //   375: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore_0
    //   380: aload_0
    //   381: ldc_w 920
    //   384: sipush 911
    //   387: bipush 18
    //   389: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   392: aload_0
    //   393: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramObject	Object
    //   0	394	1	paramArrayOfObject	Object[]
    //   72	159	2	bool	boolean
    //   7	195	3	localframe56	frame56
    //   22	169	4	localApplyToArgs	ApplyToArgs
    //   32	161	5	localObject1	Object
    //   37	159	6	localObject2	Object
    //   42	132	7	localObject3	Object
    //   52	76	8	localObject4	Object
    //   57	73	9	localIntNum1	IntNum
    //   102	16	10	localIntNum2	IntNum
    //   107	13	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	260	gnu/mapping/UnboundLocationException
    //   48	54	274	gnu/mapping/UnboundLocationException
    //   63	68	289	gnu/mapping/UnboundLocationException
    //   81	86	304	gnu/mapping/UnboundLocationException
    //   109	116	319	gnu/mapping/UnboundLocationException
    //   141	148	334	gnu/mapping/UnboundLocationException
    //   162	167	349	gnu/mapping/UnboundLocationException
    //   167	173	364	java/lang/ClassCastException
    //   252	257	379	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringHashCi$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 168	gnu/kawa/slib/srfi13$frame57
    //   3: dup
    //   4: invokespecial 2512	gnu/kawa/slib/srfi13$frame57:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 2513	gnu/kawa/slib/srfi13$frame57:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_1
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore 4
    //   24: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   32: astore 5
    //   34: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   37: astore 6
    //   39: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   42: astore 7
    //   44: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 8
    //   54: getstatic 1543	gnu/kawa/slib/srfi13:Lit9	Lgnu/math/IntNum;
    //   57: astore 9
    //   59: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   67: astore_0
    //   68: aload_0
    //   69: invokestatic 2032	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   72: istore_2
    //   73: iload_2
    //   74: ifeq +156 -> 230
    //   77: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   85: astore_0
    //   86: aload_0
    //   87: invokestatic 2035	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   90: istore_2
    //   91: iload_2
    //   92: ifeq +120 -> 212
    //   95: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   98: astore_0
    //   99: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   102: astore 10
    //   104: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   107: astore 11
    //   109: aload 11
    //   111: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   114: astore 11
    //   116: aload_0
    //   117: aload 10
    //   119: aload 11
    //   121: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_0
    //   125: aload 7
    //   127: aload 8
    //   129: aload 9
    //   131: aload_0
    //   132: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: astore_0
    //   136: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   139: astore 7
    //   141: aload 7
    //   143: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   146: astore 7
    //   148: aload 6
    //   150: aload_0
    //   151: aload 7
    //   153: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: astore 6
    //   158: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   166: astore_0
    //   167: aload_0
    //   168: checkcast 671	java/lang/Number
    //   171: astore 7
    //   173: aload 7
    //   175: invokestatic 798	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   178: ifeq +70 -> 248
    //   181: getstatic 1541	gnu/kawa/slib/srfi13:Lit10	Lgnu/math/IntNum;
    //   184: astore_0
    //   185: aload_3
    //   186: aload_0
    //   187: putfield 2514	gnu/kawa/slib/srfi13$frame57:bound	Ljava/lang/Object;
    //   190: aload 4
    //   192: aload 5
    //   194: aload_1
    //   195: aload 6
    //   197: aload_3
    //   198: getfield 2517	gnu/kawa/slib/srfi13$frame57:lambda$Fn136	Lgnu/expr/ModuleMethod;
    //   201: aload_3
    //   202: getfield 2520	gnu/kawa/slib/srfi13$frame57:lambda$Fn137	Lgnu/expr/ModuleMethod;
    //   205: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   208: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   211: areturn
    //   212: iload_2
    //   213: ifeq +10 -> 223
    //   216: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   219: astore_0
    //   220: goto -95 -> 125
    //   223: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   226: astore_0
    //   227: goto -102 -> 125
    //   230: iload_2
    //   231: ifeq +10 -> 241
    //   234: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   237: astore_0
    //   238: goto -113 -> 125
    //   241: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   244: astore_0
    //   245: goto -120 -> 125
    //   248: getstatic 1579	gnu/kawa/slib/srfi13:loc$bound	Lgnu/mapping/Location;
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   256: astore_0
    //   257: goto -72 -> 185
    //   260: astore_0
    //   261: aload_0
    //   262: ldc_w 920
    //   265: sipush 916
    //   268: iconst_3
    //   269: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   272: aload_0
    //   273: athrow
    //   274: astore_0
    //   275: aload_0
    //   276: ldc_w 920
    //   279: sipush 916
    //   282: bipush 42
    //   284: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   287: aload_0
    //   288: athrow
    //   289: astore_0
    //   290: aload_0
    //   291: ldc_w 920
    //   294: sipush 916
    //   297: bipush 72
    //   299: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: aload_0
    //   306: ldc_w 920
    //   309: sipush 917
    //   312: bipush 21
    //   314: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   317: aload_0
    //   318: athrow
    //   319: astore_0
    //   320: aload_0
    //   321: ldc_w 920
    //   324: sipush 918
    //   327: bipush 19
    //   329: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   332: aload_0
    //   333: athrow
    //   334: astore_0
    //   335: aload_0
    //   336: ldc_w 920
    //   339: sipush 919
    //   342: bipush 7
    //   344: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   347: aload_0
    //   348: athrow
    //   349: astore_0
    //   350: aload_0
    //   351: ldc_w 920
    //   354: sipush 920
    //   357: bipush 29
    //   359: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   362: aload_0
    //   363: athrow
    //   364: astore_1
    //   365: new 707	gnu/mapping/WrongType
    //   368: dup
    //   369: aload_1
    //   370: ldc_w 800
    //   373: iconst_1
    //   374: aload_0
    //   375: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore_0
    //   380: aload_0
    //   381: ldc_w 920
    //   384: sipush 920
    //   387: bipush 18
    //   389: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   392: aload_0
    //   393: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramObject	Object
    //   0	394	1	paramArrayOfObject	Object[]
    //   72	159	2	bool	boolean
    //   7	195	3	localframe57	frame57
    //   22	169	4	localApplyToArgs	ApplyToArgs
    //   32	161	5	localObject1	Object
    //   37	159	6	localObject2	Object
    //   42	132	7	localObject3	Object
    //   52	76	8	localObject4	Object
    //   57	73	9	localIntNum1	IntNum
    //   102	16	10	localIntNum2	IntNum
    //   107	13	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	260	gnu/mapping/UnboundLocationException
    //   48	54	274	gnu/mapping/UnboundLocationException
    //   63	68	289	gnu/mapping/UnboundLocationException
    //   81	86	304	gnu/mapping/UnboundLocationException
    //   109	116	319	gnu/mapping/UnboundLocationException
    //   141	148	334	gnu/mapping/UnboundLocationException
    //   162	167	349	gnu/mapping/UnboundLocationException
    //   167	173	364	java/lang/ClassCastException
    //   252	257	379	gnu/mapping/UnboundLocationException
  }
  
  public static Object stringIndex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame77 localframe77 = new frame77();
    localframe77.str = paramObject1;
    localframe77.criterion = paramObject2;
    localframe77.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe77.lambda$Fn177, localframe77.lambda$Fn178);
  }
  
  public static Object stringIndexRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame78 localframe78 = new frame78();
    localframe78.str = paramObject1;
    localframe78.criterion = paramObject2;
    localframe78.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe78.lambda$Fn179, localframe78.lambda$Fn180);
  }
  
  public static Object stringJoin$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    paramArrayOfObject = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject1 = paramArrayOfObject.get();
        localObject2 = Scheme.applyToArgs;
        localObject3 = Scheme.applyToArgs;
        paramArrayOfObject = loc$delim;
      }
      catch (UnboundLocationException paramObject)
      {
        try
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          paramObject = ((Location)paramObject).get();
          if (paramObject == Lit16)
          {
            paramObject = misc.error$V("Empty list cannot be joined with STRICT-INFIX grammar.", new Object[] { string$Mnjoin });
            continue;
          }
          paramObject = "";
        }
        catch (UnboundLocationException paramObject)
        {
          ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1880, 13);
          throw ((Throwable)paramObject);
        }
        paramObject = paramObject;
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1852, 3);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject4 = paramArrayOfObject.get();
        paramArrayOfObject = loc$delim;
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1852, 34);
        throw ((Throwable)paramObject);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (strings.isString(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          paramArrayOfObject = ((Procedure)localObject3).apply3(localObject4, " ", paramArrayOfObject);
          localObject3 = Scheme.applyToArgs;
          localObject4 = loc$grammar;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1852, 54);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject4 = ((Location)localObject4).get();
        paramArrayOfObject = ((Procedure)localObject2).apply2(paramArrayOfObject, ((Procedure)localObject3).apply2(localObject4, Lit15));
        if (lists.isPair(paramObject)) {
          localObject2 = loc$grammar;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1853, 6);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject2 = ((Location)localObject2).get();
        localObject3 = Scheme.isEqv.apply2(localObject2, Lit15);
        if (localObject3 != Boolean.FALSE)
        {
          if (localObject3 != Boolean.FALSE)
          {
            paramObject = lists.cons(lists.car.apply1(paramObject), lambda222buildit(lists.cdr.apply1(paramObject), LList.Empty));
            paramObject = stringConcatenate(paramObject);
            return localApplyToArgs.apply4(localObject1, localLList, paramArrayOfObject, paramObject);
            paramArrayOfObject = Boolean.FALSE;
          }
        }
        else {
          if (Scheme.isEqv.apply2(localObject2, Lit16) != Boolean.FALSE) {
            continue;
          }
        }
        if (Scheme.isEqv.apply2(localObject2, Lit17) != Boolean.FALSE)
        {
          paramObject = lambda222buildit(paramObject, LList.Empty);
          continue;
        }
        if (Scheme.isEqv.apply2(localObject2, Lit18) != Boolean.FALSE)
        {
          localObject2 = lists.car.apply1(paramObject);
          paramObject = lists.cdr.apply1(paramObject);
          localObject3 = loc$delim;
        }
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1862, 14);
        throw ((Throwable)paramObject);
      }
      try
      {
        localObject3 = ((Location)localObject3).get();
        paramObject = lists.cons(localObject2, lambda222buildit(paramObject, LList.list1(localObject3)));
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1870, 53);
        throw ((Throwable)paramObject);
      }
      paramObject = loc$grammar;
      try
      {
        paramObject = ((Location)paramObject).get();
        paramObject = misc.error$V("Illegal join grammar", new Object[] { paramObject, string$Mnjoin });
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1873, 9);
        throw ((Throwable)paramObject);
      }
      if (lists.isNull(paramObject)) {
        continue;
      }
      paramObject = misc.error$V("STRINGS parameter not list.", new Object[] { paramObject, string$Mnjoin });
    }
    paramObject = loc$grammar;
  }
  
  /* Error */
  public static Object stringKmpPartialSearch$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 270	gnu/kawa/slib/srfi13$frame88
    //   3: dup
    //   4: invokespecial 2574	gnu/kawa/slib/srfi13$frame88:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: aload_2
    //   12: putfield 2575	gnu/kawa/slib/srfi13$frame88:s	Ljava/lang/Object;
    //   15: aload 4
    //   17: iconst_0
    //   18: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   21: astore 9
    //   23: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   26: astore_2
    //   27: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   30: astore 4
    //   32: aload 4
    //   34: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   37: astore 4
    //   39: aload_2
    //   40: aload 4
    //   42: getstatic 2578	kawa/lib/vectors:vector$Qu	Lgnu/expr/ModuleMethod;
    //   45: aload_1
    //   46: getstatic 1904	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   49: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   56: astore 10
    //   58: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   66: astore 11
    //   68: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   71: astore 4
    //   73: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   76: astore 12
    //   78: getstatic 1587	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   86: astore 13
    //   88: getstatic 2056	kawa/lib/characters:char$Eq$Qu	Lgnu/expr/ModuleMethod;
    //   91: astore 14
    //   93: getstatic 1587	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   101: astore_2
    //   102: aload_2
    //   103: invokestatic 2059	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   106: ifeq +288 -> 394
    //   109: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   112: astore_2
    //   113: aload 12
    //   115: aload 13
    //   117: aload 14
    //   119: aload_2
    //   120: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: astore 12
    //   125: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   128: astore 13
    //   130: getstatic 1593	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   138: astore 14
    //   140: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   143: astore 15
    //   145: getstatic 1593	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   148: astore_2
    //   149: aload_2
    //   150: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   153: astore_2
    //   154: aload_2
    //   155: invokestatic 2032	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   158: istore 7
    //   160: iload 7
    //   162: ifeq +258 -> 420
    //   165: getstatic 1593	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   173: astore_2
    //   174: aload_2
    //   175: invokestatic 2035	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   178: istore 7
    //   180: iload 7
    //   182: ifeq +219 -> 401
    //   185: getstatic 739	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   188: astore_2
    //   189: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   192: astore 16
    //   194: getstatic 1593	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   197: astore 17
    //   199: aload 17
    //   201: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   204: astore 17
    //   206: aload_2
    //   207: aload 16
    //   209: aload 17
    //   211: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: astore_2
    //   215: aload 13
    //   217: aload 14
    //   219: aload 15
    //   221: aload_2
    //   222: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: astore_2
    //   226: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   229: astore 13
    //   231: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   234: astore 14
    //   236: getstatic 1595	gnu/kawa/slib/srfi13:loc$s$Mnstart	Lgnu/mapping/Location;
    //   239: astore 15
    //   241: aload 15
    //   243: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   246: astore 15
    //   248: getstatic 1597	gnu/kawa/slib/srfi13:loc$s$Mnend	Lgnu/mapping/Location;
    //   251: astore 16
    //   253: aload 16
    //   255: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   258: astore 16
    //   260: aload 4
    //   262: aload 12
    //   264: aload_2
    //   265: aload 13
    //   267: aload 14
    //   269: aload 15
    //   271: aload 16
    //   273: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: aload 8
    //   278: getfield 2581	gnu/kawa/slib/srfi13$frame88:lambda$Fn198	Lgnu/expr/ModuleMethod;
    //   281: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   284: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: astore 12
    //   289: aload_1
    //   290: checkcast 765	gnu/lists/FVector
    //   293: astore_2
    //   294: aload 8
    //   296: aload_2
    //   297: invokestatic 2585	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   300: putfield 2588	gnu/kawa/slib/srfi13$frame88:patlen	I
    //   303: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   306: astore_2
    //   307: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   310: astore 4
    //   312: aload 4
    //   314: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   317: astore 4
    //   319: aload_2
    //   320: aload 4
    //   322: aload 8
    //   324: getfield 2591	gnu/kawa/slib/srfi13$frame88:lambda$Fn199	Lgnu/expr/ModuleMethod;
    //   327: aload_3
    //   328: getstatic 1904	gnu/kawa/slib/srfi13:string$Mnkmp$Mnpartial$Mnsearch	Lgnu/expr/ModuleMethod;
    //   331: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: pop
    //   335: getstatic 1595	gnu/kawa/slib/srfi13:loc$s$Mnstart	Lgnu/mapping/Location;
    //   338: astore_2
    //   339: aload_2
    //   340: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   343: astore 4
    //   345: aload_3
    //   346: astore_2
    //   347: aload 4
    //   349: astore_3
    //   350: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   353: aload_2
    //   354: aload 8
    //   356: getfield 2588	gnu/kawa/slib/srfi13$frame88:patlen	I
    //   359: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   368: if_acmpeq +71 -> 439
    //   371: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   374: aload_3
    //   375: invokevirtual 699	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   378: astore 4
    //   380: aload 10
    //   382: aload 11
    //   384: aload 9
    //   386: aload 12
    //   388: aload 4
    //   390: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: areturn
    //   394: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   397: astore_2
    //   398: goto -285 -> 113
    //   401: iload 7
    //   403: ifeq +10 -> 413
    //   406: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   409: astore_2
    //   410: goto -195 -> 215
    //   413: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   416: astore_2
    //   417: goto -202 -> 215
    //   420: iload 7
    //   422: ifeq +10 -> 432
    //   425: getstatic 776	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   428: astore_2
    //   429: goto -214 -> 215
    //   432: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   435: astore_2
    //   436: goto -221 -> 215
    //   439: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   442: astore 13
    //   444: getstatic 1597	gnu/kawa/slib/srfi13:loc$s$Mnend	Lgnu/mapping/Location;
    //   447: astore 4
    //   449: aload 4
    //   451: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   454: astore 14
    //   456: aload_2
    //   457: astore 4
    //   459: aload 13
    //   461: aload_3
    //   462: aload 14
    //   464: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   470: if_acmpne -90 -> 380
    //   473: aload 8
    //   475: getfield 2575	gnu/kawa/slib/srfi13$frame88:s	Ljava/lang/Object;
    //   478: astore 4
    //   480: aload 4
    //   482: checkcast 681	java/lang/CharSequence
    //   485: astore 13
    //   487: aload_3
    //   488: checkcast 671	java/lang/Number
    //   491: invokevirtual 675	java/lang/Number:intValue	()I
    //   494: istore 5
    //   496: aload 13
    //   498: iload 5
    //   500: invokestatic 751	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   503: istore 5
    //   505: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   508: aload_3
    //   509: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   512: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: astore_3
    //   516: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   519: astore 4
    //   521: getstatic 1587	gnu/kawa/slib/srfi13:loc$c$Eq	Lgnu/mapping/Location;
    //   524: astore 13
    //   526: aload 13
    //   528: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   531: astore 13
    //   533: iload 5
    //   535: invokestatic 757	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   538: astore 14
    //   540: aload_0
    //   541: checkcast 681	java/lang/CharSequence
    //   544: astore 15
    //   546: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   549: astore 16
    //   551: getstatic 1593	gnu/kawa/slib/srfi13:loc$p$Mnstart	Lgnu/mapping/Location;
    //   554: astore 17
    //   556: aload 17
    //   558: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   561: astore 17
    //   563: aload 16
    //   565: aload_2
    //   566: aload 17
    //   568: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore 16
    //   573: aload 16
    //   575: checkcast 671	java/lang/Number
    //   578: invokevirtual 675	java/lang/Number:intValue	()I
    //   581: istore 6
    //   583: aload 4
    //   585: aload 13
    //   587: aload 14
    //   589: aload 15
    //   591: iload 6
    //   593: invokestatic 751	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   596: invokestatic 757	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   599: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   602: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   605: if_acmpeq +17 -> 622
    //   608: getstatic 663	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   611: aload_2
    //   612: getstatic 763	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
    //   615: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: astore_2
    //   619: goto -269 -> 350
    //   622: aload_1
    //   623: checkcast 765	gnu/lists/FVector
    //   626: astore 4
    //   628: aload_2
    //   629: checkcast 671	java/lang/Number
    //   632: invokevirtual 675	java/lang/Number:intValue	()I
    //   635: istore 6
    //   637: aload 4
    //   639: iload 6
    //   641: invokestatic 771	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   644: astore 4
    //   646: aload 4
    //   648: astore_2
    //   649: getstatic 730	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   652: aload 4
    //   654: getstatic 773	gnu/kawa/slib/srfi13:Lit13	Lgnu/math/IntNum;
    //   657: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   660: getstatic 736	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   663: if_acmpeq -147 -> 516
    //   666: getstatic 724	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
    //   669: astore_2
    //   670: goto -51 -> 619
    //   673: astore_0
    //   674: aload_0
    //   675: ldc_w 920
    //   678: sipush 1464
    //   681: iconst_3
    //   682: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   685: aload_0
    //   686: athrow
    //   687: astore_0
    //   688: aload_0
    //   689: ldc_w 920
    //   692: sipush 1465
    //   695: iconst_3
    //   696: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   699: aload_0
    //   700: athrow
    //   701: astore_0
    //   702: aload_0
    //   703: ldc_w 920
    //   706: sipush 1466
    //   709: bipush 6
    //   711: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   714: aload_0
    //   715: athrow
    //   716: astore_0
    //   717: aload_0
    //   718: ldc_w 920
    //   721: sipush 1466
    //   724: bipush 34
    //   726: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   729: aload_0
    //   730: athrow
    //   731: astore_0
    //   732: aload_0
    //   733: ldc_w 920
    //   736: sipush 1467
    //   739: bipush 6
    //   741: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   744: aload_0
    //   745: athrow
    //   746: astore_0
    //   747: aload_0
    //   748: ldc_w 920
    //   751: sipush 1467
    //   754: bipush 32
    //   756: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   759: aload_0
    //   760: athrow
    //   761: astore_0
    //   762: aload_0
    //   763: ldc_w 920
    //   766: sipush 1467
    //   769: bipush 49
    //   771: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   774: aload_0
    //   775: athrow
    //   776: astore_0
    //   777: aload_0
    //   778: ldc_w 920
    //   781: sipush 1467
    //   784: bipush 64
    //   786: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   789: aload_0
    //   790: athrow
    //   791: astore_0
    //   792: aload_0
    //   793: ldc_w 920
    //   796: sipush 1468
    //   799: bipush 7
    //   801: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   804: aload_0
    //   805: athrow
    //   806: astore_0
    //   807: aload_0
    //   808: ldc_w 920
    //   811: sipush 1468
    //   814: bipush 16
    //   816: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   819: aload_0
    //   820: athrow
    //   821: astore_0
    //   822: new 707	gnu/mapping/WrongType
    //   825: dup
    //   826: aload_0
    //   827: ldc_w 2593
    //   830: iconst_1
    //   831: aload_1
    //   832: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   835: athrow
    //   836: astore_0
    //   837: aload_0
    //   838: ldc_w 920
    //   841: sipush 1472
    //   844: bipush 7
    //   846: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   849: aload_0
    //   850: athrow
    //   851: astore_0
    //   852: aload_0
    //   853: ldc_w 920
    //   856: sipush 1476
    //   859: bipush 7
    //   861: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   864: aload_0
    //   865: athrow
    //   866: astore_0
    //   867: aload_0
    //   868: ldc_w 920
    //   871: sipush 1479
    //   874: bipush 15
    //   876: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   879: aload_0
    //   880: athrow
    //   881: astore_0
    //   882: new 707	gnu/mapping/WrongType
    //   885: dup
    //   886: aload_0
    //   887: ldc_w 780
    //   890: iconst_1
    //   891: aload 4
    //   893: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   896: athrow
    //   897: astore_0
    //   898: new 707	gnu/mapping/WrongType
    //   901: dup
    //   902: aload_0
    //   903: ldc_w 780
    //   906: iconst_2
    //   907: aload_3
    //   908: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   911: athrow
    //   912: astore_0
    //   913: aload_0
    //   914: ldc_w 920
    //   917: sipush 1484
    //   920: bipush 14
    //   922: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   925: aload_0
    //   926: athrow
    //   927: astore_1
    //   928: new 707	gnu/mapping/WrongType
    //   931: dup
    //   932: aload_1
    //   933: ldc_w 780
    //   936: iconst_1
    //   937: aload_0
    //   938: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   941: athrow
    //   942: astore_0
    //   943: aload_0
    //   944: ldc_w 920
    //   947: sipush 1484
    //   950: bipush 42
    //   952: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   955: aload_0
    //   956: athrow
    //   957: astore_0
    //   958: new 707	gnu/mapping/WrongType
    //   961: dup
    //   962: aload_0
    //   963: ldc_w 780
    //   966: iconst_2
    //   967: aload 16
    //   969: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   972: athrow
    //   973: astore_0
    //   974: new 707	gnu/mapping/WrongType
    //   977: dup
    //   978: aload_0
    //   979: ldc_w 782
    //   982: iconst_1
    //   983: aload_1
    //   984: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   987: athrow
    //   988: astore_0
    //   989: new 707	gnu/mapping/WrongType
    //   992: dup
    //   993: aload_0
    //   994: ldc_w 782
    //   997: iconst_2
    //   998: aload_2
    //   999: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1002: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1003	0	paramObject1	Object
    //   0	1003	1	paramObject2	Object
    //   0	1003	2	paramObject3	Object
    //   0	1003	3	paramObject4	Object
    //   0	1003	4	paramArrayOfObject	Object[]
    //   494	40	5	i	int
    //   581	59	6	j	int
    //   158	263	7	bool	boolean
    //   7	467	8	localframe88	frame88
    //   21	364	9	localLList	LList
    //   56	325	10	localApplyToArgs	ApplyToArgs
    //   66	317	11	localObject1	Object
    //   76	311	12	localObject2	Object
    //   86	500	13	localObject3	Object
    //   91	497	14	localObject4	Object
    //   143	447	15	localObject5	Object
    //   192	776	16	localObject6	Object
    //   197	370	17	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	673	gnu/mapping/UnboundLocationException
    //   62	68	687	gnu/mapping/UnboundLocationException
    //   82	88	701	gnu/mapping/UnboundLocationException
    //   97	102	716	gnu/mapping/UnboundLocationException
    //   134	140	731	gnu/mapping/UnboundLocationException
    //   149	154	746	gnu/mapping/UnboundLocationException
    //   169	174	761	gnu/mapping/UnboundLocationException
    //   199	206	776	gnu/mapping/UnboundLocationException
    //   241	248	791	gnu/mapping/UnboundLocationException
    //   253	260	806	gnu/mapping/UnboundLocationException
    //   289	294	821	java/lang/ClassCastException
    //   312	319	836	gnu/mapping/UnboundLocationException
    //   339	345	851	gnu/mapping/UnboundLocationException
    //   449	456	866	gnu/mapping/UnboundLocationException
    //   480	487	881	java/lang/ClassCastException
    //   487	496	897	java/lang/ClassCastException
    //   526	533	912	gnu/mapping/UnboundLocationException
    //   540	546	927	java/lang/ClassCastException
    //   556	563	942	gnu/mapping/UnboundLocationException
    //   573	583	957	java/lang/ClassCastException
    //   622	628	973	java/lang/ClassCastException
    //   628	637	988	java/lang/ClassCastException
  }
  
  public static Object stringMap$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame4 localframe4 = new frame4();
    localframe4.proc = paramObject1;
    localframe4.s = paramObject2;
    localframe4.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe4.proc, string$Mnmap$Ex);
      return call_with_values.callWithValues(localframe4.lambda$Fn11, localframe4.lambda$Fn12);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 285, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringMap$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame3 localframe3 = new frame3();
    localframe3.proc = paramObject1;
    localframe3.s = paramObject2;
    localframe3.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, misc.procedure$Qu, localframe3.proc, string$Mnmap);
      return call_with_values.callWithValues(localframe3.lambda$Fn9, localframe3.lambda$Fn10);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 271, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public static Object stringPad$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame72 localframe72 = new frame72();
    localframe72.s = paramObject1;
    localframe72.n = paramObject2;
    paramObject2 = LList.makeList(paramArrayOfObject, 0);
    paramArrayOfObject = Scheme.applyToArgs;
    for (paramObject1 = loc$let$Mnoptionals$St;; paramObject1 = Boolean.FALSE)
    {
      try
      {
        localObject1 = ((Location)paramObject1).get();
        localApplyToArgs = Scheme.applyToArgs;
        localObject2 = Invoke.make;
        LangPrimType localLangPrimType = LangPrimType.charType;
        Char localChar = Lit12;
        if (characters.isChar(LangPrimType.charType))
        {
          paramObject1 = Boolean.TRUE;
          paramObject1 = ((Procedure)localObject2).apply3(localLangPrimType, localChar, paramObject1);
          localObject2 = loc$rest;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        Object localObject1;
        ApplyToArgs localApplyToArgs;
        Object localObject2;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1057, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject2 = ((Location)localObject2).get();
        return paramArrayOfObject.apply4(localObject1, paramObject2, localApplyToArgs.apply2(paramObject1, localObject2), call_with_values.callWithValues(localframe72.lambda$Fn164, localframe72.lambda$Fn165));
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1057, 63);
        throw ((Throwable)paramObject1);
      }
    }
  }
  
  public static Object stringPadRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame71 localframe71 = new frame71();
    localframe71.s = paramObject1;
    localframe71.n = paramObject2;
    paramObject2 = LList.makeList(paramArrayOfObject, 0);
    paramArrayOfObject = Scheme.applyToArgs;
    for (paramObject1 = loc$let$Mnoptionals$St;; paramObject1 = Boolean.FALSE)
    {
      try
      {
        localObject1 = ((Location)paramObject1).get();
        localApplyToArgs = Scheme.applyToArgs;
        localObject2 = Invoke.make;
        LangPrimType localLangPrimType = LangPrimType.charType;
        Char localChar = Lit12;
        if (characters.isChar(LangPrimType.charType))
        {
          paramObject1 = Boolean.TRUE;
          paramObject1 = ((Procedure)localObject2).apply3(localLangPrimType, localChar, paramObject1);
          localObject2 = loc$rest;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        Object localObject1;
        ApplyToArgs localApplyToArgs;
        Object localObject2;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1045, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject2 = ((Location)localObject2).get();
        return paramArrayOfObject.apply4(localObject1, paramObject2, localApplyToArgs.apply2(paramObject1, localObject2), call_with_values.callWithValues(localframe71.lambda$Fn161, localframe71.lambda$Fn162));
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1045, 63);
        throw ((Throwable)paramObject1);
      }
    }
  }
  
  public static Object stringParseFinalStart$PlEnd(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame0 localframe0 = new frame0();
    localframe0.proc = paramObject1;
    localframe0.s = paramObject2;
    localframe0.args = paramObject3;
    return call_with_values.callWithValues(localframe0.lambda$Fn3, localframe0.lambda$Fn4);
  }
  
  public static Object stringParseStart$PlEnd(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame localframe = new frame();
    localframe.proc = paramObject1;
    localframe.s = paramObject2;
    if (!strings.isString(localframe.s)) {
      misc.error$V("Non-string value", new Object[] { localframe.proc, localframe.s });
    }
    paramObject1 = localframe.s;
    try
    {
      paramObject2 = (CharSequence)paramObject1;
      localframe.slen = strings.stringLength((CharSequence)paramObject2);
      if (lists.isPair(paramObject3))
      {
        paramObject1 = lists.car.apply1(paramObject3);
        localframe.args = lists.cdr.apply1(paramObject3);
        localframe.start = paramObject1;
        boolean bool = numbers.isInteger(localframe.start);
        if (bool)
        {
          bool = numbers.isExact(localframe.start);
          if (bool) {
            if (Scheme.numGEq.apply2(localframe.start, Lit0) == Boolean.FALSE) {
              break label176;
            }
          }
        }
        for (;;)
        {
          return call_with_values.callWithValues(localframe.lambda$Fn1, localframe.lambda$Fn2);
          if (!bool) {
            label176:
            do
            {
              return misc.error$V("Illegal substring START spec", new Object[] { localframe.proc, localframe.start, localframe.s });
            } while (!bool);
          }
        }
      }
      return misc.values(new Object[] { LList.Empty, Lit0, Integer.valueOf(localframe.slen) });
    }
    catch (ClassCastException paramObject2)
    {
      throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
    }
  }
  
  public static Object stringPrefixLength$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame11 localframe11 = new frame11();
    localframe11.s1 = paramObject1;
    localframe11.s2 = paramObject2;
    localframe11.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe11.lambda$Fn28, localframe11.lambda$Fn29);
  }
  
  public static Object stringPrefixLengthCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame15 localframe15 = new frame15();
    localframe15.s1 = paramObject1;
    localframe15.s2 = paramObject2;
    localframe15.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe15.lambda$Fn36, localframe15.lambda$Fn37);
  }
  
  public static Object stringReplace$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame92 localframe92 = new frame92();
    localframe92.s1 = paramObject1;
    localframe92.s2 = paramObject2;
    localframe92.start1 = paramObject3;
    localframe92.end1 = paramObject4;
    localframe92.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    checkSubstringSpec(string$Mnreplace, localframe92.s1, localframe92.start1, localframe92.end1);
    return call_with_values.callWithValues(localframe92.lambda$Fn206, localframe92.lambda$Fn207);
  }
  
  public static Object stringReverse$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame90 localframe90 = new frame90();
    localframe90.s = paramObject;
    localframe90.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe90.lambda$Fn202, localframe90.lambda$Fn203);
  }
  
  public static Object stringReverse$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame89 localframe89 = new frame89();
    localframe89.s = paramObject;
    localframe89.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe89.lambda$Fn200, localframe89.lambda$Fn201);
  }
  
  public static Object stringSkip$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame79 localframe79 = new frame79();
    localframe79.str = paramObject1;
    localframe79.criterion = paramObject2;
    localframe79.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe79.lambda$Fn181, localframe79.lambda$Fn182);
  }
  
  public static Object stringSkipRight$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame80 localframe80 = new frame80();
    localframe80.str = paramObject1;
    localframe80.criterion = paramObject2;
    localframe80.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe80.lambda$Fn183, localframe80.lambda$Fn184);
  }
  
  public static Object stringSuffixLength$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame13 localframe13 = new frame13();
    localframe13.s1 = paramObject1;
    localframe13.s2 = paramObject2;
    localframe13.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe13.lambda$Fn32, localframe13.lambda$Fn33);
  }
  
  public static Object stringSuffixLengthCi$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame17 localframe17 = new frame17();
    localframe17.s1 = paramObject1;
    localframe17.s2 = paramObject2;
    localframe17.maybe$Mnstarts$Plends = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe17.lambda$Fn40, localframe17.lambda$Fn41);
  }
  
  /* Error */
  public static CharSequence stringTabulate(Object paramObject, int paramInt)
  {
    // Byte code:
    //   0: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3: astore_3
    //   4: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   14: astore 4
    //   16: aload_3
    //   17: aload 4
    //   19: getstatic 2267	kawa/lib/misc:procedure$Qu	Lgnu/expr/ModuleMethod;
    //   22: aload_0
    //   23: getstatic 1685	gnu/kawa/slib/srfi13:string$Mntabulate	Lgnu/expr/ModuleMethod;
    //   26: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: pop
    //   30: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   33: astore_3
    //   34: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   44: astore 4
    //   46: aload_3
    //   47: aload 4
    //   49: getstatic 1683	gnu/kawa/slib/srfi13:lambda$Fn27	Lgnu/expr/ModuleMethod;
    //   52: iload_1
    //   53: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: getstatic 1685	gnu/kawa/slib/srfi13:string$Mntabulate	Lgnu/expr/ModuleMethod;
    //   59: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: iload_1
    //   64: invokestatic 679	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   67: astore_3
    //   68: iload_1
    //   69: iconst_1
    //   70: isub
    //   71: istore_1
    //   72: iload_1
    //   73: iflt +104 -> 177
    //   76: aload_3
    //   77: checkcast 826	gnu/lists/CharSeq
    //   80: astore 5
    //   82: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   85: aload_0
    //   86: iload_1
    //   87: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore 4
    //   95: aload 4
    //   97: checkcast 753	gnu/text/Char
    //   100: invokevirtual 868	gnu/text/Char:charValue	()C
    //   103: istore_2
    //   104: aload 5
    //   106: iload_1
    //   107: iload_2
    //   108: invokestatic 830	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   111: iload_1
    //   112: iconst_1
    //   113: isub
    //   114: istore_1
    //   115: goto -43 -> 72
    //   118: astore_0
    //   119: aload_0
    //   120: ldc_w 920
    //   123: sipush 534
    //   126: iconst_3
    //   127: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   130: aload_0
    //   131: athrow
    //   132: astore_0
    //   133: aload_0
    //   134: ldc_w 920
    //   137: sipush 535
    //   140: iconst_3
    //   141: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: new 707	gnu/mapping/WrongType
    //   150: dup
    //   151: aload_0
    //   152: ldc_w 832
    //   155: iconst_1
    //   156: aload_3
    //   157: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   160: athrow
    //   161: astore_0
    //   162: new 707	gnu/mapping/WrongType
    //   165: dup
    //   166: aload_0
    //   167: ldc_w 832
    //   170: iconst_3
    //   171: aload 4
    //   173: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: aload_3
    //   178: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramObject	Object
    //   0	179	1	paramInt	int
    //   103	5	2	c	char
    //   3	175	3	localObject1	Object
    //   7	165	4	localObject2	Object
    //   80	25	5	localCharSeq	CharSeq
    // Exception table:
    //   from	to	target	type
    //   9	16	118	gnu/mapping/UnboundLocationException
    //   39	46	132	gnu/mapping/UnboundLocationException
    //   76	82	146	java/lang/ClassCastException
    //   95	104	161	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTake(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 192	gnu/kawa/slib/srfi13$frame64
    //   3: dup
    //   4: invokespecial 2791	gnu/kawa/slib/srfi13$frame64:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 2792	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_1
    //   15: putfield 2793	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   18: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   21: astore_0
    //   22: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   30: astore_1
    //   31: aload_0
    //   32: aload_1
    //   33: getstatic 2796	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   36: aload_3
    //   37: getfield 2792	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   40: getstatic 1848	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   43: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   50: astore_0
    //   51: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: aload_3
    //   63: getfield 2799	gnu/kawa/slib/srfi13$frame64:lambda$Fn151	Lgnu/expr/ModuleMethod;
    //   66: aload_3
    //   67: getfield 2793	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   70: getstatic 1848	gnu/kawa/slib/srfi13:string$Mntake	Lgnu/expr/ModuleMethod;
    //   73: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload_3
    //   78: getfield 2792	gnu/kawa/slib/srfi13$frame64:s	Ljava/lang/Object;
    //   81: astore_0
    //   82: aload_0
    //   83: checkcast 681	java/lang/CharSequence
    //   86: astore_1
    //   87: aload_3
    //   88: getfield 2793	gnu/kawa/slib/srfi13$frame64:n	Ljava/lang/Object;
    //   91: astore_0
    //   92: aload_0
    //   93: checkcast 671	java/lang/Number
    //   96: invokevirtual 675	java/lang/Number:intValue	()I
    //   99: istore_2
    //   100: aload_1
    //   101: iconst_0
    //   102: iload_2
    //   103: invokestatic 2401	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: ldc_w 920
    //   112: sipush 995
    //   115: iconst_3
    //   116: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: ldc_w 920
    //   126: sipush 996
    //   129: iconst_3
    //   130: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: new 707	gnu/mapping/WrongType
    //   139: dup
    //   140: aload_1
    //   141: ldc_w 1330
    //   144: iconst_0
    //   145: aload_0
    //   146: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: astore_1
    //   151: new 707	gnu/mapping/WrongType
    //   154: dup
    //   155: aload_1
    //   156: ldc_w 1330
    //   159: iconst_2
    //   160: aload_0
    //   161: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramObject1	Object
    //   0	165	1	paramObject2	Object
    //   99	4	2	i	int
    //   7	81	3	localframe64	frame64
    // Exception table:
    //   from	to	target	type
    //   26	31	107	gnu/mapping/UnboundLocationException
    //   55	60	121	gnu/mapping/UnboundLocationException
    //   82	87	135	java/lang/ClassCastException
    //   92	100	150	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object stringTakeRight(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 195	gnu/kawa/slib/srfi13$frame65
    //   3: dup
    //   4: invokespecial 2801	gnu/kawa/slib/srfi13$frame65:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: putfield 2802	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   13: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   16: astore_1
    //   17: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   27: astore 4
    //   29: aload_1
    //   30: aload 4
    //   32: getstatic 2796	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   35: aload_0
    //   36: getstatic 1850	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   39: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: aload_0
    //   44: checkcast 681	java/lang/CharSequence
    //   47: astore_1
    //   48: aload_3
    //   49: aload_1
    //   50: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   53: putfield 2803	gnu/kawa/slib/srfi13$frame65:len	I
    //   56: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   59: astore_1
    //   60: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   70: astore 4
    //   72: aload_1
    //   73: aload 4
    //   75: aload_3
    //   76: getfield 2806	gnu/kawa/slib/srfi13$frame65:lambda$Fn152	Lgnu/expr/ModuleMethod;
    //   79: aload_3
    //   80: getfield 2802	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   83: getstatic 1850	gnu/kawa/slib/srfi13:string$Mntake$Mnright	Lgnu/expr/ModuleMethod;
    //   86: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: checkcast 681	java/lang/CharSequence
    //   94: astore_1
    //   95: getstatic 705	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   98: aload_3
    //   99: getfield 2803	gnu/kawa/slib/srfi13$frame65:len	I
    //   102: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aload_3
    //   106: getfield 2802	gnu/kawa/slib/srfi13$frame65:n	Ljava/lang/Object;
    //   109: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: astore_0
    //   113: aload_0
    //   114: checkcast 671	java/lang/Number
    //   117: invokevirtual 675	java/lang/Number:intValue	()I
    //   120: istore_2
    //   121: aload_1
    //   122: iload_2
    //   123: aload_3
    //   124: getfield 2803	gnu/kawa/slib/srfi13$frame65:len	I
    //   127: invokestatic 2401	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   130: areturn
    //   131: astore_0
    //   132: aload_0
    //   133: ldc_w 920
    //   136: sipush 1002
    //   139: iconst_3
    //   140: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   143: aload_0
    //   144: athrow
    //   145: astore_1
    //   146: new 707	gnu/mapping/WrongType
    //   149: dup
    //   150: aload_1
    //   151: ldc_w 717
    //   154: iconst_1
    //   155: aload_0
    //   156: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: astore_0
    //   161: aload_0
    //   162: ldc_w 920
    //   165: sipush 1004
    //   168: iconst_5
    //   169: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   172: aload_0
    //   173: athrow
    //   174: astore_1
    //   175: new 707	gnu/mapping/WrongType
    //   178: dup
    //   179: aload_1
    //   180: ldc_w 1330
    //   183: iconst_0
    //   184: aload_0
    //   185: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: astore_1
    //   190: new 707	gnu/mapping/WrongType
    //   193: dup
    //   194: aload_1
    //   195: ldc_w 1330
    //   198: iconst_1
    //   199: aload_0
    //   200: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramObject1	Object
    //   0	204	1	paramObject2	Object
    //   120	3	2	i	int
    //   7	117	3	localframe65	frame65
    //   20	54	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	29	131	gnu/mapping/UnboundLocationException
    //   43	48	145	java/lang/ClassCastException
    //   65	72	160	gnu/mapping/UnboundLocationException
    //   90	95	174	java/lang/ClassCastException
    //   113	121	189	java/lang/ClassCastException
  }
  
  public static Object stringTitlecase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame62 localframe62 = new frame62();
    localframe62.s = paramObject;
    localframe62.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe62.lambda$Fn147, localframe62.lambda$Fn148);
  }
  
  public static Object stringTitlecase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame63 localframe63 = new frame63();
    localframe63.s = paramObject;
    localframe63.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe63.lambda$Fn149, localframe63.lambda$Fn150);
  }
  
  /* Error */
  public static Object stringTokenize$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 288	gnu/kawa/slib/srfi13$frame93
    //   3: dup
    //   4: invokespecial 2828	gnu/kawa/slib/srfi13$frame93:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2829	gnu/kawa/slib/srfi13$frame93:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_0
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore_1
    //   23: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   31: astore_3
    //   32: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   35: astore 4
    //   37: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   40: astore 5
    //   42: getstatic 1601	gnu/kawa/slib/srfi13:loc$token$Mnchars	Lgnu/mapping/Location;
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 6
    //   54: getstatic 2835	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   57: astore 7
    //   59: getstatic 1585	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   62: astore 8
    //   64: aload 8
    //   66: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   69: astore 8
    //   71: aload 7
    //   73: aload 8
    //   75: getstatic 1527	gnu/kawa/slib/srfi13:Lit14	Lgnu/mapping/SimpleSymbol;
    //   78: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 7
    //   83: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   86: astore 8
    //   88: getstatic 1575	gnu/kawa/slib/srfi13:loc$char$Mnset$Qu	Lgnu/mapping/Location;
    //   91: astore 9
    //   93: aload 9
    //   95: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   98: astore 9
    //   100: getstatic 1601	gnu/kawa/slib/srfi13:loc$token$Mnchars	Lgnu/mapping/Location;
    //   103: astore 10
    //   105: aload 10
    //   107: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   110: astore 10
    //   112: aload 5
    //   114: aload 6
    //   116: aload 7
    //   118: aload 8
    //   120: aload 9
    //   122: aload 10
    //   124: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: invokevirtual 761	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: astore 5
    //   132: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   135: astore 6
    //   137: aload 6
    //   139: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   142: astore 6
    //   144: aload_1
    //   145: aload_3
    //   146: aload_0
    //   147: aload 4
    //   149: aload 5
    //   151: aload 6
    //   153: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: aload_2
    //   157: getfield 2838	gnu/kawa/slib/srfi13$frame93:lambda$Fn208	Lgnu/expr/ModuleMethod;
    //   160: aload_2
    //   161: getfield 2841	gnu/kawa/slib/srfi13$frame93:lambda$Fn209	Lgnu/expr/ModuleMethod;
    //   164: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   167: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: ldc_w 920
    //   176: sipush 1694
    //   179: iconst_3
    //   180: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: aload_0
    //   187: ldc_w 920
    //   190: sipush 1695
    //   193: bipush 20
    //   195: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   198: aload_0
    //   199: athrow
    //   200: astore_0
    //   201: aload_0
    //   202: ldc_w 920
    //   205: sipush 1695
    //   208: bipush 33
    //   210: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   213: aload_0
    //   214: athrow
    //   215: astore_0
    //   216: aload_0
    //   217: ldc_w 920
    //   220: sipush 1695
    //   223: bipush 50
    //   225: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   228: aload_0
    //   229: athrow
    //   230: astore_0
    //   231: aload_0
    //   232: ldc_w 920
    //   235: sipush 1695
    //   238: bipush 61
    //   240: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   243: aload_0
    //   244: athrow
    //   245: astore_0
    //   246: aload_0
    //   247: ldc_w 920
    //   250: sipush 1695
    //   253: bipush 75
    //   255: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   258: aload_0
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramObject	Object
    //   0	260	1	paramArrayOfObject	Object[]
    //   7	154	2	localframe93	frame93
    //   26	120	3	localObject1	Object
    //   35	113	4	localApplyToArgs	ApplyToArgs
    //   40	110	5	localObject2	Object
    //   45	107	6	localObject3	Object
    //   57	60	7	localObject4	Object
    //   62	57	8	localObject5	Object
    //   91	30	9	localObject6	Object
    //   103	20	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	171	gnu/mapping/UnboundLocationException
    //   47	54	185	gnu/mapping/UnboundLocationException
    //   64	71	200	gnu/mapping/UnboundLocationException
    //   93	100	215	gnu/mapping/UnboundLocationException
    //   105	112	230	gnu/mapping/UnboundLocationException
    //   137	144	245	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrim$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 204	gnu/kawa/slib/srfi13$frame68
    //   3: dup
    //   4: invokespecial 2843	gnu/kawa/slib/srfi13$frame68:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2844	gnu/kawa/slib/srfi13$frame68:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_0
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore_1
    //   23: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   31: astore_3
    //   32: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   35: astore 4
    //   37: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   40: astore 5
    //   42: getstatic 1583	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 6
    //   54: getstatic 2835	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   57: astore 7
    //   59: getstatic 1585	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   62: astore 8
    //   64: aload 8
    //   66: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   69: astore 8
    //   71: aload 5
    //   73: aload 6
    //   75: aload 7
    //   77: aload 8
    //   79: getstatic 1538	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   82: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 5
    //   90: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   93: astore 6
    //   95: aload 6
    //   97: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   100: astore 6
    //   102: aload_1
    //   103: aload_3
    //   104: aload_0
    //   105: aload 4
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: aload_2
    //   115: getfield 2847	gnu/kawa/slib/srfi13$frame68:lambda$Fn155	Lgnu/expr/ModuleMethod;
    //   118: aload_2
    //   119: getfield 2850	gnu/kawa/slib/srfi13$frame68:lambda$Fn156	Lgnu/expr/ModuleMethod;
    //   122: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   125: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: ldc_w 920
    //   134: sipush 1022
    //   137: iconst_3
    //   138: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: aload_0
    //   145: ldc_w 920
    //   148: sipush 1022
    //   151: bipush 40
    //   153: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: aload_0
    //   160: ldc_w 920
    //   163: sipush 1022
    //   166: bipush 51
    //   168: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: ldc_w 920
    //   178: sipush 1022
    //   181: bipush 72
    //   183: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   186: aload_0
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramObject	Object
    //   0	188	1	paramArrayOfObject	Object[]
    //   7	112	2	localframe68	frame68
    //   26	78	3	localObject1	Object
    //   35	71	4	localApplyToArgs	ApplyToArgs
    //   40	68	5	localObject2	Object
    //   45	65	6	localObject3	Object
    //   57	19	7	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   62	16	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	129	gnu/mapping/UnboundLocationException
    //   47	54	143	gnu/mapping/UnboundLocationException
    //   64	71	158	gnu/mapping/UnboundLocationException
    //   95	102	173	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrimBoth$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 213	gnu/kawa/slib/srfi13$frame70
    //   3: dup
    //   4: invokespecial 2852	gnu/kawa/slib/srfi13$frame70:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2853	gnu/kawa/slib/srfi13$frame70:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_0
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore_1
    //   23: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   31: astore_3
    //   32: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   35: astore 4
    //   37: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   40: astore 5
    //   42: getstatic 1583	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 6
    //   54: getstatic 2835	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   57: astore 7
    //   59: getstatic 1585	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   62: astore 8
    //   64: aload 8
    //   66: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   69: astore 8
    //   71: aload 5
    //   73: aload 6
    //   75: aload 7
    //   77: aload 8
    //   79: getstatic 1538	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   82: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 5
    //   90: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   93: astore 6
    //   95: aload 6
    //   97: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   100: astore 6
    //   102: aload_1
    //   103: aload_3
    //   104: aload_0
    //   105: aload 4
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: aload_2
    //   115: getfield 2856	gnu/kawa/slib/srfi13$frame70:lambda$Fn159	Lgnu/expr/ModuleMethod;
    //   118: aload_2
    //   119: getfield 2859	gnu/kawa/slib/srfi13$frame70:lambda$Fn160	Lgnu/expr/ModuleMethod;
    //   122: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   125: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: ldc_w 920
    //   134: sipush 1036
    //   137: iconst_3
    //   138: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: aload_0
    //   145: ldc_w 920
    //   148: sipush 1036
    //   151: bipush 40
    //   153: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: aload_0
    //   160: ldc_w 920
    //   163: sipush 1036
    //   166: bipush 51
    //   168: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: ldc_w 920
    //   178: sipush 1036
    //   181: bipush 72
    //   183: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   186: aload_0
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramObject	Object
    //   0	188	1	paramArrayOfObject	Object[]
    //   7	112	2	localframe70	frame70
    //   26	78	3	localObject1	Object
    //   35	71	4	localApplyToArgs	ApplyToArgs
    //   40	68	5	localObject2	Object
    //   45	65	6	localObject3	Object
    //   57	19	7	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   62	16	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	129	gnu/mapping/UnboundLocationException
    //   47	54	143	gnu/mapping/UnboundLocationException
    //   64	71	158	gnu/mapping/UnboundLocationException
    //   95	102	173	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object stringTrimRight$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 207	gnu/kawa/slib/srfi13$frame69
    //   3: dup
    //   4: invokespecial 2861	gnu/kawa/slib/srfi13$frame69:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 2862	gnu/kawa/slib/srfi13$frame69:s	Ljava/lang/Object;
    //   13: aload_1
    //   14: iconst_0
    //   15: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore_0
    //   19: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   22: astore_1
    //   23: getstatic 1569	gnu/kawa/slib/srfi13:loc$let$Mnoptionals$St	Lgnu/mapping/Location;
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   31: astore_3
    //   32: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   35: astore 4
    //   37: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   40: astore 5
    //   42: getstatic 1583	gnu/kawa/slib/srfi13:loc$criterion	Lgnu/mapping/Location;
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   52: astore 6
    //   54: getstatic 2835	gnu/kawa/functions/GetNamedPart:getNamedPart	Lgnu/kawa/functions/GetNamedPart;
    //   57: astore 7
    //   59: getstatic 1585	gnu/kawa/slib/srfi13:loc$char$Mnset	Lgnu/mapping/Location;
    //   62: astore 8
    //   64: aload 8
    //   66: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   69: astore 8
    //   71: aload 5
    //   73: aload 6
    //   75: aload 7
    //   77: aload 8
    //   79: getstatic 1538	gnu/kawa/slib/srfi13:Lit11	Lgnu/mapping/SimpleSymbol;
    //   82: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 5
    //   90: getstatic 1581	gnu/kawa/slib/srfi13:loc$rest	Lgnu/mapping/Location;
    //   93: astore 6
    //   95: aload 6
    //   97: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   100: astore 6
    //   102: aload_1
    //   103: aload_3
    //   104: aload_0
    //   105: aload 4
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 669	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: aload_2
    //   115: getfield 2865	gnu/kawa/slib/srfi13$frame69:lambda$Fn157	Lgnu/expr/ModuleMethod;
    //   118: aload_2
    //   119: getfield 2868	gnu/kawa/slib/srfi13$frame69:lambda$Fn158	Lgnu/expr/ModuleMethod;
    //   122: invokestatic 1993	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   125: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: ldc_w 920
    //   134: sipush 1029
    //   137: iconst_3
    //   138: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: aload_0
    //   145: ldc_w 920
    //   148: sipush 1029
    //   151: bipush 40
    //   153: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: aload_0
    //   160: ldc_w 920
    //   163: sipush 1029
    //   166: bipush 51
    //   168: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: ldc_w 920
    //   178: sipush 1029
    //   181: bipush 72
    //   183: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   186: aload_0
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramObject	Object
    //   0	188	1	paramArrayOfObject	Object[]
    //   7	112	2	localframe69	frame69
    //   26	78	3	localObject1	Object
    //   35	71	4	localApplyToArgs	ApplyToArgs
    //   40	68	5	localObject2	Object
    //   45	65	6	localObject3	Object
    //   57	19	7	localGetNamedPart	gnu.kawa.functions.GetNamedPart
    //   62	16	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   27	32	129	gnu/mapping/UnboundLocationException
    //   47	54	143	gnu/mapping/UnboundLocationException
    //   64	71	158	gnu/mapping/UnboundLocationException
    //   95	102	173	gnu/mapping/UnboundLocationException
  }
  
  public static Object stringUnfold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    paramArrayOfObject = Scheme.applyToArgs;
    localObject1 = loc$check$Mnarg;
    for (;;)
    {
      try
      {
        localObject1 = ((Location)localObject1).get();
        paramArrayOfObject.apply4(localObject1, misc.procedure$Qu, paramObject1, string$Mnunfold);
        paramArrayOfObject = Scheme.applyToArgs;
        localObject1 = loc$check$Mnarg;
      }
      catch (UnboundLocationException paramObject1)
      {
        try
        {
          Object localObject2;
          Object localObject6;
          int i;
          int k;
          char c;
          paramObject1 = ((Location)paramObject1).get();
        }
        catch (UnboundLocationException paramObject1)
        {
          ApplyToArgs localApplyToArgs;
          Object localObject4;
          Object localObject3;
          Object localObject5;
          int j;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 416, 29);
          throw ((Throwable)paramObject1);
        }
        try
        {
          paramObject3 = (CharSequence)paramObject1;
          $PcStringCopy$Ex((CharSequence)paramObject2, 0, (CharSequence)paramObject3, 0, j);
          return localApplyToArgs.apply4(localObject4, localLList, localObject5, paramObject2);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 2, paramObject1);
        }
        paramObject1 = paramObject1;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 372, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = ((Location)localObject1).get();
        paramArrayOfObject.apply4(localObject1, misc.procedure$Qu, paramObject2, string$Mnunfold);
        paramArrayOfObject = Scheme.applyToArgs;
        localObject1 = loc$check$Mnarg;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 373, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = ((Location)localObject1).get();
        paramArrayOfObject.apply4(localObject1, misc.procedure$Qu, paramObject3, string$Mnunfold);
        localApplyToArgs = Scheme.applyToArgs;
        paramArrayOfObject = loc$let$Mnoptionals$St;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 374, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject4 = paramArrayOfObject.get();
        localObject1 = Scheme.applyToArgs;
        localObject2 = Scheme.applyToArgs;
        paramArrayOfObject = loc$base;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 375, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject3 = paramArrayOfObject.get();
        paramArrayOfObject = loc$base;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 376, 20);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (strings.isString(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject2 = ((Procedure)localObject2).apply3(localObject3, "", paramArrayOfObject);
          localObject3 = Scheme.applyToArgs;
          paramArrayOfObject = loc$make$Mnfinal;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 376, 57);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject5 = paramArrayOfObject.get();
        localObject6 = lambda$Fn17;
        paramArrayOfObject = loc$make$Mnfinal;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 377, 6);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (misc.isProcedure(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject5 = ((Procedure)localObject1).apply2(localObject2, ((Procedure)localObject3).apply3(localObject5, localObject6, paramArrayOfObject));
          localObject2 = LList.Empty;
          i = 0;
          localObject1 = strings.makeString(40);
          j = 40;
          k = 0;
          paramArrayOfObject = (Object[])paramObject4;
          paramObject4 = localObject2;
          localObject3 = Integer.valueOf(k);
          localObject2 = paramArrayOfObject;
          paramArrayOfObject = (Object[])localObject3;
          if (Scheme.applyToArgs.apply2(paramObject1, localObject2) != Boolean.FALSE) {
            continue;
          }
          localObject3 = Scheme.applyToArgs.apply2(paramObject2, localObject2);
          localObject2 = Scheme.applyToArgs.apply2(paramObject3, localObject2);
          if (Scheme.numLss.apply2(paramArrayOfObject, Integer.valueOf(j)) == Boolean.FALSE) {
            continue;
          }
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 377, 46);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject6 = (CharSeq)localObject1;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject1);
      }
      try
      {
        k = ((Number)paramArrayOfObject).intValue();
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramArrayOfObject);
      }
      try
      {
        c = ((Char)localObject3).charValue();
        strings.stringSet$Ex((CharSeq)localObject6, k, c);
        paramArrayOfObject = AddOp.$Pl.apply2(paramArrayOfObject, Lit1);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject3);
      }
      paramArrayOfObject = Boolean.FALSE;
      continue;
      paramArrayOfObject = Boolean.FALSE;
      continue;
      paramArrayOfObject = numbers.min(new Object[] { Lit2, Integer.valueOf(j + i) });
      try
      {
        k = ((Number)paramArrayOfObject).intValue();
        paramArrayOfObject = strings.makeString(k);
      }
      catch (ClassCastException paramObject1)
      {
        int m;
        throw new WrongType((ClassCastException)paramObject1, "chunk-len2", -2, paramArrayOfObject);
      }
      try
      {
        localObject6 = (CharSeq)paramArrayOfObject;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, paramArrayOfObject);
      }
      try
      {
        c = ((Char)localObject3).charValue();
        strings.stringSet$Ex((CharSeq)localObject6, 0, c);
        paramObject4 = lists.cons(localObject1, paramObject4);
        i += j;
        m = 1;
        j = k;
        localObject1 = paramArrayOfObject;
        k = m;
        paramArrayOfObject = (Object[])localObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject3);
      }
    }
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$make$Mnfinal;
    for (;;)
    {
      try
      {
        paramObject2 = ((Location)paramObject2).get();
        paramObject1 = ((Procedure)paramObject1).apply2(paramObject2, localObject2);
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 400, 20);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramObject2 = (CharSequence)paramObject1;
        k = strings.stringLength((CharSequence)paramObject2);
        paramObject2 = loc$base;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
      }
      try
      {
        paramObject2 = ((Location)paramObject2).get();
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 402, 38);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject2;
        j = strings.stringLength((CharSequence)paramObject3);
        paramObject2 = AddOp.$Pl.apply2(Integer.valueOf(j + i), paramArrayOfObject);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        paramObject2 = strings.makeString(i + k);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "j", -2, paramObject2);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject1;
        $PcStringCopy$Ex((CharSequence)paramObject2, i, (CharSequence)paramObject3, 0, k);
        paramObject1 = AddOp.$Mn.apply2(Integer.valueOf(i), paramArrayOfObject);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 2, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "j", -2, paramObject1);
      }
      try
      {
        paramObject1 = (CharSequence)localObject1;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, localObject1);
      }
      try
      {
        k = ((Number)paramArrayOfObject).intValue();
        $PcStringCopy$Ex((CharSequence)paramObject2, i, (CharSequence)paramObject1, 0, k);
        paramObject1 = Integer.valueOf(i);
        if (lists.isPair(paramObject4))
        {
          paramObject3 = lists.car.apply1(paramObject4);
          paramObject4 = lists.cdr.apply1(paramObject4);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 4, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = (CharSequence)paramObject3;
        i = strings.stringLength(paramArrayOfObject);
        paramObject1 = AddOp.$Mn.apply2(paramObject1, Integer.valueOf(i));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject3);
      }
      try
      {
        k = ((Number)paramObject1).intValue();
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 1, paramObject1);
      }
      try
      {
        paramArrayOfObject = (CharSequence)paramObject3;
        $PcStringCopy$Ex((CharSequence)paramObject2, k, paramArrayOfObject, 0, i);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, paramObject3);
      }
    }
    paramObject1 = loc$base;
  }
  
  public static Object stringUnfoldRight$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    localLList = LList.makeList(paramArrayOfObject, 0);
    localApplyToArgs = Scheme.applyToArgs;
    paramArrayOfObject = loc$let$Mnoptionals$St;
    for (;;)
    {
      try
      {
        localObject7 = paramArrayOfObject.get();
        localObject1 = Scheme.applyToArgs;
        localObject2 = Scheme.applyToArgs;
        paramArrayOfObject = loc$base;
      }
      catch (UnboundLocationException paramObject1)
      {
        try
        {
          Object localObject4;
          char c;
          paramObject2 = ((Location)paramObject2).get();
          paramObject1 = ((Procedure)paramObject1).apply2(paramObject2, localObject4);
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject7;
          Object localObject3;
          Object localObject5;
          Object localObject8;
          Object localObject9;
          int i;
          Object localObject6;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 447, 20);
          throw ((Throwable)paramObject1);
        }
        try
        {
          paramObject2 = (CharSequence)paramObject1;
          j = strings.stringLength((CharSequence)paramObject2);
          paramObject2 = loc$base;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
        }
        try
        {
          paramObject2 = ((Location)paramObject2).get();
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 449, 31);
          throw ((Throwable)paramObject1);
        }
        try
        {
          paramObject3 = (CharSequence)paramObject2;
          i = strings.stringLength((CharSequence)paramObject3);
          paramObject3 = AddOp.$Mn.apply2(localObject2, paramArrayOfObject);
          paramObject2 = AddOp.$Pl.apply2(AddOp.$Pl.apply2(Integer.valueOf(i), localObject3), paramObject3);
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Integer.valueOf(j));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
        }
        try
        {
          k = ((Number)paramObject2).intValue();
          paramObject2 = strings.makeString(k);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, paramObject2);
        }
        try
        {
          localObject3 = (CharSequence)paramObject1;
          $PcStringCopy$Ex((CharSequence)paramObject2, 0, (CharSequence)localObject3, 0, j);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 2, paramObject1);
        }
        try
        {
          paramObject1 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, localObject1);
        }
        try
        {
          k = ((Number)paramArrayOfObject).intValue();
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 3, paramArrayOfObject);
        }
        try
        {
          m = ((Number)localObject2).intValue();
          $PcStringCopy$Ex((CharSequence)paramObject2, j, (CharSequence)paramObject1, k, m);
          paramObject1 = AddOp.$Pl.apply2(Integer.valueOf(j), paramObject3);
          if (lists.isPair(paramObject4))
          {
            paramObject3 = lists.car.apply1(paramObject4);
            paramObject4 = lists.cdr.apply1(paramObject4);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 4, localObject2);
        }
        try
        {
          paramArrayOfObject = (CharSequence)paramObject3;
          j = strings.stringLength(paramArrayOfObject);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject3);
        }
        try
        {
          k = ((Number)paramObject1).intValue();
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 1, paramObject1);
        }
        try
        {
          paramArrayOfObject = (CharSequence)paramObject3;
          $PcStringCopy$Ex((CharSequence)paramObject2, k, paramArrayOfObject, 0, j);
          paramObject1 = AddOp.$Pl.apply2(paramObject1, Integer.valueOf(j));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, paramObject3);
        }
        try
        {
          j = ((Number)paramObject1).intValue();
          paramObject1 = loc$base;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 1, paramObject1);
        }
        try
        {
          paramObject1 = ((Location)paramObject1).get();
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 463, 30);
          throw ((Throwable)paramObject1);
        }
        try
        {
          paramObject3 = (CharSequence)paramObject1;
          $PcStringCopy$Ex((CharSequence)paramObject2, j, (CharSequence)paramObject3, 0, i);
          return localApplyToArgs.apply4(localObject7, localLList, localObject8, paramObject2);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 2, paramObject1);
        }
        paramObject1 = paramObject1;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 420, 3);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject3 = paramArrayOfObject.get();
        paramArrayOfObject = loc$base;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 421, 20);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (strings.isString(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject2 = ((Procedure)localObject2).apply3(localObject3, "", paramArrayOfObject);
          localObject3 = Scheme.applyToArgs;
          paramArrayOfObject = loc$make$Mnfinal;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 421, 57);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject4 = paramArrayOfObject.get();
        localObject5 = lambda$Fn18;
        paramArrayOfObject = loc$make$Mnfinal;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 422, 6);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramArrayOfObject = paramArrayOfObject.get();
        if (misc.isProcedure(paramArrayOfObject))
        {
          paramArrayOfObject = Boolean.TRUE;
          localObject8 = ((Procedure)localObject1).apply2(localObject2, ((Procedure)localObject3).apply3(localObject4, localObject5, paramArrayOfObject));
          localObject5 = LList.Empty;
          localObject3 = Lit0;
          localObject1 = strings.makeString(40);
          localObject2 = Lit3;
          paramArrayOfObject = Lit3;
          localObject4 = paramObject4;
          paramObject4 = localObject5;
          if (Scheme.applyToArgs.apply2(paramObject1, localObject4) != Boolean.FALSE) {
            continue;
          }
          localObject9 = Scheme.applyToArgs.apply2(paramObject2, localObject4);
          localObject4 = Scheme.applyToArgs.apply2(paramObject3, localObject4);
          if (Scheme.numGrt.apply2(paramArrayOfObject, Lit0) == Boolean.FALSE) {
            continue;
          }
          paramArrayOfObject = AddOp.$Mn.apply2(paramArrayOfObject, Lit1);
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 422, 46);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject5 = (CharSeq)localObject1;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject1);
      }
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramArrayOfObject);
      }
      try
      {
        c = ((Char)localObject9).charValue();
        strings.stringSet$Ex((CharSeq)localObject5, i, c);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject9);
      }
      paramArrayOfObject = Boolean.FALSE;
      continue;
      paramArrayOfObject = Boolean.FALSE;
      continue;
      paramArrayOfObject = AddOp.$Pl.apply2(localObject2, localObject3);
      localObject6 = numbers.min(new Object[] { Lit4, paramArrayOfObject });
      try
      {
        i = ((Number)localObject6).intValue();
        localObject5 = strings.makeString(i);
        paramArrayOfObject = AddOp.$Mn.apply2(localObject6, Lit1);
      }
      catch (ClassCastException paramObject1)
      {
        CharSeq localCharSeq;
        int j;
        int k;
        int m;
        throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject6);
      }
      try
      {
        localCharSeq = (CharSeq)localObject5;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject5);
      }
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramArrayOfObject);
      }
      try
      {
        c = ((Char)localObject9).charValue();
        strings.stringSet$Ex(localCharSeq, i, c);
        paramObject4 = lists.cons(localObject1, paramObject4);
        localObject3 = AddOp.$Pl.apply2(localObject3, localObject2);
        localObject2 = localObject6;
        localObject1 = localObject5;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject9);
      }
    }
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$make$Mnfinal;
  }
  
  public static Object stringUpcase$Ex$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame59 localframe59 = new frame59();
    localframe59.s = paramObject;
    localframe59.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe59.lambda$Fn141, localframe59.lambda$Fn142);
  }
  
  public static Object stringUpcase$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame58 localframe58 = new frame58();
    localframe58.s = paramObject;
    localframe58.maybe$Mnstart$Plend = LList.makeList(paramArrayOfObject, 0);
    return call_with_values.callWithValues(localframe58.lambda$Fn139, localframe58.lambda$Fn140);
  }
  
  public static Object stringXcopy$Ex$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame95 localframe95 = new frame95();
    localframe95.target = paramObject1;
    localframe95.tstart = paramObject2;
    localframe95.s = paramObject3;
    localframe95.sfrom = paramObject4;
    localframe95.maybe$Mnsto$Plstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, lambda$Fn216, localframe95.sfrom, string$Mnxcopy$Ex);
      return call_with_values.callWithValues(localframe95.lambda$Fn217, localframe95.lambda$Fn221);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1779, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  /* Error */
  public static Object substring$SlShared$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 12	gnu/kawa/slib/srfi13$frame1
    //   3: dup
    //   4: invokespecial 2916	gnu/kawa/slib/srfi13$frame1:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_1
    //   12: putfield 2917	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 1978	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: astore_1
    //   21: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   24: astore_2
    //   25: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   28: astore 6
    //   30: aload 6
    //   32: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_2
    //   38: aload 6
    //   40: getstatic 2796	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
    //   43: aload_0
    //   44: getstatic 1643	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   47: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_0
    //   52: checkcast 681	java/lang/CharSequence
    //   55: astore_2
    //   56: aload 5
    //   58: aload_2
    //   59: invokestatic 641	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   62: putfield 2918	gnu/kawa/slib/srfi13$frame1:slen	I
    //   65: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   68: astore_2
    //   69: getstatic 1565	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
    //   72: astore 6
    //   74: aload 6
    //   76: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   79: astore 6
    //   81: aload_2
    //   82: aload 6
    //   84: getstatic 1641	gnu/kawa/slib/srfi13:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   87: aload 5
    //   89: getfield 2917	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   92: getstatic 1643	gnu/kawa/slib/srfi13:substring$Slshared	Lgnu/expr/ModuleMethod;
    //   95: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: aload_0
    //   100: checkcast 681	java/lang/CharSequence
    //   103: astore_2
    //   104: aload 5
    //   106: getfield 2917	gnu/kawa/slib/srfi13$frame1:start	Ljava/lang/Object;
    //   109: astore_0
    //   110: aload_0
    //   111: checkcast 671	java/lang/Number
    //   114: invokevirtual 675	java/lang/Number:intValue	()I
    //   117: istore_3
    //   118: getstatic 747	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   121: astore_0
    //   122: getstatic 1567	gnu/kawa/slib/srfi13:loc$$Cloptional	Lgnu/mapping/Location;
    //   125: astore 6
    //   127: aload 6
    //   129: invokevirtual 904	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   132: astore 6
    //   134: aload_0
    //   135: aload 6
    //   137: aload_1
    //   138: aload 5
    //   140: getfield 2918	gnu/kawa/slib/srfi13$frame1:slen	I
    //   143: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aload 5
    //   148: getfield 2921	gnu/kawa/slib/srfi13$frame1:lambda$Fn6	Lgnu/expr/ModuleMethod;
    //   151: invokevirtual 2076	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: astore_0
    //   155: aload_0
    //   156: checkcast 671	java/lang/Number
    //   159: invokevirtual 675	java/lang/Number:intValue	()I
    //   162: istore 4
    //   164: aload_2
    //   165: iload_3
    //   166: iload 4
    //   168: invokestatic 2401	gnu/kawa/slib/srfi13:$PcSubstring$SlShared	(Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   171: areturn
    //   172: astore_0
    //   173: aload_0
    //   174: ldc_w 920
    //   177: sipush 221
    //   180: iconst_3
    //   181: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   184: aload_0
    //   185: athrow
    //   186: astore_1
    //   187: new 707	gnu/mapping/WrongType
    //   190: dup
    //   191: aload_1
    //   192: ldc_w 717
    //   195: iconst_1
    //   196: aload_0
    //   197: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore_0
    //   202: aload_0
    //   203: ldc_w 920
    //   206: sipush 223
    //   209: iconst_5
    //   210: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   213: aload_0
    //   214: athrow
    //   215: astore_1
    //   216: new 707	gnu/mapping/WrongType
    //   219: dup
    //   220: aload_1
    //   221: ldc_w 1330
    //   224: iconst_0
    //   225: aload_0
    //   226: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore_1
    //   231: new 707	gnu/mapping/WrongType
    //   234: dup
    //   235: aload_1
    //   236: ldc_w 1330
    //   239: iconst_1
    //   240: aload_0
    //   241: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: astore_0
    //   246: aload_0
    //   247: ldc_w 920
    //   250: sipush 226
    //   253: bipush 10
    //   255: invokevirtual 924	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   258: aload_0
    //   259: athrow
    //   260: astore_1
    //   261: new 707	gnu/mapping/WrongType
    //   264: dup
    //   265: aload_1
    //   266: ldc_w 1330
    //   269: iconst_2
    //   270: aload_0
    //   271: invokespecial 713	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramObject1	Object
    //   0	275	1	paramObject2	Object
    //   0	275	2	paramArrayOfObject	Object[]
    //   117	49	3	i	int
    //   162	5	4	j	int
    //   7	140	5	localframe1	frame1
    //   28	108	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	172	gnu/mapping/UnboundLocationException
    //   51	56	186	java/lang/ClassCastException
    //   74	81	201	gnu/mapping/UnboundLocationException
    //   99	104	215	java/lang/ClassCastException
    //   110	118	230	java/lang/ClassCastException
    //   127	134	245	gnu/mapping/UnboundLocationException
    //   155	164	260	java/lang/ClassCastException
  }
  
  public static Object xsubstring$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame94 localframe94 = new frame94();
    localframe94.s = paramObject1;
    localframe94.from = paramObject2;
    localframe94.maybe$Mnto$Plstart$Plend = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.applyToArgs;
    paramObject2 = loc$check$Mnarg;
    try
    {
      paramObject2 = ((Location)paramObject2).get();
      ((Procedure)paramObject1).apply4(paramObject2, lambda$Fn210, localframe94.from, xsubstring);
      return call_with_values.callWithValues(localframe94.lambda$Fn211, localframe94.lambda$Fn215);
    }
    catch (UnboundLocationException paramObject1)
    {
      ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1738, 3);
      throw ((Throwable)paramObject1);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 199: 
      if (frame1.lambda5(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 209: 
      return lambda17(paramObject);
    case 211: 
      return lambda18(paramObject);
    case 217: 
      if (lambda27(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 239: 
      return frame32.lambda72(paramObject);
    case 240: 
      return frame32.lambda73(paramObject);
    case 242: 
      return frame34.lambda78(paramObject);
    case 244: 
      return frame36.lambda83(paramObject);
    case 245: 
      return frame36.lambda84(paramObject);
    case 247: 
      return frame38.lambda89(paramObject);
    case 248: 
      return frame38.lambda90(paramObject);
    case 250: 
      return frame40.lambda95(paramObject);
    case 252: 
      return frame42.lambda100(paramObject);
    case 254: 
      return frame44.lambda105(paramObject);
    case 255: 
      return frame44.lambda106(paramObject);
    case 257: 
      return frame46.lambda111(paramObject);
    case 259: 
      return frame48.lambda116(paramObject);
    case 260: 
      return frame48.lambda117(paramObject);
    case 262: 
      return frame50.lambda122(paramObject);
    case 263: 
      return frame50.lambda123(paramObject);
    case 265: 
      return frame52.lambda128(paramObject);
    case 267: 
      return frame54.lambda133(paramObject);
    case 271: 
      return Integer.valueOf(frame57.lambda138(paramObject));
    case 287: 
      if (frame71.lambda163(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 289: 
      if (frame72.lambda166(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 309: 
      if (isStringNull(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 312: 
      return reverseList$To$String(paramObject);
    case 315: 
      return stringConcatenate$SlShared(paramObject);
    case 316: 
      return stringConcatenate(paramObject);
    case 322: 
      if (frame94.lambda210(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 324: 
      if (frame95.lambda216(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    if (frame95.lambda220(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    try
    {
      int i = ((Number)paramObject2).intValue();
      return stringTabulate(paramObject1, i);
    }
    catch (ClassCastException paramModuleMethod)
    {
      try
      {
        paramModuleMethod = (CharSequence)paramObject1;
        return stringDrop(paramModuleMethod, paramObject2);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-drop", 1, paramObject1);
      }
      try
      {
        paramModuleMethod = (CharSequence)paramObject1;
        return stringDropRight(paramModuleMethod, paramObject2);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-drop-right", 1, paramObject1);
      }
      paramModuleMethod = paramModuleMethod;
      throw new WrongType(paramModuleMethod, "string-tabulate", 2, paramObject2);
    }
    return stringTake(paramObject1, paramObject2);
    return stringTakeRight(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 194: 
      return stringParseStart$PlEnd(paramObject1, paramObject2, paramObject3);
    case 196: 
      return stringParseFinalStart$PlEnd(paramObject1, paramObject2, paramObject3);
    case 197: 
      if (isSubstringSpecOk(paramObject1, paramObject2, paramObject3)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    try
    {
      paramModuleMethod = (CharSequence)paramObject1;
    }
    catch (ClassCastException paramModuleMethod)
    {
      try
      {
        int j;
        i = ((Number)paramObject2).intValue();
      }
      catch (ClassCastException paramModuleMethod)
      {
        int i;
        throw new WrongType(paramModuleMethod, "string-copy!", 2, paramObject2);
      }
      try
      {
        paramModuleMethod = (CharSequence)paramObject3;
        return stringCopy$Ex(paramObject1, i, paramModuleMethod);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-copy!", 3, paramObject3);
      }
      paramModuleMethod = paramModuleMethod;
      throw new WrongType(paramModuleMethod, "%substring/shared", 1, paramObject1);
    }
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%substring/shared", 2, paramObject2);
    }
    try
    {
      j = ((Number)paramObject3).intValue();
      return $PcSubstring$SlShared(paramModuleMethod, i, j);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%substring/shared", 3, paramObject3);
    }
    return $PcStringTitlecase$Ex(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    try
    {
      paramModuleMethod = (CharSequence)paramObject2;
    }
    catch (ClassCastException paramModuleMethod)
    {
      int i;
      int j;
      throw new WrongType(paramModuleMethod, "%check-bounds", 2, paramObject2);
    }
    try
    {
      i = ((Number)paramObject3).intValue();
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%check-bounds", 3, paramObject3);
    }
    try
    {
      j = ((Number)paramObject4).intValue();
      return $PcCheckBounds(paramObject1, paramModuleMethod, i, j);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%check-bounds", 4, paramObject4);
    }
    return checkSubstringSpec(paramObject1, paramObject2, paramObject3, paramObject4);
    return $PcStringMap(paramObject1, paramObject2, paramObject3, paramObject4);
    return $PcStringMap$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
    try
    {
      i = ((Number)paramObject2).intValue();
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "string-copy!", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = (CharSequence)paramObject3;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "string-copy!", 3, paramObject3);
    }
    try
    {
      j = ((Number)paramObject4).intValue();
      return stringCopy$Ex(paramObject1, i, paramModuleMethod, j);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "string-copy!", 4, paramObject4);
    }
    return $PcFinishStringConcatenateReverse(paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 201: 
    case 204: 
    case 206: 
    case 209: 
    case 211: 
    case 217: 
    case 218: 
    case 239: 
    case 240: 
    case 242: 
    case 244: 
    case 245: 
    case 247: 
    case 248: 
    case 250: 
    case 252: 
    case 254: 
    case 255: 
    case 257: 
    case 259: 
    case 260: 
    case 262: 
    case 263: 
    case 265: 
    case 267: 
    case 271: 
    case 277: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 287: 
    case 289: 
    case 300: 
    case 301: 
    case 309: 
    case 312: 
    case 315: 
    case 316: 
    case 319: 
    case 322: 
    case 324: 
    case 325: 
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 200: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return substring$SlShared$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 202: 
      paramModuleMethod = paramArrayOfObject[0];
      i = paramArrayOfObject.length - 1;
      localObject1 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringCopy$V(paramModuleMethod, (Object[])localObject1);
        }
        localObject1[i] = paramArrayOfObject[(i + 1)];
      }
    case 203: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringMap$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 205: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringMap$Ex$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 207: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      localObject2 = paramArrayOfObject[2];
      i = paramArrayOfObject.length - 3;
      localObject3 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringFold$V(paramModuleMethod, localObject1, localObject2, (Object[])localObject3);
        }
        localObject3[i] = paramArrayOfObject[(i + 3)];
      }
    case 208: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      localObject2 = paramArrayOfObject[2];
      i = paramArrayOfObject.length - 3;
      localObject3 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringFoldRight$V(paramModuleMethod, localObject1, localObject2, (Object[])localObject3);
        }
        localObject3[i] = paramArrayOfObject[(i + 3)];
      }
    case 210: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      localObject2 = paramArrayOfObject[2];
      localObject3 = paramArrayOfObject[3];
      i = paramArrayOfObject.length - 4;
      localObject4 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringUnfold$V(paramModuleMethod, localObject1, localObject2, localObject3, (Object[])localObject4);
        }
        localObject4[i] = paramArrayOfObject[(i + 4)];
      }
    case 212: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      localObject2 = paramArrayOfObject[2];
      localObject3 = paramArrayOfObject[3];
      i = paramArrayOfObject.length - 4;
      localObject4 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringUnfoldRight$V(paramModuleMethod, localObject1, localObject2, localObject3, (Object[])localObject4);
        }
        localObject4[i] = paramArrayOfObject[(i + 4)];
      }
    case 213: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringForEach$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 214: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringForEachIndex$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 215: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringEvery$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 216: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      localObject2 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stringAny$V(paramModuleMethod, localObject1, (Object[])localObject2);
        }
        localObject2[i] = paramArrayOfObject[(i + 2)];
      }
    case 219: 
      return $PcStringPrefixLength(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 220: 
      return $PcStringSuffixLength(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 221: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject1 = paramArrayOfObject[1];
    }
    try
    {
      i = ((Number)localObject1).intValue();
      localObject1 = paramArrayOfObject[2];
    }
    catch (ClassCastException paramModuleMethod)
    {
      int j;
      int k;
      int m;
      throw new WrongType(paramModuleMethod, "%string-prefix-length-ci", 2, localObject1);
    }
    try
    {
      j = ((Number)localObject1).intValue();
      localObject1 = paramArrayOfObject[3];
      localObject2 = paramArrayOfObject[4];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-prefix-length-ci", 3, localObject1);
    }
    try
    {
      k = ((Number)localObject2).intValue();
      paramArrayOfObject = paramArrayOfObject[5];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-prefix-length-ci", 5, localObject2);
    }
    try
    {
      m = ((Number)paramArrayOfObject).intValue();
      return Integer.valueOf($PcStringPrefixLengthCi(paramModuleMethod, i, j, localObject1, k, m));
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-prefix-length-ci", 6, paramArrayOfObject);
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    try
    {
      i = ((Number)localObject1).intValue();
      localObject1 = paramArrayOfObject[2];
    }
    catch (ClassCastException paramModuleMethod)
    {
      Object[] arrayOfObject;
      throw new WrongType(paramModuleMethod, "%string-suffix-length-ci", 2, localObject1);
    }
    try
    {
      j = ((Number)localObject1).intValue();
      localObject1 = paramArrayOfObject[3];
      localObject2 = paramArrayOfObject[4];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-suffix-length-ci", 3, localObject1);
    }
    try
    {
      k = ((Number)localObject2).intValue();
      paramArrayOfObject = paramArrayOfObject[5];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-suffix-length-ci", 5, localObject2);
    }
    try
    {
      m = ((Number)paramArrayOfObject).intValue();
      return Integer.valueOf($PcStringSuffixLengthCi(paramModuleMethod, i, j, localObject1, k, m));
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-suffix-length-ci", 6, paramArrayOfObject);
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    int i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringPrefixLength$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringSuffixLength$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringPrefixLengthCi$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringSuffixLengthCi$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return isStringPrefix$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return isStringSuffix$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return isStringPrefixCi$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return isStringSuffixCi$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    return $PcStringPrefix$Qu(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    return $PcStringSuffix$Qu(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    return $PcStringPrefixCi$Qu(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    return $PcStringSuffixCi$Qu(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    return $PcStringCompare(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6], paramArrayOfObject[7], paramArrayOfObject[8]);
    return $PcStringCompareCi(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6], paramArrayOfObject[7], paramArrayOfObject[8]);
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    localObject2 = paramArrayOfObject[2];
    Object localObject3 = paramArrayOfObject[3];
    Object localObject4 = paramArrayOfObject[4];
    i = paramArrayOfObject.length - 5;
    arrayOfObject = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCompare$V(paramModuleMethod, localObject1, localObject2, localObject3, localObject4, arrayOfObject);
      }
      arrayOfObject[i] = paramArrayOfObject[(i + 5)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    localObject2 = paramArrayOfObject[2];
    localObject3 = paramArrayOfObject[3];
    localObject4 = paramArrayOfObject[4];
    i = paramArrayOfObject.length - 5;
    arrayOfObject = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCompareCi$V(paramModuleMethod, localObject1, localObject2, localObject3, localObject4, arrayOfObject);
      }
      arrayOfObject[i] = paramArrayOfObject[(i + 5)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Ls$Gr$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Ls$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Gr$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Ls$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$Gr$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Ls$Gr$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Ls$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Gr$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Ls$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCi$Gr$Eq$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    return $PcStringHash(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]);
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringHash$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringHashCi$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringUpcase$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringUpcase$Ex$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringDowncase$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringDowncase$Ex$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTitlecase$Ex$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTitlecase$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTrim$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTrimRight$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTrimBoth$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringPadRight$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringPad$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringDelete$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringFilter$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringIndex$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringIndexRight$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringSkip$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringSkipRight$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringCount$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringFill$Ex$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    j = paramArrayOfObject.length - 3;
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    for (;;)
    {
      try
      {
        i = ((Number)localObject1).intValue();
        localObject2 = paramArrayOfObject[2];
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-copy!", 2, localObject1);
      }
      try
      {
        localObject1 = (CharSequence)localObject2;
        if (j <= 0) {
          return stringCopy$Ex(paramModuleMethod, i, (CharSequence)localObject1);
        }
        k = j - 1;
        localObject2 = paramArrayOfObject[3];
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-copy!", 3, localObject2);
      }
      try
      {
        j = ((Number)localObject2).intValue();
        if (k <= 0) {
          return stringCopy$Ex(paramModuleMethod, i, (CharSequence)localObject1, j);
        }
        paramArrayOfObject = paramArrayOfObject[4];
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "string-copy!", 4, localObject2);
      }
    }
    try
    {
      k = ((Number)paramArrayOfObject).intValue();
      return stringCopy$Ex(paramModuleMethod, i, (CharSequence)localObject1, j, k);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "string-copy!", 5, paramArrayOfObject);
    }
    localObject1 = paramArrayOfObject[0];
    try
    {
      paramModuleMethod = (CharSequence)localObject1;
      localObject1 = paramArrayOfObject[1];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-copy!", 1, localObject1);
    }
    try
    {
      i = ((Number)localObject1).intValue();
      localObject2 = paramArrayOfObject[2];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-copy!", 2, localObject1);
    }
    try
    {
      localObject1 = (CharSequence)localObject2;
      localObject2 = paramArrayOfObject[3];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-copy!", 3, localObject2);
    }
    try
    {
      j = ((Number)localObject2).intValue();
      paramArrayOfObject = paramArrayOfObject[4];
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-copy!", 4, localObject2);
    }
    try
    {
      k = ((Number)paramArrayOfObject).intValue();
      return $PcStringCopy$Ex(paramModuleMethod, i, (CharSequence)localObject1, j, k);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "%string-copy!", 5, paramArrayOfObject);
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringContains$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringContainsCi$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    return $PcKmpSearch(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6]);
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return makeKmpRestartVector$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    return kmpStep(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    localObject2 = paramArrayOfObject[2];
    localObject3 = paramArrayOfObject[3];
    i = paramArrayOfObject.length - 4;
    localObject4 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringKmpPartialSearch$V(paramModuleMethod, localObject1, localObject2, localObject3, (Object[])localObject4);
      }
      localObject4[i] = paramArrayOfObject[(i + 4)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringReverse$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringReverse$Ex$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return string$To$List$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    return stringAppend$SlShared$V(paramArrayOfObject);
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringConcatenateReverse$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringConcatenateReverse$SlShared$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    localObject2 = paramArrayOfObject[2];
    localObject3 = paramArrayOfObject[3];
    i = paramArrayOfObject.length - 4;
    localObject4 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringReplace$V(paramModuleMethod, localObject1, localObject2, localObject3, (Object[])localObject4);
      }
      localObject4[i] = paramArrayOfObject[(i + 4)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringTokenize$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    i = paramArrayOfObject.length - 2;
    localObject2 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return xsubstring$V(paramModuleMethod, localObject1, (Object[])localObject2);
      }
      localObject2[i] = paramArrayOfObject[(i + 2)];
    }
    paramModuleMethod = paramArrayOfObject[0];
    localObject1 = paramArrayOfObject[1];
    localObject2 = paramArrayOfObject[2];
    localObject3 = paramArrayOfObject[3];
    i = paramArrayOfObject.length - 4;
    localObject4 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringXcopy$Ex$V(paramModuleMethod, localObject1, localObject2, localObject3, (Object[])localObject4);
      }
      localObject4[i] = paramArrayOfObject[(i + 4)];
    }
    return $PcMultispanRepcopy$Ex(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5], paramArrayOfObject[6]);
    paramModuleMethod = paramArrayOfObject[0];
    i = paramArrayOfObject.length - 1;
    localObject1 = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return stringJoin$V(paramModuleMethod, (Object[])localObject1);
      }
      localObject1[i] = paramArrayOfObject[(i + 1)];
    }
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 325: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 324: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 322: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 316: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 315: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 312: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 309: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 289: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 287: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 271: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 267: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 265: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 263: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 262: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 260: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 259: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 257: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 255: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 254: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 252: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 250: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 248: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 247: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 245: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 244: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 242: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 240: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 239: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 217: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 211: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 209: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 283: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 282: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 281: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 280: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 299: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if ((paramObject3 instanceof CharSequence))
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786429;
    case 277: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 201: 
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 197: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 196: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 319: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 299: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if ((paramObject3 instanceof CharSequence))
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786429;
    case 206: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 204: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 198: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return -786430;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 201: 
    case 204: 
    case 206: 
    case 209: 
    case 211: 
    case 217: 
    case 218: 
    case 239: 
    case 240: 
    case 242: 
    case 244: 
    case 245: 
    case 247: 
    case 248: 
    case 250: 
    case 252: 
    case 254: 
    case 255: 
    case 257: 
    case 259: 
    case 260: 
    case 262: 
    case 263: 
    case 265: 
    case 267: 
    case 271: 
    case 277: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 287: 
    case 289: 
    case 300: 
    case 301: 
    case 309: 
    case 312: 
    case 315: 
    case 316: 
    case 319: 
    case 322: 
    case 324: 
    case 325: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 328: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 327: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 326: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 323: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 321: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 320: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 318: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 317: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 314: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 313: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 311: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 310: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 308: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 307: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 306: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 305: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 304: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 303: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 302: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 299: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 298: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 297: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 296: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 295: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 294: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 293: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 292: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 291: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 290: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 288: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 286: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 285: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 284: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 279: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 278: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 276: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 275: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 274: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 273: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 272: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 270: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 269: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 268: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 266: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 264: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 261: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 258: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 256: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 253: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 251: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 249: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 246: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 243: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 241: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 238: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 237: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 236: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 235: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 234: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 233: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 232: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 231: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 230: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 229: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 228: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 227: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 226: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 225: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 224: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 223: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 222: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 221: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 220: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 219: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 216: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 215: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 214: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 213: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 212: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 210: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 208: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 207: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 205: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 203: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 202: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }
  
  public final void run(CallContext paramCallContext)
  {
    paramCallContext = paramCallContext.consumer;
  }
  
  public class frame
    extends ModuleBody
  {
    Object args;
    final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
    final ModuleMethod lambda$Fn2;
    Object proc;
    Object s;
    int slen;
    Object start;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:150");
      this.lambda$Fn2 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda1();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda2(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda1()
    {
      if (lists.isPair(this.args))
      {
        Object localObject1 = lists.car.apply1(this.args);
        Object localObject2 = lists.cdr.apply1(this.args);
        boolean bool = numbers.isInteger(localObject1);
        if (bool)
        {
          bool = numbers.isExact(localObject1);
          if (bool) {
            if (Scheme.numLEq.apply2(localObject1, Integer.valueOf(this.slen)) == Boolean.FALSE) {
              break label90;
            }
          }
        }
        for (;;)
        {
          return misc.values(new Object[] { localObject1, localObject2 });
          if (!bool) {
            label90:
            do
            {
              return misc.error$V("Illegal substring END spec", new Object[] { this.proc, localObject1, this.s });
            } while (!bool);
          }
        }
      }
      return misc.values(new Object[] { Integer.valueOf(this.slen), this.args });
    }
    
    Object lambda2(Object paramObject1, Object paramObject2)
    {
      if (Scheme.numLEq.apply2(this.start, paramObject1) != Boolean.FALSE) {
        return misc.values(new Object[] { paramObject2, this.start, paramObject1 });
      }
      return misc.error$V("Illegal substring START/END spec", new Object[] { this.proc, this.start, paramObject1, this.s });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object args;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object proc;
    Object s;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 4, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:174");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda3();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda4(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda3()
    {
      return srfi13.stringParseStart$PlEnd(this.proc, this.s, this.args);
    }
    
    Object lambda4(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (lists.isPair(paramObject1)) {
        return misc.error$V("Extra arguments to procedure", new Object[] { this.proc, paramObject1 });
      }
      return misc.values(new Object[] { paramObject2, paramObject3 });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame1
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn6;
    int slen;
    Object start;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 5, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:227");
      this.lambda$Fn6 = this$1;
    }
    
    static boolean lambda5(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 5)
      {
        if (lambda6(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda6(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      Object localObject;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          localObject = Scheme.numLEq.apply2(this.start, paramObject);
        }
      }
      try
      {
        bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(paramObject, Integer.valueOf(this.slen))).booleanValue();
        }
        return bool1;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "x", -2, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame10
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn25 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 23, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 22) {
        return lambda25();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 23) {
        return lambda26(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda25()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnany, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda26(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion)) {
        localObject1 = Scheme.numLss.apply2(paramObject1, paramObject2);
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool) {
            localObject2 = this.criterion;
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject1 = (Char)localObject2;
          localObject2 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "char=?", 1, localObject2);
        }
        try
        {
          localObject3 = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          bool = characters.isChar$Eq((Char)localObject1, Char.make(strings.stringRef((CharSequence)localObject3, i)));
          if (bool)
          {
            if (bool)
            {
              paramObject1 = Boolean.TRUE;
              return paramObject1;
            }
            paramObject1 = Boolean.FALSE;
            continue;
          }
          paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        if (bool)
        {
          paramObject1 = Boolean.TRUE;
        }
        else
        {
          paramObject1 = Boolean.FALSE;
          continue;
          localObject1 = Scheme.applyToArgs;
          localObject2 = srfi13.loc$char$Mnset$Qu;
        }
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = paramObject1;
            paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 515, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool)
          {
            paramObject1 = Scheme.applyToArgs;
            localObject2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject3 = ((Location)localObject2).get();
          localObject4 = this.criterion;
          localObject2 = this.s;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 518, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          localObject2 = ((Procedure)paramObject1).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i)));
          paramObject1 = localObject2;
          if (localObject2 != Boolean.FALSE) {
            continue;
          }
          localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject1 = Scheme.numLss.apply2(paramObject1, paramObject2);
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool) {
            localObject1 = this.s;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject2 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          i = strings.stringRef((CharSequence)localObject2, i);
          localObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
          if (Scheme.numEqu.apply2(localObject1, paramObject2) != Boolean.FALSE) {
            return Scheme.applyToArgs.apply2(this.criterion, Char.make(i));
          }
          localObject2 = Scheme.applyToArgs.apply2(this.criterion, Char.make(i));
          paramObject1 = localObject2;
          if (localObject2 == Boolean.FALSE) {
            paramObject1 = localObject1;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] { srfi13.string$Mnany, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 22)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 23)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 26, null, 0);
    final ModuleMethod lambda$Fn29 = new ModuleMethod(this, 27, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 26) {
        return lambda28();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 27) {
        return lambda29(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda28()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnlength, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda29(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame12 localframe12 = new srfi13.frame12();
      localframe12.staticLink = this;
      localframe12.rest = paramObject1;
      localframe12.start1 = paramObject2;
      localframe12.end1 = paramObject3;
      return call_with_values.callWithValues(localframe12.lambda$Fn30, localframe12.lambda$Fn31);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 26)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 27)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame12
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn30 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn31 = new ModuleMethod(this, 25, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame11 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 24) {
        return lambda30();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 25) {
        return lambda31(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda30()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnlength, this.staticLink.s2, this.rest);
    }
    
    Object lambda31(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefixLength(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 24)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 25)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame13
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn32 = new ModuleMethod(this, 30, null, 0);
    final ModuleMethod lambda$Fn33 = new ModuleMethod(this, 31, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 30) {
        return lambda32();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 31) {
        return lambda33(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda32()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnlength, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda33(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame14 localframe14 = new srfi13.frame14();
      localframe14.staticLink = this;
      localframe14.rest = paramObject1;
      localframe14.start1 = paramObject2;
      localframe14.end1 = paramObject3;
      return call_with_values.callWithValues(localframe14.lambda$Fn34, localframe14.lambda$Fn35);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 30)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 31)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame14
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn34 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn35 = new ModuleMethod(this, 29, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame13 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 28) {
        return lambda34();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 29) {
        return lambda35(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda34()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnlength, this.staticLink.s2, this.rest);
    }
    
    Object lambda35(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffixLength(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 28)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 29)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame15
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn36 = new ModuleMethod(this, 34, null, 0);
    final ModuleMethod lambda$Fn37 = new ModuleMethod(this, 35, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 34) {
        return lambda36();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 35) {
        return lambda37(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda36()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnlength$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda37(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame16 localframe16 = new srfi13.frame16();
      localframe16.staticLink = this;
      localframe16.rest = paramObject1;
      localframe16.start1 = paramObject2;
      localframe16.end1 = paramObject3;
      return call_with_values.callWithValues(localframe16.lambda$Fn38, localframe16.lambda$Fn39);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 34)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 35)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame16
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn38 = new ModuleMethod(this, 32, null, 0);
    final ModuleMethod lambda$Fn39 = new ModuleMethod(this, 33, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame15 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 32) {
        return lambda38();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 33) {
        return Integer.valueOf(lambda39(paramObject1, paramObject2));
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda38()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnlength$Mnci, this.staticLink.s2, this.rest);
    }
    
    /* Error */
    int lambda39(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 64	gnu/kawa/slib/srfi13$frame16:staticLink	Lgnu/kawa/slib/srfi13$frame15;
      //   4: getfield 78	gnu/kawa/slib/srfi13$frame15:s1	Ljava/lang/Object;
      //   7: astore 7
      //   9: aload_0
      //   10: getfield 80	gnu/kawa/slib/srfi13$frame16:start1	Ljava/lang/Object;
      //   13: astore 8
      //   15: aload 8
      //   17: checkcast 82	java/lang/Number
      //   20: invokevirtual 86	java/lang/Number:intValue	()I
      //   23: istore_3
      //   24: aload_0
      //   25: getfield 88	gnu/kawa/slib/srfi13$frame16:end1	Ljava/lang/Object;
      //   28: astore 8
      //   30: aload 8
      //   32: checkcast 82	java/lang/Number
      //   35: invokevirtual 86	java/lang/Number:intValue	()I
      //   38: istore 4
      //   40: aload_0
      //   41: getfield 64	gnu/kawa/slib/srfi13$frame16:staticLink	Lgnu/kawa/slib/srfi13$frame15;
      //   44: getfield 67	gnu/kawa/slib/srfi13$frame15:s2	Ljava/lang/Object;
      //   47: astore 8
      //   49: aload_1
      //   50: checkcast 82	java/lang/Number
      //   53: invokevirtual 86	java/lang/Number:intValue	()I
      //   56: istore 5
      //   58: aload_2
      //   59: checkcast 82	java/lang/Number
      //   62: invokevirtual 86	java/lang/Number:intValue	()I
      //   65: istore 6
      //   67: aload 7
      //   69: iload_3
      //   70: iload 4
      //   72: aload 8
      //   74: iload 5
      //   76: iload 6
      //   78: invokestatic 92	gnu/kawa/slib/srfi13:$PcStringPrefixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
      //   81: ireturn
      //   82: astore_1
      //   83: new 94	gnu/mapping/WrongType
      //   86: dup
      //   87: aload_1
      //   88: ldc 96
      //   90: iconst_1
      //   91: aload 8
      //   93: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      //   97: astore_1
      //   98: new 94	gnu/mapping/WrongType
      //   101: dup
      //   102: aload_1
      //   103: ldc 96
      //   105: iconst_2
      //   106: aload 8
      //   108: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   111: athrow
      //   112: astore_2
      //   113: new 94	gnu/mapping/WrongType
      //   116: dup
      //   117: aload_2
      //   118: ldc 96
      //   120: iconst_4
      //   121: aload_1
      //   122: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   125: athrow
      //   126: astore_1
      //   127: new 94	gnu/mapping/WrongType
      //   130: dup
      //   131: aload_1
      //   132: ldc 96
      //   134: iconst_5
      //   135: aload_2
      //   136: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   139: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	140	0	this	frame16
      //   0	140	1	paramObject1	Object
      //   0	140	2	paramObject2	Object
      //   23	47	3	i	int
      //   38	33	4	j	int
      //   56	19	5	k	int
      //   65	12	6	m	int
      //   7	61	7	localObject1	Object
      //   13	94	8	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   15	24	82	java/lang/ClassCastException
      //   30	40	97	java/lang/ClassCastException
      //   49	58	112	java/lang/ClassCastException
      //   58	67	126	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 32)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 33)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame17
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn40 = new ModuleMethod(this, 38, null, 0);
    final ModuleMethod lambda$Fn41 = new ModuleMethod(this, 39, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 38) {
        return lambda40();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 39) {
        return lambda41(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda40()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnlength$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda41(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame18 localframe18 = new srfi13.frame18();
      localframe18.staticLink = this;
      localframe18.rest = paramObject1;
      localframe18.start1 = paramObject2;
      localframe18.end1 = paramObject3;
      return call_with_values.callWithValues(localframe18.lambda$Fn42, localframe18.lambda$Fn43);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 38)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 39)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame18
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn42 = new ModuleMethod(this, 36, null, 0);
    final ModuleMethod lambda$Fn43 = new ModuleMethod(this, 37, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame17 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 36) {
        return lambda42();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 37) {
        return Integer.valueOf(lambda43(paramObject1, paramObject2));
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda42()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnlength$Mnci, this.staticLink.s2, this.rest);
    }
    
    /* Error */
    int lambda43(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 64	gnu/kawa/slib/srfi13$frame18:staticLink	Lgnu/kawa/slib/srfi13$frame17;
      //   4: getfield 78	gnu/kawa/slib/srfi13$frame17:s1	Ljava/lang/Object;
      //   7: astore 7
      //   9: aload_0
      //   10: getfield 80	gnu/kawa/slib/srfi13$frame18:start1	Ljava/lang/Object;
      //   13: astore 8
      //   15: aload 8
      //   17: checkcast 82	java/lang/Number
      //   20: invokevirtual 86	java/lang/Number:intValue	()I
      //   23: istore_3
      //   24: aload_0
      //   25: getfield 88	gnu/kawa/slib/srfi13$frame18:end1	Ljava/lang/Object;
      //   28: astore 8
      //   30: aload 8
      //   32: checkcast 82	java/lang/Number
      //   35: invokevirtual 86	java/lang/Number:intValue	()I
      //   38: istore 4
      //   40: aload_0
      //   41: getfield 64	gnu/kawa/slib/srfi13$frame18:staticLink	Lgnu/kawa/slib/srfi13$frame17;
      //   44: getfield 67	gnu/kawa/slib/srfi13$frame17:s2	Ljava/lang/Object;
      //   47: astore 8
      //   49: aload_1
      //   50: checkcast 82	java/lang/Number
      //   53: invokevirtual 86	java/lang/Number:intValue	()I
      //   56: istore 5
      //   58: aload_2
      //   59: checkcast 82	java/lang/Number
      //   62: invokevirtual 86	java/lang/Number:intValue	()I
      //   65: istore 6
      //   67: aload 7
      //   69: iload_3
      //   70: iload 4
      //   72: aload 8
      //   74: iload 5
      //   76: iload 6
      //   78: invokestatic 92	gnu/kawa/slib/srfi13:$PcStringSuffixLengthCi	(Ljava/lang/Object;IILjava/lang/Object;II)I
      //   81: ireturn
      //   82: astore_1
      //   83: new 94	gnu/mapping/WrongType
      //   86: dup
      //   87: aload_1
      //   88: ldc 96
      //   90: iconst_1
      //   91: aload 8
      //   93: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      //   97: astore_1
      //   98: new 94	gnu/mapping/WrongType
      //   101: dup
      //   102: aload_1
      //   103: ldc 96
      //   105: iconst_2
      //   106: aload 8
      //   108: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   111: athrow
      //   112: astore_2
      //   113: new 94	gnu/mapping/WrongType
      //   116: dup
      //   117: aload_2
      //   118: ldc 96
      //   120: iconst_4
      //   121: aload_1
      //   122: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   125: athrow
      //   126: astore_1
      //   127: new 94	gnu/mapping/WrongType
      //   130: dup
      //   131: aload_1
      //   132: ldc 96
      //   134: iconst_5
      //   135: aload_2
      //   136: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   139: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	140	0	this	frame18
      //   0	140	1	paramObject1	Object
      //   0	140	2	paramObject2	Object
      //   23	47	3	i	int
      //   38	33	4	j	int
      //   56	19	5	k	int
      //   65	12	6	m	int
      //   7	61	7	localObject1	Object
      //   13	94	8	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   15	24	82	java/lang/ClassCastException
      //   30	40	97	java/lang/ClassCastException
      //   49	58	112	java/lang/ClassCastException
      //   58	67	126	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 36)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 37)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame19
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn44 = new ModuleMethod(this, 42, null, 0);
    final ModuleMethod lambda$Fn45 = new ModuleMethod(this, 43, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 42) {
        return lambda44();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 43) {
        return lambda45(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda44()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda45(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame20 localframe20 = new srfi13.frame20();
      localframe20.staticLink = this;
      localframe20.rest = paramObject1;
      localframe20.start1 = paramObject2;
      localframe20.end1 = paramObject3;
      return call_with_values.callWithValues(localframe20.lambda$Fn46, localframe20.lambda$Fn47);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 42)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 43)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 6, null, 0);
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 7, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda7();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda8(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda7()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncopy, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda8(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 53	gnu/kawa/slib/srfi13$frame2:s	Ljava/lang/Object;
      //   4: astore 5
      //   6: aload 5
      //   8: checkcast 63	java/lang/CharSequence
      //   11: astore 6
      //   13: aload_1
      //   14: checkcast 65	java/lang/Number
      //   17: invokevirtual 69	java/lang/Number:intValue	()I
      //   20: istore_3
      //   21: aload_2
      //   22: checkcast 65	java/lang/Number
      //   25: invokevirtual 69	java/lang/Number:intValue	()I
      //   28: istore 4
      //   30: aload 6
      //   32: iload_3
      //   33: iload 4
      //   35: invokestatic 75	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   38: areturn
      //   39: astore_1
      //   40: new 77	gnu/mapping/WrongType
      //   43: dup
      //   44: aload_1
      //   45: ldc 78
      //   47: iconst_1
      //   48: aload 5
      //   50: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   53: athrow
      //   54: astore_2
      //   55: new 77	gnu/mapping/WrongType
      //   58: dup
      //   59: aload_2
      //   60: ldc 78
      //   62: iconst_2
      //   63: aload_1
      //   64: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   67: athrow
      //   68: astore_1
      //   69: new 77	gnu/mapping/WrongType
      //   72: dup
      //   73: aload_1
      //   74: ldc 78
      //   76: iconst_3
      //   77: aload_2
      //   78: invokespecial 81	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	frame2
      //   0	82	1	paramObject1	Object
      //   0	82	2	paramObject2	Object
      //   20	13	3	i	int
      //   28	6	4	j	int
      //   4	45	5	localObject	Object
      //   11	20	6	localCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   6	13	39	java/lang/ClassCastException
      //   13	21	54	java/lang/ClassCastException
      //   21	30	68	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame20
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 40, null, 0);
    final ModuleMethod lambda$Fn47 = new ModuleMethod(this, 41, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame19 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 40) {
        return lambda46();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 41) {
        return lambda47(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda46()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda47(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefix$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 40)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 41)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame21
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn48 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn49 = new ModuleMethod(this, 47, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 46) {
        return lambda48();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 47) {
        return lambda49(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda48()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda49(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame22 localframe22 = new srfi13.frame22();
      localframe22.staticLink = this;
      localframe22.rest = paramObject1;
      localframe22.start1 = paramObject2;
      localframe22.end1 = paramObject3;
      return call_with_values.callWithValues(localframe22.lambda$Fn50, localframe22.lambda$Fn51);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 46)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 47)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame22
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 44, null, 0);
    final ModuleMethod lambda$Fn51 = new ModuleMethod(this, 45, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame21 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 44) {
        return lambda50();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 45) {
        return lambda51(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda50()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda51(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffix$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 44)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 45)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame23
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn52 = new ModuleMethod(this, 50, null, 0);
    final ModuleMethod lambda$Fn53 = new ModuleMethod(this, 51, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 50) {
        return lambda52();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 51) {
        return lambda53(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda52()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnprefix$Mnci$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda53(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame24 localframe24 = new srfi13.frame24();
      localframe24.staticLink = this;
      localframe24.rest = paramObject1;
      localframe24.start1 = paramObject2;
      localframe24.end1 = paramObject3;
      return call_with_values.callWithValues(localframe24.lambda$Fn54, localframe24.lambda$Fn55);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 50)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 51)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame24
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn54 = new ModuleMethod(this, 48, null, 0);
    final ModuleMethod lambda$Fn55 = new ModuleMethod(this, 49, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame23 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 48) {
        return lambda54();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 49) {
        return lambda55(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda54()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnci$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda55(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringPrefixCi$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 48)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 49)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame25
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn56 = new ModuleMethod(this, 54, null, 0);
    final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 55, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 54) {
        return lambda56();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 55) {
        return lambda57(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda56()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnsuffix$Mnci$Qu, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda57(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame26 localframe26 = new srfi13.frame26();
      localframe26.staticLink = this;
      localframe26.rest = paramObject1;
      localframe26.start1 = paramObject2;
      localframe26.end1 = paramObject3;
      return call_with_values.callWithValues(localframe26.lambda$Fn58, localframe26.lambda$Fn59);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 54)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 55)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame26
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn58 = new ModuleMethod(this, 52, null, 0);
    final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 53, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame25 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 52) {
        return lambda58();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 53) {
        return lambda59(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda58()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnsuffix$Mnci$Qu, this.staticLink.s2, this.rest);
    }
    
    Object lambda59(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringSuffixCi$Qu(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 52)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 53)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame27
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn60 = new ModuleMethod(this, 58, null, 0);
    final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 59, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object proc$Eq;
    Object proc$Gr;
    Object proc$Ls;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 58) {
        return lambda60();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 59) {
        return lambda61(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda60()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncompare, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda61(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame28 localframe28 = new srfi13.frame28();
      localframe28.staticLink = this;
      localframe28.rest = paramObject1;
      localframe28.start1 = paramObject2;
      localframe28.end1 = paramObject3;
      return call_with_values.callWithValues(localframe28.lambda$Fn62, localframe28.lambda$Fn63);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 58)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 59)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame28
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn62 = new ModuleMethod(this, 56, null, 0);
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 57, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame27 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 56) {
        return lambda62();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 57) {
        return lambda63(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda62()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare, this.staticLink.s2, this.rest);
    }
    
    Object lambda63(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, this.staticLink.proc$Ls, this.staticLink.proc$Eq, this.staticLink.proc$Gr);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 56)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 57)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame29
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn64 = new ModuleMethod(this, 62, null, 0);
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 63, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object proc$Eq;
    Object proc$Gr;
    Object proc$Ls;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 62) {
        return lambda64();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 63) {
        return lambda65(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda64()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncompare$Mnci, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda65(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame30 localframe30 = new srfi13.frame30();
      localframe30.staticLink = this;
      localframe30.rest = paramObject1;
      localframe30.start1 = paramObject2;
      localframe30.end1 = paramObject3;
      return call_with_values.callWithValues(localframe30.lambda$Fn66, localframe30.lambda$Fn67);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 62)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 63)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 9, null, 8194);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 8, null, 0);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda9();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda10(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(this.proc, this.s, paramObject1, paramObject2);
    }
    
    Object lambda9()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnmap, this.s, this.maybe$Mnstart$Plend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame30
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn66 = new ModuleMethod(this, 60, null, 0);
    final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 61, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame29 staticLink;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 60) {
        return lambda66();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 61) {
        return lambda67(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda66()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare$Mnci, this.staticLink.s2, this.rest);
    }
    
    Object lambda67(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, this.staticLink.proc$Ls, this.staticLink.proc$Eq, this.staticLink.proc$Gr);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 60)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 61)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame31
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn68 = new ModuleMethod(this, 66, null, 0);
    final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 67, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 66) {
        return lambda68();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 67) {
        return lambda69(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda68()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda69(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame32 localframe32 = new srfi13.frame32();
      localframe32.staticLink = this;
      localframe32.rest = paramObject1;
      localframe32.start1 = paramObject2;
      localframe32.end1 = paramObject3;
      return call_with_values.callWithValues(localframe32.lambda$Fn70, localframe32.lambda$Fn71);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 66)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 67)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame32
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn70 = new ModuleMethod(this, 64, null, 0);
    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 65, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame31 staticLink;
    
    static Boolean lambda72(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda73(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 64) {
        return lambda70();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 65) {
        return lambda71(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda70()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda71(Object paramObject1, Object paramObject2)
    {
      localObject = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      for (;;)
      {
        try
        {
          bool1 = ((Boolean)localObject).booleanValue();
          if (bool1) {
            if (this.staticLink.s1 == this.staticLink.s2)
            {
              bool1 = true;
              bool2 = bool1;
              if (bool1) {
                localObject = Scheme.numEqu.apply2(this.start1, paramObject1);
              }
            }
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool1;
          boolean bool2;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
        try
        {
          bool2 = ((Boolean)localObject).booleanValue();
          if (bool2)
          {
            if (bool2)
            {
              return Boolean.TRUE;
              bool1 = false;
            }
            else
            {
              return Boolean.FALSE;
            }
          }
          else {
            return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn72, misc.values, srfi13.lambda$Fn73);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 64)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 65)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame33
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn74 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 71, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 70) {
        return lambda74();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 71) {
        return lambda75(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda74()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda75(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame34 localframe34 = new srfi13.frame34();
      localframe34.staticLink = this;
      localframe34.rest = paramObject1;
      localframe34.start1 = paramObject2;
      localframe34.end1 = paramObject3;
      return call_with_values.callWithValues(localframe34.lambda$Fn76, localframe34.lambda$Fn77);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 70)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 71)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame34
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn76 = new ModuleMethod(this, 68, null, 0);
    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 69, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame33 staticLink;
    
    static Boolean lambda78(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 68) {
        return lambda76();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 69) {
        return lambda77(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda76()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda77(Object paramObject1, Object paramObject2)
    {
      j = 1;
      localObject = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      try
      {
        localBoolean = Boolean.FALSE;
        if (localObject != localBoolean) {}
        for (i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label74;
          }
          if (i == 0) {
            break;
          }
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        label74:
        if (this.staticLink.s1 != this.staticLink.s2) {
          break label172;
        }
        i = 1;
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          int i;
          Boolean localBoolean = Boolean.FALSE;
          if (localObject != localBoolean) {
            i = j;
          }
          for (;;)
          {
            i = i + 1 & 0x1;
            if (i == 0) {
              break label185;
            }
            return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn78, misc.values);
            i = 0;
            break;
            i = 0;
          }
          if (i != 0) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
      }
      if (i != 0) {
        localObject = Scheme.numEqu.apply2(this.start1, paramObject1);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 68)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 69)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame35
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn79 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn80 = new ModuleMethod(this, 75, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 74) {
        return lambda79();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 75) {
        return lambda80(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda79()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda80(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame36 localframe36 = new srfi13.frame36();
      localframe36.staticLink = this;
      localframe36.rest = paramObject1;
      localframe36.start1 = paramObject2;
      localframe36.end1 = paramObject3;
      return call_with_values.callWithValues(localframe36.lambda$Fn81, localframe36.lambda$Fn82);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 74)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 75)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame36
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn81 = new ModuleMethod(this, 72, null, 0);
    final ModuleMethod lambda$Fn82 = new ModuleMethod(this, 73, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame35 staticLink;
    
    static Boolean lambda83(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda84(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 72) {
        return lambda81();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 73) {
        return lambda82(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda81()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls, this.staticLink.s2, this.rest);
    }
    
    Object lambda82(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLss.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn83, srfi13.lambda$Fn84);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 72)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 73)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame37
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn85 = new ModuleMethod(this, 78, null, 0);
    final ModuleMethod lambda$Fn86 = new ModuleMethod(this, 79, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 78) {
        return lambda85();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 79) {
        return lambda86(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda85()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda86(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame38 localframe38 = new srfi13.frame38();
      localframe38.staticLink = this;
      localframe38.rest = paramObject1;
      localframe38.start1 = paramObject2;
      localframe38.end1 = paramObject3;
      return call_with_values.callWithValues(localframe38.lambda$Fn87, localframe38.lambda$Fn88);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 78)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 79)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame38
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn87 = new ModuleMethod(this, 76, null, 0);
    final ModuleMethod lambda$Fn88 = new ModuleMethod(this, 77, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame37 staticLink;
    
    static Boolean lambda89(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda90(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 76) {
        return lambda87();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 77) {
        return lambda88(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda87()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda88(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGrt.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn89, srfi13.lambda$Fn90, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 76)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 77)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame39
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn91 = new ModuleMethod(this, 82, null, 0);
    final ModuleMethod lambda$Fn92 = new ModuleMethod(this, 83, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 82) {
        return lambda91();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 83) {
        return lambda92(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda91()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Ls$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda92(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame40 localframe40 = new srfi13.frame40();
      localframe40.staticLink = this;
      localframe40.rest = paramObject1;
      localframe40.start1 = paramObject2;
      localframe40.end1 = paramObject3;
      return call_with_values.callWithValues(localframe40.lambda$Fn93, localframe40.lambda$Fn94);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 82)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 83)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame4
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 10, null, 0);
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 11, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda11();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 11) {
        return lambda12(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda11()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnmap$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda12(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(this.proc, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame40
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn93 = new ModuleMethod(this, 80, null, 0);
    final ModuleMethod lambda$Fn94 = new ModuleMethod(this, 81, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame39 staticLink;
    
    static Boolean lambda95(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 80) {
        return lambda93();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 81) {
        return lambda94(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda93()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Ls$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda94(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, misc.values, srfi13.lambda$Fn95);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 80)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 81)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame41
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn96 = new ModuleMethod(this, 86, null, 0);
    final ModuleMethod lambda$Fn97 = new ModuleMethod(this, 87, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 86) {
        return lambda96();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 87) {
        return lambda97(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda96()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Gr$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda97(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame42 localframe42 = new srfi13.frame42();
      localframe42.staticLink = this;
      localframe42.rest = paramObject1;
      localframe42.start1 = paramObject2;
      localframe42.end1 = paramObject3;
      return call_with_values.callWithValues(localframe42.lambda$Fn98, localframe42.lambda$Fn99);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 86)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 87)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame42
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn98 = new ModuleMethod(this, 84, null, 0);
    final ModuleMethod lambda$Fn99 = new ModuleMethod(this, 85, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame41 staticLink;
    
    static Boolean lambda100(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 84) {
        return lambda98();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 85) {
        return lambda99(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda98()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Gr$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda99(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompare(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn100, misc.values, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 84)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 85)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame43
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn101 = new ModuleMethod(this, 90, null, 0);
    final ModuleMethod lambda$Fn102 = new ModuleMethod(this, 91, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 90) {
        return lambda101();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 91) {
        return lambda102(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda101()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda102(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame44 localframe44 = new srfi13.frame44();
      localframe44.staticLink = this;
      localframe44.rest = paramObject1;
      localframe44.start1 = paramObject2;
      localframe44.end1 = paramObject3;
      return call_with_values.callWithValues(localframe44.lambda$Fn103, localframe44.lambda$Fn104);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 90)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 91)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame44
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn103 = new ModuleMethod(this, 88, null, 0);
    final ModuleMethod lambda$Fn104 = new ModuleMethod(this, 89, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame43 staticLink;
    
    static Boolean lambda105(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda106(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 88) {
        return lambda103();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 89) {
        return lambda104(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda103()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda104(Object paramObject1, Object paramObject2)
    {
      localObject = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      for (;;)
      {
        try
        {
          bool1 = ((Boolean)localObject).booleanValue();
          if (bool1) {
            if (this.staticLink.s1 == this.staticLink.s2)
            {
              bool1 = true;
              bool2 = bool1;
              if (bool1) {
                localObject = Scheme.numEqu.apply2(this.start1, paramObject1);
              }
            }
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool1;
          boolean bool2;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
        try
        {
          bool2 = ((Boolean)localObject).booleanValue();
          if (bool2)
          {
            if (bool2)
            {
              return Boolean.TRUE;
              bool1 = false;
            }
            else
            {
              return Boolean.FALSE;
            }
          }
          else {
            return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn105, misc.values, srfi13.lambda$Fn106);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
      }
      if (bool1) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 88)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 89)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame45
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn107 = new ModuleMethod(this, 94, null, 0);
    final ModuleMethod lambda$Fn108 = new ModuleMethod(this, 95, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 94) {
        return lambda107();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 95) {
        return lambda108(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda107()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda108(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame46 localframe46 = new srfi13.frame46();
      localframe46.staticLink = this;
      localframe46.rest = paramObject1;
      localframe46.start1 = paramObject2;
      localframe46.end1 = paramObject3;
      return call_with_values.callWithValues(localframe46.lambda$Fn109, localframe46.lambda$Fn110);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 94)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 95)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame46
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn109 = new ModuleMethod(this, 92, null, 0);
    final ModuleMethod lambda$Fn110 = new ModuleMethod(this, 93, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame45 staticLink;
    
    static Boolean lambda111(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 92) {
        return lambda109();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 93) {
        return lambda110(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda109()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda110(Object paramObject1, Object paramObject2)
    {
      j = 1;
      localObject = Scheme.numEqu.apply2(AddOp.$Mn.apply2(this.end1, this.start1), AddOp.$Mn.apply2(paramObject2, paramObject1));
      try
      {
        localBoolean = Boolean.FALSE;
        if (localObject != localBoolean) {}
        for (i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label74;
          }
          if (i == 0) {
            break;
          }
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        label74:
        if (this.staticLink.s1 != this.staticLink.s2) {
          break label172;
        }
        i = 1;
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          int i;
          Boolean localBoolean = Boolean.FALSE;
          if (localObject != localBoolean) {
            i = j;
          }
          for (;;)
          {
            i = i + 1 & 0x1;
            if (i == 0) {
              break label185;
            }
            return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn111, misc.values);
            i = 0;
            break;
            i = 0;
          }
          if (i != 0) {
            return Boolean.TRUE;
          }
          return Boolean.FALSE;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
      }
      if (i != 0) {
        localObject = Scheme.numEqu.apply2(this.start1, paramObject1);
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 92)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 93)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame47
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn112 = new ModuleMethod(this, 98, null, 0);
    final ModuleMethod lambda$Fn113 = new ModuleMethod(this, 99, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 98) {
        return lambda112();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 99) {
        return lambda113(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda112()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda113(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame48 localframe48 = new srfi13.frame48();
      localframe48.staticLink = this;
      localframe48.rest = paramObject1;
      localframe48.start1 = paramObject2;
      localframe48.end1 = paramObject3;
      return call_with_values.callWithValues(localframe48.lambda$Fn114, localframe48.lambda$Fn115);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 98)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 99)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame48
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn114 = new ModuleMethod(this, 96, null, 0);
    final ModuleMethod lambda$Fn115 = new ModuleMethod(this, 97, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame47 staticLink;
    
    static Boolean lambda116(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda117(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 96) {
        return lambda114();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 97) {
        return lambda115(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda114()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls, this.staticLink.s2, this.rest);
    }
    
    Object lambda115(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLss.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, srfi13.lambda$Fn116, srfi13.lambda$Fn117);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 96)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 97)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame49
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn118 = new ModuleMethod(this, 102, null, 0);
    final ModuleMethod lambda$Fn119 = new ModuleMethod(this, 103, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 102) {
        return lambda118();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 103) {
        return lambda119(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda118()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Gr, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda119(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame50 localframe50 = new srfi13.frame50();
      localframe50.staticLink = this;
      localframe50.rest = paramObject1;
      localframe50.start1 = paramObject2;
      localframe50.end1 = paramObject3;
      return call_with_values.callWithValues(localframe50.lambda$Fn120, localframe50.lambda$Fn121);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 102)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 103)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame5
    extends ModuleBody
  {
    Object knil;
    Object kons;
    final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 12, null, 0);
    final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 13, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda13();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 13) {
        return lambda14(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda13()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfold, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda14(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.knil;
      for (;;)
      {
        if (Scheme.numLss.apply2(paramObject1, paramObject2) != Boolean.FALSE)
        {
          ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
          Object localObject3 = this.kons;
          Object localObject2 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject2;
          }
          catch (ClassCastException paramObject1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)paramObject1).intValue();
              localObject1 = localApplyToArgs.apply3(localObject3, Char.make(strings.stringRef(localCharSequence, i)), localObject1);
              paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
            }
            catch (ClassCastException paramObject2)
            {
              throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
            }
            paramObject1 = paramObject1;
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
          }
        }
      }
      return localObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 13)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame50
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn120 = new ModuleMethod(this, 100, null, 0);
    final ModuleMethod lambda$Fn121 = new ModuleMethod(this, 101, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame49 staticLink;
    
    static Boolean lambda122(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda123(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 100) {
        return lambda120();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 101) {
        return lambda121(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda120()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Gr, this.staticLink.s2, this.rest);
    }
    
    Object lambda121(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGrt.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn122, srfi13.lambda$Fn123, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 100)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 101)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame51
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn124 = new ModuleMethod(this, 106, null, 0);
    final ModuleMethod lambda$Fn125 = new ModuleMethod(this, 107, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 106) {
        return lambda124();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 107) {
        return lambda125(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda124()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Ls$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda125(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame52 localframe52 = new srfi13.frame52();
      localframe52.staticLink = this;
      localframe52.rest = paramObject1;
      localframe52.start1 = paramObject2;
      localframe52.end1 = paramObject3;
      return call_with_values.callWithValues(localframe52.lambda$Fn126, localframe52.lambda$Fn127);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 106)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 107)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame52
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn126 = new ModuleMethod(this, 104, null, 0);
    final ModuleMethod lambda$Fn127 = new ModuleMethod(this, 105, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame51 staticLink;
    
    static Boolean lambda128(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 104) {
        return lambda126();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 105) {
        return lambda127(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda126()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Ls$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda127(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numLEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, misc.values, misc.values, srfi13.lambda$Fn128);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 104)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 105)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame53
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn129 = new ModuleMethod(this, 110, null, 0);
    final ModuleMethod lambda$Fn130 = new ModuleMethod(this, 111, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object s1;
    Object s2;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 110) {
        return lambda129();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 111) {
        return lambda130(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda129()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnci$Gr$Eq, this.s1, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda130(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame54 localframe54 = new srfi13.frame54();
      localframe54.staticLink = this;
      localframe54.rest = paramObject1;
      localframe54.start1 = paramObject2;
      localframe54.end1 = paramObject3;
      return call_with_values.callWithValues(localframe54.lambda$Fn131, localframe54.lambda$Fn132);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 110)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 111)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame54
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn131 = new ModuleMethod(this, 108, null, 0);
    final ModuleMethod lambda$Fn132 = new ModuleMethod(this, 109, null, 8194);
    Object rest;
    Object start1;
    srfi13.frame53 staticLink;
    
    static Boolean lambda133(Object paramObject)
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 108) {
        return lambda131();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 109) {
        return lambda132(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda131()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Gr$Eq, this.staticLink.s2, this.rest);
    }
    
    Object lambda132(Object paramObject1, Object paramObject2)
    {
      int i;
      if (this.staticLink.s1 == this.staticLink.s2)
      {
        i = 1;
        if (i == 0) {
          break label57;
        }
        if (Scheme.numEqu.apply2(this.start1, paramObject1) == Boolean.FALSE) {
          break label61;
        }
      }
      label57:
      while (i != 0)
      {
        return Scheme.numGEq.apply2(this.end1, paramObject2);
        i = 0;
        break;
      }
      label61:
      return srfi13.$PcStringCompareCi(this.staticLink.s1, this.start1, this.end1, this.staticLink.s2, paramObject1, paramObject2, srfi13.lambda$Fn133, misc.values, misc.values);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 108)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 109)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame55
    extends ModuleBody
  {
    Object char$Mn$Grint;
  }
  
  public class frame56
    extends ModuleBody
  {
    Object bound;
    final ModuleMethod lambda$Fn134 = new ModuleMethod(this, 112, null, 0);
    final ModuleMethod lambda$Fn135 = new ModuleMethod(this, 113, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 112) {
        return lambda134();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 113) {
        return lambda135(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda134()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnhash;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 912, 55);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda135(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringHash(this.s, characters.char$Mn$Grinteger, this.bound, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 112)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 113)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame57
    extends ModuleBody
  {
    Object bound;
    final ModuleMethod lambda$Fn136 = new ModuleMethod(this, 114, null, 0);
    final ModuleMethod lambda$Fn137 = new ModuleMethod(this, 115, null, 8194);
    Object s;
    
    static int lambda138(Object paramObject)
    {
      try
      {
        Char localChar = (Char)paramObject;
        return characters.char$To$Integer(unicode.charDowncase(localChar));
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "char-downcase", 1, paramObject);
      }
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 114) {
        return lambda136();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 115) {
        return lambda137(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda136()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnhash$Mnci;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 921, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda137(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringHash(this.s, srfi13.lambda$Fn138, this.bound, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 114)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 115)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame58
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn139 = new ModuleMethod(this, 116, null, 0);
    final ModuleMethod lambda$Fn140 = new ModuleMethod(this, 117, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 116) {
        return lambda139();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 117) {
        return lambda140(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda139()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnupcase, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda140(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(unicode.char$Mnupcase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 116)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 117)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame59
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn141 = new ModuleMethod(this, 118, null, 0);
    final ModuleMethod lambda$Fn142 = new ModuleMethod(this, 119, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 118) {
        return lambda141();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 119) {
        return lambda142(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda141()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnupcase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda142(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(unicode.char$Mnupcase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 118)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 119)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame6
    extends ModuleBody
  {
    Object knil;
    Object kons;
    final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 14, null, 0);
    final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 15, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 14) {
        return lambda15();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 15) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfold$Mnright, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.knil;
      paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      for (;;)
      {
        if (Scheme.numGEq.apply2(paramObject2, paramObject1) != Boolean.FALSE)
        {
          ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
          Object localObject3 = this.kons;
          Object localObject2 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject2;
          }
          catch (ClassCastException paramObject1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)paramObject2).intValue();
              localObject1 = localApplyToArgs.apply3(localObject3, Char.make(strings.stringRef(localCharSequence, i)), localObject1);
              paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
            }
            catch (ClassCastException paramObject1)
            {
              throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
            }
            paramObject1 = paramObject1;
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
          }
        }
      }
      return localObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame60
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn143 = new ModuleMethod(this, 120, null, 0);
    final ModuleMethod lambda$Fn144 = new ModuleMethod(this, 121, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 120) {
        return lambda143();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 121) {
        return lambda144(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda143()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndowncase, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda144(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap(unicode.char$Mndowncase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 120)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 121)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame61
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn145 = new ModuleMethod(this, 122, null, 0);
    final ModuleMethod lambda$Fn146 = new ModuleMethod(this, 123, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 122) {
        return lambda145();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 123) {
        return lambda146(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda145()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndowncase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda146(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringMap$Ex(unicode.char$Mndowncase, this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 122)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 123)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame62
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn147 = new ModuleMethod(this, 124, null, 0);
    final ModuleMethod lambda$Fn148 = new ModuleMethod(this, 125, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 124) {
        return lambda147();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 125) {
        return lambda148(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda147()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mntitlecase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda148(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcStringTitlecase$Ex(this.s, paramObject1, paramObject2);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 124)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 125)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame63
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn149 = new ModuleMethod(this, 126, null, 0);
    final ModuleMethod lambda$Fn150 = new ModuleMethod(this, 127, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 126) {
        return lambda149();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 127) {
        return lambda150(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda149()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mntitlecase$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda150(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 53	gnu/kawa/slib/srfi13$frame63:s	Ljava/lang/Object;
      //   4: astore 5
      //   6: aload 5
      //   8: checkcast 63	java/lang/CharSequence
      //   11: astore 6
      //   13: aload_1
      //   14: checkcast 65	java/lang/Number
      //   17: invokevirtual 69	java/lang/Number:intValue	()I
      //   20: istore_3
      //   21: aload_2
      //   22: checkcast 65	java/lang/Number
      //   25: invokevirtual 69	java/lang/Number:intValue	()I
      //   28: istore 4
      //   30: aload 6
      //   32: iload_3
      //   33: iload 4
      //   35: invokestatic 75	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   38: astore 5
      //   40: aload 5
      //   42: getstatic 79	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   45: getstatic 85	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   48: aload_2
      //   49: aload_1
      //   50: invokevirtual 90	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: invokestatic 93	gnu/kawa/slib/srfi13:$PcStringTitlecase$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   56: pop
      //   57: aload 5
      //   59: areturn
      //   60: astore_1
      //   61: new 95	gnu/mapping/WrongType
      //   64: dup
      //   65: aload_1
      //   66: ldc 96
      //   68: iconst_1
      //   69: aload 5
      //   71: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   74: athrow
      //   75: astore_2
      //   76: new 95	gnu/mapping/WrongType
      //   79: dup
      //   80: aload_2
      //   81: ldc 96
      //   83: iconst_2
      //   84: aload_1
      //   85: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   88: athrow
      //   89: astore_1
      //   90: new 95	gnu/mapping/WrongType
      //   93: dup
      //   94: aload_1
      //   95: ldc 96
      //   97: iconst_3
      //   98: aload_2
      //   99: invokespecial 99	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   102: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	frame63
      //   0	103	1	paramObject1	Object
      //   0	103	2	paramObject2	Object
      //   20	13	3	i	int
      //   28	6	4	j	int
      //   4	66	5	localObject	Object
      //   11	20	6	localCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   6	13	60	java/lang/ClassCastException
      //   13	21	75	java/lang/ClassCastException
      //   21	30	89	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 126)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 127)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame64
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn151;
    Object n;
    Object s;
    
    public frame64()
    {
      this$1 = new ModuleMethod(this, 128, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:996");
      this.lambda$Fn151 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 128)
      {
        if (lambda151(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda151(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(this.n);
      boolean bool1 = bool2;
      NumberCompare localNumberCompare;
      IntNum localIntNum;
      Object localObject;
      if (bool2)
      {
        bool2 = numbers.isExact(this.n);
        bool1 = bool2;
        if (bool2)
        {
          localNumberCompare = Scheme.numLEq;
          localIntNum = srfi13.Lit0;
          localObject = this.n;
          paramObject = this.s;
        }
      }
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        bool1 = ((Boolean)localNumberCompare.apply3(localIntNum, localObject, Integer.valueOf(strings.stringLength(localCharSequence)))).booleanValue();
        return bool1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 128)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame65
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn152;
    int len;
    Object n;
    
    public frame65()
    {
      this$1 = new ModuleMethod(this, 129, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1004");
      this.lambda$Fn152 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 129)
      {
        if (lambda152(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda152(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(this.n);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(this.n);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 129)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame66
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn153;
    int len;
    Object n;
    
    public frame66()
    {
      this$1 = new ModuleMethod(this, 130, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1010");
      this.lambda$Fn153 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 130)
      {
        if (lambda153(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda153(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(this.n);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(this.n);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 130)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame67
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn154;
    int len;
    Object n;
    
    public frame67()
    {
      this$1 = new ModuleMethod(this, 131, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1016");
      this.lambda$Fn154 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 131)
      {
        if (lambda154(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda154(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(this.n);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(this.n);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, this.n, Integer.valueOf(this.len))).booleanValue();
        }
      }
      return bool1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 131)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame68
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn155 = new ModuleMethod(this, 132, null, 0);
    final ModuleMethod lambda$Fn156 = new ModuleMethod(this, 133, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 132) {
        return lambda155();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 133) {
        return lambda156(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda155()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1023, 53);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda156(Object paramObject1, Object paramObject2)
    {
      localObject1 = this.s;
      Object localObject2 = srfi13.loc$criterion;
      try
      {
        localObject2 = ((Location)localObject2).get();
        paramObject1 = srfi13.stringSkip$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (paramObject1 != Boolean.FALSE) {
          localObject1 = this.s;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        int i;
        int j;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1024, 29);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject2 = (CharSequence)localObject1;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%substring/shared", 0, localObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        return srfi13.$PcSubstring$SlShared((CharSequence)localObject2, i, j);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%substring/shared", 2, paramObject2);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 132)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 133)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame69
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn157 = new ModuleMethod(this, 134, null, 0);
    final ModuleMethod lambda$Fn158 = new ModuleMethod(this, 135, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 134) {
        return lambda157();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 135) {
        return lambda158(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda157()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim$Mnright;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1030, 59);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda158(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$criterion;
      try
      {
        localObject2 = ((Location)localObject2).get();
        localObject1 = srfi13.stringSkipRight$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (localObject1 != Boolean.FALSE) {
          paramObject1 = this.s;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        int i;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1031, 35);
        throw ((Throwable)paramObject1);
      }
      try
      {
        paramObject2 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Pl.apply2(srfi13.Lit1, localObject1);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 0, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        return srfi13.$PcSubstring$SlShared((CharSequence)paramObject2, 0, i);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 2, paramObject1);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 134)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 135)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame7
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 16, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 17, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 16) {
        return lambda19();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 17) {
        return lambda20(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda19()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfor$Mneach, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda20(Object paramObject1, Object paramObject2)
    {
      for (;;)
      {
        ApplyToArgs localApplyToArgs;
        Object localObject2;
        Object localObject1;
        if (Scheme.numLss.apply2(paramObject1, paramObject2) != Boolean.FALSE)
        {
          localApplyToArgs = Scheme.applyToArgs;
          localObject2 = this.proc;
          localObject1 = this.s;
        }
        try
        {
          localCharSequence = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          CharSequence localCharSequence;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          localApplyToArgs.apply2(localObject2, Char.make(strings.stringRef(localCharSequence, i)));
          paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 17)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame70
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn159 = new ModuleMethod(this, 136, null, 0);
    final ModuleMethod lambda$Fn160 = new ModuleMethod(this, 137, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 136) {
        return lambda159();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 137) {
        return lambda160(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda159()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntrim$Mnboth;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1037, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda160(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = this.s;
      localObject2 = srfi13.loc$criterion;
      try
      {
        localObject2 = ((Location)localObject2).get();
        paramObject1 = srfi13.stringSkip$V(localObject1, localObject2, new Object[] { paramObject1, paramObject2 });
        if (paramObject1 != Boolean.FALSE) {
          localObject2 = this.s;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        int i;
        IntNum localIntNum;
        Object localObject3;
        Object localObject4;
        int j;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1038, 29);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = (CharSequence)localObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%substring/shared", 0, localObject2);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        localObject2 = AddOp.$Pl;
        localIntNum = srfi13.Lit1;
        localObject3 = this.s;
        localObject4 = srfi13.loc$criterion;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 1, paramObject1);
      }
      try
      {
        localObject4 = ((Location)localObject4).get();
        paramObject1 = ((Procedure)localObject2).apply2(localIntNum, srfi13.stringSkipRight$V(localObject3, localObject4, new Object[] { paramObject1, paramObject2 }));
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1040, 58);
        throw ((Throwable)paramObject1);
      }
      try
      {
        j = ((Number)paramObject1).intValue();
        return srfi13.$PcSubstring$SlShared((CharSequence)localObject1, i, j);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 2, paramObject1);
      }
      return "";
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 136)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 137)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame71
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn161 = new ModuleMethod(this, 138, null, 0);
    final ModuleMethod lambda$Fn162 = new ModuleMethod(this, 139, null, 8194);
    Object n;
    Object s;
    
    static boolean lambda163(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 138) {
        return lambda161();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 139) {
        return lambda162(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda161()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnpad$Mnright;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1046, 58);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda162(Object paramObject1, Object paramObject2)
    {
      localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$check$Mnarg;
      try
      {
        localObject2 = ((Location)localObject2).get();
        ((Procedure)localObject1).apply4(localObject2, srfi13.lambda$Fn163, this.n, srfi13.string$Mnpad$Mnright);
        localObject1 = AddOp.$Mn.apply2(paramObject2, paramObject1);
        if (Scheme.numLEq.apply2(this.n, localObject1) != Boolean.FALSE) {
          paramObject2 = this.s;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        try
        {
          i = ((Number)localObject1).intValue();
          localObject2 = strings.makeString(i, LangPrimType.charType);
          localObject1 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          int j;
          CharSequence localCharSequence;
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
        }
        try
        {
          localCharSequence = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, localObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 3, paramObject1);
        }
        try
        {
          j = ((Number)paramObject2).intValue();
          srfi13.$PcStringCopy$Ex((CharSequence)localObject2, 0, localCharSequence, i, j);
          return localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 4, paramObject2);
        }
        paramObject1 = paramObject1;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1047, 7);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = (CharSequence)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%substring/shared", 0, paramObject2);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        paramObject1 = AddOp.$Pl.apply2(paramObject1, this.n);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject1).intValue();
        return srfi13.$PcSubstring$SlShared((CharSequence)localObject1, i, j);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 2, paramObject1);
      }
      localObject1 = this.n;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 138)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 139)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame72
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn164 = new ModuleMethod(this, 140, null, 0);
    final ModuleMethod lambda$Fn165 = new ModuleMethod(this, 141, null, 8194);
    Object n;
    Object s;
    
    static boolean lambda166(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, paramObject)).booleanValue();
        }
      }
      return bool1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 140) {
        return lambda164();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 141) {
        return lambda165(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda164()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mnpad;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1058, 52);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda165(Object paramObject1, Object paramObject2)
    {
      localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$check$Mnarg;
      try
      {
        localObject2 = ((Location)localObject2).get();
        ((Procedure)localObject1).apply4(localObject2, srfi13.lambda$Fn166, this.n, srfi13.string$Mnpad);
        localObject2 = AddOp.$Mn.apply2(paramObject2, paramObject1);
        if (Scheme.numLEq.apply2(this.n, localObject2) != Boolean.FALSE) {
          paramObject1 = this.s;
        }
      }
      catch (UnboundLocationException paramObject1)
      {
        try
        {
          i = ((Number)localObject1).intValue();
          localObject1 = strings.makeString(i, LangPrimType.charType);
          localObject2 = AddOp.$Mn.apply2(this.n, localObject2);
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          int j;
          CharSequence localCharSequence;
          int k;
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          localObject2 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 1, localObject2);
        }
        try
        {
          localCharSequence = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, localObject2);
        }
        try
        {
          j = ((Number)paramObject1).intValue();
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 3, paramObject1);
        }
        try
        {
          k = ((Number)paramObject2).intValue();
          srfi13.$PcStringCopy$Ex((CharSequence)localObject1, i, localCharSequence, j, k);
          return localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 4, paramObject2);
        }
        paramObject1 = paramObject1;
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1059, 7);
        throw ((Throwable)paramObject1);
      }
      try
      {
        localObject1 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Mn.apply2(paramObject2, this.n);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 0, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%substring/shared", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        return srfi13.$PcSubstring$SlShared((CharSequence)localObject1, i, j);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%substring/shared", 2, paramObject2);
      }
      localObject1 = this.n;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 140)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 141)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame73
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn167 = new ModuleMethod(this, 145, null, 0);
    final ModuleMethod lambda$Fn168 = new ModuleMethod(this, 146, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 145) {
        return lambda167();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 146) {
        return lambda168(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda167()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndelete, this.s, this.maybe$Mnstart$Plend);
    }
    
    CharSequence lambda168(Object paramObject1, Object paramObject2)
    {
      srfi13.frame74 localframe74 = new srfi13.frame74();
      localframe74.staticLink = this;
      if (misc.isProcedure(this.criterion)) {
        localObject1 = AddOp.$Mn.apply2(paramObject2, paramObject1);
      }
      try
      {
        i = ((Number)localObject1).intValue();
        localframe74.temp = strings.makeString(i);
        paramObject1 = srfi13.stringFold$V(localframe74.lambda$Fn169, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
        if (Scheme.numEqu.apply2(paramObject1, localObject1) != Boolean.FALSE) {
          return localframe74.temp;
        }
        paramObject2 = localframe74.temp;
      }
      catch (ClassCastException paramObject1)
      {
        int i;
        Object localObject2;
        throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        return strings.substring((CharSequence)paramObject2, 0, i);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "substring", 3, paramObject1);
      }
      localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = this.criterion;
            localframe74.cset = localObject1;
            localObject1 = srfi13.stringFold$V(localframe74.lambda$Fn170, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1096, 22);
          throw ((Throwable)paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          localframe74.ans = strings.makeString(i);
          srfi13.stringFold$V(localframe74.lambda$Fn171, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          return localframe74.ans;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
        }
        if (characters.isChar(this.criterion))
        {
          localObject1 = Scheme.applyToArgs;
          localObject2 = srfi13.loc$char$Mnset;
        }
        try
        {
          localObject2 = ((Location)localObject2).get();
          localObject1 = ((Procedure)localObject1).apply2(localObject2, this.criterion);
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1097, 26);
          throw ((Throwable)paramObject1);
        }
        localObject1 = misc.error$V("string-delete criterion not predicate, char or char-set", new Object[] { this.criterion });
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 145)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 146)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame74
    extends ModuleBody
  {
    CharSequence ans;
    Object cset;
    final ModuleMethod lambda$Fn169;
    final ModuleMethod lambda$Fn170;
    final ModuleMethod lambda$Fn171;
    srfi13.frame73 staticLink;
    CharSequence temp;
    
    public frame74()
    {
      this$1 = new ModuleMethod(this, 142, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1089");
      this.lambda$Fn169 = this$1;
      this$1 = new ModuleMethod(this, 143, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1099");
      this.lambda$Fn170 = this$1;
      this$1 = new ModuleMethod(this, 144, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1104");
      this.lambda$Fn171 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 142: 
        return lambda169(paramObject1, paramObject2);
      case 143: 
        return lambda170(paramObject1, paramObject2);
      }
      return lambda171(paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda169(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 77	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 79	gnu/kawa/slib/srfi13$frame74:staticLink	Lgnu/kawa/slib/srfi13$frame73;
      //   7: getfield 82	gnu/kawa/slib/srfi13$frame73:criterion	Ljava/lang/Object;
      //   10: aload_1
      //   11: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   17: if_acmpeq +5 -> 22
      //   20: aload_2
      //   21: areturn
      //   22: aload_0
      //   23: getfield 94	gnu/kawa/slib/srfi13$frame74:temp	Ljava/lang/CharSequence;
      //   26: astore 5
      //   28: aload 5
      //   30: checkcast 96	gnu/lists/CharSeq
      //   33: astore 6
      //   35: aload_2
      //   36: checkcast 98	java/lang/Number
      //   39: invokevirtual 102	java/lang/Number:intValue	()I
      //   42: istore 4
      //   44: aload_1
      //   45: checkcast 104	gnu/text/Char
      //   48: invokevirtual 108	gnu/text/Char:charValue	()C
      //   51: istore_3
      //   52: aload 6
      //   54: iload 4
      //   56: iload_3
      //   57: invokestatic 114	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   60: getstatic 120	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   63: aload_2
      //   64: getstatic 124	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   67: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   70: areturn
      //   71: astore_1
      //   72: new 126	gnu/mapping/WrongType
      //   75: dup
      //   76: aload_1
      //   77: ldc -128
      //   79: iconst_1
      //   80: aload 5
      //   82: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   85: athrow
      //   86: astore_1
      //   87: new 126	gnu/mapping/WrongType
      //   90: dup
      //   91: aload_1
      //   92: ldc -128
      //   94: iconst_2
      //   95: aload_2
      //   96: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   99: athrow
      //   100: astore_2
      //   101: new 126	gnu/mapping/WrongType
      //   104: dup
      //   105: aload_2
      //   106: ldc -128
      //   108: iconst_3
      //   109: aload_1
      //   110: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	frame74
      //   0	114	1	paramObject1	Object
      //   0	114	2	paramObject2	Object
      //   51	6	3	c	char
      //   42	13	4	i	int
      //   26	55	5	localCharSequence	CharSequence
      //   33	20	6	localCharSeq	CharSeq
      // Exception table:
      //   from	to	target	type
      //   28	35	71	java/lang/ClassCastException
      //   35	44	86	java/lang/ClassCastException
      //   44	52	100	java/lang/ClassCastException
    }
    
    Object lambda170(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject = srfi13.loc$char$Mnset$Mncontains$Qu;
      try
      {
        localObject = ((Location)localObject).get();
        if (localApplyToArgs.apply3(localObject, this.cset, paramObject1) != Boolean.FALSE) {
          return paramObject2;
        }
        return AddOp.$Pl.apply2(paramObject2, srfi13.Lit1);
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1099, 45);
        throw ((Throwable)paramObject1);
      }
    }
    
    /* Error */
    Object lambda171(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 77	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore 5
      //   5: getstatic 137	gnu/kawa/slib/srfi13:loc$char$Mnset$Mncontains$Qu	Lgnu/mapping/Location;
      //   8: astore 6
      //   10: aload 6
      //   12: invokevirtual 143	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   15: astore 6
      //   17: aload 5
      //   19: aload 6
      //   21: aload_0
      //   22: getfield 145	gnu/kawa/slib/srfi13$frame74:cset	Ljava/lang/Object;
      //   25: aload_1
      //   26: invokevirtual 149	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   29: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   32: if_acmpeq +5 -> 37
      //   35: aload_2
      //   36: areturn
      //   37: aload_0
      //   38: getfield 157	gnu/kawa/slib/srfi13$frame74:ans	Ljava/lang/CharSequence;
      //   41: astore 5
      //   43: aload 5
      //   45: checkcast 96	gnu/lists/CharSeq
      //   48: astore 6
      //   50: aload_2
      //   51: checkcast 98	java/lang/Number
      //   54: invokevirtual 102	java/lang/Number:intValue	()I
      //   57: istore 4
      //   59: aload_1
      //   60: checkcast 104	gnu/text/Char
      //   63: invokevirtual 108	gnu/text/Char:charValue	()C
      //   66: istore_3
      //   67: aload 6
      //   69: iload 4
      //   71: iload_3
      //   72: invokestatic 114	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   75: getstatic 120	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   78: aload_2
      //   79: getstatic 124	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   82: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   85: areturn
      //   86: astore_1
      //   87: aload_1
      //   88: ldc -105
      //   90: sipush 1104
      //   93: bipush 35
      //   95: invokevirtual 155	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   98: aload_1
      //   99: athrow
      //   100: astore_1
      //   101: new 126	gnu/mapping/WrongType
      //   104: dup
      //   105: aload_1
      //   106: ldc -128
      //   108: iconst_1
      //   109: aload 5
      //   111: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   114: athrow
      //   115: astore_1
      //   116: new 126	gnu/mapping/WrongType
      //   119: dup
      //   120: aload_1
      //   121: ldc -128
      //   123: iconst_2
      //   124: aload_2
      //   125: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   128: athrow
      //   129: astore_2
      //   130: new 126	gnu/mapping/WrongType
      //   133: dup
      //   134: aload_2
      //   135: ldc -128
      //   137: iconst_3
      //   138: aload_1
      //   139: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   142: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	143	0	this	frame74
      //   0	143	1	paramObject1	Object
      //   0	143	2	paramObject2	Object
      //   66	6	3	c	char
      //   57	13	4	i	int
      //   3	107	5	localObject1	Object
      //   8	60	6	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   10	17	86	gnu/mapping/UnboundLocationException
      //   43	50	100	java/lang/ClassCastException
      //   50	59	115	java/lang/ClassCastException
      //   59	67	129	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 144: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 143: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
  }
  
  public class frame75
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn172 = new ModuleMethod(this, 150, null, 0);
    final ModuleMethod lambda$Fn173 = new ModuleMethod(this, 151, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 150) {
        return lambda172();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 151) {
        return lambda173(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda172()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfilter, this.s, this.maybe$Mnstart$Plend);
    }
    
    CharSequence lambda173(Object paramObject1, Object paramObject2)
    {
      srfi13.frame76 localframe76 = new srfi13.frame76();
      localframe76.staticLink = this;
      if (misc.isProcedure(this.criterion)) {
        localObject1 = AddOp.$Mn.apply2(paramObject2, paramObject1);
      }
      try
      {
        i = ((Number)localObject1).intValue();
        localframe76.temp = strings.makeString(i);
        paramObject1 = srfi13.stringFold$V(localframe76.lambda$Fn174, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
        if (Scheme.numEqu.apply2(paramObject1, localObject1) != Boolean.FALSE) {
          return localframe76.temp;
        }
        paramObject2 = localframe76.temp;
      }
      catch (ClassCastException paramObject1)
      {
        int i;
        Object localObject2;
        throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        return strings.substring((CharSequence)paramObject2, 0, i);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "substring", 3, paramObject1);
      }
      localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = this.criterion;
            localframe76.cset = localObject1;
            localObject1 = srfi13.stringFold$V(localframe76.lambda$Fn175, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1124, 22);
          throw ((Throwable)paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          localframe76.ans = strings.makeString(i);
          srfi13.stringFold$V(localframe76.lambda$Fn176, srfi13.Lit0, this.s, new Object[] { paramObject1, paramObject2 });
          return localframe76.ans;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
        }
        if (characters.isChar(this.criterion))
        {
          localObject1 = Scheme.applyToArgs;
          localObject2 = srfi13.loc$char$Mnset;
        }
        try
        {
          localObject2 = ((Location)localObject2).get();
          localObject1 = ((Procedure)localObject1).apply2(localObject2, this.criterion);
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1125, 26);
          throw ((Throwable)paramObject1);
        }
        localObject1 = misc.error$V("string-delete criterion not predicate, char or char-set", new Object[] { this.criterion });
      }
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 150)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 151)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame76
    extends ModuleBody
  {
    CharSequence ans;
    Object cset;
    final ModuleMethod lambda$Fn174;
    final ModuleMethod lambda$Fn175;
    final ModuleMethod lambda$Fn176;
    srfi13.frame75 staticLink;
    CharSequence temp;
    
    public frame76()
    {
      this$1 = new ModuleMethod(this, 147, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1116");
      this.lambda$Fn174 = this$1;
      this$1 = new ModuleMethod(this, 148, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1128");
      this.lambda$Fn175 = this$1;
      this$1 = new ModuleMethod(this, 149, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1133");
      this.lambda$Fn176 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 147: 
        return lambda174(paramObject1, paramObject2);
      case 148: 
        return lambda175(paramObject1, paramObject2);
      }
      return lambda176(paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda174(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_2
      //   1: astore 5
      //   3: getstatic 77	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   6: aload_0
      //   7: getfield 79	gnu/kawa/slib/srfi13$frame76:staticLink	Lgnu/kawa/slib/srfi13$frame75;
      //   10: getfield 82	gnu/kawa/slib/srfi13$frame75:criterion	Ljava/lang/Object;
      //   13: aload_1
      //   14: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   17: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   20: if_acmpeq +53 -> 73
      //   23: aload_0
      //   24: getfield 94	gnu/kawa/slib/srfi13$frame76:temp	Ljava/lang/CharSequence;
      //   27: astore 5
      //   29: aload 5
      //   31: checkcast 96	gnu/lists/CharSeq
      //   34: astore 6
      //   36: aload_2
      //   37: checkcast 98	java/lang/Number
      //   40: invokevirtual 102	java/lang/Number:intValue	()I
      //   43: istore 4
      //   45: aload_1
      //   46: checkcast 104	gnu/text/Char
      //   49: invokevirtual 108	gnu/text/Char:charValue	()C
      //   52: istore_3
      //   53: aload 6
      //   55: iload 4
      //   57: iload_3
      //   58: invokestatic 114	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   61: getstatic 120	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   64: aload_2
      //   65: getstatic 124	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   68: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   71: astore 5
      //   73: aload 5
      //   75: areturn
      //   76: astore_1
      //   77: new 126	gnu/mapping/WrongType
      //   80: dup
      //   81: aload_1
      //   82: ldc -128
      //   84: iconst_1
      //   85: aload 5
      //   87: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   90: athrow
      //   91: astore_1
      //   92: new 126	gnu/mapping/WrongType
      //   95: dup
      //   96: aload_1
      //   97: ldc -128
      //   99: iconst_2
      //   100: aload_2
      //   101: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   104: athrow
      //   105: astore_2
      //   106: new 126	gnu/mapping/WrongType
      //   109: dup
      //   110: aload_2
      //   111: ldc -128
      //   113: iconst_3
      //   114: aload_1
      //   115: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	frame76
      //   0	119	1	paramObject1	Object
      //   0	119	2	paramObject2	Object
      //   52	6	3	c	char
      //   43	13	4	i	int
      //   1	85	5	localObject	Object
      //   34	20	6	localCharSeq	CharSeq
      // Exception table:
      //   from	to	target	type
      //   29	36	76	java/lang/ClassCastException
      //   36	45	91	java/lang/ClassCastException
      //   45	53	105	java/lang/ClassCastException
    }
    
    Object lambda175(Object paramObject1, Object paramObject2)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject1 = srfi13.loc$char$Mnset$Mncontains$Qu;
      try
      {
        Object localObject2 = ((Location)localObject1).get();
        localObject1 = paramObject2;
        if (localApplyToArgs.apply3(localObject2, this.cset, paramObject1) != Boolean.FALSE) {
          localObject1 = AddOp.$Pl.apply2(paramObject2, srfi13.Lit1);
        }
        return localObject1;
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1128, 45);
        throw ((Throwable)paramObject1);
      }
    }
    
    /* Error */
    Object lambda176(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 77	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore 6
      //   5: getstatic 137	gnu/kawa/slib/srfi13:loc$char$Mnset$Mncontains$Qu	Lgnu/mapping/Location;
      //   8: astore 5
      //   10: aload 5
      //   12: invokevirtual 143	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   15: astore 7
      //   17: aload_2
      //   18: astore 5
      //   20: aload 6
      //   22: aload 7
      //   24: aload_0
      //   25: getfield 145	gnu/kawa/slib/srfi13$frame76:cset	Ljava/lang/Object;
      //   28: aload_1
      //   29: invokevirtual 149	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   32: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   35: if_acmpeq +53 -> 88
      //   38: aload_0
      //   39: getfield 157	gnu/kawa/slib/srfi13$frame76:ans	Ljava/lang/CharSequence;
      //   42: astore 5
      //   44: aload 5
      //   46: checkcast 96	gnu/lists/CharSeq
      //   49: astore 6
      //   51: aload_2
      //   52: checkcast 98	java/lang/Number
      //   55: invokevirtual 102	java/lang/Number:intValue	()I
      //   58: istore 4
      //   60: aload_1
      //   61: checkcast 104	gnu/text/Char
      //   64: invokevirtual 108	gnu/text/Char:charValue	()C
      //   67: istore_3
      //   68: aload 6
      //   70: iload 4
      //   72: iload_3
      //   73: invokestatic 114	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   76: getstatic 120	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   79: aload_2
      //   80: getstatic 124	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   83: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   86: astore 5
      //   88: aload 5
      //   90: areturn
      //   91: astore_1
      //   92: aload_1
      //   93: ldc -105
      //   95: sipush 1133
      //   98: bipush 35
      //   100: invokevirtual 155	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   103: aload_1
      //   104: athrow
      //   105: astore_1
      //   106: new 126	gnu/mapping/WrongType
      //   109: dup
      //   110: aload_1
      //   111: ldc -128
      //   113: iconst_1
      //   114: aload 5
      //   116: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   119: athrow
      //   120: astore_1
      //   121: new 126	gnu/mapping/WrongType
      //   124: dup
      //   125: aload_1
      //   126: ldc -128
      //   128: iconst_2
      //   129: aload_2
      //   130: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   133: athrow
      //   134: astore_2
      //   135: new 126	gnu/mapping/WrongType
      //   138: dup
      //   139: aload_2
      //   140: ldc -128
      //   142: iconst_3
      //   143: aload_1
      //   144: invokespecial 131	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	frame76
      //   0	148	1	paramObject1	Object
      //   0	148	2	paramObject2	Object
      //   67	6	3	c	char
      //   58	13	4	i	int
      //   8	107	5	localObject1	Object
      //   3	66	6	localObject2	Object
      //   15	8	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   10	17	91	gnu/mapping/UnboundLocationException
      //   44	51	105	java/lang/ClassCastException
      //   51	60	120	java/lang/ClassCastException
      //   60	68	134	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 149: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 148: 
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
  }
  
  public class frame77
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn177 = new ModuleMethod(this, 152, null, 0);
    final ModuleMethod lambda$Fn178 = new ModuleMethod(this, 153, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 152) {
        return lambda177();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 153) {
        return lambda178(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda177()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda178(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion)) {
        localObject1 = Scheme.numLss.apply2(paramObject1, paramObject2);
      }
      for (;;)
      {
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool) {
            localObject2 = this.criterion;
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject1 = (Char)localObject2;
          localObject2 = this.str;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "char=?", 1, localObject2);
        }
        try
        {
          localObject3 = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          if (characters.isChar$Eq((Char)localObject1, Char.make(strings.stringRef((CharSequence)localObject3, i)))) {
            return paramObject1;
          }
          paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        localObject1 = Scheme.applyToArgs;
        Object localObject2 = srfi13.loc$char$Mnset$Qu;
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = paramObject1;
            paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1159, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            paramObject1 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject3 = ((Location)paramObject1).get();
          localObject4 = this.criterion;
          paramObject1 = this.str;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1162, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject2).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE) {
            continue;
          }
          localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject1 = paramObject1;
        paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            localObject3 = this.criterion;
            paramObject1 = this.str;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject4 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject2).apply2(localObject3, Char.make(strings.stringRef((CharSequence)localObject4, i))) == Boolean.FALSE) {
            localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] { srfi13.string$Mnindex, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 152)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 153)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame78
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn179 = new ModuleMethod(this, 154, null, 0);
    final ModuleMethod lambda$Fn180 = new ModuleMethod(this, 155, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 154) {
        return lambda179();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 155) {
        return lambda180(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda179()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex$Mnright, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda180(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        localObject1 = Scheme.numGEq.apply2(paramObject2, paramObject1);
      }
      for (;;)
      {
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool) {
            localObject2 = this.criterion;
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject1 = (Char)localObject2;
          localObject2 = this.str;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "char=?", 1, localObject2);
        }
        try
        {
          localObject3 = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          if (characters.isChar$Eq((Char)localObject1, Char.make(strings.stringRef((CharSequence)localObject3, i)))) {
            return paramObject2;
          }
          paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        localObject1 = Scheme.applyToArgs;
        Object localObject2 = srfi13.loc$char$Mnset$Qu;
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
            paramObject2 = Scheme.numGEq.apply2(localObject1, paramObject1);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1179, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)paramObject2).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            paramObject2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject2);
        }
        try
        {
          localObject3 = ((Location)paramObject2).get();
          localObject4 = this.criterion;
          paramObject2 = this.str;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1182, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject2 = localObject1;
          if (((Procedure)localObject2).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE) {
            continue;
          }
          localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        paramObject2 = Scheme.numGEq.apply2(localObject1, paramObject1);
        try
        {
          bool = ((Boolean)paramObject2).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            localObject3 = this.criterion;
            paramObject2 = this.str;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject2);
        }
        try
        {
          localObject4 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject2 = localObject1;
          if (((Procedure)localObject2).apply2(localObject3, Char.make(strings.stringRef((CharSequence)localObject4, i))) == Boolean.FALSE) {
            localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] { srfi13.string$Mnindex$Mnright, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 154)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 155)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame79
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn181 = new ModuleMethod(this, 156, null, 0);
    final ModuleMethod lambda$Fn182 = new ModuleMethod(this, 157, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 156) {
        return lambda181();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 157) {
        return lambda182(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda181()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnskip, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda182(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject1 = paramObject1;
        paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
      }
      for (;;)
      {
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool) {
            paramObject1 = this.criterion;
          }
        }
        catch (ClassCastException paramObject2)
        {
          boolean bool;
          Object localObject2;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject2 = (Char)paramObject1;
          paramObject1 = this.str;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "char=?", 1, paramObject1);
        }
        try
        {
          localObject3 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject1 = localObject1;
          if (characters.isChar$Eq((Char)localObject2, Char.make(strings.stringRef((CharSequence)localObject3, i))))
          {
            localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
            break;
            if (!bool) {
              continue;
            }
            paramObject1 = Boolean.TRUE;
          }
          return paramObject1;
          return Boolean.FALSE;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        localObject1 = Scheme.applyToArgs;
        localObject2 = srfi13.loc$char$Mnset$Qu;
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = paramObject1;
            paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1200, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            paramObject1 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject3 = ((Location)paramObject1).get();
          localObject4 = this.criterion;
          paramObject1 = this.str;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1203, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject2).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i))) == Boolean.FALSE) {
            continue;
          }
          localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject1 = paramObject1;
        paramObject1 = Scheme.numLss.apply2(localObject1, paramObject2);
        try
        {
          bool = ((Boolean)paramObject1).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            localObject3 = this.criterion;
            paramObject1 = this.str;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject4 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject2).apply2(localObject3, Char.make(strings.stringRef((CharSequence)localObject4, i))) != Boolean.FALSE) {
            localObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] { srfi13.string$Mnskip, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 156)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 157)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame8
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 18, null, 0);
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 19, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 18) {
        return lambda21();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 19) {
        return lambda22(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda21()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfor$Mneach$Mnindex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda22(Object paramObject1, Object paramObject2)
    {
      while (Scheme.numLss.apply2(paramObject1, paramObject2) != Boolean.FALSE)
      {
        Scheme.applyToArgs.apply2(this.proc, paramObject1);
        paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 19)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame80
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn183 = new ModuleMethod(this, 158, null, 0);
    final ModuleMethod lambda$Fn184 = new ModuleMethod(this, 159, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 158) {
        return lambda183();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 159) {
        return lambda184(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda183()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnskip$Mnright, this.str, this.maybe$Mnstart$Plend);
    }
    
    Object lambda184(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        paramObject2 = Scheme.numGEq.apply2(localObject1, paramObject1);
      }
      for (;;)
      {
        try
        {
          bool = ((Boolean)paramObject2).booleanValue();
          if (bool) {
            paramObject2 = this.criterion;
          }
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool;
          Object localObject2;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject2);
        }
        try
        {
          localObject2 = (Char)paramObject2;
          paramObject2 = this.str;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "char=?", 1, paramObject2);
        }
        try
        {
          localObject3 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject2 = localObject1;
          if (characters.isChar$Eq((Char)localObject2, Char.make(strings.stringRef((CharSequence)localObject3, i))))
          {
            localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
            break;
            if (!bool) {
              continue;
            }
            paramObject2 = Boolean.TRUE;
          }
          return paramObject2;
          return Boolean.FALSE;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        localObject1 = Scheme.applyToArgs;
        localObject2 = srfi13.loc$char$Mnset$Qu;
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
            paramObject2 = Scheme.numGEq.apply2(localObject1, paramObject1);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1222, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)paramObject2).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            paramObject2 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject2);
        }
        try
        {
          localObject3 = ((Location)paramObject2).get();
          localObject4 = this.criterion;
          paramObject2 = this.str;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1225, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject2 = localObject1;
          if (((Procedure)localObject2).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i))) == Boolean.FALSE) {
            continue;
          }
          localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
        if (!misc.isProcedure(this.criterion)) {
          continue;
        }
        localObject1 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        paramObject2 = Scheme.numGEq.apply2(localObject1, paramObject1);
        try
        {
          bool = ((Boolean)paramObject2).booleanValue();
          if (bool)
          {
            localObject2 = Scheme.applyToArgs;
            localObject3 = this.criterion;
            paramObject2 = this.str;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject2);
        }
        try
        {
          localObject4 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          paramObject2 = localObject1;
          if (((Procedure)localObject2).apply2(localObject3, Char.make(strings.stringRef((CharSequence)localObject4, i))) != Boolean.FALSE) {
            localObject1 = AddOp.$Mn.apply2(localObject1, srfi13.Lit1);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return misc.error$V("CRITERION param is neither char-set or char.", new Object[] { srfi13.string$Mnskip$Mnright, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 158)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 159)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame81
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn185 = new ModuleMethod(this, 160, null, 0);
    final ModuleMethod lambda$Fn186 = new ModuleMethod(this, 161, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 160) {
        return lambda185();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 161) {
        return lambda186(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda185()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncount, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda186(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion))
      {
        localObject1 = srfi13.Lit0;
        localObject2 = paramObject1;
      }
      for (;;)
      {
        paramObject1 = localObject1;
        if (Scheme.numGEq.apply2(localObject2, paramObject2) != Boolean.FALSE) {
          break label435;
        }
        Object localObject3 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
        paramObject1 = this.criterion;
        try
        {
          localObject4 = (Char)paramObject1;
          paramObject1 = this.s;
        }
        catch (ClassCastException paramObject2)
        {
          Object localObject4;
          Object localObject5;
          int i;
          throw new WrongType((ClassCastException)paramObject2, "char=?", 1, paramObject1);
        }
        try
        {
          localObject5 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          paramObject1 = localObject1;
          if (characters.isChar$Eq((Char)localObject4, Char.make(strings.stringRef((CharSequence)localObject5, i)))) {
            paramObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
          }
          localObject2 = localObject3;
          localObject1 = paramObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
        }
      }
      Object localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE)
          {
            localObject1 = srfi13.Lit0;
            localObject2 = paramObject1;
            paramObject1 = localObject1;
            if (Scheme.numGEq.apply2(localObject2, paramObject2) != Boolean.FALSE) {
              continue;
            }
            localObject3 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
            localObject4 = Scheme.applyToArgs;
            paramObject1 = srfi13.loc$char$Mnset$Mncontains$Qu;
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject6;
          CharSequence localCharSequence;
          label435:
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1246, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localObject5 = ((Location)paramObject1).get();
          localObject6 = this.criterion;
          paramObject1 = this.s;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1248, 16);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject4).apply3(localObject5, localObject6, Char.make(strings.stringRef(localCharSequence, i))) != Boolean.FALSE) {
            paramObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
          }
          localObject2 = localObject3;
          localObject1 = paramObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
        }
      }
      if (misc.isProcedure(this.criterion))
      {
        localObject1 = srfi13.Lit0;
        localObject2 = paramObject1;
      }
      for (;;)
      {
        paramObject1 = localObject1;
        if (Scheme.numGEq.apply2(localObject2, paramObject2) != Boolean.FALSE) {
          break label435;
        }
        localObject3 = AddOp.$Pl.apply2(localObject2, srfi13.Lit1);
        localObject4 = Scheme.applyToArgs;
        localObject5 = this.criterion;
        paramObject1 = this.s;
        try
        {
          localObject6 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          paramObject1 = localObject1;
          if (((Procedure)localObject4).apply2(localObject5, Char.make(strings.stringRef((CharSequence)localObject6, i))) != Boolean.FALSE) {
            paramObject1 = AddOp.$Pl.apply2(localObject1, srfi13.Lit1);
          }
          localObject2 = localObject3;
          localObject1 = paramObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
        }
      }
      paramObject1 = misc.error$V("CRITERION param is neither char-set or char.", new Object[] { srfi13.string$Mncount, this.criterion });
      return paramObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 160)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 161)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame82
    extends ModuleBody
  {
    Object jdField_char;
    final ModuleMethod lambda$Fn187 = new ModuleMethod(this, 162, null, 0);
    final ModuleMethod lambda$Fn188 = new ModuleMethod(this, 163, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 162) {
        return lambda187();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 163) {
        return lambda188(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda187()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfill$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda188(Object paramObject1, Object paramObject2)
    {
      paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      for (;;)
      {
        Object localObject;
        if (Scheme.numLss.apply2(paramObject2, paramObject1) == Boolean.FALSE) {
          localObject = this.s;
        }
        try
        {
          localCharSeq = (CharSeq)localObject;
        }
        catch (ClassCastException paramObject1)
        {
          CharSeq localCharSeq;
          int i;
          char c;
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          localObject = this.jdField_char;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramObject2);
        }
        try
        {
          c = ((Char)localObject).charValue();
          strings.stringSet$Ex(localCharSeq, i, c);
          paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 3, localObject);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 162)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 163)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame83
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn189 = new ModuleMethod(this, 166, null, 0);
    final ModuleMethod lambda$Fn190 = new ModuleMethod(this, 167, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object pattern;
    Object text;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 166) {
        return lambda189();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 167) {
        return lambda190(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda189()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncontains, this.text, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda190(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame84 localframe84 = new srfi13.frame84();
      localframe84.staticLink = this;
      localframe84.rest = paramObject1;
      localframe84.t$Mnstart = paramObject2;
      localframe84.t$Mnend = paramObject3;
      return call_with_values.callWithValues(localframe84.lambda$Fn191, localframe84.lambda$Fn192);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 166)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 167)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame84
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn191 = new ModuleMethod(this, 164, null, 0);
    final ModuleMethod lambda$Fn192 = new ModuleMethod(this, 165, null, 8194);
    Object rest;
    srfi13.frame83 staticLink;
    Object t$Mnend;
    Object t$Mnstart;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 164) {
        return lambda191();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 165) {
        return lambda192(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda191()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains, this.staticLink.pattern, this.rest);
    }
    
    Object lambda192(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcKmpSearch(this.staticLink.pattern, this.staticLink.text, characters.char$Eq$Qu, paramObject1, paramObject2, this.t$Mnstart, this.t$Mnend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 164)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 165)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame85
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn193 = new ModuleMethod(this, 170, null, 0);
    final ModuleMethod lambda$Fn194 = new ModuleMethod(this, 171, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object pattern;
    Object text;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 170) {
        return lambda193();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 171) {
        return lambda194(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda193()
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mncontains$Mnci, this.text, this.maybe$Mnstarts$Plends);
    }
    
    Object lambda194(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      srfi13.frame86 localframe86 = new srfi13.frame86();
      localframe86.staticLink = this;
      localframe86.rest = paramObject1;
      localframe86.t$Mnstart = paramObject2;
      localframe86.t$Mnend = paramObject3;
      return call_with_values.callWithValues(localframe86.lambda$Fn195, localframe86.lambda$Fn196);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 170)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 171)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame86
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn195 = new ModuleMethod(this, 168, null, 0);
    final ModuleMethod lambda$Fn196 = new ModuleMethod(this, 169, null, 8194);
    Object rest;
    srfi13.frame85 staticLink;
    Object t$Mnend;
    Object t$Mnstart;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 168) {
        return lambda195();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 169) {
        return lambda196(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda195()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains$Mnci, this.staticLink.pattern, this.rest);
    }
    
    Object lambda196(Object paramObject1, Object paramObject2)
    {
      return srfi13.$PcKmpSearch(this.staticLink.pattern, this.staticLink.text, unicode.char$Mnci$Eq$Qu, paramObject1, paramObject2, this.t$Mnstart, this.t$Mnend);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 168)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 169)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame87
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn197;
    Object pattern;
    
    public frame87()
    {
      this$1 = new ModuleMethod(this, 172, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1399");
      this.lambda$Fn197 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 172) {
        return lambda197(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda197(Object paramObject)
    {
      return srfi13.stringParseStart$PlEnd(srfi13.make$Mnkmp$Mnrestart$Mnvector, this.pattern, paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 172)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame88
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn198;
    final ModuleMethod lambda$Fn199;
    int patlen;
    Object s;
    
    public frame88()
    {
      this$1 = new ModuleMethod(this, 173, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1468");
      this.lambda$Fn198 = this$1;
      this$1 = new ModuleMethod(this, 174, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1472");
      this.lambda$Fn199 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 173: 
        return lambda198(paramObject);
      }
      if (lambda199(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    Object lambda198(Object paramObject)
    {
      return srfi13.stringParseStart$PlEnd(srfi13.string$Mnkmp$Mnpartial$Mnsearch, this.s, paramObject);
    }
    
    boolean lambda199(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      Object localObject;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          localObject = Scheme.numLEq.apply2(srfi13.Lit0, paramObject);
        }
      }
      try
      {
        bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLss.apply2(paramObject, Integer.valueOf(this.patlen))).booleanValue();
        }
        return bool1;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "x", -2, localObject);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 174: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
  }
  
  public class frame89
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn200 = new ModuleMethod(this, 175, null, 0);
    final ModuleMethod lambda$Fn201 = new ModuleMethod(this, 176, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 175) {
        return lambda200();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 176) {
        return lambda201(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda200()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreverse, this.s, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda201(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 67	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   3: aload_2
      //   4: aload_1
      //   5: invokevirtual 72	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   8: astore_2
      //   9: aload_2
      //   10: checkcast 74	java/lang/Number
      //   13: invokevirtual 78	java/lang/Number:intValue	()I
      //   16: istore_3
      //   17: iload_3
      //   18: invokestatic 84	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
      //   21: astore 6
      //   23: getstatic 67	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   26: aload_2
      //   27: getstatic 88	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   30: invokevirtual 72	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   33: astore 5
      //   35: aload_1
      //   36: astore_2
      //   37: aload 5
      //   39: astore_1
      //   40: getstatic 94	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   43: aload_1
      //   44: getstatic 97	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   47: invokevirtual 72	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   50: getstatic 103	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   53: if_acmpne +150 -> 203
      //   56: aload 6
      //   58: checkcast 105	gnu/lists/CharSeq
      //   61: astore 7
      //   63: aload_1
      //   64: checkcast 74	java/lang/Number
      //   67: invokevirtual 78	java/lang/Number:intValue	()I
      //   70: istore_3
      //   71: aload_0
      //   72: getfield 53	gnu/kawa/slib/srfi13$frame89:s	Ljava/lang/Object;
      //   75: astore 5
      //   77: aload 5
      //   79: checkcast 107	java/lang/CharSequence
      //   82: astore 8
      //   84: aload_2
      //   85: checkcast 74	java/lang/Number
      //   88: invokevirtual 78	java/lang/Number:intValue	()I
      //   91: istore 4
      //   93: aload 7
      //   95: iload_3
      //   96: aload 8
      //   98: iload 4
      //   100: invokestatic 111	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   103: invokestatic 115	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   106: getstatic 118	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   109: aload_2
      //   110: getstatic 88	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   113: invokevirtual 72	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   116: astore_2
      //   117: getstatic 67	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   120: aload_1
      //   121: getstatic 88	gnu/kawa/slib/srfi13:Lit1	Lgnu/math/IntNum;
      //   124: invokevirtual 72	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   127: astore_1
      //   128: goto -88 -> 40
      //   131: astore_1
      //   132: new 120	gnu/mapping/WrongType
      //   135: dup
      //   136: aload_1
      //   137: ldc 122
      //   139: iconst_1
      //   140: aload_2
      //   141: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   144: athrow
      //   145: astore_1
      //   146: new 120	gnu/mapping/WrongType
      //   149: dup
      //   150: aload_1
      //   151: ldc 127
      //   153: iconst_1
      //   154: aload 6
      //   156: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   159: athrow
      //   160: astore_2
      //   161: new 120	gnu/mapping/WrongType
      //   164: dup
      //   165: aload_2
      //   166: ldc 127
      //   168: iconst_2
      //   169: aload_1
      //   170: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   173: athrow
      //   174: astore_1
      //   175: new 120	gnu/mapping/WrongType
      //   178: dup
      //   179: aload_1
      //   180: ldc -127
      //   182: iconst_1
      //   183: aload 5
      //   185: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   188: athrow
      //   189: astore_1
      //   190: new 120	gnu/mapping/WrongType
      //   193: dup
      //   194: aload_1
      //   195: ldc -127
      //   197: iconst_2
      //   198: aload_2
      //   199: invokespecial 125	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   202: athrow
      //   203: aload 6
      //   205: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	206	0	this	frame89
      //   0	206	1	paramObject1	Object
      //   0	206	2	paramObject2	Object
      //   16	80	3	i	int
      //   91	8	4	j	int
      //   33	151	5	localObject	Object
      //   21	183	6	localCharSequence1	CharSequence
      //   61	33	7	localCharSeq	CharSeq
      //   82	15	8	localCharSequence2	CharSequence
      // Exception table:
      //   from	to	target	type
      //   9	17	131	java/lang/ClassCastException
      //   56	63	145	java/lang/ClassCastException
      //   63	71	160	java/lang/ClassCastException
      //   77	84	174	java/lang/ClassCastException
      //   84	93	189	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 175)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 176)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame9
    extends ModuleBody
  {
    Object criterion;
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 20, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 21, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 20) {
        return lambda23();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 21) {
        return lambda24(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda23()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnevery, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda24(Object paramObject1, Object paramObject2)
    {
      if (characters.isChar(this.criterion)) {}
      for (;;)
      {
        localObject1 = Scheme.numGEq.apply2(paramObject1, paramObject2);
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            if (bool) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localObject2 = this.criterion;
        }
        catch (ClassCastException paramObject1)
        {
          boolean bool;
          Object localObject3;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject1 = (Char)localObject2;
          localObject2 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "char=?", 1, localObject2);
        }
        try
        {
          localObject3 = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          bool = characters.isChar$Eq((Char)localObject1, Char.make(strings.stringRef((CharSequence)localObject3, i)));
          if (bool)
          {
            paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
          }
          else
          {
            if (bool) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      localObject1 = Scheme.applyToArgs;
      localObject2 = srfi13.loc$char$Mnset$Qu;
      for (;;)
      {
        try
        {
          localObject2 = ((Location)localObject2).get();
          if (((Procedure)localObject1).apply2(localObject2, this.criterion) != Boolean.FALSE) {
            localObject1 = Scheme.numGEq.apply2(paramObject1, paramObject2);
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          Object localObject4;
          CharSequence localCharSequence;
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 489, 5);
          throw ((Throwable)paramObject1);
        }
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            if (bool) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localObject1 = Scheme.applyToArgs;
          localObject2 = srfi13.loc$char$Mnset$Mncontains$Qu;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject3 = ((Location)localObject2).get();
          localObject4 = this.criterion;
          localObject2 = this.s;
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 492, 9);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localCharSequence = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          localObject1 = ((Procedure)localObject1).apply3(localObject3, localObject4, Char.make(strings.stringRef(localCharSequence, i)));
          if (localObject1 != Boolean.FALSE) {
            paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
          } else {
            return localObject1;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      if (misc.isProcedure(this.criterion)) {
        localObject1 = Scheme.numEqu.apply2(paramObject1, paramObject2);
      }
      for (;;)
      {
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            if (bool) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
          localObject1 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
        try
        {
          localObject2 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          i = strings.stringRef((CharSequence)localObject2, i);
          paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
          if (Scheme.numEqu.apply2(paramObject1, paramObject2) != Boolean.FALSE) {
            return Scheme.applyToArgs.apply2(this.criterion, Char.make(i));
          }
          localObject1 = Scheme.applyToArgs.apply2(this.criterion, Char.make(i));
          if (localObject1 == Boolean.FALSE) {
            return localObject1;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] { srfi13.string$Mnevery, this.criterion });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame90
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn202 = new ModuleMethod(this, 177, null, 0);
    final ModuleMethod lambda$Fn203 = new ModuleMethod(this, 178, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 177) {
        return lambda202();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 178) {
        return lambda203(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda202()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreverse$Ex, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda203(Object paramObject1, Object paramObject2)
    {
      paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      for (;;)
      {
        Object localObject1;
        if (Scheme.numLEq.apply2(paramObject2, paramObject1) == Boolean.FALSE) {
          localObject1 = this.s;
        }
        Object localObject2;
        try
        {
          localObject2 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          char c;
          CharSequence localCharSequence;
          int j;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          c = strings.stringRef((CharSequence)localObject2, i);
          localObject2 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
        }
        try
        {
          localObject1 = (CharSeq)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject2);
        }
        try
        {
          i = ((Number)paramObject2).intValue();
          localObject2 = this.s;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 2, paramObject2);
        }
        try
        {
          localCharSequence = (CharSequence)localObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject2);
        }
        try
        {
          j = ((Number)paramObject1).intValue();
          strings.stringSet$Ex((CharSeq)localObject1, i, strings.stringRef(localCharSequence, j));
          localObject1 = this.s;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        try
        {
          localObject2 = (CharSeq)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-set!", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          strings.stringSet$Ex((CharSeq)localObject2, i, c);
          paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
          paramObject1 = AddOp.$Pl.apply2(paramObject1, srfi13.Lit1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-set!", 2, paramObject1);
        }
      }
      return Values.empty;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 177)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 178)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame91
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn204 = new ModuleMethod(this, 179, null, 0);
    final ModuleMethod lambda$Fn205 = new ModuleMethod(this, 180, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 179) {
        return lambda204();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 180) {
        return lambda205(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda204()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mn$Grlist, this.s, this.maybe$Mnstart$Plend);
    }
    
    Object lambda205(Object paramObject1, Object paramObject2)
    {
      paramObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
      Object localObject1 = LList.Empty;
      for (;;)
      {
        if (Scheme.numLss.apply2(paramObject2, paramObject1) == Boolean.FALSE)
        {
          Object localObject2 = AddOp.$Mn.apply2(paramObject2, srfi13.Lit1);
          Object localObject3 = this.s;
          try
          {
            localCharSequence = (CharSequence)localObject3;
          }
          catch (ClassCastException paramObject1)
          {
            try
            {
              CharSequence localCharSequence;
              int i = ((Number)paramObject2).intValue();
              localObject1 = lists.cons(Char.make(strings.stringRef(localCharSequence, i)), localObject1);
              paramObject2 = localObject2;
            }
            catch (ClassCastException paramObject1)
            {
              throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
            }
            paramObject1 = paramObject1;
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject3);
          }
        }
      }
      return localObject1;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 179)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 180)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame92
    extends ModuleBody
  {
    Object end1;
    final ModuleMethod lambda$Fn206 = new ModuleMethod(this, 181, null, 0);
    final ModuleMethod lambda$Fn207 = new ModuleMethod(this, 182, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s1;
    Object s2;
    Object start1;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 181) {
        return lambda206();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 182) {
        return lambda207(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda206()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreplace, this.s2, this.maybe$Mnstart$Plend);
    }
    
    /* Error */
    CharSequence lambda207(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 66	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   4: astore 7
      //   6: aload 7
      //   8: checkcast 68	java/lang/CharSequence
      //   11: astore 8
      //   13: aload 8
      //   15: invokestatic 74	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   18: istore_3
      //   19: getstatic 80	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   22: aload_2
      //   23: aload_1
      //   24: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   27: astore 8
      //   29: getstatic 88	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   32: getstatic 80	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   35: iload_3
      //   36: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   39: getstatic 80	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   42: aload_0
      //   43: getfield 96	gnu/kawa/slib/srfi13$frame92:end1	Ljava/lang/Object;
      //   46: aload_0
      //   47: getfield 98	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   50: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   56: aload 8
      //   58: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   61: astore 7
      //   63: aload 7
      //   65: checkcast 100	java/lang/Number
      //   68: invokevirtual 104	java/lang/Number:intValue	()I
      //   71: istore 4
      //   73: iload 4
      //   75: invokestatic 108	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
      //   78: astore 7
      //   80: aload_0
      //   81: getfield 66	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   84: astore 9
      //   86: aload 9
      //   88: checkcast 68	java/lang/CharSequence
      //   91: astore 10
      //   93: aload_0
      //   94: getfield 98	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   97: astore 9
      //   99: aload 9
      //   101: checkcast 100	java/lang/Number
      //   104: invokevirtual 104	java/lang/Number:intValue	()I
      //   107: istore 4
      //   109: aload 7
      //   111: iconst_0
      //   112: aload 10
      //   114: iconst_0
      //   115: iload 4
      //   117: invokestatic 112	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   120: pop
      //   121: aload_0
      //   122: getfield 98	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   125: astore 9
      //   127: aload 9
      //   129: checkcast 100	java/lang/Number
      //   132: invokevirtual 104	java/lang/Number:intValue	()I
      //   135: istore 4
      //   137: aload_0
      //   138: getfield 56	gnu/kawa/slib/srfi13$frame92:s2	Ljava/lang/Object;
      //   141: astore 9
      //   143: aload 9
      //   145: checkcast 68	java/lang/CharSequence
      //   148: astore 10
      //   150: aload_1
      //   151: checkcast 100	java/lang/Number
      //   154: invokevirtual 104	java/lang/Number:intValue	()I
      //   157: istore 5
      //   159: aload_2
      //   160: checkcast 100	java/lang/Number
      //   163: invokevirtual 104	java/lang/Number:intValue	()I
      //   166: istore 6
      //   168: aload 7
      //   170: iload 4
      //   172: aload 10
      //   174: iload 5
      //   176: iload 6
      //   178: invokestatic 112	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   181: pop
      //   182: getstatic 88	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   185: aload_0
      //   186: getfield 98	gnu/kawa/slib/srfi13$frame92:start1	Ljava/lang/Object;
      //   189: aload 8
      //   191: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   194: astore_1
      //   195: aload_1
      //   196: checkcast 100	java/lang/Number
      //   199: invokevirtual 104	java/lang/Number:intValue	()I
      //   202: istore 4
      //   204: aload_0
      //   205: getfield 66	gnu/kawa/slib/srfi13$frame92:s1	Ljava/lang/Object;
      //   208: astore_1
      //   209: aload_1
      //   210: checkcast 68	java/lang/CharSequence
      //   213: astore_2
      //   214: aload_0
      //   215: getfield 96	gnu/kawa/slib/srfi13$frame92:end1	Ljava/lang/Object;
      //   218: astore_1
      //   219: aload_1
      //   220: checkcast 100	java/lang/Number
      //   223: invokevirtual 104	java/lang/Number:intValue	()I
      //   226: istore 5
      //   228: aload 7
      //   230: iload 4
      //   232: aload_2
      //   233: iload 5
      //   235: iload_3
      //   236: invokestatic 112	gnu/kawa/slib/srfi13:$PcStringCopy$Ex	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;II)Ljava/lang/Object;
      //   239: pop
      //   240: aload 7
      //   242: areturn
      //   243: astore_1
      //   244: new 114	gnu/mapping/WrongType
      //   247: dup
      //   248: aload_1
      //   249: ldc 116
      //   251: iconst_1
      //   252: aload 7
      //   254: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   257: athrow
      //   258: astore_1
      //   259: new 114	gnu/mapping/WrongType
      //   262: dup
      //   263: aload_1
      //   264: ldc 121
      //   266: iconst_1
      //   267: aload 7
      //   269: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   272: athrow
      //   273: astore_1
      //   274: new 114	gnu/mapping/WrongType
      //   277: dup
      //   278: aload_1
      //   279: ldc 123
      //   281: iconst_2
      //   282: aload 9
      //   284: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      //   288: astore_1
      //   289: new 114	gnu/mapping/WrongType
      //   292: dup
      //   293: aload_1
      //   294: ldc 123
      //   296: iconst_4
      //   297: aload 9
      //   299: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   302: athrow
      //   303: astore_1
      //   304: new 114	gnu/mapping/WrongType
      //   307: dup
      //   308: aload_1
      //   309: ldc 123
      //   311: iconst_1
      //   312: aload 9
      //   314: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   317: athrow
      //   318: astore_1
      //   319: new 114	gnu/mapping/WrongType
      //   322: dup
      //   323: aload_1
      //   324: ldc 123
      //   326: iconst_2
      //   327: aload 9
      //   329: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   332: athrow
      //   333: astore_2
      //   334: new 114	gnu/mapping/WrongType
      //   337: dup
      //   338: aload_2
      //   339: ldc 123
      //   341: iconst_3
      //   342: aload_1
      //   343: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   346: athrow
      //   347: astore_1
      //   348: new 114	gnu/mapping/WrongType
      //   351: dup
      //   352: aload_1
      //   353: ldc 123
      //   355: iconst_4
      //   356: aload_2
      //   357: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   360: athrow
      //   361: astore_2
      //   362: new 114	gnu/mapping/WrongType
      //   365: dup
      //   366: aload_2
      //   367: ldc 123
      //   369: iconst_1
      //   370: aload_1
      //   371: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   374: athrow
      //   375: astore_2
      //   376: new 114	gnu/mapping/WrongType
      //   379: dup
      //   380: aload_2
      //   381: ldc 123
      //   383: iconst_2
      //   384: aload_1
      //   385: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   388: athrow
      //   389: astore_2
      //   390: new 114	gnu/mapping/WrongType
      //   393: dup
      //   394: aload_2
      //   395: ldc 123
      //   397: iconst_3
      //   398: aload_1
      //   399: invokespecial 119	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   402: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	403	0	this	frame92
      //   0	403	1	paramObject1	Object
      //   0	403	2	paramObject2	Object
      //   18	218	3	i	int
      //   71	160	4	j	int
      //   157	77	5	k	int
      //   166	11	6	m	int
      //   4	264	7	localObject1	Object
      //   11	179	8	localObject2	Object
      //   84	244	9	localObject3	Object
      //   91	82	10	localCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   6	13	243	java/lang/ClassCastException
      //   63	73	258	java/lang/ClassCastException
      //   86	93	273	java/lang/ClassCastException
      //   99	109	288	java/lang/ClassCastException
      //   127	137	303	java/lang/ClassCastException
      //   143	150	318	java/lang/ClassCastException
      //   150	159	333	java/lang/ClassCastException
      //   159	168	347	java/lang/ClassCastException
      //   195	204	361	java/lang/ClassCastException
      //   209	214	375	java/lang/ClassCastException
      //   219	228	389	java/lang/ClassCastException
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 181)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 182)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame93
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn208 = new ModuleMethod(this, 183, null, 0);
    final ModuleMethod lambda$Fn209 = new ModuleMethod(this, 184, null, 8194);
    Object s;
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 183) {
        return lambda208();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 184) {
        return lambda209(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda208()
    {
      ModuleMethod localModuleMethod = srfi13.string$Mntokenize;
      Object localObject1 = this.s;
      Object localObject2 = srfi13.loc$rest;
      try
      {
        localObject2 = ((Location)localObject2).get();
        return srfi13.stringParseFinalStart$PlEnd(localModuleMethod, localObject1, localObject2);
      }
      catch (UnboundLocationException localUnboundLocationException)
      {
        localUnboundLocationException.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1696, 57);
        throw localUnboundLocationException;
      }
    }
    
    Object lambda209(Object paramObject1, Object paramObject2)
    {
      localObject2 = LList.Empty;
      localObject1 = paramObject2;
      paramObject2 = localObject2;
      localObject2 = Scheme.numLss.apply2(paramObject1, localObject1);
      for (;;)
      {
        try
        {
          bool = ((Boolean)localObject2).booleanValue();
          if (bool)
          {
            localObject2 = this.s;
            localObject3 = srfi13.loc$token$Mnchars;
          }
        }
        catch (ClassCastException paramObject1)
        {
          try
          {
            boolean bool;
            Object localObject4;
            localObject3 = (CharSequence)localObject1;
          }
          catch (ClassCastException paramObject1)
          {
            Object localObject3;
            int i;
            int j;
            throw new WrongType((ClassCastException)paramObject1, "substring", 1, localObject1);
          }
          try
          {
            i = ((Number)paramObject1).intValue();
          }
          catch (ClassCastException paramObject2)
          {
            throw new WrongType((ClassCastException)paramObject2, "substring", 2, paramObject1);
          }
          try
          {
            j = ((Number)localObject2).intValue();
            localObject2 = lists.cons(strings.substring((CharSequence)localObject3, i, j), paramObject2);
            return localObject2;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject2);
          }
          paramObject1 = paramObject1;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject2);
        }
        try
        {
          localObject3 = ((Location)localObject3).get();
          localObject1 = srfi13.stringIndexRight$V(localObject2, localObject3, new Object[] { paramObject1, localObject1 });
          localObject2 = paramObject2;
          if (localObject1 != Boolean.FALSE)
          {
            localObject2 = AddOp.$Pl.apply2(srfi13.Lit1, localObject1);
            localObject3 = this.s;
            localObject4 = srfi13.loc$token$Mnchars;
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1698, 48);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localObject4 = ((Location)localObject4).get();
          localObject1 = srfi13.stringSkipRight$V(localObject3, localObject4, new Object[] { paramObject1, localObject1 });
          if (localObject1 != Boolean.FALSE) {
            localObject3 = this.s;
          }
        }
        catch (UnboundLocationException paramObject1)
        {
          ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1701, 34);
          throw ((Throwable)paramObject1);
        }
        try
        {
          localObject4 = (CharSequence)localObject3;
          localObject3 = AddOp.$Pl.apply2(srfi13.Lit1, localObject1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, localObject3);
        }
        try
        {
          i = ((Number)localObject3).intValue();
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject3);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          paramObject2 = lists.cons(strings.substring((CharSequence)localObject4, i, j), paramObject2);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject2);
        }
        if (bool) {
          localObject1 = Boolean.TRUE;
        } else {
          localObject1 = Boolean.FALSE;
        }
      }
      localObject1 = this.s;
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 183)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 184)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }
  
  public class frame94
    extends ModuleBody
  {
    Object from;
    final ModuleMethod lambda$Fn211;
    final ModuleMethod lambda$Fn212 = new ModuleMethod(this, 185, null, 0);
    final ModuleMethod lambda$Fn213;
    final ModuleMethod lambda$Fn214;
    final ModuleMethod lambda$Fn215;
    LList maybe$Mnto$Plstart$Plend;
    Object s;
    
    public frame94()
    {
      this$1 = new ModuleMethod(this, 186, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1744");
      this.lambda$Fn214 = this$1;
      this.lambda$Fn213 = new ModuleMethod(this, 187, null, 8194);
      this.lambda$Fn211 = new ModuleMethod(this, 188, null, 0);
      this$1 = new ModuleMethod(this, 189, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1740");
      this.lambda$Fn215 = this$1;
    }
    
    static boolean lambda210(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = numbers.isExact(paramObject);
      }
      return bool1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 186: 
      case 187: 
      default: 
        return super.apply0(paramModuleMethod);
      case 185: 
        return lambda212();
      }
      return lambda211();
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 186)
      {
        if (lambda214(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 187) {
        return lambda213(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 189) {
        return lambda215(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    /* Error */
    Object lambda211()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 113	gnu/kawa/slib/srfi13$frame94:maybe$Mnto$Plstart$Plend	Lgnu/lists/LList;
      //   4: invokestatic 118	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   7: ifeq +15 -> 22
      //   10: aload_0
      //   11: getfield 29	gnu/kawa/slib/srfi13$frame94:lambda$Fn212	Lgnu/expr/ModuleMethod;
      //   14: aload_0
      //   15: getfield 43	gnu/kawa/slib/srfi13$frame94:lambda$Fn213	Lgnu/expr/ModuleMethod;
      //   18: invokestatic 124	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   21: areturn
      //   22: getstatic 130	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   25: astore_2
      //   26: getstatic 134	gnu/kawa/slib/srfi13:loc$check$Mnarg	Lgnu/mapping/Location;
      //   29: astore_3
      //   30: aload_3
      //   31: invokevirtual 139	gnu/mapping/Location:get	()Ljava/lang/Object;
      //   34: astore_3
      //   35: aload_2
      //   36: aload_3
      //   37: getstatic 144	kawa/lib/strings:string$Qu	Lgnu/expr/ModuleMethod;
      //   40: aload_0
      //   41: getfield 146	gnu/kawa/slib/srfi13$frame94:s	Ljava/lang/Object;
      //   44: getstatic 149	gnu/kawa/slib/srfi13:xsubstring	Lgnu/expr/ModuleMethod;
      //   47: invokevirtual 155	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   50: astore_2
      //   51: aload_2
      //   52: checkcast 157	java/lang/CharSequence
      //   55: astore_3
      //   56: aload_3
      //   57: invokestatic 161	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   60: istore_1
      //   61: iconst_3
      //   62: anewarray 163	java/lang/Object
      //   65: dup
      //   66: iconst_0
      //   67: getstatic 169	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   70: aload_0
      //   71: getfield 171	gnu/kawa/slib/srfi13$frame94:from	Ljava/lang/Object;
      //   74: iload_1
      //   75: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   78: invokevirtual 179	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   81: aastore
      //   82: dup
      //   83: iconst_1
      //   84: getstatic 183	gnu/kawa/slib/srfi13:Lit0	Lgnu/math/IntNum;
      //   87: aastore
      //   88: dup
      //   89: iconst_2
      //   90: iload_1
      //   91: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   94: aastore
      //   95: invokestatic 189	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
      //   98: areturn
      //   99: astore_2
      //   100: aload_2
      //   101: ldc -65
      //   103: sipush 1749
      //   106: bipush 36
      //   108: invokevirtual 195	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
      //   111: aload_2
      //   112: athrow
      //   113: astore_3
      //   114: new 197	gnu/mapping/WrongType
      //   117: dup
      //   118: aload_3
      //   119: ldc -57
      //   121: iconst_1
      //   122: aload_2
      //   123: invokespecial 202	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   126: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	127	0	this	frame94
      //   60	31	1	i	int
      //   25	27	2	localObject1	Object
      //   99	24	2	localUnboundLocationException	UnboundLocationException
      //   29	28	3	localObject2	Object
      //   113	6	3	localClassCastException	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   30	35	99	gnu/mapping/UnboundLocationException
      //   51	56	113	java/lang/ClassCastException
    }
    
    Object lambda212()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.xsubstring, this.s, lists.cdr.apply1(this.maybe$Mnto$Plstart$Plend));
    }
    
    Object lambda213(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = lists.car.apply1(this.maybe$Mnto$Plstart$Plend);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject2 = srfi13.loc$check$Mnarg;
      try
      {
        localObject2 = ((Location)localObject2).get();
        localApplyToArgs.apply4(localObject2, this.lambda$Fn214, localObject1, srfi13.xsubstring);
        return misc.values(new Object[] { localObject1, paramObject1, paramObject2 });
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1744, 6);
        throw ((Throwable)paramObject1);
      }
    }
    
    boolean lambda214(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2)
      {
        bool2 = numbers.isExact(paramObject);
        bool1 = bool2;
        if (bool2) {
          bool1 = ((Boolean)Scheme.numLEq.apply2(this.from, paramObject)).booleanValue();
        }
      }
      return bool1;
    }
    
    Object lambda215(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
      localObject2 = AddOp.$Mn.apply2(paramObject1, this.from);
      for (;;)
      {
        try
        {
          localObject3 = (Number)localObject2;
          if (numbers.isZero((Number)localObject3)) {
            return "";
          }
        }
        catch (ClassCastException paramObject1)
        {
          try
          {
            localRealNum = LangObjType.coerceRealNum(localObject3);
            d = numbers.floor(localRealNum).doubleValue();
            localObject3 = DivideOp.$Sl.apply2(paramObject1, localObject1);
          }
          catch (ClassCastException paramObject1)
          {
            int i;
            int j;
            RealNum localRealNum;
            double d;
            throw new WrongType((ClassCastException)paramObject1, "floor", 1, localObject3);
          }
          try
          {
            localRealNum = LangObjType.coerceRealNum(localObject3);
            if (d == numbers.floor(localRealNum).doubleValue()) {
              localObject2 = this.s;
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "floor", 1, localObject3);
          }
          try
          {
            paramObject3 = (CharSequence)localObject2;
            localObject2 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(this.from, localObject1));
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 1, localObject2);
          }
          try
          {
            i = ((Number)localObject2).intValue();
            paramObject1 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(paramObject1, localObject1));
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject2);
          }
          try
          {
            j = ((Number)paramObject1).intValue();
            return strings.substring((CharSequence)paramObject3, i, j);
          }
          catch (ClassCastException paramObject2)
          {
            throw new WrongType((ClassCastException)paramObject2, "substring", 3, paramObject1);
          }
          try
          {
            i = ((Number)localObject2).intValue();
            localObject1 = strings.makeString(i);
            srfi13.$PcMultispanRepcopy$Ex(localObject1, srfi13.Lit0, this.s, this.from, paramObject1, paramObject2, paramObject3);
            return localObject1;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject2);
          }
          paramObject1 = paramObject1;
          throw new WrongType((ClassCastException)paramObject1, "zero?", 1, localObject2);
        }
        try
        {
          localObject3 = (Number)localObject1;
          if (numbers.isZero((Number)localObject3)) {
            return misc.error$V("Cannot replicate empty (sub)string", new Object[] { srfi13.xsubstring, this.s, this.from, paramObject1, paramObject2, paramObject3 });
          }
          if (Scheme.numEqu.apply2(srfi13.Lit1, localObject1) == Boolean.FALSE) {}
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "zero?", 1, localObject1);
        }
      }
      try
      {
        i = ((Number)localObject2).intValue();
        paramObject1 = this.s;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject2);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        j = ((Number)paramObject2).intValue();
        return strings.makeString(i, Char.make(strings.stringRef((CharSequence)paramObject3, j)));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      localObject3 = DivideOp.$Sl.apply2(this.from, localObject1);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 186: 
      case 187: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 188: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 186)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 187)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 189)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame95
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn217 = new ModuleMethod(this, 192, null, 0);
    final ModuleMethod lambda$Fn218 = new ModuleMethod(this, 190, null, 0);
    final ModuleMethod lambda$Fn219 = new ModuleMethod(this, 191, null, 8194);
    final ModuleMethod lambda$Fn221;
    LList maybe$Mnsto$Plstart$Plend;
    Object s;
    Object sfrom;
    Object target;
    Object tstart;
    
    public frame95()
    {
      this$1 = new ModuleMethod(this, 193, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm:1781");
      this.lambda$Fn221 = this$1;
    }
    
    static boolean lambda216(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = numbers.isExact(paramObject);
      }
      return bool1;
    }
    
    static boolean lambda220(Object paramObject)
    {
      boolean bool2 = numbers.isInteger(paramObject);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = numbers.isExact(paramObject);
      }
      return bool1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 191: 
      default: 
        return super.apply0(paramModuleMethod);
      case 190: 
        return lambda218();
      }
      return lambda217();
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 191) {
        return lambda219(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 193) {
        return lambda221(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda217()
    {
      if (lists.isPair(this.maybe$Mnsto$Plstart$Plend)) {
        return call_with_values.callWithValues(this.lambda$Fn218, this.lambda$Fn219);
      }
      Object localObject = this.s;
      try
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        int i = strings.stringLength(localCharSequence);
        return misc.values(new Object[] { AddOp.$Pl.apply2(this.sfrom, Integer.valueOf(i)), srfi13.Lit0, Integer.valueOf(i) });
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, localObject);
      }
    }
    
    Object lambda218()
    {
      return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnxcopy$Ex, this.s, lists.cdr.apply1(this.maybe$Mnsto$Plstart$Plend));
    }
    
    Object lambda219(Object paramObject1, Object paramObject2)
    {
      Object localObject1 = lists.car.apply1(this.maybe$Mnsto$Plstart$Plend);
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object localObject2 = srfi13.loc$check$Mnarg;
      try
      {
        localObject2 = ((Location)localObject2).get();
        localApplyToArgs.apply4(localObject2, srfi13.lambda$Fn220, localObject1, srfi13.string$Mnxcopy$Ex);
        return misc.values(new Object[] { localObject1, paramObject1, paramObject2 });
      }
      catch (UnboundLocationException paramObject1)
      {
        ((UnboundLocationException)paramObject1).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1785, 6);
        throw ((Throwable)paramObject1);
      }
    }
    
    Object lambda221(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      localObject3 = AddOp.$Mn.apply2(paramObject1, this.sfrom);
      localObject2 = AddOp.$Pl.apply2(this.tstart, localObject3);
      localObject1 = AddOp.$Mn.apply2(paramObject3, paramObject2);
      srfi13.checkSubstringSpec(srfi13.string$Mnxcopy$Ex, this.target, this.tstart, localObject2);
      for (;;)
      {
        try
        {
          Number localNumber = (Number)localObject3;
          boolean bool = numbers.isZero(localNumber);
          if (bool)
          {
            if (bool) {
              return Boolean.TRUE;
            }
            return Boolean.FALSE;
          }
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          throw new WrongType((ClassCastException)paramObject1, "zero?", 1, localObject3);
        }
        try
        {
          localObject3 = (Number)localObject1;
          if (numbers.isZero((Number)localObject3)) {
            return misc.error$V("Cannot replicate empty (sub)string", new Object[] { srfi13.string$Mnxcopy$Ex, this.target, this.tstart, this.s, this.sfrom, paramObject1, paramObject2, paramObject3 });
          }
          if (Scheme.numEqu.apply2(srfi13.Lit1, localObject1) != Boolean.FALSE)
          {
            paramObject3 = this.target;
            paramObject1 = this.s;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "zero?", 1, localObject1);
        }
      }
      try
      {
        localObject1 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        return srfi13.stringFill$Ex$V(paramObject3, Char.make(strings.stringRef((CharSequence)localObject1, i)), new Object[] { this.tstart, localObject2 });
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      localObject2 = DivideOp.$Sl.apply2(this.sfrom, localObject1);
      for (;;)
      {
        try
        {
          localObject3 = LangObjType.coerceRealNum(localObject2);
          d = numbers.floor((RealNum)localObject3).doubleValue();
          localObject2 = DivideOp.$Sl.apply2(paramObject1, localObject1);
        }
        catch (ClassCastException paramObject1)
        {
          double d;
          int j;
          int k;
          throw new WrongType((ClassCastException)paramObject1, "floor", 1, localObject2);
        }
        try
        {
          localObject3 = LangObjType.coerceRealNum(localObject2);
          if (d == numbers.floor((RealNum)localObject3).doubleValue()) {
            localObject2 = this.target;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "floor", 1, localObject2);
        }
      }
      try
      {
        paramObject3 = (CharSequence)localObject2;
        localObject2 = this.tstart;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 0, localObject2);
      }
      try
      {
        i = ((Number)localObject2).intValue();
        localObject3 = this.s;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 1, localObject2);
      }
      try
      {
        localObject2 = (CharSequence)localObject3;
        localObject3 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(this.sfrom, localObject1));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 2, localObject3);
      }
      try
      {
        j = ((Number)localObject3).intValue();
        paramObject1 = AddOp.$Pl.apply2(paramObject2, DivideOp.modulo.apply2(paramObject1, localObject1));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "%string-copy!", 3, localObject3);
      }
      try
      {
        k = ((Number)paramObject1).intValue();
        return srfi13.$PcStringCopy$Ex((CharSequence)paramObject3, i, (CharSequence)localObject2, j, k);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "%string-copy!", 4, paramObject1);
      }
      return srfi13.$PcMultispanRepcopy$Ex(this.target, this.tstart, this.s, this.sfrom, paramObject1, paramObject2, paramObject3);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 191: 
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 192: 
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 191)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 193)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }
  
  public class frame96
    extends ModuleBody
  {
    Object jdField_final;
    
    public Object lambda223recur(Object paramObject)
    {
      Object localObject;
      if (lists.isPair(paramObject)) {
        localObject = srfi13.loc$delim;
      }
      try
      {
        localObject = ((Location)localObject).get();
        return lists.cons(localObject, lists.cons(lists.car.apply1(paramObject), lambda223recur(lists.cdr.apply1(paramObject))));
      }
      catch (UnboundLocationException paramObject)
      {
        ((UnboundLocationException)paramObject).setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi13.scm", 1857, 13);
        throw ((Throwable)paramObject);
      }
      return this.jdField_final;
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\srfi13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */