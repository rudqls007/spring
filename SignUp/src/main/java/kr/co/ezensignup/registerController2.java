package kr.co.ezensignup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class registerController2 {
	//@RequestMapping(value ="/register/add2", method = {RequestMethod.GET, RequestMethod.POST}) // 신규회원 가입 화면
	//@RequestMapping(value ="/register/add2") // 신규회원 가입 화면
	@GetMapping(value = "/register/add2")
	public String register() {
		return "registerForm";				// /Web-INF/views/registerForm.jsp
	}
	
	//@RequestMapping(value ="/register/save2")
	@PostMapping("/register/save2")
	public String save(User user) {
		return "registerinfo";				// /Web-INF/views/registerinfo.jsp
	}
}
