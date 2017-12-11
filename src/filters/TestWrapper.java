package filters;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TestWrapper extends HttpServletRequestWrapper{
	
	private Map<String, String[]> parameterMap = null;
	
	public TestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());
	}
	
	public void setBasicParameter(HttpServletRequest request) {
		String unt_cd = request.getParameter("unt_cd");
		if(unt_cd == null || unt_cd.trim().equals(""))
			parameterMap.put("unt_cd", new String[] {"defaultUnt_cd"});
	}
	
	public String getParameter(String name) {
		String[] values = parameterMap.get(name);
		if(values != null && values.length > 0)
			return values[0];
		else
			return null;
	}
	
	public String[] getParameterValues(String name) {
		return parameterMap.get(name);
	}
	
	public Map<String, String[]> getParameterMap(){
		return parameterMap;
	}
	
	public Enumeration<String> getParameterNames(){
		return Collections.enumeration(parameterMap.keySet());
	}
}
