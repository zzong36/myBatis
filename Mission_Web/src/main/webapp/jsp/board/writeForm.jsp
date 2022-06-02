<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#listBtn').click(function(){
		location.href = 'list.jsp'
	})
})
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>Write Post</h2>
		<hr>
		<br>
		<form action="write.jsp" method="post">
			<table border="1" style="width: 80%">
				<tr>
					<th width="25%">Title</th>
					<td><input type="text" name="title" size="80"></td>
				</tr>
				<tr>
					<th width="25%">Writer</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th width="25%">Content</th>
					<td>
					<textarea rows="5" cols="80" name="content"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="newPost">
			<button type="button" id="listBtn">LIST</button>
		</form>
	</div>
</body>
</html>