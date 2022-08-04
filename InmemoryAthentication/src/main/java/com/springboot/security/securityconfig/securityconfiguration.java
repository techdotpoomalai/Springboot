package com.springboot.security.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class securityconfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser("user1").password(encoder.encode("user1")).roles("USER")
		.and()
		.withUser("admin1").password(encoder.encode("admin1")).roles("ADMIN");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/useradmin").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated().and().httpBasic();
	}
}
