<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈페이지</title>
<link rel="stylesheet" href="/Mission_Web/resources/css/layout.css">
<link rel="stylesheet" href="/Mission_Web/resources/css/table.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>section 부분</section>
	<footer>
		<!-- 경로가 Mission_Web 이후부터 시작(xml, include, forward)의 경우 나머지는 localhost:9999/이후부터 시작하므로 절대경로는 /Mission_Web부터 시작  -->
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>