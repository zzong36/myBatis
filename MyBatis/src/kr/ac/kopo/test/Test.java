package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;

import kr.ac.kopo.MyConfig;
import kr.ac.kopo.dao.BoardDAO;

public class Test {

	@Ignore // 지금은 테스트 하지 않는다는 말
	@org.junit.Test
	public void myConfigTest() throws Exception{
		MyConfig config = new MyConfig();
		SqlSession session = config.getInstance();
		
		assertNotNull(session);
	}
	
	@org.junit.Test
	public void BoardDAO생성테스트() throws Exception{
		BoardDAO dao = new BoardDAO();
	}
}
