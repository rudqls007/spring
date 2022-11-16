package kr.co.heart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.dao.CommentDao;
import kr.co.heart.domain.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {
	
	BoardDao boardDao;
	CommentDao commentDao;
	
	

	@Autowired		// 둘 다 자동으로 Autowired 적용이 된다.
	public CommentServiceImpl(BoardDao boardDao, CommentDao commentDao) {		// boardDao, commentDao 생성자 무조건 있어야 함.
//		super();
		this.boardDao = boardDao;
		this.commentDao = commentDao;
	}



	@Override
	public List<CommentDto> getList(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		//throw new Exception("test"); 에러 보냄
		return commentDao.selectAll(bno);
	}



	@Override
	@Transactional(rollbackFor = Exception.class)
	public int remove(Integer cno, Integer bno, String commenter) throws Exception {
		int rowCnt = boardDao.updateCommentCnt(bno, -1);				// 보드에 있는 댓글 총 개수 줄이는 메서드
		System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//		throw new Exception("test");
		
		
		rowCnt = commentDao.delete(cno, commenter);
		System.out.println("rowCnt = " + rowCnt);
		
		return rowCnt;
	}

}
