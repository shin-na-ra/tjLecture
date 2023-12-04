package com.lec.base;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dateName = {"일요일", "월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int monty = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		int date = cal.get(Calendar.DAY_OF_WEEK) ;
		
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println(year +"-"+ monty+"-"+String.format("%02d", day)+"-"+dateName[date-1]);
		
		System.out.println(hour+":"+min+":"+sec);
		
	}

}
