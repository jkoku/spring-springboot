package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.mapper.EmpMapper;

@Service // 비즈니스로직을 담당하니까.  
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpMapper empMapper;

	@Override
	public List<EmpVO> empList() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO empInfo(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);

		if(result == 1) {
			return empVO.getEmployeeId(); //  정상적으로 등록되었다면 사원번호 리턴될수있도록
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) { // map도 객체.
		// let map = {}; 구조에서 같은의미 . 내부적으로는 다르지만
		Map<String, Object> map = new HashMap<>(); // key는 string 값은value의 형태 
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmp(empVO);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		// map.target ={ employeeId : '', lastName : '', ...} map이 가진key를 필드명이라고 보고 
		map.put("tartget", empVO);
		return map;
	}

	@Override
	public Map<String, Object> empDelete(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		int result = empMapper.deleteEmp(empVO.getEmployeeId());
		
		if(result == 1) {
			map.put("employeeId",empVO.getEmployeeId());
		} 
		return map;
	}
}
