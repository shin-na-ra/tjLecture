package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.lec.function.Bmi;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class Main {

	private JFrame frmBmi;
	private JLabel lblNewLabel;
	private JTextField tfHeight;
	private JLabel lblCm;
	private JLabel lblNewLabel_1;
	private JTextField tfWeight;
	private JLabel lblKg;
	private JButton btnCalc;
	private JLabel lblResult;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBmi.setVisible(true);
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
		frmBmi = new JFrame();
		frmBmi.setTitle("BMI 계산기");
		frmBmi.setBounds(100, 100, 405, 582);
		frmBmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmi.getContentPane().setLayout(null);
		frmBmi.getContentPane().add(getLblNewLabel());
		frmBmi.getContentPane().add(getTfHeight());
		frmBmi.getContentPane().add(getLblCm());
		frmBmi.getContentPane().add(getLblNewLabel_1());
		frmBmi.getContentPane().add(getTfWeight());
		frmBmi.getContentPane().add(getLblKg());
		frmBmi.getContentPane().add(getBtnCalc());
		frmBmi.getContentPane().add(getLblResult());
		frmBmi.getContentPane().add(getLblImage());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("키 : ");
			lblNewLabel.setBounds(84, 60, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfHeight() {
		if (tfHeight == null) {
			tfHeight = new JTextField();
			tfHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					checkChar(e);
				}
			});
			tfHeight.setBounds(130, 55, 130, 26);
			tfHeight.setColumns(10);
		}
		return tfHeight;
	}
	private JLabel getLblCm() {
		if (lblCm == null) {
			lblCm = new JLabel("cm");
			lblCm.setBounds(275, 60, 61, 16);
		}
		return lblCm;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("몸무게 : ");
			lblNewLabel_1.setBounds(84, 102, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfWeight() {
		if (tfWeight == null) {
			tfWeight = new JTextField();
			tfWeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					checkChar(e);
				}
			});
			tfWeight.setColumns(10);
			tfWeight.setBounds(130, 97, 130, 26);
		}
		return tfWeight;
	}
	private JLabel getLblKg() {
		if (lblKg == null) {
			lblKg = new JLabel("kg");
			lblKg.setBounds(275, 102, 61, 16);
		}
		return lblKg;
	}
	private JButton getBtnCalc() {
		if (btnCalc == null) {
			btnCalc = new JButton("계산하기");
			btnCalc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bmiCalc();
				}
			});
			btnCalc.setBounds(143, 153, 117, 29);
		}
		return btnCalc;
	}
	private JLabel getLblResult() {
		if (lblResult == null) {
			lblResult = new JLabel("");
			lblResult.setHorizontalAlignment(SwingConstants.CENTER);
			lblResult.setBounds(6, 210, 393, 16);
		}
		return lblResult;
	}
	
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/정상.png")));
			lblImage.setBounds(143, 220, 117, 299);
		}
		return lblImage;
	}
	
	//-------------------function 
	private void bmiCalc() {
		int check = inputCheck();
		if(check != 0) {
			JOptionPane.showMessageDialog(null, "항목을 입력하세요!");
		} else {
			calcBmi();
		}
	}
	
	//입력했는지 체크
	private int inputCheck() {
		int checkResult = 0;
		int num = 0;
		if(tfHeight.getText().trim().length() == 0) {
			checkResult++;
			num = 1;
			tfHeight.requestFocus();
		}
		
		if(tfWeight.getText().trim().length() == 0) {
			checkResult++;
			num = 2;
			tfWeight.requestFocus();
		}
		setTextField(num);
		return checkResult;
	}
	
	//bmi 계산 
	private void calcBmi() {
		if(!tfHeight.getText().equals("0")) {
			Bmi bmi = new Bmi(Double.parseDouble(tfHeight.getText()), Double.parseDouble(tfWeight.getText()));
			double bmiCalc = bmi.calcBmi();
			System.out.println("bmiCalc called () : "+bmiCalc); // 1번호
			String str = bmi.resultBmi(bmiCalc);
			getLblImage();
			lblResult.setText("귀하의 BMI 지수는 "+bmiCalc+"이고 "+str+" 입니다.");
			showImages(str);
		}
	}
	
	//문자체크
	private void checkChar(KeyEvent e) {
		if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER || e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
		} else {
			JOptionPane.showMessageDialog(null, "문자만 입력하세요!");
		}
	}
	
	//이미지 보이게 
	private void showImages(String str) {
		lblImage.setIcon(new ImageIcon(Main.class.getResource("/com/lec/images/"+str+".png")));
	}
	
	private void setTextField(int num) {
		if(num == 1) {
			tfHeight.setText("");
		} else if (num == 2) {
			tfWeight.setText("");
		}
	}
}
