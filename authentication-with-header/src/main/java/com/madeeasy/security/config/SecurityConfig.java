package com.madeeasy.security.config;
import com.madeeasy.security.filter.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@SuppressWarnings("deprecation")
@EnableWebSecurity(debug = true)
public class SecurityConfig {
	
	@Autowired
	private CustomAuthenticationFilter authenticationFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.addFilterBefore(authenticationFilter, BasicAuthenticationFilter.class);
		return http.build(); 
	}
}
