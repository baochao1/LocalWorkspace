import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JLabelDemo1
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JLabelDemo1");
        Container contentPane = f.getContentPane();
        JLabel label = new JLabel();
        label.setText("Hello");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.TOP);
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