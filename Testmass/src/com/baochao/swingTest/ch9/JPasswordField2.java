import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPasswordField2{

    public static void main(String args[])    {

    	JFrame f = new JFrame("JPasswordField2");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	JPanel p1 = new JPanel();        
    	p1.setLayout(new GridLayout(4,2));        
    	p1.setBorder(BorderFactory.createTitledBorder("���Ļ�������"));         
    	JLabel l1 = new JLabel("������");        
    	JLabel l2 = new JLabel("�Ա�");        
    	JLabel l3 = new JLabel("��ߣ�");        
    	JLabel l4 = new JLabel("���أ�");        
    	JPasswordField t1 = new JPasswordField(10);
    	JPasswordField t2 = new JPasswordField(2);
    	JPasswordField t3 = new JPasswordField(" 175cm");
    	JPasswordField t4 = new JPasswordField(" 50kg̫����",10);
    	
    	t1.setEchoChar('#');
    	t2.setEchoChar('%');
    	t3.setEchoChar('&');
    	t4.setEchoChar('M');
    	
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

