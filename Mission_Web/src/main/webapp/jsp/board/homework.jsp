<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="kr.ac.kopo.util.ConnectionFactory"%>

<%
	Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("select id, name, password,email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as reg_date");
	sql.append("	from t_member");
	sql.append(" order by reg_date");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());
ResultSet rs = pstmt.executeQuery();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<hr>
	<h1>전체 회원 조회</h1>
	<hr>
	<table border="1" width="100%">
	<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>비밀번호</th>	
	<th>이메일 아이디</th>	
	<th>이메일 도메인</th>	
	<th>전화1</th>	
	<th>전화2</th>	
	<th>전화3</th>	
	<th>주소</th>	
	<th>상세주소</th>	
	<th>타입</th>	
	<th>가입일</th>	
	</tr>
	<%
		while(rs.next()){
			String id = rs.getString("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			String email_id = rs.getString("email_id");
			String email_domain = rs.getString("email_domain");
			String tel1 = rs.getString("tel1");
			String tel2 = rs.getString("tel2");
			String tel3 = rs.getString("tel3");
			String basic_addr = rs.getString("basic_addr");
			String detail_addr = rs.getString("detail_addr");
			String type = rs.getString("type");
			String reg_date = rs.getString("reg_date");
	%>
	<tr>
		<td><%=id %></td>
		<td><%=name %></td>
		<td><%=password %></td>
		<td><%=email_id %></td>
		<td><%=email_domain %></td>
		<td><%=tel1 %></td>
		<td><%=tel2 %></td>
		<td><%=tel3 %></td>
		<td><%=basic_addr %></td>
		<td><%=detail_addr %></td>
		<td><%=type %></td>
		<td><%=reg_date %></td>
	</tr>
	<%
		}
	%>
	</table>
<br>
</div>
</body>
</html>