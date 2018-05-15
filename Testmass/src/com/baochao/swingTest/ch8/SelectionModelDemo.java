import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SelectionModelDemo implements ActionListener,ListSelectionListener
{
    JTable table = null;
    ListSelectionModel selectionMode = null;
    JLabel label = null;
        
    public SelectionModelDemo()
    {
       	JFrame f = new JFrame();
       	String[] name = {"�ֶ� 1","�ֶ� 2","�ֶ� 3","�ֶ� 4","�ֶ� 5"};
       	String[][] data = new String[5][5];
       	int value =1;
       	for(int i=0; i<data.length; i++)
       	{
       	    for(int j=0; j<data[i].length ; j++)
       	        data[i][j] = String.valueOf(value++);
        }
         	        
       	table=new JTable(data,name);
       	table.setPreferredScrollableViewportSize(new Dimension(400, 80));
       	table.setCellSelectionEnabled(true);
       	selectionMode = table.getSelectionModel();
       	selectionMode.addListSelectionListener(this);
        JScrollPane s = new JScrollPane(table);
        
        JPanel panel = new JPanel();
        JButton b = new JButton("��һѡ��");
        panel.add(b);
        b.addActionListener(this);
        b = new JButton("��������ѡ��");
        panel.add(b);
        b.addActionListener(this);
        b = new JButton("����ѡ��");
        panel.add(b);
        b.addActionListener(this);
        
        label = new JLabel("��ѡȡ��");
        
        Container contentPane = f.getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(s, BorderLayout.CENTER);
        contentPane.add(label, BorderLayout.SOUTH);
        
	    f.setTitle("SelectionModelDemo");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("��һѡ��"))
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(e.getActionCommand().equals("��������ѡ��"))
            selectionMode.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if(e.getActionCommand().equals("����ѡ��"))
            selectionMode.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.revalidate();
    }
    
    public void valueChanged(ListSelectionEvent e1)
    {
        String tempString = "";
        int[] rows = table.getSelectedRows();
        int[] columns = table.getSelectedColumns();

        for (int i=0; i<rows.length; i++) {        
            for (int j=0; j<columns.length; j++)
                tempString = tempString+" "+(String)table.getValueAt(rows[i], columns[j]);      
        }
        label.setText("��ѡȡ��"+tempString);
    }

    public static void main(String args[]) {
        new SelectionModelDemo();
    }
}

