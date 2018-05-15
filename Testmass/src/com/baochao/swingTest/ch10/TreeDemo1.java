package com.baochao.swingTest.ch10;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class TreeDemo1
{
    public TreeDemo1()
    {
        JFrame f = new JFrame("TreeDemo");
        Container contentPane = f.getContentPane();
        
        String[] s1 = {"��˾�ļ�","�����ż�","˽���ļ�"};
        String[] s2 = {"��������(C:)","��������(D:)","��������(E:)"};
        String[] s3 = {"��Ħվ","ְ����Ϣ","�������"};
        Hashtable hashtable1 = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        hashtable1.put("�ҵĹ��İ�",s1);
        hashtable1.put("�ҵĵ���",s2);
        hashtable1.put("�ղؼ�",hashtable2);
        hashtable2.put("��վ�б�",s3);
        JTree tree = new JTree(hashtable1);
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
    
        new TreeDemo1();
    }
}

