package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    		
         //System.out.println(se.getSession().getId() + "생성");
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    		//System.out.println("test : " + se.getSession().getAttribute("test"));
    		//System.out.println(se.getSession().getId() + "소멸");
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}	
}