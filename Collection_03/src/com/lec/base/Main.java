package com.lec.base;

import java.util.HashMap;

public class Main {
 
	public static void main(String[] args) {
		//MAP
		
	
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Apple", "사과");
		hashMap.put("Melon", "멜론");
		hashMap.put("Banana", "바나나");
		
		System.out.println(hashMap.get("Apple"));
		hashMap.put("Apple", "Apple");
		
		hashMap.remove("Apple");
		hashMap.clear();
		hashMap.size();
		System.out.println(hashMap);
	}
}
