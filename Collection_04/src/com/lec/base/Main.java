package com.lec.base;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {

		
		//Set
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(2);
		hashSet.add(2);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		hashSet.add(4);
		
		hashSet.remove(4);
		
		System.out.println(hashSet);
	}

}
