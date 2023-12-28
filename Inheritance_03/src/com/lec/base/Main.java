package com.lec.base;

import com.lec.store.HQ;
import com.lec.store.Shop1;
import com.lec.store.Shop2;
import com.lec.store.Shop3;

public class Main {

	public static void main(String[] args) {

		HQ hq = new HQ();
		Shop1 shop1 = new Shop1();
		Shop2 shop2 = new Shop2();
		Shop3 shop3 = new Shop3();
		
		
		System.out.println("HQ-------------------------");
		hq.kimChi();
		hq.buDea();
		hq.biBim();
		hq.sunDae();
		hq.rice();
		
		System.out.println();
		System.out.println("Shop1----------------------");
		shop1.kimChi();
		shop1.buDea();
		shop1.biBim();
		shop1.sunDae();
		shop1.rice();
		
		System.out.println();
		System.out.println("Shop2----------------------");
		shop2.kimChi();
		shop2.buDea();
		shop2.biBim();
		shop2.sunDae();
		shop2.rice();
	
		System.out.println();
		System.out.println("Shop3----------------------");
		shop3.kimChi();
		shop3.buDea();
		shop3.biBim();
		shop3.sunDae();
		shop3.rice();
	
	}

}
