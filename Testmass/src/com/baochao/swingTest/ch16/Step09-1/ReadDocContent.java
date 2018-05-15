import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class ReadDocContent implements Runnable{

    JFrame mainframe;
    JTextPane textpane = null;
    JInternalFrame innerframe = null;
    
    JFileChooser fileChooser = null;
    Thread athread;
    
    SimpleAttributeSet attrset = new SimpleAttributeSet();
    
    public ReadDocContent(JTextPane pane,JFrame mf,JInternalFrame current){
        
        this.mainframe  = mf;
        this.textpane   = pane;
        this.innerframe = current;
                               
        fileChooser = new JFileChooser();
        
        athread = new Thread(this);        
        athread.start();             
    }//end of ReadDocContent()
            
    public void run()    {        
        File file = null;        
        int result = fileChooser.showOpenDialog(mainframe);                
        textpane.setText("");        
        if (result == JFileChooser.APPROVE_OPTION)        {            
            file = fileChooser.getSelectedFile();            
            innerframe.setTitle("您選擇的檔案名稱為："+file.getName());        
        }        
        else if(result == JFileChooser.CANCEL_OPTION)        {            
            innerframe.setTitle("您沒有選擇任何檔案");        
        }                
        
        FileInputStream inputStream;                
        if(file != null)        {            
            try{                
            inputStream = new FileInputStream(file);            
        }catch(FileNotFoundException fe){                
            innerframe.setTitle("File Not Found");                
            return;            
        }                        
        ProgressMonitorInputStream pmInputStream = new ProgressMonitorInputStream(mainframe,     //parant component
                                                                "Get File Content.....", //message                                   
                                                                inputStream);    //input stream                        
        ProgressMonitor pMonitor = pmInputStream.getProgressMonitor();            
        pMonitor.setMillisToDecideToPopup(10);            
        pMonitor.setMillisToPopup(0);
        Document docs = textpane.getDocument();       
        int readbyte;                
        try{                
            while( (readbyte = pmInputStream.read()) != -1){                    
              docs.insertString(docs.getLength(),String.valueOf((char)readbyte),attrset);                    
              try{                        
                Thread.sleep(3);                    
              }catch(InterruptedException ie){}                                        
              if(pMonitor.isCanceled()) {                        
                docs.insertString(docs.getLength(),"\n\n讀取檔案中斷！！",attrset);                    
              }                
            }            
        }catch(IOException ioe){ innerframe.setTitle("讀取檔案錯誤"); }
         catch(BadLocationException ble){
		  System.out.println("BadLocationException: "+ble);
		 }
        finally{                
          try{                    
            if(pmInputStream != null)                        
               pmInputStream.close();                
          }catch(IOException ioe2){}            
        }        
    }//end of run()
    }
}//end of ReadDocContent class