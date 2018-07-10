import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ImageIconDemo1
{
    public static void main(String args[])
    {
        byte[] image = null;
        
        JFrame f = new JFrame("ImageIconDemo");
        Container contentPane = f.getContentPane();
        
        try{
            File file = new File(".\\icons\\visa.gif");
            int size = (int)file.length();
            FileInputStream in = new FileInputStream(file);
            image = new byte[size];
            in.read(image);
        } catch (IOException e) {
            System.err.println("File open falure:"+e.getMessage());
        }
        
        Icon icon = new ImageIcon(image);
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
        