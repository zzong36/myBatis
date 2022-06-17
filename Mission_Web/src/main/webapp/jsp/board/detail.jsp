<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page import="kr.ac.kopo.board.vo.*"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
//http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=21

/* 
	작업순서
	1. no 파라미터 추출
	2. 추출된 no에 해당 게시물 조회(t_board)
	3. 조회된 게시물을 화면 출력
*/

int no = Integer.parseInt(request.getParameter("no"));

BoardDAO dao = new BoardDAO();

// 1. 게시물 조회
BoardVO board = dao.selectByNo(no);

// 2. 첨부파일 조회
List<BoardFileVO> fileList = dao.selectFileByNo(no);

// 3. 공유영역 등록
pageContext.setAttribute("board", board);
pageContext.setAttribute("fileList", fileList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세부 게시글</title>
<script>
	function doAction(type) {
		switch (type) {
		case 'U':
			location.href = "update.jsp?no=${param.no}"
			break;
		case 'D':
			if (confirm('삭제하시겠습니까?')) {
				location.href = "delete.jsp?no=${param.no}"
			}
			break;
		case 'L':
			location.href = "list.jsp"
			break;
		}
	}
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>게시판 상세</h2>
		<hr>
		<br>
		<table border="1" style="width: 80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:forEach items="${ fileList }" var="fileVO">
						<a href="/Mission_Web/upload/${ fileVO.fileSaveName }">${ fileVO.fileOriName}</a> (${ fileVO.fileSize }bytes)
					</c:forEach>
				</td>
			</tr>
		</table>
		<br>
		<button onclick="doAction('U')">수 정</button>
		&nbsp;&nbsp;
		<button onclick="doAction('D')">삭 제</button>
		&nbsp;&nbsp;
		<button onclick="doAction('L')">목 록</button>
		&nbsp;&nbsp;
	</div>
</body>
</html>