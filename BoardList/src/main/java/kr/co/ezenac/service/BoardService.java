package kr.co.ezenac.service;

import java.util.List;
import java.util.Map;

import kr.co.ezenac.domain.BoardDto;

public interface BoardService {

   List<BoardDto> getPage(Map map) throws Exception;
   int getCount() throws Exception;
}