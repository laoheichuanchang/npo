package com.wy.npo.service;

import java.util.List;

import com.wy.npo.entity.SysResource;

/**
 * 资源管理
 * @author wangy
 */
public interface ISysResourceService extends IBaseService<SysResource>{
  
	/**
	 * 根据用户获取资源权限
	 * @param account
	 * @return
	 */
	public List<SysResource> queryMenu(String account);
	
	
	/**
	 * 根据角色获取菜单资源和权限
	 * @param roleId
	 * @return
	 */
	public List<SysResource> queryResourceRelPermByRoleId(Integer roleId);
}
