package com.baochao.swingTest.ch10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class TreeDemo2
{
    public TreeDemo2()
    {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("�ҵĹ��İ�");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("�ҵĵ���");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("�ղؼ�");
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");
        root.add(node1);
        root.add(node2);
        root.add(node3);
        root.add(node4);
        
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("��˾�ļ�");
        node1.add(leafnode);
        leafnode = new DefaultMutableTreeNode("�����ż�");
        node1.add(leafnode);
        leafnode = new DefaultMutableTreeNode("˽���ļ�");
        node1.add(leafnode);
        
        leafnode = new DefaultMutableTreeNode("��������(C:)");
        node2.add(leafnode);
        leafnode = new DefaultMutableTreeNode("��������(D:)");
        node2.add(leafnode);
        leafnode = new DefaultMutableTreeNode("��������(E:)");
        node2.add(leafnode);
        
        DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("��վ�б�");
        node3.add(node31);
        
        leafnode = new DefaultMutableTreeNode("��Ħվ");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("ְ����Ϣ");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("�������");
        node31.add(leafnode);
        
        JTree tree = new JTree(root);
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
    
        new TreeDemo2();
    }
}

