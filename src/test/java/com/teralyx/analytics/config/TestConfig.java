package com.teralyx.analytics.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/application-test.properties")
public class TestConfig {

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
	return Executors.newSingleThreadScheduledExecutor();
    }
}
