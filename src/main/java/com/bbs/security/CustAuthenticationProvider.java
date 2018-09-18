package com.bbs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustAuthenticationProvider implements AuthenticationProvider {
   @Autowired
   private SnailUserDetailsService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomWebAuthenticationDetails details= (CustomWebAuthenticationDetails) authentication.getDetails();
      String username=authentication.getName();
      String password= (String) authentication.getCredentials();
       CustUserDetails userDetails= (CustUserDetails) userService.loadUserByUsername(username);

       String code=details.getCode();
       String kapacode=details.getKapcode();
System.out.println();
        System.out.println(username+"------------"+password);
        System.out.println();
       if(userDetails==null){
           System.out.println("用户不存在");
           throw new BadCredentialsException("用户不存在");
       }
       if (!password.equals(userDetails.getPassword())){
           System.out.println("密码错误");
throw new BadCredentialsException("密码错误");
       }
      Collection authorities=  userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
