package ppori;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Environments {
	private static String logFilePath;
	private static String webSocketUrl;
	private static String webSocketHandler;
	
	public static String getLogFilePath() {
		return Environments.logFilePath;
	}
	public static String getWebSocketUrl() {
		return Environments.webSocketUrl;
	}
	
	public static String getWebSocketHandler() {
		return Environments.webSocketHandler;
	}
	
	public static void init(String[] args) {
		String active = System.getProperty("spring.profiles.active");
		Environments.logFilePath = System.getProperty("logfile.path");
		Environments.webSocketUrl = System.getProperty("websocket.url");
		Environments.webSocketHandler = System.getProperty("websocket.handler");
		
		log.info("#### active = " + active);
		log.info("#### logFilePath = " + Environments.logFilePath);
		log.info("#### webSocketUrl = " + Environments.webSocketUrl);
		log.info("#### webSocketHandler = " + Environments.webSocketHandler);
	}
}
