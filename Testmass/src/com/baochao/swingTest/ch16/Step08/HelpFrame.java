import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;



public class HelpFrame extends JInternalFrame {
  
    public HelpFrame() {
    	//JInternalFrame("title,resize,close,MAX,MIN)
	super("Help", true, true, true,true);

	setBounds( 120, 50, 275, 260);
	HtmlPane html = new HtmlPane();
	setContentPane(html);
    }

}


class HtmlPane extends JScrollPane implements HyperlinkListener {
    JEditorPane html;

    public HtmlPane() {
	try {
	    File f = new File ("HelpDoc/english.html");
	    String s = f.getAbsolutePath();
	    s = "file:"+s;
	    URL url = new URL(s);
	    html = new JEditorPane(s);
	    html.setEditable(false);
	    html.addHyperlinkListener(this);

	    JViewport vp = getViewport();
	    vp.add(html);
	} catch (MalformedURLException e) {
	    System.out.println("Malformed URL: " + e);
	} catch (IOException e) {
	    System.out.println("IOException: " + e);
	}	
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
	if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	    linkActivated(e.getURL());
	}
    }

    protected void linkActivated(URL u) {
	Cursor c = html.getCursor();
	Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	html.setCursor(waitCursor);
	SwingUtilities.invokeLater(new PageLoader(u, c));
    }

    class PageLoader implements Runnable {
	
	    URL url;
	    Cursor cursor;
	
	    PageLoader(URL u, Cursor c) {
	      url = u;
	      cursor = c;
	    }

        public void run() {
	        if (url == null) {
		    // restore the original cursor
		        html.setCursor(cursor);
		
		        Container parent = html.getParent();
		        parent.repaint();
	        } else {
		        Document doc = html.getDocument();
		        try {
		            html.setPage(url);
		        } catch (IOException ioe) {
		            html.setDocument(doc);
		            getToolkit().beep();
		        } finally {
		            url = null;
		            SwingUtilities.invokeLater(this);
		        }
	        }
	    }
    }
}
