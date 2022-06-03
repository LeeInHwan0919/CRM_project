package com.two.crm.model.service;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.ClientDto;
import com.two.crm.model.dao.Client_IDao;




@Service
public class Client_ServiceImpl implements Client_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(Client_ServiceImpl.class);

	@Autowired
	private Client_IDao dao;
	
	
	@Override
	public List<ClientDto> AllClient() {
		logger.info("Client_ServiceImpl : AllClient ");
		return dao.AllClient();
	}


	@Override
	public List<ClientDto> DetailClient(String cli_num) {
		logger.info("Client_ServiceImpl : DetailClient ");
		return dao.DetailClient(cli_num);
	}


	@Override
	public String DeleteClient(String cli_num) {
		logger.info("Client_ServiceImpl query: DeleteClient ");
		return dao.DeleteClient(cli_num);
	}


	@Override
	public int UpdateClient(Map<String, Object> map) {
		logger.info("UpdateClient query: UpdateClient ");
		return dao.UpdateClient(map);
	}

	
	


}
