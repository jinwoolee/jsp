package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVo;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	
	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	//          userid, MemberVo
	private Map<String, MemberVo> userMap = new HashMap<String, MemberVo>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())){
			
			/*HttpSession session = event.getSession();
			MemberVo memberVo = (MemberVo)session.getAttribute("S_MEMBER");*/
			
			MemberVo memberVo = (MemberVo)event.getValue();
			logger.debug("사용자 로그인 : {} ", memberVo.getUserid());
			
			userMap.put(memberVo.getUserid(), memberVo);
			 
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved : {} ", event.getName());
		
		if("S_MEMBER".equals(event.getName())){
			MemberVo memberVo = (MemberVo)event.getValue();
			userMap.remove(memberVo.getUserid());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {	
	}

}
