package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.util.Share;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JLabel lblQ;
	private JPasswordField tfPw;
	private JLabel lblName;
	private JTextField tfName;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User dialog = new User();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public User() {

		initialize();
	}
	private void initialize() {
		setTitle("사용자 등록 화면");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfId());
		getContentPane().add(getLblQ());
		getContentPane().add(getTfPw());
		getContentPane().add(getLblName());
		getContentPane().add(getTfName());
		getContentPane().add(getBtnOk());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("User id : ");
			lblNewLabel.setBounds(122, 57, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(198, 52, 130, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblQ() {
		if (lblQ == null) {
			lblQ = new JLabel("Password");
			lblQ.setBounds(122, 99, 61, 16);
		}
		return lblQ;
	}
	private JPasswordField getTfPw() {
		if (tfPw == null) {
			tfPw = new JPasswordField();
			tfPw.setBounds(198, 94, 130, 26);
		}
		return tfPw;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setBounds(122, 142, 61, 16);
		}
		return lblName;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(198, 137, 130, 26);
		}
		return tfName;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					okAction();
				}
			});
			btnOk.setBounds(156, 201, 117, 29);
		}
		return btnOk;
	}
	
	private void okAction() {
		char[] pass = tfPw.getPassword();
		String password1 = new String(pass);
		
		Share.userId = tfId.getText();
		Share.name = tfName.getText();
		Share.password = password1;

		//화면정리
		Main window = new Main();
		window.main(null);
		
		this.setVisible(false);
	}
}
