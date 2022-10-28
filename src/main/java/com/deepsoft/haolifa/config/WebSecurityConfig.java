package com.deepsoft.haolifa.config;

import com.deepsoft.haolifa.authentication.*;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.util.CollectionUtils;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private ValidateCodeFilter validateCodeFilter;


    // 不需要登录验证的url
    private static List<String> whiteUrls = new ArrayList<>();

    static {
        whiteUrls.add("/code/image");
        whiteUrls.add("/login");
        whiteUrls.add("/finance/t/te");
        whiteUrls.add("*");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(whiteUrls.toArray(new String[whiteUrls.size()])).permitAll().anyRequest().authenticated()
                .and()
                .formLogin().successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .maximumSessions(10);
    }


    @Override
    public void configure(WebSecurity web) {
        List<String> list = new ArrayList<String>() {{
            add("/swagger-ui.html");
            add("/webjars/**");
            add("/v2/**");
            add("/css/**");
            add("/swagger-resources/**");
            add("/finance/t/te");
            add("/**");
        }};
        web.ignoring().antMatchers(list.toArray(new String[list.size()]));
    }


}
