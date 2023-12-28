package com.lec.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {

	//field

	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	//테이블에 있는정보로 모델을 만든다.
	int seqNo;
	String name;
	String telNo;
	String address;
	String email;
	String relation;
	FileInputStream file;
	
	
	//constructor
	public Dao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Dao(int seqNo) {
		super();
		this.seqNo = seqNo;
	}

	
	public Dao(String name, String telNo, String address, String email, String relation , FileInputStream file) {
		super();
		this.name = name;
		this.telNo = telNo;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.file = file;
	}


	public Dao(int seqNo, String name, String telNo, String address, String email, String relation, FileInputStream file) {
		super();
		this.seqNo = seqNo;
		this.name = name;
		this.telNo = telNo;
		this.address = address;
		this.email = email;
		this.relation = relation;
		this.file = file;
	}



	public Dao(String str, String search) {
		// TODO Auto-generated constructor stub
	}


	//검색 결과를 테이블로 보내자 
	public ArrayList<Dto> selectList() {
		ArrayList<Dto> dtoList = new ArrayList<Dto>();
		String whereDefault = "select seqno, name, telno, relation from userinfo";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(whereDefault);
			
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkTelNo = rs.getString(3);
				String wkRelation = rs.getString(4);
				
				//가져온값을 한번에 넣어준다. 
				Dto dto = new Dto(wkSeq, wkName, wkTelNo, wkRelation);
				
				//그 다음에 리스트에 한줄로 넣어준다. 쿠하하
				dtoList.add(dto);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	// 데이터 하나이므로 dto로받으면 된다.
	public Dto tableClick() {
		Dto dto = null;
		
		String where1 = "select seqno, name, telno, address, email, relation, file from userinfo ";
		String where2 = " where seqno ="+seqNo;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(where1 + where2);
			
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkTelNo = rs.getString(3);
				String wkAddress = rs.getString(4);
				String wkEmail = rs.getString(5);
				String wkRelation = rs.getString(6);
				
				//file
				//파일이름 설정 
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(7);
				System.out.println("input : "+input);
				
				byte[] buffer = new byte[1024];	//파일 크기 만듬 
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				
				//가져온값을 한번에 넣어준다. 
				dto = new Dto(wkSeq, wkName, wkTelNo, wkAddress, wkEmail, wkRelation);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	
	public boolean insertAction() {
		PreparedStatement ps = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String where1 = "insert into userinfo (name, telno, address, email, relation, file";
			String where2 = ") values (?,?,?,?,?,?)";
			ps = conn.prepareStatement(where1 + where2);
			
			ps.setString(1, name);
			ps.setString(2, telNo);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, relation);
			ps.setBinaryStream(6, file);
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateAction() {
		PreparedStatement ps = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String where1 = " update userinfo set  name=? , telno=?, address=?, email=?, relation=?, file=? where seqno = ?";
			ps = conn.prepareStatement(where1);
			
			ps.setString(1, name);
			ps.setString(2, telNo);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, relation);
			ps.setInt(6, seqNo);
			ps.setBinaryStream(7, file);
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteAction() {
		PreparedStatement ps = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String where1 = " delete from userinfo where seqno = "+seqNo;
			ps = conn.prepareStatement(where1);
			
		//	ps.setInt(1, seqNo);
			
			ps.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<Dto> conditionQueryAction(String colName, String value) {
		ArrayList<Dto> dtoList = new ArrayList<Dto>();
		String query = "select * from userinfo where "+colName;
		String query1 = " like '%" + value +"%'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query+query1);
			
			while(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkTelNo = rs.getString(3);
				String wkAddress = rs.getString(4);
				String wkEmail = rs.getString(5);
				String wkRelation = rs.getString(6);
				
				//가져온값을 한번에 넣어준다. 
				Dto dto = new Dto(wkSeq, wkName, wkTelNo, wkAddress, wkEmail, wkRelation);
				
				//그 다음에 리스트에 한줄로 넣어준다. 쿠하하
				dtoList.add(dto);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
}
