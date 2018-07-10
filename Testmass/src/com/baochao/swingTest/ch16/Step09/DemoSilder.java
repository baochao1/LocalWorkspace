import javax.swing.*;
import java.awt.*;

public class DemoSilder extends JDialog {

  public DemoSilder(JFrame f) {
    super(f, "Demo Silder", true);
    setBounds(200,200,300,100);
      
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());      
    //JLabel JL = new JLabel("Current Value: ");
    //panel.add(JL,BorderLayout.NORTH);

    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
    slider.setMinorTickSpacing(5);
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    slider.setLabelTable(slider.createStandardLabels(10));
    panel.add(slider,BorderLayout.SOUTH);
    
    getContentPane().add(panel);
    show();
  }//end of DemoSilder()
}//end of class DemoSilder
	