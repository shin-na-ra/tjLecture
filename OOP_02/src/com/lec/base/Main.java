package com.lec.base;

import java.util.Scanner;

import com.lec.funtion.Calc;
import com.lec.funtion.CalcAll;
import com.lec.funtion.CalcEach;

public class Main {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Calc cal = new Calc();
		CalcAll calAll = new CalcAll();
		CalcEach each = new CalcEach();
		
		int num1 = 0;
		int num2 = 0;

		System.out.print("첫번째 정수를 입력하세요 : ");
		num1 = scanner.nextInt();
		
		System.out.print("두번째 정수를 입력하세요 : ");
		num2 = scanner.nextInt();
		
		System.out.println("덧셈 : " + cal.addAction(num1, num2));
		System.out.println("뺄셈 : " + cal.subAction(num1, num2));
		System.out.println("곱셈 : " + cal.mulAction(num1, num2));
		System.out.println("나눗셈 : " + cal.divAction(num1, num2));
		

		/// -------------
		System.out.println("--------");
		calAll.calc(num1, num2);
		
		System.out.println("----====-");
		each.calc4(num1, num2);
		each.calc3(num1, num2);
		
	}

}
