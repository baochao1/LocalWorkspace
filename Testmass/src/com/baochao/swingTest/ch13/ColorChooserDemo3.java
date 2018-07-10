import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.*;
import javax.swing.event.*;

public class ColorChooserDemo3 implements ChangeListener
{
    JFrame f = null;
    JLabel label = null;
    JColorChooser colorChooser = null;
    
    public ColorChooserDemo3()
    {
        f = new JFrame("ColorChooser Example");         
        Container contentPane = f.getContentPane();
        
        label = new JLabel(" ",JLabel.CENTER);
        //�趨label������ɫΪ��͸���������ſ��Խ�label�ı�����ɫ��ʾ����
        label.setOpaque(true);
        //�趨label���������ɫ��Ҳ����label��ǰ����ɫ
        label.setForeground(Color.black);
        
        JPanel panel = new JPanel();
        colorChooser = new JColorChooser();
        
        panel.add(colorChooser);
        ColorSelectionModel selectModel = 
                                      colorChooser.getSelectionModel();
        selectModel.addChangeListener(this);
        
        contentPane.add(label,BorderLayout.NORTH);
        contentPane.add(panel,BorderLayout.CENTER);
        
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] arg)
    {
        new ColorChooserDemo3();
    }
    
    public void stateChanged(ChangeEvent e)
    {
        Color color = colorChooser.getColor();
        label.setBackground(color);
        label.setText("��ѡ�����ɫ����Ϊ��R��"+color.getRed()+
                      "  G��"+color.getGreen()+"  B��"+color.getBlue());
    }
}