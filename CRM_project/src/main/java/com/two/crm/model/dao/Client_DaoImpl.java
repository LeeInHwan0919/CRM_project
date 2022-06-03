package com.two.crm.model.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.ClientDto;

@Repository
public class Client_DaoImpl implements Client_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Client_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ClientDto> AllClient() {
		return sqlSession.selectList(NS+"AllClient");
	}

	@Override
	public List<ClientDto> DetailClient(String cli_num) {
		return sqlSession.selectList(NS+"DetailClient", cli_num);
	}

	@Override
	public String DeleteClient(String cli_num) {
		int cnt = sqlSession.delete(NS+"DeleteClient", cli_num);
		return cli_num;
	}

	@Override
	public int UpdateClient(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"UpdateClient",map);
		return cnt;
	}


}
