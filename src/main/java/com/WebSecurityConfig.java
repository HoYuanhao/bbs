package com;

import com.bbs.security.CustAuthenticationProvider;
import com.bbs.security.CustomAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
 private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
    @Autowired
  private CustAuthenticationProvider custAuthenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/static/**")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/") .authenticationDetailsSource(authenticationDetailsSource)
                .failureUrl("/login").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
        http.csrf().disable();
        super.configure(http);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
auth.authenticationProvider(custAuthenticationProvider);
   }
}