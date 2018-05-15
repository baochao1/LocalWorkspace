import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButton1 implements ItemListener
{
    JFrame f = null;
    JRadioButton r4 = null;
    JRadioButton r5 = null;
    
    JRadioButton1(){
        f = new JFrame("JRadioButton");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p1.setBorder(BorderFactory.createTitledBorder("您最喜欢哪一家速食店呢？")); 
        JRadioButton r1 = new JRadioButton("麦当劳");
        JRadioButton r2 = new JRadioButton("肯德鸡");
        JRadioButton r3 = new JRadioButton("21世纪");
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));
        p2.setBorder(BorderFactory.createTitledBorder("您喜欢哪种程序语言? 喜欢的请打勾")); 
        r4 = new JRadioButton("JAVA",new ImageIcon(".\\icons\\x.jpg"));
        r5 = new JRadioButton("C++",new ImageIcon(".\\icons\\x.jpg"));
        r4.addItemListener(this);
        r5.addItemListener(this);
        p2.add(r4);
        p2.add(r5);
        contentPane.add(p1);
        contentPane.add(p2);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getStateChange() == e.SELECTED)
        {
            if(e.getSource() == r4)
                r4.setIcon(new ImageIcon(".\\icons\\r.jpg"));
            if(e.getSource() == r5)
                r5.setIcon(new ImageIcon(".\\icons\\r.jpg"));
            
        }
        else
        {
            if(e.getSource() == r4)
                r4.setIcon(new ImageIcon(".\\icons\\x.jpg"));
            if(e.getSource() == r5)
                r5.setIcon(new ImageIcon(".\\icons\\x.jpg"));
        }
    }
      
    public static void main(String args[])
    {
        new JRadioButton1();
    }
}

