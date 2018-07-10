import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox3
{
    String[] s = {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
    
    public JComboBox3()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        
        ComboBoxModel mode = new AModel();
        JComboBox combo = new JComboBox(mode);
        combo.setBorder(BorderFactory.createTitledBorder("您最喜欢到哪个国家玩呢？"));
        
        contentPane.add(combo);
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
        new JComboBox3();
    }
    
    class AModel extends DefaultComboBoxModel
    {
        AModel()
        {
            for(int i=0; i < s.length; i++)
                addElement(s[i]);
        }
    }
}


