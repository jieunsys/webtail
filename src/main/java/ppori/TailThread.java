package ppori;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
@Scope("prototype")
public class TailThread implements Runnable {

	private long sleepInterval = 1_000;
	private File logfile = null;
	private boolean startAtBeginning = false;
	private boolean tailing = false;
	private String prefix = "####";
	
	public void setLogfile(String path) {
		this.logfile = new File(path);
	}
	
	protected void fireNewLogFileLine(String line) throws IOException {
		line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(this.prefix + line);
		
		ConcurrentHashMap<String, WebSocketSession> browsers = WebSocketHandler.getBrowsers();
		
		for(String sessionId: browsers.keySet()) {
			browsers.get(sessionId).sendMessage(new TextMessage(line));
		}
	}

	@Override
	public void run() {
		long filePointer = 0;
		
		if(this.startAtBeginning) filePointer = 0;
		else filePointer = this.logfile.length();
		
		this.tailing = true;
		try {
			RandomAccessFile file = new RandomAccessFile(logfile, "r");
			while(this.tailing) {
				long fileLength = this.logfile.length();
				if(fileLength < filePointer) {
					file = new RandomAccessFile(logfile, "r");
					filePointer = 0;
				}
				if(fileLength > filePointer) {
					file.seek(filePointer);
					String line = file.readLine();
					while(line!=null) {
						this.fireNewLogFileLine(line);
						line = file.readLine();
					}
					filePointer = file.getFilePointer();
				}
				Thread.sleep(this.sleepInterval);
			}
			file.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
