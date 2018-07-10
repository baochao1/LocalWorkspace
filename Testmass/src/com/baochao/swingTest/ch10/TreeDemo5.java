package com.baochao.swingTest.ch10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeDemo5 implements TreeModelListener
{
    JLabel label = null;
    String nodeName = null; //ԭ�нڵ�����
    
    public TreeDemo5()
    {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("�ļ���");
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
        
        leafnode = new DefaultMutableTreeNode("������վ");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("������Ϣ");
        node31.add(leafnode);
        leafnode = new DefaultMutableTreeNode("�������");
        node31.add(leafnode);
        
        JTree tree = new JTree(root);
        tree.setEditable(true);
        tree.addMouseListener(new MouseHandle());
        DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
        treeModel.addTreeModelListener(this);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tree);
        
        label = new JLabel("��������Ϊ: ");
        contentPane.add(scrollPane,BorderLayout.CENTER);
        contentPane.add(label,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
    
    public void treeNodesChanged(TreeModelEvent e) {
        
        TreePath treePath = e.getTreePath();
        System.out.println(treePath);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)treePath.getLastPathComponent();
        try {
            int[] index = e.getChildIndices();
            node = (DefaultMutableTreeNode)node.getChildAt(index[0]);
        } catch (NullPointerException exc) {}
        label.setText(nodeName+"��������Ϊ: "+(String)node.getUserObject());
    }
    public void treeNodesInserted(TreeModelEvent e) {
    }
    public void treeNodesRemoved(TreeModelEvent e) {
    }
    public void treeStructureChanged(TreeModelEvent e) {
    }

    public static void main(String args[]) {
    
        new TreeDemo5();
    }
    
    class MouseHandle extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) 
        {
            try{
              JTree tree = (JTree)e.getSource();
        
              int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
              TreePath treepath = tree.getPathForRow(rowLocation);
              TreeNode treenode = (TreeNode) treepath.getLastPathComponent(); 
        
              nodeName = treenode.toString();
            }catch(NullPointerException ne){}
        }
    }
}


