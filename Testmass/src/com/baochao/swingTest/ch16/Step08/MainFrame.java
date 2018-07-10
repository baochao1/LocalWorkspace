import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class MainFrame extends JFrame{

  JDesktopPane desktop;
  JMenuBar     MBar;
  JToolBar     toolBar;

  static final String AboutMsg = "A Java Simple Editor Example Ver 1.0\n \nAn application written to show off the functions of Editor. \n \n Written By Ming-Hsiang Fan and Chih-Yang Lin. \n \nCopyright (c) 2001 by Ming-Hsiang Fan and Chih-Yang Lin. All Rights Reserved.";
  static final String ComboStr[] = {"Times New Roman","Dialog","細明體","新細明體","標楷體"};
  static final String ComboStr2[] = {"8","10","12","14","16","18","20","24","26","30","36","48","72"};  
	
  public MainFrame(){

    super("MainFrame-Look and Feel");
    setBounds(100,100,600,400);  // --- setBounds(x座標,y座標,寬,高)
    buildContent();
    buildMenu();
    buildToolBar();

    //this.getContentPane().add(textPane,BorderLayout.CENTER);
    this.getContentPane().add(toolBar,BorderLayout.NORTH);
    
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    	  quit(); 
        }
    }); //end of addWindowListener
  } //end of main

//~~~ Layer 1 Method ~~~
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
    JMenu mdemo = buildDemoMenu();     
    JMenu mhelp = buildHelpMenu();

    //設定Hot Key Alt+'?'    
    mfile.setMnemonic('F');
    medit.setMnemonic('E');
    mfont.setMnemonic('O');    
    mdemo.setMnemonic('D');
    mhelp.setMnemonic('H');
    
    MBar.add(mfile); //將 File 選項加到MenuBar中
    MBar.add(medit); //將 Edit 選項加到MenuBar中
    MBar.add(mfont); //將 Font 選項加到MenuBar中
    MBar.add(mdemo); //將 Demo 選項加到MenuBar中    
    MBar.add(mhelp); //將 Help 選項加到MenuBar中
    
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
//~~~
//### Layer 2 method ###
  public JMenu buildFileMenu() {
  	
    JMenu file = new JMenu("File");
    JMenuItem newf = new JMenuItem("New");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close= new JMenuItem("Close");    
    JMenuItem quit = new JMenuItem("Exit");
 
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

    close.setEnabled(false);
          
    newf.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e) {
			   NewFrame();
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

  public void NewFrame() {
    JInternalFrame JInew = new NewFrame();
    desktop.add(JInew, new Integer(1));
    try { 
         JInew.setVisible(true);
	 JInew.setSelected(true); 
    }catch (java.beans.PropertyVetoException e2) {}  	
  }//end of NewFrame

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


  protected JMenu buildDemoMenu() {
  	
    JMenu demo = new JMenu("Demo");
    JMenuItem silder   = new JMenuItem("Silder");
    JMenuItem tree     = new JMenuItem("Tree Structure");
    JMenuItem table    = new JMenuItem("Table Structure");
    JMenuItem password = new JMenuItem("Password");
 
    //提示用
    silder.setMnemonic('S');
    tree.setMnemonic('T');
    table.setMnemonic('A');
    password.setMnemonic('P');
    //設定Hot Key, Ctrl+'?'
    silder.setAccelerator( KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK,false) );    
    tree.setAccelerator( KeyStroke.getKeyStroke('T',java.awt.Event.CTRL_MASK,false) );
    table.setAccelerator( KeyStroke.getKeyStroke('A',java.awt.Event.CTRL_MASK,false) );
    password.setAccelerator( KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK,false) );
          
    silder.addActionListener(new ActionListener() {
	                     public void actionPerformed(ActionEvent e) {
			     DemoSilder();
	                     }});

    tree.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e) {
			   DemoTree();
	                   }});
    table.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
			    DemoTable();
	                    }});
    password.addActionListener(new ActionListener() {
	                       public void actionPerformed(ActionEvent e) {
			       DemoPassword();
	                       }});

    demo.add(silder);	  	
    demo.add(tree);
    demo.add(table); 
    demo.add(password);   
    return demo;
  }//end of buildDemoMenu()

  public void DemoSilder() {
    DemoSilder silder = new DemoSilder(this);
    silder.show();
  }//end of DemoSilder()

  public void DemoTree() {

    JInternalFrame JItree = new DemoTree();
    desktop.add(JItree, new Integer(3));
    try { 
         JItree.setVisible(true);
	 JItree.setSelected(true); 
    }catch (java.beans.PropertyVetoException e2) {}  	
  }//end of DemoTree()

  public void DemoTable() {

    JInternalFrame JItable = new DemoTable();
    desktop.add(JItable, new Integer(4));
    try { 
         JItable.setVisible(true);
	 JItable.setSelected(true); 
    }catch (java.beans.PropertyVetoException e2) {}  	
  }//end of DemoTable()

  public void DemoPassword() {
    DemoPassword password = new DemoPassword(this);
    password.show();
  }//end of DemoPassword()


  protected JMenu buildHelpMenu() {
  	
    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About this Program");
    JMenuItem openHelp = new JMenuItem("Open Help Window");

    about.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                      showAboutBox();
	                    }});

    openHelp.addActionListener(new ActionListener() {
	                       public void actionPerformed(ActionEvent e) {
				   openHelpWindow();
			       }});
    help.add(about);
    help.add(openHelp);
    return help;
  }//end of buildHelpMenu()
  
  public void showAboutBox() {
    JOptionPane.showMessageDialog(this, AboutMsg);
  }

  public void openHelpWindow() {
    JInternalFrame help = new HelpFrame();
    desktop.add(help, new Integer(2));
    try { 
      help.setVisible(true);
      help.setSelected(true); 
    }catch (java.beans.PropertyVetoException e2) {}
  }//end of bulidHelpMenu()  

//###  
}//end of class MainFrame
