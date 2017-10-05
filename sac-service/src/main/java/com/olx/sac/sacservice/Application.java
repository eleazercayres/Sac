package com.olx.sac.sacservice;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.planetj.servlet.filter.compression.CompressingFilter;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static Logger logger = Logger.getLogger(Application.class);
	
	@Bean
	 public CompressingFilter compressingFilter() {
	     return new CompressingFilter();
	 }
	
	@Bean
	RestOperations getRestOperation() {
	    return new RestTemplate(new SimpleClientHttpRequestFactory());
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

	@Override
	public void run(String... args) throws Exception {
		logger.info("Slave Monitor Producer running!");
	}

}