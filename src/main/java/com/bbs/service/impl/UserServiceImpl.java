package com.bbs.service.impl;

import com.bbs.bean.User;
import com.bbs.dao.UserDao;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUserName(username);
    }
}
