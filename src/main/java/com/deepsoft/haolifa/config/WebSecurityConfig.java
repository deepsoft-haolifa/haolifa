package com.deepsoft.haolifa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint entryPoint;
    @Autowired
    private MyRestAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyRestAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MyRestLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .authorizeRequests()
//                .antMatchers("/swagger-ui.html").permitAll()
                .anyRequest().permitAll()//authenticated()
                .and()
                .formLogin().successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler);
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/css/**")
                .antMatchers("/swagger-resources/**");
    }


}