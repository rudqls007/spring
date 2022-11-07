package kr.co.heart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.heart.dao.BoardDao;

@Service
public class BoardServiceImpI implements BoardService {

	@Autowired
	BoardDao boardDao;
}
