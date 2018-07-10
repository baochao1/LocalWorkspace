package com.baochao.swingTest.ch2;

import javax.swing.*;
import java.awt.*;

public class FirstSwingApplet extends JApplet {

    public void init() {
        JButton button1 = new JButton("Hello Swing applet!");
        button1.setBackground(Color.green);
        getContentPane().add(button1, BorderLayout.CENTER);
    }
}
