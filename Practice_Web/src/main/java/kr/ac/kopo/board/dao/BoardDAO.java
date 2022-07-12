package kr.ac.kopo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.util.ConnectionFactory;

//t_board 테이블의 crud 담당 클래스

public class BoardDAO {

	// 게시글 번호(no)에 헤당하는 게시물 조회 메소드

	public BoardVO selectByNo(int no) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, writer, title, content, view_cnt, to_char(reg_date, 'yyyy-mm-dd') reg_date from t_board where no = ?" );
		
		try(Connection conn = new ConnectionFactory().getConnection();
					//Statement 인터페이스는 SQL 구문을 DBMS에 전달하는 역할을 하는데, PrepareStatement는 해당 인터페이스를 상속한다 
					//Statement와 PrepareStatement와의 차이는 Statement 인터페이스는 DBMS에 단순 문자열을 전달한 후 DBMS가 컴파일한다. 
					//반면 PrepareStatement의 경우에는 컴파일된 SQL문을 DBMS에 전달하여 성능을 향상시킨다
					//게다가 PrepareStatement는 SQL 문에 ? 를 넣을 수 있다
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
