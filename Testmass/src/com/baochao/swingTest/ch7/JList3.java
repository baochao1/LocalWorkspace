import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JList3
{
    public JList3()
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        
        ListModel mode = new DataModel();
        JList list = new JList(mode);
        list.setVisibleRowCount(5);
        list.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        
        contentPane.add(new JScrollPane(list));
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
        new JList3();
    }
}

class DataModel extends AbstractListModel
{
    String[] s = {"����","�ձ�","��½","Ӣ��","����","�����","����","����"};
    public Object getElementAt(int index)
    {
        return (index+1)+"."+s[index++];
    }
    
    public int getSize()
    {
        return s.length;
    }
}

