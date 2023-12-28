package com.lec.func;

import com.lec.model.LunchMenu;

public class Child3 extends LunchMenu{

	public Child3() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Child3(int rice, int bulgogi, int banana, int milk, int almond) {
		super(rice, bulgogi, banana, milk, almond);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int calc() {
		return rice + bulgogi;
	}

	
}
