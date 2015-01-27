package com.teralyx.config;

import com.teralyx.api.BuildProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(BuildProperties.class)
public class PropertiesConfig {
}