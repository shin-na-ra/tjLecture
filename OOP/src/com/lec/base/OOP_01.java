package com.lec.base;

import java.util.Scanner;

public class OOP_01 {

	public static void main(String[] args) {
		
		//필드, 어트리뷰트, 프로퍼
		int sum = 0;
		int startNum = 0;
		int endNum = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("범위의 숫자 중 작은 숫자 : ");
		startNum = scanner.nextInt();
		
		System.out.print("범위의 숫자 중 큰 숫자 : ");
		endNum = scanner.nextInt();
		
		for(int i = startNum; i<= endNum; i++) {
			sum += i;
		}
		System.out.println(startNum+"~"+endNum+"까지 합 : "+sum);
	
		if(sum % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
	}

}
