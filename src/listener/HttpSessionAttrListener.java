package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class HttpSessionAttrListener
 *
 */
@WebListener
public class HttpSessionAttrListener implements HttpSessionAttributeListener {
	private Map<String, String> sessionMap;
	
    public HttpSessionAttrListener() {
        sessionMap = new HashMap<String, String>(); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {

    	//우리가 관심있는 userVo가 session에 바인딩 되었때, map 객체에 사용자 정보를 보관한다.
    	if("userId".equals(se.getName())){
    		ServletContext application = se.getSession().getServletContext();
    		String userId = (String)se.getValue();
    		
    		//사용자 아이디 : key, 사용자 객체 : value
    		sessionMap.put(userId, userId);
    		application.setAttribute("sessionMap", sessionMap);	//application jsp에서 접근이 가능
        	
    	}
    	System.out.println("se.getName() : " + se.getName());
    	System.out.println("HttpSessionAttrListener attributeAdded ");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  {
    	
    	if("userId".equals(se.getName())){
    		//사용자 접속 현황 map 객체에 remove
    		String userId = (String)se.getValue();
    		sessionMap.remove(userId);
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