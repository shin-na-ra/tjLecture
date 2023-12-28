package com.lec.func;

public class AirplaneClass implements Missie, Light{

	public AirplaneClass() {
		
		System.out.println("나는 비행기");
		canLight();
		canMissie();
		System.out.println("=============");
	}
	
	@Override
	public void canLight() {
		System.out.println("불 들어온다.");
		
	}

	@Override
	public void canMissie() {
		System.out.println("미사일 퓽퓽");
	}

}
