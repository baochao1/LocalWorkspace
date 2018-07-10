import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JScrollPane1 implements ActionListener
{
    JScrollPane scrollPane;
    
    public JScrollPane1()
    {
        JFrame f = new JFrame("JScrollPaneDemo");
        Container contentPane = f.getContentPane();
        
        JLabel label1 = new JLabel(new ImageIcon(".\\icons\\flower.jpg"));
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        scrollPane = new JScrollPane(panel1);
        
        JPanel panel2 = new JPanel(new GridLayout(3,1));
        JButton b = new JButton("显示水平滚动轴");
        b.addActionListener(this);
        panel2.add(b);
        b = new JButton("不显示水平滚动轴");
        b.addActionListener(this);
        panel2.add(b);
        b = new JButton("适时显示水平滚动轴");
        b.addActionListener(this);
        panel2.add(b);
        
        contentPane.add(panel2,BorderLayout.WEST);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        
        f.setSize(new Dimension(350,220));
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        if (e.getActionCommand().equals("不显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        if (e.getActionCommand().equals("适时显示水平滚动轴"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.revalidate();
    }
    public static void main(String[] arg)
    {
        new JScrollPane1();
    }
}

