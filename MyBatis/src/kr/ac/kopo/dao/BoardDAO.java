package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	
	private SqlSession session;
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
}
