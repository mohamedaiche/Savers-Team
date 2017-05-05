package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.models.Paintable;
import gnu.kawa.models.WithTransform;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.swingviews.SwingDisplay;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.RealNum;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import kawa.lib.numbers;
import kawa.standard.Scheme;

public class swing
  extends ModuleBody
{
  public static final swing $instance;
  public static final Location Button;
  public static final Location Column;
  public static final Location Image;
  public static final Location Label;
  static final SimpleSymbol Lit0;
  static final Keyword Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final Keyword Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26 = (SimpleSymbol)new SimpleSymbol("scroll").readResolve();
  static final Keyword Lit3;
  static final Keyword Lit4;
  static final Keyword Lit5;
  static final Keyword Lit6;
  static final Keyword Lit7;
  static final Keyword Lit8;
  static final SimpleSymbol Lit9;
  public static final Location Row;
  public static final Location Text;
  public static final Location Window;
  public static final Location button;
  public static final Color color$Mnred;
  public static final ModuleMethod composite$Mnsrc;
  public static final ModuleMethod composite$Mnsrc$Mnover;
  public static final ModuleMethod draw;
  public static final ModuleMethod fill;
  public static final Location image$Mnheight;
  public static final Location image$Mnread;
  public static final Location image$Mnwidth;
  static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtDrawShape$Gr;
  static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtFillShape$Gr;
  static final Location loc$$Lsgnu$Dtkawa$Dtmodels$DtWithPaint$Gr;
  static final Location loc$gnu$Dtkawa$Dtmodels$DtWithComposite;
  public static final ModuleMethod make$Mnaction$Mnlistener;
  public static final ModuleMethod menu;
  public static final ModuleMethod menubar;
  public static final ModuleMethod menuitem;
  public static final ModuleMethod polygon;
  public static final ModuleMethod rotation;
  public static final Location run$Mnapplication;
  public static final ModuleMethod scroll;
  public static final Location set$Mncontent;
  public static final ModuleMethod with$Mncomposite;
  public static final ModuleMethod with$Mnpaint;
  public static final ModuleMethod with$Mntransform;
  
  static
  {
    Lit25 = (SimpleSymbol)new SimpleSymbol("polygon").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("menuitem").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("menu").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("menubar").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("with-transform").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("rotation").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("composite-src").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("composite-src-over").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("with-composite").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("with-paint").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("draw").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("fill").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("make-action-listener").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("gnu.kawa.models.WithComposite").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.WithPaint>").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.DrawShape>").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.FillShape>").readResolve();
    Lit8 = Keyword.make("h");
    Lit7 = Keyword.make("w");
    Lit6 = Keyword.make("accesskey");
    Lit5 = Keyword.make("disabled");
    Lit4 = Keyword.make("oncommand");
    Lit3 = Keyword.make("default");
    Lit2 = Keyword.make("image");
    Lit1 = Keyword.make("label");
    Lit0 = (SimpleSymbol)new SimpleSymbol("make").readResolve();
    $instance = new swing();
    loc$$Lsgnu$Dtkawa$Dtmodels$DtFillShape$Gr = ThreadLocation.getInstance(Lit9, null);
    loc$$Lsgnu$Dtkawa$Dtmodels$DtDrawShape$Gr = ThreadLocation.getInstance(Lit10, null);
    loc$$Lsgnu$Dtkawa$Dtmodels$DtWithPaint$Gr = ThreadLocation.getInstance(Lit11, null);
    loc$gnu$Dtkawa$Dtmodels$DtWithComposite = ThreadLocation.getInstance(Lit12, null);
    button = StaticFieldLocation.make("gnu.kawa.slib.gui", "button");
    Button = StaticFieldLocation.make("gnu.kawa.slib.gui", "Button");
    Image = StaticFieldLocation.make("gnu.kawa.slib.gui", "Image");
    image$Mnread = StaticFieldLocation.make("gnu.kawa.slib.gui", "image$Mnread");
    image$Mnwidth = StaticFieldLocation.make("gnu.kawa.slib.gui", "image$Mnwidth");
    image$Mnheight = StaticFieldLocation.make("gnu.kawa.slib.gui", "image$Mnheight");
    Label = StaticFieldLocation.make("gnu.kawa.slib.gui", "Label");
    Text = StaticFieldLocation.make("gnu.kawa.slib.gui", "Text");
    Row = StaticFieldLocation.make("gnu.kawa.slib.gui", "Row");
    Column = StaticFieldLocation.make("gnu.kawa.slib.gui", "Column");
    set$Mncontent = StaticFieldLocation.make("gnu.kawa.slib.gui", "set$Mncontent");
    Window = StaticFieldLocation.make("gnu.kawa.slib.gui", "Window");
    run$Mnapplication = StaticFieldLocation.make("gnu.kawa.slib.gui", "run$Mnapplication");
    swing localswing = $instance;
    make$Mnaction$Mnlistener = new ModuleMethod(localswing, 1, Lit13, 4097);
    fill = new ModuleMethod(localswing, 2, Lit14, 4097);
    draw = new ModuleMethod(localswing, 3, Lit15, 4097);
    with$Mnpaint = new ModuleMethod(localswing, 4, Lit16, 8194);
    with$Mncomposite = new ModuleMethod(localswing, 5, Lit17, 61440);
    composite$Mnsrc$Mnover = new ModuleMethod(localswing, 6, Lit18, 4096);
    composite$Mnsrc = new ModuleMethod(localswing, 8, Lit19, 4096);
    rotation = new ModuleMethod(localswing, 10, Lit20, 4097);
    with$Mntransform = new ModuleMethod(localswing, 11, Lit21, 8194);
    menubar = new ModuleMethod(localswing, 12, Lit22, 61440);
    menu = new ModuleMethod(localswing, 13, Lit23, 61440);
    menuitem = new ModuleMethod(localswing, 14, Lit24, 61440);
    polygon = new ModuleMethod(localswing, 15, Lit25, 61441);
    scroll = new ModuleMethod(localswing, 16, Lit26, 61441);
    $instance.run();
  }
  
  public swing()
  {
    ModuleInfo.register(this);
  }
  
  public static Composite compositeSrc()
  {
    return compositeSrc(1.0F);
  }
  
  public static Composite compositeSrc(float paramFloat)
  {
    return AlphaComposite.getInstance(AlphaComposite.SRC, paramFloat);
  }
  
  public static Composite compositeSrcOver()
  {
    return compositeSrcOver(1.0F);
  }
  
  public static Composite compositeSrcOver(float paramFloat)
  {
    return AlphaComposite.getInstance(AlphaComposite.SRC_OVER, paramFloat);
  }
  
  public static Paintable draw(Shape paramShape)
  {
    Invoke localInvoke = Invoke.make;
    Object localObject = loc$$Lsgnu$Dtkawa$Dtmodels$DtDrawShape$Gr;
    try
    {
      localObject = ((Location)localObject).get();
      return (Paintable)localInvoke.apply2(localObject, paramShape);
    }
    catch (UnboundLocationException paramShape)
    {
      paramShape.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/swing.scm", 22, 9);
      throw paramShape;
    }
  }
  
  public static Paintable fill(Shape paramShape)
  {
    Invoke localInvoke = Invoke.make;
    Object localObject = loc$$Lsgnu$Dtkawa$Dtmodels$DtFillShape$Gr;
    try
    {
      localObject = ((Location)localObject).get();
      return (Paintable)localInvoke.apply2(localObject, paramShape);
    }
    catch (UnboundLocationException paramShape)
    {
      paramShape.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/swing.scm", 19, 9);
      throw paramShape;
    }
  }
  
  public static ActionListener makeActionListener(Object paramObject)
  {
    return SwingDisplay.makeActionListener(paramObject);
  }
  
  public static JMenu menu(Object... paramVarArgs)
  {
    JMenu localJMenu = new JMenu();
    int k = paramVarArgs.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = paramVarArgs[i];
      int j;
      if (localObject == Lit1)
      {
        j = 1;
        label34:
        if (j == 0) {
          break label79;
        }
        if (i + 1 >= k) {
          break label83;
        }
        label45:
        localObject = paramVarArgs[(i + 1)];
        if (localObject != null) {
          break label101;
        }
      }
      label79:
      label83:
      label101:
      for (localObject = null;; localObject = localObject.toString())
      {
        localJMenu.setText((String)localObject);
        i += 2;
        break;
        j = 0;
        break label34;
        if (j != 0) {
          break label45;
        }
        localJMenu.add((JMenuItem)localObject);
        i += 1;
        break;
      }
    }
    return localJMenu;
  }
  
  public static JMenuBar menubar(Object... paramVarArgs)
  {
    JMenuBar localJMenuBar = new JMenuBar();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localJMenuBar.add((JMenu)paramVarArgs[i]);
      i += 1;
    }
    return localJMenuBar;
  }
  
  public static JMenuItem menuitem$V(Object[] paramArrayOfObject)
  {
    Object localObject1 = Keyword.searchForKeyword(paramArrayOfObject, 0, Lit1, null);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = localObject1.toString())
    {
      Keyword.searchForKeyword(paramArrayOfObject, 0, Lit2, null);
      Keyword.searchForKeyword(paramArrayOfObject, 0, Lit3, null);
      Object localObject2 = Keyword.searchForKeyword(paramArrayOfObject, 0, Lit4, null);
      Object localObject3 = Keyword.searchForKeyword(paramArrayOfObject, 0, Lit5, Boolean.FALSE);
      Keyword.searchForKeyword(paramArrayOfObject, 0, Lit6, null);
      paramArrayOfObject = new JMenuItem();
      if (localObject3 != Boolean.FALSE) {
        paramArrayOfObject.setEnabled(false);
      }
      if (localObject1 != null) {
        paramArrayOfObject.setText((String)localObject1);
      }
      if (localObject2 != null) {
        paramArrayOfObject.addActionListener(makeActionListener(localObject2));
      }
      return paramArrayOfObject;
    }
  }
  
  public static Object polygon(Complex paramComplex, Object... paramVarArgs)
  {
    GeneralPath localGeneralPath = new GeneralPath();
    int j = paramVarArgs.length;
    localGeneralPath.moveTo(numbers.realPart(paramComplex).doubleValue(), numbers.imagPart(paramComplex).doubleValue());
    int i = 0;
    for (;;)
    {
      if (i < j) {
        paramComplex = paramVarArgs[i];
      }
      try
      {
        Complex localComplex = (Complex)paramComplex;
        localGeneralPath.lineTo(numbers.realPart(localComplex).doubleValue(), numbers.imagPart(localComplex).doubleValue());
        i += 1;
      }
      catch (ClassCastException paramVarArgs)
      {
        throw new WrongType(paramVarArgs, "pt", -2, paramComplex);
      }
    }
    localGeneralPath.closePath();
    return localGeneralPath;
  }
  
  public static AffineTransform rotation(double paramDouble)
  {
    return AffineTransform.getRotateInstance(paramDouble);
  }
  
  /* Error */
  public static javax.swing.JScrollPane scroll$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: getstatic 160	gnu/kawa/slib/swing:Lit7	Lgnu/expr/Keyword;
    //   5: getstatic 386	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   8: invokestatic 380	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: astore 4
    //   13: aload_1
    //   14: iconst_0
    //   15: getstatic 156	gnu/kawa/slib/swing:Lit8	Lgnu/expr/Keyword;
    //   18: getstatic 386	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   21: invokestatic 380	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore 5
    //   26: aload_0
    //   27: astore_1
    //   28: aload_0
    //   29: instanceof 336
    //   32: ifeq +17 -> 49
    //   35: aload_0
    //   36: checkcast 336	gnu/kawa/models/Paintable
    //   39: astore_1
    //   40: new 447	gnu/kawa/swingviews/SwingPaintable
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 450	gnu/kawa/swingviews/SwingPaintable:<init>	(Lgnu/kawa/models/Paintable;)V
    //   48: astore_1
    //   49: aload_1
    //   50: checkcast 452	java/awt/Component
    //   53: astore_0
    //   54: new 454	javax/swing/JScrollPane
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 457	javax/swing/JScrollPane:<init>	(Ljava/awt/Component;)V
    //   62: astore_0
    //   63: aload 4
    //   65: checkcast 459	java/lang/Number
    //   68: invokevirtual 463	java/lang/Number:intValue	()I
    //   71: istore_2
    //   72: aload 5
    //   74: checkcast 459	java/lang/Number
    //   77: invokevirtual 463	java/lang/Number:intValue	()I
    //   80: istore_3
    //   81: aload_0
    //   82: new 465	java/awt/Dimension
    //   85: dup
    //   86: iload_2
    //   87: iload_3
    //   88: invokespecial 468	java/awt/Dimension:<init>	(II)V
    //   91: invokevirtual 472	javax/swing/JScrollPane:setPreferredSize	(Ljava/awt/Dimension;)V
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: new 432	gnu/mapping/WrongType
    //   100: dup
    //   101: aload_1
    //   102: ldc_w 474
    //   105: iconst_1
    //   106: aload_0
    //   107: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: astore_0
    //   112: new 432	gnu/mapping/WrongType
    //   115: dup
    //   116: aload_0
    //   117: ldc_w 476
    //   120: iconst_1
    //   121: aload_1
    //   122: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: astore_0
    //   127: new 432	gnu/mapping/WrongType
    //   130: dup
    //   131: aload_0
    //   132: ldc_w 478
    //   135: iconst_1
    //   136: aload 4
    //   138: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    //   142: astore_0
    //   143: new 432	gnu/mapping/WrongType
    //   146: dup
    //   147: aload_0
    //   148: ldc_w 478
    //   151: iconst_2
    //   152: aload 5
    //   154: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramObject	Object
    //   0	158	1	paramArrayOfObject	Object[]
    //   71	16	2	i	int
    //   80	8	3	j	int
    //   11	126	4	localObject1	Object
    //   24	129	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	96	java/lang/ClassCastException
    //   49	54	111	java/lang/ClassCastException
    //   63	72	126	java/lang/ClassCastException
    //   72	81	142	java/lang/ClassCastException
  }
  
  public static Object withComposite(Object... paramVarArgs)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    GetNamedPart localGetNamedPart = GetNamedPart.getNamedPart;
    Object localObject = loc$gnu$Dtkawa$Dtmodels$DtWithComposite;
    try
    {
      localObject = ((Location)localObject).get();
      return localApplyToArgs.apply2(localGetNamedPart.apply2(localObject, Lit0), paramVarArgs);
    }
    catch (UnboundLocationException paramVarArgs)
    {
      paramVarArgs.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/swing.scm", 29, 4);
      throw paramVarArgs;
    }
  }
  
  public static Object withPaint(Color paramColor, Paintable paramPaintable)
  {
    Invoke localInvoke = Invoke.make;
    Object localObject = loc$$Lsgnu$Dtkawa$Dtmodels$DtWithPaint$Gr;
    try
    {
      localObject = ((Location)localObject).get();
      return localInvoke.apply3(localObject, paramPaintable, paramColor);
    }
    catch (UnboundLocationException paramColor)
    {
      paramColor.setLine("/Users/ewpatton/Programming/mit/ai2-kawa/gnu/kawa/slib/swing.scm", 26, 10);
      throw paramColor;
    }
  }
  
  public static WithTransform withTransform(AffineTransform paramAffineTransform, Paintable paramPaintable)
  {
    return new WithTransform(paramPaintable, paramAffineTransform);
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 7: 
    default: 
      return super.apply0(paramModuleMethod);
    case 6: 
      return compositeSrcOver();
    }
    return compositeSrc();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return super.apply1(paramModuleMethod, paramObject);
    case 1: 
      return makeActionListener(paramObject);
    }
    try
    {
      paramModuleMethod = (Shape)paramObject;
      return fill(paramModuleMethod);
    }
    catch (ClassCastException paramModuleMethod)
    {
      try
      {
        paramModuleMethod = (Shape)paramObject;
        return draw(paramModuleMethod);
      }
      catch (ClassCastException paramModuleMethod)
      {
        float f;
        double d;
        throw new WrongType(paramModuleMethod, "draw", 1, paramObject);
      }
      try
      {
        f = ((Number)paramObject).floatValue();
        return compositeSrcOver(f);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "composite-src-over", 1, paramObject);
      }
      try
      {
        f = ((Number)paramObject).floatValue();
        return compositeSrc(f);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "composite-src", 1, paramObject);
      }
      try
      {
        d = ((Number)paramObject).doubleValue();
        return rotation(d);
      }
      catch (ClassCastException paramModuleMethod)
      {
        throw new WrongType(paramModuleMethod, "rotation", 1, paramObject);
      }
      paramModuleMethod = paramModuleMethod;
      throw new WrongType(paramModuleMethod, "fill", 1, paramObject);
    }
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 510	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 4:+36->40, 11:+52->56
    //   32: aload_0
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: invokespecial 536	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: areturn
    //   40: aload_2
    //   41: checkcast 538	java/awt/Color
    //   44: astore_1
    //   45: aload_3
    //   46: checkcast 336	gnu/kawa/models/Paintable
    //   49: astore_2
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 540	gnu/kawa/slib/swing:withPaint	(Ljava/awt/Color;Lgnu/kawa/models/Paintable;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_2
    //   57: checkcast 440	java/awt/geom/AffineTransform
    //   60: astore_1
    //   61: aload_3
    //   62: checkcast 336	gnu/kawa/models/Paintable
    //   65: astore_2
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 542	gnu/kawa/slib/swing:withTransform	(Ljava/awt/geom/AffineTransform;Lgnu/kawa/models/Paintable;)Lgnu/kawa/models/WithTransform;
    //   71: areturn
    //   72: astore_1
    //   73: new 432	gnu/mapping/WrongType
    //   76: dup
    //   77: aload_1
    //   78: ldc 118
    //   80: iconst_1
    //   81: aload_2
    //   82: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   85: athrow
    //   86: astore_1
    //   87: new 432	gnu/mapping/WrongType
    //   90: dup
    //   91: aload_1
    //   92: ldc 118
    //   94: iconst_2
    //   95: aload_3
    //   96: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   99: athrow
    //   100: astore_1
    //   101: new 432	gnu/mapping/WrongType
    //   104: dup
    //   105: aload_1
    //   106: ldc 99
    //   108: iconst_1
    //   109: aload_2
    //   110: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: astore_1
    //   115: new 432	gnu/mapping/WrongType
    //   118: dup
    //   119: aload_1
    //   120: ldc 99
    //   122: iconst_2
    //   123: aload_3
    //   124: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	swing
    //   0	128	1	paramModuleMethod	ModuleMethod
    //   0	128	2	paramObject1	Object
    //   0	128	3	paramObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	72	java/lang/ClassCastException
    //   45	50	86	java/lang/ClassCastException
    //   56	61	100	java/lang/ClassCastException
    //   61	66	114	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 510	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+64->68, 5:+71->75, 6:+64->68, 7:+64->68, 8:+64->68, 9:+64->68, 10:+64->68, 11:+64->68, 12:+76->80, 13:+81->85, 14:+86->90, 15:+91->95, 16:+137->141
    //   68: aload_0
    //   69: aload_1
    //   70: aload_2
    //   71: invokespecial 546	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: areturn
    //   75: aload_2
    //   76: invokestatic 548	gnu/kawa/slib/swing:withComposite	([Ljava/lang/Object;)Ljava/lang/Object;
    //   79: areturn
    //   80: aload_2
    //   81: invokestatic 550	gnu/kawa/slib/swing:menubar	([Ljava/lang/Object;)Ljavax/swing/JMenuBar;
    //   84: areturn
    //   85: aload_2
    //   86: invokestatic 552	gnu/kawa/slib/swing:menu	([Ljava/lang/Object;)Ljavax/swing/JMenu;
    //   89: areturn
    //   90: aload_2
    //   91: invokestatic 554	gnu/kawa/slib/swing:menuitem$V	([Ljava/lang/Object;)Ljavax/swing/JMenuItem;
    //   94: areturn
    //   95: aload_2
    //   96: iconst_0
    //   97: aaload
    //   98: astore_1
    //   99: aload_1
    //   100: checkcast 424	gnu/math/Complex
    //   103: astore 4
    //   105: aload_2
    //   106: arraylength
    //   107: iconst_1
    //   108: isub
    //   109: istore_3
    //   110: iload_3
    //   111: anewarray 363	java/lang/Object
    //   114: astore_1
    //   115: iload_3
    //   116: iconst_1
    //   117: isub
    //   118: istore_3
    //   119: iload_3
    //   120: ifge +10 -> 130
    //   123: aload 4
    //   125: aload_1
    //   126: invokestatic 556	gnu/kawa/slib/swing:polygon	(Lgnu/math/Complex;[Ljava/lang/Object;)Ljava/lang/Object;
    //   129: areturn
    //   130: aload_1
    //   131: iload_3
    //   132: aload_2
    //   133: iload_3
    //   134: iconst_1
    //   135: iadd
    //   136: aaload
    //   137: aastore
    //   138: goto -23 -> 115
    //   141: aload_2
    //   142: iconst_0
    //   143: aaload
    //   144: astore_1
    //   145: aload_2
    //   146: arraylength
    //   147: iconst_1
    //   148: isub
    //   149: istore_3
    //   150: iload_3
    //   151: anewarray 363	java/lang/Object
    //   154: astore 4
    //   156: iload_3
    //   157: iconst_1
    //   158: isub
    //   159: istore_3
    //   160: iload_3
    //   161: ifge +10 -> 171
    //   164: aload_1
    //   165: aload 4
    //   167: invokestatic 558	gnu/kawa/slib/swing:scroll$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljavax/swing/JScrollPane;
    //   170: areturn
    //   171: aload 4
    //   173: iload_3
    //   174: aload_2
    //   175: iload_3
    //   176: iconst_1
    //   177: iadd
    //   178: aaload
    //   179: aastore
    //   180: goto -24 -> 156
    //   183: astore_2
    //   184: new 432	gnu/mapping/WrongType
    //   187: dup
    //   188: aload_2
    //   189: ldc 86
    //   191: iconst_1
    //   192: aload_1
    //   193: invokespecial 437	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	swing
    //   0	197	1	paramModuleMethod	ModuleMethod
    //   0	197	2	paramArrayOfObject	Object[]
    //   109	69	3	i	int
    //   103	69	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	105	183	java/lang/ClassCastException
  }
  
  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 7: 
    default: 
      return super.match0(paramModuleMethod, paramCallContext);
    case 8: 
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
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 10: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6: 
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3: 
      if (!(paramObject instanceof Shape)) {
        return -786431;
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2: 
      if (!(paramObject instanceof Shape)) {
        return -786431;
      }
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
    int i = -786431;
    switch (paramModuleMethod.selector)
    {
    default: 
      i = super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
    do
    {
      do
      {
        return i;
      } while (!(paramObject1 instanceof AffineTransform));
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Paintable)) {
        return -786430;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    } while (!(paramObject1 instanceof Color));
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Paintable)) {
      return -786430;
    }
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    default: 
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 16: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 15: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 14: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 13: 
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 12: 
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
    color$Mnred = Color.red;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\slib\swing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */