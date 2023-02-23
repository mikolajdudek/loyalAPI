package com.example.loyal.Config;

import com.example.loyal.Client.SubiektApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SubiektConfig {

    private String apiUrl;

    private String username;

    private String password;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .basicAuthentication(username, password)
                .build();
    }

    @Bean
    public SubiektApiClient subiektApiClient() {
        return new SubiektApiClient(restTemplate(), apiUrl);
    }
}

