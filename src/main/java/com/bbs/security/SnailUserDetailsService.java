package com.bbs.security;

import com.bbs.bean.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SnailUserDetailsService implements UserDetailsService {
   @Autowired
   private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user=userService.getUserByUsername(s);
       if(user==null){
        return null;
       }else{
           CustUserDetails custUserDetails=new CustUserDetails(user.getId(),user.getUsername(),user.getPassword(),"USER");
       return custUserDetails;
       }
    }
}
