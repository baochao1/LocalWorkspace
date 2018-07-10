import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderDemo{

   public static void main(String arg[]){

      JFrame f=new JFrame("BorderDemo");
      Container content = f.getContentPane();
      JLabel label = new JLabel();

      label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
      content.add(label);
      f.setSize(200,150);
      f.show();

      f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
                System.exit(0);
         }
      });
   }
}