import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RolloverDemo
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("RolloverDemo");
        Container contentPane = f.getContentPane();
        Icon rollover = new ImageIcon(".\\icons\\address1.jpg");
        Icon general = new ImageIcon(".\\icons\\address2.jpg");
        Icon press = new ImageIcon(".\\icons\\address3.jpg");
        Icon disable = new ImageIcon(".\\icons\\address4.jpg");
        JButton b = new JButton();
        b.setRolloverEnabled(true);
        b.setIcon(general);
        b.setRolloverIcon(rollover);
        b.setPressedIcon(press);
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}