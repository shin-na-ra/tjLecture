package com.lec.function;

public class Dto {

	int seqNo;
	String name;
	String telNo;
	String address;
	String email;
	String relation;
	
	public Dto() {
		// TODO Auto-generated constructor stub
	}

	public Dto(int seqNo, String name, String telNo, String relation) {
		super();
		this.seqNo = seqNo;
		this.name = name;
		this.telNo = telNo;
		this.relation = relation;
	}
	

	public Dto(int seqNo, String name, String telNo, String address, String email, String relation) {
		super();
		this.seqNo = seqNo;
		this.name = name;
		this.telNo = telNo;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}	
	
	
	
	
}
