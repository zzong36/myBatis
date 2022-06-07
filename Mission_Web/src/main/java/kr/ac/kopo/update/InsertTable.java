package kr.ac.kopo.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class InsertTable {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {

			conn = new ConnectionFactory().getConnection();

			Scanner sc = new Scanner(System.in);

			//1
			System.out.print("id: ");
			String id = sc.nextLine();
			
			//2
			System.out.print("name: ");
			String name = sc.nextLine();
			
			//3
			System.out.print("password: ");
			String password = sc.nextLine();
			
			//4
			System.out.print("email_id: ");
			String email_id = sc.nextLine();
			
			//5
			System.out.print("email_domain: ");
			String email_domain = sc.nextLine();
			
			//6
			System.out.print("tel1: ");
			String tel1 = sc.nextLine();
			
			//7
			System.out.print("tel2: ");
			String tel2 = sc.nextLine();
			
			//8
			System.out.print("tel3: ");
			String tel3 = sc.nextLine();
			
			//9
			System.out.print("post: ");
			String post = sc.nextLine();

			//10
			System.out.print("basic_addr: ");
			String basic_addr = sc.nextLine();

			//11
			System.out.print("detail_addr: ");
			String detail_addr = sc.nextLine();
			
			//12
			System.out.print("type: ");
			String type = sc.nextLine();

			//13
			System.out.print("reg_date: ");
			 String reg_date = sc.nextLine();
			 
			
			String sql = "insert into t_member values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, email_id);
			pstmt.setString(5, email_domain);
			pstmt.setString(6, tel1);
			pstmt.setString(7, tel2);
			pstmt.setString(8, tel3);
			pstmt.setString(9, post);
			pstmt.setString(10, basic_addr);
			pstmt.setString(11, detail_addr);
			pstmt.setString(12, type);
			pstmt.setString(13, reg_date);
			

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "행 수정완료...");

		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			JDBCClose.close(pstmt, conn);
			
		}

	}

}
