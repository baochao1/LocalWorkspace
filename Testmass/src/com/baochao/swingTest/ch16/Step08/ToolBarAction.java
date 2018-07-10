import javax.swing.*;
import java.awt.event.*;

public class ToolBarAction extends AbstractAction{

  public ToolBarAction(String name,Icon icon){
    super(name,icon);
  }

  public void actionPerformed(ActionEvent e){
    try{
      //textPane.getStyledDocument().insertString(0,"Action ["+e.getActionCommand(),null);
      System.out.println("cmd: "+e.getActionCommand());
    }catch(Exception ex){}
  }
}