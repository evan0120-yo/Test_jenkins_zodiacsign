package com.zodiac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZodiacSignApplication {

	public static void main(String[] args){
		SpringApplication.run(ZodiacSignApplication.class, args);
		System.out.println("=============== START =============== ");
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
