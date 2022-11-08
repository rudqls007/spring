package kr.co.ezenac.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezenac.dao.BoardDao;
import kr.co.ezenac.domain.BoardDto;

@Service
public class BoardServiceImpI implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDto> getPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectpage(map);
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.count();
	}
}
