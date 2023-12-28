package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserQuery {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable inner_Table;
	private JLabel lblNewLabel;
	private JTextField tfSeqNo;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_2;
	private JTextField tfTelNo;
	private JLabel lblNewLabel_2_1;
	private JTextField tfAddr;
	private JLabel lblNewLabel_3;
	private JTextField tfEmail;
	private JLabel lblNewLabel_4;
	private JTextField tfRelation;
	
	//**************************************** Don't forget **************************************** 
	//데이터베이스 & 테이블
	private final DefaultTableModel outer_Table = new DefaultTableModel();
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root"; // id가 root로 되어있어야하고 from host가 %로 되어 있어야한다.
	private final String pw_mysql = "qwer1234";
	private JButton btnUpdate;
	private JButton btnDelete;
	//**************************************** Don't forget **************************************** 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserQuery window = new UserQuery();
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
	public UserQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("주소록 검색/수정/삭제");
		frame.setBounds(100, 100, 425, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqNo());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfTelNo());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfAddr());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnDelete());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(24, 17, 74, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(119, 16, 130, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(264, 16, 117, 29);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 56, 351, 94);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (inner_Table == null) {
			inner_Table = new JTable();
			inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						tableClick();
					}
				}
			});
			inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			//**************************************** Don't forget **************************************** 
			inner_Table.setModel(outer_Table);
			//**************************************** Don't forget **************************************** 
		}
		return inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sequence No");
			lblNewLabel.setBounds(37, 177, 109, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqNo() {
		if (tfSeqNo == null) {
			tfSeqNo = new JTextField();
			tfSeqNo.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSeqNo.setBounds(131, 172, 66, 26);
			tfSeqNo.setColumns(10);
		}
		return tfSeqNo;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(34, 215, 109, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(128, 210, 130, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setBounds(37, 261, 109, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfTelNo() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.setColumns(10);
			tfTelNo.setBounds(131, 256, 176, 26);
		}
		return tfTelNo;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("주소");
			lblNewLabel_2_1.setBounds(37, 299, 109, 16);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(131, 294, 250, 26);
		}
		return tfAddr;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전자우편");
			lblNewLabel_3.setBounds(37, 337, 109, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(131, 332, 250, 26);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("관계");
			lblNewLabel_4.setBounds(37, 375, 109, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(131, 370, 250, 26);
		}
		return tfRelation;
	}
	
	//----------funtion
	
	//컬럼데이터도 가져오고, 데이터도 지워줘야한다.=> 지우고 불러오고 지우고 불러오고=> 검색기능떄문에 
	//테이블의 컬럼을 정의하고 데이터 내용을 초기화 시킨다.
	private void tableInit() {	
		outer_Table.addColumn("순서");
		outer_Table.addColumn("이름");
		outer_Table.addColumn("전화번호");
		outer_Table.addColumn("관계");
		outer_Table.setColumnCount(4); // 컬럼이 몇개인지 알려줘야한다.
		
		
		//순서 컬럼 크기 정하기 => 컬럼은 0번부터 시작
		int colNo = 0;
		TableColumn col = inner_Table.getColumnModel().getColumn(colNo);
		int width = 30;
		col.setPreferredWidth(width);
		
		//이름 컬럼 크기 정하기 
		colNo = 1;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 70;
		col.setPreferredWidth(width);
		
		//전화번호 컬럼 크기 정하기 
		colNo = 2;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		//관계 컬럼 크기 정하기 
		colNo = 3;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		

		
		//초기화 시키기 
		int i = outer_Table.getRowCount(); //데이터가 몇개인지 
		for(int j = 0; j <i; j++) {
			outer_Table.removeRow(0); 	//0번만 지움. 
		}
		
		
		//inner_table resize 끄기 
		inner_Table.setAutoResizeMode(inner_Table.AUTO_RESIZE_OFF);
		
	}
	
	
	private void searchAction() {
		String query = "select seqno, name, telno, relation from userinfo";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(query);	//검색은 executeQuery. db에서 위 쿼리를 실행한 뭉태기를 rs에 넣어줌 
			
			while(rs.next()) { //next() : 다음줄에 데이터가 있냐 없냐 
//				rs.getInt(1);	//아직 배열이 아니므로 1로 가져와도 된다.
//				rs.getString(2);
//				rs.getString(3);
//				rs.getString(4);
	
				
				//잘 되는지 테스트 => 마지막 데이터만 보여지면 성공!
				// 쌓여서 보여지고 싶을 때는 배열에 집어넣어야 한다.
//				tfSeqNo.setText(Integer.toString(rs.getInt(1);
//				tfName.setText(rs.getString(2));
//				tfTelNo.setText(rs.getString(3));
//				tfRelation.setText(rs.getString(4));
				
				//위에서 나온데이터를 테이블에 한줄씩 넣어주기 위해 데이터들을 배열에 넣어줘서 outer_table에 집어넣는다. 
				//while문이 계속돌면 배열은 초기값이니.. 데이터가 없는상태에서 시작된다.
				//데이터들을 한번에 집어넣는 것은 outer_table을 사용한다. -> 하나하나씩의 데이터를 보려면은 그 때 inner_table을 사용한다.
				String[] qTxt = {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
				outer_Table.addRow(qTxt);

			}
			
			conn_mysql.close(); 


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void tableClick() {
		int i = inner_Table.getSelectedRow(); // 몇번째 row를 클릭했는지
		String seqno =(String) inner_Table.getValueAt(i, 0);	//선택한 row의 pK인 seqno를 가져온다. //getValueAt은 Object여서 String으로 가져와서 밑에서 int로 바꿔줘야한다. 
		
		String query = "select seqno, name, telno, address, email, relation from userinfo ";
		String query1 = "where seqno="+Integer.parseInt(seqno);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(query+query1);	//검색은 executeQuery. db에서 위 쿼리를 실행한 뭉태기를 rs에 넣어줌 
			
			while(rs.next()) { //next() : 다음줄에 데이터가 있냐 없냐 
				tfSeqNo.setText(Integer.toString(rs.getInt(1)));
				tfName.setText(rs.getString(2));
				tfTelNo.setText(rs.getString(3));
				tfAddr.setText(rs.getString(4));
				tfEmail.setText(rs.getString(5));
				tfRelation.setText(rs.getString(6));
			}
			
			conn_mysql.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void conditionQuery() {
		
		int i = cbSelection.getSelectedIndex();
		String conditionQueryName = "";
		
		switch(i) {
		case 0:
			conditionQueryName = "name";
			break;
		case 1:
			conditionQueryName = "address";
			break;
		case 2:
			conditionQueryName = "relation";
			break;
		default :
			break;
		}
		
		
		tableInit();	//전에 검색했던 내용 지워주기 
		clearColumn(); //상세보기의 데이터도 지워주기 
		conditionQueryAction(conditionQueryName);
		
	}
	
	private void clearColumn() {
		tfSeqNo.setText("");
		tfName.setText("");
		tfAddr.setText("");
		tfTelNo.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
	}
	
	private void conditionQueryAction(String conditionQueryName) {
				
		String query = "select * from userinfo where "+conditionQueryName;
		String query1 = " like '%" + tfSelection.getText()+"%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(query+query1);	//검색은 executeQuery. db에서 위 쿼리를 실행한 뭉태기를 rs에 넣어줌 
			
			while(rs.next()) { //next() : 다음줄에 데이터가 있냐 없냐 
				String[] qTxt = {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
				outer_Table.addRow(qTxt);
			}
			
			conn_mysql.close(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnUpdate.setBounds(146, 419, 117, 29);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnDelete.setForeground(new Color(255, 25, 15));
			btnDelete.setBounds(275, 419, 117, 29);
		}
		return btnDelete;
	}
	
	private void update() {
		updateAction();
		tableInit();
		clearColumn();
		searchAction();
		
	}
	
	private void updateAction () {
		PreparedStatement ps = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			String query = "update userinfo set name=?, telno=?, address=?, email=?, relation=? "; 
			String query1 = " where seqno=?";

			ps = conn_mysql.prepareStatement(query + query1); 
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfTelNo.getText().trim());
			ps.setString(3, tfAddr.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			ps.setInt(6, Integer.parseInt(tfSeqNo.getText()));
			
			ps.executeUpdate(); 
			conn_mysql.close(); 

			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void delete() {
		deleteAction();
		tableInit();
		clearColumn();
		searchAction();
	}
	
	private void deleteAction() {
		PreparedStatement ps = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			String query = "delete from userinfo where seqno=?"; 

			ps = conn_mysql.prepareStatement(query ); 
			ps.setInt(1, Integer.parseInt(tfSeqNo.getText()));
			
			ps.executeUpdate(); 
			conn_mysql.close(); 

			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 삭제되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
