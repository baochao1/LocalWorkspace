package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo4
{
    public EventDemo4()
    {
        JFrame f = new JFrame("EventDemo4");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("∞¥Œ“”–…˘“Ù‡∏");
        b.addActionListener(new EventHandle());
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(new EventHandle());
    }

    public static void main(String args[])
    {
        new EventDemo4();
    }
}

class EventHandle extends WindowAdapter implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
    
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
