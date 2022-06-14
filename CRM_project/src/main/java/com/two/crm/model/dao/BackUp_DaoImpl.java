package com.two.crm.model.dao;



import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.BackupDto;


@Repository
public class BackUp_DaoImpl implements BackUp_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.BackUp_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BackupDto> BackUpBoard() {
		return sqlSession.selectList(NS+"BackUpBoard");
	}
	@Override
	public List<BackupDto> BackUpClient() {
		return sqlSession.selectList(NS+"BackUpClient");
	}

	@Override
	public List<BackupDto> BackUpGoods() {
		return sqlSession.selectList(NS+"BackUpGoods");
	}

	@Override
	public List<BackupDto> BackUpUsers() {
		return sqlSession.selectList(NS+"BackUpUsers");
	}

	


}
