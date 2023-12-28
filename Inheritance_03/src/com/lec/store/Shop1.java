package com.lec.store;

public class Shop1 extends HQ {
	
	public Shop1() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void kimChi() {
		System.out.println("김치찌개 : 4,500원");
	}
	
	@Override
	public void buDea() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void sunDae() {
		System.out.println("순대국: 판매하지 않습니다.");
	}
	
}
