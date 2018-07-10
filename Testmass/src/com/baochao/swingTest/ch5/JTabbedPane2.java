import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class JTabbedPane2 implements ActionListener,ChangeListener
{
    int index = 0;  
    int newNumber = 1;
    JTabbedPane tabbedPane = null;
    
    public JTabbedPane2()
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
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        tabbedPane.addChangeListener(this);
        tabbedPane.addTab("Picture",new ImageIcon(".\\icons\\eye.jpg"),panel1,"图案");
        tabbedPane.addTab("Label 2",panel2);
        tabbedPane.addTab("Label 3",null,panel3,"label");
        tabbedPane.setEnabledAt(2,false); //设Label 3标签为Disable状态
        
        JButton b = new JButton("新增标签");
        b.addActionListener(this);
        contentPane.add(b,BorderLayout.NORTH);
        contentPane.add(tabbedPane,BorderLayout.CENTER);
       
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public void stateChanged(ChangeEvent e)
    {
        if (index!= tabbedPane.getSelectedIndex())
        {
            if(index < tabbedPane.getTabCount()-1)
                tabbedPane.setEnabledAt(index+1,true);
        }
        index = tabbedPane.getSelectedIndex();
    }
    
    public void actionPerformed(ActionEvent e1)
    {
        JPanel panel = new JPanel();
        tabbedPane.addTab("new "+newNumber,panel);
        tabbedPane.setEnabledAt(newNumber+2,false);
        newNumber++;
        tabbedPane.validate();
    }
    
    public static void main(String[] arg)
    {
        new JTabbedPane2();
    }
}

