package com.baochao.swingTest.ch2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JButton;


public class ErrorSwingApplet extends JApplet {

    public void init() {
        JButton button1 = new JButton("Hello Swing applet!");
        button1.setBackground(Color.green);
        getContentPane().add(button1, BorderLayout.CENTER);
    }
}
