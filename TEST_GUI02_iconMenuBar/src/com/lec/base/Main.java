package com.lec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu backMenu;
	private JMenu forwardMenu;

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
			menuBar.add(getBackMenu());
			menuBar.add(getForwardMenu());
		}
		return menuBar;
	}
	private JMenu getBackMenu() {
		if (backMenu == null) {
			backMenu = new JMenu("");
			
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_4187319.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			backMenu.setIcon(updateIcon);
			
		}
		return backMenu;
	}
	private JMenu getForwardMenu() {
		if (forwardMenu == null) {
			forwardMenu = new JMenu("");
			
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_41873190.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			forwardMenu.setIcon(updateIcon);
			
		}
		return forwardMenu;
	}
}
