package ppori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TailConfig {

	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@PostConstruct
	public void executeAsync() {
		log.info("#### SET logfilePath = " + Environments.getLogFilePath());
		
		TailThread tailThread = applicationContext.getBean(TailThread.class);
		tailThread.setLogfile(Environments.getLogFilePath());
		taskExecutor.execute(tailThread);
	}
}
