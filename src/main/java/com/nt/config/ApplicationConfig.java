package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ch.qos.logback.core.net.server.Client;

@Configuration
public class ApplicationConfig {

    @Bean(name = "template")
    public RestTemplate createTemplate() {
		return new RestTemplate();
	}
	
    @Bean(name = "webClient")
    public WebClient createWebClient() {
    	return WebClient.create();
    }
}
