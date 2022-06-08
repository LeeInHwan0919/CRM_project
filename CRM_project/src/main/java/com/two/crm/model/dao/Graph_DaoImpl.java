package com.two.crm.model.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.ContractDto;

@Repository
public class Graph_DaoImpl implements Graph_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Graph_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Integer> ClientGraph() {
		List<Integer> list = sqlSession.selectList(NS+"ClientGraph");
		System.out.println(list);
		return sqlSession.selectList(NS+"ClientGraph");
	}

	


}
