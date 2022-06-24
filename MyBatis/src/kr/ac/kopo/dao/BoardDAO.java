package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("mybatis 삽입");
		board.setWriter("user");
		board.setContent("삽입완료 했습니다");
		
		session.insert("dao.BoardDAO.insertBoard", board);
		session.commit();
		System.out.println("삽입완료");
	}
	
	public void select() {
		List<BoardVO> boardList = session.selectList("dao.BoardDAO.selectAllBoard");
		for(BoardVO board : boardList)
			System.out.println(board);
		
	}
	
	public void selectOne() {
		// 33번 게시물 조회
		BoardVO vo = new BoardVO();
		vo.setNo(33);
		
		//BoardVO board = session.selectOne("dao.BoardDAO.selectByNo", 33);
		//BoardVO board = session.selectOne("dao.BoardDAO.selectByNo2", vo);
		BoardVO board = session.selectOne("dao.BoardDAO.selectByNo3", vo);
		System.out.println(board);
	}
	
	public void selectWhere() {
		// 제목이 "제목"으로 시작하는 게시물 조회
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere", "제목");
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	public void selectWhere2() {
		BoardVO vo = new BoardVO();
		// 1번 : 제목이 "myBatis 삽입이면서 작성자가 "user"인 게시물 조회
		// vo.setTitle("mybatis 삽입");
		// vo.setWriter("user");
		
		
		// 2번 : 제목이 "mybatis 삽입 게시물 조회
		//vo.setTitle("mybatis 삽입");
		
		//3번 : 작성자가 user인 게시물 조회
		vo.setWriter("user");
		
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectWhere2", vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	public void selectNos() {
		// 1, 2, 6, 10, 15, 19, 24, 30, 33번에 속한 게시물 조회
		int[] nos = {1, 2, 6, 10, 15, 19, 24, 30, 33};
		
		BoardVO vo = new BoardVO();
		vo.setNos(nos);
		
		//List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos", vo);
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectNos2", nos);
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
	}
	
	public void selectMap() {
		//제목이 "mybatis 삽입"이면서 작성자가 "user"인 게시물 조회
		Map<String, String> map = new HashMap<>();
		map.put("title", "mybatis 삽입");
		map.put("writer", "user");
		
		List<BoardVO> list = session.selectList("dao.BoardDAO.selectMap", map);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	public void selectMap2() {
		// 38번 게시물 조회
		Map<String, Object> board = session.selectOne("dao.BoardDAO.selectMap2", 28);
		
		Set<String> keys = board.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + board.get(key));
		}
	}
	
	public void work() {
		//insert();
		//select();
		//selectOne();
		//selectWhere();
		//selectWhere2();
		//selectNos();
		//selectMap();
		selectMap2();
	}
}
