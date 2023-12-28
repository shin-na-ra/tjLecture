package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.lec.util.Share;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	private JFrame frmPasswordfield;
	private JButton btnRegister;
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
		frmPasswordfield.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				checkStatus();
			}
		});
		frmPasswordfield.setTitle("Menu");
		frmPasswordfield.setBounds(100, 100, 431, 278);
		frmPasswordfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordfield.getContentPane().setLayout(null);
		frmPasswordfield.getContentPane().add(getBtnRegister());
		frmPasswordfield.getContentPane().add(getLblResult());
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("사용자 등록");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userRegister();
				}
			});
			btnRegister.setBounds(145, 61, 117, 29);
		}
		return btnRegister;
	}
	private JLabel getLblResult() {
		if (lblResult == null) {
			lblResult = new JLabel("");
			lblResult.setHorizontalAlignment(SwingConstants.CENTER);
			lblResult.setBounds(54, 135, 326, 85);
		}
		return lblResult;
	}
	
	private void userRegister() {
		User user = new User();
		user.setVisible(true);
		frmPasswordfield.setVisible(false);
	}
	
	private void checkStatus() {
		if(!Share.userId.equals("")) {
			System.out.println("1111" + Share.userId);
			String str;
			str = "<html>당신의 아이디는 "+ Share.userId +"이고 <br> 당신의 이름은 "+Share.name + "이며 <br>당신의 패스워드는 "+Share.password+"입니다.</html>";
			lblResult.setText(str);
			System.out.println("2222" + Share.userId);
			Share.userId = "";
			Share.name = "";
			Share.password = "";
			
			System.out.println("3333" + Share.userId);
			System.out.println("3333" + Share.name);
			System.out.println("3333" + Share.password);
			
		}
	}
	
}//end
