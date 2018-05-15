package com.baochao.swingTest.ch3.Box;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FillerB1 {
     
    public FillerB1() {
    
    	JFrame f = new JFrame();
    	
        Container contentPane = f.getContentPane();
        Box baseBox = Box.createHorizontalBox();
        contentPane.add(baseBox);
        baseBox.add(new JButton("A"));  
        baseBox.add(new Box.Filler(new Dimension(50,50),
                                   new Dimension(50,100),
                                   new Dimension(50,200)));
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
    
        FillerB1 b = new FillerB1();
        
    }
}
