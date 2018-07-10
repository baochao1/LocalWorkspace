package com.baochao.swingTest.ch10;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class InitialTree
{
    public InitialTree()
    {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();
        
        JTree tree = new JTree();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tree);
        
        contentPane.add(scrollPane);
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String args[]) {
    
        new InitialTree();
    }
}