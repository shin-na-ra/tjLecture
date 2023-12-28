package com.lec.function;

public class Calc {

	int num1;
	int num2;
	
	public Calc() {
		
	}

	public Calc(String num1, String num2) {
		super();
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}
	
	public String add() {
		return Integer.toString(num1 + num2);
	}
	
	public String sub() {
		return Integer.toString(num1 - num2);
	}
	
	public String mul() {
		return Integer.toString(num1 * num2);
	}
	
	public String div() {
		String result;
		if(num2 == 0) {
			result ="";
		} else {
			result = String.format("%.3f", (double)num1/num2);
		}
		
		return result;
	}
	
}
