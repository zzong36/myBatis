package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.framework.ModelAndView;
import kr.ac.kopo.framework.annotation.RequestMapping;

/* 그룹별로 Controller가 줄어든다
 * 전체 게시글 조회			/board/list.do						list()
 * 새글 등록 폼			/board/writeForm.do					writeForm()
 * 새글 등록				/board/write.do						write()
 * 상세 게시글 조회			/board/detail.do					detail()
 * 게시글 수정
 * 게시글 삭제 
 */

public class BoardController {

	@RequestMapping(value="/board/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		ServletContext sc = request.getServletContext();

//		System.out.println("list() 호출.....");
		
		BoardService service = (BoardService)sc.getAttribute("boardService");
		List<BoardVO> boardList = service.selectAllBoard();
		
		//공유영역에 등록시킬 객체와 포워드할 주소를 가지고 있는 클래스
		ModelAndView mav = new ModelAndView("/jsp/board/list.jsp");
		//공유영역에 올려달라고 모델객체로 넘긴 상태
		mav.setAttribute("list", boardList);
		return mav;
	}
	
	//value="" 사용 가능
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		//객체를 만드는 행위는 
		ServletContext sc = request.getServletContext();
		BoardService service = (BoardService)sc.getAttribute("boardService");
		BoardVO board = service.selectByNo(no);
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/jsp/board/detail.jsp");
		mav.setAttribute("board", board);
		
//		System.out.println("detail() 호출.....");
		return mav;
	}
	
	@RequestMapping("/board/writeForm.do")
	public ModelAndView writeForm(HttpServletRequest request, HttpServletResponse respone) throws Exception {

		
		ModelAndView mav = new ModelAndView("/jsp/board/writeForm.jsp");
		return mav;
	}

}
