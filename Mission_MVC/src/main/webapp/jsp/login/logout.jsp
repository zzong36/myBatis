<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();

	/* response.sendRedirect("/Mission_Web"); */
%>

<script>
	location.href='${ pageContext.request.contextPath }'
</script>