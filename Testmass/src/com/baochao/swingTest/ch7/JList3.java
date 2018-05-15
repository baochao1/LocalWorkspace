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
        list.setBorder(BorderFactory.createTitledBorder("您最喜欢到哪个国家玩呢？"));
        
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
    String[] s = {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
    public Object getElementAt(int index)
    {
        return (index+1)+"."+s[index++];
    }
    
    public int getSize()
    {
        return s.length;
    }
}

