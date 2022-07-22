package kr.ac.kopo.framework;

import java.util.HashMap;
import java.util.Map;

//응답하려는 화면과 공유영역에 등록시킬 객체를 보유하는 클래스
public class ModelAndView {

	//Forward용
	private String view;
	//공유영역 등록욕
	private Map<String, Object> model;
	
	
	public ModelAndView() {
		model = new HashMap<>();
	}
	
	public ModelAndView(String view) {
		this();
		this.view = view;
		
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	
	public void setAttribute(String key, Object value) {
		model.put(key, value);
	}
	
	
	
}
