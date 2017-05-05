package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.append;

public class printf
  extends ModuleBody
{
  public static final printf $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final PairWithPosition Lit10;
  static final Char Lit11;
  static final Char Lit12;
  static final Char Lit13;
  static final IntNum Lit14;
  static final IntNum Lit15;
  static final IntNum Lit16;
  static final IntNum Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final PairWithPosition Lit2;
  static final Char Lit20;
  static final Char Lit21;
  static final Char Lit22;
  static final Char Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final Char Lit26;
  static final Char Lit27;
  static final Char Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final Char Lit30;
  static final Char Lit31;
  static final Char Lit32;
  static final PairWithPosition Lit33;
  static final SimpleSymbol Lit34;
  static final Char Lit35;
  static final Char Lit36;
  static final Char Lit37;
  static final Char Lit38;
  static final Char Lit39;
  static final Char Lit4;
  static final Char Lit40;
  static final Char Lit41;
  static final Char Lit42;
  static final Char Lit43;
  static final Char Lit44;
  static final IntNum Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final IntNum Lit48;
  static final Char Lit49;
  static final Char Lit5;
  static final IntNum Lit50;
  static final Char Lit51;
  static final Char Lit52;
  static final Char Lit53;
  static final Char Lit54;
  static final Char Lit55;
  static final Char Lit56;
  static final Char Lit57;
  static final Char Lit58;
  static final IntNum Lit59;
  static final Char Lit6;
  static final IntNum Lit60;
  static final IntNum Lit61;
  static final FVector Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final IntNum Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72 = (SimpleSymbol)new SimpleSymbol("fprintf").readResolve();
  static final Char Lit8;
  static final Char Lit9;
  public static final ModuleMethod fprintf;
  public static final ModuleMethod printf;
  public static final ModuleMethod sprintf;
  public static final boolean stdio$Clhex$Mnupper$Mncase$Qu = false;
  public static final ModuleMethod stdio$Cliprintf;
  public static final ModuleMethod stdio$Clparse$Mnfloat;
  public static final ModuleMethod stdio$Clround$Mnstring;
  
  static
  {
    Lit71 = (SimpleSymbol)new SimpleSymbol("stdio:iprintf").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("stdio:round-string").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("stdio:parse-float").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("sprintf").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("pad").readResolve();
    Lit66 = Char.make(42);
    Lit65 = Char.make(63);
    Lit64 = (SimpleSymbol)new SimpleSymbol("format-real").readResolve();
    Lit63 = PairWithPosition.make("i", LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1634315);
    Lit62 = FVector.make(new Object[] { "y", "z", "a", "f", "p", "n", "u", "m", "", "k", "M", "G", "T", "P", "E", "Z", "Y" });
    Lit61 = IntNum.make(3);
    Lit60 = IntNum.make(-10);
    Lit59 = IntNum.make(6);
    Lit58 = Char.make(75);
    Lit57 = Char.make(107);
    Lit56 = Char.make(71);
    Lit55 = Char.make(103);
    Lit54 = Char.make(69);
    Lit53 = Char.make(66);
    Lit52 = Char.make(98);
    Lit51 = Char.make(88);
    Lit50 = IntNum.make(16);
    Lit49 = Char.make(120);
    Lit48 = IntNum.make(8);
    Lit47 = Char.make(79);
    Lit46 = Char.make(111);
    Lit45 = IntNum.make(10);
    Lit44 = Char.make(85);
    Lit43 = Char.make(117);
    Lit42 = Char.make(73);
    Lit41 = Char.make(68);
    Lit40 = Char.make(65);
    Lit39 = Char.make(97);
    Lit38 = Char.make(83);
    Lit37 = Char.make(115);
    Lit36 = Char.make(67);
    Lit35 = Char.make(99);
    Lit34 = (SimpleSymbol)new SimpleSymbol("printf").readResolve();
    Object localObject = Lit35;
    Char localChar1 = Lit37;
    Char localChar2 = Lit39;
    Char localChar3 = Char.make(100);
    Lit12 = localChar3;
    Char localChar4 = Char.make(105);
    Lit3 = localChar4;
    Char localChar5 = Lit43;
    Char localChar6 = Lit46;
    Char localChar7 = Lit49;
    Char localChar8 = Lit52;
    Char localChar9 = Char.make(102);
    Lit25 = localChar9;
    Char localChar10 = Char.make(101);
    Lit13 = localChar10;
    Lit33 = PairWithPosition.make(localObject, PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, PairWithPosition.make(localChar10, PairWithPosition.make(Lit55, PairWithPosition.make(Lit57, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1781780), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1781776), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1781772), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1781768), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777704), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777700), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777696), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777692), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777688), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777684), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777680), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777676), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 1777671);
    Lit32 = Char.make(104);
    Lit31 = Char.make(76);
    Lit30 = Char.make(108);
    Lit29 = Char.make(32);
    Lit28 = Char.make(37);
    Lit27 = Char.make(12);
    Lit26 = Char.make(70);
    Lit24 = Char.make(9);
    Lit23 = Char.make(84);
    Lit22 = Char.make(116);
    Lit21 = Char.make(10);
    Lit20 = Char.make(78);
    Lit19 = Char.make(110);
    Lit18 = Char.make(92);
    Lit17 = IntNum.make(-1);
    Lit16 = IntNum.make(9);
    Lit15 = IntNum.make(5);
    Lit14 = IntNum.make(2);
    Lit11 = Char.make(46);
    Lit10 = PairWithPosition.make(Lit13, PairWithPosition.make(Lit37, PairWithPosition.make(Lit25, PairWithPosition.make(Lit12, PairWithPosition.make(Lit30, PairWithPosition.make(Lit54, PairWithPosition.make(Lit38, PairWithPosition.make(Lit26, PairWithPosition.make(Lit41, PairWithPosition.make(Lit31, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266284), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266280), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266276), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266272), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266268), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266264), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266260), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266256), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266252), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 266247);
    Lit9 = Char.make(48);
    Lit8 = Char.make(35);
    Lit7 = IntNum.make(1);
    Lit6 = Char.make(43);
    Lit5 = Char.make(45);
    Lit4 = Char.make(64);
    Lit2 = PairWithPosition.make(Lit6, PairWithPosition.make(Lit5, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 446503), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm", 446498);
    Lit1 = IntNum.make(0);
    Lit0 = IntNum.make(-15);
    $instance = new printf();
    localObject = $instance;
    stdio$Clparse$Mnfloat = new ModuleMethod((ModuleBody)localObject, 22, Lit69, 8194);
    stdio$Clround$Mnstring = new ModuleMethod((ModuleBody)localObject, 23, Lit70, 12291);
    stdio$Cliprintf = new ModuleMethod((ModuleBody)localObject, 24, Lit71, 61442);
    fprintf = new ModuleMethod((ModuleBody)localObject, 25, Lit72, 61442);
    printf = new ModuleMethod((ModuleBody)localObject, 26, Lit34, 61441);
    sprintf = new ModuleMethod((ModuleBody)localObject, 27, Lit68, 61442);
    $instance.run();
  }
  
  public printf()
  {
    ModuleInfo.register(this);
  }
  
  public static Object fprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.port = paramObject1;
    paramObject1 = LList.makeList(paramArrayOfObject, 0);
    localframe12.cnt = Lit1;
    Scheme.apply.apply4(stdio$Cliprintf, localframe12.lambda$Fn18, paramObject2, paramObject1);
    return localframe12.cnt;
  }
  
  public static Object printf$V(Object paramObject, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(fprintf, ports.current$Mnoutput$Mnport.apply0(), paramObject, paramArrayOfObject);
  }
  
  /* Error */
  public static Object sprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 24	gnu/kawa/slib/printf$frame13
    //   3: dup
    //   4: invokespecial 478	gnu/kawa/slib/printf$frame13:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 445	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: astore_2
    //   21: aload 4
    //   23: getstatic 400	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   26: putfield 482	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   29: aload 4
    //   31: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   34: invokestatic 488	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   37: ifeq +74 -> 111
    //   40: aload 4
    //   42: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   45: astore_0
    //   46: aload 4
    //   48: aload_0
    //   49: putfield 491	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   52: aload 4
    //   54: getfield 491	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   57: astore_0
    //   58: aload_0
    //   59: checkcast 493	java/lang/CharSequence
    //   62: astore 5
    //   64: aload 4
    //   66: aload 5
    //   68: invokestatic 497	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   71: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: putfield 506	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   77: getstatic 454	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   80: getstatic 417	gnu/kawa/slib/printf:stdio$Cliprintf	Lgnu/expr/ModuleMethod;
    //   83: aload 4
    //   85: getfield 509	gnu/kawa/slib/printf$frame13:lambda$Fn19	Lgnu/expr/ModuleMethod;
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 463	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload 4
    //   96: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   99: invokestatic 488	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   102: ifeq +90 -> 192
    //   105: aload 4
    //   107: getfield 482	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   110: areturn
    //   111: aload 4
    //   113: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   116: invokestatic 514	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   119: ifeq +25 -> 144
    //   122: aload 4
    //   124: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   127: astore_0
    //   128: aload_0
    //   129: checkcast 516	java/lang/Number
    //   132: invokevirtual 520	java/lang/Number:intValue	()I
    //   135: istore_3
    //   136: iload_3
    //   137: invokestatic 524	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   140: astore_0
    //   141: goto -95 -> 46
    //   144: aload 4
    //   146: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   149: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   152: if_acmpne +12 -> 164
    //   155: bipush 100
    //   157: invokestatic 524	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   160: astore_0
    //   161: goto -115 -> 46
    //   164: getstatic 169	gnu/kawa/slib/printf:Lit68	Lgnu/mapping/SimpleSymbol;
    //   167: iconst_2
    //   168: anewarray 207	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 532
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload 4
    //   181: getfield 481	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   184: aastore
    //   185: invokestatic 537	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   188: astore_0
    //   189: goto -143 -> 46
    //   192: getstatic 541	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   195: aload 4
    //   197: getfield 506	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   200: aload 4
    //   202: getfield 482	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   205: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   211: if_acmpeq +9 -> 220
    //   214: aload 4
    //   216: getfield 491	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   219: areturn
    //   220: aload 4
    //   222: getfield 491	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   225: astore_0
    //   226: aload_0
    //   227: checkcast 493	java/lang/CharSequence
    //   230: astore_1
    //   231: aload 4
    //   233: getfield 482	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   236: astore_0
    //   237: aload_0
    //   238: checkcast 516	java/lang/Number
    //   241: invokevirtual 520	java/lang/Number:intValue	()I
    //   244: istore_3
    //   245: aload_1
    //   246: iconst_0
    //   247: iload_3
    //   248: invokestatic 549	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   251: areturn
    //   252: astore_1
    //   253: new 551	gnu/mapping/WrongType
    //   256: dup
    //   257: aload_1
    //   258: ldc_w 553
    //   261: iconst_1
    //   262: aload_0
    //   263: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: astore_1
    //   268: new 551	gnu/mapping/WrongType
    //   271: dup
    //   272: aload_1
    //   273: ldc_w 558
    //   276: iconst_1
    //   277: aload_0
    //   278: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: astore_1
    //   283: new 551	gnu/mapping/WrongType
    //   286: dup
    //   287: aload_1
    //   288: ldc_w 559
    //   291: iconst_1
    //   292: aload_0
    //   293: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore_1
    //   298: new 551	gnu/mapping/WrongType
    //   301: dup
    //   302: aload_1
    //   303: ldc_w 559
    //   306: iconst_3
    //   307: aload_0
    //   308: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramObject1	Object
    //   0	312	1	paramObject2	Object
    //   0	312	2	paramArrayOfObject	Object[]
    //   135	113	3	i	int
    //   7	225	4	localframe13	frame13
    //   62	5	5	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   128	136	252	java/lang/ClassCastException
    //   58	64	267	java/lang/ClassCastException
    //   226	231	282	java/lang/ClassCastException
    //   237	245	297	java/lang/ClassCastException
  }
  
  public static Object stdio$ClIprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.out = paramObject1;
    localframe9.format$Mnstring = paramObject2;
    localframe9.args = LList.makeList(paramArrayOfObject, 0);
    if (!IsEqual.apply("", localframe9.format$Mnstring))
    {
      paramObject1 = Lit17;
      paramObject2 = localframe9.format$Mnstring;
      for (;;)
      {
        try
        {
          paramArrayOfObject = (CharSequence)paramObject2;
          i = strings.stringLength(paramArrayOfObject);
          paramObject2 = localframe9.format$Mnstring;
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          boolean bool;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
        }
        try
        {
          paramArrayOfObject = (CharSequence)paramObject2;
          localframe9.fc = Char.make(strings.stringRef(paramArrayOfObject, 0));
          localframe9.fl = i;
          localframe9.pos = paramObject1;
          paramObject1 = localframe9.args;
          paramArrayOfObject = new frame10();
          paramArrayOfObject.staticLink = localframe9;
          paramArrayOfObject.args = paramObject1;
          localframe9.pos = AddOp.$Pl.apply2(Lit7, localframe9.pos);
          if (Scheme.numGEq.apply2(localframe9.pos, Integer.valueOf(localframe9.fl)) != Boolean.FALSE)
          {
            localframe9.fc = Boolean.FALSE;
            bool = localframe9.lambda19isEndOfFormat();
            if (!bool) {
              continue;
            }
            if (bool)
            {
              paramObject1 = Boolean.TRUE;
              return paramObject1;
            }
          }
          else
          {
            paramObject1 = localframe9.format$Mnstring;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          paramObject2 = (CharSequence)paramObject1;
          paramObject1 = localframe9.pos;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          localframe9.fc = Char.make(strings.stringRef((CharSequence)paramObject2, i));
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        paramObject1 = Boolean.FALSE;
        continue;
        if (Scheme.isEqv.apply2(Lit18, localframe9.fc) != Boolean.FALSE)
        {
          localframe9.lambda18mustAdvance();
          paramObject1 = localframe9.fc;
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit19);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 != Boolean.FALSE)
            {
              paramObject1 = Scheme.applyToArgs.apply2(localframe9.out, Lit21);
              if (paramObject1 == Boolean.FALSE) {
                continue;
              }
              paramObject1 = paramArrayOfObject.args;
            }
          }
          else {
            if (Scheme.isEqv.apply2(paramObject1, Lit20) != Boolean.FALSE) {
              continue;
            }
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit22);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 != Boolean.FALSE) {
              paramObject1 = Scheme.applyToArgs.apply2(localframe9.out, Lit24);
            }
          }
          else {
            if (Scheme.isEqv.apply2(paramObject1, Lit23) != Boolean.FALSE) {
              continue;
            }
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit25);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 != Boolean.FALSE) {
              paramObject1 = Scheme.applyToArgs.apply2(localframe9.out, Lit27);
            }
          }
          else {
            if (Scheme.isEqv.apply2(paramObject1, Lit26) != Boolean.FALSE) {
              continue;
            }
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit21) != Boolean.FALSE)
          {
            paramObject1 = Boolean.TRUE;
          }
          else
          {
            paramObject1 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
            continue;
            return paramObject1;
          }
        }
        else if (Scheme.isEqv.apply2(Lit28, localframe9.fc) != Boolean.FALSE)
        {
          localframe9.lambda18mustAdvance();
          paramObject1 = Boolean.FALSE;
          paramObject2 = Boolean.FALSE;
          localObject1 = Boolean.FALSE;
          localObject2 = Boolean.FALSE;
          localObject3 = Boolean.FALSE;
          localObject4 = Lit1;
          paramArrayOfObject.precision = Lit17;
          paramArrayOfObject.width = localObject4;
          paramArrayOfObject.leading$Mn0s = localObject3;
          paramArrayOfObject.alternate$Mnform = localObject2;
          paramArrayOfObject.blank = localObject1;
          paramArrayOfObject.signed = paramObject2;
          paramArrayOfObject.left$Mnadjust = paramObject1;
          paramArrayOfObject.pad = paramArrayOfObject.pad;
          paramObject1 = localframe9.fc;
          if (Scheme.isEqv.apply2(paramObject1, Lit5) != Boolean.FALSE)
          {
            paramArrayOfObject.left$Mnadjust = Boolean.TRUE;
            localframe9.lambda18mustAdvance();
            continue;
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit6) != Boolean.FALSE)
          {
            paramArrayOfObject.signed = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit29) != Boolean.FALSE)
          {
            paramArrayOfObject.blank = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit8) != Boolean.FALSE)
          {
            paramArrayOfObject.alternate$Mnform = Boolean.TRUE;
            continue;
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit9) != Boolean.FALSE)
          {
            paramArrayOfObject.leading$Mn0s = Boolean.TRUE;
            continue;
          }
          if (paramArrayOfObject.left$Mnadjust != Boolean.FALSE) {
            paramArrayOfObject.leading$Mn0s = Boolean.FALSE;
          }
          if (paramArrayOfObject.signed != Boolean.FALSE) {
            paramArrayOfObject.blank = Boolean.FALSE;
          }
          paramArrayOfObject.width = paramArrayOfObject.lambda22readFormatNumber();
          paramObject1 = paramArrayOfObject.width;
        }
        try
        {
          paramObject2 = LangObjType.coerceRealNum(paramObject1);
          if (numbers.isNegative((RealNum)paramObject2))
          {
            paramArrayOfObject.left$Mnadjust = Boolean.TRUE;
            paramArrayOfObject.width = AddOp.$Mn.apply1(paramArrayOfObject.width);
          }
          if (Scheme.isEqv.apply2(Lit11, localframe9.fc) != Boolean.FALSE)
          {
            localframe9.lambda18mustAdvance();
            paramArrayOfObject.precision = paramArrayOfObject.lambda22readFormatNumber();
          }
          paramObject1 = localframe9.fc;
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit30);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 != Boolean.FALSE) {
              localframe9.lambda18mustAdvance();
            }
            if (lists.isNull(paramArrayOfObject.args)) {
              paramObject1 = localframe9.fc;
            }
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "negative?", 1, paramObject1);
        }
        try
        {
          paramObject2 = (Char)paramObject1;
          if (lists.memv(unicode.charDowncase((Char)paramObject2), Lit33) != Boolean.FALSE) {
            misc.error$V(Lit34, new Object[] { "wrong number of arguments", Integer.valueOf(lists.length(localframe9.args)), localframe9.format$Mnstring });
          }
          paramObject1 = localframe9.fc;
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit35);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 != Boolean.FALSE)
            {
              paramObject2 = Scheme.applyToArgs;
              localObject1 = localframe9.out;
              paramObject1 = lists.car.apply1(paramArrayOfObject.args);
              if (!(paramObject1 instanceof Object[])) {
                continue;
              }
              paramObject1 = (Object[])paramObject1;
              paramObject2 = ((Procedure)paramObject2).apply2(localObject1, strings.$make$string$((Object[])paramObject1));
              paramObject1 = paramObject2;
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
              continue;
              paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit31);
              if (paramObject2 != Boolean.FALSE)
              {
                if (paramObject2 == Boolean.FALSE) {
                  continue;
                }
                continue;
              }
              if (Scheme.isEqv.apply2(paramObject1, Lit32) == Boolean.FALSE) {
                continue;
              }
              continue;
            }
          }
          else {
            if (Scheme.isEqv.apply2(paramObject1, Lit36) != Boolean.FALSE) {
              continue;
            }
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit37);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            if (!misc.isSymbol(lists.car.apply1(paramArrayOfObject.args))) {
              continue;
            }
            paramObject1 = lists.car.apply1(paramArrayOfObject.args);
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "char-downcase", 1, paramObject1);
        }
        try
        {
          paramObject2 = (Symbol)paramObject1;
          paramObject1 = misc.symbol$To$String((Symbol)paramObject2);
          paramObject2 = paramArrayOfObject.precision;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "symbol->string", 1, paramObject1);
        }
        try
        {
          localObject1 = LangObjType.coerceRealNum(paramObject2);
          bool = numbers.isNegative((RealNum)localObject1);
          if (bool)
          {
            paramObject2 = paramObject1;
            if (bool) {}
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "negative?", 1, paramObject2);
        }
        try
        {
          paramObject2 = (CharSequence)paramObject1;
          paramObject1 = paramArrayOfObject.precision;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "substring", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          paramObject2 = strings.substring((CharSequence)paramObject2, 0, i);
          paramObject1 = Scheme.numLEq;
          localObject1 = paramArrayOfObject.width;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "substring", 3, paramObject1);
        }
        try
        {
          localObject2 = (CharSequence)paramObject2;
          if (((Procedure)paramObject1).apply2(localObject1, Integer.valueOf(strings.stringLength((CharSequence)localObject2))) != Boolean.FALSE)
          {
            paramObject2 = localframe9.lambda21out$St(paramObject2);
            paramObject1 = paramObject2;
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
            continue;
            paramObject1 = new Object[] { paramObject1 };
            continue;
            if (Scheme.isEqv.apply2(paramObject1, Lit38) != Boolean.FALSE) {
              continue;
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit39);
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramArrayOfObject.pr = paramArrayOfObject.precision;
            paramArrayOfObject.os = "";
            localObject1 = lists.car.apply1(paramArrayOfObject.args);
            if (paramArrayOfObject.alternate$Mnform == Boolean.FALSE) {
              continue;
            }
            paramObject2 = Boolean.FALSE;
            localObject2 = Boolean.FALSE;
            paramObject1 = paramArrayOfObject.left$Mnadjust;
            if (paramObject1 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = paramArrayOfObject.pr;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
        }
        try
        {
          localObject3 = LangObjType.coerceRealNum(paramObject1);
          if (numbers.isNegative((RealNum)localObject3))
          {
            paramArrayOfObject.pr = Lit1;
            paramObject1 = paramArrayOfObject.lambda$Fn13;
            genwrite.genericWrite(localObject1, paramObject2, localObject2, paramObject1);
            paramObject1 = paramArrayOfObject.left$Mnadjust;
            if (paramObject1 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = paramArrayOfObject.precision;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "negative?", 1, paramObject1);
        }
        try
        {
          paramObject2 = LangObjType.coerceRealNum(paramObject1);
          if (numbers.isNegative((RealNum)paramObject2)) {
            if (Scheme.numGrt.apply2(paramArrayOfObject.width, paramArrayOfObject.pr) != Boolean.FALSE)
            {
              paramObject2 = Scheme.applyToArgs;
              localObject1 = localframe9.out;
              paramObject1 = AddOp.$Mn.apply2(paramArrayOfObject.width, paramArrayOfObject.pr);
            }
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "negative?", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          ((Procedure)paramObject2).apply2(localObject1, strings.makeString(i, Lit29));
          paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "make-string", 1, paramObject1);
        }
        if (lists.car.apply1(paramArrayOfObject.args) == Boolean.FALSE)
        {
          paramObject1 = "(NULL)";
        }
        else
        {
          paramObject1 = lists.car.apply1(paramArrayOfObject.args);
          continue;
          localObject1 = Scheme.numGEq;
          localObject2 = paramArrayOfObject.precision;
        }
        try
        {
          localObject3 = (CharSequence)paramObject1;
          paramObject2 = paramObject1;
          if (((Procedure)localObject1).apply2(localObject2, Integer.valueOf(strings.stringLength((CharSequence)localObject3))) != Boolean.FALSE) {
            continue;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
        }
        if (paramArrayOfObject.left$Mnadjust != Boolean.FALSE)
        {
          paramObject1 = AddOp.$Mn;
          localObject1 = paramArrayOfObject.width;
        }
        try
        {
          localObject2 = (CharSequence)paramObject2;
          paramObject1 = ((Procedure)paramObject1).apply2(localObject1, Integer.valueOf(strings.stringLength((CharSequence)localObject2)));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          paramObject2 = LList.list2(paramObject2, strings.makeString(i, Lit29));
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "make-string", 1, paramObject1);
        }
        paramObject1 = AddOp.$Mn;
        localObject1 = paramArrayOfObject.width;
        try
        {
          localObject2 = (CharSequence)paramObject2;
          paramObject1 = ((Procedure)paramObject1).apply2(localObject1, Integer.valueOf(strings.stringLength((CharSequence)localObject2)));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          if (paramArrayOfObject.leading$Mn0s != Boolean.FALSE)
          {
            paramObject1 = Lit9;
            paramObject2 = LList.list2(strings.makeString(i, paramObject1), paramObject2);
            continue;
          }
          paramObject1 = Lit29;
          continue;
          if (Scheme.isEqv.apply2(paramObject1, Lit40) != Boolean.FALSE) {
            continue;
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit12);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject2 = localframe9.lambda21out$St(paramArrayOfObject.lambda24integerConvert(lists.car.apply1(paramArrayOfObject.args), Lit45, Boolean.FALSE));
            paramObject1 = paramObject2;
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
            continue;
            paramObject2 = Boolean.TRUE;
            continue;
            if (paramObject1 != Boolean.FALSE) {
              continue;
            }
            if (paramArrayOfObject.left$Mnadjust != Boolean.FALSE)
            {
              paramObject1 = paramArrayOfObject.lambda$Fn14;
              continue;
            }
            paramObject1 = paramArrayOfObject.pr;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "make-string", 1, paramObject1);
        }
        try
        {
          localObject3 = LangObjType.coerceRealNum(paramObject1);
          if (numbers.isNegative((RealNum)localObject3))
          {
            paramArrayOfObject.pr = paramArrayOfObject.width;
            paramObject1 = paramArrayOfObject.lambda$Fn15;
            continue;
          }
          paramObject1 = paramArrayOfObject.lambda$Fn16;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "negative?", 1, paramObject1);
        }
        if (paramObject1 == Boolean.FALSE) {
          if (paramArrayOfObject.left$Mnadjust != Boolean.FALSE)
          {
            if (Scheme.numGrt.apply2(paramArrayOfObject.width, AddOp.$Mn.apply2(paramArrayOfObject.precision, paramArrayOfObject.pr)) == Boolean.FALSE) {
              continue;
            }
            paramObject2 = Scheme.applyToArgs;
            localObject1 = localframe9.out;
            paramObject1 = AddOp.$Mn.apply2(paramArrayOfObject.width, AddOp.$Mn.apply2(paramArrayOfObject.precision, paramArrayOfObject.pr));
          }
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          ((Procedure)paramObject2).apply2(localObject1, strings.makeString(i, Lit29));
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "make-string", 1, paramObject1);
        }
        paramObject1 = paramArrayOfObject.os;
        try
        {
          paramObject2 = Boolean.FALSE;
          if (paramObject1 != paramObject2)
          {
            i = 1;
            if ((i + 1 & 0x1) != 0) {
              continue;
            }
            paramObject2 = Scheme.numLEq;
            localObject1 = paramArrayOfObject.width;
            paramObject1 = paramArrayOfObject.os;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
        }
        try
        {
          localObject2 = (CharSequence)paramObject1;
          if (((Procedure)paramObject2).apply2(localObject1, Integer.valueOf(strings.stringLength((CharSequence)localObject2))) != Boolean.FALSE)
          {
            Scheme.applyToArgs.apply2(localframe9.out, paramArrayOfObject.os);
            continue;
            i = 0;
            continue;
          }
          paramObject1 = Scheme.applyToArgs;
          paramObject2 = localframe9.out;
          localObject2 = AddOp.$Mn;
          localObject3 = paramArrayOfObject.width;
          localObject1 = paramArrayOfObject.os;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
        }
        try
        {
          localObject4 = (CharSequence)localObject1;
          localObject1 = ((Procedure)localObject2).apply2(localObject3, Integer.valueOf(strings.stringLength((CharSequence)localObject4)));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, localObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          if (((Procedure)paramObject1).apply2(paramObject2, strings.makeString(i, Lit29)) == Boolean.FALSE) {
            continue;
          }
          Scheme.applyToArgs.apply2(localframe9.out, paramArrayOfObject.os);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "make-string", 1, localObject1);
        }
        paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit41);
        if (paramObject2 != Boolean.FALSE)
        {
          if (paramObject2 != Boolean.FALSE) {
            continue;
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit46);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject2 = localframe9.lambda21out$St(paramArrayOfObject.lambda24integerConvert(lists.car.apply1(paramArrayOfObject.args), Lit48, Boolean.FALSE));
            paramObject1 = paramObject2;
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
          }
        }
        else
        {
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit3);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit42);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit43);
          if (paramObject2 != Boolean.FALSE)
          {
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            continue;
          }
          if (Scheme.isEqv.apply2(paramObject1, Lit44) == Boolean.FALSE) {
            continue;
          }
          continue;
        }
        if (Scheme.isEqv.apply2(paramObject1, Lit47) == Boolean.FALSE) {
          if (Scheme.isEqv.apply2(paramObject1, Lit49) != Boolean.FALSE)
          {
            paramObject2 = lists.car.apply1(paramArrayOfObject.args);
            localObject1 = Lit50;
            if (stdio$Clhex$Mnupper$Mncase$Qu)
            {
              paramObject1 = unicode.string$Mndowncase;
              paramObject2 = localframe9.lambda21out$St(paramArrayOfObject.lambda24integerConvert(paramObject2, localObject1, paramObject1));
              paramObject1 = paramObject2;
              if (paramObject2 != Boolean.FALSE) {
                paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
              }
            }
            else
            {
              paramObject1 = Boolean.FALSE;
            }
          }
          else if (Scheme.isEqv.apply2(paramObject1, Lit51) != Boolean.FALSE)
          {
            paramObject2 = lists.car.apply1(paramArrayOfObject.args);
            localObject1 = Lit50;
            if (stdio$Clhex$Mnupper$Mncase$Qu)
            {
              paramObject1 = Boolean.FALSE;
              paramObject2 = localframe9.lambda21out$St(paramArrayOfObject.lambda24integerConvert(paramObject2, localObject1, paramObject1));
              paramObject1 = paramObject2;
              if (paramObject2 != Boolean.FALSE) {
                paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
              }
            }
            else
            {
              paramObject1 = unicode.string$Mnupcase;
            }
          }
          else
          {
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit52);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 != Boolean.FALSE)
              {
                paramObject2 = localframe9.lambda21out$St(paramArrayOfObject.lambda24integerConvert(lists.car.apply1(paramArrayOfObject.args), Lit14, Boolean.FALSE));
                paramObject1 = paramObject2;
                if (paramObject2 == Boolean.FALSE) {
                  continue;
                }
                paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
              }
            }
            else {
              if (Scheme.isEqv.apply2(paramObject1, Lit53) != Boolean.FALSE) {
                continue;
              }
            }
            if (Scheme.isEqv.apply2(paramObject1, Lit28) != Boolean.FALSE)
            {
              paramObject2 = Scheme.applyToArgs.apply2(localframe9.out, Lit28);
              paramObject1 = paramObject2;
              if (paramObject2 != Boolean.FALSE) {
                paramObject1 = paramArrayOfObject.args;
              }
            }
            else
            {
              paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit25);
              if (paramObject2 != Boolean.FALSE)
              {
                if (paramObject2 == Boolean.FALSE) {
                  continue;
                }
                paramObject1 = lists.car.apply1(paramArrayOfObject.args);
                localObject1 = localframe9.fc;
                paramObject2 = new frame11();
                ((frame11)paramObject2).staticLink = paramArrayOfObject;
                ((frame11)paramObject2).fc = localObject1;
                localObject1 = paramArrayOfObject.precision;
              }
            }
          }
        }
        try
        {
          localObject2 = LangObjType.coerceRealNum(localObject1);
          if (numbers.isNegative((RealNum)localObject2))
          {
            paramArrayOfObject.precision = Lit59;
            if (!numbers.isNumber(paramObject1)) {
              continue;
            }
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "negative?", 1, localObject1);
        }
        try
        {
          localObject1 = (Number)paramObject1;
          paramObject1 = numbers.number$To$String(numbers.exact$To$Inexact((Number)localObject1));
          ((frame11)paramObject2).format$Mnreal = ((frame11)paramObject2).format$Mnreal;
          paramObject1 = stdio$ClParseFloat(paramObject1, ((frame11)paramObject2).lambda$Fn17);
          if (paramObject1 != Boolean.FALSE)
          {
            paramObject2 = localframe9.lambda21out$St(paramObject1);
            paramObject1 = paramObject2;
            if (paramObject2 == Boolean.FALSE) {
              continue;
            }
            paramObject1 = lists.cdr.apply1(paramArrayOfObject.args);
            continue;
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit26);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 != Boolean.FALSE) {
                continue;
              }
              if (!localframe9.lambda19isEndOfFormat()) {
                continue;
              }
              return localframe9.lambda20incomplete();
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit13);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit54);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit55);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit56);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            paramObject2 = Scheme.isEqv.apply2(paramObject1, Lit57);
            if (paramObject2 != Boolean.FALSE)
            {
              if (paramObject2 == Boolean.FALSE) {
                continue;
              }
              continue;
            }
            if (Scheme.isEqv.apply2(paramObject1, Lit58) == Boolean.FALSE) {
              continue;
            }
            continue;
            localObject1 = paramArrayOfObject.precision;
          }
          try
          {
            localObject2 = (Number)localObject1;
            bool = numbers.isZero((Number)localObject2);
            if (bool) {
              localObject1 = ((frame11)paramObject2).fc;
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "zero?", 1, localObject1);
          }
          try
          {
            localObject2 = (Char)localObject1;
            if (!unicode.isCharCi$Eq((Char)localObject2, Lit55)) {
              continue;
            }
            paramArrayOfObject.precision = Lit7;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "char-ci=?", 1, localObject1);
          }
          if (!bool) {
            continue;
          }
          continue;
          if (strings.isString(paramObject1)) {
            continue;
          }
          if (!misc.isSymbol(paramObject1)) {}
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "exact->inexact", 1, paramObject1);
        }
        try
        {
          localObject1 = (Symbol)paramObject1;
          paramObject1 = misc.symbol$To$String((Symbol)localObject1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "symbol->string", 1, paramObject1);
        }
        paramObject1 = "???";
        continue;
        paramObject1 = paramArrayOfObject.lambda23pad$V("???", new Object[0]);
        continue;
        paramObject2 = Scheme.applyToArgs.apply2(localframe9.out, Lit28);
        paramObject1 = paramObject2;
        if (paramObject2 != Boolean.FALSE)
        {
          paramObject2 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
          paramObject1 = paramObject2;
          if (paramObject2 != Boolean.FALSE)
          {
            paramObject2 = Scheme.applyToArgs.apply2(localframe9.out, Lit65);
            paramObject1 = paramObject2;
            if (paramObject2 != Boolean.FALSE)
            {
              paramObject1 = paramArrayOfObject.args;
              continue;
              paramObject2 = Scheme.applyToArgs.apply2(localframe9.out, localframe9.fc);
              paramObject1 = paramObject2;
              if (paramObject2 != Boolean.FALSE) {
                paramObject1 = paramArrayOfObject.args;
              }
            }
          }
        }
      }
    }
    return Values.empty;
  }
  
  public static Object stdio$ClParseFloat(Object paramObject1, Object paramObject2)
  {
    frame localframe = new frame();
    localframe.str = paramObject1;
    localframe.proc = paramObject2;
    paramObject1 = localframe.str;
    try
    {
      paramObject2 = (CharSequence)paramObject1;
      localframe.n = strings.stringLength((CharSequence)paramObject2);
      return localframe.lambda4real(Lit1, localframe.lambda$Fn1);
    }
    catch (ClassCastException paramObject2)
    {
      throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
    }
  }
  
  /* Error */
  public static Object stdio$ClRoundString(CharSequence paramCharSequence, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 45	gnu/kawa/slib/printf$frame8
    //   3: dup
    //   4: invokespecial 835	gnu/kawa/slib/printf$frame8:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: aload_0
    //   12: putfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   15: aload 7
    //   17: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   20: invokestatic 497	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   23: iconst_1
    //   24: isub
    //   25: istore_3
    //   26: getstatic 841	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   29: aload_1
    //   30: getstatic 400	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   33: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   39: if_acmpeq +93 -> 132
    //   42: ldc -31
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   51: if_acmpeq +79 -> 130
    //   54: aload_0
    //   55: checkcast 493	java/lang/CharSequence
    //   58: astore_1
    //   59: aload_1
    //   60: invokestatic 497	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   63: iconst_1
    //   64: isub
    //   65: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: astore_1
    //   69: getstatic 709	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore 6
    //   79: aload 6
    //   81: checkcast 526	java/lang/Boolean
    //   84: invokevirtual 844	java/lang/Boolean:booleanValue	()Z
    //   87: istore 5
    //   89: iload 5
    //   91: ifeq +547 -> 638
    //   94: iload 5
    //   96: ifeq +578 -> 674
    //   99: aload_0
    //   100: checkcast 493	java/lang/CharSequence
    //   103: astore_2
    //   104: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   107: aload_1
    //   108: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   111: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: astore_0
    //   115: aload_0
    //   116: checkcast 516	java/lang/Number
    //   119: invokevirtual 520	java/lang/Number:intValue	()I
    //   122: istore_3
    //   123: aload_2
    //   124: iconst_0
    //   125: iload_3
    //   126: invokestatic 549	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   129: astore_1
    //   130: aload_1
    //   131: areturn
    //   132: getstatic 847	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   135: iload_3
    //   136: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aload_1
    //   140: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   146: if_acmpeq +12 -> 158
    //   149: aload 7
    //   151: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   154: astore_0
    //   155: goto -110 -> 45
    //   158: getstatic 841	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   161: iload_3
    //   162: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aload_1
    //   166: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   172: if_acmpeq +139 -> 311
    //   175: getstatic 400	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   178: astore 6
    //   180: getstatic 660	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   183: astore 8
    //   185: aload_1
    //   186: astore_0
    //   187: aload_2
    //   188: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   191: if_acmpeq +5 -> 196
    //   194: aload_2
    //   195: astore_0
    //   196: iconst_2
    //   197: anewarray 207	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 6
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: aload 8
    //   209: aload_0
    //   210: iload_3
    //   211: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: aastore
    //   218: invokestatic 851	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   221: astore_0
    //   222: aload_0
    //   223: checkcast 516	java/lang/Number
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 788	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   231: ifeq +12 -> 243
    //   234: aload 7
    //   236: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   239: astore_0
    //   240: goto -195 -> 45
    //   243: aload 7
    //   245: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   248: astore_1
    //   249: aload_0
    //   250: checkcast 516	java/lang/Number
    //   253: invokevirtual 520	java/lang/Number:intValue	()I
    //   256: istore 4
    //   258: aload 7
    //   260: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   263: iload_3
    //   264: invokestatic 579	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   267: invokestatic 179	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   270: invokestatic 855	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   273: ifeq +31 -> 304
    //   276: getstatic 384	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   279: astore_0
    //   280: iconst_2
    //   281: anewarray 207	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload_1
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: iload 4
    //   292: aload_0
    //   293: invokestatic 732	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   296: aastore
    //   297: invokestatic 859	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   300: astore_0
    //   301: goto -61 -> 240
    //   304: getstatic 386	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
    //   307: astore_0
    //   308: goto -28 -> 280
    //   311: aload 7
    //   313: getfield 838	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   316: astore 6
    //   318: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   321: aload_1
    //   322: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   325: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: astore_0
    //   329: aload_0
    //   330: checkcast 516	java/lang/Number
    //   333: invokevirtual 520	java/lang/Number:intValue	()I
    //   336: istore 4
    //   338: aload 6
    //   340: iconst_0
    //   341: iload 4
    //   343: invokestatic 549	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   346: astore 6
    //   348: aload 7
    //   350: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   353: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   356: aload_1
    //   357: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   360: invokevirtual 862	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   363: astore 8
    //   365: getstatic 729	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   368: aload 8
    //   370: getstatic 366	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   373: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: astore_0
    //   377: aload_0
    //   378: checkcast 526	java/lang/Boolean
    //   381: invokevirtual 844	java/lang/Boolean:booleanValue	()Z
    //   384: istore 5
    //   386: iload 5
    //   388: ifeq +90 -> 478
    //   391: aload 6
    //   393: astore_0
    //   394: iload 5
    //   396: ifeq -351 -> 45
    //   399: aload_1
    //   400: astore_0
    //   401: aload 7
    //   403: aload_0
    //   404: invokevirtual 862	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   407: astore 8
    //   409: getstatic 841	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   412: aload 8
    //   414: getstatic 364	gnu/kawa/slib/printf:Lit16	Lgnu/math/IntNum;
    //   417: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   420: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   423: if_acmpeq +180 -> 603
    //   426: aload 6
    //   428: checkcast 864	gnu/lists/CharSeq
    //   431: astore_1
    //   432: aload_0
    //   433: checkcast 516	java/lang/Number
    //   436: invokevirtual 520	java/lang/Number:intValue	()I
    //   439: istore_3
    //   440: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   443: aload 8
    //   445: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   448: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   451: astore_0
    //   452: aload_0
    //   453: checkcast 516	java/lang/Number
    //   456: astore 7
    //   458: aload_1
    //   459: iload_3
    //   460: aload 7
    //   462: invokestatic 772	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   465: iconst_0
    //   466: invokestatic 579	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   469: invokestatic 868	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   472: aload 6
    //   474: astore_0
    //   475: goto -430 -> 45
    //   478: getstatic 847	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   481: aload 8
    //   483: getstatic 366	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   486: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: astore_0
    //   490: aload_0
    //   491: checkcast 526	java/lang/Boolean
    //   494: invokevirtual 844	java/lang/Boolean:booleanValue	()Z
    //   497: istore 5
    //   499: iload 5
    //   501: ifeq +91 -> 592
    //   504: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   507: getstatic 368	gnu/kawa/slib/printf:Lit14	Lgnu/math/IntNum;
    //   510: aload_1
    //   511: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: astore_0
    //   515: getstatic 729	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   518: aload_0
    //   519: iload_3
    //   520: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: getstatic 530	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   529: if_acmpeq +26 -> 555
    //   532: aload 6
    //   534: astore_0
    //   535: aload 7
    //   537: aload_1
    //   538: invokevirtual 862	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   541: checkcast 516	java/lang/Number
    //   544: invokevirtual 520	java/lang/Number:intValue	()I
    //   547: iconst_1
    //   548: iand
    //   549: ifeq -504 -> 45
    //   552: goto -153 -> 399
    //   555: aload 7
    //   557: aload_0
    //   558: invokevirtual 862	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   561: astore 8
    //   563: aload 8
    //   565: checkcast 516	java/lang/Number
    //   568: astore 9
    //   570: aload 9
    //   572: invokestatic 788	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   575: ifeq -176 -> 399
    //   578: getstatic 602	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   581: aload_0
    //   582: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   585: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   588: astore_0
    //   589: goto -74 -> 515
    //   592: aload 6
    //   594: astore_0
    //   595: iload 5
    //   597: ifeq -552 -> 45
    //   600: goto -201 -> 399
    //   603: aload 6
    //   605: checkcast 864	gnu/lists/CharSeq
    //   608: astore_1
    //   609: aload_0
    //   610: checkcast 516	java/lang/Number
    //   613: invokevirtual 520	java/lang/Number:intValue	()I
    //   616: istore_3
    //   617: aload_1
    //   618: iload_3
    //   619: bipush 48
    //   621: invokestatic 868	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   624: getstatic 660	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   627: aload_0
    //   628: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   631: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   634: astore_0
    //   635: goto -234 -> 401
    //   638: getstatic 384	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   641: astore 6
    //   643: aload_0
    //   644: checkcast 493	java/lang/CharSequence
    //   647: astore 7
    //   649: aload_1
    //   650: checkcast 516	java/lang/Number
    //   653: invokevirtual 520	java/lang/Number:intValue	()I
    //   656: istore_3
    //   657: aload 6
    //   659: aload 7
    //   661: iload_3
    //   662: invokestatic 579	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   665: invokestatic 179	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   668: invokestatic 873	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   671: ifeq -572 -> 99
    //   674: getstatic 660	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   677: aload_1
    //   678: getstatic 388	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   681: invokevirtual 545	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   684: astore_1
    //   685: goto -616 -> 69
    //   688: astore_1
    //   689: new 551	gnu/mapping/WrongType
    //   692: dup
    //   693: aload_1
    //   694: ldc_w 815
    //   697: iconst_1
    //   698: aload_0
    //   699: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   702: athrow
    //   703: astore_1
    //   704: new 551	gnu/mapping/WrongType
    //   707: dup
    //   708: aload_1
    //   709: ldc_w 553
    //   712: iconst_1
    //   713: aload_0
    //   714: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   717: athrow
    //   718: astore_1
    //   719: new 551	gnu/mapping/WrongType
    //   722: dup
    //   723: aload_1
    //   724: ldc_w 559
    //   727: iconst_3
    //   728: aload_0
    //   729: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   732: athrow
    //   733: astore_1
    //   734: new 551	gnu/mapping/WrongType
    //   737: dup
    //   738: aload_1
    //   739: ldc_w 813
    //   742: bipush -2
    //   744: aload_0
    //   745: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   748: athrow
    //   749: astore_1
    //   750: new 551	gnu/mapping/WrongType
    //   753: dup
    //   754: aload_1
    //   755: ldc_w 813
    //   758: bipush -2
    //   760: aload_0
    //   761: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   764: athrow
    //   765: astore_0
    //   766: new 551	gnu/mapping/WrongType
    //   769: dup
    //   770: aload_0
    //   771: ldc_w 815
    //   774: iconst_1
    //   775: aload 8
    //   777: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   780: athrow
    //   781: astore_0
    //   782: new 551	gnu/mapping/WrongType
    //   785: dup
    //   786: aload_0
    //   787: ldc_w 875
    //   790: iconst_1
    //   791: aload 6
    //   793: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   796: athrow
    //   797: astore_1
    //   798: new 551	gnu/mapping/WrongType
    //   801: dup
    //   802: aload_1
    //   803: ldc_w 875
    //   806: iconst_2
    //   807: aload_0
    //   808: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   811: athrow
    //   812: astore_1
    //   813: new 551	gnu/mapping/WrongType
    //   816: dup
    //   817: aload_1
    //   818: ldc_w 877
    //   821: iconst_1
    //   822: aload_0
    //   823: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   826: athrow
    //   827: astore_0
    //   828: new 551	gnu/mapping/WrongType
    //   831: dup
    //   832: aload_0
    //   833: ldc_w 875
    //   836: iconst_1
    //   837: aload 6
    //   839: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   842: athrow
    //   843: astore_1
    //   844: new 551	gnu/mapping/WrongType
    //   847: dup
    //   848: aload_1
    //   849: ldc_w 875
    //   852: iconst_2
    //   853: aload_0
    //   854: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   857: athrow
    //   858: astore_1
    //   859: new 551	gnu/mapping/WrongType
    //   862: dup
    //   863: aload_1
    //   864: ldc_w 558
    //   867: iconst_1
    //   868: aload_0
    //   869: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   872: athrow
    //   873: astore_0
    //   874: new 551	gnu/mapping/WrongType
    //   877: dup
    //   878: aload_0
    //   879: ldc_w 813
    //   882: bipush -2
    //   884: aload 6
    //   886: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   889: athrow
    //   890: astore_1
    //   891: new 551	gnu/mapping/WrongType
    //   894: dup
    //   895: aload_1
    //   896: ldc_w 805
    //   899: iconst_1
    //   900: aload_0
    //   901: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   904: athrow
    //   905: astore_0
    //   906: new 551	gnu/mapping/WrongType
    //   909: dup
    //   910: aload_0
    //   911: ldc_w 805
    //   914: iconst_2
    //   915: aload_1
    //   916: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   919: athrow
    //   920: astore_1
    //   921: new 551	gnu/mapping/WrongType
    //   924: dup
    //   925: aload_1
    //   926: ldc_w 559
    //   929: iconst_1
    //   930: aload_0
    //   931: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   934: athrow
    //   935: astore_1
    //   936: new 551	gnu/mapping/WrongType
    //   939: dup
    //   940: aload_1
    //   941: ldc_w 559
    //   944: iconst_3
    //   945: aload_0
    //   946: invokespecial 556	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   949: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	950	0	paramCharSequence	CharSequence
    //   0	950	1	paramObject1	Object
    //   0	950	2	paramObject2	Object
    //   25	637	3	i	int
    //   256	86	4	j	int
    //   87	509	5	bool	boolean
    //   77	808	6	localObject1	Object
    //   7	653	7	localObject2	Object
    //   183	593	8	localObject3	Object
    //   568	3	9	localNumber	Number
    // Exception table:
    //   from	to	target	type
    //   222	227	688	java/lang/ClassCastException
    //   249	258	703	java/lang/ClassCastException
    //   329	338	718	java/lang/ClassCastException
    //   377	386	733	java/lang/ClassCastException
    //   490	499	749	java/lang/ClassCastException
    //   563	570	765	java/lang/ClassCastException
    //   426	432	781	java/lang/ClassCastException
    //   432	440	797	java/lang/ClassCastException
    //   452	458	812	java/lang/ClassCastException
    //   603	609	827	java/lang/ClassCastException
    //   609	617	843	java/lang/ClassCastException
    //   54	59	858	java/lang/ClassCastException
    //   79	89	873	java/lang/ClassCastException
    //   643	649	890	java/lang/ClassCastException
    //   649	657	905	java/lang/ClassCastException
    //   99	104	920	java/lang/ClassCastException
    //   115	123	935	java/lang/ClassCastException
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 22) {
      return stdio$ClParseFloat(paramObject1, paramObject2);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 23) {}
    try
    {
      paramModuleMethod = (CharSequence)paramObject1;
      return stdio$ClRoundString(paramModuleMethod, paramObject2, paramObject3);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "stdio:round-string", 1, paramObject1);
    }
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 24: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      arrayOfObject = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return stdio$ClIprintf$V(paramModuleMethod, localObject, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 2)];
      }
    case 25: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      arrayOfObject = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return fprintf$V(paramModuleMethod, localObject, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 2)];
      }
    case 26: 
      paramModuleMethod = paramArrayOfObject[0];
      i = paramArrayOfObject.length - 1;
      localObject = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return printf$V(paramModuleMethod, (Object[])localObject);
        }
        localObject[i] = paramArrayOfObject[(i + 1)];
      }
    }
    paramModuleMethod = paramArrayOfObject[0];
    Object localObject = paramArrayOfObject[1];
    int i = paramArrayOfObject.length - 2;
    Object[] arrayOfObject = new Object[i];
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        return sprintf$V(paramModuleMethod, localObject, arrayOfObject);
      }
      arrayOfObject[i] = paramArrayOfObject[(i + 2)];
    }
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 22)
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
    if (paramModuleMethod.selector == 23)
    {
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
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 27: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 26: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 25: 
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
    stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(Lit0, 16));
  }
  
  public class frame
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    int n;
    Object proc;
    Object str;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 12, null, 16388);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:106");
      this.lambda$Fn1 = this$1;
    }
    
    public static Boolean lambda1parseError()
    {
      return Boolean.FALSE;
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda5(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    public Object lambda2sign(Object paramObject1, Object paramObject2)
    {
      if (Scheme.numLss.apply2(paramObject1, Integer.valueOf(this.n)) != Boolean.FALSE) {
        localObject = this.str;
      }
      for (;;)
      {
        try
        {
          localCharSequence = (CharSequence)localObject;
        }
        catch (ClassCastException paramObject1)
        {
          CharSequence localCharSequence;
          int i;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          i = strings.stringRef(localCharSequence, i);
          localObject = Scheme.isEqv.apply2(Char.make(i), printf.Lit5);
          if (localObject != Boolean.FALSE)
          {
            if (localObject != Boolean.FALSE) {
              return Scheme.applyToArgs.apply3(paramObject2, AddOp.$Pl.apply2(paramObject1, printf.Lit7), Char.make(i));
            }
          }
          else {
            if (Scheme.isEqv.apply2(Char.make(i), printf.Lit6) != Boolean.FALSE) {
              continue;
            }
          }
          return Scheme.applyToArgs.apply3(paramObject2, paramObject1, printf.Lit6);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
      }
      return Values.empty;
    }
    
    public Object lambda3digits(Object paramObject1, Object paramObject2)
    {
      localObject1 = paramObject1;
      localObject2 = Scheme.numGEq.apply2(localObject1, Integer.valueOf(this.n));
      for (;;)
      {
        try
        {
          bool = ((Boolean)localObject2).booleanValue();
          if (bool)
          {
            if (bool) {
              continue;
            }
            localObject1 = AddOp.$Pl.apply2(localObject1, printf.Lit7);
            break;
          }
          localObject2 = this.str;
        }
        catch (ClassCastException paramObject1)
        {
          try
          {
            boolean bool;
            localCharSequence = (CharSequence)localObject3;
          }
          catch (ClassCastException paramObject1)
          {
            Object localObject3;
            int i;
            CharSequence localCharSequence;
            int j;
            throw new WrongType((ClassCastException)paramObject1, "substring", 1, localObject3);
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
            j = ((Number)localObject1).intValue();
            paramObject1 = strings.substring(localCharSequence, i, j);
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject1);
          }
          paramObject1 = paramObject1;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject2);
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
          i = ((Number)localObject1).intValue();
          bool = unicode.isCharNumeric(Char.make(strings.stringRef((CharSequence)localObject3, i)));
          if (bool)
          {
            if (bool) {
              continue;
            }
            localObject2 = Scheme.applyToArgs;
            if (Scheme.numEqu.apply2(paramObject1, localObject1) != Boolean.FALSE)
            {
              paramObject1 = "0";
              return ((Procedure)localObject2).apply3(paramObject2, localObject1, paramObject1);
            }
          }
          else
          {
            localObject3 = printf.Lit8;
            localObject2 = this.str;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
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
          if (!characters.isChar$Eq((Char)localObject3, Char.make(strings.stringRef(localCharSequence, i)))) {}
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
      }
      localObject3 = this.str;
    }
    
    public Object lambda4real(Object paramObject1, Object paramObject2)
    {
      localObject1 = new printf.frame2();
      ((printf.frame2)localObject1).staticLink = this;
      ((printf.frame2)localObject1).cont = paramObject2;
      paramObject2 = ((printf.frame2)localObject1).lambda$Fn5;
      for (;;)
      {
        localObject1 = Scheme.numLss.apply2(paramObject1, Integer.valueOf(this.n - 1));
        try
        {
          bool = ((Boolean)localObject1).booleanValue();
          if (bool)
          {
            localObject2 = printf.Lit8;
            localObject1 = this.str;
          }
        }
        catch (ClassCastException paramObject1)
        {
          for (;;)
          {
            try
            {
              localCharSequence = (CharSequence)localObject1;
            }
            catch (ClassCastException paramObject1)
            {
              boolean bool;
              Object localObject2;
              CharSequence localCharSequence;
              int i;
              label103:
              label175:
              label234:
              label262:
              throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
            }
            try
            {
              i = ((Number)paramObject1).intValue();
              if (characters.isChar$Eq((Char)localObject2, Char.make(strings.stringRef(localCharSequence, i)))) {
                localObject1 = this.str;
              }
            }
            catch (ClassCastException paramObject2)
            {
              throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
            }
          }
          try
          {
            localObject2 = (CharSequence)localObject1;
            localObject1 = AddOp.$Pl.apply2(paramObject1, printf.Lit7);
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
          }
          try
          {
            i = ((Number)localObject1).intValue();
            i = strings.stringRef((CharSequence)localObject2, i);
            localObject1 = Scheme.isEqv.apply2(Char.make(i), printf.Lit12);
            if (localObject1 != Boolean.FALSE)
            {
              if (localObject1 != Boolean.FALSE)
              {
                paramObject1 = AddOp.$Pl.apply2(paramObject1, printf.Lit14);
                continue;
                if (bool) {
                  break label103;
                }
                return Scheme.applyToArgs.apply2(paramObject2, paramObject1);
              }
            }
            else
            {
              localObject1 = Scheme.isEqv.apply2(Char.make(i), printf.Lit3);
              if (localObject1 == Boolean.FALSE) {
                break label262;
              }
              if (localObject1 != Boolean.FALSE) {
                break label175;
              }
            }
            if (Scheme.isEqv.apply2(Char.make(i), printf.Lit11) != Boolean.FALSE)
            {
              return Scheme.applyToArgs.apply2(paramObject2, paramObject1);
              if (Scheme.isEqv.apply2(Char.make(i), printf.Lit13) == Boolean.FALSE) {
                break label234;
              }
              break label175;
            }
            return lambda1parseError();
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
          }
          paramObject1 = paramObject1;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject1);
        }
      }
    }
    
    Object lambda5(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      printf.frame0 localframe0 = new printf.frame0();
      localframe0.staticLink = this;
      localframe0.sgn = paramObject2;
      localframe0.digs = paramObject3;
      localframe0.ex = paramObject4;
      if (Scheme.numEqu.apply2(paramObject1, Integer.valueOf(this.n)) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply4(this.proc, localframe0.sgn, localframe0.digs, localframe0.ex);
      }
      paramObject2 = this.str;
      for (;;)
      {
        try
        {
          paramObject3 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          if (lists.memv(Char.make(strings.stringRef((CharSequence)paramObject3, i)), printf.Lit2) != Boolean.FALSE) {
            return lambda4real(paramObject1, localframe0.lambda$Fn2);
          }
          paramObject3 = Scheme.isEqv;
          paramObject2 = this.str;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        try
        {
          paramObject4 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          if (((Procedure)paramObject3).apply2(Char.make(strings.stringRef((CharSequence)paramObject4, i)), printf.Lit4) != Boolean.FALSE) {
            paramObject1 = this.str;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
        }
        try
        {
          paramObject2 = (CharSequence)paramObject1;
          localframe0.num = numbers.string$To$Number((CharSequence)paramObject2);
          if (localframe0.num != Boolean.FALSE) {
            paramObject1 = localframe0.num;
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string->number", 1, paramObject1);
        }
      }
      try
      {
        paramObject2 = (Complex)paramObject1;
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.realPart((Complex)paramObject2)), localframe0.lambda$Fn3);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "real-part", 1, paramObject1);
      }
      return lambda1parseError();
      return Boolean.FALSE;
    }
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    Object num;
    Object sgn;
    printf.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 16388);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:111");
      this.lambda$Fn2 = this$1;
      this$1 = new ModuleMethod(this, 3, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:123");
      this.lambda$Fn3 = this$1;
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda7(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda6(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    /* Error */
    Object lambda6(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: getstatic 77	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   3: aload_1
      //   4: aload_0
      //   5: getfield 79	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   8: getfield 82	gnu/kawa/slib/printf$frame:n	I
      //   11: iconst_1
      //   12: isub
      //   13: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   16: invokevirtual 94	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   19: astore 7
      //   21: aload 7
      //   23: checkcast 96	java/lang/Boolean
      //   26: invokevirtual 100	java/lang/Boolean:booleanValue	()Z
      //   29: istore 6
      //   31: iload 6
      //   33: ifeq +108 -> 141
      //   36: getstatic 104	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
      //   39: astore 8
      //   41: aload_0
      //   42: getfield 79	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   45: getfield 107	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   48: astore 7
      //   50: aload 7
      //   52: checkcast 109	java/lang/CharSequence
      //   55: astore 9
      //   57: aload_1
      //   58: checkcast 111	java/lang/Number
      //   61: invokevirtual 115	java/lang/Number:intValue	()I
      //   64: istore 5
      //   66: aload 8
      //   68: aload 9
      //   70: iload 5
      //   72: invokestatic 121	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   75: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   78: invokestatic 133	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   81: ifeq +65 -> 146
      //   84: getstatic 137	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   87: bipush 7
      //   89: anewarray 139	java/lang/Object
      //   92: dup
      //   93: iconst_0
      //   94: aload_0
      //   95: getfield 79	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   98: getfield 142	gnu/kawa/slib/printf$frame:proc	Ljava/lang/Object;
      //   101: aastore
      //   102: dup
      //   103: iconst_1
      //   104: aload_0
      //   105: getfield 144	gnu/kawa/slib/printf$frame0:sgn	Ljava/lang/Object;
      //   108: aastore
      //   109: dup
      //   110: iconst_2
      //   111: aload_0
      //   112: getfield 146	gnu/kawa/slib/printf$frame0:digs	Ljava/lang/Object;
      //   115: aastore
      //   116: dup
      //   117: iconst_3
      //   118: aload_0
      //   119: getfield 148	gnu/kawa/slib/printf$frame0:ex	Ljava/lang/Object;
      //   122: aastore
      //   123: dup
      //   124: iconst_4
      //   125: aload_2
      //   126: aastore
      //   127: dup
      //   128: iconst_5
      //   129: aload_3
      //   130: aastore
      //   131: dup
      //   132: bipush 6
      //   134: aload 4
      //   136: aastore
      //   137: invokevirtual 152	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   140: areturn
      //   141: iload 6
      //   143: ifne -59 -> 84
      //   146: invokestatic 156	gnu/kawa/slib/printf$frame:lambda1parseError	()Ljava/lang/Boolean;
      //   149: areturn
      //   150: astore_1
      //   151: new 158	gnu/mapping/WrongType
      //   154: dup
      //   155: aload_1
      //   156: ldc -96
      //   158: bipush -2
      //   160: aload 7
      //   162: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   165: athrow
      //   166: astore_1
      //   167: new 158	gnu/mapping/WrongType
      //   170: dup
      //   171: aload_1
      //   172: ldc -91
      //   174: iconst_1
      //   175: aload 7
      //   177: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   180: athrow
      //   181: astore_2
      //   182: new 158	gnu/mapping/WrongType
      //   185: dup
      //   186: aload_2
      //   187: ldc -91
      //   189: iconst_2
      //   190: aload_1
      //   191: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   194: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	195	0	this	frame0
      //   0	195	1	paramObject1	Object
      //   0	195	2	paramObject2	Object
      //   0	195	3	paramObject3	Object
      //   0	195	4	paramObject4	Object
      //   64	7	5	i	int
      //   29	113	6	bool	boolean
      //   19	157	7	localObject	Object
      //   39	28	8	localChar	Char
      //   55	14	9	localCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   21	31	150	java/lang/ClassCastException
      //   50	57	166	java/lang/ClassCastException
      //   57	66	181	java/lang/ClassCastException
    }
    
    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      printf.frame1 localframe1 = new printf.frame1();
      localframe1.staticLink = this;
      localframe1.sgn = paramObject1;
      localframe1.digs = paramObject2;
      localframe1.ex = paramObject3;
      paramObject1 = this.num;
      try
      {
        paramObject2 = (Complex)paramObject1;
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart((Complex)paramObject2)), localframe1.lambda$Fn4);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "imag-part", 1, paramObject1);
      }
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
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
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    }
  }
  
  public class frame1
    extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn4;
    Object sgn;
    printf.frame0 staticLink;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:126");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda8(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda8(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return Scheme.applyToArgs.applyN(new Object[] { this.staticLink.staticLink.proc, this.sgn, this.digs, this.ex, paramObject1, paramObject2, paramObject3 });
    }
    
    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
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
  
  public class frame10
    extends ModuleBody
  {
    Object alternate$Mnform;
    Object args;
    Object blank;
    final ModuleMethod lambda$Fn13;
    final ModuleMethod lambda$Fn14;
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object leading$Mn0s;
    Object left$Mnadjust;
    Object os;
    Procedure pad = new ModuleMethod(this, 15, printf.Lit67, 61441);
    Object pr;
    Object precision;
    Object signed;
    printf.frame9 staticLink;
    Object width;
    
    public frame10()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:472");
      this.lambda$Fn13 = this$1;
      this$1 = new ModuleMethod(this, 17, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:476");
      this.lambda$Fn14 = this$1;
      this$1 = new ModuleMethod(this, 18, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:484");
      this.lambda$Fn15 = this$1;
      this$1 = new ModuleMethod(this, 19, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:494");
      this.lambda$Fn16 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 16: 
        return lambda25(paramObject);
      case 17: 
        if (lambda26(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      case 18: 
        return lambda27(paramObject);
      }
      if (lambda28(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramModuleMethod = paramArrayOfObject[0];
        int i = paramArrayOfObject.length - 1;
        Object[] arrayOfObject = new Object[i];
        for (;;)
        {
          i -= 1;
          if (i < 0) {
            return lambda23pad$V(paramModuleMethod, arrayOfObject);
          }
          arrayOfObject[i] = paramArrayOfObject[(i + 1)];
        }
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    public Object lambda22readFormatNumber()
    {
      if (Scheme.isEqv.apply2(printf.Lit66, this.staticLink.fc) != Boolean.FALSE)
      {
        this.staticLink.lambda18mustAdvance();
        localObject1 = lists.car.apply1(this.args);
        this.args = lists.cdr.apply1(this.args);
        return localObject1;
      }
      Object localObject1 = this.staticLink.fc;
      Object localObject2 = printf.Lit1;
      for (;;)
      {
        Object localObject3 = this.staticLink.fc;
        try
        {
          Object localObject4 = (Char)localObject3;
          if (unicode.isCharNumeric((Char)localObject4))
          {
            this.staticLink.lambda18mustAdvance();
            localObject3 = this.staticLink.fc;
            localObject4 = AddOp.$Pl;
            localObject2 = MultiplyOp.$St.apply2(localObject2, printf.Lit45);
            if ((localObject1 instanceof Object[])) {}
            for (localObject1 = (Object[])localObject1;; localObject1 = new Object[] { localObject1 })
            {
              localObject2 = ((Procedure)localObject4).apply2(localObject2, numbers.string$To$Number(strings.$make$string$((Object[])localObject1)));
              localObject1 = localObject3;
              break;
            }
          }
          return localObject2;
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "char-numeric?", 1, localObject3);
        }
      }
    }
    
    public Object lambda23pad$V(Object paramObject, Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      try
      {
        paramArrayOfObject = (CharSequence)paramObject;
        localObject1 = Integer.valueOf(strings.stringLength(paramArrayOfObject));
        paramArrayOfObject = localLList;
      }
      catch (ClassCastException paramArrayOfObject)
      {
        try
        {
          localCharSequence = (CharSequence)localObject2;
          Object localObject1 = localAddOp.apply2(localObject1, Integer.valueOf(strings.stringLength(localCharSequence)));
          paramArrayOfObject = lists.cdr.apply1(paramArrayOfObject);
        }
        catch (ClassCastException paramObject)
        {
          Object localObject2;
          throw new WrongType((ClassCastException)paramObject, "string-length", 1, localObject2);
        }
        paramArrayOfObject = paramArrayOfObject;
        throw new WrongType(paramArrayOfObject, "string-length", 1, paramObject);
      }
      if (Scheme.numGEq.apply2(localObject1, this.width) != Boolean.FALSE) {
        return lists.cons(paramObject, localLList);
      }
      if (lists.isNull(paramArrayOfObject)) {
        if (this.left$Mnadjust != Boolean.FALSE) {
          paramArrayOfObject = AddOp.$Mn.apply2(this.width, localObject1);
        }
      }
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
        return lists.cons(paramObject, append.append$V(new Object[] { localLList, LList.list1(strings.makeString(i, printf.Lit29)) }));
      }
      catch (ClassCastException paramObject)
      {
        int i;
        throw new WrongType((ClassCastException)paramObject, "make-string", 1, paramArrayOfObject);
      }
      if (this.leading$Mn0s != Boolean.FALSE) {
        paramArrayOfObject = AddOp.$Mn.apply2(this.width, localObject1);
      }
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
        return lists.cons(paramObject, lists.cons(strings.makeString(i, printf.Lit9), localLList));
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "make-string", 1, paramArrayOfObject);
      }
      paramArrayOfObject = AddOp.$Mn.apply2(this.width, localObject1);
      try
      {
        i = ((Number)paramArrayOfObject).intValue();
        return lists.cons(strings.makeString(i, printf.Lit29), lists.cons(paramObject, localLList));
      }
      catch (ClassCastException paramObject)
      {
        AddOp localAddOp;
        CharSequence localCharSequence;
        throw new WrongType((ClassCastException)paramObject, "make-string", 1, paramArrayOfObject);
      }
      localAddOp = AddOp.$Pl;
      localObject2 = lists.car.apply1(paramArrayOfObject);
    }
    
    /* Error */
    public Object lambda24integerConvert(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 272	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   4: astore 6
      //   6: aload 6
      //   8: invokestatic 278	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   11: astore 7
      //   13: aload 7
      //   15: invokestatic 282	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   18: ifne +691 -> 709
      //   21: aload_0
      //   22: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   25: putfield 261	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
      //   28: aload_0
      //   29: getfield 272	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   32: astore 6
      //   34: aload 6
      //   36: checkcast 238	java/lang/Number
      //   39: astore 7
      //   41: aload 7
      //   43: invokestatic 286	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   46: istore 5
      //   48: iload 5
      //   50: ifeq +182 -> 232
      //   53: aload_1
      //   54: astore 6
      //   56: getstatic 119	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   59: getstatic 156	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   62: aload_1
      //   63: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   66: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   69: if_acmpeq +8 -> 77
      //   72: ldc_w 288
      //   75: astore 6
      //   77: aload 6
      //   79: astore_1
      //   80: aload_1
      //   81: invokestatic 293	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   84: ifeq +159 -> 243
      //   87: aload_1
      //   88: checkcast 295	gnu/mapping/Symbol
      //   91: astore 6
      //   93: aload 6
      //   95: invokestatic 299	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
      //   98: astore_1
      //   99: aload_1
      //   100: astore 6
      //   102: aload_3
      //   103: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   106: if_acmpeq +13 -> 119
      //   109: getstatic 303	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   112: aload_3
      //   113: aload_1
      //   114: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   117: astore 6
      //   119: ldc_w 288
      //   122: aload 6
      //   124: invokestatic 309	gnu/kawa/functions/IsEqual:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   127: ifeq +218 -> 345
      //   130: ldc_w 288
      //   133: astore_1
      //   134: getstatic 312	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   137: astore_2
      //   138: aload 6
      //   140: checkcast 208	java/lang/CharSequence
      //   143: astore_3
      //   144: aload_2
      //   145: aload_3
      //   146: invokestatic 212	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   149: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   152: aload_0
      //   153: getfield 272	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   156: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   159: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   162: if_acmpeq +352 -> 514
      //   165: getstatic 236	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   168: astore_2
      //   169: aload_0
      //   170: getfield 272	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   173: astore_3
      //   174: aload 6
      //   176: checkcast 208	java/lang/CharSequence
      //   179: astore 7
      //   181: aload_2
      //   182: aload_3
      //   183: aload 7
      //   185: invokestatic 212	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   188: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   191: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   194: astore_2
      //   195: aload_2
      //   196: checkcast 238	java/lang/Number
      //   199: invokevirtual 242	java/lang/Number:intValue	()I
      //   202: istore 4
      //   204: iload 4
      //   206: getstatic 264	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   209: invokestatic 249	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   212: astore_2
      //   213: aload_0
      //   214: aload_1
      //   215: iconst_2
      //   216: anewarray 103	java/lang/Object
      //   219: dup
      //   220: iconst_0
      //   221: aload_2
      //   222: aastore
      //   223: dup
      //   224: iconst_1
      //   225: aload 6
      //   227: aastore
      //   228: invokevirtual 107	gnu/kawa/slib/printf$frame10:lambda23pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   231: areturn
      //   232: aload_1
      //   233: astore 6
      //   235: iload 5
      //   237: ifeq -160 -> 77
      //   240: goto -168 -> 72
      //   243: aload_1
      //   244: invokestatic 315	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
      //   247: ifeq +29 -> 276
      //   250: aload_1
      //   251: checkcast 238	java/lang/Number
      //   254: astore 6
      //   256: aload_2
      //   257: checkcast 238	java/lang/Number
      //   260: invokevirtual 242	java/lang/Number:intValue	()I
      //   263: istore 4
      //   265: aload 6
      //   267: iload 4
      //   269: invokestatic 319	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
      //   272: astore_1
      //   273: goto -174 -> 99
      //   276: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   279: astore 6
      //   281: aload_1
      //   282: aload 6
      //   284: if_acmpeq +31 -> 315
      //   287: iconst_1
      //   288: istore 4
      //   290: iload 4
      //   292: iconst_1
      //   293: iadd
      //   294: iconst_1
      //   295: iand
      //   296: istore 4
      //   298: iload 4
      //   300: ifeq +21 -> 321
      //   303: iload 4
      //   305: ifeq +23 -> 328
      //   308: ldc_w 321
      //   311: astore_1
      //   312: goto -213 -> 99
      //   315: iconst_0
      //   316: istore 4
      //   318: goto -28 -> 290
      //   321: aload_1
      //   322: invokestatic 231	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   325: ifne -17 -> 308
      //   328: aload_1
      //   329: invokestatic 324	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   332: ifeq +6 -> 338
      //   335: goto -236 -> 99
      //   338: ldc_w 326
      //   341: astore_1
      //   342: goto -243 -> 99
      //   345: getstatic 119	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   348: astore_1
      //   349: getstatic 329	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   352: astore_3
      //   353: aload 6
      //   355: checkcast 208	java/lang/CharSequence
      //   358: astore 7
      //   360: aload_1
      //   361: aload_3
      //   362: aload 7
      //   364: iconst_0
      //   365: invokestatic 333	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   368: invokestatic 337	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   371: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   374: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   377: if_acmpeq +33 -> 410
      //   380: aload 6
      //   382: checkcast 208	java/lang/CharSequence
      //   385: astore_1
      //   386: aload 6
      //   388: checkcast 208	java/lang/CharSequence
      //   391: astore_2
      //   392: aload_1
      //   393: iconst_1
      //   394: aload_2
      //   395: invokestatic 212	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   398: invokestatic 341	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   401: astore 6
      //   403: ldc_w 343
      //   406: astore_1
      //   407: goto -273 -> 134
      //   410: aload_0
      //   411: getfield 345	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
      //   414: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   417: if_acmpeq +10 -> 427
      //   420: ldc_w 347
      //   423: astore_1
      //   424: goto -290 -> 134
      //   427: aload_0
      //   428: getfield 349	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
      //   431: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   434: if_acmpeq +10 -> 444
      //   437: ldc_w 351
      //   440: astore_1
      //   441: goto -307 -> 134
      //   444: aload_0
      //   445: getfield 353	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   448: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   451: if_acmpeq +56 -> 507
      //   454: getstatic 119	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   457: aload_2
      //   458: getstatic 356	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
      //   461: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   464: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   467: if_acmpeq +10 -> 477
      //   470: ldc_w 321
      //   473: astore_1
      //   474: goto -340 -> 134
      //   477: getstatic 119	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   480: aload_2
      //   481: getstatic 359	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
      //   484: invokevirtual 136	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   487: getstatic 92	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   490: if_acmpeq +10 -> 500
      //   493: ldc_w 361
      //   496: astore_1
      //   497: goto -23 -> 474
      //   500: ldc_w 288
      //   503: astore_1
      //   504: goto -30 -> 474
      //   507: ldc_w 288
      //   510: astore_1
      //   511: goto -377 -> 134
      //   514: ldc_w 288
      //   517: astore_2
      //   518: goto -305 -> 213
      //   521: astore_1
      //   522: new 195	gnu/mapping/WrongType
      //   525: dup
      //   526: aload_1
      //   527: ldc_w 363
      //   530: iconst_1
      //   531: aload 6
      //   533: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   536: athrow
      //   537: astore_1
      //   538: new 195	gnu/mapping/WrongType
      //   541: dup
      //   542: aload_1
      //   543: ldc_w 365
      //   546: iconst_1
      //   547: aload 6
      //   549: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   552: athrow
      //   553: astore_2
      //   554: new 195	gnu/mapping/WrongType
      //   557: dup
      //   558: aload_2
      //   559: ldc_w 367
      //   562: iconst_1
      //   563: aload_1
      //   564: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   567: athrow
      //   568: astore_2
      //   569: new 195	gnu/mapping/WrongType
      //   572: dup
      //   573: aload_2
      //   574: ldc_w 369
      //   577: iconst_1
      //   578: aload_1
      //   579: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   582: athrow
      //   583: astore_1
      //   584: new 195	gnu/mapping/WrongType
      //   587: dup
      //   588: aload_1
      //   589: ldc_w 369
      //   592: iconst_2
      //   593: aload_2
      //   594: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   597: athrow
      //   598: astore_2
      //   599: new 195	gnu/mapping/WrongType
      //   602: dup
      //   603: aload_2
      //   604: ldc_w 371
      //   607: bipush -2
      //   609: aload_1
      //   610: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   613: athrow
      //   614: astore_1
      //   615: new 195	gnu/mapping/WrongType
      //   618: dup
      //   619: aload_1
      //   620: ldc_w 373
      //   623: iconst_1
      //   624: aload 6
      //   626: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   629: athrow
      //   630: astore_1
      //   631: new 195	gnu/mapping/WrongType
      //   634: dup
      //   635: aload_1
      //   636: ldc_w 374
      //   639: iconst_1
      //   640: aload 6
      //   642: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   645: athrow
      //   646: astore_1
      //   647: new 195	gnu/mapping/WrongType
      //   650: dup
      //   651: aload_1
      //   652: ldc_w 266
      //   655: iconst_1
      //   656: aload 6
      //   658: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   661: athrow
      //   662: astore_1
      //   663: new 195	gnu/mapping/WrongType
      //   666: dup
      //   667: aload_1
      //   668: ldc_w 266
      //   671: iconst_1
      //   672: aload 6
      //   674: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   677: athrow
      //   678: astore_1
      //   679: new 195	gnu/mapping/WrongType
      //   682: dup
      //   683: aload_1
      //   684: ldc_w 266
      //   687: iconst_1
      //   688: aload 6
      //   690: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   693: athrow
      //   694: astore_1
      //   695: new 195	gnu/mapping/WrongType
      //   698: dup
      //   699: aload_1
      //   700: ldc_w 268
      //   703: iconst_1
      //   704: aload_2
      //   705: invokespecial 200	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   708: athrow
      //   709: goto -629 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	712	0	this	frame10
      //   0	712	1	paramObject1	Object
      //   0	712	2	paramObject2	Object
      //   0	712	3	paramObject3	Object
      //   202	115	4	i	int
      //   46	190	5	bool	boolean
      //   4	685	6	localObject1	Object
      //   11	352	7	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   6	13	521	java/lang/ClassCastException
      //   34	41	537	java/lang/ClassCastException
      //   87	93	553	java/lang/ClassCastException
      //   250	256	568	java/lang/ClassCastException
      //   256	265	583	java/lang/ClassCastException
      //   276	281	598	java/lang/ClassCastException
      //   353	360	614	java/lang/ClassCastException
      //   380	386	630	java/lang/ClassCastException
      //   386	392	646	java/lang/ClassCastException
      //   138	144	662	java/lang/ClassCastException
      //   174	181	678	java/lang/ClassCastException
      //   195	204	694	java/lang/ClassCastException
    }
    
    Object lambda25(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Pl;
      Object localObject = this.pr;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.pr = localAddOp.apply2(localObject, Integer.valueOf(strings.stringLength(localCharSequence)));
        return Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
    }
    
    boolean lambda26(Object paramObject)
    {
      Object localObject1 = Special.undefined;
      localObject1 = AddOp.$Mn;
      Object localObject2 = this.pr;
      for (;;)
      {
        try
        {
          localObject3 = (CharSequence)paramObject;
          localObject1 = ((Procedure)localObject1).apply2(localObject2, Integer.valueOf(strings.stringLength((CharSequence)localObject3)));
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject3;
          CharSequence localCharSequence;
          int i;
          throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
        }
        try
        {
          localObject2 = LangObjType.coerceRealNum(localObject1);
          if (numbers.isNegative((RealNum)localObject2))
          {
            localObject2 = Scheme.applyToArgs;
            localObject3 = this.staticLink.out;
          }
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "negative?", 1, localClassCastException1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject;
          paramObject = this.pr;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "substring", 1, paramObject);
        }
        try
        {
          i = ((Number)paramObject).intValue();
          ((Procedure)localObject2).apply2(localObject3, strings.substring(localCharSequence, 0, i));
          paramObject = printf.Lit1;
          this.pr = paramObject;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "substring", 3, paramObject);
        }
        try
        {
          paramObject = LangObjType.coerceRealNum(localObject1);
          return numbers.isPositive((RealNum)paramObject);
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "positive?", 1, localClassCastException3);
        }
        Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
        paramObject = localObject1;
      }
    }
    
    Boolean lambda27(Object paramObject)
    {
      localObject1 = AddOp.$Mn;
      localObject2 = this.pr;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.pr = ((Procedure)localObject1).apply2(localObject2, Integer.valueOf(strings.stringLength(localCharSequence)));
        if (this.os != Boolean.FALSE) {
          break label61;
        }
        Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        try
        {
          for (;;)
          {
            label61:
            localObject2 = LangObjType.coerceRealNum(localObject1);
            if (!numbers.isNegative((RealNum)localObject2)) {
              break;
            }
            Scheme.applyToArgs.apply2(this.staticLink.out, this.os);
            this.os = Boolean.FALSE;
            Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
          }
          this.os = strings.stringAppend(new Object[] { this.os, paramObject });
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "negative?", 1, localClassCastException);
        }
        localClassCastException = localClassCastException;
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
      return Boolean.TRUE;
      localObject1 = this.pr;
    }
    
    boolean lambda28(Object paramObject)
    {
      Object localObject1 = Special.undefined;
      localObject1 = AddOp.$Mn;
      Object localObject2 = this.pr;
      for (;;)
      {
        try
        {
          localCharSequence = (CharSequence)paramObject;
          localObject1 = ((Procedure)localObject1).apply2(localObject2, Integer.valueOf(strings.stringLength(localCharSequence)));
        }
        catch (ClassCastException localClassCastException1)
        {
          CharSequence localCharSequence;
          int i;
          throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
        }
        try
        {
          localObject2 = LangObjType.coerceRealNum(localObject1);
          if (numbers.isNegative((RealNum)localObject2)) {
            localObject2 = this.os;
          }
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "negative?", 1, localClassCastException1);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject;
          paramObject = this.pr;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "substring", 1, paramObject);
        }
        try
        {
          i = ((Number)paramObject).intValue();
          this.os = strings.stringAppend(new Object[] { localObject2, strings.substring(localCharSequence, 0, i) });
          this.pr = localObject1;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "substring", 3, paramObject);
        }
        try
        {
          paramObject = LangObjType.coerceRealNum(localObject1);
          return numbers.isPositive((RealNum)paramObject);
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "positive?", 1, localClassCastException3);
        }
        this.os = strings.stringAppend(new Object[] { this.os, paramObject });
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 19: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 18: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 17: 
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
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    Object fc;
    Procedure format$Mnreal = new ModuleMethod(this, 13, printf.Lit64, 61444);
    final ModuleMethod lambda$Fn17;
    printf.frame10 staticLink;
    
    public frame11()
    {
      this$1 = new ModuleMethod(this, 14, null, 61443);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:401");
      this.lambda$Fn17 = this$1;
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 13: 
        paramModuleMethod = paramArrayOfObject[0];
        localObject1 = paramArrayOfObject[1];
        localObject2 = paramArrayOfObject[2];
        localObject3 = paramArrayOfObject[3];
        i = paramArrayOfObject.length - 4;
        Object[] arrayOfObject = new Object[i];
        for (;;)
        {
          i -= 1;
          if (i < 0) {
            return lambda30formatReal$V(paramModuleMethod, localObject1, localObject2, localObject3, arrayOfObject);
          }
          arrayOfObject[i] = paramArrayOfObject[(i + 4)];
        }
      }
      paramModuleMethod = paramArrayOfObject[0];
      Object localObject1 = paramArrayOfObject[1];
      Object localObject2 = paramArrayOfObject[2];
      int i = paramArrayOfObject.length - 3;
      Object localObject3 = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return lambda31$V(paramModuleMethod, localObject1, localObject2, (Object[])localObject3);
        }
        localObject3[i] = paramArrayOfObject[(i + 3)];
      }
    }
    
    public Object lambda29f(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      for (;;)
      {
        try
        {
          localObject1 = (CharSequence)paramObject1;
          localObject2 = AddOp.$Pl.apply2(paramObject2, this.staticLink.precision);
          if (paramObject3 != Boolean.FALSE)
          {
            paramObject1 = paramObject2;
            localObject1 = printf.stdio$ClRoundString((CharSequence)localObject1, localObject2, paramObject1);
            if (Scheme.numGEq.apply2(paramObject2, printf.Lit1) == Boolean.FALSE) {
              continue;
            }
          }
        }
        catch (ClassCastException paramObject2)
        {
          Object localObject2;
          int i;
          int j;
          boolean bool;
          throw new WrongType((ClassCastException)paramObject2, "stdio:round-string", 0, paramObject1);
        }
        try
        {
          paramObject1 = (Number)paramObject2;
          if (numbers.isZero((Number)paramObject1))
          {
            paramObject1 = printf.Lit1;
            paramObject3 = numbers.max(new Object[] { printf.Lit7, AddOp.$Pl.apply2(printf.Lit7, paramObject2) });
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "zero?", 1, paramObject2);
        }
        try
        {
          paramObject2 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
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
          j = ((Number)paramObject3).intValue();
          paramObject2 = strings.substring((CharSequence)paramObject2, i, j);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 3, paramObject3);
        }
        try
        {
          paramObject1 = (CharSequence)localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, localObject1);
        }
        try
        {
          i = ((Number)paramObject3).intValue();
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, paramObject3);
        }
        try
        {
          paramObject3 = (CharSequence)localObject1;
          paramObject1 = strings.substring((CharSequence)paramObject1, i, strings.stringLength((CharSequence)paramObject3));
          bool = strings.isString$Eq(paramObject1, "");
          if (bool)
          {
            if (this.staticLink.alternate$Mnform != Boolean.FALSE) {
              continue;
            }
            paramObject1 = LList.Empty;
            paramObject3 = lists.cons(paramObject2, paramObject1);
            return paramObject3;
            paramObject1 = paramObject3;
            continue;
            paramObject1 = printf.Lit9;
          }
          try
          {
            paramObject3 = (CharSequence)localObject1;
            if (characters.isChar$Eq((Char)paramObject1, Char.make(strings.stringRef((CharSequence)paramObject3, 0))))
            {
              paramObject1 = printf.Lit7;
              continue;
            }
            paramObject1 = printf.Lit1;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, localObject1);
          }
          if (bool) {
            continue;
          }
          paramObject1 = LList.list2(".", paramObject1);
          continue;
          paramObject1 = this.staticLink.precision;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-length", 1, localObject1);
        }
        try
        {
          localObject2 = (Number)paramObject1;
          if (numbers.isZero((Number)localObject2))
          {
            if (this.staticLink.alternate$Mnform != Boolean.FALSE)
            {
              paramObject1 = "0.";
              return LList.list1(paramObject1);
            }
            paramObject1 = "0";
            continue;
          }
          if (paramObject3 != Boolean.FALSE)
          {
            bool = strings.isString$Eq(localObject1, "");
            if (bool)
            {
              paramObject1 = LList.list1("0");
              paramObject3 = paramObject1;
              if (paramObject1 != Boolean.FALSE) {
                continue;
              }
              paramObject1 = numbers.min(new Object[] { this.staticLink.precision, AddOp.$Mn.apply2(printf.Lit17, paramObject2) });
            }
          }
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "zero?", 1, paramObject1);
        }
        try
        {
          i = ((Number)paramObject1).intValue();
          return LList.list3("0.", strings.makeString(i, printf.Lit9), localObject1);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "make-string", 1, paramObject1);
        }
        if (bool)
        {
          paramObject1 = Boolean.TRUE;
        }
        else
        {
          paramObject1 = Boolean.FALSE;
          continue;
          paramObject1 = paramObject3;
        }
      }
    }
    
    public Object lambda30formatReal$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
    {
      paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
      if (lists.isNull(paramArrayOfObject))
      {
        paramArrayOfObject = printf.Lit5;
        for (;;)
        {
          try
          {
            localObject = (Char)paramObject2;
            if (characters.isChar$Eq(paramArrayOfObject, (Char)localObject))
            {
              paramObject2 = "-";
              paramObject1 = Scheme.isEqv.apply2(this.fc, printf.Lit13);
              if (paramObject1 == Boolean.FALSE) {
                continue;
              }
              if (paramObject1 == Boolean.FALSE) {
                continue;
              }
              paramObject1 = Boolean.FALSE;
            }
          }
          catch (ClassCastException paramObject1)
          {
            int i;
            CharSequence localCharSequence;
            boolean bool;
            throw new WrongType((ClassCastException)paramObject1, "char=?", 2, paramObject2);
          }
          try
          {
            paramArrayOfObject = (CharSequence)paramObject3;
            localObject = AddOp.$Pl.apply2(printf.Lit7, this.staticLink.precision);
            paramObject3 = paramObject1;
            if (paramObject1 != Boolean.FALSE) {
              paramObject3 = printf.Lit1;
            }
            paramObject3 = printf.stdio$ClRoundString(paramArrayOfObject, localObject, paramObject3);
            paramObject1 = printf.Lit9;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "stdio:round-string", 0, paramObject3);
          }
          try
          {
            paramArrayOfObject = (CharSequence)paramObject3;
            if (characters.isChar$Eq((Char)paramObject1, Char.make(strings.stringRef(paramArrayOfObject, 0)))) {
              paramObject1 = printf.Lit7;
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject3);
          }
          try
          {
            paramArrayOfObject = (CharSequence)paramObject3;
            i = ((Number)paramObject1).intValue();
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject3);
          }
          try
          {
            localObject = (CharSequence)paramObject3;
            localCharSequence = strings.substring(paramArrayOfObject, i + 1, strings.stringLength((CharSequence)localObject));
            if (!numbers.isZero((Number)paramObject1)) {}
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject3);
          }
          try
          {
            paramArrayOfObject = (CharSequence)paramObject3;
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject3);
          }
          try
          {
            i = ((Number)paramObject1).intValue();
            localObject = LList.list1(strings.substring(paramArrayOfObject, i, ((Number)paramObject1).intValue() + 1));
            bool = strings.isString$Eq(localCharSequence, "");
            if (bool)
            {
              if (this.staticLink.alternate$Mnform != Boolean.FALSE) {
                continue;
              }
              paramObject1 = "";
              paramObject3 = this.fc;
            }
          }
          catch (ClassCastException paramObject2)
          {
            throw new WrongType((ClassCastException)paramObject2, "substring", 2, paramObject1);
          }
          try
          {
            paramArrayOfObject = (Char)paramObject3;
            if (unicode.isCharUpperCase(paramArrayOfObject)) {
              paramObject3 = "E";
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "char-upper-case?", 1, paramObject3);
          }
          try
          {
            paramArrayOfObject = LangObjType.coerceRealNum(paramObject4);
            if (numbers.isNegative(paramArrayOfObject))
            {
              paramArrayOfObject = "-";
              paramObject3 = LList.chain4((Pair)localObject, paramObject1, localCharSequence, paramObject3, paramArrayOfObject);
              if (Scheme.numLss.apply3(printf.Lit60, paramObject4, printf.Lit45) == Boolean.FALSE) {
                continue;
              }
              paramObject1 = "0";
              paramObject1 = LList.chain1((Pair)paramObject3, paramObject1);
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "negative?", 1, paramObject4);
          }
          try
          {
            paramObject3 = (Number)paramObject4;
            LList.chain1((Pair)paramObject1, numbers.number$To$String(numbers.abs((Number)paramObject3)));
            paramObject1 = localObject;
            return lists.cons(paramObject2, paramObject1);
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "abs", 1, paramObject4);
          }
          if (paramObject1 != Boolean.FALSE)
          {
            paramObject2 = "+";
          }
          else if (this.staticLink.blank != Boolean.FALSE)
          {
            paramObject2 = " ";
          }
          else
          {
            paramObject2 = "";
            continue;
            if (Scheme.isEqv.apply2(this.fc, printf.Lit54) == Boolean.FALSE)
            {
              paramObject1 = Scheme.isEqv.apply2(this.fc, printf.Lit25);
              if (paramObject1 != Boolean.FALSE)
              {
                if (paramObject1 != Boolean.FALSE)
                {
                  paramObject1 = lambda29f(paramObject3, paramObject4, Boolean.FALSE);
                  continue;
                  paramObject1 = printf.Lit1;
                  continue;
                  paramObject4 = AddOp.$Mn.apply2(paramObject4, printf.Lit7);
                  continue;
                  if (bool) {
                    continue;
                  }
                  paramObject1 = ".";
                  continue;
                  paramObject3 = "e";
                  continue;
                  paramArrayOfObject = "+";
                  continue;
                  paramObject1 = "";
                  continue;
                }
              }
              else {
                if (Scheme.isEqv.apply2(this.fc, printf.Lit26) != Boolean.FALSE) {
                  continue;
                }
              }
              paramObject1 = Scheme.isEqv.apply2(this.fc, printf.Lit55);
              if (paramObject1 != Boolean.FALSE)
              {
                if (paramObject1 == Boolean.FALSE) {
                  continue;
                }
                paramObject1 = this.staticLink.alternate$Mnform;
              }
            }
          }
          try
          {
            paramArrayOfObject = Boolean.FALSE;
            if (paramObject1 != paramArrayOfObject)
            {
              i = 1;
              i = i + 1 & 0x1;
              this.staticLink.alternate$Mnform = Boolean.FALSE;
              if (Scheme.numLEq.apply3(AddOp.$Mn.apply2(printf.Lit7, this.staticLink.precision), paramObject4, this.staticLink.precision) == Boolean.FALSE) {
                continue;
              }
              this.staticLink.precision = AddOp.$Mn.apply2(this.staticLink.precision, paramObject4);
              if (i == 0) {
                continue;
              }
              paramObject1 = Boolean.TRUE;
              paramObject1 = lambda29f(paramObject3, paramObject4, paramObject1);
              continue;
              if (Scheme.isEqv.apply2(this.fc, printf.Lit56) != Boolean.FALSE) {
                continue;
              }
              if (Scheme.isEqv.apply2(this.fc, printf.Lit57) == Boolean.FALSE) {
                continue;
              }
              paramArrayOfObject = "";
            }
          }
          catch (ClassCastException paramObject2)
          {
            throw new WrongType((ClassCastException)paramObject2, "strip-0s", -2, paramObject1);
          }
          try
          {
            paramObject1 = LangObjType.coerceRealNum(paramObject4);
            if (numbers.isNegative((RealNum)paramObject1))
            {
              paramObject1 = DivideOp.quotient.apply2(AddOp.$Mn.apply2(paramObject4, printf.Lit61), printf.Lit61);
              localObject = Scheme.numLss.apply3(printf.Lit17, AddOp.$Pl.apply2(paramObject1, printf.Lit48), Integer.valueOf(vectors.vectorLength(printf.Lit62)));
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "negative?", 1, paramObject4);
          }
          try
          {
            bool = ((Boolean)localObject).booleanValue();
            if (bool)
            {
              if (paramObject1 == Boolean.FALSE) {
                continue;
              }
              paramObject4 = AddOp.$Mn.apply2(paramObject4, MultiplyOp.$St.apply2(printf.Lit61, paramObject1));
              this.staticLink.precision = numbers.max(new Object[] { printf.Lit1, AddOp.$Mn.apply2(this.staticLink.precision, paramObject4) });
              paramObject3 = lambda29f(paramObject3, paramObject4, Boolean.FALSE);
              paramObject4 = printf.Lit62;
              paramObject1 = AddOp.$Pl.apply2(paramObject1, printf.Lit48);
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
          }
          try
          {
            i = ((Number)paramObject1).intValue();
            paramObject1 = append.append$V(new Object[] { paramObject3, LList.list2(paramArrayOfObject, vectors.vectorRef((FVector)paramObject4, i)) });
          }
          catch (ClassCastException paramObject2)
          {
            throw new WrongType((ClassCastException)paramObject2, "vector-ref", 2, paramObject1);
          }
          i = 0;
          continue;
          paramObject1 = Boolean.FALSE;
          continue;
          this.staticLink.precision = AddOp.$Mn.apply2(this.staticLink.precision, printf.Lit7);
          if (i != 0)
          {
            paramObject1 = Boolean.TRUE;
          }
          else
          {
            paramObject1 = Boolean.FALSE;
            continue;
            paramObject1 = DivideOp.quotient.apply2(AddOp.$Mn.apply2(paramObject4, printf.Lit7), printf.Lit61);
            continue;
            if (bool)
            {
              paramObject1 = Boolean.TRUE;
            }
            else
            {
              paramObject1 = Boolean.FALSE;
              continue;
              continue;
              if (Scheme.isEqv.apply2(this.fc, printf.Lit58) != Boolean.FALSE) {
                paramArrayOfObject = " ";
              } else {
                paramObject1 = Values.empty;
              }
            }
          }
        }
      }
      return append.append$V(new Object[] { lambda30formatReal$V(paramObject1, paramObject2, paramObject3, paramObject4, new Object[0]), Scheme.apply.apply3(this.format$Mnreal, Boolean.TRUE, paramArrayOfObject), printf.Lit63 });
    }
    
    Object lambda31$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
    {
      paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
      return Scheme.apply.apply2(this.staticLink.pad, Scheme.apply.applyN(new Object[] { this.format$Mnreal, this.staticLink.signed, paramObject1, paramObject2, paramObject3, paramArrayOfObject }));
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 14: 
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
  }
  
  public class frame12
    extends ModuleBody
  {
    Object cnt;
    final ModuleMethod lambda$Fn18;
    Object port;
    
    public frame12()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:546");
      this.lambda$Fn18 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20) {
        return lambda32(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Boolean lambda32(Object paramObject)
    {
      AddOp localAddOp;
      if (strings.isString(paramObject)) {
        localAddOp = AddOp.$Pl;
      }
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.cnt = localAddOp.apply2(Integer.valueOf(strings.stringLength(localCharSequence)), this.cnt);
        ports.display(paramObject, this.port);
        return Boolean.TRUE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
      this.cnt = AddOp.$Pl.apply2(printf.Lit7, this.cnt);
      ports.display(paramObject, this.port);
      return Boolean.TRUE;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame13
    extends ModuleBody
  {
    Object cnt;
    Object end;
    final ModuleMethod lambda$Fn19;
    Object s;
    Object str;
    
    public frame13()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:564");
      this.lambda$Fn19 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda33(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda33(Object paramObject)
    {
      Object localObject2;
      if (strings.isString(paramObject)) {
        if (this.str == Boolean.FALSE)
        {
          localObject1 = Scheme.numGEq;
          localObject2 = AddOp.$Mn.apply2(this.end, this.cnt);
        }
      }
      for (;;)
      {
        Object localObject4;
        try
        {
          localObject3 = (CharSequence)paramObject;
          if (((Procedure)localObject1).apply2(localObject2, Integer.valueOf(strings.stringLength((CharSequence)localObject3))) == Boolean.FALSE) {}
        }
        catch (ClassCastException localClassCastException1)
        {
          Object localObject3;
          int i;
          int j;
          throw new WrongType(localClassCastException1, "string-length", 1, paramObject);
        }
        try
        {
          localObject1 = (CharSequence)paramObject;
          localObject2 = numbers.min(new Object[] { Integer.valueOf(strings.stringLength((CharSequence)localObject1)), AddOp.$Mn.apply2(this.end, this.cnt) });
          localObject1 = printf.Lit1;
          if (Scheme.numGEq.apply2(localObject1, localObject2) == Boolean.FALSE) {
            localObject4 = this.s;
          }
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new WrongType(localClassCastException2, "string-length", 1, paramObject);
        }
        try
        {
          localObject3 = (CharSeq)localObject4;
          localObject4 = this.cnt;
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-set!", 1, localObject4);
        }
        try
        {
          i = ((Number)localObject4).intValue();
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-set!", 2, localObject4);
        }
        try
        {
          localObject4 = (CharSequence)paramObject;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new WrongType(localClassCastException3, "string-ref", 1, paramObject);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          strings.stringSet$Ex((CharSeq)localObject3, i, strings.stringRef((CharSequence)localObject4, j));
          this.cnt = AddOp.$Pl.apply2(this.cnt, printf.Lit7);
          localObject1 = AddOp.$Pl.apply2(localObject1, printf.Lit7);
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-ref", 2, localClassCastException3);
        }
      }
      Object localObject1 = this.s;
      for (;;)
      {
        try
        {
          localObject2 = (CharSequence)localObject1;
          localObject1 = this.cnt;
        }
        catch (ClassCastException paramObject)
        {
          char c;
          throw new WrongType((ClassCastException)paramObject, "substring", 1, localClassCastException3);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          this.s = strings.stringAppend(new Object[] { strings.substring((CharSequence)localObject2, 0, i), paramObject });
          paramObject = this.s;
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "substring", 3, localClassCastException3);
        }
        try
        {
          localObject1 = (CharSequence)paramObject;
          this.cnt = Integer.valueOf(strings.stringLength((CharSequence)localObject1));
          this.end = this.cnt;
          if (this.str != Boolean.FALSE) {
            if (Scheme.numGEq.apply2(this.cnt, this.end) != Boolean.FALSE)
            {
              i = 1;
              return i + 1 & 0x1;
              if (this.str != Boolean.FALSE)
              {
                localObject1 = Scheme.numGEq.apply2(this.cnt, this.end);
                if (localObject1 != Boolean.FALSE) {
                  continue;
                }
                localObject1 = this.str;
              }
            }
          }
        }
        catch (ClassCastException localClassCastException4)
        {
          throw new WrongType(localClassCastException4, "string-length", 1, paramObject);
        }
        try
        {
          localObject2 = Boolean.FALSE;
          if (localObject1 != localObject2)
          {
            i = 1;
            i = i + 1 & 0x1;
            if (i == 0) {
              continue;
            }
            if (Scheme.numGEq.apply2(this.cnt, this.end) != Boolean.FALSE)
            {
              this.s = strings.stringAppend(new Object[] { this.s, strings.makeString(100) });
              localObject1 = this.s;
            }
          }
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "x", -2, localClassCastException4);
        }
        try
        {
          localObject2 = (CharSequence)localObject1;
          this.end = Integer.valueOf(strings.stringLength((CharSequence)localObject2));
          localObject1 = this.s;
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-length", 1, localClassCastException4);
        }
        try
        {
          localObject2 = (CharSeq)localObject1;
          localObject1 = this.cnt;
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-set!", 1, localClassCastException4);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          if (!characters.isChar(paramObject)) {}
        }
        catch (ClassCastException paramObject)
        {
          throw new WrongType((ClassCastException)paramObject, "string-set!", 2, localClassCastException4);
        }
        try
        {
          c = ((Char)paramObject).charValue();
          strings.stringSet$Ex((CharSeq)localObject2, i, c);
          this.cnt = AddOp.$Pl.apply2(this.cnt, printf.Lit7);
        }
        catch (ClassCastException localClassCastException5)
        {
          throw new WrongType(localClassCastException5, "string-set!", 3, paramObject);
        }
        localObject1 = this.str;
        continue;
        i = 0;
        continue;
        if (i != 0)
        {
          continue;
          c = '?';
          continue;
          i = 0;
          continue;
          if (this.str != Boolean.FALSE) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    Object cont;
    final ModuleMethod lambda$Fn5;
    final ModuleMethod lambda$Fn6;
    printf.frame staticLink;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:81");
      this.lambda$Fn6 = this$1;
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:78");
      this.lambda$Fn5 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11) {
        return lambda9(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda10(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2)
    {
      printf.frame3 localframe3 = new printf.frame3();
      localframe3.staticLink = this;
      localframe3.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe3.lambda$Fn7);
    }
    
    Object lambda9(Object paramObject)
    {
      return this.staticLink.lambda2sign(paramObject, this.lambda$Fn6);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
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
      if (paramModuleMethod.selector == 10)
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
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn7;
    Object sgn;
    printf.frame2 staticLink;
    
    public frame3()
    {
      this$1 = new ModuleMethod(this, 9, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:84");
      this.lambda$Fn7 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda11(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda11(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 15	gnu/kawa/slib/printf$frame4
      //   3: dup
      //   4: invokespecial 68	gnu/kawa/slib/printf$frame4:<init>	()V
      //   7: astore 5
      //   9: aload 5
      //   11: aload_0
      //   12: putfield 71	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   15: aload 5
      //   17: aload_2
      //   18: putfield 74	gnu/kawa/slib/printf$frame4:idigs	Ljava/lang/Object;
      //   21: aload 5
      //   23: getfield 77	gnu/kawa/slib/printf$frame4:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   26: astore_2
      //   27: getstatic 83	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   30: aload_1
      //   31: aload_0
      //   32: getfield 85	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   35: getfield 88	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   38: getfield 91	gnu/kawa/slib/printf$frame:n	I
      //   41: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   44: invokevirtual 101	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   47: astore 5
      //   49: aload 5
      //   51: checkcast 103	java/lang/Boolean
      //   54: invokevirtual 107	java/lang/Boolean:booleanValue	()Z
      //   57: istore 4
      //   59: iload 4
      //   61: ifeq +70 -> 131
      //   64: getstatic 111	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
      //   67: astore 6
      //   69: aload_0
      //   70: getfield 85	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   73: getfield 88	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   76: getfield 114	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   79: astore 5
      //   81: aload 5
      //   83: checkcast 116	java/lang/CharSequence
      //   86: astore 7
      //   88: aload_1
      //   89: checkcast 118	java/lang/Number
      //   92: invokevirtual 122	java/lang/Number:intValue	()I
      //   95: istore_3
      //   96: aload 6
      //   98: aload 7
      //   100: iload_3
      //   101: invokestatic 128	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   104: invokestatic 134	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   107: invokestatic 140	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   110: ifeq +26 -> 136
      //   113: getstatic 144	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   116: aload_2
      //   117: getstatic 150	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   120: aload_1
      //   121: getstatic 154	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   124: invokevirtual 101	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   127: invokevirtual 101	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   130: areturn
      //   131: iload 4
      //   133: ifne -20 -> 113
      //   136: getstatic 144	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   139: aload_2
      //   140: aload_1
      //   141: invokevirtual 101	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   144: areturn
      //   145: astore_1
      //   146: new 156	gnu/mapping/WrongType
      //   149: dup
      //   150: aload_1
      //   151: ldc -98
      //   153: bipush -2
      //   155: aload 5
      //   157: invokespecial 161	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   160: athrow
      //   161: astore_1
      //   162: new 156	gnu/mapping/WrongType
      //   165: dup
      //   166: aload_1
      //   167: ldc -93
      //   169: iconst_1
      //   170: aload 5
      //   172: invokespecial 161	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   175: athrow
      //   176: astore_2
      //   177: new 156	gnu/mapping/WrongType
      //   180: dup
      //   181: aload_2
      //   182: ldc -93
      //   184: iconst_2
      //   185: aload_1
      //   186: invokespecial 161	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   189: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	frame3
      //   0	190	1	paramObject1	Object
      //   0	190	2	paramObject2	Object
      //   95	6	3	i	int
      //   57	75	4	bool	boolean
      //   7	164	5	localObject	Object
      //   67	30	6	localChar	Char
      //   86	13	7	localCharSequence	CharSequence
      // Exception table:
      //   from	to	target	type
      //   49	59	145	java/lang/ClassCastException
      //   81	88	161	java/lang/ClassCastException
      //   88	96	176	java/lang/ClassCastException
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
  
  public class frame4
    extends ModuleBody
  {
    Object idigs;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
    printf.frame3 staticLink;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 7, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:90");
      this.lambda$Fn9 = this$1;
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:87");
      this.lambda$Fn8 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda12(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda13(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda12(Object paramObject)
    {
      return this.staticLink.staticLink.staticLink.lambda3digits(paramObject, this.lambda$Fn9);
    }
    
    /* Error */
    Object lambda13(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 18	gnu/kawa/slib/printf$frame5
      //   3: dup
      //   4: invokespecial 92	gnu/kawa/slib/printf$frame5:<init>	()V
      //   7: astore 4
      //   9: aload 4
      //   11: aload_0
      //   12: putfield 95	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   15: aload 4
      //   17: aload_2
      //   18: putfield 98	gnu/kawa/slib/printf$frame5:fdigs	Ljava/lang/Object;
      //   21: aload 4
      //   23: getfield 101	gnu/kawa/slib/printf$frame5:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   26: astore 4
      //   28: aload_0
      //   29: getfield 80	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   32: getfield 83	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   35: getfield 86	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   38: astore 5
      //   40: new 21	gnu/kawa/slib/printf$frame6
      //   43: dup
      //   44: invokespecial 102	gnu/kawa/slib/printf$frame6:<init>	()V
      //   47: astore_2
      //   48: aload_2
      //   49: aload 5
      //   51: putfield 103	gnu/kawa/slib/printf$frame6:staticLink	Lgnu/kawa/slib/printf$frame;
      //   54: aload_2
      //   55: aload 4
      //   57: putfield 106	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   60: getstatic 112	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   63: aload_1
      //   64: aload_0
      //   65: getfield 80	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   68: getfield 83	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   71: getfield 86	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   74: getfield 115	gnu/kawa/slib/printf$frame:n	I
      //   77: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   80: invokevirtual 125	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   83: getstatic 131	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   86: if_acmpeq +18 -> 104
      //   89: getstatic 135	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   92: aload_2
      //   93: getfield 106	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   96: aload_1
      //   97: getstatic 139	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   100: invokevirtual 143	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   103: areturn
      //   104: aload_0
      //   105: getfield 80	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   108: getfield 83	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   111: getfield 86	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   114: getfield 146	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   117: astore 4
      //   119: aload 4
      //   121: checkcast 148	java/lang/CharSequence
      //   124: astore 5
      //   126: aload_1
      //   127: checkcast 150	java/lang/Number
      //   130: invokevirtual 154	java/lang/Number:intValue	()I
      //   133: istore_3
      //   134: aload 5
      //   136: iload_3
      //   137: invokestatic 160	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   140: invokestatic 166	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   143: getstatic 170	gnu/kawa/slib/printf:Lit10	Lgnu/lists/PairWithPosition;
      //   146: invokestatic 175	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   149: getstatic 131	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   152: if_acmpeq +31 -> 183
      //   155: aload_0
      //   156: getfield 80	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   159: getfield 83	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   162: getfield 86	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   165: getstatic 181	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   168: aload_1
      //   169: getstatic 184	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   172: invokevirtual 125	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   175: aload_2
      //   176: getfield 187	gnu/kawa/slib/printf$frame6:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   179: invokevirtual 190	gnu/kawa/slib/printf$frame:lambda2sign	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   182: areturn
      //   183: getstatic 135	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   186: aload_2
      //   187: getfield 106	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   190: aload_1
      //   191: getstatic 139	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   194: invokevirtual 143	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   197: areturn
      //   198: astore_1
      //   199: new 192	gnu/mapping/WrongType
      //   202: dup
      //   203: aload_1
      //   204: ldc -62
      //   206: iconst_1
      //   207: aload 4
      //   209: invokespecial 197	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   212: athrow
      //   213: astore_2
      //   214: new 192	gnu/mapping/WrongType
      //   217: dup
      //   218: aload_2
      //   219: ldc -62
      //   221: iconst_2
      //   222: aload_1
      //   223: invokespecial 197	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   226: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	227	0	this	frame4
      //   0	227	1	paramObject1	Object
      //   0	227	2	paramObject2	Object
      //   133	4	3	i	int
      //   7	201	4	localObject1	Object
      //   38	97	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   119	126	198	java/lang/ClassCastException
      //   126	134	213	java/lang/ClassCastException
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
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
  
  public class frame5
    extends ModuleBody
  {
    Object fdigs;
    final ModuleMethod lambda$Fn10;
    printf.frame4 staticLink;
    
    public frame5()
    {
      this$1 = new ModuleMethod(this, 6, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:92");
      this.lambda$Fn10 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda14(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda14(Object paramObject1, Object paramObject2)
    {
      localFString = strings.stringAppend(new Object[] { "0", this.staticLink.idigs, this.fdigs });
      i = strings.stringLength(localFString);
      localObject1 = printf.Lit7;
      localObject3 = AddOp.$Pl;
      localObject2 = this.staticLink.idigs;
      try
      {
        localObject4 = (CharSequence)localObject2;
        paramObject2 = ((Procedure)localObject3).apply2(paramObject2, Integer.valueOf(strings.stringLength((CharSequence)localObject4)));
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          for (;;)
          {
            j = ((Number)localObject1).intValue();
            if (!characters.isChar$Eq((Char)localObject2, Char.make(strings.stringRef(localFString, j)))) {
              break;
            }
            localObject1 = AddOp.$Pl.apply2(localObject1, printf.Lit7);
            paramObject2 = AddOp.$Mn.apply2(paramObject2, printf.Lit7);
          }
          localObject2 = Scheme.applyToArgs;
          localObject3 = this.staticLink.staticLink.staticLink.cont;
          localObject4 = this.staticLink.staticLink.sgn;
          localObject1 = AddOp.$Mn.apply2(localObject1, printf.Lit7);
        }
        catch (ClassCastException paramObject1)
        {
          Object localObject4;
          int j;
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          return ((Procedure)localObject2).applyN(new Object[] { localObject3, paramObject1, localObject4, strings.substring(localFString, j, i), paramObject2 });
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject1);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, localObject2);
      }
      if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
        return Scheme.applyToArgs.applyN(new Object[] { this.staticLink.staticLink.staticLink.cont, paramObject1, this.staticLink.staticLink.sgn, "0", printf.Lit7 });
      }
      localObject2 = printf.Lit9;
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
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
    Object cont;
    final ModuleMethod lambda$Fn11;
    printf.frame staticLink;
    
    public frame6()
    {
      this$1 = new ModuleMethod(this, 5, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:67");
      this.lambda$Fn11 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda15(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15(Object paramObject1, Object paramObject2)
    {
      printf.frame7 localframe7 = new printf.frame7();
      localframe7.staticLink = this;
      localframe7.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe7.lambda$Fn12);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
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
    final ModuleMethod lambda$Fn12;
    Object sgn;
    printf.frame6 staticLink;
    
    public frame7()
    {
      this$1 = new ModuleMethod(this, 4, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/printf.scm:69");
      this.lambda$Fn12 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    /* Error */
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 70	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore_3
      //   4: aload_0
      //   5: getfield 72	gnu/kawa/slib/printf$frame7:staticLink	Lgnu/kawa/slib/printf$frame6;
      //   8: getfield 75	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   11: astore 4
      //   13: getstatic 79	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   16: astore 6
      //   18: aload_0
      //   19: getfield 81	gnu/kawa/slib/printf$frame7:sgn	Ljava/lang/Object;
      //   22: astore 5
      //   24: aload 5
      //   26: checkcast 83	gnu/text/Char
      //   29: astore 7
      //   31: aload 6
      //   33: aload 7
      //   35: invokestatic 89	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   38: ifeq +34 -> 72
      //   41: getstatic 95	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   44: astore 5
      //   46: aload_2
      //   47: checkcast 97	java/lang/CharSequence
      //   50: astore 6
      //   52: aload 5
      //   54: aload 6
      //   56: invokestatic 103	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   59: invokevirtual 109	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   62: astore_2
      //   63: aload_3
      //   64: aload 4
      //   66: aload_1
      //   67: aload_2
      //   68: invokevirtual 113	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   71: areturn
      //   72: aload_2
      //   73: checkcast 97	java/lang/CharSequence
      //   76: astore 5
      //   78: aload 5
      //   80: invokestatic 103	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   83: astore_2
      //   84: goto -21 -> 63
      //   87: astore_1
      //   88: new 115	gnu/mapping/WrongType
      //   91: dup
      //   92: aload_1
      //   93: ldc 117
      //   95: iconst_2
      //   96: aload 5
      //   98: invokespecial 120	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   101: athrow
      //   102: astore_1
      //   103: new 115	gnu/mapping/WrongType
      //   106: dup
      //   107: aload_1
      //   108: ldc 122
      //   110: iconst_1
      //   111: aload_2
      //   112: invokespecial 120	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   115: athrow
      //   116: astore_1
      //   117: new 115	gnu/mapping/WrongType
      //   120: dup
      //   121: aload_1
      //   122: ldc 122
      //   124: iconst_1
      //   125: aload_2
      //   126: invokespecial 120	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   129: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	this	frame7
      //   0	130	1	paramObject1	Object
      //   0	130	2	paramObject2	Object
      //   3	61	3	localApplyToArgs	gnu.kawa.functions.ApplyToArgs
      //   11	54	4	localObject1	Object
      //   22	75	5	localObject2	Object
      //   16	39	6	localObject3	Object
      //   29	5	7	localChar	Char
      // Exception table:
      //   from	to	target	type
      //   24	31	87	java/lang/ClassCastException
      //   46	52	102	java/lang/ClassCastException
      //   72	78	116	java/lang/ClassCastException
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
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
    CharSequence str;
    
    public Object lambda17dig(Object paramObject)
    {
      CharSequence localCharSequence = this.str;
      try
      {
        int i = ((Number)paramObject).intValue();
        i = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(i))) {
          return numbers.string$To$Number(strings.$make$string$(new Object[] { Char.make(i) }));
        }
        return printf.Lit1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-ref", 2, paramObject);
      }
    }
  }
  
  public class frame9
    extends ModuleBody
  {
    LList args;
    Object fc;
    int fl;
    Object format$Mnstring;
    Object out;
    Object pos;
    
    /* Error */
    public Object lambda18mustAdvance()
    {
      // Byte code:
      //   0: aload_0
      //   1: getstatic 31	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   4: getstatic 35	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   7: aload_0
      //   8: getfield 37	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   11: invokevirtual 43	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: putfield 37	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   17: getstatic 49	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   20: aload_0
      //   21: getfield 37	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   24: aload_0
      //   25: getfield 51	gnu/kawa/slib/printf$frame9:fl	I
      //   28: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   31: invokevirtual 43	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   37: if_acmpeq +8 -> 45
      //   40: aload_0
      //   41: invokevirtual 66	gnu/kawa/slib/printf$frame9:lambda20incomplete	()Ljava/lang/Object;
      //   44: areturn
      //   45: aload_0
      //   46: getfield 68	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
      //   49: astore_2
      //   50: aload_2
      //   51: checkcast 70	java/lang/CharSequence
      //   54: astore_3
      //   55: aload_0
      //   56: getfield 37	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   59: astore_2
      //   60: aload_2
      //   61: checkcast 72	java/lang/Number
      //   64: invokevirtual 76	java/lang/Number:intValue	()I
      //   67: istore_1
      //   68: aload_0
      //   69: aload_3
      //   70: iload_1
      //   71: invokestatic 82	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   74: invokestatic 88	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   77: putfield 90	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
      //   80: getstatic 96	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   83: areturn
      //   84: astore_3
      //   85: new 98	gnu/mapping/WrongType
      //   88: dup
      //   89: aload_3
      //   90: ldc 100
      //   92: iconst_1
      //   93: aload_2
      //   94: invokespecial 103	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   97: athrow
      //   98: astore_3
      //   99: new 98	gnu/mapping/WrongType
      //   102: dup
      //   103: aload_3
      //   104: ldc 100
      //   106: iconst_2
      //   107: aload_2
      //   108: invokespecial 103	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   111: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	frame9
      //   67	4	1	i	int
      //   49	59	2	localObject	Object
      //   54	16	3	localCharSequence	CharSequence
      //   84	6	3	localClassCastException1	ClassCastException
      //   98	6	3	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   50	55	84	java/lang/ClassCastException
      //   60	68	98	java/lang/ClassCastException
    }
    
    public boolean lambda19isEndOfFormat()
    {
      return ((Boolean)Scheme.numGEq.apply2(this.pos, Integer.valueOf(this.fl))).booleanValue();
    }
    
    public Object lambda20incomplete()
    {
      return misc.error$V(printf.Lit34, new Object[] { "conversion specification incomplete", this.format$Mnstring });
    }
    
    public Object lambda21out$St(Object paramObject)
    {
      Object localObject = paramObject;
      if (strings.isString(paramObject)) {
        return Scheme.applyToArgs.apply2(this.out, paramObject);
      }
      boolean bool;
      do
      {
        paramObject = Scheme.applyToArgs.apply2(this.out, lists.car.apply1(localObject));
        if (paramObject == Boolean.FALSE) {
          break;
        }
        localObject = lists.cdr.apply1(localObject);
        bool = lists.isNull(localObject);
      } while (!bool);
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
      return paramObject;
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\printf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */