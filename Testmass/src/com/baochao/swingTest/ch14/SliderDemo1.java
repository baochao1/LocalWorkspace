import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SliderDemo1 implements ChangeListener
{
    JFrame f = null;
    JSlider slider1;
    JSlider slider2;
    JSlider slider3;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    
    public SliderDemo1()                           
    {
        f = new JFrame("JSlider Example");
        Container contentPane = f.getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,1));
        slider1 = new JSlider();
        label1 = new JLabel("Ŀǰ�̶ȣ�"+slider1.getValue());
        panel1.add(label1);
        panel1.add(slider1);
        panel1.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 1",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        slider2 = new JSlider(JSlider.HORIZONTAL);
        slider2.setMinimum(0);
        slider2.setMaximum(100);
        slider2.setValue(30);
        slider2.setExtent(50);
        label2 = new JLabel("Ŀǰ�̶ȣ�"+slider2.getValue());
        panel2.add(label2);
        panel2.add(slider2);
        panel2.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 2",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));
        slider3 = new JSlider(20,80);
        slider3.setOrientation(JSlider.VERTICAL);
        label3 = new JLabel("Ŀǰ�̶ȣ�"+slider3.getValue());
        panel3.add(label3);
        panel3.add(slider3);
        panel3.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(),"Slider 3",TitledBorder.LEFT,
        TitledBorder.TOP));
        
        slider1.addChangeListener(this);
        slider2.addChangeListener(this);
        slider3.addChangeListener(this);
        
        panel1.setPreferredSize(new Dimension(300,100));
        panel2.setPreferredSize(new Dimension(300,100));
        panel3.setPreferredSize(new Dimension(150,200));
        
        GridBagConstraints c;
        int gridx,gridy,gridwidth,
            gridheight,anchor,fill,ipadx,ipady;
        double weightx,weighty;
        Insets inset;     
        
        GridBagLayout gridbag = new GridBagLayout();
        contentPane.setLayout(gridbag);
        
        gridx=0;               //��0��
                gridy=0;               //��0��
                gridwidth = 2;         //ռ����λ���
                gridheight = 1;        //ռһ��λ�߶�
                weightx = 0;           //��������ʱ�������������0
                weighty = 0;           //��������ʱ����߶��������0
                anchor = GridBagConstraints.CENTER; //�����������sizeʱ�����
//������������
                fill = GridBagConstraints.BOTH;     //��������ʱ������ˮƽ�봹
//ֱ�ռ�
                inset = new Insets(0,0,0,0);        //�������
                ipadx = 0;                          //�����ˮƽ���
                ipady = 0;                          //����ڴ�ֱ�߶�
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel1,c);
        contentPane.add(panel1); 
        
        gridx=0;
        gridy=1;
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel2,c);
        contentPane.add(panel2);
        
        gridx=2;
        gridy=0;
        gridwidth = 1;         //ռһ��λ���
        gridheight = 2;        //ռ����λ�߶�
        c = new GridBagConstraints(gridx,gridy,gridwidth,gridheight,
            weightx,weighty,anchor,fill,inset,ipadx,ipady);
        gridbag.setConstraints(panel3,c);
        contentPane.add(panel3);
        
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
        new SliderDemo1();
    }
    
    public void stateChanged(ChangeEvent e)
    {
        if ((JSlider)e.getSource() == slider1)
            label1.setText("Ŀǰ�̶ȣ�"+slider1.getValue());
        if ((JSlider)e.getSource() == slider2)
            label2.setText("Ŀǰ�̶ȣ�"+slider2.getValue());
        if ((JSlider)e.getSource() == slider3)
            label3.setText("Ŀǰ�̶ȣ�"+slider3.getValue());
    }
}

