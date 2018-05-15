import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JList1
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        String[] s = {"����","�ձ�","��½","Ӣ��","����"};
        Vector v = new Vector();
        v.addElement("Nokia 8850");
        v.addElement("Nokia 8250");
        v.addElement("Motorola V8088");
        v.addElement("Motorola V3688x");
        v.addElement("Panasonic GD92");
        v.addElement("����");
        
        JList list1 = new JList(s);
        list1.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        
        JList list2 = new JList(v); 
        list2.setBorder(BorderFactory.createTitledBorder("����ϲ����һ���ֻ���"));

        contentPane.add(list1);
        contentPane.add(list2);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}

