import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class TimerDemo1 implements ActionListener,ChangeListener
{
    JFrame f = null;
    ImageIcon[] icons;
    JSlider slider1;
    JLabel label;
    JToggleButton toggleb1,toggleb2;
    JButton b;
    javax.swing.Timer timer;
    int index = 0;
    
    public TimerDemo1()                           
    {
        f = new JFrame("Timer Example");
        Container contentPane = f.getContentPane();
        icons = new ImageIcon[5];
        for (int i=0 ; i<5 ; i++)
            icons[i] = new ImageIcon(".\\icons\\"+(i+1)+".jpg");
        
        label = new JLabel(icons[0]);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1));
        slider1 = new JSlider();
        slider1.setPaintTicks(true);
        slider1.setMajorTickSpacing(20);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintLabels(true);
        slider1.addChangeListener(this);
        panel1.add(slider1);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        toggleb1 = new JToggleButton("Start");
        toggleb1.addActionListener(this);
        buttonPanel.add(toggleb1);
        b = new JButton("Restart");
        b.addActionListener(this);
        buttonPanel.add(b);
        toggleb2 = new JToggleButton("Don't Repeat");
        toggleb2.addActionListener(this);
        buttonPanel.add(toggleb2);
        panel1.add(buttonPanel);
        
        Hashtable table = new Hashtable();
        table.put(new Integer( 0 ),new JLabel("快"));
        table.put(new Integer( 50 ),new JLabel("中"));
        table.put(new Integer( 100 ),new JLabel("慢"));
        slider1.setLabelTable(table);
        
        timer = new javax.swing.Timer(slider1.getValue()*10,this);
        
        contentPane.add(label,BorderLayout.CENTER);
        contentPane.add(panel1,BorderLayout.SOUTH);
        
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
        new TimerDemo1();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == toggleb1)
        {
            if (e.getActionCommand().equals("Start"))
            {   
                timer.start();
                toggleb1.setText("Stop");
            }
            if (e.getActionCommand().equals("Stop"))
            {   
                timer.stop(); 
                toggleb1.setText("Start");
            }
        }
        if (e.getSource() == toggleb2)
        {
            if(timer.isRepeats())
            {
                timer.setRepeats(false);
            }
            else
            {
                timer.setRepeats(true);
                timer.start();
            }
        }
        if (e.getSource() == b)
        {
            slider1.setValue(50);
            timer.restart();
        }
        
        if (e.getSource() == timer)
        {
            if (index == 5)
                index = 0;
            label.setIcon(icons[index]);
            label.repaint();
            //f.pack(); //若要視窗隨圖形大小變化，可加入此行
            index++;
        }
    }
            
    public void stateChanged(ChangeEvent e1)
    {
            timer.setDelay(slider1.getValue()*10);
    }
}