package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class SessionListener implements HttpSessionAttributeListener{
	
	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		//사용자가 정상적으로 로그인 했을때 session에 추가되는 S_USERVO값을 기준으로
		//S_USERVO 속성이 세션에 추가 될때 application객체에 사용자를 추가해서
		//현재 접속한 사용자 리스트를 보여주는 화면을 개발
		
		String attrName = event.getName();	//session 추가된 속성 이름
		logger.debug("attributeAdded, {} ", attrName);
		if(attrName.equals("S_USERVO")) {
			
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>)sc.getAttribute("S_USERVO_LIST");
			s_uservo_list.add((User)event.getValue());
			
			logger.debug("attributeAdded, {} ", ((User)event.getValue()).getUserId());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		logger.debug("attributeRemoved");
		
		//사용자가 로그아웃 한경우 : S_USERVO가 세션에서 제거될 때  
		//S_USERVO_LIST에서 해당 사용자 정보를 제거한다
		String attrName = event.getName();
		if(attrName.equals("S_USERVO")) {
			HttpSession session = event.getSession();
			ServletContext sc = session.getServletContext();
			List<User> userList = (List<User>)sc.getAttribute("S_USERVO_LIST");
			userList.remove(event.getValue());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
		logger.debug("attributeReplaced, {}", event.getName());
		
		logger.debug("attributeReplaced, {} ", ((User)event.getValue()).getUserId());
		
		//새롭게 변경된 사용자 세션 정보
		HttpSession session = (HttpSession)event.getSource();
		User user = (User)session.getAttribute("S_USERVO");
		
		//기존 사용자 세션 정보
		User oldUser = (User)event.getValue();
		
		ServletContext sc = event.getSession().getServletContext();
		List<User> s_uservo_list = (List<User>)sc.getAttribute("S_USERVO_LIST");	
		
		s_uservo_list.remove(oldUser);		//기존 사용자 제거
		s_uservo_list.add(user);			//신규 사용자 등록
	}
}


