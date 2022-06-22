package com.two.crm.model.dao;

import java.util.List;
import java.util.Map;

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
	

	/**
	 * 사원 정보 업데이트
	 * @param map (사원코드, 성별, 전화번호, 주소, 계정사용여부)
	 * @return int
	 */
	public int updateUser(Map<String, Object> map);
	
	/**
	 * 사원 정보 등록
	 * @param dto (사원코드, 담당지역, 사원이름, 비밀번호, 성별, 담당업무(권한), 전화번호, 주소
	 * @return int
	 */
	public int insertUser(UserDto dto);

	public List<UserDto> BackUpUsers();
	public List<UserDto> BackUpLocation();

}
