package com.spring.jms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.spring")
@EnableWebMvc
@Import({ MessagingConfiguration.class, SpringJDBCConfiguration.class })
public class AppConfig extends WebMvcConfigurerAdapter {

	// Put Other Application configuration here.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configuration) {

		configuration.enable();
	}
}
