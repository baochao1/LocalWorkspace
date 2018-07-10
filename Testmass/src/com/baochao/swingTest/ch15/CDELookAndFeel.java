import javax.swing.*;

public class CDELookAndFeel{
	
  public static void main(String[] args){

    try {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    }  
    catch ( UnsupportedLookAndFeelException e ) {
	    System.out.println ("This Look & Feel not supported on this platform. \nProgram Terminated");
	    System.exit(0);
    }
    catch ( IllegalAccessException e ) {
	    System.out.println ("This Look & Feel could not be accessed. \nProgram Terminated");
	    System.exit(0);
    }
    catch ( ClassNotFoundException e ) {
            System.out.println ("This Look & Feel could not found. \nProgram Terminated");
	    System.exit(0);
    }   
    catch ( InstantiationException e ) {
            System.out.println ("This Look & Feel could not be instantiated. \nProgram Terminated");
	    System.exit(0);
    }
    catch ( Exception e ) {
	    System.out.println ("Unexpected error. \nProgram Terminated");
	    e.printStackTrace();
	    System.exit(0);
    }
    JFrame F = new MainFrame();
    F.setVisible(true); 
  } // end of main
}//end of class CDELookAndFeel