package mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInvoker {
	public String invoke(HttpServletRequest request, HttpServletResponse response, IAction action)
			throws IOException, ServletException {
		/*
		 * 만일 Handler객체가 POJO이고, 인터페이스가 제한되어 있지 않다면, invoke(HttpServletRequest,
		 * HttpServletResponse, Object)와 같은 시그니처를 가질 것이다. 이때 해당 핸들러의 메소드를 호출한다면, 각기 다른
		 * 파라미터와 각기 다른 리턴타입을 가진 핸들러를 호출하기 위해 리플렉션 코드가 상당한 분량으로 구현되어야 할 것이다. 또한 리플렉션을 통해
		 * 파라미터와 리턴타입에 대해 확인했다면, 파라미터를 준비하고, 리턴 타입을 사용하기 위한 코드가 상당량 이어질 것이다.
		 */
		return action.process(request, response);
	}
}