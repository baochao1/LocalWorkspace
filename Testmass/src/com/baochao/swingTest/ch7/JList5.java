import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class JList5
{
    public JList5()
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        ListModel mode = new DataModel(1);
        JList list1 = new JList(mode);
        list1.setVisibleRowCount(5);
        list1.setBorder(BorderFactory.createTitledBorder("您玩过哪些软件？"));
        
        mode = new DataModel(2);
        JList list2 = new JList(mode);
        list2.setBorder(BorderFactory.createTitledBorder("您玩过哪些数据库软件？"));
        
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
        new JList5();
    }
}

class DataModel extends AbstractListModel
{
    String[] s = {"MS SQL","MySQL","IBM DB2","ORACLE","Windows 2000","Linux","UNix","OS2"};
    int flag;
    
    DataModel(int flag)
    {
        this.flag = flag;
    }
    public Object getElementAt(int index)
    {
        String tmp = null;
        
        if (flag == 1)
            tmp = (index+1)+"."+s[index++];
        if (flag == 2)
        {
            if(index < 4)
                tmp = (index+1)+"."+s[index++];     
        }
        
        return tmp;
    }
    
    public int getSize()
    {
        return s.length;
    }
}

