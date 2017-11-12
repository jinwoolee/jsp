package filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCountFilter implements Filter {
	Map<String, Integer> counterMap;

	public RequestCountFilter() {
		System.out.println("RequestCountFilter 생성자" );
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("RequestCountFilter 초기화" );
		
		counterMap = new HashMap<String, Integer>();
		
		ServletContext application = filterConfig.getServletContext();
		application.setAttribute("counterMap", counterMap);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//int count = counterMap.getOrDefault(req.getRequestURI(), 0);
		int count = counterMap.get(req.getRequestURI());
		
		counterMap.put(req.getRequestURI(), ++count);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
