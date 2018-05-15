import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColumnModelTest{
     
    public ColumnModelTest() {
    
   	JFrame f = new JFrame();
   	MyTable mt=new MyTable();
   	JTable t=new JTable(mt);
   	JComboBox c = new JComboBox();
   	c.addItem("Taipei");
   	c.addItem("ChiaYi");
   	c.addItem("HsinChu");
   	t.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(c));
   	t.setPreferredScrollableViewportSize(new Dimension(550, 30));
        JScrollPane s = new JScrollPane(t);
        
        f.getContentPane().add(s, BorderLayout.CENTER);
	    f.setTitle("ColumnModelTest");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        new ColumnModelTest();
    }
      
}

class MyTable extends AbstractTableModel{

        Object[][] p = {
            {"阿呆", "Taipei",new Integer(66), 
              new Integer(32), new Integer(98), new Boolean(false),new Boolean(false)},
            {"阿瓜", "ChiaYi",new Integer(85), 
              new Integer(69), new Integer(154), new Boolean(true),new Boolean(false)},          
        };

        String[] n = {"姓名", 
        	         "居住地",
                      "语文",
                      "数学",
                      "总分",
                      "及格",			         
                      "作弊"};
    
        public int getColumnCount() {
            return n.length;
        }

        public int getRowCount() {
            return p.length;
        }

        public String getColumnName(int col) {
            return n[col];
        }

        public Object getValueAt(int row, int col) {
            return p[row][col];
        }
	    public Class getColumnClass(int c) {
        	return getValueAt(0, c).getClass();
    	}
	    /*public boolean isCellEditable(int rowIndex, int columnIndex) {
		    return true;	
    	}
	    public void setValueAt(Object value, int row, int col) {
        	p[row][col] = value;
		    fireTableCellUpdated(row, col);
    	}*/
}



