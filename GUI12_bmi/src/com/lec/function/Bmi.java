package com.lec.function;

public class Bmi {
	
	double height;
	double weight;
	
	public Bmi() {
		// TODO Auto-generated constructor stub
	}

	public Bmi(double height, double weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	
	public double calcBmi() {
		
		height = height/100;
		double bmi = weight / (height* height);
		bmi = Math.round(bmi*10)/10.0;
		System.out.println("ddd+ : "+bmi);
		return bmi;
	}
	
	
	public String resultBmi(double bmi) {
		String result = "";
		System.out.println(bmi + ", : bmi");
		double num = calcBmi();
		System.out.println(num + ", nujm ");
		System.out.println("calcBmi() :" + calcBmi());
		
		if(bmi >= 30.0) {
			result = "고도비만";
		} else if(bmi >= 25.0) {
			result = "비만";
		} else if(bmi >= 23.0) {
			result = "과체중";
		} else if(bmi >= 18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}
	
	
	

}
