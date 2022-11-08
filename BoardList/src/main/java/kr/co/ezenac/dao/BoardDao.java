package kr.co.ezenac.dao;

import java.util.List;
import java.util.Map;

import kr.co.ezenac.domain.BoardDto;

public interface BoardDao {

	BoardDto select(Integer bno) throws Exception; 
	
	int insert(BoardDto dto) throws Exception;
	int	count() throws Exception;
	int deleteAll() throws Exception;
	
	
	List<BoardDto> selectpage(Map map) throws Exception;
	
}
