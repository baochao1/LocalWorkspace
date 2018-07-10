package com.baochao.swingTest.ch3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutDemo {
     
    public BorderLayoutDemo() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JButton("EAST"),BorderLayout.EAST);  
        contentPane.add(new JButton("WEST"),BorderLayout.WEST);
        contentPane.add(new JButton("SOUTH"),BorderLayout.SOUTH);
        contentPane.add(new JButton("NORTH"),BorderLayout.NORTH);
        contentPane.add(new JLabel("CENTER",JLabel.CENTER),BorderLayout.CENTER);

	    f.setTitle("BorderLayout");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        BorderLayoutDemo b = new BorderLayoutDemo();
        
    }
}
