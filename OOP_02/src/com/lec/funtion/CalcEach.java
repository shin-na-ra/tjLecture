package com.lec.funtion;

public class CalcEach {
	
	public CalcEach() {
		// TODO Auto-generated constructor stub
	}
	
	public void calc4(int num1, int num2) {
		// 덧셈, 뺄셈, 곱, 나눗셈
		add(num1, num2);
		substrc(num1, num2);
		mul(num1, num2);
		div(num1, num2);
	}
	
	public void calc3(int num1, int num2) {
		// 덧셈, 뺄셈, 곱
		add(num1, num2);
		substrc(num1, num2);
		mul(num1, num2);
	}
	
	private void add(int num1, int num2) {
		System.out.println("덧셈 : "+ (num1 + num2));
	}
	
	private void substrc(int num1, int num2) {
		System.out.println("뺄셈 : "+ (num1 - num2));
	}
	
	private void mul(int num1, int num2) {
		System.out.println("곱셈 : "+ (num1 * num2));
	}
	
	private void div(int num1, int num2) {
		System.out.println("나눗셈 : "+ (num1 / (double)num2));
	}
}
