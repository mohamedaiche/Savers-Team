package gnu.commonlisp.lang;

import gnu.kawa.lispexpr.ReadTable;

class Lisp2ReadTable
  extends ReadTable
{
  protected Object makeSymbol(String paramString)
  {
    return Lisp2.asSymbol(paramString.intern());
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\commonlisp\lang\Lisp2ReadTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */