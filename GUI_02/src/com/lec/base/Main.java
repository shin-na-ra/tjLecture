package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.lec.function.Addition;
import com.lec.function.Calc;
import com.lec.function.Divide;
import com.lec.function.Multiple;
import com.lec.function.Substration;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Main {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfNum2;
	private JTextField tfNum1;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnDiv;
	private JButton btnMul;
	private JTextField tfNumResult1;
	private JTextField tfNumResult2;
	private JTextField tfResult;
	private JLabel inputLabel;
	private JLabel lblNewLabel_2_1;

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
		frame.getContentPane().setBackground(new Color(244, 221, 223));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnDiv());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getTfNumResult1());
		frame.getContentPane().add(getTfNumResult2());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getInputLabel());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.setTitle("두 개의 숫자 가감승제");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("숫자 1 :");
			lblNewLabel.setBounds(33, 44, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("숫자 2 :");
			lblNewLabel_1.setBounds(33, 99, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() >= '0' && e.getKeyChar() <='9') {
						inputNum2();
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						tfNum2.setText("");
					}
				}
			});
			tfNum2.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					inputNum2();
				}
			});
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(91, 89, 68, 36);
		}
		return tfNum2;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					//textfield에 숫자외의 문자가 입력되면 지우
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
						//정상 case. 숫자가 입력됨
						inputNum1();
					} else {
						JOptionPane.showMessageDialog(null, "숫자 입력하세요!","경고", JOptionPane.ERROR_MESSAGE);
						tfNum1.setText("");
					}
				}
			});
			
			tfNum1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					inputNum1();
				}
			});

			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setColumns(10);
			tfNum1.setBounds(91, 34, 68, 36);
		}
		return tfNum1;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnAdd.setForeground(new Color(254, 20, 13));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculator(1);
				}
			});
			btnAdd.setBackground(new Color(218, 248, 255));
			btnAdd.setBounds(281, 32, 50, 43);
		}
		return btnAdd;
	}
	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculator(2);
				}
			});
			btnSub.setForeground(new Color(233, 118, 27));
			btnSub.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnSub.setBackground(new Color(241, 249, 255));
			btnSub.setBounds(343, 32, 50, 43);
		}
		return btnSub;
	}
	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculator(4);
				}
			});
			btnDiv.setForeground(new Color(0, 0, 0));
			btnDiv.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnDiv.setBackground(new Color(241, 249, 255));
			btnDiv.setBounds(343, 82, 50, 43);
		}
		return btnDiv;
	}
	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("X");
			btnMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calculator(3);
				}
			});
			btnMul.setForeground(new Color(26, 18, 218));
			btnMul.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnMul.setBackground(new Color(241, 249, 255));
			btnMul.setBounds(281, 82, 50, 43);
		}
		return btnMul;
	}
	private JTextField getTfNumResult1() {
		if (tfNumResult1 == null) {
			tfNumResult1 = new JTextField();
			tfNumResult1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			tfNumResult1.setForeground(new Color(64, 54, 243));
			tfNumResult1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNumResult1.setEditable(false);
			tfNumResult1.setColumns(10);
			tfNumResult1.setBounds(47, 181, 68, 36);
		}
		return tfNumResult1;
	}
	private JTextField getTfNumResult2() {
		if (tfNumResult2 == null) {
			tfNumResult2 = new JTextField();
			tfNumResult2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			tfNumResult2.setForeground(new Color(90, 94, 253));
			tfNumResult2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNumResult2.setEditable(false);
			tfNumResult2.setColumns(10);
			tfNumResult2.setBounds(177, 181, 68, 36);
		}
		return tfNumResult2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setEditable(false);
			tfResult.setColumns(10);
			tfResult.setBounds(307, 181, 86, 36);
		}
		return tfResult;
	}
	private JLabel getInputLabel() {
		if (inputLabel == null) {
			inputLabel = new JLabel("+");
			inputLabel.setBounds(138, 191, 42, 16);
		}
		return inputLabel;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("=");
			lblNewLabel_2_1.setBounds(267, 191, 42, 16);
		}
		return lblNewLabel_2_1;
	}
	
	// ----------function --------- 
	
	
	private void inputNum1() {
		tfNumResult1.setText(tfNum1.getText());
	}
	
	private void inputNum2() {
		tfNumResult2.setText(tfNum2.getText());
	}
	
	private void calculator(int num) {
		
		if(tfNum1.getText().equals("") || tfNum2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "숫자를 입력 하세요!");
			
		} else {
			//inputNum1();
			//inputNum2();
			
			Calc calc = new Calc(tfNum1.getText(), tfNum2.getText());
			
			switch (num) {
			case 1:
				inputLabel.setText("+");
				tfResult.setText(calc.add());
				break;
			case 2:
				inputLabel.setText("-");
				tfResult.setText(calc.sub());
				break;
			case 3:
				inputLabel.setText("x");
				tfResult.setText(calc.mul());
				break;
			case 4:
				inputLabel.setText("/");
				if(tfNum2.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다. 다시 입력하세요!");
				} else {
					tfResult.setText(calc.div());
					break;
				}
			}
		}
	
	}
	
}//end
