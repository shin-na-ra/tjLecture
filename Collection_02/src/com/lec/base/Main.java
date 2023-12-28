package com.lec.base;

import java.util.ArrayList;

import com.lec.model.User;

public class Main {

	public static void main(String[] args) {
		User user;
		
		ArrayList<User> arrayList = new ArrayList<User>();
		
		arrayList.add(new User("a", "111", "서울", "010-1111-1222"));
		System.out.println(arrayList.get(0).getId());
		System.out.println(arrayList.get(0).getPw());
		System.out.println(arrayList.get(0).getAddress());
		System.out.println(arrayList.get(0).getPhone());
		System.out.println(arrayList.get(0).getClass());
		
		
	}

}
