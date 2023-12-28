package com.lec.base;

import com.lec.funtion.FireFighter;
import com.lec.funtion.PoliceMan;
import com.lec.funtion.XMan;

public class Main {

	public static void main(String[] args) {

		
		XMan man = new XMan();
		
		System.out.println("x-man의 역할");
		man.catchFire();
		man.catchThief();
		man.findThing();
		man.makePizza();
		man.makeSpaghetti();
		man.saveMan();
		man.tt();
		
		System.out.println("-----------------------------");
		System.out.println("경찰역할");
		
		PoliceMan policeMan = new XMan();
		policeMan.catchThief();
		policeMan.findThing();

		FireFighter fighter = new XMan();
		fighter.catchFire();
		fighter.saveMan();
	
	}

}
