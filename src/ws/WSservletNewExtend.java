package ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/WSservletNewExtend")
public class WSservletNewExtend  extends Endpoint{ 	
	private static final long serialVersionUID = 1L;

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public WSservletNewExtend() {
	}

	@Override
	public void onOpen(Session session, EndpointConfig endpointConfig) {
		
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		super.onClose(session, closeReason);
	}

	@Override
	public void onError(Session session, Throwable throwable) {
		super.onError(session, throwable);
	}
}
