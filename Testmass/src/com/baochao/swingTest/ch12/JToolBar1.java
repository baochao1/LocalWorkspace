import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JToolBar1 extends JFrame{

	JTextArea theArea = null;
	static final String ComboStr[] = {"Times New Roman","Dialog","ËÎÌå","ºÚÌå","¿¬Ìå"};

	public JToolBar1(){
	  
	  super("JToolBar1");
	  theArea = new JTextArea();
	  theArea.setEditable(false);
	  getContentPane().add(new JScrollPane(theArea));
	  JMenuBar MBar = new JMenuBar();
	  MBar.setOpaque(true);
	  
	  JMenu mfile = buildFileMenu();
	  JToolBar theBar = buildToolBar();
      this.getContentPane().add(theBar,BorderLayout.NORTH);
          
	  MBar.add(mfile);  
	  setJMenuBar(MBar);
	}//end of JToolBar1()

	public JMenu buildFileMenu() {
  	
	  JMenu thefile = new JMenu("File");
	  thefile.setMnemonic('F');

	  JMenuItem newf = new JMenuItem("New",new ImageIcon("icons/new24.gif"));
	  JMenuItem open = new JMenuItem("Open",new ImageIcon("icons/open24.gif"));
	  JMenuItem close= new JMenuItem("Close",new ImageIcon("icons/close24.gif"));    
	  JMenuItem quit = new JMenuItem("Exit",new ImageIcon("icons/exit24.gif"));

	  newf.setMnemonic('N');
	  open.setMnemonic('O');
	  close.setMnemonic('L');
	  quit.setMnemonic('X');
	  
	  newf.setAccelerator( KeyStroke.getKeyStroke('N', java.awt.Event.CTRL_MASK, false) );
	  open.setAccelerator( KeyStroke.getKeyStroke('O', java.awt.Event.CTRL_MASK, false) );
	  close.setAccelerator( KeyStroke.getKeyStroke('L', java.awt.Event.CTRL_MASK, false) );
	  quit.setAccelerator( KeyStroke.getKeyStroke('X', java.awt.Event.CTRL_MASK, false) );

	  newf.addActionListener(new ActionListener() {
	                   	     public void actionPerformed(ActionEvent e) {
			   	               theArea.append("- MenuItem New Performed -\n");
	                   	     }});

	  open.addActionListener(new ActionListener() {
	                   	     public void actionPerformed(ActionEvent e) {
			   	               theArea.append("- MenuItem Open Performed -\n");
	                   	     }});
	                   	 
	  close.addActionListener(new ActionListener() {
	                    	  public void actionPerformed(ActionEvent e) {
			   	                theArea.append("- MenuItem Close Performed -\n");
	                   	      }});

	  quit.addActionListener(new ActionListener() {
	                   	     public void actionPerformed(ActionEvent e) {
			   	               System.exit(0);
	  	           	         }});

	  thefile.add(newf);	  	
	  thefile.add(open);
	  thefile.add(close);        
	  thefile.addSeparator();
	  thefile.add(quit);

	  return thefile;
	}//end of buildFileMenu()
	
	public JToolBar buildToolBar() {
	  
	  JToolBar toolBar = new JToolBar();
      toolBar.setFloatable(true);
    
	  ToolBarAction tba_new   = new ToolBarAction("new",new ImageIcon("icons/new24.gif"));
	  ToolBarAction tba_open  = new ToolBarAction("open",new ImageIcon("icons/open24.gif"));
	  ToolBarAction tba_close = new ToolBarAction("close",new ImageIcon("icons/close24.gif"));
    
	  JButton JB;
	  JB = toolBar.add(tba_new);
	  JB.setActionCommand("#TooBar_NEW performed!");
	  JB = toolBar.add(tba_open);
	  JB.setActionCommand("#ToolBar_OPEN performed!");
	  JB = toolBar.add(tba_close);
	  JB.setActionCommand("#ToolBar_CLOSE performed!");
    
	  toolBar.addSeparator();
        
	  ToolBarAction tba_B  = new ToolBarAction("bold",new ImageIcon("icons/bold24.gif"));
	  ToolBarAction tba_I  = new ToolBarAction("italic",new ImageIcon("icons/italic24.gif"));
	  ToolBarAction tba_U  = new ToolBarAction("underline",new ImageIcon("icons/underline24.gif")); 
	  JB = toolBar.add(tba_B);
	  JB.setActionCommand("#ToolBar_Bold performed!");
	  JB = toolBar.add(tba_I);
	  JB.setActionCommand("#ToolBar_Italic performed!");
	  JB = toolBar.add(tba_U);
	  JB.setActionCommand("#ToolBar_Underline performed!");
  
	  toolBar.addSeparator();    
	  JLabel JLfont = new JLabel("Font Type");
	  toolBar.add(JLfont);
	  toolBar.addSeparator();
	  JComboBox jcb = new JComboBox(ComboStr);
	  jcb.addActionListener(new ActionListener() {
	                    	  public void actionPerformed(ActionEvent e) {
			   	                theArea.append("*Combobox "+((JComboBox)e.getSource()).getSelectedItem()+" performed!\n");
	                   	    }});
	  toolBar.add(jcb);
	
	  return toolBar;
	}//end of buildToolBar()
	
	public static void main(String[] args){

	  JFrame F = new JToolBar1();
	  F.setSize(430,200);
	  F.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
	      System.exit(0); 
	    }
	  });//end of addWindowListener
	  F.setVisible(true); 
	} // end of main
	
	class ToolBarAction extends AbstractAction{

      public ToolBarAction(String name,Icon icon){
        super(name,icon);
      }

      public void actionPerformed(ActionEvent e){
    
        try{
          theArea.append(e.getActionCommand()+"\n");
        }catch(Exception ex){}
      }
    }//end of inner class ToolBarAction
}//end of class JToolBar1