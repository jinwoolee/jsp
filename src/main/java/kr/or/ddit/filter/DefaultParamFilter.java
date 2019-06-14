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

//@WebFilter("/*")
public class DefaultParamFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DefaultParamWrapper reuqestWrapper = 
				new DefaultParamWrapper((HttpServletRequest)request);
		reuqestWrapper.setParameter("UNT_CD", new String[]{"LINE"});
		chain.doFilter(reuqestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
