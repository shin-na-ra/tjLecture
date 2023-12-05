package com.lec.function;

public class SumEvenOdd{
	
	//Field
	
	//Constructor
	public SumEvenOdd() {
		// TODO Auto-generated constructor stub
	}
	
	//Method 
	//1.합계를 구한다. 
	public int sumCalc(int num1, int num2){
		int sum = 0;
		for(int i = num1; i<= num2; i++ ) {
			sum += i;
		}
		return sum;
	}
	
	//2. 합계의 짝수인지 홀수인지 판단
	public String evenOdd(int sum) {
		String result = "";
		if(sum % 2 == 0) {
			return "짝수입니다.";
		}else {
			result = "홀수입니다.";
		}
		return result;
	}
}
