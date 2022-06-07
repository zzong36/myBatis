<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.ac.kopo.util.ConnectionFactory"%>

<%
/*
	작업순서
	1. 파라미터 추출(제목, 작성자, 내용)
	2. t_board 테이블에 새로운 게시글 삽입
	3. 클라이언트에게 결과 전송
*/

// Post 방식은 encoding이 필요
request.setCharacterEncoding("utf-8");

// getParameter()를 통해 값 추출
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

System.out.println("title: " + title);
System.out.println("writer: " + writer);
System.out.println("content: " + content);

// DB에 접속
Connection conn = new ConnectionFactory().getConnection();

StringBuilder sql = new StringBuilder();
sql.append("insert into t_board(no, title, writer, content) ");
sql.append(" values(seq_t_board_no.nextval, ?, ?, ?) ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());
pstmt.setString(1, title);
pstmt.setString(2, writer);
pstmt.setString(3, content);

// 실행
pstmt.executeUpdate();
%>

<!-- 새글 등록해서 전체 게시판으로만 가면 되기 때문에 javascript만 사용하면 된다 -->
<script>
	alert("새글 등록을 완료했습니다");
	// 이동
	location.href = "list.jsp"
	
</script>