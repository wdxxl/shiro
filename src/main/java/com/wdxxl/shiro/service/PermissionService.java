package com.wdxxl.shiro.service;

public interface PermissionService {
	void assignPermission(long roleId,long permissionId);
	long createPermission(String permissionName);
}
