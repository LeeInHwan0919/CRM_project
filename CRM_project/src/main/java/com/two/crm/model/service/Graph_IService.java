package com.two.crm.model.service;

import java.util.List;

import com.two.crm.dto.ClientDto;
import com.two.crm.dto.ContractDto;

public interface Graph_IService {
	
	public List<Integer> ClientGraph();
	
	public List<Integer> GoodsGraph();
	
	public List<Integer> LocationGraph();
}
