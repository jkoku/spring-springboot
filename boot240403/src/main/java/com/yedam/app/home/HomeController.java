package com.yedam.app.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j 
@Controller
public class HomeController {
	
	
	// QueryString  => 커맨드객체
	// Method는 상관없음
	// Content-type : application/x-www-form-urlencoded
	@RequestMapping(path="comobj", method= {RequestMethod.GET, RequestMethod.POST}) //기본은 리퀘스트매핑
	@ResponseBody  
	public String commandObject(EmpVO empVO) {
		log.info("path : /comobj");
		log.info("= employee_id : " + empVO.getEmployeeId());
		log.info("= last_name : " + empVO.getLastName());
		log.info(empVO.toString());
		return "";
	}
	
	// 개별개별 받는 방식
	@RequestMapping(path="reqparm", method= {RequestMethod.GET, RequestMethod.POST})
	
	@ResponseBody
	public String requestParam(@RequestParam Integer employeeId, String lastName, @RequestParam(name="message", defaultValue="No message",required=false) String msg) {
		log.info("path : /reqparm");
		log.info("= employee_id : " + employeeId);
		log.info("= last_name : " + lastName);
		log.info("= msg : " + msg);
		return "";
	}
	// @RequestParam(name="") name 키 매개변수이름이 아니라 통신일으킬때 다른 변수를 쓰면 name속성을 이용하면 두개 따로 놀게할 수 있다. 
	// 두번째는 defaultValue 필수인데 값이 넘어오지않는 경우 미리 사용할 메세지 등록
	// required 속성자체 기본은 true, false로 쓰려면 명시해주기. 

	
	@RequestMapping(path="path/{id}")
	@ResponseBody
	public String pathVariable(@PathVariable String id) { 	//@pathVariable 메소드 상관없다. 경로에 붙어오니까. 
		log.info("path : /path/{id}");
		log.info("= id : " + id);
		return "";
	}
	
	@PostMapping("resbody") // 매핑은 post나 put만가능하다 body를 요청하기때문 
	@ResponseBody
	public Map<String, Object> requestBody(@RequestBody EmpVO empVO) {
		 Map<String, Object> map = new HashMap<>();
		 map.put("path", "resbody");
		 map.put("data", empVO);
		return map;
	}
}



	

