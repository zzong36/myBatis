package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
//	DB �̵� �� ConnectioFactory�� ���� ���̵�, ��й�ȣ, ip �ּ� ���� ���⼭�� �ٲٸ� �ǹǷ� ���� �̵� ����

	public Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 완료....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

//	try-catch�� ����ϱ� �������� throws ���
//	public Connection getConnection() throws Exception {
//
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
//		String user = "scott";
//		String password = "tiger";
//
//	}

}
