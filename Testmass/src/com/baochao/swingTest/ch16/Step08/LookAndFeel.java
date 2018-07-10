import javax.swing.*;

public class LookAndFeel{
	
  public static void main(String[] args){

    try {
    //javax.swing.plaf.metal.MetalLookAndFeel.setCurrentTheme( new javax.swing.plaf.metal.DefaultMetalTheme());
	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
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
}//end of class LookAndFeel