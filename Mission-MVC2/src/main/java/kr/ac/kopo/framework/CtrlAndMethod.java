package kr.ac.kopo.framework;

import java.lang.reflect.Method;

//실제 스프링에 있음
public class CtrlAndMethod {

	//board/list.do가 들어오면 new BoardControlelr().list를 실행해줘 .target이 기억하고
	//login.do가 들어오면 new LoginController().login() .method가 기억한다
	//Controller들(Board, Member, List 컨트롤러)의 인스턴스 객체를 갖는것이 목표 
	private Object target;
	private Method method;
	
	public CtrlAndMethod(Object target, Method method) {
		super();
		this.target = target;
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}

	public Method getMethod() {
		return method;
	}

	
	
}
