package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

/*
 * t_board 테이블의 CRUD 담당 클래스
 */

public class BoardDAO {

	/**
	 * no에 해당 게시물 조회 메소드
	 */
	public BoardVO selectByNo(int no) {

		// StringBuilder는 autoclosable 안 됨
		StringBuilder sql = new StringBuilder();
		sql.append("select no, writer, title, content, view_cnt ");
		sql.append("    , to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append(" from t_board ");
		sql.append(" where no = ? ");

		// try()는 자동으로 연결을 해제함 autoclosable 인터페이스 상속받고 있기 때문에
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			// 물음표는 여기서 채움
			pstmt.setInt(1, no);

			ResultSet rs = pstmt.executeQuery();

			// 한번만 돌리면 됨
			if (rs.next()) {

				int boardNo = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");

				// BoardVO로 감싼다
				BoardVO board = new BoardVO(boardNo, title, writer, content, viewCnt, regDate);

				return board;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 전체 게시글 조회 메소드
	 */
	public List<BoardVO> selectAll() {

		List<BoardVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date");
			sql.append("	from t_board");
			sql.append(" order by no desc");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			// 데이터 추출
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");

				BoardVO board = new BoardVO();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);

				list.add(board);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}

		return list;
	}

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		System.out.println(dao.selectByNo(25).toString());
	}

	/**
	 * 새글등록
	 */

	public void insertBoard(BoardVO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_board(no, title, writer, content) ");
			sql.append(" values(seq_t_board_no.nextval, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
}
