package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo2 extends WindowAdapter implements ActionListener
{
    public EventDemo2()
    {
        JFrame f = new JFrame("EventDemo2");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("∞¥Œ“”–…˘“Ù‡∏");
        b.addActionListener(this);
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(this);
    }

    public static void main(String args[])
    {
        new EventDemo2();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
    
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}