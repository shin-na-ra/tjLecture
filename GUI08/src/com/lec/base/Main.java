package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frmPasswordfield;
	private JLabel lblNewLabel;
	private JPasswordField pfPassword1;
	private JButton btnShow;
	private JPasswordField pfPassword2;
	private JButton btnCompare;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPasswordfield.setVisible(true);
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
		frmPasswordfield = new JFrame();
		frmPasswordfield.setTitle("passwordField");
		frmPasswordfield.setBounds(100, 100, 431, 278);
		frmPasswordfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordfield.getContentPane().setLayout(null);
		frmPasswordfield.getContentPane().add(getLblNewLabel());
		frmPasswordfield.getContentPane().add(getPfPassword1());
		frmPasswordfield.getContentPane().add(getBtnShow());
		frmPasswordfield.getContentPane().add(getPfPassword2());
		frmPasswordfield.getContentPane().add(getBtnCompare());
		frmPasswordfield.getContentPane().add(getLblResult());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Password : ");
			lblNewLabel.setBounds(52, 61, 84, 16);
		}
		return lblNewLabel;
	}
	private JPasswordField getPfPassword1() {
		if (pfPassword1 == null) {
			pfPassword1 = new JPasswordField();
			pfPassword1.setBounds(129, 56, 114, 26);
		}
		return pfPassword1;
	}
	private JButton getBtnShow() {
		if (btnShow == null) {
			btnShow = new JButton("Show");
			btnShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			btnShow.setBounds(255, 56, 117, 29);
		}
		return btnShow;
	}
	private JPasswordField getPfPassword2() {
		if (pfPassword2 == null) {
			pfPassword2 = new JPasswordField();
			pfPassword2.setBounds(129, 107, 114, 26);
		}
		return pfPassword2;
	}
	private JButton getBtnCompare() {
		if (btnCompare == null) {
			btnCompare = new JButton("Compare");
			btnCompare.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comparePassword();
				}
			});
			btnCompare.setBounds(255, 107, 117, 29);
		}
		return btnCompare;
	}
	private JLabel getLblResult() {
		if (lblResult == null) {
			lblResult = new JLabel("");
			lblResult.setHorizontalAlignment(SwingConstants.CENTER);
			lblResult.setBounds(52, 185, 320, 16);
		}
		return lblResult;
	}
	
	private void checkPassword() {
		char[] pass = pfPassword1.getPassword();
		String passString = new String(pass);
		lblResult.setText(passString);
	}
	
	private void comparePassword() {
		char[] pass1 = pfPassword1.getPassword();
		String passString1 = new String(pass1);
		
		char[] pass2 = pfPassword2.getPassword();
		String passString2 = new String(pass2);
		
	
		
		
		if(passString1.equals(passString2)) {
			lblResult.setText("Password가 일치합니다.");
		}else {
			lblResult.setText("Password가 일치하지 않습니다.");
		}
	}
}//end
