package com.yedam.spring.annotation;

import org.springframework.stereotype.Component;

@Component("chef")
public class Chef {
	public void cooking() {
		System.out.println("annotatino 방식");
	}

}
