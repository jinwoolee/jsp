package kr.or.ddit.filter;

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

public class RequestCounterFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//map : key-uri(String), value-count(Integer)
		
		//application 객체 확보
		ServletContext application = request.getServletContext();
		
		//application객체에서 requestMap 가져오기
		Map<String, Integer> rcMap = 
				(Map<String, Integer>)application.getAttribute("rcMap");
		
		//application 객체에 rcMap 객체가 존재하는지 확인
		//없으면 신규생성후 저장
		if(rcMap == null)
			rcMap = new HashMap<String, Integer>();
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		Integer count = rcMap.get(uri);
		
		//최초요청시
		if(count == null)
			rcMap.put(uri, 1);
		//최초요청이 아닐시
		else
			rcMap.put(uri, ++count);
		
		application.setAttribute("rcMap", rcMap);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}






