import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeparatorDemo1
{
    JFrame f = null;
    
    public SeparatorDemo1()
    {
        f = new JFrame("Separator Example");         
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new BorderLayout(1,2));
        
        JPanel panel1 = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel("水平分隔线",JLabel.CENTER);
        JSeparator seph = new JSeparator();
        panel1.add(label);
        panel1.add(seph);
        
        JTextArea textarea = new JTextArea();
        textarea.setPreferredSize(new Dimension(150,100));
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(panel1,BorderLayout.NORTH);
        panel2.add(textarea,BorderLayout.CENTER);
        
        JPanel panel3 = new JPanel(new GridLayout(1,3));
        label = new JLabel("垂直");
        label.setVerticalAlignment(JLabel.CENTER);
        panel3.add(label);
        JSeparator sepv = new JSeparator();
        sepv.setOrientation(JSeparator.VERTICAL);
        panel3.add(sepv);
        
        contentPane.add(panel2,BorderLayout.CENTER);
        contentPane.add(panel3,BorderLayout.EAST);
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] arg)
    {
        new SeparatorDemo1();
    }
}

