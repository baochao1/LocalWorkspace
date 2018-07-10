import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JInternalFrame1 extends JFrame implements ActionListener{
    
    JDesktopPane desktopPane;
    int count = 1;
    
    public JInternalFrame1() {
        super("JInternalFrame1");
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JButton b = new JButton("Create New Internal Frames");
        b.addActionListener(this);
        contentPane.add(b, BorderLayout.SOUTH);

        desktopPane = new JDesktopPane(); 
        contentPane.add(desktopPane); 

        setSize(350, 350); 
        show(); 
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        JInternalFrame internalFrame = new JInternalFrame(
        "Internal Frame "+(count++), true, true, true, true);  

        internalFrame.setLocation( 20,20);
        internalFrame.setSize(200,200); 
        internalFrame.setVisible(true);
        
        Container icontentPane = internalFrame.getContentPane();
        JTextArea textArea = new JTextArea();
        JButton b = new JButton("Internal Frame Button");
        icontentPane.add(textArea,"Center");
        icontentPane.add(b,"South");
        
        desktopPane.add(internalFrame);  
        
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
          System.out.println("Exception while selecting");
        }
    }

    public static void main(String[] args) {
        new JInternalFrame1();
    }
}