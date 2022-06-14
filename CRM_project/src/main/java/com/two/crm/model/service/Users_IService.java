package com.two.crm.model.service;

import java.util.List;
import java.util.Map;

import com.two.crm.dto.UserDto;

public interface Users_IService {
	
	public List<UserDto> AllUsers();
	
	public List<UserDto> UserDetail(String emp_code);
	

	public int updateUser(Map<String, Object> map);
	
	public int insertUser(Map<String, Object> map);

	public List<UserDto> BackUpUsers();
	public List<UserDto> BackUpLocation();

}
