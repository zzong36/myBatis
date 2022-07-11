<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('새글 등록을 완료하였습니다')
	location.href = '${ pageContext.request.contextPath}/board/list.do'
</script>