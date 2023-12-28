package com.lec.func;

public class Add {

	int num1;
	int num2;
	int sum;
	
	public Add() {
		// TODO Auto-generated constructor stub
	}

	public Add(String num1, String num2) {
		super();
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}

	
	public void change() {
		int tmp;
		if(num1 < num2) {
		} else {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
	}
	
	public String wholeAdd() {
		
		change();
		
		for(int i = num1; i <=num2; i++) {
			sum += i;
		}
		return Integer.toString(sum);
	}
	
	public String evenAdd() {
		change();
		
		for(int i = num1; i <=num2; i++) {
			if(i % 2 == 0) {
				sum += i;	
			}
		}
		return Integer.toString(sum);
	}
	
	public String oddAdd() {
		change();
		
		for(int i = num1; i <=num2; i++) {
			if(i % 2 != 0) {
				sum += i;	
			}
		}
		return Integer.toString(sum);
	}
	
}
