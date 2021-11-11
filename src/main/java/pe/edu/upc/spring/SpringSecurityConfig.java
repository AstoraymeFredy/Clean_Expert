package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSuccessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private LoginSuccessHandler successHandler;
	
	
	protected void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
	            .antMatchers("/").permitAll() // This will be your home screen URL
	            .antMatchers("/css/**").permitAll()
	            .antMatchers("/js/**").permitAll()
	            .antMatchers("/img/**").permitAll()
	        	.antMatchers("/admin/**").access("hasRole('ROLE_Administrador')")
				.antMatchers("/parameter/**").access("hasRole('ROLE_Administrador')")
				.antMatchers("/property/**").access("hasRole('ROLE_Cliente')")	
				.antMatchers("/reservation/**").access("hasRole('ROLE_Cliente')")	
				.antMatchers("/service/**").access("hasRole('ROLE_Personal_de_Limpieza')")
				.antMatchers("/schedule/**").access("hasRole('ROLE_Personal_de_Limpieza')")
				.antMatchers("/valoration/**").access("hasRole('ROLE_Cliente')")
			.and()
				.formLogin().successHandler(successHandler).loginPage("/login").defaultSuccessUrl("/login").permitAll()
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/error_403");

				
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
