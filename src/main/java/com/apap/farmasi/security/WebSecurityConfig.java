package com.apap.farmasi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().ignoringAntMatchers("/api/**").and()
//			.disable();
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/api/**").permitAll() 												// ini harus ada biar apinya bisa diakses tanpa security
			.antMatchers("/user/addUser").permitAll()
			.antMatchers("/user/add").permitAll()
			.antMatchers("/medical-supplies/").hasAnyAuthority("ADMIN", "STAF") 				// Fitur 3
			.antMatchers("/medical-supplies/{id}/").hasAnyAuthority("ADMIN", "STAF") 			// Fitur 5
			//.antMatchers("/medical-supplies/tambah/").hasAnyAuthority("ADMIN") 				// Fitur 6
			//.antMatchers("/medical-supplies/ubah/**").hasAnyAuthority("ADMIN")				// Fitur 7 
			//.antMatchers("/rawat-jalan/obat/tambah").hasAnyAuthority("ADMIN", "STAF") 		// Fitur 8
			.antMatchers("/medical-supplies/perencanaan/tambah/**").hasAnyAuthority("STAF") 	// Fitur 9 
			.antMatchers("/medical-supplies/perencanaan/**").hasAnyAuthority("ADMIN", "STAF") 	// Fitur 10
			.antMatchers("/medical-supplies/permintaan/**").hasAnyAuthority("ADMIN", "STAF")	// Fitur 11
			.antMatchers("/medical-supplies/permintaan/ubah/**").hasAnyAuthority("ADMIN") 		// Fitur 13
			.antMatchers("/medical-supplies/jadwal-staf/**").hasAnyAuthority("ADMIN") 			// Fitur 14, 15, 16
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

//	@Autowired
//	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.passwordEncoder(encoder())
//			.withUser("thaitea").password(encoder().encode("dumdum"))
//			.roles("USER");
//	}

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)throws Exception
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
}
	
