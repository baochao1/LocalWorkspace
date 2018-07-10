package com.baochao.swingTest.ch4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseDemo1 extends WindowAdapter implements MouseListener
{
    JFrame f = null;
    JButton b1 = null;
    JLabel label = null;
    
    public MouseDemo1()
    {
        f = new JFrame("MouseDemo1");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));
        b1 = new JButton("按钮");
        label = new JLabel("起始状态，还没鼠标事件",JLabel.CENTER);
        b1.addMouseListener(this);
        contentPane.add(label);
        contentPane.add(b1);
        f.pack();
        f.show();
        f.addWindowListener(this);
    }

    public void mousePressed(MouseEvent e) {
       label.setText("您已经压下鼠标按钮");
    }

    public void mouseReleased(MouseEvent e) {
       label.setText("您已经放开鼠标按钮");
    }

    public void mouseEntered(MouseEvent e) {
       label.setText("鼠标光标进入按钮");
    }

    public void mouseExited(MouseEvent e) {
       label.setText("鼠标光标离开按钮");
    }

    public void mouseClicked(MouseEvent e) {
       label.setText("您已经按下鼠标按钮");
    }
    
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    
    public static void main(String args[])
    {
        new MouseDemo1();
    }
}


