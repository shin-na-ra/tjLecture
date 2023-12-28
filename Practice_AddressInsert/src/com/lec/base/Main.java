package com.lec.base;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
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

public class Main {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu backMenu;
	private JMenu forwardMenu;
	private JComboBox cbSelect;
	private JTextField tfSelection;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable inner_Table;
	private JLabel lblNewLabel;
	private JTextField tfSeqNo;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_1_1;
	private JTextField tfTelNo;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tfAddr;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField tfEmail;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JTextField tfRelation;
	
	//설정
	private final DefaultTableModel outer_Table = new DefaultTableModel();
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				showInit();
			}
		});
		frame.setTitle("주소록 검색");
		frame.setBounds(100, 100, 466, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(getMenuBar());
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelect());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqNo());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTfTelNo());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getTfAddr());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1_1());
		frame.getContentPane().add(getTfRelation());
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBackMenu());
			menuBar.add(getForwardMenu());
		}
		return menuBar;
	}
	private JMenu getBackMenu() {
		if (backMenu == null) {
			backMenu = new JMenu("");
			
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_4187319.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			backMenu.setIcon(updateIcon);
			
		}
		return backMenu;
	}
	private JMenu getForwardMenu() {
		if (forwardMenu == null) {
			forwardMenu = new JMenu("");
			
			ImageIcon icon = new ImageIcon("/Users/tj/Downloads/—Pngtree—vector back icon_41873190.png");
			Image image = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			ImageIcon updateIcon = new ImageIcon(image);
			forwardMenu.setIcon(updateIcon);
			
		}
		return forwardMenu;
	}
	private JComboBox getCbSelect() {
		if (cbSelect == null) {
			cbSelect = new JComboBox();
			cbSelect.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계", "전화번호"}));
			cbSelect.setBounds(25, 19, 85, 27);
		}
		return cbSelect;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(108, 18, 211, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(327, 18, 117, 29);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 59, 419, 130);
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
					tblClicked();
				}
			});
			inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_Table.setModel(outer_Table);
		}
		return inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("번호");
			lblNewLabel.setBounds(25, 221, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqNo() {
		if (tfSeqNo == null) {
			tfSeqNo = new JTextField();
			tfSeqNo.setEditable(false);
			tfSeqNo.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSeqNo.setBounds(108, 216, 335, 26);
			tfSeqNo.setColumns(10);
		}
		return tfSeqNo;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(25, 259, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(108, 254, 335, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("전화번호");
			lblNewLabel_1_1.setBounds(25, 297, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfTelNo() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.setEditable(false);
			tfTelNo.setColumns(10);
			tfTelNo.setBounds(108, 292, 335, 26);
		}
		return tfTelNo;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("주소");
			lblNewLabel_1_1_1.setBounds(27, 340, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setEditable(false);
			tfAddr.setColumns(10);
			tfAddr.setBounds(110, 335, 335, 26);
		}
		return tfAddr;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("이메일");
			lblNewLabel_1_1_1_1.setBounds(25, 387, 61, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(108, 382, 335, 26);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("관계");
			lblNewLabel_1_1_1_1_1.setBounds(26, 425, 61, 16);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setEditable(false);
			tfRelation.setColumns(10);
			tfRelation.setBounds(109, 420, 335, 26);
		}
		return tfRelation;
	}
	
	//테이블의 컬럼을 정의하고, 테이블 데이터의 내용을 초기화
	private void tableInit() {
		outer_Table.addColumn("순서");
		outer_Table.addColumn("이름");
		outer_Table.addColumn("전화번호");
		outer_Table.addColumn("관계");
		outer_Table.setColumnCount(4);;
		
		int colNo = 0;
		TableColumn col = inner_Table.getColumnModel().getColumn(colNo);
		int width = 30;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 80;
		col.setPreferredWidth(width);
		
		colNo = 2;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = inner_Table.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		

		//초기화
		int i = outer_Table.getRowCount();
		for(int j = 0; j < i; j++) {
			outer_Table.removeRow(0);
		}
		
		inner_Table.setAutoResizeMode(inner_Table.AUTO_RESIZE_OFF);
	}
	
	//초기화면 보여주기 
	private void showInit() {
		String query = "select seqno, name, telno, relation from userinfo";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(query);
			while(rs.next()) {
				String[] qtxt = {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4)}; 
				outer_Table.addRow(qtxt);
			}
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void tblClicked() {
		int i = inner_Table.getSelectedRow();
		String seqno = (String)inner_Table.getValueAt(i, 0);
		
		String query = "select seqno, name, telno, address, email ,relation from userinfo ";
		String query1 = "where seqno="+Integer.parseInt(seqno);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 

			ResultSet rs = stmt_mysql.executeQuery(query);
			while(rs.next()) {
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
}
