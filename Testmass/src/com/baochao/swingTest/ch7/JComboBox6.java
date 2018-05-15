import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox6
{
    String[] s = {"Î÷¹Ï","Æ»¹û","²ÝÝ®","Ïã½¶","ÆÏÌÑ"};
    ImageIcon[] icons = new ImageIcon[5];;
    
    public JComboBox6()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        for(int i=0; i < 5; i++)
        {
            icons[i] = new ImageIcon(".\\icons\\fruit"+(i+1)+".jpg");
        }
        ComboBoxModel mode = new AModel();
        JComboBox combo = new JComboBox(mode);
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
        new JComboBox6();
    }
    
    class AModel extends DefaultComboBoxModel
    {
        AModel()
        {
            for(int i = 0; i < s.length; i++) {
                ItemObj obj = new ItemObj(s[i],icons[i]);
                addElement(obj);
            }
            
        }
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

