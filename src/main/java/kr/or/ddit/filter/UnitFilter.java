package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class UnitFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//새로운 request 객체를 생성
		UnitHttpServletRequestWrapper req = 
				new UnitHttpServletRequestWrapper((HttpServletRequest)request);
		
		//UNT_CD 파라미터를 새롭게 추가
		req.setUnit();
		
		chain.doFilter(req, response);
		//chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}








