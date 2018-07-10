import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;

class PicsFileFilter extends FileFilter
{
    String ext;
    
    public PicsFileFilter(String ext)
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
            //表示檔案名稱不為『.xxx』與『xxx.』之型態
            String extension = fileName.substring(index+1).toLowerCase();
            if (extension.equals(ext))
                return true;
        }
        return false;
    }
    
    public String getDescription(){
        if (ext.equals("jpg"))
            return "JPG File (*.jpg)";
        if (ext.equals("gif"))
            return "GIF File (*.gif)";
        return "";
    }
}