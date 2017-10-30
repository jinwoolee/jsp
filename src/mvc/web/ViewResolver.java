package mvc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static final String REDIRECTFLAG = "redirect:";
	public static final String FORWARDFLAG = "forward:";

	public void resolve(HttpServletRequest request, HttpServletResponse response, String viewInfo)
			throws IOException, ServletException {

		if (viewInfo == null || viewInfo.trim().length() == 0) {
			if (!response.isCommitted()) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "뷰에 대한 정보가 없다.");
			}
		} else {
			if (viewInfo.startsWith(REDIRECTFLAG)) {
				viewInfo = viewInfo.substring(REDIRECTFLAG.length());
				response.sendRedirect(viewInfo);
			} else {
				if (viewInfo.startsWith(FORWARDFLAG)) {
					viewInfo = viewInfo.substring(FORWARDFLAG.length());
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewInfo);
				dispatcher.forward(request, response);
			}
		}
	}
}