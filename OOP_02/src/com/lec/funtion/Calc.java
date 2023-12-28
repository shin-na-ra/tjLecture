package com.lec.funtion;

public class Calc {

	
	//Field
	
	
	
	
	//Constructor
	public Calc() {

	}
	
	
	//Method
	// >> 덧셈
	public int addAction(int num1, int num2) {
		return (num1 + num2);
	}
	
	// >>뺄셈
	public int subAction(int num1, int num2) {
		return (num1 - num2);
	}
	
	// >>곱셈
	public int mulAction(int num1, int num2) {
		return (num1 * num2);
	}
	
	// >>나눗셈
	public double divAction(int num1, int num2) {
		return (num1 / (double) num2);
	}
	
}
