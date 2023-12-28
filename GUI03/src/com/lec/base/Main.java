package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lec.function.Add;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Main {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField firstNum;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField endNum;
	private JLabel lblNewLabel_1_1;
	private JTextField addResult;

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
		frame.setTitle("범위의 숫자 합계 구하기");
		frame.setBounds(100, 100, 446, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getFirstNum());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getEndNum());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getAddResult());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("시작 숫자");
			lblNewLabel.setBounds(37, 55, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getFirstNum() {
		if (firstNum == null) {
			firstNum = new JTextField();
			firstNum.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					inputNum1();
				}
			});
			firstNum.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
						inputNum1();
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						firstNum.setText("");
						addResult.setText("");
					}
				}
			});
			firstNum.setHorizontalAlignment(SwingConstants.TRAILING);
			firstNum.setBounds(98, 50, 97, 26);
			firstNum.setColumns(10);
		}
		return firstNum;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("합계 구하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addition();
				}
			});
			btnNewButton.setBounds(226, 50, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("끝 숫자");
			lblNewLabel_1.setBounds(37, 107, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getEndNum() {
		if (endNum == null) {
			endNum = new JTextField();
			endNum.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					inputNum2();
				}
			});
			endNum.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
						if(e.getKeyCode() == 13) {
							inputNum2();
							getBtnNewButton();
						}
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						endNum.setText("");
						addResult.setText("");
					}
				}
			});
			endNum.setHorizontalAlignment(SwingConstants.TRAILING);
			endNum.setColumns(10);
			endNum.setBounds(98, 102, 97, 26);
		}
		return endNum;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("합계");
			lblNewLabel_1_1.setBounds(226, 107, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getAddResult() {
		if (addResult == null) {
			addResult = new JTextField();
			addResult.setEditable(false);
			addResult.setHorizontalAlignment(SwingConstants.TRAILING);
			addResult.setColumns(10);
			addResult.setBounds(264, 102, 97, 26);
		}
		return addResult;
	}
	
	// ------- function --------
	private void inputNum1() {
		firstNum.getText();
	}
	private void inputNum2() {
		endNum.getText();
	}
	
	private void addition() {
		Add add = new Add(firstNum.getText(), endNum.getText());
		addResult.setText(add.add());
	}
	

	
	
}//end
