import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JLayeredPane2 extends JFrame
{
    public JLayeredPane2()
    {
        super("JLayeredPane");
        Integer[] layerConstants = { new Integer(-100),
        JLayeredPane.PALETTE_LAYER, new Integer(101), 
        JLayeredPane.MODAL_LAYER, new Integer(201),
        JLayeredPane.POPUP_LAYER, JLayeredPane.DRAG_LAYER };
        
        Color[] colors = { Color.red, Color.blue,
                                Color.magenta,Color.cyan ,
                                Color.yellow,Color.green,
                                Color.pink };
                                    
        Point position = new Point(10,10);
        JButton[] button = new JButton[7];
        JLayeredPane layeredPane = getLayeredPane();
        
        for (int i=0 ; i<7; i++)
        {
            button[i] = createButton("Button "+(i+1),colors[i],position);
            position.x = position.x+20;
            position.y = position.y+20;
            layeredPane.add(button[i],layerConstants[i]);
        }
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2,2));
        JButton b1 = new JButton("«ö¶s¤@");
        contentPane.add(b1);
        JButton b2 = new JButton("«ö¶s¤G");
        contentPane.add(b2);
        JButton b3 = new JButton("«ö¶s¤T");
        contentPane.add(b3);
        JButton b4 = new JButton("«ö¶s¥|");
        contentPane.add(b4);
        
        System.out.println("Content Pane¼h¯Å­È¬°¡G"+layeredPane.getLayer(contentPane));
        System.out.println("«ö¶s¤@¼h¯Å­È¬°¡G"+layeredPane.getLayer(b1));
        System.out.println("«ö¶s¤G¼h¯Å­È¬°¡G"+layeredPane.getLayer(b2));
        System.out.println("Button1¼h¯Å­È¬°¡G"+layeredPane.getLayer(button[0]));
        System.out.println("Button2¼h¯Å­È¬°¡G"+layeredPane.getLayer(button[1]));
        System.out.println("Button3¼h¯Å­È¬°¡G"+layeredPane.getLayer(button[2]));

        setSize(new Dimension(280, 280));
        show();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }
    
    public JButton createButton(String content, 
                              Color color,
                              Point position)
   {
        JButton button = new JButton(content);
        button.setVerticalAlignment(JButton.TOP);
        button.setBackground(color);
        button.setForeground(Color.black);
        button.setOpaque(true);
        button.setBounds(position.x, position.y, 100, 100);
        return button;
    }
    
    public static void main(String[] arg)
    {
        new JLayeredPane2();
    }
}