package filters;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TestSetCharacterEncoding
 */
@WebFilter("/*")
public class TestSetCharacterEncoding implements Filter {

    /**
     * Default constructor. 
     */
    public TestSetCharacterEncoding() {
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
		String uuid = UUID.randomUUID().toString();
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(uuid + " before filter");
		System.out.println("uri " + ((HttpServletRequest)request).getRequestURI());
		System.out.println("request.getCharacterEncoding() " + request.getCharacterEncoding());
		System.out.println("response.getCharacterEncoding() " + response.getCharacterEncoding());
		     
		TestWrapper wrapperRequest = new TestWrapper((HttpServletRequest)request);
		wrapperRequest.setBasicParameter((HttpServletRequest)request);
		System.out.println("wrapperRequest.getParameter : " + wrapperRequest.getParameter("unt_cd"));
		
		chain.doFilter(wrapperRequest, response);
		
		System.out.println("request.getCharacterEncoding() " + request.getCharacterEncoding());
		System.out.println("response.getCharacterEncoding() " + response.getCharacterEncoding());
		System.out.println(uuid + " after filter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
