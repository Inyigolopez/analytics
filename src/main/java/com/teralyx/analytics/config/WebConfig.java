package com.teralyx.analytics.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableSpringDataWebSupport
public class WebConfig {

	/**
	 * Maps all AngularJS routes to index so that they work with direct linking.
	 */
	@Controller
	static class Routes {

		@RequestMapping({ "/", "/data", "/maps" })
		public String index() {
			return "forward:/index.html";
		}
	}

	
}
