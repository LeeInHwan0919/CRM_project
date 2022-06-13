package com.two.crm.model.service;



import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.BackupDto;
import com.two.crm.model.dao.BackUp_IDao;




@Service
public class BackUp_ServiceImpl implements BackUp_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(BackUp_ServiceImpl.class);

	@Autowired
	private BackUp_IDao dao;

	@Override
	public List<BackupDto> BackUpBoard() {
		logger.info("BackUp_ServiceImpl : BackUpBoard ");
		return dao.BackUpBoard();
	}
	

	@Override
	public List<BackupDto> BackUpClient() {
		logger.info("BackUp_ServiceImpl : BackUpClient ");
		return dao.BackUpClient();
	}

	@Override
	public List<BackupDto> BackUpGoods() {
		logger.info("BackUp_ServiceImpl : BackUpGoods ");
		return dao.BackUpGoods();
	}

	@Override
	public List<BackupDto> BackUpUsers() {
		logger.info("BackUp_ServiceImpl : BackUpUsers ");
		return dao.BackUpUsers();
	}
	
	
	
}
