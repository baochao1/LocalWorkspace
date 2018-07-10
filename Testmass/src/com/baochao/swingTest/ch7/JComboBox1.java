import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JComboBox1
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("JComboBox");
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
        
        JComboBox combo1 = new JComboBox(s);
        combo1.addItem("����");
        combo1.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        
        JComboBox combo2 = new JComboBox(v); 
        combo2.setBorder(BorderFactory.createTitledBorder("����ϲ����һ���ֻ���?"));

        contentPane.add(combo1);
        contentPane.add(combo2);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}

