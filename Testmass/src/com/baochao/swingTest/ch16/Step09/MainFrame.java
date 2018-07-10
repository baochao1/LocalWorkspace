import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.undo.*;

public class MainFrame
{ 
    JDesktopPane desktop;
    JFrame topFrame;
    JMenuBar menuBar;
    JPopupMenu popupMenu;
    
    public MainFrame()
    {
        topFrame = new JFrame("MainFrame-Look and Feel");
        topFrame.setBounds(100,100,630,400);  // --- setBounds(x座標,y座標,寬,高)
        buildContent();
        buildMenuBar();
        buildToolBar();
        popupMenu = buildPopupMenu();
        
        topFrame.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        	  System.exit(0); 
            }
        }); //end of addWindowListener
        
        topFrame.setVisible(true);
    } //end of MainFrame()
    
    public void buildContent()
    {
        desktop = new JDesktopPane();
        topFrame.getContentPane().add(desktop);
    }//end of buildContent()
    
    public void buildMenuBar()
    {
        String menuName;
        
        menuBar = new JMenuBar();
        menuName = "File";
        String[] fileFunctions = {"New", "Open", "Close", "Exit"};
        char[] fileMnemonic = {'N', 'O', 'L', 'X'};
        JMenu mfile = buildMenu(menuName,fileFunctions,fileMnemonic);
        
        menuName = "Edit";
        String[] editFunctions = {"Undo","Redo","addSeparator","Copy", "Cut", "Paste"};
        char[] editMnemonic = {'Z','Y','0','T', 'C', 'P'};
        JMenu medit = buildMenu(menuName,editFunctions,editMnemonic);
        
        JMenu malign = buildAlignMenu();
        
        menuName = "Insert";
        String[] insertFunctions = {"Picture", "Object"};
        char[] insertMnemonic = null;
        JMenu minsert = buildMenu(menuName,insertFunctions,insertMnemonic);
        
        menuName = "Demo";
        String[] demoFunctions = {"Slider", "Tree Structure", "Table Structure", "Password"};
        char[] demoMnemonic = {'S', 'T', 'A', 'P'};
        JMenu mdemo = buildMenu(menuName,demoFunctions,demoMnemonic);
        
        menuName = "Help";
        String[] helpFunctions = {"About this Program", "Open Help Window"};
        char[] helpMnemonic = {'B', 'H'};     
        JMenu mhelp = buildMenu(menuName,helpFunctions,helpMnemonic);
    
        //設定Hot Key Alt+'?'    
        mfile.setMnemonic('F');
        medit.setMnemonic('E');
        malign.setMnemonic('A');
        minsert.setMnemonic('I'); 
        mdemo.setMnemonic('D');
        mhelp.setMnemonic('H');
        
        menuBar.add(mfile); //將 File 選項加到MenuBar中
        menuBar.add(medit); //將 Edit 選項加到MenuBar中
        menuBar.add(malign); //將 Align 選項加到MenuBar中
        menuBar.add(mdemo); //將 Demo 選項加到MenuBar中    
        menuBar.add(mhelp); //將 Help 選項加到MenuBar中
        
        topFrame.setJMenuBar(menuBar);    
    }//end of bulidMenuBar()
    
    public JMenu buildMenu(String menuName, String[] functions, char[] mnemonic)
    {
        ActionSet action;
        JMenuItem item;
        JMenu menu = new JMenu(menuName);
        for (int i=0; i<functions.length; i++)
        {
            if (functions[i].equals("addSeparator"))
            {
                menu.addSeparator();
                continue;
            }
            item = menu.add(new ActionSet(functions[i],null));
            item.setActionCommand(functions[i]);
            if (mnemonic != null)
            {
                item.setMnemonic(mnemonic[i]);
                item.setAccelerator( KeyStroke.getKeyStroke(mnemonic[i],java.awt.Event.CTRL_MASK,false));
            }
        }
        return menu;
    }//end of buildMenu()
    
    public JMenu buildAlignMenu()
    {
        JRadioButtonMenuItem aL;
        JRadioButtonMenuItem aC;
        JRadioButtonMenuItem aR;
    
        JMenu malign = new JMenu("Align");
        
        aL = new JRadioButtonMenuItem("Align Left");
        aC = new JRadioButtonMenuItem("Align Center");
        aR = new JRadioButtonMenuItem("Align Right");
        
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        aL.addItemListener(new HandleItemEvent("LEFT",attrset));
        aC.addItemListener(new HandleItemEvent("CENTER",attrset));  
        aR.addItemListener(new HandleItemEvent("RIGHT",attrset));
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(aL);
        buttonGroup.add(aC);
        buttonGroup.add(aR);
        
        JCheckBoxMenuItem demo1 = new JCheckBoxMenuItem("demo1", true);
        JCheckBoxMenuItem demo2 = new JCheckBoxMenuItem("demo2");
        JCheckBoxMenuItem demo3 = new JCheckBoxMenuItem("demo3");
         
        malign.add(aL);
        malign.add(aC);
        malign.add(aR);
        malign.addSeparator();
        malign.add(demo1);
        malign.add(demo2);
        malign.add(demo3);
        
        return malign;
    }//end of buildAlignMenu()
        
    class HandleItemEvent implements ItemListener
    {
        String align;
        SimpleAttributeSet attrset;
        
        HandleItemEvent(String align, SimpleAttributeSet attrset)
        {
            this.align = align;
            this.attrset = attrset;
        }
        
        public void itemStateChanged(ItemEvent e)
        {
            NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
            JTextPane pane = currentFrame.getTextPane();
            StyledDocument docs = pane.getStyledDocument();
            int offset = pane.getSelectionStart();
            int end    = pane.getSelectionEnd();
            int selected_length = end - offset;
            
            if(currentFrame == null) { return;}
            
            if (align.equals("LEFT"))
                StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_LEFT);
            if (align.equals("CENTER"))
                StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_CENTER);
            if (align.equals("RIGHT"))
                StyleConstants.setAlignment(attrset, StyleConstants.ALIGN_RIGHT);
                
            docs.setParagraphAttributes(offset, selected_length, attrset, true);

        }//end of itemStateChanged()
    }//end of HandleItemEvent class
    
    public void buildToolBar()
    {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(true);
        
        String[] newFunctions = {"New"};
        String[] newPics = {"icons/new16.gif"};
        buildToolButton(toolBar,newFunctions,newPics);
        
        toolBar.addSeparator();
        
        String[] editFunctions = {"Cut","Copy","Paste"};
        String[] editPics = {"icons/cut16.gif","icons/copy16.gif","icons/paste16.gif"};
        buildToolButton(toolBar,editFunctions,editPics);
        
        toolBar.addSeparator();
        
        String[] shapeFunctions = {"Bold","Italic","Underline"};
        String[] shapePics = {"icons/_bold.gif","icons/_italic.gif","icons/_underline.gif"};
        buildToolButton(toolBar,shapeFunctions,shapePics);
        
        toolBar.addSeparator();
        
        String[] colorFunctions = {"Set Color"};
        String[] colorPics = {"icons/color.gif"};
        buildToolButton(toolBar,colorFunctions,colorPics);
        
        toolBar.addSeparator();
        
        JLabel label = new JLabel("Insert");
        toolBar.add(label);
        
        toolBar.addSeparator();
        
        String[] insertFunctions = {"Picture","Object"};
        String[] insertPics = {"icons/picture.gif","icons/object.gif"};
        buildToolButton(toolBar,insertFunctions,insertPics);
        
        toolBar.addSeparator();
            
        label = new JLabel("Font Type");
        toolBar.add(label);
        
        toolBar.addSeparator();
        
        String[] ComboStr1 = {"Monospaced","Times New Roman","Dialog","細明體","新細明體","標楷體"};
        JComboBox combo = new JComboBox(ComboStr1);
        combo.setActionCommand("Type");
        combo.addActionListener(new ActionSet("Type",null));
        toolBar.add(combo);
        toolBar.addSeparator();
        
        String[] ComboStr2 = {"8","10","12","14","16","18","20","24","26","30","36","48","72"};  
        combo = new JComboBox(ComboStr2);
        combo.setActionCommand("Size");
        combo.addActionListener(new ActionSet("Size",null));
        toolBar.add(combo);
        toolBar.addSeparator();
        topFrame.getContentPane().add(toolBar,BorderLayout.NORTH);
    }//end of buildToolBar()
    
    public void buildToolButton(JToolBar toolBar,String[] functions,String[] pics)
    {
        JButton button;
        
        for(int i=0; i<functions.length; i++)
        {
            ActionSet action = new ActionSet(functions[i],new ImageIcon(pics[i]));
            button = toolBar.add(action);
            button.setActionCommand(functions[i]);
            button.setToolTipText((String)action.getValue(Action.NAME));
        }
    }//end of buildToolButton()
    
    public JPopupMenu buildPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu("Popup Menu");
        JMenuItem item = popupMenu.add(new ActionSet("Cut",new ImageIcon("icons/cut16.gif")));
        item.setActionCommand("Cut");
        item = popupMenu.add(new ActionSet("Copy",new ImageIcon("icons/copy16.gif"))); 
        item.setActionCommand("Copy");
        item = popupMenu.add(new ActionSet("Paste",new ImageIcon("icons/paste16.gif"))); 
        item.setActionCommand("Paste");
        return popupMenu;
    }//end of buildPopupMenu()
    
    class ShowPopupMenu extends MouseAdapter
    {
        JPopupMenu popupMenu;
        
        ShowPopupMenu(JPopupMenu popupMenu)
        {
            this.popupMenu = popupMenu;
        }
        
        public void mouseReleased(MouseEvent e)
        {
            if (e.isPopupTrigger())
            {
                popupMenu.show(e.getComponent(),e.getX(),e.getY());
            }
        }
    }
    
    UndoManager undo;
    
    class ActionSet extends AbstractAction
    {
        public ActionSet(String name,Icon icon)
        {
          super(name,icon);
          if(name.equals("Undo") || name.equals("Redo"))
            setEnabled(false);
        }
        
        public void updateUndoState() {
            NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                undo = currentFrame.getUndoManager();
            JMenuItem undoItem = menuBar.getMenu(1).getItem(0);
            if (undo.canUndo()) {
                undoItem.setEnabled(true);
                //您可以用putValue()方法改變MenuItem的顯示字串
                //putValue(Action.NAME, undo.getRedoPresentationName());
            } else {
                undoItem.setEnabled(false);
            }
        }
        
        public void updateRedoState() {
            NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                undo = currentFrame.getUndoManager();
            JMenuItem redoItem = menuBar.getMenu(1).getItem(1);
            if (undo.canRedo()) {
                redoItem.setEnabled(true);
                //putValue(Action.NAME, undo.getUndoPresentationName());
            } else {
                redoItem.setEnabled(false);
            }
        }
      
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            
            if(command.equals("New"))
            {
                NewFrame internalFrame = new NewFrame();
                desktop.add(internalFrame, new Integer(1));
                try { 
                    internalFrame.setVisible(true);
                    internalFrame.setSelected(true);
                }catch (java.beans.PropertyVetoException e2) {}
                JTextPane textPane = internalFrame.getTextPane();
                textPane.addMouseListener(new ShowPopupMenu(popupMenu));
                textPane.requestFocus();
            }
            if(command.equals("Open"))
            {
                NewFrame internalFrame = new NewFrame();
                desktop.add(internalFrame, new Integer(1));
                try { 
                    internalFrame.setVisible(true);
                    internalFrame.setSelected(true); 
                }catch (java.beans.PropertyVetoException e2) {}
                
                JTextPane textPane = internalFrame.getTextPane();
                ReadDocContent rIS = new ReadDocContent(textPane,topFrame,internalFrame);
            }
            if(command.equals("Close"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                else{
                    desktop.remove(currentFrame);
                    desktop.updateUI();
                }
            }
            if(command.equals("Exit"))
            {
                System.exit(0);
            }
            if(command.equals("Undo"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                undo = currentFrame.getUndoManager();
                try {
                    undo.undo();
                } catch (CannotUndoException ex) {
                    System.out.println("Unable Undo");
                }
                updateUndoState();
                updateRedoState();
            }
                  
            if(command.equals("Redo"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                undo = currentFrame.getUndoManager();
                try {
                    undo.redo();
                } catch (CannotRedoException ex) {
                    System.out.println("Unable Redo");
                }
                updateRedoState();
                updateUndoState();
            }

            if(command.equals("Copy"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                currentFrame.getTextPane().copy();
            }
            if(command.equals("Cut"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                currentFrame.getTextPane().cut();
            }
            if(command.equals("Paste"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                currentFrame.getTextPane().paste();
            }
            if(command.equals("Bold"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                
                MutableAttributeSet attrset = textPane.getInputAttributes();
                boolean bold = (StyleConstants.isBold(attrset)) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
        		StyleConstants.setBold(sas, bold);
        		textPane.setCharacterAttributes(sas, false);
            }
            if(command.equals("Italic"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                
                MutableAttributeSet attrset = textPane.getInputAttributes();
                boolean italic = (StyleConstants.isItalic(attrset)) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
        		StyleConstants.setItalic(sas, italic);
        		textPane.setCharacterAttributes(sas, false);
            }
            if(command.equals("Underline"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                
                MutableAttributeSet attrset = textPane.getInputAttributes();
                boolean underline = (StyleConstants.isUnderline(attrset)) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
        		StyleConstants.setUnderline(sas, underline);
        		textPane.setCharacterAttributes(sas, false);
            }
            if(command.equals("Set Color"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                Color color = JColorChooser.showDialog(topFrame,"Change Font Color",Color.black);
                if (color != null) //若為null值表示使用者按下Cancel按鈕
                {
                    SimpleAttributeSet sas = new SimpleAttributeSet();
        		    StyleConstants.setForeground(sas, color);
            		textPane.setCharacterAttributes(sas, false);
                }
            }
            if (command.equals("Type"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                
                MutableAttributeSet attrset = textPane.getInputAttributes();
                String cstr = (((JComboBox)e.getSource()).getSelectedItem()).toString();
                SimpleAttributeSet sas = new SimpleAttributeSet();
    		    StyleConstants.setFontFamily(sas, cstr);
    		    textPane.setCharacterAttributes(sas, false);
            }
            if (command.equals("Size"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                
                MutableAttributeSet attrset = textPane.getInputAttributes();
                int size = Integer.parseInt((((JComboBox)e.getSource()).getSelectedItem()).toString());
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setFontSize(sas, size);
                textPane.setCharacterAttributes(sas, false);
            }
            if(command.equals("Picture"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                JFileChooser fileChooser = new JFileChooser("c:\\");
                fileChooser.addChoosableFileFilter(new PicsFileFilter("jpg"));
                fileChooser.addChoosableFileFilter(new PicsFileFilter("gif"));
                int result = fileChooser.showOpenDialog(topFrame);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileChooser.getSelectedFile();
                    textPane.insertIcon(new ImageIcon(file.getPath()));
                }else if (result == fileChooser.CANCEL_OPTION){}
            }
            if(command.equals("Object"))
            {
                NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
                if(currentFrame == null) { return;}
                JTextPane textPane = currentFrame.getTextPane();
                textPane.insertComponent(new JButton("按鈕物件"));
            }
            if(command.equals("Slider"))
            {
                new DemoSilder(topFrame);
            }
            if(command.equals("Tree Structure"))
            {
                JInternalFrame JItree = new DemoTree();
                desktop.add(JItree, new Integer(3));
                try { 
                     JItree.setVisible(true);
            	     JItree.setSelected(true); 
                }catch (java.beans.PropertyVetoException e2) {}
            }
            if(command.equals("Table Structure"))
            {
                JInternalFrame JItable = new DemoTable();
                desktop.add(JItable, new Integer(4));
                try { 
                     JItable.setVisible(true);
                     JItable.setSelected(true); 
                }catch (java.beans.PropertyVetoException e2) {}  	
            }
            if(command.equals("Password"))
            {
                new DemoPassword(topFrame);
            }
            if(command.equals("About this Program"))
            {
                final String AboutMsg = "A Java Simple Editor Example  Ver 1.0\n \n"+
                       "An application written to show off the functions of Editor. \n \n "+
                       "Written By Ming-Hsiang Fan and Chih-Yang Lin. \n \n"+
                       "Copyright (c) 2001 by Ming-Hsiang Fan and Chih-Yang Lin. All Rights Reserved.";
                       
                JOptionPane.showMessageDialog(topFrame, AboutMsg);
            }
            if(command.equals("Open Help Window"))
            {
                JInternalFrame help = new HelpFrame();
                desktop.add(help, new Integer(2));
                try { 
                    help.setVisible(true);
                    help.setSelected(true); 
                }catch (java.beans.PropertyVetoException e2) {}
            }					
        }//end of actionPerformed()
    }//end of ActionSet class
    
    static int Count = 0;
    static final int offset = 30;
        
    class NewFrame extends JInternalFrame
    {
        JTextPane textPane = null;
        MyUndoManager myUndo;
    
        public NewFrame() {
            super("", true, true, true, true);
            setTitle("Untitled Document " + (Count++));
            setSize(new Dimension(300,200));
            
            JPanel panel = new JPanel();
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));
            panel.setLayout(new BorderLayout());
            
            textPane = new JTextPane();
            textPane.setBorder( new EmptyBorder(0,5 ,0, 5) );
            
            myUndo = new MyUndoManager();
            textPane.getDocument().addUndoableEditListener(myUndo);
            
            JScrollPane textScroller = new JScrollPane(textPane, 
               				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            				   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
            panel.add( textScroller, BorderLayout.CENTER);
            setContentPane(panel);
            setLocation( offset * Count, offset *Count);
        }//end of NewFrame()
        
        public UndoManager getUndoManager()
        {
            return myUndo;
        }
        public JTextPane getTextPane()
        {
            return textPane;
        }//end of getTextPane()
    }//end of NewFrame class
    
    class MyUndoManager extends UndoManager
    {
        public void undoableEditHappened(UndoableEditEvent e)
        {
            NewFrame currentFrame = (NewFrame)desktop.getSelectedFrame();
            if(currentFrame == null) { return;}
            UndoManager undo = currentFrame.getUndoManager();
                
            undo.addEdit(e.getEdit());
            new ActionSet("Undo",null).updateUndoState();
            new ActionSet("Redo",null).updateRedoState();
        }//end of undoableEditHappened()
    }//end of MyUndoManager class
}//end of class MainFrame
