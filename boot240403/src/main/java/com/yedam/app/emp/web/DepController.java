package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dep.service.DepVO;
import com.yedam.app.mapper.DepMapper;

@Controller
public class DepController {

	@Autowired
	DepMapper depMapper;
	
	/* // 전체조회  // 검색,페이징 아니면 받을게없어서 값을 담는 대상은 필요없고, 모델필요.
	@GetMapping("depList") //("경로")       // Model = Request + Response 스프링내부에서 두 객체를 사용하기 편하도록 하나로 묶어둔 것. 
 	public String depList(Model model) { // , Session) 세션필요하면 매개변수에 가능
		// 1) 해당기능수행 -> Service
		List<DepVO> list = depSerivce.depList(); // 기능불러옴 
		// 2) 클라이언트에 전달한 데이터 담기 
		model.addAttribute("depList",list);
		// 3) 데이터를 출력할 페이지 선택. 
		return "dep/list"; // emp 아래에 list라는 이름 html / return할때 앞에서이미 /가붙기때문에 / 부터작성하지 말것. 
		// prefix => classpath:/templates/
		// subfix => .html
	
	
	}
	// 단건조회
		@GetMapping("depInfo")  // 커맨드객체 어노테이션이 아무것도 붙지않는경우 => QueryString 
		public String depInfo(DepVO depVo, Model model) { // 단건조회 특정한대상에 값을 가져올때 결정
		DepVO findVO = depSerivce.empInfo(depVo);
		model.addAttribute("empInfo",findVO);
			return"dep/info";
		}
		
	// 등록 - 페이지 => GET 데이터 넘어가는게 아니니까 입력받을 form필요! 
		@GetMapping("depInsert")
		public String empInsertForm(Model model) {
			model.addAttribute("depVo", new DepVO());
			return "dep/insert";
		}
		
	// 등록 - 처리 => POST
		@PostMapping("empInsert")
		public String empInsertProcess(DepVO depVo) {
			//int eId = depSerivce.empInsert(depVo);
			String uri = null;
			if(dId > -1) {
				uri="redirect:depInfo?departmentId="+dId;
			} else {
				uri="depList";
			}
			return "";
		}
*/	
}
