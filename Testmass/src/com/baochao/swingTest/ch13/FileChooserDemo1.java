import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class FileChooserDemo1 implements ActionListener
{
    JFrame f = null;
    JLabel label = null;
    JTextArea textarea = null;
    JFileChooser fileChooser = null;

    public FileChooserDemo1()
    {
        f = new JFrame("FileChooser Example");
        Container contentPane = f.getContentPane();
        textarea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textarea);
        scrollPane.setPreferredSize(new Dimension(350,300));
        
        JPanel panel = new JPanel();
        JButton b1 = new JButton("�½��ļ�");
        b1.addActionListener(this);
        JButton b2 = new JButton("�洢�ļ�");
        b2.addActionListener(this);
        panel.add(b1);
        panel.add(b2);
        
        label = new JLabel(" ",JLabel.CENTER);
        
        fileChooser = new JFileChooser("D:\\");
        
        contentPane.add(label,BorderLayout.NORTH);
        contentPane.add(scrollPane,BorderLayout.CENTER);
        contentPane.add(panel,BorderLayout.SOUTH);
        
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        new FileChooserDemo1();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        File file = null;
        int result;
        
        if (e.getActionCommand().equals("�½��ļ�"))
        {
            fileChooser.setApproveButtonText("ȷ��");
            fileChooser.setDialogTitle("���ļ�");
            result = fileChooser.showOpenDialog(f);
            
            textarea.setText("");
    
            if (result == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();
                label.setText("��ѡ��򿪵��ļ�����Ϊ��"+file.getName());
            }
            else if(result == JFileChooser.CANCEL_OPTION)
            {
                label.setText("��û��ѡ���κ��ļ�");
            }
            
            FileInputStream fileInStream = null;
            
            if(file != null)
            {
                try{
                    fileInStream = new FileInputStream(file);
                }catch(FileNotFoundException fe){
                    label.setText("File Not Found");
                    return;
                }
                
                int readbyte;
        
                try{
                    while( (readbyte = fileInStream.read()) != -1)
                    {
                        textarea.append(String.valueOf((char)readbyte));
                    }
                }catch(IOException ioe){
                    label.setText("��ȡ�ļ�����");
                }
                finally{
                    try{
                        if(fileInStream != null)
                            fileInStream.close();
                    }catch(IOException ioe2){}
                }
            }
        }
        
        if (e.getActionCommand().equals("�洢�ļ�"))
        {
            result = fileChooser.showSaveDialog(f);
            file = null;
            String fileName;
        
            if (result == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();
                label.setText("��ѡ��洢���ļ�����Ϊ��"+file.getName());
            }
            else if(result == JFileChooser.CANCEL_OPTION)
            {
                label.setText("��û��ѡ���κ��ļ�");
            }
            
            FileOutputStream fileOutStream = null;
            
            if(file != null)
            {
                try{
                    fileOutStream = new FileOutputStream(file);
                }catch(FileNotFoundException fe){
                    label.setText("File Not Found");
                    return;
                }

                String content = textarea.getText();
                
                try{
                    fileOutStream.write(content.getBytes());
                }catch(IOException ioe){
                    label.setText("д���ļ�����");
                }
                finally{
                    try{
                        if(fileOutStream != null)
                            fileOutStream.close();
                    }catch(IOException ioe2){}
                }
            }
        }
    }
}
