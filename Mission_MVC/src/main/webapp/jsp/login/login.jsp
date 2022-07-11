<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/table.css">
<script src="${ pageContext.request.contextPath }/resources/js/myJS.js"></script>

<script>
	function checkForm() {

		let f = document.loginForm

		if (isNull(f.id, "아이디를 입력하세요") || isNull(f.password, "비밀번호를 입력하세요")) {
			return false
		}

		/* let f = document.loginForm
		if(f.id.value == ''){
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}
		
		if(f.password.value == ''){
			alert('비밀번호를 입력하세요')
			f.password.focus()
			return false
		}
		return false; */
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
			<h2>로그인</h2>
			<hr>
			<br>
			<form action="loginProcess.jsp" method="post"
				onsubmit="return checkForm()" name="loginForm">
				<table style="width: 40%">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="로그인">
			</form>

		</div>
	</section>

	<footer>
		<!-- 경로가 Mission_Web 이후부터 시작(xml, include, forward)의 경우 나머지는 localhost:9999/이후부터 시작하므로 절대경로는 /Mission_Web부터 시작  -->
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>


</body>
</html>