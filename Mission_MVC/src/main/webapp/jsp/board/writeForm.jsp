<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="kr.ac.kopo.login.vo.LoginVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/table.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$('#listBtn').click(function() {
			location.href = 'list.jsp'
		})
	})

	function checkForm() {
		let f = document.writeForm

		if (f.title.value == '') {
			alert('enter title')
			f.title.focus
			return false
		}
		/* if (f.writer.value == '') {
			alert('enter writer')
			f.writer.focus
			return false
		} */
		if (f.content.value == '') {
			alert('enter content')
			f.content.focus
			return false
		}
			
		return true
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
			<h2>글 작성</h2>
			<hr>
			<br>
			<form action="${pageContext.request.contextPath}/board/write.do" method="post" name="writeForm"
				onsubmit="return checkForm()">
				<table border="1" style="width: 80%">
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" name="title" size="80"
							style="width: 80%"></td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td>${ userVO.id }
						<input type="hidden" name="writer" value="${ userVO.id}"></td>
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td><textarea rows="5" cols="80" name="content"
								style="width: 80%"></textarea></td>
					</tr>
				</table>
				<br> <input type="submit" value="등 록">
				<button type="button" id="listBtn">목 록</button>
			</form>
		</div>
	</section>
	<footer>
		<!-- 경로가 Mission_Web 이후부터 시작(xml, include, forward)의 경우 나머지는 localhost:9999/이후부터 시작하므로 절대경로는 /Mission_Web부터 시작  -->
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>