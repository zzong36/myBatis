package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
//	DB 이동 시 ConnectioFactory를 통해 아이디, 비밀번호, ip 주소 등을 여기서만 바꾸면 되므로 쉽게 이동 가능

	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

//	try-catch문 사용하기 귀찮으면 throws 사용
//	public Connection getConnection() throws Exception {
//
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
//		String user = "scott";
//		String password = "tiger";
//
//	}

}
