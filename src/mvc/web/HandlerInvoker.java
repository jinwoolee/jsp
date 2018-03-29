package mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInvoker {
	public String invoke(HttpServletRequest request, HttpServletResponse response, IAction action)
			throws IOException, ServletException {

		return action.process(request, response);
	}
}