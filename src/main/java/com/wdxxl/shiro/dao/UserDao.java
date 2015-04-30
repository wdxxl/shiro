package com.wdxxl.shiro.dao;

import com.wdxxl.shiro.exception.RegisterException;

public interface UserDao {
	long userExist(String username);
    long register(String username, String password) throws RegisterException;
}
