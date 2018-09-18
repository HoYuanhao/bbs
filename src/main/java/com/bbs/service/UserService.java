package com.bbs.service;

import com.bbs.bean.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User getUserByUsername(String username);
}
