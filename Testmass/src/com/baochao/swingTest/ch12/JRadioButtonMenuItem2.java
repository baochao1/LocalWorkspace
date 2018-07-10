import javax.swing.*;
import java.awt.event.*;

public class JRadioButtonMenuItem2 extends JFrame implements ActionListener{

	JTextArea theArea = null;

	public JRadioButtonMenuItem2(){
	  
	  super("JRadioButtonMenuItem2");
	  theArea = new JTextArea();
	  theArea.setEditable(false);
	  getContentPane().add(new JScrollPane(theArea));
	  JMenuBar MBar = new JMenuBar();
	  MBar.setOpaque(true);
	  
	  JMenu mfile = buildFileMenu();
	  JMenu mstyle = buildStyleMenu();

	  MBar.add(mfile);
	  MBar.add(mstyle);
	  setJMenuBar(MBar);
	}//end of JRadioButtonMenuItem2()

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

	  newf.addActionListener(this);
	  open.addActionListener(this);
	  close.addActionListener(this);
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

	public JMenu buildStyleMenu() {
		
	  JMenu style = new JMenu("Style");
	  style.setMnemonic('S');

	  JRadioButtonMenuItem Left    = new JRadioButtonMenuItem("Left",new ImageIcon("icons/left24.gif"));
	  JRadioButtonMenuItem Center  = new JRadioButtonMenuItem("Center",new ImageIcon("icons/center24.gif"));
	  JRadioButtonMenuItem Right   = new JRadioButtonMenuItem("Right",new ImageIcon("icons/right24.gif"));    
	  JRadioButtonMenuItem Justify = new JRadioButtonMenuItem("Justify",new ImageIcon("icons/justify24.gif"));

	  Left.setMnemonic('L');
	  Center.setMnemonic('E');
	  Right.setMnemonic('R');
	  Justify.setMnemonic('J');
	  
	  Left.setAccelerator( KeyStroke.getKeyStroke('L', java.awt.Event.SHIFT_MASK, false) );
	  Center.setAccelerator( KeyStroke.getKeyStroke('E', java.awt.Event.SHIFT_MASK, false) );
	  Right.setAccelerator( KeyStroke.getKeyStroke('R', java.awt.Event.SHIFT_MASK, false) );
	  Justify.setAccelerator( KeyStroke.getKeyStroke('J', java.awt.Event.SHIFT_MASK, false) );

	  Left.addActionListener(this);
	  Center.addActionListener(this);
	  Right.addActionListener(this);
	  Justify.addActionListener(this);

	  style.add(Left);	  	
	  style.add(Center);
	  style.add(Right);
	  style.add(Justify);

	  ButtonGroup bg = new ButtonGroup();
	  bg.add(Left);
	  bg.add(Center);
	  bg.add(Right);
	  bg.add(Justify);

	  return style;
	}//end of buildStyleMenu()
	
	public void actionPerformed(ActionEvent ae){ 
	  try{
	    theArea.append("* action '"+ae.getActionCommand()+"' performed. *\n");
	  }catch(Exception e){
	    System.out.println("actionPerformed Exception:"+e);
	  }
	}	
	public static void main(String[] args){

	  JFrame F = new JRadioButtonMenuItem2();
	  F.setSize(400,200);
	  F.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
	      System.exit(0); 
	    }
	  });//end of addWindowListener
	  F.setVisible(true); 
	} // end of main
}//end of class JRadioButtonMenuItem2