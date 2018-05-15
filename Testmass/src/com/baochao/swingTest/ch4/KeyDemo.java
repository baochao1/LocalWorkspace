package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyDemo extends KeyAdapter implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    JTextField tField = null;
    String keyString = ""; 
    
    public KeyDemo()
    {
        f = new JFrame("KeyEventDemo");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(3,1));
        label = new JLabel();
        tField = new JTextField();
        tField.requestFocus();
        tField.addKeyListener(this);
        JButton b = new JButton("Çå³ý");
        b.addActionListener(this);
        contentPane.add(label);
        contentPane.add(tField);
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }});
    }
    
    public void actionPerformed(ActionEvent e)
    {
        keyString = "";
        label.setText("");
        tField.setText("");
        tField.requestFocus();
    }
    
    public void keyTyped(KeyEvent e)
    {
        char c = e.getKeyChar();
        //System.out.println(e.getModifiers());
        if(c=='o')
        {
           JFrame newF = new JFrame("ÐÂ´°¿Ú");
           newF.setSize(200,200);
           newF.show();
       }
        keyString = keyString + c;
        label.setText(keyString);
    }
    
    public static void main(String args[])
    {
        new KeyDemo();
    }
    
} 

