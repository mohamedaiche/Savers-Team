package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class pregexp
  extends ModuleBody
{
  public static Char $Stpregexp$Mncomment$Mnchar$St;
  public static Object $Stpregexp$Mnnul$Mnchar$Mnint$St;
  public static Object $Stpregexp$Mnreturn$Mnchar$St;
  public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
  public static Object $Stpregexp$Mntab$Mnchar$St;
  public static IntNum $Stpregexp$Mnversion$St;
  public static final pregexp $instance;
  static final IntNum Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final PairWithPosition Lit106;
  static final SimpleSymbol Lit107;
  static final PairWithPosition Lit108;
  static final SimpleSymbol Lit109;
  static final Char Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final Char Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final PairWithPosition Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final SimpleSymbol Lit12;
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
  static final Char Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SimpleSymbol Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SimpleSymbol Lit135 = (SimpleSymbol)new SimpleSymbol("pregexp-quote").readResolve();
  static final SimpleSymbol Lit14;
  static final Char Lit15;
  static final IntNum Lit16;
  static final SimpleSymbol Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final Char Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final SimpleSymbol Lit26;
  static final Char Lit27;
  static final SimpleSymbol Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final SimpleSymbol Lit30;
  static final Char Lit31;
  static final PairWithPosition Lit32;
  static final Char Lit33;
  static final Char Lit34;
  static final Char Lit35;
  static final SimpleSymbol Lit36;
  static final Char Lit37;
  static final PairWithPosition Lit38;
  static final Char Lit39;
  static final SimpleSymbol Lit4;
  static final Char Lit40;
  static final SimpleSymbol Lit41;
  static final Char Lit42;
  static final PairWithPosition Lit43;
  static final Char Lit44;
  static final SimpleSymbol Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final Char Lit48;
  static final PairWithPosition Lit49;
  static final SimpleSymbol Lit5;
  static final Char Lit50;
  static final PairWithPosition Lit51;
  static final Char Lit52;
  static final PairWithPosition Lit53;
  static final Char Lit54;
  static final PairWithPosition Lit55;
  static final PairWithPosition Lit56;
  static final SimpleSymbol Lit57;
  static final Char Lit58;
  static final Char Lit59;
  static final Char Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final Char Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final Char Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final Char Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final IntNum Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final Char Lit77;
  static final Char Lit78;
  static final SimpleSymbol Lit79;
  static final IntNum Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final Char Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final Char Lit9;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final Char Lit96;
  static final Char Lit97;
  static final Char Lit98;
  static final SimpleSymbol Lit99;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn10;
  static final ModuleMethod lambda$Fn6;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn8;
  static final ModuleMethod lambda$Fn9;
  public static final ModuleMethod pregexp;
  public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
  public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
  public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
  public static final ModuleMethod pregexp$Mnerror;
  public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnlist$Mnref;
  public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
  public static final ModuleMethod pregexp$Mnmatch;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
  public static final ModuleMethod pregexp$Mnquote;
  public static final ModuleMethod pregexp$Mnread$Mnbranch;
  public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
  public static final ModuleMethod pregexp$Mnread$Mnnums;
  public static final ModuleMethod pregexp$Mnread$Mnpattern;
  public static final ModuleMethod pregexp$Mnread$Mnpiece;
  public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
  public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
  public static final ModuleMethod pregexp$Mnreplace;
  public static final ModuleMethod pregexp$Mnreplace$Mnaux;
  public static final ModuleMethod pregexp$Mnreplace$St;
  public static final ModuleMethod pregexp$Mnreverse$Ex;
  public static final ModuleMethod pregexp$Mnsplit;
  public static final ModuleMethod pregexp$Mnstring$Mnmatch;
  public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;
  
  static
  {
    Lit134 = (SimpleSymbol)new SimpleSymbol("pregexp-replace*").readResolve();
    Lit133 = (SimpleSymbol)new SimpleSymbol("pregexp-replace").readResolve();
    Lit132 = (SimpleSymbol)new SimpleSymbol("pregexp-split").readResolve();
    Lit131 = (SimpleSymbol)new SimpleSymbol("pregexp-match").readResolve();
    Lit130 = (SimpleSymbol)new SimpleSymbol("pregexp").readResolve();
    Lit129 = (SimpleSymbol)new SimpleSymbol("pregexp-replace-aux").readResolve();
    Lit128 = (SimpleSymbol)new SimpleSymbol("pregexp-make-backref-list").readResolve();
    Lit127 = (SimpleSymbol)new SimpleSymbol("pregexp-list-ref").readResolve();
    Lit126 = (SimpleSymbol)new SimpleSymbol("pregexp-at-word-boundary?").readResolve();
    Lit125 = (SimpleSymbol)new SimpleSymbol("pregexp-char-word?").readResolve();
    Lit124 = (SimpleSymbol)new SimpleSymbol("pregexp-string-match").readResolve();
    Lit123 = (SimpleSymbol)new SimpleSymbol("pregexp-invert-char-list").readResolve();
    Lit122 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-char").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-number").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("pregexp-read-branch").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("pregexp-read-pattern").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("pregexp-error").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("pregexp-reverse!").readResolve();
    Object localObject1 = Char.make(92);
    Lit19 = (Char)localObject1;
    Object localObject2 = Char.make(46);
    Lit13 = (Char)localObject2;
    Object localObject3 = Char.make(63);
    Lit47 = (Char)localObject3;
    Object localObject4 = Char.make(42);
    Lit65 = (Char)localObject4;
    Object localObject5 = Char.make(43);
    Lit66 = (Char)localObject5;
    Char localChar1 = Char.make(124);
    Lit7 = localChar1;
    Char localChar2 = Char.make(94);
    Lit9 = localChar2;
    Char localChar3 = Char.make(36);
    Lit11 = localChar3;
    Char localChar4 = Char.make(91);
    Lit15 = localChar4;
    Char localChar5 = Char.make(93);
    Lit46 = localChar5;
    Char localChar6 = Char.make(123);
    Lit67 = localChar6;
    Char localChar7 = Char.make(125);
    Lit78 = localChar7;
    Char localChar8 = Char.make(40);
    Lit18 = localChar8;
    Char localChar9 = Char.make(41);
    Lit6 = localChar9;
    Lit116 = PairWithPosition.make(localObject1, PairWithPosition.make(localObject2, PairWithPosition.make(localObject3, PairWithPosition.make(localObject4, PairWithPosition.make(localObject5, PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153977), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153973), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153969), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153965), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153961), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3153957), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149885), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149881), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149877), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149873), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149869), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149865), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149861), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 3149856);
    Lit115 = (SimpleSymbol)new SimpleSymbol("pattern-must-be-compiled-or-string-regexp").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions").readResolve();
    Lit113 = Char.make(38);
    Lit112 = (SimpleSymbol)new SimpleSymbol("identity").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("fk").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("greedy-quantifier-operand-could-be-empty").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol(":no-backtrack").readResolve();
    localObject1 = (SimpleSymbol)new SimpleSymbol(":between").readResolve();
    Lit68 = (SimpleSymbol)localObject1;
    localObject2 = Boolean.FALSE;
    localObject3 = IntNum.make(0);
    Lit73 = (IntNum)localObject3;
    localObject4 = Boolean.FALSE;
    localObject5 = (SimpleSymbol)new SimpleSymbol(":any").readResolve();
    Lit14 = (SimpleSymbol)localObject5;
    Lit108 = PairWithPosition.make(localObject1, PairWithPosition.make(localObject2, PairWithPosition.make(localObject3, PairWithPosition.make(localObject4, PairWithPosition.make(localObject5, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2338881), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2338878), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2338876), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2338873), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2338863);
    Lit107 = (SimpleSymbol)new SimpleSymbol(":neg-lookbehind").readResolve();
    Lit106 = PairWithPosition.make(Lit68, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit73, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit14, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2302017), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2302014), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2302012), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2302009), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 2301999);
    Lit105 = (SimpleSymbol)new SimpleSymbol(":lookbehind").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol(":neg-lookahead").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol(":lookahead").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("non-existent-backref").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions-aux").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol(":sub").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("pregexp-check-if-in-char-class?").readResolve();
    Lit98 = Char.make(102);
    Lit97 = Char.make(101);
    Lit96 = Char.make(99);
    Lit95 = (SimpleSymbol)new SimpleSymbol(":xdigit").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol(":upper").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol(":punct").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol(":print").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol(":lower").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol(":graph").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol(":cntrl").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol(":blank").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol(":ascii").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol(":alpha").readResolve();
    Lit85 = (SimpleSymbol)new SimpleSymbol(":alnum").readResolve();
    Lit84 = Char.make(95);
    Lit83 = (SimpleSymbol)new SimpleSymbol(":char-range").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol(":one-of-chars").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("character-class-ended-too-soon").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("pregexp-read-char-list").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol(":none-of-chars").readResolve();
    Lit77 = Char.make(44);
    Lit76 = (SimpleSymbol)new SimpleSymbol("pregexp-read-nums").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("left-brace-must-be-followed-by-number").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("pregexp-wrap-quantifier-if-any").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("next-i").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("at-most").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("at-least").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("minimal?").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("pregexp-read-subpattern").readResolve();
    Lit63 = PairWithPosition.make(Lit100, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 942102);
    Lit62 = Char.make(120);
    Lit61 = (SimpleSymbol)new SimpleSymbol(":case-insensitive").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol(":case-sensitive").readResolve();
    Lit59 = Char.make(105);
    Lit58 = Char.make(45);
    Lit57 = (SimpleSymbol)new SimpleSymbol("pregexp-read-cluster-type").readResolve();
    Lit56 = PairWithPosition.make(Lit107, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 876575);
    Lit55 = PairWithPosition.make(Lit105, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 872479);
    Lit54 = Char.make(60);
    Lit53 = PairWithPosition.make(Lit109, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 860188);
    Lit52 = Char.make(62);
    Lit51 = PairWithPosition.make(Lit104, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 856092);
    Lit50 = Char.make(33);
    Lit49 = PairWithPosition.make(Lit103, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 851996);
    Lit48 = Char.make(61);
    Lit45 = (SimpleSymbol)new SimpleSymbol("pregexp-read-posix-char-class").readResolve();
    Lit44 = Char.make(58);
    localObject1 = (SimpleSymbol)new SimpleSymbol(":neg-char").readResolve();
    Lit17 = (SimpleSymbol)localObject1;
    localObject2 = (SimpleSymbol)new SimpleSymbol(":word").readResolve();
    Lit41 = (SimpleSymbol)localObject2;
    Lit43 = PairWithPosition.make(localObject1, PairWithPosition.make(localObject2, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 696359), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 696348);
    Lit42 = Char.make(87);
    Lit40 = Char.make(119);
    Lit39 = Char.make(116);
    localObject1 = Lit17;
    localObject2 = (SimpleSymbol)new SimpleSymbol(":space").readResolve();
    Lit36 = (SimpleSymbol)localObject2;
    Lit38 = PairWithPosition.make(localObject1, PairWithPosition.make(localObject2, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 684071), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 684060);
    Lit37 = Char.make(83);
    Lit35 = Char.make(115);
    Lit34 = Char.make(114);
    Lit33 = Char.make(110);
    localObject1 = Lit17;
    localObject2 = (SimpleSymbol)new SimpleSymbol(":digit").readResolve();
    Lit30 = (SimpleSymbol)localObject2;
    Lit32 = PairWithPosition.make(localObject1, PairWithPosition.make(localObject2, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 667687), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm", 667676);
    Lit31 = Char.make(68);
    Lit29 = Char.make(100);
    Lit28 = (SimpleSymbol)new SimpleSymbol(":not-wbdry").readResolve();
    Lit27 = Char.make(66);
    Lit26 = (SimpleSymbol)new SimpleSymbol(":wbdry").readResolve();
    Lit25 = Char.make(98);
    Lit24 = Char.make(10);
    Lit23 = (SimpleSymbol)new SimpleSymbol(":empty").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("backslash").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("pregexp-read-piece").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol(":backref").readResolve();
    Lit16 = IntNum.make(2);
    Lit12 = (SimpleSymbol)new SimpleSymbol(":eos").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol(":bos").readResolve();
    Lit8 = IntNum.make(1);
    Lit5 = (SimpleSymbol)new SimpleSymbol(":seq").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol(":or").readResolve();
    Lit3 = Char.make(32);
    Lit2 = Char.make(97);
    Lit1 = Char.make(59);
    Lit0 = IntNum.make(20050502);
    $instance = new pregexp();
    localObject1 = $instance;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 16, Lit117, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:47");
    pregexp$Mnreverse$Ex = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 17, Lit118, 61440);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:57");
    pregexp$Mnerror = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 18, Lit119, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:65");
    pregexp$Mnread$Mnpattern = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 19, Lit120, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:79");
    pregexp$Mnread$Mnbranch = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 20, Lit21, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:91");
    pregexp$Mnread$Mnpiece = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 21, Lit121, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:138");
    pregexp$Mnread$Mnescaped$Mnnumber = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 22, Lit122, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:155");
    pregexp$Mnread$Mnescaped$Mnchar = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 23, Lit45, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:174");
    pregexp$Mnread$Mnposix$Mnchar$Mnclass = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 24, Lit57, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:200");
    pregexp$Mnread$Mncluster$Mntype = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 25, Lit64, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:233");
    pregexp$Mnread$Mnsubpattern = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 26, Lit74, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:254");
    pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 27, Lit76, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:300");
    pregexp$Mnread$Mnnums = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 28, Lit123, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:323");
    pregexp$Mninvert$Mnchar$Mnlist = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 29, Lit80, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:330");
    pregexp$Mnread$Mnchar$Mnlist = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 30, Lit124, 24582);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:368");
    pregexp$Mnstring$Mnmatch = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 31, Lit125, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:379");
    pregexp$Mnchar$Mnword$Qu = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 32, Lit126, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:387");
    pregexp$Mnat$Mnword$Mnboundary$Qu = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 33, Lit99, 8194);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:399");
    pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 34, Lit127, 8194);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:429");
    pregexp$Mnlist$Mnref = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 35, Lit128, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:448");
    pregexp$Mnmake$Mnbackref$Mnlist = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 36, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:463");
    lambda$Fn1 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 37, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:551");
    lambda$Fn6 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 38, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:556");
    lambda$Fn7 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 39, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:564");
    lambda$Fn8 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 40, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:573");
    lambda$Fn9 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 41, null, 0);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:578");
    lambda$Fn10 = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 42, Lit101, 24582);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:459");
    pregexp$Mnmatch$Mnpositions$Mnaux = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 43, Lit129, 16388);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:639");
    pregexp$Mnreplace$Mnaux = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 44, Lit130, 4097);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:665");
    pregexp = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 45, Lit114, 61442);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:670");
    pregexp$Mnmatch$Mnpositions = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 46, Lit131, 61442);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:690");
    pregexp$Mnmatch = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 47, Lit132, 8194);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:700");
    pregexp$Mnsplit = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 48, Lit133, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:723");
    pregexp$Mnreplace = (ModuleMethod)localObject2;
    localObject2 = new ModuleMethod((ModuleBody)localObject1, 49, Lit134, 12291);
    ((PropertySet)localObject2).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:736");
    pregexp$Mnreplace$St = (ModuleMethod)localObject2;
    localObject1 = new ModuleMethod((ModuleBody)localObject1, 50, Lit135, 4097);
    ((PropertySet)localObject1).setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:764");
    pregexp$Mnquote = (ModuleMethod)localObject1;
    $instance.run();
  }
  
  public pregexp()
  {
    ModuleInfo.register(this);
  }
  
  /* Error */
  public static Object isPregexpAtWordBoundary(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 892	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   3: aload_1
    //   4: getstatic 403	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   7: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 6
    //   12: aload 6
    //   14: checkcast 392	java/lang/Boolean
    //   17: invokevirtual 902	java/lang/Boolean:booleanValue	()Z
    //   20: istore 5
    //   22: iload 5
    //   24: ifeq +16 -> 40
    //   27: iload 5
    //   29: ifeq +7 -> 36
    //   32: getstatic 905	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   35: areturn
    //   36: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   39: areturn
    //   40: getstatic 908	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore_2
    //   49: aload_2
    //   50: checkcast 392	java/lang/Boolean
    //   53: invokevirtual 902	java/lang/Boolean:booleanValue	()Z
    //   56: istore 5
    //   58: iload 5
    //   60: ifeq +16 -> 76
    //   63: iload 5
    //   65: ifeq +7 -> 72
    //   68: getstatic 905	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   71: areturn
    //   72: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   75: areturn
    //   76: aload_0
    //   77: checkcast 910	java/lang/CharSequence
    //   80: astore_2
    //   81: aload_1
    //   82: checkcast 912	java/lang/Number
    //   85: invokevirtual 916	java/lang/Number:intValue	()I
    //   88: istore_3
    //   89: aload_2
    //   90: iload_3
    //   91: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   94: istore_3
    //   95: aload_0
    //   96: checkcast 910	java/lang/CharSequence
    //   99: astore_2
    //   100: getstatic 928	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   103: aload_1
    //   104: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   107: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: astore_0
    //   111: aload_0
    //   112: checkcast 912	java/lang/Number
    //   115: invokevirtual 916	java/lang/Number:intValue	()I
    //   118: istore 4
    //   120: aload_2
    //   121: iload 4
    //   123: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   126: istore 4
    //   128: iload_3
    //   129: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   132: getstatic 617	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   135: invokestatic 931	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: astore_1
    //   139: iload 4
    //   141: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   144: getstatic 617	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   147: invokestatic 931	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: astore_2
    //   151: aload_1
    //   152: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   155: if_acmpeq +30 -> 185
    //   158: aload_2
    //   159: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   162: if_acmpeq +16 -> 178
    //   165: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   168: astore_0
    //   169: aload_0
    //   170: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   173: if_acmpeq +17 -> 190
    //   176: aload_0
    //   177: areturn
    //   178: getstatic 905	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   181: astore_0
    //   182: goto -13 -> 169
    //   185: aload_1
    //   186: astore_0
    //   187: goto -18 -> 169
    //   190: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   193: astore_0
    //   194: aload_1
    //   195: aload_0
    //   196: if_acmpeq +17 -> 213
    //   199: iconst_1
    //   200: istore_3
    //   201: iload_3
    //   202: iconst_1
    //   203: iadd
    //   204: iconst_1
    //   205: iand
    //   206: istore_3
    //   207: iload_3
    //   208: ifeq +10 -> 218
    //   211: aload_2
    //   212: areturn
    //   213: iconst_0
    //   214: istore_3
    //   215: goto -14 -> 201
    //   218: iload_3
    //   219: ifeq +7 -> 226
    //   222: getstatic 905	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   225: areturn
    //   226: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   229: areturn
    //   230: astore_0
    //   231: new 933	gnu/mapping/WrongType
    //   234: dup
    //   235: aload_0
    //   236: ldc_w 935
    //   239: bipush -2
    //   241: aload 6
    //   243: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore_0
    //   248: new 933	gnu/mapping/WrongType
    //   251: dup
    //   252: aload_0
    //   253: ldc_w 935
    //   256: bipush -2
    //   258: aload_2
    //   259: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore_1
    //   264: new 933	gnu/mapping/WrongType
    //   267: dup
    //   268: aload_1
    //   269: ldc_w 940
    //   272: iconst_1
    //   273: aload_0
    //   274: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    //   278: astore_0
    //   279: new 933	gnu/mapping/WrongType
    //   282: dup
    //   283: aload_0
    //   284: ldc_w 940
    //   287: iconst_2
    //   288: aload_1
    //   289: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: astore_1
    //   294: new 933	gnu/mapping/WrongType
    //   297: dup
    //   298: aload_1
    //   299: ldc_w 940
    //   302: iconst_1
    //   303: aload_0
    //   304: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: astore_1
    //   309: new 933	gnu/mapping/WrongType
    //   312: dup
    //   313: aload_1
    //   314: ldc_w 940
    //   317: iconst_2
    //   318: aload_0
    //   319: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //   323: astore_0
    //   324: new 933	gnu/mapping/WrongType
    //   327: dup
    //   328: aload_0
    //   329: ldc_w 935
    //   332: bipush -2
    //   334: aload_1
    //   335: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramObject1	Object
    //   0	339	1	paramObject2	Object
    //   0	339	2	paramObject3	Object
    //   88	131	3	i	int
    //   118	22	4	j	int
    //   20	44	5	bool	boolean
    //   10	232	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	230	java/lang/ClassCastException
    //   49	58	247	java/lang/ClassCastException
    //   76	81	263	java/lang/ClassCastException
    //   81	89	278	java/lang/ClassCastException
    //   95	100	293	java/lang/ClassCastException
    //   111	120	308	java/lang/ClassCastException
    //   190	194	323	java/lang/ClassCastException
  }
  
  public static boolean isPregexpCharWord(Object paramObject)
  {
    try
    {
      localChar = (Char)paramObject;
      bool1 = unicode.isCharAlphabetic(localChar);
      if (!bool1) {
        break label16;
      }
    }
    catch (ClassCastException localClassCastException1)
    {
      try
      {
        label16:
        boolean bool2;
        do
        {
          localChar = (Char)paramObject;
          bool2 = unicode.isCharNumeric(localChar);
          boolean bool1 = bool2;
        } while (bool2);
      }
      catch (ClassCastException localClassCastException2)
      {
        Char localChar;
        throw new WrongType(localClassCastException2, "char-numeric?", 1, paramObject);
      }
      try
      {
        localChar = (Char)paramObject;
        return characters.isChar$Eq(localChar, Lit84);
      }
      catch (ClassCastException localClassCastException3)
      {
        throw new WrongType(localClassCastException3, "char=?", 1, paramObject);
      }
      localClassCastException1 = localClassCastException1;
      throw new WrongType(localClassCastException1, "char-alphabetic?", 1, paramObject);
    }
    return bool1;
  }
  
  public static Object isPregexpCheckIfInCharClass(Object paramObject1, Object paramObject2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object lambda1sub(Object paramObject)
  {
    if (lists.isPair(paramObject))
    {
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lambda1sub(lists.cdr.apply1(paramObject));
      if (Scheme.isEqv.apply2(localObject1, Lit100) != Boolean.FALSE) {
        return lists.cons(lists.cons(paramObject, Boolean.FALSE), localObject2);
      }
      return append.append$V(new Object[] { lambda1sub(localObject1), localObject2 });
    }
    return LList.Empty;
  }
  
  public static Pair pregexp(Object paramObject)
  {
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
    SimpleSymbol localSimpleSymbol = Lit100;
    GenericProc localGenericProc = lists.car;
    IntNum localIntNum = Lit73;
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return LList.list2(localSimpleSymbol, localGenericProc.apply1(pregexpReadPattern(paramObject, localIntNum, Integer.valueOf(strings.stringLength(localCharSequence)))));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, paramObject);
    }
  }
  
  public static Object pregexpError$V(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    ports.display("Error:");
    for (;;)
    {
      if (paramArrayOfObject == LList.Empty)
      {
        ports.newline();
        return misc.error$V("pregexp-error", new Object[0]);
      }
      try
      {
        Pair localPair = (Pair)paramArrayOfObject;
        paramArrayOfObject = localPair.getCar();
        ports.display(Lit3);
        ports.write(paramArrayOfObject);
        paramArrayOfObject = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, paramArrayOfObject);
      }
    }
  }
  
  public static Object pregexpInvertCharList(Object paramObject)
  {
    Object localObject = lists.car.apply1(paramObject);
    try
    {
      Pair localPair = (Pair)localObject;
      lists.setCar$Ex(localPair, Lit79);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw new WrongType((ClassCastException)paramObject, "set-car!", 1, localObject);
    }
  }
  
  public static Object pregexpListRef(Object paramObject1, Object paramObject2)
  {
    IntNum localIntNum = Lit73;
    Object localObject = paramObject1;
    for (paramObject1 = localIntNum;; paramObject1 = AddOp.$Pl.apply2(paramObject1, Lit8))
    {
      if (lists.isNull(localObject)) {
        return Boolean.FALSE;
      }
      if (Scheme.numEqu.apply2(paramObject1, paramObject2) != Boolean.FALSE) {
        return lists.car.apply1(localObject);
      }
      localObject = lists.cdr.apply1(localObject);
    }
  }
  
  public static Object pregexpMakeBackrefList(Object paramObject)
  {
    return lambda1sub(paramObject);
  }
  
  public static Object pregexpMatch$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    paramObject1 = Scheme.apply.apply4(pregexp$Mnmatch$Mnpositions, paramObject1, paramObject2, paramArrayOfObject);
    paramArrayOfObject = (Object[])paramObject1;
    Object localObject1;
    if (paramObject1 != Boolean.FALSE)
    {
      localObject1 = LList.Empty;
      paramArrayOfObject = (Object[])paramObject1;
      paramObject1 = localObject1;
    }
    for (;;)
    {
      if (paramArrayOfObject == LList.Empty)
      {
        paramArrayOfObject = LList.reverseInPlace(paramObject1);
        return paramArrayOfObject;
      }
      try
      {
        localObject2 = (Pair)paramArrayOfObject;
        localObject1 = ((Pair)localObject2).getCdr();
        localObject2 = ((Pair)localObject2).getCar();
        paramArrayOfObject = (Object[])localObject2;
        if (localObject2 == Boolean.FALSE) {}
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          paramArrayOfObject = (CharSequence)paramObject2;
          localObject3 = lists.car.apply1(localObject2);
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          int j;
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
        }
        try
        {
          i = ((Number)localObject3).intValue();
          localObject2 = lists.cdr.apply1(localObject2);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject3);
        }
        try
        {
          j = ((Number)localObject2).intValue();
          paramArrayOfObject = strings.substring(paramArrayOfObject, i, j);
          paramObject1 = Pair.make(paramArrayOfObject, paramObject1);
          paramArrayOfObject = (Object[])localObject1;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject2);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "arg0", -2, paramArrayOfObject);
      }
    }
  }
  
  public static Object pregexpMatchPositions$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    if (strings.isString(paramObject1)) {
      paramArrayOfObject = pregexp(paramObject1);
    }
    try
    {
      paramObject1 = (CharSequence)paramObject2;
      i = strings.stringLength((CharSequence)paramObject1);
      if (lists.isNull(localObject1))
      {
        paramObject1 = Lit73;
        if (!lists.isNull(localObject1)) {
          break label179;
        }
        localObject1 = Integer.valueOf(i);
        localObject2 = paramObject1;
        localObject3 = Scheme.numLEq.apply2(localObject2, localObject1);
      }
    }
    catch (ClassCastException paramObject1)
    {
      try
      {
        boolean bool;
        for (;;)
        {
          int i;
          bool = ((Boolean)localObject3).booleanValue();
          if (!bool) {
            break;
          }
          localObject3 = pregexpMatchPositionsAux(paramArrayOfObject, paramObject2, Integer.valueOf(i), paramObject1, localObject1, localObject2);
          if (localObject3 != Boolean.FALSE)
          {
            return localObject3;
            paramArrayOfObject = (Object[])paramObject1;
            if (lists.isPair(paramObject1)) {
              continue;
            }
            pregexpError$V(new Object[] { Lit114, Lit115, paramObject1 });
            paramArrayOfObject = (Object[])paramObject1;
            continue;
            paramObject1 = lists.car.apply1(localObject1);
            localObject2 = lists.cdr.apply1(localObject1);
          }
          try
          {
            localObject1 = (LList)localObject2;
          }
          catch (ClassCastException paramObject1)
          {
            label179:
            throw new WrongType((ClassCastException)paramObject1, "opt-args", -2, localObject2);
          }
          localObject1 = lists.car.apply1(localObject1);
          continue;
          localObject2 = AddOp.$Pl.apply2(localObject2, Lit8);
        }
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException paramObject1)
      {
        Object localObject2;
        Object localObject3;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject3);
      }
      paramObject1 = paramObject1;
      throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
    }
  }
  
  public static Object pregexpMatchPositionsAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    frame localframe = new frame();
    localframe.s = paramObject2;
    localframe.sn = paramObject3;
    localframe.start = paramObject4;
    localframe.n = paramObject5;
    paramObject2 = localframe.identity;
    paramObject3 = pregexpMakeBackrefList(paramObject1);
    localframe.case$Mnsensitive$Qu = Boolean.TRUE;
    localframe.backrefs = paramObject3;
    localframe.identity = ((Procedure)paramObject2);
    localframe.lambda3sub(paramObject1, paramObject6, localframe.identity, lambda$Fn1);
    paramObject1 = localframe.backrefs;
    paramObject2 = LList.Empty;
    for (;;)
    {
      if (paramObject1 == LList.Empty)
      {
        paramObject1 = LList.reverseInPlace(paramObject2);
        paramObject2 = lists.car.apply1(paramObject1);
        if (paramObject2 == Boolean.FALSE) {
          break label149;
        }
        return paramObject1;
      }
      try
      {
        paramObject3 = (Pair)paramObject1;
        paramObject1 = ((Pair)paramObject3).getCdr();
        paramObject2 = Pair.make(lists.cdr.apply1(((Pair)paramObject3).getCar()), paramObject2);
      }
      catch (ClassCastException paramObject2)
      {
        label149:
        throw new WrongType((ClassCastException)paramObject2, "arg0", -2, paramObject1);
      }
    }
    return paramObject2;
  }
  
  /* Error */
  public static Object pregexpQuote(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 910	java/lang/CharSequence
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1012	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   9: iconst_1
    //   10: isub
    //   11: invokestatic 1018	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: astore_3
    //   15: getstatic 337	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   18: astore_2
    //   19: getstatic 1144	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   22: aload_3
    //   23: getstatic 403	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   26: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   32: if_acmpeq +13 -> 45
    //   35: aload_2
    //   36: checkcast 333	gnu/lists/LList
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 1148	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   44: areturn
    //   45: getstatic 928	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   48: aload_3
    //   49: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   52: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 4
    //   57: aload_0
    //   58: checkcast 910	java/lang/CharSequence
    //   61: astore 5
    //   63: aload_3
    //   64: checkcast 912	java/lang/Number
    //   67: invokevirtual 916	java/lang/Number:intValue	()I
    //   70: istore_1
    //   71: aload 5
    //   73: iload_1
    //   74: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   77: istore_1
    //   78: iload_1
    //   79: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   82: getstatic 360	gnu/kawa/slib/pregexp:Lit116	Lgnu/lists/PairWithPosition;
    //   85: invokestatic 1151	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: if_acmpeq +24 -> 115
    //   94: getstatic 305	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   97: iload_1
    //   98: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   101: aload_2
    //   102: invokestatic 997	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   105: invokestatic 997	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   108: astore_2
    //   109: aload 4
    //   111: astore_3
    //   112: goto -93 -> 19
    //   115: iload_1
    //   116: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   119: aload_2
    //   120: invokestatic 997	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   123: astore_2
    //   124: goto -15 -> 109
    //   127: astore_2
    //   128: new 933	gnu/mapping/WrongType
    //   131: dup
    //   132: aload_2
    //   133: ldc_w 1026
    //   136: iconst_1
    //   137: aload_0
    //   138: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    //   142: astore_0
    //   143: new 933	gnu/mapping/WrongType
    //   146: dup
    //   147: aload_0
    //   148: ldc_w 1153
    //   151: iconst_1
    //   152: aload_2
    //   153: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //   157: astore_2
    //   158: new 933	gnu/mapping/WrongType
    //   161: dup
    //   162: aload_2
    //   163: ldc_w 940
    //   166: iconst_1
    //   167: aload_0
    //   168: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: astore_0
    //   173: new 933	gnu/mapping/WrongType
    //   176: dup
    //   177: aload_0
    //   178: ldc_w 940
    //   181: iconst_2
    //   182: aload_3
    //   183: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramObject	Object
    //   70	46	1	i	int
    //   4	120	2	localObject1	Object
    //   127	26	2	localClassCastException1	ClassCastException
    //   157	6	2	localClassCastException2	ClassCastException
    //   14	169	3	localObject2	Object
    //   55	55	4	localObject3	Object
    //   61	11	5	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   0	5	127	java/lang/ClassCastException
    //   35	40	142	java/lang/ClassCastException
    //   57	63	157	java/lang/ClassCastException
    //   63	71	172	java/lang/ClassCastException
  }
  
  public static Object pregexpReadBranch(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject2 = LList.Empty;
    localObject1 = paramObject2;
    paramObject2 = localObject2;
    for (;;)
    {
      if (Scheme.numGEq.apply2(localObject1, paramObject3) != Boolean.FALSE) {
        return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(paramObject2)), localObject1);
      }
      try
      {
        localObject2 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        try
        {
          int i = ((Number)localObject1).intValue();
          i = strings.stringRef((CharSequence)localObject2, i);
          boolean bool = characters.isChar$Eq(Char.make(i), Lit7);
          if (bool)
          {
            if (!bool) {}
          }
          else {
            while (characters.isChar$Eq(Char.make(i), Lit6)) {
              return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(paramObject2)), localObject1);
            }
          }
          localObject1 = pregexpReadPiece(paramObject1, localObject1, paramObject3);
          paramObject2 = lists.cons(lists.car.apply1(localObject1), paramObject2);
          localObject1 = lists.cadr.apply1(localObject1);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        paramObject2 = paramObject2;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
    }
  }
  
  public static Object pregexpReadCharList(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    localObject2 = LList.Empty;
    localObject1 = paramObject2;
    paramObject2 = localObject2;
    for (;;)
    {
      if (Scheme.numGEq.apply2(localObject1, paramObject3) != Boolean.FALSE) {
        return pregexpError$V(new Object[] { Lit80, Lit81 });
      }
      for (;;)
      {
        try
        {
          localObject2 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          int i;
          boolean bool;
          int j;
          SimpleSymbol localSimpleSymbol;
          CharSequence localCharSequence;
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject1).intValue();
          i = strings.stringRef((CharSequence)localObject2, i);
          if (Scheme.isEqv.apply2(Char.make(i), Lit46) != Boolean.FALSE)
          {
            if (lists.isNull(paramObject2))
            {
              paramObject2 = lists.cons(Char.make(i), paramObject2);
              localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
              break;
            }
            return LList.list2(lists.cons(Lit82, pregexpReverse$Ex(paramObject2)), AddOp.$Pl.apply2(localObject1, Lit8));
          }
          if (Scheme.isEqv.apply2(Char.make(i), Lit19) != Boolean.FALSE)
          {
            localObject1 = pregexpReadEscapedChar(paramObject1, localObject1, paramObject3);
            if (localObject1 != Boolean.FALSE)
            {
              paramObject2 = lists.cons(lists.car.apply1(localObject1), paramObject2);
              localObject1 = lists.cadr.apply1(localObject1);
              break;
            }
            return pregexpError$V(new Object[] { Lit80, Lit22 });
          }
          if (Scheme.isEqv.apply2(Char.make(i), Lit58) != Boolean.FALSE)
          {
            bool = lists.isNull(paramObject2);
            if (bool)
            {
              if (!bool) {
                continue;
              }
              paramObject2 = lists.cons(Char.make(i), paramObject2);
              localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
              break;
            }
            localObject2 = AddOp.$Pl.apply2(localObject1, Lit8);
            localObject3 = Scheme.numLss.apply2(localObject2, paramObject3);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
        }
        try
        {
          bool = ((Boolean)localObject3).booleanValue();
          if (!bool) {}
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject3);
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
          j = ((Number)localObject2).intValue();
          if (characters.isChar$Eq(Char.make(strings.stringRef((CharSequence)localObject3, j)), Lit46)) {
            continue;
          }
          localObject3 = lists.car.apply1(paramObject2);
          if (characters.isChar(localObject3)) {
            localSimpleSymbol = Lit83;
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
        }
        try
        {
          localCharSequence = (CharSequence)paramObject1;
          localObject2 = AddOp.$Pl.apply2(localObject1, Lit8);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject2).intValue();
          paramObject2 = lists.cons(LList.list3(localSimpleSymbol, localObject3, Char.make(strings.stringRef(localCharSequence, i))), lists.cdr.apply1(paramObject2));
          localObject1 = AddOp.$Pl.apply2(localObject1, Lit16);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
        }
        if (!bool) {}
      }
      paramObject2 = lists.cons(Char.make(i), paramObject2);
      localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
      continue;
      if (Scheme.isEqv.apply2(Char.make(i), Lit15) != Boolean.FALSE) {}
      try
      {
        localObject3 = (CharSequence)paramObject1;
        localObject2 = AddOp.$Pl.apply2(localObject1, Lit8);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        j = ((Number)localObject2).intValue();
        if (characters.isChar$Eq(Char.make(strings.stringRef((CharSequence)localObject3, j)), Lit44))
        {
          localObject1 = pregexpReadPosixCharClass(paramObject1, AddOp.$Pl.apply2(localObject1, Lit16), paramObject3);
          paramObject2 = lists.cons(lists.car.apply1(localObject1), paramObject2);
          localObject1 = lists.cadr.apply1(localObject1);
          continue;
        }
        paramObject2 = lists.cons(Char.make(i), paramObject2);
        localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
      }
      paramObject2 = lists.cons(Char.make(i), paramObject2);
      localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
    }
  }
  
  public static Object pregexpReadClusterType(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    for (;;)
    {
      try
      {
        paramObject3 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        int i;
        Object localObject;
        CharSequence localCharSequence;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        i = strings.stringRef((CharSequence)paramObject3, i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit47) != Boolean.FALSE) {
          paramObject3 = AddOp.$Pl.apply2(paramObject2, Lit8);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      try
      {
        paramObject2 = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject3).intValue();
        i = strings.stringRef((CharSequence)paramObject2, i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit44) != Boolean.FALSE) {
          return LList.list2(LList.Empty, AddOp.$Pl.apply2(paramObject3, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit48) != Boolean.FALSE) {
          return LList.list2(Lit49, AddOp.$Pl.apply2(paramObject3, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit50) != Boolean.FALSE) {
          return LList.list2(Lit51, AddOp.$Pl.apply2(paramObject3, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit52) != Boolean.FALSE) {
          return LList.list2(Lit53, AddOp.$Pl.apply2(paramObject3, Lit8));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit54) == Boolean.FALSE) {}
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject3);
      }
      try
      {
        paramObject2 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Pl.apply2(paramObject3, Lit8);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        i = strings.stringRef((CharSequence)paramObject2, i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit48) != Boolean.FALSE)
        {
          paramObject1 = Lit55;
          return LList.list2(paramObject1, AddOp.$Pl.apply2(paramObject3, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit50) != Boolean.FALSE)
        {
          paramObject1 = Lit56;
          continue;
        }
        paramObject1 = pregexpError$V(new Object[] { Lit57 });
        continue;
        localObject = LList.Empty;
        paramObject2 = Boolean.FALSE;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
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
        i = ((Number)paramObject3).intValue();
        i = strings.stringRef(localCharSequence, i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit58) != Boolean.FALSE)
        {
          paramObject3 = AddOp.$Pl.apply2(paramObject3, Lit8);
          paramObject2 = Boolean.TRUE;
        }
        else if (Scheme.isEqv.apply2(Char.make(i), Lit59) != Boolean.FALSE)
        {
          paramObject3 = AddOp.$Pl.apply2(paramObject3, Lit8);
          if (paramObject2 != Boolean.FALSE)
          {
            paramObject2 = Lit60;
            localObject = lists.cons(paramObject2, localObject);
            paramObject2 = Boolean.FALSE;
          }
          else
          {
            paramObject2 = Lit61;
          }
        }
        else if (Scheme.isEqv.apply2(Char.make(i), Lit62) != Boolean.FALSE)
        {
          $Stpregexp$Mnspace$Mnsensitive$Qu$St = paramObject2;
          paramObject3 = AddOp.$Pl.apply2(paramObject3, Lit8);
          paramObject2 = Boolean.FALSE;
        }
        else
        {
          if (Scheme.isEqv.apply2(Char.make(i), Lit44) != Boolean.FALSE) {
            return LList.list2(localObject, AddOp.$Pl.apply2(paramObject3, Lit8));
          }
          return pregexpError$V(new Object[] { Lit57 });
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject3);
      }
    }
    return LList.list2(Lit63, paramObject2);
  }
  
  public static Object pregexpReadEscapedChar(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject3 = Scheme.numLss.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
    for (;;)
    {
      try
      {
        bool = ((Boolean)paramObject3).booleanValue();
        if (!bool) {}
      }
      catch (ClassCastException paramObject1)
      {
        boolean bool;
        int i;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject3);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        i = strings.stringRef((CharSequence)paramObject3, i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit25) != Boolean.FALSE) {
          return LList.list2(Lit26, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit27) != Boolean.FALSE) {
          return LList.list2(Lit28, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit29) != Boolean.FALSE) {
          return LList.list2(Lit30, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit31) != Boolean.FALSE) {
          return LList.list2(Lit32, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit33) != Boolean.FALSE) {
          return LList.list2(Lit24, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit34) != Boolean.FALSE) {
          return LList.list2($Stpregexp$Mnreturn$Mnchar$St, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit35) != Boolean.FALSE) {
          return LList.list2(Lit36, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit37) != Boolean.FALSE) {
          return LList.list2(Lit38, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit39) != Boolean.FALSE) {
          return LList.list2($Stpregexp$Mntab$Mnchar$St, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit40) != Boolean.FALSE) {
          return LList.list2(Lit41, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit42) != Boolean.FALSE) {
          return LList.list2(Lit43, AddOp.$Pl.apply2(paramObject2, Lit16));
        }
        return LList.list2(Char.make(i), AddOp.$Pl.apply2(paramObject2, Lit16));
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
  }
  
  public static Object pregexpReadEscapedNumber(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    localObject = Scheme.numLss.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
    for (;;)
    {
      try
      {
        bool = ((Boolean)localObject).booleanValue();
        if (!bool) {}
      }
      catch (ClassCastException paramObject1)
      {
        boolean bool;
        CharSequence localCharSequence;
        int i;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject);
      }
      try
      {
        localCharSequence = (CharSequence)paramObject1;
        localObject = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)localObject).intValue();
        i = strings.stringRef(localCharSequence, i);
        bool = unicode.isCharNumeric(Char.make(i));
        if (bool)
        {
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit16);
          localObject = LList.list1(Char.make(i));
          if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
            paramObject1 = pregexpReverse$Ex(localObject);
          }
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject);
      }
      try
      {
        paramObject3 = (LList)paramObject1;
        return LList.list2(numbers.string$To$Number(strings.list$To$String((LList)paramObject3)), paramObject2);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "list->string", 1, paramObject1);
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
        i = ((Number)paramObject2).intValue();
        i = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(i)))
        {
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          localObject = lists.cons(Char.make(i), localObject);
        }
        else
        {
          paramObject1 = pregexpReverse$Ex(localObject);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
    }
    try
    {
      paramObject3 = (LList)paramObject1;
      return LList.list2(numbers.string$To$Number(strings.list$To$String((LList)paramObject3)), paramObject2);
    }
    catch (ClassCastException paramObject2)
    {
      throw new WrongType((ClassCastException)paramObject2, "list->string", 1, paramObject1);
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object pregexpReadNums(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject2 = LList.Empty;
    Object localObject1 = LList.Empty;
    IntNum localIntNum = Lit8;
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
      pregexpError$V(new Object[] { Lit76 });
    }
    for (;;)
    {
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        CharSequence localCharSequence;
        int i;
        boolean bool;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        i = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(i)))
        {
          if (Scheme.numEqu.apply2(localIntNum, Lit8) != Boolean.FALSE)
          {
            localObject2 = lists.cons(Char.make(i), localObject2);
            paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
            localIntNum = Lit8;
            break;
          }
          localObject1 = lists.cons(Char.make(i), localObject1);
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          localIntNum = Lit16;
          break;
        }
        bool = unicode.isCharWhitespace(Char.make(i));
        if (bool)
        {
          if ($Stpregexp$Mnspace$Mnsensitive$Qu$St != Boolean.FALSE) {
            continue;
          }
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          break;
        }
        if (bool) {
          continue;
        }
        bool = characters.isChar$Eq(Char.make(i), Lit77);
        if (bool)
        {
          if (Scheme.numEqu.apply2(localIntNum, Lit8) == Boolean.FALSE) {
            continue;
          }
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          localIntNum = Lit16;
          break;
        }
        if (bool) {
          continue;
        }
        if (characters.isChar$Eq(Char.make(i), Lit78)) {
          paramObject1 = pregexpReverse$Ex(localObject2);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      try
      {
        paramObject3 = (LList)paramObject1;
        paramObject1 = numbers.string$To$Number(strings.list$To$String((LList)paramObject3));
        paramObject3 = pregexpReverse$Ex(localObject1);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "list->string", 1, paramObject1);
      }
      try
      {
        localObject1 = (LList)paramObject3;
        paramObject3 = numbers.string$To$Number(strings.list$To$String((LList)localObject1));
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "list->string", 1, paramObject3);
      }
      try
      {
        localObject1 = Boolean.FALSE;
        if (paramObject1 != localObject1)
        {
          i = 1;
          i = i + 1 & 0x1;
          if (i != 0)
          {
            if (Scheme.numEqu.apply2(localIntNum, Lit8) == Boolean.FALSE) {
              continue;
            }
            return LList.list3(Lit73, Boolean.FALSE, paramObject2);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        if (i == 0)
        {
          if (Scheme.numEqu.apply2(localIntNum, Lit8) != Boolean.FALSE) {
            return LList.list3(paramObject1, paramObject1, paramObject2);
          }
          return LList.list3(paramObject1, paramObject3, paramObject2);
        }
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "x", -2, paramObject1);
      }
    }
    return Boolean.FALSE;
  }
  
  public static Object pregexpReadPattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
      return LList.list2(LList.list2(Lit4, LList.list1(Lit5)), paramObject2);
    }
    Object localObject1 = LList.Empty;
    for (;;)
    {
      Object localObject2 = Scheme.numGEq.apply2(paramObject2, paramObject3);
      try
      {
        boolean bool = ((Boolean)localObject2).booleanValue();
        if (bool)
        {
          if (!bool) {
            break label114;
          }
          return LList.list2(lists.cons(Lit4, pregexpReverse$Ex(localObject1)), paramObject2);
        }
      }
      catch (ClassCastException paramObject1)
      {
        for (;;)
        {
          try
          {
            localObject2 = (CharSequence)paramObject1;
          }
          catch (ClassCastException paramObject2)
          {
            int i;
            label114:
            CharSequence localCharSequence;
            throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
          }
          try
          {
            i = ((Number)paramObject2).intValue();
            if (characters.isChar$Eq(Char.make(strings.stringRef((CharSequence)localObject2, i)), Lit6)) {}
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
          }
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
          i = ((Number)paramObject2).intValue();
          localObject2 = paramObject2;
          if (characters.isChar$Eq(Char.make(strings.stringRef(localCharSequence, i)), Lit7)) {
            localObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          }
          paramObject2 = pregexpReadBranch(paramObject1, localObject2, paramObject3);
          localObject1 = lists.cons(lists.car.apply1(paramObject2), localObject1);
          paramObject2 = lists.cadr.apply1(paramObject2);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject2);
      }
    }
  }
  
  public static Object pregexpReadPiece(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object pregexpReadPosixCharClass(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Boolean localBoolean = Boolean.FALSE;
    Pair localPair = LList.list1(Lit44);
    if (Scheme.numGEq.apply2(paramObject2, paramObject3) != Boolean.FALSE) {
      return pregexpError$V(new Object[] { Lit45 });
    }
    for (;;)
    {
      try
      {
        localCharSequence = (CharSequence)paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        CharSequence localCharSequence;
        int i;
        boolean bool;
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject2).intValue();
        i = strings.stringRef(localCharSequence, i);
        if (characters.isChar$Eq(Char.make(i), Lit9))
        {
          localBoolean = Boolean.TRUE;
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          break;
        }
        if (unicode.isCharAlphabetic(Char.make(i)))
        {
          paramObject2 = AddOp.$Pl.apply2(paramObject2, Lit8);
          localPair = lists.cons(Char.make(i), localPair);
          break;
        }
        if (characters.isChar$Eq(Char.make(i), Lit44)) {
          paramObject3 = Scheme.numGEq.apply2(AddOp.$Pl.apply2(paramObject2, Lit8), paramObject3);
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject2);
      }
      try
      {
        bool = ((Boolean)paramObject3).booleanValue();
        if (bool)
        {
          if (!bool) {
            continue;
          }
          return pregexpError$V(new Object[] { Lit45 });
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "x", -2, paramObject3);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject1;
        paramObject1 = AddOp.$Pl.apply2(paramObject2, Lit8);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
      }
      try
      {
        i = ((Number)paramObject1).intValue();
        if (!characters.isChar$Eq(Char.make(strings.stringRef((CharSequence)paramObject3, i)), Lit46)) {
          continue;
        }
        paramObject1 = pregexpReverse$Ex(localPair);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "string-ref", 2, paramObject1);
      }
      try
      {
        paramObject3 = (LList)paramObject1;
        paramObject3 = misc.string$To$Symbol(strings.list$To$String((LList)paramObject3));
        paramObject1 = paramObject3;
        if (localBoolean != Boolean.FALSE) {
          paramObject1 = LList.list2(Lit17, paramObject3);
        }
        return LList.list2(paramObject1, AddOp.$Pl.apply2(paramObject2, Lit16));
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "list->string", 1, paramObject1);
      }
    }
    return pregexpError$V(new Object[] { Lit45 });
  }
  
  /* Error */
  public static Object pregexpReadSubpattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 1008	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   3: astore 6
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokestatic 1205	gnu/kawa/slib/pregexp:pregexpReadClusterType	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: astore_1
    //   12: getstatic 981	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   15: aload_1
    //   16: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 5
    //   21: aload_0
    //   22: getstatic 1163	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   25: aload_1
    //   26: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: aload_2
    //   30: invokestatic 1021	gnu/kawa/slib/pregexp:pregexpReadPattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore 7
    //   35: aload 6
    //   37: putstatic 1008	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   40: getstatic 981	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   43: aload 7
    //   45: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore_1
    //   49: getstatic 1163	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   52: aload 7
    //   54: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore 6
    //   59: getstatic 1144	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   62: aload 6
    //   64: aload_2
    //   65: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: astore_2
    //   69: aload_2
    //   70: checkcast 392	java/lang/Boolean
    //   73: invokevirtual 902	java/lang/Boolean:booleanValue	()Z
    //   76: istore 4
    //   78: iload 4
    //   80: ifeq +60 -> 140
    //   83: aload_0
    //   84: checkcast 910	java/lang/CharSequence
    //   87: astore_2
    //   88: aload 6
    //   90: checkcast 912	java/lang/Number
    //   93: invokevirtual 916	java/lang/Number:intValue	()I
    //   96: istore_3
    //   97: aload_2
    //   98: iload_3
    //   99: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   102: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   105: getstatic 331	gnu/kawa/slib/pregexp:Lit6	Lgnu/text/Char;
    //   108: invokestatic 957	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   111: ifeq +37 -> 148
    //   114: aload 5
    //   116: astore_0
    //   117: aload_0
    //   118: invokestatic 1071	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   121: ifeq +41 -> 162
    //   124: aload_1
    //   125: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   128: aload 6
    //   130: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   133: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: invokestatic 1024	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   139: areturn
    //   140: aload 5
    //   142: astore_0
    //   143: iload 4
    //   145: ifne -28 -> 117
    //   148: iconst_1
    //   149: anewarray 999	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: getstatic 559	gnu/kawa/slib/pregexp:Lit64	Lgnu/mapping/SimpleSymbol;
    //   157: aastore
    //   158: invokestatic 1111	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   161: areturn
    //   162: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   165: aload_0
    //   166: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: astore_2
    //   170: getstatic 981	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   173: aload_0
    //   174: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: aload_1
    //   178: invokestatic 1024	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   181: astore_1
    //   182: aload_2
    //   183: astore_0
    //   184: goto -67 -> 117
    //   187: astore_0
    //   188: new 933	gnu/mapping/WrongType
    //   191: dup
    //   192: aload_0
    //   193: ldc_w 935
    //   196: bipush -2
    //   198: aload_2
    //   199: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: astore_1
    //   204: new 933	gnu/mapping/WrongType
    //   207: dup
    //   208: aload_1
    //   209: ldc_w 940
    //   212: iconst_1
    //   213: aload_0
    //   214: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    //   218: astore_0
    //   219: new 933	gnu/mapping/WrongType
    //   222: dup
    //   223: aload_0
    //   224: ldc_w 940
    //   227: iconst_2
    //   228: aload 6
    //   230: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramObject1	Object
    //   0	234	1	paramObject2	Object
    //   0	234	2	paramObject3	Object
    //   96	3	3	i	int
    //   76	68	4	bool	boolean
    //   19	122	5	localObject1	Object
    //   3	226	6	localObject2	Object
    //   33	20	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	78	187	java/lang/ClassCastException
    //   83	88	203	java/lang/ClassCastException
    //   88	97	218	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object pregexpReplace(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 910	java/lang/CharSequence
    //   4: astore 6
    //   6: aload 6
    //   8: invokestatic 1012	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   11: istore_3
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_2
    //   15: anewarray 999	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: getstatic 403	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: iload_3
    //   27: invokestatic 1018	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: invokestatic 1208	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   34: astore 6
    //   36: aload 6
    //   38: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   41: if_acmpne +5 -> 46
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: checkcast 910	java/lang/CharSequence
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 1012	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   55: istore 4
    //   57: getstatic 1211	kawa/lib/lists:caar	Lgnu/expr/GenericProc;
    //   60: aload 6
    //   62: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: astore 7
    //   67: getstatic 1214	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   70: aload 6
    //   72: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore_0
    //   76: aload_1
    //   77: checkcast 910	java/lang/CharSequence
    //   80: astore 8
    //   82: aload 7
    //   84: checkcast 912	java/lang/Number
    //   87: invokevirtual 916	java/lang/Number:intValue	()I
    //   90: istore 5
    //   92: aload 8
    //   94: iconst_0
    //   95: iload 5
    //   97: invokestatic 1093	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   100: astore 7
    //   102: aload_1
    //   103: aload_2
    //   104: iload 4
    //   106: invokestatic 1018	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aload 6
    //   111: invokestatic 1217	gnu/kawa/slib/pregexp:pregexpReplaceAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: astore_2
    //   115: aload_1
    //   116: checkcast 910	java/lang/CharSequence
    //   119: astore 6
    //   121: aload_0
    //   122: checkcast 912	java/lang/Number
    //   125: invokevirtual 916	java/lang/Number:intValue	()I
    //   128: istore 4
    //   130: iconst_3
    //   131: anewarray 999	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload 7
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_2
    //   142: aastore
    //   143: dup
    //   144: iconst_2
    //   145: aload 6
    //   147: iload 4
    //   149: iload_3
    //   150: invokestatic 1093	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   153: aastore
    //   154: invokestatic 1221	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   157: areturn
    //   158: astore_0
    //   159: new 933	gnu/mapping/WrongType
    //   162: dup
    //   163: aload_0
    //   164: ldc_w 1026
    //   167: iconst_1
    //   168: aload_1
    //   169: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   172: athrow
    //   173: astore_0
    //   174: new 933	gnu/mapping/WrongType
    //   177: dup
    //   178: aload_0
    //   179: ldc_w 1026
    //   182: iconst_1
    //   183: aload_2
    //   184: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: astore_0
    //   189: new 933	gnu/mapping/WrongType
    //   192: dup
    //   193: aload_0
    //   194: ldc_w 1096
    //   197: iconst_1
    //   198: aload_1
    //   199: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: astore_0
    //   204: new 933	gnu/mapping/WrongType
    //   207: dup
    //   208: aload_0
    //   209: ldc_w 1096
    //   212: iconst_3
    //   213: aload 7
    //   215: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: astore_0
    //   220: new 933	gnu/mapping/WrongType
    //   223: dup
    //   224: aload_0
    //   225: ldc_w 1096
    //   228: iconst_1
    //   229: aload_1
    //   230: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   233: athrow
    //   234: astore_1
    //   235: new 933	gnu/mapping/WrongType
    //   238: dup
    //   239: aload_1
    //   240: ldc_w 1096
    //   243: iconst_2
    //   244: aload_0
    //   245: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramObject1	Object
    //   0	249	1	paramObject2	Object
    //   0	249	2	paramObject3	Object
    //   11	139	3	i	int
    //   55	93	4	j	int
    //   90	6	5	k	int
    //   4	142	6	localObject1	Object
    //   65	149	7	localObject2	Object
    //   80	13	8	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   0	6	158	java/lang/ClassCastException
    //   46	51	173	java/lang/ClassCastException
    //   76	82	188	java/lang/ClassCastException
    //   82	92	203	java/lang/ClassCastException
    //   115	121	219	java/lang/ClassCastException
    //   121	130	234	java/lang/ClassCastException
  }
  
  public static Object pregexpReplace$St(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject1 = paramObject1;
    if (strings.isString(paramObject1)) {
      localObject1 = pregexp(paramObject1);
    }
    for (;;)
    {
      try
      {
        paramObject1 = (CharSequence)paramObject2;
        i = strings.stringLength((CharSequence)paramObject1);
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          int i;
          localCharSequence = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          int j;
          Object localObject2;
          Object localObject4;
          Object localObject3;
          CharSequence localCharSequence;
          int k;
          int m;
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
        }
        try
        {
          k = ((Number)paramObject1).intValue();
          paramObject1 = lists.caar.apply1(localObject4);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "substring", 2, paramObject1);
        }
        try
        {
          m = ((Number)paramObject1).intValue();
          localObject2 = strings.stringAppend(new Object[] { localObject2, strings.substring(localCharSequence, k, m), pregexpReplaceAux(paramObject2, paramObject3, Integer.valueOf(j), localObject4) });
          paramObject1 = localObject3;
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "substring", 3, paramObject1);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
      }
      try
      {
        paramObject1 = (CharSequence)paramObject3;
        j = strings.stringLength((CharSequence)paramObject1);
        paramObject1 = Lit73;
        localObject2 = "";
        if (Scheme.numGEq.apply2(paramObject1, Integer.valueOf(i)) != Boolean.FALSE) {
          return localObject2;
        }
        localObject4 = pregexpMatchPositions$V(localObject1, paramObject2, new Object[] { paramObject1, Integer.valueOf(i) });
        if (localObject4 == Boolean.FALSE) {
          if (Scheme.numEqu.apply2(paramObject1, Lit73) != Boolean.FALSE) {
            return paramObject2;
          }
        }
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject3);
      }
      try
      {
        paramObject3 = (CharSequence)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
      }
      try
      {
        j = ((Number)paramObject1).intValue();
        paramObject2 = strings.stringAppend(new Object[] { localObject2, strings.substring((CharSequence)paramObject3, j, i) });
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "substring", 2, paramObject1);
      }
    }
    localObject3 = lists.cdar.apply1(localObject4);
  }
  
  public static Object pregexpReplaceAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    localObject2 = Lit73;
    for (Object localObject1 = "";; localObject1 = strings.stringAppend(new Object[] { localObject1, strings.$make$string$(new Object[] { Char.make(i) }) }))
    {
      for (;;)
      {
        if (Scheme.numGEq.apply2(localObject2, paramObject3) != Boolean.FALSE) {
          return localObject1;
        }
        Object localObject3;
        Object localObject4;
        Object localObject5;
        for (;;)
        {
          try
          {
            localObject3 = (CharSequence)paramObject2;
          }
          catch (ClassCastException paramObject1)
          {
            int i;
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
          }
          try
          {
            i = ((Number)localObject2).intValue();
            i = strings.stringRef((CharSequence)localObject3, i);
            if (characters.isChar$Eq(Char.make(i), Lit19))
            {
              localObject4 = pregexpReadEscapedNumber(paramObject2, localObject2, paramObject3);
              if (localObject4 != Boolean.FALSE)
              {
                localObject3 = lists.car.apply1(localObject4);
                if (localObject4 == Boolean.FALSE) {
                  continue;
                }
                localObject2 = lists.cadr.apply1(localObject4);
                if (localObject3 != Boolean.FALSE) {
                  continue;
                }
              }
            }
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
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
            i = ((Number)localObject2).intValue();
            i = strings.stringRef((CharSequence)localObject3, i);
            localObject2 = AddOp.$Pl.apply2(localObject2, Lit8);
            if (characters.isChar$Eq(Char.make(i), Lit11)) {
              break;
            }
            try
            {
              localObject5 = (CharSequence)paramObject2;
              localObject3 = AddOp.$Pl.apply2(localObject2, Lit8);
            }
            catch (ClassCastException paramObject1)
            {
              int j;
              throw new WrongType((ClassCastException)paramObject1, "string-ref", 1, paramObject2);
            }
            try
            {
              i = ((Number)localObject3).intValue();
              if (characters.isChar$Eq(Char.make(strings.stringRef((CharSequence)localObject5, i)), Lit113))
              {
                localObject3 = Lit73;
                continue;
              }
              localObject3 = Boolean.FALSE;
            }
            catch (ClassCastException paramObject1)
            {
              throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject3);
            }
            if (localObject3 != Boolean.FALSE)
            {
              localObject2 = AddOp.$Pl.apply2(localObject2, Lit16);
              continue;
            }
            localObject2 = AddOp.$Pl.apply2(localObject2, Lit8);
          }
          catch (ClassCastException paramObject1)
          {
            throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject2);
          }
          localObject1 = strings.stringAppend(new Object[] { localObject1, strings.$make$string$(new Object[] { Char.make(i) }) });
          continue;
          localObject4 = pregexpListRef(paramObject4, localObject3);
          localObject3 = localObject1;
          if (localObject4 == Boolean.FALSE) {}
        }
        try
        {
          localObject3 = (CharSequence)paramObject1;
          localObject5 = lists.car.apply1(localObject4);
        }
        catch (ClassCastException paramObject2)
        {
          throw new WrongType((ClassCastException)paramObject2, "substring", 1, paramObject1);
        }
        try
        {
          i = ((Number)localObject5).intValue();
          localObject4 = lists.cdr.apply1(localObject4);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject5);
        }
        try
        {
          j = ((Number)localObject4).intValue();
          localObject3 = strings.stringAppend(new Object[] { localObject1, strings.substring((CharSequence)localObject3, i, j) });
          localObject1 = localObject3;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject4);
        }
      }
      localObject2 = AddOp.$Pl.apply2(localObject2, Lit8);
    }
  }
  
  public static Object pregexpReverse$Ex(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    for (;;)
    {
      if (lists.isNull(paramObject)) {
        return localObject1;
      }
      Object localObject2 = lists.cdr.apply1(paramObject);
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCdr$Ex(localPair, localObject1);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject);
      }
    }
  }
  
  public static Object pregexpSplit(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      try
      {
        localObject1 = (CharSequence)paramObject2;
        i = strings.stringLength((CharSequence)localObject1);
        localObject1 = Lit73;
        localObject3 = LList.Empty;
        localObject2 = Boolean.FALSE;
      }
      catch (ClassCastException paramObject1)
      {
        try
        {
          bool = ((Boolean)localObject6).booleanValue();
          if (bool)
          {
            if (localObject2 != Boolean.FALSE)
            {
              localObject2 = Boolean.FALSE;
              localObject1 = localObject4;
            }
          }
          else {
            if (bool) {
              continue;
            }
          }
        }
        catch (ClassCastException paramObject1)
        {
          int i;
          Object localObject3;
          Object localObject2;
          Object localObject4;
          Object localObject6;
          throw new WrongType((ClassCastException)paramObject1, "x", -2, localObject6);
        }
        try
        {
          localObject2 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
        }
        try
        {
          j = ((Number)localObject1).intValue();
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject1);
        }
        try
        {
          k = ((Number)localObject5).intValue();
          localObject3 = lists.cons(strings.substring((CharSequence)localObject2, j, k), localObject3);
          localObject2 = Boolean.FALSE;
          localObject1 = localObject4;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject5);
        }
        try
        {
          localObject2 = (CharSequence)paramObject2;
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          localObject3 = lists.cons(strings.substring((CharSequence)localObject2, j, i), localObject3);
          localObject2 = Boolean.FALSE;
          localObject1 = Integer.valueOf(i);
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject1);
        }
        paramObject1 = paramObject1;
        throw new WrongType((ClassCastException)paramObject1, "string-length", 1, paramObject2);
      }
      if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
        return pregexpReverse$Ex(localObject3);
      }
      localObject4 = pregexpMatchPositions$V(paramObject1, paramObject2, new Object[] { localObject1, Integer.valueOf(i) });
      if (localObject4 == Boolean.FALSE) {
        continue;
      }
      localObject4 = lists.car.apply1(localObject4);
      localObject5 = lists.car.apply1(localObject4);
      localObject4 = lists.cdr.apply1(localObject4);
      if (Scheme.numEqu.apply2(localObject5, localObject4) != Boolean.FALSE) {
        localObject2 = AddOp.$Pl.apply2(localObject4, Lit8);
      }
      try
      {
        localObject4 = (CharSequence)paramObject2;
      }
      catch (ClassCastException paramObject1)
      {
        int j;
        int k;
        boolean bool;
        throw new WrongType((ClassCastException)paramObject1, "substring", 1, paramObject2);
      }
      try
      {
        j = ((Number)localObject1).intValue();
        localObject1 = AddOp.$Pl.apply2(localObject5, Lit8);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "substring", 2, localObject1);
      }
      try
      {
        k = ((Number)localObject1).intValue();
        localObject3 = lists.cons(strings.substring((CharSequence)localObject4, j, k), localObject3);
        localObject4 = Boolean.TRUE;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "substring", 3, localObject1);
      }
    }
    localObject6 = Scheme.numEqu.apply2(localObject5, localObject1);
  }
  
  public static Object pregexpStringMatch(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    try
    {
      localObject1 = (CharSequence)paramObject1;
      i = strings.stringLength((CharSequence)localObject1);
      if (Scheme.numGrt.apply2(Integer.valueOf(i), paramObject4) != Boolean.FALSE) {
        return Scheme.applyToArgs.apply1(paramObject6);
      }
      localObject1 = Lit73;
    }
    catch (ClassCastException paramObject2)
    {
      for (;;)
      {
        Object localObject1;
        try
        {
          int i;
          localObject2 = (CharSequence)paramObject1;
        }
        catch (ClassCastException paramObject2)
        {
          Object localObject2;
          int j;
          CharSequence localCharSequence;
          throw new WrongType((ClassCastException)paramObject2, "string-ref", 1, paramObject1);
        }
        try
        {
          j = ((Number)localObject1).intValue();
          localObject2 = Char.make(strings.stringRef((CharSequence)localObject2, j));
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, localObject1);
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
          j = ((Number)paramObject3).intValue();
          if (characters.isChar$Eq((Char)localObject2, Char.make(strings.stringRef(localCharSequence, j))))
          {
            localObject1 = AddOp.$Pl.apply2(localObject1, Lit8);
            paramObject3 = AddOp.$Pl.apply2(paramObject3, Lit8);
          }
          else
          {
            return Scheme.applyToArgs.apply1(paramObject6);
          }
        }
        catch (ClassCastException paramObject1)
        {
          throw new WrongType((ClassCastException)paramObject1, "string-ref", 2, paramObject3);
        }
      }
      paramObject2 = paramObject2;
      throw new WrongType((ClassCastException)paramObject2, "string-length", 1, paramObject1);
    }
    if (Scheme.numGEq.apply2(localObject1, Integer.valueOf(i)) != Boolean.FALSE) {
      return Scheme.applyToArgs.apply2(paramObject5, paramObject3);
    }
    if (Scheme.numGEq.apply2(paramObject3, paramObject4) != Boolean.FALSE) {
      return Scheme.applyToArgs.apply1(paramObject6);
    }
  }
  
  /* Error */
  public static Object pregexpWrapQuantifierIfAny(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 981	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   3: aload_0
    //   4: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: astore 6
    //   9: getstatic 1163	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   12: aload_0
    //   13: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: astore 5
    //   18: getstatic 908	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   21: aload 5
    //   23: aload_2
    //   24: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   30: if_acmpeq +5 -> 35
    //   33: aload_0
    //   34: areturn
    //   35: aload_1
    //   36: checkcast 910	java/lang/CharSequence
    //   39: astore 7
    //   41: aload 5
    //   43: checkcast 912	java/lang/Number
    //   46: invokevirtual 916	java/lang/Number:intValue	()I
    //   49: istore_3
    //   50: aload 7
    //   52: iload_3
    //   53: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   56: istore_3
    //   57: iload_3
    //   58: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   61: invokestatic 1196	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   64: istore 4
    //   66: iload 4
    //   68: ifeq +28 -> 96
    //   71: getstatic 1008	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   74: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: if_acmpne +24 -> 101
    //   80: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   83: aload 5
    //   85: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   88: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: astore 5
    //   93: goto -75 -> 18
    //   96: iload 4
    //   98: ifne -18 -> 80
    //   101: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   104: iload_3
    //   105: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   108: getstatic 311	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   111: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: astore 7
    //   116: aload 7
    //   118: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   121: if_acmpeq +182 -> 303
    //   124: aload 7
    //   126: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   129: if_acmpeq -96 -> 33
    //   132: getstatic 390	gnu/kawa/slib/pregexp:Lit68	Lgnu/mapping/SimpleSymbol;
    //   135: invokestatic 1186	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   138: astore 7
    //   140: aload 7
    //   142: getstatic 555	gnu/kawa/slib/pregexp:Lit69	Lgnu/mapping/SimpleSymbol;
    //   145: getstatic 551	gnu/kawa/slib/pregexp:Lit70	Lgnu/mapping/SimpleSymbol;
    //   148: getstatic 547	gnu/kawa/slib/pregexp:Lit71	Lgnu/mapping/SimpleSymbol;
    //   151: aload 6
    //   153: invokestatic 1251	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   156: pop
    //   157: aload 7
    //   159: getstatic 543	gnu/kawa/slib/pregexp:Lit72	Lgnu/mapping/SimpleSymbol;
    //   162: invokestatic 1024	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   165: astore 6
    //   167: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   170: iload_3
    //   171: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   174: getstatic 311	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   177: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   183: if_acmpeq +210 -> 393
    //   186: getstatic 1254	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   189: aload 7
    //   191: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: astore_0
    //   195: aload_0
    //   196: checkcast 1049	gnu/lists/Pair
    //   199: astore 8
    //   201: aload 8
    //   203: getstatic 403	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   206: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   209: getstatic 1257	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   212: aload 7
    //   214: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: astore_0
    //   218: aload_0
    //   219: checkcast 1049	gnu/lists/Pair
    //   222: astore 8
    //   224: aload 8
    //   226: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   229: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   232: aload 5
    //   234: astore_0
    //   235: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   238: aload_0
    //   239: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   242: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: astore_0
    //   246: getstatic 908	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   249: aload_0
    //   250: aload_2
    //   251: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   257: if_acmpeq +413 -> 670
    //   260: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   263: aload 7
    //   265: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: astore_1
    //   269: aload_1
    //   270: checkcast 1049	gnu/lists/Pair
    //   273: astore_2
    //   274: aload_2
    //   275: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   278: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   281: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   284: aload 6
    //   286: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   289: astore_1
    //   290: aload_1
    //   291: checkcast 1049	gnu/lists/Pair
    //   294: astore_2
    //   295: aload_2
    //   296: aload_0
    //   297: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   300: aload 6
    //   302: areturn
    //   303: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   306: iload_3
    //   307: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   310: getstatic 313	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   313: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   316: astore 7
    //   318: aload 7
    //   320: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   323: if_acmpeq +14 -> 337
    //   326: aload 7
    //   328: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   331: if_acmpeq -298 -> 33
    //   334: goto -202 -> 132
    //   337: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   340: iload_3
    //   341: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   344: getstatic 309	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   347: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   350: astore 7
    //   352: aload 7
    //   354: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: if_acmpeq +14 -> 371
    //   360: aload 7
    //   362: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   365: if_acmpeq -332 -> 33
    //   368: goto -236 -> 132
    //   371: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   374: iload_3
    //   375: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   378: getstatic 325	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   381: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   387: if_acmpeq -354 -> 33
    //   390: goto -258 -> 132
    //   393: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   396: iload_3
    //   397: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   400: getstatic 313	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   403: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   406: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   409: if_acmpeq +55 -> 464
    //   412: getstatic 1254	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   415: aload 7
    //   417: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   420: astore_0
    //   421: aload_0
    //   422: checkcast 1049	gnu/lists/Pair
    //   425: astore 8
    //   427: aload 8
    //   429: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   432: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   435: getstatic 1257	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   438: aload 7
    //   440: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   443: astore_0
    //   444: aload_0
    //   445: checkcast 1049	gnu/lists/Pair
    //   448: astore 8
    //   450: aload 8
    //   452: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   455: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   458: aload 5
    //   460: astore_0
    //   461: goto -226 -> 235
    //   464: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   467: iload_3
    //   468: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   471: getstatic 309	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   474: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   477: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   480: if_acmpeq +55 -> 535
    //   483: getstatic 1254	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   486: aload 7
    //   488: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   491: astore_0
    //   492: aload_0
    //   493: checkcast 1049	gnu/lists/Pair
    //   496: astore 8
    //   498: aload 8
    //   500: getstatic 403	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   503: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   506: getstatic 1257	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   509: aload 7
    //   511: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   514: astore_0
    //   515: aload_0
    //   516: checkcast 1049	gnu/lists/Pair
    //   519: astore 8
    //   521: aload 8
    //   523: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   526: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   529: aload 5
    //   531: astore_0
    //   532: goto -297 -> 235
    //   535: aload 5
    //   537: astore_0
    //   538: getstatic 993	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   541: iload_3
    //   542: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   545: getstatic 325	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   548: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   554: if_acmpeq -319 -> 235
    //   557: aload_1
    //   558: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   561: aload 5
    //   563: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   566: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: aload_2
    //   570: invokestatic 1259	gnu/kawa/slib/pregexp:pregexpReadNums	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: astore_0
    //   574: aload_0
    //   575: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   578: if_acmpne +23 -> 601
    //   581: iconst_2
    //   582: anewarray 999	java/lang/Object
    //   585: dup
    //   586: iconst_0
    //   587: getstatic 539	gnu/kawa/slib/pregexp:Lit74	Lgnu/mapping/SimpleSymbol;
    //   590: aastore
    //   591: dup
    //   592: iconst_1
    //   593: getstatic 535	gnu/kawa/slib/pregexp:Lit75	Lgnu/mapping/SimpleSymbol;
    //   596: aastore
    //   597: invokestatic 1111	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   600: pop
    //   601: getstatic 1254	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   604: aload 7
    //   606: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   609: astore 5
    //   611: aload 5
    //   613: checkcast 1049	gnu/lists/Pair
    //   616: astore 8
    //   618: aload 8
    //   620: getstatic 981	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   623: aload_0
    //   624: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   627: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   630: getstatic 1257	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   633: aload 7
    //   635: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   638: astore 5
    //   640: aload 5
    //   642: checkcast 1049	gnu/lists/Pair
    //   645: astore 8
    //   647: aload 8
    //   649: getstatic 1163	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   652: aload_0
    //   653: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   656: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   659: getstatic 1262	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   662: aload_0
    //   663: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   666: astore_0
    //   667: goto -432 -> 235
    //   670: aload_1
    //   671: checkcast 910	java/lang/CharSequence
    //   674: astore 5
    //   676: aload_0
    //   677: checkcast 912	java/lang/Number
    //   680: invokevirtual 916	java/lang/Number:intValue	()I
    //   683: istore_3
    //   684: aload 5
    //   686: iload_3
    //   687: invokestatic 922	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   690: istore_3
    //   691: iload_3
    //   692: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   695: invokestatic 1196	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   698: istore 4
    //   700: iload 4
    //   702: ifeq +26 -> 728
    //   705: getstatic 1008	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   708: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   711: if_acmpne +22 -> 733
    //   714: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   717: aload_0
    //   718: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   721: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   724: astore_0
    //   725: goto -479 -> 246
    //   728: iload 4
    //   730: ifne -16 -> 714
    //   733: iload_3
    //   734: invokestatic 303	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   737: getstatic 309	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   740: invokestatic 957	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   743: ifeq +55 -> 798
    //   746: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   749: aload 7
    //   751: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   754: astore_1
    //   755: aload_1
    //   756: checkcast 1049	gnu/lists/Pair
    //   759: astore_2
    //   760: aload_2
    //   761: getstatic 905	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   764: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   767: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   770: aload 6
    //   772: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   775: astore_1
    //   776: aload_1
    //   777: checkcast 1049	gnu/lists/Pair
    //   780: astore_2
    //   781: aload_2
    //   782: getstatic 1074	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   785: aload_0
    //   786: getstatic 697	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   789: invokevirtual 898	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   792: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   795: goto -495 -> 300
    //   798: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   801: aload 7
    //   803: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   806: astore_1
    //   807: aload_1
    //   808: checkcast 1049	gnu/lists/Pair
    //   811: astore_2
    //   812: aload_2
    //   813: getstatic 396	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   816: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   819: getstatic 987	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   822: aload 6
    //   824: invokevirtual 984	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   827: astore_1
    //   828: aload_1
    //   829: checkcast 1049	gnu/lists/Pair
    //   832: astore_2
    //   833: aload_2
    //   834: aload_0
    //   835: invokestatic 1065	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   838: goto -538 -> 300
    //   841: astore_0
    //   842: new 933	gnu/mapping/WrongType
    //   845: dup
    //   846: aload_0
    //   847: ldc_w 940
    //   850: iconst_1
    //   851: aload_1
    //   852: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   855: athrow
    //   856: astore_0
    //   857: new 933	gnu/mapping/WrongType
    //   860: dup
    //   861: aload_0
    //   862: ldc_w 940
    //   865: iconst_2
    //   866: aload 5
    //   868: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   871: athrow
    //   872: astore_1
    //   873: new 933	gnu/mapping/WrongType
    //   876: dup
    //   877: aload_1
    //   878: ldc_w 1067
    //   881: iconst_1
    //   882: aload_0
    //   883: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   886: athrow
    //   887: astore_1
    //   888: new 933	gnu/mapping/WrongType
    //   891: dup
    //   892: aload_1
    //   893: ldc_w 1067
    //   896: iconst_1
    //   897: aload_0
    //   898: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   901: athrow
    //   902: astore_1
    //   903: new 933	gnu/mapping/WrongType
    //   906: dup
    //   907: aload_1
    //   908: ldc_w 1067
    //   911: iconst_1
    //   912: aload_0
    //   913: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   916: athrow
    //   917: astore_1
    //   918: new 933	gnu/mapping/WrongType
    //   921: dup
    //   922: aload_1
    //   923: ldc_w 1067
    //   926: iconst_1
    //   927: aload_0
    //   928: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   931: athrow
    //   932: astore_1
    //   933: new 933	gnu/mapping/WrongType
    //   936: dup
    //   937: aload_1
    //   938: ldc_w 1067
    //   941: iconst_1
    //   942: aload_0
    //   943: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   946: athrow
    //   947: astore_1
    //   948: new 933	gnu/mapping/WrongType
    //   951: dup
    //   952: aload_1
    //   953: ldc_w 1067
    //   956: iconst_1
    //   957: aload_0
    //   958: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   961: athrow
    //   962: astore_0
    //   963: new 933	gnu/mapping/WrongType
    //   966: dup
    //   967: aload_0
    //   968: ldc_w 1067
    //   971: iconst_1
    //   972: aload 5
    //   974: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   977: athrow
    //   978: astore_0
    //   979: new 933	gnu/mapping/WrongType
    //   982: dup
    //   983: aload_0
    //   984: ldc_w 1067
    //   987: iconst_1
    //   988: aload 5
    //   990: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   993: athrow
    //   994: astore_0
    //   995: new 933	gnu/mapping/WrongType
    //   998: dup
    //   999: aload_0
    //   1000: ldc_w 1067
    //   1003: iconst_1
    //   1004: aload_1
    //   1005: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1008: athrow
    //   1009: astore_0
    //   1010: new 933	gnu/mapping/WrongType
    //   1013: dup
    //   1014: aload_0
    //   1015: ldc_w 1067
    //   1018: iconst_1
    //   1019: aload_1
    //   1020: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1023: athrow
    //   1024: astore_0
    //   1025: new 933	gnu/mapping/WrongType
    //   1028: dup
    //   1029: aload_0
    //   1030: ldc_w 940
    //   1033: iconst_1
    //   1034: aload_1
    //   1035: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1038: athrow
    //   1039: astore_1
    //   1040: new 933	gnu/mapping/WrongType
    //   1043: dup
    //   1044: aload_1
    //   1045: ldc_w 940
    //   1048: iconst_2
    //   1049: aload_0
    //   1050: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1053: athrow
    //   1054: astore_0
    //   1055: new 933	gnu/mapping/WrongType
    //   1058: dup
    //   1059: aload_0
    //   1060: ldc_w 1067
    //   1063: iconst_1
    //   1064: aload_1
    //   1065: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1068: athrow
    //   1069: astore_0
    //   1070: new 933	gnu/mapping/WrongType
    //   1073: dup
    //   1074: aload_0
    //   1075: ldc_w 1067
    //   1078: iconst_1
    //   1079: aload_1
    //   1080: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1083: athrow
    //   1084: astore_0
    //   1085: new 933	gnu/mapping/WrongType
    //   1088: dup
    //   1089: aload_0
    //   1090: ldc_w 1067
    //   1093: iconst_1
    //   1094: aload_1
    //   1095: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1098: athrow
    //   1099: astore_0
    //   1100: new 933	gnu/mapping/WrongType
    //   1103: dup
    //   1104: aload_0
    //   1105: ldc_w 1067
    //   1108: iconst_1
    //   1109: aload_1
    //   1110: invokespecial 938	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	paramObject1	Object
    //   0	1114	1	paramObject2	Object
    //   0	1114	2	paramObject3	Object
    //   49	685	3	i	int
    //   64	665	4	bool	boolean
    //   16	973	5	localObject1	Object
    //   7	816	6	localObject2	Object
    //   39	763	7	localObject3	Object
    //   199	449	8	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   35	41	841	java/lang/ClassCastException
    //   41	50	856	java/lang/ClassCastException
    //   195	201	872	java/lang/ClassCastException
    //   218	224	887	java/lang/ClassCastException
    //   421	427	902	java/lang/ClassCastException
    //   444	450	917	java/lang/ClassCastException
    //   492	498	932	java/lang/ClassCastException
    //   515	521	947	java/lang/ClassCastException
    //   611	618	962	java/lang/ClassCastException
    //   640	647	978	java/lang/ClassCastException
    //   269	274	994	java/lang/ClassCastException
    //   290	295	1009	java/lang/ClassCastException
    //   670	676	1024	java/lang/ClassCastException
    //   676	684	1039	java/lang/ClassCastException
    //   755	760	1054	java/lang/ClassCastException
    //   776	781	1069	java/lang/ClassCastException
    //   807	812	1084	java/lang/ClassCastException
    //   828	833	1099	java/lang/ClassCastException
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply0(paramModuleMethod);
    case 36: 
      return frame.lambda4();
    case 37: 
      return frame0.lambda13();
    case 38: 
      return frame0.lambda14();
    case 39: 
      return frame0.lambda15();
    case 40: 
      return frame0.lambda16();
    }
    return frame0.lambda17();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 16: 
      return pregexpReverse$Ex(paramObject);
    case 28: 
      return pregexpInvertCharList(paramObject);
    case 31: 
      if (isPregexpCharWord(paramObject)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    case 35: 
      return pregexpMakeBackrefList(paramObject);
    case 44: 
      return pregexp(paramObject);
    }
    return pregexpQuote(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 33: 
      return isPregexpCheckIfInCharClass(paramObject1, paramObject2);
    case 34: 
      return pregexpListRef(paramObject1, paramObject2);
    }
    return pregexpSplit(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    case 28: 
    case 30: 
    case 31: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 18: 
      return pregexpReadPattern(paramObject1, paramObject2, paramObject3);
    case 19: 
      return pregexpReadBranch(paramObject1, paramObject2, paramObject3);
    case 20: 
      return pregexpReadPiece(paramObject1, paramObject2, paramObject3);
    case 21: 
      return pregexpReadEscapedNumber(paramObject1, paramObject2, paramObject3);
    case 22: 
      return pregexpReadEscapedChar(paramObject1, paramObject2, paramObject3);
    case 23: 
      return pregexpReadPosixCharClass(paramObject1, paramObject2, paramObject3);
    case 24: 
      return pregexpReadClusterType(paramObject1, paramObject2, paramObject3);
    case 25: 
      return pregexpReadSubpattern(paramObject1, paramObject2, paramObject3);
    case 26: 
      return pregexpWrapQuantifierIfAny(paramObject1, paramObject2, paramObject3);
    case 27: 
      return pregexpReadNums(paramObject1, paramObject2, paramObject3);
    case 29: 
      return pregexpReadCharList(paramObject1, paramObject2, paramObject3);
    case 32: 
      return isPregexpAtWordBoundary(paramObject1, paramObject2, paramObject3);
    case 48: 
      return pregexpReplace(paramObject1, paramObject2, paramObject3);
    }
    return pregexpReplace$St(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 43) {
      return pregexpReplaceAux(paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 17: 
      return pregexpError$V(paramArrayOfObject);
    case 30: 
      return pregexpStringMatch(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 42: 
      return pregexpMatchPositionsAux(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 45: 
      paramModuleMethod = paramArrayOfObject[0];
      localObject = paramArrayOfObject[1];
      i = paramArrayOfObject.length - 2;
      arrayOfObject = new Object[i];
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          return pregexpMatchPositions$V(paramModuleMethod, localObject, arrayOfObject);
        }
        arrayOfObject[i] = paramArrayOfObject[(i + 2)];
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
        return pregexpMatch$V(paramModuleMethod, localObject, arrayOfObject);
      }
      arrayOfObject[i] = paramArrayOfObject[(i + 2)];
    }
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 41: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 40: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 39: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 38: 
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 37: 
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
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 50: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28: 
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
    case 47: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34: 
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
    case 28: 
    case 30: 
    case 31: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    default: 
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 49: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 48: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 32: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 29: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 27: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 26: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 25: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 23: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 22: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 21: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 20: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 19: 
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
    if (paramModuleMethod.selector == 43)
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
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 46: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 45: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 42: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 30: 
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
    $Stpregexp$Mnversion$St = Lit0;
    $Stpregexp$Mncomment$Mnchar$St = Lit1;
    $Stpregexp$Mnnul$Mnchar$Mnint$St = Integer.valueOf(characters.char$To$Integer(Lit2) - 97);
    $Stpregexp$Mnreturn$Mnchar$St = characters.integer$To$Char(((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue() + 13);
    $Stpregexp$Mntab$Mnchar$St = characters.integer$To$Char(((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue() + 9);
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
  }
  
  public class frame
    extends ModuleBody
  {
    Object backrefs;
    Object case$Mnsensitive$Qu;
    Procedure identity;
    Object n;
    Object s;
    Object sn;
    Object start;
    
    public frame()
    {
      this$1 = new ModuleMethod(this, 15, pregexp.Lit112, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:460");
      this.identity = this$1;
    }
    
    public static Object lambda2identity(Object paramObject)
    {
      return paramObject;
    }
    
    static Boolean lambda4()
    {
      return Boolean.FALSE;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15) {
        return lambda2identity(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object lambda3sub(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    boolean could$Mnloop$Mninfinitely$Qu;
    Object fk;
    Object i;
    final ModuleMethod lambda$Fn11;
    final ModuleMethod lambda$Fn12;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    final ModuleMethod lambda$Fn4;
    final ModuleMethod lambda$Fn5;
    boolean maximal$Qu;
    Object old;
    Object p;
    Object q;
    Object re;
    Object re$1;
    Object sk;
    pregexp.frame staticLink;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 9, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:513");
      this.lambda$Fn2 = this$1;
      this$1 = new ModuleMethod(this, 10, null, 0);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:514");
      this.lambda$Fn3 = this$1;
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:541");
      this.lambda$Fn4 = this$1;
      this$1 = new ModuleMethod(this, 12, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:545");
      this.lambda$Fn5 = this$1;
      this$1 = new ModuleMethod(this, 13, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:587");
      this.lambda$Fn11 = this$1;
      this$1 = new ModuleMethod(this, 14, null, 0);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:590");
      this.lambda$Fn12 = this$1;
    }
    
    static Boolean lambda13()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda14()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda15()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda16()
    {
      return Boolean.FALSE;
    }
    
    static Boolean lambda17()
    {
      return Boolean.FALSE;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply0(paramModuleMethod);
      case 10: 
        return lambda10();
      }
      return lambda19();
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 10: 
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 9: 
        return lambda9(paramObject);
      case 11: 
        return lambda11(paramObject);
      case 12: 
        return lambda12(paramObject);
      }
      return lambda18(paramObject);
    }
    
    Object lambda10()
    {
      return Scheme.applyToArgs.apply2(this.sk, AddOp.$Pl.apply2(this.i, pregexp.Lit8));
    }
    
    Object lambda11(Object paramObject)
    {
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }
    
    Object lambda12(Object paramObject)
    {
      Object localObject = lists.assv(this.re$1, this.staticLink.backrefs);
      try
      {
        Pair localPair = (Pair)localObject;
        lists.setCdr$Ex(localPair, lists.cons(this.i, paramObject));
        return Scheme.applyToArgs.apply2(this.sk, paramObject);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "set-cdr!", 1, localObject);
      }
    }
    
    Object lambda18(Object paramObject)
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }
    
    Object lambda19()
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply1(this.fk);
    }
    
    public Object lambda5loupOneOfChars(Object paramObject)
    {
      pregexp.frame1 localframe1 = new pregexp.frame1();
      localframe1.staticLink = this;
      localframe1.chars = paramObject;
      if (lists.isNull(localframe1.chars)) {
        return Scheme.applyToArgs.apply1(this.fk);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe1.chars), this.i, this.sk, localframe1.lambda$Fn13);
    }
    
    public Object lambda6loupSeq(Object paramObject1, Object paramObject2)
    {
      pregexp.frame2 localframe2 = new pregexp.frame2();
      localframe2.staticLink = this;
      localframe2.res = paramObject1;
      if (lists.isNull(localframe2.res)) {
        return Scheme.applyToArgs.apply2(this.sk, paramObject2);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe2.res), paramObject2, localframe2.lambda$Fn14, this.fk);
    }
    
    public Object lambda7loupOr(Object paramObject)
    {
      pregexp.frame3 localframe3 = new pregexp.frame3();
      localframe3.staticLink = this;
      localframe3.res = paramObject;
      if (lists.isNull(localframe3.res)) {
        return Scheme.applyToArgs.apply1(this.fk);
      }
      return this.staticLink.lambda3sub(lists.car.apply1(localframe3.res), this.i, localframe3.lambda$Fn15, localframe3.lambda$Fn16);
    }
    
    public Object lambda8loupP(Object paramObject1, Object paramObject2)
    {
      pregexp.frame4 localframe4 = new pregexp.frame4();
      localframe4.staticLink = this;
      localframe4.k = paramObject1;
      localframe4.i = paramObject2;
      if (Scheme.numLss.apply2(localframe4.k, this.p) != Boolean.FALSE) {
        return this.staticLink.lambda3sub(this.re, localframe4.i, localframe4.lambda$Fn17, this.fk);
      }
      if (this.q != Boolean.FALSE) {}
      for (paramObject1 = AddOp.$Mn.apply2(this.q, this.p);; paramObject1 = this.q)
      {
        localframe4.q = paramObject1;
        return localframe4.lambda24loupQ(pregexp.Lit73, localframe4.i);
      }
    }
    
    Object lambda9(Object paramObject)
    {
      return Scheme.applyToArgs.apply1(this.fk);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match0(paramModuleMethod, paramCallContext);
      case 14: 
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
      switch (paramModuleMethod.selector)
      {
      case 10: 
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 13: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 12: 
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 11: 
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
  
  public class frame1
    extends ModuleBody
  {
    Object chars;
    final ModuleMethod lambda$Fn13;
    pregexp.frame0 staticLink;
    
    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 0);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:508");
      this.lambda$Fn13 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda20();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda20()
    {
      return this.staticLink.lambda5loupOneOfChars(lists.cdr.apply1(this.chars));
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
  }
  
  public class frame2
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object res;
    pregexp.frame0 staticLink;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:519");
      this.lambda$Fn14 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda21(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda21(Object paramObject)
    {
      return this.staticLink.lambda6loupSeq(lists.cdr.apply1(this.res), paramObject);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame3
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object res;
    pregexp.frame0 staticLink;
    
    public frame3()
    {
      this$1 = new ModuleMethod(this, 3, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:526");
      this.lambda$Fn15 = this$1;
      this$1 = new ModuleMethod(this, 4, null, 0);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:529");
      this.lambda$Fn16 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda23();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda22(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda22(Object paramObject)
    {
      paramObject = Scheme.applyToArgs.apply2(this.staticLink.sk, paramObject);
      if (paramObject != Boolean.FALSE) {
        return paramObject;
      }
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }
    
    Object lambda23()
    {
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame4
    extends ModuleBody
  {
    Object i;
    Object k;
    final ModuleMethod lambda$Fn17;
    Object q;
    pregexp.frame0 staticLink;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:602");
      this.lambda$Fn17 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda25(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    public Object lambda24loupQ(Object paramObject1, Object paramObject2)
    {
      pregexp.frame5 localframe5 = new pregexp.frame5();
      localframe5.staticLink = this;
      localframe5.k = paramObject1;
      localframe5.i = paramObject2;
      localframe5.fk = localframe5.fk;
      if (this.q != Boolean.FALSE)
      {
        if (Scheme.numGEq.apply2(localframe5.k, this.q) == Boolean.FALSE) {
          break label78;
        }
        paramObject1 = localframe5.lambda26fk();
      }
      label78:
      do
      {
        return paramObject1;
        if (this.q != Boolean.FALSE) {
          break;
        }
        if (this.staticLink.maximal$Qu) {
          return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn18, localframe5.fk);
        }
        paramObject2 = localframe5.lambda26fk();
        paramObject1 = paramObject2;
      } while (paramObject2 != Boolean.FALSE);
      return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn19, localframe5.fk);
    }
    
    Object lambda25(Object paramObject)
    {
      if (this.staticLink.could$Mnloop$Mninfinitely$Qu) {
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE) {}
      }
      for (;;)
      {
        pregexp.pregexpError$V(new Object[] { pregexp.Lit101, pregexp.Lit110 });
        do
        {
          return this.staticLink.lambda8loupP(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
        } while (!this.staticLink.could$Mnloop$Mninfinitely$Qu);
      }
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
  }
  
  public class frame5
    extends ModuleBody
  {
    Procedure fk;
    Object i;
    Object k;
    final ModuleMethod lambda$Fn18;
    final ModuleMethod lambda$Fn19;
    pregexp.frame4 staticLink;
    
    public frame5()
    {
      this$1 = new ModuleMethod(this, 5, pregexp.Lit111, 0);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:612");
      this.fk = this$1;
      this$1 = new ModuleMethod(this, 6, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:617");
      this.lambda$Fn18 = this$1;
      this$1 = new ModuleMethod(this, 7, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/pregexp.scm:628");
      this.lambda$Fn19 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda26fk();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply1(paramModuleMethod, paramObject);
      case 6: 
        return lambda27(paramObject);
      }
      return lambda28(paramObject);
    }
    
    public Object lambda26fk()
    {
      return Scheme.applyToArgs.apply2(this.staticLink.staticLink.sk, this.i);
    }
    
    Object lambda27(Object paramObject)
    {
      if (this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu) {
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE) {}
      }
      for (;;)
      {
        pregexp.pregexpError$V(new Object[] { pregexp.Lit101, pregexp.Lit110 });
        do
        {
          paramObject = this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
          if (paramObject == Boolean.FALSE) {
            break;
          }
          return paramObject;
        } while (!this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu);
      }
      return lambda26fk();
    }
    
    Object lambda28(Object paramObject)
    {
      return this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 7: 
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
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\pregexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */