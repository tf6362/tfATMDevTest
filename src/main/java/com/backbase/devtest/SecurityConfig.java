package com.backbase.devtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * SecurityConfig that configures Website security for userids, passwords and roles
 * Created by bbates on 1/10/17.
 */
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Override
/**
 * configure configures web site security policy
 */
protected void configure(HttpSecurity http) throws Exception{
    http
            .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/user/**").authenticated()
            .antMatchers("/secureApp/**").authenticated()

            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
            .and().formLogin().loginPage("/login")
            .usernameParameter("username").passwordParameter("password")
            .and().rememberMe()
             .tokenValiditySeconds(300)
            .key("atmlocator")
            .and()
            .httpBasic()
            .realmName("ATM Locator")
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/login")
            .and().logout();



}
@Autowired
/**
 * configureGlobalSecurity configures authentication methods
 */
protected void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception{
    auth.inMemoryAuthentication().withUser("username").password("password").roles("USER").and()
    .withUser("admin").password("password").roles("USER","ADMIN");
}

}

