package com.appsdeveloperblog.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class MobileAppWsApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder createSpringApplicationBuilder() {
		// TODO Auto-generated method stub
		return super.createSpringApplicationBuilder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
	

}
