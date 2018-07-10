import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrame1 implements ActionListener
{
    public JFrame1()    
    {        
        JFrame f = new JFrame("JFrameDemo");
        Container contentPane = f.getContentPane();        
        JButton b = new JButton("Click me to get new Window");        
        b.addActionListener(this);        
        contentPane.add(b);        
        f.pack();        
        f.show();        
        f.addWindowListener(new WindowAdapter() 
        {            
            public void windowClosing(WindowEvent e) 
            {                    
                System.exit(0);            
            }        
        });    
    }        
    
    public void actionPerformed(ActionEvent e)    
    {        
        JFrame newf = new JFrame();        
        newf.setSize(200,200);        
        newf.show();    
    }        
    
    public static void main(String[] arg)    
    {        
        new JFrame1();    
    }
}