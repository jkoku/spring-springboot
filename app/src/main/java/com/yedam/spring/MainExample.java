package com.yedam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv = (TV)ctx.getBean("tv");
		tv.turnOn();
		
		// xml을 기반으로 했기때에 genericXml~~사용.
		// 우리가 인스턴스를 생성하지않는다. 내부에 bean이 등록되어있다. 이미 컨테이너안에 인스턴스 있다는 가정 하에 코드작성.
		// nullpointexception이 왠만하면 일어나지않는다. 빈이 없으면 프로젝트 생성이막힘. 
		
	}
}