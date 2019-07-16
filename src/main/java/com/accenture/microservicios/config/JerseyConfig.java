package com.accenture.microservicios.config;

import com.accenture.microservicios.service.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserService.class);
    }
}
