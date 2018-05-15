import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InternalDialog implements ActionListener
{
    JInternalFrame internalFrame = null;
    JLabel label = null;
    
    public InternalDialog() 
    {
        JFrame f = new JFrame("OptionPane Demo");
        Container contentPane = f.getContentPane();
        
        JDesktopPane desktopPane = new JDesktopPane(); 
        internalFrame = new JInternalFrame(
        "Internal Frame", true,  
                          true,  
                          true,  
                          true); 
        internalFrame.setLocation( 20,20);
        internalFrame.setSize(200,200); 
        internalFrame.setVisible(true);
        
        Container icontentPane = internalFrame.getContentPane();
        JButton b = new JButton("Show Internal Dialog");
        b.addActionListener(this);
        icontentPane.add(b,BorderLayout.CENTER);
        label = new JLabel(" ",JLabel.CENTER);
        icontentPane.add(label,BorderLayout.NORTH);
        
        desktopPane.add(internalFrame);  
        
        contentPane.add(desktopPane,BorderLayout.CENTER);
        f.setSize(350, 350);
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }    
    
    public static void main(String[] args)
    {
        new InternalDialog();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String title = "Option Dialog";
        String message ="��ϲ���Ժ�����";
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int optionType = JOptionPane.YES_NO_CANCEL_OPTION;
        String[] options = {"ϲ��","��ϲ��","ȡ��"};
        
        int result = JOptionPane.showInternalOptionDialog(internalFrame, message,
                  title, optionType, messageType,null,options,options[1]);
        
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


