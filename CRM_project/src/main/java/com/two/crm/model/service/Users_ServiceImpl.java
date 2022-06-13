package com.two.crm.model.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.UserDto;
import com.two.crm.model.dao.Users_IDao;




@Service
public class Users_ServiceImpl implements Users_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(Users_ServiceImpl.class);

	@Autowired
	private Users_IDao dao;

	@Override
	public List<UserDto> AllUsers() {
		logger.info("사원 전체조회");
		return dao.AllUsers();
	}

	@Override
	public List<UserDto> UserDetail(String emp_code) {
		logger.info("UserDetail");
		return dao.UserDetail(emp_code);
	}

	@Override
	public List<UserDto> BackUpUsers() {
		return dao.BackUpUsers();
	}

	@Override
	public List<UserDto> BackUpLocation() {
		return dao.BackUpLocation();
	}

}
