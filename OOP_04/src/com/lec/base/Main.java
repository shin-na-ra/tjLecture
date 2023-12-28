package com.lec.base;

import com.lec.func.Calc;

public class Main {

	public static void main(String[] args) {

		Calc cal = new Calc(12, 20);
		
		cal.num1 = 10;
		cal.num2 = 20;
		
		System.out.println("-------");
		cal.calcAll();
	}

}
