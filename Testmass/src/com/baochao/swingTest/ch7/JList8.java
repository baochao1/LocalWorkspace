import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JList8 extends MouseAdapter
{
    JList list1 = null;
    JList list2 = null;
    DefaultListModel mode1 = null;
    DefaultListModel mode2 = null;
    String[] s = {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
    
    public JList8()
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        
        mode1 = new DataModel(1);
        list1 = new JList(mode1);
        list1.setBorder(BorderFactory.createTitledBorder("国家名称！"));
        list1.addMouseListener(this);
        
        mode2 = new DataModel(2);
        list2 = new JList(mode2);
        list2.setBorder(BorderFactory.createTitledBorder("您最喜欢到哪个国家玩呢？"));
        list2.addMouseListener(this);
        
        contentPane.add(new JScrollPane(list1));
        contentPane.add(new JScrollPane(list2));
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
        new JList8();
    }
    
    public void mouseClicked(MouseEvent e)
    {
        int index;
        
        if (e.getSource() == list1)
        {
            if(e.getClickCount() == 2)
            {
                index = list1.locationToIndex(e.getPoint());
                String tmp = (String)mode1.getElementAt(index);
                mode2.addElement(tmp);
                list2.setModel(mode2);
                mode1.removeElementAt(index);
                list1.setModel(mode1);
            }
        }
        if (e.getSource() == list2)
        {
            if(e.getClickCount() == 2)
            {
                index = list2.locationToIndex(e.getPoint());
                String tmp = (String)mode2.getElementAt(index);
                mode1.addElement(tmp);
                list1.setModel(mode1);
                mode2.removeElementAt(index);
                list2.setModel(mode2);
            }
        }
    }
    
    class DataModel extends DefaultListModel
    {
        DataModel(int flag)
        {
            if (flag == 1)
            {
                for(int i=0; i < s.length; i++)
                    addElement(s[i]);
            }
        }
    }
}


