package com.two.crm.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.two.crm.dto.BoardDto;

@Repository
public class Board_DaoImpl implements Board_IDao{
	
	
	private final String NS = "com.two.crm.model.dao.Board_DaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	//게시판

		@Override
		public BoardDto BoardDetail(int seq) {
			return sqlSession.selectOne(NS+"BoardDetail", seq);
		}
		

		@Override
		public List<BoardDto> AllBoard() {
			return sqlSession.selectList(NS+"AllBoard");
		}
		
		@Override
		public int insertBoard(BoardDto bDto) {
			int cnt = sqlSession.insert(NS+"insertBoard", bDto);
			return cnt;
		}
		
		@Override
		public int updateBoard(Map<String, Object> map) {
			int cnt= sqlSession.insert(NS+"updateBoard",map);
			return cnt;
		}


		@Override
		public int deleteBoard(int seq) {
			int cnt = sqlSession.delete(NS+"deleteBoard", seq);
			return cnt;
		}


		@Override
		public int countBoard(Map<String, Object> map) {
			int cnt= sqlSession.insert(NS+"countBoard",map);
			return cnt;
		}


		@Override
		public int selectSEQ() {
			int cnt= sqlSession.selectOne(NS+"selectSEQ");
			return cnt;
		}


		@Override
		public int insertFile(Map<String, Object> map) {
			int cnt= sqlSession.insert(NS+"insertFile",map);
			return cnt;
		}


		@Override
		public List<BoardDto> selectFileInfo(int seq) {
			return sqlSession.selectList(NS+"selectFileInfo",seq);
		}


		@Override
		public List<BoardDto> BackUpBoard() {
			return sqlSession.selectList(NS+"BackUpBoard");
		}

		@Override
		public List<BoardDto> BackUpFile() {
			return sqlSession.selectList(NS+"BackUpBoard");
		}
	

}
