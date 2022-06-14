package com.two.crm.model.service;

import java.util.List;

import com.two.crm.dto.GoodsDto;

public interface Goods_IService {
	
	public List<GoodsDto> AllGoods();
	
	
	public List<GoodsDto> BackUpiMGR(); //재고관리
	public List<GoodsDto> BackUpContractGoods(); //계약 상품
	public List<GoodsDto> BackUpGoodsDiscount(); //상품할인
	public List<GoodsDto> BackUpGoods(); //재고상품
	
}
