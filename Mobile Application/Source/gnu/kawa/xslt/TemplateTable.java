package gnu.kawa.xslt;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class TemplateTable
{
  static final TemplateTable nullModeTable = new TemplateTable(XSLT.nullMode);
  TemplateEntry entries;
  Symbol name;
  
  public TemplateTable(Symbol paramSymbol)
  {
    this.name = paramSymbol;
  }
  
  static TemplateTable getTemplateTable(Symbol paramSymbol)
  {
    if (paramSymbol == XSLT.nullMode) {
      return nullModeTable;
    }
    return null;
  }
  
  public void enter(String paramString, double paramDouble, Procedure paramProcedure)
  {
    TemplateEntry localTemplateEntry = new TemplateEntry();
    localTemplateEntry.procedure = paramProcedure;
    localTemplateEntry.priority = paramDouble;
    localTemplateEntry.pattern = paramString;
    localTemplateEntry.next = this.entries;
    this.entries = localTemplateEntry;
  }
  
  public Procedure find(String paramString)
  {
    for (TemplateEntry localTemplateEntry = this.entries; localTemplateEntry != null; localTemplateEntry = localTemplateEntry.next) {
      if (localTemplateEntry.pattern.equals(paramString)) {
        return localTemplateEntry.procedure;
      }
    }
    return null;
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\gnu\kawa\xslt\TemplateTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */