package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	/**
	 * 
	 * @param request 		요청객체
	 * @param response		응답객체
	 * @return				forward시킬 jsp 주소
	 * @throws Exception	예외
	 */
	
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
