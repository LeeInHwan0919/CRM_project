package com.two.crm.model.dao;

import java.util.List;
import com.two.crm.dto.BackupDto;

public interface BackUp_IDao {
	
	public List<BackupDto> BackUpBoard(); // 게시판
	public List<BackupDto> BackUpClient(); // 거래처 
	public List<BackupDto> BackUpGoods(); //재고
	public List<BackupDto> BackUpUsers(); // 사원
}
