package com.two.crm.model.dao;

import java.util.List;

import com.two.crm.dto.ClientDto;
import com.two.crm.dto.ContractDto;


public interface Graph_IDao {

	/**
	 * 거래처 통계
	 * @return 현재 계약중인 연도별 거래처 count
	 */
	public List<Integer> ClientGraph();
	
	/**
	 * 상품 통계
	 * @return 판매중인 상품들의 총 갯수 count
	 */
	public List<Integer> GoodsGraph();
	
	/**
	 * 위치 통계
	 * @return 거래처의 지역에 따라 갯수 count
	 */
	public List<Integer> LocationGraph();
}
