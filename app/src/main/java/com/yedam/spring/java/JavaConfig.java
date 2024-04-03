package com.yedam.spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	// 메소드 이용해서 빈 등록. //이름 name 속성 
	@Bean(name="chf")
	public Chef chef() {
		return new Chef();
	}
	@Bean
	public Restaurant restaurant(Chef chef) {
		Restaurant res  = new Restaurant();
		res.setChef(chef);
		return res;
	}

}
