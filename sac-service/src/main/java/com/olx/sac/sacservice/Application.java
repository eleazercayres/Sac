package com.olx.sac.sacservice;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);
	
	@Bean(name="workExecutor")
    public TaskExecutor taskExecutor() {
      ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
      taskExecutor.setMaxPoolSize(10);
      taskExecutor.setCorePoolSize(5);
      taskExecutor.setQueueCapacity(10);
      taskExecutor.setThreadNamePrefix("Sac-Service");
      taskExecutor.afterPropertiesSet();
      taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
      return taskExecutor;
    }

	public static void main(String[] args) throws InterruptedException {

		try {
			SpringApplication.run(Application.class, args);

		} catch (Exception e) {
			logger.error("Application Initialization Error", e);
		} finally {
			logger.info("Application Started");
		}
	}

}