package com.wy.npo.dao;

import java.util.Set;

import com.wy.npo.entity.SysPermissions;

public interface SysPermissionsMapper extends BaseMapper<SysPermissions>{
    
    /**
     * 根据用户名获取获取所有权限
     * @param account
     * @return
     */
    Set<String> queryPermissionsByAccount(String account);
}