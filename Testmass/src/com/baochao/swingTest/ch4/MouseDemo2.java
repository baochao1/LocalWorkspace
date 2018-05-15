import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDemo2 extends MouseAdapter
{
    JFrame f = null;
    JButton b1 = null;
    JLabel label = null;
    
    public MouseDemo2()
    {
        f = new JFrame("MouseDemo2");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));
        b1 = new JButton("��ť");
        label = new JLabel("��ʼ״̬����û����¼�",JLabel.CENTER);
        b1.addMouseListener(this);
        contentPane.add(label);
        contentPane.add(b1);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }});
    }

    public void mousePressed(MouseEvent e) {
       label.setText("Ŀǰ������꣨X,Y��Ϊ����"+e.getX()+","+e.getY()+")");
    }

    public void mouseClicked(MouseEvent e) {
       if (e.getClickCount() ==2)
       {
           JFrame newF = new JFrame("�´���");
           newF.setSize(200,200);
           newF.show();
       }
    }
    
    public static void main(String args[])
    {
        new MouseDemo2();
    }
}


