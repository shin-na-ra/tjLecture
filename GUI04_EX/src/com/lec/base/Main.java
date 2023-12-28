package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;

public class Main {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tFid;
	private JTextField tfAddr;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JLabel resultLabel;

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
		frame.setTitle("전자우편 주소 결정");
		frame.setBounds(100, 100, 704, 202);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTFid());
		frame.getContentPane().add(getTfAddr());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getResultLabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Email주소 : ");
			lblNewLabel.setBounds(39, 74, 73, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTFid() {
		if (tFid == null) {
			tFid = new JTextField();
			tFid.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						String id = tFid.getText();
						String addr = tfAddr.getText();
						resultLabel.setText("당신의 이메일 주소는 " + id + "@" + addr+"입니다.");
					}
				}
			});
			
			tFid.setBounds(124, 69, 130, 26);
			tFid.setColumns(10);
		}
		return tFid;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setText("naver.com");
			tfAddr.setColumns(10);
			tfAddr.setBounds(314, 69, 130, 26);
		}
		return tfAddr;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("@");
			lblNewLabel_1.setBounds(276, 74, 73, 16);
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeCombo();
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "daum.net", "gmail.com", "iclound.com"}));
			comboBox.setBounds(478, 70, 148, 25);
		}
		return comboBox;
	}
	private JLabel getResultLabel() {
		if (resultLabel == null) {
			resultLabel = new JLabel("");
			resultLabel.setBounds(202, 118, 352, 26);
		}
		return resultLabel;
	}
	
	private void changeCombo() {
		tfAddr.setText(comboBox.getSelectedItem().toString());
		
	}
	
	
}//end
