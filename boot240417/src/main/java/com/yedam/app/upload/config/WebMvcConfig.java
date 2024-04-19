package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.upload.path}") // 스프링프레임워크 import. 내부코드가 아니라밖엣값을읽어들일때 사용. 
								// jsp에서 값꺼낼때쓰던 $, $를 통해서 정의. 실행하면서 이름의값을 불러와서 uploadPath 자신이 있는 필드 변수에 담는다. 프로터파이즈에서 일거와서 저기에 강제로 넣는다. 
	private String uploadPath; // 내부코드가 아니라밖에 값을읽어들일때 사용.  
	
	// 리소스 핸들링 
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/images/**") // 이 경로로 불러내면됨. 실제 물리적으로 폴더 밑에존재하는것들
					.addResourceLocations("file:///" + uploadPath,""); // 복수가능. 동일한 경로에 여러개의 위치를 매핑하는게 가능하다.("file:///C:/upload/",""); 
					
			//C:/upload/dog.jpg 를 images/dog.jpg 불러온다.  윈도우라서 /// 세개. 운영체제별로 프로토콜구성이 다르다. 사용하는 운영체제에 맞춰서 저장
			// 핸들러하나와 location은 한세트로 움직여진다. 
		}
		
	}

	// 이미 설정되어있는데, 변경을 요청하거나 추가적 빈들을 넣거나 할때?사용하는 대상 

	// 인터페이스는 default 강제 오버라이딩이 없다. 
