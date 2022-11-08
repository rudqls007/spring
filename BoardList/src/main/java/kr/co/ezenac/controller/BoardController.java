package kr.co.ezenac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ezenac.domain.BoardDto;
import kr.co.ezenac.domain.pageResolver;
import kr.co.ezenac.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page,
					   @RequestParam(defaultValue = "10")Integer pageSize,
					   Model m,
					   HttpServletRequest request) {

		if (!loginCheck(request))
			return "redirect:/login/login?toURL=" + request.getRequestURL(); // 로그인을 하지 않은 상태, 로그인을 하고 나서 보드 게시판으로 넘어가게끔
																				// 하는 코드
		try {
			
//			if(page==null) page=1;
//			if(pageSize==null) pageSize=10;
			
			int totalCnt = boardService.getCount();
			m.addAttribute("totalCnt", totalCnt);
		
			pageResolver pageResolver = new pageResolver(totalCnt, page, pageSize);
			
			
			if(page < 0 || page > pageResolver.getTotalCnt()) {
				page = 1;
			}
			if(pageSize < 0 || pageSize > 50) {
				pageSize = 10;
			}
			
			Map map = new HashMap();
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
			
			
			List<BoardDto> list = boardService.getPage(map);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardList"; // 로그인을 한 상태, 게시판 목록 화면으로 이동

	}

	private boolean loginCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub

		// 1. 세션을 얻어서
		HttpSession session = request.getSession(false); // false는 session이 없더라도 새로 생성하지 않는다. 반환 값 null
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환한다.
		return session != null && session.getAttribute("id")!=null;
	}
}
