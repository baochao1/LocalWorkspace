import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JScrollBar1 implements AdjustmentListener
{
    JScrollBar scrollBar1;
    JScrollBar scrollBar2;
    JPanel panel1;
    JLabel label2 = new JLabel("刻度：",JLabel.CENTER);
        
    public JScrollBar1()
    {
        JFrame f = new JFrame("JScrollBarDemo");
        Container contentPane = f.getContentPane();
        
        JLabel label1 = new JLabel(new ImageIcon(".\\icons\\flower.jpg"));
        panel1 = new JPanel();
        panel1.add(label1);
        scrollBar1 = new JScrollBar(JScrollBar.VERTICAL,10,10,0,100);
        scrollBar1.setUnitIncrement(1);
        scrollBar1.setBlockIncrement(10);
        scrollBar1.addAdjustmentListener(this);
        
        scrollBar2 = new JScrollBar();
        scrollBar2.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar2.setValue(0);
        scrollBar2.setVisibleAmount(20);
        scrollBar2.setMinimum(10);
        scrollBar2.setMaximum(60);
        scrollBar2.setBlockIncrement(5);
        scrollBar2.addAdjustmentListener(this);
        
        contentPane.add(panel1,BorderLayout.CENTER);
        contentPane.add(scrollBar1,BorderLayout.EAST);
        contentPane.add(scrollBar2,BorderLayout.SOUTH);
        contentPane.add(label2,BorderLayout.NORTH);
        
        f.setSize(new Dimension(200,200));
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        if ((JScrollBar)e.getSource() == scrollBar1)
            label2.setText("垂直刻度："+e.getValue());
        if ((JScrollBar)e.getSource() == scrollBar2)
            label2.setText("水平刻度："+e.getValue());
    }
    public static void main(String[] arg)
    {
        new JScrollBar1();
    }
}
        

