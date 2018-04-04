package com.wy.npo.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.wy.npo.entity.SysRole;
import com.wy.npo.utils.PageHelper;

public interface SysRoleMapper extends BaseMapper<SysRole>{
    
    /**
     * 根据用户名获取所有角色
     * @param account
     * @return
     */
    Set<String> queryRolesByAccount(String account);
    
    /**
     * 分页查询角色列表
     * @param role
     * @param page
     * @return
     */
    List<SysRole> queryListByBean(@Param("record")SysRole role,@Param("page")PageHelper page);
    
    /**
     * 查询角色列表数量
     * @param role
     * @return
     */
    Long queryCountByBean(SysRole role);
}