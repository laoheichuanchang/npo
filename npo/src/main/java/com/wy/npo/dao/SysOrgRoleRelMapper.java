package com.wy.npo.dao;

import com.wy.npo.entity.SysOrgRoleRel;

public interface SysOrgRoleRelMapper {
    int insert(SysOrgRoleRel record);

    int insertSelective(SysOrgRoleRel record);
    
    /**
     * 根据角色删除角色和组织结构的关联关系
     * @param roleId
     * @return
     */
    int deleteByRoleId(Integer roleId);
}