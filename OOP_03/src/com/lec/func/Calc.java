package com.lec.func;

public class Calc {
	
	//property, field
	public int num1;
	public int num2;
	
	//constructor
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	//method
	public void addAction() {
		System.out.println("덧셈 : "+ (num1 + num2));
	}
	
	public void subAction() {
		System.out.println("뺄셈 : "+ (num1 - num2));
	}
	
	public void mulAction() {
		System.out.println("곱셈 : "+ (num1 * num2));
	}
	
	public void divAction() {
		System.out.println("나눗셈 : "+ (num1 / (double)num2));
	}
	
}
