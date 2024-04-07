package com.yedam.app.dep.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dep.service.DepService;
import com.yedam.app.dep.service.DepVO;
import com.yedam.app.mapper.DepMapper;

@Service
public class DepServiceImpl implements DepService {
	
	@Autowired
	DepMapper depMapper;
	
	
	@Override
	public List<DepVO> depList() {
		return depMapper.selectEmpAll();
	}

	@Override
	public DepVO depInfo(DepVO depVO) {
		return depMapper.selectEmp(depVO);
	}

	@Override
	public int depInsert(DepVO depVO) {
		int result = depMapper.insertEmp(depVO);

		if(result == 1) {
			return depVO.getDepartmentId(); //  정상적으로 등록되었다면 사원번호 리턴될수있도록
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> depUpdate(DepVO depVO) {
		// let map = {}; 구조에서 같은의미 . 내부적으로는 다르지만
		Map<String, Object> map = new HashMap<>(); // key는 string 값은value의 형태 
		boolean isSuccessed = false;
		
		int result = depMapper.updateDep(depVO);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		// map.target ={ employeeId : '', lastName : '', ...} map이 가진key를 필드명이라고 보고 
		map.put("tartget", depVO);
		return map;
	}

	@Override
	public Map<String, Object> depDelete(DepVO depVO) {
		Map<String, Object> map = new HashMap<>();
		int result = depMapper.deleteDep(depVO.getDepartmentId());
		
		if(result == 1) {
			map.put("departmentId",depVO.getDepartmentId());
		} 
		return map;
	}



}
