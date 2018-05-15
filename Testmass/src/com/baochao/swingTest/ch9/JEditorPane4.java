import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.event.*;

public class JEditorPane4{

	public static void main(String[] args){
		
		JEditorPane editPane = null;
		try{
		  File thef = new File ("docs/JEditorPane_1.html");
	    	  String str = thef.getAbsolutePath();
	    	  str = "file:"+str;
	    	  editPane = new JEditorPane();
	    	  editPane.setPage(str);
	    	}
		catch(IOException ioe){
		  ioe.printStackTrace(System.err);
		  System.exit(0);
		}
		editPane.setEditable(false);
		
		final JEditorPane thePane = editPane;
		editPane.addHyperlinkListener(new HyperlinkListener(){
		  public void hyperlinkUpdate(HyperlinkEvent hle){
		    try{
		      if (hle.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
		        thePane.setPage(hle.getURL());
		    }
		    catch(IOException ioe){
		      ioe.printStackTrace(System.err);
		    }
		  }
		});
		
		JFrame f = new JFrame("JEditorPane4");
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