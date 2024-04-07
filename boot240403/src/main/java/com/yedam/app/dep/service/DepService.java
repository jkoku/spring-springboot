package com.yedam.app.dep.service;

import java.util.List;
import java.util.Map;


public interface DepService {
	// 전체조회
	public List<DepVO> depList();
		
	// 단건조회
	public DepVO depInfo(DepVO depVO);
	
	// 등록
	public int depInsert(DepVO depVO);
	
	// 수정
	public Map<String, Object> depUpdate(DepVO depVO);
	
	// 삭제
	public Map<String, Object> depDelete(DepVO depVO);
}
