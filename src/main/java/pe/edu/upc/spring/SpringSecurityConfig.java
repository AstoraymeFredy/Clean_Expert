package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	
	protected void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
				.antMatchers("/client/register", "/client/registerClient", "/staf/register", "/staf/registerStaff").permitAll().anyRequest().authenticated()
				.antMatchers("/admin/**").access("hasRole('Administrador')")
				.antMatchers("/staff/**").access("hasRole('Personal de Limpieza')")
				.antMatchers("/client/**").access("hasRole('Cliente')")
				.antMatchers("/parameter/**").access("hasRole('Administrador')")
				.antMatchers("/property/**").access("hasRole('Cliente')")	
				.antMatchers("/reservation/**").access("hasRole('Cliente')")	
				.antMatchers("/service/**").access("hasRole('Personal de Limpieza')")
				.antMatchers("/schedule/**").access("hasRole('Personal de Limpieza')")
				.antMatchers("/valoration/**").access("hasRole('Personal de Limpieza')")
			.and()
				.formLogin().successHandler(successHandler).loginPage("/login")
				.loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/error_403");
				
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
