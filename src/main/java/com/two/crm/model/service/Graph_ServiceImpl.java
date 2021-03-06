package com.two.crm.model.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.model.dao.Graph_IDao;




@Service
public class Graph_ServiceImpl implements Graph_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(Graph_ServiceImpl.class);

	@Autowired
	private Graph_IDao dao;

	@Override
	public List<Integer> ClientGraph(){
		logger.info("Chart ServiceImpl ClientGraph");
		return dao.ClientGraph();
	}

	@Override
	public List<Integer> GoodsGraph() {
		logger.info("Chart ServiceImpl GoodsGraph");
		return dao.GoodsGraph();
	}

	@Override
	public List<Integer> LocationGraph() {
		logger.info("Chart ServiceImpl LocationGraph");
		return dao.LocationGraph();
	}

}
