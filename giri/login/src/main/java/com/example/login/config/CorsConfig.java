package com.example.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{ //interface, which allows for customizing the configuration of Spring MVC.
    @Override
    public void addCorsMappings(CorsRegistry registry) {//It allows you to configure CORS mappings for your application.
        registry.addMapping("/**") // This means that CORS configuration will be applied globally across your application.
                .allowedOrigins("*") //In a production environment, you should specify the actual origins that are allowed to access your application for security reasons
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");//Headers are typically restricted by browsers in CORS requests, so this configuration allows any headers to be included in requests.
    }
}
