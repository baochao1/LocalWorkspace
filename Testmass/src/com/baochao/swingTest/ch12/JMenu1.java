import javax.swing.*;
import java.awt.event.*;

public class JMenu1 extends JFrame{

	JTextArea theArea = null;

	public JMenu1(){
	  
	  super("JMenu1");
	  theArea = new JTextArea();
	  theArea.setEditable(false);
	  getContentPane().add(new JScrollPane(theArea));
	  JMenuBar MBar = new JMenuBar();
	  
	  JMenu mfile = buildFileMenu();

	  MBar.add(mfile);  
	  setJMenuBar(MBar);
	}//end of JMenu1()

	public JMenu buildFileMenu() {
  	
	  JMenu thefile = new JMenu("File");
	  thefile.setIcon(new ImageIcon("icons/file.gif"));

	  return thefile;
	}//end of buildFileMenu()

	
	public static void main(String[] args){

	  JFrame F = new JMenu1();
	  F.setSize(400,200);
	  F.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
	      System.exit(0); 
	    }
	  });//end of addWindowListener
	  F.setVisible(true); 
	} // end of main
}//end of class JMenu1