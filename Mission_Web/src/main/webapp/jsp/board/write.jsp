<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@ page import="kr.ac.kopo.board.vo.*"%>
<%@ page import="kr.ac.kopo.login.vo.LoginVO"%>
<%@ page import="kr.ac.kopo.util.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
/*
	작업순서
	1. 파라미터 추출(제목, 작성자, 내용)
	2. t_board 테이블에 새로운 게시글 삽입
	3. 클라이언트에게 결과 전송
*/

// Post 방식은 encoding이 필요
request.setCharacterEncoding("utf-8");

// String saveFolder= "D:/eclipse practice/web-workspace/Mission_Web/src/main/webapp/upload";
String saveFolder = "D:/eclipse practice/web-workspace/Mission_Web/src/main/webapp/upload";

MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new KopoFileNamePolicy());

String title = multi.getParameter("title");
String writer = multi.getParameter("writer");
String content = multi.getParameter("content");

// 1. 게시판 저장
BoardVO board = new BoardVO();
board.setTitle(title);
board.setWriter(writer);
board.setContent(content);

BoardDAO dao = new BoardDAO();

// 등록할 글번호 조회
int boardNo = dao.selectBoardNo(); 
board.setNo(boardNo);

dao.insertBoard(board);

// System.out.println(board);

// 2. 첨부파일 저장
Enumeration<String> files =  multi.getFileNames();
while(files.hasMoreElements()){
	String fileName = files.nextElement();
	// System.out.println(fileName);
	
	File f = multi.getFile(fileName);
	if(f != null){
		String fileOriName = multi.getOriginalFileName(fileName);
		// 저장된 이름은 도대체 뭔데?
		String fileSaveName = multi.getFilesystemName(fileName);
		int fileSize = (int)f.length();
		
		BoardFileVO fileVO = new BoardFileVO();
		fileVO.setFileOriName(fileOriName);
		fileVO.setFileSaveName(fileSaveName);
		fileVO.setFileSize(fileSize);
		fileVO.setBoardNo(boardNo);
		
		// System.out.println(fileVO);
		dao.insertBoardFile(fileVO);
	}
	
}

/* 아래와 같이 가져오는게 목표
File f = multi.getFile("attachfile1")
f.multi.getFile("attachfile2")
 */
 
/* // getParameter()를 통해 값 추출
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

BoardVO board = new BoardVO();
board.setTitle(title);
board.setWriter(writer);
board.setContent(content);

BoardDAO dao = new BoardDAO();
// dao.insertBoard(board); */

/* System.out.println("title: " + title);
System.out.println("writer: " + writer);
System.out.println("content: " + content); */

/* // DB에 접속
Connection conn = new ConnectionFactory().getConnection();

StringBuilder sql = new StringBuilder();
sql.append("insert into t_board(no, title, writer, content) ");
sql.append(" values(seq_t_board_no.nextval, ?, ?, ?) ");

PreparedStatement pstmt = conn.prepareStatement(sql.toString());
pstmt.setString(1, title);
pstmt.setString(2, writer);
pstmt.setString(3, content);

// 실행
pstmt.executeUpdate(); */
%>

<!-- 새글 등록해서 전체 게시판으로만 가면 되기 때문에 javascript만 사용하면 된다 -->
<script>
	alert("새글 등록을 완료했습니다");
	// 이동
	location.href = "list.jsp"
</script>