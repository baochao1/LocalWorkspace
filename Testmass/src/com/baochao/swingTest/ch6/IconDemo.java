import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IconDemo implements Icon
{
    int height = 50;
    int width = 70;
    
    public int getIconHeight()
    {
        return height;
    }
    
    public int getIconWidth()
    {
        return width;
    }
    
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
        g.setColor(Color.blue);
    }
        
    public static void main(String args[])
    {
        JFrame f = new JFrame("IconDemo");
        Container contentPane = f.getContentPane();
        
        Icon icon = new IconDemo();
        JLabel label = new JLabel(icon,JLabel.CENTER);
        contentPane.add(label);
        f.pack();
        f.show();
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
}
        