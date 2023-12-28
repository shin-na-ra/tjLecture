package com.lec.base;

import com.lec.function.Child;

public class Main {

	public static void main(String[] args) {

		Child child = new Child();
		
		child.getFather();
		child.getMother();
		child.getChild();
		System.out.println(child.pStr);
	}

}
