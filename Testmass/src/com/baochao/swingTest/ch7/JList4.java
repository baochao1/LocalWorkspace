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
        new JList4();
    }
}

class DataModel extends DefaultListModel
{
    String[] s = {"美国"," 日本","大陆","英国","法国","意大利","澳洲","韩国"};
    
    DataModel()
    {
        for(int i=0; i < s.length; i++)
            addElement((i+1)+"."+s[i]);
    }
}

