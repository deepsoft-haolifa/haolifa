package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.service.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

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
                .authorizeRequests().anyRequest().permitAll()  //暂时全部放开
                .and()
                .formLogin().successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler);
    }


    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/css/**");
    }


}