package com.baochao.swingTest.ch3.Box;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GlueB1 {
     
    public GlueB1() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        Box baseBox = Box.createHorizontalBox();
        contentPane.add(baseBox);
        baseBox.add(new JButton("A"));  
        baseBox.add(Box.createHorizontalGlue());
        baseBox.add(new JButton("B"));

	    f.setTitle("BoxLayout");
        f.setSize(new Dimension(200,50));
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        GlueB1 b = new GlueB1();
        
    }
}
