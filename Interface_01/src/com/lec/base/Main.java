package com.lec.base;

import com.lec.function.APhone;
import com.lec.function.BPhone;
import com.lec.function.CPhone;
import com.lec.model.SmartPhone;

public class Main {

	public static void main(String[] args) {

		SmartPhone a = new APhone();
		SmartPhone b = new BPhone();
		SmartPhone c = new CPhone();
//		a.callSenderReceiver();
//		a.tvRemoteController();
//		a.telMethod();
//		
//		b.callSenderReceiver();
//		b.tvRemoteController();
//		b.telMethod();
//		
//		c.callSenderReceiver();
//		c.tvRemoteController();
//		c.telMethod();
//		
		SmartPhone [] smartPhones = {a, b,c};
		for ( int i = 0; i<smartPhones.length; i++) {
			smartPhones[i].callSenderReceiver();
			smartPhones[i].tvRemoteController();
			smartPhones[i].telMethod();
		}
	}

}
