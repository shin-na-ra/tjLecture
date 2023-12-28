package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserInsert {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JTextField tfTelNo;
	private JLabel lblNewLabel_1_1;
	private JTextField tfAddress;
	private JLabel lblNewLabel_2;
	private JTextField tfEmail;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField tfRelation;
	private JButton btnOk;

	// 데이터베이스 환경 정의
	// mysql 주소넣기 => 바뀌면 안되니 final
	// jdbc:mysql://localaddress ip :
	// 127.0.0.1/스키마이름?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root"; // id가 root로 되어있어야하고 from host가 %로 되어 있어야한다.
	private final String pw_mysql = "qwer1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInsert window = new UserInsert();
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
	public UserInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("주소록 등록");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfTelNo());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getBtnOk());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("성명 : ");
			lblNewLabel.setBounds(43, 26, 61, 16);
		}
		return lblNewLabel;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nameCheck();
				}
			});
			;
			tfName.setBounds(125, 21, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호 : ");
			lblNewLabel_1.setBounds(43, 59, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JTextField getTfTelNo() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					phoneCheck();
				}
			});
			tfTelNo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyCode() == KeyEvent.VK_ENTER
							|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '-'
							|| e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_SPACE) {
					} else {
						JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
					}
				}
			});
			tfTelNo.setColumns(10);
			tfTelNo.setBounds(125, 54, 130, 26);
		}
		return tfTelNo;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("주소 : ");
			lblNewLabel_1_1.setBounds(43, 92, 61, 16);
		}
		return lblNewLabel_1_1;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					checkSymbolForAddr(e);
				}
			});
			tfAddress.setColumns(10);
			tfAddress.setBounds(125, 87, 269, 26);
		}
		return tfAddress;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전자우편 : ");
			lblNewLabel_2.setBounds(43, 125, 61, 16);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					//checkSymbolForEmail(e);
				}
			});
			tfEmail.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					emailCheck();
				}
			});

			tfEmail.setColumns(10);
			tfEmail.setBounds(125, 120, 269, 26);
		}
		return tfEmail;
	}

	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("관계 :");
			lblNewLabel_1_1_1_1.setBounds(43, 158, 61, 16);
		}
		return lblNewLabel_1_1_1_1;
	}

	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					//relationCheck(e);
				}
			});
			tfRelation.setColumns(10);
			tfRelation.setBounds(125, 153, 269, 26);
		}
		return tfRelation;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("입력");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
				}
			});
			btnOk.setBounds(165, 223, 117, 29);
		}
		return btnOk;
	}

	private void insertAction() {
		PreparedStatement ps = null; // 문자열을 sql로 바꿔준다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 미드웨어 이름 - mysql버전마다 드라이버 이름 달라진다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // getConnection으로 연결시켜줌
			// 검색은 statement가 필요하다. 검색은 db에서 가져와야함으로
			Statement stmt_mysql = conn_mysql.createStatement(); // connection으로 검색내용을 가져온다.

			String query = "insert into userinfo (name, telno, address, email, relation) "; // 반드시 띄어쓰기 해야한다.
			String query1 = "values (?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1); // 문자열을 sql로 바꿔주고 connection으로 연결한다. query+quer1의 sql을 쓸거야
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfTelNo.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());

			ps.executeUpdate(); // insert delete update는 excuteupdate사용. executeUpdate()로 위에서 setString한 값들을 db에
								// 넣어준다.
								// conCurrentUser가 5명이다.: 같은시간에 동시접속한 유저, 웹에서는 큰 문제이. 웹은 db에 계속 붙어있다.
			conn_mysql.close(); // 다른 사람도 볼 수 있게 connection을 끊어줘야한다.

			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력 되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 이메일 형식 체크 메소드
	private void emailCheck() {
		final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(tfEmail.getText().toString());
		
		if(!tfEmail.getText().equals("")) {
			if (!(matcher.matches())) {
				JOptionPane.showMessageDialog(null, "<html>이메일 형식이 아닙니다!<br> ex) example@naver.com</html>");
				tfEmail.requestFocus();
				tfEmail.setText("");
			}
		} 
	}

	
	// 전화번호 형식 체크 메소드
	private void phoneCheck() {
		final String PHONE_CHECK = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		
		if(!tfTelNo.getText().equals("")) {
			if (!(Pattern.matches(PHONE_CHECK, tfTelNo.getText()))) {
				JOptionPane.showMessageDialog(null, "<html>전화번호 형식이 아닙니다! <br> ex) 010-0000-0000 </html>");
				tfTelNo.requestFocus();
				tfTelNo.setText("");
			}
		} 
	}
	
	// 주소에 특수문자 체크 메소드
	private void checkSymbolForAddr(KeyEvent e) {
		final String CHECK = "[ !@#$%^&*,.?\\\":{}|<>]";
		
		if(!tfAddress.getText().equals("")) {
			if ((Pattern.matches(CHECK, tfAddress.getText()))) {
				JOptionPane.showMessageDialog(null, "특수문자는 입력할 수 없습니다.");
				tfAddress.requestFocus();
				tfAddress.setText("");
			}
		}
	}

	
	
	
	
	
	
	
	// 관계체크 메소드
//	private void relationCheck(KeyEvent e) {
//		Pattern pattern = Pattern.compile("[ !@#$%^&*,.?\":{}|<>]");
//		Matcher matcher = pattern.matcher(tfRelation.getText().toString());
//		if (matcher.matches()) {
//			JOptionPane.showMessageDialog(null, "특수문자 입력못해요!!!");
//		} else {
//			if ((e.getKeyCode() == KeyEvent.VK_ENTER
//					|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '-'
//					|| e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_SPACE)) {
//				JOptionPane.showMessageDialog(null, "문자만 입력하세요!");
//			}
//		}
//		tfRelation.requestFocus();
//		tfRelation.setText("");
//	}
//
//
//	// 이름체크 메소드
	private void nameCheck() {
		
		Pattern pattern = Pattern.compile("[ !@#$%^&*,.?\":{}|<>]");
		Matcher matcher = pattern.matcher(tfName.getText().toString());
		if (matcher.matches()) {
			JOptionPane.showMessageDialog(null, "특수문자 입력못해요!!!");
		}
		
//		
//		if ((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '-'
//				|| e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_SPACE)) {
//			
//			
//		} else {
//			JOptionPane.showMessageDialog(null, "문자만 입력하세요!");
//			
//			tfName.requestFocus();
//			tfName.setText("");
//	
//		}
	}


	

	// 이메일에 특수문자 체크 메소드
//	private void checkSymbolForEmail(KeyEvent e) {
//		Pattern pattern = Pattern.compile("[ !@#$%^&*,.?\":{}|<>]");
//		Matcher matcher = pattern.matcher(tfEmail.getText().toString());
//		if (matcher.matches()) {
//			JOptionPane.showMessageDialog(null, "특수문자는 입력되지 않습니다.");
//			tfEmail.setText("");
//		}
//	}

}
