import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JList7 implements ListSelectionListener
{
    JList list = null;
    JLabel label = null;
    String[] s = {"����","�ձ�","��½","Ӣ��","����","�����","����","����"};
    
    public JList7()
    {
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new BorderLayout());
        label = new JLabel();
        
        list = new JList(s);
        list.setVisibleRowCount(5);
        list.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ��������أ�"));
        list.addListSelectionListener(this);
        
        contentPane.add(label,BorderLayout.NORTH);
        contentPane.add(new JScrollPane(list),BorderLayout.CENTER);
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
        new JList7();
    }
    
    public void valueChanged(ListSelectionEvent e)
    {
        int tmp = 0;
        String stmp = "��Ŀǰѡȡ��";
        int[] index = list.getSelectedIndices();
        for(int i=0; i < index.length ; i++)
        {
            tmp = index[i];
            stmp = stmp+s[tmp]+"  ";
        }
        label.setText(stmp);
    }
}


