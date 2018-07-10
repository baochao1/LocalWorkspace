package com.was.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartPanel implements ActionListener{

	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JLabel jLabel = new JLabel("Cookies");
	JTextField jTextField = new JTextField();
	JButton jButton = new JButton("search");

	public StartPanel() {

		jFrame.setSize(600, 400);
		jPanel.setSize(600,300);
		jTextField.setSize(100, 50);
		jTextField.setText("please input cookie");
		jButton.addActionListener(this);
		jPanel.add(jLabel);
		jPanel.add(jTextField);
		jPanel.add(jButton);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		StartPanel newPanel = new StartPanel();
	}


	
	public void actionPerformed(ActionEvent e){
		if (jTextField.getText().equals("1")) {
			System.out.println("1");
		} else {
			System.out.println("2");
		}
	}
}