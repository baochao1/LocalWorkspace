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
    	
    	p1.setBorder(BorderFactory.createTitledBorder("���Ļ�������"));         
    	JLabel l1 = new JLabel("������");        
    	JLabel l2 = new JLabel("�Ա�");        
    	JLabel l3 = new JLabel("��ߣ�");        
    	JLabel l4 = new JLabel("���أ�");        
    	JTextField t1 = new JTextField();
    	JTextField t2 = new JTextField(2);
    	JTextField t3 = new JTextField("175cm");        
    	JTextField t4 = new JTextField("50kg̫����",10);
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

