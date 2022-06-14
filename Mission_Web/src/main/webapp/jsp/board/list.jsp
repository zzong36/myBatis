<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%--
	작업순서
	1. t_board 테이블에서 전체 게시글 조회
	2. 조회된 게시물을 하나씩 웹브라우저 출력
 --%>

<%
BoardDAO dao = new BoardDAO();
List<BoardVO> list = dao.selectAll();

// 공유영역 등록
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시판</title>
<link rel="stylesheet" href="/Mission_Web/resources/css/layout.css">
<link rel="stylesheet" href="/Mission_Web/resources/css/table.css">
<!-- 경로: http://localhost:9999/Mission-Web/jsp/board/list.jsp -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = 'writeForm.jsp'
		})
	})
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>전체 게시글 조회</h2>
		<hr>
		<table border="1" width="80%">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<c:forEach items="${ list }" var="board" varStatus="loop">
				<tr <c:if test="${ loop.count mod 2 eq 0 }">class="even"</c:if>>
					<td>${board.no }</td>
					<td><a href="detail.jsp?no=${board.no}">
					 <c:out value="${ board.title}" />
					</a>
					</td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<button id="addBtn">새글등록</button>
	</div>
	</section>
	<footer>
		<!-- 경로가 Mission_Web 이후부터 시작(xml, include, forward)의 경우 나머지는 localhost:9999/이후부터 시작하므로 절대경로는 /Mission_Web부터 시작  -->
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>






















