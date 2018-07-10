package com.baochao.swingTest.ch3.Box;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RigidB1 {
     
    public RigidB1() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        Box baseBox = Box.createHorizontalBox();
        contentPane.add(baseBox);
        baseBox.add(new JButton("A"));  
        baseBox.add(Box.createRigidArea(new Dimension(50,100)));
        baseBox.add(new JButton("B"));

	    f.setTitle("BoxLayout");
	    f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        RigidB1 b = new RigidB1();
        
    }
}
