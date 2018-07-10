package com.baochao.swingTest.ch3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo {
     
    public GridLayoutDemo() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(0,3));
        contentPane.add(new JButton("first"));  
        contentPane.add(new JButton("second"));
        contentPane.add(new JButton("third"));
        contentPane.add(new JButton("fourth"));
        contentPane.add(new JButton("fifth"));
        contentPane.add(new JButton("This is the last button"));

	    f.setTitle("GridLayout");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        GridLayoutDemo b = new GridLayoutDemo();
        
    }
}
