import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JScrollPane2 implements ActionListener
{
    JScrollPane scrollPane;
    
    public JScrollPane2()
    {
        JFrame f = new JFrame("JScrollPaneDemo");
        Container contentPane = f.getContentPane();
        
        JLabel label1 = new JLabel(new ImageIcon(".\\icons\\flower.jpg"));
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel1);
        scrollPane.setColumnHeaderView(new JLabel("ˮƽ��ͷ"));
        scrollPane.setRowHeaderView(new JLabel("��ֱ��ͷ"));
        scrollPane.setViewportBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,new JLabel(new ImageIcon(".\\icons\\glass.jpg")));
        scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER,new JLabel(new ImageIcon(".\\icons\\glass.jpg")));
        
        JPanel panel2 = new JPanel(new GridLayout(3,1));
        JButton b = new JButton("��ʾˮƽ������");
        b.addActionListener(this);
        panel2.add(b);
        b = new JButton("����ʾˮƽ������");
        b.addActionListener(this);
        panel2.add(b);
        b = new JButton("��ʱ��ʾˮƽ������");
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
        if (e.getActionCommand().equals("��ʾˮƽ������"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        if (e.getActionCommand().equals("����ʾˮƽ������"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        if (e.getActionCommand().equals("��ʱ��ʾˮƽ������"))
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.revalidate();
    }
    public static void main(String[] arg)
    {
        new JScrollPane2();
    }
}

