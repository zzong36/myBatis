package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("요청처리...");

		String context = request.getContextPath();
		String uri = request.getRequestURI();
		// System.out.println("uri : " + uri);
		uri = uri.substring(context.length());
		// System.out.println("context :" + context);
		// System.out.println("uri : " + uri);

		try {
			HandlerMapping mappings = new HandlerMapping();
			String callPage = null;
			Controller control = null;
			control = mappings.getController(uri);

			if (control != null) {
				callPage = control.handleRequest(request, response);
				if (callPage.startsWith("redirect:")) {
					callPage = callPage.substring("redirect:".length());
					response.sendRedirect(request.getContextPath() + callPage);
				} else {
					// forward(페이지출력 및 전환)시킬 주소값
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
