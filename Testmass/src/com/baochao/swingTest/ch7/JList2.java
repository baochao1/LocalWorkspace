import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JList2
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,3));
        String[] s1 = {"美国","日本","大陆","英国","法国","意大利","澳洲","韩国"};
        String[] s2 = {"范志毅","符兵","周宁","杨晨","高锋","南方","其他"};
        Vector v = new Vector();
        v.addElement("Nokia 3310");
        v.addElement("Nokia 8850");
        v.addElement("Nokia 8250");
        v.addElement("Motorola V8088");
        v.addElement("Motorola V3688x");
        v.addElement("Panasonic GD92");
        v.addElement("Panasonic GD93");
        v.addElement("NEC DB2100");
        v.addElement("Alcatel OT500");
        v.addElement("Philips Xenium 9@9 ");
        v.addElement("Ericsson T29sc");
        v.addElement("其他");
        
        JList list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("您最喜欢到哪个国家玩呢？"));
        
        JList list2 = new JList(s2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setBorder(BorderFactory.createTitledBorder("您最喜欢哪个运动员呢？"));
        
        JList list3 = new JList(v); 
        list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list3.setBorder(BorderFactory.createTitledBorder("您最喜欢哪一种手机？"));

        contentPane.add(new JScrollPane(list1));
        contentPane.add(new JScrollPane(list2));
        contentPane.add(new JScrollPane(list3));
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}

