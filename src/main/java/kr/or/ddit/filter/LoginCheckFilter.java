package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVo;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckFilter.class);

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("LoginCheckFilter.doFilter()");
		
		//session에 S_MEMBER 이름으로 속성이 존재하면 정상적으로 로그인한 케이스
		// 없으면 로그인 하지 않은 상태로 접속 시도
		
		// GET, POST /login  ==> S_MEMBER 속성이 없는게 당연
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String uri = req.getRequestURI();
		
		// login 경로로 요청하는 것은 사용자가 로그인을 시도 하고 있는 것이므로
		// 세션 체크 없이 servlet 혹은 다른 filter로 요청을 위임 시켜준다
		if(uri.equals("/login") ||
		   uri.endsWith(".js") ||
		   uri.endsWith(".map") ||
		   uri.endsWith(".css") ) {
			chain.doFilter(request, response);
		}
		else{
			HttpSession session = req.getSession();
			MemberVo S_MEMBER = (MemberVo)session.getAttribute("S_MEMBER");
			
			// 정상 로그인 상태
			if(S_MEMBER != null) {
				chain.doFilter(request, response);
			}
			// 로그인 하지 않은 상태 (/login 화면으로 재요청 지시)
			else {
				HttpServletResponse resp = (HttpServletResponse)response;
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}






