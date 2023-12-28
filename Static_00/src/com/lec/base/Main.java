package com.lec.base;

import java.util.Scanner;

import com.lec.func.Input;
import com.lec.func.Output;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Output op = new Output();

		System.out.println("id 입력 : ");
		String inputId = sc.next();
		System.out.println("pw 입력 : ");
		String inputPw = sc.next();
		
		Input.id = inputId;
		Input.pw = inputPw;
		
		System.out.println("11111 : " + op.checkId());
		System.out.println("22222 : " + op.checkPw());
	}
}
