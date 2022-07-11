package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	
//	Statement °´Ã¼·Î ¹¬½ÃÀû Çüº¯È¯
	public static void close(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
