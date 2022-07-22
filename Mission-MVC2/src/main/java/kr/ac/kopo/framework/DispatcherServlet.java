package kr.ac.kopo.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet .do로 끝나는 모든 거 받음 webServlet 안에
 * urlPattern을 받아야 한다
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "controllers", value = "kr.ac.kopo.board.controller.BoardController" + "|kr.ac.kopo.login.controller.LoginController") })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HandlerMapping mappings;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String ctrlNames = config.getInitParameter("controllers");
//		System.out.println("ctrlNames : " + ctrlNames);
		
		//HandlerMappingd에서 던진 예외처리
		try {			
			mappings = new HandlerMapping(ctrlNames);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
//		System.out.println("uri : " + uri);
		
//		System.out.println(mappings.getCtrlAndMethod("/board/list.do").getTarget());
//		System.out.println(mappings.getCtrlAndMethod("/board/list.do").getMethod());
		
		// 응답없음 페이지를 만들기 위해 try-catch문 밖에 있어야 한다.
		String view = "";
		
		try {
			CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
			if(cam == null) {
				throw new Exception("해당 URL은 존재하지 않습니다.");
			}
			
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			
			ModelAndView mav = (ModelAndView)method.invoke(target, request, response);
			view = mav.getView();
			
			//공유영역등록
			Map<String, Object> model = mav.getModel();
			Set<String> keys = model.keySet();
			for(String key : keys) {
				request.setAttribute(key, model.get(key));
			}
			
			//메소드 객체를 실행하기 위해 invoke
			//method.invoke(target, request, response);
			
		}catch(Exception e) {
			response.setContentType("text/html; charset=utf-8"); //html/text
			PrintWriter out = response.getWriter();
			out.print(e.getMessage());
		}
		//응답(forward, sendRedirect)
		if(view.startsWith("redirect:")) {
			//sendRedirect
			view = view.substring("redirect:".length());
			response.sendRedirect(view);
		}else {
			//forward
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
