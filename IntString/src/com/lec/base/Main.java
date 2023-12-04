package com.lec.base;

public class Main {

	public static void main(String[] args) {
		
		int num1 = 123;
		String str1 = "12345";
		
		System.out.println(str1.concat(Integer.toString(num1)));
		System.out.println(num1 + Integer.parseInt(str1));
	}

}
