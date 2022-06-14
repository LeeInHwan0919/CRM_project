package com.two.crm.model.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.UserDto;
import com.two.crm.model.dao.Login_IDao;

@Service
public class Login_ServiceImpl implements Login_IService{

	@Autowired
	private Login_IDao dao;
	
	@Override
	public UserDto loginChk(String id) {
		return dao.loginChk(id);
	}

	@Override
	public boolean modifyPW(UserDto dto) {
		return dao.modifyPW(dto);
	}


	@Override
	public int match(Map<String, Object> map) {
		return dao.match(map);
	}

}
