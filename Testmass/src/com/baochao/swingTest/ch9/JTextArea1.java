import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextArea1{

    public static void main(String args[])    {

    	JFrame f = new JFrame("JTextArea1");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	JPanel p1 = new JPanel();
    	p1.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.anchor = GridBagConstraints.WEST; //设定Layout的位置
    	gbc.insets = new Insets(2,2,2,2); //设定与边界的距离(上,左,下,右)
    	
    	p1.setBorder(BorderFactory.createTitledBorder("建构一般的JTextArea"));         
    	JLabel l1 = new JLabel("一：");        
    	JLabel l2 = new JLabel("二：");        
    	JLabel l3 = new JLabel("三：");        
    	JLabel l4 = new JLabel("四：");        
    	JTextArea t1 = new JTextArea();
    	JTextArea t2 = new JTextArea(2,8);
    	JTextArea t3 = new JTextArea("JTextArea3");        
    	JTextArea t4 = new JTextArea("JTextArea4",5,10);
        t1.setText("JTextArea1");
        t2.append("JTextArea2");
        t4.setLineWrap(true);

    	gbc.gridy=1;
    	gbc.gridx=0;
    	p1.add(l1,gbc);
    	gbc.gridx=1;
    	p1.add(t1,gbc);
    	gbc.gridy=2;
    	gbc.gridx=0;
    	p1.add(l2,gbc);
    	gbc.gridx=1;
    	p1.add(t2,gbc);
    	gbc.gridy=3;
    	gbc.gridx=0;        
   	p1.add(l3,gbc);
   	gbc.gridx=1;
    	p1.add(t3,gbc);
    	gbc.gridy=4;
    	gbc.gridx=0;        
    	p1.add(l4,gbc);
    	gbc.gridx=1;
    	p1.add(t4,gbc);        
    	
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

