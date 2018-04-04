package com.kft.npo.dao;

import java.util.List;

import com.kft.npo.entity.SysUserRoleRel;

public interface SysUserRoleRelMapper {
    int insert(SysUserRoleRel record);

    int insertSelective(SysUserRoleRel record);
    
    /**
     * 根据用户删除角色关联关系
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
    
    /**
     * 批量插入用户和角色的关联关系
     * @param list
     * @return
     */
    int batchInsertSelective(List<SysUserRoleRel> list);
}