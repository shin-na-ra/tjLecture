package com.lec.func;

public class Calc {
	
	//field
	int dan;
	int startNum;
	int endNum;
	
	
	//constructor 
	public Calc() {
		// TODO Auto-generated constructor stub
	}

	public Calc(int dan, int startNum, int endNum) {
		super();
		this.dan = dan;
		this.startNum = startNum;
		this.endNum = endNum;
	}

	//method
	public void gugu() {
		for(int i=startNum; i<=endNum; i++) {
			System.out.println(dan + " X " +i+ " = " + dan*i);
		}
	}
	
	
	
}
