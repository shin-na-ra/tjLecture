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

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Main {

	private JFrame frmCombobox;
	private JCheckBox cbBanana;
	private JCheckBox cbApple;
	private JRadioButton rdKBS;
	private JRadioButton rdMBC;
	private JButton btnBorad;
	private JTextField tfBoard;
	private JTextField tfFruits;
	private JButton btnFruits;
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
		frmCombobox.setTitle("CheckBox / RadioButton");
		frmCombobox.setBounds(100, 100, 578, 337);
		frmCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombobox.getContentPane().setLayout(null);
		frmCombobox.getContentPane().add(getCbBanana());
		frmCombobox.getContentPane().add(getCbApple());
		frmCombobox.getContentPane().add(getRdKBS());
		frmCombobox.getContentPane().add(getRdMBC());
		frmCombobox.getContentPane().add(getBtnBorad());
		frmCombobox.getContentPane().add(getTfBoard());
		frmCombobox.getContentPane().add(getTfFruits());
		frmCombobox.getContentPane().add(getBtnFruits());
	}

	private JCheckBox getCbBanana() {
		if (cbBanana == null) {
			cbBanana = new JCheckBox("Banana");
			cbBanana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			cbBanana.setBounds(87, 55, 128, 23);
		}
		return cbBanana;
	}
	private JCheckBox getCbApple() {
		if (cbApple == null) {
			cbApple = new JCheckBox("Apple");
			cbApple.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			cbApple.setBounds(87, 122, 128, 23);
		}
		return cbApple;
	}
	private JRadioButton getRdKBS() {
		if (rdKBS == null) {
			rdKBS = new JRadioButton("KBS");
			rdKBS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			buttonGroup.add(rdKBS);
			rdKBS.setSelected(true);
			rdKBS.setBounds(322, 55, 141, 23);
		}
		return rdKBS;
	}
	private JRadioButton getRdMBC() {
		if (rdMBC == null) {
			rdMBC = new JRadioButton("MBC");
			rdMBC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			buttonGroup.add(rdMBC);
			rdMBC.setBounds(321, 119, 141, 23);
		}
		return rdMBC;
	}
	private JButton getBtnBorad() {
		if (btnBorad == null) {
			btnBorad = new JButton("OK");
			btnBorad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			btnBorad.setBounds(322, 169, 117, 29);
		}
		return btnBorad;
	}
	private JTextField getTfBoard() {
		if (tfBoard == null) {
			tfBoard = new JTextField();
			tfBoard.setBounds(328, 223, 117, 26);
			tfBoard.setColumns(10);
		}
		return tfBoard;
	}
	private JTextField getTfFruits() {
		if (tfFruits == null) {
			tfFruits = new JTextField();
			tfFruits.setText("Nothing");
			tfFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			tfFruits.setColumns(10);
			tfFruits.setBounds(95, 225, 207, 26);
		}
		return tfFruits;
	}
	private JButton getBtnFruits() {
		if (btnFruits == null) {
			btnFruits = new JButton("OK");
			btnFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			btnFruits.setBounds(89, 171, 117, 29);
		}
		return btnFruits;
	}
	
	private void broadCheck() {
		if(rdKBS.isSelected()) {
			tfBoard.setText("KBS is selected");
		}  
		
		if(rdMBC.isSelected()){
			tfBoard.setText("MBC is selected");
		}
	}
	
	private void fruitCheck() {

		tfFruits.setText("Nothing");
		
		if(cbBanana.isSelected()) {
			tfFruits.setText("Banana is selected");
		}
		
		if(cbApple.isSelected()) {
			tfFruits.setText("Apple is selected");
		}
		
		if(cbBanana.isSelected() && cbApple.isSelected()) {
			tfFruits.setText("Apple & Banana");
		}
	}
}//end
