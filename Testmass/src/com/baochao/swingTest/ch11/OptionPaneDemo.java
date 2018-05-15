import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OptionPaneDemo implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    
    public OptionPaneDemo() 
    {
        f = new JFrame("OptionPane Demo");
        Container contentPane = f.getContentPane();
        
        JButton b = new JButton("Show Text Input");
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
        new OptionPaneDemo();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String title = "Input Dialog";
        JLabel message =new JLabel("您最喜欢吃什么食物？",JLabel.CENTER);
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int optionType = JOptionPane.OK_CANCEL_OPTION;
        String result ="";
        
        JOptionPane optionPane = new JOptionPane(message,messageType,optionType);
        optionPane.setWantsInput(true);
        optionPane.setInitialSelectionValue("请输入！");
        optionPane.setInputValue("您没有输入！");
        JDialog dialog = optionPane.createDialog(f, title);
        dialog.show();
        
        result = (String)optionPane.getInputValue();

        label.setText("您输入："+result);
    }
}



