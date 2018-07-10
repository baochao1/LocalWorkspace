import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTabbedPane1
{
    public JTabbedPane1()
    {
        JFrame f = new JFrame("JTabbedPaneDemo");
        Container contentPane = f.getContentPane();
        
        JLabel label1 = new JLabel(new ImageIcon(".\\icons\\flower.jpg"));
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        
        JLabel label2 = new JLabel("Label 2",JLabel.CENTER);
        label2.setBackground(Color.pink);
        label2.setOpaque(true);
        JPanel panel2 = new JPanel();
        panel2.add(label2);
        
        JLabel label3 = new JLabel("Label 3",JLabel.CENTER);
        label3.setBackground(Color.yellow);
        label3.setOpaque(true);
        JPanel panel3 = new JPanel();
        panel3.add(label3);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.addTab("Picture",new ImageIcon(".\\icons\\eye.jpg"),panel1,"Í¼°¸");
        tabbedPane.addTab("Label 2",panel2);
        tabbedPane.setEnabledAt(1,false);
        tabbedPane.addTab("Label 3",null,panel3,"label");
        
        contentPane.add(tabbedPane);
       
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public static void main(String[] arg)
    {
        new JTabbedPane1();
    }
}

