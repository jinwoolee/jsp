package mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	/**
	 * Command pattern 에 따라 특정 요청을 처리하기 위한 핸들러
	 * @return 요청 처리의 결과에 따라 응답 전송에 사용될 뷰에 대한 논리적정보
	 */
	public String process(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException;
}
