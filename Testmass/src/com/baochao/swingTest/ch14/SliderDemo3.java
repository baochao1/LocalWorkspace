import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class SliderDemo3 implements ChangeListener
{
    JFrame f = null;
    JSlider slider1;
    JSlider slider2;
    JSlider slider3;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    
    public SliderDemo3()                           
    {
        f = new JFrame("JSlider Example");
        Container contentPane = f.getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1));
        slider1 = new JSlider();
        slider1.setPaintTicks(true);
        slider1.setMajorTickSpacing(20);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintLabels(true);
        slider1.setPaintTrack(true);
        slider1.setSnapToTicks(true);
        label1 = new JLabel("目前刻度："+slider1.getValue());
        panel1.add(label1);
        panel1.add(slider1);
        panel1.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 1",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        Hashtable table = new Hashtable();
        table.put(new Integer( 0 ),new JLabel("低"));
        table.put(new Integer( 50 ),new JLabel("中"));
        table.put(new Integer( 100 ),new JLabel("高"));
        slider1.setLabelTable(table);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        slider2 = new JSlider(JSlider.HORIZONTAL);
        slider2.setMinimum(0);
        slider2.setMaximum(100);
        slider2.setValue(30);
        slider2.setExtent(50);
        slider2.setPaintTicks(true);
        slider2.setMajorTickSpacing(10);
        slider2.setMinorTickSpacing(5);
        slider2.setPaintLabels(true);
        slider2.putClientProperty("JSlider.isFilled",Boolean.TRUE);
        label2 = new JLabel("目前刻度："+slider2.getValue());
        panel2.add(label2);
        panel2.add(slider2);
        panel2.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 2",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        table = new Hashtable();
        table.put(new Integer( 0 ),new JLabel("弱"));
        table.put(new Integer( 25 ),new JLabel("有点弱"));
        table.put(new Integer( 50 ),new JLabel("中"));
        table.put(new Integer( 75 ),new JLabel("有点强"));
        table.put(new Integer( 100 ),new JLabel("强"));
        slider2.setLabelTable(table);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));
        slider3 = new JSlider(20,80);
        slider3.setOrientation(JSlider.VERTICAL);
        slider3.setPaintTicks(true);
        slider3.setMajorTickSpacing(30);
        slider3.setMinorTickSpacing(10);
        slider3.setPaintLabels(true);
        slider3.putClientProperty("JSlider.isFilled",Boolean.TRUE);
        label3 = new JLabel("目前刻度："+slider3.getValue());
        panel3.add(label3);
        panel3.add(slider3);
        panel3.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 3",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        slider1.addChangeListener(this);
        slider2.addChangeListener(this);
        slider3.addChangeListener(this);
        
        panel1.setPreferredSize(new Dimension(300,130));
        panel2.setPreferredSize(new Dimension(300,130));
        panel3.setPreferredSize(new Dimension(150,260));
        
        GridBagConstraints c;
        int gridx,gridy,gridwidth,
            gridheight,anchor,fill,ipadx,ipady;
        double weightx,weighty;
        Insets inset;     
        
        GridBagLayout gridbag = new GridBagLayout();
        contentPane.setLayout(gridbag);
        
        gridx=0;               //第0行
        gridy=0;               //第0列
        gridwidth = 2;         //占两单位宽度
        gridheight = 1;        //占一单位高度
        weightx = 0;           
        weighty = 0;          
        anchor = GridBagConstraints.CENTER; 
        fill = GridBagConstraints.BOTH;     
        inset = new Insets(0,0,0,0);        
        ipadx = 0;                          
        ipady = 0;                          
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel1,c);
        contentPane.add(panel1); 
        
        gridx=0;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel2,c);
        contentPane.add(panel2);
        
        gridx=2;
        gridy=0;
        gridwidth = 1;         //占一单位宽度
        gridheight = 2;        //占两单位高度
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel3,c);
        contentPane.add(panel3);
        
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args)
    {
        new SliderDemo3();
    }
    
    public void stateChanged(ChangeEvent e)
    {
        if ((JSlider)e.getSource() == slider1)
            label1.setText("目前刻度："+slider1.getValue());
        if ((JSlider)e.getSource() == slider2)
            label2.setText("目前刻度："+slider2.getValue());
        if ((JSlider)e.getSource() == slider3)
            label3.setText("目前刻度："+slider3.getValue());
    }
}

