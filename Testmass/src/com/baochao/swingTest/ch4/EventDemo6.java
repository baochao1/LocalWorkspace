package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo6 extends WindowAdapter implements ActionListener
{
    JButton b1 = null;
    JButton b2 = null;
    
    public EventDemo6()
    {
        JFrame f = new JFrame("EventDemo6");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1,2));
        b1 = new JButton("�����������");
        b2 = new JButton("���ҿɿ��´���");
        b1.addActionListener(this);
        b2.addActionListener(this);
        contentPane.add(b1);
        contentPane.add(b2);
        f.pack();
        f.show();
        f.addWindowListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if((e.getActionCommand()).equals("�����������")) 
            Toolkit.getDefaultToolkit().beep();
        if((e.getActionCommand()).equals("���ҿɿ��´���"))
        {
            JFrame newF = new JFrame("�´���");
            newF.setSize(200,200);
            newF.show();
        } 
    }
    
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    
    public static void main(String args[])
    {
        new EventDemo6();
    }
}

