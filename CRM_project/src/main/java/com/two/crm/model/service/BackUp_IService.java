package com.two.crm.model.service;

import java.util.List;
import java.util.Map;

import com.two.crm.dto.BackupDto;

public interface BackUp_IService {
	
	public List<BackupDto> BackUpBoard(); // 게시판
	public List<BackupDto> BackUpClient(); // 거래처 
	public List<BackupDto> BackUpGoods(); //재고
	public List<BackupDto> BackUpUsers(); // 사원
	

}
