package com.devd.spring.bookstorepaymentservice.config;

import com.wolverine.solutions.commons.security.GlobalResourceServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@Configuration
public class PaymentResourceServiceConfig extends GlobalResourceServerConfig {
    
    @Autowired
    private ResourceServerTokenServices tokenServices;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("web").tokenServices(tokenServices);
    }
    
}
