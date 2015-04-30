package com.wdxxl.shiro.dao;

public interface RoleDao {
	void assignRole(long roleId,long userId);
	long createRole(String roleName);
	
}
