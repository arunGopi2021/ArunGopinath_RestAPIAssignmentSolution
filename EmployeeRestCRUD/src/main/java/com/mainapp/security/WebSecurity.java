package com.mainapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mainapp.services.UserDetailsServiceImpl;

@Configuration
@SuppressWarnings("deprecation")
public class WebSecurity extends WebSecurityConfigurerAdapter {
	 @Bean
	 public UserDetailsService userDetailsService() {
		 return new UserDetailsServiceImpl();
	}
	 
	 
	 @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 
	 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/users/**").hasAuthority("ADMIN")
        	.antMatchers("/users/403").hasAnyAuthority("USER","ADMIN")
        	.antMatchers("/roles/**").hasAuthority("ADMIN")
        	.antMatchers("/roles/403").hasAnyAuthority("USER","ADMIN")
        	.antMatchers("/employees/update","/employees/add","/employees/delete/{id}").hasAuthority("ADMIN")
            .antMatchers("/","/employees/list/**","employees/search/**","/employees/403").hasAnyAuthority("USER","ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .exceptionHandling().accessDeniedPage("/employees/403")
            .and()
            .cors().and().csrf().disable();
    }
    
    
    
    
    
  

}
