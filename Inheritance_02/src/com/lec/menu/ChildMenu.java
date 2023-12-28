package com.lec.menu;

public class ChildMenu extends ParentsMenu {

	//Fields
	
	//Constructor
	public ChildMenu() {
		// TODO Auto-generated constructor stub
	}
	
	//Method
	public void makeBeefChung() {
		System.out.println("쇠고기 청국장");
	}
	
	public void makeHotDoen() {
		System.out.println("얼큰 된장국");
	}
	
	public void makeKongNa() {
		super.makeChung();
		System.out.println("콩나물국");
	}
	
	@Override
	public void makeChung() {
		System.out.println("냄새없는 청국장");
	}

	@Override
	public void makeGal() {
		System.out.println("팔지않습니다.");
	}
	
}
