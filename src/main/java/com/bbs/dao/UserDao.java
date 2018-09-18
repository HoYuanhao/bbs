package com.bbs.dao;

import com.bbs.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User getUserByUserName(String username);
}
