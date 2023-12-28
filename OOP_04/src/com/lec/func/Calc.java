package com.lec.func;

public class Calc {

	//field
	public int num1 = 0;
	public int num2 = 0;
	
	//constructor
	public Calc() {
		
	}

	public Calc(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		addAction();
	}
	
	public void calcAll() {
		String arr[] = {addAction(), subAction(), mulAction(), divAction()};
			
		for (int i=0; i<arr.length; i++) {
			String a = arr[i];
		}
//		addAction();
//		subAction();
//		mulAction();
//		divAction();
	}
	
	
	//method
	public String addAction() {
		System.out.println("덧셈 : "+ (num1 + num2));
		return "";
	}
	
	public String subAction() {
		System.out.println("뺄셈 : "+ (num1 - num2));
		return "";
	}
	
	public String mulAction() {
		System.out.println("곱셈 : "+ (num1 * num2));
		return "";
	}
	
	public String divAction() {
		System.out.println("나눗셈 : "+ (num1 / (double)num2));
		return "";
	}
}
