package com.fst.asustech.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/assets/**")
			.permitAll()
			.antMatchers("/authentication/login.xhtml?logout").hasAnyRole("EMPLOYEE")
			.antMatchers("/**").hasRole("ADMIN")
			.and().formLogin().loginPage("/authentication/login.xhtml")
			.loginProcessingUrl("/authenticateTheUser").permitAll()
			.defaultSuccessUrl("/", true)
			.and().logout().permitAll()
			.and().exceptionHandling().accessDeniedPage("/error/error-403.xhtml");
	}

}
