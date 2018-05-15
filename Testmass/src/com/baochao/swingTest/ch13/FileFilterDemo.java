import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileFilterDemo implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    JFileChooser fileChooser = null;
    
    public FileFilterDemo() 
    {
        f = new JFrame("FileFilter Demo");
        Container contentPane = f.getContentPane();
        
        JButton b = new JButton("打开文件");
        b.addActionListener(this);
        
        label = new JLabel(" ",JLabel.CENTER);
        label.setPreferredSize(new Dimension(150,30));
        contentPane.add(label,BorderLayout.CENTER);
        contentPane.add(b,BorderLayout.SOUTH);
        
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
        new FileFilterDemo();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        fileChooser = new JFileChooser("c:\\winnt");
        fileChooser.addChoosableFileFilter(new JAVAFileFilter("class"));
        fileChooser.addChoosableFileFilter(new JAVAFileFilter("java"));
        int result = fileChooser.showOpenDialog(f);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            label.setText("您选择了："+file.getName()+"文件");
        }else if (result == fileChooser.CANCEL_OPTION){
            label.setText("您没有选择文件");
        }
    }
}

class JAVAFileFilter extends FileFilter
{
    String ext;
    
    public JAVAFileFilter(String ext)
    {
        this.ext = ext;
    }
    
    public boolean accept(File file)
    {
        if (file.isDirectory())
            return true;
        
        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');

        if (index > 0 && index < fileName.length()-1) {
            String extension = fileName.substring(index+1).toLowerCase();
            if (extension.equals(ext))
                return true;
        }
        return false;
    }
    
    public String getDescription(){
        if (ext.equals("java"))
            return "JAVA Source File (*.java)";
        if (ext.equals("class"))
            return "JAVA Class File (*.class)";
        return "";
    }
}




