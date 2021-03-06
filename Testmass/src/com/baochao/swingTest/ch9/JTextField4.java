import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextField4{

    public static void main(String args[]){

    	JFrame f = new JFrame("JTextField4");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	JPanel p1 = new JPanel();        
    	p1.setLayout(new GridLayout(2,2));        
    	p1.setBorder(BorderFactory.createTitledBorder("JTextField 事件处理范例"));         
    	JLabel l1 = new JLabel("输入：");
     	JLabel l2 = new JLabel("输入后，按下 Enter ==>");   	
    	final JLabel l3 = new JLabel("");
    	final JTextField t1 = new JTextField();
    	t1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent ev){
    			l3.setText(t1.getText());
    		}
    	});
    	p1.add(l1);        
    	p1.add(t1);        
   	p1.add(l2);        
    	p1.add(l3);        
   	
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

