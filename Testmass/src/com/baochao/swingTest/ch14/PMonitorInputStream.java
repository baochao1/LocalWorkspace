import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class PMonitorInputStream implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    JTextArea textarea = null;
    JFileChooser fileChooser = null;

    public PMonitorInputStream()
    {
        f = new JFrame("ProgressMonitorInputStream Example");
        Container contentPane = f.getContentPane();
        textarea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textarea);
        scrollPane.setPreferredSize(new Dimension(350,350));
        JButton b = new JButton("��ȡ�ļ�");
        b.addActionListener(this);
        label = new JLabel(" ",JLabel.CENTER);
        
        fileChooser = new JFileChooser();
        
        contentPane.add(label,BorderLayout.NORTH);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        contentPane.add(b,BorderLayout.SOUTH);
        
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        new PMonitorInputStream();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        File file = null;
        int result = fileChooser.showOpenDialog(f);
        
        textarea.setText("");

        if (result == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();
            label.setText("��ѡ����ļ�����Ϊ��"+file.getName());
        }
        else if(result == JFileChooser.CANCEL_OPTION)
        {
            label.setText("��û��ѡ���κ��ļ�");
        }
        
        FileInputStream inputStream;
        
        if(file != null)
        {
            try{
                inputStream = new FileInputStream(file);
            }catch(FileNotFoundException fe){
                label.setText("File Not Found");
                return;
            }
            
            ProgressMonitorInputStream pmInputStream = new 
                ProgressMonitorInputStream(f,      //parant component
                                   "Get File Content.....", //message
                                   inputStream);       //input stream
            
            ProgressMonitor pMonitor = 
                pmInputStream.getProgressMonitor();
            pMonitor.setMillisToDecideToPopup(10);
            pMonitor.setMillisToPopup(0);
            int readbyte;
    
            try{
                while( (readbyte = pmInputStream.read()) != -1)
                {
                    textarea.append(String.valueOf((char)readbyte));

                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException ie){}
                    
                    if(pMonitor.isCanceled())
                    {
                        textarea.append("\n\n��ȡ�ļ��жϣ���");
                    }
                }
            }catch(IOException ioe){
                label.setText("��ȡ�ļ�����");
            }
            finally{
                try{
                    if(pmInputStream != null)
                        pmInputStream.close();
                }catch(IOException ioe2){}
            }
        }
    }
}


