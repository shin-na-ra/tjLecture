package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmImage;
	private JButton btnBee;
	private JButton btnCat;
	private JButton btnDog;
	private JButton btnFox;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmImage.setVisible(true);
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
		frmImage = new JFrame();
		frmImage.setTitle("Image");
		frmImage.setBounds(100, 100, 450, 300);
		frmImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImage.getContentPane().setLayout(null);
		frmImage.getContentPane().add(getBtnBee());
		frmImage.getContentPane().add(getBtnCat());
		frmImage.getContentPane().add(getBtnDog());
		frmImage.getContentPane().add(getBtnFox());
		frmImage.getContentPane().add(getLblImage());
	}

	private JButton getBtnBee() {
		if (btnBee == null) {
			btnBee = new JButton("Bee");
			btnBee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					beeAction();
				}
			});
			btnBee.setBounds(44, 47, 117, 29);
		}
		return btnBee;
	}
	private JButton getBtnCat() {
		if (btnCat == null) {
			btnCat = new JButton("Cat");
			btnCat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					catAction();
				}
			});
			btnCat.setBounds(44, 88, 117, 29);
		}
		return btnCat;
	}
	private JButton getBtnDog() {
		if (btnDog == null) {
			btnDog = new JButton("Dog");
			btnDog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dogAction();
				}
			});
			btnDog.setBounds(44, 131, 117, 29);
		}
		return btnDog;
	}
	private JButton getBtnFox() {
		if (btnFox == null) {
			btnFox = new JButton("Fox");
			btnFox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					foxAction();
				}
			});
			btnFox.setBounds(44, 172, 117, 29);
		}
		return btnFox;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/bee.png")));
			lblImage.setBounds(211, 34, 183, 182);
		}
		return lblImage;
	}
	
	
	//Function
	private void beeAction(){
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/bee.png")));
	}
	
	private void catAction(){
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/cat.png")));
	}
	
	private void dogAction(){
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/dog.png")));
	}
	
	private void foxAction(){
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/fox.png")));
	}
}
