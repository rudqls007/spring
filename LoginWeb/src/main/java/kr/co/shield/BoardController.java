package kr.co.shield;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		
		
		if(!loginCheck(request))			// 로그인을 하지 않았을 때, 로그인 화면으로 이동한다.
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		return "boardList";					// 로그인 한 상태이면, 게시판 목록 화면으로 이동
		
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 세션을 얻어서
		HttpSession session = request.getSession();
		// 세션에 id가 있는지 확인, 있으면 true 반환
		return session.getAttribute("id") != null;						// true를 반환, null이면 false를 반환한다.
	}
}
