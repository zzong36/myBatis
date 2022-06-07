<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#listBtn').click(function(){
		location.href = 'list.jsp'
	})
})

function checkForm(){
	let f = document.writeForm
	
	if(f.title.value == ''){
		alert('enter title')
		f.title.focus
		return false
	}
	if(f.writer.value == ''){
		alert('enter writer')
		f.writer.focus
		return false
	}
	if(f.content.value == ''){
		alert('enter content')
		f.content.focus
		return false
	}
	
	return true
}
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>Write Post</h2>
		<hr>
		<br>
		<form action="write.jsp" method="post" name="writeForm" onsubmit="return checkForm()">
			<table border="1" style="width: 80%">
				<tr>
					<th width="25%">Title</th>
					<td><input type="text" name="title" size="80" style="width: 80%"></td>
				</tr>
				<tr>
					<th width="25%">Writer</th>
					<td><input type="text" name="writer" style="width: 80%"></td>
				</tr>
				<tr>
					<th width="25%">Content</th>
					<td>
					<textarea rows="5" cols="80" name="content" style="width: 80%"></textarea>
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