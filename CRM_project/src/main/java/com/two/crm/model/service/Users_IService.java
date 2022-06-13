package com.two.crm.model.service;

import java.util.List;

import com.two.crm.dto.UserDto;

public interface Users_IService {
	
	public List<UserDto> AllUsers();
	
	public List<UserDto> UserDetail(String emp_code);
}
