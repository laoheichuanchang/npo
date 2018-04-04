package com.wy.npo.dao;

import java.util.List;

import com.wy.npo.entity.SysResourceRoleRel;

public interface SysResourceRoleRelMapper {
    int insert(SysResourceRoleRel record);

    int insertSelective(SysResourceRoleRel record);
    
    /**
     * 批量插入角色资源关联数据
     * @param list
     * @return
     */
    int batchInsertSelective(List<SysResourceRoleRel> list);
    
    /**
     * 根据角色编号批量删除
     * @param list
     * @return
     */
    int deleteByRoleId(Integer roleId);
}