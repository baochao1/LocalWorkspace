import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox2
{
    String[] s = {"����","�ձ�","��½","Ӣ��","����","�����","����","����"};
    
    public JComboBox2()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        
        ComboBoxModel mode = new UserDefineComboBoxModel();
        JComboBox combo = new JComboBox(mode);
        combo.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        
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
        new JComboBox2();
    }
    
    class UserDefineComboBoxModel extends AbstractListModel implements ComboBoxModel
    {
        String item = null;
        
        public Object getElementAt(int index)
        {
            return s[index++];
        }
        
        public int getSize()
        {
            return s.length;
        }
        
        public void setSelectedItem(Object anItem)
        {
            item = (String)anItem;
        }
        
        public Object getSelectedItem()
        {
            return item;
        }
    }
}


