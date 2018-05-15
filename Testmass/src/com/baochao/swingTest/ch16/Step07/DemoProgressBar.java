import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class DemoProgressBar extends JPanel{

  JProgressBar JPB;
  static final int theMIN = 0;  
  static final int theMAX = 100;
  
  public DemoProgressBar(){
    super(true);
    
    JPB = new JProgressBar();
    JPB.setMinimum(theMIN);
    JPB.setMaximum(theMAX);
    add(JPB);
  }//end of DemoProgressBar()

  public void updateBar(int NewValue){
    JPB.setValue(NewValue);	
  }//end of updateBar	

  public static void main(String args[]){
    final DemoProgressBar pbe = new DemoProgressBar();
    
    JFrame jframe = new JFrame("DemoProgressBar");
    jframe.setContentPane(pbe);
    jframe.pack();
    jframe.setVisible(true);

    jframe.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    	  System.exit(0);; 
        }
    });//end of addWindowListener
    
    for(int i=0;i<=100;i++){
      final int theValue=i;
      try{
      SwingUtilities.invokeAndWait(
      	new Runnable(){
      	  public void run(){
      	    pbe.updateBar(theValue);
      	}}
      );
      }catch(InterruptedException ie){;}
       catch(InvocationTargetException ite){}
      try{
        java.lang.Thread.sleep(100);
      }catch(Exception e){;}
    }//end for loop
  }//end of main()
}//end of class