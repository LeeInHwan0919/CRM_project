package com.two.crm.model.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.GoodsDto;

@Repository
public class Goods_DaoImpl implements Goods_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Goods_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<GoodsDto> AllGoods() {
		return sqlSession.selectList(NS+"AllGoods");
	}

	@Override
	public List<GoodsDto> BackUpContractGoods() {
		return sqlSession.selectList(NS+"BackUpContractGoods");
	}

	@Override
	public List<GoodsDto> BackUpGoodsDiscount() {
		return sqlSession.selectList(NS+"BackUpGoodsDiscount");
	}

	@Override
	public List<GoodsDto> BackUpiMGR() {
		return sqlSession.selectList(NS+"BackUpiMGR");
	}


	@Override
	public List<GoodsDto> BackUpGoods() {
		return sqlSession.selectList(NS+"BackUpGoods");
	}


	


}
