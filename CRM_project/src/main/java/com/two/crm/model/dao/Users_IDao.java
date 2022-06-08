package com.two.crm.model.dao;

import java.util.List;

import com.two.crm.dto.UserDto;


public interface Users_IDao {

	/**
	 * 사원 전체 조회
	 * @return 사원 정보
	 */
	public List<UserDto> AllUsers();
	
}
