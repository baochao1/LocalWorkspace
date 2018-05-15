import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToggleButton
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("ToggleButton");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(3,1));
        JToggleButton b1 = new JToggleButton("Button 1");
        JToggleButton b2 = new JToggleButton("Button 2");
        JToggleButton b3 = new JToggleButton("Button 3");
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}