import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame{

  JDesktopPane desktop;
  JMenuBar     MBar;
	
  public MainFrame(){

    super("MainFrame-Look and Feel");
    setBounds(100,100,600,400);
    buildContent();
    buildMenu();
      
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

    MBar.add(mfile);
    
    setJMenuBar(MBar);    
  }//end of bulidMenu()

  public void quit(){
    System.exit(0); 
  }//end of quit()

  public JMenu buildFileMenu() {
  	
    JMenu file = new JMenu("File");
    JMenuItem newf = new JMenuItem("New");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close= new JMenuItem("Close");    
    JMenuItem quit = new JMenuItem("Exit");

    file.add(newf);	  	
    file.add(open);
    file.add(close);        
    file.addSeparator();
    file.add(quit);
    return file;
  }//end of buildFileMenu()
}//end of class MainFrame
