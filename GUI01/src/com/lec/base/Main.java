package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lec.function.Additon;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmGuitest;
	private JLabel lblNewLabel;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfResult;
	private JButton btnAdd;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfNum3;
	private JLabel lblNewLabel_1_2;
	private JTextField tfNum4;
	private JLabel lblNewLabel_1_1_1;
	private JTextField textField_2;
	private JButton btnSub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmGuitest.setVisible(true);
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
		frmGuitest = new JFrame();
		frmGuitest.setTitle("GUI_Test01");
		frmGuitest.setBounds(100, 100, 436, 288);
		frmGuitest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuitest.getContentPane().setLayout(null);
		frmGuitest.getContentPane().add(getLblNewLabel());
		frmGuitest.getContentPane().add(getTfNum1());
		frmGuitest.getContentPane().add(getLblNewLabel_1());
		frmGuitest.getContentPane().add(getTfNum2());
		frmGuitest.getContentPane().add(getLblNewLabel_1_1());
		frmGuitest.getContentPane().add(getTfResult());
		frmGuitest.getContentPane().add(getBtnAdd());
		frmGuitest.getContentPane().add(getTfNum3());
		frmGuitest.getContentPane().add(getLblNewLabel_1_2());
		frmGuitest.getContentPane().add(getTfNum4());
		frmGuitest.getContentPane().add(getLblNewLabel_1_1_1());
		frmGuitest.getContentPane().add(getTextField_2());
		frmGuitest.getContentPane().add(getBtnSub());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Java GUI Example 01");
			lblNewLabel.setBounds(33, 38, 158, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(33, 66, 69, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(135, 66, 69, 26);
		}
		return tfNum2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setColumns(10);
			tfResult.setBounds(241, 66, 69, 26);
		}
		return tfResult;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAction();
				}
			});
			btnAdd.setBounds(310, 66, 117, 29);
		}
		return btnAdd;
	}
	

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("+");
			lblNewLabel_1.setBounds(114, 71, 15, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("=");
			lblNewLabel_1_1.setBounds(214, 71, 15, 16);
		}
		return lblNewLabel_1_1;
	}
	
	// ----- Function Add ------
	private void addAction() {
	
		if(tfNum1.getText().equals("") || tfNum2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "숫자를 입력 하세요!");
		} else {
			Additon additon = new Additon(Integer.parseInt(tfNum1.getText()), Integer.parseInt(tfNum2.getText()));
			tfResult.setText(Integer.toString(additon.add()));
		}
	
	}
	
	
	
	
	private JTextField getTfNum3() {
		if (tfNum3 == null) {
			tfNum3 = new JTextField();
			tfNum3.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum3.setColumns(10);
			tfNum3.setBounds(33, 112, 69, 26);
		}
		return tfNum3;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("+");
			lblNewLabel_1_2.setBounds(114, 117, 15, 16);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfNum4() {
		if (tfNum4 == null) {
			tfNum4 = new JTextField();
			tfNum4.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum4.setColumns(10);
			tfNum4.setBounds(135, 112, 69, 26);
		}
		return tfNum4;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("=");
			lblNewLabel_1_1_1.setBounds(214, 117, 15, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.TRAILING);
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(241, 112, 69, 26);
		}
		return textField_2;
	}
	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("SUB");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSub.setBounds(310, 112, 117, 29);
		}
		return btnSub;
	}
}// end
