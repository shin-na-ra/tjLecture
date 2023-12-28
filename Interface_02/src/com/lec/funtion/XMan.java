package com.lec.funtion;

public class XMan implements PoliceMan, FireFighter, Cooker{
	
	@Override
	public void makePizza() {
		System.out.println("피자요리");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println("스파게티 요리");
	}

	@Override
	public void catchFire() {
		System.out.println("불끄기");
	}

	@Override
	public void saveMan() {
		System.out.println("사람구하기");
	}

	@Override
	public void catchThief() {
		System.out.println("범인검거");
	}

	@Override
	public void findThing() {
		System.out.println("분실물건 보관");
	}
	
	public void tt() {
		System.out.println("추가추가");
	}

}
