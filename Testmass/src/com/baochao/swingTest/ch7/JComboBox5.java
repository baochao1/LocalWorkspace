import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox5
{
    String[] s = {"Î÷¹Ï","Æ»¹û","²ÝÝ®","Ïã½¶","ÆÏÌÑ"};
    ImageIcon[] icons = new ImageIcon[5];;
    
    public JComboBox5()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        ItemObj[] obj = new ItemObj[5];
        
        for(int i=0; i < 5; i++)
        {
            icons[i] = new ImageIcon(".\\icons\\fruit"+(i+1)+".jpg");
            obj[i] = new ItemObj(s[i],icons[i]);
        }
        
        JComboBox combo = new JComboBox(obj);
        combo.setBorder(BorderFactory.createTitledBorder("ÄúÏ²»¶³ÔÄÄÐ©Ë®¹û£¿"));
        combo.setRenderer(new ACellRenderer());
        combo.setMaximumRowCount(3);
        
        contentPane.add(combo);
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
        new JComboBox5();
    }
}

class ItemObj
{
    String name;
    ImageIcon icon;
    
    public ItemObj(String name, ImageIcon icon){
        this.name = name;
        this.icon = icon;
    }
}
    
class ACellRenderer extends JLabel implements ListCellRenderer
{
    ACellRenderer()
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
            setText(((ItemObj)value).name);
            setIcon(((ItemObj)value).icon);
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

