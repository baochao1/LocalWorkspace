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
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("我的公文包");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");
        root.add(node1);
        root.add(node2);
        root.add(node3);
        root.add(node4);
        
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("公司文件");
        node1.add(leafnode);
        leafnode = new DefaultMutableTreeNode("个人信件");
        node1.add(leafnode);
        leafnode = new DefaultMutableTreeNode("私人文件");
        node1.add(leafnode);
        
        leafnode = new DefaultMutableTreeNode("本机磁盘(C:)");
        node2.add(leafnode);
        leafnode = new DefaultMutableTreeNode("本机磁盘(D:)");
        node2.add(leafnode);
        leafnode = new DefaultMutableTreeNode("本机磁盘(E:)");
        node2.add(leafnode);
        
        DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("网站列表");
        node3.add(node31);
        
        leafnode = new DefaultMutableTreeNode("奇摩站");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("职棒消息");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("网络书店");
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

