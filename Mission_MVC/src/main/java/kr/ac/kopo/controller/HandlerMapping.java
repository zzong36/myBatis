package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings = new HashMap<>();

	public HandlerMapping(String propLocation) {
		// 블랙박스 속에 있으므로 원칙적으로 고칠 수 없다. 그러므로 bean.properties를 읽어와서 동일하게 동작하게 해준다.
	
		//properties 파일 읽어오기
		Properties prop = new Properties();
		
		try {
			InputStream is = new FileInputStream(propLocation);
			prop.load(is);
			
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
//				System.out.println(key); //bean.properties의 키값을 읽어옴
				String className = prop.getProperty(key.toString());
//				System.out.println(className);
				
				// 클래스이름(String)을 아는것 뿐이지 객체가 생성된 것은 아님 그렇다면 어떻게 생성할 수 있는가?
				// class를 JVM으로 로딩시키는 것
				Class<?> clz = Class.forName(className);
				//생성자 이용해서 객체 만듦
				Constructor<?> constructor = clz.getConstructor();
				
				mappings.put(key.toString(), (Controller)constructor.newInstance());
			}
					
		} catch (Exception e) {

		}

		/*
		 * mappings.put("/board/list.do", new BoardListController());
		 * mappings.put("/board/writeForm.do", new BoardWriteFormController());
		 * mappings.put("/board/write.do", new BoardWriteController());
		 */
	}

	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
	public static void main(String[] args) throws Exception{

		//classForName을 이용해서 객체를 만들 수 있음
		Class<?> clz = Class.forName("kr.ac.kopo.controller.BoardListController");
		BoardListController obj = (BoardListController) clz.newInstance();
//		System.out.println(obj.handleRequest(null, null));
		/*
		Class<?> clz = Class.forName("java.util.Random");
		//clz에 있는 클래스에 관한 정보를 기반으로 객체를 만들라는 메소드
		java.util.Random r = (java.util.Random) clz.newInstance();
		int random = r.nextInt(10)+ 1;
		System.out.println(random);
		 */
		
		
	}

//	switch (uri) {
//	case "/board/list.do":
//		//묵시적 형변환
//		control = new BoardListController();
//		// handleRequest로부터 날아오는 exception을 처리할 수 있어야 하므호 try-catch문 사용(servlet과 io 예외처리만 가능하기 때문)
//		break;
//	case "/board/writeForm.do":
//		control = new BoardWriteFormController();
//		break;
//	case "/board/write.do":
//		control = new BoardWriteController();
//		break;

}
