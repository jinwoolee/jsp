package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DefaultParameterFilter
 */
@WebFilter("/*")
public class DefaultParameterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DefaultParameterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//傈贸府
		DefaultParameterWrapper requestWrapper = 
				new DefaultParameterWrapper((HttpServletRequest)request);
		
		//requestWrapper.setParameter("userId22", "brownUserId");
		
		chain.doFilter(requestWrapper, response);
		
		//饶贸府
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
