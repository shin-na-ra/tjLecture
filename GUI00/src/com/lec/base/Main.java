package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Main {

	private JFrame frmGui;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmGui.setVisible(true);
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
		frmGui = new JFrame();
		frmGui.setTitle("GUI00");
		frmGui.setBounds(100, 100, 450, 300);
		frmGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGui.getContentPane().setLayout(null);
		frmGui.getContentPane().add(getLblNewLabel());
		frmGui.getContentPane().add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("안녕하세요");
			lblNewLabel.setBounds(104, 66, 61, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Alert");
			btnNewButton.setBackground(SystemColor.desktop);
			btnNewButton.setForeground(new Color(255, 107, 184));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAlert();
				}
			});
			btnNewButton.setBounds(208, 61, 117, 29);
		}
		return btnNewButton;
	}
	
	
	private void btnAlert() {
		//JOptionPane.showMessageDialog(null, "Alert를 눌렀습니다.");
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("/Volumes/Data"));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Alert 버튼 눌렸습니다.");
		}
		
		
	}
	
	
	
}//end
