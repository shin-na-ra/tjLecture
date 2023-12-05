package com.lec.base;

import java.util.Scanner;

import com.lec.function.SumEvenOdd;

public class Main {

	public static void main(String[] args) {
		//범위의 합계를 구하고 홀수 짝수 판별한다.
		int startNum = 0;
		int endNum = 0;
		int sum = 0;
		
		Scanner scanner = new Scanner(System.in);
		SumEvenOdd evenodd = new SumEvenOdd(); //객체를 불러온다.
		
		System.out.print("범위의 숫자 중 작은 숫자 : ");
		startNum = scanner.nextInt();
		
		System.out.print("범위의 숫자 중 큰 숫자 : ");
		endNum = scanner.nextInt();
		
		sum = evenodd.sumCalc(startNum, endNum);
		
		System.out.println(startNum+"~"+endNum+"까지 합 : "+sum);
		//System.out.println(evenodd.evenOdd(sum));
		
		
	}

}
