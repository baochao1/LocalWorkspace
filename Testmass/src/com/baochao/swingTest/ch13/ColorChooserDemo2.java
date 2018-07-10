import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorChooserDemo2 extends MouseAdapter implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    JLabel label1 = null;
    JLabel label2 = null;
    Rectangle rec1 = null;
    Rectangle rec2 = null;
    JDialog dialog = null;
    JColorChooser colorChooser = null;
    
    public ColorChooserDemo2()
    {
        f = new JFrame("ColorChooser Example");         
        Container contentPane = f.getContentPane();
        contentPane.addMouseListener(this);
        
        label = new JLabel(" ",JLabel.CENTER);
        label.setPreferredSize(new Dimension(300,20));
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        
        label1 = new JLabel("左Label",JLabel.CENTER);
        label1.setBackground(Color.red);
        label1.setForeground(Color.black);
        label1.setOpaque(true);
        label1.setBounds(0, 0, 150, 150);
        panel.add(label1);
        
        label2 = new JLabel("右Label",JLabel.CENTER);
        label2.setBackground(Color.green);
        label2.setForeground(Color.black);
        label2.setOpaque(true);
        label2.setBounds(150, 0, 150, 150);
        panel.add(label2);
        
        rec1 = label1.getBounds();
        rec2 = label2.getBounds();
        
        contentPane.add(panel,BorderLayout.CENTER);
        contentPane.add(label,BorderLayout.SOUTH);
        
        colorChooser = new JColorChooser();
        dialog = colorChooser.createDialog(f, //parent component
                                  "Change Color", //title
                                  true, //modal
                                  colorChooser, //JColorChooser
                                  this,//okListenr
                                  this);//cancelListener
                                   
        f.setSize(new Dimension(300,150));
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] arg)
    {
        new ColorChooserDemo2();
    }
    
    public void mousePressed(MouseEvent e) {
       label.setText("目前鼠标坐标（X,Y）为：（"+e.getX()+","+e.getY()+")");
    }
    
    boolean flag = true; 
    
    public void mouseClicked(MouseEvent e)
    {
        Point point = e.getPoint();
        
        if (e.getClickCount() ==2)
        {
            if(rec1.contains(point))
            {
                flag = true;
                dialog.setTitle("Change label1 Color");
                dialog.show();
            }
            if(rec2.contains(point))
            {
                flag = false;
                dialog.setTitle("Change label2 Color");
                dialog.show();
            }
        }
     }
     
     
     public void actionPerformed(ActionEvent ae)
     {
        if(ae.getActionCommand().equals("OK"))
        {
            if (flag == true)
                label1.setBackground(colorChooser.getColor());
            else
                label2.setBackground(colorChooser.getColor());
        }
        if(ae.getActionCommand().equals("Cancel"))
            dialog.dispose();
    }
}

