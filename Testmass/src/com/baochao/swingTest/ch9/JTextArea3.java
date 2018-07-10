import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextArea3 implements ActionListener
{
    JTextArea textarea = null;
    JButton b1,b2,b3;
    
    public JTextArea3()
    {
        JFrame f = new JFrame("JTextArea3");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	textarea = new JTextArea(10,15);
    	JScrollPane scrollPane = new JScrollPane(textarea);
    	
    	JPanel panel = new JPanel();        
    	panel.setLayout(new GridLayout(1,3));       
        b1 = new JButton("Copy");
        b1.addActionListener(this);
        b2 = new JButton("Paste");
        b2.addActionListener(this);
        b3 = new JButton("Cut");
        b3.addActionListener(this);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        
    	contentPane.add(scrollPane,BorderLayout.CENTER);        
    	contentPane.add(panel,BorderLayout.SOUTH);
    	
    	f.pack();        
    	f.show();        
    	f.addWindowListener(new WindowAdapter() {            
    		public void windowClosing(WindowEvent e) {                    
    			System.exit(0);            
    		}        
    	});
    }

    public static void main(String args[])
    {

    	new JTextArea3();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b1)
        {
            textarea.copy();
        }
        if (e.getSource() == b2)
        {
            textarea.paste();
        }
        if (e.getSource() == b3)
        {
            textarea.cut();
        }
    }
}