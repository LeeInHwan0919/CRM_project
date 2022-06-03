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
	
}
