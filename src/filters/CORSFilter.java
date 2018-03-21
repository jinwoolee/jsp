package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
//@WebFilter("/CORSFilter")
public class CORSFilter implements Filter {

    public CORSFilter() {
    
    }
	
	public void destroy() {
	
	}

	//잘 정리된 문서 
	//http://ooz.co.kr/232
	// 이 필터를 web.xml에 설정한다. 
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;

		//요청 허용 메소드 
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        
        //Preflight request 캐싱 시간(3600초 = 1시간)
        response.setHeader("Access-Control-Max-Age", "3600");
        
        //ajax 요청에 대한 허용설정
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        
        //허용 도메인 설정
        response.setHeader("Access-Control-Allow-Origin", "*");

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
