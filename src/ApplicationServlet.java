

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub 
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		String mimeType = servletContext.getMimeType("/hello.jsp");
		System.out.println("mimeType = " + mimeType);
		
		ServletContext servletContext2 = servletContext.getContext("/jsp2/index.jsp");
		ServletContext servletContext3 = servletContext.getContext("/hello.jsp");
		
		//ServletContext servletContext2 = servletContext.getContext("/jsp2/index.jsp");
		
		/*returns a ServletContext object that corresponds to a specified URL on the server.
		This method allows servlets to gain access to the context for various parts of the server,
		and as needed obtain RequestDispatcher objects from the context. 
		The given path must be begin with "/", is interpreted relative to the server's document root and is matched against the context roots of other web applications hosted on this container.

		In a security conscious environment, the servlet container may return null for a given URL.

		Parameters:
		uripath a String specifying the context path of another web application in the container.
		Returns:
		the ServletContext object that corresponds to the named URL, or null if either none exists or the container wishes to restrict this access.
		See Also:
		RequestDispatcher*/
		
		
		
		/*PrintWriter pw = response.getWriter();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		char[] chars = new char[512];
		int len = -1;
		
		while( (len = br.read(chars)) != -1) {
			System.out.println(chars);
			//pw.println(chars);	
		}*/
	}

}
