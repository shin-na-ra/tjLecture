package com.lec.base;

import java.security.spec.ECFieldF2m;
import java.util.Scanner;

import com.lec.function.EvenOdd;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EvenOdd evenodd = new EvenOdd();
		
		int firstNum = 0;
		int secondNum = 0;
		
		System.out.print("첫 번째 정수 입력하세요 : ");
		firstNum = scanner.nextInt();
		
		System.out.print("두 번째 정수 입력하세요 : ");
		secondNum = scanner.nextInt();
		
		System.out.println("합 : "+evenodd.sum(firstNum, secondNum));
		System.out.println();
		System.out.println("첫 번째 정수는 "+ evenodd.evenOdd(firstNum));
		System.out.println("두 번째 정수는 "+ evenodd.evenOdd(secondNum));
		
	
		
		
	}

}
