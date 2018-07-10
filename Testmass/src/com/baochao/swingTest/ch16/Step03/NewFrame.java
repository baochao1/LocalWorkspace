import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;


public class NewFrame extends JInternalFrame {
  
    static int Count = 0;
    static final int offset = 30;

    public NewFrame() {
	super("", true, true, true, true);
        setTitle("Untitled Document " + (Count++));

	JPanel top = new JPanel();
	top.setBorder(new EmptyBorder(10, 10, 10, 10));
	top.setLayout(new BorderLayout());

	JTextArea content = new JTextArea( 10, 30 );
	content.setBorder( new EmptyBorder(0,5 ,0, 5) );
	content.setLineWrap(true);

	JScrollPane textScroller = new JScrollPane(content, 
						   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
						   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	top.add( textScroller, BorderLayout.CENTER);
	

	setContentPane(top);
	pack();
	setLocation( offset * Count, offset *Count);
    }//end of NewFrame()
}//end of NewFrame class