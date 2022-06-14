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
	public int insertClient(Map<String, Object> map) {
		logger.info("UpdateClient query: insertClient ");
		return dao.insertClient(map);
	}


	@Override
	public void insertContractMGT() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int insertContract(Map<String, Object> rMap2) {
		logger.info("UpdateClient query: insertContract ");
		return dao.insertContract(rMap2);
		
	}


	@Override
	public void insertContractGS() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public  List<ClientDto> selectGoodsName() {
		logger.info("UpdateClient query: selectGoodsName ");
		return dao.selectGoodsName();
	}


	@Override
	public List<ClientDto> selectCliNum() {
		logger.info("UpdateClient query: selectCliNum ");
		return dao.selectCliNum();
	}


	@Override
	public List<ClientDto> selectConractCode() {
		logger.info("Client_ServiceImpl query: selectConractCode ");
		return dao.selectConractCode();
	}


	@Override
	public int insertMGT(Map<String, Object> map) {
		logger.info("UpdateClient query: insertMGT ");
		return dao.insertMGT(map);

	
	
	}


	@Override
	public int insertGoods(Map<String, Object> map) {
		logger.info("UpdateClient query: insertGoods ");
		return dao.insertGoods(map);

	}
	
	@Override
	public List<ClientDto> selectStatus(Map<String, Object> map) {
		logger.info("Client_ServiceImpl : selectStatus ");
		return dao.selectStatus(map);
	}


	@Override
	public List<ClientDto> BackUpClient() {
		logger.info("Client_ServiceImpl : BackUpClient ");
		return dao.BackUpClient();
	}


	@Override
	public List<ClientDto> BackUpcMGR() {
		logger.info("Client_ServiceImpl : BackUpcMGR ");
		return dao.BackUpcMGR();
	}


	@Override
	public List<ClientDto> BackUpContract() {
		logger.info("Client_ServiceImpl : BackUpContract ");
		return dao.BackUpContract();
	}


	@Override
	public List<ClientDto> BackUpGoodsClient() {
		logger.info("Client_ServiceImpl : BackUpGoodsClient ");
		return dao.BackUpGoodsClient();
	}


	@Override
	public List<Map<String, Object>> selectLocation() {
		return dao.selectLocation();
	}


	@Override
	public int UpdateClient(Map<String, Object> map) {
		logger.info("Client_ServiceImpl query: UpdateClient ");
		return dao.UpdateClient(map);
	}
	
	@Override
	public int UpdateContract(Map<String, Object> map) {
		logger.info("Client_ServiceImpl query: UpdateContract ");
		return dao.UpdateContract(map);
	}


	@Override
	public int UpdateGoods(Map<String, Object> map) {
		logger.info("Client_ServiceImpl query: UpdateGoods ");
		return dao.UpdateGoods(map);
	}


}
