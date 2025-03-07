package com.tekworks.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@PropertySource("users.properties")
public class UserConfig {

	@Value("${user1.name}")
	private String name1;
	@Value("${user1.password}")
	private String password1;
	@Value("${user1.role}")
	private String role1;
	
	@Value("${user2.name}")
	private String name2;
	@Value("${user2.password}")
	private String password2;
	@Value("${user2.role}")
	private String role2;
	
	@Value("${user3.name}")
	private String name3;
	@Value("${user3.password}")
	private String password3;
	@Value("${user3.role}")
	private String role3;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails user1=User.builder()
				   .username(name1)
				   .password(encoder.encode(password1))
				   .roles(role1)
				   .build();
		
		
		
		UserDetails user2=User.builder()
				   .username(name2)
				   .password(encoder.encode(password2))
				   .roles(role2)
				   .build();
		
		UserDetails user3=User.builder()
				   .username(name3)
				   .password(encoder.encode(password3))
				   .roles(role3)
				   .build();
		return new InMemoryUserDetailsManager(user1,user2,user3);
	}
}
