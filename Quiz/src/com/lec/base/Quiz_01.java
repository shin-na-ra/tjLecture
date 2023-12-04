package com.lec.base;

import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int input = 0;
		int loc = 0;
		
		System.out.print("입력할 숫자의 갯수? : ");
		num = scanner.nextInt();
		int[] arr = new int[num];  // 5
		int[] temp = new int[num-1]; //4
		
		System.out.println(num+"개의 숫자를 입력하세요!:");
		
		for(int i=0; i<num; i++) {
			System.out.print((i+1)+"의 숫자 : ");
			input = scanner.nextInt();
			arr[i] = input;
		}
		
		System.out.print("몇번째의 숫자를 삭제 하시겠습니까? : ");
		loc = scanner.nextInt(); //3 
		for(int i=loc-1; i < num-1; i++) {
			arr[i] = arr[i+1];
		}
		
		for(int i = 0; i<temp.length; i++) {
			temp[i] = arr[i];
		}
		
		System.out.println("------ 결과 -------");
		for(int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	
	} 

}
