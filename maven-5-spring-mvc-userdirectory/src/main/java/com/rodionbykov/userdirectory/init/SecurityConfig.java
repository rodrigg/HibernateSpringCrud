package com.rodionbykov.userdirectory.init;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password("12345").roles("USER");
        //auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT login, passwd, 1 AS active FROM users WHERE login = ?")
                .authoritiesByUsernameQuery(
                        "SELECT user_login, user_role FROM users_roles WHERE user_login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/about").permitAll()
                .antMatchers(HttpMethod.GET, "/list", "/create", "/edit/**", "/delete/**").access("hasRole('ADMIN')")
                .and()
                .formLogin().loginPage("/login").usernameParameter("login").passwordParameter("passwd").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf();
    }

}