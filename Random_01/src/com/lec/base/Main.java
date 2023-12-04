package com.lec.base;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();

		int[] lottNum = new int[6];

		for (int i = 0; i < lottNum.length; i++) {
			lottNum[i] = random.nextInt(45)+1;
			
			for(int j= 0; j < i; j++) {
				if(lottNum[i] == lottNum[j] ) {
					i--;
				}
			}
			
		}
		
		for (int i = 0; i < lottNum.length; i++) {
			System.out.print(lottNum[i]+"\t");
		}
	}
}
