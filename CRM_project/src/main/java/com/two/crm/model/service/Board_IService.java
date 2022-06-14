package com.two.crm.model.service;

import java.util.List;
import java.util.Map;


import com.two.crm.dto.BoardDto;




public interface Board_IService {
	
	//게시판 관련
		public List<BoardDto> AllBoard();
		public BoardDto BoardDetail(int seq);
		public int insertBoard(BoardDto bDto);
		public int updateBoard(Map<String, Object> map);
		public int deleteBoard(int seq);
		public int countBoard (Map<String, Object> map);
		public int selectSEQ();
		public int insertFile(Map<String, Object> map);
		public List<BoardDto> selectFileInfo(int seq);
		
		public List<BoardDto> BackUpBoard();
		public List<BoardDto> BackUpFile();
}
