package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

public class BoardService {

	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
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
	
}
