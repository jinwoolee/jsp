package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;

public class ControllerUtil {
	public static String parseUri(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String dispatchUri = (String)request.getAttribute(Globals.DISPATCHER_REQUEST_PATH_ATTR);
		
		if(dispatchUri != null)
			uri = dispatchUri.replace(request.getContextPath(), "");
		else
			uri = uri.replace(request.getContextPath(), "");
		return uri;
	}
}
