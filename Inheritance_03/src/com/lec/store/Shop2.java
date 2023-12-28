package com.lec.store;

public class Shop2 extends HQ {
	
	public Shop2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buDea() {
		System.out.println("부대찌개 : 5,000원");
	}
	
	@Override
	public void biBim() {
		System.out.println("비빔밥: 5,000원");
	}
	
	@Override
	public void sunDae() {
		System.out.println("순대국 : 4,000원");
	}
	
	@Override
	public void rice() {
		System.out.println("공기밥 : 무료입니다.");
	}
}
