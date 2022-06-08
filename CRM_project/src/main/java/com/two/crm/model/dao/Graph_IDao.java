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
	
}
