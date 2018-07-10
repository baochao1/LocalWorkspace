import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MnemonicButton implements ActionListener
{
    public MnemonicButton()
    {
        JFrame f = new JFrame("MnemonicButton");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("Open new window");
        b.setMnemonic('O');
        b.addActionListener(this);
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JFrame newf = new JFrame("新窗口");
        JLabel label = new JLabel("这是新窗口");
        label.setHorizontalAlignment(JLabel.CENTER);
        newf.getContentPane().add(label);
        newf.setSize(100,100);
        newf.show();
    }
    
    public static void main(String arg[])
    {
        new MnemonicButton();
    }
}