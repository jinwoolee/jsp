package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ParameterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//새로운 파라미터를 추가
		ParameterWrapper pw =
				new ParameterWrapper((HttpServletRequest)request);
		
		pw.setParameter("newParameter",
						new String[]{"brown", "sally", "cony"});
		
		chain.doFilter(pw, response);
	}

	@Override
	public void destroy() {

	}

}







