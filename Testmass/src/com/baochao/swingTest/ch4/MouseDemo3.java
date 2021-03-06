import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDemo3 extends JFrame implements MouseListener,MouseMotionListener
{
    int flag = 0;
    int x = 0;
    int y = 0;
    int startx,starty,endx,endy;
    
    public MouseDemo3()
    {
        Container contentPane = getContentPane();
        contentPane.addMouseListener(this);
        contentPane.addMouseMotionListener(this);
        setSize(300,300);
        show();
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }});
    }

    public void mousePressed(MouseEvent e) {
       startx = e.getX();
       starty = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
       endx = e.getX();
       endy = e.getY();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseMoved(MouseEvent e) {
        flag = 1;
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        flag = 2;
        x = e.getX();
        y = e.getY();
        repaint();
    }
    
    public void update(Graphics g)
    {
        g.setColor(this.getBackground());
        g.fillRect(0,0,getWidth(),getHeight());
        paint(g);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        if (flag == 1)
        {
            g.drawString("������꣺("+x+","+y+")",10,50);
            g.drawLine(startx,starty,endx,endy);
        }
        if (flag == 2)
        {
            g.drawString("��ҷ������꣺("+x+","+y+")",10,50);
            g.drawLine(startx,starty,x,y);
        }
    }

    public static void main(String args[])
    {
        new MouseDemo3();
    }
}


