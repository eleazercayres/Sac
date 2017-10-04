package com.olx.sac.sacwebbff;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Bean
	RestOperations getRestOperation() {
	    return new RestTemplate(new SimpleClientHttpRequestFactory());
	}
	
	public static void main(String[] args) throws InterruptedException {

		try {
			SpringApplication.run(Application.class, args);

		} catch (Exception e) {
			LOGGER.error("Application Initialization Error" + e);
		} finally {
			LOGGER.info("Application Started");
		}
	}

}