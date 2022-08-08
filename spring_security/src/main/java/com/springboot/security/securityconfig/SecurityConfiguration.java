package com.springboot.security.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	UserDetailsService userService;
	
	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(daoathunticationProvider());
	}
	
	@Bean
	DaoAuthenticationProvider daoathunticationProvider() {
		DaoAuthenticationProvider daoAthunticationProvider= new DaoAuthenticationProvider();
//		daoAthunticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
		daoAthunticationProvider.setUserDetailsService(this.userService);
		return daoAthunticationProvider;
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").permitAll()
//		.antMatchers("/adduser").permitAll()
//		.antMatchers("/addrole").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin").hasRole("admin")
		.anyRequest().authenticated().and().httpBasic();
	}

}
