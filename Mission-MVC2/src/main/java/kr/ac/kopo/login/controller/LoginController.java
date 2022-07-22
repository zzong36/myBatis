package kr.ac.kopo.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.ModelAndView;
import kr.ac.kopo.framework.annotation.Controller;
import kr.ac.kopo.framework.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse reponse) throws Exception{
		ModelAndView mav = new ModelAndView("/jsp/login/login.jsp");
//		System.out.println("login() 호출.....");
		return mav;
	}
}
