package filters;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SetDefaultCompanyCodeRequestWrapper extends HttpServletRequestWrapper{
	private	final String DEFAULT_COMPANY_CODE	=	"defaultCompanyCode";
	
	private Map parameterMap = null;
	
	public SetDefaultCompanyCodeRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap(request.getParameterMap());
	}
	
	public void setDefaultCompanyCode(ServletRequest request) {
		String	companyCode	=	request.getParameter("companyCode");
		if(companyCode == null || companyCode.equals(""))
			parameterMap.put("companyCode", new String[]{ DEFAULT_COMPANY_CODE});
	}
	
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if (values != null && values.length > 0)
			return values[0];
		return null;
	}

	public Map getParameterMap() {
		return parameterMap;
	}

	public Enumeration getParameterNames() {
		return Collections.enumeration(parameterMap.keySet());
	}

	public String[] getParameterValues(String name) {
		return (String[]) parameterMap.get(name);
	}
}
