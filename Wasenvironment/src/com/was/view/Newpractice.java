package com.was.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Newpractice {
	public static void main(String[] args){
		JFrame jFrame = new JFrame();
		JPanel jPanel = new JPanel(); 
		JLabel evmLabel = new JLabel("»·¾³");
		JLabel jLabel = new JLabel("Cookies");
		JButton searchButton = new JButton("search");
		JComboBox<String> optionEnvironment = new JComboBox<>();
		
		optionEnvironment = initCombox();
		optionEnvironment.setSize(20, 200);
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				String selectOption = (String) optionEnvironment.getSelectedItem();
			}
		});
		
		jPanel.add(jLabel);
		jPanel.add(optionEnvironment);
		jPanel.add(searchButton);
		jFrame.add(jPanel);
		jFrame.setSize(600,600);
		jFrame.setVisible(true);
	}
	
	
	private static JComboBox<String> initCombox(){
		JComboBox<String> choice = new JComboBox<String>();
		choice.addItem("1");
		choice.addItem("2");
		choice.addItem("3");
		choice.addItem("4");
		choice.addItem("5");
		choice.addItem("6");
		choice.addItem("7");
		return choice;
	}
}
