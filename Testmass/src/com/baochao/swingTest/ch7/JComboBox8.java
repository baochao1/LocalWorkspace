import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBox8 implements ItemListener,ActionListener
{
    String[] fontsize = {"12","14","16","18","20","22","24","26","28"};
    String defaultMessage = "��ѡ���ֱ���������ִ�С��";
    Font font = null;
    JComboBox combo = null;
    JLabel label = null;
    
    public JComboBox8()
    {
        JFrame f = new JFrame("JComboBox");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));
        label = new JLabel("Swing",JLabel.CENTER);
        font = new Font("SansSerif",Font.PLAIN,12);
        label.setFont(font);
        
        combo = new JComboBox(fontsize);
        combo.setBorder(BorderFactory.createTitledBorder("��ѡ����Ҫ�����ִ�С"));
        combo.setEditable(true);
        ComboBoxEditor editor = combo.getEditor();
        combo.configureEditor(editor, defaultMessage);
        combo.addItemListener(this);
        combo.addActionListener(this);
        
        contentPane.add(label);
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
        new JComboBox8();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        boolean isaddItem = true;
        int fontsize = 0;
        String tmp = (String)combo.getSelectedItem();
        
        try
        {
            fontsize = Integer.parseInt(tmp);
            
            for (int i=0; i< combo.getItemCount();i++)
            {
                if (combo.getItemAt(i).equals(tmp))
                {
                    isaddItem = false;
                    break;
                }
            }
            
            if (isaddItem)
            {
                combo.insertItemAt(tmp,0);
            }
            
            font = new Font("SansSerif",Font.PLAIN,fontsize);
            label.setFont(font);
            
        }catch(NumberFormatException ne){
            combo.getEditor().setItem("�������ֵ��������ֵ�����������룡");
        }
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            int fontsize = 0;
            try
            {
                fontsize = Integer.parseInt((String)e.getItem());
                label.setText("Swing Ŀǰ�����С��"+fontsize);
            }catch(NumberFormatException ne){
            }
        }
    }
}


