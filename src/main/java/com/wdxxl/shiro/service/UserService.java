package com.wdxxl.shiro.service;

import com.wdxxl.shiro.exception.LoginException;
import com.wdxxl.shiro.exception.RegisterException;
import java.util.Map;

public interface UserService {

    void login(String username, String password, boolean isRememberMe) throws LoginException;

    void register(Map<String, String> fieldMap) throws RegisterException;
}
