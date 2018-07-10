package com.baochao.practice;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageView {
	public JLabel label;
	public JFileChooser jFileChooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				JFrame frame = new ImageViewerFrame();
			}
		});
	}
	
	class ImageViewerFrame extends JFrame {
		public ImageViewerFrame (){
			setTitle("ImageViewer");
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			
			label = new JLabel();
			add(label);
			
		}
	}
}
