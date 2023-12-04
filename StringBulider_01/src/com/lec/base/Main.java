package com.lec.base;

public class Main {

	public static void main(String[] args) {

		
		//StringBuilder / StringBuffer
		StringBuilder stringBuilder = new StringBuilder("abcdefg");
		stringBuilder.append("hijklmn");
		
		stringBuilder.insert(3, "xxx");
		stringBuilder.delete(3, 6);
		System.out.println(stringBuilder);
		
		
		
		StringBuffer stringBuffer = new StringBuffer("abcdefg");
		stringBuffer.append("hijklmn");
		
		stringBuffer.insert(3, "xxx");
		stringBuffer.delete(3, 6);
		System.out.println(stringBuffer);
		
		
	}

}
