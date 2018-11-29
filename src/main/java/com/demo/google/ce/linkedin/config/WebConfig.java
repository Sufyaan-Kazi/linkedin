package com.demo.google.ce.linkedin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableAutoConfiguration
@Configuration
@EnableOAuth2Client
public class WebConfig {
    // private RestTemplate restTemplate;
    @Autowired
    private OAuth2ProtectedResourceDetails resource;

    @Bean
    @Primary
    public OAuth2RestOperations restTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(resource, clientContext);
    }
}
