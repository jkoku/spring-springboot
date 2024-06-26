package com.yedam.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot240417ApplicationTests {
	/*
	  @Test void contextLoads() { }
	  
	  @Autowired AaaService aaaService;
	 
	
	@Test
	public void aopTest() {
		aaaService.insert();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder; // 단방향 : 복구가 불가능한 형태의 암호 . 
	
	@Test
	public void testEndcoder() {
		String password = "1234";
		
		String enPwd = passwordEncoder.encode(password);
		System.out.println("enPwd : " + enPwd);
		//  1234 가 해시 머 해서 이렇게 나옴. db 에 들어감 enPwd : $2a$10$WmP3c4Hjmory/Y4gIPGaoeF/zrYYtfImDk.zHsRXjiPnPsc0jn6lW

		boolean matchResult = passwordEncoder.matches(password, enPwd); // 순서바뀌면안됨. 
											// 첫번째 매개변수가 원래데이터, 두번째 매개변수가 암호화된값 두개 비교.	// 로그인할때 사용. 
		System.out.println("matchResult : " + matchResult);
	}
	*/
	
	@Autowired
	StringEncryptor jasyptStringEncryptor; // 암호화작업에 대한 부분 적용.
	
	@Test
	public void encryption() { 
		String[] strs = {
				"net.sf.log4jdbc.sql.jdbcapi.DriverSpy",
				"jdbc:log4jdbc:oracle:thin:@127.0.0.1:1521:xe",
				"hr",
				"hr" 
		};
		
	for(String str : strs) {
		String encStr = jasyptStringEncryptor.encrypt(str);
				System.out.println(encStr);
		}
	}
	
}
