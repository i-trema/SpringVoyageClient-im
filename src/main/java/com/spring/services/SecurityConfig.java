package com.spring.services;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws
	Exception { 
		
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
	
		auth.jdbcAuthentication()
		.dataSource(dataSource).usersByUsernameQuery("SELECT login AS principal, password, active AS credentials FROM admin WHERE login=?")
		.authoritiesByUsernameQuery("SELECT admin_login AS principal, roles_role_name AS role FROM admin_roles "
		+ "WHERE admin_login=?")
		.passwordEncoder(bCryptPasswordEncoder)
		.rolePrefix("ROLE_");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.formLogin();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/login/**").permitAll();
//		http.authorizeRequests().antMatchers("/voyage/**","client/**","/apivoyage/**","apiclient/**");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/apivoyage/**").hasRole("SUPERVISOR");	
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/apivoyage/**").hasRole("SUPERVISOR");			
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/voyage/**").hasRole("SUPERVISOR");	
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/voyage/**").hasRole("SUPERVISOR");		

		http.authorizeRequests().antMatchers("/voyageedit/**").hasRole("SUPERVISOR");
		http.authorizeRequests().anyRequest().authenticated();
	}
}
