<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Info</title>
</head>
<body>
	<%
		InputStreamReader isr =new InputStreamReader(request.getInputStream(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		while(true){
			String buf = br.readLine();
			if(buf == null) break;
			out.write(buf + "<br>");
		}
	%>
</body>
</html>