package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import user.model.UserVo;

/**
 * Application Lifecycle Listener implementation class HttpSessionAttrListener
 *
 */
@WebListener
public class HttpSessionAttrListener implements HttpSessionAttributeListener {
	private Map<String, UserVo> sessionMap;
	
    /**
     * Default constructor. 
     */
    public HttpSessionAttrListener() {
        sessionMap = new HashMap<String, UserVo>(); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	//day7LoginProcessServlet : session.setAttribute("userVo", userVo);
    	//--->
    	//HttpSessionAttrListener.attributeAdded 호출
    	//session에 입력된 속성 키값(이름) userVo 이면 == 로그인 성공후 세션에 userVo객체를 setAttribute 실행한것.
    	
    	//우리가 관심있는 userVo가 session에 바인딩 되었때, map 객체에 사용자 정보를 보관한다.
    	if("userVo".equals(se.getName())){
    		ServletContext application = se.getSession().getServletContext();
    		UserVo userVo = (UserVo)se.getValue();
    		
    		//사용자 아이디 : key, 사용자 객체 : value
    		sessionMap.put(userVo.getUserId(), userVo);
    		application.setAttribute("sessionMap", sessionMap);	//application jsp에서 접근이 가능
        	
    	}
    	System.out.println("se.getName() : " + se.getName());
    	
    	
    	//servletContext 객체에 sessionMap 속성이 있는지 검사, 없을 경우 sessionMap을 속성으로 설정한다.
    	/*ServletContext sc = se.getSession().getServletContext();
    	if(sc.getAttribute("sessionMap") == null)
    		sc.setAttribute("sessionMap", sessionMap);
    	
    	//로그인 처리후 userVo(사용자)객체가 세션에 바인될경우 sessionMap 사용자 아이디를 키, 사용자 객체를 값으로
    	//sessionMap 넣어준다.
        if("userVo".equals(se.getName())){
        	UserVo userVo = (UserVo)se.getValue();
        	sessionMap.put(userVo.getUserId(), userVo);
     	}*/
         
         System.out.println("HttpSessionAttrListener attributeAdded ");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  {
    	
    	if("userVo".equals(se.getName())){
    		//사용자 접속 현황 map 객체에 remove
    		ServletContext application = se.getSession().getServletContext();
    		UserVo userVo = (UserVo)se.getValue();
    		sessionMap.remove(userVo.getUserId());
    	}
    	
    	 
    	System.out.println("HttpSessionAttrListener attributeRemoved ");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("HttpSessionAttrListener attributeReplaced ");
    }
	
}



