import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JList4
{
    public JList4()
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
        new JList4();
    }
}

class DataModel extends DefaultListModel
{
    String[] s = {"����"," �ձ�","��½","Ӣ��","����","�����","����","����"};
    
    DataModel()
    {
        for(int i=0; i < s.length; i++)
            addElement((i+1)+"."+s[i]);
    }
}

