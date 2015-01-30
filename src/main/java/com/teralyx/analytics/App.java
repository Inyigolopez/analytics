package com.teralyx.analytics;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(App.class);
    }
	
    public static void main(String[] args) {
    	System.setProperty("spring.profiles.default", System.getProperty("spring.profiles.default", "dev"));
    	final ApplicationContext applicationContext = SpringApplication.run(App.class, args);
    }
    
    
    @Bean(destroyMethod="shutdown")
    public Executor taskScheduler(final @Value("${teralyx.scheduled-thread-pool-size:10}") int scheduledThreadPoolSize) {
        return Executors.newScheduledThreadPool(scheduledThreadPoolSize);
    }
    
}

