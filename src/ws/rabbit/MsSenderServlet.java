package ws.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Servlet implementation class MsSenderServlet
 */

@WebServlet("/seder")
public class MsSenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel; 
       
	private void initMq() {
		factory = new ConnectionFactory();
		factory.setHost("iothome.iptime.org");
		factory.setUsername("sensor");
		factory.setPassword("sensor");
		
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare("message", false, false, false, null);
			
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
	}
	
    public MsSenderServlet() {
    	initMq();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MsSenderServlet");
		channel.basicPublish("", "message", null, "send from MsSenderServlet".getBytes("utf-8"));
	}
}
