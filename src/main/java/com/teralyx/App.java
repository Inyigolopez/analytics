package com.teralyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class App {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(App.class);
    }
	
    public static void main(String[] args) {
    	System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "dev"));
    	final ApplicationContext applicationContext = SpringApplication.run(App.class, args);
    }
    
    
}
