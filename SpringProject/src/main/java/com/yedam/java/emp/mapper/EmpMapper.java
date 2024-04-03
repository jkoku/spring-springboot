package com.yedam.java.emp.mapper;

import java.util.List;

import com.yedam.java.emp.service.EmpVO;

public interface EmpMapper {
	public List<EmpVO> selectEmpAll();
}

// 인터페이스는 빈등록 안됨