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
        b1 = new JButton("按钮");
        label = new JLabel("起始状态，还没鼠标事件",JLabel.CENTER);
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
       label.setText("目前鼠标坐标（X,Y）为：（"+e.getX()+","+e.getY()+")");
    }

    public void mouseClicked(MouseEvent e) {
       if (e.getClickCount() ==2)
       {
           JFrame newF = new JFrame("新窗口");
           newF.setSize(200,200);
           newF.show();
       }
    }
    
    public static void main(String args[])
    {
        new MouseDemo2();
    }
}


