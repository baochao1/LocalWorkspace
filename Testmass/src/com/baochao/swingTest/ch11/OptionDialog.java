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
        String message ="��ϲ���Ժ�����";
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int optionType = JOptionPane.YES_NO_CANCEL_OPTION;
        String[] options = {"ϲ��","��ϲ��","ȡ��"};
        
        int result = JOptionPane.showOptionDialog(f, message, title, 
                   optionType, messageType,null,options,options[1]);
        
        if (result == JOptionPane.YES_OPTION)
            label.setText("��ѡ��ϲ��");
        if (result == JOptionPane.NO_OPTION)
            label.setText("��ѡ�񣺲�ϲ��");
        if (result == JOptionPane.CANCEL_OPTION)
            label.setText("��ѡ��ȡ��");
        if (result == JOptionPane.CLOSED_OPTION)
            label.setText("��û���κ�ѡ�񣬲��ر��˶Ի���");
    }
}


