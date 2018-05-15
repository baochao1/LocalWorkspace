import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class JTextArea5 extends JFrame implements UndoableEditListener,DocumentListener{

    private UndoableEdit edit;
    private JTextArea    jta;
    private JTextArea    message;
    private JMenuItem    undoitem;
    private JMenuItem    redoitem;
   
    public JTextArea5(){
    	
    	super("JTextArea5");
    	jta = new JTextArea();
    	jta.getDocument().addUndoableEditListener(this);
    	jta.getDocument().addDocumentListener(this);

        message = new JTextArea();
        message.setEditable(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1));
        p1.setBorder(BorderFactory.createTitledBorder("Edit Area"));  
        p1.add(new JScrollPane(jta));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1));
        p2.setBorder(BorderFactory.createTitledBorder("Message"));  
        p2.add(new JScrollPane(message));        
        
    	getContentPane().setLayout(new GridLayout(2,1));
    	getContentPane().add(p1);
    	getContentPane().add(p2);
    	
    	JMenuBar bar  = new JMenuBar();
    	JMenu theMenu = new JMenu("Edit");
    	undoitem = new JMenuItem("Undo");
    	redoitem = new JMenuItem("Redo");
    	theMenu.add(undoitem);
    	theMenu.add(redoitem);
    	bar.add(theMenu);
    	updateMenuItem();
    	
    	setJMenuBar(bar);
    	setSize(300,300);
    	
    	undoitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent ev){
    			edit.undo();
    			updateMenuItem();
    			message.append("- Undo -\n");
    		}	
    	});

    	redoitem.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent ev){
    			edit.redo();
    			updateMenuItem();
    			message.append("- Redo -\n");
    		}	
    	});    	
    }//end of JTextArea5()

    public void undoableEditHappened(UndoableEditEvent ev){
    	StringBuffer buf = new StringBuffer(50);
    	edit = ev.getEdit();
    	buf.append("undoableEdit:");
    	buf.append(edit.getPresentationName());
    	buf.append("\n");
    	message.append(buf.toString());
    	updateMenuItem();
    }//end of undoableEditHappened()

    public void updateMenuItem(){
    	
    	if (edit != null){
		undoitem.setEnabled(edit.canUndo());
		redoitem.setEnabled(edit.canRedo());
		undoitem.setText(edit.getUndoPresentationName());
		redoitem.setText(edit.getRedoPresentationName());
	}else{
		undoitem.setEnabled(false);
		redoitem.setEnabled(false);
		undoitem.setText("Undo");
		redoitem.setText("Redo");
	}
    }//end of updateMenu()

    public void showDE(DocumentEvent de){
    	StringBuffer debuf = new StringBuffer(100);
    	debuf.append(de.getType());
    	debuf.append(" Offset:");
    	debuf.append(de.getOffset());
    	debuf.append(" Length:");
    	debuf.append(de.getLength());
    
    	Element Eroot = jta.getDocument().getDefaultRootElement();
    	DocumentEvent.ElementChange Echange = de.getChange(Eroot);
    	if (Echange == null){
    		debuf.append("  (No Element Change)");
    	}else{
    		debuf.append("  Element Change: index ");
    		debuf.append(Echange.getIndex());
    /*		debuf.append(" ,Added Length:");
    		debuf.append(Echange.getChildrenAdded().length);
    		debuf.append(" ,Removed Length:");
    		debuf.append(Echange.getChildrenRemoved().length);
    		debuf.append(" ,=> ");
    		debuf.append(Echange.getElement());
    */	
    	}
    	debuf.append("\n");
    	message.append(debuf.toString());
    }//end of showDE()

    public void changedUpdate(DocumentEvent de){
	    showDE(de);
    }

    public void insertUpdate(DocumentEvent de){
	showDE(de);
    }
    
    public void removeUpdate(DocumentEvent de){
	    showDE(de);
    }

    public static void main(String args[])    {

    	JFrame f = new JTextArea5();
    	f.addWindowListener(new WindowAdapter() {            
    		public void windowClosing(WindowEvent e) {                    
    			System.exit(0);            
    		}        
    	});
    	f.show();
    }//end of main()
}//end of class JTextArea5