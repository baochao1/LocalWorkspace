import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox7
{
    String[] fontsize = {"12","14","16","18","20","22","24","26","28"};
    String defaultMessage = "��ѡ���ֱ���������ִ�С��";
    
    public JComboBox7()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        
        JComboBox combo = new JComboBox(fontsize);
        combo.setBorder(BorderFactory.createTitledBorder("��ѡ����Ҫ�����ִ�С"));
        combo.setEditable(true);
        ComboBoxEditor editor = combo.getEditor();
        combo.configureEditor(editor, defaultMessage);
        
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
        new JComboBox7();
    }
}


