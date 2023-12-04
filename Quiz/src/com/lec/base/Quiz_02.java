package com.lec.base;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int inputMoney = 0;
		int[] customer = {1,2,3,4,5}; 
		int[] account =  new int[5]; 
		int cusNum = 0;
		
		while(true) {
			System.out.println();
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 현황");
			System.out.println("4. 종료");
			
			System.out.print("번호를 선택하세요! : ");
			num = scanner.nextInt();
			
			//입금
			if(num == 1) {
				
				System.out.print("고객번호 : ");
				cusNum = scanner.nextInt();
				
				for(int i=0; i<customer.length; i++) {
					if(cusNum != customer[i]) {
						System.out.println("등록되지 않는 고객입니다. 다시 입력해주세요 ");
					} else {
						System.out.print("금액 : ");
						inputMoney = scanner.nextInt();
						account[cusNum - 1] = inputMoney;
						System.out.println("입금 결과 : 고객번호 : "+cusNum+ ", 잔액 : "+account[cusNum - 1] );
					}
				}
				
			} else if (num == 2) { // 출금
				
				System.out.print("고객번호 : ");
				cusNum = scanner.nextInt();
				System.out.print("금액 : ");
				inputMoney = scanner.nextInt();
				
				if(account[cusNum - 1] > inputMoney) {
					account[cusNum - 1] -= inputMoney;
				} else {
					System.out.println("잔액이 부족합니다!");
				}
				
			} else if(num == 3) {	// 현황
				System.out.println(" 고객명  잔액");
				System.out.println(" -----  ---");
				for(int i=0; i<account.length; i++ ) {
					System.out.println(customer[i] +"\t"+account[i]);
				}
			} else if(num == 4) {
				System.out.println(">>>> Thank you <<<< ");
				break;
			}
			
		}
	}

}
