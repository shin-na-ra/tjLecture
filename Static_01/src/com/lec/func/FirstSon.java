package com.lec.func;

public class FirstSon {

	public FirstSon() {
		// TODO Auto-generated constructor stub
	}
	
	public void takeChoco() {
		MamaBag.choco = MamaBag.choco - 1;

		if(MamaBag.choco < 0) {
			System.out.println("첫째는 초코파이 먹고 싶어요");
		}else {
			System.out.println("첫째는 맛있게 먹었어요");
		}
	}
}
