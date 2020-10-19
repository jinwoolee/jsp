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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	
	Map<String, Integer> reqeustCounterMap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("RequestCounterFilter.init()");
		reqeustCounterMap = new HashMap<String, Integer>();
		
		//  request, session, application
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCounterMap", reqeustCounterMap);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("RequestCounterFilter.doFilter()");
		
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug("uri : {} ", req.getRequestURI());
		
		//uri별 요청 횟수 
		// /memberList 12
		// /jstl/jstl_fmt_date.jsp  20
		// 어떤 자료구조를 쓰면 좋을까??
		// List, Set, Map
		
		/*map객체에서 uri에 해당는 요청이 있었는지 확인
		없으면
			값을 1로 해서 새로운 key로 추가
		있으면
			기존 값에서 1을 더해 값을 수정*/
		
		Integer value = reqeustCounterMap.get(req.getRequestURI());
		
		//해당 uri로 최초요청
		if(value == null) {
			reqeustCounterMap.put(req.getRequestURI(), 1);
		}
		//해당 uri로 최소 한번이상 요청이 존재 했던 경우
		else {
			reqeustCounterMap.put(req.getRequestURI(), value + 1);
		}
		
		
		
		
		//등록된 다른 필터로 요청 위임
		//만약 더이상 등록된 Filter가 없을경우 요청을 처리할 서블릿 / jsp으로 요청을 전달
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}



