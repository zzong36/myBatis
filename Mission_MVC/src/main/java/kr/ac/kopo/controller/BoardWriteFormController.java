package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * board/writeForm.do 요청시 처리
 */
public class BoardWriteFormController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "/jsp/board/writeForm.jsp";
	}

}
