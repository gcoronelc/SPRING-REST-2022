package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	// Define una cadena de filtros que se puede comparar con un HttpServletRequest para decidir si se aplica a esa solicitud.
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authConfig -> {
				authConfig.requestMatchers("/").permitAll();
				authConfig.requestMatchers("/user/**").authenticated();
				authConfig.requestMatchers("/admin/**").denyAll();
				
			})
			.formLogin(Customizer.withDefaults()) // Login with browser and Form
			.httpBasic(Customizer.withDefaults()); // Login with Insomnia and Basic Auth
		return http.build();
	}
	
}
