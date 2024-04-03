package com.yedam.java.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(path="empList", method =RequestMethod.GET) // 메소드는 get으로만 받겠다는개념
	public String empList(Model model) {
		List<EmpVO> list = empService.empAllList();
		model.addAttribute("empList", list);
		return "empList"; // 이 jsp에 뿌려주겠다.
	}
	
}
