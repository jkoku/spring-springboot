package com.yedam.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yedam.app.dep.service.DepVO;


@Mapper
public interface DepMapper {
	// 전체조회
	public List<DepVO> selectEmpAll();
	
	// 단건조회
	public DepVO selectEmp(DepVO depVO);

	// 등록
	public int insertEmp(DepVO depVO);
	
	// 수정
	public int updateDep(DepVO depVO);
	// 객체에파람이 붙으면 그 이름으로 찾아가서 내부에 있는 필드값을 불러와야한다.
	// (@Param("emp")EmpVO) 할꺼면.. #{emp.salary}
	
	// 삭제
	public int deleteDep(@Param("did") int departmentId);
	// mapper안에 쿼리문에 이름 지정할떄 param 을 사용. 여러개의 값을 넘길때는 이름을 각각 부여.ㅣ
	// param 안 이름만 사용 가능. 

	
}
