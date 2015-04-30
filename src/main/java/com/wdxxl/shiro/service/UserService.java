package com.wdxxl.shiro.service;

import com.wdxxl.shiro.exception.LoginException;
import com.wdxxl.shiro.exception.RegisterException;

public interface UserService {
    void login(String username, String password, boolean isRememberMe) throws LoginException;
    long register(String username, String password) throws RegisterException;
}
