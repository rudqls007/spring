package kr.co.work;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/register")
public class RegisterController {
	
	@Autowired
	UserDao  userDao;
	
	
//	 @RequestMapping 대신에 @GetMapping, @PostMapping 사용 가능하다.  
//   @RequestMapping(value = "/register/add2", Method = {RequestMethod.GET, RequestMethod.POST)
//   @RequestMapping(value = "/register/add2")
   @GetMapping("/add")
   public String register() {
      return "registerForm"; // /WEB-INF/views/registerForm.jsp
   }
   
//   @RequestMapping(value = "/register/save2")
   @PostMapping("/add")
   public String save(User user, Model m) throws UnsupportedEncodingException {
      
		   if(isValid(user)) {
			   String msg = URLEncoder.encode("id를 잘못입력했습니다.", "utf-8");
		   }
	   return "registerinfo"; // /WEB-INF/views/registerInfo.jsp
   }

private boolean isValid(User user) {
	// 현재 유효하지 못하게 false로 설정한다.
	return false;
}
}