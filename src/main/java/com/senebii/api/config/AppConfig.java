package com.senebii.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(resourcePattern = "com.senebii.api")
public class AppConfig extends WebMvcConfigurerAdapter{
	 @Override
	  public void addInterceptors (InterceptorRegistry registry) {
	      registry.addInterceptor(new SessionInterceptor());
	  }
}