import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

public class JTextField3_FixedLengthDocument extends PlainDocument{

	private int maxLength;
	
	public JTextField3_FixedLengthDocument(int maxLength){
		this.maxLength = maxLength;
	}
	
	public void insertString(int offset,String str,AttributeSet att) throws BadLocationException
	{
		if ( getLength() + str.length() > maxLength ){
			Toolkit.getDefaultToolkit().beep();
		}else{
			super.insertString(offset,str,att);
		}
	}
}