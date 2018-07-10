import javax.swing.*;

public class JavaLookAndFeel{
	
  public static void main(String[] args){

    try {
	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }  
    catch ( Exception e ) {
	    System.out.println ("Unexpected error. \nProgram Terminated");
	    e.printStackTrace();
	    System.exit(0);
    }
    new MainFrame();
  } // end of main
}//end of class LookAndFeel