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
			.antMatchers("/assets/vendor/bootstrap/css/bootstrap.min.css",
						 "/assets/vendor/fonts/circular-std/style.css",
						 "/assets/libs/css/style.css",
						 "/assets/vendor/fonts/fontawesome/css/fontawesome-all.css",
						 "/assets/vendor/jquery/jquery-3.3.1.min.js",
						 "/assets/vendor/bootstrap/js/bootstrap.bundle.js",
						 "/assets/vendor/slimscroll/jquery.slimscroll.js",
						 "/assets/libs/js/main-js.js",
						 "/assets/images/logo.png")
			.permitAll()
			.antMatchers("/**").hasRole("ADMIN")
			.and().formLogin().loginPage("/login")
			.loginProcessingUrl("/authenticateTheUser").permitAll()
			.and().logout().permitAll()
			.and().exceptionHandling().accessDeniedPage("/access-denied");
	}

}
