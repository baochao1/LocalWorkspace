import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame{

  JDesktopPane desktop;
	
  public MainFrame(){

    super("MainFrame-Look And Feel");
    setBounds(100,100,600,400);  
    buildContent();
    
    this.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    	  quit(); 
        }
    }); //end of addWindowListener
  } //end of MainFrame()

  protected void buildContent() {
    desktop = new JDesktopPane();
    getContentPane().add(desktop);
  }//end of buildContent()
  
  public void quit(){
    System.exit(0); 
  }//end of quit()
}//end of class MainFrame