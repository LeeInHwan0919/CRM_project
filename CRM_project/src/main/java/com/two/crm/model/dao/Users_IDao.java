package com.two.crm.model.dao;

import java.util.List;

import com.two.crm.dto.UserDto;


public interface Users_IDao {

	/**
	 * 사원 전체 조회
	 * @return 사원 정보
	 */
	public List<UserDto> AllUsers();
	
	/**
	 * 사원 상세 조회
	 * @return 사원 상세 정보
	 */
	public List<UserDto> UserDetail(String emp_code);
	
	public List<UserDto> BackUpUsers();
	public List<UserDto> BackUpLocation();
}
