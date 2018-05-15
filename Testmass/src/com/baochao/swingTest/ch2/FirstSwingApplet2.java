package com.baochao.swingTest.ch2;

/*
<APPLET
    CODE=FirstSwingApplet2.class
    WIDTH=200
    HEIGHT=100 >
</APPLET>
*/

import javax.swing.*;
import java.awt.*;

public class FirstSwingApplet2 extends JApplet {

    public void init() {
        JButton button1 = new JButton("Hello Swing applet!");
        button1.setBackground(Color.green);
        getContentPane().add(button1, BorderLayout.CENTER);
    }
}
