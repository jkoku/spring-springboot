package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//aop기반 : 빈이긴한테 aop기반으로 추가. 이에 대한 정보를 따로 들고있따(service mapper말고 aop설정정보)  Aspect declaration
@Aspect 
// 빈으로 등록
@Component
public class LogAdvice {
	// 포인트컷 : 비즈니스 로직과 관련된 메소드 중에서 Advice(공통코드) 가 적용될 메소드
	// 메소드를 기준으로 그 위에 어노테이션을 이용해서 이 포인트컷에 대한것을 정의. 
	@Pointcut("within(com.yedam.app.emp.service.impl.*)") // 괄호안은 단순한 표현식
	public void allPointCut() {} // 위 표현식을 불러내기 위한 메소드 allPointCut(). 메소드가 저 포인트 컷의 이름이 되어줌
	// ("within(com.yedam.app.emp.service.impl.*)") = allPointCut()
	
	// Weaving : 포인트컷+ Advice + 타이밍
	// 특정포인트컷에 적용한 어드바이스가 누구인지. 타이밍까지 필요 위빙을통해 실행되는형태가 완성된다.
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable { // ProceedingJoinPoint joinPoint (실행을 요청받는)메소드에 대한 정보 전체를 가지고 있다  joinPoint 메소드자체를 매개변수로 받음
		// Aop가 적용되는 메서드의 이름
		String signatuerStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr); 
		
		// 공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능: " + System.currentTimeMillis());
		
		try {
			// 비즈니스 메소드를 실행
			Object obj = joinPoint.proceed(); // 결과를 받아서 리턴. 오브젝트인이유 무슨메소드가 실행될지 알수없음. 항상 오브젝트로 반환된다. 
			return obj;
		} finally { // finally로 정의....
			System.out.println("핵심 기능 전 실행 - 공통기능: " + System.currentTimeMillis());
			System.out.println("끝 : " + signatuerStr);
		}
	}
	
	@Before("allPointCut()") // 특정시전에 대해 도는 부분
	public void beforeAdvice(JoinPoint joinPoint) {
		String signatuerStr = joinPoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr );
	}
}


// within return 타입, 클래스명,매개변수 에 대한 부분없음. 
// 특정 기능에 공통적으로 정용. 지금 지정한 범위안에ㅣㅆ는 모든 메소드에 대해서 적용하겠다는 표현식.

// 위빙 : 실행하는 내용...


