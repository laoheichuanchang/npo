package com.wy.npo.service;

import java.util.Set;

import com.wy.npo.entity.SysPermissions;

/**
 * 操作权限管理
 * @author wangy
 */
public interface ISysPermissionsService  extends IBaseService<SysPermissions>{
      
	/**
	 * 根据用户名查询用户的功能权限
	 * @param account
	 * @return
	 */
	Set<String> queryPermissionsByAccount(String account);
	
}
