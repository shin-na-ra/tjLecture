package com.lec.base;

import com.lec.func.Child1;
import com.lec.func.Child2;
import com.lec.func.Child3;
import com.lec.model.LunchMenu;
import com.lec.model.PriceTable;

public class Main {

	public static void main(String[] args) {

		LunchMenu child1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		LunchMenu child2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		LunchMenu child3 = new Child3(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND);
		

		System.out.println("1 : "+child1.calc());
		System.out.println("2 : "+child2.calc());
		System.out.println("3 : "+child3.calc());
	}

}
