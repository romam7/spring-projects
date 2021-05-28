package com.todo.rest.basicauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * THE PACKAGE WAS RENAMED FROM com.todo.rest.webservices.basicauth TO com.todo.rest.basicauth DUE TO
 * THIS BASIC AUTH CONFIGURATION WOULD INTERFER WITH THE JWT CONFIGURATION 
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/**
		 * We disable CSRF, except for OPTIONS request for all URLs, authenticate all the other requests
		 * and use basic http authentication
		 */
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();
	}

}
