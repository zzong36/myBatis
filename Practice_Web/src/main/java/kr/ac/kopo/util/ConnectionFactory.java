package kr.ac.kopo.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		// 데이터베이스와 연결된 세션 역할 수행 이 세션을 통해 데이터베이스에 SQL을 전송하고 그 결과인 ResultSet 객체를 얻어낸다
		Connection conn = null;
		
		try{
			//드라이버 로드. 드라이버란 서로 통신할 수 있게 하는 소프트웨어의 구성요소
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, user, password);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
