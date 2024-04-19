package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "home"; 
		// classpath:/template/home.html <- 이경로로 저 파일을 찾아간다. 실제로 파일을 만들때 저 경로를 참고해서
		// classpath: = src/main/resources
	}
}
