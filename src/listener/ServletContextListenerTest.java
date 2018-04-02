package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
@WebListener
public class ServletContextListenerTest implements javax.servlet.ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerTest() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListenerTest#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println( sce.getServletContext().getServletContextName() +
				" contextDestroyed ");	
    }

	/**
     * @see ServletContextListenerTest#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	try {
    		//getServletContext() == application
    		String jdcbcDriver = sce.getServletContext().getInitParameter("jdbcDriver");
			Class.forName(jdcbcDriver);	//oracle.jdbc.driver.OracleDriver -->initParameter
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	System.out.println( sce.getServletContext().getServletContextName() +
    										" contextInitialized ");
    }
}







