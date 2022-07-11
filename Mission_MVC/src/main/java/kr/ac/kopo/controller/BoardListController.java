package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardListController implements Controller{

	
//	FrontController가 해야 할 일(요청과 응답)을 대신해주기 위한 메서드
//	FrontController에게 forward 시킬 주소값(jsp)를 알려주기 위해 리턴값이 String이다
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		BoardService service = new BoardService();
		List<BoardVO> boardList = service.selectAllBoard();
		
		//request 영역에 등록해줌
		request.setAttribute("list", boardList);
		
		// 아래 주소값으로 forward해 줄려고 함
		return "/jsp/board/list.jsp";
	}
}

//		List<BoardVO> list = new ArrayList<>();
//		list.add(new BoardVO("aaa", "bbb"));
//		list.add(new BoardVO("ccc", "ddd"));
//		list.add(new BoardVO("eee", "fff"));
//		
//		//REQUEST 공유영역에 등록
//		request.setAttribute("list", list);