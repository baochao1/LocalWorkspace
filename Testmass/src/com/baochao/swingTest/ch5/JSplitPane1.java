import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPane1
{
    public JSplitPane1()
    {
        JFrame f = new JFrame("JSplitPaneDemo");
        Container contentPane = f.getContentPane();
        JLabel label1 = new JLabel("Label 1",JLabel.CENTER);
        label1.setBackground(Color.green);
        label1.setOpaque(true);
        JLabel label2 = new JLabel("Label 2",JLabel.CENTER);
        label2.setBackground(Color.pink);
        label2.setOpaque(true);
        JLabel label3 = new JLabel("Label 3",JLabel.CENTER);
        label3.setBackground(Color.yellow);
        label3.setOpaque(true);
        
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,label1,label2);
        splitPane1.setDividerLocation(0.3);
        splitPane1.setOneTouchExpandable(true); 
        splitPane1.setDividerSize(10); 
        
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,splitPane1,label3);
        splitPane2.setDividerLocation(35);
        splitPane2.setOneTouchExpandable(false); 
        splitPane2.setDividerSize(5); 
        
        contentPane.add(splitPane2);

        f.setSize(250,200);
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public static void main(String[] arg)
    {
        new JSplitPane1();
    }
}