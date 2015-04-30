package com.wdxxl.shiro.service;

public interface RoleService {
	void assignRole(long roleId,long userId);
	long createRole(String roleName);
}
