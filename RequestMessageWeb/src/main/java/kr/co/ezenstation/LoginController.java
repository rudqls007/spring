package kr.co.ezenstation;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
		@RequestMapping(value = {"/req/loginForm.do", "/req/loginForm2.do"}, method = {RequestMethod.GET})
		public ModelAndView loginForm() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/requestMessage/loginForm");
			return mav;
			
		}
			@RequestMapping(value = "/req/login.do", method = {RequestMethod.GET, RequestMethod.POST})
			public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
				ModelAndView mav = new ModelAndView();
				
				
				
				// request line
				String requestLine = request.getMethod();			//GET 또는 POST
				requestLine += " " + request.getRequestURI();		// /ezenweb/requestmessage
			 	
			 String	queryString = request.getQueryString();			// year=2022&month=10&day-13
			 requestLine += queryString == null ? "" : "?"+queryString;
			 requestLine += " " + request.getProtocol();
			 System.out.println(requestLine);
			 
			 // request header
			Enumeration<String> e =	request.getHeaderNames();
				
			while(e.hasMoreElements()) {
					String name = e.nextElement();
					System.out.println(name + " : " + request.getHeader(name));
				}
				
				// request body -- post일 때만 해당, GET은 body가 없다.
				final int CONTENT_LENGTH = request.getContentLength();
				System.out.println(" CONTENT_LENGTH " + CONTENT_LENGTH);
				
				if(CONTENT_LENGTH > 0) {
					try {
					
						request.setCharacterEncoding("utf-8");
						mav.setViewName("/requestMessage/result");
						
						String userID = request.getParameter("userID");
						String userName = request.getParameter("userName");
						
						mav.addObject("userID", userID);
						mav.addObject("userName", userName);
						
						System.out.println();
						System.out.println("userID = " + userID + ", userName =" + userName );
						
					} catch (UnsupportedEncodingException e1) {e1.printStackTrace();}
					
				}
				return mav;
			}
		} 

