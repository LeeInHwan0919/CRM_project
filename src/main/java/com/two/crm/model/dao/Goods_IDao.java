package com.two.crm.model.dao;

import java.util.List;

import com.two.crm.dto.GoodsDto;


public interface Goods_IDao {

	/**
	 * 재고 전체조회
	 * @return 재고리스트
	 */
	public List<GoodsDto> AllGoods();
	
	public List<GoodsDto> BackUpContractGoods();
	public List<GoodsDto> BackUpGoodsDiscount();
	public List<GoodsDto> BackUpiMGR();
	public List<GoodsDto> BackUpGoods();
	
}
