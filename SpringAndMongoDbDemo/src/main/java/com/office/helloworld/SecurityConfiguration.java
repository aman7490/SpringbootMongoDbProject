package com.office.helloworld;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	//step 1 to create use and authenticate them
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
			.withUser("aman").password(passwordEncoder().encode("aman123"))
			.roles("USER").authorities("Access_restcontroller")
			.and()
			.withUser("admin").password(passwordEncoder().encode("admin123"))
			.roles("ADMIN").authorities("Access_restcontroller","Access_restcontroller1")
			.and()
			.withUser("manager").password(passwordEncoder().encode("manager123"))
			.roles("MANAGER").authorities("Access_restcontroller1");
	}
	
	// authorize the user 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		//	.anyRequest().authenticated()
		//	.antMatchers("/hotels/**").permitAll()
			.antMatchers("/hotels/**").authenticated()
		//	.antMatchers("/profile/index").authenticated()    // for single 
		//	.antMatchers("/profile/**").authenticated()    // for multiples under sub profile pages
		//	.antMatchers("/admin/index").hasRole("ADMIN")
		//	.antMatchers("/management/index").hasAnyRole("ADMIN","MANAGER")
		//	.antMatchers("/api/restcontroller").authenticated()
		//	.antMatchers("/api/restcontroller").hasAuthority("Access_restcontroller")
		//	.antMatchers("/api/restcontroller1").hasAuthority("Access_restcontroller1")
		//	.antMatchers("/api/**").authenticated()
		//	.antMatchers("/api/**").hasAnyAuthority("Access_restcontroller","Access_restcontroller1")
			.and()
			.httpBasic();
	}
	
	// define encoder for created user passwords
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
*/