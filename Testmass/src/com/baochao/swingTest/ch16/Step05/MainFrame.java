import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainFrame extends JFrame{

  JDesktopPane desktop;
  JMenuBar     MBar;
  JToolBar     toolBar;

  static final String ComboStr[] = {"Times New Roman","Dialog","宋体","黑体","楷体"};
  static final String ComboStr2[] = {"8","10","12","14","16","18","20","24","26","30","36","48","72"};  
	
  public MainFrame(){

    super("MainFrame-Look and Feel");
    setBounds(100,100,600,400);  // --- setBounds(x坐标,y坐标,宽,高)
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
    JMenu medit = buildEditMenu();
    JMenu mfont = buildFontMenu();
    //设定Hot Key Alt+'?'    
    mfile.setMnemonic('F');
    medit.setMnemonic('E');
    mfont.setMnemonic('O');    
    
    MBar.add(mfile); //将 File 选项加到MenuBar中
    MBar.add(medit); //将 Edit 选项加到MenuBar中
    MBar.add(mfont); //将 Font 选项加到MenuBar中
    
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
    
    toolBar.addSeparator();
    
    ToolBarAction tba_B  = new ToolBarAction("bold",new ImageIcon("icons/_bold.gif"));
    ToolBarAction tba_I  = new ToolBarAction("italic",new ImageIcon("icons/_italic.gif"));
    ToolBarAction tba_U  = new ToolBarAction("underline",new ImageIcon("icons/_underline.gif")); 
    JB = toolBar.add(tba_B);
    JB.setActionCommand("TB_Bold");
    JB.setToolTipText((String)tba_B.getValue(Action.NAME));
    JB = toolBar.add(tba_I);
    JB.setActionCommand("TB_Italic");
    JB.setToolTipText((String)tba_I.getValue(Action.NAME));    
    JB = toolBar.add(tba_U);
    JB.setActionCommand("TB_Underline");
    JB.setToolTipText((String)tba_U.getValue(Action.NAME));
   
    toolBar.addSeparator();    
    JLabel JLfont = new JLabel("Font Type");
    toolBar.add(JLfont);
    toolBar.addSeparator();
    JComboBox jcb = new JComboBox(ComboStr);
    toolBar.add(jcb);
    toolBar.addSeparator();
    jcb = new JComboBox(ComboStr2);
    toolBar.add(jcb);
    toolBar.addSeparator();    
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
 
    //抟儃僲
    newf.setMnemonic('N');
    open.setMnemonic('O');
    close.setMnemonic('C');   
    quit.setMnemonic('X');
    //设定Hot Key, Ctrl+'?'
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
  
  protected JMenu buildEditMenu() {
    JMenu edit = new JMenu("Edit");
    JMenuItem undo = new JMenuItem("Undo");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem prefs = new JMenuItem("Preferences...");

    undo.setEnabled(false);
    copy.setEnabled(false);
    cut.setEnabled(false);
    paste.setEnabled(false);
    prefs.setEnabled(false);
    
    edit.add(undo);
    edit.addSeparator();
    edit.add(cut);
    edit.add(copy);
    edit.add(paste);
    edit.addSeparator();
    edit.add(prefs);
    return edit;
  }//end of buildEditMenu()

  protected JMenu buildFontMenu() {
    JMenu mfont = new JMenu("Font");
    JCheckBoxMenuItem bold      = new JCheckBoxMenuItem("Bold");
    JCheckBoxMenuItem italic    = new JCheckBoxMenuItem("Italic");
    JCheckBoxMenuItem underline = new JCheckBoxMenuItem("UnderLine");

    JRadioButtonMenuItem aL = new JRadioButtonMenuItem("Align Left");
    JRadioButtonMenuItem aC = new JRadioButtonMenuItem("Align Center");
    JRadioButtonMenuItem aR = new JRadioButtonMenuItem("Align Right");
    JRadioButtonMenuItem aJ = new JRadioButtonMenuItem("Justify");

    aJ.setEnabled(false);
    
    ButtonGroup RBGroup = new ButtonGroup();
    RBGroup.add(aL);
    RBGroup.add(aC);
    RBGroup.add(aR);
    RBGroup.add(aJ);
    
    mfont.add(bold);
    mfont.add(italic);
    mfont.add(underline);
    mfont.addSeparator();
    mfont.add(aL);
    mfont.add(aC);
    mfont.add(aR);
    mfont.add(aJ);            

    return mfont;
  }//end of buildFontMenu()
}//end of class MainFrame


