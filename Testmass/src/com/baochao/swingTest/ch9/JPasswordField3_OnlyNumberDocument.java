import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

public class JPasswordField3_OnlyNumberDocument extends PlainDocument{

	private int maxLength;
	int result;
	
	public JPasswordField3_OnlyNumberDocument(int maxLength){
		this.maxLength = maxLength;
	}
	
	public void insertString(int offset,String str,AttributeSet att) throws BadLocationException
	{
		for(int i=0;i<=9;i++){
			result = Integer.toString(i).compareTo(str);
			if (result == 0){ //是数字才处理

			  if ( getLength() + str.length() > maxLength ){
		   		Toolkit.getDefaultToolkit().beep();
			  }else{
				super.insertString(offset,str,att);
			  }	
			}
		}
	}
}