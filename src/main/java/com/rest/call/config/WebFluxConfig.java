package com.rest.call.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig {
	
	@Value("${external.api.url}")
	private String apiUrl;
	
	@Bean
	public WebClient webClient() {
	  return WebClient.builder().baseUrl(apiUrl).build();
	}

}
