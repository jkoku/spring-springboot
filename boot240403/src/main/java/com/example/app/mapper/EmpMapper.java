package com.example.app.mapper;

import java.util.List;

import com.example.app.emp.service.EmpVO;

//import org.apache.ibatis.annotations.Mapper;
//
//@Mapper
public interface EmpMapper {

	// 전체조회
	public List<EmpVO> selectEmpAll();
	
	// 단건조회
	public EmpVO selectEmp(EmpVO empVO);

	// 등록
	public int insertEmp(EmpVO empVO);
	
	// 수정
	public int unpdate (EmpVO empVO);
	
	// 삭제
	public int deleteEmp(int employeeId);
	
}
