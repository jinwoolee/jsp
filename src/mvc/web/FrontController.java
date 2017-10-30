package mvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private HandlerMapper handlerMapper;
	private HandlerInvoker handlerInvoker;
	private ViewResolver viewResolver;

	public FrontController() {
		handlerMapper = new HandlerMapper("mvc.web.controllerHandlerInfo");
		handlerInvoker = new HandlerInvoker();
		viewResolver = new ViewResolver();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		uri = uri.substring(contextPath.length());

		IAction handler = handlerMapper.getHandler(uri);
		if (handler == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, uri + ", 해당 요청을 처리할 수 있는 핸들러가 없다.");
		} else {
			String viewInfo = handlerInvoker.invoke(req, resp, handler);
			viewResolver.resolve(req, resp, viewInfo);
		}
	}
}