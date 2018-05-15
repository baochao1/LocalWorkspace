package com.baochao.swingTest.ch3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NonLayoutDemo {
     
    public NonLayoutDemo() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        contentPane.setLayout(null);
        JButton b1 = new JButton("first");
        contentPane.add(b1);
        JButton b2 = new JButton("second");
        contentPane.add(b2);

        b1.setBounds(15, 10, 80, 30);
        b2.setBounds(80, 50, 90, 40);

	    f.setTitle("NoLayout");
        f.setSize(200,130);
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        NonLayoutDemo b = new NonLayoutDemo();
        
    }
}
