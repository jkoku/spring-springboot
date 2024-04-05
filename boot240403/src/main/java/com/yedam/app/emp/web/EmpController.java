package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 컨트롤러는 중간역할만한다.. 서비스불러오고 리턴
public class EmpController {

	@Autowired// 서비스 필요
	EmpService empSerivce;
	
	// REST말고 정통적인 방식에서 get,post 구분 GET: 조회, 빈페이지 
	// POST: 데이터 조작(등록, 수정, 삭제) 삭제는 pk하나만 넘기는 경우도 있기때문에 get 방식도 사용가능.

	// 전체조회  // 검색,페이징 아니면 받을게없어서 값을 담는 대상은 필요없고, 모델필요.
	@GetMapping("empList") //("경로")       // Model = Request + Response 스프링내부에서 두 객체를 사용하기 편하도록 하나로 묶어둔 것. 
 	public String empList(Model model) { // , Session) 세션필요하면 매개변수에 가능
		// 1) 해당기능수행 -> Service
		List<EmpVO> list = empSerivce.empList(); // 기능불러옴 
		// 2) 클라이언트에 전달한 데이터 담기 
		model.addAttribute("empList",list);
		// 3) 데이터를 출력할 페이지 선택. 
		return "emp/list"; // emp 아래에 list라는 이름 html / return할때 앞에서이미 /가붙기때문에 / 부터작성하지 말것. 
		// prefix => classpath:/templates/
		// subfix => .html
	
	
	}
	// 단건조회
		@GetMapping("empInfo")  // 커맨드객체 어노테이션이 아무것도 붙지않는경우 => QueryString 
		public String empInfo(EmpVO empVo, Model model) { // 단건조회 특정한대상에 값을 가져올때 결정
		EmpVO findVO = empSerivce.empInfo(empVo);
		model.addAttribute("empInfo",findVO);
			return"emp/info";
		}
		
	// 등록 - 페이지 => GET 데이터 넘어가는게 아니니까 입력받을 form필요! 
		@GetMapping("empInsert")
		public String empInsertForm(Model model) {
			model.addAttribute("empVO", new EmpVO());
			return "emp/insert";
		}
		
	// 등록 - 처리 => POST
		@PostMapping("empInsert")
		public String empInsertProcess(EmpVO empVO) {
			int eId = empSerivce.empInsert(empVO);
			String uri = null;
			if(eId > -1) {
				uri="redirect:empInfo?employeeId="+eId;
			} else {
				uri="empList";
			}
			return "";
		}
}

