package com.promineoTech;

import java.util.Random;

public class TestDemo {

	
	public int addInt(int a, int b) {
		if(a > 0 && b >0) {
		int sum = a + b;
		return sum;
		}
		else {
			throw new java.lang.IllegalArgumentException("Both paramaters must be positive!");
		}
	}
	//adds a last name to a first name. 
	public String fullName(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	public int  getRandomInt() {
	    Random random = new Random();
	    return random.nextInt(10) + 1;

	}
	public int randomNumberSquared() {
		return getRandomInt()*getRandomInt();
	}
	
	
}
