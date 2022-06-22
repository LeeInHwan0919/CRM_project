package com.two.crm.model.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	@Override
	public List<Integer> GoodsGraph() {
		List<Integer> list = sqlSession.selectList(NS+"GoodsGraph");
		System.out.println(list);
		return sqlSession.selectList(NS+"GoodsGraph");
	}

	@Override
	public List<Integer> LocationGraph() {
		List<Integer> list = sqlSession.selectList(NS+"LocationGraph");
		System.out.println(list);
		return sqlSession.selectList(NS+"LocationGraph");
	}

	


}
