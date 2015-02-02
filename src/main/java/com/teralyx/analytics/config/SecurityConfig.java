
package com.teralyx.analytics.config;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile({"dev", "prod"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {	
	http
	    .httpBasic()
	    .and()		
	    .sessionManagement()
		.sessionCreationPolicy(STATELESS)
	    .and()
	    .csrf()
		.disable()
	    .headers()
		.frameOptions() // OEmbedController#embedTrack uses an iframe
		    .disable();
    }
}
