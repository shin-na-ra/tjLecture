package com.lec.base;

public class Main {

	public static void main(String[] args) {

		//Time을 이용하여 측정하기
		String str1 = "a";
		
//		long startTime = System.currentTimeMillis();
//		for(int i=1; i<= 500000; i++) {
//			str1 = str1 +"a";
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("Term1 :"+(endTime - startTime)); //12013
		
		
		
//		StringBuilder stirngBuilder = new StringBuilder("a");
//		long startTime2 = System.currentTimeMillis();
//		for(int i=1; i<= 500000; i++) {
//			stirngBuilder.append("a");
//		}
//		long endTime2 = System.currentTimeMillis();
//		System.out.println("Term2 :"+(endTime2 - startTime2)); //14
		
		StringBuffer stirngBuffer = new StringBuffer("a");
		long startTime3 = System.currentTimeMillis();
		for(int i=1; i<= 500000; i++) {
			stirngBuffer.append("a");
		}
		long endTime3 = System.currentTimeMillis();
		System.out.println("Term3 :"+(endTime3 - startTime3)); //23
		
		
	}

}
