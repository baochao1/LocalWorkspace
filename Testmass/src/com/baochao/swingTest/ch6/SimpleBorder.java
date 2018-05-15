import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleBorder{

   public static void main(String arg[]){

      JFrame f=new JFrame("SimpleBorder");
      Container content = f.getContentPane();
      JButton b= new JButton();
      b.setBorder(BorderFactory.createLineBorder(Color.blue,10));
      content.add(b);
      f.setSize(200,150);
      f.show();

      f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
                System.exit(0);
         }
      });
   }
}