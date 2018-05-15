import javax.swing.*;

public class CDELookAndFeel{
	
  public static void main(String[] args){

    try {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    }  
    catch ( Exception e ) {
	    System.out.println ("Unexpected error. \nProgram Terminated");
	    e.printStackTrace();
	    System.exit(0);
    }
    new MainFrame();
  } // end of main
}//end of class CDELookAndFeel