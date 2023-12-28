package com.lec.function;

public class Add {

	int num1;
	int num2;
	 
	public Add() {
		// TODO Auto-generated constructor stub
	}

	public Add(String num1, String num2) {
		super();
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}
	
	public String add() {
		int sum = 0;
		
		if(num1 < num2) {
			for(int i = num1; i <= num2; i++) {
				sum += i;
			}
		} else {
			for(int i = num1; i >= num2; i--) {
				sum += i;
			}
		}
		
		return Integer.toString(sum);
	}
	
}
