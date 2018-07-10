import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoPassword extends JDialog {

  char[] thepasswd;

  public DemoPassword(JFrame f){
    super(f, "Demo PasswordField", true);
    setBounds(250,200,250,150);	
    
    JPanel JPc = new JPanel();
    JPc.setLayout(new GridLayout(4,2,2,2));

    JLabel Lname   = new JLabel("Name: ");
    JLabel Lpasswd = new JLabel("Password: ");
    final JLabel Lresult = new JLabel("");
    JLabel Lnull   = new JLabel("Hint:the password is");
    JLabel Lnull2  = new JLabel("JavaSwing");
    JTextField     TFname   = new JTextField();
    final JPasswordField PFpasswd = new JPasswordField();


    JButton jbutton = new JButton("Login");
    jbutton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
      	thepasswd = PFpasswd.getPassword();
      	String passwdStr = new String(thepasswd);
      	int itf = passwdStr.compareTo("JavaSwing");
      	if (itf != 0){
      	   Lresult.setText("Access Deny!!");
      	}else{
      	   Lresult.setText("PASS!! ^_^");
      	}   
      }
    });
    
    JPc.add(Lname);
    JPc.add(TFname);
    JPc.add(Lpasswd);
    JPc.add(PFpasswd);
    JPc.add(Lnull);
    JPc.add(Lnull2);
    JPc.add(Lresult);
    JPc.add(jbutton);
    
    getContentPane().add(JPc);
    show();
  }
}//end of class DemoPassword