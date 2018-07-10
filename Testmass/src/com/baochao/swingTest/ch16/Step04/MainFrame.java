import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainFrame extends JFrame{

  JDesktopPane desktop;
  JMenuBar     MBar;
  JToolBar     toolBar;  
	
  public MainFrame(){

    super("MainFrame-Look and Feel");
    setBounds(100,100,600,400);
    buildContent();
    buildMenu();
    buildToolBar();

    this.getContentPane().add(toolBar,BorderLayout.NORTH);
     
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    	  quit(); 
        }
    });//end of addWindowListener
  }//end of main

  protected void buildContent() {
    desktop = new JDesktopPane();
    getContentPane().add(desktop);
  }//end of buildContent()

  protected void buildMenu(){
    MBar = new JMenuBar();
    MBar.setOpaque(true);
    JMenu mfile = buildFileMenu();

    //設定Hot Key Alt+'?'    
    mfile.setMnemonic('F');
    
    MBar.add(mfile);
    setJMenuBar(MBar);    
  }//end of bulidMenu()

  protected void buildToolBar(){
    toolBar = new JToolBar();
    toolBar.setFloatable(true);
    
    ToolBarAction tba_new   = new ToolBarAction("new",new ImageIcon("icons/new.jpg"));
    ToolBarAction tba_open  = new ToolBarAction("open",new ImageIcon("icons/open.jpg"));
    ToolBarAction tba_close = new ToolBarAction("close",new ImageIcon("icons/close.jpg"));
    ToolBarAction tba_save  = new ToolBarAction("save",new ImageIcon("icons/save.jpg"));
    
    JButton JB;
    JB = toolBar.add(tba_new);
    JB.setActionCommand("TB_NEW");
    JB.setToolTipText((String)tba_new.getValue(Action.NAME));
    JB = toolBar.add(tba_open);
    JB.setActionCommand("TB_OPEN");
    JB.setToolTipText((String)tba_open.getValue(Action.NAME));
    JB = toolBar.add(tba_close);
    JB.setActionCommand("TB_CLOSE");
    JB.setToolTipText((String)tba_close.getValue(Action.NAME));
    
    toolBar.addSeparator();
    
    JB = toolBar.add(tba_save);
    JB.setActionCommand("TB_SAVE");
    JB.setToolTipText((String)tba_save.getValue(Action.NAME));
    tba_save.setEnabled(false);
  }//end of buildToolBar()

  public void quit(){
    System.exit(0); 
  }//end of quit()

  public JMenu buildFileMenu() {
  	
    JMenu file = new JMenu("File");
    JMenuItem newf = new JMenuItem("New");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close= new JMenuItem("Close");    
    JMenuItem quit = new JMenuItem("Exit");

    close.setEnabled(false);
 
    //提示用
    newf.setMnemonic('N');
    open.setMnemonic('O');
    close.setMnemonic('C');   
    quit.setMnemonic('X');
    //設定Hot Key, Ctrl+'?'
    newf.setAccelerator( KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK,false) );    
    open.setAccelerator( KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK,false) );
    close.setAccelerator( KeyStroke.getKeyStroke('C',java.awt.Event.CTRL_MASK,false) );
    quit.setAccelerator( KeyStroke.getKeyStroke('X',java.awt.Event.CTRL_MASK,false) );    

          
    newf.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e) {
			   makeNewFrame();
	                   }});

    open.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e) {
			   openDocument();
	                   }});

    quit.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e) {
			   quit();
	  	           }});
    file.add(newf);	  	
    file.add(open);
    file.add(close);        
    file.addSeparator();
    file.add(quit);
    return file;
  }//end of buildFileMenu()

  public void makeNewFrame() {
    JInternalFrame JInew = new NewFrame();
    desktop.add(JInew, new Integer(1));
    try { 
         JInew.setVisible(true);
	 JInew.setSelected(true); 
    }catch (java.beans.PropertyVetoException e2) {}  	
  }//end of makeNewFrame

  public void openDocument() {
    JFileChooser chooser = new JFileChooser();
    chooser.showOpenDialog(this);
  }//end of openFrame()
}//end of class MainFrame
