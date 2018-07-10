import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JLabelDemo2
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JLabelDemo2");
        Container contentPane = f.getContentPane();
        Icon icon = new ImageIcon(".\\icons\\hello.jpg");
        JLabel label = new JLabel("Hello",icon,JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
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