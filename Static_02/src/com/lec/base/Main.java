package com.lec.base;

import java.util.Scanner;

import com.lec.func.Input;
import com.lec.func.Output;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("id를 입력하세요 : ");
		String inputId = scanner.next();
		System.out.print("pw를 입력하세요 : ");
		String inputPw = scanner.next();
		
		Input.id = inputId;
		Input.pw = inputPw;
		
		System.out.println("id : "+ Output.checkId());
		System.out.println("pw : "+ Output.checkPw());
		
	}

}
