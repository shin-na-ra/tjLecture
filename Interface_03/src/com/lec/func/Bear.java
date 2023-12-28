package com.lec.func;

public class Bear implements MoveArmLeg{

	public Bear() {
		
		System.out.println("나는 곰돌이");
		canMoveArmLeg();
		System.out.println("===========");
	}
	
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리 움직인다.");
		
	}

}
