package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {

	@RequestMapping("/ex")
	public void ezen(Model m) throws Exception {
			
			m.addAttribute("msg", "message from ExceptionController2.ezen()");
			throw new Exception("예외가 발생했습니다.");

	}

	@RequestMapping("/ex2")
	public String ezen2(Model m) throws Exception {

		throw new Exception("예외가 발생했습니다.");

	}

	@RequestMapping("/ex3")
	public String ezen3(Model m) throws Exception {

		throw new NullPointerException("널포인트 예외가 발생했습니다.");
	}

	@RequestMapping("/ex4")
	public void ezen4(Model m) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지 않는 예외가 발생했습니다.");

	}

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) { // 예외정보가 모델에 담겨서 뷰에 전달된 것이다. m.addAttribute("ex", ex); return
		System.out.println("catcher() in ExceptionController2");
		System.out.println("m = " + m.getAttribute("msg"));
		
		m.addAttribute("ex", ex);
		return "error";							// "error";

	}

	@ExceptionHandler({ NullPointerException.class, FileNotFoundException.class })
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";

	}

}
