/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.mgb.Security;

import com.portfolio.mgb.Security.Service.UserDetailsImpl;
import com.portfolio.mgb.Security.jwt.JwtEntryPoint;
import com.portfolio.mgb.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class MainSecurity extends WebSecurityConfigurerAdapter{
//public class MainSecurity extends SecurityFilterChain{
    @Autowired
    //correccion: No es userDetailsImpl; es userDetailsServiceImpl;
    UserDetailsImpl userDetailsServiceImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
        
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    //@Bean
    
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    protected void configure(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable()
              .authorizeRequests()
               .antMatchers("**").permitAll()
               .anyRequest().authenticated()
               .and()
               .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
               .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
        //Este return debe ir, porque al comienzo del método se usa un --Public-- que retorna un --SecurityFilterChain--
        //return http.build();
        //Si se usa "protect void" al comienzo del método no se usa el return (no devuelve nada)
    }
    

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
         return super.authenticationManager();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsImpl).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
}
    
                            
    

   
