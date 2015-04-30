package com.wdxxl.shiro.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wdxxl.shiro.dao.UserDao;
import com.wdxxl.shiro.exception.LoginException;
import com.wdxxl.shiro.exception.RegisterException;
import com.wdxxl.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordService passwordService;
    
    @Autowired
    private UserDao userDao;

    @Override
    public void login(String username, String password, boolean isRememberMe) throws LoginException {
        // 创建 Token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(isRememberMe);

        Subject user = SecurityUtils.getSubject();
        try {
            user.login(token);
        } catch (AuthenticationException e) {
            logger.error("", e);
            throw new LoginException(e);
        }
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public long register(String username, String password) throws RegisterException {
        // 在 user 表中根据 username 查询用户是否已存在
        Long userCount = userDao.userExist(username);
        if (userCount > 0) {
            throw new RegisterException();
        }
        
        long registedUserId = userDao.register(username, passwordService.encryptPassword(password));
        
    	//从主键持有者中获得主键值
    	return registedUserId;
    }
}
