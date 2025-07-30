//	package com.jijamataCollege.storeManagementSystem.configuration;
//	
//	import org.springframework.context.annotation.Bean;
//	import org.springframework.context.annotation.Configuration;
//	import org.springframework.security.config.Customizer;
//	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//	import org.springframework.security.web.SecurityFilterChain;
//	import org.springframework.web.cors.CorsConfiguration;
//	import org.springframework.web.cors.CorsConfigurationSource;
//	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//	
//	import java.util.List;
//	
//	@Configuration
//	@EnableWebSecurity
//	public class Config {
//	
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Fix: Enable CORS
//	            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
//	            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//	            .httpBasic();
////	            .formLogin(login->login.loginPage("/login").permitAll());
////	            .formLogin(Customizer.withDefaults());
//	
//	        return http.build();
//	    }
//	
//	    @Bean
//	    public CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//	        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Allow frontend
//	        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//	        configuration.setAllowedHeaders(List.of("*"));
//	        configuration.setAllowCredentials(true);
//	
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", configuration);
//	        return source;
//	    }
//	}
