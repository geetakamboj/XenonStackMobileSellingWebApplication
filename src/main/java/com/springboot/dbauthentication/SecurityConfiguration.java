package com.springboot.dbauthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean(name = "myPasswordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories
				.createDelegatingPasswordEncoder();
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
		return delPasswordEncoder;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.antMatchers("/index.html")
				.hasRole("ADMIN")
				.and()
				.formLogin()

				.and()
				.logout();


	}
}
