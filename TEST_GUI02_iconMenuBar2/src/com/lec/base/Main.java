package com.lec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu backMenu;
	private JMenu forwardMenu;
	private JButton btnBack;
	private JButton btnForward;

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
		frame.setJMenuBar(getMenuBar());
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBtnBack());
			menuBar.add(getBtnForward());
		}
		return menuBar;
	}
	
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBack.setBackground(Color.gray);
				}
			});
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_4187319.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			btnBack.setIcon(updateIcon);
			btnBack.setBorderPainted(false);
			
		}
		return btnBack;
	}
	private JButton getBtnForward() {
		if (btnForward == null) {
			btnForward = new JButton("");
			btnForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnForward.setBackground(Color.gray);
				}
			});
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_41873190.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			btnForward.setIcon(updateIcon);
			btnForward.setBorderPainted(false);
		}
		return btnForward;
	}
}
