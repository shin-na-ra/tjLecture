package com.lec.function;

public class EvenOdd {

	public EvenOdd() {
		// TODO Auto-generated constructor stub
	}
	
	public int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	public String evenOdd(int num1) {
		String result = "";
		if(num1 % 2 == 0) {
			result ="짝수입니다.";
		} else {
			result = "홀수입니다.";
		}
		return result;
	}
}
