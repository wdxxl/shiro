package com.wdxxl.shiro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wdxxl.shiro.dao.UserDao;
import com.wdxxl.shiro.exception.RegisterException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public long userExist(String username) {
		String selectSQL = "select count(*) from user where username = ?";
		Long userCount = jdbcTemplate.queryForObject(selectSQL, Long.class, username);
	    return userCount;
	}

	@Override
	public long register(String username, String password)
			throws RegisterException {
        final String fpassword = password;
        final String fusername  = username;

        final String sql="insert into user (username, password) values (?, ?)";
    	//创建一个主键持有者
        
    	KeyHolder keyHolder=new GeneratedKeyHolder();
    	jdbcTemplate.update(new PreparedStatementCreator(){
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
    			PreparedStatement preState = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    			preState.setString(1,fusername);
    			preState.setString(2,fpassword);
    			return preState;
    		}
    	},keyHolder);
    	
		return keyHolder.getKey().longValue();
	}

}
