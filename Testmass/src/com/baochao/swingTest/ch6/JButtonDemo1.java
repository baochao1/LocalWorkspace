import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo1
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JButtonDemo1");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("«ö§Ú",new ImageIcon(".\\icons\\hand.jpg"));
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setVerticalTextPosition(JButton.BOTTOM);
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