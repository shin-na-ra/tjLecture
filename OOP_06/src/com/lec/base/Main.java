package com.lec.base;

import com.lec.func.Car;

public class Main {

	public static void main(String[] args) {

		Car car1 = new Car();
		System.out.println("car1.company = "+car1.company); // 현대자동차
		
		Car car2 = new Car("자가");
		System.out.println("car2.company = "+car2.company); // 현대자동차
		System.out.println("car2.model = "+car2.model);// 자가
				
	}

}
