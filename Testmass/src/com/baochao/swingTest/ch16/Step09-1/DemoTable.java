import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class DemoTable extends JInternalFrame{

  public DemoTable(){
  
    super("Demo Table Structure", true, true, true, true);
    
    TableModel tm = new AbstractTableModel(){
      String data[][]={
      	{"Erick","70.0","65.2","92.4","67.6"},
      	{"Tom"  ,"80.0","75.2","82.4","87.6"},
      	{"Su"   ,"60.0","75.2","72.4","77.6"},
      	{"Jimmy","50.0","65.2","82.4","47.6"},
      	{"Jack" ,"90.0","85.2","62.4","67.6"}
      };
      String headers[] ={"","Chinese","English","Ecomonics","Math"};
      public int getColumnCount(){return headers.length;}
      public int getRowCount(){return data.length;}
      public String getColumnName(int col){return headers[col];}
      public boolean isCellEditable(int row,int col){return true;}
      public Object getValueAt(int row,int col){return data[row][col];}
      public void setValueAt(Object value,int row,int col){
      	data[row][col] = (String)value;
      	fireTableRowsUpdated(row,row);
      }      
    };//end of TableModel
    
    JTable jt = new JTable(tm);
    JScrollPane jsp = new JScrollPane(jt);

    setContentPane(jsp);
    setSize( 350, 150);
    setLocation( 150, 20);
  }//end of DemoTable()
}//end of class DemoTable