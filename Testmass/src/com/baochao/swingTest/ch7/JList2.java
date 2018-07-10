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
        String[] s1 = {"����","�ձ�","��½","Ӣ��","����","�����","����","����"};
        String[] s2 = {"��־��","����","����","�","�߷�","�Ϸ�","����"};
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
        v.addElement("����");
        
        JList list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        
        JList list2 = new JList(s2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setBorder(BorderFactory.createTitledBorder("����ϲ���ĸ��˶�Ա�أ�"));
        
        JList list3 = new JList(v); 
        list3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list3.setBorder(BorderFactory.createTitledBorder("����ϲ����һ���ֻ���"));

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

