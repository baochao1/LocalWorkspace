import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ProgressMonitorDemo implements ActionListener,ChangeListener
{
    JFrame f = null;
    Timer timer = null;
    ImageIcon[] icons = null;
    JSlider slider = null;
    JLabel label = null;
    int index=0;   
    int total=0;  
    ProgressMonitor pMonitor = null;
    
    public ProgressMonitorDemo()                           
    {
        f = new JFrame("Progress Monitor Example");
        Container contentPane = f.getContentPane();
        
        icons = new ImageIcon[5];
        for (int i=0 ; i<5 ; i++)
            icons[i] = new ImageIcon(".\\icons\\"+(i+1)+".jpg");
        
        label = new JLabel(icons[0]);
        
        slider = new JSlider(JSlider.HORIZONTAL,
                             0,   // min
                           100,   //max
                             50);  //Initial value
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        
        JButton b1 = new JButton("Start");
        b1.addActionListener(new ButtonListener());
        panel.add(b1);
        JButton b2 = new JButton("Stop");
        b2.addActionListener(new ButtonListener());
        panel.add(b2);
        
        panel.setPreferredSize(new Dimension(200,30));
        
        timer = new Timer(slider.getValue()*10,this);

        contentPane.add(slider,BorderLayout.NORTH);
        contentPane.add(label,BorderLayout.CENTER);
        contentPane.add(panel,BorderLayout.SOUTH);
        
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
        new ProgressMonitorDemo();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (pMonitor.isCanceled()) 
        {
            timer.stop();
            index = 0;
            total = 0;
        } else {
            pMonitor.setProgress(total*10);
        }
    
        if (total < 10)
        {
            if (index == 5)
                index = 0;
            label.setIcon(icons[index]);
            label.repaint();
            index++;
            total++;
        }
        else
            timer.stop();
    }
            
    public void stateChanged(ChangeEvent e1)
    {
        timer.setDelay(slider.getValue()*10);
    }

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Start"))
            {
                pMonitor = new ProgressMonitor(f,
                               "Showing Progress Monitor", //message
                               "",  //note
                               0,   //min
                               100);//max
                               
                pMonitor.setNote("Changing Photo....");
                pMonitor.setMillisToDecideToPopup(0);
                pMonitor.setMillisToPopup(1000);
                pMonitor.setProgress(0);
                index = 0;
                total = 0;
                timer.start();
            }
            if (e.getActionCommand().equals("Stop"))
            {   
                timer.stop(); 
            }
        }
    }
}

