package mvc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static final String REDIRECT_FLAG = "redirect:";
	public static final String FORWARD_FLAG = "forward:";

	public void resolve(HttpServletRequest request, HttpServletResponse response, String viewInfo)
			throws IOException, ServletException {

		if (viewInfo == null || viewInfo.trim().length() == 0)
			noViewInfo(response);
		else if (viewInfo.startsWith(REDIRECT_FLAG))
			redirect(response, viewInfo);
		else if (viewInfo.startsWith(FORWARD_FLAG))
			forward(request, response, viewInfo);
	}

	public void noViewInfo(HttpServletResponse response) throws IOException{
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "뷰에 대한 정보가 없다.");
	}

	public void redirect(HttpServletResponse response, String viewInfo) throws IOException {
		viewInfo = viewInfo.substring(REDIRECT_FLAG.length());
		response.sendRedirect(viewInfo);
	}

	public void forward(HttpServletRequest request, HttpServletResponse response, String viewInfo) throws ServletException, IOException {
		viewInfo = viewInfo.substring(FORWARD_FLAG.length());
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewInfo);
		dispatcher.forward(request, response);
	}
}