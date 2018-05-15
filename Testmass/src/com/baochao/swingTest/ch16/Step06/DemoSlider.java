import javax.swing.*;
import java.awt.*;

public class DemoSlider extends JDialog {

  public DemoSlider(JFrame f) {
    super(f, "Demo Slider", true);
    setBounds(200,200,300,100);
      
    JPanel JPc = new JPanel();
    JPc.setLayout(new BorderLayout());      
    //JLabel JL = new JLabel("Current Value: ");
    //JPc.add(JL,BorderLayout.NORTH);

    JSlider JS = new JSlider(JSlider.HORIZONTAL,0,100,0);
    JS.setMinorTickSpacing(5);
    JS.setMajorTickSpacing(10);
    JS.setPaintTicks(true);
    JS.setPaintLabels(true);
    JS.setLabelTable(JS.createStandardLabels(10));
    JPc.add(JS,BorderLayout.SOUTH);
    
    getContentPane().add(JPc);
  }//end of DemoSlider()
}//end of class DemoSlider
	