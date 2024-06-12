package ppori;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private static final ConcurrentHashMap<String, WebSocketSession> browsers = new ConcurrentHashMap<>();
	
	public static ConcurrentHashMap<String, WebSocketSession> getBrowsers(){
		return browsers;
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		browsers.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		browsers.put(session.getId(), session);
		super.afterConnectionEstablished(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String str1 = "### RECV001 " + message.getPayload();
		String str2 = "### RECV002 " + message.getPayload();
		
		session.sendMessage(new TextMessage(str1));
		for(String sessionId: browsers.keySet()) {
			browsers.get(sessionId).sendMessage(new TextMessage(str2));
		}
		super.handleTextMessage(session, message);
	}
	
	
}
