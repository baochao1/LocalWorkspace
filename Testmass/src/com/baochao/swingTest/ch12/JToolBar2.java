import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JToolBar2 extends JFrame{

	JTextArea theArea = null;
	ToolBarAction pushAction = null;

	public JToolBar2(){
	  
	  super("JToolBar2");
	  theArea = new JTextArea();
	  theArea.setEditable(false);
	  getContentPane().add(new JScrollPane(theArea));
	  JMenuBar MBar = new JMenuBar();
	  MBar.setOpaque(true);
	  
	  pushAction = new ToolBarAction("按我",null);
	  JMenu mfile = buildFileMenu();
	  JToolBar theBar = buildToolBar();
      this.getContentPane().add(theBar,BorderLayout.NORTH);
          
	  MBar.add(mfile);  
	  setJMenuBar(MBar);
	}//end of JToolBar2()

	public JMenu buildFileMenu() {
  	
	  JMenu thefile = new JMenu("File");
	  thefile.setMnemonic('F');
	  thefile.add(pushAction);

	  return thefile;
	}//end of buildFileMenu()
	
	public JToolBar buildToolBar() {
	  
	  JToolBar toolBar = new JToolBar();
      toolBar.setFloatable(true);
	  toolBar.add(pushAction);
	
	  return toolBar;
	}//end of buildToolBar()
	
	public static void main(String[] args){

	  JFrame F = new JToolBar2();
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
          theArea.append("不管用哪种方式执行\"按我\"，都会出现这句！！"+"\n");
        }catch(Exception ex){}
      }
    }//end of inner class ToolBarAction
}//end of class JToolBar2

