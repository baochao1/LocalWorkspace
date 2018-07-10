import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OptionDialog implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    
    public OptionDialog() 
    {
        f = new JFrame("OptionPane Demo");
        Container contentPane = f.getContentPane();
        
        JButton b = new JButton("Show Option Dialog");
        b.addActionListener(this);
        
        label = new JLabel(" ",JLabel.CENTER);
        contentPane.add(label,BorderLayout.NORTH);
        contentPane.add(b,BorderLayout.CENTER);
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
        new OptionDialog();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String title = "Option Dialog";
        String message ="您喜欢吃汉堡吗？";
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int optionType = JOptionPane.YES_NO_CANCEL_OPTION;
        String[] options = {"喜欢","不喜欢","取消"};
        
        int result = JOptionPane.showOptionDialog(f, message, title, 
                   optionType, messageType,null,options,options[1]);
        
        if (result == JOptionPane.YES_OPTION)
            label.setText("您选择：喜欢");
        if (result == JOptionPane.NO_OPTION)
            label.setText("您选择：不喜欢");
        if (result == JOptionPane.CANCEL_OPTION)
            label.setText("您选择：取消");
        if (result == JOptionPane.CLOSED_OPTION)
            label.setText("您没做任何选择，并关闭了对话框");
    }
}


