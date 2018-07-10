import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JList6
{
    public JList6()
    {
        String[] s = {"Î÷¹Ï","Æ»¹û","²ÝÝ®","Ïã½¶","ÆÏÌÑ"};
        JFrame f = new JFrame("JList");
        Container contentPane = f.getContentPane();
        JList list1 = new JList(s);
        list1.setBorder(BorderFactory.createTitledBorder("ÄúÏ²»¶³ÔÄÄÐ©Ë®¹û£¿"));
        list1.setCellRenderer(new CellRenderer());
        
        contentPane.add(new JScrollPane(list1));
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
        new JList6();
    }
}

class CellRenderer extends JLabel implements ListCellRenderer
{
    CellRenderer()
    {
        setOpaque(true);
    }
    
    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus)
    {
        if (value != null)
        {
            setText(value.toString());
            setIcon(new ImageIcon(".\\icons\\fruit"+(index+1)+".jpg"));
        }
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }    
}

