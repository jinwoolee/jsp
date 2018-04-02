package filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterWrapper extends HttpServletRequestWrapper{

	private	Map<String, String[]> customMap;
	
	public DefaultParameterWrapper(HttpServletRequest request) {
		super(request);
		//request.getParameterMap()에서 리턴되는 Map<String, String[]> 객체를
		//우리가 필요한 형태로 재정의
		customMap = new HashMap<String, String[]>(request.getParameterMap());
		customMap.put("unt_cd", new String[]{"defaultUnt_cd"});
	}
	
	public void setParameter(String key, String value){
		customMap.put(key, new String[]{value});
	}
	
	//request객체를 모방하는일 (다음 4가지 메소드가 parameter map과 연관된 메소드)
	public String getParameter(String name){
		//request.getParameter 기본동작
		//Map<String, String[]>
		//String[] : 0건이면 : null
		//			 1건이면 : 해당건 리턴
		//			 1건 이상 : 첫번째 객체 (String[0])
		String[] values = customMap.get(name);
		
		if(values != null && values.length > 0)
			return values[0];
		else
			return null;
		
		/*if(values==null){
			return null;
		}else if(values.length==1){
			return values[0];
		}else if(values.length>1 && values.length!=0){
			return values[0];
		}else{
			return null;
		}
//		return values==null ? null : values.length==1 ? values[0] : values[0];*/
	}
	
	public String[] getParameterValues(String name){
		return customMap.get(name);
	}
	
	public Map<String, String[]> getParameterMap(){
		return customMap;
	}
	
	//map 객체의 키값을 enumration<String>
	public Enumeration<String> getParameterNames(){
		return Collections.enumeration(customMap.keySet());
	}

}





