package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo1 implements ActionListener,WindowListener
{
    public EventDemo1()
    {
        JFrame f = new JFrame("EventDemo1");
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
        new EventDemo1();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
    
    public void windowActivated(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}