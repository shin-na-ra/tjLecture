package com.lec.base;

import com.lec.func.Calc;

public class Main {

	public static void main(String[] args) {

		Calc calc = new Calc();
		
		calc.num1 = 12;
		calc.num2 = 24;
		
		calc.addAction();
		calc.subAction();
		calc.mulAction();
		calc.divAction();
	}

}
