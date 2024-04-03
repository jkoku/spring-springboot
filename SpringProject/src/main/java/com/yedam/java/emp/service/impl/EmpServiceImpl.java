package com.yedam.java.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired // 필드주입방식.
	EmpMapper empMapper;
	

	@Override
	public List<EmpVO> empAllList() {
		return empMapper.selectEmpAll();
	}

}

// 클래스를 만들때는 빈으로 등록을해야하는가. 어떤 annotation을 작성해야하는지 먼저 생각하고 작성. 
// 빈으로 등록. 
// 우리는 주로 필드주입방식으로 이게더 편해서. 생성자 방식도 알고있어야한다. 아래.
/*
 * @Autowired public EmpserviceImpl(EmpMapper empMapper) { this.empMapper =
 * empMapper; }
 */

