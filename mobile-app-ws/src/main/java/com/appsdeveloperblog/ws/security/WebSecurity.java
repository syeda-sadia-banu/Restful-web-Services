package com.appsdeveloperblog.ws.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.appsdeveloperblog.ws.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity {
	private final UserService userDetailService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	public WebSecurity(UserService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailService = userDetailService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}



	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);

		// Configure authentication manager with the userDetailsService and password
		// encoder
		authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);

		//AuthenticationManager authenticationManager = authenticationManagerBuilder.build(); // Return the
																							// AuthenticationManager

		

		http

				.csrf().disable().authorizeRequests()
				.requestMatchers(HttpMethod.POST, "/users").permitAll().anyRequest()
				.authenticated();

		return http.build();

	}

}
