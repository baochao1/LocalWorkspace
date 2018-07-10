import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageIconDemo
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("ImageIconDemo");
        Container contentPane = f.getContentPane();
        Icon icon = new ImageIcon(".\\icons\\visa.gif");
        JLabel label = new JLabel(icon,JLabel.CENTER);
        contentPane.add(label);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}
        