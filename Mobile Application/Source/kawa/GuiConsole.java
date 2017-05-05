package kawa;

import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GuiConsole
  extends JFrame
  implements ActionListener, ReplDocument.DocumentCloseListener
{
  private static String CLOSE = "Close";
  private static String EXIT = "Exit";
  private static String NEW = "New";
  private static String NEW_SHARED = "New (Shared)";
  private static String PURGE_MESSAGE = "Purge Buffer";
  static int window_number = 0;
  ReplDocument document;
  ReplPane pane;
  
  public GuiConsole()
  {
    this(Language.getDefaultLanguage(), Environment.getCurrent(), false);
  }
  
  public GuiConsole(Language paramLanguage, Environment paramEnvironment, boolean paramBoolean)
  {
    super("Kawa");
    repl.getLanguage();
    init(new ReplDocument(paramLanguage, paramEnvironment, paramBoolean));
  }
  
  public GuiConsole(ReplDocument paramReplDocument)
  {
    super("Kawa");
    init(paramReplDocument);
  }
  
  public static void main(String[] paramArrayOfString)
  {
    repl.noConsole = false;
    int i = repl.processArgs(paramArrayOfString, 0, paramArrayOfString.length);
    repl.getLanguage();
    repl.setArgs(paramArrayOfString, i);
    repl.checkInitFile();
    new GuiConsole();
  }
  
  private void setupMenus()
  {
    Object localObject = new WindowAdapter()
    {
      public void windowClosing(WindowEvent paramAnonymousWindowEvent)
      {
        GuiConsole.this.close();
      }
    };
    MenuBar localMenuBar = new MenuBar();
    Menu localMenu2 = new Menu("File");
    Menu localMenu1 = new Menu("Utilities");
    localMenuBar.add(localMenu2);
    localMenuBar.add(localMenu1);
    MenuItem localMenuItem = new MenuItem(NEW);
    localMenuItem.addActionListener(this);
    localMenu2.add(localMenuItem);
    localMenuItem = new MenuItem(NEW_SHARED);
    localMenuItem.addActionListener(this);
    localMenu2.add(localMenuItem);
    localMenuItem = new MenuItem(CLOSE);
    localMenuItem.addActionListener(this);
    localMenu2.add(localMenuItem);
    localMenuItem = new MenuItem(EXIT);
    localMenuItem.addActionListener(this);
    addWindowListener((WindowListener)localObject);
    localMenu2.add(localMenuItem);
    localObject = new MenuItem(PURGE_MESSAGE);
    ((MenuItem)localObject).addActionListener(this);
    localMenu1.add((MenuItem)localObject);
    setMenuBar(localMenuBar);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    paramActionEvent = paramActionEvent.getActionCommand();
    if (paramActionEvent.equals(NEW))
    {
      new GuiConsole(this.document.language, Environment.getGlobal(), false);
      return;
    }
    if (paramActionEvent.equals(NEW_SHARED))
    {
      new GuiConsole(this.document.language, this.document.environment, true);
      return;
    }
    if (paramActionEvent.equals(EXIT))
    {
      System.exit(0);
      return;
    }
    if (paramActionEvent.equals(CLOSE))
    {
      close();
      return;
    }
    if (paramActionEvent.equals(PURGE_MESSAGE))
    {
      this.pane.document.deleteOldText();
      return;
    }
    OutPort.outDefault().println("Unknown menu action: " + paramActionEvent);
  }
  
  void close()
  {
    this.document.removeDocumentCloseListener(this);
    dispose();
  }
  
  public void closed(ReplDocument paramReplDocument)
  {
    close();
  }
  
  void init(ReplDocument paramReplDocument)
  {
    this.document = paramReplDocument;
    this.document.addDocumentCloseListener(this);
    this.pane = new ReplPane(this.document);
    window_number += 1;
    setLayout(new BorderLayout(0, 0));
    add("Center", new JScrollPane(this.pane));
    setupMenus();
    setLocation(window_number * 100, window_number * 50);
    setSize(700, 500);
    setVisible(true);
  }
}


/* Location:              C:\Users\Mohamed\Downloads\dex2jar-2.0\dex2jar-2.0\classes-dex2jar.jar!\kawa\GuiConsole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */