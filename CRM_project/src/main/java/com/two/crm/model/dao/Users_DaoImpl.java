package com.two.crm.model.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.UserDto;

@Repository
public class Users_DaoImpl implements Users_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Users_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public List<UserDto> AllUsers() {
		return sqlSession.selectList(NS+"AllUsers");
	}

	@Override
	public List<UserDto> UserDetail(String emp_code) {
		return sqlSession.selectList(NS+"UserDetail",emp_code);
	}

	@Override
	public int updateUser(Map<String, Object> map) {
		return sqlSession.update(NS+"updateUser",map);
	}

	@Override
	public int insertUser(UserDto dto) {
		String encodePw = passwordEncoder.encode(dto.getEmp_pw());
		dto.setEmp_pw(encodePw);
		return sqlSession.update(NS+"insertUser",dto);
	}
	
	public List<UserDto> BackUpUsers() {
		return sqlSession.selectList(NS+"BackUpUsers");
	}

	@Override
	public List<UserDto> BackUpLocation() {
		return sqlSession.selectList(NS+"BackUpLocation");
	}

	


}
