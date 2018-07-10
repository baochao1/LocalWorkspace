import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MessageDialog implements ActionListener
{
    JFrame f = null;
    
    public MessageDialog() 
    {
        f = new JFrame("OptionPane Demo");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(2,3));
        
        JButton b = new JButton("Show Error Icon");
        b.addActionListener(this);
        contentPane.add(b);
        b = new JButton("Show Information Icon");
        b.addActionListener(this);
        contentPane.add(b);
        b = new JButton("Show Warning Icon");
        b.addActionListener(this);
        contentPane.add(b);
        b = new JButton("Show Question Icon");
        b.addActionListener(this);
        contentPane.add(b);
        b = new JButton("Show Plain Icon");
        b.addActionListener(this);
        contentPane.add(b);
        b = new JButton("Show User Define Icon");
        b.addActionListener(this);
        contentPane.add(b);
        
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }    
    
    public static void main(String[] args)
    {
        new MessageDialog();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String cmd = e.getActionCommand();
        String title = "Message Dialog";
        String message ="";
        int type = JOptionPane.PLAIN_MESSAGE;

        if(cmd.equals("Show Error Icon")) {
            type = JOptionPane.ERROR_MESSAGE;
            message = " Error Message";
        } else if(cmd.equals("Show Information Icon")) {
            type = JOptionPane.INFORMATION_MESSAGE;
            message = " Information Message";
        } else if(cmd.equals("Show Warning Icon")) {
            type = JOptionPane.WARNING_MESSAGE;
            message = " Warning Message";
        } else if(cmd.equals("Show Question Icon")) {
            type = JOptionPane.QUESTION_MESSAGE;
            message = " Question Message";
        } else if(cmd.equals("Show Plain Icon")) {
            type = JOptionPane.PLAIN_MESSAGE;
            message = " Plain Message";
        } else if(cmd.equals("Show User Define Icon")) {
            type = JOptionPane.PLAIN_MESSAGE;
            message = " User Define Message";
            JOptionPane.showMessageDialog(f, message, title, 
                        type, new ImageIcon("glass.jpg"));
            return;
        }
    
        JOptionPane.showMessageDialog(f, message, title, type);
    }
}

