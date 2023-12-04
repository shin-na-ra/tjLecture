package com.lec.base;

public class Main {

	public static void main(String[] args) {

		String str0 = "가나다라마바"; 			//String은 객체형 변수타입, 
		String str1 = new String("abcdefg");
		String str11 = new String("ABCDEFG");
		String str2 = new String("ABCD");
		String str3 = new String("    abc   ");
		
		System.out.println(str1);
		System.out.println(str1.concat(str2));
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3, 5));
		
		// 라마 만 출력
		System.out.println(str0.substring(3,5));
		
		System.out.println(str0.length());
		System.out.println(str1.toUpperCase());
		System.out.println(str2.toLowerCase());

		System.out.println(str1.charAt(3));
		System.out.println(str1.indexOf("c"));
		
		System.out.println(str1.equals(str2));
		
		//str1 과 str11을 equals로 비교하여 true값이 나오게
//		str11 = str11.toLowerCase();
//		System.out.println(str1.equals(str11));
//		
//		str1 = str1.toUpperCase();
//		System.out.println(str1.equals(str11));
		System.out.println(str3.trim());
		System.out.println(str1.replace('a', 'j'));
		System.out.println(str1.replaceAll("abc", "zzzzz"));
		
	}

}
