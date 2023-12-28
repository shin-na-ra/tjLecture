package com.lec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNewButton());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/pngwing.com.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			btnNewButton.setIcon(updateIcon);
			btnNewButton.setBounds(76, 96, 40, 40);
		}
		return btnNewButton;
	}
}
