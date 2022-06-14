package com.two.crm.model.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.GoodsDto;
import com.two.crm.model.dao.Goods_IDao;




@Service
public class Goods_ServiceImpl implements Goods_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(Goods_ServiceImpl.class);

	@Autowired
	private Goods_IDao dao;

	@Override
	public List<GoodsDto> AllGoods() {
		logger.info("재고 조회");
		return dao.AllGoods();
	}

	@Override
	public List<GoodsDto> BackUpContractGoods() {
		return dao.BackUpContractGoods();
	}


	@Override
	public List<GoodsDto> BackUpGoodsDiscount() {
		return dao.BackUpGoodsDiscount();
	}

	@Override
	public List<GoodsDto> BackUpiMGR() {
		return dao.BackUpiMGR();
		}


	@Override
	public List<GoodsDto> BackUpGoods() {
		return dao.BackUpGoods();
		}



}
