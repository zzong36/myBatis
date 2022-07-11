package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private Map<String, Controller> mappings = new HashMap<>();
	
	public HandlerMapping() {
		mappings.put("/board/list.do", new BoardListController());
		mappings.put("/board/writeForm.do", new BoardWriteFormController());
		mappings.put("/board/write.do", new BoardWriteController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
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
