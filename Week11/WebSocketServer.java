package websockets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.websocket.EncodeException;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class WebSocketServer {
	
	/**
	 * Server needs a collection of unique WebSocket connections between itself
	 * and a list of clients. Note: a single client can have multiple sessions!
	 * The synchronizedSet helps avoid race conditions when adding new sessions 
	 * to the Set, as and when WebSocket handshakes are established.
	 */
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	public WebSocketServer() {
	}
	
	@OnMessage
	public void onMessage(Session session, String incomingMessage)
	{
		System.out.println("onMessage " + session.getId()+ " with message : " + incomingMessage);
		if(null != sessions && !(sessions.isEmpty()))
		{
			for (Session openSession : sessions) {
				try {
					openSession.getBasicRemote().sendText("Client " + session.getId() +
							" echoed : " + incomingMessage + "\n");
				} catch (Exception e) {
					e.printStackTrace(System.out);
					sessions.remove(session);
				}
			}
		}
		
	}
	/**
	 * Add a client-server WebSocket session to ther server's session Set.
	 */
	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {
		System.out.println("onOpen : " + session.getId());
		sessions.add(session);
		session.getBasicRemote().sendText("Welcome to Echo WebSocket Server\n");
		
	}

	/** 
	 * Remove a client-server WebSocket session to ther server's session Set.
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose : "+session.getId());
		sessions.remove(session);
	}

	/**
	 * 
	 */
	@OnError
	public void onError(Session session, Throwable thr) {
		System.out.println(thr.getLocalizedMessage() + " on session " + session);
	}
	


}
