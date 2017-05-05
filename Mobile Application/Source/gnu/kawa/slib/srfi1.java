package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import kawa.lang.Continuation;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.standard.Scheme;
import kawa.standard.append;
import kawa.standard.call_with_values;

public class srfi1
  extends ModuleBody
{
  public static final Macro $Pcevery;
  public static final int $Pcprovide$Pclist$Mnlib = 123;
  public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
  public static final srfi1 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
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
  static final SimpleSymbol Lit3;
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
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit5;
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
  static final SimpleSymbol Lit6;
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
  static final SimpleSymbol Lit7;
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
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final SimpleSymbol Lit84;
  static final SyntaxRules Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final SimpleSymbol Lit9;
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
  public static final ModuleMethod alist$Mncons;
  public static final ModuleMethod alist$Mncopy;
  public static final ModuleMethod alist$Mndelete;
  public static final ModuleMethod alist$Mndelete$Ex;
  public static final ModuleMethod any;
  public static final ModuleMethod append$Ex;
  public static final ModuleMethod append$Mnmap;
  public static final ModuleMethod append$Mnmap$Ex;
  public static final ModuleMethod append$Mnreverse;
  public static final ModuleMethod append$Mnreverse$Ex;
  public static final ModuleMethod jdField_break;
  public static final ModuleMethod break$Ex;
  public static final ModuleMethod car$Plcdr;
  public static final ModuleMethod circular$Mnlist;
  public static final ModuleMethod circular$Mnlist$Qu;
  public static final ModuleMethod concatenate;
  public static final ModuleMethod concatenate$Ex;
  public static final ModuleMethod cons$St;
  public static final ModuleMethod count;
  public static final ModuleMethod delete;
  public static final ModuleMethod delete$Ex;
  public static final ModuleMethod delete$Mnduplicates;
  public static final ModuleMethod delete$Mnduplicates$Ex;
  public static final ModuleMethod dotted$Mnlist$Qu;
  public static final ModuleMethod drop;
  public static final ModuleMethod drop$Mnright;
  public static final ModuleMethod drop$Mnright$Ex;
  public static final ModuleMethod drop$Mnwhile;
  public static final ModuleMethod eighth;
  public static final ModuleMethod every;
  public static final ModuleMethod fifth;
  public static final ModuleMethod filter;
  public static final ModuleMethod filter$Ex;
  public static final ModuleMethod filter$Mnmap;
  public static final ModuleMethod find;
  public static final ModuleMethod find$Mntail;
  public static GenericProc first;
  public static final ModuleMethod fold;
  public static final ModuleMethod fold$Mnright;
  public static GenericProc fourth;
  public static final ModuleMethod iota;
  static final ModuleMethod lambda$Fn64;
  static final ModuleMethod lambda$Fn78;
  public static final ModuleMethod last;
  public static final ModuleMethod last$Mnpair;
  public static final ModuleMethod length$Pl;
  public static final ModuleMethod list$Eq;
  public static final ModuleMethod list$Mncopy;
  public static final ModuleMethod list$Mnindex;
  public static final ModuleMethod list$Mntabulate;
  public static final ModuleMethod lset$Eq;
  public static final ModuleMethod lset$Ls$Eq;
  public static final ModuleMethod lset$Mnadjoin;
  public static final ModuleMethod lset$Mndiff$Plintersection;
  public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
  public static final ModuleMethod lset$Mndifference;
  public static final ModuleMethod lset$Mndifference$Ex;
  public static final ModuleMethod lset$Mnintersection;
  public static final ModuleMethod lset$Mnintersection$Ex;
  public static final ModuleMethod lset$Mnunion;
  public static final ModuleMethod lset$Mnunion$Ex;
  public static final ModuleMethod lset$Mnxor;
  public static final ModuleMethod lset$Mnxor$Ex;
  public static final ModuleMethod make$Mnlist;
  public static final ModuleMethod map$Ex;
  public static Map map$Mnin$Mnorder;
  public static final ModuleMethod ninth;
  public static final ModuleMethod not$Mnpair$Qu;
  public static final ModuleMethod null$Mnlist$Qu;
  public static final ModuleMethod pair$Mnfold;
  public static final ModuleMethod pair$Mnfold$Mnright;
  public static final ModuleMethod pair$Mnfor$Mneach;
  public static final ModuleMethod partition;
  public static final ModuleMethod partition$Ex;
  public static final ModuleMethod proper$Mnlist$Qu;
  public static final ModuleMethod reduce;
  public static final ModuleMethod reduce$Mnright;
  public static final ModuleMethod remove;
  public static final ModuleMethod remove$Ex;
  public static GenericProc second;
  public static final ModuleMethod seventh;
  public static final ModuleMethod sixth;
  public static final ModuleMethod span;
  public static final ModuleMethod span$Ex;
  public static final ModuleMethod split$Mnat;
  public static final ModuleMethod split$Mnat$Ex;
  public static final ModuleMethod take;
  public static final ModuleMethod take$Ex;
  public static final ModuleMethod take$Mnright;
  public static final ModuleMethod take$Mnwhile;
  public static final ModuleMethod take$Mnwhile$Ex;
  public static final ModuleMethod tenth;
  public static GenericProc third;
  public static final ModuleMethod unfold;
  public static final ModuleMethod unfold$Mnright;
  public static final ModuleMethod unzip1;
  public static final ModuleMethod unzip2;
  public static final ModuleMethod unzip3;
  public static final ModuleMethod unzip4;
  public static final ModuleMethod unzip5;
  public static final ModuleMethod xcons;
  public static final ModuleMethod zip;
  
  static Object $PcCars$Pl(Object paramObject1, Object paramObject2)
  {
    frame56 localframe56 = new frame56();
    localframe56.last$Mnelt = paramObject2;
    return localframe56.lambda75recur(paramObject1);
  }
  
  static Object $PcCars$PlCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame57 localframe57 = new frame57();
      localframe57.abort = localContinuation;
      paramObject = localframe57.lambda76recur(paramObject);
      localContinuation.invoked = true;
      return paramObject;
    }
    finally {}
    return Continuation.handleException((Throwable)paramObject, localContinuation);
  }
  
  static Object $PcCars$PlCdrs$Pl(Object paramObject1, Object paramObject2)
  {
    frame62 localframe62 = new frame62();
    localframe62.cars$Mnfinal = paramObject2;
    paramObject2 = new Continuation(CallContext.getInstance());
    try
    {
      frame63 localframe63 = new frame63();
      localframe63.staticLink = localframe62;
      localframe63.abort = ((Continuation)paramObject2);
      paramObject1 = localframe63.lambda85recur(paramObject1);
      ((Continuation)paramObject2).invoked = true;
      return paramObject1;
    }
    finally {}
    return Continuation.handleException((Throwable)paramObject1, (Continuation)paramObject2);
  }
  
  static Object $PcCars$PlCdrs$SlNoTest(Object paramObject)
  {
    new frame67();
    return frame67.lambda92recur(paramObject);
  }
  
  static Object $PcCars$PlCdrs$SlNoTest$SlPair(Object paramObject)
  {
    frame71 localframe71 = new frame71();
    localframe71.lists = paramObject;
    return call_with_values.callWithValues(localframe71.lambda$Fn77, lambda$Fn78);
  }
  
  static Object $PcCars$PlCdrs$SlPair(Object paramObject)
  {
    frame61 localframe61 = new frame61();
    localframe61.lists = paramObject;
    return call_with_values.callWithValues(localframe61.lambda$Fn63, lambda$Fn64);
  }
  
  static Object $PcCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame55 localframe55 = new frame55();
      localframe55.abort = localContinuation;
      paramObject = localframe55.lambda74recur(paramObject);
      localContinuation.invoked = true;
      return paramObject;
    }
    finally {}
    return Continuation.handleException((Throwable)paramObject, localContinuation);
  }
  
  static Object $PcLset2$Ls$Eq(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame72 localframe72 = new frame72();
    localframe72.$Eq = paramObject1;
    localframe72.lis2 = paramObject3;
    return every$V(localframe72.lambda$Fn79, paramObject2, new Object[0]);
  }
  
  static
  {
    Lit103 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("lp").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("head").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol("tail").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection!").readResolve();
    Lit98 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection").readResolve();
    Lit97 = (SimpleSymbol)new SimpleSymbol("lset-xor!").readResolve();
    Lit96 = (SimpleSymbol)new SimpleSymbol("lset-xor").readResolve();
    Lit95 = (SimpleSymbol)new SimpleSymbol("lset-difference!").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol("lset-difference").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol("lset-intersection!").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol("lset-intersection").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol("lset-union!").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol("lset-union").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol("lset-adjoin").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol("lset=").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol("lset<=").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol("list-index").readResolve();
    Object localObject1 = (SimpleSymbol)new SimpleSymbol("%every").readResolve();
    Lit84 = (SimpleSymbol)localObject1;
    Object localObject2 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    SimpleSymbol localSimpleSymbol2 = Lit102;
    SimpleSymbol localSimpleSymbol3 = Lit101;
    SimpleSymbol localSimpleSymbol4 = Lit103;
    SimpleSymbol localSimpleSymbol5 = Lit100;
    SimpleSymbol localSimpleSymbol6 = Lit104;
    SimpleSymbol localSimpleSymbol7 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol("null-list?").readResolve();
    Lit14 = localSimpleSymbol8;
    localObject2 = new SyntaxRule((SyntaxPattern)localObject2, "\001\001", "\021\030\004\021\030\f¡I\021\030\024\b\021\030\034\b\013\b\021\030$\b\021\030,\b\013\b\021\0304\021\030<!\t\003\030D\030L", new Object[] { localSimpleSymbol1, localSimpleSymbol2, localSimpleSymbol3, localSimpleSymbol4, localSimpleSymbol5, localSimpleSymbol6, localSimpleSymbol7, PairWithPosition.make(localSimpleSymbol8, PairWithPosition.make(Lit100, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722136), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722124), PairWithPosition.make(Lit101, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722148), PairWithPosition.make(PairWithPosition.make(Lit102, PairWithPosition.make(PairWithPosition.make(Lit103, PairWithPosition.make(Lit100, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722163), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722158), PairWithPosition.make(PairWithPosition.make(Lit104, PairWithPosition.make(Lit100, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722174), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722169), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722169), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722158), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722154), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm", 5722154) }, 0);
    Lit85 = new SyntaxRules(new Object[] { localObject1 }, new SyntaxRule[] { localObject2 }, 2);
    Lit83 = (SimpleSymbol)new SimpleSymbol("every").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol("any").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("break!").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("break").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("span!").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("span").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("take-while!").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("drop-while").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("take-while").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("find-tail").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("find").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("alist-delete!").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("alist-delete").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("alist-copy").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("alist-cons").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("delete-duplicates!").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("delete-duplicates").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("delete!").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("delete").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("remove!").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("remove").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("partition!").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("partition").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("filter!").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("filter").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("filter-map").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("map!").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("pair-for-each").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("append-map!").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("append-map").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("reduce-right").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("reduce").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("pair-fold").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("pair-fold-right").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("fold-right").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("fold").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("unfold").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("unfold-right").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("count").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("concatenate!").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("concatenate").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("append-reverse!").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("append-reverse").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("append!").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("unzip5").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("unzip4").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("unzip3").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("unzip2").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("unzip1").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("last-pair").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("last").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("split-at!").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("split-at").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("drop-right!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("drop-right").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("take-right").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("take!").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("drop").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("take").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("car+cdr").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("tenth").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("ninth").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("eighth").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("seventh").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("sixth").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("fifth").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("zip").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("length+").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("list=").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("not-pair?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("circular-list?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("dotted-list?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("proper-list?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("circular-list").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("iota").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("list-copy").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("cons*").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("list-tabulate").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("make-list").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("xcons").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("tmp").readResolve();
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new srfi1();
    $Pcprovide$Pcsrfi$Mn1 = 123;
    $Pcprovide$Pclist$Mnlib = 123;
    localObject1 = $instance;
    xcons = new ModuleMethod((ModuleBody)localObject1, 78, Lit3, 8194);
    make$Mnlist = new ModuleMethod((ModuleBody)localObject1, 79, Lit4, 61441);
    list$Mntabulate = new ModuleMethod((ModuleBody)localObject1, 80, Lit5, 8194);
    cons$St = new ModuleMethod((ModuleBody)localObject1, 81, Lit6, 61440);
    list$Mncopy = new ModuleMethod((ModuleBody)localObject1, 82, Lit7, 4097);
    iota = new ModuleMethod((ModuleBody)localObject1, 83, Lit8, 12289);
    circular$Mnlist = new ModuleMethod((ModuleBody)localObject1, 86, Lit9, 61441);
    proper$Mnlist$Qu = new ModuleMethod((ModuleBody)localObject1, 87, Lit10, 4097);
    dotted$Mnlist$Qu = new ModuleMethod((ModuleBody)localObject1, 88, Lit11, 4097);
    circular$Mnlist$Qu = new ModuleMethod((ModuleBody)localObject1, 89, Lit12, 4097);
    not$Mnpair$Qu = new ModuleMethod((ModuleBody)localObject1, 90, Lit13, 4097);
    null$Mnlist$Qu = new ModuleMethod((ModuleBody)localObject1, 91, Lit14, 4097);
    list$Eq = new ModuleMethod((ModuleBody)localObject1, 92, Lit15, 61441);
    length$Pl = new ModuleMethod((ModuleBody)localObject1, 93, Lit16, 4097);
    zip = new ModuleMethod((ModuleBody)localObject1, 94, Lit17, 61441);
    fifth = new ModuleMethod((ModuleBody)localObject1, 95, Lit18, 4097);
    sixth = new ModuleMethod((ModuleBody)localObject1, 96, Lit19, 4097);
    seventh = new ModuleMethod((ModuleBody)localObject1, 97, Lit20, 4097);
    eighth = new ModuleMethod((ModuleBody)localObject1, 98, Lit21, 4097);
    ninth = new ModuleMethod((ModuleBody)localObject1, 99, Lit22, 4097);
    tenth = new ModuleMethod((ModuleBody)localObject1, 100, Lit23, 4097);
    car$Plcdr = new ModuleMethod((ModuleBody)localObject1, 101, Lit24, 4097);
    take = new ModuleMethod((ModuleBody)localObject1, 102, Lit25, 8194);
    drop = new ModuleMethod((ModuleBody)localObject1, 103, Lit26, 8194);
    take$Ex = new ModuleMethod((ModuleBody)localObject1, 104, Lit27, 8194);
    take$Mnright = new ModuleMethod((ModuleBody)localObject1, 105, Lit28, 8194);
    drop$Mnright = new ModuleMethod((ModuleBody)localObject1, 106, Lit29, 8194);
    drop$Mnright$Ex = new ModuleMethod((ModuleBody)localObject1, 107, Lit30, 8194);
    split$Mnat = new ModuleMethod((ModuleBody)localObject1, 108, Lit31, 8194);
    split$Mnat$Ex = new ModuleMethod((ModuleBody)localObject1, 109, Lit32, 8194);
    last = new ModuleMethod((ModuleBody)localObject1, 110, Lit33, 4097);
    last$Mnpair = new ModuleMethod((ModuleBody)localObject1, 111, Lit34, 4097);
    unzip1 = new ModuleMethod((ModuleBody)localObject1, 112, Lit35, 4097);
    unzip2 = new ModuleMethod((ModuleBody)localObject1, 113, Lit36, 4097);
    unzip3 = new ModuleMethod((ModuleBody)localObject1, 114, Lit37, 4097);
    unzip4 = new ModuleMethod((ModuleBody)localObject1, 115, Lit38, 4097);
    unzip5 = new ModuleMethod((ModuleBody)localObject1, 116, Lit39, 4097);
    append$Ex = new ModuleMethod((ModuleBody)localObject1, 117, Lit40, 61440);
    append$Mnreverse = new ModuleMethod((ModuleBody)localObject1, 118, Lit41, 8194);
    append$Mnreverse$Ex = new ModuleMethod((ModuleBody)localObject1, 119, Lit42, 8194);
    concatenate = new ModuleMethod((ModuleBody)localObject1, 120, Lit43, 4097);
    concatenate$Ex = new ModuleMethod((ModuleBody)localObject1, 121, Lit44, 4097);
    count = new ModuleMethod((ModuleBody)localObject1, 122, Lit45, 61442);
    unfold$Mnright = new ModuleMethod((ModuleBody)localObject1, 123, Lit46, 20484);
    unfold = new ModuleMethod((ModuleBody)localObject1, 125, Lit47, 61444);
    fold = new ModuleMethod((ModuleBody)localObject1, 126, Lit48, 61443);
    fold$Mnright = new ModuleMethod((ModuleBody)localObject1, 127, Lit49, 61443);
    pair$Mnfold$Mnright = new ModuleMethod((ModuleBody)localObject1, 128, Lit50, 61443);
    pair$Mnfold = new ModuleMethod((ModuleBody)localObject1, 129, Lit51, 61443);
    reduce = new ModuleMethod((ModuleBody)localObject1, 130, Lit52, 12291);
    reduce$Mnright = new ModuleMethod((ModuleBody)localObject1, 131, Lit53, 12291);
    append$Mnmap = new ModuleMethod((ModuleBody)localObject1, 132, Lit54, 61442);
    append$Mnmap$Ex = new ModuleMethod((ModuleBody)localObject1, 133, Lit55, 61442);
    pair$Mnfor$Mneach = new ModuleMethod((ModuleBody)localObject1, 134, Lit56, 61442);
    map$Ex = new ModuleMethod((ModuleBody)localObject1, 135, Lit57, 61442);
    filter$Mnmap = new ModuleMethod((ModuleBody)localObject1, 136, Lit58, 61442);
    filter = new ModuleMethod((ModuleBody)localObject1, 137, Lit59, 8194);
    filter$Ex = new ModuleMethod((ModuleBody)localObject1, 138, Lit60, 8194);
    partition = new ModuleMethod((ModuleBody)localObject1, 139, Lit61, 8194);
    partition$Ex = new ModuleMethod((ModuleBody)localObject1, 140, Lit62, 8194);
    remove = new ModuleMethod((ModuleBody)localObject1, 141, Lit63, 8194);
    remove$Ex = new ModuleMethod((ModuleBody)localObject1, 142, Lit64, 8194);
    delete = new ModuleMethod((ModuleBody)localObject1, 143, Lit65, 12290);
    delete$Ex = new ModuleMethod((ModuleBody)localObject1, 145, Lit66, 12290);
    delete$Mnduplicates = new ModuleMethod((ModuleBody)localObject1, 147, Lit67, 8193);
    delete$Mnduplicates$Ex = new ModuleMethod((ModuleBody)localObject1, 149, Lit68, 8193);
    alist$Mncons = new ModuleMethod((ModuleBody)localObject1, 151, Lit69, 12291);
    alist$Mncopy = new ModuleMethod((ModuleBody)localObject1, 152, Lit70, 4097);
    alist$Mndelete = new ModuleMethod((ModuleBody)localObject1, 153, Lit71, 12290);
    alist$Mndelete$Ex = new ModuleMethod((ModuleBody)localObject1, 155, Lit72, 12290);
    find = new ModuleMethod((ModuleBody)localObject1, 157, Lit73, 8194);
    find$Mntail = new ModuleMethod((ModuleBody)localObject1, 158, Lit74, 8194);
    take$Mnwhile = new ModuleMethod((ModuleBody)localObject1, 159, Lit75, 8194);
    drop$Mnwhile = new ModuleMethod((ModuleBody)localObject1, 160, Lit76, 8194);
    take$Mnwhile$Ex = new ModuleMethod((ModuleBody)localObject1, 161, Lit77, 8194);
    span = new ModuleMethod((ModuleBody)localObject1, 162, Lit78, 8194);
    span$Ex = new ModuleMethod((ModuleBody)localObject1, 163, Lit79, 8194);
    break = new ModuleMethod((ModuleBody)localObject1, 164, Lit80, 8194);
    break$Ex = new ModuleMethod((ModuleBody)localObject1, 165, Lit81, 8194);
    any = new ModuleMethod((ModuleBody)localObject1, 166, Lit82, 61442);
    every = new ModuleMethod((ModuleBody)localObject1, 167, Lit83, 61442);
    $Pcevery = Macro.make(Lit84, Lit85, $instance);
    list$Mnindex = new ModuleMethod((ModuleBody)localObject1, 168, Lit86, 61442);
    lset$Ls$Eq = new ModuleMethod((ModuleBody)localObject1, 169, Lit87, 61441);
    lset$Eq = new ModuleMethod((ModuleBody)localObject1, 170, Lit88, 61441);
    lset$Mnadjoin = new ModuleMethod((ModuleBody)localObject1, 171, Lit89, 61442);
    lset$Mnunion = new ModuleMethod((ModuleBody)localObject1, 172, Lit90, 61441);
    lset$Mnunion$Ex = new ModuleMethod((ModuleBody)localObject1, 173, Lit91, 61441);
    lset$Mnintersection = new ModuleMethod((ModuleBody)localObject1, 174, Lit92, 61442);
    lset$Mnintersection$Ex = new ModuleMethod((ModuleBody)localObject1, 175, Lit93, 61442);
    lset$Mndifference = new ModuleMethod((ModuleBody)localObject1, 176, Lit94, 61442);
    lset$Mndifference$Ex = new ModuleMethod((ModuleBody)localObject1, 177, Lit95, 61442);
    lset$Mnxor = new ModuleMethod((ModuleBody)localObject1, 178, Lit96, 61441);
    lset$Mnxor$Ex = new ModuleMethod((ModuleBody)localObject1, 179, Lit97, 61441);
    lset$Mndiff$Plintersection = new ModuleMethod((ModuleBody)localObject1, 180, Lit98, 61442);
    lset$Mndiff$Plintersection$Ex = new ModuleMethod((ModuleBody)localObject1, 181, Lit99, 61442);
    lambda$Fn64 = new ModuleMethod((ModuleBody)localObject1, 182, null, 8194);
    lambda$Fn78 = new ModuleMethod((ModuleBody)localObject1, 183, null, 8194);
    $instance.run();
  }
  
  public srfi1()
  {
    ModuleInfo.register(this);
  }
  
  public static Pair alistCons(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(lists.cons(paramObject1, paramObject2), paramObject3);
  }
  
  public static LList alistCopy(Object paramObject)
  {
    Object localObject2 = LList.Empty;
    Object localObject1 = paramObject;
    paramObject = localObject2;
    for (;;)
    {
      if (localObject1 == LList.Empty) {
        return LList.reverseInPlace(paramObject);
      }
      try
      {
        localObject2 = (Pair)localObject1;
        localObject1 = ((Pair)localObject2).getCdr();
        localObject2 = ((Pair)localObject2).getCar();
        paramObject = Pair.make(lists.cons(lists.car.apply1(localObject2), lists.cdr.apply1(localObject2)), paramObject);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "arg0", -2, localObject1);
      }
    }
  }
  
  public static Object alistDelete(Object paramObject1, Object paramObject2)
  {
    return alistDelete(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object alistDelete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame21 localframe21 = new frame21();
    localframe21.key = paramObject1;
    localframe21.maybe$Mn$Eq = paramObject3;
    return filter(localframe21.lambda$Fn18, paramObject2);
  }
  
  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2)
  {
    return alistDelete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame22 localframe22 = new frame22();
    localframe22.key = paramObject1;
    localframe22.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe22.lambda$Fn19, paramObject2);
  }
  
  public static Object any$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    int i = 0;
    frame26 localframe26 = new frame26();
    localframe26.pred = paramProcedure;
    localframe26.lis1 = paramObject;
    localframe26.lists = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localframe26.lists)) {
      paramObject = call_with_values.callWithValues(localframe26.lambda$Fn22, localframe26.lambda$Fn23);
    }
    for (;;)
    {
      return paramObject;
      paramProcedure = isNullList(localframe26.lis1);
      try
      {
        paramObject = Boolean.FALSE;
        if (paramProcedure != paramObject) {
          i = 1;
        }
        i = i + 1 & 0x1;
        if (i != 0)
        {
          paramObject = lists.car.apply1(localframe26.lis1);
          for (paramProcedure = lists.cdr.apply1(localframe26.lis1);; paramProcedure = lists.cdr.apply1(paramProcedure))
          {
            if (isNullList(paramProcedure) != Boolean.FALSE) {
              return localframe26.pred.apply1(paramObject);
            }
            paramArrayOfObject = localframe26.pred.apply1(paramObject);
            paramObject = paramArrayOfObject;
            if (paramArrayOfObject != Boolean.FALSE) {
              break;
            }
            paramObject = lists.car.apply1(paramProcedure);
          }
        }
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "x", -2, paramProcedure);
      }
    }
  }
  
  public static Object append$Ex$V(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    localObject2 = LList.Empty;
    Object localObject1;
    for (;;)
    {
      if (!lists.isPair(paramArrayOfObject)) {
        return localObject2;
      }
      localObject2 = lists.car.apply1(paramArrayOfObject);
      localObject1 = lists.cdr.apply1(paramArrayOfObject);
      if (lists.isPair(localObject2)) {
        break;
      }
      paramArrayOfObject = (Object[])localObject1;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        paramArrayOfObject = (Pair)localObject2;
        paramArrayOfObject = lastPair(paramArrayOfObject);
        if (lists.isPair(localObject1))
        {
          localObject3 = lists.car.apply1(localObject1);
          localObject1 = lists.cdr.apply1(localObject1);
        }
      }
      catch (ClassCastException paramArrayOfObject)
      {
        Pair localPair;
        throw new WrongType(paramArrayOfObject, "last-pair", 0, localObject2);
      }
      try
      {
        localPair = (Pair)paramArrayOfObject;
        lists.setCdr$Ex(localPair, localObject3);
        if (!lists.isPair(localObject3)) {}
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramArrayOfObject);
      }
      try
      {
        paramArrayOfObject = (Pair)localObject3;
        paramArrayOfObject = lastPair(paramArrayOfObject);
      }
      catch (ClassCastException paramArrayOfObject)
      {
        throw new WrongType(paramArrayOfObject, "last-pair", 0, localObject3);
      }
    }
    return localObject2;
  }
  
  public static Object appendMap$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject)) {
      return Scheme.apply.apply2(append$Ex, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, paramArrayOfObject));
    }
    Apply localApply = Scheme.apply;
    ModuleMethod localModuleMethod = append$Ex;
    paramArrayOfObject = LList.Empty;
    for (;;)
    {
      if (paramObject2 == LList.Empty) {
        return localApply.apply2(localModuleMethod, LList.reverseInPlace(paramArrayOfObject));
      }
      try
      {
        Pair localPair = (Pair)paramObject2;
        paramObject2 = localPair.getCdr();
        paramArrayOfObject = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), paramArrayOfObject);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "arg0", -2, paramObject2);
      }
    }
  }
  
  public static Object appendMap$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject)) {
      return Scheme.apply.apply2(append.append, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, paramArrayOfObject));
    }
    Apply localApply = Scheme.apply;
    append localappend = append.append;
    paramArrayOfObject = LList.Empty;
    for (;;)
    {
      if (paramObject2 == LList.Empty) {
        return localApply.apply2(localappend, LList.reverseInPlace(paramArrayOfObject));
      }
      try
      {
        Pair localPair = (Pair)paramObject2;
        paramObject2 = localPair.getCdr();
        paramArrayOfObject = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), paramArrayOfObject);
      }
      catch (ClassCastException paramObject1)
      {
        throw new WrongType((ClassCastException)paramObject1, "arg0", -2, paramObject2);
      }
    }
  }
  
  public static Object appendReverse(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (isNullList(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = lists.cdr.apply1(paramObject1);
      paramObject2 = lists.cons(lists.car.apply1(paramObject1), paramObject2);
      paramObject1 = localObject;
    }
  }
  
  public static Object appendReverse$Ex(Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (isNullList(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = lists.cdr.apply1(paramObject1);
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        paramObject2 = paramObject1;
        paramObject1 = localObject;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "set-cdr!", 1, paramObject1);
      }
    }
  }
  
  public static Object jdMethod_break(Object paramObject1, Object paramObject2)
  {
    frame24 localframe24 = new frame24();
    localframe24.pred = paramObject1;
    return span(localframe24.lambda$Fn20, paramObject2);
  }
  
  public static Object break$Ex(Object paramObject1, Object paramObject2)
  {
    frame25 localframe25 = new frame25();
    localframe25.pred = paramObject1;
    return span$Ex(localframe25.lambda$Fn21, paramObject2);
  }
  
  public static Object car$PlCdr(Object paramObject)
  {
    return misc.values(new Object[] { lists.car.apply1(paramObject), lists.cdr.apply1(paramObject) });
  }
  
  public static Pair circularList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = lists.cons(paramObject, LList.makeList(paramArrayOfObject, 0));
    paramObject = lastPair(paramArrayOfObject);
    try
    {
      Pair localPair = (Pair)paramObject;
      lists.setCdr$Ex(localPair, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassCastException paramArrayOfObject)
    {
      throw new WrongType(paramArrayOfObject, "set-cdr!", 1, paramObject);
    }
  }
  
  public static Object concatenate(Object paramObject)
  {
    return reduceRight(append.append, LList.Empty, paramObject);
  }
  
  public static Object concatenate$Ex(Object paramObject)
  {
    return reduceRight(append$Ex, LList.Empty, paramObject);
  }
  
  public static Object cons$St(Object... paramVarArgs)
  {
    return LList.consX(paramVarArgs);
  }
  
  public static Object count$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    Object localObject2;
    if (lists.isPair(localObject1))
    {
      localObject2 = Lit0;
      paramArrayOfObject = (Object[])paramObject;
      paramObject = localObject2;
      for (;;)
      {
        if (isNullList(paramArrayOfObject) != Boolean.FALSE) {
          localObject1 = paramObject;
        }
        Object localObject4;
        do
        {
          return localObject1;
          localObject1 = $PcCars$PlCdrs$SlPair(localObject1);
          localObject4 = lists.car.apply1(localObject1);
          localObject2 = lists.cdr.apply1(localObject1);
          localObject1 = paramObject;
        } while (lists.isNull(localObject4));
        Object localObject3 = lists.cdr.apply1(paramArrayOfObject);
        localObject1 = paramObject;
        if (Scheme.apply.apply3(paramProcedure, lists.car.apply1(paramArrayOfObject), localObject4) != Boolean.FALSE) {
          localObject1 = AddOp.$Pl.apply2(paramObject, Lit1);
        }
        paramArrayOfObject = (Object[])localObject2;
        localObject2 = localObject3;
        paramObject = localObject1;
        localObject1 = paramArrayOfObject;
        paramArrayOfObject = (Object[])localObject2;
      }
    }
    localObject1 = Lit0;
    paramArrayOfObject = (Object[])paramObject;
    for (paramObject = localObject1;; paramObject = localObject1)
    {
      localObject1 = paramObject;
      if (isNullList(paramArrayOfObject) != Boolean.FALSE) {
        break;
      }
      localObject2 = lists.cdr.apply1(paramArrayOfObject);
      localObject1 = paramObject;
      if (paramProcedure.apply1(lists.car.apply1(paramArrayOfObject)) != Boolean.FALSE) {
        localObject1 = AddOp.$Pl.apply2(paramObject, Lit1);
      }
      paramArrayOfObject = (Object[])localObject2;
    }
  }
  
  public static Object delete(Object paramObject1, Object paramObject2)
  {
    return delete(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object delete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame17 localframe17 = new frame17();
    localframe17.x = paramObject1;
    localframe17.maybe$Mn$Eq = paramObject3;
    return filter(localframe17.lambda$Fn16, paramObject2);
  }
  
  public static Object delete$Ex(Object paramObject1, Object paramObject2)
  {
    return delete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }
  
  public static Object delete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame18 localframe18 = new frame18();
    localframe18.x = paramObject1;
    localframe18.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe18.lambda$Fn17, paramObject2);
  }
  
  public static Object deleteDuplicates(Object paramObject)
  {
    return deleteDuplicates(paramObject, Scheme.isEqual);
  }
  
  public static Object deleteDuplicates(Object paramObject, Procedure paramProcedure)
  {
    frame19 localframe19 = new frame19();
    localframe19.maybe$Mn$Eq = paramProcedure;
    return localframe19.lambda30recur(paramObject);
  }
  
  public static Object deleteDuplicates$Ex(Object paramObject)
  {
    return deleteDuplicates$Ex(paramObject, Scheme.isEqual);
  }
  
  public static Object deleteDuplicates$Ex(Object paramObject, Procedure paramProcedure)
  {
    frame20 localframe20 = new frame20();
    localframe20.maybe$Mn$Eq = paramProcedure;
    return localframe20.lambda31recur(paramObject);
  }
  
  /* Error */
  public static Object drop(Object paramObject, IntNum paramIntNum)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 1458	java/lang/Number
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1464	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   9: ifeq +5 -> 14
    //   12: aload_0
    //   13: areturn
    //   14: getstatic 1253	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   17: aload_0
    //   18: invokevirtual 1251	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore_0
    //   22: getstatic 1467	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   25: aload_1
    //   26: getstatic 1000	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   29: invokevirtual 1362	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: astore_1
    //   33: goto -33 -> 0
    //   36: astore_0
    //   37: new 1257	gnu/mapping/WrongType
    //   40: dup
    //   41: aload_0
    //   42: ldc_w 1469
    //   45: iconst_1
    //   46: aload_1
    //   47: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramObject	Object
    //   0	51	1	paramIntNum	IntNum
    //   4	2	2	localNumber	Number
    // Exception table:
    //   from	to	target	type
    //   0	5	36	java/lang/ClassCastException
  }
  
  public static Object dropRight(Object paramObject, IntNum paramIntNum)
  {
    return lambda1recur(paramObject, drop(paramObject, paramIntNum));
  }
  
  public static Object dropRight$Ex(Object paramObject, IntNum paramIntNum)
  {
    paramIntNum = drop(paramObject, paramIntNum);
    Object localObject;
    if (lists.isPair(paramIntNum))
    {
      localObject = lists.cdr.apply1(paramIntNum);
      paramIntNum = (IntNum)paramObject;
      while (lists.isPair(localObject))
      {
        paramIntNum = lists.cdr.apply1(paramIntNum);
        localObject = lists.cdr.apply1(localObject);
      }
    }
    try
    {
      localObject = (Pair)paramIntNum;
      lists.setCdr$Ex((Pair)localObject, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw new WrongType((ClassCastException)paramObject, "set-cdr!", 1, paramIntNum);
    }
    return LList.Empty;
  }
  
  public static Object dropWhile(Procedure paramProcedure, Object paramObject)
  {
    for (;;)
    {
      Object localObject;
      if (isNullList(paramObject) != Boolean.FALSE) {
        localObject = LList.Empty;
      }
      do
      {
        return localObject;
        localObject = paramObject;
      } while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE);
      paramObject = lists.cdr.apply1(paramObject);
    }
  }
  
  public static Object eighth(Object paramObject)
  {
    return lists.cadddr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object every$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame27 localframe27 = new frame27();
    localframe27.pred = paramProcedure;
    localframe27.lis1 = paramObject;
    localframe27.lists = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localframe27.lists)) {
      paramProcedure = call_with_values.callWithValues(localframe27.lambda$Fn24, localframe27.lambda$Fn25);
    }
    do
    {
      return paramProcedure;
      paramObject = isNullList(localframe27.lis1);
      paramProcedure = (Procedure)paramObject;
    } while (paramObject != Boolean.FALSE);
    paramProcedure = lists.car.apply1(localframe27.lis1);
    for (paramObject = lists.cdr.apply1(localframe27.lis1);; paramObject = lists.cdr.apply1(paramObject))
    {
      if (isNullList(paramObject) != Boolean.FALSE) {
        return localframe27.pred.apply1(paramProcedure);
      }
      paramArrayOfObject = localframe27.pred.apply1(paramProcedure);
      paramProcedure = paramArrayOfObject;
      if (paramArrayOfObject == Boolean.FALSE) {
        break;
      }
      paramProcedure = lists.car.apply1(paramObject);
    }
  }
  
  public static Object fifth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object filter(Procedure paramProcedure, Object paramObject)
  {
    localObject1 = LList.Empty;
    for (;;)
    {
      if (isNullList(paramObject) != Boolean.FALSE) {}
      try
      {
        paramProcedure = (LList)localObject1;
        return lists.reverse$Ex(paramProcedure);
      }
      catch (ClassCastException paramProcedure)
      {
        Object localObject2;
        throw new WrongType(paramProcedure, "reverse!", 1, localObject1);
      }
      localObject2 = lists.car.apply1(paramObject);
      paramObject = lists.cdr.apply1(paramObject);
      if (paramProcedure.apply1(localObject2) != Boolean.FALSE) {
        localObject1 = lists.cons(localObject2, localObject1);
      }
    }
  }
  
  public static Object filter$Ex(Procedure paramProcedure, Object paramObject)
  {
    localObject1 = paramObject;
    if (isNullList(localObject1) != Boolean.FALSE) {}
    Object localObject3;
    for (;;)
    {
      return localObject1;
      if (paramProcedure.apply1(lists.car.apply1(localObject1)) == Boolean.FALSE)
      {
        localObject1 = lists.cdr.apply1(localObject1);
        break;
      }
      paramObject = lists.cdr.apply1(localObject1);
      localObject2 = localObject1;
      while (lists.isPair(paramObject))
      {
        if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
          break label93;
        }
        localObject3 = lists.cdr.apply1(paramObject);
        localObject2 = paramObject;
        paramObject = localObject3;
      }
    }
    label93:
    for (paramObject = lists.cdr.apply1(paramObject);; paramObject = lists.cdr.apply1(paramObject))
    {
      if ((!lists.isPair(paramObject)) || (paramProcedure.apply1(lists.car.apply1(paramObject)) != Boolean.FALSE)) {}
      try
      {
        localObject3 = (Pair)localObject2;
        lists.setCdr$Ex((Pair)localObject3, paramObject);
        localObject3 = lists.cdr.apply1(paramObject);
        localObject2 = paramObject;
        paramObject = localObject3;
      }
      catch (ClassCastException paramProcedure)
      {
        try
        {
          paramProcedure = (Pair)localObject2;
          lists.setCdr$Ex(paramProcedure, paramObject);
          return localObject1;
        }
        catch (ClassCastException paramProcedure)
        {
          throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
        }
        paramProcedure = paramProcedure;
        throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
      }
    }
  }
  
  public static Object filterMap$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame13 localframe13 = new frame13();
    localframe13.f = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramProcedure)) {
      return localframe13.lambda23recur(lists.cons(paramObject, paramProcedure), LList.Empty);
    }
    paramArrayOfObject = LList.Empty;
    paramProcedure = (Procedure)paramObject;
    paramObject = paramArrayOfObject;
    for (;;)
    {
      if (isNullList(paramProcedure) != Boolean.FALSE) {}
      try
      {
        paramProcedure = (LList)paramObject;
        return lists.reverse$Ex(paramProcedure);
      }
      catch (ClassCastException paramProcedure)
      {
        throw new WrongType(paramProcedure, "reverse!", 1, paramObject);
      }
      paramArrayOfObject = localframe13.f.apply1(lists.car.apply1(paramProcedure));
      paramProcedure = lists.cdr.apply1(paramProcedure);
      if (paramArrayOfObject != Boolean.FALSE) {
        paramObject = lists.cons(paramArrayOfObject, paramObject);
      }
    }
  }
  
  public static Object find(Object paramObject1, Object paramObject2)
  {
    try
    {
      Procedure localProcedure = (Procedure)paramObject1;
      paramObject1 = findTail(localProcedure, paramObject2);
      if (paramObject1 != Boolean.FALSE) {
        return lists.car.apply1(paramObject1);
      }
      return Boolean.FALSE;
    }
    catch (ClassCastException paramObject2)
    {
      throw new WrongType((ClassCastException)paramObject2, "find-tail", 0, paramObject1);
    }
  }
  
  public static Object findTail(Procedure paramProcedure, Object paramObject)
  {
    for (;;)
    {
      Object localObject = isNullList(paramObject);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject != localBoolean) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label63;
          }
          if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
            break;
          }
          return paramObject;
        }
        paramObject = lists.cdr.apply1(paramObject);
        continue;
        label63:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException paramProcedure)
      {
        throw new WrongType(paramProcedure, "x", -2, localObject);
      }
    }
  }
  
  public static Object fold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame7 localframe7 = new frame7();
    localframe7.kons = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramProcedure))
    {
      paramObject2 = localframe7.lambda14lp(lists.cons(paramObject2, paramProcedure), paramObject1);
      return paramObject2;
    }
    for (paramProcedure = (Procedure)paramObject2;; paramProcedure = (Procedure)paramObject2)
    {
      paramObject2 = paramObject1;
      if (isNullList(paramProcedure) != Boolean.FALSE) {
        break;
      }
      paramObject2 = lists.cdr.apply1(paramProcedure);
      paramObject1 = localframe7.kons.apply2(lists.car.apply1(paramProcedure), paramObject1);
    }
  }
  
  public static Object foldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.kons = paramProcedure;
    localframe9.knil = paramObject1;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramProcedure)) {
      return localframe9.lambda17recur(lists.cons(paramObject2, paramProcedure));
    }
    return localframe9.lambda18recur(paramObject2);
  }
  
  public static Object iota(IntNum paramIntNum)
  {
    return iota(paramIntNum, Lit0, Lit1);
  }
  
  public static Object iota(IntNum paramIntNum, Numeric paramNumeric)
  {
    return iota(paramIntNum, paramNumeric, Lit1);
  }
  
  public static Object iota(IntNum paramIntNum, Numeric paramNumeric1, Numeric paramNumeric2)
  {
    if (IntNum.compare(paramIntNum, 0L) < 0) {
      misc.error$V("Negative step count", new Object[] { iota, paramIntNum });
    }
    Object localObject1 = AddOp.$Pl.apply2(paramNumeric1, MultiplyOp.$St.apply2(IntNum.add(paramIntNum, -1), paramNumeric2));
    try
    {
      paramNumeric1 = (Numeric)localObject1;
      Object localObject2 = LList.Empty;
      localObject1 = paramIntNum;
      paramIntNum = (IntNum)localObject2;
      while (Scheme.numLEq.apply2(localObject1, Lit0) == Boolean.FALSE)
      {
        localObject1 = AddOp.$Mn.apply2(localObject1, Lit1);
        localObject2 = AddOp.$Mn.apply2(paramNumeric1, paramNumeric2);
        paramIntNum = lists.cons(paramNumeric1, paramIntNum);
        paramNumeric1 = (Numeric)localObject2;
      }
      return paramIntNum;
    }
    catch (ClassCastException paramIntNum)
    {
      throw new WrongType(paramIntNum, "last-val", -2, localObject1);
    }
  }
  
  public static Object isCircularList(Object paramObject)
  {
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    paramObject = localObject1;
    boolean bool;
    for (;;)
    {
      bool = lists.isPair(localObject2);
      if (!bool) {
        break label96;
      }
      localObject1 = lists.cdr.apply1(localObject2);
      bool = lists.isPair(localObject1);
      if (!bool) {
        break;
      }
      localObject2 = lists.cdr.apply1(localObject1);
      paramObject = lists.cdr.apply1(paramObject);
      int i;
      if (localObject2 == paramObject) {
        i = 1;
      }
      while (i != 0) {
        if (i != 0)
        {
          return Boolean.TRUE;
          i = 0;
        }
        else
        {
          return Boolean.FALSE;
        }
      }
    }
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    label96:
    if (bool) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object isDottedList(Object paramObject)
  {
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    paramObject = localObject1;
    if (lists.isPair(localObject2))
    {
      localObject1 = lists.cdr.apply1(localObject2);
      if (lists.isPair(localObject1))
      {
        localObject2 = lists.cdr.apply1(localObject1);
        paramObject = lists.cdr.apply1(paramObject);
        if (localObject2 == paramObject) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label69;
          }
          break;
        }
        label69:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject1)) {
        return Boolean.FALSE;
      }
      return Boolean.TRUE;
    }
    if (lists.isNull(localObject2)) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static boolean isNotPair(Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object isNullList(Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return Boolean.FALSE;
    }
    if (paramObject == LList.Empty) {
      return Boolean.TRUE;
    }
    return misc.error$V("null-list?: argument out of domain", new Object[] { paramObject });
  }
  
  public static Object isProperList(Object paramObject)
  {
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    paramObject = localObject1;
    if (lists.isPair(localObject2))
    {
      localObject1 = lists.cdr.apply1(localObject2);
      if (lists.isPair(localObject1))
      {
        localObject2 = lists.cdr.apply1(localObject1);
        paramObject = lists.cdr.apply1(paramObject);
        if (localObject2 == paramObject) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label69;
          }
          break;
        }
        label69:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject1)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    if (lists.isNull(localObject2)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static Object lambda1recur(Object paramObject1, Object paramObject2)
  {
    if (lists.isPair(paramObject2)) {
      return lists.cons(lists.car.apply1(paramObject1), lambda1recur(lists.cdr.apply1(paramObject1), lists.cdr.apply1(paramObject2)));
    }
    return LList.Empty;
  }
  
  public static Object last(Object paramObject)
  {
    GenericProc localGenericProc = lists.car;
    try
    {
      Pair localPair = (Pair)paramObject;
      return localGenericProc.apply1(lastPair(localPair));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "last-pair", 0, paramObject);
    }
  }
  
  public static Object lastPair(Pair paramPair)
  {
    for (;;)
    {
      Object localObject = lists.cdr.apply1(paramPair);
      if (!lists.isPair(localObject)) {
        break;
      }
      paramPair = (Pair)localObject;
    }
    return paramPair;
  }
  
  public static Object length$Pl(Object paramObject)
  {
    Object localObject1 = Lit0;
    Object localObject2 = paramObject;
    Object localObject3 = paramObject;
    paramObject = localObject2;
    if (lists.isPair(localObject3))
    {
      localObject2 = lists.cdr.apply1(localObject3);
      localObject1 = AddOp.$Pl.apply2(localObject1, Lit1);
      if (lists.isPair(localObject2))
      {
        localObject3 = lists.cdr.apply1(localObject2);
        paramObject = lists.cdr.apply1(paramObject);
        localObject1 = AddOp.$Pl.apply2(localObject1, Lit1);
        if (localObject3 == paramObject) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label100;
          }
          break;
        }
        label100:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return localObject1;
    }
    return localObject1;
  }
  
  public static Object list$Eq$V(Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    boolean bool = lists.isNull(localObject1);
    if (bool)
    {
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    paramArrayOfObject = lists.car.apply1(localObject1);
    Object localObject2;
    Object localObject3;
    for (localObject1 = lists.cdr.apply1(localObject1);; localObject1 = localObject3)
    {
      bool = lists.isNull(localObject1);
      if (bool)
      {
        if (bool) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      localObject2 = lists.car.apply1(localObject1);
      localObject3 = lists.cdr.apply1(localObject1);
      if (paramArrayOfObject != localObject2) {
        break;
      }
      paramArrayOfObject = (Object[])localObject2;
    }
    localObject1 = localObject2;
    for (;;)
    {
      if (isNullList(paramArrayOfObject) != Boolean.FALSE)
      {
        paramArrayOfObject = isNullList(localObject1);
        if (paramArrayOfObject != Boolean.FALSE)
        {
          paramArrayOfObject = (Object[])localObject1;
          localObject1 = localObject3;
          break;
        }
        return paramArrayOfObject;
      }
      localObject2 = isNullList(localObject1);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject2 != localBoolean) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label237;
          }
          localObject2 = Scheme.applyToArgs.apply3(paramObject, lists.car.apply1(paramArrayOfObject), lists.car.apply1(localObject1));
          if (localObject2 == Boolean.FALSE) {
            break label234;
          }
          paramArrayOfObject = lists.cdr.apply1(paramArrayOfObject);
          localObject1 = lists.cdr.apply1(localObject1);
          break;
        }
        label234:
        return localObject2;
        label237:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "x", -2, localObject2);
      }
    }
  }
  
  public static LList listCopy(LList paramLList)
  {
    Object localObject2 = LList.Empty;
    Object localObject1 = LList.Empty;
    if (lists.isPair(paramLList))
    {
      Pair localPair1 = lists.cons(lists.car.apply1(paramLList), LList.Empty);
      if (localObject1 == LList.Empty) {
        localObject2 = localPair1;
      }
      for (;;)
      {
        localObject1 = localPair1;
        paramLList = (LList)lists.cdr.apply1(paramLList);
        break;
        try
        {
          Pair localPair2 = (Pair)localObject1;
          lists.setCdr$Ex(localPair2, localPair1);
        }
        catch (ClassCastException paramLList)
        {
          throw new WrongType(paramLList, "set-cdr!", 1, localObject1);
        }
      }
    }
    return (LList)localObject2;
  }
  
  public static Object listIndex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame30 localframe30 = new frame30();
    localframe30.pred = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramProcedure)) {
      paramArrayOfObject = localframe30.lambda44lp(lists.cons(paramObject, paramProcedure), Lit0);
    }
    for (;;)
    {
      return paramArrayOfObject;
      paramProcedure = Lit0;
      label48:
      paramArrayOfObject = isNullList(paramObject);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (paramArrayOfObject != localBoolean) {}
        for (int i = 1;; i = 0)
        {
          i = i + 1 & 0x1;
          if (i == 0) {
            break label126;
          }
          paramArrayOfObject = paramProcedure;
          if (localframe30.pred.apply1(lists.car.apply1(paramObject)) != Boolean.FALSE) {
            break;
          }
          paramObject = lists.cdr.apply1(paramObject);
          paramProcedure = AddOp.$Pl.apply2(paramProcedure, Lit1);
          break label48;
        }
        label126:
        if (i != 0) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException paramProcedure)
      {
        throw new WrongType(paramProcedure, "x", -2, paramArrayOfObject);
      }
    }
  }
  
  public static Object listTabulate(Object paramObject, Procedure paramProcedure)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object lset$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object lset$Ls$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object lsetAdjoin$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame32 localframe32 = new frame32();
    localframe32.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    return fold$V(localframe32.lambda$Fn30, paramObject, paramProcedure, new Object[0]);
  }
  
  public static Object lsetDiff$PlIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame53 localframe53 = new frame53();
    localframe53.$Eq = paramProcedure;
    localframe53.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe53.lists, new Object[0]) != Boolean.FALSE) {
      return misc.values(new Object[] { paramObject, LList.Empty });
    }
    if (lists.memq(paramObject, localframe53.lists) != Boolean.FALSE) {
      return misc.values(new Object[] { LList.Empty, paramObject });
    }
    return partition$Ex(localframe53.lambda$Fn55, paramObject);
  }
  
  public static Object lsetDiff$PlIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame51 localframe51 = new frame51();
    localframe51.$Eq = paramProcedure;
    localframe51.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe51.lists, new Object[0]) != Boolean.FALSE) {
      return misc.values(new Object[] { paramObject, LList.Empty });
    }
    if (lists.memq(paramObject, localframe51.lists) != Boolean.FALSE) {
      return misc.values(new Object[] { LList.Empty, paramObject });
    }
    return partition(localframe51.lambda$Fn53, paramObject);
  }
  
  public static Object lsetDifference$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame43 localframe43 = new frame43();
    localframe43.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    localframe43.lists = filter(lists.pair$Qu, paramProcedure);
    if (lists.isNull(localframe43.lists)) {
      return paramObject;
    }
    if (lists.memq(paramObject, localframe43.lists) != Boolean.FALSE) {
      return LList.Empty;
    }
    return filter$Ex(localframe43.lambda$Fn43, paramObject);
  }
  
  public static Object lsetDifference$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame41 localframe41 = new frame41();
    localframe41.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    localframe41.lists = filter(lists.pair$Qu, paramProcedure);
    if (lists.isNull(localframe41.lists)) {
      return paramObject;
    }
    if (lists.memq(paramObject, localframe41.lists) != Boolean.FALSE) {
      return LList.Empty;
    }
    return filter(localframe41.lambda$Fn41, paramObject);
  }
  
  public static Object lsetIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame39 localframe39 = new frame39();
    localframe39.$Eq = paramProcedure;
    localframe39.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe39.lists, new Object[0]) != Boolean.FALSE) {
      paramProcedure = LList.Empty;
    }
    do
    {
      return paramProcedure;
      paramProcedure = (Procedure)paramObject;
    } while (lists.isNull(localframe39.lists));
    return filter$Ex(localframe39.lambda$Fn39, paramObject);
  }
  
  public static Object lsetIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame37 localframe37 = new frame37();
    localframe37.$Eq = paramProcedure;
    localframe37.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe37.lists, new Object[0]) != Boolean.FALSE) {
      paramProcedure = LList.Empty;
    }
    do
    {
      return paramProcedure;
      paramProcedure = (Procedure)paramObject;
    } while (lists.isNull(localframe37.lists));
    return filter(localframe37.lambda$Fn37, paramObject);
  }
  
  public static Object lsetUnion$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame35 localframe35 = new frame35();
    localframe35.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe35.lambda$Fn34, LList.Empty, paramProcedure);
  }
  
  public static Object lsetUnion$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame33 localframe33 = new frame33();
    localframe33.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe33.lambda$Fn31, LList.Empty, paramProcedure);
  }
  
  public static Object lsetXor$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame48 localframe48 = new frame48();
    localframe48.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe48.lambda$Fn49, LList.Empty, paramProcedure);
  }
  
  public static Object lsetXor$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame45 localframe45 = new frame45();
    localframe45.$Eq = paramProcedure;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe45.lambda$Fn45, LList.Empty, paramProcedure);
  }
  
  public static Object makeList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static Object map$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.f = paramProcedure;
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject)) {
      paramProcedure = (Procedure)paramObject;
    }
    for (;;)
    {
      if (isNullList(paramProcedure) != Boolean.FALSE) {
        break label114;
      }
      paramArrayOfObject = $PcCars$PlCdrs$SlNoTest$SlPair(paramArrayOfObject);
      Object localObject = lists.car.apply1(paramArrayOfObject);
      paramArrayOfObject = lists.cdr.apply1(paramArrayOfObject);
      try
      {
        Pair localPair = (Pair)paramProcedure;
        lists.setCar$Ex(localPair, Scheme.apply.apply3(localframe12.f, lists.car.apply1(paramProcedure), localObject));
        paramProcedure = lists.cdr.apply1(paramProcedure);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "set-car!", 1, paramProcedure);
      }
    }
    pairForEach$V(localframe12.lambda$Fn11, paramObject, new Object[0]);
    label114:
    return paramObject;
  }
  
  public static Object ninth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }
  
  public static Object pairFold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject)) {
      for (paramObject2 = lists.cons(paramObject2, paramArrayOfObject);; paramObject2 = paramArrayOfObject)
      {
        paramArrayOfObject = $PcCdrs(paramObject2);
        if (lists.isNull(paramArrayOfObject))
        {
          paramArrayOfObject = (Object[])paramObject1;
          return paramArrayOfObject;
        }
        paramObject1 = Scheme.apply.apply2(paramProcedure, append$Ex$V(new Object[] { paramObject2, LList.list1(paramObject1) }));
      }
    }
    for (;;)
    {
      paramArrayOfObject = (Object[])paramObject1;
      if (isNullList(paramObject2) != Boolean.FALSE) {
        break;
      }
      paramArrayOfObject = lists.cdr.apply1(paramObject2);
      paramObject1 = paramProcedure.apply2(paramObject2, paramObject1);
      paramObject2 = paramArrayOfObject;
    }
  }
  
  public static Object pairFoldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame10 localframe10 = new frame10();
    localframe10.f = paramProcedure;
    localframe10.zero = paramObject1;
    paramProcedure = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramProcedure)) {
      return localframe10.lambda19recur(lists.cons(paramObject2, paramProcedure));
    }
    return localframe10.lambda20recur(paramObject2);
  }
  
  public static Object pairForEach$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject))
    {
      for (paramObject = lists.cons(paramObject, paramArrayOfObject);; paramObject = paramArrayOfObject)
      {
        paramArrayOfObject = $PcCdrs(paramObject);
        if (!lists.isPair(paramArrayOfObject)) {
          break;
        }
        Scheme.apply.apply2(paramProcedure, paramObject);
      }
      return Values.empty;
    }
    while (isNullList(paramObject) == Boolean.FALSE)
    {
      paramArrayOfObject = lists.cdr.apply1(paramObject);
      paramProcedure.apply1(paramObject);
      paramObject = paramArrayOfObject;
    }
    return Values.empty;
  }
  
  public static Object partition(Procedure paramProcedure, Object paramObject)
  {
    localObject2 = LList.Empty;
    localObject1 = LList.Empty;
    for (;;)
    {
      if (isNullList(paramObject) != Boolean.FALSE) {}
      try
      {
        paramProcedure = (LList)localObject2;
        paramProcedure = lists.reverse$Ex(paramProcedure);
      }
      catch (ClassCastException paramProcedure)
      {
        Object localObject3;
        throw new WrongType(paramProcedure, "reverse!", 1, localObject2);
      }
      try
      {
        paramObject = (LList)localObject1;
        return misc.values(new Object[] { paramProcedure, lists.reverse$Ex((LList)paramObject) });
      }
      catch (ClassCastException paramProcedure)
      {
        throw new WrongType(paramProcedure, "reverse!", 1, localObject1);
      }
      localObject3 = lists.car.apply1(paramObject);
      paramObject = lists.cdr.apply1(paramObject);
      if (paramProcedure.apply1(localObject3) != Boolean.FALSE) {
        localObject2 = lists.cons(localObject3, localObject2);
      } else {
        localObject1 = lists.cons(localObject3, localObject1);
      }
    }
  }
  
  public static Object partition$Ex(Procedure paramProcedure, Object paramObject)
  {
    Pair localPair1 = lists.cons(Lit2, LList.Empty);
    Pair localPair2 = lists.cons(Lit2, LList.Empty);
    localObject2 = localPair1;
    localObject1 = localPair2;
    for (;;)
    {
      if (isNotPair(paramObject)) {}
      try
      {
        paramProcedure = (Pair)localObject2;
        lists.setCdr$Ex(paramProcedure, LList.Empty);
        try
        {
          paramProcedure = (Pair)localObject1;
          lists.setCdr$Ex(paramProcedure, LList.Empty);
          return misc.values(new Object[] { lists.cdr.apply1(localPair1), lists.cdr.apply1(localPair2) });
        }
        catch (ClassCastException paramProcedure)
        {
          Object localObject3;
          throw new WrongType(paramProcedure, "set-cdr!", 1, localObject1);
        }
        if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {}
      }
      catch (ClassCastException paramProcedure)
      {
        try
        {
          localObject3 = (Pair)localObject2;
          lists.setCdr$Ex((Pair)localObject3, paramObject);
          localObject3 = lists.cdr.apply1(paramObject);
          localObject2 = paramObject;
          paramObject = localObject3;
        }
        catch (ClassCastException paramProcedure)
        {
          throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
        }
        try
        {
          localObject3 = (Pair)localObject1;
          lists.setCdr$Ex((Pair)localObject3, paramObject);
          localObject3 = lists.cdr.apply1(paramObject);
          localObject1 = paramObject;
          paramObject = localObject3;
        }
        catch (ClassCastException paramProcedure)
        {
          throw new WrongType(paramProcedure, "set-cdr!", 1, localObject1);
        }
        paramProcedure = paramProcedure;
        throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
      }
    }
  }
  
  public static Object reduce(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    if (isNullList(paramObject2) != Boolean.FALSE) {
      return paramObject1;
    }
    return fold$V(paramProcedure, lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2), new Object[0]);
  }
  
  public static Object reduceRight(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    frame11 localframe11 = new frame11();
    localframe11.f = paramProcedure;
    if (isNullList(paramObject2) != Boolean.FALSE) {
      return paramObject1;
    }
    return localframe11.lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2));
  }
  
  public static Object remove(Object paramObject1, Object paramObject2)
  {
    frame15 localframe15 = new frame15();
    localframe15.pred = paramObject1;
    return filter(localframe15.lambda$Fn14, paramObject2);
  }
  
  public static Object remove$Ex(Object paramObject1, Object paramObject2)
  {
    frame16 localframe16 = new frame16();
    localframe16.pred = paramObject1;
    return filter$Ex(localframe16.lambda$Fn15, paramObject2);
  }
  
  public static Object seventh(Object paramObject)
  {
    return lists.caddr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object sixth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(paramObject));
  }
  
  public static Object span(Procedure paramProcedure, Object paramObject)
  {
    Object localObject2 = LList.Empty;
    localObject1 = paramObject;
    for (paramObject = localObject2;; paramObject = lists.cons(localObject2, paramObject))
    {
      if (isNullList(localObject1) != Boolean.FALSE) {}
      try
      {
        paramProcedure = (LList)paramObject;
        return misc.values(new Object[] { lists.reverse$Ex(paramProcedure), localObject1 });
      }
      catch (ClassCastException paramProcedure)
      {
        try
        {
          paramProcedure = (LList)paramObject;
          return misc.values(new Object[] { lists.reverse$Ex(paramProcedure), localObject1 });
        }
        catch (ClassCastException paramProcedure)
        {
          throw new WrongType(paramProcedure, "reverse!", 1, paramObject);
        }
        paramProcedure = paramProcedure;
        throw new WrongType(paramProcedure, "reverse!", 1, paramObject);
      }
      localObject2 = lists.car.apply1(localObject1);
      if (paramProcedure.apply1(localObject2) == Boolean.FALSE) {
        break;
      }
      localObject1 = lists.cdr.apply1(localObject1);
    }
  }
  
  public static Object span$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE) {}
    }
    else {
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE) {
        return misc.values(new Object[] { LList.Empty, paramObject });
      }
    }
    localObject1 = lists.cdr.apply1(paramObject);
    Object localObject2 = paramObject;
    if (isNullList(localObject1) != Boolean.FALSE) {}
    for (;;)
    {
      return misc.values(new Object[] { paramObject, localObject1 });
      if (paramProcedure.apply1(lists.car.apply1(localObject1)) != Boolean.FALSE)
      {
        Object localObject3 = lists.cdr.apply1(localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      try
      {
        paramProcedure = (Pair)localObject2;
        lists.setCdr$Ex(paramProcedure, LList.Empty);
      }
      catch (ClassCastException paramProcedure)
      {
        throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
      }
    }
  }
  
  public static Object splitAt(Object paramObject, IntNum paramIntNum)
  {
    Object localObject2 = LList.Empty;
    Object localObject1 = paramObject;
    paramObject = localObject2;
    for (;;)
    {
      try
      {
        localObject2 = (Number)paramIntNum;
        if (!numbers.isZero((Number)localObject2)) {}
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "zero?", 1, paramIntNum);
      }
      try
      {
        paramIntNum = (LList)paramObject;
        return misc.values(new Object[] { lists.reverse$Ex(paramIntNum), localObject1 });
      }
      catch (ClassCastException paramIntNum)
      {
        throw new WrongType(paramIntNum, "reverse!", 1, paramObject);
      }
      paramObject = lists.cons(lists.car.apply1(localObject1), paramObject);
      localObject1 = lists.cdr.apply1(localObject1);
      paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
    }
  }
  
  public static Object splitAt$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum)) {
      return misc.values(new Object[] { LList.Empty, paramObject });
    }
    paramIntNum = drop(paramObject, IntNum.add(paramIntNum, -1));
    Object localObject = lists.cdr.apply1(paramIntNum);
    try
    {
      Pair localPair = (Pair)paramIntNum;
      lists.setCdr$Ex(localPair, LList.Empty);
      return misc.values(new Object[] { paramObject, localObject });
    }
    catch (ClassCastException paramObject)
    {
      throw new WrongType((ClassCastException)paramObject, "set-cdr!", 1, paramIntNum);
    }
  }
  
  public static Object take(Object paramObject, IntNum paramIntNum)
  {
    Object localObject2 = LList.Empty;
    Object localObject1 = paramObject;
    paramObject = localObject2;
    for (;;)
    {
      try
      {
        localObject2 = (Number)paramIntNum;
        if (!numbers.isZero((Number)localObject2)) {}
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "zero?", 1, paramIntNum);
      }
      try
      {
        paramIntNum = (LList)paramObject;
        return lists.reverse$Ex(paramIntNum);
      }
      catch (ClassCastException paramIntNum)
      {
        throw new WrongType(paramIntNum, "reverse!", 1, paramObject);
      }
      localObject2 = lists.cdr.apply1(localObject1);
      paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
      paramObject = lists.cons(lists.car.apply1(localObject1), paramObject);
      localObject1 = localObject2;
    }
  }
  
  public static Object take$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum)) {
      return LList.Empty;
    }
    paramIntNum = drop(paramObject, IntNum.add(paramIntNum, -1));
    try
    {
      Pair localPair = (Pair)paramIntNum;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw new WrongType((ClassCastException)paramObject, "set-cdr!", 1, paramIntNum);
    }
  }
  
  public static Object takeRight(Object paramObject, IntNum paramIntNum)
  {
    Object localObject = drop(paramObject, paramIntNum);
    paramIntNum = (IntNum)paramObject;
    for (paramObject = localObject; lists.isPair(paramObject); paramObject = lists.cdr.apply1(paramObject)) {
      paramIntNum = lists.cdr.apply1(paramIntNum);
    }
    return paramIntNum;
  }
  
  public static Object takeWhile(Procedure paramProcedure, Object paramObject)
  {
    frame23 localframe23 = new frame23();
    localframe23.pred = paramProcedure;
    return localframe23.lambda34recur(paramObject);
  }
  
  public static Object takeWhile$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    Object localObject3;
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE) {}
    }
    else {
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
      {
        localObject3 = LList.Empty;
        return localObject3;
      }
    }
    localObject1 = lists.cdr.apply1(paramObject);
    Object localObject2 = paramObject;
    for (;;)
    {
      localObject3 = paramObject;
      if (!lists.isPair(localObject1)) {
        break;
      }
      if (paramProcedure.apply1(lists.car.apply1(localObject1)) == Boolean.FALSE) {
        break label98;
      }
      localObject3 = lists.cdr.apply1(localObject1);
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    try
    {
      label98:
      paramProcedure = (Pair)localObject2;
      lists.setCdr$Ex(paramProcedure, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException paramProcedure)
    {
      throw new WrongType(paramProcedure, "set-cdr!", 1, localObject2);
    }
  }
  
  public static Object tenth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }
  
  public static Object unfold$V(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(paramArrayOfObject))
    {
      Object localObject2 = lists.car.apply1(paramArrayOfObject);
      if (lists.isPair(lists.cdr.apply1(paramArrayOfObject))) {
        return Scheme.apply.applyN(new Object[] { misc.error, "Too many arguments", unfold, paramProcedure1, paramProcedure2, paramProcedure3, paramObject, paramArrayOfObject });
      }
      localObject1 = LList.Empty;
      paramArrayOfObject = (Object[])paramObject;
      paramObject = localObject1;
      for (;;)
      {
        if (paramProcedure1.apply1(paramArrayOfObject) != Boolean.FALSE) {
          return appendReverse$Ex(paramObject, Scheme.applyToArgs.apply2(localObject2, paramArrayOfObject));
        }
        localObject1 = paramProcedure3.apply1(paramArrayOfObject);
        paramObject = lists.cons(paramProcedure2.apply1(paramArrayOfObject), paramObject);
        paramArrayOfObject = (Object[])localObject1;
      }
    }
    Object localObject1 = LList.Empty;
    paramArrayOfObject = (Object[])paramObject;
    paramObject = localObject1;
    for (;;)
    {
      if (paramProcedure1.apply1(paramArrayOfObject) != Boolean.FALSE) {}
      try
      {
        paramProcedure1 = (LList)paramObject;
        return lists.reverse$Ex(paramProcedure1);
      }
      catch (ClassCastException paramProcedure1)
      {
        throw new WrongType(paramProcedure1, "reverse!", 1, paramObject);
      }
      localObject1 = paramProcedure3.apply1(paramArrayOfObject);
      paramObject = lists.cons(paramProcedure2.apply1(paramArrayOfObject), paramObject);
      paramArrayOfObject = (Object[])localObject1;
    }
  }
  
  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject)
  {
    return unfoldRight(paramProcedure1, paramProcedure2, paramProcedure3, paramObject, LList.Empty);
  }
  
  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject1, Object paramObject2)
  {
    for (;;)
    {
      if (paramProcedure1.apply1(paramObject1) != Boolean.FALSE) {
        return paramObject2;
      }
      Object localObject = paramProcedure3.apply1(paramObject1);
      paramObject2 = lists.cons(paramProcedure2.apply1(paramObject1), paramObject2);
      paramObject1 = localObject;
    }
  }
  
  public static LList unzip1(Object paramObject)
  {
    Object localObject = LList.Empty;
    for (;;)
    {
      if (paramObject == LList.Empty) {
        return LList.reverseInPlace(localObject);
      }
      try
      {
        Pair localPair = (Pair)paramObject;
        paramObject = localPair.getCdr();
        localObject = Pair.make(lists.car.apply1(localPair.getCar()), localObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, paramObject);
      }
    }
  }
  
  public static Object unzip2(Object paramObject)
  {
    new frame();
    return frame.lambda2recur(paramObject);
  }
  
  public static Object unzip3(Object paramObject)
  {
    new frame1();
    return frame1.lambda5recur(paramObject);
  }
  
  public static Object unzip4(Object paramObject)
  {
    new frame3();
    return frame3.lambda8recur(paramObject);
  }
  
  public static Object unzip5(Object paramObject)
  {
    new frame5();
    return frame5.lambda11recur(paramObject);
  }
  
  public static Pair xcons(Object paramObject1, Object paramObject2)
  {
    return lists.cons(paramObject2, paramObject1);
  }
  
  public static Object zip$V(Object paramObject, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(Scheme.map, LangObjType.listType, paramObject, paramArrayOfObject);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    }
    try
    {
      paramModuleMethod = (LList)paramObject;
      return listCopy(paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "list-copy", 1, paramObject);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject);
      return iota(paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 1, paramObject);
    }
    return isProperList(paramObject);
    return isDottedList(paramObject);
    return isCircularList(paramObject);
    if (isNotPair(paramObject)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
    return isNullList(paramObject);
    return length$Pl(paramObject);
    return fifth(paramObject);
    return sixth(paramObject);
    return seventh(paramObject);
    return eighth(paramObject);
    return ninth(paramObject);
    return tenth(paramObject);
    return car$PlCdr(paramObject);
    return last(paramObject);
    try
    {
      paramModuleMethod = (Pair)paramObject;
      return lastPair(paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "last-pair", 1, paramObject);
    }
    return unzip1(paramObject);
    return unzip2(paramObject);
    return unzip3(paramObject);
    return unzip4(paramObject);
    return unzip5(paramObject);
    return concatenate(paramObject);
    return concatenate$Ex(paramObject);
    return deleteDuplicates(paramObject);
    return deleteDuplicates$Ex(paramObject);
    return alistCopy(paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 78: 
      return xcons(paramObject1, paramObject2);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject2;
      return listTabulate(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "list-tabulate", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 1, paramObject1);
    }
    try
    {
      paramObject1 = LangObjType.coerceNumeric(paramObject2);
      return iota(paramModuleMethod, (Numeric)paramObject1);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return take(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "take", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return drop(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "drop", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return take$Ex(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "take!", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return takeRight(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "take-right", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return dropRight(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "drop-right", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return dropRight$Ex(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "drop-right!", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return splitAt(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "split-at", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject2);
      return splitAt$Ex(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "split-at!", 2, paramObject2);
    }
    return appendReverse(paramObject1, paramObject2);
    return appendReverse$Ex(paramObject1, paramObject2);
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return filter(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "filter", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return filter$Ex(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "filter!", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return partition(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "partition", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return partition$Ex(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "partition!", 1, paramObject1);
    }
    return remove(paramObject1, paramObject2);
    return remove$Ex(paramObject1, paramObject2);
    return delete(paramObject1, paramObject2);
    return delete$Ex(paramObject1, paramObject2);
    try
    {
      paramModuleMethod = (Procedure)paramObject2;
      return deleteDuplicates(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "delete-duplicates", 2, paramObject2);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject2;
      return deleteDuplicates$Ex(paramObject1, paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "delete-duplicates!", 2, paramObject2);
    }
    return alistDelete(paramObject1, paramObject2);
    return alistDelete$Ex(paramObject1, paramObject2);
    return find(paramObject1, paramObject2);
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return findTail(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "find-tail", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return takeWhile(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "take-while", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return dropWhile(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "drop-while", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return takeWhile$Ex(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "take-while!", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return span(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "span", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return span$Ex(paramModuleMethod, paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "span!", 1, paramObject1);
    }
    return jdMethod_break(paramObject1, paramObject2);
    return break$Ex(paramObject1, paramObject2);
    return frame61.lambda84(paramObject1, paramObject2);
    return frame71.lambda100(paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    try
    {
      paramModuleMethod = LangObjType.coerceIntNum(paramObject1);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 1, paramObject1);
    }
    try
    {
      paramObject1 = LangObjType.coerceNumeric(paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 2, paramObject2);
    }
    try
    {
      paramObject2 = LangObjType.coerceNumeric(paramObject3);
      return iota(paramModuleMethod, (Numeric)paramObject1, (Numeric)paramObject2);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "iota", 3, paramObject3);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return reduce(paramModuleMethod, paramObject2, paramObject3);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "reduce", 1, paramObject1);
    }
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
      return reduceRight(paramModuleMethod, paramObject2, paramObject3);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "reduce-right", 1, paramObject1);
    }
    return delete(paramObject1, paramObject2, paramObject3);
    return delete$Ex(paramObject1, paramObject2, paramObject3);
    return alistCons(paramObject1, paramObject2, paramObject3);
    return alistDelete(paramObject1, paramObject2, paramObject3);
    return alistDelete$Ex(paramObject1, paramObject2, paramObject3);
  }
  
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 123) {}
    try
    {
      paramModuleMethod = (Procedure)paramObject1;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "unfold-right", 1, paramObject1);
    }
    try
    {
      paramObject1 = (Procedure)paramObject2;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "unfold-right", 2, paramObject2);
    }
    try
    {
      paramObject2 = (Procedure)paramObject3;
      return unfoldRight(paramModuleMethod, (Procedure)paramObject1, (Procedure)paramObject2, paramObject4);
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "unfold-right", 3, paramObject3);
    }
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1805	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+284->288, 79:+291->295, 81:+333->337, 86:+338->342, 92:+380->384, 94:+422->426, 117:+464->468, 122:+469->473, 123:+525->529, 125:+599->603, 126:+683->687, 127:+746->750, 128:+809->813, 129:+872->876, 132:+935->939, 133:+984->988, 134:+1033->1037, 135:+1089->1093, 136:+1145->1149, 166:+1201->1205, 167:+1257->1261, 168:+1313->1317, 169:+1369->1373, 170:+1415->1419, 171:+1461->1465, 172:+1517->1521, 173:+1563->1567, 174:+1609->1613, 175:+1665->1669, 176:+1721->1725, 177:+1777->1781, 178:+1833->1837, 179:+1879->1883, 180:+1925->1929, 181:+1981->1985
    //   288: aload_0
    //   289: aload_1
    //   290: aload_2
    //   291: invokespecial 1931	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: aload_2
    //   296: iconst_0
    //   297: aaload
    //   298: astore_1
    //   299: aload_2
    //   300: arraylength
    //   301: iconst_1
    //   302: isub
    //   303: istore_3
    //   304: iload_3
    //   305: anewarray 553	java/lang/Object
    //   308: astore 4
    //   310: iload_3
    //   311: iconst_1
    //   312: isub
    //   313: istore_3
    //   314: iload_3
    //   315: ifge +10 -> 325
    //   318: aload_1
    //   319: aload 4
    //   321: invokestatic 1933	gnu/kawa/slib/srfi1:makeList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   324: areturn
    //   325: aload 4
    //   327: iload_3
    //   328: aload_2
    //   329: iload_3
    //   330: iconst_1
    //   331: iadd
    //   332: aaload
    //   333: aastore
    //   334: goto -24 -> 310
    //   337: aload_2
    //   338: invokestatic 1935	gnu/kawa/slib/srfi1:cons$St	([Ljava/lang/Object;)Ljava/lang/Object;
    //   341: areturn
    //   342: aload_2
    //   343: iconst_0
    //   344: aaload
    //   345: astore_1
    //   346: aload_2
    //   347: arraylength
    //   348: iconst_1
    //   349: isub
    //   350: istore_3
    //   351: iload_3
    //   352: anewarray 553	java/lang/Object
    //   355: astore 4
    //   357: iload_3
    //   358: iconst_1
    //   359: isub
    //   360: istore_3
    //   361: iload_3
    //   362: ifge +10 -> 372
    //   365: aload_1
    //   366: aload 4
    //   368: invokestatic 1937	gnu/kawa/slib/srfi1:circularList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
    //   371: areturn
    //   372: aload 4
    //   374: iload_3
    //   375: aload_2
    //   376: iload_3
    //   377: iconst_1
    //   378: iadd
    //   379: aaload
    //   380: aastore
    //   381: goto -24 -> 357
    //   384: aload_2
    //   385: iconst_0
    //   386: aaload
    //   387: astore_1
    //   388: aload_2
    //   389: arraylength
    //   390: iconst_1
    //   391: isub
    //   392: istore_3
    //   393: iload_3
    //   394: anewarray 553	java/lang/Object
    //   397: astore 4
    //   399: iload_3
    //   400: iconst_1
    //   401: isub
    //   402: istore_3
    //   403: iload_3
    //   404: ifge +10 -> 414
    //   407: aload_1
    //   408: aload 4
    //   410: invokestatic 1939	gnu/kawa/slib/srfi1:list$Eq$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   413: areturn
    //   414: aload 4
    //   416: iload_3
    //   417: aload_2
    //   418: iload_3
    //   419: iconst_1
    //   420: iadd
    //   421: aaload
    //   422: aastore
    //   423: goto -24 -> 399
    //   426: aload_2
    //   427: iconst_0
    //   428: aaload
    //   429: astore_1
    //   430: aload_2
    //   431: arraylength
    //   432: iconst_1
    //   433: isub
    //   434: istore_3
    //   435: iload_3
    //   436: anewarray 553	java/lang/Object
    //   439: astore 4
    //   441: iload_3
    //   442: iconst_1
    //   443: isub
    //   444: istore_3
    //   445: iload_3
    //   446: ifge +10 -> 456
    //   449: aload_1
    //   450: aload 4
    //   452: invokestatic 1941	gnu/kawa/slib/srfi1:zip$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   455: areturn
    //   456: aload 4
    //   458: iload_3
    //   459: aload_2
    //   460: iload_3
    //   461: iconst_1
    //   462: iadd
    //   463: aaload
    //   464: aastore
    //   465: goto -24 -> 441
    //   468: aload_2
    //   469: invokestatic 1710	gnu/kawa/slib/srfi1:append$Ex$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   472: areturn
    //   473: aload_2
    //   474: iconst_0
    //   475: aaload
    //   476: astore 4
    //   478: aload 4
    //   480: checkcast 1248	gnu/mapping/Procedure
    //   483: astore_1
    //   484: aload_2
    //   485: iconst_1
    //   486: aaload
    //   487: astore 4
    //   489: aload_2
    //   490: arraylength
    //   491: iconst_2
    //   492: isub
    //   493: istore_3
    //   494: iload_3
    //   495: anewarray 553	java/lang/Object
    //   498: astore 5
    //   500: iload_3
    //   501: iconst_1
    //   502: isub
    //   503: istore_3
    //   504: iload_3
    //   505: ifge +12 -> 517
    //   508: aload_1
    //   509: aload 4
    //   511: aload 5
    //   513: invokestatic 1943	gnu/kawa/slib/srfi1:count$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   516: areturn
    //   517: aload 5
    //   519: iload_3
    //   520: aload_2
    //   521: iload_3
    //   522: iconst_2
    //   523: iadd
    //   524: aaload
    //   525: aastore
    //   526: goto -26 -> 500
    //   529: aload_2
    //   530: arraylength
    //   531: iconst_4
    //   532: isub
    //   533: istore_3
    //   534: aload_2
    //   535: iconst_0
    //   536: aaload
    //   537: astore 4
    //   539: aload 4
    //   541: checkcast 1248	gnu/mapping/Procedure
    //   544: astore_1
    //   545: aload_2
    //   546: iconst_1
    //   547: aaload
    //   548: astore 5
    //   550: aload 5
    //   552: checkcast 1248	gnu/mapping/Procedure
    //   555: astore 4
    //   557: aload_2
    //   558: iconst_2
    //   559: aaload
    //   560: astore 5
    //   562: aload 5
    //   564: checkcast 1248	gnu/mapping/Procedure
    //   567: astore 6
    //   569: aload_2
    //   570: iconst_3
    //   571: aaload
    //   572: astore 5
    //   574: iload_3
    //   575: ifgt +14 -> 589
    //   578: aload_1
    //   579: aload 4
    //   581: aload 6
    //   583: aload 5
    //   585: invokestatic 1926	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   588: areturn
    //   589: aload_1
    //   590: aload 4
    //   592: aload 6
    //   594: aload 5
    //   596: aload_2
    //   597: iconst_4
    //   598: aaload
    //   599: invokestatic 1778	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   602: areturn
    //   603: aload_2
    //   604: iconst_0
    //   605: aaload
    //   606: astore 4
    //   608: aload 4
    //   610: checkcast 1248	gnu/mapping/Procedure
    //   613: astore_1
    //   614: aload_2
    //   615: iconst_1
    //   616: aaload
    //   617: astore 5
    //   619: aload 5
    //   621: checkcast 1248	gnu/mapping/Procedure
    //   624: astore 4
    //   626: aload_2
    //   627: iconst_2
    //   628: aaload
    //   629: astore 6
    //   631: aload 6
    //   633: checkcast 1248	gnu/mapping/Procedure
    //   636: astore 5
    //   638: aload_2
    //   639: iconst_3
    //   640: aaload
    //   641: astore 6
    //   643: aload_2
    //   644: arraylength
    //   645: iconst_4
    //   646: isub
    //   647: istore_3
    //   648: iload_3
    //   649: anewarray 553	java/lang/Object
    //   652: astore 7
    //   654: iload_3
    //   655: iconst_1
    //   656: isub
    //   657: istore_3
    //   658: iload_3
    //   659: ifge +16 -> 675
    //   662: aload_1
    //   663: aload 4
    //   665: aload 5
    //   667: aload 6
    //   669: aload 7
    //   671: invokestatic 1945	gnu/kawa/slib/srfi1:unfold$V	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   674: areturn
    //   675: aload 7
    //   677: iload_3
    //   678: aload_2
    //   679: iload_3
    //   680: iconst_4
    //   681: iadd
    //   682: aaload
    //   683: aastore
    //   684: goto -30 -> 654
    //   687: aload_2
    //   688: iconst_0
    //   689: aaload
    //   690: astore 4
    //   692: aload 4
    //   694: checkcast 1248	gnu/mapping/Procedure
    //   697: astore_1
    //   698: aload_2
    //   699: iconst_1
    //   700: aaload
    //   701: astore 4
    //   703: aload_2
    //   704: iconst_2
    //   705: aaload
    //   706: astore 5
    //   708: aload_2
    //   709: arraylength
    //   710: iconst_3
    //   711: isub
    //   712: istore_3
    //   713: iload_3
    //   714: anewarray 553	java/lang/Object
    //   717: astore 6
    //   719: iload_3
    //   720: iconst_1
    //   721: isub
    //   722: istore_3
    //   723: iload_3
    //   724: ifge +14 -> 738
    //   727: aload_1
    //   728: aload 4
    //   730: aload 5
    //   732: aload 6
    //   734: invokestatic 1600	gnu/kawa/slib/srfi1:fold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   737: areturn
    //   738: aload 6
    //   740: iload_3
    //   741: aload_2
    //   742: iload_3
    //   743: iconst_3
    //   744: iadd
    //   745: aaload
    //   746: aastore
    //   747: goto -28 -> 719
    //   750: aload_2
    //   751: iconst_0
    //   752: aaload
    //   753: astore 4
    //   755: aload 4
    //   757: checkcast 1248	gnu/mapping/Procedure
    //   760: astore_1
    //   761: aload_2
    //   762: iconst_1
    //   763: aaload
    //   764: astore 4
    //   766: aload_2
    //   767: iconst_2
    //   768: aaload
    //   769: astore 5
    //   771: aload_2
    //   772: arraylength
    //   773: iconst_3
    //   774: isub
    //   775: istore_3
    //   776: iload_3
    //   777: anewarray 553	java/lang/Object
    //   780: astore 6
    //   782: iload_3
    //   783: iconst_1
    //   784: isub
    //   785: istore_3
    //   786: iload_3
    //   787: ifge +14 -> 801
    //   790: aload_1
    //   791: aload 4
    //   793: aload 5
    //   795: aload 6
    //   797: invokestatic 1947	gnu/kawa/slib/srfi1:foldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   800: areturn
    //   801: aload 6
    //   803: iload_3
    //   804: aload_2
    //   805: iload_3
    //   806: iconst_3
    //   807: iadd
    //   808: aaload
    //   809: aastore
    //   810: goto -28 -> 782
    //   813: aload_2
    //   814: iconst_0
    //   815: aaload
    //   816: astore 4
    //   818: aload 4
    //   820: checkcast 1248	gnu/mapping/Procedure
    //   823: astore_1
    //   824: aload_2
    //   825: iconst_1
    //   826: aaload
    //   827: astore 4
    //   829: aload_2
    //   830: iconst_2
    //   831: aaload
    //   832: astore 5
    //   834: aload_2
    //   835: arraylength
    //   836: iconst_3
    //   837: isub
    //   838: istore_3
    //   839: iload_3
    //   840: anewarray 553	java/lang/Object
    //   843: astore 6
    //   845: iload_3
    //   846: iconst_1
    //   847: isub
    //   848: istore_3
    //   849: iload_3
    //   850: ifge +14 -> 864
    //   853: aload_1
    //   854: aload 4
    //   856: aload 5
    //   858: aload 6
    //   860: invokestatic 1949	gnu/kawa/slib/srfi1:pairFoldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   863: areturn
    //   864: aload 6
    //   866: iload_3
    //   867: aload_2
    //   868: iload_3
    //   869: iconst_3
    //   870: iadd
    //   871: aaload
    //   872: aastore
    //   873: goto -28 -> 845
    //   876: aload_2
    //   877: iconst_0
    //   878: aaload
    //   879: astore 4
    //   881: aload 4
    //   883: checkcast 1248	gnu/mapping/Procedure
    //   886: astore_1
    //   887: aload_2
    //   888: iconst_1
    //   889: aaload
    //   890: astore 4
    //   892: aload_2
    //   893: iconst_2
    //   894: aaload
    //   895: astore 5
    //   897: aload_2
    //   898: arraylength
    //   899: iconst_3
    //   900: isub
    //   901: istore_3
    //   902: iload_3
    //   903: anewarray 553	java/lang/Object
    //   906: astore 6
    //   908: iload_3
    //   909: iconst_1
    //   910: isub
    //   911: istore_3
    //   912: iload_3
    //   913: ifge +14 -> 927
    //   916: aload_1
    //   917: aload 4
    //   919: aload 5
    //   921: aload 6
    //   923: invokestatic 1951	gnu/kawa/slib/srfi1:pairFold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   926: areturn
    //   927: aload 6
    //   929: iload_3
    //   930: aload_2
    //   931: iload_3
    //   932: iconst_3
    //   933: iadd
    //   934: aaload
    //   935: aastore
    //   936: goto -28 -> 908
    //   939: aload_2
    //   940: iconst_0
    //   941: aaload
    //   942: astore_1
    //   943: aload_2
    //   944: iconst_1
    //   945: aaload
    //   946: astore 4
    //   948: aload_2
    //   949: arraylength
    //   950: iconst_2
    //   951: isub
    //   952: istore_3
    //   953: iload_3
    //   954: anewarray 553	java/lang/Object
    //   957: astore 5
    //   959: iload_3
    //   960: iconst_1
    //   961: isub
    //   962: istore_3
    //   963: iload_3
    //   964: ifge +12 -> 976
    //   967: aload_1
    //   968: aload 4
    //   970: aload 5
    //   972: invokestatic 1953	gnu/kawa/slib/srfi1:appendMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   975: areturn
    //   976: aload 5
    //   978: iload_3
    //   979: aload_2
    //   980: iload_3
    //   981: iconst_2
    //   982: iadd
    //   983: aaload
    //   984: aastore
    //   985: goto -26 -> 959
    //   988: aload_2
    //   989: iconst_0
    //   990: aaload
    //   991: astore_1
    //   992: aload_2
    //   993: iconst_1
    //   994: aaload
    //   995: astore 4
    //   997: aload_2
    //   998: arraylength
    //   999: iconst_2
    //   1000: isub
    //   1001: istore_3
    //   1002: iload_3
    //   1003: anewarray 553	java/lang/Object
    //   1006: astore 5
    //   1008: iload_3
    //   1009: iconst_1
    //   1010: isub
    //   1011: istore_3
    //   1012: iload_3
    //   1013: ifge +12 -> 1025
    //   1016: aload_1
    //   1017: aload 4
    //   1019: aload 5
    //   1021: invokestatic 1955	gnu/kawa/slib/srfi1:appendMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1024: areturn
    //   1025: aload 5
    //   1027: iload_3
    //   1028: aload_2
    //   1029: iload_3
    //   1030: iconst_2
    //   1031: iadd
    //   1032: aaload
    //   1033: aastore
    //   1034: goto -26 -> 1008
    //   1037: aload_2
    //   1038: iconst_0
    //   1039: aaload
    //   1040: astore 4
    //   1042: aload 4
    //   1044: checkcast 1248	gnu/mapping/Procedure
    //   1047: astore_1
    //   1048: aload_2
    //   1049: iconst_1
    //   1050: aaload
    //   1051: astore 4
    //   1053: aload_2
    //   1054: arraylength
    //   1055: iconst_2
    //   1056: isub
    //   1057: istore_3
    //   1058: iload_3
    //   1059: anewarray 553	java/lang/Object
    //   1062: astore 5
    //   1064: iload_3
    //   1065: iconst_1
    //   1066: isub
    //   1067: istore_3
    //   1068: iload_3
    //   1069: ifge +12 -> 1081
    //   1072: aload_1
    //   1073: aload 4
    //   1075: aload 5
    //   1077: invokestatic 1699	gnu/kawa/slib/srfi1:pairForEach$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1080: areturn
    //   1081: aload 5
    //   1083: iload_3
    //   1084: aload_2
    //   1085: iload_3
    //   1086: iconst_2
    //   1087: iadd
    //   1088: aaload
    //   1089: aastore
    //   1090: goto -26 -> 1064
    //   1093: aload_2
    //   1094: iconst_0
    //   1095: aaload
    //   1096: astore 4
    //   1098: aload 4
    //   1100: checkcast 1248	gnu/mapping/Procedure
    //   1103: astore_1
    //   1104: aload_2
    //   1105: iconst_1
    //   1106: aaload
    //   1107: astore 4
    //   1109: aload_2
    //   1110: arraylength
    //   1111: iconst_2
    //   1112: isub
    //   1113: istore_3
    //   1114: iload_3
    //   1115: anewarray 553	java/lang/Object
    //   1118: astore 5
    //   1120: iload_3
    //   1121: iconst_1
    //   1122: isub
    //   1123: istore_3
    //   1124: iload_3
    //   1125: ifge +12 -> 1137
    //   1128: aload_1
    //   1129: aload 4
    //   1131: aload 5
    //   1133: invokestatic 1957	gnu/kawa/slib/srfi1:map$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1136: areturn
    //   1137: aload 5
    //   1139: iload_3
    //   1140: aload_2
    //   1141: iload_3
    //   1142: iconst_2
    //   1143: iadd
    //   1144: aaload
    //   1145: aastore
    //   1146: goto -26 -> 1120
    //   1149: aload_2
    //   1150: iconst_0
    //   1151: aaload
    //   1152: astore 4
    //   1154: aload 4
    //   1156: checkcast 1248	gnu/mapping/Procedure
    //   1159: astore_1
    //   1160: aload_2
    //   1161: iconst_1
    //   1162: aaload
    //   1163: astore 4
    //   1165: aload_2
    //   1166: arraylength
    //   1167: iconst_2
    //   1168: isub
    //   1169: istore_3
    //   1170: iload_3
    //   1171: anewarray 553	java/lang/Object
    //   1174: astore 5
    //   1176: iload_3
    //   1177: iconst_1
    //   1178: isub
    //   1179: istore_3
    //   1180: iload_3
    //   1181: ifge +12 -> 1193
    //   1184: aload_1
    //   1185: aload 4
    //   1187: aload 5
    //   1189: invokestatic 1959	gnu/kawa/slib/srfi1:filterMap$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1192: areturn
    //   1193: aload 5
    //   1195: iload_3
    //   1196: aload_2
    //   1197: iload_3
    //   1198: iconst_2
    //   1199: iadd
    //   1200: aaload
    //   1201: aastore
    //   1202: goto -26 -> 1176
    //   1205: aload_2
    //   1206: iconst_0
    //   1207: aaload
    //   1208: astore 4
    //   1210: aload 4
    //   1212: checkcast 1248	gnu/mapping/Procedure
    //   1215: astore_1
    //   1216: aload_2
    //   1217: iconst_1
    //   1218: aaload
    //   1219: astore 4
    //   1221: aload_2
    //   1222: arraylength
    //   1223: iconst_2
    //   1224: isub
    //   1225: istore_3
    //   1226: iload_3
    //   1227: anewarray 553	java/lang/Object
    //   1230: astore 5
    //   1232: iload_3
    //   1233: iconst_1
    //   1234: isub
    //   1235: istore_3
    //   1236: iload_3
    //   1237: ifge +12 -> 1249
    //   1240: aload_1
    //   1241: aload 4
    //   1243: aload 5
    //   1245: invokestatic 1648	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1248: areturn
    //   1249: aload 5
    //   1251: iload_3
    //   1252: aload_2
    //   1253: iload_3
    //   1254: iconst_2
    //   1255: iadd
    //   1256: aaload
    //   1257: aastore
    //   1258: goto -26 -> 1232
    //   1261: aload_2
    //   1262: iconst_0
    //   1263: aaload
    //   1264: astore 4
    //   1266: aload 4
    //   1268: checkcast 1248	gnu/mapping/Procedure
    //   1271: astore_1
    //   1272: aload_2
    //   1273: iconst_1
    //   1274: aaload
    //   1275: astore 4
    //   1277: aload_2
    //   1278: arraylength
    //   1279: iconst_2
    //   1280: isub
    //   1281: istore_3
    //   1282: iload_3
    //   1283: anewarray 553	java/lang/Object
    //   1286: astore 5
    //   1288: iload_3
    //   1289: iconst_1
    //   1290: isub
    //   1291: istore_3
    //   1292: iload_3
    //   1293: ifge +12 -> 1305
    //   1296: aload_1
    //   1297: aload 4
    //   1299: aload 5
    //   1301: invokestatic 557	gnu/kawa/slib/srfi1:every$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1304: areturn
    //   1305: aload 5
    //   1307: iload_3
    //   1308: aload_2
    //   1309: iload_3
    //   1310: iconst_2
    //   1311: iadd
    //   1312: aaload
    //   1313: aastore
    //   1314: goto -26 -> 1288
    //   1317: aload_2
    //   1318: iconst_0
    //   1319: aaload
    //   1320: astore 4
    //   1322: aload 4
    //   1324: checkcast 1248	gnu/mapping/Procedure
    //   1327: astore_1
    //   1328: aload_2
    //   1329: iconst_1
    //   1330: aaload
    //   1331: astore 4
    //   1333: aload_2
    //   1334: arraylength
    //   1335: iconst_2
    //   1336: isub
    //   1337: istore_3
    //   1338: iload_3
    //   1339: anewarray 553	java/lang/Object
    //   1342: astore 5
    //   1344: iload_3
    //   1345: iconst_1
    //   1346: isub
    //   1347: istore_3
    //   1348: iload_3
    //   1349: ifge +12 -> 1361
    //   1352: aload_1
    //   1353: aload 4
    //   1355: aload 5
    //   1357: invokestatic 1961	gnu/kawa/slib/srfi1:listIndex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1360: areturn
    //   1361: aload 5
    //   1363: iload_3
    //   1364: aload_2
    //   1365: iload_3
    //   1366: iconst_2
    //   1367: iadd
    //   1368: aaload
    //   1369: aastore
    //   1370: goto -26 -> 1344
    //   1373: aload_2
    //   1374: iconst_0
    //   1375: aaload
    //   1376: astore_1
    //   1377: aload_1
    //   1378: checkcast 1248	gnu/mapping/Procedure
    //   1381: astore 4
    //   1383: aload_2
    //   1384: arraylength
    //   1385: iconst_1
    //   1386: isub
    //   1387: istore_3
    //   1388: iload_3
    //   1389: anewarray 553	java/lang/Object
    //   1392: astore_1
    //   1393: iload_3
    //   1394: iconst_1
    //   1395: isub
    //   1396: istore_3
    //   1397: iload_3
    //   1398: ifge +10 -> 1408
    //   1401: aload 4
    //   1403: aload_1
    //   1404: invokestatic 1963	gnu/kawa/slib/srfi1:lset$Ls$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1407: areturn
    //   1408: aload_1
    //   1409: iload_3
    //   1410: aload_2
    //   1411: iload_3
    //   1412: iconst_1
    //   1413: iadd
    //   1414: aaload
    //   1415: aastore
    //   1416: goto -23 -> 1393
    //   1419: aload_2
    //   1420: iconst_0
    //   1421: aaload
    //   1422: astore_1
    //   1423: aload_1
    //   1424: checkcast 1248	gnu/mapping/Procedure
    //   1427: astore 4
    //   1429: aload_2
    //   1430: arraylength
    //   1431: iconst_1
    //   1432: isub
    //   1433: istore_3
    //   1434: iload_3
    //   1435: anewarray 553	java/lang/Object
    //   1438: astore_1
    //   1439: iload_3
    //   1440: iconst_1
    //   1441: isub
    //   1442: istore_3
    //   1443: iload_3
    //   1444: ifge +10 -> 1454
    //   1447: aload 4
    //   1449: aload_1
    //   1450: invokestatic 1965	gnu/kawa/slib/srfi1:lset$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1453: areturn
    //   1454: aload_1
    //   1455: iload_3
    //   1456: aload_2
    //   1457: iload_3
    //   1458: iconst_1
    //   1459: iadd
    //   1460: aaload
    //   1461: aastore
    //   1462: goto -23 -> 1439
    //   1465: aload_2
    //   1466: iconst_0
    //   1467: aaload
    //   1468: astore 4
    //   1470: aload 4
    //   1472: checkcast 1248	gnu/mapping/Procedure
    //   1475: astore_1
    //   1476: aload_2
    //   1477: iconst_1
    //   1478: aaload
    //   1479: astore 4
    //   1481: aload_2
    //   1482: arraylength
    //   1483: iconst_2
    //   1484: isub
    //   1485: istore_3
    //   1486: iload_3
    //   1487: anewarray 553	java/lang/Object
    //   1490: astore 5
    //   1492: iload_3
    //   1493: iconst_1
    //   1494: isub
    //   1495: istore_3
    //   1496: iload_3
    //   1497: ifge +12 -> 1509
    //   1500: aload_1
    //   1501: aload 4
    //   1503: aload 5
    //   1505: invokestatic 1967	gnu/kawa/slib/srfi1:lsetAdjoin$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1508: areturn
    //   1509: aload 5
    //   1511: iload_3
    //   1512: aload_2
    //   1513: iload_3
    //   1514: iconst_2
    //   1515: iadd
    //   1516: aaload
    //   1517: aastore
    //   1518: goto -26 -> 1492
    //   1521: aload_2
    //   1522: iconst_0
    //   1523: aaload
    //   1524: astore_1
    //   1525: aload_1
    //   1526: checkcast 1248	gnu/mapping/Procedure
    //   1529: astore 4
    //   1531: aload_2
    //   1532: arraylength
    //   1533: iconst_1
    //   1534: isub
    //   1535: istore_3
    //   1536: iload_3
    //   1537: anewarray 553	java/lang/Object
    //   1540: astore_1
    //   1541: iload_3
    //   1542: iconst_1
    //   1543: isub
    //   1544: istore_3
    //   1545: iload_3
    //   1546: ifge +10 -> 1556
    //   1549: aload 4
    //   1551: aload_1
    //   1552: invokestatic 1969	gnu/kawa/slib/srfi1:lsetUnion$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1555: areturn
    //   1556: aload_1
    //   1557: iload_3
    //   1558: aload_2
    //   1559: iload_3
    //   1560: iconst_1
    //   1561: iadd
    //   1562: aaload
    //   1563: aastore
    //   1564: goto -23 -> 1541
    //   1567: aload_2
    //   1568: iconst_0
    //   1569: aaload
    //   1570: astore_1
    //   1571: aload_1
    //   1572: checkcast 1248	gnu/mapping/Procedure
    //   1575: astore 4
    //   1577: aload_2
    //   1578: arraylength
    //   1579: iconst_1
    //   1580: isub
    //   1581: istore_3
    //   1582: iload_3
    //   1583: anewarray 553	java/lang/Object
    //   1586: astore_1
    //   1587: iload_3
    //   1588: iconst_1
    //   1589: isub
    //   1590: istore_3
    //   1591: iload_3
    //   1592: ifge +10 -> 1602
    //   1595: aload 4
    //   1597: aload_1
    //   1598: invokestatic 1971	gnu/kawa/slib/srfi1:lsetUnion$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1601: areturn
    //   1602: aload_1
    //   1603: iload_3
    //   1604: aload_2
    //   1605: iload_3
    //   1606: iconst_1
    //   1607: iadd
    //   1608: aaload
    //   1609: aastore
    //   1610: goto -23 -> 1587
    //   1613: aload_2
    //   1614: iconst_0
    //   1615: aaload
    //   1616: astore 4
    //   1618: aload 4
    //   1620: checkcast 1248	gnu/mapping/Procedure
    //   1623: astore_1
    //   1624: aload_2
    //   1625: iconst_1
    //   1626: aaload
    //   1627: astore 4
    //   1629: aload_2
    //   1630: arraylength
    //   1631: iconst_2
    //   1632: isub
    //   1633: istore_3
    //   1634: iload_3
    //   1635: anewarray 553	java/lang/Object
    //   1638: astore 5
    //   1640: iload_3
    //   1641: iconst_1
    //   1642: isub
    //   1643: istore_3
    //   1644: iload_3
    //   1645: ifge +12 -> 1657
    //   1648: aload_1
    //   1649: aload 4
    //   1651: aload 5
    //   1653: invokestatic 1973	gnu/kawa/slib/srfi1:lsetIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1656: areturn
    //   1657: aload 5
    //   1659: iload_3
    //   1660: aload_2
    //   1661: iload_3
    //   1662: iconst_2
    //   1663: iadd
    //   1664: aaload
    //   1665: aastore
    //   1666: goto -26 -> 1640
    //   1669: aload_2
    //   1670: iconst_0
    //   1671: aaload
    //   1672: astore 4
    //   1674: aload 4
    //   1676: checkcast 1248	gnu/mapping/Procedure
    //   1679: astore_1
    //   1680: aload_2
    //   1681: iconst_1
    //   1682: aaload
    //   1683: astore 4
    //   1685: aload_2
    //   1686: arraylength
    //   1687: iconst_2
    //   1688: isub
    //   1689: istore_3
    //   1690: iload_3
    //   1691: anewarray 553	java/lang/Object
    //   1694: astore 5
    //   1696: iload_3
    //   1697: iconst_1
    //   1698: isub
    //   1699: istore_3
    //   1700: iload_3
    //   1701: ifge +12 -> 1713
    //   1704: aload_1
    //   1705: aload 4
    //   1707: aload 5
    //   1709: invokestatic 1975	gnu/kawa/slib/srfi1:lsetIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1712: areturn
    //   1713: aload 5
    //   1715: iload_3
    //   1716: aload_2
    //   1717: iload_3
    //   1718: iconst_2
    //   1719: iadd
    //   1720: aaload
    //   1721: aastore
    //   1722: goto -26 -> 1696
    //   1725: aload_2
    //   1726: iconst_0
    //   1727: aaload
    //   1728: astore 4
    //   1730: aload 4
    //   1732: checkcast 1248	gnu/mapping/Procedure
    //   1735: astore_1
    //   1736: aload_2
    //   1737: iconst_1
    //   1738: aaload
    //   1739: astore 4
    //   1741: aload_2
    //   1742: arraylength
    //   1743: iconst_2
    //   1744: isub
    //   1745: istore_3
    //   1746: iload_3
    //   1747: anewarray 553	java/lang/Object
    //   1750: astore 5
    //   1752: iload_3
    //   1753: iconst_1
    //   1754: isub
    //   1755: istore_3
    //   1756: iload_3
    //   1757: ifge +12 -> 1769
    //   1760: aload_1
    //   1761: aload 4
    //   1763: aload 5
    //   1765: invokestatic 1977	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1768: areturn
    //   1769: aload 5
    //   1771: iload_3
    //   1772: aload_2
    //   1773: iload_3
    //   1774: iconst_2
    //   1775: iadd
    //   1776: aaload
    //   1777: aastore
    //   1778: goto -26 -> 1752
    //   1781: aload_2
    //   1782: iconst_0
    //   1783: aaload
    //   1784: astore 4
    //   1786: aload 4
    //   1788: checkcast 1248	gnu/mapping/Procedure
    //   1791: astore_1
    //   1792: aload_2
    //   1793: iconst_1
    //   1794: aaload
    //   1795: astore 4
    //   1797: aload_2
    //   1798: arraylength
    //   1799: iconst_2
    //   1800: isub
    //   1801: istore_3
    //   1802: iload_3
    //   1803: anewarray 553	java/lang/Object
    //   1806: astore 5
    //   1808: iload_3
    //   1809: iconst_1
    //   1810: isub
    //   1811: istore_3
    //   1812: iload_3
    //   1813: ifge +12 -> 1825
    //   1816: aload_1
    //   1817: aload 4
    //   1819: aload 5
    //   1821: invokestatic 1979	gnu/kawa/slib/srfi1:lsetDifference$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1824: areturn
    //   1825: aload 5
    //   1827: iload_3
    //   1828: aload_2
    //   1829: iload_3
    //   1830: iconst_2
    //   1831: iadd
    //   1832: aaload
    //   1833: aastore
    //   1834: goto -26 -> 1808
    //   1837: aload_2
    //   1838: iconst_0
    //   1839: aaload
    //   1840: astore_1
    //   1841: aload_1
    //   1842: checkcast 1248	gnu/mapping/Procedure
    //   1845: astore 4
    //   1847: aload_2
    //   1848: arraylength
    //   1849: iconst_1
    //   1850: isub
    //   1851: istore_3
    //   1852: iload_3
    //   1853: anewarray 553	java/lang/Object
    //   1856: astore_1
    //   1857: iload_3
    //   1858: iconst_1
    //   1859: isub
    //   1860: istore_3
    //   1861: iload_3
    //   1862: ifge +10 -> 1872
    //   1865: aload 4
    //   1867: aload_1
    //   1868: invokestatic 1981	gnu/kawa/slib/srfi1:lsetXor$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1871: areturn
    //   1872: aload_1
    //   1873: iload_3
    //   1874: aload_2
    //   1875: iload_3
    //   1876: iconst_1
    //   1877: iadd
    //   1878: aaload
    //   1879: aastore
    //   1880: goto -23 -> 1857
    //   1883: aload_2
    //   1884: iconst_0
    //   1885: aaload
    //   1886: astore_1
    //   1887: aload_1
    //   1888: checkcast 1248	gnu/mapping/Procedure
    //   1891: astore 4
    //   1893: aload_2
    //   1894: arraylength
    //   1895: iconst_1
    //   1896: isub
    //   1897: istore_3
    //   1898: iload_3
    //   1899: anewarray 553	java/lang/Object
    //   1902: astore_1
    //   1903: iload_3
    //   1904: iconst_1
    //   1905: isub
    //   1906: istore_3
    //   1907: iload_3
    //   1908: ifge +10 -> 1918
    //   1911: aload 4
    //   1913: aload_1
    //   1914: invokestatic 1983	gnu/kawa/slib/srfi1:lsetXor$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1917: areturn
    //   1918: aload_1
    //   1919: iload_3
    //   1920: aload_2
    //   1921: iload_3
    //   1922: iconst_1
    //   1923: iadd
    //   1924: aaload
    //   1925: aastore
    //   1926: goto -23 -> 1903
    //   1929: aload_2
    //   1930: iconst_0
    //   1931: aaload
    //   1932: astore 4
    //   1934: aload 4
    //   1936: checkcast 1248	gnu/mapping/Procedure
    //   1939: astore_1
    //   1940: aload_2
    //   1941: iconst_1
    //   1942: aaload
    //   1943: astore 4
    //   1945: aload_2
    //   1946: arraylength
    //   1947: iconst_2
    //   1948: isub
    //   1949: istore_3
    //   1950: iload_3
    //   1951: anewarray 553	java/lang/Object
    //   1954: astore 5
    //   1956: iload_3
    //   1957: iconst_1
    //   1958: isub
    //   1959: istore_3
    //   1960: iload_3
    //   1961: ifge +12 -> 1973
    //   1964: aload_1
    //   1965: aload 4
    //   1967: aload 5
    //   1969: invokestatic 1985	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1972: areturn
    //   1973: aload 5
    //   1975: iload_3
    //   1976: aload_2
    //   1977: iload_3
    //   1978: iconst_2
    //   1979: iadd
    //   1980: aaload
    //   1981: aastore
    //   1982: goto -26 -> 1956
    //   1985: aload_2
    //   1986: iconst_0
    //   1987: aaload
    //   1988: astore 4
    //   1990: aload 4
    //   1992: checkcast 1248	gnu/mapping/Procedure
    //   1995: astore_1
    //   1996: aload_2
    //   1997: iconst_1
    //   1998: aaload
    //   1999: astore 4
    //   2001: aload_2
    //   2002: arraylength
    //   2003: iconst_2
    //   2004: isub
    //   2005: istore_3
    //   2006: iload_3
    //   2007: anewarray 553	java/lang/Object
    //   2010: astore 5
    //   2012: iload_3
    //   2013: iconst_1
    //   2014: isub
    //   2015: istore_3
    //   2016: iload_3
    //   2017: ifge +12 -> 2029
    //   2020: aload_1
    //   2021: aload 4
    //   2023: aload 5
    //   2025: invokestatic 1987	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2028: areturn
    //   2029: aload 5
    //   2031: iload_3
    //   2032: aload_2
    //   2033: iload_3
    //   2034: iconst_2
    //   2035: iadd
    //   2036: aaload
    //   2037: aastore
    //   2038: goto -26 -> 2012
    //   2041: astore_1
    //   2042: new 1257	gnu/mapping/WrongType
    //   2045: dup
    //   2046: aload_1
    //   2047: ldc_w 841
    //   2050: iconst_1
    //   2051: aload 4
    //   2053: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2056: athrow
    //   2057: astore_1
    //   2058: new 1257	gnu/mapping/WrongType
    //   2061: dup
    //   2062: aload_1
    //   2063: ldc_w 838
    //   2066: iconst_1
    //   2067: aload 4
    //   2069: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2072: athrow
    //   2073: astore_1
    //   2074: new 1257	gnu/mapping/WrongType
    //   2077: dup
    //   2078: aload_1
    //   2079: ldc_w 838
    //   2082: iconst_2
    //   2083: aload 5
    //   2085: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2088: athrow
    //   2089: astore_1
    //   2090: new 1257	gnu/mapping/WrongType
    //   2093: dup
    //   2094: aload_1
    //   2095: ldc_w 838
    //   2098: iconst_3
    //   2099: aload 5
    //   2101: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2104: athrow
    //   2105: astore_1
    //   2106: new 1257	gnu/mapping/WrongType
    //   2109: dup
    //   2110: aload_1
    //   2111: ldc_w 834
    //   2114: iconst_1
    //   2115: aload 4
    //   2117: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2120: athrow
    //   2121: astore_1
    //   2122: new 1257	gnu/mapping/WrongType
    //   2125: dup
    //   2126: aload_1
    //   2127: ldc_w 834
    //   2130: iconst_2
    //   2131: aload 5
    //   2133: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2136: athrow
    //   2137: astore_1
    //   2138: new 1257	gnu/mapping/WrongType
    //   2141: dup
    //   2142: aload_1
    //   2143: ldc_w 834
    //   2146: iconst_3
    //   2147: aload 6
    //   2149: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2152: athrow
    //   2153: astore_1
    //   2154: new 1257	gnu/mapping/WrongType
    //   2157: dup
    //   2158: aload_1
    //   2159: ldc_w 831
    //   2162: iconst_1
    //   2163: aload 4
    //   2165: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2168: athrow
    //   2169: astore_1
    //   2170: new 1257	gnu/mapping/WrongType
    //   2173: dup
    //   2174: aload_1
    //   2175: ldc_w 828
    //   2178: iconst_1
    //   2179: aload 4
    //   2181: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2184: athrow
    //   2185: astore_1
    //   2186: new 1257	gnu/mapping/WrongType
    //   2189: dup
    //   2190: aload_1
    //   2191: ldc_w 824
    //   2194: iconst_1
    //   2195: aload 4
    //   2197: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2200: athrow
    //   2201: astore_1
    //   2202: new 1257	gnu/mapping/WrongType
    //   2205: dup
    //   2206: aload_1
    //   2207: ldc_w 820
    //   2210: iconst_1
    //   2211: aload 4
    //   2213: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2216: athrow
    //   2217: astore_1
    //   2218: new 1257	gnu/mapping/WrongType
    //   2221: dup
    //   2222: aload_1
    //   2223: ldc_w 801
    //   2226: iconst_1
    //   2227: aload 4
    //   2229: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2232: athrow
    //   2233: astore_1
    //   2234: new 1257	gnu/mapping/WrongType
    //   2237: dup
    //   2238: aload_1
    //   2239: ldc_w 797
    //   2242: iconst_1
    //   2243: aload 4
    //   2245: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2248: athrow
    //   2249: astore_1
    //   2250: new 1257	gnu/mapping/WrongType
    //   2253: dup
    //   2254: aload_1
    //   2255: ldc_w 793
    //   2258: iconst_1
    //   2259: aload 4
    //   2261: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2264: athrow
    //   2265: astore_1
    //   2266: new 1257	gnu/mapping/WrongType
    //   2269: dup
    //   2270: aload_1
    //   2271: ldc_w 704
    //   2274: iconst_1
    //   2275: aload 4
    //   2277: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2280: athrow
    //   2281: astore_1
    //   2282: new 1257	gnu/mapping/WrongType
    //   2285: dup
    //   2286: aload_1
    //   2287: ldc_w 701
    //   2290: iconst_1
    //   2291: aload 4
    //   2293: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2296: athrow
    //   2297: astore_1
    //   2298: new 1257	gnu/mapping/WrongType
    //   2301: dup
    //   2302: aload_1
    //   2303: ldc_w 641
    //   2306: iconst_1
    //   2307: aload 4
    //   2309: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2312: athrow
    //   2313: astore_2
    //   2314: new 1257	gnu/mapping/WrongType
    //   2317: dup
    //   2318: aload_2
    //   2319: ldc_w 637
    //   2322: iconst_1
    //   2323: aload_1
    //   2324: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2327: athrow
    //   2328: astore_2
    //   2329: new 1257	gnu/mapping/WrongType
    //   2332: dup
    //   2333: aload_2
    //   2334: ldc_w 633
    //   2337: iconst_1
    //   2338: aload_1
    //   2339: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2342: athrow
    //   2343: astore_1
    //   2344: new 1257	gnu/mapping/WrongType
    //   2347: dup
    //   2348: aload_1
    //   2349: ldc_w 629
    //   2352: iconst_1
    //   2353: aload 4
    //   2355: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2358: athrow
    //   2359: astore_2
    //   2360: new 1257	gnu/mapping/WrongType
    //   2363: dup
    //   2364: aload_2
    //   2365: ldc_w 625
    //   2368: iconst_1
    //   2369: aload_1
    //   2370: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2373: athrow
    //   2374: astore_2
    //   2375: new 1257	gnu/mapping/WrongType
    //   2378: dup
    //   2379: aload_2
    //   2380: ldc_w 621
    //   2383: iconst_1
    //   2384: aload_1
    //   2385: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2388: athrow
    //   2389: astore_1
    //   2390: new 1257	gnu/mapping/WrongType
    //   2393: dup
    //   2394: aload_1
    //   2395: ldc_w 617
    //   2398: iconst_1
    //   2399: aload 4
    //   2401: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2404: athrow
    //   2405: astore_1
    //   2406: new 1257	gnu/mapping/WrongType
    //   2409: dup
    //   2410: aload_1
    //   2411: ldc_w 613
    //   2414: iconst_1
    //   2415: aload 4
    //   2417: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2420: athrow
    //   2421: astore_1
    //   2422: new 1257	gnu/mapping/WrongType
    //   2425: dup
    //   2426: aload_1
    //   2427: ldc_w 609
    //   2430: iconst_1
    //   2431: aload 4
    //   2433: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2436: athrow
    //   2437: astore_1
    //   2438: new 1257	gnu/mapping/WrongType
    //   2441: dup
    //   2442: aload_1
    //   2443: ldc_w 605
    //   2446: iconst_1
    //   2447: aload 4
    //   2449: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2452: athrow
    //   2453: astore_2
    //   2454: new 1257	gnu/mapping/WrongType
    //   2457: dup
    //   2458: aload_2
    //   2459: ldc_w 601
    //   2462: iconst_1
    //   2463: aload_1
    //   2464: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2467: athrow
    //   2468: astore_2
    //   2469: new 1257	gnu/mapping/WrongType
    //   2472: dup
    //   2473: aload_2
    //   2474: ldc_w 597
    //   2477: iconst_1
    //   2478: aload_1
    //   2479: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2482: athrow
    //   2483: astore_1
    //   2484: new 1257	gnu/mapping/WrongType
    //   2487: dup
    //   2488: aload_1
    //   2489: ldc_w 593
    //   2492: iconst_1
    //   2493: aload 4
    //   2495: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2498: athrow
    //   2499: astore_1
    //   2500: new 1257	gnu/mapping/WrongType
    //   2503: dup
    //   2504: aload_1
    //   2505: ldc_w 589
    //   2508: iconst_1
    //   2509: aload 4
    //   2511: invokespecial 1262	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2514: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2515	0	this	srfi1
    //   0	2515	1	paramModuleMethod	ModuleMethod
    //   0	2515	2	paramArrayOfObject	Object[]
    //   303	1733	3	i	int
    //   308	2202	4	localObject1	Object
    //   498	1634	5	localObject2	Object
    //   567	1581	6	localObject3	Object
    //   652	24	7	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   478	484	2041	java/lang/ClassCastException
    //   539	545	2057	java/lang/ClassCastException
    //   550	557	2073	java/lang/ClassCastException
    //   562	569	2089	java/lang/ClassCastException
    //   608	614	2105	java/lang/ClassCastException
    //   619	626	2121	java/lang/ClassCastException
    //   631	638	2137	java/lang/ClassCastException
    //   692	698	2153	java/lang/ClassCastException
    //   755	761	2169	java/lang/ClassCastException
    //   818	824	2185	java/lang/ClassCastException
    //   881	887	2201	java/lang/ClassCastException
    //   1042	1048	2217	java/lang/ClassCastException
    //   1098	1104	2233	java/lang/ClassCastException
    //   1154	1160	2249	java/lang/ClassCastException
    //   1210	1216	2265	java/lang/ClassCastException
    //   1266	1272	2281	java/lang/ClassCastException
    //   1322	1328	2297	java/lang/ClassCastException
    //   1377	1383	2313	java/lang/ClassCastException
    //   1423	1429	2328	java/lang/ClassCastException
    //   1470	1476	2343	java/lang/ClassCastException
    //   1525	1531	2359	java/lang/ClassCastException
    //   1571	1577	2374	java/lang/ClassCastException
    //   1618	1624	2389	java/lang/ClassCastException
    //   1674	1680	2405	java/lang/ClassCastException
    //   1730	1736	2421	java/lang/ClassCastException
    //   1786	1792	2437	java/lang/ClassCastException
    //   1841	1847	2453	java/lang/ClassCastException
    //   1887	1893	2468	java/lang/ClassCastException
    //   1934	1940	2483	java/lang/ClassCastException
    //   1990	1996	2499	java/lang/ClassCastException
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 152: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 149: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 147: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 121: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 120: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 116: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 115: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 114: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 113: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 112: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 111: 
      if (!(paramObject instanceof Pair)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 110: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 101: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 100: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 99: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 98: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 97: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 96: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 95: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 93: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 91: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 90: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 89: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 88: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 87: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 83: 
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    }
    if ((paramObject instanceof LList))
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return -786431;
  }
  
  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default: 
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 183: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 182: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 165: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 164: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 163: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 162: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 161: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 160: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 159: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 158: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 157: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 155: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 153: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 149: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 147: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 145: 
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
    case 142: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 141: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 140: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 139: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 138: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 137: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 119: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 118: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 109: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 108: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 107: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 106: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 105: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 104: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 103: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 102: 
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 83: 
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Numeric.asNumericOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 80: 
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
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
    case 155: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 153: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 151: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 145: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 143: 
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 131: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 130: 
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    if (IntNum.asIntNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (Numeric.asNumericOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        if (Numeric.asNumericOrNull(paramObject3) == null) {
          break label408;
        }
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786430;
    label408:
    return -786429;
  }
  
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 123)
    {
      if (!(paramObject1 instanceof Procedure)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure)) {
        return -786429;
      }
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
    case 181: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 180: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 179: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 178: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 177: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 176: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 175: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 174: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 173: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 172: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 171: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 170: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 169: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 168: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 167: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 166: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 136: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 135: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 134: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 133: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 132: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 129: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 128: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 127: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 126: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 125: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 123: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 122: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 117: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 94: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 92: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 86: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 81: 
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
    first = lists.car;
    second = lists.cadr;
    third = lists.caddr;
    fourth = lists.cadddr;
    map$Mnin$Mnorder = Scheme.map;
  }
  
  public class frame
    extends ModuleBody
  {
    public static Object lambda2recur(Object paramObject)
    {
      srfi1.frame0 localframe0 = new srfi1.frame0();
      localframe0.lis = paramObject;
      if (srfi1.isNullList(localframe0.lis) != Boolean.FALSE) {
        return misc.values(new Object[] { localframe0.lis, localframe0.lis });
      }
      localframe0.elt = lists.car.apply1(localframe0.lis);
      return call_with_values.callWithValues(localframe0.lambda$Fn1, localframe0.lambda$Fn2);
    }
  }
  
  public class frame0
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
    final ModuleMethod lambda$Fn2;
    Object lis;
    
    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:627");
      this.lambda$Fn2 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1) {
        return lambda3();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 2) {
        return lambda4(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda3()
    {
      return srfi1.frame.lambda2recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda4(Object paramObject1, Object paramObject2)
    {
      return misc.values(new Object[] { lists.cons(lists.car.apply1(this.elt), paramObject1), lists.cons(lists.cadr.apply1(this.elt), paramObject2) });
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
  
  public class frame1
    extends ModuleBody
  {
    public static Object lambda5recur(Object paramObject)
    {
      srfi1.frame2 localframe2 = new srfi1.frame2();
      localframe2.lis = paramObject;
      if (srfi1.isNullList(localframe2.lis) != Boolean.FALSE) {
        return misc.values(new Object[] { localframe2.lis, localframe2.lis, localframe2.lis });
      }
      localframe2.elt = lists.car.apply1(localframe2.lis);
      return call_with_values.callWithValues(localframe2.lambda$Fn3, localframe2.lambda$Fn4);
    }
  }
  
  public class frame10
    extends ModuleBody
  {
    Procedure f;
    Object zero;
    
    public Object lambda19recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject)) {
        return this.zero;
      }
      return Scheme.apply.apply2(this.f, srfi1.append$Ex$V(new Object[] { paramObject, LList.list1(lambda19recur(localObject)) }));
    }
    
    public Object lambda20recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return this.zero;
      }
      return this.f.apply2(paramObject, lambda20recur(lists.cdr.apply1(paramObject)));
    }
  }
  
  public class frame11
    extends ModuleBody
  {
    Procedure f;
    
    public Object lambda21recur(Object paramObject1, Object paramObject2)
    {
      Object localObject = paramObject1;
      if (lists.isPair(paramObject2)) {
        localObject = this.f.apply2(paramObject1, lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2)));
      }
      return localObject;
    }
  }
  
  public class frame12
    extends ModuleBody
  {
    Procedure f;
    final ModuleMethod lambda$Fn11;
    
    public frame12()
    {
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:961");
      this.lambda$Fn11 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
      {
        lambda22(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    void lambda22(Object paramObject)
    {
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCar$Ex(localPair, this.f.apply1(lists.car.apply1(paramObject)));
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-car!", 1, paramObject);
      }
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
  }
  
  public class frame13
    extends ModuleBody
  {
    Procedure f;
    
    public Object lambda23recur(Object paramObject1, Object paramObject2)
    {
      srfi1.frame14 localframe14 = new srfi1.frame14();
      localframe14.staticLink = this;
      localframe14.lists = paramObject1;
      localframe14.res = paramObject2;
      return call_with_values.callWithValues(localframe14.lambda$Fn12, localframe14.lambda$Fn13);
    }
  }
  
  public class frame14
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 12, null, 0);
    final ModuleMethod lambda$Fn13;
    Object lists;
    Object res;
    srfi1.frame13 staticLink;
    
    public frame14()
    {
      this$1 = new ModuleMethod(this, 13, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:969");
      this.lambda$Fn13 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 12) {
        return lambda24();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 13) {
        return lambda25(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda24()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    Object lambda25(Object paramObject1, Object paramObject2)
    {
      if (srfi1.isNotPair(paramObject1)) {
        paramObject1 = this.res;
      }
      try
      {
        paramObject2 = (LList)paramObject1;
        return lists.reverse$Ex((LList)paramObject2);
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "reverse!", 1, paramObject1);
      }
      paramObject1 = Scheme.apply.apply2(this.staticLink.f, paramObject1);
      if (paramObject1 != Boolean.FALSE) {
        return this.staticLink.lambda23recur(paramObject2, lists.cons(paramObject1, this.res));
      }
      return this.staticLink.lambda23recur(paramObject2, this.res);
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
  
  public class frame15
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object pred;
    
    public frame15()
    {
      this$1 = new ModuleMethod(this, 14, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1199");
      this.lambda$Fn14 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 14)
      {
        if (lambda26(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda26(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame16
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn15;
    Object pred;
    
    public frame16()
    {
      this$1 = new ModuleMethod(this, 15, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1200");
      this.lambda$Fn15 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        if (lambda27(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda27(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
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
  
  public class frame17
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn16;
    Object maybe$Mn$Eq;
    Object x;
    
    public frame17()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1222");
      this.lambda$Fn16 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 16)
      {
        if (lambda28(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda28(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame18
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn17;
    Object maybe$Mn$Eq;
    Object x;
    
    public frame18()
    {
      this$1 = new ModuleMethod(this, 17, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1225");
      this.lambda$Fn17 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 17)
      {
        if (lambda29(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda29(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 17)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame19
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public Object lambda30recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {}
      Object localObject1;
      Object localObject2;
      Object localObject3;
      do
      {
        return paramObject;
        localObject1 = lists.car.apply1(paramObject);
        localObject2 = lists.cdr.apply1(paramObject);
        localObject3 = lambda30recur(srfi1.delete(localObject1, localObject2, this.maybe$Mn$Eq));
      } while (localObject2 == localObject3);
      return lists.cons(localObject1, localObject3);
    }
  }
  
  public class frame2
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object lis;
    
    public frame2()
    {
      this$1 = new ModuleMethod(this, 4, null, 12291);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:635");
      this.lambda$Fn4 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 3) {
        return lambda6();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 4) {
        return lambda7(paramObject1, paramObject2, paramObject3);
      }
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    
    Object lambda6()
    {
      return srfi1.frame1.lambda5recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return misc.values(new Object[] { lists.cons(lists.car.apply1(this.elt), paramObject1), lists.cons(lists.cadr.apply1(this.elt), paramObject2), lists.cons(lists.caddr.apply1(this.elt), paramObject3) });
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
  
  public class frame20
    extends ModuleBody
  {
    Procedure maybe$Mn$Eq;
    
    public Object lambda31recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {}
      Object localObject1;
      Object localObject2;
      Object localObject3;
      do
      {
        return paramObject;
        localObject1 = lists.car.apply1(paramObject);
        localObject2 = lists.cdr.apply1(paramObject);
        localObject3 = lambda31recur(srfi1.delete$Ex(localObject1, localObject2, this.maybe$Mn$Eq));
      } while (localObject2 == localObject3);
      return lists.cons(localObject1, localObject3);
    }
  }
  
  public class frame21
    extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn18;
    Object maybe$Mn$Eq;
    
    public frame21()
    {
      this$1 = new ModuleMethod(this, 18, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1280");
      this.lambda$Fn18 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 18)
      {
        if (lambda32(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda32(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame22
    extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn19;
    Object maybe$Mn$Eq;
    
    public frame22()
    {
      this$1 = new ModuleMethod(this, 19, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1283");
      this.lambda$Fn19 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 19)
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
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 19)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame23
    extends ModuleBody
  {
    Procedure pred;
    
    public Object lambda34recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return LList.Empty;
      }
      Object localObject = lists.car.apply1(paramObject);
      if (this.pred.apply1(localObject) != Boolean.FALSE) {
        return lists.cons(localObject, lambda34recur(lists.cdr.apply1(paramObject)));
      }
      return LList.Empty;
    }
  }
  
  public class frame24
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn20;
    Object pred;
    
    public frame24()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1343");
      this.lambda$Fn20 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20)
      {
        if (lambda35(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda35(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
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
  
  public class frame25
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn21;
    Object pred;
    
    public frame25()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1344");
      this.lambda$Fn21 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda36(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda36(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
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
  
  public class frame26
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn23;
    Object lis1;
    LList lists;
    Procedure pred;
    
    public frame26()
    {
      this$1 = new ModuleMethod(this, 23, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1350");
      this.lambda$Fn23 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 22) {
        return lambda37();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 23) {
        return lambda38(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda37()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }
    
    Object lambda38(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        for (;;)
        {
          paramObject2 = srfi1.$PcCars$PlCdrs$SlPair(paramObject2);
          Object localObject = lists.car.apply1(paramObject2);
          paramObject2 = lists.cdr.apply1(paramObject2);
          if (!lists.isPair(localObject)) {
            break;
          }
          paramObject1 = Scheme.apply.apply2(this.pred, paramObject1);
          if (paramObject1 != Boolean.FALSE) {
            return paramObject1;
          }
          paramObject1 = localObject;
        }
        return Scheme.apply.apply2(this.pred, paramObject1);
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
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
  
  public class frame27
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 26, null, 0);
    final ModuleMethod lambda$Fn25;
    Object lis1;
    LList lists;
    Procedure pred;
    
    public frame27()
    {
      this$1 = new ModuleMethod(this, 27, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1378");
      this.lambda$Fn25 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 26) {
        return lambda39();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 27) {
        return lambda40(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda39()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }
    
    Object lambda40(Object paramObject1, Object paramObject2)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 27)
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
  
  public class frame28
    extends ModuleBody
  {
    srfi1.frame27 staticLink;
    
    public Object lambda41lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame29 localframe29 = new srfi1.frame29();
      localframe29.staticLink = this;
      localframe29.heads = paramObject1;
      localframe29.tails = paramObject2;
      return call_with_values.callWithValues(localframe29.lambda$Fn26, localframe29.lambda$Fn27);
    }
  }
  
  public class frame29
    extends ModuleBody
  {
    Object heads;
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn27;
    srfi1.frame28 staticLink;
    Object tails;
    
    public frame29()
    {
      this$1 = new ModuleMethod(this, 25, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1381");
      this.lambda$Fn27 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 24) {
        return lambda42();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 25) {
        return lambda43(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda42()
    {
      return srfi1.$PcCars$PlCdrs(this.tails);
    }
    
    Object lambda43(Object paramObject1, Object paramObject2)
    {
      if (lists.isPair(paramObject1))
      {
        Object localObject2 = Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
        Object localObject1 = localObject2;
        if (localObject2 != Boolean.FALSE) {
          localObject1 = this.staticLink.lambda41lp(paramObject1, paramObject2);
        }
        return localObject1;
      }
      return Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
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
  
  public class frame3
    extends ModuleBody
  {
    public static Object lambda8recur(Object paramObject)
    {
      srfi1.frame4 localframe4 = new srfi1.frame4();
      localframe4.lis = paramObject;
      if (srfi1.isNullList(localframe4.lis) != Boolean.FALSE) {
        return misc.values(new Object[] { localframe4.lis, localframe4.lis, localframe4.lis, localframe4.lis });
      }
      localframe4.elt = lists.car.apply1(localframe4.lis);
      return call_with_values.callWithValues(localframe4.lambda$Fn5, localframe4.lambda$Fn6);
    }
  }
  
  public class frame30
    extends ModuleBody
  {
    Procedure pred;
    
    public Object lambda44lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame31 localframe31 = new srfi1.frame31();
      localframe31.staticLink = this;
      localframe31.lists = paramObject1;
      localframe31.n = paramObject2;
      return call_with_values.callWithValues(localframe31.lambda$Fn28, localframe31.lambda$Fn29);
    }
  }
  
  public class frame31
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn29;
    Object lists;
    Object n;
    srfi1.frame30 staticLink;
    
    public frame31()
    {
      this$1 = new ModuleMethod(this, 29, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1404");
      this.lambda$Fn29 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 28) {
        return lambda45();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 29) {
        return lambda46(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda45()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    Object lambda46(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        if (Scheme.apply.apply2(this.staticLink.pred, paramObject1) != Boolean.FALSE) {
          return this.n;
        }
        return this.staticLink.lambda44lp(paramObject2, AddOp.$Pl.apply2(this.n, srfi1.Lit1));
      }
      if (bool) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
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
  
  public class frame32
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn30;
    
    public frame32()
    {
      this$1 = new ModuleMethod(this, 30, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1466");
      this.lambda$Fn30 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 30) {
        return lambda47(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda47(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, paramObject2, this.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(paramObject1, paramObject2);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 30)
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
    Procedure $Eq;
    final ModuleMethod lambda$Fn31;
    final ModuleMethod lambda$Fn32;
    
    public frame33()
    {
      this$1 = new ModuleMethod(this, 32, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1476");
      this.lambda$Fn32 = this$1;
      this$1 = new ModuleMethod(this, 33, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1471");
      this.lambda$Fn31 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 32: 
        return lambda49(paramObject1, paramObject2);
      }
      return lambda48(paramObject1, paramObject2);
    }
    
    Object lambda48(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {}
      do
      {
        return paramObject2;
        if (lists.isNull(paramObject2)) {
          return paramObject1;
        }
      } while (paramObject1 == paramObject2);
      return srfi1.fold$V(this.lambda$Fn32, paramObject2, paramObject1, new Object[0]);
    }
    
    Object lambda49(Object paramObject1, Object paramObject2)
    {
      srfi1.frame34 localframe34 = new srfi1.frame34();
      localframe34.staticLink = this;
      localframe34.elt = paramObject1;
      if (srfi1.any$V(localframe34.lambda$Fn33, paramObject2, new Object[0]) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(localframe34.elt, paramObject2);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 33: 
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
  
  public class frame34
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn33;
    srfi1.frame33 staticLink;
    
    public frame34()
    {
      this$1 = new ModuleMethod(this, 31, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1476");
      this.lambda$Fn33 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 31) {
        return lambda50(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda50(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 31)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame35
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn34;
    final ModuleMethod lambda$Fn35;
    
    public frame35()
    {
      this$1 = new ModuleMethod(this, 35, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1488");
      this.lambda$Fn35 = this$1;
      this$1 = new ModuleMethod(this, 36, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1483");
      this.lambda$Fn34 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 35: 
        return lambda52(paramObject1, paramObject2);
      }
      return lambda51(paramObject1, paramObject2);
    }
    
    Object lambda51(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {}
      do
      {
        return paramObject2;
        if (lists.isNull(paramObject2)) {
          return paramObject1;
        }
      } while (paramObject1 == paramObject2);
      return srfi1.pairFold$V(this.lambda$Fn35, paramObject2, paramObject1, new Object[0]);
    }
    
    Object lambda52(Object paramObject1, Object paramObject2)
    {
      Object localObject = new srfi1.frame36();
      ((srfi1.frame36)localObject).staticLink = this;
      ((srfi1.frame36)localObject).elt = lists.car.apply1(paramObject1);
      if (srfi1.any$V(((srfi1.frame36)localObject).lambda$Fn36, paramObject2, new Object[0]) != Boolean.FALSE) {
        return paramObject2;
      }
      try
      {
        localObject = (Pair)paramObject1;
        lists.setCdr$Ex((Pair)localObject, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "set-cdr!", 1, paramObject1);
      }
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default: 
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 36: 
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
  
  public class frame36
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn36;
    srfi1.frame35 staticLink;
    
    public frame36()
    {
      this$1 = new ModuleMethod(this, 34, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1490");
      this.lambda$Fn36 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 34) {
        return lambda53(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda53(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 34)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame37
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn37;
    Object lists;
    
    public frame37()
    {
      this$1 = new ModuleMethod(this, 38, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1501");
      this.lambda$Fn37 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 38) {
        return lambda54(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda54(Object paramObject)
    {
      srfi1.frame38 localframe38 = new srfi1.frame38();
      localframe38.staticLink = this;
      localframe38.x = paramObject;
      return srfi1.every$V(localframe38.lambda$Fn38, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 38)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame38
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn38;
    srfi1.frame37 staticLink;
    Object x;
    
    public frame38()
    {
      this$1 = new ModuleMethod(this, 37, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1502");
      this.lambda$Fn38 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 37) {
        return lambda55(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda55(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 37)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame39
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn39;
    Object lists;
    
    public frame39()
    {
      this$1 = new ModuleMethod(this, 40, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1509");
      this.lambda$Fn39 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 40) {
        return lambda56(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda56(Object paramObject)
    {
      srfi1.frame40 localframe40 = new srfi1.frame40();
      localframe40.staticLink = this;
      localframe40.x = paramObject;
      return srfi1.every$V(localframe40.lambda$Fn40, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 40)
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
    Object elt;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6;
    Object lis;
    
    public frame4()
    {
      this$1 = new ModuleMethod(this, 6, null, 16388);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:644");
      this.lambda$Fn6 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5) {
        return lambda9();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 6) {
        return lambda10(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    
    Object lambda10(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      return misc.values(new Object[] { lists.cons(lists.car.apply1(this.elt), paramObject1), lists.cons(lists.cadr.apply1(this.elt), paramObject2), lists.cons(lists.caddr.apply1(this.elt), paramObject3), lists.cons(lists.cadddr.apply1(this.elt), paramObject4) });
    }
    
    Object lambda9()
    {
      return srfi1.frame3.lambda8recur(lists.cdr.apply1(this.lis));
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
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
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
  
  public class frame40
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn40;
    srfi1.frame39 staticLink;
    Object x;
    
    public frame40()
    {
      this$1 = new ModuleMethod(this, 39, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1510");
      this.lambda$Fn40 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 39) {
        return lambda57(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda57(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 39)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame41
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn41;
    Object lists;
    
    public frame41()
    {
      this$1 = new ModuleMethod(this, 42, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1518");
      this.lambda$Fn41 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 42) {
        return lambda58(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda58(Object paramObject)
    {
      srfi1.frame42 localframe42 = new srfi1.frame42();
      localframe42.staticLink = this;
      localframe42.x = paramObject;
      return srfi1.every$V(localframe42.lambda$Fn42, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 42)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame42
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn42;
    srfi1.frame41 staticLink;
    Object x;
    
    public frame42()
    {
      this$1 = new ModuleMethod(this, 41, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1519");
      this.lambda$Fn42 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 41)
      {
        if (lambda59(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda59(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 41)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame43
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn43;
    Object lists;
    
    public frame43()
    {
      this$1 = new ModuleMethod(this, 44, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1527");
      this.lambda$Fn43 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 44) {
        return lambda60(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda60(Object paramObject)
    {
      srfi1.frame44 localframe44 = new srfi1.frame44();
      localframe44.staticLink = this;
      localframe44.x = paramObject;
      return srfi1.every$V(localframe44.lambda$Fn44, this.lists, new Object[0]);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 44)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame44
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn44;
    srfi1.frame43 staticLink;
    Object x;
    
    public frame44()
    {
      this$1 = new ModuleMethod(this, 43, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1528");
      this.lambda$Fn44 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 43)
      {
        if (lambda61(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda61(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE) {}
      for (int i = 1;; i = 0) {
        return i + 1 & 0x1;
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 43)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame45
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn45;
    
    public frame45()
    {
      this$1 = new ModuleMethod(this, 48, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1534");
      this.lambda$Fn45 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 48) {
        return lambda62(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda62(Object paramObject1, Object paramObject2)
    {
      srfi1.frame46 localframe46 = new srfi1.frame46();
      localframe46.staticLink = this;
      localframe46.b = paramObject1;
      localframe46.a = paramObject2;
      return call_with_values.callWithValues(localframe46.lambda$Fn46, localframe46.lambda$Fn47);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 48)
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
  
  public class frame46
    extends ModuleBody
  {
    Object a;
    Object b;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn47;
    srfi1.frame45 staticLink;
    
    public frame46()
    {
      this$1 = new ModuleMethod(this, 47, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1544");
      this.lambda$Fn47 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 46) {
        return lambda63();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 47) {
        return lambda64(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda63()
    {
      return srfi1.lsetDiff$PlIntersection$V(this.staticLink.$Eq, this.a, new Object[] { this.b });
    }
    
    Object lambda64(Object paramObject1, Object paramObject2)
    {
      srfi1.frame47 localframe47 = new srfi1.frame47();
      localframe47.staticLink = this;
      localframe47.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1)) {
        return srfi1.lsetDifference$V(this.staticLink.$Eq, this.b, new Object[] { this.a });
      }
      if (lists.isNull(localframe47.a$Mnint$Mnb)) {
        return append.append$V(new Object[] { this.b, this.a });
      }
      return srfi1.fold$V(localframe47.lambda$Fn48, paramObject1, this.b, new Object[0]);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 47)
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
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn48;
    srfi1.frame46 staticLink;
    
    public frame47()
    {
      this$1 = new ModuleMethod(this, 45, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1547");
      this.lambda$Fn48 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 45) {
        return lambda65(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda65(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      return lists.cons(paramObject1, paramObject2);
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
  
  public class frame48
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn49;
    
    public frame48()
    {
      this$1 = new ModuleMethod(this, 52, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1555");
      this.lambda$Fn49 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 52) {
        return lambda66(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda66(Object paramObject1, Object paramObject2)
    {
      srfi1.frame49 localframe49 = new srfi1.frame49();
      localframe49.staticLink = this;
      localframe49.b = paramObject1;
      localframe49.a = paramObject2;
      return call_with_values.callWithValues(localframe49.lambda$Fn50, localframe49.lambda$Fn51);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 52)
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
    Object a;
    Object b;
    final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 50, null, 0);
    final ModuleMethod lambda$Fn51;
    srfi1.frame48 staticLink;
    
    public frame49()
    {
      this$1 = new ModuleMethod(this, 51, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1565");
      this.lambda$Fn51 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 50) {
        return lambda67();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 51) {
        return lambda68(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda67()
    {
      return srfi1.lsetDiff$PlIntersection$Ex$V(this.staticLink.$Eq, this.a, new Object[] { this.b });
    }
    
    Object lambda68(Object paramObject1, Object paramObject2)
    {
      srfi1.frame50 localframe50 = new srfi1.frame50();
      localframe50.staticLink = this;
      localframe50.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1)) {
        return srfi1.lsetDifference$Ex$V(this.staticLink.$Eq, this.b, new Object[] { this.a });
      }
      if (lists.isNull(localframe50.a$Mnint$Mnb)) {
        return srfi1.append$Ex$V(new Object[] { this.b, this.a });
      }
      return srfi1.pairFold$V(localframe50.lambda$Fn52, paramObject1, this.b, new Object[0]);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 51)
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
    public static Object lambda11recur(Object paramObject)
    {
      srfi1.frame6 localframe6 = new srfi1.frame6();
      localframe6.lis = paramObject;
      if (srfi1.isNullList(localframe6.lis) != Boolean.FALSE) {
        return misc.values(new Object[] { localframe6.lis, localframe6.lis, localframe6.lis, localframe6.lis, localframe6.lis });
      }
      localframe6.elt = lists.car.apply1(localframe6.lis);
      return call_with_values.callWithValues(localframe6.lambda$Fn7, localframe6.lambda$Fn8);
    }
  }
  
  public class frame50
    extends ModuleBody
  {
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn52;
    srfi1.frame49 staticLink;
    
    public frame50()
    {
      this$1 = new ModuleMethod(this, 49, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1568");
      this.lambda$Fn52 = this$1;
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 49) {
        return lambda69(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda69(Object paramObject1, Object paramObject2)
    {
      if (lists.member(lists.car.apply1(paramObject1), this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE) {
        return paramObject2;
      }
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException paramObject2)
      {
        throw new WrongType((ClassCastException)paramObject2, "set-cdr!", 1, paramObject1);
      }
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
  
  public class frame51
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn53;
    LList lists;
    
    public frame51()
    {
      this$1 = new ModuleMethod(this, 54, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1579");
      this.lambda$Fn53 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 54)
      {
        if (lambda70(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda70(Object paramObject)
    {
      int i = 0;
      srfi1.frame52 localframe52 = new srfi1.frame52();
      localframe52.staticLink = this;
      localframe52.elt = paramObject;
      if (srfi1.any$V(localframe52.lambda$Fn54, this.lists, new Object[0]) != Boolean.FALSE) {
        i = 1;
      }
      return i + 1 & 0x1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 54)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame52
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn54;
    srfi1.frame51 staticLink;
    
    public frame52()
    {
      this$1 = new ModuleMethod(this, 53, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1580");
      this.lambda$Fn54 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 53) {
        return lambda71(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda71(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 53)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame53
    extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn55;
    LList lists;
    
    public frame53()
    {
      this$1 = new ModuleMethod(this, 56, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1587");
      this.lambda$Fn55 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 56)
      {
        if (lambda72(paramObject)) {
          return Boolean.TRUE;
        }
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    boolean lambda72(Object paramObject)
    {
      int i = 0;
      srfi1.frame54 localframe54 = new srfi1.frame54();
      localframe54.staticLink = this;
      localframe54.elt = paramObject;
      if (srfi1.any$V(localframe54.lambda$Fn56, this.lists, new Object[0]) != Boolean.FALSE) {
        i = 1;
      }
      return i + 1 & 0x1;
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 56)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame54
    extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn56;
    srfi1.frame53 staticLink;
    
    public frame54()
    {
      this$1 = new ModuleMethod(this, 55, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1588");
      this.lambda$Fn56 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 55) {
        return lambda73(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda73(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 55)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame55
    extends ModuleBody
  {
    Continuation abort;
    
    public Object lambda74recur(Object paramObject)
    {
      if (lists.isPair(paramObject))
      {
        Object localObject = lists.car.apply1(paramObject);
        if (srfi1.isNullList(localObject) != Boolean.FALSE) {
          return this.abort.apply1(LList.Empty);
        }
        return lists.cons(lists.cdr.apply1(localObject), lambda74recur(lists.cdr.apply1(paramObject)));
      }
      return LList.Empty;
    }
  }
  
  public class frame56
    extends ModuleBody
  {
    Object last$Mnelt;
    
    public Object lambda75recur(Object paramObject)
    {
      if (lists.isPair(paramObject)) {
        return lists.cons(lists.caar.apply1(paramObject), lambda75recur(lists.cdr.apply1(paramObject)));
      }
      return LList.list1(this.last$Mnelt);
    }
  }
  
  public class frame57
    extends ModuleBody
  {
    Continuation abort;
    
    public Object lambda76recur(Object paramObject)
    {
      srfi1.frame58 localframe58 = new srfi1.frame58();
      localframe58.staticLink = this;
      localframe58.lists = paramObject;
      if (lists.isPair(localframe58.lists)) {
        return call_with_values.callWithValues(localframe58.lambda$Fn57, localframe58.lambda$Fn58);
      }
      return misc.values(new Object[] { LList.Empty, LList.Empty });
    }
  }
  
  public class frame58
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 61, null, 0);
    final ModuleMethod lambda$Fn58;
    Object lists;
    srfi1.frame57 staticLink;
    
    public frame58()
    {
      this$1 = new ModuleMethod(this, 62, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:762");
      this.lambda$Fn58 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 61) {
        return lambda77();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 62) {
        return lambda78(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda77()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda78(Object paramObject1, Object paramObject2)
    {
      srfi1.frame59 localframe59 = new srfi1.frame59();
      localframe59.staticLink = this;
      localframe59.list = paramObject1;
      localframe59.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe59.list) != Boolean.FALSE) {
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      }
      return call_with_values.callWithValues(localframe59.lambda$Fn59, localframe59.lambda$Fn60);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 61)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 62)
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
    final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 59, null, 0);
    final ModuleMethod lambda$Fn60;
    Object list;
    Object other$Mnlists;
    srfi1.frame58 staticLink;
    
    public frame59()
    {
      this$1 = new ModuleMethod(this, 60, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:764");
      this.lambda$Fn60 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 59) {
        return lambda79();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 60) {
        return lambda80(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda79()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda80(Object paramObject1, Object paramObject2)
    {
      srfi1.frame60 localframe60 = new srfi1.frame60();
      localframe60.staticLink = this;
      localframe60.a = paramObject1;
      localframe60.d = paramObject2;
      return call_with_values.callWithValues(localframe60.lambda$Fn61, localframe60.lambda$Fn62);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 59)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 60)
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
    Object elt;
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8;
    Object lis;
    
    public frame6()
    {
      this$1 = new ModuleMethod(this, 8, null, 20485);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:654");
      this.lambda$Fn8 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 7) {
        return lambda12();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 8) {
        return lambda13(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]);
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }
    
    Object lambda12()
    {
      return srfi1.frame5.lambda11recur(lists.cdr.apply1(this.lis));
    }
    
    Object lambda13(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      return misc.values(new Object[] { lists.cons(lists.car.apply1(this.elt), paramObject1), lists.cons(lists.cadr.apply1(this.elt), paramObject2), lists.cons(lists.caddr.apply1(this.elt), paramObject3), lists.cons(lists.cadddr.apply1(this.elt), paramObject4), lists.cons(lists.car.apply1(lists.cddddr.apply1(this.elt)), paramObject5) });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
  
  public class frame60
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 57, null, 0);
    final ModuleMethod lambda$Fn62;
    srfi1.frame59 staticLink;
    
    public frame60()
    {
      this$1 = new ModuleMethod(this, 58, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:765");
      this.lambda$Fn62 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 57) {
        return lambda81();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 58) {
        return lambda82(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda81()
    {
      return this.staticLink.staticLink.staticLink.lambda76recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda82(Object paramObject1, Object paramObject2)
    {
      return misc.values(new Object[] { lists.cons(this.a, paramObject1), lists.cons(this.d, paramObject2) });
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 57)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 58)
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
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 63, null, 0);
    Object lists;
    
    static Pair lambda84(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 63) {
        return lambda83();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda83()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 63)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }
  
  public class frame62
    extends ModuleBody
  {
    Object cars$Mnfinal;
  }
  
  public class frame63
    extends ModuleBody
  {
    Continuation abort;
    srfi1.frame62 staticLink;
    
    public Object lambda85recur(Object paramObject)
    {
      srfi1.frame64 localframe64 = new srfi1.frame64();
      localframe64.staticLink = this;
      localframe64.lists = paramObject;
      if (lists.isPair(localframe64.lists)) {
        return call_with_values.callWithValues(localframe64.lambda$Fn65, localframe64.lambda$Fn66);
      }
      return misc.values(new Object[] { LList.list1(this.staticLink.cars$Mnfinal), LList.Empty });
    }
  }
  
  public class frame64
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 68, null, 0);
    final ModuleMethod lambda$Fn66;
    Object lists;
    srfi1.frame63 staticLink;
    
    public frame64()
    {
      this$1 = new ModuleMethod(this, 69, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:783");
      this.lambda$Fn66 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 68) {
        return lambda86();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 69) {
        return lambda87(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda86()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda87(Object paramObject1, Object paramObject2)
    {
      srfi1.frame65 localframe65 = new srfi1.frame65();
      localframe65.staticLink = this;
      localframe65.list = paramObject1;
      localframe65.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe65.list) != Boolean.FALSE) {
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      }
      return call_with_values.callWithValues(localframe65.lambda$Fn67, localframe65.lambda$Fn68);
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
  
  public class frame65
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 66, null, 0);
    final ModuleMethod lambda$Fn68;
    Object list;
    Object other$Mnlists;
    srfi1.frame64 staticLink;
    
    public frame65()
    {
      this$1 = new ModuleMethod(this, 67, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:785");
      this.lambda$Fn68 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 66) {
        return lambda88();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 67) {
        return lambda89(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda88()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda89(Object paramObject1, Object paramObject2)
    {
      srfi1.frame66 localframe66 = new srfi1.frame66();
      localframe66.staticLink = this;
      localframe66.a = paramObject1;
      localframe66.d = paramObject2;
      return call_with_values.callWithValues(localframe66.lambda$Fn69, localframe66.lambda$Fn70);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 67)
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
  
  public class frame66
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 64, null, 0);
    final ModuleMethod lambda$Fn70;
    srfi1.frame65 staticLink;
    
    public frame66()
    {
      this$1 = new ModuleMethod(this, 65, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:786");
      this.lambda$Fn70 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 64) {
        return lambda90();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 65) {
        return lambda91(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda90()
    {
      return this.staticLink.staticLink.staticLink.lambda85recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda91(Object paramObject1, Object paramObject2)
    {
      return misc.values(new Object[] { lists.cons(this.a, paramObject1), lists.cons(this.d, paramObject2) });
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
  
  public class frame67
    extends ModuleBody
  {
    public static Object lambda92recur(Object paramObject)
    {
      srfi1.frame68 localframe68 = new srfi1.frame68();
      localframe68.lists = paramObject;
      if (lists.isPair(localframe68.lists)) {
        return call_with_values.callWithValues(localframe68.lambda$Fn71, localframe68.lambda$Fn72);
      }
      return misc.values(new Object[] { LList.Empty, LList.Empty });
    }
  }
  
  public class frame68
    extends ModuleBody
  {
    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn72;
    Object lists;
    
    public frame68()
    {
      this$1 = new ModuleMethod(this, 75, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:794");
      this.lambda$Fn72 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 74) {
        return lambda93();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 75) {
        return lambda94(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda93()
    {
      return srfi1.car$PlCdr(this.lists);
    }
    
    Object lambda94(Object paramObject1, Object paramObject2)
    {
      srfi1.frame69 localframe69 = new srfi1.frame69();
      localframe69.staticLink = this;
      localframe69.list = paramObject1;
      localframe69.other$Mnlists = paramObject2;
      return call_with_values.callWithValues(localframe69.lambda$Fn73, localframe69.lambda$Fn74);
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 75)
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
    final ModuleMethod lambda$Fn73 = new ModuleMethod(this, 72, null, 0);
    final ModuleMethod lambda$Fn74;
    Object list;
    Object other$Mnlists;
    srfi1.frame68 staticLink;
    
    public frame69()
    {
      this$1 = new ModuleMethod(this, 73, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:795");
      this.lambda$Fn74 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 72) {
        return lambda95();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 73) {
        return lambda96(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda95()
    {
      return srfi1.car$PlCdr(this.list);
    }
    
    Object lambda96(Object paramObject1, Object paramObject2)
    {
      srfi1.frame70 localframe70 = new srfi1.frame70();
      localframe70.staticLink = this;
      localframe70.a = paramObject1;
      localframe70.d = paramObject2;
      return call_with_values.callWithValues(localframe70.lambda$Fn75, localframe70.lambda$Fn76);
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
  
  public class frame7
    extends ModuleBody
  {
    Procedure kons;
    
    public Object lambda14lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame8 localframe8 = new srfi1.frame8();
      localframe8.staticLink = this;
      localframe8.lists = paramObject1;
      localframe8.ans = paramObject2;
      return call_with_values.callWithValues(localframe8.lambda$Fn9, localframe8.lambda$Fn10);
    }
  }
  
  public class frame70
    extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn76;
    srfi1.frame69 staticLink;
    
    public frame70()
    {
      this$1 = new ModuleMethod(this, 71, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:796");
      this.lambda$Fn76 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 70) {
        return lambda97();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 71) {
        return lambda98(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda97()
    {
      return srfi1.frame67.lambda92recur(this.staticLink.other$Mnlists);
    }
    
    Object lambda98(Object paramObject1, Object paramObject2)
    {
      return misc.values(new Object[] { lists.cons(this.a, paramObject1), lists.cons(this.d, paramObject2) });
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
    
    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 71)
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
    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 76, null, 0);
    Object lists;
    
    static Pair lambda100(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 76) {
        return lambda99();
      }
      return super.apply0(paramModuleMethod);
    }
    
    Object lambda99()
    {
      return srfi1.$PcCars$PlCdrs$SlNoTest(this.lists);
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
  }
  
  public class frame72
    extends ModuleBody
  {
    Object $Eq;
    final ModuleMethod lambda$Fn79;
    Object lis2;
    
    public frame72()
    {
      this$1 = new ModuleMethod(this, 77, null, 4097);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:1443");
      this.lambda$Fn79 = this$1;
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 77) {
        return lambda101(paramObject);
      }
      return super.apply1(paramModuleMethod, paramObject);
    }
    
    Object lambda101(Object paramObject)
    {
      Object localObject2 = this.lis2;
      Object localObject1 = this.$Eq;
      try
      {
        Procedure localProcedure = (Procedure)localObject1;
        return lists.member(paramObject, localObject2, localProcedure);
      }
      catch (ClassCastException paramObject)
      {
        throw new WrongType((ClassCastException)paramObject, "member", 3, localObject1);
      }
    }
    
    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 77)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
  
  public class frame8
    extends ModuleBody
  {
    Object ans;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object lists;
    srfi1.frame7 staticLink;
    
    public frame8()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/srfi1.scm:859");
      this.lambda$Fn10 = this$1;
    }
    
    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 9) {
        return lambda15();
      }
      return super.apply0(paramModuleMethod);
    }
    
    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10) {
        return lambda16(paramObject1, paramObject2);
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    
    Object lambda15()
    {
      return srfi1.$PcCars$PlCdrs$Pl(this.lists, this.ans);
    }
    
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1)) {
        return this.ans;
      }
      return this.staticLink.lambda14lp(paramObject2, Scheme.apply.apply2(this.staticLink.kons, paramObject1));
    }
    
    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
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
  
  public class frame9
    extends ModuleBody
  {
    Object knil;
    Procedure kons;
    
    public Object lambda17recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject)) {
        return this.knil;
      }
      return Scheme.apply.apply2(this.kons, srfi1.$PcCars$Pl(paramObject, lambda17recur(localObject)));
    }
    
    public Object lambda18recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE) {
        return this.knil;
      }
      Object localObject = lists.car.apply1(paramObject);
      return this.kons.apply2(localObject, lambda18recur(lists.cdr.apply1(paramObject)));
    }
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\srfi1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */