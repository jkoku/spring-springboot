package com.yedam.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	 
	private Chef chef;
	
	public void run() {
		chef.cooking();
		
	}

	public Chef getChef() {
		return chef;
	}
	
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
}
