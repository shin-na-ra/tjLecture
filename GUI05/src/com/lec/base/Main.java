package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.lec.function.Calc;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

	private JFrame frmCombobox;
	private JTextField tfNum1;
	private JComboBox operand;
	private JTextField tfNum2;
	private JTextField tfResult;
	private JButton btnEqual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCombobox.setVisible(true);
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
		frmCombobox = new JFrame();
		frmCombobox.setTitle("계산기");
		frmCombobox.setBounds(100, 100, 620, 165);
		frmCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombobox.getContentPane().setLayout(null);
		frmCombobox.getContentPane().add(getTfNum1());
		frmCombobox.getContentPane().add(getOperand());
		frmCombobox.getContentPane().add(getTfNum2());
		frmCombobox.getContentPane().add(getTfResult());
		frmCombobox.getContentPane().add(getBtnEqual());
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						tfNum1.setText("");
						tfResult.setText("");
					}
				}
			});
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setColumns(10);
			tfNum1.setBounds(56, 59, 80, 36);
		}
		return tfNum1;
	}
	private JComboBox getOperand() {
		if (operand == null) {
			operand = new JComboBox();
			operand.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tfNum2.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "두번째 숫자 입력해주세요!","경고", JOptionPane.ERROR_MESSAGE);
					} else {
						calculator();
					}
					
				}
			});
			operand.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "x", "/"}));
			operand.setBounds(148, 58, 73, 40);
		}
		return operand;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						tfNum2.setText("");
						tfResult.setText("");
					}
				}
			});
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(231, 59, 80, 36);
		}
		return tfNum2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setColumns(10);
			tfResult.setBounds(405, 58, 80, 36);
		}
		return tfResult;
	}

	private void calculator() {
		if(tfNum2.getText().equals("0")) {
			JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다.!","경고", JOptionPane.ERROR_MESSAGE);
			tfNum2.setText("");
			tfResult.setText("");
		} else {
			
			Calc calc = new Calc(tfNum1.getText(), tfNum2.getText());
			
			switch(operand.getSelectedIndex()) {
			case 0:
				tfResult.setText(calc.add());
				break;
				
			case 1:
				tfResult.setText(calc.sub());
				break;
				
			case 2:
				tfResult.setText(calc.mul());
				break;
			
			case 3:
				tfResult.setText(calc.div());
				break;
			}
		}
	}
		
	private JButton getBtnEqual() {
		if (btnEqual == null) {
			btnEqual = new JButton("=");
			btnEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculator();
				}
			});
			btnEqual.setBounds(332, 64, 61, 29);
		}
		return btnEqual;
	}
}//end
