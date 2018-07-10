import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DialogDemo implements ActionListener
{
    JFrame f = null;
    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("借用物品")) {
            new LendingSystem(f);
        } else if (cmd.equals("离开系统")) {
            System.exit(0);
        }
    }
    public DialogDemo()                           
    {
        f = new JFrame("JDialog Example");
        Container contentPane = f.getContentPane();
        JPanel buttonPanel = new JPanel();
        JButton b = new JButton("借用物品");
        b.addActionListener(this);
        buttonPanel.add(b);
        b = new JButton("离开系统");
        b.addActionListener(this);
        buttonPanel.add(b);
        
        buttonPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.blue,2),
            "借用物品系统",TitledBorder.CENTER,TitledBorder.TOP));
        
        contentPane.add(buttonPanel,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args)
    {
        new DialogDemo();
    }
}

class LendingSystem implements ActionListener
{
    JTextField staffField,objectField,borrowDateField,returnDateField,reasonField;
    JDialog dialog;
    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("确定")) {
        }
        else if(cmd.equals("取消")){
            dialog.dispose();
        }
    }
    
    LendingSystem(JFrame f){
        dialog = new JDialog(f,"借用物品",true);
        GridBagConstraints c;
        int gridx,gridy,gridwidth,
            gridheight,anchor,fill,ipadx,ipady;
        double weightx,weighty;
        Insets inset;     
        
        GridBagLayout gridbag = new GridBagLayout();
        Container dialogPane = dialog.getContentPane();
        dialogPane.setLayout(gridbag);
        
        JLabel label = new JLabel("员工编号 : ");
        gridx=0;               //第0列
        gridy=0;               //第0行
        gridwidth = 1;         //占一单位宽度
        gridheight = 1;        //占一单位高度
        weightx = 0;           //窗口增大时组件宽度增大比率0
        weighty = 0;           //窗口增大时组件高度增大比率0
        anchor = GridBagConstraints.CENTER; //容器大于组件size时将组件置于容器中央
        fill = GridBagConstraints.BOTH;     //窗口拉大时会填满水平与垂直空间
        inset = new Insets(0,0,0,0);        //组件间间距
        ipadx = 0;                          //组件内水平宽度
        ipady = 0;                          //组件内垂直高度
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label); 
        
        label = new JLabel("借用器具 : ");
        gridx=3;
        gridy=0;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("借用日期: ");
        gridx=0;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("归还日期: ");
        gridx=3;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(label,c);
        dialogPane.add(label);
        
        label = new JLabel("借用原因 : ");
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
        JButton b = new JButton("确定");
        panel.add(b);
        b = new JButton("取消");
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

