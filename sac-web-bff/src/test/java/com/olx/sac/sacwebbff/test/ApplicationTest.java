package com.olx.sac.sacwebbff.test;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.olx.sac.sacwebbff.Application;

@EnableCaching
@SpringBootApplication(scanBasePackages = { "com.olx.sac.test" })
public class ApplicationTest extends WebMvcConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}

	@Bean
	RestOperations getRestOperation() {
		return new RestTemplate(new SimpleClientHttpRequestFactory());
	}

	public static void main(String[] args) throws InterruptedException {

		try {
			SpringApplication.run(ApplicationTest.class, args);

		} catch (Exception e) {
			LOGGER.error("Application Initialization Error" + e);
		} finally {
			LOGGER.info("Application Started");
		}
	}

}