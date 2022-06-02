package com.two.crm.model.dao;

import java.util.List;
import java.util.Map;

import com.two.crm.dto.BoardDto;


public interface Board_IDao {

	//게시판관련
	
		public List<BoardDto> AllBoard();
		public BoardDto BoardDetail(int seq);
		public int insertBoard(BoardDto bDto);
		public int updateBoard(Map<String, Object> map);
		public int deleteBoard(int seq);
		public int countBoard (Map<String, Object> map);
		
}
