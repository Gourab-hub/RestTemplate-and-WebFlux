package com.rest.call.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig {
	
	@Bean
	public WebClient webClient() {
	  return WebClient.builder().baseUrl("https://67cd5a6fdd7651e464ee213d.mockapi.io/info/api/v1").build();
	}

}
