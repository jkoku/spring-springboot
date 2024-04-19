package com.yedam.app.upload.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartConfig {
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxRequestSize(DataSize.ofMegabytes(10)); 
		factory.setMaxFileSize(DataSize.ofBytes(10485760));
		
		return factory.createMultipartConfig();
		// 설정변경
	}
}
// 3버전부터 
// 설정과 관련되었으니까 configuration어노테이션
// 구현클래스 StandardServletMultipartResolver 필요하다. 
// 인터페이스는 하나고 그걸 구현하는 클래스는 버전이나 용도에 따라서 바꿔치기하는것. 
// 이렇게 등록할 경우는 프로퍼타이즈로 설정이안된다. 우리가 등록한 대상이라서 
// 빈을 등록할때는 설정 빈, 동작 빈 두가지.