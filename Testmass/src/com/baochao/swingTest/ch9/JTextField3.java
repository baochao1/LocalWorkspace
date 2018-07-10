import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextField3{

    public static void main(String args[])    {

    	JFrame f = new JFrame("JTextField3");
    	Container contentPane = f.getContentPane();
    	contentPane.setLayout(new BorderLayout());

    	JPanel p1 = new JPanel();        
    	//p1.setLayout(new GridLayout(4,2));
    	p1.setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.anchor = GridBagConstraints.WEST; //�趨Layout��λ��
    	gbc.insets = new Insets(2,2,2,2); //�趨��߽�ľ���(��,��,��,��)
    	
    	p1.setBorder(BorderFactory.createTitledBorder("���Ļ�������"));         
    	JLabel l1 = new JLabel("������");        
    	JLabel l2 = new JLabel("�Ա�");        
    	JLabel l3 = new JLabel("���ߣ�");        
    	JLabel l4 = new JLabel("���أ�");        
    	JTextField t1 = new JTextField(new JTextField3_FixedLengthDocument(10),"",10);
    	JTextField t2 = new JTextField(new JTextField3_FixedLengthDocument(1),"",2);
    	JTextField t3 = new JTextField(new JTextField3_FixedLengthDocument(5),"",5);        
    	JTextField t4 = new JTextField(new JTextField3_FixedLengthDocument(5),"",5);

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
