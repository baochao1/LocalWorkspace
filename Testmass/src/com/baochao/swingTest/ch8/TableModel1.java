import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableModel1{
     
    public TableModel1() {
    
   	JFrame f = new JFrame();
   	MyTable mt=new MyTable();
   	JTable t=new JTable(mt);

   	t.setPreferredScrollableViewportSize(new Dimension(550, 30));
        JScrollPane s = new JScrollPane(t);
        f.getContentPane().add(s, BorderLayout.CENTER);
	   
        f.setTitle("JTable1");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        new TableModel1();
    }
}

class MyTable extends AbstractTableModel
{
    Object[][] p = {
        {"����", new Integer(66), 
          new Integer(32), new Integer(98), new Boolean(false),new Boolean(false)},
        {"����", new Integer(85), 
          new Integer(69), new Integer(154), new Boolean(true),new Boolean(false)},          
    };

    String[] n = {"����","����","��ѧ","�ܷ�","����","����"};

    public int getColumnCount() {
        return n.length;
    }

    public int getRowCount() {
        return p.length;
    }

    public Object getValueAt(int row, int col) {
        return p[row][col];
    }
}



