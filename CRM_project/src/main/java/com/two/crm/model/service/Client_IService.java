package com.two.crm.model.service;

import java.util.List;
import java.util.Map;

import com.two.crm.dto.ClientDto;

public interface Client_IService {
	
	public List<ClientDto> AllClient();
	public List<ClientDto> DetailClient(String cli_num);
//	public ClientDto DetailClient(int cli_num);
	public String DeleteClient(String cli_num);
	public int UpdateClient(Map<String, Object> map);
	public int  insertClient(Map<String, Object> map);
	public void insertContractMGT();
	public int insertContract(Map<String, Object> rMap2);
	public void insertContractGS();
	public  List<ClientDto> selectGoodsName();
	public List<ClientDto> selectCliNum();
	public List<ClientDto> selectConractCode();
	public int insertMGT(Map<String, Object> map);
	public int insertGoods(Map<String, Object> map);
	public List<ClientDto> selectStatus(Map<String, Object> map);
}
