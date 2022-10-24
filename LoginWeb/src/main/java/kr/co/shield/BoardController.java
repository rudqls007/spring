package kr.co.shield;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		
		return "boardList";
		
	}
}
