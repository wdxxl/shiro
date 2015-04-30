package com.wdxxl.shiro.dao;

public interface PermissionDao {
	void assignPermission(long roleId,long permissionId);
	long createPermission(String permissionName);
}
