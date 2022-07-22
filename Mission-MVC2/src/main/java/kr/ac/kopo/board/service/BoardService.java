package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardService {

	private BoardDAO boardDAO;
	
	public BoardService(BoardDAO boardDAO) {
		//의존주입(Dependency Injection) 객체를 개발자가 만들지 않고 다른데서 만들어진 것을 사용한다. 
		//ContextListener에서 받아서 내 매개변수에 넣어줌
		this.boardDAO = new BoardDAO();
	}


	/**
	 * 전체 게시글 조회
	 */
	
	public List<BoardVO> selectAllBoard(){
		List<BoardVO> boardList = boardDAO.selectAll();
		
		return boardList;
	}
	
	/**
	 *  게시글 등록
	 */
	
	public void addBoard(BoardVO board) {
		
		int no = boardDAO.selectBoardNo();
		board.setNo(no);
		boardDAO.insertBoard(board);
	}
	
	/**
	 * 
	 */
	
	public BoardVO selectByNo(int no) {
		return boardDAO.selectByNo(no);
	}
}
