/*
 * <Applet code=DialogAppletDemo.class width=300 height=100>
 * </Applet>
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DialogAppletDemo extends JApplet implements ActionListener
{
    Frame f = null;
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("������Ʒ")) {
            new LendingSystem(f);
        } else if (cmd.equals("�뿪ϵͳ")) {
            System.exit(0);
        }
    }
    public void init()                           
    {
        Container contentPane = getContentPane();
        for(Container c = this; c != null; c = c.getParent())
        {
            System.out.println("�������ƣ�"+c.getName());
            if (c instanceof Frame)
                f = (Frame)c;
        }
        JPanel buttonPanel = new JPanel();
        JButton b = new JButton("������Ʒ");
        b.addActionListener(this);
        buttonPanel.add(b);
        b = new JButton("�뿪ϵͳ");
        b.addActionListener(this);
        buttonPanel.add(b);
        
        buttonPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.blue,2),
            "������Ʒϵͳ",TitledBorder.CENTER,TitledBorder.TOP));
        
        contentPane.add(buttonPanel,BorderLayout.CENTER);
    }
}

class LendingSystem implements ActionListener
{
    JTextField staffField,objectField,borrowDateField,returnDateField,reasonField;
    JDialog dialog;
    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("ȷ��")) {
        }
        else if(cmd.equals("ȡ��")){
            dialog.dispose();
        }
    }
    
    LendingSystem(Frame f){
        dialog = new JDialog(f,"������Ʒ",true);
        GridBagConstraints c;
        int gridx,gridy,gridwidth,
            gridheight,anchor,fill,ipadx,ipady;
        double weightx,weighty;
        Insets inset;     
        
        GridBagLayout gridbag = new GridBagLayout();
        Container dialogPane = dialog.getContentPane();
        dialogPane.setLayout(gridbag);
        
        JLabel label = new JLabel("Ա����� : ");
        gridx=0;               //��0��
        gridy=0;               //��0��
        gridwidth = 1;         //ռһ��λ���
        gridheight = 1;        //ռһ��λ�߶�
        weightx = 0;           
        weighty = 0;           
        anchor = GridBagConstraints.CENTER; 
        fill = GridBagConstraints.BOTH;     
        inset = new Insets(0,0,0,0);      
        ipadx = 0;                        
        ipady = 0;                        
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label); 
        
        label = new JLabel("�������� : ");
        gridx=3;
        gridy=0;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("��������: ");
        gridx=0;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("�黹����: ");
        gridx=3;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("����ԭ�� : ");
        gridx=0;
        gridy=2;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        staffField = new JTextField();
        gridx=1;
        gridy=0;
        gridwidth = 2;
        gridheight = 1;
        weightx = 1;
        weighty = 0;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(staffField,c);
        dialogPane.add(staffField);
        
        objectField = new JTextField();
        gridx=4;
        gridy=0;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(objectField,c);
        dialogPane.add(objectField);
        
        borrowDateField = new JTextField();
        gridx=1;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(borrowDateField,c);
        dialogPane.add(borrowDateField);
        
        returnDateField = new JTextField();
        gridx=4;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(returnDateField,c);
        dialogPane.add(returnDateField);
        
        reasonField = new JTextField();
        gridx=1;
        gridy=2;
        gridwidth = 5;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(reasonField,c);
        dialogPane.add(reasonField);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        JButton b = new JButton("ȷ��");
        panel.add(b);
        b = new JButton("ȡ��");
        b.addActionListener(this);
        panel.add(b);
        
        gridx=0;
        gridy=3;
        gridwidth = 6;
        weightx = 1;
        weighty = 1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel,c);
        dialogPane.add(panel);
        
        dialog.setBounds(200,150,400,130);
        dialog.show();
    }
}

