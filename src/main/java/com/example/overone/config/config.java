package com.example.overone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.WebConnection;

@Configuration
public class config implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry viewControllerRegistration){
        viewControllerRegistration.addViewController("/login")
                .setViewName("login");

    }
}
