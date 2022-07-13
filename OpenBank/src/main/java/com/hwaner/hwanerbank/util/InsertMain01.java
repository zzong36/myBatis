package com.hwaner.hwanerbank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMain01 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@zzongbank_medium?TNS_ADMIN=C:/Users/DA/Desktop/zzongbank/Wallet_zzongbank";
			String user = "ADMIN";
			String password = "Tjrud2260341015";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);

			stmt = conn.createStatement();
			String sql = "insert into t_test(id, name) ";
			sql += " values ('hong', '홍길동')";

			// 4단계
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 " + cnt + "개 행이 삽입되었습니다");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
}
