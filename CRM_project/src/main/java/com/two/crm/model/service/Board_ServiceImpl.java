package com.two.crm.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.crm.dto.BoardDto;
import com.two.crm.model.dao.Board_DaoImpl;
import com.two.crm.model.dao.Board_IDao;



@Service
public class Board_ServiceImpl implements Board_IService{
	
	private static final Logger logger = LoggerFactory.getLogger(Board_DaoImpl.class);
	
	

	@Autowired
	private Board_IDao dao;
	
	//게시판
	
	@Override
	public List<BoardDto> AllBoard() {
		logger.info("Board_ServiceImpl : AllBoard ");
		return dao.AllBoard();
	}
	
	@Override
	public BoardDto BoardDetail(int seq) {
		logger.info("Board_ServiceImpl : BoardDetail ");
		return dao.BoardDetail(seq);
	}


	
	
	@Override
	public int updateBoard(Map<String, Object> map) {
		logger.info("Board_ServiceImpl query: updateBoard ");
		return dao.updateBoard(map);
	}

	@Override
	public int insertBoard(BoardDto bDto) {
		logger.info("Board_ServiceImpl query: insertBoard ");
		return dao.insertBoard(bDto);
	}

	@Override
	public int deleteBoard(int seq) {
		logger.info("Board_ServiceImpl query: deleteBoard ");
		return dao.deleteBoard(seq);
	}

	@Override
	public int countBoard(Map<String, Object> map) {
		logger.info("Board_ServiceImpl query: countBoard ");
		return dao.countBoard(map);
	}

	@Override
	public int selectSEQ() {
		logger.info("Board_ServiceImpl query: selectSEQ ");
		return dao.selectSEQ();
	}

	@Override
	public int insertFile(Map<String, Object> map) {
		logger.info("Board_ServiceImpl query: insertFile ");
		return dao.insertFile(map);
	}

	@Override
	public List<BoardDto> selectFileInfo(int seq) {
		logger.info("Board_ServiceImpl query: selectFileInfo ");
		return dao.selectFileInfo(seq);
	}

	@Override
	public List<BoardDto> BackUpBoard() {
		logger.info("Board_ServiceImpl : BackUpBoard ");
		return dao.BackUpBoard();
	}

	@Override
	public List<BoardDto> BackUpFile() {
		logger.info("Board_ServiceImpl : BackUpFile ");
		return dao.BackUpFile();
	}


}
