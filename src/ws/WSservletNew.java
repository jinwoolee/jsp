package ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WSservletNew")
public class WSservletNew  {
	private static final long serialVersionUID = 1L;

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public WSservletNew() {
	}

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id : " + session.getId());

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("Connection Established");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sessions.add(session);
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
