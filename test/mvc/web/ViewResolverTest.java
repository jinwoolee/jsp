package mvc.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.loader.VirtualWebappLoader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * ViewResolverTest.java
 * 
 * @author jw
 * @since 2018. 3. 29.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2018. 3. 29.    jw				최초 생성
 *
 * </pre>
 */
public class ViewResolverTest {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private ViewResolver viewResolver;
	private final String FORWARD_FLAG	=	"forward:";
	private final String REDIRECT_FLAG	=	"redirect:";
	private String url			=	"/WEB-INF/mvc/ui/board/boardList.jsp";
	private String viewInfo;
	
	@Before
	public void setUp() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		viewResolver = new ViewResolver();
	}
	
	//view resolve forward test
	@Test
	public void forwardResolveTest() throws IOException, ServletException {
		/***Given***/
		viewInfo = FORWARD_FLAG + url;
		RequestDispatcher rd = mock(RequestDispatcher.class);
		doNothing().when(rd).forward(request, response);
		when(request.getRequestDispatcher(url)).thenReturn(rd);
		
		/***When***/
		viewResolver.resolve(request, response, viewInfo);

		/***Then***/
		verify(rd, times(1)).forward(request, response);
	}

	//view resolve redirect test
	@Test
	public void redirectResolveTest() throws IOException, ServletException {
		/***Given***/
		viewInfo = REDIRECT_FLAG + url;
		doNothing().when(response).sendRedirect(url);
		
		/***When***/
		viewResolver.resolve(request, response, viewInfo);

		/***Then***/
		verify(response, times(1)).sendRedirect(url);
	}
}
