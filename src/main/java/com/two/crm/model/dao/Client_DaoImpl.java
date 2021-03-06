package com.two.crm.model.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.ClientDto;

@Repository
public class Client_DaoImpl implements Client_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Client_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ClientDto> AllClient() {
		return sqlSession.selectList(NS+"AllClient");
	}

	@Override
	public List<ClientDto> DetailClient(String cli_num) {
		return sqlSession.selectList(NS+"DetailClient", cli_num);
	}

	@Override
	public String DeleteClient(String cli_num) {
		int cnt = sqlSession.delete(NS+"DeleteClient", cli_num);
		return cli_num;
	}


	@Override
	public int insertClient(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"insertClient",map);
		return cnt;
	}

	@Override
	public void insertContractMGT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertContract(Map<String, Object> rMap2) {
		int cnt= sqlSession.insert(NS+"insertContract",rMap2);
		return cnt;
	}

	@Override
	public void insertContractGS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClientDto> selectGoodsName() {
		return sqlSession.selectList(NS+"selectGoodsName");
	}

	@Override
	public List<ClientDto> selectCliNum() {
		return sqlSession.selectList(NS+"selectCliNum");
	}

	@Override
	public List<ClientDto> selectConractCode() {
		return sqlSession.selectList(NS+"selectConractCode");
	}

	@Override
	public int insertMGT(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"insertMGT",map);
		return cnt;
	}

	@Override
	public int insertGoods(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"insertGoods",map);
		return cnt;
	}

	@Override
	public List<ClientDto> selectStatus(Map<String, Object> map){
		return sqlSession.selectList(NS+"selectStatus",map);
	}

	@Override
	public List<ClientDto> BackUpClient() {
		return sqlSession.selectList(NS+"BackUpClient");
	}


	@Override
	public List<ClientDto> BackUpContract() {
		return sqlSession.selectList(NS+"BackUpContract");
	}

	@Override
	public List<ClientDto> BackUpGoodsClient() {
		return sqlSession.selectList(NS+"BackUpGoodsClient");
	}

	@Override
	public List<ClientDto> BackUpcMGR() {
		return sqlSession.selectList(NS+"BackUpcMGR");
		}

	@Override
	public List<Map<String, Object>> selectLocation() {
		return sqlSession.selectList(NS+"selectLocation");
	}

	
	@Override
	public int UpdateClient(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"UpdateClient",map);
		return cnt;
	}

	@Override
	public int UpdateContract(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"UpdateContract",map);
		return cnt;
	}

	@Override
	public int UpdateGoods(Map<String, Object> map) {
		int cnt= sqlSession.insert(NS+"UpdateGoods",map);
		return cnt;
	}

	@Override
	public List<ClientDto> SumPrice(String cli_num) {
		return sqlSession.selectList(NS+"SumPrice",cli_num);
	}



}
