//package com.inventory.entities.user;
/*
 * package com.inventory.user;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean public UserDetailsService userDetailsService() { return new
 * UserDetailServiceImpl();
 * 
 * }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * 
 * @Bean public DaoAuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
 * authProvider.setPasswordEncoder(passwordEncoder());
 * authProvider.setUserDetailsService(userDetailsService());
 * 
 * return authProvider; }
 * 
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.authenticationProvider(authenticationProvider()); }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.authorizeRequests().anyRequest().authenticated().and().formLogin().
 * permitAll().and().logout().permitAll();
 * 
 * 
 * http.authorizeRequests().antMatchers("/category").hasAnyAuthority(
 * "Administrator", "Editor", "Visitor")
 * .antMatchers("/new").hasAnyAuthority("Administrator",
 * "Editor").antMatchers("/edit/**") .hasAnyAuthority("Administrator",
 * "Editor").antMatchers("/delete/**").hasAuthority("Administrator").anyRequest(
 * )
 * .authenticated().and().formLogin().permitAll().and().logout().permitAll().and
 * ().exceptionHandling() .accessDeniedPage("/403");
 * 
 * 
 * }
 * 
 * }
 */