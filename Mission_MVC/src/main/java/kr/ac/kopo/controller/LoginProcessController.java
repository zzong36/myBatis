package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.login.vo.LoginVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
//		System.out.println("LoginProcessController 처리부...");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//로그인 성공
		if(id.equals("user") && password.equals("user")) {
			
			LoginVO userVO = new LoginVO();
			userVO.setId(id);
			userVO.setPassword(password);
			userVO.setName("홍길동");
			userVO.setType("U");
			
			//세션등록 세션 객체를 만듦(얻어와야 함)
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			
			return "redirect:/";
		}
		
		//로그인 실패
		
		
		return "redirect:/login.do";
	}

}
