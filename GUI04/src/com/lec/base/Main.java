package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Main {

	private JFrame frmCombobox;
	private JComboBox cbFruits;
	private JTextField tfAdd;
	private JComboBox cbAdd;
	private JTextField tfFruits;
	private JButton btnAdd;

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
		frmCombobox.setTitle("ComboBox");
		frmCombobox.setBounds(100, 100, 450, 300);
		frmCombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombobox.getContentPane().setLayout(null);
		frmCombobox.getContentPane().add(getCbFruits());
		frmCombobox.getContentPane().add(getTfFruits());
		frmCombobox.getContentPane().add(getTfAdd());
		frmCombobox.getContentPane().add(getCbAdd());
		frmCombobox.getContentPane().add(getBtnAdd());
	}
	private JComboBox getCbFruits() {
		if (cbFruits == null) {
			cbFruits = new JComboBox();
			cbFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboAction();
				
				}
			});
			cbFruits.setFont(new Font("SansSerif", Font.PLAIN, 13));
			cbFruits.setModel(new DefaultComboBoxModel(new String[] {"Banana", "Tomato", "Apple", "Grape", "Orange", "Mango", "Melon"}));
			cbFruits.setBounds(56, 52, 130, 40);
		}
		return cbFruits;
	}
	private JTextField getTfAdd() {
		if (tfAdd == null) {
			tfAdd = new JTextField();
			tfAdd.setColumns(10);
			tfAdd.setBounds(60, 151, 130, 36);
		}
		return tfAdd;
	}
	private JComboBox getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JComboBox();
			cbAdd.setBounds(246, 147, 137, 40);
		}
		return cbAdd;
	}
	private JTextField getTfFruits() {
		if (tfFruits == null) {
			tfFruits = new JTextField();
			tfFruits.setText("Banana");
			tfFruits.setHorizontalAlignment(SwingConstants.CENTER);
			tfFruits.setColumns(10);
			tfFruits.setBounds(246, 52, 130, 36);
		}
		return tfFruits;
	}
	
	//-----------function -------------
	private void comboAction() {
		
		tfFruits.setText(cbFruits.getSelectedItem().toString());
		
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAction();
				}
			});
			btnAdd.setBounds(56, 199, 130, 29);
		}
		return btnAdd;
	}
	
	private void addAction() {
		cbAdd.addItem(tfAdd.getText()); //db와 연결하여 많은양의 데이터를 for문 돌려서 addItem 
	}
}//end
