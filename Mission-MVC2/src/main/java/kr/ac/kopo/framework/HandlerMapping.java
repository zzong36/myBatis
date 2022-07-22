package kr.ac.kopo.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.framework.annotation.RequestMapping;

// 어느 uri가 들어왔을 때 어느 컨트롤러를 실행해야 해?
public class HandlerMapping {
	
	//Contrller와 메소드를 알아야 하므로 CtrlAndMethod를 사용한다
	private Map<String, CtrlAndMethod> mappings;

	public HandlerMapping(String ctrlNames) throws Exception {
		/*
		 * kr.ac.kopo.board.controller.BoardController"
		 * kr.ac.kopo.login.controller.LoginController
		 */
		
		mappings = new HashMap<>();

		String[] ctrls = ctrlNames.split("\\|");
		for (String ctrl : ctrls) {
//			System.out.println(ctrl);
			Class<?> clz = Class.forName(ctrl);
			Constructor<?> constructor = clz.getConstructor();
			Object target = constructor.newInstance();

			// BoardController에 선언되어 있는 메소드를 뽑아내고 Method라는 클래스에 넣어준다.
			Method[] methods= clz.getMethods(); //상속받은 메소드 다 중 접근제한자가 public인 메소드만 뽑아낸다
//			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
//				System.out.println(method);

				// RequestMapping이 붙어있는지를 물어보고 있다면 뽑아준다
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);
//				System.out.println("reqAnno : " + reqAnno);
				if(reqAnno != null) {
					String uri = reqAnno.value();
//					System.out.println(uri); //맵의 String 값이 있는 곳
					mappings.put(uri, new CtrlAndMethod(target,method));
				}
			}
		}
	}
	
	//어느 컨트롤러의 어느 메소드가 확인하기 위함
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
}
