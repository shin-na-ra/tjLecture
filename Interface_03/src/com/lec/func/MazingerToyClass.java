package com.lec.func;

public class MazingerToyClass implements Missie, MoveArmLeg{

	public MazingerToyClass() {
	
		System.out.println("마징거입니다.");
		canMissie();
		canMoveArmLeg();
		System.out.println("===================");
	}
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔 다리 움직여");
	}

	@Override
	public void canMissie() {
		System.out.println("미사일 발사");
	}
	
}
