package com.two.crm.model.service;


import java.util.List;
import java.util.Map;

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
		logger.info("AllUsers ServiceImpl");
		return dao.AllUsers();
	}

	@Override
	public List<UserDto> UserDetail(String emp_code) {
		logger.info("UserDetail ServiceImpl");
		return dao.UserDetail(emp_code);
	}

	@Override
	public int updateUser(Map<String, Object> map) {
		logger.info("updateUser ServiceImpl");
		return dao.updateUser(map);
	}

	@Override
	public int insertUser(Map<String, Object> map) {
		logger.info("insertUser ServiceImpl");
		return dao.insertUser(map);
	}

}
