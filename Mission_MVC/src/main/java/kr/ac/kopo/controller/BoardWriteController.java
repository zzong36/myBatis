package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService service = new BoardService();
		service.addBoard(board);
		
//		return "/jsp/board/write.jsp";
		return "redirect:/board/list.do";
	}

}
