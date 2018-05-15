import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextField2{

    public static void main(String args[])    {

    	JFrame f = new JFrame("JTextField2");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	JPanel p1 = new JPanel();        
    	p1.setLayout(new GridLayout(4,2));
    	
    	p1.setBorder(BorderFactory.createTitledBorder("您的基本数据"));         
    	JLabel l1 = new JLabel("姓名：");        
    	JLabel l2 = new JLabel("性别：");        
    	JLabel l3 = new JLabel("身高：");        
    	JLabel l4 = new JLabel("体重：");        
    	JTextField t1 = new JTextField();
    	JTextField t2 = new JTextField(2);
    	JTextField t3 = new JTextField("175cm");        
    	JTextField t4 = new JTextField("50kg太瘦了",10);
    	p1.add(l1);        
    	p1.add(t1);        
    	p1.add(l2);        
    	p1.add(t2);        
   	p1.add(l3);        
    	p1.add(t3);        
    	p1.add(l4);        
    	p1.add(t4);         
    	
    	contentPane.add(p1);        
    	f.pack();        
    	f.show();        
    	f.addWindowListener(new WindowAdapter() {            
    		public void windowClosing(WindowEvent e) {                    
    			System.exit(0);            
    		}        
    	});    
    }
}

