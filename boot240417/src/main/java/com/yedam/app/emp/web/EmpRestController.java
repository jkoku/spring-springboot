package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController { // @Controller + 모든 메소드에 @ResponseBody를 적용

	@Autowired
	EmpService empService;

	// 메소드 정해져있음 GET POST PUT DELETE
	// 전체조회 - GET
	@GetMapping("emps") // 자원에 대한 명시 uri로. 기능이아님 employees에 대한 접근
	public List<EmpVO> empList() { // 페이지가 아니라 반환하고자하는 데이터타입
		return empService.empList(); // 모델사용하지않고 리턴하는대상이 그대로 클라이언트에 전달한다.
	}

	// 모델사용은 페이지에 전달하고자하는내용담는거라서 얘는 페이지요구하지않아서 모델사용X
	// 단건조회 - GET
	@GetMapping("emps/{id}") // @PathVariable 05-18p 경로에 중괄호를 기반으로 괄호안이 값임을 알림. 반드시 값이 있어야한다. /에 하나붙은 이자체가
								// 단건조회경로 자체가 하나의 경로라서
								// "emps/{id}/{name}/{age}")
								// emps/100
								// emps/100/hong
								// emps/100/hong/20 은 모두 다른 경로이다.
	public EmpVO empInfo(@PathVariable(name = "id") Integer employeeId) { // 변수랑 경로에붙은 변수 달라도 상관업음.name이용 @PathVariable는
																			// 경로에붙는다.
		EmpVO findVO = new EmpVO(); // 같다면 뒤처럼 (@PathVariable Integer id)
		findVO.setEmployeeId(employeeId);
		return empService.empInfo(findVO); // 이렇게 처리하고 서비스에 넘겨줌?
	}

	// 등록 - POST
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) { // json 들어온것 대비해서 RequestBody @RequestBody잇으면 무조건 json RequestBody는
														// POST방식
		return empService.empInsert(empVO);
	}

	// 수정 - PUT
	@PutMapping("emps/{id}")
	public Map  empUpdate(@PathVariable(name = "id") Integer employeeId,@RequestBody EmpVO empVO) { 
		
		empVO.setEmployeeId(employeeId);
	
		return empService.empUpdate(empVO); // 이렇게 처리하고 서비스에 넘겨줌?
	}
	
	// 삭제 -DELETE
	@DeleteMapping("emps/{id}") 
	public Map<String,Object> empDelete(@PathVariable Integer id) {
		EmpVO findVO = new EmpVO(); // 같다면 뒤처럼 (@PathVariable Integer id)
		findVO.setEmployeeId(id);
		
		return empService.empDelete(findVO);
	}
	
}

// 조회하는 빈페이지를 요청하려면 결국은 브라우저를 이용해서 링크를 타야한다. 그게 인정도니는게 GET 방식뿐이라 무조건 GET을 이용해야한다.
// PathVariable 경로에서 값을 꺼낸다. 기본형태. requsetparam처럼 기본값을 쓰고 필수값이다. 경로를 구성하기 대문에 얘가 빠지면 못찾아옴. 
// 컨텐트 타입에
// 등록 POST는 부메랑에서 무조건 배열아니면 객체. 빈건 제이슨이 처리못함. 포맷은 json
// 내가 요구하는 헤더가 맞고 그다음에
// 컨텐트 타입이 텍스트면 못넘어감. @requestbody는 json이니까 뒤에 작업하지않고 바로 에러 띄움.
// requestbody 쓴다면 헤더에서 application-json
// 내부도 중요하지만 타입이 다르면 바디로 들어가지 않는다. 헤더도 중요. 컨텐틑타입이 틀어지면 내부값보지도않고 헤더가 맞지 않으니까 거부. 
// 단건조회 등록할줄알면 수정은 딸려온다. 통신구성이 섞인다 단건조회 등록이 합산되서 뭐가뭐가있공.. 바디에는 수정하고자하는 정보 