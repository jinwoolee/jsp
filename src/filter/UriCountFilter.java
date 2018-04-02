package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UriCountFilter
 */
@WebFilter("/*")
public class UriCountFilter implements Filter {
	
	private Map<String, Integer> uriCountMap;
	
    /**
     * Default constructor. 
     */
    public UriCountFilter() {
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("UriCountFilter init");
		uriCountMap = new HashMap<String, Integer>();
		
		//servletContext == application
		fConfig.getServletContext().setAttribute("uriCountMap", uriCountMap);
		
		//uriCountMap.put("/boardList", 5);
		//속성 저장하는 4가지 영역
		//pageContext, request, session, application
	}

	
    /*
     * localhost:8090/main.do --> UriCounterFilter(/*) --> doFilter
     * 
     *  전처리
     *  chain.doFilter(request, response);
     *  --> 다음 필터로 요청(더이상 처리할 필터가 없을 때까지)
     *     --> 모든필터에대 수행이 완료 --- > servlet으로 rquest, response 전달
     *  후처리 <---
     * 
     */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//전처리
		System.out.println("UriCountFilter 전처리 ");
		
		//요청 uri별로 카운팅
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("uri : " + uri);
		
		Integer count = uriCountMap.get(uri);
		/*한번도 접속을 안한경우 : null  -->1 
		 *한번 이상 접속을 한 경우 : 숫자  --> 숫자+1
		 *uriCountMap.put(uri, 숫자);
		 */
		if(uriCountMap.containsKey(uri))
			uriCountMap.put(uri, uriCountMap.get(uri) +1);
		else
			uriCountMap.put(uri, 1);
		/*count = count == null ? 1 : count; 
		uriCountMap.put(uri, count);*/

		
		chain.doFilter(request, response);

		//후처리 (활용도 낮음)
		System.out.println("UriCountFilter 후처리 ");
		
	}
	
	public void destroy() {
		System.out.println("UriCountFilter destory ");
	}
}



