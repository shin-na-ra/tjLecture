package com.lec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lec.function.Dao;
import com.lec.function.Dto;
import com.lec.function.ShareVar;

import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main {

	private JFrame frame;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JRadioButton rbDelete;
	private JRadioButton rbSelect;
	private JComboBox cbSelection;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSelection;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
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
	private JButton btnOk;
	
	//테이블설정 
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblImage;
	private JButton btnFilePath;
	private JTextField tfFIlePath;
	

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
				searchAction();
				screenPartition();
			}
		});
		frame.setTitle("주소록");
		frame.setBounds(100, 100, 456, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRbInsert());
		frame.getContentPane().add(getRbUpdate());
		frame.getContentPane().add(getRbDelete());
		frame.getContentPane().add(getRbSelect());
		frame.getContentPane().add(getCbSelection());
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
		frame.getContentPane().add(getBtnOk());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getTfFIlePath());
	}
	private JRadioButton getRbInsert() {
		if (rbInsert == null) {
			rbInsert = new JRadioButton("입력");
			rbInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbInsert);
			rbInsert.setBounds(17, 23, 62, 23);
		}
		return rbInsert;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정");
			rbUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbUpdate);
			rbUpdate.setBounds(110, 23, 62, 23);
		}
		return rbUpdate;
	}
	private JRadioButton getRbDelete() {
		if (rbDelete == null) {
			rbDelete = new JRadioButton("삭제");
			rbDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbDelete);
			rbDelete.setBounds(212, 23, 62, 23);
		}
		return rbDelete;
	}
	private JRadioButton getRbSelect() {
		if (rbSelect == null) {
			rbSelect = new JRadioButton("검색");
			rbSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			buttonGroup.add(rbSelect);
			rbSelect.setSelected(true);
			rbSelect.setBounds(318, 23, 62, 23);
		}
		return rbSelect;
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(17, 70, 78, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(110, 69, 130, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(285, 69, 117, 29);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 109, 374, 125);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						tableClick();
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("SeqNo : ");
			lblNewLabel.setBounds(34, 261, 130, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqNo() {
		if (tfSeqNo == null) {
			tfSeqNo = new JTextField();
			tfSeqNo.setEditable(false);
			tfSeqNo.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSeqNo.setBounds(124, 256, 53, 26);
			tfSeqNo.setColumns(10);
		}
		return tfSeqNo;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 : ");
			lblNewLabel_1.setBounds(34, 303, 130, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(124, 298, 130, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("전화번호 : ");
			lblNewLabel_1_1.setBounds(33, 349, 130, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfTelNo() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.setColumns(10);
			tfTelNo.setBounds(123, 344, 130, 26);
		}
		return tfTelNo;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("주소 : ");
			lblNewLabel_1_1_1.setBounds(33, 392, 130, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(123, 387, 257, 26);
		}
		return tfAddr;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("전자우편 : ");
			lblNewLabel_1_1_1_1.setBounds(33, 435, 130, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(123, 430, 257, 26);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("관계 : ");
			lblNewLabel_1_1_1_1_1.setBounds(34, 475, 130, 16);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(124, 470, 256, 26);
		}
		return tfRelation;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPartition();
				}
			});
			btnOk.setBounds(285, 248, 117, 29);
		}
		return btnOk;
	}
	
	//function
	//table 초기화 하기 
	private void tableInit() {
		//테이블 컬럼명 정하기 
		outerTable.addColumn("Seq");
		outerTable.addColumn("이름");
		outerTable.addColumn("전화번호");
		outerTable.addColumn("관계");
		outerTable.setColumnCount(4);
		
		
		//테이블 컬럼 크기정하기 
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(50);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(150);
		
		col = innerTable.getColumnModel().getColumn(3);
		col.setPreferredWidth(100);
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		// 테이블 내용 지우기 
		int i = outerTable.getRowCount(); // 5
		for(int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
		
	}
	
	//검색  
	private void searchAction() {
		Dao dao = new Dao();
		ArrayList<Dto> dtoList = dao.selectList();
		
		int listCnt = dtoList.size();
		for(int i = 0; i < listCnt; i++) {
			String temp = Integer.toString(dtoList.get(i).getSeqNo());
			String[] qTxt = {temp, dtoList.get(i).getName(), dtoList.get(i).getTelNo(), dtoList.get(i).getRelation() };
			outerTable.addRow(qTxt);
			
		}
	}
	
	
	//edit 결정 
	private void screenPartition() {
		//검색일 경우
		if(rbSelect.isSelected() == true) {
			btnOk.setVisible(false);
			tfName.setEditable(false);
			tfTelNo.setEditable(false);
			tfEmail.setEditable(false);
			tfRelation.setEditable(false);
			tfAddr.setEditable(false);
		}
		
		// 입력과 수정 일 경우
		if(rbInsert.isSelected() == true || rbUpdate.isSelected() == true) {
			btnOk.setVisible(true);
			tfName.setEditable(true);
			tfTelNo.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);
			tfAddr.setEditable(true);
		}
		
		//삭제일 경우 
		if(rbDelete.isSelected() == true) {
			btnOk.setVisible(true);
			tfName.setEditable(false);
			tfTelNo.setEditable(false);
			tfEmail.setEditable(false);
			tfRelation.setEditable(false);
			tfAddr.setEditable(false);
		}
		
	}
	
	//테이블에서 row를 클릭 했을 때 
	private void tableClick() {
		int i = innerTable.getSelectedRow();
		String tkSequence = (String) innerTable.getValueAt(i, 0);
		int wkSequence = Integer.parseInt(tkSequence);
		
		Dao dao = new Dao(wkSequence);
		Dto dto = dao.tableClick();
		
		tfSeqNo.setText(Integer.toString(dto.getSeqNo()));
		tfName.setText(dto.getName());
		tfTelNo.setText(dto.getTelNo());
		tfAddr.setText(dto.getAddress());
		tfEmail.setText(dto.getEmail());
		tfRelation.setText(dto.getRelation());
		
		//Image 처리 : filename이달라야 보여주기가 가능 
		String filePath = Integer.toString(ShareVar.filename);
		//tfFIlePath.setText(filePath);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
	
	}
	
	private void actionPartition() {
		//검색일 때
		if(rbSelect.isSelected() == true) {
			screenPartition();
		}
		//입력
		if(rbInsert.isSelected() == true) {
			if(insertFieldCheck() == 0) {
				insertAction();
				tableInit();
				searchAction();
				clearColumn();
			} else {
				JOptionPane.showMessageDialog(null, "데이터를 확인하세요.");
			}
			
			screenPartition();
		}
		//수정
		if(rbUpdate.isSelected() == true) {
			if(insertFieldCheck() == 0) {
				updateAction();
				tableInit();
				searchAction();
				clearColumn();
			} else {
				JOptionPane.showMessageDialog(null, "데이터를 확인하세요.");
			}
			
			screenPartition();
		}
		
		//삭제 
		if(rbDelete.isSelected() == true) {
			deleteAction();
			tableInit();
			searchAction();
			clearColumn();
			screenPartition();
		}
	}
	

	private int insertFieldCheck() {
		int i = 0;
		if(tfName.getText().trim().length() == 0) {
			i++;
			tfName.requestFocus();
		}
		if(tfTelNo.getText().trim().length() == 0) {
			i++;
			tfTelNo.requestFocus();
		}
		if(tfAddr.getText().trim().length() == 0) {
			i++;
			tfAddr.requestFocus();
		}
		if(tfEmail.getText().trim().length() == 0) {
			i++;
			tfEmail.requestFocus();
		}
		if(tfRelation.getText().trim().length() == 0) {
			i++;
			tfRelation.requestFocus();
		}
		return i;
	}
	
	private void clearColumn(){
		tfSeqNo.setText("");
		tfName.setText("");
		tfTelNo.setText("");
		tfAddr.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
	}
	
	private void insertAction() {
		String name = tfName.getText().trim();
		String telNo = tfTelNo.getText().trim();
		String address = tfAddr.getText().trim();
		String email = tfEmail.getText().trim();
		String relation = tfRelation.getText().trim();
		
		//imgee file 
		FileInputStream input = null;
		File file = new File(tfFIlePath.getText()); 
		try {
			input = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Dao dao = new Dao(name, telNo, address, email, relation, input);
		if(dao.insertAction() == true) {
			JOptionPane.showMessageDialog(null, tfName.getText()+"님 정보가 입력되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력 중 문제가 발생했습니다.");
		}
	}
	

	private void updateAction() {
		int seqno = Integer.parseInt(tfSeqNo.getText());
		
		String name = tfName.getText().trim();
		String telNo = tfTelNo.getText().trim();
		String address = tfAddr.getText().trim();
		String email = tfEmail.getText().trim();
		String relation = tfRelation.getText().trim();
		
		FileInputStream input = null;
		File file = new File(tfFIlePath.getText()); 
		try {
			input = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Dao dao = new Dao(seqno, name, telNo, address, email, relation, input);
		
		if(dao.updateAction() == true) {
			JOptionPane.showMessageDialog(null, tfName.getText()+"님 정보가 수정되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력 중 문제가 발생했습니다.");
		}
	}
	
	private void deleteAction() {
		int seqno = Integer.parseInt(tfSeqNo.getText());
		Dao dao = new Dao(seqno);
		
		if(dao.deleteAction() == true) {
			JOptionPane.showMessageDialog(null, tfName.getText()+"님 정보가 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력 중 문제가 발생했습니다.");
		}
	}
	
	private void conditionQuery() {
		int cbChk = cbSelection.getSelectedIndex();
		String result = "";
		switch(cbChk) {
		case 0:
			result = "name";
			break;
		case 1:
			result = "address";
			break;
		case 2:
			result = "relation";
			break;
		}
		
		tableInit();
		clearColumn();
		conditionQueryAction(result);
	}
	
	private void conditionQueryAction(String str) {
		String search = tfSelection.getText();
		Dao dao = new Dao();
		ArrayList<Dto> dtoList = dao.conditionQueryAction(str, search);
		
		int listCnt = dtoList.size();
		for(int i = 0; i < listCnt; i++) {
			String temp = Integer.toString(dtoList.get(i).getSeqNo());
			String[] qTxt = {temp, dtoList.get(i).getName(), dtoList.get(i).getTelNo(), dtoList.get(i).getRelation() };
			outerTable.addRow(qTxt);
		}
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBackground(Color.ORANGE);
			lblImage.setBounds(27, 520, 195, 138);
		}
		return lblImage;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("file경로");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnFilePath.setBounds(235, 544, 117, 29);
		}
		return btnFilePath;
	}
	private JTextField getTfFIlePath() {
		if (tfFIlePath == null) {
			tfFIlePath = new JTextField();
			tfFIlePath.setBounds(233, 589, 217, 26);
			tfFIlePath.setColumns(10);
		}
		return tfFIlePath;
	}
	
	private void filePath() {
		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png", "bmp", "jpeg");
		choose.setFileFilter(filter);
		
		int ret = choose.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하세요.");
			return;
		}
		
		String filePath = choose.getSelectedFile().getPath(); //파일 경로가져오기
		tfFIlePath.setText(filePath);						// tf에 파일 경로 넣어주
		lblImage.setIcon(new ImageIcon(filePath));				// 이미지넣어주고 
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
