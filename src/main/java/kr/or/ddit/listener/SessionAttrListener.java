package kr.or.ddit.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttrListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("added : " + event.getName() + " / " +
										event.getValue()); 
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}

}
