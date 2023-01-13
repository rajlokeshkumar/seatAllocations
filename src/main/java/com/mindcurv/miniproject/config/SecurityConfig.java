package com.mindcurv.miniproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		http.authorizeRequests()
		.antMatchers("/h2-console/")
		.permitAll()
		.antMatchers(HttpMethod.GET,"/getAdminInfo").hasAnyAuthority("read")
		.antMatchers("/student/**").hasAnyRole("STUDENT")
		.anyRequest().authenticated().and().httpBasic();
		http.csrf().disable();
	}
	

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails aUserDetails=User.builder().username("loki").password(passwordEncoder.encode("loki")).roles("ADMIN","STUDENT").authorities("write").build();
		UserDetails cUserDetails=User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").authorities("read").build();
		UserDetails bUserDetails=User.builder().username("stu").password(passwordEncoder.encode("stu")).roles("STUDENT").build();
		return new InMemoryUserDetailsManager(aUserDetails,bUserDetails,cUserDetails);
	}
	
}
