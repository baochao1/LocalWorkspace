import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DefaultButton
{
    public DefaultButton()
    {
        JFrame f = new JFrame("DefaultButton");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        JButton b1 = new JButton("Open Text window");
        JButton b2 = new JButton("Open Image window");
        b1.setMnemonic('T');
        b2.setMnemonic('I');
        f.getRootPane().setDefaultButton(b1);
        
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                JFrame newf = new JFrame("新窗口");
                JLabel label = new JLabel("这是文字窗口");
                label.setHorizontalAlignment(JLabel.CENTER);
                newf.getContentPane().add(label);
                newf.setSize(200,200);
                newf.show();
            }
         });
         
         b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                JFrame newf = new JFrame("新窗口");
                JLabel label = new JLabel(new ImageIcon(".\\icons\\address1.jpg"));
                label.setHorizontalAlignment(JLabel.CENTER);
                newf.getContentPane().add(label);
                newf.setSize(200,200);
                newf.show();
            }
         });
         
        contentPane.add(b1);
        contentPane.add(b2);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public static void main(String arg[])
    {
        new DefaultButton();
    }
}