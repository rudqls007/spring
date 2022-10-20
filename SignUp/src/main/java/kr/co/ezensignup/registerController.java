package kr.co.ezensignup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class registerController {
	@RequestMapping(value ="/register/add") // 신규회원 가입 화면
	public String register() {
		return "registerForm";				// /Web-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value ="/register/save")
	public String save(User user) {
		return "registerinfo";				// /Web-INF/views/registerinfo.jsp
	}
}
