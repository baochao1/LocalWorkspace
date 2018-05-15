import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.event.*;

public class JEditorPane1{

	public static void main(String[] args){
		
		JEditorPane editPane = null;
		try{
		  File file = new File ("docs/JEditorPane_1.html");
	    	  String str = file.getAbsolutePath();
	    	  str = "file:"+str;
	    	  editPane = new JEditorPane();
	    	  editPane.setPage(str);
	    	}
		catch(IOException ioe){
		  ioe.printStackTrace(System.err);
		  System.exit(0);
		}
		editPane.setEditable(false);

		JFrame f = new JFrame("JEditorPane1");
		f.setContentPane(new JScrollPane(editPane));
		f.setSize(200,250);
    		f.show(); 
    		f.addWindowListener(new WindowAdapter() {            
    		  public void windowClosing(WindowEvent e) {                    
    		 	  System.exit(0);            
    		  }        
    		});    
	}//end of main()
}//end of class JEditPane1