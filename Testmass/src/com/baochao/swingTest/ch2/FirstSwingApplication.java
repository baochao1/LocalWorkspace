package com.baochao.swingTest.ch2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstSwingApplication {

    public static void main(String args[]) {
    	JFrame F = new JFrame("Swing application");
        JButton button1 = new JButton("Hello Swing application!");
        button1.setBackground(Color.green);
        F.getContentPane().add(button1, BorderLayout.CENTER);
        F.pack();
        F.show();
        F.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
