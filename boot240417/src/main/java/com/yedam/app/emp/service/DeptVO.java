package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class DeptVO {
	
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

}
