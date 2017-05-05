package gnu.xquery.lang;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter
  extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    paramObject = (InPort)paramObject;
    int i = ((InPort)paramObject).getLineNumber() + 1;
    char c2 = ((InPort)paramObject).readState;
    char c1 = c2;
    if (c2 == '\n') {
      c1 = ' ';
    }
    if (c1 == '<') {
      return "<!--" + i + "-->";
    }
    if (c1 == ':') {
      return "-(:" + i + "c:) ";
    }
    return "(: " + i + c1 + ":) ";
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\xquery\lang\Prompter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */