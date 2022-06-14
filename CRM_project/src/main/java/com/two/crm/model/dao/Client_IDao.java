package com.two.crm.model.dao;

import java.util.List;
import java.util.Map;

import com.two.crm.dto.ClientDto;


public interface Client_IDao {

	
	public List<ClientDto> AllClient();
	public List<ClientDto> DetailClient(String cli_num);
//	public ClientDto DetailClient(int cli_num);
	public String DeleteClient(String cli_num);
//	public int UpdateClient(Map<String, Object> map);
	public int  insertClient(Map<String, Object> map);
	public void insertContractMGT();
	public int insertContract(Map<String, Object> rMap2);
	public void insertContractGS();
	public List<ClientDto> selectGoodsName();
	public List<ClientDto> selectCliNum();
	public List<ClientDto> selectConractCode();
	public int insertMGT(Map<String, Object> map);
	public int insertGoods(Map<String, Object> map);
	public List<ClientDto> selectStatus(Map<String, Object> map);
	
	
	public List<ClientDto> BackUpClient();
	public List<ClientDto> BackUpcMGR();
	public List<ClientDto> BackUpContract();
	public List<ClientDto> BackUpGoodsClient();
	
	
	public List<Map<String, Object>> selectLocation();
	
	//거래처 수정
	public int UpdateClient(Map<String, Object> map);
	public int UpdateContract(Map<String, Object> map);
	public int UpdateGoods(Map<String, Object> map);
}
