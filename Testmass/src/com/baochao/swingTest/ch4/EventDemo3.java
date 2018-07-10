package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo3
{
    public EventDemo3()
    {
        JFrame f = new JFrame("EventDemo3");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("∞¥Œ“”–…˘“Ù‡∏");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
            }});
        contentPane.add(b);
        f.pack();
        f.show();
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }});
    }

    public static void main(String args[])
    {
        new EventDemo3();
    }
}