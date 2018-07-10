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
        //设定label背景颜色为不透明，这样才可以将label的背景颜色显示出来
        label.setOpaque(true);
        //设定label上字体的颜色，也就是label的前景颜色
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
        label.setText("您选择的颜色参数为：R："+color.getRed()+
                      "  G："+color.getGreen()+"  B："+color.getBlue());
    }
}