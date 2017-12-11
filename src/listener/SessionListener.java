package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    		
         System.out.println(se.getSession().getId() + "생성");
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    		System.out.println("test : " + se.getSession().getAttribute("test"));
    		System.out.println(se.getSession().getId() + "소멸");
    }	
}