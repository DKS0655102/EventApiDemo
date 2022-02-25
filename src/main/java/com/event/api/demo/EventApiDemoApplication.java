package com.event.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class EventApiDemoApplication {
	@Bean
	
	public RestTemplate getRestTeplate() {
		
		RestTemplate restTemp = new RestTemplate();
		
		return  restTemp;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(EventApiDemoApplication.class, args);
		
	
	}

}
