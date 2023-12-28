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

import com.lec.func.Add;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

public class Main {

	private JFrame frmCombobox;
	private JButton btnAdd;
	private JTextField tfStartNum;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfEndNum;
	private JRadioButton rbWhole;
	private JRadioButton rbEven;
	private JRadioButton rbOdd;
	private JLabel lblNewLabel_1_1;
	private JTextField tfResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		frmCombobox.setTitle("합계구하기");
		frmCombobox.setBounds(100, 100, 578, 337);
		frmCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombobox.getContentPane().setLayout(null);
		frmCombobox.getContentPane().add(getBtnAdd());
		frmCombobox.getContentPane().add(getTfStartNum());
		frmCombobox.getContentPane().add(getLblNewLabel());
		frmCombobox.getContentPane().add(getLblNewLabel_1());
		frmCombobox.getContentPane().add(getTfEndNum());
		frmCombobox.getContentPane().add(getRbWhole());
		frmCombobox.getContentPane().add(getRbEven());
		frmCombobox.getContentPane().add(getRbOdd());
		frmCombobox.getContentPane().add(getLblNewLabel_1_1());
		frmCombobox.getContentPane().add(getTfResult());
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("계산하기");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addition();
				}
			});
			btnAdd.setBounds(229, 101, 117, 29);
		}
		return btnAdd;
	}
	
	private JTextField getTfStartNum() {
		if (tfStartNum == null) {
			tfStartNum = new JTextField();
			tfStartNum.setHorizontalAlignment(SwingConstants.TRAILING);
			tfStartNum.setBounds(119, 54, 98, 26);
			tfStartNum.setColumns(10);
		}
		return tfStartNum;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("시작 숫자");
			lblNewLabel.setBounds(46, 59, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("끝 숫자");
			lblNewLabel_1.setBounds(46, 106, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfEndNum() {
		if (tfEndNum == null) {
			tfEndNum = new JTextField();
			tfEndNum.setHorizontalAlignment(SwingConstants.TRAILING);
			tfEndNum.setColumns(10);
			tfEndNum.setBounds(119, 101, 98, 26);
		}
		return tfEndNum;
	}
	private JRadioButton getRbWhole() {
		if (rbWhole == null) {
			rbWhole = new JRadioButton("전체");
			buttonGroup.add(rbWhole);
			rbWhole.setSelected(true);
			rbWhole.setBounds(238, 55, 79, 23);
		}
		return rbWhole;
	}
	private JRadioButton getRbEven() {
		if (rbEven == null) {
			rbEven = new JRadioButton("짝수");
			buttonGroup.add(rbEven);
			rbEven.setBounds(329, 55, 98, 23);
		}
		return rbEven;
	}
	private JRadioButton getRbOdd() {
		if (rbOdd == null) {
			rbOdd = new JRadioButton("홀수");
			buttonGroup.add(rbOdd);
			rbOdd.setBounds(431, 55, 141, 23);
		}
		return rbOdd;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("합계");
			lblNewLabel_1_1.setBounds(43, 206, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setColumns(10);
			tfResult.setBounds(116, 201, 98, 26);
		}
		return tfResult;
	}
	
	private void addition() {
		
		Add add = new Add(tfStartNum.getText(), tfEndNum.getText());
		
		if(rbWhole.isSelected()) {
			tfResult.setText(add.wholeAdd());
		}
		
		if(rbEven.isSelected()) {
			tfResult.setText(add.evenAdd());
		}
		
		if(rbOdd.isSelected()) {
			tfResult.setText(add.oddAdd());
		}
	}
}//end
