package gnu.kawa.xml;

import gnu.mapping.MethodProc;

public class MakeCDATA
  extends MethodProc
{
  public static final MakeCDATA makeCDATA = new MakeCDATA();
  
  /* Error */
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 23	gnu/mapping/CallContext:consumer	Lgnu/lists/Consumer;
    //   4: astore_3
    //   5: aload_1
    //   6: invokestatic 29	gnu/kawa/xml/NodeConstructor:pushNodeContext	(Lgnu/mapping/CallContext;)Lgnu/xml/XMLFilter;
    //   9: astore 4
    //   11: new 31	java/lang/StringBuffer
    //   14: dup
    //   15: invokespecial 32	java/lang/StringBuffer:<init>	()V
    //   18: astore 5
    //   20: getstatic 38	gnu/mapping/Location:UNBOUND	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: aload 6
    //   28: invokevirtual 42	gnu/mapping/CallContext:getNextArg	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 7
    //   33: aload 7
    //   35: aload 6
    //   37: if_acmpne +41 -> 78
    //   40: aload 5
    //   42: invokevirtual 46	java/lang/StringBuffer:length	()I
    //   45: istore_2
    //   46: iload_2
    //   47: newarray <illegal type>
    //   49: astore 6
    //   51: aload 5
    //   53: iconst_0
    //   54: iload_2
    //   55: aload 6
    //   57: iconst_0
    //   58: invokevirtual 50	java/lang/StringBuffer:getChars	(II[CI)V
    //   61: aload 4
    //   63: aload 6
    //   65: iconst_0
    //   66: iload_2
    //   67: invokeinterface 56 4 0
    //   72: aload_3
    //   73: aload_1
    //   74: invokestatic 60	gnu/kawa/xml/NodeConstructor:popNodeContext	(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V
    //   77: return
    //   78: aload 7
    //   80: aload 5
    //   82: invokestatic 66	gnu/xml/TextUtils:stringValue	(Ljava/lang/Object;Ljava/lang/StringBuffer;)V
    //   85: goto -60 -> 25
    //   88: astore 4
    //   90: aload_3
    //   91: aload_1
    //   92: invokestatic 60	gnu/kawa/xml/NodeConstructor:popNodeContext	(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V
    //   95: aload 4
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	MakeCDATA
    //   0	98	1	paramCallContext	gnu.mapping.CallContext
    //   45	22	2	i	int
    //   4	87	3	localConsumer	gnu.lists.Consumer
    //   9	53	4	localXMLFilter	gnu.xml.XMLFilter
    //   88	8	4	localObject1	Object
    //   18	63	5	localStringBuffer	StringBuffer
    //   23	41	6	localObject2	Object
    //   31	48	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	25	88	finally
    //   25	33	88	finally
    //   40	72	88	finally
    //   78	85	88	finally
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\xml\MakeCDATA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */