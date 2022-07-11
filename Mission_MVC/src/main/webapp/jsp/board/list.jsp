<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시판</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = 'writeForm.jsp'
		})
	})

	function checkLogin(boardNo) {
		/* 백에서 날아오는 문자 웹에서 해석하나? 텍스트 형태로 날아가기 때문에 상관없음 */
		<c:choose>
		<c:when test="${empty userVO}">
			if(confirm('로그인 후 사용가능합니다 로그인 페이지로 이동할까요?')){
				location.href="${ pageContext.request.contextPath }/jsp/login/login.jsp"
			}
		</c:when>
		<c:otherwise>
		location.href = 'detail.jsp?no=' + boardNo
		</c:otherwise>
		</c:choose>
	}
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
						<td><a href="javascript:checkLogin(${board.no })"> <c:out
									value="${ board.title }" />
						</a> <%-- <a href="detail.jsp?no=${board.no}">
					 		<c:out value="${ board.title}" />
							</a>--%></td>
						<td>${board.writer }</td>
						<td>${board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${ not empty userVO }">
				<button id="addBtn">새글등록</button>
			</c:if>
		</div>
	</section>
	<footer>
		<!-- 경로가 Mission_Web 이후부터 시작(xml, include, forward)의 경우 나머지는 localhost:9999/이후부터 시작하므로 절대경로는 /Mission_Web부터 시작  -->
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>






















