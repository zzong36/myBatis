package kr.ac.kopo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("리스너 시작...");
    	
    	//NEW를 하지 않고 리스너에서 만들어서 쓰고 싶음
    	//개발자가 NEW 하지 않고 여기서 선언하고 사용함
    	
    	//ServletContext영역에서 공유하고 사용하고 싶음
    	ServletContext sc = event.getServletContext();
    	
    	BoardDAO boardDAO = new BoardDAO();
    	//boardDAO를 파라미터로 넘겨줌
    	BoardService service = new BoardService(boardDAO);
    	
    	//미리 객체를 만들어줌 boardService만 만들어주면 됨
    	sc.setAttribute("boardService", service);
    }
	
}
