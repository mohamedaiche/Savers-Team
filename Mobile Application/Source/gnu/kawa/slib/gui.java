package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.Format;
import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Display;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.xml.KAttr;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class gui
  extends ModuleBody
{
  public static final gui $instance;
  public static final ModuleMethod Button;
  public static final ModuleMethod Column;
  public static final Macro Image;
  public static final ModuleMethod Label;
  static final Class Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SyntaxRules Lit13;
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
  static final SyntaxRules Lit24;
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
  static final IntNum Lit44 = IntNum.make(1);
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SyntaxRules Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod Row;
  public static final ModuleMethod Text;
  public static final ModuleMethod Window;
  public static final ModuleMethod as$Mncolor;
  public static final ModuleMethod button;
  public static final ModuleMethod image$Mnheight;
  public static final ModuleMethod image$Mnread;
  public static final ModuleMethod image$Mnwidth;
  static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr;
  static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr;
  static final Location loc$$St$DtgetHeight;
  static final Location loc$$St$DtgetWidth;
  public static final Macro process$Mnkeywords;
  public static final Macro run$Mnapplication;
  public static final ModuleMethod set$Mncontent;
  
  static
  {
    Lit43 = (SimpleSymbol)new SimpleSymbol("value").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("name").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("invoke").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("getName").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("attr").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.xml.KAttr>").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("instance?").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("+").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("loop").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("<object>").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("primitive-array-get").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("arg").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("num-args").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("i").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("<int>").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Object localObject = (SimpleSymbol)new SimpleSymbol("run-application").readResolve();
    Lit23 = (SimpleSymbol)localObject;
    SyntaxRule localSyntaxRule = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\b\003", new Object[] { PairWithPosition.make(Lit30, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.kawa.models.Window").readResolve(), Pair.make(Pair.make(Lit31, Pair.make((SimpleSymbol)new SimpleSymbol("open").readResolve(), LList.Empty)), LList.Empty)), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 749575) }, 0);
    Lit24 = new SyntaxRules(new Object[] { localObject }, new SyntaxRule[] { localSyntaxRule }, 1);
    Lit22 = (SimpleSymbol)new SimpleSymbol("Window").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("set-content").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("Column").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("Row").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("Text").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("Label").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("image-height").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("image-width").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("image-read").readResolve();
    localObject = (SimpleSymbol)new SimpleSymbol("text-field").readResolve();
    localSyntaxRule = new SyntaxRule(new SyntaxPattern("\f\030\003", new Object[0], 1), "\000", "\021\030\004\021\030\f\002", new Object[] { (SimpleSymbol)new SimpleSymbol("make").readResolve(), (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.DrawImage>").readResolve() }, 0);
    Lit13 = new SyntaxRules(new Object[] { localObject }, new SyntaxRule[] { localSyntaxRule }, 1);
    Lit12 = (SimpleSymbol)new SimpleSymbol("Image").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("Button").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("button").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("as-color").readResolve();
    localObject = (SimpleSymbol)new SimpleSymbol("process-keywords").readResolve();
    Lit7 = (SimpleSymbol)localObject;
    localSyntaxRule = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4), "\001\001\001\001", "\021\030\004\b\021\030\f\021\030\024\021\030\034\b\021\030$\t\013\030,\b\021\030\004\021\0304\021\030<\b\021\030D\021\030L\b\021\030\004a\b\021\030T\b\021\030\\\t\013\030d\b\021\030l©\021\030ty\t\023\t\003\021\030|\b\021\030\t\013\030\030\021\030i\021\030¤\021\030¬\b\t\023\t\003\030´\030¼\b\021\030Ä1\t\033\t\003\030Ì\030Ô", new Object[] { (SimpleSymbol)new SimpleSymbol("let").readResolve(), Lit28, Lit25, Lit26, (SimpleSymbol)new SimpleSymbol("field").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("length").readResolve(), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 16426), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 16426), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 16425), Lit34, PairWithPosition.make(PairWithPosition.make(Lit27, PairWithPosition.make(Lit25, PairWithPosition.make(Lit26, PairWithPosition.make(IntNum.make(0), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 20509), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 20503), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 20500), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 20497), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 20496), (SimpleSymbol)new SimpleSymbol("if").readResolve(), PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<").readResolve(), PairWithPosition.make(Lit27, PairWithPosition.make(Lit28, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 24593), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 24591), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 24588), Lit29, PairWithPosition.make(Lit32, PairWithPosition.make(Lit33, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 28710), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 28689), PairWithPosition.make(Lit27, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 28725), (SimpleSymbol)new SimpleSymbol("cond").readResolve(), PairWithPosition.make(Lit36, PairWithPosition.make(Lit29, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<gnu.expr.Keyword>").readResolve(), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 32797), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 32793), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 32782), PairWithPosition.make(PairWithPosition.make(Lit30, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.expr.Keyword").readResolve(), Pair.make(Pair.make(Lit31, Pair.make(Lit40, LList.Empty)), LList.Empty)), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 40970), PairWithPosition.make(Lit29, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 40995), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 40969), PairWithPosition.make(Lit32, PairWithPosition.make(Lit33, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45087), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45066), PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45107), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45105), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45102), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 45102), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(IntNum.make(2), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49170), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49168), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49165), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49165), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49159), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 49159), PairWithPosition.make(Lit36, PairWithPosition.make(Lit29, PairWithPosition.make(Lit37, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 53270), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 53266), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 53255), (SimpleSymbol)new SimpleSymbol("let*").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit38, PairWithPosition.make(Lit25, PairWithPosition.make(Lit37, PairWithPosition.make(Lit29, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 57388), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 57367), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 57364), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 57358), PairWithPosition.make(PairWithPosition.make(Lit42, PairWithPosition.make(Lit25, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<java.lang.String>").readResolve(), PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(Lit38, PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make(Lit40, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61489), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61489), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61488), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61483), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61475), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61475), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61456), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61453), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61447), PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit41, PairWithPosition.make(Lit38, PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("getObjectValue").readResolve(), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65564), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65564), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65563), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65558), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65550), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65550), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65543), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 65543), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 61447), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 57357), PairWithPosition.make(Lit42, PairWithPosition.make(Lit43, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 69666), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 69661), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73746), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73744), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73741), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73741), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73735), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 73735), (SimpleSymbol)new SimpleSymbol("else").readResolve(), PairWithPosition.make(Lit29, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 81951), PairWithPosition.make(PairWithPosition.make(Lit34, PairWithPosition.make(PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, PairWithPosition.make(Lit44, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86034), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86032), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86029), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86029), "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86023), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 86023) }, 0);
    Lit8 = new SyntaxRules(new Object[] { localObject }, new SyntaxRule[] { localSyntaxRule }, 4);
    Lit6 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.Column>").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.Row>").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("*.getHeight").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("*.getWidth").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("cell-spacing").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("text").readResolve();
    Lit0 = Color.class;
    $instance = new gui();
    loc$$St$DtgetWidth = ThreadLocation.getInstance(Lit3, null);
    loc$$St$DtgetHeight = ThreadLocation.getInstance(Lit4, null);
    loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr = ThreadLocation.getInstance(Lit5, null);
    loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr = ThreadLocation.getInstance(Lit6, null);
    process$Mnkeywords = Macro.make(Lit7, Lit8, $instance);
    localObject = $instance;
    as$Mncolor = new ModuleMethod((ModuleBody)localObject, 1, Lit9, 4097);
    button = new ModuleMethod((ModuleBody)localObject, 2, Lit10, 61440);
    Button = new ModuleMethod((ModuleBody)localObject, 3, Lit11, 61440);
    Image = Macro.make(Lit12, Lit13, $instance);
    image$Mnread = new ModuleMethod((ModuleBody)localObject, 4, Lit14, 4097);
    image$Mnwidth = new ModuleMethod((ModuleBody)localObject, 5, Lit15, 4097);
    image$Mnheight = new ModuleMethod((ModuleBody)localObject, 6, Lit16, 4097);
    Label = new ModuleMethod((ModuleBody)localObject, 7, Lit17, 61440);
    Text = new ModuleMethod((ModuleBody)localObject, 8, Lit18, 61440);
    Row = new ModuleMethod((ModuleBody)localObject, 9, Lit19, 61440);
    Column = new ModuleMethod((ModuleBody)localObject, 10, Lit20, 61440);
    set$Mncontent = new ModuleMethod((ModuleBody)localObject, 11, Lit21, 8194);
    Window = new ModuleMethod((ModuleBody)localObject, 12, Lit22, 61440);
    run$Mnapplication = Macro.make(Lit23, Lit24, $instance);
    $instance.run();
  }
  
  public gui()
  {
    ModuleInfo.register(this);
  }
  
  public static Button Button(Object... paramVarArgs)
  {
    Button localButton = new Button();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 instanceof Keyword)) {}
      try
      {
        localObject2 = (Keyword)localObject1;
        buttonKeyword(localButton, ((Keyword)localObject2).getName(), paramVarArgs[(i + 1)]);
        i += 2;
      }
      catch (ClassCastException paramVarArgs)
      {
        Object localObject2;
        throw new WrongType(paramVarArgs, "gnu.expr.Keyword.getName()", 1, localObject1);
      }
      if ((localObject1 instanceof KAttr)) {}
      try
      {
        localObject2 = (KAttr)localObject1;
        buttonKeyword(localButton, ((KAttr)localObject2).getName(), ((KAttr)localObject2).getObjectValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "attr", -2, localObject1);
      }
      buttonNonKeyword(localButton, localObject1);
      i += 1;
    }
    return localButton;
  }
  
  /* Error */
  public static Object Column(Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 500	gnu/kawa/reflect/Invoke:make	Lgnu/kawa/reflect/Invoke;
    //   3: astore_3
    //   4: getstatic 410	gnu/kawa/slib/gui:loc$$Lsgnu$Dtkawa$Dtmodels$DtColumn$Gr	Lgnu/mapping/Location;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 505	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   14: astore 4
    //   16: aload_3
    //   17: aload 4
    //   19: invokevirtual 511	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore_3
    //   23: aload_0
    //   24: arraylength
    //   25: istore_2
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iload_2
    //   30: if_icmpge +215 -> 245
    //   33: aload_0
    //   34: iload_1
    //   35: aaload
    //   36: astore 4
    //   38: aload 4
    //   40: instanceof 469
    //   43: ifeq +39 -> 82
    //   46: aload_3
    //   47: checkcast 513	gnu/kawa/models/Box
    //   50: astore 5
    //   52: aload 4
    //   54: checkcast 469	gnu/expr/Keyword
    //   57: astore 6
    //   59: aload 5
    //   61: aload 6
    //   63: invokevirtual 472	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   66: aload_0
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: aaload
    //   71: invokestatic 517	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: iload_1
    //   76: iconst_2
    //   77: iadd
    //   78: istore_1
    //   79: goto -51 -> 28
    //   82: aload 4
    //   84: instanceof 478
    //   87: ifeq +47 -> 134
    //   90: aload 4
    //   92: checkcast 478	gnu/kawa/xml/KAttr
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 479	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 481	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   109: astore 5
    //   111: aload_3
    //   112: checkcast 513	gnu/kawa/models/Box
    //   115: astore 6
    //   117: aload 6
    //   119: aload 4
    //   121: aload 5
    //   123: invokestatic 517	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: istore_1
    //   131: goto -103 -> 28
    //   134: aload_3
    //   135: checkcast 513	gnu/kawa/models/Box
    //   138: astore 5
    //   140: aload 5
    //   142: aload 4
    //   144: invokestatic 521	gnu/kawa/slib/gui:boxNonKeyword	(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -123 -> 28
    //   154: astore_0
    //   155: aload_0
    //   156: ldc -47
    //   158: sipush 151
    //   161: bipush 25
    //   163: invokevirtual 525	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: new 487	gnu/mapping/WrongType
    //   172: dup
    //   173: aload_0
    //   174: ldc_w 527
    //   177: iconst_0
    //   178: aload_3
    //   179: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: astore_0
    //   184: new 487	gnu/mapping/WrongType
    //   187: dup
    //   188: aload_0
    //   189: ldc_w 489
    //   192: iconst_1
    //   193: aload 4
    //   195: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   198: athrow
    //   199: astore_0
    //   200: new 487	gnu/mapping/WrongType
    //   203: dup
    //   204: aload_0
    //   205: ldc 119
    //   207: bipush -2
    //   209: aload 4
    //   211: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: astore_0
    //   216: new 487	gnu/mapping/WrongType
    //   219: dup
    //   220: aload_0
    //   221: ldc_w 527
    //   224: iconst_0
    //   225: aload_3
    //   226: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore_0
    //   231: new 487	gnu/mapping/WrongType
    //   234: dup
    //   235: aload_0
    //   236: ldc_w 529
    //   239: iconst_0
    //   240: aload_3
    //   241: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: aload_3
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramVarArgs	Object[]
    //   27	124	1	i	int
    //   25	6	2	j	int
    //   3	243	3	localObject1	Object
    //   7	203	4	localObject2	Object
    //   50	91	5	localObject3	Object
    //   57	61	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	154	gnu/mapping/UnboundLocationException
    //   46	52	168	java/lang/ClassCastException
    //   52	59	183	java/lang/ClassCastException
    //   90	97	199	java/lang/ClassCastException
    //   111	117	215	java/lang/ClassCastException
    //   134	140	230	java/lang/ClassCastException
  }
  
  public static Label Label(Object... paramVarArgs)
  {
    Label localLabel = new Label();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 instanceof Keyword)) {}
      try
      {
        localObject2 = (Keyword)localObject1;
        labelKeyword(localLabel, ((Keyword)localObject2).getName(), paramVarArgs[(i + 1)]);
        i += 2;
      }
      catch (ClassCastException paramVarArgs)
      {
        Object localObject2;
        throw new WrongType(paramVarArgs, "gnu.expr.Keyword.getName()", 1, localObject1);
      }
      if ((localObject1 instanceof KAttr)) {}
      try
      {
        localObject2 = (KAttr)localObject1;
        labelKeyword(localLabel, ((KAttr)localObject2).getName(), ((KAttr)localObject2).getObjectValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "attr", -2, localObject1);
      }
      labelNonKeyword(localLabel, localObject1);
      i += 1;
    }
    return localLabel;
  }
  
  /* Error */
  public static Object Row(Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 500	gnu/kawa/reflect/Invoke:make	Lgnu/kawa/reflect/Invoke;
    //   3: astore_3
    //   4: getstatic 408	gnu/kawa/slib/gui:loc$$Lsgnu$Dtkawa$Dtmodels$DtRow$Gr	Lgnu/mapping/Location;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 505	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   14: astore 4
    //   16: aload_3
    //   17: aload 4
    //   19: invokevirtual 511	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore_3
    //   23: aload_0
    //   24: arraylength
    //   25: istore_2
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iload_2
    //   30: if_icmpge +215 -> 245
    //   33: aload_0
    //   34: iload_1
    //   35: aaload
    //   36: astore 4
    //   38: aload 4
    //   40: instanceof 469
    //   43: ifeq +39 -> 82
    //   46: aload_3
    //   47: checkcast 513	gnu/kawa/models/Box
    //   50: astore 5
    //   52: aload 4
    //   54: checkcast 469	gnu/expr/Keyword
    //   57: astore 6
    //   59: aload 5
    //   61: aload 6
    //   63: invokevirtual 472	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   66: aload_0
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: aaload
    //   71: invokestatic 517	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: iload_1
    //   76: iconst_2
    //   77: iadd
    //   78: istore_1
    //   79: goto -51 -> 28
    //   82: aload 4
    //   84: instanceof 478
    //   87: ifeq +47 -> 134
    //   90: aload 4
    //   92: checkcast 478	gnu/kawa/xml/KAttr
    //   95: astore 5
    //   97: aload 5
    //   99: invokevirtual 479	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 481	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   109: astore 5
    //   111: aload_3
    //   112: checkcast 513	gnu/kawa/models/Box
    //   115: astore 6
    //   117: aload 6
    //   119: aload 4
    //   121: aload 5
    //   123: invokestatic 517	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: istore_1
    //   131: goto -103 -> 28
    //   134: aload_3
    //   135: checkcast 513	gnu/kawa/models/Box
    //   138: astore 5
    //   140: aload 5
    //   142: aload 4
    //   144: invokestatic 521	gnu/kawa/slib/gui:boxNonKeyword	(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -123 -> 28
    //   154: astore_0
    //   155: aload_0
    //   156: ldc -47
    //   158: sipush 146
    //   161: bipush 25
    //   163: invokevirtual 525	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: new 487	gnu/mapping/WrongType
    //   172: dup
    //   173: aload_0
    //   174: ldc_w 527
    //   177: iconst_0
    //   178: aload_3
    //   179: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: astore_0
    //   184: new 487	gnu/mapping/WrongType
    //   187: dup
    //   188: aload_0
    //   189: ldc_w 489
    //   192: iconst_1
    //   193: aload 4
    //   195: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   198: athrow
    //   199: astore_0
    //   200: new 487	gnu/mapping/WrongType
    //   203: dup
    //   204: aload_0
    //   205: ldc 119
    //   207: bipush -2
    //   209: aload 4
    //   211: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: astore_0
    //   216: new 487	gnu/mapping/WrongType
    //   219: dup
    //   220: aload_0
    //   221: ldc_w 527
    //   224: iconst_0
    //   225: aload_3
    //   226: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore_0
    //   231: new 487	gnu/mapping/WrongType
    //   234: dup
    //   235: aload_0
    //   236: ldc_w 529
    //   239: iconst_0
    //   240: aload_3
    //   241: invokespecial 492	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    //   245: aload_3
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramVarArgs	Object[]
    //   27	124	1	i	int
    //   25	6	2	j	int
    //   3	243	3	localObject1	Object
    //   7	203	4	localObject2	Object
    //   50	91	5	localObject3	Object
    //   57	61	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	154	gnu/mapping/UnboundLocationException
    //   46	52	168	java/lang/ClassCastException
    //   52	59	183	java/lang/ClassCastException
    //   90	97	199	java/lang/ClassCastException
    //   111	117	215	java/lang/ClassCastException
    //   134	140	230	java/lang/ClassCastException
  }
  
  public static Text Text(Object... paramVarArgs)
  {
    Text localText = new Text();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 instanceof Keyword)) {}
      try
      {
        localObject2 = (Keyword)localObject1;
        textKeyword(localText, ((Keyword)localObject2).getName(), paramVarArgs[(i + 1)]);
        i += 2;
      }
      catch (ClassCastException paramVarArgs)
      {
        Object localObject2;
        throw new WrongType(paramVarArgs, "gnu.expr.Keyword.getName()", 1, localObject1);
      }
      if ((localObject1 instanceof KAttr)) {}
      try
      {
        localObject2 = (KAttr)localObject1;
        textKeyword(localText, ((KAttr)localObject2).getName(), ((KAttr)localObject2).getObjectValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "attr", -2, localObject1);
      }
      textNonKeyword(localText, localObject1);
      i += 1;
    }
    return localText;
  }
  
  public static Window Window(Object... paramVarArgs)
  {
    Window localWindow = Display.getInstance().makeWindow();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 instanceof Keyword)) {}
      try
      {
        localObject2 = (Keyword)localObject1;
        windowKeyword(localWindow, ((Keyword)localObject2).getName(), paramVarArgs[(i + 1)]);
        i += 2;
      }
      catch (ClassCastException paramVarArgs)
      {
        Object localObject2;
        throw new WrongType(paramVarArgs, "gnu.expr.Keyword.getName()", 1, localObject1);
      }
      if ((localObject1 instanceof KAttr)) {}
      try
      {
        localObject2 = (KAttr)localObject1;
        windowKeyword(localWindow, ((KAttr)localObject2).getName(), ((KAttr)localObject2).getObjectValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "attr", -2, localObject1);
      }
      windowNonKeyword(localWindow, localObject1);
      i += 1;
    }
    return localWindow;
  }
  
  public static Color asColor(Object paramObject)
  {
    if ((paramObject instanceof Color)) {
      return (Color)paramObject;
    }
    if ((paramObject instanceof Integer)) {}
    try
    {
      Integer localInteger = (Integer)paramObject;
      return new Color(localInteger.intValue());
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "java.lang.Integer.intValue()", 1, paramObject);
    }
    if ((paramObject instanceof IntNum)) {
      return new Color(IntNum.intValue(paramObject));
    }
    return (Color)SlotGet.staticField.apply2(Lit0, paramObject.toString());
  }
  
  static Model asModel(Object paramObject)
  {
    return Display.getInstance().coerceToModel(paramObject);
  }
  
  static Object boxKeyword(Box paramBox, String paramString, Object paramObject)
  {
    if (paramString == Lit2)
    {
      paramBox.setCellSpacing(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown box attribute ~s", paramString }), new Object[0]);
  }
  
  static void boxNonKeyword(Box paramBox, Object paramObject)
  {
    paramBox.add(asModel(paramObject));
  }
  
  public static Button button(Object... paramVarArgs)
  {
    Button localButton = new Button();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 instanceof Keyword)) {}
      try
      {
        localObject2 = (Keyword)localObject1;
        buttonKeyword(localButton, ((Keyword)localObject2).getName(), paramVarArgs[(i + 1)]);
        i += 2;
      }
      catch (ClassCastException paramVarArgs)
      {
        Object localObject2;
        throw new WrongType(paramVarArgs, "gnu.expr.Keyword.getName()", 1, localObject1);
      }
      if ((localObject1 instanceof KAttr)) {}
      try
      {
        localObject2 = (KAttr)localObject1;
        buttonKeyword(localButton, ((KAttr)localObject2).getName(), ((KAttr)localObject2).getObjectValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "attr", -2, localObject1);
      }
      buttonNonKeyword(localButton, localObject1);
      i += 1;
    }
    return localButton;
  }
  
  static Object buttonKeyword(Button paramButton, String paramString, Object paramObject)
  {
    boolean bool = true;
    if (paramString == "foreground")
    {
      paramButton.setForeground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "background")
    {
      paramButton.setBackground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "action")
    {
      paramButton.setAction(paramObject);
      return Values.empty;
    }
    if (paramString == "text")
    {
      if (paramObject == null) {}
      for (paramString = null;; paramString = paramObject.toString())
      {
        paramButton.setText(paramString);
        return Values.empty;
      }
    }
    if (paramString == "disabled") {}
    try
    {
      paramString = Boolean.FALSE;
      if (paramObject != paramString) {}
      for (;;)
      {
        paramButton.setDisabled(bool);
        return Values.empty;
        bool = false;
      }
      return misc.error$V(Format.formatToString(0, new Object[] { "unknown button attribute ~s", paramString }), new Object[0]);
    }
    catch (ClassCastException paramButton)
    {
      throw new WrongType(paramButton, "gnu.kawa.models.Button.setDisabled(boolean)", 2, paramObject);
    }
  }
  
  static Boolean buttonNonKeyword(Button paramButton, Object paramObject)
  {
    return Boolean.TRUE;
  }
  
  public static int imageHeight(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Object localObject = loc$$St$DtgetHeight;
    try
    {
      localObject = ((Location)localObject).get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException paramBufferedImage)
    {
      paramBufferedImage.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 77, 3);
      throw paramBufferedImage;
    }
  }
  
  public static BufferedImage imageRead(Path paramPath)
  {
    return ImageIO.read(paramPath.openInputStream());
  }
  
  public static int imageWidth(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Object localObject = loc$$St$DtgetWidth;
    try
    {
      localObject = ((Location)localObject).get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException paramBufferedImage)
    {
      paramBufferedImage.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/gui.scm", 74, 3);
      throw paramBufferedImage;
    }
  }
  
  static Object labelKeyword(Label paramLabel, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null) {}
      for (paramString = null;; paramString = paramObject.toString())
      {
        paramLabel.setText(paramString);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown label attribute ~s", paramString }), new Object[0]);
  }
  
  static void labelNonKeyword(Label paramLabel, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = paramObject.toString())
    {
      paramLabel.setText((String)paramObject);
      return;
    }
  }
  
  public static void setContent(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }
  
  static Object textKeyword(Text paramText, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null) {}
      for (paramString = null;; paramString = paramObject.toString())
      {
        paramText.setText(paramString);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown text attribute ~s", paramString }), new Object[0]);
  }
  
  static void textNonKeyword(Text paramText, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = paramObject.toString())
    {
      paramText.setText((String)paramObject);
      return;
    }
  }
  
  static Object windowKeyword(Window paramWindow, String paramString, Object paramObject)
  {
    if (paramString == "title")
    {
      if (paramObject == null) {}
      for (paramString = null;; paramString = paramObject.toString())
      {
        paramWindow.setTitle(paramString);
        return Values.empty;
      }
    }
    if (paramString == "content")
    {
      paramWindow.setContent(paramObject);
      return Values.empty;
    }
    if (paramString == "menubar")
    {
      paramWindow.setMenuBar(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown window attribute ~s", paramString }), new Object[0]);
  }
  
  static void windowNonKeyword(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 3: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      return asColor(paramObject);
    }
    try
    {
      paramModuleMethod = Path.valueOf(paramObject);
      return imageRead(paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      try
      {
        paramModuleMethod = (BufferedImage)paramObject;
        return Integer.valueOf(imageWidth(paramModuleMethod));
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "image-width", 1, paramObject);
      }
      try
      {
        paramModuleMethod = (BufferedImage)paramObject;
        return Integer.valueOf(imageHeight(paramModuleMethod));
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "image-height", 1, paramObject);
      }
      paramModuleMethod = paramModuleMethod;
      throw new WrongType(paramModuleMethod, "image-read", 1, paramObject);
    }
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 11) {}
    try
    {
      paramModuleMethod = (Window)paramObject1;
      setContent(paramModuleMethod, paramObject2);
      return Values.empty;
    }
    catch (ClassCastException paramModuleMethod)
    {
      throw new WrongType(paramModuleMethod, "set-content", 1, paramObject1);
    }
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    default: 
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 2: 
      return button(paramArrayOfObject);
    case 3: 
      return Button(paramArrayOfObject);
    case 7: 
      return Label(paramArrayOfObject);
    case 8: 
      return Text(paramArrayOfObject);
    case 9: 
      return Row(paramArrayOfObject);
    case 10: 
      return Column(paramArrayOfObject);
    }
    return Window(paramArrayOfObject);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    case 2: 
    case 3: 
    default: 
      i = super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6: 
    case 5: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return i;
          } while (!(paramObject instanceof BufferedImage));
          paramCallContext.value1 = paramObject;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 1;
          return 0;
        } while (!(paramObject instanceof BufferedImage));
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      } while (Path.coerceToPathOrNull(paramObject) == null);
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
    if (paramModuleMethod.selector == 11)
    {
      if (!(paramObject1 instanceof Window)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 12: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 10: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 9: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 8: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 7: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 3: 
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
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\gui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */