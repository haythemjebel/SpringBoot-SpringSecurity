package com.haythem.securite;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)//protege le methode 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void globalconfigure(AuthenticationManagerBuilder auth, DataSource dataSource)throws Exception {
		/*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("1234").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("prof").password("123").roles("PROF");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("etudiant").password("111").roles("ETUDIANT");
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("scolarite").password("222").roles("SCOLARITE");*/
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal , password as credentials , true from users where username = ?")
		.authoritiesByUsernameQuery("select user_username as principal , roles_role as role from users_roles where user_username = ?")
		.rolePrefix("ROLE_").passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**","/js/**","/image/**").permitAll()
		.anyRequest().authenticated()// all request must be authenticated 
		.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/index");
	}

}