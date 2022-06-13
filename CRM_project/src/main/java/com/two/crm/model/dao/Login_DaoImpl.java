package com.two.crm.model.dao;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.UserDto;

@Repository
public class Login_DaoImpl implements Login_IDao{

	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS = "com.two.crm.login.";

	@Override
	public UserDto loginChk(String id) {
		UserDto dto = session.selectOne(NS+"loginChk", id);
		System.out.println("DTO : " + dto);
		
		return dto;
	}

	@Override
	public boolean signUp(UserDto dto) {
		// 화면에서 입력된 비밀번호를 암호화
		String encodePw = passwordEncoder.encode(dto.getEmp_pw());
		// 암호화된 비밀번호를 저장
		dto.setEmp_pw(encodePw);
		
		return session.insert(NS+"signUp", dto) > 0 ? true : false;
	}

	@Override
	public String telChk(String emp_code) {
		return session.selectOne(NS+"telChk",emp_code);
	}

}
