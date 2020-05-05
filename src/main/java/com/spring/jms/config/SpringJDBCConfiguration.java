package com.spring.jms.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.EmployeeDao;
import com.spring.daoimpl.EmployeeDaoImpl;

@Configuration
public class SpringJDBCConfiguration {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employeedb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//H2 database
		
	/*	dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");*/
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public EmployeeDao employeeDao(){
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		empDao.setJdbcTemplate(jdbcTemplate());
		return empDao;
	}

}