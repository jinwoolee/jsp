package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SetBasicParameterFilter implements Filter {
	
    public SetBasicParameterFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		SetDefaultCompanyCodeRequestWrapper reqWrapper = new SetDefaultCompanyCodeRequestWrapper((HttpServletRequest)request);
		reqWrapper.setDefaultCompanyCode(request);
		chain.doFilter(reqWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}