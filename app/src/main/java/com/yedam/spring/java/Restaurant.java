package com.yedam.spring.java;


public class Restaurant {
	 
	private Chef chef;
	
	public void run() {
		chef.cooking();
		
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
}
