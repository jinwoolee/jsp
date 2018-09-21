package ws.rabbit;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@ServerEndpoint(value="/wsServer", configurator=HttpSessionConfigurator.class)
public class WsServer {
	private static final long serialVersionUID = 1L;

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public WsServer() {
		
		initMq();
	}

	private void initMq() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("iothome.iptime.org");
		factory.setUsername("sensor");
		factory.setPassword("sensor");
		
		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare("message", false, false, false, null);
			
			Consumer cousumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					 sendAll(new String(body, "utf-8"));
				}
			};
			
			channel.basicConsume("message", true, cousumer);
			
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("Open session id : " + session.getId());
		System.out.println("http session id : " + config.getUserProperties().get("httpSessionId"));

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("Connection Established");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sessions.add(session);
	}

	private void sendAll(String message) {
		try {
			for (Session session : sessions)
				session.getBasicRemote().sendText("All : " + message);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendAllSessionToMessage(Session self, String message) {
		
		try {
			for (Session session : sessions) {
				if (!self.getId().equals(session.getId()))
					session.getBasicRemote().sendText("All : " + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		
		System.out.println("Message from " + session.getId() + ": " + message);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		sendAllSessionToMessage(session, message);
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

	/**
	 * The user closes the connection.
	 * 
	 * Note: you can't send messages to the client from this method
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		sessions.remove(session);
	}
}