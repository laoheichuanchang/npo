package com.wy.npo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wy.npo.entity.SysResource;

public interface SysResourceMapper extends BaseMapper<SysResource>{
    
    /**
     * 根据用户获取访问资源
     * @param account
     * @return
     */
    List<SysResource> queryResourceByAccount(String account);
    
    
    /**
     * 根据角色获取菜单资源和权限
     */
    List<SysResource> queryResourceRelPermByRoleId(@Param("roleId")Integer roleId);
    
    /**
     * 根据子类ID查询父类
     * @param list
     * @return
     */
    List<Integer> queryPidListByChildId(List<Integer> list);
}