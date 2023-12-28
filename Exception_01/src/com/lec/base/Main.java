package com.lec.base;

public class Main {

	public static void main(String[] args) {

		int i = 0;
		int j = 10;
		
		System.out.println("Add : "+ (j+i));
		System.out.println("Sub : "+ (j-i));
		System.out.println("Mul : "+ (j*i));
		
		
		try {
			System.out.println("Div : "+ (j/i));
		} catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
			//e.printStackTrace();
		} finally {
			
		}
		
		
		
	}

}
