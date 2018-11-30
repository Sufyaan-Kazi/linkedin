package com.demo.google.ce.linkedin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
public class WebConfig {

    @Bean
    public OAuth2RestTemplate getRestTemplate(OAuth2ProtectedResourceDetails resource,
            OAuth2ClientContext clientContext) {
        // System.out.println("TOKEN: " + clientContext.getAccessToken());
        return new OAuth2RestTemplate(resource, clientContext);
    }
}
