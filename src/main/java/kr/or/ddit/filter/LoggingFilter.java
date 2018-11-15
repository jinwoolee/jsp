package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("1.전처리");
		
		//다른 적용할 필터가 있으면 다른 필터로 요청을 넘기고
		//더이상 적용할 필터가 없으면 원 요청에 대한 servlet/jsp 로 요청을 이관
		chain.doFilter(request, response);
		
		System.out.println("3.후처리");
		
	}

	@Override
	public void destroy() {
	}

}






