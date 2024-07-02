package top.hugongzi.framework.model;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private final Map<String,Object> model;
	private String view;
	public ModelAndView(String v){
		this.view=v;
		this.model=new HashMap<String,Object>();
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public void addObject(String key,Object value){
		this.model.put(key, value);
	}
	public Map<String, ?> getModel() {
		return model;
	}

}


