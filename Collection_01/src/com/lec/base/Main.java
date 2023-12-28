package com.lec.base;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		
		//ArrayList
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("str1");
		arrayList.add("str2");
		arrayList.add("str3");
		arrayList.add("str4");
		
		System.out.println(arrayList);
		
		System.out.println(arrayList.size());
		
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		
		
		arrayList.set(3, "str1111");
		System.out.println(arrayList.remove(3));
		
		
		arrayList.clear();
		System.out.println(arrayList);
	}

}
