package com.two.crm.model.dao;


import java.util.Map;

import com.two.crm.dto.UserDto;

public interface Login_IDao {

	/**
	 * 입력받은 아이디를 통해 비밀번호를 가져옴
	 * @param 사용자의 id
	 * @return 암호화된 비밀번호
	 */
	public UserDto loginChk(String id);
	
	
	/**
	 * 사원코드에 해당하는 비밀번호 변경 
	 * @param 사원코드, 새 비밀번호
	 * @return true, false
	 */
	public boolean modifyPW(UserDto dto);
	
	
	/**
	 * 사원코드에 해당하는 전화번호인지
	 * @param emp_code 사원코드, emp_tel 전화번호
	 * @return int
	 */
	public int match(Map<String, Object> map);
	
}
